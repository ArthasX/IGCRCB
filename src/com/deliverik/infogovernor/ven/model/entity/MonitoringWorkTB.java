/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexSearchVW;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;

/**
  * 概述: 监测工作填报表实体
  * 功能描述: 监测工作填报表实体
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="MonitoringWork")
public class MonitoringWorkTB extends BaseEntity implements Serializable,
		Cloneable, MonitoringWorkInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="MONITORINGWORK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORINGWORK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORINGWORK_TABLE_GENERATOR")
	protected Integer mwid;

	/** 风险监测主键id */
	protected Integer rmid;

	/** 风险指标id */
	protected Integer riid;

	/** 风险指标信息  */	
	@Transient
	protected RiskIndexSearchVWInfo riskIndexSearchVWInfo;
	
	/** 监测结果 */
	protected String result;

	/** 结果说明 */
	protected String resultdesc;

	/** 附件 */
	protected String mwattachkey;
	
	/** 指派工作流程id*/
	protected Integer assignprid;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getMwid() {
		return mwid;
	}

	/**
	 * 主键设定
	 *
	 * @param mwid 主键
	 */
	public void setMwid(Integer mwid) {
		this.mwid = mwid;
	}

	/**
	 * 风险监测主键id取得
	 *
	 * @return 风险监测主键id
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * 风险监测主键id设定
	 *
	 * @param rmid 风险监测主键id
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * 风险指标id取得
	 *
	 * @return 风险指标id
	 */
	public Integer getRiid() {
		return riid;
	}

	/**
	 * 风险指标id设定
	 *
	 * @param riid 风险指标id
	 */
	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	/**
	 * 监测结果取得
	 *
	 * @return 监测结果
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 监测结果设定
	 *
	 * @param result 监测结果
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 结果说明取得
	 *
	 * @return 结果说明
	 */
	public String getResultdesc() {
		return resultdesc;
	}

	/**
	 * 结果说明设定
	 *
	 * @param resultdesc 结果说明
	 */
	public void setResultdesc(String resultdesc) {
		this.resultdesc = resultdesc;
	}

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getMwattachkey() {
		return mwattachkey;
	}

	/**
	 * 附件设定
	 *
	 * @param mwattachkey 附件
	 */
	public void setMwattachkey(String mwattachkey) {
		this.mwattachkey = mwattachkey;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return mwid;
	}


	/**
	 * 风险指标信息取得
	 * @return riskIndexSearchVWInfo  风险指标信息
	 */
	public RiskIndexSearchVWInfo getRiskIndexSearchVWInfo() {
		if(null == riskIndexSearchVWInfo){
			RiskIndexSearchVWBL bl = (RiskIndexSearchVWBL) WebApplicationSupport.getBean("riskIndexSearchVWBL");
			RiskIndexSearchVWSearchCondImpl cond = new RiskIndexSearchVWSearchCondImpl();
			cond.setSyscoding("");
			cond.setEiid(this.riid.toString());
			List<RiskIndexSearchVWInfo> list = bl.searchRiskIndexSearchVW(cond);
			if(list != null && list.size() > 0){
				riskIndexSearchVWInfo = list.get(0);
			}else{
				riskIndexSearchVWInfo = new RiskIndexSearchVW();
			}
		}
		return riskIndexSearchVWInfo;
	}

	
	/**
	 * 指派工作流程id取得
	 * @return the assignprid
	 */
	public Integer getAssignprid() {
		return assignprid;
	}

	/**
	 * 指派工作流程id设定
	 * @param assignprid the 指派工作流程id
	 */
	public void setAssignprid(Integer assignprid) {
		this.assignprid = assignprid;
	}

	/**
	 * 风险指标信息设定
	 * @param riskIndexSearchVWInfo  风险指标信息
	 */
	public void setRiskIndexSearchVWInfo(RiskIndexSearchVWInfo riskIndexSearchVWInfo) {
		this.riskIndexSearchVWInfo = riskIndexSearchVWInfo;
	}

}