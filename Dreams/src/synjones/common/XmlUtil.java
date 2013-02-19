package synjones.common;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlUtil {

	public String ReplaceXml(String xml,Map<String, String> maps)
	{
		String result=xml;
		if(maps!=null&&!maps.isEmpty())
		{
			for(Map.Entry<String, String> entry:maps.entrySet())
			{
				String nameString="\\$"+entry.getKey();
				Pattern pattern=Pattern.compile(nameString);
				Matcher matcher=pattern.matcher(result);
				if(matcher.find())
				{
					result=matcher.replaceAll(entry.getValue());
				}
			}
		}
		return result;
	}
}
