package com.application.trainingVer2.member.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.member.dao.MemberDAO;
import com.application.trainingVer2.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Value("${file.repo.path}")         // application.properties파일의 file.repo.path=c:/spring_member_profile/ 주입
	private String fileRepositoryPath;
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class); 

	@Override
	public String checkValidId(String memberId) {
		String isValid = "n";
		
		if (memberDAO.checkValidId(memberId) == null) {
			isValid = "y";
		}
		return isValid;
	}

	@Override
	public void createMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException  {
		
		if (!uploadProfile.isEmpty()) { 													 // 업로드된 파일이 있으면
			String originalFilename = uploadProfile.getOriginalFilename();					 // 원본파일명을 구한다.
			memberDTO.setProfileOriginalName(originalFilename);	         					 // memberDTO에 저장한다.
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf(".")); // 확장자를 구한다.
			
			String uploadFile = UUID.randomUUID() + extension;								  // 'UUID.확장자' 형태로 중복되지 않는 파일명을 만든다.
			memberDTO.setProfileUUID(uploadFile);											  // memberDTO에 저장한다.
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));			  // 새로운파일명으로 파일을 최종적으로 업로드한다.
			
		}
		
		if (memberDTO.getSmsstsYn() == null)   memberDTO.setSmsstsYn("n");					 // 문자수신에 동의하지 않으면(null이면) > memberDTO에 'n' 데이터를 저장한다.
		if (memberDTO.getEmailstsYn() == null) memberDTO.setEmailstsYn("n");				 // 이메일 수신에 동의하지 않으면(null이면) > memberDTO에 'n' 데이터를 저장한다.
		
		memberDTO.setPasswd(passwordEncoder.encode(memberDTO.getPasswd())); 				 // 전송된 비밀번호를 암호화하여 memberDTO에 다시 저장한다.
		
		memberDAO.createMember(memberDTO);													 // 데이터를 DAO로 전달한다.
		
	}

	@Override
	public boolean login(MemberDTO memberDTO) {
		// passwd, activeYn을 받아옴
		MemberDTO validateData = memberDAO.login(memberDTO.getMemberId());
		
		if (validateData != null) { // 조회된 데이터가 있으면
			if (passwordEncoder.matches(memberDTO.getPasswd(), validateData.getPasswd()) && validateData.getActiveYn().equals("y")) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public MemberDTO getMemberDetail(String memberId) {
		
		return memberDAO.getMemberDetail(memberId);
	}

	@Override
	public void updateMember(MultipartFile uploadProfile, MemberDTO memberDTO) throws IllegalStateException, IOException {
		
		if (!uploadProfile.isEmpty()) {
			
			new File(fileRepositoryPath + memberDTO.getProfileUUID()).delete();
			
			String originalFilename = uploadProfile.getOriginalFilename();
			memberDTO.setProfileOriginalName(originalFilename);
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String uploadFile = UUID.randomUUID() + extension;
			memberDTO.setProfileUUID(uploadFile);
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));
		}
		
		if (memberDTO.getSmsstsYn() == null) memberDTO.setSmsstsYn("n");
		if (memberDTO.getEmailstsYn() == null) memberDTO.setEmailstsYn("n");
		
		memberDAO.updateMember(memberDTO);
		
	}

	@Override
	public void updateInactiveMember(String memberId) {
		memberDAO.updateInactiveMember(memberId);
		
	}

	@Override
	@Scheduled(cron="0 59 23 * * *")
	public void getTodayNewMemberCnt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date()); // 오늘의 날짜 구하기
		
		logger.info("(" + today + ") 신규회원수 : " + memberDAO.getTodayNewMemberCnt(today));
	}

	@Override
	@Scheduled(cron="0 59 23 * * *")
	public void deleteMemberScheduler() {
		List<MemberDTO> deleteMemberList = memberDAO.getInActiveMemberList(); 		  
		
		if (!deleteMemberList.isEmpty()) {
			for (MemberDTO memberDTO : deleteMemberList) {
				new File(fileRepositoryPath + memberDTO.getProfileUUID()).delete();
				memberDAO.deleteMember(memberDTO.getMemberId());
			}
		}
	}
	
	
	


}
