/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.fxk.form.IGFXK0700Form;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.vo.IGFXK07012VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 参数传递DTO
 * </p>
 * 2014-6-16
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK07DTO extends BaseDTO {
	/**风险计划查询条数*/
	protected int prlistsize;
	/**风险清单查询条数*/
	protected int qdlistsize;
	/**问题整改查询条数*/
	protected int qmlistsize;
	/**风险评估查询条数*/
	protected int pglistsize;
	
	/**风险点查询条数*/
	protected int riskCount;
	
	/**检查项条数*/
	protected int checkCount;
	
	/**评估正在执行的条数*/
	protected int pgExcing;
	
	/**评估 年度*/
	protected int pgYear;
	protected int qdExcing;
	protected int qdYear;
	
	protected IGFXK0700Form igfxk0700Form;
	
	/**
	 * igfxk0700Form取得
	 * @return igfxk0700Form igfxk0700Form
	 */
	public IGFXK0700Form getIgfxk0700Form() {
		return igfxk0700Form;
	}

	/**
	 * igfxk0700Form设定
	 * @param igfxk0700Form igfxk0700Form
	 */
	public void setIgfxk0700Form(IGFXK0700Form igfxk0700Form) {
		this.igfxk0700Form = igfxk0700Form;
	}

	/**
	 * 评估年度取得
	 * @return pgYear 评估年度
	 */
	public int getPgYear() {
		return pgYear;
	}

	/**
	 * 评估年度设定
	 * @param pgYear 评估年度
	 */
	public void setPgYear(int pgYear) {
		this.pgYear = pgYear;
	}

	/**
	 * 评估正在执行的条数取得
	 * @return pgExcing 评估正在执行的条数
	 */
	public int getPgExcing() {
		return pgExcing;
	}

	/**
	 * 评估正在执行的条数设定
	 * @param pgExcing 评估正在执行的条数
	 */
	public void setPgExcing(int pgExcing) {
		this.pgExcing = pgExcing;
	}

	/**
	 * 风险点查询条数取得
	 * @return riskCount 风险点查询条数
	 */
	public int getRiskCount() {
		return riskCount;
	}

	/**
	 * 风险点查询条数设定
	 * @param riskCount 风险点查询条数
	 */
	public void setRiskCount(int riskCount) {
		this.riskCount = riskCount;
	}

	/**
	 * 检查项条数取得
	 * @return checkCount 检查项条数
	 */
	public int getCheckCount() {
		return checkCount;
	}

	/**
	 * 检查项条数设定
	 * @param checkCount 检查项条数
	 */
	public void setCheckCount(int checkCount) {
		this.checkCount = checkCount;
	}

	/**风险提示查询 条数*/
	int risklistsize;
	/** 页面初始 */
	private IGFXK0700Form form;

	/** 添加附件 */
	protected IGFXK0700Form attachFile;

	/** 接收人员 */
	protected String[] usid;

	/** 接收人员名称 */
	protected String[] usname;

	/** 风险提示集合 */
	protected List<RiskmanagerwaringInfo> list;

	/** 风险提示接收 */
	protected List<AcceptuserInfo> acceptList;
	/** 短信内容 */
	protected String smsContext;
	/** 邮件内容 */
	protected String mailTitle;

	/** 风险提示相关信息集合 */
	protected List<IGFXK07012VO> voList;

	/** 风险提示id */
	private Integer rwid;

	/** 风险提示名称 */
	protected String rwname;

	/** 下发起者id */
	protected String nuserid;

	/** 下发起者名字 */
	protected String nusername;

	/** 下发者机构名 */
	protected String norgname;

	/** 下发者机构码 */
	protected String norgid;

	/** 下发时间 */
	protected String ntime;

	/** 下发者联系方式 */
	protected String ntel;

	/** 风险提示描述 */
	protected String rwcontext;

	/** 提示附件 */
	protected String rwkey;

	/** 风险提示数据接口 */
	protected RiskmanagerwaringInfo info;

	/** 接收者机构名称 */
	protected String[] aporgname;

	/** 风险提示单条数据集合 */
	protected IGFXK07012VO igfxkvo;

	/** 判断机构还是人员 */
	protected String type;
	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;
	
	/**风险计划*/
	protected  List<IG500Info> prList;
	/**风险清单*/
	protected List<RiskcaseVWInfo> qdList;
	
	/**问题整改*/
	protected List<IG500Info> questModfiy;
	/**风险评估*/
	protected List<IG500Info> riskpg;
	/**
	 * @return the riskpg
	 */
	public List<IG500Info> getRiskpg() {
		return riskpg;
	}

	/**
	 * @param riskpg the riskpg to set
	 */
	public void setRiskpg(List<IG500Info> riskpg) {
		this.riskpg = riskpg;
	}

	/**
	 * @return the questModfiy
	 */
	public List<IG500Info> getQuestModfiy() {
		return questModfiy;
	}

	/**
	 * @param questModfiy the questModfiy to set
	 */
	public void setQuestModfiy(List<IG500Info> questModfiy) {
		this.questModfiy = questModfiy;
	}

	/**
	 * @return the qdList
	 */
	public List<RiskcaseVWInfo> getQdList() {
		return qdList;
	}

	/**
	 * @param qdList the qdList to set
	 */
	public void setQdList(List<RiskcaseVWInfo> qdList) {
		this.qdList = qdList;
	}

	/**
	 * 风险计划取得
	 * @return prList 风险计划
	 */
	
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * 风险计划设定
	 * @param prList 风险计划
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}

	/**
	 * 风险提示接收取得
	 * 
	 * @return acceptList 风险提示接收
	 */

	public List<AcceptuserInfo> getAcceptList() {
		return acceptList;
	}

	/**
	 * 风险提示接收设定
	 * 
	 * @param acceptList
	 *            风险提示接收
	 */
	public void setAcceptList(List<AcceptuserInfo> acceptList) {
		this.acceptList = acceptList;
	}

	/**
	 * 判断机构还是人员取得
	 * 
	 * @return type 判断机构还是人员
	 */

	public String getType() {
		return type;
	}

	/**
	 * 判断机构还是人员设定
	 * 
	 * @param type
	 *            判断机构还是人员
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 风险提示单条数据集合取得
	 * 
	 * @return igfxkvo 风险提示单条数据集合
	 */
	public IGFXK07012VO getIgfxkvo() {
		return igfxkvo;
	}

	/**
	 * 风险提示单条数据集合设定
	 * 
	 * @param igfxkvo
	 *            风险提示单条数据集合
	 */
	public void setIgfxkvo(IGFXK07012VO igfxkvo) {
		this.igfxkvo = igfxkvo;
	}

	/**
	 * 风险提示集合取得
	 * 
	 * @return list 风险提示集合
	 */
	public List<RiskmanagerwaringInfo> getList() {
		return list;
	}

	/**
	 * 风险提示集合设定
	 * 
	 * @param list
	 *            风险提示集合
	 */
	public void setList(List<RiskmanagerwaringInfo> list) {
		this.list = list;
	}

	/**
	 * 接收类型 1:添加机构 2:添加人员
	 */
	protected String sign;

	/**
	 * 接收类型1:添加机构2:添加人员取得
	 * 
	 * @return sign 接收类型1:添加机构2:添加人员
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * 接收类型1:添加机构2:添加人员设定
	 * 
	 * @param sign
	 *            接收类型1:添加机构2:添加人员
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}

	/**
	 * 接收人员名称取得
	 * 
	 * @return usname 接收人员名称
	 */
	public String[] getUsname() {
		return usname;
	}

	/**
	 * 接收人员名称设定
	 * 
	 * @param usname
	 *            接收人员名称
	 */
	public void setUsname(String[] usname) {
		this.usname = usname;
	}

	/** 接收机构 */
	protected String[] aporgid;

	/**
	 * 接收机构取得
	 * 
	 * @return aporgid 接收机构
	 */
	public String[] getAporgid() {
		return aporgid;
	}

	/**
	 * 接收机构设定
	 * 
	 * @param aporgid
	 *            接收机构
	 */
	public void setAporgid(String[] aporgid) {
		this.aporgid = aporgid;
	}

	/**
	 * 接收人员取得
	 * 
	 * @return usid 接收人员
	 */
	public String[] getUsid() {
		return usid;
	}

	/**
	 * 接收人员设定
	 * 
	 * @param usid
	 *            接收人员
	 */
	public void setUsid(String[] usid) {
		this.usid = usid;
	}

	/**
	 * 接收者机构名称取得
	 * 
	 * @return aporgname 接收者机构名称
	 */
	public String[] getAporgname() {
		return aporgname;
	}

	/**
	 * 接收者机构名称设定
	 * 
	 * @param aporgname
	 *            接收者机构名称
	 */
	public void setAporgname(String[] aporgname) {
		this.aporgname = aporgname;
	}

	/**
	 * 风险提示名称取得
	 * 
	 * @return rwname 风险提示名称
	 */

	public String getRwname() {
		return rwname;
	}

	/**
	 * 风险提示名称设定
	 * 
	 * @param rwname
	 *            风险提示名称
	 */
	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	/**
	 * 下发起者id取得
	 * 
	 * @return nuserid 下发起者id
	 */

	public String getNuserid() {
		return nuserid;
	}

	/**
	 * 下发起者id设定
	 * 
	 * @param nuserid
	 *            下发起者id
	 */
	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	/**
	 * 下发起者名字取得
	 * 
	 * @return nusername 下发起者名字
	 */

	public String getNusername() {
		return nusername;
	}

	/**
	 * 下发起者名字设定
	 * 
	 * @param nusername
	 *            下发起者名字
	 */
	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	/**
	 * 下发者机构名取得
	 * 
	 * @return norgname 下发者机构名
	 */

	public String getNorgname() {
		return norgname;
	}

	/**
	 * 下发者机构名设定
	 * 
	 * @param norgname
	 *            下发者机构名
	 */
	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	/**
	 * 下发者机构码取得
	 * 
	 * @return norgid 下发者机构码
	 */

	public String getNorgid() {
		return norgid;
	}

	/**
	 * 下发者机构码设定
	 * 
	 * @param norgid
	 *            下发者机构码
	 */
	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	/**
	 * 下发时间取得
	 * 
	 * @return ntime 下发时间
	 */

	public String getNtime() {
		return ntime;
	}

	/**
	 * 下发时间设定
	 * 
	 * @param ntime
	 *            下发时间
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	/**
	 * 下发者联系方式取得
	 * 
	 * @return ntel 下发者联系方式
	 */

	public String getNtel() {
		return ntel;
	}

	/**
	 * 下发者联系方式设定
	 * 
	 * @param ntel
	 *            下发者联系方式
	 */
	public void setNtel(String ntel) {
		this.ntel = ntel;
	}

	/**
	 * 风险提示描述取得
	 * 
	 * @return rwcontext 风险提示描述
	 */

	public String getRwcontext() {
		return rwcontext;
	}

	/**
	 * 风险提示描述设定
	 * 
	 * @param rwcontext
	 *            风险提示描述
	 */
	public void setRwcontext(String rwcontext) {
		this.rwcontext = rwcontext;
	}

	/**
	 * 提示附件取得
	 * 
	 * @return rwkey 提示附件
	 */

	public String getRwkey() {
		return rwkey;
	}

	/**
	 * 提示附件设定
	 * 
	 * @param rwkey
	 *            提示附件
	 */
	public void setRwkey(String rwkey) {
		this.rwkey = rwkey;
	}

	/**
	 * 允许查询的最大记录数取得
	 * 
	 * @return maxSearchCount 允许查询的最大记录数
	 */

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 允许查询的最大记录数设定
	 * 
	 * @param maxSearchCount
	 *            允许查询的最大记录数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 分页Bean取得
	 * 
	 * @return pagingDto 分页Bean
	 */

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页Bean设定
	 * 
	 * @param pagingDto
	 *            分页Bean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * form取得
	 * 
	 * @return form form
	 */

	public IGFXK0700Form getForm() {
		return form;
	}

	/**
	 * form设定
	 * 
	 * @param form
	 *            form
	 */
	public void setForm(IGFXK0700Form form) {
		this.form = form;
	}

	/**
	 * 风险提示数据接口取得
	 * 
	 * @return info 风险提示数据接口
	 */
	public RiskmanagerwaringInfo getInfo() {
		return info;
	}

	/**
	 * 风险提示数据接口设定
	 * 
	 * @param info
	 *            风险提示数据接口
	 */
	public void setInfo(RiskmanagerwaringInfo info) {
		this.info = info;
	}

	/**
	 * 风险提示id取得
	 * 
	 * @return rwid 风险提示id
	 */
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * 风险提示id设定
	 * 
	 * @param rwid
	 *            风险提示id
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	/**
	 * attachFile取得
	 * 
	 * @return attachFile attachFile
	 */
	public IGFXK0700Form getAttachFile() {
		return attachFile;
	}

	/**
	 * attachFile设定
	 * 
	 * @param attachFile
	 *            attachFile
	 */
	public void setAttachFile(IGFXK0700Form attachFile) {
		this.attachFile = attachFile;
	}

	/**
	 * 短信内容取得
	 * 
	 * @return smsContext 短信内容
	 */
	public String getSmsContext() {
		return smsContext;
	}

	/**
	 * 短信内容设定
	 * 
	 * @param smsContext
	 *            短信内容
	 */
	public void setSmsContext(String smsContext) {
		this.smsContext = smsContext;
	}

	/**
	 * 邮件内容取得
	 * 
	 * @return mailTitle 邮件内容
	 */
	public String getMailTitle() {
		return mailTitle;
	}

	/**
	 * 邮件内容设定
	 * 
	 * @param mailTitle
	 *            邮件内容
	 */
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	/**
	 * 风险提示相关信息集合取得
	 * 
	 * @return voList 风险提示相关信息集合
	 */
	public List<IGFXK07012VO> getVoList() {
		return voList;
	}

	/**
	 * 风险提示相关信息集合设定
	 * 
	 * @param voList
	 *            风险提示相关信息集合
	 */
	public void setVoList(List<IGFXK07012VO> voList) {
		this.voList = voList;
	}
	public int getPrlistsize() {
		return prlistsize;
	}

	public void setPrlistsize(int prlistsize) {
		this.prlistsize = prlistsize;
	}

	public int getQdlistsize() {
		return qdlistsize;
	}

	public void setQdlistsize(int qdlistsize) {
		this.qdlistsize = qdlistsize;
	}

	public int getQmlistsize() {
		return qmlistsize;
	}

	public void setQmlistsize(int qmlistsize) {
		this.qmlistsize = qmlistsize;
	}

	public int getPglistsize() {
		return pglistsize;
	}

	public void setPglistsize(int pglistsize) {
		this.pglistsize = pglistsize;
	}
	public int getRisklistsize() {
		return risklistsize;
	}

	public void setRisklistsize(int risklistsize) {
		this.risklistsize = risklistsize;
	}

	/**
	 * qdExcing取得
	 * @return qdExcing qdExcing
	 */
	public int getQdExcing() {
		return qdExcing;
	}

	/**
	 * qdExcing设定
	 * @param qdExcing qdExcing
	 */
	public void setQdExcing(int qdExcing) {
		this.qdExcing = qdExcing;
	}

	/**
	 * qdYear取得
	 * @return qdYear qdYear
	 */
	public int getQdYear() {
		return qdYear;
	}

	/**
	 * qdYear设定
	 * @param qdYear qdYear
	 */
	public void setQdYear(int qdYear) {
		this.qdYear = qdYear;
	}

}
