/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;

/**
 * ����:�ʲ����ϵ��ϢDAO�ӿ�
 * �����������ʲ����ϵ��ϢDAO�ӿ�
 * �����ˣ�����
 * ������¼�� 2013-10-21
 * �޸ļ�¼��
 */

public interface SOC0607DAO extends BaseHibernateDAO<SOC0119Info> {
	/**
	 * ������ѯ����
	 *
	 * @param eirid ��ϵ����
	 * @return SOC0119Info ��ϵʵ��
	 */
	public SOC0119Info checkExistEntityItemRelation(final Integer eirid);
}
