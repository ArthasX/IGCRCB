/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.model.condition;

/**
  * ����: �������ļල��������ʵ��
  * ��������: �������ļල��������ʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public class RiskCheckProblemSuperviseVWSearchCondImpl implements
	RiskCheckProblemSuperviseVWSearchCond {
	
	/** ������� */
	protected String prtitle;
	
	/** �������� */
	protected String prdesc;
	
	/** ���ⷢ��ʱ��� */
	protected String propentime_from;
	
	/** ���ⷢ��ʱ�䵽 */
	protected String propentime_to;
	
	/** ����״̬ */
	protected String prstatus;

	/** �����ѯ״̬ */
	protected String questionstatus;
	
	/** �������*/
    protected String category;
    
    protected String rcclass;
    
    protected String rcsourse;
    
	/**
	 * �������ȡ��
	 * @return prtitle �������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ��������趨
	 * @param prtitle �������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���������趨
	 * @param prdesc ��������
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ���ⷢ��ʱ���ȡ��
	 * @return propentime_from ���ⷢ��ʱ���
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * ���ⷢ��ʱ����趨
	 * @param propentime_from ���ⷢ��ʱ���
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * ���ⷢ��ʱ�䵽ȡ��
	 * @return propentime_to ���ⷢ��ʱ�䵽
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * ���ⷢ��ʱ�䵽�趨
	 * @param propentime_to ���ⷢ��ʱ�䵽
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

	/**
	 * ����״̬ȡ��
	 * @return prstatus ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * �����ѯ״̬ȡ��
	 * @return questionstatus �����ѯ״̬
	 */
	public String getQuestionstatus() {
		return questionstatus;
	}

	/**
	 * �����ѯ״̬�趨
	 * @param questionstatus �����ѯ״̬
	 */
	public void setQuestionstatus(String questionstatus) {
		this.questionstatus = questionstatus;
	}

    /**
     * �������ȡ��
     *
     * @return category �������
     */
    public String getCategory() {
        return category;
    }

    /**
     * ��������趨
     *
     * @param category �������
     */
    public void setCategory(String category) {
        this.category = category;
    }

	public String getRcclass() {
		return rcclass;
	}

	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	public String getRcsourse() {
		return rcsourse;
	}

	public void setRcsourse(String rcsourse) {
		this.rcsourse = rcsourse;
	}
    
}