package cfg;

/**
 * @ClassName: demo
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/6 19:43
 * @Version: v1.0.0
 * @Description:
 **/
public class demo {
    public static void main(String[] args) {
        System.out.println(test.str);
        test.str = "hello";
        System.out.println(test.str);
        test.str = "world";
        System.out.println(test.str);
    }
}
