package cn.onlov.cycle.util;

public class MyStringUtils  {

    public static boolean isNotEmpty(String cs) {
        boolean result = false;
        if(null!=cs && cs.trim().length()>0){
            result=true ;
        }
        return result ;

    }

    public static boolean isNotEmpty(Integer num) {
        boolean result = false;
        if(null !=num && 0!=num){
            result= true;
        }
        return result ;
    }

    public static boolean isNotEmpty(Long num) {
        boolean result =false;
        if(null !=num && 0L !=num){
            result= true;
        }
        return result ;
    }




}
