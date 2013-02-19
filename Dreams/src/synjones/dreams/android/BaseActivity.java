package synjones.dreams.android;

import java.util.Properties;

import synjones.dreams.models.CardInfo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BaseActivity extends Activity {

	protected CardInfo cardInfo;
	
	protected void MakeShortToast(String text)
	   {
		   Toast.makeText(BaseActivity.this, text,Toast.LENGTH_SHORT).show();
	   }
	   protected void MakeLongToast(String text)
	   {
		   Toast.makeText(BaseActivity.this, text,Toast.LENGTH_LONG).show();
	   }
	   protected void MakeShortToast(int resoureid)
	   {
		   Toast.makeText(BaseActivity.this, resoureid,Toast.LENGTH_SHORT).show();
	   }
	   protected void MakeLongToast(int resourecid)
	   {
		   Toast.makeText(BaseActivity.this, resourecid,Toast.LENGTH_LONG).show();
	   }
	   

	   
	   protected void ShowActivity(Context context,Class<?> class1)
	   {
		   Intent intent=new Intent();
		   intent.setClass(context, class1);
		   startActivity(intent);
		  
		     
		  // Properties.class.getField("target")
	   }
	
}
