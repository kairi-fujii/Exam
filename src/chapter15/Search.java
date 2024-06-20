package chapter15;

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
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/search"})
public class Search extends HttpServlet {
	@Override
	protected void doPost(
				HttpServletRequest req,
				HttpServletResponse resp
			) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		Page.header(out);
		// try を使って例外処理を実施
		// DB接続を行なう場合 例外処理の可能性が高まるので必須
		try {
			// JSPで入力された値を取得 -> 変数:keyword に格納
			String keyword = req.getParameter("keyword");
			// ProductDAO のインスタンス
			ProductDAO dao = new ProductDAO();
			// seachメソッドの実行で DBからデータを取得
			// 引数に入力値を入れる事で入力した値を元にデータを取得
			List<Product> list = dao.search(keyword);

			// ループ文を使って画面にデータを表示する
			// Product型(bean.product)の変数:p に listの中身を1つずつ格納する
			for(Product p : list){
				// ゲッターを使って変数にデータを格納する
				int id = p.getId();
				String name = p.getName();
				int price = p.getPrice();

				// 取得した変数を画面に表示する
				out.println(id);
				out.println("：");
				out.println(name);
				out.println("：");
				out.println(price);
				out.println("<br>");

			}

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
