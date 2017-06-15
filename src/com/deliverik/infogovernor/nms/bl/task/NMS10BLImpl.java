/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS10Info;
import com.deliverik.infogovernor.nms.model.condition.NMS10SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS10DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路黑名单信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS10BLImpl extends NMSBaseBLImpl implements NMS10BL {

	/** 链路黑名单信息实体DAO */
	protected NMS10DAO nms10DAO;

	/**
	 * 链路黑名单信息实体DAO设定
	 * @param nms10DAO 链路黑名单信息实体DAO
	 */
	public void setNms10DAO(NMS10DAO nms10dao) {
		nms10DAO = nms10dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS10Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS10SearchCond cond) {
		return nms10DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS10Info> search(NMS10SearchCond cond) {
		return nms10DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS10Info> search(NMS10SearchCond cond, int start,int count) {
		return nms10DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS10Info regist(NMS10Info instance) throws BLException {
		return nms10DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS10Info> regist(List<NMS10Info> instances) throws BLException {
		List<NMS10Info> list = new ArrayList<NMS10Info>(instances.size());
		for(NMS10Info instance:instances){
			list.add(nms10DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS10Info update(NMS10Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms10DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(String pk) throws BLException {
		nms10DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS10Info instance) throws BLException {
		nms10DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS10Info checkExistInstance(String pk) throws BLException {
		NMS10Info instance = nms10DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
