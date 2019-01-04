package cn.onlov.cycle.core.dao.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
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
 * @since 2019-01-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CycleCex implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("kgName")
    private String kgName;

    @TableField("kgNum")
    private String kgNum;

    @TableField("gradeDate")
    private Date gradeDate;

    @TableField("gradeTime")
    private String gradeTime;

    @TableField("ksName")
    private String ksName;

    @TableField("ksNum")
    private String ksNum;

        /**
     * 考生身份
     */
         @TableField("ksIdentity")
    private String ksIdentity;

        /**
     * 考核地点
     */
         private String khaddress;

        /**
     * 考核目的
     */
         private String khmudi;

        /**
     * 病历号
     */
         private String blh;

        /**
     * 病人年龄
     */
         private String bage;

        /**
     * 病人性别
     */
         private String bsex;

        /**
     * 病房号
     */
         private String bfh;

        /**
     * 病床号
     */
         private String bch;

    @TableField("isFirst")
    private String isFirst;

    @TableField("complexDegree")
    private String complexDegree;

    private String coordination;

    private String internship;

    private String mtjq;

    private String f1;

    private String tgjc;

    private String f2;

    private String zysy;

    private String f3;

    private String lcpd;

    private String f4;

    private String zxjy;

    private String f5;

    private String zznl;

    private String f6;

    private String ztlc;

    private String f7;

    private String kgmy;

    private String ksmy;

    private String k1;

    private String k2;

    private String wcjh;

    private String fkyd;

    private String kygj;

    private String bzbf;

    private String ztyx;

    @TableField("gcTime")
    private String gcTime;

    @TableField("hkTime")
    private String hkTime;

    private String score;


}
