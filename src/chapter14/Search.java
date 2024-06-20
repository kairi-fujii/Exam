package chapter14;

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

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/search"})
public class Search extends HttpServlet {
	@Override
	//	POSTでの実行（値の引き渡し）
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Page.header(out);
		try{
			// データベースへの接続 start
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/book");
			Connection con=ds.getConnection();
			// データベースへの接続 end

			// getParameterメソッドを利用してJSPの中で入力された値を取得
			String keyword=req.getParameter("keyword");
			// SQLの設定（作成）
			PreparedStatement st=con.prepareStatement(
					// WHERE句の LIKE式を使って、あいまい検索を行なう
					// ?（プレースホルダ）を検索文字列を置き換えできるようにする
					"SELECT * FROM PRODUCT WHERE NAME LIKE ?");
			// "%" を使うことで keywordの前後に文字が付くデータを検索する
			// 第一引数に設定した数値番目の "?" を第二引数で置き換え
			st.setString(1, "%"+keyword+"%");
			// SQLをDBMSに実行依頼 結果を取得
			ResultSet rs=st.executeQuery();

			// SQLの結果を全て表示する（ループ文）
			while (rs.next()) {
				// getInt, getString でテーブルの項目名を指定する事で値を取得
				out.println(rs.getInt("id"));
				out.println("：");
				out.println(rs.getString("name"));
				out.println("：");
				out.println(rs.getString("price"));
				out.println("<br>");
			}
			// SQLの設定を終了（開放）する
			st.close();
			// DBとの接続
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
