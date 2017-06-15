package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0128Info;



/**
 * ��ʷ�汾����ʱ���ѯDAO�ӿ�
 * 
 */
public interface SOC0128DAO extends BaseHibernateDAO<SOC0128Info> {

	/**
	 *  ��ȡ�ʲ���ʷ�汾����ʱ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return ���汾����ʱ��
	 */
	public List<SOC0128Info> searchVersionUpdateTime(Integer eiid);
}
