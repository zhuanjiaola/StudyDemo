package com.byx.study.mooc;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static java.nio.charset.StandardCharsets.UTF_8;

@Data
public class Student {

    private String name;

    @Test
    public void test01() {
        String s = "TSSPCMiniAppMessage";
        String ss = s.substring(5, 5 + 1).toLowerCase(Locale.ROOT) + s.substring(5 + 1);
        System.out.println(ss);


    }

    @Test
    public void test02() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(222);
            }
        });
        new Thread(() -> System.out.println(222));
        new Runnable() {

            @Override
            public void run() {

            }
        };
    }

    @Test
    public void test03() {

        String[] strings = {"1"};
        System.out.println(Arrays.asList(strings));
        String s = "|";
        String[] split = s.split("\\|");

        System.out.println(Arrays.asList(split));

    }

    @Test
    public void test04() {
        String a = ",a,,b,";
        String[] split = a.split(",");
        System.out.println(Arrays.asList(split));
        System.out.println(a.length());
        System.out.println(split.length);

        byte[] bytes = a.getBytes(UTF_8);
        String ww = new String(bytes, UTF_8);
        System.out.println(ww);
        Long.valueOf("dd");
        Long.parseLong("dd");
    }

    private static class LongCache {
        private LongCache() {
        }

        static final Long cache[] = new Long[-(-128) + 127 + 1];

        static {
            for (int i = 0; i < cache.length; i++)
                cache[i] = new Long(i - 128);
        }
    }

    private static List<String> list = new ArrayList<>();

    static {
        list.add("33");
        list.add("44");
        list.add("44");
        list.add("55");
        list.add("6");
        list.add("7");
    }

    @Test
    public void test05() {
        //System.arraycopy();
        try {
            System.out.println();
            System.out.println("try is run");
            if (true) {
                throw new RuntimeException("try exception");
            }
        } catch (Exception e) {
            System.out.println("catch is run");
            if (true) {
                throw new RuntimeException("catch exception");
            }
            System.out.println(11);
        } finally {
            System.out.println("finally is run");
            throw new RuntimeException("finally exception");
        }
    }

    @Test
    public void test06() {
        System.out.println(list);

    }

    @Test
    public void test07() {
        //!map.isEmpty() && map.containsKey("remark") && StringUtils.isEmpty(map.get("remark").toString())
        list.forEach(s -> {
            if (s.equals("55")) {
                return;
            }
            System.out.println(s);
        });

        list.sort((o1, o2) -> {
            if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
                return -1;
            } else if (Integer.parseInt(o1) == Integer.parseInt(o2)) {
                return 0;
            } else {
                return 1;
            }
        });
        System.out.println(list);


    }

}
