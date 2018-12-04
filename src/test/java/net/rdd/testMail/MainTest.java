package net.rdd.testMail;

import com.google.common.io.Files;
import org.assertj.core.util.Lists;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rdd on 2018/11/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    public static void main(String[] args) {


//        File file = new File("src.java");
//        file.renameTo(new File("dest.txt"));

        traverseFolder1("F:\\1");


    }

    public static void traverseFolder1(String path)  {

        try {


            ArrayList<String> objects = Lists.newArrayList();

            int fileNum = 0, folderNum = 0;
            File file = new File(path);
            if (file.exists()) {
                LinkedList<File> list = new LinkedList<File>();
                File[] files = file.listFiles();
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        System.out.println("文件夹:" + file2.getAbsolutePath());
                        list.add(file2);
                        folderNum++;
                    } else {
                        if (file2.getAbsolutePath().endsWith(".java")) {
                            objects.addAll(Files.readLines(file2, Charset.defaultCharset()));
                            objects.add("\r\n");
                        }

                        System.out.println("文件:" + file2.getAbsolutePath());
                        fileNum++;
                    }
                }
                File temp_file;
                while (!list.isEmpty()) {
                    temp_file = list.removeFirst();
                    files = temp_file.listFiles();
                    for (File file2 : files) {
                        if (file2.isDirectory()) {
                            System.out.println("文件夹:" + file2.getAbsolutePath());
                            list.add(file2);
                            folderNum++;
                        } else {
                            if (file2.getAbsolutePath().endsWith(".java")) {
                                objects.addAll(Files.readLines(file2, Charset.defaultCharset()));
                                objects.add("\r\n");
                            }
                            System.out.println("文件:" + file2.getAbsolutePath());
                            fileNum++;
                        }
                    }
                }
            } else {
                System.out.println("文件不存在!");
            }
            System.out.println("文件夹共有:" + folderNum + ",文件共有:" + fileNum);


            String s = "akjibuvuvu";
            FileWriter fw = null;
            File f = new File("F:\\a.txt");
            try {
                if(!f.exists()){
                    f.createNewFile();
                }
                fw = new FileWriter(f);
                BufferedWriter out = new BufferedWriter(fw);
                for (String s3:
                     objects) {
                    out.write(s3+"\r\n");
                    out.flush();
                }

                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("end");


        }catch (Exception e) {

        }
    }

//    public static List<File> getFileList(String strPath) {
//        File dir = new File(strPath);
//        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
//        if (files != null) {
//            for (int i = 0; i < files.length; i++) {
//                String fileName = files[i].getName();
//                if (files[i].isDirectory()) { // 判断是文件还是文件夹
//                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
//                } else if (fileName.endsWith("avi")) { // 判断文件名是否以.avi结尾
//                    String strFileName = files[i].getAbsolutePath();
//                    System.out.println("---" + strFileName);
//                    filelist.add(files[i]);
//                } else {
//                    continue;
//                }
//            }
//
//        }
//        return filelist;
//    }

}
