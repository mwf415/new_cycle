package cn.onlov.cycle.util;

import cn.onlov.cycle.dao.entities.BusinessUser;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class RspUtil {

    public static void errMessage(Object obj, String desc){
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

    public static void successMessage(Object obj, String desc   ){
        try {
            obj.getClass().getMethod("setCode",String.class).invoke(obj,Constant.successCode);
            obj.getClass().getMethod("setMsg",String.class).invoke(obj,desc);

            RspPage rspPage = (RspPage) obj;
            Object data = rspPage.getData();
            if(data instanceof IPage){
                long total = ((IPage) data).getTotal();
                obj.getClass().getMethod("setTotal",long.class).invoke(obj,total);// 总个数
                long current = ((IPage) data).getCurrent();
                obj.getClass().getMethod("setCurrent",long.class).invoke(obj,current); // 当前页数
                long size = ((IPage) data).getSize();
                Long tatalPage = total / size+1;
                obj.getClass().getMethod("setCurrent",long.class).invoke(obj,tatalPage); // 总页数

            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
