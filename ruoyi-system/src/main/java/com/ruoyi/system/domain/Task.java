package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 0000表 sys_task
 * 
 * @author ruoyi
 * @date 2019-05-06
 */
public class Task extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 开课任务书ID */
	@Excel(name = "任务书序号", prompt = "任务书编号")
	private Long taskId;
	/**课程号 */
	@Excel(name="课程号")
	private String courseNum;
	/** 课程名 */
	@Excel(name="课程名")
	private String courseName;
	/** 专业 */
	@Excel(name="专业")
	private String major;
	/** 院系 */
	@Excel(name="院系")
	private String faculty;
	/** 班级信息 */
	@Excel(name="班级信息")
	private String classInf;
	/** 班级人数 */
	@Excel(name="班级人数")
	private String classNum;
	/** 课程属性 */
	@Excel(name="课程属性")
	private String courseType;
	/** 考试类别 */
	@Excel(name="考试类别")
	private String textType;
	/** 任课教师 */
	@Excel(name="任课老师")
	private String teacher;
	/** 上课起止周 */
	@Excel(name="上课起止周")
	private String week;
	/** 周学时 */
	@Excel(name="周学时")
	private String weekTime;
	/** 多媒体 */
	@Excel(name="多媒体")
	private String media;
	/** 双语 */
	@Excel(name="双语")
	private String doubleLang;
	/** 辅导 */
	@Excel(name="辅导")
	private String asist;

	public void setTaskId(Long taskId) 
	{
		this.taskId = taskId;
	}

	public Long getTaskId() 
	{
		return taskId;
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
	public void setMajor(String major) 
	{
		this.major = major;
	}

	public String getMajor() 
	{
		return major;
	}
	public void setFaculty(String faculty) 
	{
		this.faculty = faculty;
	}

	public String getFaculty() 
	{
		return faculty;
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
	public void setCourseType(String courseType) 
	{
		this.courseType = courseType;
	}

	public String getCourseType() 
	{
		return courseType;
	}
	public void setTextType(String textType) 
	{
		this.textType = textType;
	}

	public String getTextType() 
	{
		return textType;
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
	public void setWeekTime(String weekTime) 
	{
		this.weekTime = weekTime;
	}

	public String getWeekTime() 
	{
		return weekTime;
	}
	public void setMedia(String media) 
	{
		this.media = media;
	}

	public String getMedia() 
	{
		return media;
	}
	public void setDoubleLang(String doubleLang) 
	{
		this.doubleLang = doubleLang;
	}

	public String getDoubleLang() 
	{
		return doubleLang;
	}
	public void setAsist(String asist) 
	{
		this.asist = asist;
	}

	public String getAsist() 
	{
		return asist;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("courseNum", getCourseNum())
            .append("courseName", getCourseName())
            .append("major", getMajor())
            .append("faculty", getFaculty())
            .append("classInf", getClassInf())
            .append("classNum", getClassNum())
            .append("courseType", getCourseType())
            .append("textType", getTextType())
            .append("teacher", getTeacher())
            .append("week", getWeek())
            .append("weekTime", getWeekTime())
            .append("media", getMedia())
            .append("doubleLang", getDoubleLang())
            .append("asist", getAsist())
            .append("remark", getRemark())
            .toString();
    }
}
