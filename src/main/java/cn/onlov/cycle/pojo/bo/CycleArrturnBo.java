package cn.onlov.cycle.pojo.bo;


import cn.onlov.cycle.core.dao.entities.CycleArrturn;
import lombok.Data;

import java.util.Date;

@Data
public class CycleArrturnBo extends CycleArrturn {
    private static final long serialVersionUID = 318399374157993931L;
    private int curr = 0; //当前页数
    private int pageSize = 10;// 每页几行

    private  Date searchStartTime ;
    private Date searchEndTime ;
}
