/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0102Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0103Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0104Form;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0107Form;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
/**
 * 概述:监控管理DTO
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */

@SuppressWarnings("serial")
public class IGMNT01DTO extends BaseDTO implements Serializable{
	
	/** 
	 * 国际化信息 
	 */
	protected Locale locale;
	/**当前用户*/
	protected User user;
	/** 
	 * 监控类型树 
	 */
	protected Map<String,TreeNode> treeNodeMap;
	
	/** 
	 * 监控类型集合 
	 */
	protected List<LabelValueBean> monitorTypeList;
	
	/**
	 * 监控对象名称集合
	 */
	protected List<LabelValueBean> moNameList;
	
	/**
	 * 监控对象集合
	 */
	protected List<MonitorObjectInfo> monitorObjectList;
	
	/**
	 * 监控对象阀值集合
	 */
	protected List<MonitorObjectDefInfo> monitorObjectDefList;
	
	
	/**
	 * 监控对象实例
	 */
	protected MonitorObjectInfo monitorObject;

	/**
	 * 监控类型阀值信息form
	 */
	protected IGMNT0102Form igmnt0102Form;
	
	/**
	 * 监控对象登记form
	 */
	protected IGMNT0103Form igmnt0103Form;
	
	/**
	 * 监控对象管理form
	 */
	protected IGMNT0104Form igmnt0104Form;
	
	/**
	 * debug监控任务form
	 */
	protected IGMNT0107Form igmnt0107Form;
	
	/**
	 * 磁盘序列号
	 */
	protected String mtSsn;
	/**
	 * 选择限制
	 */
	protected String checkedCount;
	/** 
	 * 检索最大件数 
	 */
	protected int maxSearchCount;

	/** 
	 * 翻页用DTO 
	 */
	protected PagingDTO pagingDto;
	
	/** 资产模型层次码 */
	protected String esyscoding;
	
	/** 资产模型名称 */
	protected String ename;
	
	/** 资产项信息检索条件 */
	protected SOC0124SearchCond entityItemVWSearchCond;
	
	/** 资产项检索结果 */
	protected List<SOC0124Info> entityItemVWInfoList;
	
	/**
	 * 监控类型id
	 */
	protected String mtId;
	
	/** 存储层次码 */
	protected String syscoding;
	
	/** 存储类型下的报表信息 */
	protected List<CodeDetail> codeDetailList;
	
	/** 存储类型下的报表信息 */
	protected CodeDetail codeDetailInfo;
	
	/**资产类型层次码集合*/
	protected List<LabelValueBean> esyscodingList;
	
	/**
	 * 存储基本信息实体集合
	 */
	protected List<Collect_Symmetrix_Info> collect_Symmetrix_InfoList;
	
	/**任务监控集合*/
	protected List<SOC0304Info> soc0304List=new ArrayList<SOC0304Info>();
	
	
	/**对象集合*/
	protected List<Object_ListInfo> olInfoList=new ArrayList<Object_ListInfo>();
	
	/**时间默认*/
	protected String interValDefault;
	
	/**新增任务ID*/
	protected String tmpMtId;
	/**错误标识*/
	protected String errFlag;
	/**
	 * 存储层次码取得
	 * @return 存储层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 存储层次码设定
	 * @param syscoding存储层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}
	
	/**
	 * 资产项检索结果取得
	 * @return 资产项检索结果
	 */
	public List<SOC0124Info> getEntityItemVWInfoList() {
		return entityItemVWInfoList;
	}

	/**
	 * 资产项检索结果设定
	 *
	 * @param entityItemVWInfoList 资产项检索结果
	 */
	public void setEntityItemVWInfoList(List<SOC0124Info> entityItemVWInfoList) {
		this.entityItemVWInfoList = entityItemVWInfoList;
	}
	
	/**
	 * 资产项信息检索条件取得
	 * @return 资产项信息检索条件
	 */
	public SOC0124SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * 资产项信息检索条件设定
	 *
	 * @param entityItemVWSearchCond 资产项信息检索条件
	 */
	public void setEntityItemVWSearchCond(
			SOC0124SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}
	
	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param eiid 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param eiid 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	/**
	 * 监控对象登记form获取
	 * @return
	 */
	public IGMNT0103Form getIgmnt0103Form() {
		return igmnt0103Form;
	}

	/**
	 * 监控对象登记form设定
	 * @param igmnt0103Form
	 */
	public void setIgmnt0103Form(IGMNT0103Form igmnt0103Form) {
		this.igmnt0103Form = igmnt0103Form;
	}

