package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
import com.deliverik.infogovernor.crc.model.dao.IGCRC1304DAO;

/**
 * 功能：业务逻辑实现
 * @author 史凯龙   2014-7-22
 */
public class IGCRC1304BLImpl extends BaseBLImpl implements IGCRC1304BL{
	
	/** igcrc1304DAO接口 */
	protected IGCRC1304DAO igcrc1304DAO;

	/**
     * igcrc1304DAO实例取得
     *
     * @param IGCRC1304DAO igcrc1304dao
     */
	public IGCRC1304DAO getIgcrc1304DAO() {
		return igcrc1304DAO;
	}

	/**
     * igcrc1304dao接口设定
     *
     * @param IGCRC1304DAO igcrc1304dao
     */
	public void setIgcrc1304DAO(IGCRC1304DAO igcrc1304dao) {
		igcrc1304DAO = igcrc1304dao;
	}

	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IGCRC1304Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.getSearchCount(cond);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IGCRC1303VWInfo> searchIGCRC1304(IGCRC1304Cond cond, int start,
			int count) {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.searchIGCRC1304VWInfo(cond, start, count);
	}

	/**
	 * 检索借阅统计记录
	 * @return
	 */
	public List<String> searchType() {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.searchType();
	}
	
	/**
	 * 查询被下载的文档的部门
	 * @return
	 */
	public List<String> searchDownDepart(){
		 
		return this.igcrc1304DAO.searchDownDepart();
	}

	public List<Integer> searchTypeID(IGCRC1304Cond cond) {
		// TODO Auto-generated method stub
		return this.igcrc1304DAO.searchTypeID(cond);
	}

}
