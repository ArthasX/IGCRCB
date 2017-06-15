/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.User;

/**
 * 
 * 服务工单日志实体接口
 * 
 */

public interface IG941Info extends BaseModel {
	/**
	 * 服务工单日志ID取得
	 * 
	 * @return 服务工单日志ID
	 */
	public Integer getSflid();
	
	/**
	 * 服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid();
	
	/**
	 * 服务工单处理记录取得
	 * 
	 * @return 服务工单处理记录
	 */
	public String getSfldesc();
	
	/**
	 * 服务工单处理人ID取得
	 * 
	 * @return 服务工单处理人ID
	 */
	public String getSfluserid();
	
	/**
	 * 服务工单日志登记时间取得
	 * 
	 * @return 服务工单日志登记时间
	 */
	public String getSflinstime();
	
	/**
	 * 服务工单处理人取得
	 * @return 服务工单处理人
	 */
	public User getSfluser();
	
	/**
	 * 服务工单附件KEY取得
	 * @return 服务工单附件KEY
	 */
	public String getSflattkey();
}