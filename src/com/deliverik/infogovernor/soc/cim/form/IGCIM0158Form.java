package com.deliverik.infogovernor.soc.cim.form;



import com.deliverik.framework.base.BaseForm;

/**
 * 相关流程FORM
 * 
 */
public class IGCIM0158Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	protected String eiid;

	/** 查询类型		0：相关流程	1：相关维修记录*/
	protected String type;
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

	/**
	 * 查询类型0：相关流程1：相关维修记录取得
	 * @return type 查询类型0：相关流程1：相关维修记录
	 */
	public String getType() {
		return type;
	}

	/**
	 * 查询类型0：相关流程1：相关维修记录设定
	 * @param type 查询类型0：相关流程1：相关维修记录
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}
