/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.dao;

import java.util.ArrayList;

import com.deliverik.framework.asset.VgPvMetaInfo;
import com.deliverik.framework.asset.model.condition.VgPvMetaSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 概述: 设备关系信息DAO接口(VG-PV-Meta)
 * 功能描述: 设备关系信息DAO接口(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface VgPvMetaDao extends BaseHibernateDAO<VgPvMetaInfo> {

	public ArrayList<VgPvMetaInfo> searchVgPvMeta(VgPvMetaSearchCond cond);

}
