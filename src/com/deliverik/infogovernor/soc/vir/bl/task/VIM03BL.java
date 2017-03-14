/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;

/**
  * 概述: 资源申请虚机信息表业务逻辑接口
  * 功能描述: 资源申请虚机信息表业务逻辑接口
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public interface VIM03BL extends BaseBL {

	/**
	 * 资源申请虚机信息表实例取得
	 *
	 * @return 资源申请虚机信息表实例
	 */
	public VIM03TB getVim03TBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM03Info> searchVim03();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM03Info searchVim03ByPK(Integer pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Vim03SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM03Info> searchVim03(
			Vim03SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<VIM03Info> searchVim03(
			Vim03SearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM03Info registVim03(VIM03Info instance)
		throws BLException;
	
	/**
     * 保存或更新所有
     * 
     * @param vim03InfoList
     * @throws BLException
     */
    public void  registVim03All(List<VIM03Info> vim03InfoList) throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM03Info updateVim03(VIM03Info instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVim03ByPK(Integer pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVim03(VIM03Info instance)
		throws BLException;
	/**
	 * 获取各部门每月虚机申请情况
	 * @param sDate
	 * @return List<Object[]> Obj[0]>orgname;Obj[1]>Orgsyscoding;Obj[2]>count;Obj[3]>Month
	 */
	public List<Object[]> getOrgCountByMonth(String sDate) throws BLException;

	/**
     * 查询一个季度内的资源申请数量
     * 
     * @param sDate
     * @return
     */
    public List<Object[]> getOrgCount(String sDate) throws BLException;
    
    /**
     * 检索条数取得
     *
     * @param cond 检索条件
     * @return 检索条数
     */
    public Integer  getVMCount4HostCountByCond(Vim03SearchCond cond) throws BLException;
    
    /**
     * 获取主机下虚机的个数
     *
     * @param cond 检索条件
     * @return 检索结果列表 0:hostname 1:count
     */
    public List<Object[]> getVMCount4HostByCond(Vim03SearchCond cond, int start, int count) throws BLException;
}