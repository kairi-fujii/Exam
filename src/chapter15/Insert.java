package chapter15;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/insert"})
public class Insert extends HttpServlet {
	@Override
	protected void doPost(
				HttpServletRequest req,
				HttpServletResponse resp
			) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);

		// 例外処理
		try{
			String name = req.getParameter("name");
			int price = Integer.parseInt(req.getParameter("price"));
			// Product のインスタンス
			Product p = new Product();
			//セッターを使って Productクラスのフィールドを定義
			p.setName(name);
			p.setPrice(price);

			// Product のインスタンス
			ProductDAO dao = new ProductDAO();
			// ProductDAO.insert() メソッドを実行 -> 更新データ件数を取得
			int line = dao.insert(p);

			// 更新データの件数が0件より多かった場合更新成功
			if(line > 0){
				out.println("追加に成功しました");
			}
		}catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);


	}


}
