package cn.onlov.cycle.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
public class RspBase<T> implements Serializable {
    private static final long serialVersionUID = -9139965062655369886L;

    /** 返回编码 */
    private String  code;
    /** 返回描述 */
    private String  msg;
    private Integer count;


}
