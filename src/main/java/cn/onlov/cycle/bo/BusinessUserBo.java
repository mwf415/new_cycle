package cn.onlov.cycle.bo;

import cn.onlov.cycle.dao.entities.BusinessUser;
import lombok.Data;

import java.io.Serializable;

@Data
public class BusinessUserBo extends BusinessUser  implements Serializable {

    private static final long serialVersionUID = 318399374157993931L;
    private int curr = 0; //当前页数
    private int pageSize = 10;// 每页几行

}
