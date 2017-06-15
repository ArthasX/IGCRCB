/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.dao.CustomQueryDAO;

/**
 * 概述：自定义查询通用BL 功能描述： 创建记录：2016/8/10 修改记录：
 */
public class CustomQueryBLImpl extends BaseBLImpl implements CustomQueryBL {

	private CustomQueryDAO customQueryDAO;

	public void setCustomQueryDAO(CustomQueryDAO customQueryDAO) {
		this.customQueryDAO = customQueryDAO;
	}

	public List<Map<String, Object>> queryBySql(String sql, Map<String, Type> resultField) throws BLException {
		return customQueryDAO.queryBySql(sql, resultField);
	}

}