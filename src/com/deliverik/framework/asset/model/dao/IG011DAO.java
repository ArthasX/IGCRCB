package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;




/**
 * �豸ͳ�Ʒ���
 */
public interface IG011DAO extends BaseHibernateDAO<IG011Info> {
	
	/** ���ղ�ѯ����(��������)ͳ���豸��Ϣ*/
	public List<IG011Info> findByCond(final IG011SearchCond cond, final int start, final int count);
	
	/** ���ղ�ѯ����(ʹ�û���)ͳ���豸��Ϣ*/
	public List<IG011Info> findIG011InfoCondByUseOrg(final IG011SearchCond cond, final int start, final int count);

	/**
	 * �����ʲ�ģ�Ͳ����ͳ�Ƹ��ʲ�ģ���µ��ʲ�����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG011Info> findByCond(final IG011SearchCond cond);
	
}
