/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0110DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;
import com.deliverik.framework.utility.IGStringUtils;

/**
  * 概述: 配置所属关系表业务逻辑实现
  * 功能描述: 配置所属关系表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SOC0110BLImpl extends BaseBLImpl implements
		SOC0110BL {

	/** 配置所属关系表DAO接口 */
	protected SOC0110DAO soc0110DAO;
	


	/**
	 * 配置所属关系表DAO接口设定
	 *
	 * @param soc0110DAO 配置所属关系表DAO接口
	 */
	public void setSoc0110DAO(SOC0110DAO soc0110DAO) {
		this.soc0110DAO = soc0110DAO;
	}

	/**
	 * 配置所属关系表实例取得
	 *
	 * @return 配置所属关系表实例
	 */
	public SOC0110TB getEiBelongRelationTBInstance() {
		return new SOC0110TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0110Info> searchEiBelongRelation() {
		return soc0110DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0110Info searchEiBelongRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0110SearchCond cond) {
		return soc0110DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchEiBelongRelation(
			SOC0110SearchCond cond) {
		return soc0110DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 根据父查询所有存在的关系码
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<String> searchBrassetrelationByBrpareiid(final SOC0110SearchCond cond){
		return soc0110DAO.searchBrassetrelationByBrpareiid(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchEiBelongRelation(
			SOC0110SearchCond cond, int start,
			int count) {
		return soc0110DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0110Info registEiBelongRelation(SOC0110Info instance)
		throws BLException {
		return soc0110DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0110Info updateEiBelongRelation(SOC0110Info instance)
		throws BLException {
		checkExistInstance(instance.getBrid());
		return soc0110DAO.save(instance);
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
		SOC0110SearchCondImpl condPar = new SOC0110SearchCondImpl();
		condPar.setBrpareiid(eiid.toString());//资产ID
		condPar.setBrparversion(eiversion.toString());//资产大版本
		condPar.setBrparsmallversion(eismallversion.toString());//资产小版本
		List<SOC0110Info> eirList = this.searchMaxEiBelongRelation(condPar);
		SOC0110TB eirTB = null;
		for(SOC0110Info eir : eirList) {
			eirTB = (SOC0110TB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrparversion(neweiversion);
			eirTB.setBrparsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.soc0110DAO.save(eirTB);
		}
		//检索关系表中资产最新版本关系（反向）
		SOC0110SearchCondImpl condCld = new SOC0110SearchCondImpl();
		condCld.setBrcldeiid(eiid.toString());//资产ID
		condCld.setBrcldversion(eiversion.toString());//资产大版本
		condCld.setBrcldsmallversion(eismallversion.toString());//资产小版本
		eirList = this.searchMaxEiBelongRelation(condCld);
		for(SOC0110Info eir : eirList) {
			eirTB = (SOC0110TB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrcldversion(neweiversion);
			eirTB.setBrcldsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.soc0110DAO.save(eirTB);
		}
		
	}


	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteEiBelongRelationByPK(Integer pk)
		throws BLException {
		soc0110DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteEiBelongRelation(SOC0110Info instance)
		throws BLException {
		soc0110DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0110Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0110Info instance = soc0110DAO.findByPK(pk);
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
	public List<SOC0127Info> searchEiBelongRelationVW(SOC0127SearchCond cond) {
		return this.soc0110DAO.searchEiBelongRelationVW(cond);
	}
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0127Info> searchEiBelongRelationVW2(SOC0127SearchCond cond) {
		return this.soc0110DAO.searchEiBelongRelationVW2(cond);
	}
	
	/**
	 * 配置包含关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchMaxEiBelongRelation(SOC0110SearchCond cond) {
		return this.soc0110DAO.searchMaxEiBelongRelation(cond);
	}

	/**
	 * 根据顶级设备查询该类型码数据
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0110Info> searchInBrassetrelationByEirootmark(final SOC0110SearchCondImpl cond){
		return this.soc0110DAO.searchInBrassetrelationByEirootmark(cond);
	}

	public void delByEiid(Integer eiid) {
		this.soc0110DAO.delByEiid(eiid);
		
	}
}