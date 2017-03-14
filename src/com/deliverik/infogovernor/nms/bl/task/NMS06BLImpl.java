/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS06Info;
import com.deliverik.infogovernor.nms.model.condition.NMS06SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS06DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备MAC/IP信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS06BLImpl extends NMSBaseBLImpl implements NMS06BL {

	/** 设备MAC/IP信息实体DAO */
	protected NMS06DAO nms06DAO;

	/**
	 * 设备MAC/IP信息实体DAO设定
	 * @param nms06DAO 设备MAC/IP信息实体DAO
	 */
	public void setNms06DAO(NMS06DAO nms06dao) {
		nms06DAO = nms06dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS06Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS06SearchCond cond) {
		return nms06DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS06Info> search(NMS06SearchCond cond) {
		return nms06DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS06Info> search(NMS06SearchCond cond, int start,int count) {
		return nms06DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS06Info regist(NMS06Info instance) throws BLException {
		return nms06DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS06Info> regist(List<NMS06Info> instances) throws BLException {
		List<NMS06Info> list = new ArrayList<NMS06Info>();
		for(NMS06Info instance:instances){
			list.add(nms06DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS06Info update(NMS06Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms06DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(String pk) throws BLException {
		nms06DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS06Info instance) throws BLException {
		nms06DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS06Info checkExistInstance(String pk) throws BLException {
		NMS06Info instance = nms06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
