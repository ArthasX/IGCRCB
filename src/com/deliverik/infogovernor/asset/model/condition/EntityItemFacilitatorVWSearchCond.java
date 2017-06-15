/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.condition;
/**
 * 概述:服务商信息视图查询条件接口
 * 功能描述: 服务商信息视图查询条件接口
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录: 
 */
public interface EntityItemFacilitatorVWSearchCond {

	/**公司名称  取得 */
	public String getEiname();
	/**机构码  取得 */
	public String getEiorgsyscoding();
	/**模型码  取得 */
	public String getEsyscoding();
	/**登记日起始  取得 */
	public String getEiupdtime_from();
	/**登记日结束  取得 */
	public String getEiupdtime_to();
}
