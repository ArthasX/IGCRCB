/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareprocessInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareprocessSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareprocessDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareprocessTB;

/**
  * 概述: 对比记录业务逻辑实现
  * 功能描述: 对比记录业务逻辑实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareprocessBLImpl extends BaseBLImpl implements
		CompareprocessBL {

	/** 对比记录DAO接口 */
	protected CompareprocessDAO compareprocessDAO;
	
	/**
	 * 对比记录DAO接口设定
	 *
	 * @param compareprocessDAO 对比记录DAO接口
	 */
	public void setCompareprocessDAO(CompareprocessDAO compareprocessDAO) {
		this.compareprocessDAO = compareprocessDAO;
	}

	/**
	 * 对比记录实例取得
	 *
	 * @return 对比记录实例
	 */
	public CompareprocessTB getCompareprocessTBInstance() {
		return new CompareprocessTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareprocessInfo> searchCompareprocess() {
		return compareprocessDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareprocessInfo searchCompareprocessByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareprocessSearchCond cond) {
		return compareprocessDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareprocessInfo> searchCompareprocess(
			CompareprocessSearchCond cond) {
		return compareprocessDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareprocessInfo> searchCompareprocess(
			CompareprocessSearchCond cond, int start,
			int count) {
		return compareprocessDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareprocessInfo registCompareprocess(CompareprocessInfo instance)
		throws BLException {
		return compareprocessDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareprocessInfo updateCompareprocess(CompareprocessInfo instance)
		throws BLException {
		checkExistInstance(instance.getCpid());
		return compareprocessDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareprocessByPK(Integer pk)
		throws BLException {
		compareprocessDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareprocess(CompareprocessInfo instance)
		throws BLException {
		compareprocessDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CompareprocessInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareprocessInfo instance = compareprocessDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}