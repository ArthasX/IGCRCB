package com.deliverik.infogovernor.ven.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ���ռ��FORM
 * 
 */
@SuppressWarnings("serial")
public class IGVEN0103Form extends BaseForm{
	
	/** ��⹤��id����*/
	private Integer[] rcrids;
	
	/** �����⹤����������id*/
	private Integer[] prids;
	
	/** �����⹤����������id*/
	private Integer[] rmids;

	protected Integer prid;
	
	
	/** ���̶���ID */
	protected String pdid;
	
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
	protected Integer prfacttime;
	
	/**
	 * �Զ���������ʱԾǨ����
	 */
	protected String prptdcond;
	
	/**
	 * ���̲��԰汾
	 */
	protected Integer prStrategyVersion;
	
	/**
	 * �������ȼ�
	 */
	protected String prPriority;
	
	/** ��ť���� */
	protected String buttonName;
	
	/** ��ť��ʶ */
	protected String buttonCode;
	
	/** �����ɲ�������Ϣ���� */
	protected String[] participants;
	
	/**
	 * ��⹤��id����ȡ��
	 * @return the rcrids
	 */
	public Integer[] getRcrids() {
		return rcrids;
	}

	/**
	 * ��⹤��id�����趨
	 * @param rcrids the ��⹤��id����
	 */
	public void setRcrids(Integer[] rcrids) {
		this.rcrids = rcrids;
	}

	/**
	 * �����⹤����������idȡ��
	 * @return the prids
	 */
	public Integer[] getPrids() {
		return prids;
	}

	/**
	 * �����⹤����������id�趨
	 * @param prids the �����⹤����������id
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}

	/**
	 * pridȡ��
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * prid�趨
	 * @param prid the prid
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���̼�¼����ȡ��
	 * @return the prtype
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���̼�¼�����趨
	 * @param prtype the ���̼�¼����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���̼�¼������ȡ��
	 * @return the prsubtype
	 */
	public String getPrsubtype() {
		return prsubtype;
	}

	/**
	 * ���̼�¼�������趨
	 * @param prsubtype the ���̼�¼������
	 */
	public void setPrsubtype(String prsubtype) {
		this.prsubtype = prsubtype;
	}

	/**
	 * ���̼�¼״̬ȡ��
	 * @return the prstatus
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���̼�¼״̬�趨
	 * @param prstatus the ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return the prsubstatus
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * ���̼�¼״̬��״̬�趨
	 * @param prsubstatus the ���̼�¼״̬��״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * ���̼�¼��Ŀȡ��
	 * @return the prtitle
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���̼�¼��Ŀ�趨
	 * @param prtitle the ���̼�¼��Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ���̼�¼����ȡ��
	 * @return the prdesc
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���̼�¼�����趨
	 * @param prdesc the ���̼�¼����
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ���̼�¼����ʱ��ȡ��
	 * @return the propentime
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���̼�¼����ʱ���趨
	 * @param propentime the ���̼�¼����ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 * @return the prclosetime
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���̼�¼�ر�ʱ���趨
	 * @param prclosetime the ���̼�¼�ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return the prplantime
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ���趨
	 * @param prplantime the ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * ���̼�¼�ƻ�ִ������ȡ��
	 * @return the prduration
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * ���̼�¼�ƻ�ִ�������趨
	 * @param prduration the ���̼�¼�ƻ�ִ������
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * ���̼�¼�����̶�ȡ��
	 * @return the prurgency
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���̼�¼�����̶��趨
	 * @param prurgency the ���̼�¼�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * ���̼�¼Ӱ��̶�ȡ��
	 * @return the primpact
	 */
	public String getPrimpact() {
		return primpact;
	}

	/**
	 * ���̼�¼Ӱ��̶��趨
	 * @param primpact the ���̼�¼Ӱ��̶�
	 */
	public void setPrimpact(String primpact) {
		this.primpact = primpact;
	}

