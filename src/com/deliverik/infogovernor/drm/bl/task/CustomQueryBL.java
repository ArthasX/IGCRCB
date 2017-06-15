/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 概述： 通用自定义查询接口 功能描述：通用自定义查询接口 创建记录：2016/8/10 修改记录：
 */
public interface CustomQueryBL extends BaseBL {

	/**
	 * 通用查询方法
	 * 
	 * @param sql
	 *            sql语句,参数直接拼上
	 * @param resultField
	 *            返回结果的Map字段类型 key=字段名,value=字段类型(org.hibernate.type.Type)
	 * @return
	 * @throws BLException
	 */
	public List<Map<String, Object>> queryBySql(String sql, Map<String, Type> resultField) throws BLException;
}