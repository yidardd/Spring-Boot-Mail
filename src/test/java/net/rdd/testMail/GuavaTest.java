package net.rdd.testMail;

import com.google.common.base.CharMatcher;
import com.google.common.collect.*;
import com.google.common.io.Files;
import com.google.common.primitives.Ints;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.*;

import static com.google.common.base.CharMatcher.inRange;
import static org.hibernate.validator.internal.util.CollectionHelper.newHashMap;

/**
 * Created by rdd on 2018/11/14.
 */
public class GuavaTest extends MainTest {

    public static void main(String[] args) {
        ImmutableList<? extends Serializable> of = ImmutableList.of("1", 2, 3, Lists.newArrayList("3", 4));
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

        int[] array = {1, 2, 3, 4, 5};

        System.out.println(Ints.max(array));
        System.out.println(Ints.min(array));


    }

    private static void charMatch() {

        CharMatcher or = inRange('a', 'z').or(inRange('A', 'Z'));
        System.out.println(or);

    }

    @Test
    public void test02() {
        try {
            doFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doFile() throws Exception {

//        File banner = new File(getClass().getResource("/banner.txt").getFile());
//        File banner = new File("C:\\Users\\My\\Desktop\\file\\20w2.txt");

        long bef = System.currentTimeMillis();
        File banner = new File("C:\\Users\\My\\Desktop\\file\\20w2.txt");
        List<String> list = Files.readLines(banner, Charset.defaultCharset());
        long aft = System.currentTimeMillis();

        System.out.println(aft-bef);

//        File banner2 = new File("C:\\Users\\My\\Desktop\\file\\20w2.txt");
//        try {
//        List<String> list = Files.readLines(banner, Charset.defaultCharset());
//            List<String> list2 = Files.readLines(banner2, Charset.defaultCharset());
        List<String> list2 = new ArrayList<>(10060000);

//        for (int i = 0; i < 10000000; i++) {
//
//            if (i <= 100000) {
//                list2.add(list.get(i));
//            }
//            list2.add(String.valueOf(new Random().nextInt() * 11));
//
//        }
//
//        Set<String> set = new HashSet<>(list2.size() * 2);
//        set.addAll(list);
//        set.addAll(list2);
//        long bef = System.currentTimeMillis();
//        set.removeAll(list2);
//        long aft = System.currentTimeMillis();
//
//        System.out.println(set.size());
//        System.out.println(aft - bef);
//            list2.removeAll(list);

//            HashSet<Object> sets = new HashSet<>(list);
//            Iterator<String> iterator = list.iterator();
//            List<String> list3 = new ArrayList<>(200000);
//            int i = 0;
//           while(iterator.hasNext()) {
//               System.out.println(i++);
//               String s = iterator.next();
//               if (!list2.contains(s)) {
//                   list3.add(s);
//               }
//           }


//            long time = (System.currentTimeMillis() - bef) / 100;
//            System.out.println(time + "s");
//
//            File file = new File("C:\\Users\\My\\Desktop\\file\\20w3.txt");
//            if (!file.exists())
//                file.createNewFile();
//            FileOutputStream out = new FileOutputStream(file, true);
//            StringBuffer sb = new StringBuffer();
//            for (String s :
//                    list2) {
//                sb.append(s + "\n\r");
//                out.write(sb.toString().getBytes("utf-8"));
//            }
//            out.close();
//        } catch (Exception e)
//
//        {
//        }

//            File test = new File(getClass().getResource("/test.txt").getFile());
//        boolean equal = Files.equal(banner, banner);
//        boolean equal2 = Files.equal(test, banner);
//        boolean equal1 = Files.equal(new File(getClass().getResource("/test2.txt").getFile()), test);
//
//            System.out.println(11);


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
        BiMap<Integer, String> logfileMap = HashBiMap.create();
        @Nullable String put = logfileMap.put(1, "a.log");
        @Nullable String put2 = logfileMap.put(null, null);

        String s = logfileMap.get(null);
        @Nullable String put3 = logfileMap.put(null, "ds");
        String s1 = logfileMap.get(null);

        @Nullable String put1 = logfileMap.put(2, "b.log");
        logfileMap.put(3, "c.log");
        System.out.println("logfileMap:" + logfileMap);
        BiMap<String, Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);

        @Nullable Integer ds = filelogMap.put("3333", 4);
        System.out.println("logfileMap:" + logfileMap);
//        BiMap<String,Integer> filelogMap = logfileMap.inverse();
        System.out.println("filelogMap:" + filelogMap);


    }


}
