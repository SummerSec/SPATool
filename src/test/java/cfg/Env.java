package cfg;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName: Env
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/6 21:18
 * @Version: v1.0.0
 * @Description:
 **/
public class Env {

    public static void main(String [] args) {
        Map m = System.getenv();
        for (Iterator it = m.keySet().iterator(); it.hasNext(); )
        {
            String key = (String ) it.next();
            String value = (String ) m.get(key);
            System.out.println(key +":" +value);
        }
        System.out.println( "--------------------------------------" );
        Properties p = System.getProperties();

        for ( Iterator it = p.keySet().iterator(); it.hasNext(); )
        {
            String key = (String ) it.next();
            String value = (String ) p.get(key);
            System.out.println(key +":" +value);
        }
    }
}
