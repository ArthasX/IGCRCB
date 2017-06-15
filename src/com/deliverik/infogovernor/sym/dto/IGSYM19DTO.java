/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prr.model.ProcessWorkTimeTemplateInfo;
import com.deliverik.infogovernor.sym.form.IGSYM1901Form;
import com.deliverik.infogovernor.sym.form.IGSYM1902Form;
import com.deliverik.infogovernor.sym.form.IGSYM1903Form;
import com.deliverik.infogovernor.sym.vo.IGSYM19012VO;
/**
 * 概述:服务流程有效时间计算DTO
 * 创建记录：张楠    2011/10/18
 */

@SuppressWarnings("serial")
public class IGSYM19DTO extends BaseDTO implements Serializable {

	/**
	 * igsym1901Form
	 */
	protected IGSYM1901Form igsym1901Form;
	
	/**
	 * igsym1902Form
	 */
	protected IGSYM1902Form igsym1902Form;
	
	/**
	 * igsym1903Form
	 */
	protected IGSYM1903Form igsym1903Form;
	
	/**
	 * 作息日期模板结果集
	 */
	protected List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList;
	
	/**
	 * vo集合
	 */
	protected Map<String, IGSYM19012VO> voMap;
	
	/**
	 * 用户设定工作日期检索件数
	 */
	protected Integer processWorkTimeCount;
	
	/**
	 * 用户ID
	 */
	protected String userId;
	/**
	 * igsym1901Form获取
	 * @return
	 */
	public IGSYM1901Form getIgsym1901Form() {
		return igsym1901Form;
	}

	/**
	 * igsym1901Form设定
	 * @param igsym1901Form
	 */
	public void setIgsym1901Form(IGSYM1901Form igsym1901Form) {
		this.igsym1901Form = igsym1901Form;
	}

	/**
	 * igsym1902Form获取
	 * @return
	 */
	public IGSYM1902Form getIgsym1902Form() {
		return igsym1902Form;
	}

	/**
	 * igsym1902Form设定
	 * @param igsym1902Form
	 */
	public void setIgsym1902Form(IGSYM1902Form igsym1902Form) {
		this.igsym1902Form = igsym1902Form;
	}

	/**
	 * igsym1903Form获取
	 * @return
	 */
	public IGSYM1903Form getIgsym1903Form() {
		return igsym1903Form;
	}

	/**
	 * igsym1903Form设定
	 * @param igsym1903Form
	 */
	public void setIgsym1903Form(IGSYM1903Form igsym1903Form) {
		this.igsym1903Form = igsym1903Form;
	}

	/**
	 * 作息模板结果集获取
	 * @return
	 */
	public List<ProcessWorkTimeTemplateInfo> getProcessWorkTimeTemplateInfoList() {
		return processWorkTimeTemplateInfoList;
	}

	/**
	 * 作息模板结果集设定
	 * @param processWorkTimeTemplateInfoList
	 */
	public void setProcessWorkTimeTemplateInfoList(
			List<ProcessWorkTimeTemplateInfo> processWorkTimeTemplateInfoList) {
		this.processWorkTimeTemplateInfoList = processWorkTimeTemplateInfoList;
	}

	/**
	 * voMap获取
	 * @return
	 */
	public Map<String, IGSYM19012VO> getVoMap() {
		return voMap;
	}

	/**
	 * voMap设定
	 * @param voMap
	 */
	public void setVoMap(Map<String, IGSYM19012VO> voMap) {
		this.voMap = voMap;
	}

	/**
	 * 用户设定工作日期检索件数获取
	 * @return
	 */
	public Integer getProcessWorkTimeCount() {
		return processWorkTimeCount;
	}

	/**
	 * 用户设定工作日期检索件数设定
	 * @param processWorkTimeCount
	 */
	public void setProcessWorkTimeCount(Integer processWorkTimeCount) {
		this.processWorkTimeCount = processWorkTimeCount;
	}

	/**
	 * 用户ID获取
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * 用户ID设定
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
