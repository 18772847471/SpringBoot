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

public class ScriptExceptionTest2 {
    public static  void main(String []args){
        List<Buyplan>  list = new ArrayList<Buyplan>();
        Buyplan buyplan1 = new Buyplan();
        buyplan1.setBuyplanguid("1");
        buyplan1.setPlatform(4);
        buyplan1.setMoney(new BigDecimal(600000));
        buyplan1.setName("习近平1");
        list.add(buyplan1);

        Buyplan buyplan2 = new Buyplan();
        buyplan2.setBuyplanguid("2");
        buyplan2.setPlatform(7);
        buyplan2.setMoney(new BigDecimal(200000));
        buyplan2.setName("习近平2");
        list.add(buyplan2);

        Buyplan buyplan3 = new Buyplan();
        buyplan3.setBuyplanguid("3");
        buyplan3.setPlatform(0);
        buyplan3.setMoney(new BigDecimal(600000));
        buyplan3.setName("习近平3");
        list.add(buyplan3);

        Gson gson = new Gson();
        String configInfo = "习近平";
        for(Buyplan buyplan:list){
            String jsonStr = gson.toJson(buyplan);
            System.out.println(AviatorEvaluator.execute("string.contains('"+jsonStr+"','"+configInfo+"')"));
        }

     }
}
