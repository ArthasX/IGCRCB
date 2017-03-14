/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.form.IGDBM1301Form;
import com.deliverik.infogovernor.dbm.form.IGDBM1302Form;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.vo.IGDBM13012VO;

@SuppressWarnings("serial")
public class IGDBM13DTO extends BaseDTO{
	protected Integer wmid;
	
	//工作管理查询form
	protected IGDBM1301Form igdbm1301Form;
		
	//工作管理新增form
	protected IGDBM1302Form igdbm1302Form;
	
	//工作管理结果集
	protected List<WorkmanagerInfo> wmList;
	
	//当前用户
	protected User user;
	
	protected int maxSearchCount;
	
	protected PagingDTO pagingDto;
	
	/**频率周星期集合*/
	protected List<IGDBM13012VO> weekList;
	
	/**频率月天数集合*/
	protected List<IGDBM13012VO> monthList;
	
	/** 编辑工作信息 */
	protected WorkmanagerInfo info;
	
	/**
	 * @return the 编辑工作信息
	 */
	public WorkmanagerInfo getInfo() {
		return info;
	}

	/**
	 * @param 编辑工作信息 the info to set
	 */
	public void setInfo(WorkmanagerInfo info) {
		this.info = info;
	}

	/**
	 * @return the wmid
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param wmid the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the 频率周星期集合
	 */
	public List<IGDBM13012VO> getWeekList() {
		return weekList;
	}

	/**
	 * @param 频率周星期集合 the weekList to set
	 */
	public void setWeekList(List<IGDBM13012VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * @return the 频率月天数集合
	 */
	public List<IGDBM13012VO> getMonthList() {
		return monthList;
	}

	/**
	 * @param 频率月天数集合 the monthList to set
	 */
	public void setMonthList(List<IGDBM13012VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * @param maxSearchCount the maxSearchCount to set
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * @return the pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * @param pagingDto the pagingDto to set
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the igdbm1301Form
	 */
	public IGDBM1301Form getIgdbm1301Form() {
		return igdbm1301Form;
	}

	/**
	 * @param igdbm1301Form the igdbm1301Form to set
	 */
	public void setIgdbm1301Form(IGDBM1301Form igdbm1301Form) {
		this.igdbm1301Form = igdbm1301Form;
	}

	/**
	 * @return the igdbm1302Form
	 */
	public IGDBM1302Form getIgdbm1302Form() {
		return igdbm1302Form;
	}

	/**
	 * @param igdbm1302Form the igdbm1302Form to set
	 */
	public void setIgdbm1302Form(IGDBM1302Form igdbm1302Form) {
		this.igdbm1302Form = igdbm1302Form;
	}

	/**
	 * @return the wmList
	 */
	public List<WorkmanagerInfo> getWmList() {
		return wmList;
	}

	/**
	 * @param wmList the wmList to set
	 */
	public void setWmList(List<WorkmanagerInfo> wmList) {
		this.wmList = wmList;
	}
	
}
