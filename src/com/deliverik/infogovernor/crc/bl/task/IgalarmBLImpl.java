/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;
import com.deliverik.infogovernor.crc.model.dao.IgalarmDAO;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/**
  * 概述: 集成告警表业务逻辑实现
  * 功能描述: 集成告警表业务逻辑实现
  * 创建记录: 2014/06/21
  * 修改记录: 
  */
public class IgalarmBLImpl extends BaseBLImpl implements
		IgalarmBL {

	/** 集成告警表DAO接口 */
	protected IgalarmDAO igalarmDAO;
	
	/**
	 * 集成告警表DAO接口设定
	 *
	 * @param igalarmDAO 集成告警表DAO接口
	 */
	public void setIgalarmDAO(IgalarmDAO igalarmDAO) {
		this.igalarmDAO = igalarmDAO;
	}

	/**
	 * 集成告警表实例取得
	 *
	 * @return 集成告警表实例
	 */
	public IgalarmTB getIgalarmTBInstance() {
		return new IgalarmTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IgalarmInfo> searchIgalarm() {
		return igalarmDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IgalarmInfo searchIgalarmByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IgalarmSearchCond cond) {
		return igalarmDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond) {
		return igalarmDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond, int start,
			int count) {
		List<IgalarmInfo>igalarmInfos= igalarmDAO.findByCond(cond, start, count);
		return igalarmInfos;
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IgalarmInfo registIgalarm(IgalarmInfo instance)
		throws BLException {
		return igalarmDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IgalarmInfo updateIgalarm(IgalarmInfo instance)
		throws BLException {
		checkExistInstance(instance.getPk());
		return igalarmDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIgalarmByPK(Integer pk)
		throws BLException {
		igalarmDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIgalarm(IgalarmInfo instance)
		throws BLException {
		igalarmDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IgalarmInfo checkExistInstance(Integer pk)
		throws BLException {
		IgalarmInfo instance = igalarmDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 告警事件查询
	 */
	public List<IGCRC0208VWInfo> searchProcessByType(IG500SearchCond cond, int start,
			int count, String type) throws BLException {
		return igalarmDAO.queryIG500EntityListByProcessInfo(cond, start, count);
	}

	public int searchProcessCount(IG500SearchCond cond, String type) throws BLException {
		return igalarmDAO.queryIG500EntityCount(cond);
	}
	
	/**
	 * 条件检索处理(没有默认排序)
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgalarmInfo> searchIgalarmNoSort(
			IgalarmSearchCond cond, int start,
			int count) {
		List<IgalarmInfo>igalarmInfos= igalarmDAO.findByCondNoSort(cond, start, count);
		return igalarmInfos;
	}
	
	
}