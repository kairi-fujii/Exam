package chapter15;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.Product;
import tool.Page;

@WebServlet(urlPatterns={"/chapter15/bean"})
public class Bean extends HttpServlet {
	@Override
	protected void doGet(
				HttpServletRequest req,
				HttpServletResponse resp
			) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();

			DataSource ds=(DataSource)ic.lookup(
				"java:/comp/env/jdbc/book");//context.xml name属性を紐づける
			// DataSourceのgetCOnnectionメソッドを使ってDBと接続
			Connection con=ds.getConnection();
			// DBに向けて送るSQLを記述
			PreparedStatement st=con.prepareStatement(
			"select * from product");
			// SQLの実行 結果をResultSet型のrs に格納
			ResultSet rs=st.executeQuery();

			// Product(Bean)をインスタンス化
			Product p=new Product();

			// SQLの結果を全て表示する（ループ文）
			while (rs.next()) {

				// Beanに値を設定する事で変数に関連性を持たせる
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));

				// 変数にデータを格納する
				int id = p.getId();;
				String name = p.getName();
				int price = p.getPrice();

				// getInt, getString でテーブルの項目名を指定する事で値を取得
				out.println(id);
				out.println("：");
				out.println(name);
				out.println("：");
				out.println(price);
				out.println("<br>");
				}
				// SQLの設定を終了（開放）する
				st.close();
				// DBとの接続を切断する
				con.close();
			} catch (Exception e) {
				e.printStackTrace(out);
			}
		Page.footer(out);

	}
}
