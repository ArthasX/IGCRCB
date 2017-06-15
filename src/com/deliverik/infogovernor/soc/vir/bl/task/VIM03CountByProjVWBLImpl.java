/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountByProjVWDAO;

/**
 * 虚拟化资源统计业务逻辑实现
 *
 */
public class VIM03CountByProjVWBLImpl extends BaseBLImpl implements
		VIM03CountByProjVWBL {
	
	/** 虚拟化统计视图DAO */
	protected VIM03CountByProjVWDAO vim03CountByProjVWDAO;
	
	/**
	 * 虚拟化统计视图DAO设定
	 * @param vim03CountByUserVWDAO 虚拟化统计视图DAO
	 */
	public void setVim03CountByProjVWDAO(VIM03CountByProjVWDAO vim03CountByProjVWDAO) {
		this.vim03CountByProjVWDAO = vim03CountByProjVWDAO;
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM03CountByProjVWInfo> findByCond(final VIM03CountByProjVWSearchCond cond,final int start,final int count){
		return vim03CountByProjVWDAO.findByCond(cond, start, count);
	}
}
