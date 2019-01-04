package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("cycle_score_model")
public class CycleScoreModel implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 评分模板Id
     */
         @TableId(value = "model_id", type = IdType.AUTO)
    private Integer modelId;

        /**
     * 构建人Id
     */
         private Integer userId;

        /**
     * 模板名称
     */
         private String modelName;

        /**
     * 评分项
     */
         private String scoreItem;

        /**
     * 备注
     */
         private String remark;


}
