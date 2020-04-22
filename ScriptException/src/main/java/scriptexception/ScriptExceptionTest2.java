package scriptexception;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import scriptexception.model.Buyplan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScriptExceptionTest2 {
    public static  void main(String []args){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("buyplanguid","3");
        map.put("platform",0);
        map.put("name","习近平1");




        Gson gson = new Gson();
        String configInfo = "习近平3";

            String jsonStr = gson.toJson(map);
            System.out.println(AviatorEvaluator.execute("string.contains('"+jsonStr+"','"+configInfo+"')"));


     }
}
