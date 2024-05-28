package com.application.trainingVer2.member.controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.application.trainingVer2.member.dto.MemberDTO;
import com.application.trainingVer2.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
/*
 * 24.05.27 time 12:04-13:37
 * DTO
 * @DateTimeFormat(pattern="yyyy-MM-dd") 해준 이유? 입력한 날짜는 String이므로 저장할 때는 Date 형식으로
 * 1.회원가입
 * Controller @GetMapping("/main") > main.html : session.memberId에서 session이 어디서 온 거지? login을 통해 session에 memberId를 setAttribute함
 * > Controller @GetMapping ("/register") 
 * > register.html id 중복 확인(y or n 받아오기) $.ajax 에서 @PostMapping("/validId)(Post인 이유? ajax에서 보낼 때 Post로 보냄) <> Service & ServiceImpl에서 y or n으로 바뀜 <> DAO <> mapper 
 *                 passwd 확인 html에서 작성한 값 두 개 비교
 *   +) checkFormValidation 폼 유효성 검사 : id, passwd만 하는 이유? 필수적인 값이라
 * > Controller @PostMapping("/register") 에 파일은 Multipart로 받아오고 나머지 값은 @ModelAttribute로 받아옴
   <> Service, ServiceImpl에서 file 원래 파일명 & uuid & extension / 수신동의 안할 때 > n / 비밀번호 암호화 <> DAO <> mapper
   2.로그인
   Controller @GetMapping > login.html $.ajax()에서 id, passwd Controller @Post로 보냄
   > Controller @PostMapping("/login") @RequestBody로 받음 <> Service & ServiceImpl에서 조회된 id가 있으면 activeYn과 passwd를 select해서 passwordEncoder.matches로 passwd까지 비교
                                                                                                  (activeYn을 받아오는 이유? activeYn 역할 ? 탈퇴 = n , 활동 중 = y)
                                       & 로그인 성공하면 session에 memberId 추가 -> /member/main -> main.html의 unless 부분이 보임
 * 
 * 3. 수정하기
 * Controller @GetMapping("/update") session에 저장된 memberId로 getMemberDetail를 통해 memberDTO 조회 -> update.html로 보냄 (controller <> service, serviceImpl <> dao <> mapper 쌍방향)
 * update.html 아이디 제외 파일 , 이름, 성별 , 생년월일 , 폰번호, 체크박스 , 주소, 기타 등을 바꿀 수 있음
 *                   -> Controller @GetMapping("/thumnails")
 * > Controller @PostMapping("/update")에서 Multipart로 파일 받아오고 @ModelAttribute로 memberDTO 받아옴 
 * > service , serviceImpl > dao > mapper : 바로 대입 안하고 if로 profileOriginalName != null and profileOriginalName != '' 해주는 이유? 전부 업데이트 하는 것보다 수정 값을 보낸 것만 업데이트 하도록 
 * 4. 로그아웃
 * Controller @GetMapping("/logout") session 삭제만 해주면 됨
 * 5. 탈퇴하기
 * Controller @GetMapping("/delete") > delete.html keyup? 
 * > Controller @PostMapping("/delete") session 삭제 & activeYn = 'n', inactiveYn = NOW()
 * 
 * +)스케쥴링
 * 당일 회원가입 수 체크 스케쥴러
 * Service > ServiceImpl: SimpleDateFormat sdf, sdf.format(new Date())으로 오늘 날짜 구함 > dao > mapper : LEFT?
 * 회원 삭제 체크 스케쥴러 
 * Service > ServiceImpl : 비활성화 회원 목록이 있으면 C 드라이브에 저장된 탈퇴 회원 프로필 삭제 & db 회원 삭제 쿼리 수행 <> dao <> mapper : 비활성화 된지 90일 이상 지난 회원 (inactiveAt)
 * */

@Controller
@RequestMapping("/member")
public class MemberController {

	@Value("${file.repo.path}")    // application.properties파일의 file.repo.path=c:/spring_member_profile/ 이미지파일 저장경로 주입
    private String fileRepositoryPath; // c:/spring_member_profile
	