	/**
	 * ���̼�¼����ʲ�IDȡ��
	 * @return the prassetid
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * ���̼�¼����ʲ�ID�趨
	 * @param prassetid the ���̼�¼����ʲ�ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return the prassetname
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * ���̼�¼����ʲ������趨
	 * @param prassetname the ���̼�¼����ʲ�����
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * ���̼�¼�����ҵ��ȡ��
	 * @return the prbusiness
	 */
	public String getPrbusiness() {
		return prbusiness;
	}

	/**
	 * ���̼�¼�����ҵ���趨
	 * @param prbusiness the ���̼�¼�����ҵ��
	 */
	public void setPrbusiness(String prbusiness) {
		this.prbusiness = prbusiness;
	}

	/**
	 * ���̼�¼ִ�мƻ�ȡ��
	 * @return the primplplan
	 */
	public String getPrimplplan() {
		return primplplan;
	}

	/**
	 * ���̼�¼ִ�мƻ��趨
	 * @param primplplan the ���̼�¼ִ�мƻ�
	 */
	public void setPrimplplan(String primplplan) {
		this.primplplan = primplplan;
	}

	/**
	 * ���̼�¼�ָ��ƻ�ȡ��
	 * @return the prbackplan
	 */
	public String getPrbackplan() {
		return prbackplan;
	}

	/**
	 * ���̼�¼�ָ��ƻ��趨
	 * @param prbackplan the ���̼�¼�ָ��ƻ�
	 */
	public void setPrbackplan(String prbackplan) {
		this.prbackplan = prbackplan;
	}

	/**
	 * ���̼�¼��֤�ƻ�ȡ��
	 * @return the prvfyplan
	 */
	public String getPrvfyplan() {
		return prvfyplan;
	}

	/**
	 * ���̼�¼��֤�ƻ��趨
	 * @param prvfyplan the ���̼�¼��֤�ƻ�
	 */
	public void setPrvfyplan(String prvfyplan) {
		this.prvfyplan = prvfyplan;
	}

	/**
	 * ���̼�¼�����ĿIDȡ��
	 * @return the pid
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ���̼�¼�����ĿID�趨
	 * @param pid the ���̼�¼�����ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * ���̼�¼�����Ŀ���ȡ��
	 * @return the pcode
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ���̼�¼�����Ŀ����趨
	 * @param pcode the ���̼�¼�����Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ���̼�¼�����Ŀ����ȡ��
	 * @return the pname
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * ���̼�¼�����Ŀ�����趨
	 * @param pname the ���̼�¼�����Ŀ����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * ���̼�¼��������ϵ��ʽȡ��
	 * @return the prinfo
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * ���̼�¼��������ϵ��ʽ�趨
	 * @param prinfo the ���̼�¼��������ϵ��ʽ
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * ���̼�¼�������IDȡ��
	 * @return the prcorid
	 */
	public Integer getPrcorid() {
		return prcorid;
	}

	/**
	 * ���̼�¼�������ID�趨
	 * @param prcorid the ���̼�¼�������ID
	 */
	public void setPrcorid(Integer prcorid) {
		this.prcorid = prcorid;
	}

	/**
	 * ���̼�¼�����������ȡ��
	 * @return the prcortype
	 */
	public String getPrcortype() {
		return prcortype;
	}

	/**
	 * ���̼�¼������������趨
	 * @param prcortype the ���̼�¼�����������
	 */
	public void setPrcortype(String prcortype) {
		this.prcortype = prcortype;
	}

	/**
	 * ���̼�¼�����������ȡ��
	 * @return the prcortitle
	 */
	public String getPrcortitle() {
		return prcortitle;
	}

