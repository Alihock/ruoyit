package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Map;

import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.Task;
import com.ruoyi.system.service.ITaskService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 0000 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
@Controller
@RequestMapping("/system/task")
public class TaskController extends BaseController
{
    private String prefix = "system/task";
	
	@Autowired
	private ITaskService taskService;
	@Autowired
	private ISysUserService iSysUserService;


	//@RequiresPermissions("system:task:view")//
	@GetMapping()
	public String task( Map mmap)
	{
		SysUser user = (SysUser)iSysUserService.getUser();
		String roleNames = "";
		List<SysRole> roles = user.getRoles();
		for (SysRole role : roles) {
			roleNames += role.getRoleName() +",";
		}
		mmap.put("roleNames",roleNames);
	    return prefix + "/task";
	}
	
	/**
	 * 查询0000列表
	 */
	//@RequiresPermissions("system:task:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Task task)
	{
		startPage();
        List<Task> list = taskService.selectTaskList(task);

		return getDataTable(list);
	}

	/*提交确认
	*/
	/*校验
	*/

	/**
	 * 导入  修改
	 */
	@PostMapping("/importData")
	@ResponseBody
	public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
	{
		ExcelUtil<Task> util = new ExcelUtil<Task>(Task.class);
		List<Task> userList = util.importExcel(file.getInputStream());
		String operName = ShiroUtils.getSysUser().getLoginName();
		String message = taskService.importTask(userList, updateSupport, operName);
		return AjaxResult.success(message);
	}
	/**
	 * 导入  修改
	 */
	/**
 	*	 确认 修改
 	*/

	/**
	 *	 确认 修改
	 */
	/**
	 * 导出0000列表
	 */
	//@RequiresPermissions("system:task:export")//
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Task task)
    {
    	List<Task> list = taskService.selectTaskList(task);
        ExcelUtil<Task> util = new ExcelUtil<Task>(Task.class);
        return util.exportExcel(list, "task");
    }
	
	/**
	 * 新增0000
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存0000
	 */
	//@RequiresPermissions("system:task:add")//
	@Log(title = "0000", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Task task)
	{		
		return toAjax(taskService.insertTask(task));
	}

	/**
	 * 修改0000
	 */
	@GetMapping("/edit/{taskId}")
	public String edit(@PathVariable("taskId") Long taskId, ModelMap mmap)
	{
		String roleNames = "";
		Task task = taskService.selectTaskById(taskId);
		mmap.put("task", task);

		SysUser user = (SysUser)iSysUserService.getUser();
		List<SysRole> roles = user.getRoles();
		for (SysRole role : roles) {
			roleNames += role.getRoleName() +",";
		}
		mmap.put("roleNames",roleNames);
		return prefix + "/edit";
	}
	
	/**
	 * 修改保存0000
	 */
	//@RequiresPermissions("system:task:edit")//
	@Log(title = "0000", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Task task)
	{		
		return toAjax(taskService.updateTask(task));
	}
	
	/**
	 * 删除0000
	 */
	//@RequiresPermissions("system:task:remove")//
	@Log(title = "0000", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(taskService.deleteTaskByIds(ids));
	}
	
}
