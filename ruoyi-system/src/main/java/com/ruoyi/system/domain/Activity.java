package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 实践活动表 sys_activity
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
public class Activity extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 实践环节ID */
	@Excel(name = "实践环节序号", prompt = "实践环节编号")
	private Long activityId;
	/** 课程号 */
	@Excel(name = "课程号")
	private String courseNum;
	/** 课程名 */
	@Excel(name = "课程名")
	private String courseName;
	/** 总学分 */
	@Excel(name = "总学分")
	private String totalCredit;
	/** 班级信息 */
	@Excel(name = "班级信息")
	private String classInf;
	/** 班级人数 */
	@Excel(name = "班级人数")
	private String classNum;
	/** 任课教师 */
	@Excel(name = "任课教师")
	private String teacher;
	/** 上课起止周 */
	@Excel(name = "上课起止周")
	private String week;
	/** 校内外 */
	@Excel(name = "校内外")
	private String school;
	/** 详细地址 */
	@Excel(name = "地址")
	private String address;

	public void setActivityId(Long activityId) 
	{
		this.activityId = activityId;
	}

	public Long getActivityId() 
	{
		return activityId;
	}
	public void setCourseNum(String courseNum) 
	{
		this.courseNum = courseNum;
	}

	public String getCourseNum() 
	{
		return courseNum;
	}
	public void setCourseName(String courseName) 
	{
		this.courseName = courseName;
	}

	public String getCourseName() 
	{
		return courseName;
	}
	public void setTotalCredit(String totalCredit) 
	{
		this.totalCredit = totalCredit;
	}

	public String getTotalCredit() 
	{
		return totalCredit;
	}
	public void setClassInf(String classInf) 
	{
		this.classInf = classInf;
	}

	public String getClassInf() 
	{
		return classInf;
	}
	public void setClassNum(String classNum) 
	{
		this.classNum = classNum;
	}

	public String getClassNum() 
	{
		return classNum;
	}
	public void setTeacher(String teacher) 
	{
		this.teacher = teacher;
	}

	public String getTeacher() 
	{
		return teacher;
	}
	public void setWeek(String week) 
	{
		this.week = week;
	}

	public String getWeek() 
	{
		return week;
	}
	public void setSchool(String school) 
	{
		this.school = school;
	}

	public String getSchool() 
	{
		return school;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("activityId", getActivityId())
            .append("courseNum", getCourseNum())
            .append("courseName", getCourseName())
            .append("totalCredit", getTotalCredit())
            .append("classInf", getClassInf())
            .append("classNum", getClassNum())
            .append("teacher", getTeacher())
            .append("week", getWeek())
            .append("school", getSchool())
            .append("address", getAddress())
            .append("remark", getRemark())
            .toString();
    }
}
