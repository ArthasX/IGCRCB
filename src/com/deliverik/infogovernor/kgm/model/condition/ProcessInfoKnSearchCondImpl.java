/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.kgm.model.condition;


/**
 * @Description: 知识管理查询
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
public class ProcessInfoKnSearchCondImpl implements ProcessInfoKnSearchCond {

	protected Integer prkid;
	
	protected String pikvarname;
	
	protected String pikvartype;
	
	protected String pikvarlable;
	
	protected String pikvarvalue;
	

	public Integer getPrkid() {
		return prkid;
	}

	public String getPikvarname() {
		return pikvarname;
	}

	public void setPrkid(Integer prkid) {
		this.prkid = prkid;
	}

	public void setPikvarname(String pikvarname) {
		this.pikvarname = pikvarname;
	}

	public String getPikvartype() {
		return pikvartype;
	}

	public void setPikvartype(String pikvartype) {
		this.pikvartype = pikvartype;
	}

	public String getPikvarlable() {
		return pikvarlable;
	}

	public void setPikvarlable(String pikvarlable) {
		this.pikvarlable = pikvarlable;
	}

	public String getPikvarvalue() {
		return pikvarvalue;
	}

	public void setPikvarvalue(String pikvarvalue) {
		this.pikvarvalue = pikvarvalue;
	}

	


}
