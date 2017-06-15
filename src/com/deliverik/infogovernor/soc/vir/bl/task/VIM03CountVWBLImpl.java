/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountVWDAO;

/**
 * 虚拟化资源统计业务逻辑实现
 *
 */
public class VIM03CountVWBLImpl extends BaseBLImpl implements
		VIM03CountVWBL {
	
	/** 虚拟化统计视图DAO */
	protected VIM03CountVWDAO vim03CountVWDAO;

	/**
	 * 虚拟化统计视图DAO设定
	 * @param vim03CountVWDAO 虚拟化统计视图DAO
	 */
	public void setVim03CountVWDAO(VIM03CountVWDAO vim03CountVWDAO) {
		this.vim03CountVWDAO = vim03CountVWDAO;
	}
	
	/**
	 * 检索条数取得
	 *
	 * @param cond 检索条件
	 * @return 检索条数
	 */
	public Integer getCount(final VIM03CountVWSearchCond cond){
		return vim03CountVWDAO.getCount(cond);
	}
	
	/**
	 * 检索条数取得
	 *
	 * @param cond 检索条件
	 * @return 检索条数
	 */
	public Integer getCountByCond(final VIM03CountVWSearchCond cond){
		return vim03CountVWDAO.getCountByCond(cond);
	}
}
