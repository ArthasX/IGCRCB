/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.emo.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.emo.model.EmInfo;
import com.deliverik.infogovernor.emo.model.condition.EmSearchCond;
import com.deliverik.infogovernor.emo.model.dao.EmDAO;
import com.deliverik.infogovernor.emo.model.entity.EmTB;

/**
  * 概述: oracle性能采集业务逻辑实现
  * 功能描述: oracle性能采集业务逻辑实现
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public class EmBLImpl extends BaseBLImpl implements
		EmBL {

	/** oracle性能采集DAO接口 */
	protected EmDAO emDAO;
	
	/**
	 * oracle性能采集DAO接口设定
	 *
	 * @param emDAO oracle性能采集DAO接口
	 */
	public void setEmDAO(EmDAO emDAO) {
		this.emDAO = emDAO;
	}

	/**
	 * oracle性能采集实例取得
	 *
	 * @return oracle性能采集实例
	 */
	public EmTB getEmTBInstance() {
		return new EmTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<EmInfo> searchEm() {
		return emDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public EmInfo searchEmByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EmSearchCond cond) {
		return emDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond) {
		return emDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<EmInfo> searchEm(
			EmSearchCond cond, int start,
			int count) {
		return emDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public EmInfo registEm(EmInfo instance)
		throws BLException {
		return emDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public EmInfo updateEm(EmInfo instance)
		throws BLException {
		checkExistInstance(instance.getEm_id());
		return emDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteEmByPK(Integer pk)
		throws BLException {
		emDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteEm(EmInfo instance)
		throws BLException {
		emDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public EmInfo checkExistInstance(Integer pk)
		throws BLException {
		EmInfo instance = emDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}