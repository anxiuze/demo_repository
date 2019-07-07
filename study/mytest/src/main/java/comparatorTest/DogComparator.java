package comparatorTest;

import java.util.Comparator;

/**
 * @author ：shizhonghuai
 * @date ：2019/7/7 13:13
 * @description： 自定义狗子比较器，按照年龄进行排序
 * @modified By：
 * @version:
 */

public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {

        return o2.getAge()-o1.getAge();

    }
}
