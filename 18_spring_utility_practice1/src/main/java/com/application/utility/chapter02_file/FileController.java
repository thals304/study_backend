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
 * 24.05.25 time 22:37-13:31
 * today 소감문
 * multipart로 file를 업로드하고 다운 받는 등의 구현을 따라해보는 시간을 가질 것이다. 
 * 
 * > 파일 경로 
 *   application.properties 에서 경로 관련 정보 추가
 *   @Value("${file.repo.path}")
	 private String fileRepoPath; 추가
   > 파일 업로드
 *   1개 파일 업로드 @RequestParam("file") Multipart file -> !file.isEmpty()   
 *   다중 파일 업로드 @RequestParam("files") List<Multipart> files -> for ( Multipart file : files ) -> !file.isEmpty()
 *   원래 파일명   : file.getOriginalFilename()
 *   원래 파일 타입 : file.getContentType();
 *   uuid       : UUID.randomUUID();
 *   extension : 원래파일명.substring(원래파일명.lastIndexOf("."));
 * > 썸네일 (C드라이브 파일에 있는 이미지를 화면에 뿌리는 것)
 *   html       -> <img th:src="@{/file/thumbnails(변수명=${이미지 이름})}"/>
 *   GetMapping & ResponseBody -> public Resource 이름 (@RequestParam("변수명") String 변수명){
 *   									return new UrlResource("file:" + 경로 + 변수명);
 *   							}  
 * > 파일 다운로드   
 * > 파일 삭제
 * 	 new File(경로 + deleteFile).delete(); 
 * > 파일 수정 
 *   File deleteFile = new File(경로 + deleteFile); 
 *   if ( deleteFile.exists() && !다시 올릴 파일.isExists() ){
 *   		deleteFile.delete();
 *   		uuid 하는 것과 같은 흐름 연개
 *   }
 * */
@Controller
@RequestMapping("/file")
public class FileController {

	@Value("${file.repo.path}")
	private String fileRepoPath;
	
	@GetMapping("/main")
	public String main() {
		return "file/fileMain";
	}
	
	@PostMapping("/upload1")
	@ResponseBody
	public String upload1(@RequestParam("upFile") MultipartFile upFile) throws IllegalStateException, IOException {
		
		if (!upFile.isEmpty()) {
			
			System.out.println("업로드된 파일명 : " + upFile.getOriginalFilename());
			System.out.println("파일의 타입 : " + upFile.getContentType());
			
			File targetFile = new File(fileRepoPath + upFile.getOriginalFilename());
			
			upFile.transferTo(targetFile);
		}
		
		String jsScript = """
				<script>
				alert('파일이 업로드 되었습니다.');
				location.href = '/file/main';
				</script>
				""";
		
		return jsScript;
	}
	
	@PostMapping("/upload2")
	@ResponseBody
	public String upload2(@RequestParam("files") List<MultipartFile> files) throws IllegalStateException, IOException {
		
		for (MultipartFile file : files) {
			if (!file.isEmpty()) {
				String originalName = file.getOriginalFilename();
				
				UUID uuid = UUID.randomUUID();
				
				String extension = originalName.substring(originalName.lastIndexOf("."));
				
				String uploadFile = uuid + extension;
				
				file.transferTo(new File(fileRepoPath + uploadFile));
				
				System.out.println("원본 파일명 : " + originalName);
				System.out.println("업로드 된 파일명 : " + uploadFile);
				System.out.println();
			}
		}
		
		String jsScript = """
				<script>
				alert('파일이 업로드 되었습니다.');
				location.href = '/file/main';
				</script>
				""";
		
		return jsScript;
	}
	
	@GetMapping("/thumbnails")
	@ResponseBody
	public Resource thumbnails(@RequestParam("fileName") String fileName) throws MalformedURLException {
		// new UrlResource("file:" + 파일접근경로) 객체를 반환하여 이미지를 조회한다.
		return new UrlResource("file:" + fileRepoPath + fileName );  // 이미지 경로를 수정하여 사용한다.
	}
	
	@GetMapping("/download")
	public ResponseEntity<Object> download(@RequestParam("fileName") String fileName){
		
		String downloadFilePath = fileRepoPath + fileName;
		
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
	
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam("deleteFileName") String deleteFileName ) {
		
		File file = new File(fileRepoPath + deleteFileName);
		
		file.delete();
		
		String jsScript = """
				<script>
				alert('파일이 삭제 되었습니다.');
				location.href = '/file/main';
				</script>
				""";
		
		return jsScript;
	}
	
	@PostMapping("/update")
	@ResponseBody
	public String update (@RequestParam("deleteFileName") String deleteFileName ,
			              @RequestParam("modifyFile") MultipartFile modifyFile) throws IllegalStateException, IOException {
		
		File deleteFile = new File(fileRepoPath + deleteFileName);
		
		if(deleteFile.exists() && !modifyFile.isEmpty()) {
			deleteFile.delete();
				
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
