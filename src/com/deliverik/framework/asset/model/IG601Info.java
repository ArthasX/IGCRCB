package com.deliverik.framework.asset.model;

/**
 * ������Ϣ
 * 
 */
public interface IG601Info {

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public Integer getEid();

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname();
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getEilabel();

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public String getEidesc();

	/**
	 * �����汾��ȡ��
	 * @return �����汾��
	 */
	public Integer getEiversion();

	/**
	 * �Ǽ���ȡ��
	 * @return �Ǽ���
	 */
	public String getEiinsdate();

	/**
	 * ����λ�����곤ȡ��
	 * @return ����λ�����곤
	 */
	public String getX_total();

	/**
	 * ����λ�����곤ȡ��
	 * @return ����λ�����곤
	 */
	public String getY_total();

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getManager();
	
	/**
	 * ��ϵ�绰ȡ��
	 * @return ��ϵ�绰
	 */
	public String getTel();
	/**
	 * ��������ID
	 * @return ��������ID
	 */
	public String getRelateroom();
	/**
	 * �����ذ�X
	 * @return �����ذ�X
	 */
	public String getRelatex();
	/**
	 * �����ذ�Y
	 * @return �����ذ�Y
	 */
	public String getRelatey();
	
}