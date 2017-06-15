/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.asset.model.dao.CIResultDAO;
import com.deliverik.framework.asset.model.entity.CIResultTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: CI变更对比结果信息表业务逻辑实现
  * 功能描述: CI变更对比结果信息表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CIResultBLImpl extends BaseBLImpl implements
		CIResultBL {

	/** CI变更对比结果信息表DAO接口 */
	protected CIResultDAO ciResultDAO;
	
	/**
	 * CI变更对比结果信息表DAO接口设定
	 *
	 * @param ciResultDAO CI变更对比结果信息表DAO接口
	 */
	public void setCiResultDAO(CIResultDAO ciResultDAO) {
		this.ciResultDAO = ciResultDAO;
	}

	/**
	 * CI变更对比结果信息表实例取得
	 *
	 * @return CI变更对比结果信息表实例
	 */
	public CIResultTB getCIResultTBInstance() {
		return new CIResultTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIResultInfo> searchCIResult() {
		return ciResultDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIResultInfo searchCIResultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CIResultSearchCond cond) {
		return ciResultDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CIResultInfo> searchCIResult(
			CIResultSearchCond cond) {
		return ciResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CIResultInfo> searchCIResult(
			CIResultSearchCond cond, int start,
			int count) {
		return ciResultDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CIResultInfo registCIResult(CIResultInfo instance)
		throws BLException {
		return ciResultDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CIResultInfo updateCIResult(CIResultInfo instance)
		throws BLException {
		checkExistInstance(instance.getCirid());
		return ciResultDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCIResultByPK(Integer pk)
		throws BLException {
		ciResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCIResult(CIResultInfo instance)
		throws BLException {
		ciResultDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CIResultInfo checkExistInstance(Integer pk)
		throws BLException {
		CIResultInfo instance = ciResultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 更新当前数据为不合理
	 *
	 * @param cond 检索条件
	 */
	public Integer updateCIResultWithout(CIResultSearchCond cond)
		throws BLException{
		return ciResultDAO.updateCIResultWithout(cond);
	}

}