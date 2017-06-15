/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.condition.CIConfigItemSearchCond;
import com.deliverik.framework.asset.model.dao.CIConfigItemDAO;
import com.deliverik.framework.asset.model.entity.CIConfigItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: CI变更资产属性表业务逻辑实现
  * 功能描述: CI变更资产属性表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CIConfigItemBLImpl extends BaseBLImpl implements
		CIConfigItemBL {

	/** CI变更资产属性表DAO接口 */
	protected CIConfigItemDAO ciConfigItemDAO;
	
	/**
	 * CI变更资产属性表DAO接口设定
	 *
	 * @param ciConfigItemDAO CI变更资产属性表DAO接口
	 */
	public void setCiConfigItemDAO(CIConfigItemDAO ciConfigItemDAO) {
		this.ciConfigItemDAO = ciConfigItemDAO;
	}

	/**
	 * CI变更资产属性表实例取得
	 *
	 * @return CI变更资产属性表实例
	 */
	public CIConfigItemTB getCIConfigItemTBInstance() {
		return new CIConfigItemTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIConfigItemInfo> searchCIConfigItem() {
		return ciConfigItemDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIConfigItemInfo searchCIConfigItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CIConfigItemSearchCond cond) {
		return ciConfigItemDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond) {
		return ciConfigItemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CIConfigItemInfo> searchCIConfigItem(
			CIConfigItemSearchCond cond, int start,
			int count) {
		return ciConfigItemDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CIConfigItemInfo registCIConfigItem(CIConfigItemInfo instance)
		throws BLException {
		return ciConfigItemDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CIConfigItemInfo updateCIConfigItem(CIConfigItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return ciConfigItemDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCIConfigItemByPK(Integer pk)
		throws BLException {
		ciConfigItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCIConfigItem(CIConfigItemInfo instance)
		throws BLException {
		ciConfigItemDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CIConfigItemInfo checkExistInstance(Integer pk)
		throws BLException {
		CIConfigItemInfo instance = ciConfigItemDAO.findByPK(pk);
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
	public List<CIConfigItemInfo> searchCIConfigItemForAucmptype(Integer eiid){
		return ciConfigItemDAO.searchCIConfigItemForAucmptype(eiid);
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteCIConfigItem(){
		return ciConfigItemDAO.deleteCIConfigItem();
	}

}