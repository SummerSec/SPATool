package cfg;

import java.io.IOException;

/**
 * @ClassName: dot
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/8 22:34
 * @Version: v1.0.0
 * @Description:
 **/
public class dot {

    public static void main(String[] args) {
        String[] cmds = new String[]{"cmd.exe", "/c", "dot", "-Tpng", "G:\\GitHubProject\\SPATool\\datas\\sootOutput\\726180910287200\\tmethod.dot", "-o", "G:\\GitHubProject\\SPATool\\result\\725912927108400\\tm.png"};

        try {
            Runtime.getRuntime().exec(cmds);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
