/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0105DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0105TB;

/**
  * 概述: 审计待处理任务业务逻辑实现
  * 功能描述: 审计待处理任务业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class SOC0105BLImpl extends BaseBLImpl implements
		SOC0105BL {

	/** 审计待处理任务DAO接口 */
	protected SOC0105DAO soc0105DAO;
	
	/**
	 * 审计待处理任务DAO接口设定
	 *
	 * @param soc0105DAO 审计待处理任务DAO接口
	 */
	public void setsoc0105DAO(SOC0105DAO soc0105DAO) {
		this.soc0105DAO = soc0105DAO;
	}

	/**
	 * 审计待处理任务实例取得
	 *
	 * @return 审计待处理任务实例
	 */
	public SOC0105TB getSOC0105Instance() {
		return new SOC0105TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0105Info> searchSOC0105() {
		return soc0105DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0105Info searchSOC0105ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0105SearchCond cond) {
		return soc0105DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0105Info> searchSOC0105(
			SOC0105SearchCond cond) {
		return soc0105DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0105Info> searchSOC0105(
			SOC0105SearchCond cond, int start,
			int count) {
		return soc0105DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0105Info registSOC0105(SOC0105Info instance)
		throws BLException {
		return soc0105DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0105Info updateSOC0105(SOC0105Info instance)
		throws BLException {
		checkExistInstance(instance.getAuwtid());
		return soc0105DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0105ByPK(Integer pk)
		throws BLException {
		soc0105DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0105(SOC0105Info instance)
		throws BLException {
		soc0105DAO.delete(instance);
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteSOC0105All(){
		return soc0105DAO.deleteAll();
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0105Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0105Info instance = soc0105DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}