package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.Date;

import com.deliverik.framework.workflow.prr.model.IG677Info;

public class IGCOM04031VO implements Serializable,IG677Info {
	/**
	 * ���̼�¼ID
	 */
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
	protected String prpdid;
	
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
	protected String prfacttime;
	
	
	
	
	/**
	 * ���̲����û���ϢID
	 */
	protected Integer ppid;
	
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
	 * ���̲��԰汾
	 */
	protected Integer prStrategyVersion;
	
	/**
	 * ����״̬�������ʱ��
	 */
	protected Date rslclosetime;
	
	/**
	 * ���̶�̬��֧���
	 */
	protected Integer psdnum;
	
	/**
	 * ����״̬ID
	 */
	protected String psdid;

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPrsubtype() {
		return prsubtype;
	}

	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPrsubstatus() {
		return prsubstatus;
	}

	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPrplantime() {
		return prplantime;
	}

	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	public String getPrduration() {
		return prduration;
	}

	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrimpact() {
		return primpact;
	}

	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	public Integer getPrassetid() {
		return prassetid;
	}

	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	public String getPrassetname() {
		return prassetname;
	}

	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	public String getPrbusiness() {
		return prbusiness;
	}

	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	public String getPrimplplan() {
		return primplplan;
	}

	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	public String getPrbackplan() {
		return prbackplan;
	}

	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	public String getPrvfyplan() {
		return prvfyplan;
	}

	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrinfo() {
		return prinfo;
	}

	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	public Integer getPrcorid() {
		return prcorid;
	}

	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	public String getPrcortype() {
		return prcortype;
	}

	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	public String getPrcortitle() {
		return prcortitle;
	}

	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	public String getPruserid() {
		return pruserid;
	}

	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	public String getPrusername() {
		return prusername;
	}

	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	public Integer getPrroleid() {
		return prroleid;
	}

	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	public String getPrrolename() {
		return prrolename;
	}

	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPrpdname() {
		return prpdname;
	}

	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	public String getProrgid() {
		return prorgid;
	}

	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	public String getProrgname() {
		return prorgname;
	}

	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public String getPrfacttime() {
		return prfacttime;
	}

	public void setPrfacttime(String prfacttime) {
		this.prfacttime = prfacttime;
	}

	public Integer getPpid() {
		return ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	public Integer getPproleid() {
		return pproleid;
	}

	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	public String getPporgid() {
		return pporgid;
	}

	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	public String getPporgname() {
		return pporgname;
	}

	public void setPporgname(String pporgname) {
		this.pporgname = pporgname;
	}

	public String getPprolename() {
		return pprolename;
	}

	public void setPprolename(String pprolename) {
		this.pprolename = pprolename;
	}

	public String getPpuserid() {
		return ppuserid;
	}

	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	public String getPpusername() {
		return ppusername;
	}

	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	public String getPptype() {
		return pptype;
	}

	public void setPptype(String pptype) {
		this.pptype = pptype;
	}

	public String getPpuserinfo() {
		return ppuserinfo;
	}

	public void setPpuserinfo(String ppuserinfo) {
		this.ppuserinfo = ppuserinfo;
	}

	public String getPpcomment() {
		return ppcomment;
	}

	public void setPpcomment(String ppcomment) {
		this.ppcomment = ppcomment;
	}

	public String getPpstatus() {
		return ppstatus;
	}

	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	public String getPpattkey() {
		return ppattkey;
	}

	public void setPpattkey(String ppattkey) {
		this.ppattkey = ppattkey;
	}

	public String getPpinittime() {
		return ppinittime;
	}

	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	public String getPpproctime() {
		return ppproctime;
	}

	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}

	public String getPpsubstatus() {
		return ppsubstatus;
	}

	public void setPpsubstatus(String ppsubstatus) {
		this.ppsubstatus = ppsubstatus;
	}

	public Integer getPpfacttime() {
		return ppfacttime;
	}

	public void setPpfacttime(Integer ppfacttime) {
		this.ppfacttime = ppfacttime;
	}

	public String getPpbacktime() {
		return ppbacktime;
	}

	public void setPpbacktime(String ppbacktime) {
		this.ppbacktime = ppbacktime;
	}

	/**
	 * ���̲���ȡ��
	 * @return ���̲���
	 */
	public Integer getPrStrategyVersion() {
		if(prStrategyVersion != null && prStrategyVersion == 0) {
			return null;
		} else {
			return prStrategyVersion;
		}
	}

	/**
	 * ���̲����趨
	 * @param prStrategyVersion ���̲���
	 */
	public void setPrStrategyVersion(Integer prStrategyVersion) {
		if(prStrategyVersion != null && prStrategyVersion == 0) {
			this.prStrategyVersion = null;
		} else {
			this.prStrategyVersion = prStrategyVersion;
		}
	}

	/**
	 * ����״̬�������ʱ��ȡ��
	 * @return ����״̬�������ʱ��
	 */
	public Date getRslclosetime() {
		return rslclosetime;
	}

	/**
	 * ����״̬�������ʱ���趨
	 * @param rslclosetime ����״̬�������ʱ��
	 */
	public void setRslclosetime(Date rslclosetime) {
		this.rslclosetime = rslclosetime;
	}

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ���̶�̬��֧���ȡ��
	 * @return ���̶�̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ���̶�̬��֧����趨
	 * @param psdnum ���̶�̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}
	
}
