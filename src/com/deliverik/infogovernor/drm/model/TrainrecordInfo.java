/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model;

import java.util.List;

import com.deliverik.framework.model.entity.AttachmentTB;


/**
  * 概述: 培训记录接口
  * 功能描述: 培训记录接口
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public interface TrainrecordInfo{

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTrid();

	/**
	 * 培训名称取得
	 *
	 * @return 培训名称
	 */
	public String getTrname();

	/**
	 * 培训计划id取得
	 *
	 * @return 培训计划id
	 */
	public Integer getTpid();

	/**
	 * 培训计划名称取得
	 *
	 * @return 培训计划名称
	 */
	public String getTpname();

	/**
	 * 培训内容取得
	 *
	 * @return 培训内容
	 */
	public String getTpcontent();

	/**
	 * 培训开始时间取得
	 *
	 * @return 培训开始时间
	 */
	public String getTrstime();

	/**
	 * 培训结束时间取得
	 *
	 * @return 培训结束时间
	 */
	public String getTretime();

	/**
	 * 培训地点取得
	 *
	 * @return 培训地点
	 */
	public String getTrside();

	/**
	 * 讲师取得
	 *
	 * @return 讲师
	 */
	public String getTrlecturer();

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getTratt();
	
	/**  
	 * 获取附件  
	 * @return attachmentList 附件  
	 */
	public List<AttachmentTB> getAttachmentList();

}