	@Autowired
	private MemberService memberService;
	
	
	@GetMapping("/main")  // localhost/member/main 요청시 매핑
	public String main()  {
		return "member/main"; // templates/member/main.html 파일로 포워딩
	}
	
	
	@GetMapping("/register")  // localhost/member/main 요청시 매핑
	public String register() {
		return "member/register"; // templates/member/register.html 파일로 포워딩
	}
	
	
	@PostMapping("/register") //register.html 파일에서 회원가입 진행할 때 매핑
						  // 파일은 MultipartFile로 받는다.								 // DTO관련 데이터는 DTO로 전송받는다.
	public String register(@RequestParam("uploadProfile") MultipartFile uploadProfile , @ModelAttribute MemberDTO memberDTO) throws IllegalStateException, IOException  {
		memberService.createMember(uploadProfile, memberDTO); // 관련 로직은 서비스에서 처리하기 위하여 포워딩한다.
		return "redirect:/member/main"; // /member/main으로 포워딩
	}
	
	
	@PostMapping("/validId") // localhost/member/validId 요청시 매핑
	@ResponseBody
	public String validId(@RequestParam("memberId") String memberId) { 
		return memberService.checkValidId(memberId); // memberId를 전달받아 중복체크한 결과 ('y' or 'n')을 register.html파일의 AJAX success 콜백함수로 반환
	}
	
	
	@GetMapping("/login") // localhost/member/login 요청시 매핑
	public String login()  {
		return "member/login"; // templates/member/login.html 파일로 포워딩
	}
	
	
	@PostMapping("/login") //login.html 파일에서 로그인 진행할 때 매핑
	@ResponseBody		// 전송된 데이터를 받는다.			session에 등록하기 위해 작성한다.
	public String login(@RequestBody MemberDTO memberDTO , HttpServletRequest request) {
		
		String isValidMember = "n";					// 초기값 : 인증 x
		if (memberService.login(memberDTO)) {		// memberService에서 인증여부를 확인한 후 인증이 되었을 경우(return true)
			
			HttpSession session = request.getSession();					
			session.setAttribute("memberId", memberDTO.getMemberId());  // session 객체에 memberId를 저장한다.
			
			isValidMember = "y";
			
		} 
		
		return isValidMember; // 로그인 여부 ('y' or 'n')을 login.html파일의 AJAX success 콜백함수로 반환
		
	}
	
	
	@GetMapping("/logout") // localhost/member/logout 요청시 매핑
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(); 
		session.invalidate(); // 세션 삭제
		
		return "redirect:/member/main";  // /member/main으로 포워딩
		
	}
	
	
	@GetMapping("/update") // localhost/member/update 요청시 매핑
	public String update(HttpServletRequest request , Model model) {
		
		HttpSession session = request.getSession();	
		// Session에서 memberId정보를 가져와 memberDTO를 조회한다.
		model.addAttribute("memberDTO" , memberService.getMemberDetail((String)session.getAttribute("memberId")));
		
		return "member/update"; // templates/member/update 화면으로 포워딩(memberDTO 데이터포함)
		
	}	
	
	
	@PostMapping("/update") // update.html 파일에서 수정을 진행할 때 매핑
							// 파일은 MultipartFile로 받는다.						    // DTO관련 데이터는 DTO로 전송받는다.
	public String update(@RequestParam("uploadProfile") MultipartFile uploadProfile , @ModelAttribute MemberDTO memberDTO) throws IllegalStateException, IOException  {
		memberService.updateMember(uploadProfile , memberDTO); // 관련 로직은 서비스에서 처리하기 위하여 포워딩한다.
		return "redirect:/member/main"; // /member/main으로 포워딩
		 
	}
	
	
	@GetMapping("/thumbnails") // localhost/member/thumbnails 요청시 매핑
    @ResponseBody
    public Resource thumbnails(@RequestParam("fileName") String fileName) throws MalformedURLException{
        return new UrlResource("file:" + fileRepositoryPath + fileName); // 전달된 파일명으로 썸네일 객체를 반환한다.
    }
	
	
	@GetMapping("/delete")  // localhost/member/delete 요청시 매핑
	public String delete() {
		return "member/delete"; // templates/member/delete 화면으로 포워딩
	}
	
	
	@PostMapping("/delete") // delete.html 파일에서 삭제를 진행할 때 매핑
	public String delete(HttpServletRequest request)  {
		
		HttpSession session = request.getSession();
		memberService.updateInactiveMember((String)session.getAttribute("memberId")); // Session 객체에서 memberId를 조회하여 Service로 전달한다.
		session.invalidate(); // 세션 삭제
		
		return "redirect:/member/main"; // /member/main으로 포워딩
		
	}
	
}
