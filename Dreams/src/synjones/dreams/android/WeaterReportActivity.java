package synjones.dreams.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import synjones.dreams.android.R;
import synjones.dreams.service.WeatherReportService;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class WeaterReportActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weatherreport);
		LoadGrid();

	}

	private void LoadGrid() {
		SimpleAdapter adapter = new SimpleAdapter(WeaterReportActivity.this,
				LoadProvince(), R.layout.weathergriditem,
				new String[] { "provinceName" }, new int[] { R.id.weateritem });
		GridView gView = (GridView) findViewById(R.id.weathergrid);
		gView.setAdapter(adapter);

		gView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				 proviceNameString = provinceSource.get(arg2).get(
						"provinceName");
				// TextView txtTextView=(TextView)arg1;
				// Toast.makeText(WeaterReportActivity.this,proviceNameString,Toast.LENGTH_SHORT).show();
				List<Map<String, String>> citysList = LoadCitys(proviceNameString);
				SimpleAdapter adapter = new SimpleAdapter(
						WeaterReportActivity.this, citysList,
						R.layout.weathergriditem, new String[] { "cityName" },
						new int[] { R.id.weateritem });

//				GridView gView = (GridView) findViewById(R.id.weathergrid);
//				gView.setAdapter(adapter);
			ListView listView=new ListView(WeaterReportActivity.this);
			listView.setAdapter(adapter);
			setContentView(listView);
			listView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					String cityNameString=citysMap.get(proviceNameString).get(arg2).get("cityName");
					cityNameString=cityNameString.substring(0,cityNameString.indexOf("("));
					Log.i("cityName", cityNameString);
					String weatherInfo=GetCityInfo(cityNameString);
					TextView tx=new TextView(WeaterReportActivity.this);
					tx.setText(weatherInfo);
					setContentView(tx);
					
				};
			});
			}
		});

	}
private String proviceNameString;
	private List<Map<String, String>> provinceSource = new ArrayList<Map<String, String>>();
	private Map<String, List<Map<String, String>>> citysMap = new HashMap<String, List<Map<String, String>>>();

	private List<Map<String, String>> LoadProvince() {
		if (provinceSource == null || provinceSource.isEmpty()) {

			WeatherReportService service = new WeatherReportService();
			List<String> provinceList = service.GetProvinces();
			for (String provice : provinceList) {
				Map<String, String> maps = new HashMap<String, String>();
				maps.put("provinceName", provice);
				provinceSource.add(maps);
			}
		}
		return provinceSource;
	}

	private List<Map<String, String>> LoadCitys(String proviceName) {
		if (citysMap.isEmpty() || !citysMap.containsKey(proviceName)) {
			List<String> citysList = new WeatherReportService()
					.GetCitys(proviceName);
			List<Map<String, String>> citymapList=new ArrayList<Map<String,String>>();
			for (String city : citysList) {
				Map<String, String> cityMap=new HashMap<String, String>();
				cityMap.put("cityName", city);
				citymapList.add(cityMap);
			}
			citysMap.put(proviceName, citymapList);
		}
		return citysMap.get(proviceName);
	}

//	private List<Map<String, String>> getCityMaps(List<String> citys) {
//		List<Map<String, String>> cityMaps = new ArrayList<Map<String, String>>();
//		for (String city : citys) {
//			Map<String, String> map2 = new HashMap<String, String>();
//			map2.put("cityName", city);
//			cityMaps.add(map2);
//		}
//		return cityMaps;
//	}
//	
	private String GetCityInfo(String cityName)
	{
		WeatherReportService service=new WeatherReportService();
	   return	service.GetWeatherInfo(cityName);
	}
}
