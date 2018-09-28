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
public class BookRoom implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 预定的id
     */
         @TableId(value = "book_room_id", type = IdType.ID_WORKER)
    private Long bookRoomId;

        /**
     * 预定的房间Id
     */
         private Long classRoomId;

        /**
     * 预定房间名称
     */
         private String roomName;

        /**
     * 预定开始时间
     */
         private Date startTime;

        /**
     * 预定结束时间
     */
         private Date endTime;

    private Long activityId;

    private String activityName;

    private String createName;

    private Long createId;


}