	/**
	 * 监控类型阀值信息集合
	 */
	protected List<MonitorTypeDefInfo> monitorTypeDefInfoList;

	/**
	 * 监控类型阀值信息集合获取
	 * @return
	 */
	public List<MonitorTypeDefInfo> getMonitorTypeDefInfoList() {
		return monitorTypeDefInfoList;
	}

	/**
	 * 监控类型阀值信息集合设定
	 * @param monitorTypeDefInfoList
	 */
	public void setMonitorTypeDefInfoList(
			List<MonitorTypeDefInfo> monitorTypeDefInfoList) {
		this.monitorTypeDefInfoList = monitorTypeDefInfoList;
	}

	/**
	 * 监控类型阀值信息form获取
	 * @return
	 */
	public IGMNT0102Form getIgmnt0102Form() {
		return igmnt0102Form;
	}

	/**
	 * 监控类型阀值信息form设定
	 * @param form
	 */
	public void setIgmnt0102Form(IGMNT0102Form igmnt0102Form) {
		this.igmnt0102Form = igmnt0102Form;
	}

	/**
	 * 监控分类树取得
	 * @return
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * 监控分类树设定
	 * @param treeNodeMap
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * 监控类型集合获取
	 * @return
	 */
	public List<LabelValueBean> getMonitorTypeList() {
		return monitorTypeList;
	}

	/**
	 * 监控类型集合取得
	 * @param monitorTypeList
	 */
	public void setMonitorTypeList(List<LabelValueBean> monitorTypeList) {
		this.monitorTypeList = monitorTypeList;
	}

	/**
	 * 国际化获取
	 * @return
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * 国际化设定
	 * @param locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 监控对象管理form获取
	 * @return
	 */
	public IGMNT0104Form getIgmnt0104Form() {
		return igmnt0104Form;
	}

	/**
	 * 监控对象管理form设定
	 * @param igmnt0104Form
	 */
	public void setIgmnt0104Form(IGMNT0104Form igmnt0104Form) {
		this.igmnt0104Form = igmnt0104Form;
	}

	/**
	 * 监控对象集合获取
	 * @return
	 */
	public List<MonitorObjectInfo> getMonitorObjectList() {
		return monitorObjectList;
	}

	/**
	 * 监控对象集合设定
	 * @param monitorObjectList
	 */
	public void setMonitorObjectList(List<MonitorObjectInfo> monitorObjectList) {
		this.monitorObjectList = monitorObjectList;
	}

	/**
	 * 检索最大件数取得
	 * @return
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**检索最大件数设定
	 * 
	 * @param maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 * @return
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 * @param pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 监控对象实例取得
	 * @return
	 */
	public MonitorObjectInfo getMonitorObject() {
		return monitorObject;
	}

	/**
	 * 监控对象实例设定
	 * @param monitorObject
	 */
	public void setMonitorObject(MonitorObjectInfo monitorObject) {
		this.monitorObject = monitorObject;
	}

	/**
	 * 监控对象阀值集合取得
	 * @return
	 */
	public List<MonitorObjectDefInfo> getMonitorObjectDefList() {
		return monitorObjectDefList;
	}

	/**
	 * 监控对象阀值集合设定
	 * @param monitorObjectDefList
	 */
	public void setMonitorObjectDefList(
			List<MonitorObjectDefInfo> monitorObjectDefList) {
		this.monitorObjectDefList = monitorObjectDefList;
	}

	/**
	 * 监控对象名称集合取得
	 * @return
	 */
	public List<LabelValueBean> getMoNameList() {
		return moNameList;
	}

	/**
	 * 监控对象名称集合设定
	 * @param moNameList
	 */
	public void setMoNameList(List<LabelValueBean> moNameList) {
		this.moNameList = moNameList;
	}

	/**
	 * 监控类型id取得
	 * @return
	 */
	public String getMtId() {
		return mtId;
	}

	/**
	 * 监控类型id设定
	 * @param mtId
	 */
	public void setMtId(String mtId) {
		this.mtId = mtId;
	}

