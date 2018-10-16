package cn.onlov.cycle.util;

import lombok.Data;

import java.util.List;

@Data
public class RspPage<T> extends  RspBase {
    private T  data;
    /** 记录总数 */
    private int              total;

    /** 总页数 */
    private int             totalPage  ;

    /** 当前页 */
    private int          current;

    /**
     * 返回编码
     */
    private String respCode;

    /**
     * 返回编码
     */
    private String respDesc;
}
