package _08_file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String deleteFile = request.getParameter("deleteFile");
		
		File file = new File(FileConfig.FILE_REPOSITORY_PATH + deleteFile);
		
		if (file.exists()) { // 파일이 존재하면
			file.delete();   // delete 메서드로 파일을 삭제한다.
			
		String jsScript = """
				<script>
					alert('파일을 삭제 하였습니다.');
					location.href = 'fileMain';
				</script>""";
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(jsScript);
		
		}
		else { // 파일이 존재하지 않으면
			String jsScript = """
					<script>
						alert('파일이 존재하지 않습니다.');
						location.href = 'fileMain';
					</script>""";
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print(jsScript);
		}
		
		
		
	}

}
