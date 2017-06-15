/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0600SearchCond;

/**
 * 
 * �ʲ��������dao�ӿ�
 * 
 */
public interface SOC0600DAO extends BaseHibernateDAO<SOC0600Info> {
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public List<SOC0600Info> findByCond(final SOC0600SearchCond cond);
}
