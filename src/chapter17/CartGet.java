package chapter17;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Page;

@WebServlet(urlPatterns={"/chapter17/cart-get"})
public class CartGet extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		Page.header(out);

		// セッションの開始
		HttpSession session=request.getSession();

		// getAttributeを使ってセッションに保存されているデータを取得
		List<Product> cart=(List<Product>)session.getAttribute("cart");

		// セッションのデータをループ文を使って表示
		for (Product p : cart) {
			out.println("<p>");
			out.println(p.getName());
			out.println("：");
			out.println(p.getPrice());
			out.println("</p>");
		}

		Page.footer(out);
	}
}
