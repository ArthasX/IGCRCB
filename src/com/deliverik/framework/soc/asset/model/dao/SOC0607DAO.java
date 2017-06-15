/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0119Info;

/**
 * 概述:资产项关系信息DAO接口
 * 功能描述：资产项关系信息DAO接口
 * 创建人：付彬
 * 创建记录： 2013-10-21
 * 修改记录：
 */

public interface SOC0607DAO extends BaseHibernateDAO<SOC0119Info> {
	/**
	 * 主键查询处理
	 *
	 * @param eirid 关系主键
	 * @return SOC0119Info 关系实体
	 */
	public SOC0119Info checkExistEntityItemRelation(final Integer eirid);
}
