package com.deliverik.framework.asset.model;

/**
 * �豸ͳ�Ʒ�����Ϣ��ƽ̨������
 * 
 * �г�����Ϊ�豸��001����һ����������������
 *
 */
public interface IG445Info {
	
	/** ���������*/
	public String getOrgsyscoding();
	
	/** ��������*/
	public String getOrgname();
	
	/** ȡ�ø���*/
	public Integer getCount();
	
	/** ȡ����ռ�ٷ���*/
	public String getProportion();
	
	/** ������ռ�ٷ���*/
	public void setProportion(String proportion);
	
}