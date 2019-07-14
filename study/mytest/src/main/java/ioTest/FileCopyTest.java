package ioTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName FileCopyTest
 * @Description 将文件A，copy一份
 * @Author shizhonghuai
 * @Date 2019/7/14 17:58
 * @Version 1.0
 **/
public class FileCopyTest {

    public static void main(String[] args) {
        copy_01();
    }

    /**
     * @Author shizhonghuai
     * @Description //TODO
     * @Date 18:03 2019/7/14
     **/
    public static void copy_01() {

        FileWriter fw = null;
        FileReader fr = null; //创建字符输入流，读取文件信息
        try {
            fr = new FileReader("F:\\Git\\study\\mytest\\src\\main\\java\\ioTest\\FileCopyTest.java");
            fw = new FileWriter("F:\\Git\\study\\mytest\\src\\main\\java\\CopyFile.txt");
            char[] buff = new char[1024];
            int len = 0;
            while ((len = fr.read(buff)) != -1) {
                fw.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (fw != null){
                    fw.close();
                }
                System.out.println("copy finish!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
