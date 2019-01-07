package cn.onlov.cycle.service;

import cn.onlov.cycle.core.dao.entities.CyclePermission;
import cn.onlov.cycle.core.dao.entities.User;
import cn.onlov.cycle.pojo.bo.CyclePermissionBo;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/25.
 */
public interface CyclePermissionService  {
	IPage<CyclePermission> selectByPage(CyclePermissionBo CyclePermission);
	List<CyclePermission> queryAll();
	List<CyclePermission> queryAllMenu();
	List<CyclePermission> loadUserCyclePermissions(Map<String, Object> map);
	List<CyclePermission> queryCyclePermissionsListWithSelected(Integer rid);
	List<CyclePermission> loadUserCyclePermissionsTree(Integer userId);
	List<CyclePermission> updateUserCyclePermissionsTree(Integer userId);
	void deleteByKeys(String[] keys);
}
