/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.workflow.prd.model.IG567Info;


/**
 * ����:�����������ʵ��
 * ���������������������ʵ��
 *           
 * ������¼���κ���    2010/11/26
 */
@SuppressWarnings("serial")
@Entity
public class IG567VW implements Serializable, Cloneable,IG567Info {
	
	/**
	 * ���̼�¼ID
	 */
	@Id
	protected Integer prid;
	
	/**
	 * ���̼�¼����
	 */
	protected String prtype;
	
	/**
	 * ���̼�¼������
	 */
	protected String prsubtype;
	
	/**
	 * ���̼�¼״̬
	 */
	protected String prstatus;
	
	/**
	 * ���̼�¼״̬��״̬
	 */
	protected String prsubstatus;
	
	/**
	 * ���̼�¼��Ŀ
	 */
	protected String prtitle;
	
	/**
	 * ���̼�¼����
	 */
	protected String prdesc;
	
	/**
	 * ���̼�¼����ʱ��
	 */
	protected String propentime;
	
	/**
	 * ���̼�¼�ر�ʱ��
	 */
	protected String prclosetime;
	
	/**
	 * ���̼�¼�ƻ�ִ��ʱ��
	 */
	protected String prplantime;
	
	/**
	 * ���̼�¼�ƻ�ִ������
	 */
	protected String prduration;
	
	/**
	 * ���̼�¼�����̶�
	 */
	protected String prurgency;
	
	/**
	 * ���̼�¼Ӱ��̶�
	 */
	protected String primpact;
	
	/**
	 * ���̼�¼����ʲ�ID
	 */
	protected Integer prassetid;
	
	/**
	 * ���̼�¼����ʲ�����
	 */
	protected String prassetname;
	
	/**
	 * ���̼�¼�����ҵ��
	 */
	protected String prbusiness;
	
	/**
	 * ���̼�¼ִ�мƻ�
	 */
	protected String primplplan;
	
	/**
	 * ���̼�¼�ָ��ƻ�
	 */
	protected String prbackplan;
	
	/**
	 * ���̼�¼��֤�ƻ�
	 */
	protected String prvfyplan;
	
	/**
	 * ���̼�¼�����ĿID
	 */
	protected Integer pid;
	
	/**
	 * ���̼�¼�����Ŀ���
	 */
	protected String pcode;
	
	/**
	 * ���̼�¼�����Ŀ����
	 */
	protected String pname;
	
	/**
	 * ���̼�¼��������ϵ��ʽ
	 */
	protected String prinfo;
	
	/**
	 * ���̼�¼�������ID
	 */
	protected Integer prcorid;
	
	/**
	 * ���̼�¼�����������
	 */
	protected String prcortype;
	
	/**
	 * ���̼�¼�����������
	 */
	protected String prcortitle;
	
	/**
	 * ���̼�¼����ʲ�����
	 */
	protected String prassetcategory;
	
	/**
	 * ���̼�¼�������û�ID
	 */
	protected String pruserid;
	
	/**
	 * ���̼�¼�������û�����
	 */
	protected String prusername;
	
	/**
	 * ���̼�¼�����߽�ɫID
	 */
	protected Integer prroleid;
	
	/**
	 * ���̼�¼�����߽�ɫ����
	 */
	protected String prrolename;
	
	/**
	 * ���̼�¼��������ID
	 */
	protected Integer prpdid;
	
	/**
	 * ���̼�¼������������
	 */
	protected String prpdname;
	
	/**
	 * ���̼�¼�������������������
	 */
	protected String prorgid;
	
	/**
	 * ���̼�¼������������������
	 */
	protected String prorgname;
	
	/**
	 * ���̼�¼������
	 */
	protected String prserialnum;
	
	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ��������
	 */
	protected Integer prfacttime;
	
	/**
	 * �Զ���������ʱԾǨ����
	 */
	protected String prptdcond;
	
