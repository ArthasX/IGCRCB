/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 阜新拓扑，应用详细FORM
 * 功能描述: 阜新拓扑，应用详细FORM
 * 创建记录: 2013/10/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM0151Form extends BaseForm {

	/** 资产ID */
	protected String eiid;

	/** 资产模型ID */
	protected String eid;
	
	/** 资产属性版本号 */
	protected String civersion;
	
	/** 资产模型属性ID */
	protected String cid;
	
	/** 资产模型属性值 */
	protected String civalue;

	/** 资产属性小版本号*/
	protected String cismallversion;

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getCiversion() {
		return civersion;
	}

	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	public String getCismallversion() {
		return cismallversion;
	}

	public void setCismallversion(String cismallversion) {
		this.cismallversion = cismallversion;
	}
}
