package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC1303DAO;

/**
 * 功能：业务逻辑实现
 * @author 史凯龙   2014-7-22
 */
public class IGCRC1303BLImpl extends BaseBLImpl implements IGCRC1303BL{
	
	/** igcrc1303DAO接口 */
	protected IGCRC1303DAO igcrc1303DAO;
	
	/**
     * igcrc1303DAO实例取得
     *
     * @param IGCRC1303DAO igcrc1303dao
     */
	public IGCRC1303DAO getIgcrc1303DAO() {
		return igcrc1303DAO;
	}
	
	/**
     * igcrc1303dao接口设定
     *
     * @param IGCRC1303DAO igcrc1303dao
     */
	public void setIgcrc1303DAO(IGCRC1303DAO igcrc1303dao) {
		igcrc1303DAO = igcrc1303dao;
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGCRC1303Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc1303DAO.getSearchCount(cond);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGCRC1303VWInfo> searchIGCRC1303(IGCRC1303Cond cond, int start,
			int count) {
		// TODO Auto-generated method stub
		return this.igcrc1303DAO.searchIGCRC1303VWInfo(cond, start, count);
	}
	
	/**
	 * 查询被下载的文档的类型
	 * @return
	 */
	public List<String> searchDownType(){
		
		return this.igcrc1303DAO.searchDownType();
	}
	
	/**
	 * 检索借阅统计记录
	 * @return
	 */
	public List<String> searchType() {
		// TODO Auto-generated method stub
		return this.igcrc1303DAO.searchType();
	}

	

}
