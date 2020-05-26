package scriptexception;

public class TestString {
    public static  void main(String []args){
       int j =0;
       for(j=0;j<10;j++){
           j+=++j;
           System.out.println(j);
       }
    }
}

