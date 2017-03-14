/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS13Info;
import com.deliverik.infogovernor.nms.model.condition.NMS13SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS13DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路白名单信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS13BLImpl extends NMSBaseBLImpl implements NMS13BL {

	/** 链路白名单信息实体DAO */
	protected NMS13DAO nms13DAO;

	/**
	 * 链路白名单信息实体DAO设定
	 * @param nms13DAO 链路白名单信息实体DAO
	 */
	public void setNms13DAO(NMS13DAO nms13dao) {
		nms13DAO = nms13dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS13Info searchByPK(String pk) throws BLException {
		return nms13DAO.findByPK(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS13SearchCond cond) {
		return nms13DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS13Info> search(NMS13SearchCond cond) {
		return nms13DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS13Info> search(NMS13SearchCond cond, int start,int count) {
		return nms13DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS13Info regist(NMS13Info instance) throws BLException {
		return nms13DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS13Info> regist(List<NMS13Info> instances) throws BLException {
		List<NMS13Info> list = new ArrayList<NMS13Info>(instances.size());
		for(NMS13Info instance:instances){
			list.add(nms13DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS13Info update(NMS13Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms13DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(String pk) throws BLException {
		nms13DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS13Info instance) throws BLException {
		nms13DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS13Info checkExistInstance(String pk) throws BLException {
		NMS13Info instance = nms13DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO13000.E004", "实例基本");
		}
		return instance;
	}
}
