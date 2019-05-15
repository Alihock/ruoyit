package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Task;
import java.util.List;	

/**
 * 0000 数据层
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
public interface TaskMapper 
{
	/**
     * 查询0000信息
     * 
     * @param taskId 0000ID
     * @return 0000信息
     */
	public Task selectTaskById(Long taskId);
	
	/**
     * 查询0000列表
     * 
     * @param task 0000信息
     * @return 0000集合
     */
	public List<Task> selectTaskList(Task task);
	
	/**
     * 新增0000
     * 
     * @param task 0000信息
     * @return 结果
     */
	public int insertTask(Task task);
	
	/**
     * 修改0000
     * 
     * @param task 0000信息
     * @return 结果
     */
	public int updateTask(Task task);
	
	/**
     * 删除0000
     * 
     * @param taskId 0000ID
     * @return 结果
     */
	public int deleteTaskById(Long taskId);
	
	/**
     * 批量删除0000
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaskByIds(String[] taskIds);
	
}