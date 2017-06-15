/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCondImpl;
import com.deliverik.framework.asset.model.dao.EiDomainDefDAO;
import com.deliverik.framework.asset.model.entity.EiDomainDefPK;
import com.deliverik.framework.asset.model.entity.EiDomainDefTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: 资产域定义表业务逻辑实现
  * 功能描述: 资产域定义表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class EiDomainDefBLImpl extends BaseBLImpl implements
		EiDomainDefBL {

	/** 资产域定义表DAO接口 */
	protected EiDomainDefDAO eiDomainDefDAO;
	
	/**
	 * 资产域定义表DAO接口设定
	 *
	 * @param eiDomainDefDAO资产域定义表DAO接口
	 */
	public void setEiDomainDefDAO(EiDomainDefDAO eiDomainDefDAO) {
		this.eiDomainDefDAO = eiDomainDefDAO;
	}

	/**
	 * 资产域定义表实例取得
	 *
	 * @return 资产域定义表实例
	 */
	public EiDomainDefTB getEiDomainDefTBInstance() {
		return new EiDomainDefTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiDomainDefInfo> searchEiDomainDef() {
		return eiDomainDefDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public EiDomainDefInfo searchEiDomainDefByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiDomainDefSearchCond cond) {
		return eiDomainDefDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiDomainDefInfo> searchEiDomainDef(
			EiDomainDefSearchCond cond) {
		return eiDomainDefDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiDomainDefInfo> searchEiDomainDef(
			EiDomainDefSearchCond cond, int start,
			int count) {
		return eiDomainDefDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public EiDomainDefInfo registEiDomainDef(EiDomainDefInfo instance)
		throws BLException {
		return eiDomainDefDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public EiDomainDefInfo updateEiDomainDef(EiDomainDefInfo instance)
		throws BLException {
		checkExistInstance(new EiDomainDefPK(instance.getEiddid(),instance.getVersion()));
		return eiDomainDefDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiDomainDefByPK(Serializable pk)
		throws BLException {
		eiDomainDefDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiDomainDef(EiDomainDefInfo instance)
		throws BLException {
		eiDomainDefDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public EiDomainDefInfo checkExistInstance(Serializable pk)
		throws BLException {
		EiDomainDefInfo instance = eiDomainDefDAO.findByPK(pk);
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
		return eiDomainDefDAO.findMaxEiddId();
	}
	
	/**
	 * 获取最新版本域
	 * @param eiddid 域ID
	 * @return 最新版本域
	 * @throws BLException 
	 */
	public EiDomainDefInfo searchDomainMaxVersion(Integer eiddid) throws BLException {
		EiDomainDefSearchCondImpl cond = new EiDomainDefSearchCondImpl();
		cond.setEiddid_eq(eiddid.toString());
		List<EiDomainDefInfo> eiDomainDefList = this.searchEiDomainDef(cond);
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
	public List<EiDomainDefInfo> searchEiDomainDefByPK(Integer eiddid,
			Integer version) throws BLException {
		return eiDomainDefDAO.searchEiDomainDefByPK(eiddid,version);
	}
}