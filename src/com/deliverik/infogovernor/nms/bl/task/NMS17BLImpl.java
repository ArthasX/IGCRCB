/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS17Info;
import com.deliverik.infogovernor.nms.model.condition.NMS17SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS17DAO;
import com.deliverik.infogovernor.nms.model.entity.NMS17TB;

/**
  * 概述: 子网区域信息业务逻辑实现
  * 功能描述: 子网区域信息业务逻辑实现
  * 创建记录: 2014/01/07
  * 修改记录: 
  */
public class NMS17BLImpl extends NMSBaseBLImpl implements
		NMS17BL {

	/** 子网区域信息DAO接口 */
	protected NMS17DAO nms17DAO;
	
	/**
     * nms17DAO is set.
     * @param nms17dao nms17DAO
     */
    public void setNms17DAO(NMS17DAO nms17dao) {
        nms17DAO = nms17dao;
    }

    /**
	 * 子网区域信息实例取得
	 *
	 * @return 子网区域信息实例
	 */
	public NMS17TB getNMS17TBInstance() {
		return new NMS17TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<NMS17Info> searchNMS17() {
		return nms17DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS17Info searchNMS17ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS17SearchCond cond) {
		return nms17DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS17Info> searchNMS17(
			NMS17SearchCond cond) {
		return nms17DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS17Info> searchNMS17(
			NMS17SearchCond cond, int start,
			int count) {
		return nms17DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS17Info registNMS17(NMS17Info instance)
		throws BLException {
		return nms17DAO.save(instance);
	}
	
	/**
	 * 批量新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public void registNMS17All(List<NMS17Info> instance)
	        throws BLException {
	    nms17DAO.saveOrUpdateAll(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS17Info updateNMS17(NMS17Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return nms17DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteNMS17ByPK(String pk)
		throws BLException {
		nms17DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteNMS17(NMS17Info instance)
		throws BLException {
		nms17DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS17Info checkExistInstance(String pk)
		throws BLException {
		NMS17Info instance = nms17DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}