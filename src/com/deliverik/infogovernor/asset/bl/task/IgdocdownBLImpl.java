/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.IgdocdownInfo;
import com.deliverik.infogovernor.asset.model.condition.IgdocdownSearchCond;
import com.deliverik.infogovernor.asset.model.dao.IgdocdownDAO;
import com.deliverik.infogovernor.asset.model.entity.IgdocdownTB;

/**
  * 概述: 下载记录表业务逻辑实现
  * 功能描述: 下载记录表业务逻辑实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public class IgdocdownBLImpl extends BaseBLImpl implements
		IgdocdownBL {

	/** 下载记录表DAO接口 */
	protected IgdocdownDAO igdocdownDAO;
	
	/**
	 * 下载记录表DAO接口设定
	 *
	 * @param igdocdownDAO 下载记录表DAO接口
	 */
	public void setIgdocdownDAO(IgdocdownDAO igdocdownDAO) {
		this.igdocdownDAO = igdocdownDAO;
	}

	/**
	 * 下载记录表实例取得
	 *
	 * @return 下载记录表实例
	 */
	public IgdocdownTB getIgdocdownTBInstance() {
		return new IgdocdownTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IgdocdownInfo> searchIgdocdown() {
		return igdocdownDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IgdocdownInfo searchIgdocdownByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IgdocdownSearchCond cond) {
		return igdocdownDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IgdocdownInfo> searchIgdocdown(
			IgdocdownSearchCond cond) {
		return igdocdownDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgdocdownInfo> searchIgdocdown(
			IgdocdownSearchCond cond, int start,
			int count) {
		return igdocdownDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IgdocdownInfo registIgdocdown(IgdocdownInfo instance)
		throws BLException {
		
		return igdocdownDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IgdocdownInfo updateIgdocdown(IgdocdownInfo instance)
		throws BLException {
		checkExistInstance(instance.getDdid());
		return igdocdownDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIgdocdownByPK(Integer pk)
		throws BLException {
		igdocdownDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIgdocdown(IgdocdownInfo instance)
		throws BLException {
		igdocdownDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IgdocdownInfo checkExistInstance(Integer pk)
		throws BLException {
		IgdocdownInfo instance = igdocdownDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	public void insertDate(IgdocdownSearchCond cond){
		this.igdocdownDAO.insertDate(cond);
		
	}

}