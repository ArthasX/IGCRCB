/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: SOC0118VW接口
  * 功能描述: SOC0118VW接口
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public interface SOC0118VWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 资产ID                  取得
	 *
	 * @return 资产ID                  
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID              取得
	 *
	 * @return 资产模型ID              
	 */
	public String getEid();

	/**
	 * 资产项的说明            取得
	 *
	 * @return 资产项的说明            
	 */
	public String getEidesc();

	/**
	 * 资产名称                取得
	 *
	 * @return 资产名称                
	 */
	public String getEiname();

	/**
	 * 资产编号                取得
	 *
	 * @return 资产编号                
	 */
	public String getEilabel();

	/**
	 * 资产登记日              取得
	 *
	 * @return 资产登记日              
	 */
	public String getEiinsdate();

	/**
	 * 所属机构层次码          取得
	 *
	 * @return 所属机构层次码          
	 */
	public String getEiorgsyscoding();

	/**
	 * 所属模型层次码          取得
	 *
	 * @return 所属模型层次码          
	 */
	public String getEsyscoding();

	/**
	 * 更新时间                取得
	 *
	 * @return 更新时间                
	 */
	public String getEiupdtime();

	/**
	 * 资产状态                取得
	 *
	 * @return 资产状态                
	 */
	public String getEistatus();

	/**
	 * 版本                    取得
	 *
	 * @return 版本                    
	 */
	public String getEiversion();
	
	/**
	 * 资产管理人取得
	 * @return 资产管理人
	 */
	public String getEiuserid();
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername();
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion();
	
	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark();
}