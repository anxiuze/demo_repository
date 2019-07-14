package ioTest;


import java.io.FileReader;
import java.io.IOException;

/**
 * @author ：shizhonghuai
 * @date ：2019/7/13 23:40
 * @description：字符输出流读取文件
 */
public class ReadTest {

    public static void main(String[] args) {

        FileReader fr = null;
        char [] buff = new char[1024];
        try {
            fr = new FileReader("F:\\Git\\study\\mytest\\src\\main\\java\\extendsTest\\ExtendsTest.java");
            int num = 0;
            while ((num = fr.read(buff)) !=-1){
                System.out.print(new String(buff,0, num));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
