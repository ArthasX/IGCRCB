/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;
import com.deliverik.infogovernor.cic.model.condition.ComparescopeSearchCond;
import com.deliverik.infogovernor.cic.model.dao.ComparescopeDAO;
import com.deliverik.infogovernor.cic.model.entity.ComparescopeTB;

/**
  * 概述: 对比域业务逻辑实现
  * 功能描述: 对比域业务逻辑实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class ComparescopeBLImpl extends BaseBLImpl implements
		ComparescopeBL {

	/** 对比域DAO接口 */
	protected ComparescopeDAO comparescopeDAO;
	
	/**
	 * 对比域DAO接口设定
	 *
	 * @param comparescopeDAO 对比域DAO接口
	 */
	public void setComparescopeDAO(ComparescopeDAO comparescopeDAO) {
		this.comparescopeDAO = comparescopeDAO;
	}

	/**
	 * 对比域实例取得
	 *
	 * @return 对比域实例
	 */
	public ComparescopeTB getComparescopeTBInstance() {
		return new ComparescopeTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ComparescopeInfo> searchComparescope() {
		return comparescopeDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ComparescopeInfo searchComparescopeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ComparescopeSearchCond cond) {
		return comparescopeDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond) {
		return comparescopeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond, int start,
			int count) {
		return comparescopeDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ComparescopeInfo registComparescope(ComparescopeInfo instance)
		throws BLException {
		return comparescopeDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ComparescopeInfo updateComparescope(ComparescopeInfo instance)
		throws BLException {
		checkExistInstance(instance.getCsid());
		return comparescopeDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteComparescopeByPK(Integer pk)
		throws BLException {
		comparescopeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteComparescope(ComparescopeInfo instance)
		throws BLException {
		comparescopeDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ComparescopeInfo checkExistInstance(Integer pk)
		throws BLException {
		ComparescopeInfo instance = comparescopeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}