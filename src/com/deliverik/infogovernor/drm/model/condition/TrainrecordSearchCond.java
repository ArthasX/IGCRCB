/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ��ѵ��¼���������ӿ�
  * ��������: ��ѵ��¼���������ӿ�
  * ������¼: 2015/04/13
  * �޸ļ�¼: 
  */
public interface TrainrecordSearchCond {
	public Integer getTrid();

	/** ��ѵ���� */
	public String getTrname();

	/** ��ѵ�ƻ�id */
	public Integer getTpid();

	/** ��ѵ�ƻ����� */
	public String getTpname();

	/** ��ѵ���� */
	public String getTpcontent();

	/** ��ѵ��ʼʱ�� */
	public String getTrstime();

	/** ��ѵ����ʱ�� */
	public String getTretime();

	/** ��ѵ�ص� */
	public String getTrside();

	/** ��ʦ */
	public String getTrlecturer();

	/** ���� */
	public String getTratt();
	/**  
	 * ��ȡ��ѵ��ʼʱ����ʼ  
	 * @return trstimeFrom ��ѵ��ʼʱ����ʼ  
	 */
	
	public String getTrstimeFrom() ;

	/**  
	 * ��ȡ��ѵ��ʼʱ����ֹ  
	 * @return trstimeTo ��ѵ��ʼʱ����ֹ  
	 */
	
	public String getTrstimeTo();
}