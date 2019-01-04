package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.CycleBase;
import cn.onlov.cycle.core.dao.interfaces.ICycleBaseService;
import cn.onlov.cycle.pojo.bo.CycleBaseBo;
import cn.onlov.cycle.pojo.bo.CycleRoomBo;
import cn.onlov.cycle.service.CycleBaseService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/bases")
public class BaseController {
    @Resource
    private CycleBaseService cycleBaseService;
    @Resource
    private ICycleBaseService iCycleBaseService;


    @RequestMapping
    public  Map<String,Object> getAll(CycleBase base, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length){

        Map<String,Object> map = new HashMap<>();

        CycleBaseBo bo  = new CycleBaseBo();
        BeanUtils.copyProperties(base,bo);
        bo.setCurr(start);
        bo.setPageSize(length);
        IPage<CycleBase> pageInfo = cycleBaseService.selectByPage(bo);
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getRecords());
        return map;
    }
    
    @RequestMapping("getAll")
    public  Map<String,Object> getAll(){
        Map<String,Object> map = new HashMap<>();
        boolean success = false;
        String msg = "获取数据失败！";
        Object data = null;
        
        List<CycleBase> list = null;
        try {
        	list = cycleBaseService.selectAll();
        	success = true;
        	data = list;
        	msg = "获取数据成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        map.put("success", success);
        map.put("data", data);
        map.put("msg", msg);
        return map;
    }
    
    @RequestMapping(value = "/add")
    public String add(CycleBase base) {
        try {
            iCycleBaseService.save(base);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        try{
            cycleBaseService.deleteByKey(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
    
    @RequestMapping(value = "/update")
    public String update(CycleBase base) {
        try {
            iCycleBaseService.saveOrUpdate(base);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * discription:根据基地查找专业
     * @param
     * @return
     */
    @RequestMapping(value = "/listArrturnRuleByBaseName")
    public Map<String, Object> listArrturnRuleByBaseName(String baseName) {
        Map<String,Object> map = new HashMap<>();
        boolean success = false;
        String msg = "获取数据失败！";
        Object data = null;
        
        try {
        	data = cycleBaseService.listArrturnRuleByCycleBaseName(baseName);
        	success = true;
        	msg = "获取数据成功";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        map.put("success", success);
        map.put("data", data);
        map.put("msg", msg);
        return map;
    }
    
}
