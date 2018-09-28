package cn.onlov.cycle.util;

import lombok.Data;

import java.util.List;

@Data
public class RspPage<T> extends  RspBase {
    private T  data;
    /** 记录总数 */
    private int               recordsTotal;

    /** 总页数 */
    private int               total;

    /** 当前页 */
    private int               pageNo;
}
