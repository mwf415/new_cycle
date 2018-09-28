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
public class ExamResult implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Integer userId;

    private Integer solutionId;

    private Double solutionScore;

    private String wordUrl;

    private Double mins;

    private Double maxs;

    private Date startTime;

    private Date endTime;

    private String userAnswer;

    private String baseName;

    private String roomName;


}
