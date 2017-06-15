/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.form.IGCRC0203Form;
import com.deliverik.infogovernor.crc.form.IGCRC0204Form;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/***
 * 集成告警相关业务用DTO
 * @time 2014/06/20
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */

@SuppressWarnings("serial")
public class IGCRC02DTO extends BaseDTO implements Serializable{

	/** 集成告警表接口 */
	private IgalarmInfo igalarmInfo;
	
	protected IGWKM0101Form igwkm0101form;
	
	/** 查询数据 */
	private List<IgalarmInfo> IgalarmInfos;
	
	/** 最大查询页数 */
	private int maxSearchCount;
	
	/** 页面用 数据传输对象 */
	private PagingDTO pagingDTO;
	
	/** 告警信息查询Form */
	private IGCRC0203Form form;
	
	/** 告警更新Form */
	private IGCRC0204Form igcrc0204Form;
	
	/** socket信息 */
	private String msg;
	
	//告警事件用 begin
	protected String prtype;
	
	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	protected Map<String,String> nameURLMap;
	
	protected List<IG380Info> processDefinitionList;
	
	protected List<IG259Info> processTemplateList;
	
	/**变更查询接口*/
	protected IG500SearchCond prSearchCond;
	/** 查询类型*/
	protected String type;
	//告警事件用 end
	/** 流程信息集合 */
	protected List<IGCRC0208VWInfo> processList;
	
	
	/** 主机名称排序状态码 */
	private String appnamestatus;
	
	/** ip地址排序状态码 */
	private String ipaddrstatus;
	
	/** 触发时间排序状态码 */
	private String lasttimestatus;
	
	
	public List<IGCRC0208VWInfo> getProcessList() {
		return processList;
	}

