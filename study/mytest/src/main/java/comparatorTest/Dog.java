package comparatorTest;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：shizhonghuai
 * @date ：2019/7/7 13:12
 * @description： TODO
 * @modified By：
 * @version:
 */
@Data
public class Dog {

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog("KK",12);
        Dog dog2 = new Dog("QQ",23);
        Dog dog3 = new Dog("ww",6);

        List<Dog> dogList = new ArrayList<>(4);
        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);

        for (Dog dog : dogList) {
            System.out.println("排序前："+ dog);
        }

        System.out.println("++++++++++++++++++++++++++++++++");
        Collections.sort(dogList,new DogComparator());

        for (Dog dog : dogList) {
            System.out.println("排序前："+ dog);
        }

    }

}
