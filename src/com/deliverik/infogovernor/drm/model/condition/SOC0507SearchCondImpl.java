/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: Ԥ����Ϣ���������ʵ��
  * ��������: Ԥ����Ϣ���������ʵ��
  * ������¼: 2016/07/15
  * �޸ļ�¼: 
  */
public class SOC0507SearchCondImpl implements
		SOC0507SearchCond {

	private String cid;
	private String eid;
	private Integer eiid;
	private String esyscoding;

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getCid() {
		return cid;
	}

	public String getEid() {
		return eid;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

}