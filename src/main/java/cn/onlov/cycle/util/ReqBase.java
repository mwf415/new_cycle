package cn.onlov.cycle.util;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReqBase implements Serializable {
    private static final long serialVersionUID = 318399374157993931L;
    private Long userId;
    private Long baseId;
    private Long roomId;
    private int curr = 0;
    /**
     * 第几页
     */
    private int pageSize = 10;
    /**
     * 每页的数量
     */

}
