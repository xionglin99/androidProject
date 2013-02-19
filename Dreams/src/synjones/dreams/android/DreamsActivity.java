package synjones.dreams.android;

import synjones.dreams.android.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class DreamsActivity extends BaseActivity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// 平台通知
		Button btnNoticeButton = (Button) this.findViewById(R.id.btnNotice);
		btnNoticeButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MakeShortToast("平台通知");
			}
		});

		// 个人通知
		Button btnPersonalButton = (Button) this
				.findViewById(R.id.btnPersonalNotice);
		btnPersonalButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MakeShortToast("个人通知");
			}
		});

		// 校园卡基本信息
		Button btnCardInfoButton = (Button) this.findViewById(R.id.btnCardInfo);
		btnCardInfoButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// MakeToast("校园卡基本信息");
				ShowActivity(DreamsActivity.this, CardInfoActivity.class);

			}
		});

		Button btnTrjnQueryButton = (Button) this
				.findViewById(R.id.btnTrjnQuery);
		btnTrjnQueryButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//MakeShortToast("流水查询");
				ShowActivity(DreamsActivity.this, TrjnQueryActivity.class);
			}
		});

		Button btnTransferButton = (Button) this.findViewById(R.id.btnTransfer);
		btnTransferButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//MakeShortToast("转账充值");
				ShowActivity(DreamsActivity.this, CardTransferActivity.class);
			}
		});

		Button btnPayPowerFee = (Button) this.findViewById(R.id.btnPayPowerFee);
		btnPayPowerFee.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//MakeShortToast("缴电费");
				ShowActivity(DreamsActivity.this, PayPowerFeeActivity.class);
			}
		});

		Button btnPayNetFeeButton = (Button) this
				.findViewById(R.id.btnPayNetFee);
		btnPayNetFeeButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//MakeShortToast("缴网费");
				ShowActivity(DreamsActivity.this, PayNetFeeActivity.class);
			}
		});

		Button btnSetCardLoss = (Button) this.findViewById(R.id.btnSetCardLoss);
		btnSetCardLoss.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//MakeShortToast("校园卡挂失");
				ShowActivity(DreamsActivity.this, CardLostActivity.class);
			}
		});

		// 手机归属地查询
		Button btnPhoneButton = (Button) this
				.findViewById(R.id.btnPhoneAddress);
		btnPhoneButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(DreamsActivity.this, PhoneAddrActivity.class);
				startActivity(intent);
				DreamsActivity.this.finish();
			}
		});

		// 天气预报
		Button btnWeatherButton = (Button) this.findViewById(R.id.btnWeather);
		btnWeatherButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ShowActivity(DreamsActivity.this, WeaterReportActivity.class);
			}
		});
		FindBtnAndSetClick(R.id.btnWebkit);
		// Button btnWebViewButton=(Button)this.findViewById(R.id.btnWebkit);
		// btnWebViewButton.setOnClickListener(new View.OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// // TODO Auto-generated method stub
		// ShowActivity(DreamsActivity.this,WebViewActivity.class);
		//
		// }
		// });

		FindBtnAndSetClick(R.id.btnTestDB);

	}

	private void FindBtnAndSetClick(int btnID) {
		Button btnButton = (Button) findViewById(btnID);
		btnButton.setOnClickListener(new btnClickListener());
	}

	public class btnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {

			case R.id.btnTestDemo:
				break;
			case R.id.btnWebkit:
				ShowActivity(DreamsActivity.this, WebViewActivity.class);
				break;
			case R.id.btnTestDB:
				SharedPreferences preferences = getBaseContext()
						.getSharedPreferences("dreams", MODE_WORLD_WRITEABLE);
				Editor editor = preferences.edit();
				editor.putString("cardno", "123456");
				editor.putString("sno", "0090052");
				editor.commit();

				String cardnoString = preferences.getString("cardno", "111");
				Log.i("cardno", cardnoString);
				MakeShortToast(cardnoString);
				break;
			default:
				break;
			}

		}
	}

}
