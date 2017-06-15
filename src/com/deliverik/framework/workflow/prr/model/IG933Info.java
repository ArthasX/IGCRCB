/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.asset.model.entity.IG688VW;
import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 服务工单实体接口
 * 
 * 
 */

public interface IG933Info extends BaseModel {
	/**
	 * 服务工单ID取得
	 * 
	 * @return 服务工单ID
	 */
	public Integer getSfid();
	
	/**
	 * 服务工单编码取得
	 * 
	 * @return 服务工单编码
	 */
	public String getSfcode();
	
	/**
	 * 服务工单报告人取得
	 * 
	 * @return 服务工单报告人
	 */
	public String getSfreportname();
	
	/**
	 * 服务工单报告人电话取得
	 * 
	 * @return 服务工单报告人电话
	 */
	public String getSfreportphone();
	
	/**
	 * 服务工单报告人部门取得
	 * 
	 * @return 服务工单报告人部门
	 */
	public String getSfreportorgid();
	
	/**
	 * 服务工单题目取得
	 * 
	 * @return 服务工单题目
	 */
	public String getSftitle();

	/**
	 * 服务工单描述取得
	 * 
	 * @return 服务工单描述
	 */
	public String getSfdesc();
	
	/**
	 * 服务工单附件取得
	 * 
	 * @return 服务工单附件
	 */
	public String getSfattkey();
	
	/**
	 * 服务工单状态取得
	 * 
	 * @return 服务工单状态
	 */
	public String getSfstatus();

	/**
	 * 服务工单部门ID取得
	 * 
	 * @return 服务工单部门ID
	 */
	public String getSforgid();
	
	/**
	 * 服务工单记录人ID取得
	 * 
	 * @return 服务工单记录人ID
	 */
	public String getSfregisterid();

	/**
	 * 服务工单记录时间取得
	 * 
	 * @return 服务工单记录时间
	 */
	public String getSfinstime();
	
	/** 服务工单时间戳取得
	 * 
	 * @return 服务工单时间戳
	 */
	
	/** 服务工单记录分类取得
	 * 
	 * @return 服务工单记录分类
	 */
	public String getSftype();
	

	/** 服务工单相关资产ID取得
	 * 
	 * @return 服务工单相关资产ID
	 */
	public Integer getSfeiid();
	
 
	/** 服务工单相关资产对象取得
	 * 
	 * @return 服务工单相关资产对象
	 */
	public IG688VW getEntityItemVW();
	
	/** 服务工单来源取得
	 * 
	 * @return 服务工单来源
	 */
	public String getSfsource();
	
	/** 服务工单办公电话取得
	 * 
	 * @return 服务工单办公电话
	 */
	public String getSfworkphone();
	
	/** 邮箱取得
	 * 
	 * @return 邮箱
	 */
	public String getSfemail();
}