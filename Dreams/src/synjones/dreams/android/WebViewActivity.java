package synjones.dreams.android;

import synjones.dreams.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends Activity {
	private WebView webView;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.webview);
	Button button=(Button)findViewById(R.id.btnLook);
	button.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		EditText editText=(EditText)findViewById(R.id.txtUrl);
		 webView=(WebView)findViewById(R.id.myWebView);
		 String urlString=editText.getText().toString();
		 if(urlString.indexOf("http")==-1){
			 urlString="http://"+urlString;
		 }
		webView.loadUrl(urlString);
		WebSettings settings=webView.getSettings();
		settings.setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// TODO Auto-generated method stub
				//return super.shouldOverrideUrlLoading(view, url);
				view.loadUrl(url);
				return true;
			}
		});
		}
	});
}
@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		//return super.onKeyDown(keyCode, event);
	if(keyCode==KeyEvent.KEYCODE_BACK&&webView.canGoBack())
	{
		webView.goBack();
		return true;
	}
	return super.onKeyDown(keyCode, event);
	}
}
