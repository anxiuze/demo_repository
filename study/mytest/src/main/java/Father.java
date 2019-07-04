import lombok.Data;

/**
 * @author ：shizhonghuai
 * @date ：2019/7/4 23:23
 * @description： TODO
 * @modified By：
 * @version:
 */
@Data
public class Father {

    private String name;

    private int age;

    public void test(){
        System.out.println("this is father!");
    }

}
