/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03DAO;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;

/**
  * 概述: 资源申请虚机信息表业务逻辑实现
  * 功能描述: 资源申请虚机信息表业务逻辑实现
  * 创建记录: 2014/02/13
  * 修改记录: 
  */
public class VIM03BLImpl extends BaseBLImpl implements
		VIM03BL {

	/** 资源申请虚机信息表DAO接口 */
	protected VIM03DAO vim03DAO;
	
	/**
	 * 资源申请虚机信息表DAO接口设定
	 *
	 * @param vim03DAO 资源申请虚机信息表DAO接口
	 */
	public void setVim03DAO(VIM03DAO vim03DAO) {
		this.vim03DAO = vim03DAO;
	}

	/**
	 * 资源申请虚机信息表实例取得
	 *
	 * @return 资源申请虚机信息表实例
	 */
	public VIM03TB getVim03TBInstance() {
		return new VIM03TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<VIM03Info> searchVim03() {
		return vim03DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public VIM03Info searchVim03ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Vim03SearchCond cond) {
		return vim03DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM03Info> searchVim03(
			Vim03SearchCond cond) {
		return vim03DAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		
		return vim03DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public VIM03Info registVim03(VIM03Info instance)
		throws BLException {
		return vim03DAO.save(instance);
	}
	
	/**
	 * 保存或更新所有
	 * 
	 * @param vim03InfoList
	 * @throws BLException
	 */
	public void  registVim03All(List<VIM03Info> vim03InfoList) throws BLException {
	    vim03DAO.saveOrUpdateAll(vim03InfoList);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public VIM03Info updateVim03(VIM03Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return vim03DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteVim03ByPK(Integer pk)
		throws BLException {
		vim03DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteVim03(VIM03Info instance)
		throws BLException {
		vim03DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public VIM03Info checkExistInstance(Integer pk)
		throws BLException {
		VIM03Info instance = vim03DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * 获取各部门每月虚机申请情况
	 * @param sDate
	 * @return List<Object[]> Obj[0]>orgname;Obj[1]>Orgsyscoding;Obj[2]>count;Obj[3]>Month
	 */
	public List<Object[]> getOrgCountByMonth(String sDate)throws BLException{
		return vim03DAO.getOrgCountByMonth(sDate);
	}
	
	/**
     * 查询一个季度内的资源申请数量
     * 
     * @param sDate
     * @return
     */
    public List<Object[]> getOrgCount(String sDate) throws BLException {
        return vim03DAO.getOrgCount(sDate);
    }
    
    /**
     * 检索条数取得
     *
     * @param cond 检索条件
     * @return 检索条数
     */
    public Integer  getVMCount4HostCountByCond(Vim03SearchCond cond) throws BLException {
        return vim03DAO.getVMCount4HostCountByCond(cond);
    }
    
    /**
     * 获取主机下虚机的个数
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<Object[]> getVMCount4HostByCond(Vim03SearchCond cond, int start, int count) throws BLException {
        return vim03DAO.getVMCount4HostByCond(cond, start, count);
    }
}