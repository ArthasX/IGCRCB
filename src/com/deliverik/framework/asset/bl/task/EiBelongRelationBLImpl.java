/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCond;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCondImpl;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCond;
import com.deliverik.framework.asset.model.dao.EiBelongRelationDAO;
import com.deliverik.framework.asset.model.entity.EiBelongRelationTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;

/**
  * 概述: 配置所属关系表业务逻辑实现
  * 功能描述: 配置所属关系表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class EiBelongRelationBLImpl extends BaseBLImpl implements
		EiBelongRelationBL {

	/** 配置所属关系表DAO接口 */
	protected EiBelongRelationDAO eiBelongRelationDAO;
	
	/**
	 * 配置所属关系表DAO接口设定
	 *
	 * @param eiBelongRelationDAO配置所属关系表DAO接口
	 */
	public void setEiBelongRelationDAO(EiBelongRelationDAO eiBelongRelationDAO) {
		this.eiBelongRelationDAO = eiBelongRelationDAO;
	}

	/**
	 * 配置所属关系表实例取得
	 *
	 * @return 配置所属关系表实例
	 */
	public EiBelongRelationTB getEiBelongRelationTBInstance() {
		return new EiBelongRelationTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation() {
		return eiBelongRelationDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public EiBelongRelationInfo searchEiBelongRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiBelongRelationSearchCond cond) {
		return eiBelongRelationDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation(
			EiBelongRelationSearchCond cond) {
		return eiBelongRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation(
			EiBelongRelationSearchCond cond, int start,
			int count) {
		return eiBelongRelationDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public EiBelongRelationInfo registEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException {
		return eiBelongRelationDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public EiBelongRelationInfo updateEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getBrid());
		return eiBelongRelationDAO.save(instance);
	}
	
	/**
	 * 资产所属关系信息版本升级处理
	 * 
	 * @param eiid 变更资产ID
	 * @param eiversion 关系表中资产最新大版本
	 * @param eismallversion 关闭表中资产最新小版本
	 * @param neweiversion 资产最新大版本
	 * @param neweismallversion 资产最新小版本
	 * @throws BLException 
	 */
	public void upgradeEntityItemRelation(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException {
		//当前时间
		String dataTime = IGStringUtils.getCurrentDateTime();
		//检索关系表中资产最新版本关系（正向）
		EiBelongRelationSearchCondImpl condPar = new EiBelongRelationSearchCondImpl();
		condPar.setBrpareiid(eiid.toString());//资产ID
		condPar.setBrparversion(eiversion.toString());//资产大版本
		condPar.setBrparsmallversion(eismallversion.toString());//资产小版本
		List<EiBelongRelationInfo> eirList = this.searchMaxEiBelongRelation(condPar);
		EiBelongRelationTB eirTB = null;
		for(EiBelongRelationInfo eir : eirList) {
			eirTB = (EiBelongRelationTB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrparversion(neweiversion);
			eirTB.setBrparsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.eiBelongRelationDAO.save(eirTB);
		}
		//检索关系表中资产最新版本关系（反向）
		EiBelongRelationSearchCondImpl condCld = new EiBelongRelationSearchCondImpl();
		condCld.setBrcldeiid(eiid.toString());//资产ID
		condCld.setBrcldversion(eiversion.toString());//资产大版本
		condCld.setBrcldsmallversion(eismallversion.toString());//资产小版本
		eirList = this.searchMaxEiBelongRelation(condCld);
		for(EiBelongRelationInfo eir : eirList) {
			eirTB = (EiBelongRelationTB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrcldversion(neweiversion);
			eirTB.setBrcldsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.eiBelongRelationDAO.save(eirTB);
		}
		
	}


	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiBelongRelationByPK(Integer pk)
		throws BLException {
		eiBelongRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException {
		eiBelongRelationDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public EiBelongRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		EiBelongRelationInfo instance = eiBelongRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiBelongRelationVWInfo> searchEiBelongRelationVW(EiBelongRelationVWSearchCond cond) {
		return this.eiBelongRelationDAO.searchEiBelongRelationVW(cond);
	}
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EiBelongRelationInfo> searchMaxEiBelongRelation(EiBelongRelationSearchCond cond) {
		return this.eiBelongRelationDAO.searchMaxEiBelongRelation(cond);
	}

}