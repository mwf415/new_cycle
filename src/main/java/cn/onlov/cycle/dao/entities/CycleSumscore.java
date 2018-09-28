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
public class CycleSumscore implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("activesId")
    private Integer activesId;

    @TableField("userNum")
    private String userNum;

    @TableField("userName")
    private String userName;

    @TableField("teacherName")
    private String teacherName;

    @TableField("teacherNum")
    private String teacherNum;

    @TableField("createName")
    private String createName;

    @TableField("createNum")
    private String createNum;

    @TableField("absenceMount")
    private String absenceMount;

    @TableField("onDetyMount")
    private String onDetyMount;

    @TableField("sickMount")
    private String sickMount;

    @TableField("mngMount")
    private String mngMount;

    @TableField("writeQuality")
    private String writeQuality;

    @TableField("operateMount")
    private String operateMount;

    private String thinking;

    private String virtues;

    @TableField("teachAbility")
    private String teachAbility;

    @TableField("learnAmount")
    private String learnAmount;

    private String science;

    private String mistake;

    private String miniCex;

    @TableField("theoryExam")
    private String theoryExam;

    @TableField("practiceExam")
    private String practiceExam;

    private String soap;

    @TableField("nurseDes")
    private String nurseDes;

    @TableField("sickDes")
    private String sickDes;

    @TableField("createTime")
    private Date createTime;

    @TableField("roomName")
    private String roomName;

    private String theoryscore;

    @TableField("uploadFileCount")
    private Integer uploadFileCount;


}
