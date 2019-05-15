package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Map;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.Task;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.ITaskService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.service.IActivityService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实践活动 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
@Controller
@RequestMapping("/system/activity")
public class ActivityController extends BaseController
{
    private String prefix = "system/activity";
	
	@Autowired
	private IActivityService activityService;
	@Autowired
	private ISysUserService iSysUserService;

	/**
	 * 导入  修改
	 */
	@Autowired
	private IActivityService activityServiceService;
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
	{
		ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
		List<Activity> userList = util.importExcel(file.getInputStream());
		String operName = ShiroUtils.getSysUser().getLoginName();
		String message = activityServiceService.importActivity(userList, updateSupport, operName);
		return AjaxResult.success(message);
	}
	/**
	 * 导入  修改
	 */
	//@RequiresPermissions("system:activity:view")//
	@GetMapping()
	public String activity(Map mmap)
	{
		SysUser user = (SysUser)iSysUserService.getUser();
		String roleNames = "";
		List<SysRole> roles = user.getRoles();
		for (SysRole role : roles) {
			roleNames += role.getRoleName() +",";
		}
		mmap.put("roleNames",roleNames);
	    return prefix + "/activity";
	}
	
	/**
	 * 查询实践活动列表
	 */
	//@RequiresPermissions("system:activity:list")//
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Activity activity)
	{
		startPage();
        List<Activity> list = activityService.selectActivityList(activity);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出实践活动列表
	 */
	//@RequiresPermissions("system:activity:export")//
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Activity activity)
    {
    	List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        return util.exportExcel(list, "activity");
    }
	
	/**
	 * 新增实践活动
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存实践活动
	 */
	//@RequiresPermissions("system:activity:add")//
	@Log(title = "实践活动", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Activity activity)
	{		
		return toAjax(activityService.insertActivity(activity));
	}

	/**
	 * 修改实践活动
	 */
	@GetMapping("/edit/{activityId}")
	public String edit(@PathVariable("activityId") Long activityId, ModelMap mmap)
	{	String roleNames = "";
		Activity activity = activityService.selectActivityById(activityId);
		mmap.put("activity", activity);

		SysUser user = (SysUser)iSysUserService.getUser();
		List<SysRole> roles = user.getRoles();
		for (SysRole role : roles) {
			roleNames += role.getRoleName() +",";
		}
		mmap.put("roleNames",roleNames);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存实践活动
	 */
	//@RequiresPermissions("system:activity:edit")//
	@Log(title = "实践活动", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Activity activity)
	{		
		return toAjax(activityService.updateActivity(activity));
	}
	
	/**
	 * 删除实践活动
	 */
	//@RequiresPermissions("system:activity:remove")//
	@Log(title = "实践活动", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(activityService.deleteActivityByIds(ids));
	}
	
}
