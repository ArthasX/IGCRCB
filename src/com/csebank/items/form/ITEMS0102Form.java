/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.csebank.items.model.ItemsCategory;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0102Form extends BaseForm implements ItemsCategory {

	private static final long serialVersionUID = 1L;

	protected Integer icid;
	protected String category;
	protected String seqcode;
	protected String typecode;
	protected String type;
	protected String desc;
	protected String status;
	
	public Integer getIcid() {
		return icid;
	}
	public void setIcid(Integer icid) {
		this.icid = icid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
