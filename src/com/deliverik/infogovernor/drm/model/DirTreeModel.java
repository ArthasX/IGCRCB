package com.deliverik.infogovernor.drm.model;

import java.util.List;

/**
 * 预案章节目录模型
 * @author Yhb
 *
 */
public class DirTreeModel {
	private String cid;
	private String pcid;
	private String eid;
	private String cname;
	private String cstatus;
	private String cseq;
	private String cattach;
	private String esyscoding;
	private String corder;
	private List<DirTreeModel> childDirTreeModel;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPcid() {
		return pcid;
	}
	public void setPcid(String pcid) {
		this.pcid = pcid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}
	public String getCseq() {
		return cseq;
	}
	public void setCseq(String cseq) {
		this.cseq = cseq;
	}
	public String getCattach() {
		return cattach;
	}
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getCorder() {
		return corder;
	}
	public void setCorder(String corder) {
		this.corder = corder;
	}
	public List<DirTreeModel> getChildDirTreeModel() {
		return childDirTreeModel;
	}
	public void setChildDirTreeModel(List<DirTreeModel> childDirTreeModel) {
		this.childDirTreeModel = childDirTreeModel;
	}
}
