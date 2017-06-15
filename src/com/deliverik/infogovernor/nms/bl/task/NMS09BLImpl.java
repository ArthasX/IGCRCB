/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS09Info;
import com.deliverik.infogovernor.nms.model.condition.NMS09SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS09DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 用户拓扑视图信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS09BLImpl extends NMSBaseBLImpl implements NMS09BL {

	/** 用户拓扑视图信息实体DAO */
	protected NMS09DAO nms09DAO;

	/**
	 * 用户拓扑视图信息实体DAO设定
	 * @param nms09DAO 用户拓扑视图信息实体DAO
	 */
	public void setNms09DAO(NMS09DAO nms09dao) {
		nms09DAO = nms09dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS09Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS09SearchCond cond) {
		return nms09DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS09Info> search(NMS09SearchCond cond) {
		return nms09DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS09Info> search(NMS09SearchCond cond, int start,int count) {
		return nms09DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS09Info regist(NMS09Info instance) throws BLException {
		return nms09DAO.save(instance);
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS09Info update(NMS09Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms09DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		nms09DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS09Info instance) throws BLException {
		nms09DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS09Info checkExistInstance(Integer pk) throws BLException {
		NMS09Info instance = nms09DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
