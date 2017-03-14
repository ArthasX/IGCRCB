/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.model.entity.AttachmentTB;

/**
 * 概述:流程评审实体TB类
 * 功能描述：针对流程评审实体接口
 *           
 * 创建记录：宋海洋    2010/11/26
 */
public interface IG433Info {
	/**
	 *主键
	 */
	public Integer getPaid();

	/**
	 *流程ID
	 */
	public Integer getPaprid();

	/**
	 *流程名
	 */
	public String getPaprname();

	/**
	 *评审人id
	 */
	public String getPauserid();

	/**
	 *评审说明1
	 */
	public String getPaassessmentdes();

	/**
	 *评审时间
	 */
	public String getPaassessmentdate();
	
	/**
	 * 事件类别code
	 */
	public String getPaeventtypecode();
	
	/**
	 * 评审附件Key
	 */
	public String getPaattkey();
	
	/**
	 * 附件List
	 */
	public List<AttachmentTB> getAttachmentList();
	
	/**
	 * 评审状态
	 */
	public String getPastatus();

}
