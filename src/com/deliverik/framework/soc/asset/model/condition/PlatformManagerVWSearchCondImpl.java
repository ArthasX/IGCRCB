/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: ҵ��ϵͳ����Աȱʧ��ͼ��������ʵ��
  * ��������: ҵ��ϵͳ����Աȱʧ��ͼ��������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class PlatformManagerVWSearchCondImpl implements
PlatformManagerVWSearchCond {
	
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
	
	
	
	
}