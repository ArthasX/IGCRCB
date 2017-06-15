package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程类型定义信息
 *
 */
public interface IG380Info  extends BaseModel {

	/**
	 * 流程类型定义ID取得
	 * @return 流程类型定义ID
	 */
	public String getPdid();


	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid();

	/**
	 * 流程类型定义名称取得
	 * @return 流程类型定义名称
	 */
	public String getPdname();


	/**
	 * 流程类型定义描述取得
	 * @return 流程类型定义描述
	 */
	public String getPddesc();

	/**
	 * 流程类型定义创建时间取得
	 * @return 流程类型定义创建时间
	 */
	public String getPdcrtdate();

	/**
	 * 流程类型定义状态取得
	 * @return 流程类型定义状态
	 */
	public String getPdstatus();


	/**
	 * 流程图xml信息取得
	 * @return 流程图xml信息
	 */
	public String getPdxml();
	
	/**
	 * 流程日志权限取得
	 * @return 流程日志权限
	 */
	public String getPermission();

	/**
	 * 工单号生成器取得
	 * 
	 * @return 工单号生成器
	 */
	public String getSerialgenerator();
	
	/**
     * 菜单ID取得
     * 
     * @return 菜单ID
     */
    public String getPdactname();
    
    /**
	 * 监管报表填报说明取得
	 * @return reportdesc 监管报表填报说明
	 */
	public String getReportdesc();
	
	/**
	 * 提醒信息生成器取得
	 * @return messagegenerator 提醒信息生成器
	 */
	public String getMessagegenerator();
	

	/**
	 * 服务目录取得
	 * @return pdservicecatalog 服务目录
	 */
	public String getPdservicecatalog();


	/**
	 * 流程编号取得
	 * @return pdserialnumber 流程编号
	 */
	public String getPdserialnumber();
	
	/**
	 * 服务目录显示名称取得
	 * @return pdservicecatalogname 服务目录显示名称
	 */
	public String getPdservicecatalogname();
	
}