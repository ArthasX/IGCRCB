package com.deliverik.infogovernor.fin.model.condition;

/**
 * 
 */
public class BudgetSearchCondImpl implements BudgetSearchCond {

	protected String btype;

	protected String bstatus;

	protected String binittime;

	protected String bopentime;

	protected String bclosetime;

	protected String btitle;

	protected String pcode;

	protected String bstatus_q;// 查询用

	protected String pquality;//项目性质
	
	protected String pcategory;//项目类别

	protected String pstorecode;// 储备项目编号

	protected String pneeddispart;// 需求部门

	protected String pbuggetform;// 预算组成

	protected String remark;// 备注

	protected String btitle_q;
	
	protected String byear_q;
	
	protected String btype_q;
	
	protected String byear_before;//前年的年份
	
	protected String byear_now;//今年的年份
	
	/**
	 * 今年的年份取得
	 * 
	 * @return byear_now
	 */
	public String getByear_now() {
		return byear_now;
	}
	/**
	 * 今年的年份设定
	 * 
	 * @return byear_now
	 */
	public void setByear_now(String byear_now) {
		this.byear_now = byear_now;
	}
	/**
	 * 前年的年份取得
	 * 
	 * @return byear_before
	 */
	public String getByear_before() {
		return byear_before;
	}
	/**
	 * 前年的年份设定
	 * 
	 * @param byear_before
	 */
	public void setByear_before(String byear_before) {
		this.byear_before = byear_before;
	}

	public String getBtitle_q() {
		return btitle_q;
	}

	public void setBtitle_q(String btitle_q) {
		this.btitle_q = btitle_q;
	}

	public String getByear_q() {
		return byear_q;
	}

	public void setByear_q(String byear_q) {
		this.byear_q = byear_q;
	}

	public String getBtype_q() {
		return btype_q;
	}

	public void setBtype_q(String btype_q) {
		this.btype_q = btype_q;
	}

	public String getPquality() {
		return pquality;
	}

	public void setPquality(String pquality) {
		this.pquality = pquality;
	}

	public String getPcategory() {
		return pcategory;
	}

	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}

	public String getPstorecode() {
		return pstorecode;
	}

	public void setPstorecode(String pstorecode) {
		this.pstorecode = pstorecode;
	}

	public String getPneeddispart() {
		return pneeddispart;
	}

	public void setPneeddispart(String pneeddispart) {
		this.pneeddispart = pneeddispart;
	}

	public String getPbuggetform() {
		return pbuggetform;
	}

	public void setPbuggetform(String pbuggetform) {
		this.pbuggetform = pbuggetform;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getBstatus_q() {
		return bstatus_q;
	}

	public void setBstatus_q(String bstatus_q) {
		this.bstatus_q = bstatus_q;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBstatus() {
		return bstatus;
	}

	public void setBstatus(String bstatus) {
		this.bstatus = bstatus;
	}

	public String getBinittime() {
		return binittime;
	}

	public void setBinittime(String binittime) {
		this.binittime = binittime;
	}

	public String getBopentime() {
		return bopentime;
	}

	public void setBopentime(String bopentime) {
		this.bopentime = bopentime;
	}

	public String getBclosetime() {
		return bclosetime;
	}

	public void setBclosetime(String bclosetime) {
		this.bclosetime = bclosetime;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getSelectMode() {

		return null;
	}

}
