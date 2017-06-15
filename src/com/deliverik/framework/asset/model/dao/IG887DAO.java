package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * 历史版本更新时间查询DAO接口
 * 
 */
public interface IG887DAO extends BaseHibernateDAO<IG887Info> {

	/**
	 *  获取资产历史版本更新时间
	 * 
	 * @param eiid 资产ID
	 * @return 各版本更新时间
	 */
	public List<IG887Info> searchVersionUpdateTime(Integer eiid);
}
