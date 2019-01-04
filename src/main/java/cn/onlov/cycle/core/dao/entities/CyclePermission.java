package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Transient;

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
public class CyclePermission implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 主键
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * url描述
     */
         private String name;

        /**
     * url地址
     */
         private String url;

    private Integer pid;

    private Integer type;

    @Column(name = "system_id")
    private Integer systemId;

    private Integer sort;

    @Transient
    private String checked;//是否选中

    @Transient
    private List children;//子菜单


}
