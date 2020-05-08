
import java.io.File;

import java.io.IOException;
import java.util.Arrays;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\java");//找到这个路径的文件
        System.out.println(file.isFile());//判断是否为一个文件
        System.out.println(file.isDirectory());//判断是否为一个目录
        String[] strings = file.list();//该目录下的所有子目录和文件对象，并返回一个字符串
        System.out.println(Arrays.toString(strings));
        File[] files = file.listFiles();//该目录下的所有子目录和文件对象，并返回一个对象数组
        //包含的子目录
        assert files != null;
        for(File temp : files) {
            if(temp.isDirectory()) {
                System.out.println(temp);
            }
        }
        //包含的文件
        for(File temp : files) {
            if(temp.isFile()) {
                System.out.println(temp);
            }
        }
        File file1 = new File("d:\\happy");
        //创建一个文件
        if(! file1.exists()) {
            file1.createNewFile();
        }
        File dir = new File("e:\\dir");
        //创建一个目录
        if(!dir.exists()) {
            file1.mkdir();
        }

        //删一个文件要先删除这个文件里的文件和目录
        File file2 = new File("d:\\c++");
        File[] files1 = file2.listFiles();
        assert files1 != null;
        for (File temp: files1
             ) {
            temp.delete();
        }
        file2.delete();
    }
}
