package cn.onlov.cycle.core.dao.entities;

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
public class CycleScore implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 分数Id
     */
         @TableId(value = "score_id", type = IdType.AUTO)
    private Integer scoreId;

        /**
     * 模板Id
     */
         private Integer modelId;

        /**
     * 评分人Id
     */
         private Integer ratersId;

        /**
     * 被评分人Id
     */
         private String targetId;

        /**
     * 分数详情
     */
         private String scoreDetail;

        /**
     * 总分数
     */
         private Double totalScore;

        /**
     * 所属科室Id
     */
         private Integer roomId;

        /**
     * 所属基地Id
     */
         private Integer baseId;

        /**
     * 备注
     */
         private String remark;


}