	/**
	 * ���̼�¼������������趨
	 * @param prcortitle the ���̼�¼�����������
	 */
	public void setPrcortitle(String prcortitle) {
		this.prcortitle = prcortitle;
	}

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return the prassetcategory
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * ���̼�¼����ʲ������趨
	 * @param prassetcategory the ���̼�¼����ʲ�����
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ���̼�¼�������û�IDȡ��
	 * @return the pruserid
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * ���̼�¼�������û�ID�趨
	 * @param pruserid the ���̼�¼�������û�ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * ���̼�¼�������û�����ȡ��
	 * @return the prusername
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���̼�¼�������û������趨
	 * @param prusername the ���̼�¼�������û�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ���̼�¼�����߽�ɫIDȡ��
	 * @return the prroleid
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * ���̼�¼�����߽�ɫID�趨
	 * @param prroleid the ���̼�¼�����߽�ɫID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ���̼�¼�����߽�ɫ����ȡ��
	 * @return the prrolename
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * ���̼�¼�����߽�ɫ�����趨
	 * @param prrolename the ���̼�¼�����߽�ɫ����
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * ���̼�¼��������IDȡ��
	 * @return the prpdid
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̼�¼��������ID�趨
	 * @param prpdid the ���̼�¼��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ���̼�¼������������ȡ��
	 * @return the prpdname
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * ���̼�¼�������������趨
	 * @param prpdname the ���̼�¼������������
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * ���̼�¼�������������������ȡ��
	 * @return the prorgid
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * ���̼�¼��������������������趨
	 * @param prorgid the ���̼�¼�������������������
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * ���̼�¼������������������ȡ��
	 * @return the prorgname
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * ���̼�¼�������������������趨
	 * @param prorgname the ���̼�¼������������������
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	/**
	 * ���̼�¼������ȡ��
	 * @return the prserialnum
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���̼�¼�������趨
	 * @param prserialnum the ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ��������ȡ��
	 * @return the prfacttime
	 */
	public Integer getPrfacttime() {
		return prfacttime;
	}

	/**
	 * ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ���������趨
	 * @param prfacttime the ���̼�¼ʵ�ʽ��ʱ�䣨�ӿ�ʼ��������
	 */
	public void setPrfacttime(Integer prfacttime) {
		this.prfacttime = prfacttime;
	}

	/**
	 * �Զ���������ʱԾǨ����ȡ��
	 * @return the prptdcond
	 */
	public String getPrptdcond() {
		return prptdcond;
	}

	/**
	 * �Զ���������ʱԾǨ�����趨
	 * @param prptdcond the �Զ���������ʱԾǨ����
	 */
	public void setPrptdcond(String prptdcond) {
		this.prptdcond = prptdcond;
	}

	/**
	 * ���̲��԰汾ȡ��
	 * @return the prStrategyVersion
	 */
	public Integer getPrStrategyVersion() {
		return prStrategyVersion;
	}

	/**
	 * ���̲��԰汾�趨
	 * @param prStrategyVersion the ���̲��԰汾
	 */
	public void setPrStrategyVersion(Integer prStrategyVersion) {
		this.prStrategyVersion = prStrategyVersion;
	}

	/**
	 * �������ȼ�ȡ��
	 * @return the prPriority
	 */
	public String getPrPriority() {
		return prPriority;
	}

	/**
	 * �������ȼ��趨
	 * @param prPriority the �������ȼ�
	 */
	public void setPrPriority(String prPriority) {
		this.prPriority = prPriority;
	}

	/**
	 * ��ť����ȡ��
	 * @return the buttonName
	 */
	public String getButtonName() {
		return buttonName;
	}

	/**
	 * ��ť�����趨
	 * @param buttonName the ��ť����
	 */
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	/**
	 * ��ť��ʶȡ��
	 * @return the buttonCode
	 */
	public String getButtonCode() {
		return buttonCode;
	}

	/**
	 * ��ť��ʶ�趨
	 * @param buttonCode the ��ť��ʶ
	 */
	public void setButtonCode(String buttonCode) {
		this.buttonCode = buttonCode;
	}

	/**
	 * �����ɲ�������Ϣ����ȡ��
	 * @return the participants
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * �����ɲ�������Ϣ�����趨
	 * @param participants the �����ɲ�������Ϣ����
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}

	/**
	 * �����⹤����������idȡ��
	 * @return the rmids
	 */
	public Integer[] getRmids() {
		return rmids;
	}

	/**
	 * �����⹤����������id�趨
	 * @param rmids the �����⹤����������id
	 */
	public void setRmids(Integer[] rmids) {
		this.rmids = rmids;
	}

	/**
	 * ���̶���IDȡ��
	 * @return the pdid
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid the ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
}
