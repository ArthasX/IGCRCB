/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0125Info;

/**
 * ����: ���°�����Ϣ��ͼDAO�ӿ�
 * ��������: ���°�����Ϣ��ͼDAO�ӿ�
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface SOC0125DAO extends BaseHibernateDAO<SOC0125Info> {
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0125Info> findAll();

	
	/**
	 * ����eiddid��ѯ
	 * @param eiddid
	 * @return
	 */
	public SOC0125Info searchEiDomainDefVW(String eiddid);

}
