/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS15Info;
import com.deliverik.infogovernor.nms.model.condition.NMS15SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS15DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自动发现记录实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS15BLImpl extends NMSBaseBLImpl implements NMS15BL {

	/** 自动发现记录实体DAO */
	protected NMS15DAO nms15DAO;

	/**
	 * 自动发现记录实体DAO设定
	 * @param nms15DAO 自动发现记录实体DAO
	 */
	public void setNms15DAO(NMS15DAO nms15dao) {
		nms15DAO = nms15dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS15Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS15SearchCond cond) {
		return nms15DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS15Info> search(NMS15SearchCond cond) {
		return nms15DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS15Info> search(NMS15SearchCond cond, int start,int count) {
		return nms15DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS15Info regist(NMS15Info instance) throws BLException {
		return nms15DAO.save(instance);
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS15Info update(NMS15Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms15DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		nms15DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS15Info instance) throws BLException {
		nms15DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS15Info checkExistInstance(Integer pk) throws BLException {
		NMS15Info instance = nms15DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("组信息不存在！");
		}
		return instance;
	}
}
