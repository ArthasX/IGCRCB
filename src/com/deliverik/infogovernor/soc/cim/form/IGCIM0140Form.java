package com.deliverik.infogovernor.soc.cim.form;



import com.deliverik.framework.base.BaseForm;

/**
 * ҵ��ϵͳ������Աȱʧ��ѯ����FORM
 * 
 */
public class IGCIM0140Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/**ҵ��ϵͳeiid*/
	private Integer eiid;
	/**ҵ��ϵͳ����*/
	private String	eiName;
	/**ҵ��ϵͳ�Ǽ���Ա*/
	private String eiUserName;
	/**ҵ��ϵͳ�Ǽ�����*/
	private String eiInsDate;
	/**����ԱA*/
	private String magea;
	/**����ԱB*/
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
