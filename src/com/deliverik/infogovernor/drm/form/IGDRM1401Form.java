/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;

/**
 * Title : InfoGovernor 信息服务管理平台
 * Description: 系统管理_通知管理_查询删除Form
 * 
 */

@SuppressWarnings("serial")
public class IGDRM1401Form extends BaseForm implements NoticeSearchCond {

	protected String nname;
	
	protected String ntime;//portal页滚动显示通知用,时间

	protected String ntime_from;

	protected String ntime_to;

	protected String[] deleteNid;
	protected String nid;
	public String date;
	public String userid;
	/**应急管理专用*/
	public String fingerprint;
	
	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public String getNtime_from() {
		return ntime_from;
	}

	public void setNtime_from(String ntime_from) {
		this.ntime_from = ntime_from;
	}

	public String getNtime_to() {
		return ntime_to;
	}

	public void setNtime_to(String ntime_to) {
		this.ntime_to = ntime_to;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the ntime
	 */
	public String getNtime() {
		return ntime;
	}

	/**
	 * @param ntime the ntime to set
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	/**
	 * @return the deleteNid
	 */
	public String[] getDeleteNid() {
		return deleteNid;
	}

	/**
	 * @param deleteNid the deleteNid to set
	 */
	public void setDeleteNid(String[] deleteNid) {
		this.deleteNid = deleteNid;
	}

	/**
	 * @return the fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}

	/**
	 * @param fingerprint the fingerprint to set
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public String getPagetype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTuserid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTroleid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getTroleids() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
