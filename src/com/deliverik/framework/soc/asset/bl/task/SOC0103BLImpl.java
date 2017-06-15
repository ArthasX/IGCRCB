/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0103DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;

/**
  * 概述: 审计对比结果信息表业务逻辑实现
  * 功能描述: 审计对比结果信息表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class SOC0103BLImpl extends BaseBLImpl implements
		SOC0103BL {

	/** 审计对比结果信息表DAO接口 */
	protected SOC0103DAO soc0103DAO;
	
	/**
	 * 审计对比结果信息表DAO接口设定
	 *
	 * @param soc0103DAO 审计对比结果信息表DAO接口
	 */
	public void setsoc0103DAO(SOC0103DAO soc0103DAO) {
		this.soc0103DAO = soc0103DAO;
	}

	/**
	 * 审计对比结果信息表实例取得
	 *
	 * @return 审计对比结果信息表实例
	 */
	public SOC0103TB getSOC0103Instance() {
		return new SOC0103TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0103Info> searchSOC0103() {
		return soc0103DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0103Info searchSOC0103ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0103SearchCond cond) {
		return soc0103DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond) {
		return soc0103DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond, int start,
			int count) {
		return soc0103DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0103Info registSOC0103(SOC0103Info instance)
		throws BLException {
		return soc0103DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0103Info updateSOC0103(SOC0103Info instance)
		throws BLException {
		checkExistInstance(instance.getAurid());
		return soc0103DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0103ByPK(Integer pk)
		throws BLException {
		soc0103DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0103(SOC0103Info instance)
		throws BLException {
		soc0103DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0103Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0103Info instance = soc0103DAO.findByPK(pk);
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
	public Integer updateSOC0103Without(SOC0103SearchCond cond)
		throws BLException{
		return soc0103DAO.updateSOC0103Without(cond);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0137Info> searchAuditResultOne(SOC0103SearchCond cond)
			throws BLException {
		return soc0103DAO.findByCondOne(cond);
	}

}