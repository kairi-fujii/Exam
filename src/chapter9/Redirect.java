package chapter9;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/chapter9/redirect"})
public class Redirect extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse respnse
			) throws ServletException, IOException {
		// リダイレクト実行：http://tomcat.apache.org/
		respnse.sendRedirect("http://tomcat.apache.org/");

	}
}










