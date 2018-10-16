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
                IPage iPage =(IPage) obj;
                obj.getClass().getMethod("setTotal",Integer.class).invoke(obj,iPage.getTotal());// 总个数

                obj.getClass().getMethod("setCurrent",Integer.class).invoke(obj,iPage.getCurrent()); // 当前页数
                Long tatalPage = (iPage.getTotal() / iPage.getSize())+1;
                obj.getClass().getMethod("setCurrent",Integer.class).invoke(obj,iPage.getCurrent()); // 总页数

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
