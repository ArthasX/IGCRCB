/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountByOrgVWDAO;

/**
 * 虚拟化资源统计业务逻辑实现
 *
 */
public class VIM03CountByOrgVWBLImpl extends BaseBLImpl implements
		VIM03CountByOrgVWBL {
	
	/** 虚拟化统计视图DAO */
	protected VIM03CountByOrgVWDAO vim03CountByOrgVWDAO;
	
	/**
	 * 虚拟化统计视图DAO设定
	 * @param vim03CountByUserVWDAO 虚拟化统计视图DAO
	 */
	public void setVim03CountByOrgVWDAO(VIM03CountByOrgVWDAO vim03CountByOrgVWDAO) {
		this.vim03CountByOrgVWDAO = vim03CountByOrgVWDAO;
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM03CountByOrgVWInfo> findByCond(final VIM03CountByOrgVWSearchCond cond,final int start,final int count){
		return vim03CountByOrgVWDAO.findByCond(cond, start, count);
	}
	
	/**
	 * 查询各机构资源使用情况
	 * @param cond
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getCount(final VIM03CountByOrgVWSearchCond cond){
		return vim03CountByOrgVWDAO.getCount(cond);
	}
}