	public void setProcessList(List<IGCRC0208VWInfo> processList) {
		this.processList = processList;
	}

	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}
	
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}
	

	/**
	 * @return the igwkm0101form
	 */
	public IGWKM0101Form getIgwkm0101form() {
		return igwkm0101form;
	}

	/**
	 * @param igwkm0101form the igwkm0101form to set
	 */
	public void setIgwkm0101form(IGWKM0101Form igwkm0101form) {
		this.igwkm0101form = igwkm0101form;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}

	/** 用户信息 */
	protected User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
		return assignInfo;
	}

	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
		this.assignInfo = assignInfo;
	}

	public Map<String, IG007Info> getProcessInfoQueryMap() {
		return processInfoQueryMap;
	}

	public void setProcessInfoQueryMap(Map<String, IG007Info> processInfoQueryMap) {
		this.processInfoQueryMap = processInfoQueryMap;
	}

	/** 分派信息 */
	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;
	/** 表单值*/
	protected List<IG599Info> processInfoList;
	/** 表单定义查询条件map */
	protected Map<String, IG007Info> processInfoQueryMap;
	/** 参与人*/
	protected List<IG337Info> processParticipantList;
	/** 状态定义*/
	protected List<IG333Info> processStatusDefList;
	/**
	 * 集成告警表接口获取
	 * @return 集成告警表接口
	 */
	public IgalarmInfo getIgalarmInfo() {
		return igalarmInfo;
	}

	/**
	 * 集成告警表接口设置
	 * @param igalarmInfo 集成告警表接口
	 */
	public void setIgalarmInfo(IgalarmInfo igalarmInfo) {
		this.igalarmInfo = igalarmInfo;
	}

	/**
	 * 页面查询数据获取
	 * @return 页面查询数据
	 */
	public List<IgalarmInfo> getIgalarmInfos() {
		return IgalarmInfos;
	}
	
	/**
	 * 页面查询数据设置
	 * @param igalarmInfos 页面查询数据
	 */
	public void setIgalarmInfos(List<IgalarmInfo> igalarmInfos) {
		IgalarmInfos = igalarmInfos;
	}

	/**
	 * 最大查询数获取
	 * @return 最大查询数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 最大查询数设置
	 * @param maxSearchCount 最大查询数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页查询参数获取
	 * @return 分页查询参数
	 */
	public PagingDTO getPagingDTO() {
		return pagingDTO;
	}

	/**
	 * 分页查询参数
	 * @param pagingDTO 设置
	 */
	public void setPagingDTO(PagingDTO pagingDTO) {
		this.pagingDTO = pagingDTO;
	}
	
	/**
	 * 告警信息查询Form
	 * @return 告警信息查询Form
	 */
	public IGCRC0203Form getForm() {
		return form;
	}
	
	/**
	 * 告警信息查询Form设置
	 * @param form 告警信息查询Form
	 */
	public void setForm(IGCRC0203Form form) {
		this.form = form;
	}
	
	/**
	 * socket信息
	 * @return socket信息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * socket信息设置
	 * @param msg socket信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 告警更新Form取得
	 * @return igcrc0204Form  告警更新Form
	 */
	public IGCRC0204Form getIgcrc0204Form() {
		return igcrc0204Form;
	}

	/**
	 * 告警更新Form设定
	 * @param igcrc0204Form  告警更新Form
	 */
	public void setIgcrc0204Form(IGCRC0204Form igcrc0204Form) {
		this.igcrc0204Form = igcrc0204Form;
	}

	/**
	 * prtype取得
	 * @return prtype  prtype
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * prtype设定
	 * @param prtype  prtype
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 分页Bean取得
	 * @return pagingDto  分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * @param pagingDto  分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * nameURLMap取得
	 * @return nameURLMap  nameURLMap
	 */
	public Map<String, String> getNameURLMap() {
		return nameURLMap;
	}

	/**
	 * nameURLMap设定
	 * @param nameURLMap  nameURLMap
	 */
	public void setNameURLMap(Map<String, String> nameURLMap) {
		this.nameURLMap = nameURLMap;
	}

	/**
	 * processDefinitionList取得
	 * @return processDefinitionList  processDefinitionList
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * processDefinitionList设定
	 * @param processDefinitionList  processDefinitionList
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * processTemplateList取得
	 * @return processTemplateList  processTemplateList
	 */
	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	/**
	 * processTemplateList设定
	 * @param processTemplateList  processTemplateList
	 */
	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}

	/**
	 * 变更查询接口取得
	 * @return prSearchCond  变更查询接口
	 */
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	/**
	 * 变更查询接口设定
	 * @param prSearchCond  变更查询接口
	 */
	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	/**
	 * 查询类型取得
	 * @return type  查询类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 查询类型设定
	 * @param type  查询类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	

	/**
	 * 主机名称排序状态码(1为升序 2为降序)取得
	 * 
	 * @return 主机名称排序状态码
	 */
	public String getAppnamestatus() {
		return appnamestatus;
	}

	/**
	 * 主机名称排序状态码(1为升序 2为降序)设置
	 * 
	 * @param 主机名称排序状态码
	 */
	public void setAppnamestatus(String appnamestatus) {
		this.appnamestatus = appnamestatus;
	}

	/**
	 * ip地址排序状态码(1为升序 2为降序)取得
	 * 
	 * @return ip地址排序状态码(1为升序 2为降序)
	 */
	public String getIpaddrstatus() {
		return ipaddrstatus;
	}

	/**
	 * ip地址排序状态码(1为升序 2为降序)设置
	 * 
	 * @param  ip地址排序状态码(1为升序 2为降序)
	 */
	public void setIpaddrstatus(String ipaddrstatus) {
		this.ipaddrstatus = ipaddrstatus;
	}

	/**
	 * 触发时间排序状态码(1为升序 2为降序)取得
	 * 
	 * @return 触发时间排序状态码(1为升序 2为降序)
	 */
	public String getLasttimestatus() {
		return lasttimestatus;
	}

	/**
	 * 触发时间排序状态码(1为升序 2为降序)设置
	 * 
	 * @param 触发时间排序状态码(1为升序 2为降序)
	 */
	public void setLasttimestatus(String lasttimestatus) {
		this.lasttimestatus = lasttimestatus;
	}

}
