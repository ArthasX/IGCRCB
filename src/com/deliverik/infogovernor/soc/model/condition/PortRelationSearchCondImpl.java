/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * ����: �˵��˹�ϵ���������ʵ��
  * ��������: �˵��˹�ϵ���������ʵ��
  * ������¼: 2013/01/17
  * �޸ļ�¼: 
  */
public class PortRelationSearchCondImpl implements
		PortRelationSearchCond {
	protected String symmetrixid;
	
	protected String eiid;
	
	protected String einame;

	protected String hba;
	
	protected String wwn;
	
	protected boolean flag;

	protected String style;
	
	protected String brpareiid;
	
	protected String tempid;
	
	public String getTempid() {
		return tempid;
	}

	public void setTempid(String tempid) {
		this.tempid = tempid;
	}
	public String getBrpareiid() {
		return brpareiid;
	}

	public void setBrpareiid(String brpareiid) {
		this.brpareiid = brpareiid;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getSymmetrixid() {
		return symmetrixid;
	}

	public void setSymmetrixid(String symmetrixid) {
		this.symmetrixid = symmetrixid;
	}

	public String getHba() {
		return hba;
	}

	public void setHba(String hba) {
		this.hba = hba;
	}

	public String getWwn() {
		return wwn;
	}

	public void setWwn(String wwn) {
		this.wwn = wwn;
	}
}