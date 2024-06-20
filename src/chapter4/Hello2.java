package chapter4; // P56-57の内容を記述

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// パス
// コンテキストパス：http://localhost:8080/book
// コンテテキストパスからの相対パス：/chapter3/hello
// ↓404エラーが発生したら確認する場所
@WebServlet(urlPatterns={"/chapter4/hello2"})

// public class → ファイル名と同じ（大文字小文字判別あり）
// JavaのClass名は先頭大文字（アッパーキャメルケース）
public class Hello2 extends HttpServlet {
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
		response.setContentType("text/plain; charset=UTF-8");

		// HTMLへの書き出しを行なうための定義
		PrintWriter out=response.getWriter();
		// ↓HTMLの記述（HTMLを作成する関数）
		out.println("<h1>Hello!</h1>");
		out.println("こんにちは");
		// 現在時刻の取得＋ブラウザに表示
		out.println(new java.util.Date());


	}

}




