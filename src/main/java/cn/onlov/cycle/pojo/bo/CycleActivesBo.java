package cn.onlov.cycle.pojo.bo;

import cn.onlov.cycle.core.dao.entities.CycleActives;
import lombok.Data;

import java.util.Date;

@Data
public class CycleActivesBo extends CycleActives {
    private static final long serialVersionUID = 318399374157993931L;
    private int curr = 0; //当前页数
    private int pageSize = 10;// 每页几行

    private int isIn;// 学生查询自己已参加和未参加的活动
    private Date searchStartTime ; //查询条件开始时间
    private Date searchEndTime ;  // 查询添加结束时间

}
