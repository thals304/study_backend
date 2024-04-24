package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/fileEx05_정답예시")
public class FileEx05_정답예시 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("chapter08_file/fileEx_정답예시/fileEx05_정답예시.jsp"); 
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MultipartRequest multipartRequest = new MultipartRequest(request, FileConfig.FILE_REPOSITORY_PATH , 1024 * 1024 * 100 , "utf-8" );
		
		Enumeration<?> files = multipartRequest.getFileNames();
		
		if (files.hasMoreElements()) { 
			
			String element  = (String)files.nextElement();  	   			 
			String originalFileName = multipartRequest.getOriginalFileName(element); 
			String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
			String fileUUID = UUID.randomUUID() + extension;
			
			File originalFile = new File(FileConfig.FILE_REPOSITORY_PATH + originalFileName);		
			File renameFile = new File(FileConfig.FILE_REPOSITORY_PATH + fileUUID);				
			originalFile.renameTo(renameFile);		
			
			System.out.println("originalFileName : " + originalFileName );
			System.out.println("fileUUID : " + fileUUID );
			System.out.println();
			
			String jsScript = """
				<script>
					alert('파일을 업로드 하였습니다.');
					history.go(-1);
				</script>""";
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsScript);
			
		}
		
		
	}

}
