package scriptexception;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import scriptexception.model.Buyplan;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScriptExceptionTest {
    public static  void main(String []args){
        List<Buyplan>  list = new ArrayList<Buyplan>();
        Buyplan buyplan1 = new Buyplan();
        buyplan1.setBuyplanguid("1");
        buyplan1.setPlatform(4);
        buyplan1.setMoney(new BigDecimal(600000));
        buyplan1.setName("习近平");
        list.add(buyplan1);

        Buyplan buyplan2 = new Buyplan();
        buyplan2.setBuyplanguid("2");
        buyplan2.setPlatform(7);
        buyplan2.setMoney(new BigDecimal(200000));
        buyplan2.setName("习近平");
        list.add(buyplan2);

        Buyplan buyplan3 = new Buyplan();
        buyplan3.setBuyplanguid("3");
        buyplan3.setPlatform(null);
        buyplan3.setMoney(new BigDecimal(600000));
        buyplan3.setName("习近平");
        list.add(buyplan3);

        Gson gson = new Gson();
        String configInfo = "name == '习近平' && (platform == 7 || platform == nil)";
        for(Buyplan buyplan:list){
            String jsonStr = gson.toJson(buyplan);
            Map m = JSONObject.parseObject(jsonStr);
            Expression expression = AviatorEvaluator.compile(configInfo);
            Boolean result = (Boolean)expression.execute(m);
            if(result){
               System.out.println(buyplan.getBuyplanguid()+"是预警数据");
            }else{
                System.out.println(buyplan.getBuyplanguid()+"不是预警数据");
            }
        }

     }
}
