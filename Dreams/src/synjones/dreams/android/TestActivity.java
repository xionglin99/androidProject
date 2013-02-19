package synjones.dreams.android;

import android.os.Bundle;
import android.widget.TextView;


public class TestActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		TextView tView=new TextView(TestActivity.this);
		tView.setText("text");
		setContentView(tView);
		
	}
}
