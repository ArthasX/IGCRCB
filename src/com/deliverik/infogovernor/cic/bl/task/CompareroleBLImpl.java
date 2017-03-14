/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareroleInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareroleSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareroleDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareroleTB;

/**
  * 概述: 对比规则业务逻辑实现
  * 功能描述: 对比规则业务逻辑实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareroleBLImpl extends BaseBLImpl implements
		CompareroleBL {

	/** 对比规则DAO接口 */
	protected CompareroleDAO compareroleDAO;
	
	/**
	 * 对比规则DAO接口设定
	 *
	 * @param compareroleDAO 对比规则DAO接口
	 */
	public void setCompareroleDAO(CompareroleDAO compareroleDAO) {
		this.compareroleDAO = compareroleDAO;
	}

	/**
	 * 对比规则实例取得
	 *
	 * @return 对比规则实例
	 */
	public CompareroleTB getCompareroleTBInstance() {
		return new CompareroleTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareroleInfo> searchComparerole() {
		return compareroleDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareroleInfo searchCompareroleByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareroleSearchCond cond) {
		return compareroleDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond) {
		return compareroleDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareroleInfo> searchComparerole(
			CompareroleSearchCond cond, int start,
			int count) {
		return compareroleDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareroleInfo registComparerole(CompareroleInfo instance)
		throws BLException {
		return compareroleDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareroleInfo updateComparerole(CompareroleInfo instance)
		throws BLException {
		checkExistInstance(instance.getCrid());
		return compareroleDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareroleByPK(Integer pk)
		throws BLException {
		compareroleDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteComparerole(CompareroleInfo instance)
		throws BLException {
		compareroleDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CompareroleInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareroleInfo instance = compareroleDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * 保存
	 * @param instantce
	 * @return
	 */
	public CompareroleInfo save(CompareroleInfo instantce)throws BLException{
		return compareroleDAO.save(instantce);
	}


	
	/**
     * 根据关系表查询规则及对象
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<CompareroleInfo> searchCompareroleByRelation(CompareroleSearchCond cond) throws BLException {
        return compareroleDAO.searchCompareroleByRelation(cond);
    }
}