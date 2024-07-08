package com.application.trainingVer2.member.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import com.application.trainingVer2.mapper.MemberDTO;
import com.application.trainingVer2.mapper.MemberMapper;
import com.application.trainingVer2.member.domain.Member;
import com.application.trainingVer2.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Value("${file.repo.path}")  // application.properties파일의 file.repo.path=c:/spring_member_profile/ 주입
    private String fileRepositoryPath;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	
	@Override
	public void createMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException  {
		
		if (!uploadProfile.isEmpty()) { // 업로드된 파일이 있으면
			
			String originalFilename = uploadProfile.getOriginalFilename();  // 원본파일명을 구한다.
			memberDTO.setProfileOriginalName(originalFilename);				 // memberDTO에 저장한다.
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));	 // 확장자를 구한다.
			
			String uploadFile = UUID.randomUUID() + extension;		  // 'UUID.확장자' 형태로 중복되지 않는 파일명을 만든다.
			memberDTO.setProfileUuid(uploadFile);					  // memberDTO에 저장한다
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));	// 새로운파일명으로 파일을 최종적으로 업로드한다.
			
		}
		
		if (memberDTO.getSmsstsYn() == null)   memberDTO.setSmsstsYn("n");	 // 문자수신에 동의하지 않으면(null이면) > memberDTO에 'n' 데이터를 저장한다.
		if (memberDTO.getEmailstsYn() == null) memberDTO.setEmailstsYn("n");  // 이메일 수신에 동의하지 않으면(null이면) > memberDTO에 'n' 데이터를 저장한다.
		
		memberDTO.setPasswd(passwordEncoder.encode(memberDTO.getPasswd()));   // 전송된 비밀번호를 암호화하여 memberDTO에 다시 저장한다.
		memberRepository.save(MemberMapper.toEntity(memberDTO));   			  // 데이터를 DAO로 전달한다.
	}

	
	@Override
	public String checkValidId(String memberId)  {
		
		String isValidId = "n";	   						 // 유효여부 변수 (초깃값 'n')
		if (memberRepository.checkValidId(memberId) == null) {  // DAO에서 조회결과가 없을 경우
			isValidId = "y";							 // 유효여부 변수 'y'
		}
		
		return isValidId; // 유효여부('y' or 'n') 반환

		
	}
	
	
	@Override
	public Boolean login(MemberDTO memberDTO)  {
		
		MemberDTO validateData = memberRepository.login(memberDTO.getMemberId());
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
		return MemberMapper.toDTO(memberRepository.findById(memberId).orElse(null));
	}
	
	
	@Override
	public void updateMember(MultipartFile uploadProfile , MemberDTO memberDTO) throws IllegalStateException, IOException  {
		
		Member member = memberRepository.findById(memberDTO.getMemberId()).orElse(null);
		
		if (!uploadProfile.isEmpty()) { // 유효여부 변수 (초깃값 'n')
			
			new File(fileRepositoryPath + memberDTO.getProfileUuid()).delete(); // 기존의 이미지 파일을 삭제한다.
			
			String originalFilename = uploadProfile.getOriginalFilename(); // 원본파일명을 구한다.
			memberDTO.setProfileOriginalName(originalFilename); // memberDTO에 저장한다.
			
			String extension = originalFilename.substring(originalFilename.lastIndexOf("."));  // 확장자를 구한다.
			
			String uploadFile = UUID.randomUUID() + extension;  // 'UUID.확장자' 형태로 중복되지 않는 파일명을 만든다.
			memberDTO.setProfileUuid(uploadFile); // memberDTO에 저장한다.
			
			uploadProfile.transferTo(new File(fileRepositoryPath + uploadFile));  // 새로운파일명으로 파일을 최종적으로 업로드한다.
			
		}
		
		member.setProfileOriginalName(memberDTO.getProfileOriginalName());
		member.setProfileUuid(memberDTO.getProfileUuid());
		member.setMemberNm(memberDTO.getMemberNm());
		member.setSex(memberDTO.getSex());
		member.setBirthAt(memberDTO.getBirthAt());
		member.setHp(memberDTO.getHp()); 
		if (memberDTO.getSmsstsYn() == null)   member.setSmsstsYn("n");					   // 문자수신에 동의하지 않으면(null이면) > member에 'n' 데이터를 저장한다.
		else 								   member.setSmsstsYn(memberDTO.getSmsstsYn()); 		
		if (memberDTO.getEmailstsYn() == null) member.setEmailstsYn("n");					// 이메일 수신에 동의하지 않으면(null이면) > member에 'n' 데이터를 저장한다.
		else 								   member.setEmailstsYn(memberDTO.getEmailstsYn());
		member.setEmail(memberDTO.getEmail());
		member.setZipcode(memberDTO.getZipcode());
		member.setRoadAddress(memberDTO.getRoadAddress());
		member.setJibunAddress(memberDTO.getJibunAddress());
		member.setNamujiAddress(memberDTO.getNamujiAddress());
		member.setEtc(memberDTO.getEtc());
		
		memberRepository.save(member);
	
	}
	
	
	@Override
	public void updateInactiveMember(String memberId)  {    				// 회원 비활성화
		Member member = memberRepository.findById(memberId).orElse(null);   // 현재 회원정보 조회
		member.setActiveYn("n");											// 활성화 여부를 'n'으로 수정 		
		member.setInactiveAt(new Date());									// 비활성화 시간을 현재일자로 수정
		memberRepository.save(member);
	}

	
	@Override
	@Scheduled(cron="59 59 23 * * *") // 23시 59분 0초 신규회원카운트 스케쥴러
	public void getTodayNewMemberCnt()  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		logger.info("(" + today + ") 신규회원수 : " + memberRepository.getTodayNewMemberCnt(today));  // 오늘 하루 회원가입한 숫자를 반환한다.
	}
	
	
	@Override
	@Scheduled(cron="59 59 23 * * *") // 23시 59분 59초 회원삭제 스케쥴러
	public void deleteMemberScheduler()  {
		List<Member> deleteMemberList = memberRepository.getInActiveMemberList(); // 비활성화 된 회원목록을 조회한다.
		if (!deleteMemberList.isEmpty()) {										  // 비활성화 회원 목록이 있으면
			for (Member member : deleteMemberList) {
				new File(fileRepositoryPath + member.getProfileUuid()).delete();  // 회원의 프로필 삭제
				memberRepository.deleteById(member.getMemberId());				  // 회원삭제 쿼리 진행
			}
		}
	}
	
}
