package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kaifa
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Pbcattbl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pbt_tid", type = IdType.ID_WORKER)
    private Integer pbtTid;

    private String pbtTnam;

    private String pbtOwnr;

    private Integer pbdFhgt;

    private Integer pbdFwgt;

    private String pbdFitl;

    private String pbdFunl;

    private Integer pbdFchr;

    private Integer pbdFptc;

    private String pbdFfce;

    private Integer pbhFhgt;

    private Integer pbhFwgt;

    private String pbhFitl;

    private String pbhFunl;

    private Integer pbhFchr;

    private Integer pbhFptc;

    private String pbhFfce;

    private Integer pblFhgt;

    private Integer pblFwgt;

    private String pblFitl;

    private String pblFunl;

    private Integer pblFchr;

    private Integer pblFptc;

    private String pblFfce;

    private String pbtCmnt;


}
