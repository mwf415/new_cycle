package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

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
public class CycleArrturn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "arrturn_id", type = IdType.AUTO)
    private Long arrturnId;

    private String userNum;

    private String userId;

    /**
     * 姓名
     */
    private String realName;

    /**
     * 开始时间
     */
    private Date startTime;

    private Date endTime;

    /**
     * 科室名称
     */
    private String roomName;

    private String teacherNum1;

    /**
     * 带教老师
     */
    private String teacherName1;

    private String teacherNum2;

    /**
     * 有可能两个带教老师，这个备用
     */
    private String teacherName2;

    /**
     * 级别
     */
    private String grade;

    private String baseName;

    /**
     * 审核
     */
    private String checkStatus;

    /**
     * 主要用来区分本科室和研究生的
     */
    private String trainTime;

    /**
     * 批次
     */
    private String batch;


}
