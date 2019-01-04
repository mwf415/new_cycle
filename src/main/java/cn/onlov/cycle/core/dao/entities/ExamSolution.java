package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExamSolution implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer examTotal;

    private Integer examPass;

    private Integer examDuration;

    private Integer examNum;

    private Date examBuildTime;

    private Integer examClass;

    private String examKnowledge;

    private Integer isTop;

    private Integer sumScore;

    private Integer isAuto;

    private Integer examType;

    private Integer isSave;

    private Integer userId;

    private Integer ipValidate;

    private Integer isSingle;

    private Integer isPost;

    private Integer testClass;

    private String qualificationId;

    private String departmentId;

    private Integer ageLimit;

    private Date startTime;

    private Date endTime;

    private Integer useHourModel;

    private Integer isReset;

    private String solutionPath;

    private String solutionAnswer;

    private Integer needUpdateAnswer;


}
