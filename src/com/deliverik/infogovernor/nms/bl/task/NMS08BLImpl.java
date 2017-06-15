/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS08Info;
import com.deliverik.infogovernor.nms.model.condition.NMS08SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS08DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备黑名单信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS08BLImpl extends NMSBaseBLImpl implements NMS08BL {

	/** 设备黑名单信息实体DAO */
	protected NMS08DAO nms08DAO;

	/**
	 * 设备黑名单信息实体DAO设定
	 * @param nms08DAO 设备黑名单信息实体DAO
	 */
	public void setNms08DAO(NMS08DAO nms08dao) {
		nms08DAO = nms08dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS08Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS08SearchCond cond) {
		return nms08DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS08Info> search(NMS08SearchCond cond) {
		return nms08DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS08Info> search(NMS08SearchCond cond, int start,int count) {
		return nms08DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS08Info regist(NMS08Info instance) throws BLException {
		return nms08DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS08Info> regist(List<NMS08Info> instances) throws BLException {
		List<NMS08Info> list = new ArrayList<NMS08Info>(instances.size());
		for(NMS08Info instance:instances){
			list.add(nms08DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS08Info update(NMS08Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms08DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		nms08DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS08Info instance) throws BLException {
		nms08DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS08Info checkExistInstance(Integer pk) throws BLException {
		NMS08Info instance = nms08DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
