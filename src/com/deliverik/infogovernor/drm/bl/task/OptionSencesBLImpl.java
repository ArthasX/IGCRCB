/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;
import com.deliverik.infogovernor.drm.model.dao.OptionSencesDAO;
import com.deliverik.infogovernor.drm.model.entity.OptionSencesTB;

/**
  * 概述: 备选场景业务逻辑实现
  * 功能描述: 备选场景业务逻辑实现
  * 创建记录: 2016/10/09
  * 修改记录: 
  */
public class OptionSencesBLImpl extends BaseBLImpl implements
		OptionSencesBL {

	/** 备选场景DAO接口 */
	protected OptionSencesDAO optionSencesDAO;
	
	/**
	 * 备选场景DAO接口设定
	 *
	 * @param optionSencesDAO 备选场景DAO接口
	 */
	public void setOptionSencesDAO(OptionSencesDAO optionSencesDAO) {
		this.optionSencesDAO = optionSencesDAO;
	}

	/**
	 * 备选场景实例取得
	 *
	 * @return 备选场景实例
	 */
	public OptionSencesTB getOptionSencesTBInstance() {
		return new OptionSencesTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<OptionSencesInfo> searchOptionSences() {
		return optionSencesDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public OptionSencesInfo searchOptionSencesByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(OptionSencesSearchCond cond) {
		return optionSencesDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond) {
		return optionSencesDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond, int start,
			int count) {
		return optionSencesDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public OptionSencesInfo registOptionSences(OptionSencesInfo instance)
		throws BLException {
		return optionSencesDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public OptionSencesInfo updateOptionSences(OptionSencesInfo instance)
		throws BLException {
		checkExistInstance(instance.getOsid());
		return optionSencesDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteOptionSencesByPK(Integer pk)
		throws BLException {
		optionSencesDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteOptionSences(OptionSencesInfo instance)
		throws BLException {
		optionSencesDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public OptionSencesInfo checkExistInstance(Integer pk)
		throws BLException {
		OptionSencesInfo instance = optionSencesDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}