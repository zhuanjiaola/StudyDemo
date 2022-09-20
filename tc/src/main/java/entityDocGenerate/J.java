package entityDocGenerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 1205869
 * @version Id: J, v 0.1 2022/9/9 4:09 PM 1205869 Exp $
 */
public class J {

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("train.java.dsf.sgorder", "  dsf.train.backend\n" +
                "31733\n" +
                "  USER(train.avatarcallback)\n" +
                "17924\n" +
                "  train.java.dsf.smartshelfresource\n" +
                "14313\n" +
                "  train.java.dsf.multiple\n" +
                "13978\n" +
                "  USER(train.callbackevent)\n" +
                "8154\n" +
                "  train.avatarcallback\n" +
                "1975\n" +
                "  dsf.train.tiger.kyfw\n" +
                "1420\n" +
                "  USER(gny.openapi.dto)\n" +
                "735\n" +
                "  train.java.dsf.distribution\n" +
                "575\n" +
                "  train.jobsystem\n" +
                "233\n" +
                "  train.java.dsf.smartshelforder\n" +
                "231\n" +
                " unKnown\n" +
                "224\n" +
                "  train.java.job.platform\n" +
                "70\n" +
                "  gny.openapi.dto");
        map.put("train.java.dsf.ordercore", "  train.java.dsf.tc.tw.jebi\n" +
                "20009\n" +
                "  train.unionapi\n" +
                "1878\n" +
                "  train.net.trainwxgrab\n" +
                "407\n" +
                "  USER(train.unionapi)\n" +
                "174\n" +
                "  train.net.trainwebapiapp\n" +
                "114\n" +
                "  train.java.internationalapi\n" +
                "90\n" +
                "  train.net.trainwebapibaidu\n" +
                "53\n" +
                "  USER(train.net.trainwebapielong)\n" +
                "33\n" +
                "  USER(train.net.touchwebapi)\n" +
                "16\n" +
                "  train.unionapi.pc");
        extracted(map);


    }

    private static void extracted(Map<String, String> map) {
        for (String s : map.keySet()) {
            System.out.println(s);
            for (String s1 : getSet(map.get(s))) {
                System.out.println(s1);
            }
            System.out.println();
        }
    }


    private static Set<String> getSet(String s) {
        String[] split = s.split("\n");

        List<String> list = new ArrayList<>(Arrays.asList(split));


        Iterator<String> iterator = list.iterator();


        while (iterator.hasNext()) {
            String s1 = iterator.next();
            if (isNumeric2(s1.trim())) {
                iterator.remove();
            }
            if ("unknown".equalsIgnoreCase(s1.trim())) {
                iterator.remove();
            }
            if ("user".equalsIgnoreCase(s1.trim())) {
                iterator.remove();
            }
        }


        Set<String> set = new LinkedHashSet<>();


        for (String s1 : list) {
            s1 = s1.trim();
            if (s1.startsWith("USER")) {
                s1 = s1.substring(5, s1.length() - 1);
            }
            set.add(s1);
        }
        return set;
    }


    public static boolean isNumeric2(String str) {
        return str != null && str.matches("-?\\d+(\\.\\d+)?");
    }

}
