package com.deliverik.infogovernor.fin.model.condition;

/**
 * 
 */
public class ExpenseSearchCondImpl implements ExpenseSearchCond {

	protected String exdesc;
	
	protected String exstatus;
	
	protected String exopentime;
	
	protected String exclosetime;
	
	protected Integer bid;
	
	protected String btitle;
	
	
	
	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public Double getExamount() {
		return examount;
	}

	public void setExamount(Double examount) {
		this.examount = examount;
	}

	protected Double examount;
	


	public String getExapvname() {
		return exapvname;
	}

	public void setExapvname(String exapvname) {
		this.exapvname = exapvname;
	}

	protected String exapvname;

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getExstatus() {
		return exstatus;
	}

	public void setExstatus(String exstatus) {
		this.exstatus = exstatus;
	}

	public String getExopentime() {
		return exopentime;
	}

	public void setExopentime(String exopentime) {
		this.exopentime = exopentime;
	}

	public String getExclosetime() {
		return exclosetime;
	}

	public void setExclosetime(String exclosetime) {
		this.exclosetime = exclosetime;
	}

	public String getExdesc() {
		return exdesc;
	}

	public void setExdesc(String exdesc) {
		this.exdesc = exdesc;
	}

	public Integer getBid() {
		return bid;
	}

}
