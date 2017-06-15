package com.deliverik.infogovernor.soc.model.condition;


/**
 * 风险检查信息查询条件实现
 * 
 */
public class IgTestSearchCondImpl implements IgTestSearchCond {

	protected Integer id;


	protected String xmlvalue;
	

	protected String attkey;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getXmlvalue() {
		return xmlvalue;
	}


	public void setXmlvalue(String xmlvalue) {
		this.xmlvalue = xmlvalue;
	}


	public String getAttkey() {
		return attkey;
	}


	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}
	
	
}
