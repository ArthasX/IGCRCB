/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;
import com.deliverik.infogovernor.dbm.model.dao.Ip_FilterDAO;
import com.deliverik.infogovernor.dbm.model.entity.Ip_FilterTB;

/**
  * 概述: 全网IP过滤业务逻辑实现
  * 功能描述: 全网IP过滤业务逻辑实现
  * 创建记录: 2012/11/07
  * 修改记录: 
  */
public class Ip_FilterBLImpl extends BaseBLImpl implements
		Ip_FilterBL {

	/** 全网IP过滤DAO接口 */
	protected Ip_FilterDAO ip_FilterDAO;
	
	/**
	 * 全网IP过滤DAO接口设定
	 *
	 * @param ip_FilterDAO 全网IP过滤DAO接口
	 */
	public void setIp_FilterDAO(Ip_FilterDAO ip_FilterDAO) {
		this.ip_FilterDAO = ip_FilterDAO;
	}

	/**
	 * 全网IP过滤实例取得
	 *
	 * @return 全网IP过滤实例
	 */
	public Ip_FilterTB getIp_FilterTBInstance() {
		return new Ip_FilterTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Ip_FilterInfo> searchIp_Filter() {
		return ip_FilterDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Ip_FilterInfo searchIp_FilterByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Ip_FilterSearchCond cond) {
		return ip_FilterDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond) {
		return ip_FilterDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond, int start,
			int count) {
		return ip_FilterDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public Ip_FilterInfo registIp_Filter(Ip_FilterInfo instance)
		throws BLException {
		return ip_FilterDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public Ip_FilterInfo updateIp_Filter(Ip_FilterInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return ip_FilterDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIp_FilterByPK(Integer pk)
		throws BLException {
		ip_FilterDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIp_Filter(Ip_FilterInfo instance)
		throws BLException {
		ip_FilterDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public Ip_FilterInfo checkExistInstance(Integer pk)
		throws BLException {
		Ip_FilterInfo instance = ip_FilterDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}