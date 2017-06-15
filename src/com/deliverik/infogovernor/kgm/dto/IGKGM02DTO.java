/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0231Form;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;


/**
 * @Description: 知识管理
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGKGM02DTO extends BaseDTO implements Serializable {
    
	private String userid;
	
	private String username;
	
	private Integer roleid;
	
	private IG500SearchCond  prSearchCond;
	
	private IG500Info processRecord;
	
	private Integer prkid_r;
	
	private Integer prkid;

	private Map<String, List<List<IG677Info>>> processRecordMap;
	
	private Map<String, List<IG677Info>> allActiveProcessMap;

	private Integer prid;
	
	//============================>>2010-9-7 	  修改 0001103 start
	/** 流程与资产关系 */
	protected List<IG731Info> processInfoEntityList;
	
	/** 相关资产信息 */
	protected List<IG731Info> pieList;
	
	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/**知识查询form*/
	protected IGKGM0203Form igkgm0203Form;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;

	/** 知识ID */
	protected KnowLogSearchCond knowLogSearchCond;

	/**知识库日志*/
	protected List<KnowLogInfo> recordList;
	
	/**知识贡献数量统计form*/
	protected IGKGM0231Form igkgm0231Form;
	
	/**业务系统分类列表*/
	protected List<CodeDetailDef> businessSystemList;
	
	/**业务系统分类层次码*/
	protected String businessSystemSyscoding;

	/**
	 * 获取允许查询的最大记录数
	 * @return 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	
	public IGKGM0203Form getIgkgm0203Form() {
		return igkgm0203Form;
	}

	public void setIgkgm0203Form(IGKGM0203Form igkgm0203Form) {
		this.igkgm0203Form = igkgm0203Form;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	//<<============================2010-12-07   修改wangxiaoqiang end
	
	
	//-----------------------------------------------------------宋海洋----------------------------------------------------------------------
	
	
   //-----------------------------------------------------------刘鹏----------------------------------------------------------------------
	
	
	
	//-----------------------------------------------------------王晓强----------------------------------------------------------------------
	
	
	//-----------------------------------------------------------崔东东----------------------------------------------------------------------
	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public Integer getPrkid() {
		return prkid;
	}

	public void setPrkid(Integer prkid) {
		this.prkid = prkid;
	}

	public Integer getPrkid_r() {
		return prkid_r;
	}

	public void setPrkid_r(Integer prkid_r) {
		this.prkid_r = prkid_r;
	}

	public String getUserid() {
		return userid;
	}

	public String getUsername() {
		return username;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}


	public IG500Info getProcessRecord() {
		return processRecord;
	}


	public Map<String, List<List<IG677Info>>> getProcessRecordMap() {
		return processRecordMap;
	}

	public Map<String, List<IG677Info>> getAllActiveProcessMap() {
		return allActiveProcessMap;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}


	public void setProcessRecord(IG500Info processRecord) {
		this.processRecord = processRecord;
	}

	public void setProcessRecordMap(
			Map<String, List<List<IG677Info>>> processRecordMap) {
		this.processRecordMap = processRecordMap;
	}

	public void setAllActiveProcessMap(
			Map<String, List<IG677Info>> allActiveProcessMap) {
		this.allActiveProcessMap = allActiveProcessMap;
	}

	
	//============================>>2010-9-7 	  修改 0001103 start
	/**
	 * 流程与资产关系取得
	 * @return 流程与资产关系
	 */
	public List<IG731Info> getProcessInfoEntityList() {
		return processInfoEntityList;
	}

	/**
	 * 流程与资产关系设定
	 * @param processInfoEntityList 流程与资产关系
	 */
	public void setProcessInfoEntityList(
			List<IG731Info> processInfoEntityList) {
		this.processInfoEntityList = processInfoEntityList;
	}

	/**
	 * 相关资产信息取得
	 * @return 相关资产信息
	 */
	public List<IG731Info> getPieList() {
		return pieList;
	}

	/**
	 * 相关资产信息设定
	 * @param pieList 相关资产信息
	 */
	public void setPieList(List<IG731Info> pieList) {
		this.pieList = pieList;
	}

	/**
	 * 知识ID取得
	 * @return klkid 知识ID
	 */
	public KnowLogSearchCond getKnowLogSearchCond() {
		return knowLogSearchCond;
	}

	/**
	 * 知识ID设定
	 * @param klkid 知识ID
	 */
	public void setKnowLogSearchCond(KnowLogSearchCond knowLogSearchCond) {
		this.knowLogSearchCond = knowLogSearchCond;
	}

	/**
	 * 知识库日志取得
	 * @return recordLogMap 知识库日志
	 */
	public List<KnowLogInfo> getRecordList() {
		return recordList;
	}

	/**
	 * 知识库日志设定
	 * @param recordLogMap 知识库日志
	 */
	public void setRecordList(List<KnowLogInfo> recordList) {
		this.recordList = recordList;
	}
	/**
	 * 知识贡献数量统计form取得
	 * @return igkgm0231Form 知识贡献数量统计form
	 */
	public IGKGM0231Form getIgkgm0231Form() {
		return igkgm0231Form;
	}
	
	/**
	 * 知识贡献数量统计form设定
	 * @param igkgm0231Form 知识贡献数量统计form
	 */
	public void setIgkgm0231Form(IGKGM0231Form igkgm0231Form) {
		this.igkgm0231Form = igkgm0231Form;
	}

	public List<CodeDetailDef> getBusinessSystemList() {
		return businessSystemList;
	}

	public void setBusinessSystemList(List<CodeDetailDef> businessSystemList) {
		this.businessSystemList = businessSystemList;
	}

	public String getBusinessSystemSyscoding() {
		return businessSystemSyscoding;
	}

	public void setBusinessSystemSyscoding(String businessSystemSyscoding) {
		this.businessSystemSyscoding = businessSystemSyscoding;
	}


	
	
}