package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class CycleQuest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "questId", type = IdType.AUTO)
    private Integer questId;

    @TableField("paramNum")
    private String paramNum;

        /**
     * 问题内容，用cheditor做的
     */
         @TableField("questTxt")
    private String questTxt;

    private String des;

    private String usernum;

    @TableField("userName")
    private String userName;

    @TableField("teacherNum")
    private String teacherNum;

    @TableField("teacherName")
    private String teacherName;

        /**
     *  0 老师，1 学生   用来判断是否是老师发布的问题，还是学生回答的问题
     */
         private String org;


}
