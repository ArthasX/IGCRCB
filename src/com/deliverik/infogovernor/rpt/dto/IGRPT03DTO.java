/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.dto;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0302Form;
import com.deliverik.infogovernor.rpt.model.SOC0401Info;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;

/**
 * 概述: 报表统计
 * 功能描述: 负责报表统计查询
 * 创建记录: 杨龙全 2012/07/03
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT03DTO extends BaseDTO{
	/**存储集合*/
	protected List<SOC0118Info> scList;
	/**业务系统集合*/
	protected List<SOC0118Info> bcVWList;
	/**主机集合*/
	protected List<SOC0118Info> hcVWList;
	/**VG集合*/
	protected List<SOC0124Info> vgList=new ArrayList<SOC0124Info>();
	/**FS集合*/
	protected List<SOC0124Info> fsList=new ArrayList<SOC0124Info>();
	
	/**DB集合*/
	protected List<SOC0401Info> dbList=new ArrayList<SOC0401Info>();
	/**TS集合*/
	protected List<SOC0415Info> tsList=new ArrayList<SOC0415Info>();
	
	protected IGRPT0302Form igrpt0302Form;
	/**性能报表菜单*/
	protected List<CodeDetailEntity> catagoryCodeDeatilList=new ArrayList<CodeDetailEntity>();
	/**对象报表菜单*/
	protected List<CodeDetailEntity> objCodeDeatilList=new ArrayList<CodeDetailEntity>();
	/**服务报表*/
	protected List<ReportFileDefinition> reportFileDefinitionList=new ArrayList<ReportFileDefinition>();
	
	protected User user;
	
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
	 * VG集合取得
	 *
	 * @return vgList VG集合
	 */
	public List<SOC0124Info> getVgList() {
		return vgList;
	}

	/**
	 * VG集合设定
	 *
	 * @param vgList VG集合
	 */
	public void setVgList(List<SOC0124Info> vgList) {
		this.vgList = vgList;
	}

	/**
	 * FS集合取得
	 *
	 * @return fsList FS集合
	 */
	public List<SOC0124Info> getFsList() {
		return fsList;
	}

	/**
	 * FS集合设定
	 *
	 * @param fsList FS集合
	 */
	public void setFsList(List<SOC0124Info> fsList) {
		this.fsList = fsList;
	}

	/**
	 * DB集合取得
	 *
	 * @return dbList DB集合
	 */
	public List<SOC0401Info> getDbList() {
		return dbList;
	}

	/**
	 * DB集合设定
	 *
	 * @param dbList DB集合
	 */
	public void setDbList(List<SOC0401Info> dbList) {
		this.dbList = dbList;
	}

	/**
	 * TS集合取得
	 *
	 * @return tsList TS集合
	 */
	public List<SOC0415Info> getTsList() {
		return tsList;
	}

	/**
	 * TS集合设定
	 *
	 * @param tsList TS集合
	 */
	public void setTsList(List<SOC0415Info> tsList) {
		this.tsList = tsList;
	}

	/**
	 * igrpt0302Form取得
	 *
	 * @return igrpt0302Form igrpt0302Form
	 */
	public IGRPT0302Form getIgrpt0302Form() {
		return igrpt0302Form;
	}

	/**
	 * igrpt0302Form设定
	 *
	 * @param igrpt0302Form igrpt0302Form
	 */
	public void setIgrpt0302Form(IGRPT0302Form igrpt0302Form) {
		this.igrpt0302Form = igrpt0302Form;
	}

	



	/**
	 * 性能报表菜单取得
	 *
	 * @return catagoryCodeDeatilList 性能报表菜单
	 */
	public List<CodeDetailEntity> getCatagoryCodeDeatilList() {
		return catagoryCodeDeatilList;
	}

	/**
	 * 性能报表菜单设定
	 *
	 * @param catagoryCodeDeatilList 性能报表菜单
	 */
	public void setCatagoryCodeDeatilList(
			List<CodeDetailEntity> catagoryCodeDeatilList) {
		this.catagoryCodeDeatilList = catagoryCodeDeatilList;
	}

	/**
	 * 对象报表菜单取得
	 *
	 * @return objCodeDeatilList 对象报表菜单
	 */
	public List<CodeDetailEntity> getObjCodeDeatilList() {
		return objCodeDeatilList;
	}

	/**
	 * 对象报表菜单设定
	 *
	 * @param objCodeDeatilList 对象报表菜单
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
