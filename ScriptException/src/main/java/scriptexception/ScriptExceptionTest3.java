package scriptexception;

import com.google.gson.Gson;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

public class ScriptExceptionTest3 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("buyplanguid", "3");
        map.put("platform", null);
        map.put("name", 1);
        String configInfo = "(platform == nil || name == nil)";
        Expression expression = AviatorEvaluator.compile(configInfo);
        Boolean result = (Boolean) expression.execute(map);
        if (result) {
            System.out.println("是预警数据");
        } else {
            System.out.println("不是预警数据");
        }
    }
}
