/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.CIEntityItemInfo;
import com.deliverik.framework.asset.model.condition.CIEntityItemSearchCond;
import com.deliverik.framework.asset.model.dao.CIEntityItemDAO;
import com.deliverik.framework.asset.model.entity.CIEntityItemTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * 概述: CI变更资产表业务逻辑实现
  * 功能描述: CI变更资产表业务逻辑实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CIEntityItemBLImpl extends BaseBLImpl implements
		CIEntityItemBL {

	/** CI变更资产表DAO接口 */
	protected CIEntityItemDAO ciEntityItemDAO;
	
	/**
	 * CI变更资产表DAO接口设定
	 *
	 * @param ciEntityItemDAO CI变更资产表DAO接口
	 */
	public void setCiEntityItemDAO(CIEntityItemDAO ciEntityItemDAO) {
		this.ciEntityItemDAO = ciEntityItemDAO;
	}

	/**
	 * CI变更资产表实例取得
	 *
	 * @return CI变更资产表实例
	 */
	public CIEntityItemTB getCIEntityItemTBInstance() {
		return new CIEntityItemTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CIEntityItemInfo> searchCIEntityItem() {
		return ciEntityItemDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CIEntityItemInfo searchCIEntityItemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CIEntityItemSearchCond cond) {
		return ciEntityItemDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond) {
		return ciEntityItemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CIEntityItemInfo> searchCIEntityItem(
			CIEntityItemSearchCond cond, int start,
			int count) {
		return ciEntityItemDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CIEntityItemInfo registCIEntityItem(CIEntityItemInfo instance)
		throws BLException {
		return ciEntityItemDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CIEntityItemInfo updateCIEntityItem(CIEntityItemInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return ciEntityItemDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCIEntityItemByPK(Integer pk)
		throws BLException {
		ciEntityItemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCIEntityItem(CIEntityItemInfo instance)
		throws BLException {
		ciEntityItemDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CIEntityItemInfo checkExistInstance(Integer pk)
		throws BLException {
		CIEntityItemInfo instance = ciEntityItemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 清空表数据
	 *
	 * @return 执行数量
	 */
	public Integer deleteCIEntityItem(){
		return ciEntityItemDAO.deleteCIEntityItem();
	}

}