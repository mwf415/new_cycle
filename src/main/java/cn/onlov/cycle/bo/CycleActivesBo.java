package cn.onlov.cycle.bo;

import cn.onlov.cycle.dao.entities.CycleActives;

public class CycleActivesBo extends CycleActives {
    private static final long serialVersionUID = 318399374157993931L;
    private int curr = 0; //当前页数
    private int pageSize = 10;// 每页几行
}
