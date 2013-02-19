package synjones.dreams.android;

import synjones.dreams.android.R;
import synjones.dreams.models.CardInfo;
import synjones.dreams.service.CardManageService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CardInfoActivity extends Activity {
	private CardManageService cardManageService;
	
	@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
    setContentView(R.layout.cardinfo);
    
    ShowInfo();
    
    Button btnBackButton=(Button)this.findViewById(R.id.btnCardInfoBack);
    btnBackButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(CardInfoActivity.this, DreamsActivity.class);
			startActivity(intent);
		}
	});
    
    Button btnExitButton=(Button)this.findViewById(R.id.btnCardInfoExit);
    btnExitButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(CardInfoActivity.this, "ÍË³ö", Toast.LENGTH_LONG).show();
		}
	});
}
private void ShowInfo()
{cardManageService=new CardManageService();
	CardInfo cardInfo=cardManageService.GetCardInfoDemo("255790");
	((TextView)this.findViewById(R.id.lblBankNo)).setText(cardInfo.getBankNo());
	((TextView)this.findViewById(R.id.lblCardNo)).setText(cardInfo.getCardNo());
	((TextView)this.findViewById(R.id.lblSno)).setText(cardInfo.getSno());
	((TextView)this.findViewById(R.id.lblBankBalance)).setText(cardInfo.getBankBalance());
	((TextView)this.findViewById(R.id.lblCardBalance)).setText(cardInfo.getCardBalance());
	}
//@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		// TODO Auto-generated method stub
//		super.onActivityResult(requestCode, resultCode, data);
//	}
}
