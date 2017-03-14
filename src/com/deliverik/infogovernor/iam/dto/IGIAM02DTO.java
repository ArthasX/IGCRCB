/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0201Form;
import com.deliverik.infogovernor.iam.form.IGIAM0202Form;
import com.deliverik.infogovernor.iam.form.IGIAM0203Form;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;

/**
 * @author zhaomin
 *
 */
/**
 * 概述: 内审工作管理
 * 功能描述：内审工作管理
 * 创建人：赵敏
 * 创建记录： 2012-7-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGIAM02DTO extends BaseDTO implements Serializable{

	/**
	 * 内置工作管理查询form
	 */
	private IGIAM0201Form igiam0201form;
	
	/**
	 * 内置工作管理新增form
	 */
	private IGIAM0202Form igiam0202form;

	/**
	 * 设置附件用
	 */
	protected IGIAM0202Form attachFile;
	
	/** 
	 * 分页Bean 
	 */
    protected PagingDTO pagingDto;
    
    /** 
     * 审计管理信息最大检索件数
     */
    protected int maxSearchCount;
    
    /**
     * 内审工作条件查询结果list
     */
    protected List<InternalauditJobInfo> internalauditJobList;
    
    /**
     * 内审工作详细信息显示bean
     */
	private IGIAM0203Form igiam0203form;

	/**
	 * 内审工作附件集合
	 */
	private List<Attachment> attkeyList ;
	
	/**
	 * 内审工作删除附件ID
	 */
	private Integer attid;
	
	/**
	 * 获取attid
	 * @return fattid attid
	 */
	public Integer getAttid() {
		return attid;
	}

	/**
	 * 设置attid
	 * @param attid  attid
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}

	/**
	 * 获取attkeyList
	 * @return fattkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}

	/**
	 * 设置attkeyList
	 * @param attkeyList  attkeyList
	 */
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}

	/**
	 * 内审工作删除id
	 */
	private String iajids;

	/**
	 * 获取iajids
	 * @return fiajids iajids
	 */
	public String getIajids() {
		return iajids;
	}

	/**
	 * 设置iajids
	 * @param iajids  iajids
	 */
	public void setIajids(String iajids) {
		this.iajids = iajids;
	}

	/**
	 * 获取igiam0203form
	 * @return figiam0203form igiam0203form
	 */
	public IGIAM0203Form getIgiam0203form() {
		return igiam0203form;
	}

	/**
	 * 设置igiam0203form
	 * @param igiam0203form  igiam0203form
	 */
	public void setIgiam0203form(IGIAM0203Form igiam0203form) {
		this.igiam0203form = igiam0203form;
	}

	/**
	 * 获取igiam0202form
	 * @return figiam0202form igiam0202form
	 */
	public IGIAM0202Form getIgiam0202form() {
		return igiam0202form;
	}

	/**
	 * 设置igiam0202form
	 * @param igiam0202form  igiam0202form
	 */
	public void setIgiam0202form(IGIAM0202Form igiam0202form) {
		this.igiam0202form = igiam0202form;
	}

	/**
	 * 获取igiam0201form
	 * @return figiam0201form igiam0201form
	 */
	public IGIAM0201Form getIgiam0201form() {
		return igiam0201form;
	}

	/**
	 * 设置igiam0201form
	 * @param igiam0201form  igiam0201form
	 */
	public void setIgiam0201form(IGIAM0201Form igiam0201form) {
		this.igiam0201form = igiam0201form;
	}

	/**
	 * 获取attachFile
	 * @return fattachFile attachFile
	 */
	public IGIAM0202Form getAttachFile() {
		return attachFile;
	}

	/**
	 * 设置attachFile
	 * @param attachFile  attachFile
	 */
	public void setAttachFile(IGIAM0202Form attachFile) {
		this.attachFile = attachFile;
	}

	/**
	 * 获取pagingDto
	 * @return fpagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置pagingDto
	 * @param pagingDto  pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 获取internalauditJobList
	 * @return finternalauditJobList internalauditJobList
	 */
	public List<InternalauditJobInfo> getInternalauditJobList() {
		return internalauditJobList;
	}

	/**
	 * 设置internalauditJobList
	 * @param internalauditJobList  internalauditJobList
	 */
	public void setInternalauditJobList(
			List<InternalauditJobInfo> internalauditJobList) {
		this.internalauditJobList = internalauditJobList;
	}

	/**
	 * 获取maxSearchCount
	 * @return fmaxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置maxSearchCount
	 * @param maxSearchCount  maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

}
