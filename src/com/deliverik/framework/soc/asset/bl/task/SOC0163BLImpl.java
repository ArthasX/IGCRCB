/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0163SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0163DAO;

/**
  * 概述: 用户资产业务逻辑实现
  * 功能描述: 用户资产业务逻辑实现
  * 创建记录: 2011/04/21
  * 修改记录: 
  */
public class SOC0163BLImpl extends BaseBLImpl implements
		SOC0163BL {

	/** 资产模型视图DAO接口 */
	protected SOC0163DAO soc0163DAO;
	


	/**
	 * 资产模型视图DAO接口设定
	 *
	 * @param soc0163DAO 资产模型视图DAO接口
	 */
	public void setSoc0163DAO(SOC0163DAO soc0163DAO) {
		this.soc0163DAO = soc0163DAO;
	}



	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0163Info searchEntityItemEntityVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0163SearchCond cond) {
		return soc0163DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond) {
		return soc0163DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond, int start,
			int count) {
		return soc0163DAO.findByCond(cond, start, count);
	}

	

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0163Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0163Info instance = soc0163DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}



	
	public int getSearchCountForNetAsset(SOC0163SearchCond cond) {
		return this.soc0163DAO.getSearchCountForNetAsset(cond);
	}



	public List<SOC0163Info> findByCondForNetAsset(SOC0163SearchCond cond,
			int start, int count) {
		return this.soc0163DAO.findByCondForNetAsset(cond, start, count);
	}

}