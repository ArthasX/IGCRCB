/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCond;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.dao.EiLinkMapDAO;
import com.deliverik.framework.asset.model.entity.EiLinkMapPK;
import com.deliverik.framework.asset.model.entity.EiLinkMapTB;

/**
  * 概述: 实体链路图业务逻辑实现
  * 功能描述: 实体链路图业务逻辑实现
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public class EiLinkMapBLImpl extends BaseBLImpl implements
		EiLinkMapBL {

	/** 实体链路图DAO接口 */
	protected EiLinkMapDAO eiLinkMapDAO;
	
	/**
	 * 实体链路图DAO接口设定
	 *
	 * @param eiLinkMapDAO 实体链路图DAO接口
	 */
	public void setEiLinkMapDAO(EiLinkMapDAO eiLinkMapDAO) {
		this.eiLinkMapDAO = eiLinkMapDAO;
	}

	/**
	 * 实体链路图实例取得
	 *
	 * @return 实体链路图实例
	 */
	public EiLinkMapTB getEiLinkMapTBInstance() {
		return new EiLinkMapTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiLinkMapInfo> searchEiLinkMap() {
		return eiLinkMapDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EiLinkMapInfo searchEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiLinkMapSearchCond cond) {
		return eiLinkMapDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond) {
		return eiLinkMapDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond, int start,
			int count) {
		return eiLinkMapDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EiLinkMapInfo registEiLinkMap(EiLinkMapInfo instance)
		throws BLException {
		return eiLinkMapDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EiLinkMapInfo updateEiLinkMap(EiLinkMapInfo instance)
		throws BLException {
		checkExistInstance(new EiLinkMapPK(instance.getDomainid(), instance.getDomainversion(), instance.getLinkid(), instance.getLinkorder()));
		return eiLinkMapDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException {
		eiLinkMapDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEiLinkMap(EiLinkMapInfo instance)
		throws BLException {
		eiLinkMapDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public EiLinkMapInfo checkExistInstance(EiLinkMapPK pk)
		throws BLException {
		EiLinkMapInfo instance = eiLinkMapDAO.findByPK(pk);
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
	public List<EiLinkMapInfo> queryEiLinkMapList(EiLinkMapSearchCond cond) {
		return this.eiLinkMapDAO.queryEiLinkMapList(cond);
	}
	
	/**
	 * 影响CI检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> queryImpactCI(final EiLinkMapSearchCond cond) {
		return this.eiLinkMapDAO.queryImpactCI(cond);
	}
	public List<EiLinkMapInfo> searchEiLinkMapByOtherEiid(
			EiLinkMapSearchCondImpl emCond) {
		return this.eiLinkMapDAO.searchEiLinkMapByOtherEiid(emCond);
	}

}