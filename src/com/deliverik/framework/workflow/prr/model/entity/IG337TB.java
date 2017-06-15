package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * ���̲����û���Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG337")
public class IG337TB extends BaseEntity implements Serializable, Cloneable, IG337Info {

	/**
	 * ���̲����û���ϢID
	 */
	@Id
	@TableGenerator(
		    name="IG337_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG337_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG337_TABLE_GENERATOR")
	protected Integer ppid;
	
	/**
	 * ���̼�¼ID
	 */
	protected Integer prid;
	
	/**
	 * ���̲����û���ɫID
	 */
	protected Integer pproleid;
	
	/**
	 * ���̲����û��������������
	 */
	protected String pporgid;
	
	/**
	 * ���̲����û�������������
	 */
	protected String pporgname;
	
	/**
	 * ���̲����û���ɫ����
	 */
	protected String pprolename;
	
	/**
	 * ���̲����û�ID
	 */
	protected String ppuserid;
	
	/**
	 * ���̲����û�����
	 */
	protected String ppusername;
	
	/**
	 * ���̲����û��Ĳ�������
	 */
	protected String pptype;
	
	/**
	 * ���̲����û�����Ϣ����ϵ��ʽ�ȣ�
	 */
	protected String ppuserinfo;
	
	/**
	 * ���̲����û��Ĺ�������
	 */
	protected String ppcomment;
	
	/**
	 * ���̲����û��Ĳ���״̬
	 */
	protected String ppstatus;
	
	/**
	 * ��������KEY
	 */
	protected String ppattkey;
	
	/**
	 * ���̲����û�ָ��ʱ��
	 */
	protected String ppinittime;
	
	/**
	 * ���̲����û��������ʱ��
	 */
	protected String ppproctime;
	
	/**
	 * ���̲����û���״̬
	 */
	protected String ppsubstatus;
	
	/**
	 * ���̲����û�ʵ�ʽ��ʱ��
	 */
	protected Integer ppfacttime;
	
	/**
	 * ���̻���ָ��ʱ��
	 */
	protected String ppbacktime;
	
	/**
	 * ����super�����߱�ʶ
	 */
	public String ppsuper;
	
	/**
	 * ���̲����߽�ɫ�����˱�ʶ
	 */
	public String pprolemanager;
	
	/**
	 * ���̲�����ֵ���˱�ʶ
	 */
	public String ppdutyperson;

	/** ����״̬����ID */
	protected String psdid;

	/** ��̬��֧��� */
	protected Integer psdnum;
	
	/**
	 * ���̲��������id
	 */
	public String ppproxyuserid;
	
	/** ��ť����ID */
	public String pbdid;
	
