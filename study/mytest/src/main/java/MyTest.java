/**
 * @author ：shizhonghuai
 * @date ：2019/6/19 18:41
 * @description： TODO
 * @modified By：
 * @version:
 */
public class MyTest {

    public static void main(String[] args) {
        int result = plus(5);
        System.out.println("result="+result);
    }

    public static int plus(int i){
        try {
            ++i;
            return i++;
        }finally {
            i++;
        }
    }
}
