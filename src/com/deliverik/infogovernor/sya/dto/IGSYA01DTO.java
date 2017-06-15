/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sya.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sya.form.IGSYA0101Form;
import com.deliverik.infogovernor.sya.form.IGSYA0102Form;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;


@SuppressWarnings("serial")
public class IGSYA01DTO extends BaseDTO implements Serializable {
    
	public IGSYA0101Form igSYA0101Form;
	
	public IGSYA0102Form igSYA0102Form;
	
	
	/** 用户信息 */
	protected User user;
	
	/**
	 * 设置附件用
	 */
	protected IGSYA0102Form attachFile;
	
	/**查询结果返回*/
    protected List<InstitutionInfo> institutionList;
	
	public IGSYA0102Form getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(IGSYA0102Form attachFile) {
		this.attachFile = attachFile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 分页Bean
	 */
	
	protected PagingDTO pagingDto;

	/**
	 * 允许查询的最大记录数
	 */
	
	protected int maxSearchCount;
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public IGSYA0101Form getIgSYA0101Form() {
		return igSYA0101Form;
	}

	public void setIgSYA0101Form(IGSYA0101Form igSYA0101Form) {
		this.igSYA0101Form = igSYA0101Form;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public IGSYA0102Form getIgSYA0102Form() {
		return igSYA0102Form;
	}

	public void setIgSYA0102Form(IGSYA0102Form igSYA0102Form) {
		this.igSYA0102Form = igSYA0102Form;
	}

	/**
	 * 查询结果返回取得
	 * @return institutionList  查询结果返回
	 */
	public List<InstitutionInfo> getInstitutionList() {
		return institutionList;
	}

	/**
	 * 查询结果返回设定
	 * @param institutionList  查询结果返回
	 */
	public void setInstitutionList(List<InstitutionInfo> institutionList) {
		this.institutionList = institutionList;
	}

}