/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.vo;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 概述: 报表统计初始VO
 * 功能描述: 
 * 创建记录: 杨龙全 2012/07/03
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT03011VO extends BaseVO{
	
	/**存储集合*/
	List<SOC0118Info> scList;
	/**业务系统集合*/
	List<SOC0118Info> bcVWList;
	/**主机集合*/
	List<SOC0118Info> hcVWList;
	/**性能报告菜单*/
	protected List<CodeDetailEntity> catagoryCodeDeatilList=new ArrayList<CodeDetailEntity>();
	/**对象报告菜单*/
	protected List<CodeDetailEntity> objCodeDeatilList=new ArrayList<CodeDetailEntity>();
	
	/**服务报表*/
	protected List<ReportFileDefinition> reportFileDefinitionList=new ArrayList<ReportFileDefinition>();
	
	/**
	 * 存储集合取得
	 *
	 * @return scList 存储集合
	 */
	public List<SOC0118Info> getScList() {
		return scList;
	}
	/**
	 * 存储集合设定
	 *
	 * @param scList 存储集合
	 */
	public void setScList(List<SOC0118Info> scList) {
		this.scList = scList;
	}
	/**
	 * 业务系统集合取得
	 *
	 * @return bcVWList 业务系统集合
	 */
	public List<SOC0118Info> getBcVWList() {
		return bcVWList;
	}
	/**
	 * 业务系统集合设定
	 *
	 * @param bcVWList 业务系统集合
	 */
	public void setBcVWList(List<SOC0118Info> bcVWList) {
		this.bcVWList = bcVWList;
	}
	/**
	 * 主机集合取得
	 *
	 * @return hcVWList 主机集合
	 */
	public List<SOC0118Info> getHcVWList() {
		return hcVWList;
	}
	/**
	 * 主机集合设定
	 *
	 * @param hcVWList 主机集合
	 */
	public void setHcVWList(List<SOC0118Info> hcVWList) {
		this.hcVWList = hcVWList;
	}
	
	
	/**
	 * 性能报告菜单取得
	 *
	 * @return catagoryCodeDeatilList 性能报告菜单
	 */
	public List<CodeDetailEntity> getCatagoryCodeDeatilList() {
		return catagoryCodeDeatilList;
	}
	/**
	 * 性能报告菜单设定
	 *
	 * @param catagoryCodeDeatilList 性能报告菜单
	 */
	public void setCatagoryCodeDeatilList(
			List<CodeDetailEntity> catagoryCodeDeatilList) {
		this.catagoryCodeDeatilList = catagoryCodeDeatilList;
	}
	/**
	 * 对象报告菜单取得
	 *
	 * @return objCodeDeatilList 对象报告菜单
	 */
	public List<CodeDetailEntity> getObjCodeDeatilList() {
		return objCodeDeatilList;
	}
	/**
	 * 对象报告菜单设定
	 *
	 * @param objCodeDeatilList 对象报告菜单
	 */
	public void setObjCodeDeatilList(List<CodeDetailEntity> objCodeDeatilList) {
		this.objCodeDeatilList = objCodeDeatilList;
	}
	/**
	 * 服务报表取得
	 *
	 * @return reportFileDefinitionList 服务报表
	 */
	public List<ReportFileDefinition> getReportFileDefinitionList() {
		return reportFileDefinitionList;
	}
	/**
	 * 服务报表设定
	 *
	 * @param reportFileDefinitionList 服务报表
	 */
	public void setReportFileDefinitionList(
			List<ReportFileDefinition> reportFileDefinitionList) {
		this.reportFileDefinitionList = reportFileDefinitionList;
	}
	
	
	
}
