/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;



/**
 * ����:���д����˵ı��¹�����ѯ 
 * �������������д����˵ı��¹�����ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-04-19
 * �޸ļ�¼��
 */
@Entity
public class CurrentMonthWorkVW implements CurrentMonthWorkVWInfo{

	@Id
    protected Integer prid;
	
	/**
	 * ���̼�¼����
	 */
	protected String prtype;	
	
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
	 * ���̼�¼����ʱ��
	 */
	protected String propentime;
	
	/**
	 * ���̼�¼�ر�ʱ��
	 */
	protected String prclosetime;
		
	/**
	 * ���̼�¼�����̶�
	 */
	protected String prurgency;
	
	/**
	 * ���̼�¼Ӱ��̶�
	 */
	protected String primpact;
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
	protected String prpdid;
	
	/**
	 * ���̼�¼������������
	 */
	protected String prpdname;
	
	
	/**
	 * ���̼�¼������
	 */
	protected String prserialnum;
		
	/**
	 * �����߽�ɫid
	 */
	protected String pproleid;
	
	/**
	 * �����˺ϲ����û�����
	 */
	protected String ppusername;
	
	/**
	 * �����˺ϲ���Ľ�ɫ��
	 */
	protected String pprolename;
	
	/**
	 * �����˺ϲ�����û�id
	 */
	protected String ppuserid;
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
	 * ���̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̼�¼��������ID�趨
	 * @param prpdid ���̼�¼��������ID
	 */
	public void setPrpdid(String prpdid) {
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
	 * �����߽�ɫidȡ��
	 * @return �����߽�ɫid
	 */
	public String getPproleid() {
		return pproleid;
	}

	/**
	 * �����߽�ɫid�趨
	 * @param pproleid �����߽�ɫid
	 */
	public void setPproleid(String pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * �����������趨
	 * @param ppusername ����������
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * �����˺ϲ���Ľ�ɫ��ȡ��
	 * @return �����˺ϲ���Ľ�ɫ��
	 */
	public String getPprolename() {
		return pprolename;
	}

	/**
	 * �����˺ϲ���Ľ�ɫ���趨
	 * @param pprolename �����˺ϲ���Ľ�ɫ��
	 */
	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	/**
	 * �����˺ϲ�����û�idȡ��
	 * @return �����˺ϲ�����û�id
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * �����˺ϲ�����û�id�趨
	 * @param ppuserid �����˺ϲ�����û�id
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	
	
}
