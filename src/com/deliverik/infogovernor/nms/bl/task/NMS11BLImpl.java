/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS11Info;
import com.deliverik.infogovernor.nms.model.condition.NMS11SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS11DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 任务日志实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS11BLImpl extends NMSBaseBLImpl implements NMS11BL {

	/** 任务日志实体DAO */
	protected NMS11DAO nms11DAO;

	/**
	 * 任务日志实体DAO设定
	 * @param nms11DAO 任务日志实体DAO
	 */
	public void setNms11DAO(NMS11DAO nms11dao) {
		nms11DAO = nms11dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS11Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS11SearchCond cond) {
		return nms11DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS11Info> search(NMS11SearchCond cond) {
		return nms11DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS11Info> search(NMS11SearchCond cond, int start,int count) {
		return nms11DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS11Info regist(NMS11Info instance) throws BLException {
		return nms11DAO.save(instance);
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS11Info update(NMS11Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms11DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		nms11DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS11Info instance) throws BLException {
		nms11DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS11Info checkExistInstance(Integer pk) throws BLException {
		NMS11Info instance = nms11DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
