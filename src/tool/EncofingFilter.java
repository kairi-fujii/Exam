package tool;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

// WebFilterアノテーション "/*" とすることで全てのサーブレットに適応
@WebFilter(urlPatterns={"/*"})
// Filterインターフェイスの実装（destroy, doFilter, init）
public class EncofingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ
		// Filterの終了時に1度だけ呼び出されるメソッド
		// 今回の記述は無し

	}

	@Override
	public void doFilter(
			ServletRequest request,
			ServletResponse response,
			FilterChain chain)
			throws IOException, ServletException
	{
		// 全てのサーブレットで共通の文字コードの指定：UTF-8
		request.setCharacterEncoding("UTF-8");
		// 全てのサーブレットで共通のコンテンツ設定
		// コンテンツ：HTML形式
		// 文字コード：UTF-8
		response.setContentType("text/html; charset=UTF-8");
		// フィルターの実行が判りやすいようにコンソールにログとして文字を出力
		System.out.println("フィルタの前処理");
		// チェイン機能を使って複数のフィルターを実行する事ができる
		chain.doFilter(request, response);
		// フィルターの実行が判りやすいようにコンソールにログとして文字を出力
		System.out.println("フィルタの後処理");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ
		// Filterの開始時に1度だけ呼び出されるメソッド
		// 今回の記述は無し


	}

}
