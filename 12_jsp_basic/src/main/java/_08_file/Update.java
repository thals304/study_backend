package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/update")
public class Update extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String saveDirectory = FileConfig.FILE_REPOSITORY_PATH;
		
		// 새로운 파일 업로드
		MultipartRequest mr = new MultipartRequest(request, saveDirectory , 1024 * 1024 * 30 , "utf-8");
		
		// 기존 파일 삭제
		String deleteFileName = mr.getParameter("deleteFileName");
		
		new File(saveDirectory + deleteFileName).delete();
		
		String jsScript = """
				<script>
					alert('파일을 수정 하였습니다.');
					location.href = 'fileMain';
				</script>""";
			
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsScript);
	
	}

}
