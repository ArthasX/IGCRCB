/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: NMSDAO����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMSBaseDAO<T> extends BaseHibernateDAO<T> {

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion();

	/**
	 * �汾�趨
	 * @param version �汾
	 */
	public void setVersion(Integer version);
	
	/**
	 * ����������ǰ�汾����ڣ���ɾ���������ݣ����򴴽���
	 */
	public void upateVersionForCreateTable();
	
	/**
	 * У�鵱ǰ���Ƿ����
	 * @return true ���� false ������
	 */
	public boolean checkTableExits();
	
	
	/**
	 * ɾ����
	 */
	public void dropTable();
}
