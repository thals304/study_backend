package com.application.utility.chapter02_file;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/*

# Spring 파일라이브러리 'MultipartFile'


- Spring MVC에서는 MultipartFile객체를 사용하여 클라이언트로부터 전송된 파일을 받아서 처리할 수 있다.


- MultipartFile 객체에서 제공되어지는 메서드 목록

	getBytes() : 업로드된 파일의 내용을 바이트 배열로 반환한다.
	getContentType() :업로드된 파일의 MIME 유형을 반환한다.
	getInputStream() :업로드된 파일의 InputStream을 반환한다. 이를 통해 파일의 내용을 읽어올 수 있다.
	getOriginalFilename() : 클라이언트가 업로드한 파일의 원래 파일 이름을 반환한다.


[ 스프링 파일업로드 기능 구현 방법 ]

	1) 스프링부트 프로젝트에 파일 업로드기능이 포함되어있어서 의존성을 추가하지 않아도 된다.(build.gradle에 추가 안해도 됨)

	2) application.properties 파일에 파일업로드 관련 설정을 추가한다.
	
		# 멀티파트 요청에서 개별 파일의 최대 허용 크기 (기본값 1MB)
		spring.servlet.multipart.max-file-size=30MB
		
		# 멀티파트 요청 (파일용량)전체의 최대 허용 크기 (기본값 10MB)         
		spring.servlet.multipart.max-request-size=100MB
		
		# 파일저장 경로 지정 
		file.repo.path=C:/spring_file_test/
	
    3) MultipartFile 객체를 사용하여 파일관련 기능을 구현한다.

*/

@Controller
@RequestMapping("/file")
public class FileController {
	/*
	  
	   import org.springframework.beans.factory.annotation.Value;
	  
	   웹애플리케이션의 설정정보 위치를 통합하기 위하여 
	   application.properties파일에서 파일저장 위치를 (file.repo.path)로명시하고 @Value 애노테이션을 사용하여 대입하여 사용한다. 
	 
	 */
	@Value("${file.repo.path}")
	private String fileRepoPath;
	
	@GetMapping("/main")
	public String fileEx() {
		return "file/fileMain";
	}
	
	
	// 1) 파일 업로드 기초 메뉴얼
	@PostMapping("/upload1")
	@ResponseBody
	//@RequestParam("name명") 어노테이션을 사용하여 MultipartFile타입으로 파일을 전달받는다. 
	public String upload1(@RequestParam("upFile") MultipartFile upFile) throws IllegalStateException, IOException {
		
		// isEmpty() : 전송된 파일이 없으면 true, 있으면 false 반환
		if (!upFile.isEmpty()) { // 전송된 파일이 있으면
			
			System.out.println("업로드 된 파일명 : " + upFile.getOriginalFilename());
			System.out.println("파일의 타입 : " + upFile.getContentType());
			
			// jsp에서는 FileConfig.fileRepoPath
			File targetFile = new File(fileRepoPath + upFile.getOriginalFilename()); // 파일 객체를 생성한다.
			
			upFile.transferTo(targetFile);  // transferTo(파일객체) 메서드를 사용하여 파일저장소에 파일을 저장한다.
			//upFile.transferTo(new File(fileRepoPath + upFile.getOriginalFilename()));
			
		}
		
		String jsScript = """
				<script>
					alert('업로드 되었습니다.');
					location.href = '/file/main';
				</script>
				""";
		
		
		return jsScript;
	
	}
	
