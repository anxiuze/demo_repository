package comparatorTest;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ：shizhonghuai
 * @date ：2019/7/7 12:24
 * @description： TODO
 * @modified By：
 * @version:
 */
@Data
public class Person implements Comparable<Person>{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        return this.age-person.age;
    }


    public static void main(String[] args) {
        Person p1 = new Person("AA",12);
        Person p2 = new Person("BBB",15);
        Person p3 = new Person("BBCC",7);

        List<Person> personList = new ArrayList<>(100);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        for (Person person : personList) {
            System.out.println("排序前："+person.toString());
        }

        Collections.sort(personList);
        System.out.println("+++++++++++++++++++++++++++++++++++++");

        for (Person person : personList) {
            System.out.println("排序后："+person.toString());
        }
    }

}
