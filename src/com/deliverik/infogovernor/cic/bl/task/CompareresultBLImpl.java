/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareresultInfo;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareresultSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareresultDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareresultTB;

/**
  * 概述: 比对结果业务逻辑实现
  * 功能描述: 比对结果业务逻辑实现
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public class CompareresultBLImpl extends BaseBLImpl implements
		CompareresultBL {

	/** 比对结果DAO接口 */
	protected CompareresultDAO compareresultDAO;
	
	/**
	 * 比对结果DAO接口设定
	 *
	 * @param compareresultDAO 比对结果DAO接口
	 */
	public void setCompareresultDAO(CompareresultDAO compareresultDAO) {
		this.compareresultDAO = compareresultDAO;
	}

	/**
	 * 比对结果实例取得
	 *
	 * @return 比对结果实例
	 */
	public CompareresultTB getCompareresultTBInstance() {
		return new CompareresultTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CompareresultInfo> searchCompareresult() {
		return compareresultDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CompareresultInfo searchCompareresultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CompareresultSearchCond cond) {
		return compareresultDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond) {
		return compareresultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CompareresultInfo> searchCompareresult(
			CompareresultSearchCond cond, int start,
			int count) {
		return compareresultDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CompareresultInfo registCompareresult(CompareresultInfo instance)
		throws BLException {
		return compareresultDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CompareresultInfo updateCompareresult(CompareresultInfo instance)
		throws BLException {
		checkExistInstance(instance.getCrid());
		return compareresultDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCompareresultByPK(Integer pk)
		throws BLException {
		compareresultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCompareresult(CompareresultInfo instance)
		throws BLException {
		compareresultDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CompareresultInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareresultInfo instance = compareresultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<CompareresultVWInfo> searchCompareresultVW(CompareresultSearchCond cond) throws BLException {
        return compareresultDAO.searchCompareresultVW(cond);
    }
    
    /**
     * 根据对象比对结果标题List
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<Object[]> getEnameList(final CompareresultSearchCond cond) throws BLException {
        return compareresultDAO.getEnameList(cond);
    }
}