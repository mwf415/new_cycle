package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2018-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CycleSelfsumup implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer activesId;

    private String zdjb;

    private String yyjxcf;

    private String ghjxcf;

    private String yybltl;

    private String nlfx;

    private String wqbz;

    private String knjz;

    private String ckksnr;

    private String jx;

    @TableField("t2sId")
    private Integer t2sId;

    private String ext01;

    @TableField("createTime")
    private Date createTime;

    @TableField("loginName")
    private String loginName;


}
