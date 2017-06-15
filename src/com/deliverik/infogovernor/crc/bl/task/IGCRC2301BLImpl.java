/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2301DAO;

/**	
 * 概述:程序开发统计BL实现
 * 创建记录：yukexin    2014-8-15 下午5:14:19	
 * 修改记录：null
 */	
public class IGCRC2301BLImpl extends BaseBLImpl implements IGCRC2301BL{
	
	/** igcrc2301DAO接口 */
	protected IGCRC2301DAO igcrc2301DAO;
	
	/**
     * igcrc2301DAO实例取得
     *
     * @param IGCRC2301DAO igcrc2301dao
     */
	public IGCRC2301DAO getIgcrc2301DAO() {
		return igcrc2301DAO;
	}
	
	/**
     * igcrc2301dao接口设定
     *
     * @param IGCRC2301DAO igcrc2301dao
     */
	public void setIgcrc2301DAO(IGCRC2301DAO igcrc2301dao) {
		igcrc2301DAO = igcrc2301dao;
	}
	
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IGCRC2301VWInfo> searchIGCRC2301(IGCRC2301Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc2301DAO.searchIGCRC2301VWInfo(cond);
	}
	
	/**
	 * 条件检索处理
	 * 		查询处理驳回次数
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> searchList(IGCRC2301Cond cond) {
		// TODO Auto-generated method stub
		return igcrc2301DAO.searchList(cond);
	}
	
	/**
	 * 条件检索处理
	 *		查询处理工单的总数
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> searchListSum(IGCRC2301Cond cond){
		return igcrc2301DAO.searchListSum(cond);
	}
}

