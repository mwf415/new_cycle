package cn.onlov.cycle.core.dao.entities;

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
public class CycleActives implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 查房安排Id
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 创建时间
     */
         @TableField("createTime")
    private Date createTime;

        /**
     * 查房开始时间
     */
         @TableField("startTime")
    private Date startTime;

    @TableField("endTime")
    private Date endTime;

    @TableField("baseName")
    private String baseName;

        /**
     * 承担科室
     */
         @TableField("roomName")
    private String roomName;

        /**
     * 病人姓名
     */
         @TableField("sickPerson")
    private String sickPerson;

    @TableField("sickNum")
    private String sickNum;

    private String title;

        /**
     * 定义几个状态，4:入科教育 6 教学查房，7病例讨论， 8 讲座，9 操作训练,5出科考试
     */
         private Integer status;

    @TableField("takeTime")
    private Integer takeTime;

    private String address;

        /**
     * 是否完成
     */
         @TableField("isOver")
    private String isOver;

        /**
     * 来源  1 院级，2  基地，3 科室
     */
         private String org;

    private String text;

    private String creater;

    private String des;

    private String ext01;

    private String ext02;

    @TableField("fileNum")
    private Integer fileNum;


}
