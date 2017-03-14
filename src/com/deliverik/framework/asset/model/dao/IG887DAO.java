package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * ��ʷ�汾����ʱ���ѯDAO�ӿ�
 * 
 */
public interface IG887DAO extends BaseHibernateDAO<IG887Info> {

	/**
	 *  ��ȡ�ʲ���ʷ�汾����ʱ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return ���汾����ʱ��
	 */
	public List<IG887Info> searchVersionUpdateTime(Integer eiid);
}
