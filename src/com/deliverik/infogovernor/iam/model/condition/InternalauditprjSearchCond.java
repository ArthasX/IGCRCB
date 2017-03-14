/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * 概述: 内审项目检索条件接口
  * 功能描述: 内审项目检索条件接口
  * 创建记录: 2012/07/19
  * 修改记录: 
  */
public interface InternalauditprjSearchCond {

	/** iapYear_eq取得 */
	public String getIapYear_eq();
	
	/** iapName_like取得 */
	public String getIapName_like();
	
	/** iapStatus_eq取得 */
	public String getIapStatus_eq();
	
	/** iapOpenTimeFrom_ge取得 */
	public String getIapOpenTimeFrom_ge();
	
	/** iapOpenTimeTo_le取得 */
	public String getIapOpenTimeTo_le();
	
	/** iapType_eq取得 */
	public String getIapType_eq();
}