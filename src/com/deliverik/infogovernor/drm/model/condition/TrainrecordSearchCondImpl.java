/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ��ѵ��¼��������ʵ��
  * ��������: ��ѵ��¼��������ʵ��
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public class TrainrecordSearchCondImpl implements TrainrecordSearchCond {

	protected Integer trid;

	/** ��ѵ���� */
	protected String trname;

	/** ��ѵ�ƻ�id */
	protected Integer tpid;

	/** ��ѵ�ƻ����� */
	protected String tpname;

	/** ��ѵ���� */
	protected String tpcontent;

	/** ��ѵ��ʼʱ�� */
	protected String trstime;

	/** ��ѵ����ʱ�� */
	protected String tretime;

	/** ��ѵ�ص� */
	protected String trside;

	/** ��ʦ */
	protected String trlecturer;

	/** ���� */
	protected String tratt;
	
	/** ��ѵ��ʼʱ����ʼ */
	protected String trstimeFrom;
	
	/** ��ѵ��ʼʱ����ֹ */
	protected String trstimeTo;

	/**  
	 * ��ȡtrid  
	 * @return trid trid  
	 */
	
	public Integer getTrid() {
		return trid;
	}

	/**  
	 * ����trid  
	 * @param trid trid  
	 */
	
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**  
	 * ������ѵ����  
	 * @param trname ��ѵ����  
	 */
	
	public void setTrname(String trname) {
		this.trname = trname;
	}

	/**  
	 * ������ѵ�ƻ�id  
	 * @param tpid ��ѵ�ƻ�id  
	 */
	
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**  
	 * ������ѵ�ƻ�����  
	 * @param tpname ��ѵ�ƻ�����  
	 */
	
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**  
	 * ������ѵ����  
	 * @param tpcontent ��ѵ����  
	 */
	
	public void setTpcontent(String tpcontent) {
		this.tpcontent = tpcontent;
	}

	/**  
	 * ������ѵ��ʼʱ��  
	 * @param trstime ��ѵ��ʼʱ��  
	 */
	
	public void setTrstime(String trstime) {
		this.trstime = trstime;
	}

	/**  
	 * ������ѵ����ʱ��  
	 * @param tretime ��ѵ����ʱ��  
	 */
	
	public void setTretime(String tretime) {
		this.tretime = tretime;
	}

	/**  
	 * ������ѵ�ص�  
	 * @param trside ��ѵ�ص�  
	 */
	
	public void setTrside(String trside) {
		this.trside = trside;
	}

	/**  
	 * ���ý�ʦ  
	 * @param trlecturer ��ʦ  
	 */
	
	public void setTrlecturer(String trlecturer) {
		this.trlecturer = trlecturer;
	}

	/**  
	 * ���ø���  
	 * @param tratt ����  
	 */
	
	public void setTratt(String tratt) {
		this.tratt = tratt;
	}

	/**  
	 * ��ȡ��ѵ����  
	 * @return trname ��ѵ����  
	 */
	
	public String getTrname() {
		return trname;
	}

	/**  
	 * ��ȡ��ѵ�ƻ�id  
	 * @return tpid ��ѵ�ƻ�id  
	 */
	
	public Integer getTpid() {
		return tpid;
	}

	/**  
	 * ��ȡ��ѵ�ƻ�����  
	 * @return tpname ��ѵ�ƻ�����  
	 */
	
	public String getTpname() {
		return tpname;
	}

	/**  
	 * ��ȡ��ѵ����  
	 * @return tpcontent ��ѵ����  
	 */
	
	public String getTpcontent() {
		return tpcontent;
	}

	/**  
	 * ��ȡ��ѵ��ʼʱ��  
	 * @return trstime ��ѵ��ʼʱ��  
	 */
	
	public String getTrstime() {
		return trstime;
	}

	/**  
	 * ��ȡ��ѵ����ʱ��  
	 * @return tretime ��ѵ����ʱ��  
	 */
	
	public String getTretime() {
		return tretime;
	}

	/**  
	 * ��ȡ��ѵ�ص�  
	 * @return trside ��ѵ�ص�  
	 */
	
	public String getTrside() {
		return trside;
	}

	/**  
	 * ��ȡ��ʦ  
	 * @return trlecturer ��ʦ  
	 */
	
	public String getTrlecturer() {
		return trlecturer;
	}

	/**  
	 * ��ȡ����  
	 * @return tratt ����  
	 */
	
	public String getTratt() {
		return tratt;
	}

	/**  
	 * ��ȡ��ѵ��ʼʱ����ʼ  
	 * @return trstimeFrom ��ѵ��ʼʱ����ʼ  
	 */
	
	public String getTrstimeFrom() {
		return trstimeFrom;
	}

	/**  
	 * ������ѵ��ʼʱ����ʼ  
	 * @param trstimeFrom ��ѵ��ʼʱ����ʼ  
	 */
	
	public void setTrstimeFrom(String trstimeFrom) {
		this.trstimeFrom = trstimeFrom;
	}

	/**  
	 * ��ȡ��ѵ��ʼʱ����ֹ  
	 * @return trstimeTo ��ѵ��ʼʱ����ֹ  
	 */
	
	public String getTrstimeTo() {
		return trstimeTo;
	}

	/**  
	 * ������ѵ��ʼʱ����ֹ  
	 * @param trstimeTo ��ѵ��ʼʱ����ֹ  
	 */
	
	public void setTrstimeTo(String trstimeTo) {
		this.trstimeTo = trstimeTo;
	}

}