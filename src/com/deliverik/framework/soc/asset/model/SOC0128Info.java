package com.deliverik.framework.soc.asset.model;


/**
 * �ʲ�������ʷ�汾����ʱ��
 * 
 */
public interface SOC0128Info  {

	/**
	 * �ʲ����Դ�汾��ȡ��
	 * @return �ʲ����Դ�汾��
	 */
	public Integer getCiversion();
	
	 /**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public Integer getCismallversion();
	
	/**
	 * �ʲ����Ը���ʱ��ȡ��
	 * @return �ʲ����Ը���ʱ��
	 */
	public String getCiupdtime();
	
	
	/**
	 * �Ƿ���������ļ������������ڵ��ڰ汾�Ƚ�ʱ����ʾ 0����ʾ 1��ʾ
	 * @return ��ʾ��ʶ
	 */
    public String getIsshow();
}