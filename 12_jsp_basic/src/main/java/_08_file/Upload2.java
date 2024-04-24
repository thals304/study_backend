package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/upload2")
public class Upload2 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// saveDirectory 맨 뒤에 \\ 를 반드시 추가해줘야함!!
		// String saveDirectory ="C:\\Users\\somin\\git\\study_backend\\12_jsp_basic\\src\\main\\webapp\\chapter08_file\\fileRepository\\";
		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
		
		MultipartRequest multipartRequest = new MultipartRequest(request, saveDirectory , 1024 * 1024 * 300 , "utf-8");
		
		Enumeration<?> files = multipartRequest.getFileNames();
		
		while (files.hasMoreElements()) { // <input type="file" />엘리먼트가 있으면
			
			String element = (String)files.nextElement();
			
			if (multipartRequest.getOriginalFileName(element) != null) { // 업로드한 파일이 있으면
				
				String originalFileName = multipartRequest.getOriginalFileName(element);
				
				System.out.println("originalFileName : " + originalFileName);
				
				UUID uuid = UUID.randomUUID(); // UUID.randomUUID() : 해쉬 생성 메서드
				System.out.println("uuid : " + uuid);
				
				// 파일의 확장자를 구한다.
				String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
				System.out.println("extension : " + extension);
				
				// UUID.확장자 형태파일명을 생성한다.
				String fileUUID = uuid + extension;
				System.out.println("fileUUID : " + fileUUID);
				
				File originalFile = new File(saveDirectory + originalFileName); // 기존에 업로드한 파일을 자바객체로 생성한다.
				File renameFile = new File(saveDirectory + fileUUID);			// 변환된 파일을 자바객체로 생성한다.
				originalFile.renameTo(renameFile);								// 기존에 업로드한 파일을 변환된 파일로 변경// 기존에 업로드한 파일을 변환된 파일로 변경
			}
			
		}
		String jsScript = """
				<script>
					alert('파일을 업로드 하였습니다.');
					location.href = 'fileMain';
				</script>""";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsScript);
	
		
	}

}
