package com.deliverik.framework.dao.hibernate;

/**
 * �߼�ɾ��ʵ��ӿ�
 * 
 * @author SQS Yoshinaga
 */
public interface LogicalDelete {

	/**
	 * �߼�ɾ����ʶȡ��
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();

	/**
	 * �߼�ɾ����ʶ�趨
	 * @param deleteflag �߼�ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag);

}
