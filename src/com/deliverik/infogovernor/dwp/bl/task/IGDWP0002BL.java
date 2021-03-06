/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0002SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划流程信息实体BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0002BL extends BaseBL{

	/**
	 * 主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IGDWP0002Info searchByPk(Integer pk) throws BLException;
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGDWP0002SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IGDWP0002Info> search(IGDWP0002SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGDWP0002Info> search(IGDWP0002SearchCond cond,int start, int count);
	
	/**
	 * 新增处理
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IGDWP0002Info regist(IGDWP0002Info instance) throws BLException;
	
	/**
	 * 修改处理
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IGDWP0002Info update(IGDWP0002Info instance) throws BLException;
	
	/**
	 * 删除处理
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException;
	
	/**
	 * 删除处理
	 * @param instance 删除实例
	 */
	public void delete(IGDWP0002Info instance) throws BLException;
}
