package com.ruoyi.system.service;

import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.domain.Task;

import java.util.List;

/**
 * 实践活动 服务层
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
public interface IActivityService 
{
	/**
     * 查询实践活动信息
     * 
     * @param activityId 实践活动ID
     * @return 实践活动信息
     */
	public Activity selectActivityById(Long activityId);
	
	/**
     * 查询实践活动列表
     * 
     * @param activity 实践活动信息
     * @return 实践活动集合
     */
	public List<Activity> selectActivityList(Activity activity);
	
	/**
     * 新增实践活动
     * 
     * @param activity 实践活动信息
     * @return 结果
     */
	public int insertActivity(Activity activity);
	
	/**
     * 修改实践活动
     * 
     * @param activity 实践活动信息
     * @return 结果
     */
	public int updateActivity(Activity activity);
		
	/**
     * 删除实践活动信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteActivityByIds(String ids);

	/*xiugai
	 *
	 */
	public String importActivity(List<Activity> activityList, Boolean isUpdateSupport, String operName);

}
