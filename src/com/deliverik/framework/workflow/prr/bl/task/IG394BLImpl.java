/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG394Info;
import com.deliverik.framework.workflow.prr.model.condition.IG394SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG394DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG394TB;

/**
  * 概述: 提醒记录表业务逻辑实现
  * 功能描述: 提醒记录表业务逻辑实现
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public class IG394BLImpl extends BaseBLImpl implements
		IG394BL {

	/** 提醒记录表DAO接口 */
	protected IG394DAO ig394DAO;
	
	/**
	 * 提醒记录表DAO接口设定
	 *
	 * @param ig394DAO 提醒记录表DAO接口
	 */
	public void setIg394DAO(IG394DAO ig394DAO) {
		this.ig394DAO = ig394DAO;
	}

	/**
	 * 提醒记录表实例取得
	 *
	 * @return 提醒记录表实例
	 */
	public IG394TB getIG394TBInstance() {
		return new IG394TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG394Info> searchIG394Info() {
		return ig394DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG394Info searchIG394InfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG394SearchCond cond) {
		return ig394DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG394Info> searchIG394Info(
			IG394SearchCond cond) {
		return ig394DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG394Info> searchIG394Info(
			IG394SearchCond cond, int start,
			int count) {
		return ig394DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param ig394Info 新增实例
	 * @return 新增实例
	 */
	public IG394Info registIG394Info(IG394Info ig394Info)
		throws BLException {
		return ig394DAO.save(ig394Info);
	}

	/**
	 * 修改处理
	 *
	 * @param ig394Info 修改实例
	 * @return 修改实例
	 */
	public IG394Info updateIG394Info(IG394Info ig394Info)
		throws BLException {
		checkExistInstance(ig394Info.getPnssid());
		return ig394DAO.save(ig394Info);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG394InfoByPK(Integer pk)
		throws BLException {
		ig394DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param ig394Info 删除实例
	 */
	public void deleteIG394Info(IG394Info ig394Info)
		throws BLException {
		ig394DAO.delete(ig394Info);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG394Info checkExistInstance(Integer pk)
		throws BLException {
		IG394Info instance = ig394DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}