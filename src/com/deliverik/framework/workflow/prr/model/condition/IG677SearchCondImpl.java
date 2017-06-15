/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:���̼�¼������û���Ϣ��������ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG677SearchCondImpl implements IG677SearchCond {

	/**
	 * ���̼�¼��Ŀ
	 */
	protected String prtitle;
	
	/**
	 * ���̼�¼����
	 */
	protected String prtype;

	/**
	 * ����ģ��
	 */
	protected String prpdid;
	
	/**
	 * ���̼�¼״̬
	 */
	protected String prstatus;
	
	/**
	 * ���̲����û���ɫID
	 */
	protected Integer pproleid;
	
	/**
	 * ���̲����û�ID
	 */
	protected String ppuserid;
	
	/**
	 * ���̲����û�ָ��ʱ��
	 */
	protected String ppinittime;
	
	/**
	 * ���̲����û��������ʱ��
	 */
	protected String ppproctime;
	
	/**
	 * ���̲����û�������ɿ�ʼʱ��
	 */
	protected String ppproctime_from;
	
	/**
	 * ���̲����û�������ɽ���ʱ��
	 */
	protected String ppproctime_to;
	
	/**
	 * ���̲����û�����
	 */
	protected String ppusername;
	
	/**
	 * ���̼�¼ID
	 */
	protected Integer prid;
	
	/**
	 * ���̼�¼�����̶�
	 */
	protected String prurgency;
	
	/**
	 * ���̼�¼����ʱ��
	 */
	protected String propentime;
	
	/**
	 * ���̼�¼����ʱ�䣨С���ڣ�
	 */
	protected String prclosetime;
	
	/**
	 * ���̲����û��Ĳ���״̬
	 */
	protected String ppstatus;
	
	/**
	 * ���̼�¼״̬��״̬
	 */
	protected String prsubstatus;
	
	/**
	 * ���̼�¼�����Ŀ���
	 */
	protected String pcode;
	
	/**
	 * ���̼�¼�ƻ�ִ��ʱ��
	 */
	protected String prplantime;// �¼�����ʱ���(����ͼ��ʾ����)
	
	/**
	 * ���̼�¼�ƻ�ִ������
	 */
	protected String prduration;// �¼�����ʱ����(����ͼ��ʾ����)
	
	/**
	 * ���̼�¼����ʲ�ID
	 */
	protected Integer prassetid;
	
	/**
	 * ���̼�¼����ʲ�����
	 */
	protected String prassetcategory;
	
	/**
	 * ���̼�¼������
	 */
	protected String prserialnum;
	
	/**
	 * ƽ̨����
	 */
	protected String selectMode;
	
	/**
	 * ƽ̨����
	 */
	protected int isWork;
	
	/**
	 * ƽ̨����
	 */
	protected String mode;
	
	/**
	 * ƽ̨����
	 */
	protected String prActive;
	
	/**
	 * ƽ̨����
	 */
	protected boolean isTodo;
	
	/**
	 * ƽ̨����
	 */
	protected boolean isToImplement;
	
	/**
	 * ��������״̬��������
	 */
	protected String dsstatus;

	/**
	 * 
	 */
	protected String[] prtypes;
	
	
    /**
     * ȡ��
     *
     * @return prtypes 
     */
    public String[] getPrtypes() {
        return prtypes;
    }

    /**
     * �趨
     *
     * @param prtypes 
     */
    public void setPrtypes(String[] prtypes) {
        this.prtypes = prtypes;
    }

    /**
	 * ���ܣ����̼�¼����ʲ�IDȡ��
	 * @return ���̼�¼����ʲ�ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * ���ܣ����̼�¼����ʲ�ID�趨
	 * @param prassetid ���̼�¼����ʲ�ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * ���ܣ����̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * ���ܣ����̼�¼����ʲ������趨
	 * @param prassetcategory ���̼�¼����ʲ�����
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ���ܣ����̲����û��Ĳ���״̬ȡ��
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus() {
		return ppstatus;
	}

	/**
	 * ���ܣ����̲����û��Ĳ���״̬�趨
	 * @param ppstatus ���̲����û��Ĳ���״̬
	 */
	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	/**
	 * ���ܣ����̼�¼��Ŀȡ��
	 * @return ���̼�¼��Ŀ
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���ܣ����̼�¼��Ŀ�趨
	 * @param prtitle ���̼�¼��Ŀ
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ���ܣ����̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���ܣ����̼�¼�����趨
	 * @param prtype ���̼�¼����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���ܣ����̼�¼״̬ȡ��
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���ܣ����̼�¼״̬�趨
	 * @param prstatus ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	
	/**
	 * ���ܣ����̲����û���ɫIDȡ��
	 * @return ���̲����û���ɫID
	 */
	public Integer getPproleid() {
		return pproleid;
	}

	/**
	 * ���ܣ����̲����û���ɫID�趨
	 * @param pproleid ���̲����û���ɫID
	 */
	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	/**
	 * ���ܣ����̲����û�IDȡ��
	 * @return ���̲����û�ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * ���ܣ����̲����û�ID�趨
	 * @param ppuserid ���̲����û�ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * ���ܣ����̲����û�ָ��ʱ��ȡ��
	 * @return ���̲����û�ָ��ʱ��
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * ���ܣ����̲����û�ָ��ʱ���趨
	 * @param ppinittime ���̲����û�ָ��ʱ��
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * ���ܣ����̲����û��������ʱ��ȡ��
	 * @return ���̲����û��������ʱ��
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * ���ܣ����̲����û��������ʱ���趨
	 * @param ppproctime ���̲����û��������ʱ��
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}
	
	/**
	 * ���ܣ����̲����û�������ɿ�ʼʱ��ȡ��
	 * @return ���̲����û�������ɿ�ʼʱ��
	 */
	public String getPpproctime_from() {
		return ppproctime_from;
	}

	/**
	 * ���ܣ����̲����û�������ɿ�ʼʱ���趨
	 * @param ppproctime_from ���̲����û�������ɿ�ʼʱ��
	 */
	public void setPpproctime_from(String ppproctime_from) {
		this.ppproctime_from = ppproctime_from;
	}

	/**
	 * ���ܣ����̲����û�������ɽ���ʱ��ȡ��
	 * @return ���̲����û�������ɽ���ʱ��
	 */
	public String getPpproctime_to() {
		return ppproctime_to;
	}

	/**
	 * ���ܣ����̲����û�������ɽ���ʱ���趨
	 * @param ppproctime_to ���̲����û�������ɽ���ʱ��
	 */
	public void setPpproctime_to(String ppproctime_to) {
		this.ppproctime_to = ppproctime_to;
	}

	/**
	 * ���ܣ����̲����û�����ȡ��
	 * @return ���̲����û�����
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * ���ܣ����̲����û������趨
	 * @param ppusername ���̲����û�����
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	/**
	 * ���ܣ����̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ܣ����̼�¼ID�趨
	 * @param prid ���̼�¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���ܣ����̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * ���ܣ����̼�¼�����̶��趨
	 * @param prurgency ���̼�¼�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	/**
	 * ���ܣ����̼�¼����ʱ��ȡ��
	 * @return ���̼�¼����ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���ܣ����̼�¼����ʱ���趨
	 * @param propentime ���̼�¼����ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨С���ڣ�ȡ��
	 * @return ���̼�¼����ʱ�䣨С���ڣ�
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���ܣ����̼�¼����ʱ�䣨С���ڣ��趨
	 * @param prclosetime ���̼�¼����ʱ�䣨С���ڣ�
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	

	/**
	 * ���ܣ����̼�¼�����Ŀ���ȡ��
	 * @return ���̼�¼�����Ŀ���
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * ���ܣ����̼�¼�����Ŀ����趨
	 * @param pcode ���̼�¼�����Ŀ���
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ��ʱ���趨
	 * @param prplantime ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrduration() {
		return prduration;
	}

	/**
	 * ���ܣ����̼�¼�ƻ�ִ�������趨
	 * @param prduration ���̼�¼�ƻ�ִ������
	 */
	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	/**
	 * ���ܣ����̼�¼״̬��״̬ȡ��
	 * @return ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus() {
		return prsubstatus;
	}

	/**
	 * ���ܣ����̼�¼״̬��״̬�趨
	 * @param prsubstatus ���̼�¼״̬��״̬
	 */
	public void setPrsubstatus(String prsubstatus) {
		this.prsubstatus = prsubstatus;
	}

	/**
	 * ���ܣ����̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���ܣ����̼�¼�������趨
	 * @param prserialnum ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}
	
	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ƽ̨����
	 * @param mode
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getPrActive() {
		return prActive;
	}

	/**
	 * ƽ̨����
	 * @param mode
	 */
	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	/**
	 * ƽ̨����
	 * @return 
	 */
	public boolean isTodo() {
		return isTodo;
	}

	/**
	 * ƽ̨����
	 * @param mode
	 */
	public void setTodo(boolean todo) {
		isTodo = todo;
		
	}
	
	/**
	 * ƽ̨����
	 * @return 
	 */
	public int getIsWork() {
		return isWork;
	}

	/**
	 * ƽ̨����
	 * @param mode
	 */
	public void setIsWork(int isWork) {
		this.isWork = isWork;
	}

	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getSelectMode() {
		return selectMode;
	}

	/**
	 * ƽ̨����
	 * @param mode
	 */
	public void setSelectMode(String selectMode) {
		this.selectMode = selectMode;
	}

	/**
	 * ƽ̨����
	 * @return 
	 */
	public boolean isToImplement() {
		return isToImplement;
	}

	/**
	 * ƽ̨����
	 * @param mode
	 */
	public void setToImplement(boolean isToImplement) {
		this.isToImplement = isToImplement;
	}

	/**
	 * ���ܣ���������״̬��������ȡ��
	 * @return ��������״̬��������
	 */
	public String getDsstatus() {
		return dsstatus;
	}

	/**
	 * ���ܣ���������״̬���������趨
	 * @param dsstatus ��������״̬��������
	 */
	public void setDsstatus(String dsstatus) {
		this.dsstatus = dsstatus;
	}

    /**
     * ����ģ��ȡ��
     *
     * @return prpdid ����ģ��
     */
    public String getPrpdid() {
        return prpdid;
    }

    /**
     * ����ģ���趨
     *
     * @param prpdid ����ģ��
     */
    public void setPrpdid(String prpdid) {
        this.prpdid = prpdid;
    }
	
	/**���̽ڵ�״̬��ʾ��(��ȫƥ��)*/
	protected String psdid_eq;
	/**
	 * ���̽ڵ�״̬��ʾ��(��ȫƥ��)ȡ��
	 * @return
	 */
	public String getPsdid_eq() {
		return psdid_eq;
	}
	/**
	 * ���̽ڵ�״̬��ʾ��(��ȫƥ��)�趨
	 * @param psdid_eq
	 */
	public void setPsdid_eq(String psdid_eq) {
		this.psdid_eq = psdid_eq;
	}
	
	/**�����˻�����(��ȫƥ��)*/
	protected String pporgid_eq;
	/**
	 * �����˻�����(��ȫƥ��)ȡ��
	 * @return
	 */
	public String getPporgid_eq() {
		return pporgid_eq;
	}
	/**
	 * �����˻�����(��ȫƥ��)�趨
	 * @param pporgid_eq
	 */
	public void setPporgid_eq(String pporgid_eq) {
		this.pporgid_eq = pporgid_eq;
	}
}
