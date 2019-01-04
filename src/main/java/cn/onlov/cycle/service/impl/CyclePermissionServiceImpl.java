package cn.onlov.cycle.service.impl;

import cn.onlov.cycle.constants.Constants;
import cn.onlov.cycle.core.dao.entities.CyclePermission;
import cn.onlov.cycle.core.dao.entities.CycleRole;
import cn.onlov.cycle.core.dao.entities.CycleRolePermission;
import cn.onlov.cycle.core.dao.entities.User;
import cn.onlov.cycle.core.dao.interfaces.ICyclePermissionService;
import cn.onlov.cycle.core.dao.interfaces.ICycleRolePermissionService;
import cn.onlov.cycle.core.dao.interfaces.ICycleRoleService;
import cn.onlov.cycle.core.dao.mapper.CyclePermissionMapper;
import cn.onlov.cycle.pojo.bo.CyclePermissionBo;
import cn.onlov.cycle.service.CyclePermissionService;
import cn.onlov.cycle.util.MyStringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.annotation.Resource;
import java.util.*;

@Service
@Transactional
public class CyclePermissionServiceImpl  implements CyclePermissionService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());  
    @Resource
    private ICyclePermissionService iCyclePermissionService;
    @Resource
    private ICycleRoleService iCycleRoleService;
    @Autowired
    private ICycleRolePermissionService iCycleRolePermissionService;


    @Override
    public IPage<CyclePermission> selectByPage(CyclePermissionBo bo) {
        IPage<CyclePermission> page = new Page<>();
        page.setCurrent(bo.getCurr()).setSize(bo.getPageSize());

        IPage<CyclePermission> res = iCyclePermissionService.page(page, new QueryWrapper<CyclePermission>().lambda().orderByDesc(CyclePermission::getId));
        return res;

    }
    @Override
    @Cacheable(value="CyclePermissions", key="'all'")
    public List<CyclePermission> queryAll(){
       QueryWrapper<CyclePermission> queryWrapper =  new QueryWrapper<>() ;

        List<CyclePermission> list = iCyclePermissionService.list(queryWrapper);
        return list;
    }

	@Override
	@Cacheable(value="permissions", key="'all_menu'")
	public List<CyclePermission> queryAllMenu() {
        QueryWrapper<CyclePermission> queryWrapper =  new QueryWrapper<>() ;
        queryWrapper.lambda().eq(CyclePermission::getSystemId,Constants.SYSTEM_CYCLE_ID).eq(CyclePermission::getType,Constants.MENU_TYPE).orderByDesc(CyclePermission::getId);
		List<CyclePermission> list = iCyclePermissionService.list(queryWrapper);
		return list;
	}
	
    @Override
    @Cacheable(value="permissions",key="'list_'+#map['id'].toString()+'_'+#map['type']")
    public List<CyclePermission> loadUserCyclePermissions(Map<String, Object> map){
    	logger.debug("loadUserPermissions id={},type={}" , new Object[]{map.get("id"),map.get("type")});
        int id = (int) map.get("id");
        int type = (int) map.get("type");
        QueryWrapper<CyclePermission> queryWrapper =  new QueryWrapper<>() ;
        List<CyclePermission> list = iCyclePermissionService.loadUserPermissions(id, type);
        return list;
    }

    @Override
    public List<CyclePermission> queryCyclePermissionsListWithSelected(Integer rid) {
        List<CyclePermission> list = iCyclePermissionService.queryPermissionsListWithSelected( rid);
        return list;
    }

	@Override
	@Cacheable(value="permissions",key="'tree_'+#userId")
	public List<CyclePermission> loadUserCyclePermissionsTree(Integer userId) {
        return getPermissions(userId);
	}

    @Override
    @CachePut(value="permissions",key="'tree_'+#userId")
    public List<CyclePermission> updateUserCyclePermissionsTree(Integer userId) {
        return getPermissions(userId);
    }

    private List<CyclePermission> getPermissions(Integer userId) {
        logger.debug("loadUserPermissionsTree userId={}" , userId);
        Map<String,Object> map = new HashMap();
        map.put("type",1);
        map.put("id",userId);
        List<CyclePermission> userPermissions = null;
        if(userId==1){
            userPermissions = queryAllMenu();
        }else{
            userPermissions = loadUserCyclePermissions(map);
        }
        List<CyclePermission> list = getChildren(userPermissions, 0);
        return list;
    }



    // 取节点的所有children  
    private List<CyclePermission> getChildren(List<CyclePermission> results, Integer rootId) {  
  
        List<CyclePermission> list = new ArrayList();
        for (int i = 0; i < results.size(); i++) {
            CyclePermission root = results.get(i);
            if (rootId == root.getPid()) {  
                List<CyclePermission> children = getChildren(results,  root.getId());  
                if (!children.isEmpty()) {  
                    root.setChildren(children);  
                }  
                list.add(root);  
            }  
        }  
        return list;  
    }

	@Override
	public void deleteByKeys(String[] keys) {
		//删除资源
		if(keys!=null){
			//删除关联数据
            QueryWrapper<CyclePermission> queryWrapper =  new QueryWrapper<>() ;
            iCyclePermissionService.remove(queryWrapper.lambda().in(CyclePermission::getId,keys));


            QueryWrapper<CycleRolePermission> queryWrapperRole =  new QueryWrapper<>() ;
            iCycleRolePermissionService.remove(queryWrapperRole.lambda().in(CycleRolePermission::getPid,keys));

		}
	}



}
