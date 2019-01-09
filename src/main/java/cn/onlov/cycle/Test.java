package cn.onlov.cycle;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<String ,String > map  = new HashMap<>();
        map.put("1","aaaaaaaaa");
        String s = map.get("1");
        s = "bbbb";
        String s1 = map.get("1");
        System.out.println(s1);


        map.put("1",s1);
        s1 = map.get("1");
        System.out.println(s1);


    }


}
