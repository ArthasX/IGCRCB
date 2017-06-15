/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.csebank.items.model.condition.ItemsCategorySearchCond;
import com.deliverik.framework.base.BaseForm;

public class ITEMS0101Form extends BaseForm implements ItemsCategorySearchCond {

	private static final long serialVersionUID = 1L;

	protected String category;
	protected String typecode;
	protected String status;
	protected String seqcode;
	protected String path;
	protected Integer icid;
	
	public Integer getIcid() {
		return icid;
	}
	public void setIcid(Integer icid) {
		this.icid = icid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	
}
