/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0101Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0101SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0101DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0101TB;

/**
  * 概述: 审计资产属性表业务逻辑实现
  * 功能描述: 审计资产属性表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class SOC0101BLImpl extends BaseBLImpl implements
		SOC0101BL {

	/** 审计资产属性表DAO接口 */
	protected SOC0101DAO soc0101DAO;
	
	/**
	 * 审计资产属性表DAO接口设定
	 *
	 * @param soc0101DAO 审计资产属性表DAO接口
	 */
	public void setsoc0101DAO(SOC0101DAO soc0101DAO) {
		this.soc0101DAO = soc0101DAO;
	}

	/**
	 * 审计资产属性表实例取得
	 *
	 * @return 审计资产属性表实例
	 */
	public SOC0101TB getSOC0101Instance() {
		return new SOC0101TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0101Info> searchSOC0101() {
		return soc0101DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0101Info searchSOC0101ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0101SearchCond cond) {
		return soc0101DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0101Info> searchSOC0101(
			SOC0101SearchCond cond) {
		return soc0101DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0101Info> searchSOC0101(
			SOC0101SearchCond cond, int start,
			int count) {
		return soc0101DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0101Info registSOC0101(SOC0101Info instance)
		throws BLException {
		return soc0101DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0101Info updateSOC0101(SOC0101Info instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return soc0101DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0101ByPK(Integer pk)
		throws BLException {
		soc0101DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0101(SOC0101Info instance)
		throws BLException {
		soc0101DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0101Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0101Info instance = soc0101DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 检索资产属性及属性对比分类
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0101Info> searchSOC0101ForAucmptype(Integer eiid){
		return soc0101DAO.searchSOC0101ForAucmptype(eiid);
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteSOC0101(){
		return soc0101DAO.deleteSOC0101();
	}

}