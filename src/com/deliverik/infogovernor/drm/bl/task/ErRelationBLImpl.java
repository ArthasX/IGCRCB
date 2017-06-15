/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCond;
import com.deliverik.infogovernor.drm.model.dao.ErRelationDAO;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;

/**
  * 概述: ErRelation业务逻辑实现
  * 功能描述: ErRelation业务逻辑实现
  * 创建记录: 2016/06/14
  * 修改记录: 
  */
public class ErRelationBLImpl extends BaseBLImpl implements
		ErRelationBL {

	/** ErRelationDAO接口 */
	protected ErRelationDAO erRelationDAO;
	
	/**
	 * ErRelationDAO接口设定
	 *
	 * @param erRelationDAO ErRelationDAO接口
	 */
	public void setErRelationDAO(ErRelationDAO erRelationDAO) {
		this.erRelationDAO = erRelationDAO;
	}

	/**
	 * ErRelation实例取得
	 *
	 * @return ErRelation实例
	 */
	public ErRelationTB getErRelationTBInstance() {
		return new ErRelationTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ErRelationInfo> searchErRelation() {
		return erRelationDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ErRelationInfo searchErRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(ErRelationSearchCond cond) {
		return erRelationDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond) {
		return erRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond, int start,
			int count) {
		return erRelationDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public ErRelationInfo registErRelation(ErRelationInfo instance)
		throws BLException {
		return erRelationDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public ErRelationInfo updateErRelation(ErRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getErrid());
		return erRelationDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteErRelationByPK(Integer pk)
		throws BLException {
		erRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteErRelation(ErRelationInfo instance)
		throws BLException {
		erRelationDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public ErRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		ErRelationInfo instance = erRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}