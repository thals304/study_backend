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
	private PasswordEncoder passwordEncoder; // SecurityConfig클래스의 new BCryptPasswordEncoder(); 객체 주입
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class); // 얘는 왜 있는거지? scheduler에서 sysout으로 찍기 보다는 파일에도 쓰여질 수 있게끔
	
	
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
	public String checkValidId(String memberId)  {  
		
		String isValidId = "n";	   						 // 유효여부 변수 (초깃값 'n')
		if (memberDAO.checkValidId(memberId) == null) {  // DAO에서 조회결과가 없을 경우
			isValidId = "y";							 // 유효여부 변수 'y'
		}
		
		return isValidId; // 유효여부('y' or 'n') 반환
		
	}
	
	
	@Override
	public boolean login(MemberDTO memberDTO)  { 
		
		MemberDTO validateData = memberDAO.login(memberDTO.getMemberId()); // 비밀번호와 활성화 여부를 조회한다.
		
		if (validateData != null) {  // 조회된 데이터가 있으면
			// 화면에서 전송된 비밀번호와 암호화된 패스워드가 일치하고 ActiveYn데이터가 y이면
			if (passwordEncoder.matches(memberDTO.getPasswd() , validateData.getPasswd()) && validateData.getActiveYn().equals("y")) {
				return true;  // true를 Controller로 반환한다.
			} 
		}
		
		return false; // false를 Controller로 반환한다.
		
		
		
	}
	
	
	@Override
	public MemberDTO getMemberDetail(String memberId)  {
		return memberDAO.getMemberDetail(memberId);
	}
	
	
	@Override
	public void updateMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException   {
		
		if (!uploadProfile.isEmpty()) { 														// 업로드된 파일이 있으면		
			
			new File(fileRepositoryPath + memberDTO.getProfileUUID()).delete(); 				// 기존의 이미지 파일을 삭제한다.
			
			String originalFilename = uploadProfile.getOriginalFilename();						// 원본파일명을 구한다.
			memberDTO.setProfileOriginalName(originalFilename);									// memberDTO에 저장한다.
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));   // 확장자를 구한다.
			
			String uploadFile = UUID.randomUUID() + extension;									// 'UUID.확장자' 형태로 중복되지 않는 파일명을 만든다.
			memberDTO.setProfileUUID(uploadFile);												// memberDTO에 저장한다.
			
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));				// 새로운파일명으로 파일을 최종적으로 업로드한다.
			
		}
		
		if (memberDTO.getSmsstsYn() == null)   memberDTO.setSmsstsYn("n");						// 문자수신에 동의하지 않으면(null이면) > memberDTO에 'n' 데이터를 저장한다.
		if (memberDTO.getEmailstsYn() == null) memberDTO.setEmailstsYn("n");					// 이메일 수신에 동의하지 않으면(null이면) > memberDTO에 'n' 데이터를 저장한다.
		
		memberDAO.updateMember(memberDTO);														// 데이터를 DAO로 전달한다.			
	
	}
	
	
	@Override
	public void updateInactiveMember(String memberId)  {
		memberDAO.updateInactiveMember(memberId);
	}

	
	@Override
	@Scheduled(cron="0 59 23 * * *") // 23시 59분 0초 신규회원카운트 스케쥴러
	public void getTodayNewMemberCnt()  {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());  // 오늘의 날짜를 구한다.
		
		logger.info("(" + today + ") 신규회원수 : " + memberDAO.getTodayNewMemberCnt(today)); // 오늘 하루 회원가입한 숫자를 반환한다.
	
	}
	
	
	@Override
	@Scheduled(cron="59 59 23 * * *") // 23시 59분 59초 회원삭제 스케쥴러
	public void deleteMemberScheduler() {
		
		List<MemberDTO> deleteMemberList = memberDAO.getInActiveMemberList(); 		  // 비활성화 된 회원목록을 조회한다.
		if (!deleteMemberList.isEmpty()) {											  // 비활성화 회원 목록이 있으면
			for (MemberDTO memberDTO : deleteMemberList) {	
				new File(fileRepositoryPath + memberDTO.getProfileUUID()).delete();   // 회원의 프로필 삭제
				memberDAO.deleteMember(memberDTO.getMemberId());					  // 회원삭제 쿼리 진행
			}
		}
		
	}
	
}
