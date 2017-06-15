/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.rpt.form.IGRPT0201Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0202Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0203Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0204Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0205Form;
import com.deliverik.infogovernor.rpt.form.IGRPT0207Form;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;

/**
 * 概述: 
 * 功能描述: 
 * 创建记录: 2012/04/27
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT02DTO extends BaseDTO{
	
	/** 自定义报表 性能 */
	protected List<SOC0204Info> reportCustomLinkList_Pref;
	
	/** 自定义报表 容量 */
	protected List<SOC0204Info> reportCustomLinkList_Cap;

	/**
	 * 自定义报表性能取得
	 *
	 * @return reportCustomLinkList_Pref 自定义报表性能
	 */
	public List<SOC0204Info> getReportCustomLinkList_Pref() {
		return reportCustomLinkList_Pref;
	}

	/**
	 * 自定义报表容量取得
	 *
	 * @return reportCustomLinkList_Cap 自定义报表容量
	 */
	public List<SOC0204Info> getReportCustomLinkList_Cap() {
		return reportCustomLinkList_Cap;
	}

	/**
	 * 自定义报表性能设定
	 *
	 * @param reportCustomLinkList_Pref 自定义报表性能
	 */
	public void setReportCustomLinkList_Pref(
			List<SOC0204Info> reportCustomLinkList_Pref) {
		this.reportCustomLinkList_Pref = reportCustomLinkList_Pref;
	}

	/**
	 * 自定义报表容量设定
	 *
	 * @param reportCustomLinkList_Cap 自定义报表容量
	 */
	public void setReportCustomLinkList_Cap(
			List<SOC0204Info> reportCustomLinkList_Cap) {
		this.reportCustomLinkList_Cap = reportCustomLinkList_Cap;
	}

	/**ReportManageList*/
	protected List<SOC0205Info> soc0205List;
	
	/**ReportTemplateMappingList*/
	protected List<SOC0206Info> soc0206List;
	
	/**dmx codeDetail*/
	protected List<CodeDetail> dmx_list=new ArrayList<CodeDetail>();
	/**ibm codeDetail*/
	protected List<CodeDetail> ibm_list=new ArrayList<CodeDetail>();
	/**cx codeDetail*/
	protected List<CodeDetail> cx_list=new ArrayList<CodeDetail>();
	/**获得存储ID*/
	protected List<MonitorObjectInfo> monitorObjectList=new ArrayList<MonitorObjectInfo>();
	
	/** 自动报表检索条件 */
	protected SOC0207SearchCond soc0207SearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	/** 模板新增更新form */
	protected IGRPT0201Form iGRPT0201Form;
	/** 模板查询form */
	protected IGRPT0202Form iGRPT0202Form;
	/**报告查询删除Form */
	protected IGRPT0204Form iGRPT0204Form;
	/**报告查询删除Form */
	protected IGRPT0203Form iGRPT0203Form;
	
	protected List<SOC0207Info> reportTemplateList;
	
	/**报告增加修改*/
	protected IGRPT0205Form igrpt0205Form;

	/**报告附加Form*/
	protected IGRPT0207Form igrpt0207Form;
	/**当前用户*/
	protected User curUser;
	/**附加报表*/
	List<SOC0202Info> raInfoList;
	/**报告名称*/
	protected String reportName;
	/**
	 * reportTemplateList取得
	 *
	 * @return reportTemplateList reportTemplateList
	 */
	public List<SOC0207Info> getReportTemplateList() {
		return reportTemplateList;
	}

	/**
	 * reportTemplateList设定
	 *
	 * @param reportTemplateList reportTemplateList
	 */
	public void setReportTemplateList(List<SOC0207Info> reportTemplateList) {
		this.reportTemplateList = reportTemplateList;
	}

	/**
	 * iGRPT0201Form取得
	 *
	 * @return iGRPT0201Form iGRPT0201Form
	 */
	public IGRPT0201Form getIGRPT0201Form() {
		return iGRPT0201Form;
	}

	/**
	 * iGRPT0201Form设定
	 *
	 * @param form iGRPT0201Form
	 */
	public void setIGRPT0201Form(IGRPT0201Form form) {
		iGRPT0201Form = form;
	}

	/**
	 * 自动报表检索条件取得
	 *
	 * @return soc0207SearchCond 自动报表检索条件
	 */
	public SOC0207SearchCond getSoc0207SearchCond() {
		return soc0207SearchCond;
	}

	/**
	 * 检索最大件数取得
	 *
	 * @return maxSearchCount 检索最大件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 *
	 * @return pagingDto 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 自动报表检索条件设定
	 *
	 * @param soc0207SearchCond 自动报表检索条件
	 */
	public void setSoc0207SearchCond(
			SOC0207SearchCond soc0207SearchCond) {
		this.soc0207SearchCond = soc0207SearchCond;
	}

	/**
	 * 检索最大件数设定
	 *
	 * @param maxSearchCount 检索最大件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO设定
	 *
	 * @param pagingDto 翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * messageList取得
	 *
	 * @return messageList messageList
	 */
	public List<ActionMessage> getMessageList() {
		return messageList;
	}

	/**
	 * messageList设定
	 *
	 * @param messageList messageList
	 */
	public void setMessageList(List<ActionMessage> messageList) {
		this.messageList = messageList;
	}

	/**
	 * 获得存储ID取得
	 *
	 * @return monitorObjectList 获得存储ID
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}

	/**
	 * 获得存储ID设定
	 *
	 * @param monitorObjectList 获得存储ID
	 */
	public void setMonitorObjectList(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList = monitorObjectList;
	}

	/**
	 * 报告增加修改取得
	 *
	 * @return igrpt0205Form 报告增加修改
	 */
	public IGRPT0205Form getIgrpt0205Form() {
		return igrpt0205Form;
	}

	/**
	 * 报告增加修改设定
	 *
	 * @param igrpt0205Form 报告增加修改
	 */
	public void setIgrpt0205Form(IGRPT0205Form igrpt0205Form) {
		this.igrpt0205Form = igrpt0205Form;
	}

	/**
	 * iGRPT0202Form取得
	 *
	 * @return iGRPT0202Form iGRPT0202Form
	 */
	public IGRPT0202Form getIGRPT0202Form() {
		return iGRPT0202Form;
	}

	/**
	 * iGRPT0202Form设定
	 *
	 * @param form iGRPT0202Form
	 */
	public void setIGRPT0202Form(IGRPT0202Form form) {
		iGRPT0202Form = form;
	}

	/**
	 * dmxcodeDetail取得
	 *
	 * @return dmx_list dmxcodeDetail
	 */
	public List<CodeDetail> getDmx_list() {
		return dmx_list;
	}

	/**
	 * ibmcodeDetail取得
	 *
	 * @return ibm_list ibmcodeDetail
	 */
	public List<CodeDetail> getIbm_list() {
		return ibm_list;
	}

	/**
	 * cxcodeDetail取得
	 *
	 * @return cx_list cxcodeDetail
	 */
	public List<CodeDetail> getCx_list() {
		return cx_list;
	}

	/**
	 * dmxcodeDetail设定
	 *
	 * @param dmx_list dmxcodeDetail
	 */
	public void setDmx_list(List<CodeDetail> dmx_list) {
		this.dmx_list = dmx_list;
	}

	/**
	 * ibmcodeDetail设定
	 *
	 * @param ibm_list ibmcodeDetail
	 */
	public void setIbm_list(List<CodeDetail> ibm_list) {
		this.ibm_list = ibm_list;
	}

	/**
	 * cxcodeDetail设定
	 *
	 * @param cx_list cxcodeDetail
	 */
	public void setCx_list(List<CodeDetail> cx_list) {
		this.cx_list = cx_list;
	}

	/**
	 * ReportTemplateMappingList取得
	 *
	 * @return soc0206List SOC0206List
	 */
	public List<SOC0206Info> getSoc0206List() {
		return soc0206List;
	}

	/**
	 * ReportTemplateMappingList设定
	 *
	 * @param soc0206List SOC0206List
	 */
	public void setSoc0206List(
			List<SOC0206Info> soc0206List) {
		this.soc0206List = soc0206List;
	}

	/**
	 * 报告查询删除Form取得
	 *
	 * @return iGRPT0204Form 报告查询删除Form
	 */
	public IGRPT0204Form getIGRPT0204Form() {
		return iGRPT0204Form;
	}

	/**
	 * 报告查询删除Form设定
	 *
	 * @param form iGRPT0204Form
	 */
	public void setIGRPT0204Form(IGRPT0204Form form) {
		iGRPT0204Form = form;
	}

	/**
	 * 报告附加Form取得
	 *
	 * @return igrpt0207Form 报告附加Form
	 */
	public IGRPT0207Form getIgrpt0207Form() {
		return igrpt0207Form;
	}

	/**
	 * 报告附加Form设定
	 *
	 * @param igrpt0207Form 报告附加Form
	 */
	public void setIgrpt0207Form(IGRPT0207Form igrpt0207Form) {
		this.igrpt0207Form = igrpt0207Form;
	}

	/**
	 * 当前用户取得
	 *
	 * @return curUser 当前用户
	 */
	public User getCurUser() {
		return curUser;
	}

	/**
	 * 当前用户设定
	 *
	 * @param curUser 当前用户
	 */
	public void setCurUser(User curUser) {
		this.curUser = curUser;
	}

	/**
	 * 附加报表取得
	 *
	 * @return raInfoList 附加报表
	 */
	public List<SOC0202Info> getRaInfoList() {
		return raInfoList;
	}

	/**
	 * 附加报表设定
	 *
	 * @param raInfoList 附加报表
	 */
	public void setRaInfoList(List<SOC0202Info> raInfoList) {
		this.raInfoList = raInfoList;
	}

	/**
	 * 报告名称取得
	 *
	 * @return reportName 报告名称
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * 报告名称设定
	 *
	 * @param reportName 报告名称
	 */
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	/**
	 * ReportManageList取得
	 *
	 * @return soc0205List SOC0205List
	 */
	public List<SOC0205Info> getSoc0205List() {
		return soc0205List;
	}

	/**
	 * ReportManageList设定
	 *
	 * @param soc0205List SOC0205List
	 */
	public void setSoc0205List(List<SOC0205Info> soc0205List) {
		this.soc0205List = soc0205List;
	}

	/**
	 * 报告查询删除Form取得
	 *
	 * @return iGRPT0203Form 报告查询删除Form
	 */
	public IGRPT0203Form getIGRPT0203Form() {
		return iGRPT0203Form;
	}

	/**
	 * 报告查询删除Form设定
	 *
	 * @param form iGRPT0203Form
	 */
	public void setIGRPT0203Form(IGRPT0203Form form) {
		iGRPT0203Form = form;
	}


	
}
