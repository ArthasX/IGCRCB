/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.form.IGKGM0201Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0202Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0207Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0216Form;
import com.deliverik.infogovernor.kgm.form.IGKGM0228Form;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.KnowledgeAppImpact;
import com.deliverik.infogovernor.kgm.model.KnowledgeGrade;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.vo.IGKGM02052VO;


/**
 * @Description: 知识管理
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGKGM03DTO extends BaseDTO implements Serializable {

	
	/**分页Bean*/
	protected PagingDTO pagingDto;
	
	/**知识添加form*/
	protected IGKGM0201Form igkgm0201Form;
	
	/**知识查询form*/
	protected IGKGM0202Form igkgm0202Form;
	
	/**知识查询form*/
	protected IGKGM0216Form igkgm0216Form;

	/**知识查询form*/
	protected IGKGM0203Form igkgm0203Form;

	/**知识批量导出form*/
	protected IGKGM0228Form igkgm0228Form;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;
	
	/**知识查询接口*/
	protected KnowledgeSearchCond knowledgeSearchCond;
	
	/**知识查询接口*/
	protected Knowledge knowledgeREAD;
	
	/**关键字列表*/
	protected List keysFromDB ;	

	/**流程id*/
	protected String ProcessID ;
	
	/**Session id*/
	protected String SessionID ;
	
	/**流程id*/
	protected String rlcomment ;	
	
	/**流程名称*/
	protected String ProcessName ;	
	protected String messageflag ;	
	/**技术领域*/
	protected String kntelareaname;
	
	/**知识审批人角色*/
	protected List<Role> roleList;
	
	/**要删除附件的ID集合*/
	protected String delFiles;
	
	/**要删除相关案例的ID集合*/
	protected String delKgm;
	
	/**需要导出知识的信息集合*/
	protected List<Knowledge> knowledgelist;
	
	
	/**历史业务系统*/
	protected List<IGKGM02052VO> voList;
	
	/**消息数量*/
	protected int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * 技术领域取得
	 * @return 技术领域
	 */
	public String getKntelareaname() {
		return kntelareaname;
	}

	/**
	 * 技术领域设定
	 * @param kntelareaname 技术领域
	 */
	public void setKntelareaname(String kntelareaname) {
		this.kntelareaname = kntelareaname;
	}

	/**
	 * 获取知识查询接口
	 * @return 知识查询接口
	 */
	public KnowledgeSearchCond getKnowledgeSearchCond() {
		return knowledgeSearchCond;
	}
	
	/**
	 * 设置知识查询接口
	 * @param knowledgeSearchCond 知识查询接口
	 */
	public void setKnowledgeSearchCond(KnowledgeSearchCond knowledgeSearchCond) {
		this.knowledgeSearchCond = knowledgeSearchCond;
	}


	/**
	 * 获取允许查询的最大记录数
	 * @return 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/** 用户信息*/
	protected User user;
	
	/** 关键字*/
	protected String keys;
	
	/** 打开知识明细页面的流程ID */
	protected Integer prid;
	
	/** 打开知识明细页面的工单ID */
	protected Integer sfid;
	/**
	 *驳回原因数组
	 */
	protected String[] knrejects;
	
	/**
	 *版本数组
	 */
	protected String[] knversions;
	/**
	 *版本数组取得
	 * 
	 * @return 版本数组
	 */
	public String[] getKnversions() {
		return knversions;
	}
	/**
	 * 版本数组设定
	 * @param knversions 版本数组
	 */
	public void setKnversions(String[] knversions) {
		this.knversions = knversions;
	}
	
	/**
	 *驳回原因数组取得
	 * 
	 * @return 驳回原因数组
	 */
	public String[] getKnrejects() {
		return knrejects;
	}
	/**
	 * 驳回原因数组设定
	 * @param knrejects 驳回原因数组
	 */
	public void setKnrejects(String[] knrejects) {
		this.knrejects = knrejects;
	}
	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount 允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	
	public IGKGM0201Form getIgkgm0201Form() {
		return igkgm0201Form;
	}

	public void setIgkgm0201Form(IGKGM0201Form igkgm0201Form) {
		this.igkgm0201Form = igkgm0201Form;
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
	
	//-----------------------------------------------------------宋海洋----------------------------------------------------------------------
	/** 知识结果集 */
	private List<Knowledge>  knowledgeList;
	/**
	 * 知识结果集的取得
	 * @return 知识结果集
	 */
	public List<Knowledge> getKnowledgeList() {
		return knowledgeList;
	}
	/**
	 * 设定知识结果集
	 * @param knowledgeList 知识结果集
	 */
	public void setKnowledgeList(List<Knowledge> knowledgeList) {
		this.knowledgeList = knowledgeList;
	}
	
	/**
	 *知识id数组
	 */
	protected String[] knids;
	/**
	 *知识id数组取得
	 * 
	 * @return 知识id数组
	 */
	public String[] getKnids() {
		return knids;
	}
	
	/**
	 *知识id数组设定
	 * 
	 * @param knids 知识id数组
	 */
	public void setKnids(String[] knids) {
		this.knids = knids;
	}
	
	/**
	 *状态
	 */
	protected String knstatus;
	/**
	 *状态取得
	 * 
	 * @return 状态
	 */
	public String getKnstatus() {
		return knstatus;
	}
	
	/**
	 *状态设定
	 * 
	 * @param knstatus状态
	 */
	public void setKnstatus(String knstatus) {
		this.knstatus = knstatus;
	}
   //-----------------------------------------------------------刘鹏----------------------------------------------------------------------
	
	
	
	//-----------------------------------------------------------王晓强----------------------------------------------------------------------
	
	/**知识查询结果List */
	protected List<KnowLedgeInfo> knowLedgeInfoList;
	
	/**知识ID*/
	protected Integer knid;
	
	/**知识版本*/
	protected Integer knversion;
	
	/**知识评分查询结果List */
	protected List<KnowledgeGrade> knowledgeGradeList;
	
	/**知识信息明细*/
	protected Knowledge knowledge;
	
	/**知识相关流程查询结果List*/
	protected List<KnowledgeProcess> knowledgeProcessList;

	/**知识登记Form*/
	protected IGKGM0207Form igkgm0207Form;
	
	/**
	 * 知识登记Form取得
	 * @return 知识登记Form
	 */
	public IGKGM0207Form getIgkgm0207Form() {
		return igkgm0207Form;
	}

	/**
	 * 知识登记Form设定
	 * @param igkgm0207Form 知识登记Form
	 */
	public void setIgkgm0207Form(IGKGM0207Form igkgm0207Form) {
		this.igkgm0207Form = igkgm0207Form;
	}

	/**
	 * 知识相关流程查询结果取得
	 * @return 知识相关流程查询结果
	 */
	public List<KnowledgeProcess> getKnowledgeProcessList() {
		return knowledgeProcessList;
	}

	/**
	 * 知识相关流程查询结果设定
	 * @param knowledgeProcessList 知识相关流程查询结果
	 */
	public void setKnowledgeProcessList(List<KnowledgeProcess> knowledgeProcessList) {
		this.knowledgeProcessList = knowledgeProcessList;
	}

	/**
	 * 知识信息明细取得
	 * @return 知识信息明细
	 */
	public Knowledge getKnowledge() {
		return knowledge;
	}

	/**
	 * 知识信息明细设定
	 * @param knowledge 知识信息明细
	 */
	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	
	/**
	 * 知识评分查询结果List取得
	 * @return 知识评分查询结果List
	 */
	public List<KnowledgeGrade> getKnowledgeGradeList() {
		return knowledgeGradeList;
	}

	/**
	 * 知识评分查询结果List设定
	 * @param knowledgeGradeList 知识评分查询结果List
	 */
	public void setKnowledgeGradeList(List<KnowledgeGrade> knowledgeGradeList) {
		this.knowledgeGradeList = knowledgeGradeList;
	}
	
	/**
	 * 知识ID取得
	 * @return 知识ID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 * 知识ID设定
	 * @param knid 知识ID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}
	
	/**
	 * 知识查询结果List取得
	 * @return 知识查询结果List
	 */
	public List<KnowLedgeInfo> getKnowLedgeInfoList() {
		return knowLedgeInfoList;
	}

	/**
	 * 知识查询结果List设定
	 * @param knowLedgeInfoList 知识查询结果List
	 */
	public void setKnowLedgeInfoList(List<KnowLedgeInfo> knowLedgeInfoList) {
		this.knowLedgeInfoList = knowLedgeInfoList;
	}
	/**
	 * 知识版本号取得
	 * @return 知识版本号
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * 知识版本号设定
	 * @param knversion 知识版本号
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}
	
	/**流程影响应用系统List*/
	protected List<KnowledgeAppImpact> knowledgeAppImpactList;
	
	/**流程业务系统Map*/
	protected Map<LabelValueBean,String> knowledgeAppImpactMap;
	
	public List<KnowledgeAppImpact> getKnowledgeAppImpactList() {
		return knowledgeAppImpactList;
	}

	public void setKnowledgeAppImpactList(List<KnowledgeAppImpact> knowledgeAppImpactList) {
		this.knowledgeAppImpactList = knowledgeAppImpactList;
	}
	
	public Map<LabelValueBean, String> getKnowledgeAppImpactMap() {
		return knowledgeAppImpactMap;
	}

	public void setKnowledgeAppImpactMap(
			Map<LabelValueBean, String> knowledgeAppImpactMap) {
		this.knowledgeAppImpactMap = knowledgeAppImpactMap;
	}
	
	/**事件评审系统类型*/
	protected List<LabelValueBean> system_typeList;
	
	/**
	 * 事件评审系统取得
	 * @return 事件评审系统
	 */
	public List<LabelValueBean> getSystem_typeList() {
		return system_typeList;
	}
	
	/**
	 * 事件评审系统集合
	 * @param system_typeList 事件评审系统
	 */
	public void setSystem_typeList(List<LabelValueBean> system_typeList) {
		this.system_typeList = system_typeList;
	}
	
	//-----------------------------------------------------------崔东东----------------------------------------------------------------------
	
	/**一条知识中存在没被审批的更新版本数*/
	protected int versions;

	/**
	 * 用户信息获取
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 关键字获取
	 * @return 关键字
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * 关键字设定
	 * @param user 关键字
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * 知识查询form获取
	 * @return 知识查询form
	 */
	public IGKGM0202Form getIgkgm0202Form() {
		return igkgm0202Form;
	}
	/**知识查询form设定
	 * @param igkgm0202Form 知识查询
	 */
	public void setIgkgm0202Form(IGKGM0202Form igkgm0202Form) {
		this.igkgm0202Form = igkgm0202Form;
	}
	
	/**
	 * 打开知识明细页面的流程ID取得
	 * @return 打开知识明细页面的流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 打开知识明细页面的流程ID设定
	 * @param prid打开知识明细页面的流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 打开知识明细页面的工单ID取得
	 * @return 打开知识明细页面的工单ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * 打开知识明细页面的工单ID设定
	 * @param sfid打开知识明细页面的工单ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}
	
	/**
	 * 知识更新明细查询
	 * @return igkgm0216Form知识更新明细查询
	 */
	public IGKGM0216Form getIgkgm0216Form() {
		return igkgm0216Form;
	}

	/**
	 * 知识更新明细查询
	 * @param igkgm0216Form知识更新明细查询
	 */
	public void setIgkgm0216Form(IGKGM0216Form igkgm0216Form) {
		this.igkgm0216Form = igkgm0216Form;
	}

	/**
	 * 数据库查找关键字数组
	 * @return 数据库查找关键字数组
	 */
	public List getKeysFromDB() {
		return keysFromDB;
	}

	/**
	 * 数据库查找关键字
	 * @param 数据库查找关键字数组
	 */
	public void setKeysFromDB(List keysFromDB) {
		this.keysFromDB = keysFromDB;
	}

	/**
	 * 未被审批的知识数
	 * @return 未被审批的知识数
	 */
	public int getVersions() {
		return versions;
	}

	/**
	 * 未被审批的知识数
	 * @param 未被审批的知识数
	 */
	public void setVersions(int versions) {
		this.versions = versions;
	}

	/**
	 * 流程名称
	 * @return 流程名称
	 */
	public String getProcessName() {
		return ProcessName;
	}

	/**
	 * 流程名称
	 * @param 流程名称
	 */
	public void setProcessName(String processName) {
		ProcessName = processName;
	}

	/**
	 * 流程id
	 * @return 流程id
	 */
	public String getProcessID() {
		return ProcessID;
	}

	/**
	 * 流程id
	 * @param 流程id
	 */
	public void setProcessID(String processID) {
		ProcessID = processID;
	}

	/**
	 * @return the delFiles
	 */
	public String getDelFiles() {
		return delFiles;
	}

	/**
	 * @param delFiles the delFiles to set
	 */
	public void setDelFiles(String delFiles) {
		this.delFiles = delFiles;
	}

	public String getRlcomment() {
		return rlcomment;
	}

	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

	/**
	 * @return the delKgm
	 */
	public String getDelKgm() {
		return delKgm;
	}

	/**
	 * @param delKgm the delKgm to set
	 */
	public void setDelKgm(String delKgm) {
		this.delKgm = delKgm;
	}

	/**
	 * 知识批量导出form取得
	 * @return 知识批量导出form
	 */
	public IGKGM0228Form getIgkgm0228Form() {
		return igkgm0228Form;
	}

	/**
	 * 知识批量导出form设定
	 * @param igkgm0228Form 知识批量导出form
	 */
	public void setIgkgm0228Form(IGKGM0228Form igkgm0228Form) {
		this.igkgm0228Form = igkgm0228Form;
	}

	/**
	 * 需要导出知识的信息集合取得
	 * @return 需要导出知识的信息集合
	 */
	public List<Knowledge> getKnowledgelist() {
		return knowledgelist;
	}

	/**
	 * 需要导出知识的信息集合设定
	 * @param knowledgelist 需要导出知识的信息集合
	 */
	public void setKnowledgelist(List<Knowledge> knowledgelist) {
		this.knowledgelist = knowledgelist;
	}

	public String getMessageflag() {
		return messageflag;
	}

	public void setMessageflag(String messageflag) {
		this.messageflag = messageflag;
	}

	/**
	 * 历史业务系统取得
	 * @return 历史业务系统
	 */
	public List<IGKGM02052VO> getVoList() {
		return voList;
	}

	/**
	 * 历史业务系统设定
	 * @param voList 历史业务系统
	 */
	public void setVoList(List<IGKGM02052VO> voList) {
		this.voList = voList;
	}

	public String getSessionID() {
		return SessionID;
	}

	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
}