package cn.onlov.cycle.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

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
 * @since 2018-09-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CycleMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "messageId", type = IdType.AUTO)
    private Integer messageId;

    @TableField("messageTitle")
    private String messageTitle;

        /**
     * 接收者
     */
         private String receiver;

    @TableField("messageTxt")
    private String messageTxt;

    @TableField("createTime")
    private Date createTime;

    private String sender;

    @TableField("senderName")
    private String senderName;


}
