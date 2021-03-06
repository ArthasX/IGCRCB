/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.UserRegionInfo;
import com.deliverik.infogovernor.soc.model.condition.UserRegionSearchCond;
import com.deliverik.infogovernor.soc.model.dao.UserRegionDAO;
import com.deliverik.infogovernor.soc.model.entity.UserRegionTB;

/**
  * 概述: UserRegion业务逻辑实现
  * 功能描述: UserRegion业务逻辑实现
  * 创建记录: 2014/01/10
  * 修改记录: 
  */
public class UserRegionBLImpl extends BaseBLImpl implements
		UserRegionBL {

	/** UserRegionDAO接口 */
	protected UserRegionDAO userRegionDAO;
	
	/**
	 * UserRegionDAO接口设定
	 *
	 * @param userRegionDAO UserRegionDAO接口
	 */
	public void setUserRegionDAO(UserRegionDAO userRegionDAO) {
		this.userRegionDAO = userRegionDAO;
	}

	/**
	 * UserRegion实例取得
	 *
	 * @return UserRegion实例
	 */
	public UserRegionTB getUserRegionTBInstance() {
		return new UserRegionTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<UserRegionInfo> searchUserRegion() {
		return userRegionDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public UserRegionInfo searchUserRegionByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(UserRegionSearchCond cond) {
		return userRegionDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<UserRegionInfo> searchUserRegion(
			UserRegionSearchCond cond) {
		return userRegionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<UserRegionInfo> searchUserRegion(
			UserRegionSearchCond cond, int start,
			int count) {
		return userRegionDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public UserRegionInfo registUserRegion(UserRegionInfo instance)
		throws BLException {
		return userRegionDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public UserRegionInfo updateUserRegion(UserRegionInfo instance)
		throws BLException {
		checkExistInstance(instance.getID());
		return userRegionDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteUserRegionByPK(Integer pk)
		throws BLException {
		userRegionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteUserRegion(UserRegionInfo instance)
		throws BLException {
		userRegionDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public UserRegionInfo checkExistInstance(Integer pk)
		throws BLException {
		UserRegionInfo instance = userRegionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}