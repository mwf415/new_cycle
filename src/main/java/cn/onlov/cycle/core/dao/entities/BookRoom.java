package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
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
public class BookRoom implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER)
    private Integer id;

    @TableField("classRoomId")
    private Integer classRoomId;

    @TableField("roomName")
    private String roomName;

    @TableField("startTime")
    private Date startTime;

    @TableField("endTime")
    private Date endTime;

    @TableField("activityId")
    private Integer activityId;

    @TableField("activityName")
    private String activityName;

    @TableField("bookPeople")
    private String bookPeople;


}
