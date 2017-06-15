/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;
import com.deliverik.infogovernor.sym.model.dao.ReportFileVersionDAO;

/**
 * 报表版本业务逻辑接口
 *
 */
public class ReportFileVersionBLImpl extends BaseBLImpl implements ReportFileVersionBL{
	
	/** ReportFileVersion DAO */
	protected ReportFileVersionDAO reportFileVersionDAO;
	
	public void setReportFileVersionDAO(
			ReportFileVersionDAO reportFileVersionDAO) {
		this.reportFileVersionDAO = reportFileVersionDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(ReportFileVersionSearchCond cond){
		
		return reportFileVersionDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rfvid 报表信息ID
	 * @return 报表信息
	 */
	public ReportFileVersion searchReportFileVersionByKey(Integer rfvid) throws BLException{
		
		return checkExistReportFileVersion(rfvid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部报表信息信息
	 */
	public List<ReportFileVersion> searchReportFileVersionAll(){
		
		return reportFileVersionDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ReportFileVersion> searchReportFileVersion(ReportFileVersionSearchCond cond, int start, int count){
		
		return reportFileVersionDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param reportFileVersion 登录数据
	 * @return 报表信息
	 */
	public ReportFileVersion registReportFileVersion(ReportFileVersion reportFileVersion) throws BLException{
		
		return reportFileVersionDAO.save(reportFileVersion);
	}

	/**
	 * 删除处理
	 * 
	 * @param rfvid 报表信息ID
	 * @return
	 */
	public void deleteReportFileVersion(Integer rfvid) throws BLException{
		
		ReportFileVersion reportFileVersion = checkExistReportFileVersion(rfvid);
		
		reportFileVersionDAO.delete(reportFileVersion);
	}

	/**
	 * 变更处理
	 * 
	 * @param reportFileVersion 变更数据
	 * @return 报表信息
	 */
	public ReportFileVersion updateReportFileVersion(ReportFileVersion reportFileVersion) throws BLException{
		
		checkExistReportFileVersion(reportFileVersion.getRfvid());
		return reportFileVersionDAO.save(reportFileVersion);
	}

	/**
	 * 报表版本信息存在检查
	 * 
	 * @param rfvid 报表版本信息ID
	 * @return 报表版本信息
	 * @throws BLException 
	 */
	protected ReportFileVersion checkExistReportFileVersion(Integer rfvid) throws BLException{
		ReportFileVersion info = reportFileVersionDAO.findByPK(rfvid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","报表版本基本");
		}
		return info;
	}
	
}
