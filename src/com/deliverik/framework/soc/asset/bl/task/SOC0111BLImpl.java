/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0111DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0111PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;

/**
  * 概述: 资产域定义表业务逻辑实现
  * 功能描述: 资产域定义表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SOC0111BLImpl extends BaseBLImpl implements
		SOC0111BL {

	/** 资产域定义表DAO接口 */
	protected SOC0111DAO soc0111DAO;
	
	/**
	 * 资产域定义表DAO接口设定
	 *
	 * @param eiDomainDefDAO资产域定义表DAO接口
	 */
	public void setSoc0111DAO(SOC0111DAO soc0111DAO) {
		this.soc0111DAO = soc0111DAO;
	}

	/**
	 * 资产域定义表实例取得
	 *
	 * @return 资产域定义表实例
	 */
	public SOC0111TB getEiDomainDefTBInstance() {
		return new SOC0111TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0111Info> searchEiDomainDef() {
		return soc0111DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0111Info searchEiDomainDefByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0111SearchCond cond) {
		return soc0111DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond) {
		return soc0111DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond, int start,
			int count) {
		return soc0111DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0111Info registEiDomainDef(SOC0111Info instance)
		throws BLException {
		return soc0111DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0111Info updateEiDomainDef(SOC0111Info instance)
		throws BLException {
		checkExistInstance(new SOC0111PK(instance.getEiddid(),instance.getVersion()));
		return soc0111DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiDomainDefByPK(Serializable pk)
		throws BLException {
		soc0111DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiDomainDef(SOC0111Info instance)
		throws BLException {
		soc0111DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0111Info checkExistInstance(Serializable pk)
		throws BLException {
		SOC0111Info instance = soc0111DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "资产域定义基本");
		}
		return instance;
	}
	/**
	 * 查询最大EiddId
	 * @return 
	 * @throws BLException
	 */
	public Integer findMaxEiddId() throws BLException{
		return soc0111DAO.findMaxEiddId();
	}
	
	/**
	 * 获取最新版本域
	 * @param eiddid 域ID
	 * @return 最新版本域
	 * @throws BLException 
	 */
	public SOC0111Info searchDomainMaxVersion(Integer eiddid) throws BLException {
		SOC0111SearchCondImpl cond = new SOC0111SearchCondImpl();
		cond.setEiddid_eq(eiddid.toString());
		List<SOC0111Info> eiDomainDefList = this.searchEiDomainDef(cond);
		if(eiDomainDefList.size() != 1) {
			throw new BLException("IGCO10000.E004", "资产域定义基本");
		}
		return eiDomainDefList.get(0);
	}

	/**
	 * 获取资产域定义版本
	 * @param eiddid
	 * @param version
	 * @return
	 * @throws BLException
	 */
	public List<SOC0111Info> searchEiDomainDefByPK(Integer eiddid,
			Integer version) throws BLException {
		return soc0111DAO.searchEiDomainDefByPK(eiddid,version);
	}
}