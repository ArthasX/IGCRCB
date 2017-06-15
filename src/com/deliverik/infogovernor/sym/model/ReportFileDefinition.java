/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.model.CodeDetail;

/**
 * 报表信息接口
 * 
 */

public interface ReportFileDefinition  extends BaseModel {

	/**
	 * 主键取得
	 * @return 主键
	 */
	public abstract Integer getRfdid();

	/**
	 * 报表显示名称取得
	 * @return 报表显示名称
	 */
	public abstract String getRfdtitle();
	
	/**
	 * 报表分类取得
	 * @return 报表分类
	 */
	public abstract String getRfdtype();

	/**
	 * 报表说明取得
	 * @return 报表说明
	 */
	public abstract String getRfddesc();

	/**
	 * 报表文件名取得
	 * @return 报表文件名
	 */
	public abstract String getRfdfilename();

	/**
	 * 报表登记人ID取得
	 * @return 报表登记人ID
	 */
	public abstract String getRfduserid();

	/**
	 * 报表登记人姓名取得
	 * @return 报表登记人姓名
	 */
	public abstract String getRfdusername();

	/**
	 * 报表登记时间取得
	 * @return 报表登记时间
	 */
	public abstract String getRfdinstime();
	
	/**
	 * 报表版本号取得
	 * @return 报表版本号
	 */
	public abstract Integer getRfdversion();
	
	/**
	 * 报表最新版本号取得
	 * @return 报表最新版本号
	 */
	public abstract Integer getRfdnewversion();
	
	/**
	 * 基础数据实体取得
	 * @return 基础数据实体
	 */
	public abstract CodeDetail getCodeDetailTB();
	
	/**
	 * 报表类型取得
	 * @return 基础数据实体
	 */
	public abstract String getRfdpictype();
	
	
	public String getRfdparameters();
	
	public String getIsFlag();


}