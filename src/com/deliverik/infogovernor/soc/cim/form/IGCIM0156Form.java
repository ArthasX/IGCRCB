/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.form;


/**
 * 概述: 监控对象Form
 * 功能描述: 监控对象Form
 * 创建记录: yanglongquan 2013-10-29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM0156Form extends IGCIM0155Form{
	
	/**resource_id*/
	protected Integer resource_id;
	/**eiid*/
	protected String eiid;

	/**
	 * resource_id取得
	 *
	 * @return resource_id resource_id
	 */
	
	public Integer getResource_id() {
		return resource_id;
	}

	/**
	 * resource_id设定
	 *
	 * @param resource_id resource_id
	 */
	
	public void setResource_id(Integer resource_id) {
		this.resource_id = resource_id;
	}

	/**
	 * eiid取得
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid设定
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

}
