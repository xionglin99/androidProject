package synjones.dreams.android;

import synjones.dreams.android.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CardTransferActivity extends BaseActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.cardtransfer);
	
	Button btnBackButton=(Button)findViewById(R.id.btnTransferCancel);
	btnBackButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		ShowActivity(CardTransferActivity.this, DreamsActivity.class);	
		}
	});
}
}
