package synjones.dreams.android;

import synjones.dreams.android.R;
import synjones.dreams.service.HttpWebService;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneAddrActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.phone);
	
	Button button=(Button)findViewById(R.id.btnPhoneQuery);
	button.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText editText=(EditText)findViewById(R.id.txtPhone);
		if (editText.getText().equals("")) {
			Toast.makeText(PhoneAddrActivity.this, "«Î ‰»Î ÷ª˙∫≈", Toast.LENGTH_LONG).show();
		}	else {
			TextView lblView=(TextView)findViewById(R.id.lblPhoneAddr);
			String phoneString=editText.getText().toString();
			Log.i("PhoneActivity", phoneString);
			lblView.setText(new HttpWebService().GetPhoneAddr("http://webservice.webxml.com.cn/WebServices/MobileCodeWS.asmx",phoneString));
		}
		}
	});
}
}
