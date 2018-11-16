package net.rdd.testMail;

import com.google.common.base.CharMatcher;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.*;

import static com.google.common.base.CharMatcher.inRange;
import static org.hibernate.validator.internal.util.CollectionHelper.newHashMap;
import static org.springframework.boot.context.properties.bind.Bindable.mapOf;

/**
 * Created by rdd on 2018/11/14.
 */
public class GuavaTest extends MainTest {

    public static void main(String[] args) {
        ImmutableList<? extends Serializable> of = ImmutableList.of("1", 2, 3, Lists.newArrayList("3",4));
        ImmutableBiMap<String, Integer> of1 = ImmutableBiMap.of("1", 2, "3", 4);
        String s = of1.toString();
        System.out.println(222211);
        System.out.println(of1);
//        BiMap<Object, Object> objectObjectBiMap = Maps.synchronizedBiMap();

//        bigMap();
//
//        charMatch();
//
//        arraytest();

        cacheTest();

    }

    private static void cacheTest() {


    }

    private static void arraytest() {

        int[] array = { 1, 2, 3, 4, 5 };

        System.out.println(Ints.max(array));
        System.out.println(Ints.min(array));



    }

    private static void charMatch() {

        CharMatcher or = inRange('a', 'z').or(inRange('A', 'Z'));
        System.out.println(or);

    }

    @Test
    public void test02(){
        doFile();
    }

    private void doFile() {

        File banner = new File(getClass().getResource("/banner.txt").getFile());
        String path = banner.getPath();
        try {
            List<String> list = Files.readLines(banner, Charset.defaultCharset());
            System.out.println(list);


            File test = new File(getClass().getResource("/test.txt").getFile());
        boolean equal = Files.equal(banner, banner);
        boolean equal2 = Files.equal(test, banner);
        boolean equal1 = Files.equal(new File(getClass().getResource("/test2.txt").getFile()), test);

            System.out.println(11);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test01() {
        ArrayList<Object> objects = Lists.newArrayList();
        ArrayList<String> strings = Lists.newArrayList("3", "3");
        System.out.println(strings);
        Map<String, Map<String, List<String>>> map = Maps.newHashMap();
        HashMap<String, String> objectObjectHashMap = newHashMap();
    }




    private static void bigMap() {
        BiMap<Integer,String> logfileMap = HashBiMap.create();
        @Nullable String put = logfileMap.put(1, "a.log");
        @Nullable String put2 = logfileMap.put(null, null);

        String s = logfileMap.get(null);
        @Nullable String put3 = logfileMap.put(null, "ds");
        String s1 = logfileMap.get(null);

        @Nullable String put1 = logfileMap.put(2, "b.log");
        logfileMap.put(3,"c.log");
        System.out.println("logfileMap:"+logfileMap);
        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);

        @Nullable Integer ds = filelogMap.put("3333", 4);
        System.out.println("logfileMap:"+logfileMap);
//        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:"+filelogMap);


    }


}
