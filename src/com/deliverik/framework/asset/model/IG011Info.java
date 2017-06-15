package com.deliverik.framework.asset.model;

/**
 * �ʲ�ͳ����Ϣ
 *
 */
public interface IG011Info {

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getCid();
	
	/**
	 * �ʲ�ģ������ȡ��
	 * @return �ʲ�ģ������
	 */
	public String getCvalue();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getTotal();
	
	/**
	 * ÿ���ʲ�ģ��������ռ�����İٷ���ȡ��
	 * @return ÿ���ʲ�ģ��������ռ�����İٷ���
	 */
	public String getProportion();
	

	/**
	 * ÿ���ʲ�ģ��������ռ�����İٷ����趨
	 *
	 * @param proportion ÿ���ʲ�ģ��������ռ�����İٷ���
	 */
	public void setProportion(String proportion);
	
}