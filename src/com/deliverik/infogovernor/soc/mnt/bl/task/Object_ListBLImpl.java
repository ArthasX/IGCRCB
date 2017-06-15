/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.Object_ListDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.Object_ListTB;

/**
  * 概述: 对象集合表业务逻辑实现
  * 功能描述: 对象集合表业务逻辑实现
  * 创建记录: 2012/05/11
  * 修改记录: 
  */
public class Object_ListBLImpl extends BaseBLImpl implements
		Object_ListBL {

	/** 对象集合表DAO接口 */
	protected Object_ListDAO object_ListDAO;
	
	/**
	 * 对象集合表DAO接口设定
	 *
	 * @param object_ListDAO 对象集合表DAO接口
	 */
	public void setObject_ListDAO(Object_ListDAO object_ListDAO) {
		this.object_ListDAO = object_ListDAO;
	}

	/**
	 * 对象集合表实例取得
	 *
	 * @return 对象集合表实例
	 */
	public Object_ListTB getObject_ListTBInstance() {
		return new Object_ListTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Object_ListInfo> searchObject_List() {
		return object_ListDAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Object_ListSearchCond cond) {
		return object_ListDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Object_ListInfo> searchObject_List(
			Object_ListSearchCond cond) {
		return object_ListDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Object_ListInfo> searchObject_List(
			Object_ListSearchCond cond, int start,
			int count) {
		return object_ListDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Object_ListInfo registObject_List(Object_ListInfo instance)
		throws BLException {
		return object_ListDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Object_ListInfo updateObject_List(Object_ListInfo instance)
		throws BLException {
		return object_ListDAO.save(instance);
	}


	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteObject_List(Object_ListInfo instance)
		throws BLException {
		object_ListDAO.delete(instance);
	}


}