package synjones.dreams.android;

import synjones.dreams.android.R;
import synjones.dreams.service.CardManageService;
import android.content.ContentProvider;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		Button btnLoginButton = (Button) findViewById(R.id.btnLogin);
		btnLoginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String usernameString = ((EditText) findViewById(R.id.lblUserName))
						.getText().toString();
				String password = ((EditText) findViewById(R.id.lblPassword))
						.getText().toString();
				if (usernameString.equals("") || password.equals("")) {
					MakeShortToast(R.string.strLoginTip);
					// Toast.makeText(context, resId, duration)
				} else {
					CardManageService service = new CardManageService();
					String cookieString = service.CheckIn(usernameString,
							password);
					if (cookieString == null || cookieString == "") {
						MakeShortToast(R.string.strLoginError);
					} else {
						{
							SharedPreferences preferences = getApplicationContext()
									.getSharedPreferences("cookievalue",
											MODE_WORLD_WRITEABLE);
							preferences.edit().putString("sk", cookieString);
							ShowActivity(LoginActivity.this,
									DreamsActivity.class);
						}
					}
				}
			}
		});
	}
}
