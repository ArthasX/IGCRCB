/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.model;


/**
 * <p>����:Ԥ�㼰���̷�����Ϣ��ͼ�ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */

public interface Pbsummary {
	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getPbrid();
	
	/**
	 * ��ȡԤ���ID
	 * @return Ԥ���ID
	 */
	public Integer getBid();
	
	/**
	 * ��ȡԤ������
	 * @return Ԥ������
	 */
	public String getBtype();
	
	/**
	 * ��ȡԤ��״̬
	 * @return Ԥ��״̬
	 */
	public String getBstatus();
	
	/**
	 * ��ȡԤ������
	 * @return Ԥ������
	 */
	public String getBtitle();
	
	/**
	 * ��ȡԤ����
	 * @return Ԥ����
	 */
	public String getBdesc();
	
	/**
	 * ��ȡԤ�����
	 * @return Ԥ�����
	 */
	public String getByear();
	
	/**
	 * ��ȡԤ���ܶ�
	 * @return Ԥ���ܶ�
	 */
	public Double getBamount();
	
	/**
	 * ��ȡԤ������
	 * @return Ԥ������
	 */
	public String getPquality();
	
	/**
	 * ��ȡԤ�㴢��Ԥ����
	 * @return Ԥ�㴢��Ԥ����
	 */
	public String getPstorecode();
	
	/**
	 * ��ȡԤ��������
	 * @return Ԥ��������
	 */
	public String getPneeddispart();
	
	/**
	 * ��ȡԤ�����
	 * @return Ԥ�����
	 */
	public String getPbuggetform();
	
	/**
	 * ��ȡԤ����;
	 * @return Ԥ����;
	 */
	public String getPuse();
	
	/**
	 * ��ȡԤ�㱸ע
	 * @return Ԥ�㱸ע
	 */
	public String getRemark();
	
	/**
	 * ��ȡ�ʱ��𿪷�Ԥ���ܶ�
	 * @return �ʱ��𿪷�Ԥ���ܶ�
	 */
	public float getTotal1();
	
	/**
	 * ��ȡ�ʱ���Ӳ��Ԥ���ܶ�
	 * @return �ʱ���Ӳ��Ԥ���ܶ�
	 */
	public float getTotal2();
	
	/**
	 * ��ȡ�ʱ������Ԥ���ܶ�
	 * @return �ʱ������Ԥ���ܶ�
	 */
	public float getTotal3();
	
	/**
	 * ��ȡ�ʱ��𹤳�Ԥ���ܶ�
	 * @return �ʱ��𹤳�Ԥ���ܶ�
	 */
	public float getTotal4();
	
	/**
	 * ��ȡ�ʱ�������Ԥ���ܶ�
	 * @return �ʱ�������Ԥ���ܶ�
	 */
	public float getTotal5();
	
	/**
	 * ��ȡ�ɱ���ʵʩԤ���ܶ�
	 * @return �ɱ���ʵʩԤ���ܶ�
	 */
	public float getTotal6();
	
	/**
	 * ��ȡ�ɱ�������Ԥ���ܶ�
	 * @return �ɱ�������Ԥ���ܶ�
	 */
	public float getTotal7();
	
	/**
	 * ��ȡ�ʱ��𿪷���ʹ���ܶ�
	 * @return �ʱ��𿪷���ʹ���ܶ�
	 */
	public float getTotaluse1();
	
	/**
	 * ��ȡ�ʱ���Ӳ����ʹ���ܶ�
	 * @return �ʱ���Ӳ����ʹ���ܶ�
	 */
	public float getTotaluse2();
	
	/**
	 * ��ȡ�ʱ��������ʹ���ܶ�
	 * @return �ʱ��������ʹ���ܶ�
	 */
	public float getTotaluse3();
	
	/**
	 * ��ȡ�ʱ��𹤳���ʹ���ܶ�
	 * @return �ʱ��𹤳���ʹ���ܶ�
	 */
	public float getTotaluse4();
	
	/**
	 * ��ȡ�ʱ���������ʹ���ܶ�
	 * @return �ʱ���������ʹ���ܶ�
	 */
	public float getTotaluse5();
	
	/**
	 * ��ȡ�ɱ���ʵʩ��ʹ���ܶ�
	 * @return �ɱ���ʵʩ��ʹ���ܶ�
	 */
	public float getTotaluse6();
	
	/**
	 * ��ȡ�ɱ���������ʹ���ܶ�
	 * @return �ɱ���������ʹ���ܶ�
	 */
	public float getTotaluse7();
	
	/**
	 * ��ȡ�ʱ��𿪷�ʣ���ܶ�
	 * @return �ʱ��𿪷�ʣ���ܶ�
	 */
	public float getSub1();
	
	/**
	 * ��ȡ�ʱ���Ӳ��ʣ���ܶ�
	 * @return �ʱ���Ӳ��ʣ���ܶ�
	 */
	public float getSub2();
	
	/**
	 * ��ȡ�ʱ������ʣ���ܶ�
	 * @return �ʱ������ʣ���ܶ�
	 */
	public float getSub3();
	
	/**
	 * ��ȡ�ʱ��𹤳�ʣ���ܶ�
	 * @return �ʱ��𹤳�ʣ���ܶ�
	 */
	public float getSub4();
	
	/**
	 * ��ȡ�ʱ�������ʣ���ܶ�
	 * @return �ʱ�������ʣ���ܶ�
	 */
	public float getSub5();
	
	/**
	 * ��ȡ�ɱ���ʵʩʣ���ܶ�
	 * @return �ɱ���ʵʩʣ���ܶ�
	 */
	public float getSub6();
	
	/**
	 * ��ȡ�ɱ�������ʣ���ܶ�
	 * @return �ɱ�������ʣ���ܶ�
	 */
	public float getSub7();
	
	/**
	 * ��ȡ�ʱ��𿪷�����Ԥ��ʹ�ö�
	 * @return �ʱ��𿪷�����Ԥ��ʹ�ö�
	 */
	public float getUse1();
	
	/**
	 * ��ȡ�ʱ���Ӳ������Ԥ��ʹ�ö�
	 * @return �ʱ���Ӳ������Ԥ��ʹ�ö�
	 */
	public float getUse2();
	
	/**
	 * ��ȡ�ʱ����������Ԥ��ʹ�ö�
	 * @return �ʱ����������Ԥ��ʹ�ö�
	 */
	public float getUse3();
	
	/**
	 * ��ȡ�ʱ��𹤳̵���Ԥ��ʹ�ö�
	 * @return �ʱ��𹤳̵���Ԥ��ʹ�ö�
	 */
	public float getUse4();
	
	/**
	 * ��ȡ�ʱ�����������Ԥ��ʹ�ö�
	 * @return �ʱ�����������Ԥ��ʹ�ö�
	 */
	public float getUse5();
	
	/**
	 * ��ȡ�ɱ���ʵʩ����Ԥ��ʹ�ö�
	 * @return �ɱ���ʵʩ����Ԥ��ʹ�ö�
	 */
	public float getUse6();
	
	/**
	 * ��ȡ�ɱ�����������Ԥ��ʹ�ö�
	 * @return �ɱ�����������Ԥ��ʹ�ö�
	 */
	public float getUse7();
	
	/**
	 * ��ȡ��ĿID
	 * @return ��ĿID
	 */
	public Integer getPid();
	
	/**
	 * ��ȡԤ����Ŀ��ϵ��ID
	 * @return Ԥ����Ŀ��ϵ��ID
	 */
	public Integer getPbid();
}
