package cn.onlov.cycle.util;

import lombok.Data;

import java.util.List;

@Data
public class RspPage<T> extends  RspBase {
    private List<T>  data;

}
