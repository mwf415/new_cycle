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
public class CycleActivesQuest implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 课程问题的ID
     */
         @TableId(value = "cycle_acitves_quest_id", type = IdType.AUTO)
    private Long cycleAcitvesQuestId;

        /**
     * 活动ID
     */
         private Long cycleActivesId;

        /**
     * 问题内容，用cheditor做的
     */
         private String questTxt;

        /**
     * 描述
     */
         private String des;


}
