package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.Task;
import com.ruoyi.system.service.ISysConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ActivityMapper;
import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.service.IActivityService;
import com.ruoyi.common.core.text.Convert;

/**
 * 实践活动 服务层实现
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
@Service
public class ActivityServiceImpl implements IActivityService 
{private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
	@Autowired
	private ActivityMapper activityMapper;

	/**
     * 查询实践活动信息
     * 
     * @param activityId 实践活动ID
     * @return 实践活动信息
     */
    @Override
	public Activity selectActivityById(Long activityId)
	{
	    return activityMapper.selectActivityById(activityId);
	}
	
	/**
     * 查询实践活动列表
     * 
     * @param activity 实践活动信息
     * @return 实践活动集合
     */
	@Override
	public List<Activity> selectActivityList(Activity activity)
	{
	    return activityMapper.selectActivityList(activity);
	}
	
    /**
     * 新增实践活动
     * 
     * @param activity 实践活动信息
     * @return 结果
     */
	@Override
	public int insertActivity(Activity activity)
	{
	    return activityMapper.insertActivity(activity);
	}
	
	/**
     * 修改实践活动
     * 
     * @param activity 实践活动信息
     * @return 结果
     */
	@Override
	public int updateActivity(Activity activity)
	{
	    return activityMapper.updateActivity(activity);
	}

	/**
     * 删除实践活动对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteActivityByIds(String ids)
	{
		return activityMapper.deleteActivityByIds(Convert.toStrArray(ids));
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
	public String importActivity(List<Activity> activityList, Boolean isUpdateSupport, String operName)
	{
		if (StringUtils.isNull(activityList) || activityList.size() == 0)
		{
			throw new BusinessException("导入用户数据不能为空！");
		}
		int successNum = 0;
		int failureNum = 0;
		StringBuilder successMsg = new StringBuilder();
		StringBuilder failureMsg = new StringBuilder();
		String password = configService.selectConfigByKey("sys.user.initPassword");
		for (Activity activity : activityList)
		{
			try
			{
				// 验证是否存在
				Activity u = activityMapper.selectActivityById(activity.getActivityId());
				if (StringUtils.isNull(u))
				{
//					task.setPassword(Md5Utils.hash(task.getLoginName() + password));
//					task.setCreateBy(operName);
//					this.insertUser(task);
					this.insertActivity(activity);
					successNum++;
					successMsg.append("<br/>" + successNum + "任务书 " + activity.getCourseName() + " 导入成功");
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
				String msg = "<br/>" + failureNum + "、账号 " + activity.getCourseName() + " 导入失败：";
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
