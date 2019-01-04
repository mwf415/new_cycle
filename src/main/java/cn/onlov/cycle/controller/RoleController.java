package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.CycleRole;
import cn.onlov.cycle.core.dao.interfaces.ICycleRoleService;
import cn.onlov.cycle.pojo.bo.CycleBaseBo;
import cn.onlov.cycle.pojo.bo.CycleRoleBo;
import cn.onlov.cycle.service.CycleRolePermissionService;
import cn.onlov.cycle.service.CycleRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/26.
 */
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Resource
    private CycleRoleService cycleRoleService;
    @Resource
    private CycleRolePermissionService cycleRolePermissionService;


    @Autowired
    private ICycleRoleService iCycleRoleService;

    @RequestMapping
    public  Map<String,Object> getAll(CycleRole role, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length){

        Map<String,Object> map = new HashMap<>();

        CycleRoleBo bo  = new CycleRoleBo();
        BeanUtils.copyProperties(role,bo);
        bo.setCurr(start);
        bo.setPageSize(length);

        IPage<CycleRole> pageInfo = cycleRoleService.selectByPage(bo);
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getRecords());
        return map;
    }

    @RequestMapping("/rolesWithSelected")
    public List<CycleRole> rolesWithSelected(Integer uid){
        return cycleRoleService.queryCycleRoleListWithSelected(uid);
    }

    //分配角色
    @RequestMapping("/saveRolePermissions")
    public String saveRolePermission(Integer rid, Integer[] pids){
        if(StringUtils.isEmpty(rid))
            return "error";
        try {
            cycleRolePermissionService.addRolePermission(rid, pids);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(CycleRole role) {
        try {
            iCycleRoleService.saveOrUpdate(role);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        try{
            iCycleRoleService.removeById(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }



}
