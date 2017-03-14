/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model;

/**
 * 概述:服务商信息视图接口
 * 功能描述: 服务商信息视图接口
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录: 
 */

public interface EntityItemFacilitatorVWInfo {

	/**服务商id 取得 */
	public Integer getEiid();
	/**公司名称  取得 */
	public String getEiname();
	/**地址  取得 */
	public String getAddress();
	/**联系人  取得 */
	public String getLinkman();
	/**电话 取得  */
	public String getTel();
	/**开户行  取得 */
	public String getAccountbk();
	/**开户帐号  取得 */
	public String getAccountno();
	/**开户名称  取得 */
	public String getAccountname();
	/**机构码  取得 */
	public String getEiorgsyscoding();
	/**模型码  取得 */
	public String getEsyscoding();
	/**登记日  取得 */
	public String getEiinsdate();
}
