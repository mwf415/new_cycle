package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.core.dao.entities.CyclePermission;
import cn.onlov.cycle.core.dao.entities.CycleRolePermission;
import cn.onlov.cycle.core.dao.interfaces.ICycleRolePermissionService;
import cn.onlov.cycle.service.CycleRolePermissionService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@Transactional
public class RolePermissionServiceImpl  implements CycleRolePermissionService {
   @Autowired
   private ICycleRolePermissionService iCycleRolePermissionService;


	@Override
    //更新权限
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    @CacheEvict(cacheNames="permissions", allEntries=true)
    public void addRolePermission(Integer rid, Integer[] pids){

		QueryWrapper<CycleRolePermission> queryWrapper =  new QueryWrapper<>() ;
		iCycleRolePermissionService.remove(queryWrapper.lambda().eq(CycleRolePermission::getRid,rid));
        //添加
        for(Integer pid: pids){
			CycleRolePermission record = new CycleRolePermission();
        	record.setRid(rid);
        	record.setPid(pid);
        	iCycleRolePermissionService.save(record);
        }
	}

	@Override
	public void deleteByPermissionKeys(String[] ids) {
		QueryWrapper<CycleRolePermission> queryWrapper =  new QueryWrapper<>() ;
		iCycleRolePermissionService.remove(queryWrapper.lambda().in(CycleRolePermission::getPid,ids));
	}
}
