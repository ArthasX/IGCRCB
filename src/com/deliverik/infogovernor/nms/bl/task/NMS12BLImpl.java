/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS12Info;
import com.deliverik.infogovernor.nms.model.condition.NMS12SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS12DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备白名单信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS12BLImpl extends NMSBaseBLImpl implements NMS12BL {

	/** 设备白名单信息实体DAO */
	protected NMS12DAO nms12DAO;

	/**
	 * 设备白名单信息实体DAO设定
	 * @param nms12DAO 设备白名单信息实体DAO
	 */
	public void setNms12DAO(NMS12DAO nms12dao) {
		nms12DAO = nms12dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS12Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS12SearchCond cond) {
		return nms12DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS12Info> search(NMS12SearchCond cond) {
		return nms12DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS12Info> search(NMS12SearchCond cond, int start,int count) {
		return nms12DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS12Info regist(NMS12Info instance) throws BLException {
		return nms12DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS12Info> regist(List<NMS12Info> instances) throws BLException {
		List<NMS12Info> list = new ArrayList<NMS12Info>(instances.size());
		for(NMS12Info instance:instances){
			list.add(nms12DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS12Info update(NMS12Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms12DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		nms12DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS12Info instance) throws BLException {
		nms12DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS12Info checkExistInstance(Integer pk) throws BLException {
		NMS12Info instance = nms12DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
