package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0128Info;



/**
 * 历史版本更新时间查询DAO接口
 * 
 */
public interface SOC0128DAO extends BaseHibernateDAO<SOC0128Info> {

	/**
	 *  获取资产历史版本更新时间
	 * 
	 * @param eiid 资产ID
	 * @return 各版本更新时间
	 */
	public List<SOC0128Info> searchVersionUpdateTime(Integer eiid);
}
