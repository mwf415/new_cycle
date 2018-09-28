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
public class CycleActives implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 查房安排Id
     */
         @TableId(value = "cycle_active_id", type = IdType.AUTO)
    private Integer cycleActiveId;

        /**
     * 创建时间
     */
         private Date createTime;

        /**
     * 查房开始时间
     */
         private Date startTime;

    private Date endTime;

    private String baseName;

        /**
     * 承担科室
     */
         private String roomName;

        /**
     * 病人姓名
     */
         private String sickPerson;

    private String sickNum;

    private String title;

        /**
     * 定义几个状态，4:入科教育 6 教学查房，7病例讨论， 8 讲座，9 操作训练,5出科考试
     */
         private Integer status;

    private Integer takeTime;

    private String address;

        /**
     * 是否完成
     */
         private String isOver;

        /**
     * 来源  1 院级，2  基地，3 科室
     */
         private String org;

    private String text;

    private Long createUserId;

        /**
     * 创建人
     */
         private String createName;

    private String des;

    private String ext01;

    private String ext02;

    private Integer fileNum;


}
