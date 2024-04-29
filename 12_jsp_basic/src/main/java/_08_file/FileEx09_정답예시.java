package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileEx09_정답예시")
public class FileEx09_정답예시 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deleteFileName = request.getParameter("deleteFileName");
		new File(FileConfig.FILE_REPOSITORY_PATH  + deleteFileName).delete();
		
		String jsScript = """
			<script>
				alert('파일을 삭제 하였습니다.');
				location.href = 'fileMain';
			</script>""";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsScript);
		
	}

}
