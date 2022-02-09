package cfg;

import java.util.Locale;

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
        String str = "G:\\GitHubProject\\SPATool\\datas\\sootOutput\\724867879666400\\FizzBuzz void printFizzBuzz(int).dot";
        System.out.println(str.substring(str.lastIndexOf("\\") + 1, str.lastIndexOf(".")));

    }
}
