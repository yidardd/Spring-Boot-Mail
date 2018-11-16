package net.rdd.testMail;

import com.google.common.base.Optional;
import net.rdd.cache.CacheMap;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by rdd on 2018/11/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

    public static void main(String[] args) {

//        System.out.println(1111);
//        System.out.println(2222);
//        System.out.println(333);
//        System.out.println(444);
//        System.out.println(5555);
//        System.out.println(6666);

//        CacheMap.put("111", "fds");
//
//        Object o = CacheMap.get("111");
//        System.out.println(o);

        Student student = new Student();
        Optional<Student> possibleNull = Optional.of(student);
        Student student1 = possibleNull.get();


    }

}
