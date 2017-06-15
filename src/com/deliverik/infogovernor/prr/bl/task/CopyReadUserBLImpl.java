/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prr.model.CopyReadUserInfo;
import com.deliverik.infogovernor.prr.model.condition.CopyReadUserSearchCond;
import com.deliverik.infogovernor.prr.model.dao.CopyReadUserDAO;
import com.deliverik.infogovernor.prr.model.entity.CopyReadUserTB;

/**
  * 概述: 抄阅人表业务逻辑实现
  * 功能描述: 抄阅人表业务逻辑实现
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
public class CopyReadUserBLImpl extends BaseBLImpl implements
		CopyReadUserBL {

	/** 抄阅人表DAO接口 */
	protected CopyReadUserDAO copyReadUserDAO;
	
	/**
	 * 抄阅人表DAO接口设定
	 *
	 * @param copyReadUserDAO 抄阅人表DAO接口
	 */
	public void setCopyReadUserDAO(CopyReadUserDAO copyReadUserDAO) {
		this.copyReadUserDAO = copyReadUserDAO;
	}

	/**
	 * 抄阅人表实例取得
	 *
	 * @return 抄阅人表实例
	 */
	public CopyReadUserTB getCopyReadUserTBInstance() {
		return new CopyReadUserTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CopyReadUserInfo> searchCopyReadUser() {
		return copyReadUserDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CopyReadUserInfo searchCopyReadUserByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CopyReadUserSearchCond cond) {
		return copyReadUserDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CopyReadUserInfo> searchCopyReadUser(
			CopyReadUserSearchCond cond) {
		return copyReadUserDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CopyReadUserInfo> searchCopyReadUser(
			CopyReadUserSearchCond cond, int start,
			int count) {
		return copyReadUserDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public CopyReadUserInfo registCopyReadUser(CopyReadUserInfo instance)
		throws BLException {
		return copyReadUserDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public CopyReadUserInfo updateCopyReadUser(CopyReadUserInfo instance)
		throws BLException {
		checkExistInstance(instance.getCruid());
		return copyReadUserDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteCopyReadUserByPK(Integer pk)
		throws BLException {
		copyReadUserDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteCopyReadUser(CopyReadUserInfo instance)
		throws BLException {
		copyReadUserDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public CopyReadUserInfo checkExistInstance(Integer pk)
		throws BLException {
		CopyReadUserInfo instance = copyReadUserDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	public int getCopyReadUserCount(CopyReadUserSearchCond cond) {
		
		return copyReadUserDAO.getCopyReadUserCount(cond);
	}

	public List<CopyReadUserInfo> getCopyReadUserInfo(
			CopyReadUserSearchCond cond, int start, int count) {
		
		return copyReadUserDAO.getCopyReadUserInfo(cond, start, count);
	}

	public List<CopyReadUserInfo> getCopyReadUserInfoDesc(
			CopyReadUserSearchCond cond, int start, int count) {
		
		return copyReadUserDAO.getCopyReadUserInfoDesc(cond, start, count);
	}

}