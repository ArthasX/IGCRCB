/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0121DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0141DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;

/**
  * 概述: 快照关系表业务逻辑实现
  * 功能描述: 快照关系表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录：2011/7/13 增加IBM逻辑图显示 王龙宇
  * 修改记录: 
  */
public class SOC0121BLImpl extends BaseBLImpl implements
		SOC0121BL {

	/** 快照关系表DAO接口 */
	protected SOC0121DAO soc0121DAO;
	
	/** 快照关系表DAO试图接口 */
	protected SOC0141DAO soc0141DAO;
	
	/**
	 * 快照关系表DAO接口设定
	 *
	 * @param snapshotRelationDAO快照关系表DAO接口
	 */
	public void setSoc0121DAO(SOC0121DAO soc0121DAO) {
		this.soc0121DAO = soc0121DAO;
	}

	/**
	 * 快照关系表实例取得
	 *
	 * @return 快照关系表实例
	 */
	public SOC0121TB getSnapshotRelationTBInstance() {
		return new SOC0121TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0121Info> searchSnapshotRelation() {
		return soc0121DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0121Info searchSnapshotRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0121SearchCond cond) {
		return soc0121DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond) {
		return soc0121DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond, int start,
			int count) {
		return soc0121DAO.findByCond(cond, start, count);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0141VW> searchSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findByCond(cond);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0140VW> searchDiskFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findDiskByCond(cond);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchDaFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findDaByCond(cond);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> searchFaFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel) {
		return soc0141DAO.findFaByCond(cond,strStorageEilabel);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0121Info registSnapshotRelation(SOC0121Info instance)
		throws BLException {
		return soc0121DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0121Info updateSnapshotRelation(SOC0121Info instance)
		throws BLException {
		checkExistInstance(instance.getSrid());
		return soc0121DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException {
		soc0121DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteSnapshotRelation(SOC0121Info instance)
		throws BLException {
		soc0121DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0121Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0121Info instance = soc0121DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public void setSoc0141DAO(SOC0141DAO soc0141DAO) {
		this.soc0141DAO = soc0141DAO;
	}

	public List<SOC0132VW> searchSwitchPortByCond(
			SOC0121SearchCond cond) {
		
		return soc0141DAO.findSwitchPortByCond(cond);
	}

	public List<SOC0133VW> searchSwitchZoneByCond(
			SOC0121SearchCond cond) {
		
		return soc0141DAO.findSwitchZoneByCond(cond);
	}
	 /**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0121TB> searchSwitchRelationByCond(SOC0121SearchCond cond1,SOC0121SearchCond cond2){
		return soc0141DAO.findSwitchRelationByCond(cond1, cond2);
	}

	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询IBM FA PORT属性]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return faport的显示集合
	 */
	public List<SOC0140VW> searchIBMFaPortFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel) {
		return soc0141DAO.findIBMFaportByCond(cond,strStorageEilabel);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询IBM DISK SERIAL属性]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return  disk serial属性的显示集合
	 */
	public List<SOC0140VW> searchIBMDiskSerialFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDiskSerialByCond(cond);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询IBM DISK PACK属性]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return Disk pack属性的显示集合
	 */
	public List<SOC0140VW> searchIBMDiskPackFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDiskPackByCond(cond);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询IBM fa属性]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return fa属性的显示集合
	 */
	public List<SOC0140VW> searchIBMFaFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMFaByCond(cond);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询IBM da loc属性]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond disk-da 关系
	 * @return DA loc属性的显示集合
	 */
	public List<SOC0140VW> searchIBMDaLocFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDaLocByCond(cond);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询IBM da pair属性]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return DA pair属性的显示集合
	 */
	public List<SOC0140VW> searchIBMDaPairFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDaPairByCond(cond);
	}
	/**
	 * 
	 * <p>[功能描述]</p>
	 *
	 * @comment	[查询IBM da interface属性]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return DA interface属性的显示集合
	 */
	public List<SOC0140VW> searchIBMDaInterfaceFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDaInterfaceByCond(cond);
	}

	/**
	 * 出图用拓扑关系
	 * @return
	 */
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation() {
		return soc0121DAO.searchShowStorageIOSnapshotRelation();
	}
}