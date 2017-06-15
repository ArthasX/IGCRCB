package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;




/**
 * �豸ͳ�Ʒ���
 */
public interface IG445DAO extends BaseHibernateDAO<IG445Info> {
	
	/** ���ղ�ѯ����(��������)ͳ���豸��Ϣ*/
	public List<IG445Info> findByCond(final IG445SearchCond cond, final int start, final int count);
	

}
