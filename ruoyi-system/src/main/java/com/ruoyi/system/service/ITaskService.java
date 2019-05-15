package com.ruoyi.system.service;

import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.Task;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import java.util.List;

/**
 * 0000 服务层
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
public interface ITaskService 
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
     * 删除0000信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTaskByIds(String ids);


/*xiugai
*
 */
public String importTask(List<Task> taskList, Boolean isUpdateSupport, String operName);

}
