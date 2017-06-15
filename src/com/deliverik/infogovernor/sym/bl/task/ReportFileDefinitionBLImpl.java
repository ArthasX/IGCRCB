/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCondImpl;
import com.deliverik.infogovernor.sym.model.dao.ReportFileDefinitionDAO;

/**
 * 报表信息业务逻辑接口
 *
 */
public class ReportFileDefinitionBLImpl extends BaseBLImpl implements ReportFileDefinitionBL{
	
	/** ReportFileDefinition DAO */
	protected ReportFileDefinitionDAO reportFileDefinitionDAO;
	
	public void setReportFileDefinitionDAO(
			ReportFileDefinitionDAO reportFileDefinitionDAO) {
		this.reportFileDefinitionDAO = reportFileDefinitionDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(ReportFileDefinitionSearchCond cond){
		
		return reportFileDefinitionDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param rfdid 报表信息ID
	 * @return 报表信息
	 */
	public ReportFileDefinition searchReportFileDefinitionByKey(Integer rfdid) throws BLException{
		
		return checkExistReportFileDefinition(rfdid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部报表信息信息
	 */
	public List<ReportFileDefinition> searchReportFileDefinitionAll(){
		
		return reportFileDefinitionDAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ReportFileDefinition> searchReportFileDefinition(ReportFileDefinitionSearchCond cond, int start, int count){
		
		return reportFileDefinitionDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param reportFileDefinition 登录数据
	 * @return 报表信息
	 */
	public ReportFileDefinition registReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException{
		
		//checkRfdtitle(reportFileDefinition.getRfdtitle());
		checkRfdfilename(reportFileDefinition.getRfdfilename(),reportFileDefinition.getRfdtype());
		
//		if("1".equals(reportFileDefinition.getIsFlag())){
//			checkRfdfilename(reportFileDefinition.getRfdfilename());
//		}
		return reportFileDefinitionDAO.save(reportFileDefinition);
	}

	/**
	 * 删除处理
	 * 
	 * @param rfdid 报表信息ID
	 * @return
	 */
	public void deleteReportFileDefinition(Integer rfdid) throws BLException{
		
		ReportFileDefinition reportFileDefinition = checkExistReportFileDefinition(rfdid);
		
		reportFileDefinitionDAO.delete(reportFileDefinition);
	}

	/**
	 * 变更处理
	 * 
	 * @param reportFileDefinition 变更数据
	 * @return 报表信息
	 */
	public ReportFileDefinition updateReportFileDefinition(ReportFileDefinition reportFileDefinition) throws BLException{
		
		checkExistReportFileDefinition(reportFileDefinition.getRfdid());
		return reportFileDefinitionDAO.save(reportFileDefinition);
	}

	/**
	 * 报表信息存在检查
	 * 
	 * @param rfdid 报表信息ID
	 * @return 报表信息
	 * @throws BLException 
	 */
	protected ReportFileDefinition checkExistReportFileDefinition(Integer rfdid) throws BLException{
		ReportFileDefinition info = reportFileDefinitionDAO.findByPK(rfdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","报表基本");
		}
		return info;
	}
	
	/**
	 * 校验报表显示名称是否存在
	 * 
	 * @param rfdtitle 报表显示名称
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdtitle(String rfdtitle) throws BLException{
		ReportFileDefinitionSearchCondImpl cond = new ReportFileDefinitionSearchCondImpl();
		
		cond.setRfdtitle(rfdtitle);
		
		List<ReportFileDefinition> raList = reportFileDefinitionDAO.findByCond(cond, 0, 0);
		if( raList != null && raList.size()>0 ) {
			throw new BLException("IGSYM1402.E001","显示名称");
		}
	}
	
	/**
	 * 校验报表发布名称是否存在
	 * 
	 * @param rfdtitle 报表发布名称
	 * @return
	 * @throws BLException 
	 */
	public void checkRfdfilename(String rfdfilename,String rfdtype) throws BLException{
		ReportFileDefinitionSearchCondImpl cond = new ReportFileDefinitionSearchCondImpl();
		
		cond.setRfdfilename(rfdfilename);
		cond.setRfdtype(rfdtype);
		List<ReportFileDefinition> raList = reportFileDefinitionDAO.findByCond(cond, 0, 0);
		if( raList != null && raList.size()>0 ) {
			throw new BLException("IGSYM1402.E001","发布名称");
		}
	}
	
}
