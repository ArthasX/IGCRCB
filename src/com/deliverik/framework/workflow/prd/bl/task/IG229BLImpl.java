/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG229Info;
import com.deliverik.framework.workflow.prd.model.condition.IG229SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG229DAO;


 /**
  * <p>概述:流程评审详细记录表BL实现类</p>
  * <p>功能描述：1.持久化</p>
  * <p>			2.主键检索处理</p>
  * <p>			3.全件检索</p>
  * <p>			4.条件检索结果件数取得</p>
  * <p>			5.条件检索处理</p>
  * <p>			6.删除处理</p>
  * <p>创建记录：</p>
  */
public class IG229BLImpl extends BaseBLImpl implements
		IG229BL {

	protected IG229DAO ig229DAO;

	public void setIg229DAO(
			IG229DAO ig229DAO) {
		this.ig229DAO = ig229DAO;
	}

	/**
	 * 持久化处理
	 * 
	 * @param IG229Info实体类
	 * @return IG229Info实体类
	 */
	public IG229Info saveIG229Info(
			IG229Info ig229Info) throws BLException {
		return ig229DAO.save(ig229Info);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id 主键
	 * @return 检索结果
	 */
	public IG229Info findIG229InfoByPK(Integer id)
			throws BLException {
		return ig229DAO.findByPK(id);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<IG229Info> findAllIG229Info()
			throws BLException {
		return ig229DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG229SearchCond cond)
			throws BLException {
		return ig229DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG229Info> findIG229InfoByCond(
			IG229SearchCond cond, int start, int count)
			throws BLException {
		return ig229DAO.findByCond(cond, start, count);
	}

	/**
	 * 删除处理
	 * 
	 * @param IG229Info实体类
	 */
	public void deleteIG229Info(
			IG229Info processAssessmentDetail) throws BLException {
		ig229DAO.delete(processAssessmentDetail);
	}

}

