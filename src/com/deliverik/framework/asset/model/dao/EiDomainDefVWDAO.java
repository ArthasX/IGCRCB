/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefVWInfo;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ����: ���°�����Ϣ��ͼDAO�ӿ�
 * ��������: ���°�����Ϣ��ͼDAO�ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface EiDomainDefVWDAO extends BaseHibernateDAO<EiDomainDefVWInfo> {
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDefVWInfo> findAll();

	
	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	public EiDomainDefVWInfo searchEiDomainDefVW(String eiddid);

}
