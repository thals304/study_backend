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

@WebServlet("/fileEx10_정답예시")
public class FileEx10_정답예시 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
		
		MultipartRequest multipartRequest = new MultipartRequest(request , saveDirectory , 1024*1024*30 , "utf-8");
		String deleteFileName = multipartRequest.getParameter("deleteFileName");
		
		new File(saveDirectory + deleteFileName).delete(); 	
		
		Enumeration<?> files = multipartRequest.getFileNames();
		if (files.hasMoreElements()) {  			
			
			String element = (String)files.nextElement();	
			String originalFileName = multipartRequest.getOriginalFileName(element); 
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String fileUUID = UUID.randomUUID() + extension;
			
			File originalFile = new File(saveDirectory + originalFileName);	
			File renameFile = new File(saveDirectory + fileUUID);		
			originalFile.renameTo(renameFile);
				
		}
		
		String jsScript = """
						<script>
							alert('수정 되었습니다.');
							location.href = 'fileMain';
						</script>""";
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();	
		out.print(jsScript);
		
	}

}
