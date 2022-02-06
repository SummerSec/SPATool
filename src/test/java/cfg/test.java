package cfg;

import cn.hutool.log.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: test
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/6 19:40
 * @Version: v1.0.0
 * @Description:
 **/
public class test {
    public static String str = "123";
    static {
        test.str = "456";
    }
    public static void main(String[] args) {
        Logger log = LogManager.getLogger(test.class);
        log.info("info "+ "${sys:user.dir}");

    }


}
