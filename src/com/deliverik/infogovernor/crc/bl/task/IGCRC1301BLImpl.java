/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC1301DAO;

/**
 * 概述: 业务逻辑实现
 * 功能描述: 业务逻辑实现
 * 创建记录: 2014/07/15
 * 修改记录: 
 */
public class IGCRC1301BLImpl extends BaseBLImpl implements IGCRC1301BL {

	/** igcrc1301DAO接口 */
	protected IGCRC1301DAO igcrc1301DAO;
	
	/**
	 * igcrc1301DAO实例取得
	 *
	 * @return igcrc1301DAO实例
	 */
	public IGCRC1301DAO getIgcrc1301DAO() {
		return igcrc1301DAO;
	}

	/**
     * igcrc1301dao接口设定
     *
     * @param IGCRC1301DAO igcrc1301dao
     */
	public void setIgcrc1301DAO(IGCRC1301DAO igcrc1301dao) {
		igcrc1301DAO = igcrc1301dao;
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGCRC1301VWInfo> searchIGCRC1301(IGCRC1301Cond cond, int start,
			int count) {
		return igcrc1301DAO.searchIGCRC1301VWInfo(cond, start, count);
	}

	
	public List<IGCRC1301VWInfo> searchIGCRC1302(IGCRC1301Cond cond, int start,
			int count) {
		return igcrc1301DAO.searchIGCRC1302VWInfo(cond, start, count);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGCRC1301Cond cond) {
		return igcrc1301DAO.getSearchCount(cond);
	}
}
