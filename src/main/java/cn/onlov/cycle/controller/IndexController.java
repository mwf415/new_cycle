package cn.onlov.cycle.controller;

import cn.onlov.cycle.core.dao.entities.CycleBase;
import cn.onlov.cycle.core.dao.entities.CycleRole;
import cn.onlov.cycle.core.dao.entities.CycleRoom;
import cn.onlov.cycle.core.dao.entities.User;
import cn.onlov.cycle.service.CycleBaseService;
import cn.onlov.cycle.service.CycleRoleService;
import cn.onlov.cycle.service.CycleRoomService;
import cn.onlov.cycle.service.CycleUserService;
import cn.onlov.cycle.util.MyStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yangqj on 2017/4/21.
 */
@Controller
public class IndexController {
	
	@Resource
	private CycleUserService cycleUserService;
	@Resource
	private CycleRoleService cycleRoleService;
	@Resource
	private CycleBaseService cycleBaseService;
    @Resource
    private CycleRoomService cycleRoomService;


    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, User user, Model model){
        if ( !MyStringUtils.isNotEmpty(user.getLoginName()) || !MyStringUtils.isNotEmpty(user.getUserPwd())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "/login";
        }
        User u = cycleUserService.selectByLoginName(user.getLoginName());
        if(u==null || u.getIdentityId()!=user.getIdentityId()){
            request.setAttribute("msg", "用户不存在！");
            return "/login";
        }
        UsernamePasswordToken token = null;
        try {
        	Subject subject = SecurityUtils.getSubject();
        	if(user.getUserPwd()!=null){
        		token=new UsernamePasswordToken(user.getLoginName(),user.getUserPwd());
        		subject.login(token);
        		if(user.getIdentityId()==2)//如果是学生，跳转到学生页面
        			return "redirect:/myExams/examsPage";
        		return "redirect:examsPage";
        	}
        }catch (LockedAccountException lae) {
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
        } catch (AuthenticationException e) {
            request.setAttribute("msg", "用户或密码不正确！");
        }
        
        if(token!=null){
        	token.clear();
        }
        return "login";
        
        
    }


    @RequestMapping(value="/usersPage")
    public String usersPage(Model model){
        List<CycleBase> bases = cycleBaseService.selectAll();
        List<CycleRoom> rooms = cycleRoomService.selectAll();
        model.addAttribute("bases",bases);
        model.addAttribute("rooms",rooms);

        return "user/users";
    }

    @RequestMapping("/rolesPage")
    public String rolesPage(){
        return "role/roles";
    }

    @RequestMapping("/permissionsPage")
    public String permissionsPage(){
        return "resources/resources";
    }
    
    @RequestMapping("/stationsPage")
    public String stationsPage(){
        return "station/stations";
    }
    @RequestMapping("/groupsPage")
    public String toolGroupPage(){
    	return "group/groups";
    }


    @RequestMapping("/applyPage")
    public String applyPage(){
        return "apply/applys";
    }

    @RequestMapping("/countPage")
    public String countPage(Model model){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        List<CycleRole> roles = cycleRoleService.queryCycleRoleListByUserId(userId);
        List<CycleBase> bases = cycleBaseService.selectAll();
        List<CycleRoom> rooms = cycleRoomService.selectAll();
        model.addAttribute("roles", roles);
        model.addAttribute("bases", bases);
        model.addAttribute("rooms", rooms);


        return "count/index";
    }


    /**
     * 动态监控页面
     * @return
     */
    @RequestMapping("/allMonitorPage")
    public String allMonitor(Model model){
        model= indexSession(model);
        model.addAttribute("topTitle","全院监控");
        return "/monitor/index";
    }

    @RequestMapping("/baseMonitorPage")
    public String baseMonitor(Model model){
        model= indexSession(model);
        model.addAttribute("topTitle","基地监控");
        return "/monitor/index";
    }

    @RequestMapping("/roomMonitorPage")
    public String roomMonitor(Model model){
        model.addAttribute("topTitle","科室监控");
        return "/monitor/index";
    }

    @RequestMapping("/stationMonitorPage")
    public String stationMonitor(Model model){
        model.addAttribute("topTitle","站点监控");
        return "/monitor/index";
    }



    /**
     * 安排考试
     * @param model
     * @return
     */
    @RequestMapping(value={"/examsPage",""})
    public String examsPage(Model model){
        model = indexSession(model);
        return "/exam/exams";
    }

    private Model indexSession(Model model) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userSessionId");
        List<CycleRole> roles = cycleRoleService.queryCycleRoleListByUserId(userId);
        List<CycleBase> bases = cycleBaseService.selectAll();
        List<CycleRoom> rooms = cycleRoomService.selectAll();
        model.addAttribute("roles", roles);
        model.addAttribute("bases", bases);
        model.addAttribute("rooms", rooms);
    return  model;
    }

    /**
     * 考试详情
     * @param model
     * @return
     */
    @RequestMapping(value={"/examsDetail"})
    public String examsDetail(Model model){
        indexSession(model);
        return "/exam/exams_detail";
    }
    @RequestMapping("/basesPage")
    public String baseStationItemsPage(Model model){
    	List<CycleBase> bases = cycleBaseService.selectAll();
    	model.addAttribute("bases", bases);;
        return "/base/bases";
    }

    @RequestMapping("/roomsPage")
    public String roomStationItemsPage(Model model){
        List<CycleRoom> rooms = cycleRoomService.selectAll();
        model.addAttribute("rooms", rooms);
        return "/room/rooms";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }
}
