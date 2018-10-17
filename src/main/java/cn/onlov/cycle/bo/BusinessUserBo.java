package cn.onlov.cycle.bo;

import cn.onlov.cycle.util.ReqBase;
import lombok.Data;

@Data
public class BusinessUserBo extends ReqBase  {
    private String realName;
    private Integer grade;
    private Integer status;


}
