import com.yazuo.People;

import java.lang.reflect.Field;


/**
 * @Author: caimian
 * @Description:
 * @Date: 2018/5/4 14:59
 */
public class Test2 {

    public static void main(String[] args) throws Exception {

      for(int i =0;i<10;i++){
          if(i==5){
              continue;
          }
          System.out.println(i);

          if(i==8){
              continue;
          }
          System.out.println(i);

      }

    }

}
