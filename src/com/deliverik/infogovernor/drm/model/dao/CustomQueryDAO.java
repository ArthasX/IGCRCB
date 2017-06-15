/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 概述：自定义查询通用DAO 功能描述：自定义查询通用DAO 创建记录：2016/8/10
 */
public interface CustomQueryDAO extends BaseHibernateDAO {


	public List<Map<String, Object>> queryBySql(String sql, Map<String, Type> resultField);
}