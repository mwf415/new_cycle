package cn.onlov.cycle.util;

import java.lang.reflect.InvocationTargetException;

public class RspUtil {

    public static void errMessage(Object obj,String desc){
        try {
            obj.getClass().getMethod("setCode",String.class).invoke(obj,Constant.errorCode);
            obj.getClass().getMethod("setMsg",String.class).invoke(obj,desc);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void successMessage(Object obj){
        successMessage(obj,"成功");
    }

    public static void successMessage(Object obj,String desc){
        try {
            obj.getClass().getMethod("setCode",String.class).invoke(obj,Constant.successCode);
            obj.getClass().getMethod("setMsg",String.class).invoke(obj,desc);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
