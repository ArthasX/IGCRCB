/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0114Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0114SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0114DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0114PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0114TB;

/**
  * 概述: 实体链路图业务逻辑实现
  * 功能描述: 实体链路图业务逻辑实现
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public class SOC0114BLImpl extends BaseBLImpl implements
		SOC0114BL {

	/**
	 * 实体链路图DAO接口设定
	 *
	 * @param soc0114DAO 实体链路图DAO接口
	 */
	public void setSoc0114DAO(SOC0114DAO soc0114DAO) {
		this.soc0114DAO = soc0114DAO;
	}

	/** 实体链路图DAO接口 */
	protected SOC0114DAO soc0114DAO;
	


	/**
	 * 实体链路图实例取得
	 *
	 * @return 实体链路图实例
	 */
	public SOC0114TB getEiLinkMapTBInstance() {
		return new SOC0114TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0114Info> searchEiLinkMap() {
		return soc0114DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0114Info searchEiLinkMapByPK(SOC0114PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0114SearchCond cond) {
		return soc0114DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond) {
		return soc0114DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0114Info> searchEiLinkMap(
			SOC0114SearchCond cond, int start,
			int count) {
		return soc0114DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0114Info registEiLinkMap(SOC0114Info instance)
		throws BLException {
		return soc0114DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0114Info updateEiLinkMap(SOC0114Info instance)
		throws BLException {
		checkExistInstance(new SOC0114PK(instance.getDomainid(), instance.getDomainversion(), instance.getLinkid(), instance.getLinkorder()));
		return soc0114DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiLinkMapByPK(SOC0114PK pk)
		throws BLException {
		soc0114DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiLinkMap(SOC0114Info instance)
		throws BLException {
		soc0114DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0114Info checkExistInstance(SOC0114PK pk)
		throws BLException {
		SOC0114Info instance = soc0114DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 拓扑图链路检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0114Info> queryEiLinkMapList(SOC0114SearchCond cond) {
		return this.soc0114DAO.queryEiLinkMapList(cond);
	}
	
	/**
	 * 影响CI检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> queryImpactCI(final SOC0114SearchCond cond) {
		return this.soc0114DAO.queryImpactCI(cond);
	}

	public List<SOC0114Info> searchEiLinkMapByOtherEiid(
			EiLinkMapSearchCondImpl emCond) {
		return this.soc0114DAO.searchEiLinkMapByOtherEiid(emCond);
	}
	
	/**
	 * 根据eiid 删除链路
	 * @param eiid
	 */
	public void delByEiid (Integer eiid)throws BLException{
		this.soc0114DAO.delByEiid(eiid);
	}

	/**
	 * 根据eiid查询与其相关的业务系统eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchLinkByEiid(Integer eiid)throws BLException{
		return this.soc0114DAO.searchLinkByEiid(eiid);
	}
}