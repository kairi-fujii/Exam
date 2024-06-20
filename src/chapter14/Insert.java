package chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Page;

@WebServlet(urlPatterns={"/chapter14/insert"})
public class Insert extends HttpServlet {
	@Override
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
			String name=req.getParameter("name");
			// getParameterメソッドを利用してJSPの中で入力された値を取得
			// Integer.parseIntメソッドを利用して文字列をInt型に変換
			int price=Integer.parseInt(req.getParameter("price"));

			// SQLの設定（作成）
			PreparedStatement st=con.prepareStatement(
					// INSRT文を用意してデータベースにデータを登録できるようにする
					// ?（プレースホルダ）を検索文字列を置き換えできるようにする
					"INSERT INTO PRODUCT VALUES(null, ?, ?)");

			// 第一引数に設定した数値番目の "?" を第二引数で置き換え
			st.setString(1, name);
			st.setInt(2, price);

			// SQLをDBMSに実行依頼 結果を取得
			// 登録件数、更新件数を取得
			int line=st.executeUpdate();

			if(line>0){
//				out.println("追加しました");
				// JSPをforwardする仕組み
				// JSPに画面表示は全て任せる
				// サーブレット側でデータ処理を行なう
				req.getRequestDispatcher("insert_success.jsp").forward(req, resp);

			}else{
				out.println("追加できませんでした");

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
