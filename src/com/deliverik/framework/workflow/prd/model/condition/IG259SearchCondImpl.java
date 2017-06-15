package com.deliverik.framework.workflow.prd.model.condition;

/**
 * ����ģ����Ϣ��������ʵ��
 */
public class IG259SearchCondImpl implements IG259SearchCond{
	
	/**
	 * ����ģ��ID
	 */
	protected Integer ptid;

	/**
	 * ����ģ������
	 */
	protected String ptname;

	/**
	 * ����ģ������
	 */
	protected String pttype;

	/**
	 * ����ģ��״̬��a���ã�iͣ�ã�
	 */
	protected String ptstatus;
	
	/**
	 * ����ģ��ʹ��λ�ñ�ʶ��ƽ̨������
	 */
	protected String ptqrtzflag;
	
	/**
	 * ����ģ�������Ƿ�Ϊ������ƽ̨������
	 */
	protected int isWorkPt;

	/**
	 * ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�
	 */
	protected String[] ptstatuses;

	
	
	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ��ID�趨
	  * @param ptid ����ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPtname() {
		return ptname;
	}

	/**
	 * ����ģ�������趨
	  * @param ptname ����ģ������
	 */
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * ����ģ�������趨
	  * @param pttype ����ģ������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * ����ģ��״̬��a���ã�iͣ�ã�ȡ��
	 * @return ����ģ��״̬
	 */
	public String getPtstatus() {
		return ptstatus;
	}

	/**
	 * ����ģ��״̬�趨
	  * @param ptstatus ����ģ��״̬
	 */
	public void setPtstatus(String ptstatus) {
		this.ptstatus = ptstatus;
	}

	/**
	 * ����ģ��ʹ��λ�ñ�ʶ��ƽ̨������ȡ��
	 * @return ����ģ��ʹ��λ�ñ�ʶ
	 */
	public String getPtqrtzflag() {
		return ptqrtzflag;
	}

	/**
	 * ����ģ��ʹ��λ�ñ�ʶ�趨
	  * @param ptqrtzflag ����ģ��ʹ��λ�ñ�ʶ
	 */
	public void setPtqrtzflag(String ptqrtzflag) {
		this.ptqrtzflag = ptqrtzflag;
	}
	
	/**
	 * ����ģ�������Ƿ�Ϊ������ƽ̨������ȡ��
	 * @return ����ģ�������Ƿ�Ϊ����
	 */
	public int getIsWorkPt() {
		return isWorkPt;
	}

	/**
	 * ����ģ�������Ƿ�Ϊ�����趨
	  * @param isWorkPt ����ģ�������Ƿ�Ϊ����
	 */
	public void setIsWorkPt(int isWorkPt) {
		this.isWorkPt = isWorkPt;
	}

	/**
	 * ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�ȡ��
	 * @return ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�
	 */
	public String[] getPtstatuses() {
		return ptstatuses;
	}

	/**
	 * ����ģ��״̬��a���ã�iͣ�ã�t���ԣ��趨
	 * @param ptstatuses ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�
	 */
	public void setPtstatuses(String[] ptstatuses) {
		this.ptstatuses = ptstatuses;
	}

	
	
}
