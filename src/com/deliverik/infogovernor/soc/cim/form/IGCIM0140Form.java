package com.deliverik.infogovernor.soc.cim.form;



import com.deliverik.framework.base.BaseForm;

/**
 * 业务系统管理人员缺失查询画面FORM
 * 
 */
public class IGCIM0140Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/**业务系统eiid*/
	private Integer eiid;
	/**业务系统名称*/
	private String	eiName;
	/**业务系统登记人员*/
	private String eiUserName;
	/**业务系统登记日期*/
	private String eiInsDate;
	/**管理员A*/
	private String magea;
	/**管理员B*/
	private String mageb;
	
	private String edate;
	private String sdate;
	
	
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	public String getEiName() {
		return eiName;
	}
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}
	public String getEiUserName() {
		return eiUserName;
	}
	public void setEiUserName(String eiUserName) {
		this.eiUserName = eiUserName;
	}
	public String getEiInsDate() {
		return eiInsDate;
	}
	public void setEiInsDate(String eiInsDate) {
		this.eiInsDate = eiInsDate;
	}
	public String getMagea() {
		return magea;
	}
	public void setMagea(String magea) {
		this.magea = magea;
	}
	public String getMageb() {
		return mageb;
	}
	public void setMageb(String mageb) {
		this.mageb = mageb;
	}
	
	
	
}
