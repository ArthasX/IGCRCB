/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.condition;


/**
 * 概述:服务商信息视图查询条件实现
 * 功能描述: 服务商信息视图查询条件实现
 * 创建人：付彬
 * 创建记录: 2013/05/13
 * 修改记录: 
 */
public class EntityItemFacilitatorVWSearchCondImpl implements
		EntityItemFacilitatorVWSearchCond {

	/**公司名称  */
	protected String einame;
	/**机构码  */
	protected String eiorgsyscoding;
	/**模型码  */
	protected String esyscoding;
	/**登记日  起始*/
	protected String eiupdtime_from;
	/**登记日 结束*/
	protected String eiupdtime_to;
	
	
	/**公司名称  取得 */
	public String getEiname() {
		return einame;
	}
	/**机构码  取得 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**模型码  取得 */
	public String getEsyscoding() {
		return esyscoding;
	}
	/**登记日起始  取得 */
	public String getEiupdtime_from() {
		return eiupdtime_from;
	}
	/**登记日结束  取得 */
	public String getEiupdtime_to() {
		return eiupdtime_to;
	}
	
	
	/**公司名称  设定 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	/**机构码  设定 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	/**模型码  设定 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	/**登记日起始  设定 */
	public void setEiupdtime_from(String eiupdtime_from) {
		this.eiupdtime_from = eiupdtime_from;
	}
	/**登记日结束   设定 */
	public void setEiupdtime_to(String eiupdtime_to) {
		this.eiupdtime_to = eiupdtime_to;
	}
	
}
