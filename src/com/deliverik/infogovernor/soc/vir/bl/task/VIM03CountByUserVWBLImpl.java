/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountByUserVWDAO;

/**
 * 虚拟化资源统计业务逻辑实现
 *
 */
public class VIM03CountByUserVWBLImpl extends BaseBLImpl implements
		VIM03CountByUserVWBL {
	
	/** 虚拟化统计视图DAO */
	protected VIM03CountByUserVWDAO vim03CountByUserVWDAO;
	
	/**
	 * 虚拟化统计视图DAO设定
	 * @param vim03CountByUserVWDAO 虚拟化统计视图DAO
	 */
	public void setVim03CountByUserVWDAO(VIM03CountByUserVWDAO vim03CountByUserVWDAO) {
		this.vim03CountByUserVWDAO = vim03CountByUserVWDAO;
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM03CountByUserVWInfo> findByCond(final VIM03CountByUserVWSearchCond cond,final int start,final int count){
		return vim03CountByUserVWDAO.findByCond(cond, start, count);
	}
}
