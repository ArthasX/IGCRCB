/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;
import com.deliverik.infogovernor.rdp.model.condition.ExcuteResultSearchCond;
import com.deliverik.infogovernor.rdp.model.dao.ExcuteResultDAO;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultPK;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultTB;

/**
  * 概述: ExcuteResult业务逻辑实现
  * 功能描述: ExcuteResult业务逻辑实现
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
public class ExcuteResultBLImpl extends BaseBLImpl implements
		ExcuteResultBL {

	/** ExcuteResultDAO接口 */
	protected ExcuteResultDAO excuteResultDAO;
	
	/**
	 * ExcuteResultDAO接口设定
	 *
	 * @param excuteResultDAO ExcuteResultDAO接口
	 */
	public void setExcuteResultDAO(ExcuteResultDAO excuteResultDAO) {
		this.excuteResultDAO = excuteResultDAO;
	}

	/**
	 * ExcuteResult实例取得
	 *
	 * @return ExcuteResult实例
	 */
	public ExcuteResultTB getExcuteResultTBInstance() {
		return new ExcuteResultTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ExcuteResultInfo> searchExcuteResult() {
		return excuteResultDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ExcuteResultInfo searchExcuteResultByPK(ExcuteResultPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ExcuteResultSearchCond cond) {
		return excuteResultDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ExcuteResultInfo> searchExcuteResult(
			ExcuteResultSearchCond cond) {
		return excuteResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ExcuteResultInfo> searchExcuteResult(
			ExcuteResultSearchCond cond, int start,
			int count) {
		return excuteResultDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ExcuteResultInfo registExcuteResult(ExcuteResultInfo instance)
		throws BLException {
		return excuteResultDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ExcuteResultInfo updateExcuteResult(ExcuteResultInfo instance)
		throws BLException {
		checkExistInstance(new ExcuteResultPK(instance.getHostid(), instance.getTaskid()));
		return excuteResultDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteExcuteResultByPK(ExcuteResultPK pk)
		throws BLException {
		excuteResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteExcuteResult(ExcuteResultInfo instance)
		throws BLException {
		excuteResultDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ExcuteResultInfo checkExistInstance(ExcuteResultPK pk)
		throws BLException {
		ExcuteResultInfo instance = excuteResultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}