	/**
	 * 存储类型下的报表信息取得
	 * @return 存储类型下的报表信息
	 */
	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	/**
	 * 存储类型下的报表信息设定
	 * @param codeDetailList存储类型下的报表信息
	 */
	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}
	
	/**
	 * 存储类型下的报表信息取得
	 * @return 存储类型下的报表信息
	 */
	public CodeDetail getCodeDetailInfo() {
		return codeDetailInfo;
	}

	/**
	 * 存储类型下的报表信息设定
	 * @param codeDetailInfo存储类型下的报表信息
	 */
	public void setCodeDetailInfo(CodeDetail codeDetailInfo) {
		this.codeDetailInfo = codeDetailInfo;
	}

	/**
	 * 存储基本信息实体集合取得
	 * @return
	 */
	public List<Collect_Symmetrix_Info> getCollect_Symmetrix_InfoList() {
		return collect_Symmetrix_InfoList;
	}

	/**
	 * 存储基本信息实体集合设定
	 * @param collect_Symmetrix_InfoList
	 */
	public void setCollect_Symmetrix_InfoList(
			List<Collect_Symmetrix_Info> collect_Symmetrix_InfoList) {
		this.collect_Symmetrix_InfoList = collect_Symmetrix_InfoList;
	}

	/**
	 * 资产类型层次码集合取得
	 * @return
	 */
	public List<LabelValueBean> getEsyscodingList() {
		return esyscodingList;
	}

	/**
	 * 资产类型层次码集合设定
	 * @param esyscodingList
	 */
	public void setEsyscodingList(List<LabelValueBean> esyscodingList) {
		this.esyscodingList = esyscodingList;
	}

	/**
	 * debug监控任务form取得
	 *
	 * @return igmnt0107Form debug监控任务form
	 */
	public IGMNT0107Form getIgmnt0107Form() {
		return igmnt0107Form;
	}

	/**
	 * debug监控任务form设定
	 *
	 * @param igmnt0107Form debug监控任务form
	 */
	public void setIgmnt0107Form(IGMNT0107Form igmnt0107Form) {
		this.igmnt0107Form = igmnt0107Form;
	}



	/**
	 * 对象集合取得
	 *
	 * @return olInfoList 对象集合
	 */
	public List<Object_ListInfo> getOlInfoList() {
		return olInfoList;
	}

	/**
	 * 对象集合设定
	 *
	 * @param olInfoList 对象集合
	 */
	public void setOlInfoList(List<Object_ListInfo> olInfoList) {
		this.olInfoList = olInfoList;
	}

	/**
	 * 当前用户取得
	 *
	 * @return user 当前用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 当前用户设定
	 *
	 * @param user 当前用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 磁盘序列号取得
	 *
	 * @return mtSsn 磁盘序列号
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * 磁盘序列号设定
	 *
	 * @param mtSsn 磁盘序列号
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * 选择限制取得
	 *
	 * @return checkedCount 选择限制
	 */
	public String getCheckedCount() {
		return checkedCount;
	}

	/**
	 * 选择限制设定
	 *
	 * @param checkedCount 选择限制
	 */
	public void setCheckedCount(String checkedCount) {
		this.checkedCount = checkedCount;
	}

	/**
	 * 时间默认取得
	 *
	 * @return interValDefault 时间默认
	 */
	public String getInterValDefault() {
		return interValDefault;
	}

	/**
	 * 时间默认设定
	 *
	 * @param interValDefault 时间默认
	 */
	public void setInterValDefault(String interValDefault) {
		this.interValDefault = interValDefault;
	}

	/**
	 * 新增任务ID取得
	 *
	 * @return tmpMtId 新增任务ID
	 */
	public String getTmpMtId() {
		return tmpMtId;
	}

	/**
	 * 新增任务ID设定
	 *
	 * @param tmpMtId 新增任务ID
	 */
	public void setTmpMtId(String tmpMtId) {
		this.tmpMtId = tmpMtId;
	}

	/**
	 * 错误标识取得
	 *
	 * @return errFlag 错误标识
	 */
	public String getErrFlag() {
		return errFlag;
	}

	/**
	 * 错误标识设定
	 *
	 * @param errFlag 错误标识
	 */
	public void setErrFlag(String errFlag) {
		this.errFlag = errFlag;
	}

	/**
	 * 任务监控集合取得
	 *
	 * @return soc0304List 任务监控集合
	 */
	public List<SOC0304Info> getSoc0304List() {
		return soc0304List;
	}

	/**
	 * 任务监控集合设定
	 *
	 * @param soc0304List 任务监控集合
	 */
	public void setSoc0304List(List<SOC0304Info> soc0304List) {
		this.soc0304List = soc0304List;
	}

	
	
}
