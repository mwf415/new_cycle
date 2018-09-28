package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class CycleArrturnRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "arrturn_rule_id", type = IdType.AUTO)
    private Integer arrturnRuleId;

    private String baseName;

        /**
     * 学历
     */
         private String education;

        /**
     * 科室
     */
         private String roomName;

        /**
     * 周期（单位：月）
     */
         private String period;

        /**
     * 轮转年限类型,存放2  或者3  代表2年或者3年轮转期
     */
         private Integer type;

        /**
     * 排序
     */
         private Integer roomSort;


}
