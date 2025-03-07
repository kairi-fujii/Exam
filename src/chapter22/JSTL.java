package chapter22;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

@WebServlet(urlPatterns={"/chapter22/jstl"})
public class JSTL extends HttpServlet {
	@Override
	protected void doGet(
				HttpServletRequest req,
				HttpServletResponse resp
			) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		try{
			ProductDAO dao = new ProductDAO();
			//
			String keyword = "";
			List<Product> list = dao.search(keyword);

			req.setAttribute("list", list);

			// "attribute2.jsp"をフォワード(実行) する
			req.getRequestDispatcher("jstl.jsp").forward(req, resp);
		}catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
