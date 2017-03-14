/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC2101DAO;

/**	
 * 概述:业务逻辑实现	
 * 创建记录：yukexin    2014-8-15 下午5:13:07	
 * 修改记录：null
 */	
public class IGCRC2101BLImpl extends BaseBLImpl implements IGCRC2101BL{
	
	/** igcrc2101DAO接口 */
	protected IGCRC2101DAO igcrc2101DAO;
	
	/**
     * igcrc2101DAO实例取得
     *
     * @param IGCRC2101DAO igcrc2101dao
     */
	public IGCRC2101DAO getIgcrc2101DAO() {
		return igcrc2101DAO;
	}
	
	/**
     * igcrc2101dao接口设定
     *
     * @param IGCRC2101DAO igcrc2101dao
     */
	public void setIgcrc2101DAO(IGCRC2101DAO igcrc2101dao) {
		igcrc2101DAO = igcrc2101dao;
	}
	
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(IGCRC2101Cond cond, int start,
			int count) {
		// TODO Auto-generated method stub
		return this.igcrc2101DAO.searchIGCRC2101VWInfo(cond, start, count);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(IGCRC2101Cond cond) {
		return this.igcrc2101DAO.searchIGCRC2101VWInfo(cond);
	}

	public List<IGCRC2102VWInfo> searchDepartmentBeanList() {
		return igcrc2101DAO.searchDepartmentBeanList();
	}
}
