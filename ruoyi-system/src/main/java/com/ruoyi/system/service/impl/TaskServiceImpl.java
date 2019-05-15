package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.Md5Utils;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.domain.Task;
import com.ruoyi.system.service.ITaskService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 0000 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
@Service
public class TaskServiceImpl implements ITaskService 
{
	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	@Autowired
	private TaskMapper taskMapper;


	/**
     * 查询0000信息
     * 
     * @param taskId 0000ID
     * @return 0000信息
     */
    @Override
	public Task selectTaskById(Long taskId)
	{
	    return taskMapper.selectTaskById(taskId);
	}
	
	/**
     * 查询0000列表
     * 
     * @param task 0000信息
     * @return 0000集合
     */
	@Override
	public List<Task> selectTaskList(Task task)
	{
	    return taskMapper.selectTaskList(task);
	}
	
    /**
     * 新增0000
     * 
     * @param task 0000信息
     * @return 结果
     */
	@Override
	public int insertTask(Task task)
	{
	    return taskMapper.insertTask(task);
	}
	
	/**
     * 修改0000
     * 
     * @param task 0000信息
     * @return 结果
     */
	@Override
	public int updateTask(Task task)
	{
	    return taskMapper.updateTask(task);
	}

	/**
     * 删除0000对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTaskByIds(String ids)
	{
		return taskMapper.deleteTaskByIds(Convert.toStrArray(ids));
	}



	/**xiugai
	 * 导入用户数据
	 *
	 * @param taskList 任务书数据列表
	 * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
	 * @param operName 操作用户
	 * @return 结果
	 */
	@Autowired
	private ISysConfigService configService;

	@Override
	public String importTask(List<Task> taskList, Boolean isUpdateSupport, String operName)
	{
		if (StringUtils.isNull(taskList) || taskList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		String password = configService.selectConfigByKey("sys.user.initPassword");
		for (Task task : taskList)
		{
			try
			{
				// 验证是否存在
				Task u = taskMapper.selectTaskById(task.getTaskId());
				if (StringUtils.isNull(u))
				{
//					task.setPassword(Md5Utils.hash(task.getLoginName() + password));
//					task.setCreateBy(operName);
//					this.insertUser(task);
					this.insertTask(task);
					successNum++;
					successMsg.append("<br/>" + successNum + "任务书 " + task.getCourseName() + " 导入成功");
				}
//				else if (isUpdateSupport)
//				{
//					task.setUpdateBy(operName);
//					this.updateUser(task);
//					successNum++;
//					successMsg.append("<br/>" + successNum + "、账号 " + task.getLoginName() + " 更新成功");
//				}
//				else
//				{
//					failureNum++;
//					failureMsg.append("<br/>" + failureNum + "、账号 " + task.getLoginName() + " 已存在");
//				}
			}
			catch (Exception e)
			{
				failureNum++;
				String msg = "<br/>" + failureNum + "、账号 " + task.getCourseName() + " 导入失败：";
				failureMsg.append(msg + e.getMessage());
				log.error(msg, e);
			}
		}
		if (failureNum > 0)
		{
			failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
			throw new BusinessException(failureMsg.toString());
		}
		else
		{
			successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
		}
		return successMsg.toString();
	}

}
