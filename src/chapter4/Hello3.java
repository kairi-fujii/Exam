package chapter4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//パス
//コンテキストパス：http://localhost:8080/book
//コンテテキストパスからの相対パス：/chapter3/hello
//↓404エラーが発生したら確認する場所
@WebServlet(urlPatterns={"/chapter4/hello3"})

//public class → ファイル名と同じ（大文字小文字判別あり）
//JavaのClass名は先頭大文字（アッパーキャメルケース）
public class Hello3 extends HttpServlet {
	// ブラウザからのリクエストはアプリケーションに対して
	// Getを送信する為doGetメソッドが実行される
	public void doGet (
		// HttpServletRequest：サーバーに対してのリクエスト情報を取得する
		HttpServletRequest request,
		// HttpServletResponse：レスポンスを生成する為に使用する引数
		HttpServletResponse response

	// ServletException：サーブレットの実行中に例外が発生した際に知らせる
	// IOException：入力処理において例外が発生した際に知らせる
	) throws ServletException, IOException {

		// 日本語を表示する設定
		// 文字コードを設定する（UTF-8）
		// printなの記述の意味を設定（htmlでhtmlの要素を判定）
		response.setContentType("text/html; charset=UTF-8");

		// HTMLへの書き出しを行なうための定義
		PrintWriter out=response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<p>Hello!</p>");
		out.println("<p>こんにちは！</p>");
		out.println("<p>"+new java.util.Date()+"</p>");

		out.println("</body>");
		out.println("</html>");
	}
}