	/** ����ʵ�� */
	@OneToOne
	@JoinColumn(name="prorgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	/**
	 * �������������
	 */
	protected Integer paid;

	/**
	 *�������������ȡ��
	 * 
	 * @return �������������
	 */
	public Integer getPaid() {
		return paid;
	}

	/**
	 *��������������趨
	 * 
	 * @param paid �������������
	 */
	public void setPaid(Integer paid) {
		this.paid = paid;
	}
	
	/**
	 * �����Ƿ��������
	 */
	protected String assessmentstatus;

	/**
	 * ���ܣ����������ȡ��
	 * @return  ���������
	 */
	public String getAssessmentstatus() {
		return assessmentstatus;
	}
	
	/**
	 * ���ܣ�����������趨
	 * @param assessmentstatus ���������
	 */
	public void setAssessmentstatus(String assessmentstatus) {
		this.assessmentstatus = assessmentstatus;
	}
	
	/**
	 * ����ȡ��
	 * @return ����ʵ��
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * ����ʵ���趨
	 * @param organizationTB ������Ϣ
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	
	/**
	 * ����ȡ��
	 * @return piid
	 */
	public Serializable getPK() {
		return prid;
	}

	/**
	 * ���̼�¼IDȡ��
	 * @return���̼�¼ID
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
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���̼�¼�����趨
	 * @param prtype ���̼�¼����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrsubtype() {
		return prsubtype;
	}

	/**
	 * ���̼�¼�������趨
	 * @param prsubtype ���̼�¼������
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	/**
	 * ���̼�¼״̬ȡ��
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���̼�¼״̬�趨
	 * @param prstatus ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * ���̼�¼״̬��״̬�趨
	 * @param prsubstatus ���̼�¼״̬��״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * ���̼�¼��Ŀȡ��
	 * @return ���̼�¼��Ŀ
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���̼�¼��Ŀ�趨
	 * @param prtitle ���̼�¼��Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���̼�¼�����趨
	 * @param prdesc ���̼�¼����
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ���̼�¼����ʱ��ȡ��
	 * @return ���̼�¼����ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���̼�¼����ʱ���趨
	 * @param propentime ���̼�¼����ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 * @return ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���̼�¼�ر�ʱ���趨
	 * @param prclosetime ���̼�¼�ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ���趨
	 * @param prplantime ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * ���̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * ���̼�¼�ƻ�ִ�������趨
	 * @param prduration ���̼�¼�ƻ�ִ������
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * ���̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���̼�¼�����̶��趨
	 * @param prurgency ���̼�¼�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * ���̼�¼Ӱ��̶�ȡ��
	 * @return ���̼�¼Ӱ��̶�
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * ���̼�¼Ӱ��̶��趨
	 * @param primpact ���̼�¼Ӱ��̶�
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	/**
	 * ���̼�¼����ʲ�IDȡ��
	 * @return ���̼�¼����ʲ�ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * ���̼�¼����ʲ�ID�趨
	 * @param prassetid ���̼�¼����ʲ�ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * ���̼�¼����ʲ������趨
	 * @param prassetname ���̼�¼����ʲ�����
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * ���̼�¼�����ҵ��ȡ��
	 * @return ���̼�¼�����ҵ��
	 */
	public String getPrbusiness() {
		return prbusiness;
	}

	/**
	 * ���̼�¼�����ҵ���趨
	 * @param prbusiness ���̼�¼�����ҵ��
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	/**
	 * ���̼�¼ִ�мƻ�ȡ��
	 * @return ���̼�¼ִ�мƻ�
	 */
	public String getPrimplplan() {
		return primplplan;
	}

	/**
	 * ���̼�¼ִ�мƻ��趨
	 * @param primplplan ���̼�¼ִ�мƻ�
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	/**
	 * ���̼�¼�ָ��ƻ�ȡ��
	 * @return ���̼�¼�ָ��ƻ�
	 */
	public String getPrbackplan() {
		return prbackplan;
	}

	/**
	 * ���̼�¼�ָ��ƻ��趨
	 * @param prbackplan ���̼�¼�ָ��ƻ�
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	/**
	 * ���̼�¼��֤�ƻ�ȡ��
	 * @return ���̼�¼��֤�ƻ�
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}

	/**
	 * ���̼�¼��֤�ƻ��趨
	 * @param prvfyplan ���̼�¼��֤�ƻ�
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}
	
	/**
	 * ���̼�¼�����ĿIDȡ��
	 * @return ���̼�¼�����ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ���̼�¼�����ĿID�趨
	 * @param pid ���̼�¼�����ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ���̼�¼�����Ŀ���ȡ��
	 * @return ���̼�¼�����Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ���̼�¼�����Ŀ����趨
	 * @param pcode ���̼�¼�����Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ���̼�¼�����Ŀ����ȡ��
	 * @return ���̼�¼�����Ŀ����
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * ���̼�¼�����Ŀ�����趨
	 * @param pname ���̼�¼�����Ŀ����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	/**
	 * ���̼�¼��������ϵ��ʽȡ��
	 * @return ���̼�¼��������ϵ��ʽ
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * ���̼�¼��������ϵ��ʽ�趨
	 * @param prinfo ���̼�¼��������ϵ��ʽ
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * ���̼�¼�������IDȡ��
	 * @return ���̼�¼�������ID
	 */
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * ���̼�¼�������ID�趨
	 * @param prcorid ���̼�¼�������ID
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	/**
	 * ���̼�¼�����������ȡ��
	 * @return ���̼�¼�����������
	 */
	public String getPrcortype() {
		return prcortype;
	}

	/**
	 * ���̼�¼������������趨
	 * @param prcortype ���̼�¼�����������
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	/**
	 * ���̼�¼�����������ȡ��
	 * @return ���̼�¼�����������
	 */
	public String getPrcortitle() {
		return prcortitle;
	}

	/**
	 * ���̼�¼������������趨
	 * @param prcortitle ���̼�¼�����������
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * ���̼�¼����ʲ������趨
	 * @param prassetcategory ���̼�¼����ʲ�����
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ���̼�¼�������û�����ȡ��
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���̼�¼�������û������趨
	 * @param prusername ���̼�¼�������û�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ���̼�¼�����߽�ɫ����ȡ��
	 * @return ���̼�¼�����߽�ɫ����
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * ���̼�¼�����߽�ɫ�����趨
	 * @param prrolename ���̼�¼�����߽�ɫ����
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * ���̼�¼�������û�IDȡ��
	 * @return ���̼�¼�������û�ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * ���̼�¼�������û�ID�趨
	 * @param pruserid ���̼�¼�������û�ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * ���̼�¼�����߽�ɫIDȡ��
	 * @return ���̼�¼�����߽�ɫID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * ���̼�¼�����߽�ɫID�趨
	 * @param prroleid ���̼�¼�����߽�ɫID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ���̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public Integer getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̼�¼��������ID�趨
	 * @param prpdid ���̼�¼��������ID
	 */
	public void setPrpdid(Integer prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ���̼�¼������������ȡ��
	 * @return ���̼�¼������������
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * ���̼�¼�������������趨
	 * @param prpdname ���̼�¼������������
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * ���̼�¼�������������������ȡ��
	 * @return ���̼�¼�������������������
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * �����̼�¼��������������������趨
	 * @param prorgid ���̼�¼�������������������
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * ���̼�¼������������������ȡ��
	 * @return ���̼�¼������������������
	 */
	public String getProrgname() {
		if(getOrganizationTB() == null) {
			return prorgname;
		} else {
			return getOrganizationTB().getOrgname();
		}
	}

	/**
	 * ���̼�¼�������������������趨
	 * @param prorgname ���̼�¼������������������
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	/**
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���̼�¼�������趨
	 * @param prserialnum ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ��������ȡ��
	 * @return ���̼�¼ʵ�ʽ��ʱ��
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}

	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ���������趨
	 * @param piid ���̼�¼ʵ�ʽ��ʱ��
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	/**
	 * �Զ���������ʱԾǨ����ȡ��
	 * @return �Զ���������ʱԾǨ����
	 */
	public String getPrptdcond() {
		return prptdcond;
	}

	/**
	 * �Զ���������ʱԾǨ�����趨
	 * @param prptdcond �Զ���������ʱԾǨ����
	 */
	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}
}
