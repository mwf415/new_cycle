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
public class BusinessUser implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 用户Id
     */
         @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

        /**
     * 用户编号
     */
         private String userNum;

        /**
     * 登录名
     */
         private String loginName;

        /**
     * 真实姓名
     */
         private String realName;

        /**
     * 密码
     */
         private String userPwd;

        /**
     * 1：老师 2：学生 3：助理老师
     */
         private Integer identityId;

        /**
     * 性别
     */
         private String sex;

    private String dept;

    private String cardNo;

    private Date birthTime;

    private Integer education;

    private String image;

    private Integer isLogin;

    private String loginIp;

        /**
     * 0 是注册，1 是正常
     */
         private Integer status;

    private String baseName;

    private String roomName;

    private String address;

    private String gradSchool;

    private String major;

    private String degree;

    private String xuewei;

        /**
     * 证书编号
     */
         private String certificationNum;

    @TableField("cellPhone")
    private String cellPhone;

    private String staff;

    @TableField("trainTime")
    private Integer trainTime;

    private String email;

        /**
     * 年级，2017 2018 2019 
     */
         private Integer grade;

        /**
     * 是否已经安排轮转
     */
         @TableField("isAt")
    private Integer isAt;


}