	// 2) 다중파일 업로드 + 파일명 수정(UUID 적용) 메뉴얼
	@PostMapping("/upload2")
	@ResponseBody
	//@RequestParam("name명") 어노테이션을 사용하여 List<MultipartFile>타입으로 파일을 전달받는다. 
	public String upload2(@RequestParam("files") List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for (MultipartFile file : files ) {
			if (!file.isEmpty()) { // 전송된 파일이 있으면
				// 원본 파일 이름
				String originalFilename = file.getOriginalFilename(); 
				
				// 범용고유식별자(UUID) 생성
				UUID uuid = UUID.randomUUID();
				
				// 확장자 추출
				String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
				
				// 파일 이름 수정
				String uploadFileName = uuid + extension;
				
				// transferTo() 메서드를 사용하여 수정된 파일명으로 저장
				file.transferTo(new File(fileRepoPath + uploadFileName));
				
				System.out.println("원본 파일명 : " + originalFilename);
				System.out.println("업로드 된 파일명 : " + uploadFileName);
				System.out.println();
			}
		}
		
		String jsScript = """
				<script>
					alert('업로드 되었습니다.');
					location.href = '/file/main';
				</script>
				""";
		
		return jsScript;
	}
	/*
	
		import org.springframework.core.io.InputStreamResource;
		import org.springframework.core.io.Resource;
		import org.springframework.core.io.UrlResource;
		import org.springframework.http.ContentDisposition;
		import org.springframework.http.HttpHeaders;
		import org.springframework.http.HttpStatus;
		import org.springframework.http.ResponseEntity;
		import java.nio.file.Path;
		import java.nio.file.Paths;
		
	*/
	
	
	// 3) 썸네일기능 구현 메뉴얼
	// 파일에서 저장된 이미지를 가져와 화면에 뿌리는 것
	@GetMapping("/thumbnails")
	@ResponseBody
	public Resource thumbnails(@RequestParam("fileName") String fileName) throws MalformedURLException {
		// new UrlResource("file:" + 파일접근경로) 객체를 반환하여 이미지를 조회한다.
		return new UrlResource("file:" + fileRepoPath + fileName );  // 이미지 경로를 수정하여 사용한다.
	}
	
	// 4) 파일 다운로드 기능 구현 메뉴얼
	@GetMapping("/download")
	public ResponseEntity<Object> download(@RequestParam("fileName") String fileName) throws MalformedURLException{
		
		String downloadFilePath = fileRepoPath + fileName;  // 이미지 경로를 수정하여 사용한다.
		
		try {
			
			Path filePath = Paths.get(downloadFilePath);
			Resource resource = new InputStreamResource(Files.newInputStream(filePath));
			
			File file = new File(downloadFilePath);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentDisposition(ContentDisposition.builder("attachment").filename(file.getName()).build());  
			return new ResponseEntity<Object>(resource, headers, HttpStatus.OK);
			
		} catch(Exception e) {
			return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
		}
	        
	}

	
	// 5) 파일 삭제 메뉴얼
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("deleteFileName") String deleteFileName) {
		
		File file = new File(fileRepoPath + deleteFileName);
		file.delete();
		
		String jsScript = """
				<script>
					alert('삭제 되었습니다.');
					location.href = '/file/main';
				</script>
				""";
		
		return jsScript;
	}
	
	// 6) 파일 수정 메뉴얼
	@PostMapping("/update")
	@ResponseBody
	public String update(@RequestParam("deleteFileName") String deleteFileName,
			             @RequestParam("modifyFile") MultipartFile modifyFile) throws IllegalStateException, IOException {
		
		File deleteFile = new File(fileRepoPath + deleteFileName);
	
		// 삭제할 파일이 존재하고 수정 파일이 전송되었으면
		if (deleteFile.exists() && !modifyFile.isEmpty()) {
			
			deleteFile.delete(); // 파일 삭제
			
			// 원본 파일 이름
			String originalFilename = modifyFile.getOriginalFilename();
			
			// UUID 생성
			UUID uuid = UUID.randomUUID();
			
			// 확장자 추출
			String extension = originalFilename.substring(originalFilename.indexOf("."));
			
			// 파일 이름 수정
			String uploadFileName = uuid + extension;
			
			// transferTo() 메서드를 사용해 수정된 파일명으로 저장
			modifyFile.transferTo(new File(fileRepoPath + uploadFileName));
			
		}
		
		
		String jsScript = """
				<script>
					alert('수정 되었습니다.');
					location.href = '/file/main';
				</script>
				""";
		
		return jsScript;
	}
}
