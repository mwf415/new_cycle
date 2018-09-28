package cn.onlov.cycle.util;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter @Setter
public class RspBase<T> implements Serializable {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;


}
