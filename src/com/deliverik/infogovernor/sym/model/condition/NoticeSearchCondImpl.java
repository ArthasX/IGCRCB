package com.deliverik.infogovernor.sym.model.condition;

/**
 * 
 */
public class NoticeSearchCondImpl implements NoticeSearchCond {

	public String nname;

	public String ntime_from;
	
	public String ntime_to;
	public String nid;
	public String date;
	public String userid;
	
	public String pagetype;
	
	public String tuserid;
	
	public String troleid;
	public String[] troleids;
	/**fingerprint*/
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
	public String getPagetype() {
		return pagetype;
	}

	public void setPagetype(String pagetype) {
		this.pagetype = pagetype;
	}

	public String getTuserid() {
		return tuserid;
	}

	public void setTuserid(String tuserid) {
		this.tuserid = tuserid;
	}

	public String getTroleid() {
		return troleid;
	}

	public void setTroleid(String troleid) {
		this.troleid = troleid;
	}

	/**
	 * troleids取得
	 * @return troleids  troleids
	 */
	public String[] getTroleids() {
		return troleids;
	}

	/**
	 * troleids设定
	 * @param troleids  troleids
	 */
	public void setTroleids(String[] troleids) {
		this.troleids = troleids;
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

}
