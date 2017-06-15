/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0001SearchCond;
import com.deliverik.infogovernor.dwp.model.dao.IGDWP0001DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0001BLImpl extends BaseBLImpl implements IGDWP0001BL{

	/** 日常工作计划实体DAO */
	protected IGDWP0001DAO igdwp0001DAO;

	/**
	 * 日常工作计划实体DAO设定
	 * @param igdwp0001DAO 日常工作计划实体DAO
	 */
	public void setIgdwp0001DAO(IGDWP0001DAO igdwp0001dao) {
		igdwp0001DAO = igdwp0001dao;
	}
	
	/**
	 * 主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IGDWP0001Info searchByPk(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGDWP0001SearchCond cond){
		return this.igdwp0001DAO.getSearchCount(cond);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IGDWP0001Info> search(IGDWP0001SearchCond cond){
		return this.igdwp0001DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGDWP0001Info> search(IGDWP0001SearchCond cond,int start, int count){
		return this.igdwp0001DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IGDWP0001Info regist(IGDWP0001Info instance) throws BLException {
		return this.igdwp0001DAO.save(instance);
	}
	
	/**
	 * 修改处理
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IGDWP0001Info update(IGDWP0001Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return this.igdwp0001DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		this.igdwp0001DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 * @param instance 删除实例
	 */
	public void delete(IGDWP0001Info instance) throws BLException {
		this.igdwp0001DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 * @param pk 主键
	 * @return 实例
	 */
	private IGDWP0001Info checkExistInstance(Integer pk) throws BLException{
		IGDWP0001Info instance = this.igdwp0001DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
