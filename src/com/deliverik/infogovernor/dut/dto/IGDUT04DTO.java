/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dut.form.IGDUT0401Form;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;

/**
 * 延时解锁DTO
 */
public class IGDUT04DTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 登录用户
	 */
	protected User user;
	
	/**
	 * 延时解锁检索条件
	 */
	protected DelaySearchCond delaySearchCond;
	
	/**
	 * 延迟解锁Form
	 */
	protected IGDUT0401Form igdut0401Form;
	
	/**
	 * 延时解锁结果集
	 */
	protected List<DelayInfo> delayList;
	
	/**
	 * 删除主键
	 */
	protected String[] deleteId;
	
	/**
	 * 分页Bean
	 */
	protected PagingDTO pagingDto;
	
	protected List<LabelValueBean> titleList;
	
	protected int maxSearchCount;

	/**
	 * 登录用户取得
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 登录用户设定
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 延迟解锁Form取得
	 * @return
	 */
	public IGDUT0401Form getIgdut0401Form() {
		return igdut0401Form;
	}

	/**
	 * 延迟解锁Form设定
	 * @param igdut0401Form
	 */
	public void setIgdut0401Form(IGDUT0401Form igdut0401Form) {
		this.igdut0401Form = igdut0401Form;
	}

	/**
	 * 延时解锁检索条件取得
	 * @return
	 */
	public DelaySearchCond getDelaySearchCond() {
		return delaySearchCond;
	}

	/**
	 * 延时解锁检索条件设定
	 * @param delaySearchCond
	 */
	public void setDelaySearchCond(DelaySearchCond delaySearchCond) {
		this.delaySearchCond = delaySearchCond;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 延时解锁结果集取得
	 * @return
	 */
	public List<DelayInfo> getDelayList() {
		return delayList;
	}

	/**
	 * 延时解锁结果集设定
	 * @param delayList
	 */
	public void setDelayList(List<DelayInfo> delayList) {
		this.delayList = delayList;
	}

	/**
	 * 删除主键取得
	 * @return
	 */
	public String[] getDeleteId() {
		return deleteId;
	}

	/**
	 * 删除主键设定
	 * @param deleteRoleid
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	public List<LabelValueBean> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<LabelValueBean> titleList) {
		this.titleList = titleList;
	}

}
