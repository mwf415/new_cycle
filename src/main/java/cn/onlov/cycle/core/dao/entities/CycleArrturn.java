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
public class CycleArrturn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "arrTurnId", type = IdType.AUTO)
    private Integer arrTurnId;

    @TableField("hospitalId")
    private String hospitalId;

    @TableField("loginName")
    private String loginName;

        /**
     * 姓名
     */
         @TableField("realName")
    private String realName;

        /**
     * 开始时间
     */
         @TableField("startTime")
    private Date startTime;

    @TableField("endTime")
    private Date endTime;

        /**
     * 科室名称
     */
         @TableField("roomName")
    private String roomName;

    @TableField("teacherNum1")
    private String teacherNum1;

        /**
     * 带教老师
     */
         @TableField("teacherName1")
    private String teacherName1;

    @TableField("teacherNum2")
    private String teacherNum2;

        /**
     * 有可能两个带教老师，这个备用
     */
         @TableField("teacherName2")
    private String teacherName2;

        /**
     * 级别
     */
         private String grade;

    private String basename;

    @TableField("checkStatus")
    private String checkStatus;

        /**
     * 主要用来区分本科室和研究生的
     */
         @TableField("trainTime")
    private String trainTime;

        /**
     * 批次
     */
         private String batch;


}
