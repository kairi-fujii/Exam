package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tool.Page;

@WebServlet(urlPatterns={"/chapter6/checkbox"})
public class Chekbox extends HttpServlet {
	@Override
	protected void doPost(
			HttpServletRequest req,
			HttpServletResponse resp
			) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out=resp.getWriter();

		req.setCharacterEncoding("UTF-8");
//		フォームで入力された値を取得（配列）
		String[] genre=req.getParameterValues("genre");

		Page.header(out);
//		フォームの入力があったのかを確認
		if(genre!=null){
//			配列の中身を1ずつ取り出して 変数：itemの中に格納
//			配列「genre」の中身が空になるまで繰り返し処理
			for(String item : genre){
				out.println("[" + item + "]");
			}
			out.println("に関するお買い得情報をお送りいたします。");
		} else {
			out.println("お買い得情報はお送りしません。");
		}
		Page.footer(out);
	}

}
