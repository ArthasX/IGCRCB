/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.RiskCheck;

/**
 * ���ռ��ʵ��
 * @author lipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskCheck")
public class RiskCheckTB extends BaseEntity implements Serializable, Cloneable, RiskCheck {

	/** ���ռ��ID */
	@Id
	@TableGenerator(
		    name="RISKCHECK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKCHECK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKCHECK_TABLE_GENERATOR")
	protected Integer rcid;

	/** ���ռ������ */
	protected String rcname;
	
	/** ���ռ������ */
	protected String rcdesc;
	
	/** ���ռ����Ҫ�� */
	protected String rctype;
	
	/** ���ռ��״̬ */
	protected String rcstatus;
	
	/** ���ռ����ʼ���� */
	protected String rcstartdate;
	
	/** ���ռ��������� */
	protected String rcenddate;
	
	/** ���ռ��Ƶ�� */
	protected String rcfrequency;
	
	/** ���ռ��Ƶ������ */
	protected String rcfrequencydesc;
	
	/** ���ռ��������ID */
	protected String rcuserid;
	
	/** ���ռ������������ */
	protected String rcusername;
	
	/** ���ռ���������ɫID */
	protected Integer rcroleid;
	
	/** ���ռ���������ɫ�� */
	protected String rcrolename;
	
	/** ���ռ������ʲ�id */
	protected Integer rcasset;
	
	/** ���ռ������ʲ����� */
	protected String rcassetname;
	
	/** ���ռ������ʲ��汾��*/
	protected Integer rcassetversion; 
	
	/** ���ռ�鸽��ID */
	protected String rcattch;

	/** ���ռ��ѡ�� */
	protected String rcoption;
	
	/** ���ռ�����ִ�б��ʽ */
	protected String rccron;
	
	/** ���ռ������� */
	protected String rccategory;
	
	/** ���ռ����������� */
	protected String rccategoryname;
	
	/** ���ռ��Ǽ�ʱ�� */
	protected String rccreatetime;
	
	/** ���ռ������ʱ�� */
	protected String rcapprovetime;
	
	/** ���ռ�������� */
	protected String rcapprover;
	
	/** ���ռ��Ƶ��(ÿ�����һ��) */
	protected String rcfrequencymonthlastday;
	
	/** ����ʱ�� */
	protected String rcupdatetime;

	/** ���ռ������ */
	protected String rcclass;
	
	/** ���ռ�鷽�� */
	protected String rccommon;
	/** ��鷽ʽ  */
	protected String rcrtestmode;
	/** ����ִ����  */
	protected String cog;
	/** ����ִ����  */
	protected String ciiop;
	/** ����ִ����ID  */
	protected String cogid;
	/** ����ִ����ID  */
	protected String ciiopid;
	/** ����ִ������  */
	protected Integer wtip;
	
	public String getCog() {
		return cog;
	}

	public void setCog(String cog) {
		this.cog = cog;
	}
	/**
	 * ����ִ����IDȡ��
	 * @return ����ִ����ID
	 */
	public String getCogid() {
		return cogid;
	}

	public void setCogid(String cogid) {
		this.cogid = cogid;
	}
	/**
	 * ����ִ����IDȡ��
	 * @return ����ִ����ID
	 */
	public String getCiiopid() {
		return ciiopid;
	}

	public void setCiiopid(String ciiopid) {
		this.ciiopid = ciiopid;
	}

	public String getCiiop() {
		return ciiop;
	}

	public void setCiiop(String ciiop) {
		this.ciiop = ciiop;
	}

	public Integer getWtip() {
		return wtip;
	}

	public void setWtip(Integer wtip) {
		this.wtip = wtip;
	}
	/**
	 * ���ռ�鷽ʽȡ��
	 * @return ���ռ�鷽ʽ
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 *���ռ�鷽ʽ�趨
	 * @param rcrtestmode ���ռ�鷽ʽ
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return rcid;
	}
	
	
	/**
	 * ���ռ������ʲ�����
	 * @return ���ռ������ʲ�����
	 */
	public String getRcassetname() {
		return rcassetname;
	}


	/**
	 * ���ռ������ʲ������趨
	 *
	 * @param rccron ���ռ������ʲ�����
	 */
	public void setRcassetname(String rcassetname) {
		this.rcassetname = rcassetname;
	}


	/**
	 * ���ռ������ʲ��汾��ȡ��
	 * @return the rcassetversion
	 */
	public Integer getRcassetversion() {
		return rcassetversion;
	}

	/**
	 * ���ռ������ʲ��汾���趨
	 * @param rcassetversion the rcassetversion to set
	 */
	public void setRcassetversion(Integer rcassetversion) {
		this.rcassetversion = rcassetversion;
	}

	/**
	 * ���ռ�����ִ�б��ʽȡ��
	 * @return ���ռ�����ִ�б��ʽ
	 */
	public String getRccron() {
		return rccron;
	}


	/**
	 * ���ռ�����ִ�б��ʽ�趨
	 *
	 * @param rccron ���ռ�����ִ�б��ʽ
	 */
	public void setRccron(String rccron) {
		this.rccron = rccron;
	}


	/**
	 * ���ռ��IDȡ��
	 * @return ���ռ��ID
	 */
	public Integer getRcid() {
		return rcid;
	}
	
	/**
	 * ���ռ��ID�趨
	 *
	 * @param rcid ���ռ��ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ���ռ������ȡ��
	 * @return ���ռ������
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * ���ռ�������趨
	 *
	 * @param rcname ���ռ������
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * ���ռ������ȡ��
	 * @return ���ռ������
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * ���ռ�������趨
	 *
	 * @param rcdesc ���ռ������
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}

	/**
	 * ���ռ����Ҫ��ȡ��
	 * @return ���ռ����Ҫ��
	 */
	public String getRctype() {
		return rctype;
	}
	
	/**
	 * ���ռ����Ҫ���趨
	 *
	 * @param rctype ���ռ����Ҫ��
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * ���ռ��״̬ȡ��
	 * @return ���ռ��״̬
	 */
	public String getRcstatus() {
		return rcstatus;
	}
	
	/**
	 * ���ռ��״̬�趨
	 *
	 * @param rcstatus ���ռ��״̬
	 */
	public void setRcstatus(String rcstatus) {
		this.rcstatus = rcstatus;
	}

	/**
	 * ���ռ����ʼ����ȡ��
	 * @return ���ռ����ʼ����
	 */
	public String getRcstartdate() {
		return rcstartdate;
	}
	
	/**
	 * ���ռ����ʼ�����趨
	 *
	 * @param rcstartdate ���ռ����ʼ����
	 */
	public void setRcstartdate(String rcstartdate) {
		this.rcstartdate = rcstartdate;
	}
	

	/**
	 * ���ռ���������ȡ��
	 * @return ���ռ���������
	 */
	public String getRcenddate() {
		return rcenddate;
	}
	
	/**
	 * ���ռ����������趨
	 *
	 * @param rcenddate ���ռ���������
	 */
	public void setRcenddate(String rcenddate) {
		this.rcenddate = rcenddate;
	}

	/**
	 * ���ռ��Ƶ��ȡ��
	 * @return ���ռ��Ƶ��
	 */
	public String getRcfrequency() {
		return rcfrequency;
	}
	
	/**
	 * ���ռ��Ƶ���趨
	 *
	 * @param rcfrequency ���ռ��Ƶ��
	 */
	public void setRcfrequency(String rcfrequency) {
		this.rcfrequency = rcfrequency;
	}
	
	/**
	 * ���ռ��Ƶ������ȡ��
	 * @return ���ռ��Ƶ������
	 */
	public String getRcfrequencydesc() {
		return rcfrequencydesc;
	}

	/**
	 * ���ռ��Ƶ�������趨
	 *
	 * @param rcfrequencydesc ���ռ��Ƶ������
	 */
	public void setRcfrequencydesc(String rcfrequencydesc) {
		this.rcfrequencydesc = rcfrequencydesc;
	}

	/**
	 * ���ռ��������IDȡ��
	 * @return ���ռ��������ID
	 */
	public String getRcuserid() {
		return rcuserid;
	}
	
	/**
	 * ���ռ��������ID�趨
	 *
	 * @param rcuserid ���ռ��������ID
	 */
	public void setRcuserid(String rcuserid) {
		this.rcuserid = rcuserid;
	}

	/**
	 * ���ռ������������ȡ��
	 * @return ���ռ������������
	 */
	public String getRcusername() {
		return rcusername;
	}
	
	/**
	 * ���ռ�������������趨
	 *
	 * @param rcusername ���ռ������������
	 */
	public void setRcusername(String rcusername) {
		this.rcusername = rcusername;
	}

	/**
	 * ���ռ���������ɫIDȡ��
	 * @return ���ռ���������ɫID
	 */
	public Integer getRcroleid() {
		return rcroleid;
	}
	
	/**
	 * ���ռ���������ɫID�趨
	 *
	 * @param rcroleid ���ռ���������ɫID
	 */
	public void setRcroleid(Integer rcroleid) {
		this.rcroleid = rcroleid;
	}

	/**
	 * ���ռ���������ɫ��ȡ��
	 * @return ���ռ���������ɫ��
	 */
	public String getRcrolename() {
		return rcrolename;
	}
	
	/**
	 * ���ռ���������ɫ���趨
	 *
	 * @param rcrolename ���ռ���������ɫ��
	 */
	public void setRcrolename(String rcrolename) {
		this.rcrolename = rcrolename;
	}

	/**
	 * ���ռ������ʲ�ȡ��
	 * @return ���ռ������ʲ�
	 */
	public Integer getRcasset() {
		return rcasset;
	}
	
	/**
	 * ���ռ������ʲ��趨
	 *
	 * @param rcasset ���ռ������ʲ�
	 */
	public void setRcasset(Integer rcasset) {
		this.rcasset = rcasset;
	}

	/**
	 * ���ռ�鸽��IDȡ��
	 * @return ���ռ�鸽��ID
	 */
	public String getRcattch() {
		return rcattch;
	}
	
	/**
	 * ���ռ�鸽��ID�趨
	 *
	 * @param rcattch ���ռ�鸽��ID
	 */
	public void setRcattch(String rcattch) {
		this.rcattch = rcattch;
	}

	/**
	 * ���ռ��ѡ��ȡ��
	 * @return ���ռ��ѡ��
	 */
	public String getRcoption() {
		return rcoption;
	}
	
	/**
	 * ���ռ��ѡ���趨
	 *
	 * @param rcoption ���ռ��ѡ��
	 */
	public void setRcoption(String rcoption) {
		this.rcoption = rcoption;
	}

	/**
	 * ���ռ�������ȡ��
	 * @return ���ռ�������
	 */
	public String getRccategory() {
		return rccategory;
	}

	/**
	 * ���ռ��������趨
	 *
	 * @param rccategory ���ռ�������
	 */
	public void setRccategory(String rccategory) {
		this.rccategory = rccategory;
	}

	/**
	 * ���ռ�����������ȡ��
	 * @return ���ռ�����������
	 */
	public String getRccategoryname() {
		return rccategoryname;
	}

	/**
	 * ���ռ������������趨
	 *
	 * @param rccategoryname ���ռ�����������
	 */
	public void setRccategoryname(String rccategoryname) {
		this.rccategoryname = rccategoryname;
	}
	
	/**
	 * ���ռ��Ǽ�ʱ��ȡ��
	 * @return ���ռ��Ǽ�ʱ��
	 */
	public String getRccreatetime() {
		return rccreatetime;
	}

	/**
	 * ���ռ��Ǽ�ʱ���趨
	 *
	 * @param rccreatetime ���ռ��Ǽ�ʱ��
	 */
	public void setRccreatetime(String rccreatetime) {
		this.rccreatetime = rccreatetime;
	}

	/**
	 * ���ռ������ʱ��ȡ��
	 * @return ���ռ������ʱ��
	 */
	public String getRcapprovetime() {
		return rcapprovetime;
	}

	/**
	 * ���ռ������ʱ���趨
	 *
	 * @param rcapprovetime ���ռ������ʱ��
	 */
	public void setRcapprovetime(String rcapprovetime) {
		this.rcapprovetime = rcapprovetime;
	}

	/**
	 * ���ռ��������ȡ��
	 * @return ���ռ��������
	 */
	public String getRcapprover() {
		return rcapprover;
	}

	/**
	 * ���ռ���������趨
	 *
	 * @param rcapprover ���ռ��������
	 */
	public void setRcapprover(String rcapprover) {
		this.rcapprover = rcapprover;
	}

	/**
	 * ���ռ��Ƶ��(ÿ�����һ��)ȡ��
	 * @return ���ռ��Ƶ��(ÿ�����һ��)
	 */
	public String getRcfrequencymonthlastday() {
		return rcfrequencymonthlastday;
	}

	/**
	 * ���ռ��Ƶ��(ÿ�����һ��)�趨
	 *
	 * @param rcfrequencymonthlastday ���ռ��Ƶ��(ÿ�����һ��)
	 */
	public void setRcfrequencymonthlastday(String rcfrequencymonthlastday) {
		this.rcfrequencymonthlastday = rcfrequencymonthlastday;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getRcupdatetime() {
		return rcupdatetime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param rcupdatetime ����ʱ��
	 */
	public void setRcupdatetime(String rcupdatetime) {
		this.rcupdatetime = rcupdatetime;
	}


	public String getRcclass() {
		return rcclass;
	}


	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}


	public String getRccommon() {
		return rccommon;
	}


	public void setRccommon(String rccommon) {
		this.rccommon = rccommon;
	}

}
