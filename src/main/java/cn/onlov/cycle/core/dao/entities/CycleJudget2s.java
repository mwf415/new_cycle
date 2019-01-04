package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cycle_judget2s")
public class CycleJudget2s implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("activesId")
    private Integer activesId;

    @TableField("selfStatus")
    private Integer selfStatus;

    @TableField("isOver")
    private Integer isOver;

    @TableField("roomName")
    private String roomName;

    @TableField("baseName")
    private String baseName;

    @TableField("teacherNum")
    private String teacherNum;

    @TableField("teacherName")
    private String teacherName;

    @TableField("userName")
    private String userName;

    @TableField("loginName")
    private String loginName;

    @TableField("createTime")
    private Date createTime;

    private String ylws;

    private String zlnl;

    private String zdce;

    private String brpj;

    private String hspj;

    private String fxyj;

    private String bzs;

    private String cfrz;

    private String ylcz;

    private String cjtl;

    private String gtxz;

    private String zbjb;

    private String llkh;

    private String dlglbrsl;

    private String cyglbrsl;

    private String zbcs;

    private String cqjl;


}