	/**
	 * ����ȡ��
	 * @return ppid
	 */
	public Serializable getPK() {
		return ppid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG337TB))
			return false;
		IG337Info target = (IG337Info) obj;
		if (!(getPpid()==target.getPpid()))
			return false;

		return true;
	}
	
	/**
	 * ���̲����û�������������ȡ��
	 * @return ���̲����û�������������
	 */
	public String getPporgname() {
		return pporgname;
	}

	/**
	 * ���̲����û��������������趨
	 * @param pporgname ���̲����û�������������
	 */
	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}

	

	/**
	 * ���̲����û���ϢIDȡ��
	 * @return ���̲����û���ϢID
	 */
	public Integer getPpid() {
		return ppid;
	}

	/**
	 * ���̲����û���ϢID�趨
	 * @param ppid ���̲����û���ϢID
	 */
	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ���̲����û��������������ȡ��
	 * @return ���̲����û��������������
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * ���̲����û���������������趨
	 * @param pporgid ���̲����û��������������
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * ���̲����û���ɫIDȡ��
	 * @return ���̲����û���ɫID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * ���̲����û���ɫID�趨
	 * @param pproleid ���̲����û���ɫID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * ���̲����û���ɫ����ȡ��
	 * @return ���̲����û���ɫ����
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * ���̲����û���ɫ�����趨
	 * @param pprolename ���̲����û���ɫ����
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	/**
	 * ���̲����û�IDȡ��
	 * @return ���̲����û�ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ���̲����û�ID�趨
	 * @param ppuserid ���̲����û�ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * ���̲����û�����ȡ��
	 * @return ���̲����û�����
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * ���̲����û������趨
	 * @param ppusername ���̲����û�����
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * ���̲����û��Ĳ�������ȡ��
	 * @return ���̲����û��Ĳ�������
	 */
	public String getPptype() {
		return pptype;
	}

	/**
	 * ���̲����û��Ĳ��������趨
	 * @param pptype ���̲����û��Ĳ�������
	 */
	public void setPptype(String pptype) {
		this.pptype = pptype;
	}

	/**
	 * ���̲����û�����Ϣ����ϵ��ʽ�ȣ�ȡ��
	 * @return ���̲����û�����Ϣ����ϵ��ʽ�ȣ�
	 */
	public String getPpuserinfo() {
		return ppuserinfo;
	}

	/**
	 * ���̲����û�����Ϣ����ϵ��ʽ�ȣ��趨
	 * @param ppuserinfo ���̲����û�����Ϣ
	 */
	public void setPpuserinfo(String ppuserinfo) {
		this.ppuserinfo = ppuserinfo;
	}

	/**
	 * ���̲����û��Ĺ�������ȡ��
	 * @return ���̲����û��Ĺ�������
	 */
	public String getPpcomment() {
		return ppcomment;
	}

	/**
	 * ���̲����û��Ĺ��������趨
	 * @param ppcomment ���̲����û��Ĺ�������
	 */
	public void setPpcomment(String ppcomment) {
		this.ppcomment = ppcomment;
	}

	/**
	 * ���̲����û��Ĳ���״̬ȡ��
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**
	 * ���̲����û��Ĳ���״̬�趨
	 * @param ppstatus ���̲����û��Ĳ���״̬
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * ��������KEYȡ��
	 * @return ��������KEY
	 */
	public String getPpattkey() {
		return ppattkey;
	}

	/**
	 * ��������KEY�趨
	 * @param ppattkey ��������KEY
	 */
	public void setPpattkey(String ppattkey) {
		this.ppattkey = ppattkey;
	}

	/**
	 * ���̲����û�ָ��ʱ��ȡ��
	 * @return ���̲����û�ָ��ʱ��
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * ���̲����û�ָ��ʱ���趨
	 * @param ppinittime ���̲����û�ָ��ʱ��
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * ���̲����û��������ʱ��ȡ��
	 * @return ���̲����û��������ʱ��
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * ���̲����û��������ʱ���趨
	 * @param ppproctime ���̲����û��������ʱ��
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}

	/**
	 * ���̲����û���״̬ȡ��
	 * @return ���̲����û���״̬
	 */
	public String getPpsubstatus() {
		return ppsubstatus;
	}

	/**
	 * ���̲����û���״̬�趨
	 * @param ppsubstatus ���̲����û���״̬
	 */
	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	/**
	 * ���̲����û�ʵ�ʽ��ʱ��ȡ��
	 * @return ���̲����û�ʵ�ʽ��ʱ��
	 */
	public Integer getPpfacttime() {
		return ppfacttime;
	}

	/**
	 * ���̲����û�ʵ�ʽ��ʱ���趨
	 * @param ppfacttime ���̲����û�ʵ�ʽ��ʱ��
	 */
	public void setPpfacttime(Integer ppfacttime) {
		this.ppfacttime = ppfacttime;
	}

	/**
	 * ���̻���ָ��ʱ��ȡ��
	 * @return ���̻���ָ��ʱ��
	 */
	public String getPpbacktime() {
		return ppbacktime;
	}

	/**
	 * ���̻���ָ��ʱ���趨
	 * @param ppbacktime ���̻���ָ��ʱ��
	 */
	public void setPpbacktime(String ppbacktime) {
		this.ppbacktime = ppbacktime;
	}
	
	/**
	 * ����super�����߱�ʶȡ��
	 * @return ����super�����߱�ʶ
	 */
	public String getPpsuper() {
		return ppsuper;
	}

	/**
	 * ����super�����߱�ʶ�趨
	 * @param ppsuper����super�����߱�ʶ
	 */
	public void setPpsuper(String ppsuper) {
		this.ppsuper = ppsuper;
	}

	/**
	 * ���̲����߽�ɫ�����˱�ʶȡ��
	 * @return ���̲����߽�ɫ�����˱�ʶ
	 */
	public String getPprolemanager() {
		return pprolemanager;
	}

	/**
	 * ���̲����߽�ɫ�����˱�ʶ�趨
	 * @param pprolemanager���̲����߽�ɫ�����˱�ʶ
	 */
	public void setPprolemanager(String pprolemanager) {
		this.pprolemanager = pprolemanager;
	}

	/**
	 * ���̲�����ֵ���˱�ʶȡ��
	 * @return ���̲�����ֵ���˱�ʶ
	 */
	public String getPpdutyperson() {
		return ppdutyperson;
	}

	/**
	 * ���̲�����ֵ���˱�ʶ�趨
	 * @param ppdutyperson���̲�����ֵ���˱�ʶ
	 */
	public void setPpdutyperson(String ppdutyperson) {
		this.ppdutyperson = ppdutyperson;
	}

	/**
	 * ���̲��������ȡ��
	 * @return ���̲��������
	 */
	public String getPpproxyuserid() {
		return ppproxyuserid;
	}

	/**
	 * ���̲���������趨
	 * @param ppproxyuserid ���̲��������
	 */
	public void setPpproxyuserid(String ppproxyuserid) {
		this.ppproxyuserid = ppproxyuserid;
	}

	/**
	 * ��ť����IDȡ��
	 * 
	 * @return ��ť����ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * ��ť����ID�趨
	 * 
	 * @param pbdid ��ť����ID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬����ID�趨
	 * @param psdid ����״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ��̬��֧����趨
	 * @param psdnum ��̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}
	public UserTB getProxyUserTB() {
		return null;
	}
	
}
