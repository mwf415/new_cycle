package cn.onlov.cycle.pojo.bo;

import cn.onlov.cycle.core.dao.entities.CycleArrturnRule;
import lombok.Data;

@Data
public class CycleArrturnRuleBo extends CycleArrturnRule {
    private static final long serialVersionUID = 318399374157993931L;
    private int curr = 0; //当前页数
    private int pageSize = 10;// 每页几行

}
