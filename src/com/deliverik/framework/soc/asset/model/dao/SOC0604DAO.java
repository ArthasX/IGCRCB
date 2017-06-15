/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;



import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;





/**
 * ��������ͳ�Ʒ���
 */
public interface SOC0604DAO extends BaseHibernateDAO<SOC0604Info> {
	
	public List<SOC0604Info> findByCond(final SOC0604SearchCond cond, final int start, final int count);
}
