/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.model.dao;

import java.util.ArrayList;

import com.deliverik.framework.asset.FsLvVgInfo;
import com.deliverik.framework.asset.model.condition.FsLvVgSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 概述: 设备关系信息（FS-LV-VG）DAO接口
 * 功能描述: 设备关系信息（FS-LV-VG）DAO接口
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public interface FsLvVgDao extends BaseHibernateDAO<FsLvVgInfo> {

	public ArrayList<FsLvVgInfo> searchFsLvVg(FsLvVgSearchCond cond);

}
