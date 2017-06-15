/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.condition.AcceptuserSearchCond;
import com.deliverik.infogovernor.fxk.model.dao.AcceptuserDAO;
import com.deliverik.infogovernor.fxk.model.entity.AcceptuserTB;

/**
  * 概述: 风险管理提示接收者数据表业务逻辑实现
  * 功能描述: 风险管理提示接收者数据表业务逻辑实现
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public class AcceptuserBLImpl extends BaseBLImpl implements
		AcceptuserBL {

	/** 风险管理提示接收者数据表DAO接口 */
	protected AcceptuserDAO acceptuserDAO;
	
	/**
	 * 风险管理提示接收者数据表DAO接口设定
	 *
	 * @param acceptuserDAO 风险管理提示接收者数据表DAO接口
	 */
	public void setAcceptuserDAO(AcceptuserDAO acceptuserDAO) {
		this.acceptuserDAO = acceptuserDAO;
	}

	/**
	 * 风险管理提示接收者数据表实例取得
	 *
	 * @return 风险管理提示接收者数据表实例
	 */
	public AcceptuserTB getAcceptuserTBInstance() {
		return new AcceptuserTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AcceptuserInfo> searchAcceptuser() {
		return acceptuserDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AcceptuserInfo searchAcceptuserByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(AcceptuserSearchCond cond) {
		return acceptuserDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<AcceptuserInfo> searchAcceptuser(
			AcceptuserSearchCond cond) {
		return acceptuserDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AcceptuserInfo> searchAcceptuser(
			AcceptuserSearchCond cond, int start,
			int count) {
		return acceptuserDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public AcceptuserInfo registAcceptuser(AcceptuserInfo instance)
		throws BLException {
		return acceptuserDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public AcceptuserInfo updateAcceptuser(AcceptuserInfo instance)
		throws BLException {
		checkExistInstance(instance.getApid());
		return acceptuserDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteAcceptuserByPK(Integer pk)
		throws BLException {
		acceptuserDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteAcceptuser(AcceptuserInfo instance)
		throws BLException {
		acceptuserDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public AcceptuserInfo checkExistInstance(Integer pk)
		throws BLException {
		AcceptuserInfo instance = acceptuserDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}