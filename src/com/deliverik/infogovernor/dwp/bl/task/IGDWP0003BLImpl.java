/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0003SearchCond;
import com.deliverik.infogovernor.dwp.model.dao.IGDWP0003DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划表单信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0003BLImpl extends BaseBLImpl implements IGDWP0003BL{

	/** 日常工作计划表单信息实体DAO */
	protected IGDWP0003DAO igdwp0003DAO;

	/**
	 * 日常工作计划表单信息实体DAO设定
	 * @param igdwp0003DAO 日常工作计划表单信息实体DAO
	 */
	public void setIgdwp0003DAO(IGDWP0003DAO igdwp0003dao) {
		igdwp0003DAO = igdwp0003dao;
	}
	
	/**
	 * 主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IGDWP0003Info searchByPk(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGDWP0003SearchCond cond){
		return this.igdwp0003DAO.getSearchCount(cond);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IGDWP0003Info> search(IGDWP0003SearchCond cond){
		return this.igdwp0003DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGDWP0003Info> search(IGDWP0003SearchCond cond,int start, int count){
		return this.igdwp0003DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IGDWP0003Info regist(IGDWP0003Info instance) throws BLException {
		return this.igdwp0003DAO.save(instance);
	}
	
	/**
	 * 修改处理
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IGDWP0003Info update(IGDWP0003Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return this.igdwp0003DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		this.igdwp0003DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 * @param instance 删除实例
	 */
	public void delete(IGDWP0003Info instance) throws BLException {
		this.igdwp0003DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 * @param pk 主键
	 * @return 实例
	 */
	private IGDWP0003Info checkExistInstance(Integer pk) throws BLException{
		IGDWP0003Info instance = this.igdwp0003DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
