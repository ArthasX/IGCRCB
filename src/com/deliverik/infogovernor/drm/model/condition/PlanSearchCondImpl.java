/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;


/**
 * 概述: 场景检索条件接口 实现
 * 功能描述: 场景检索条件接口 实现
 * 创建记录: 2014/05/21 wym
 * 修改记录: 
 */
public class PlanSearchCondImpl implements
		PlanSearchCond {

	private Integer eiid ;
	/**场景名称*/
	private String einame;
	/**场景编号*/
	private String eilabel;
	/**创建日期大于等于*/
	private String eiinsdate_ge;
	/**创建日期小于等于*/
	private String eiinsdate_le;
	/**机构码*/
	private String eiorgsyscoding;
	/**机构码向下匹配*/
	private String eiorgsyscoding_like;
	/**模型层次码*/
	private String esyscoding;
	/**创建用户姓名*/
	private String eiusername;
	/**创建用户id*/
	private String eiuserid;
	/**预案模式(单一,复合)*/
	private String  planmode;
	/**关联处置流程id*/
	private String planprocessid;
	/**风险等级*/
	private String  planlevel;
	/**演练吃否成功*/
	private String  plansuccess;
	/**预案状态(可执行,不可执行)*/
	private String planstatus;
	/**不包含所指定的id*/
	private Integer[] idsNotIn;
	
	/** 存储过滤like*/
	protected String esyscoding_like;
	/**模糊匹配预案的文本框类属性*/
	private String planContent;
	/**与其关联的预案申请流程id*/
	private Integer prid;
	protected String participants;
	protected 	String assest;
	protected String assesteiid;
	private String senceClassify;//场景分类
	//创建起始日期
	private String eiinsdatestart;
	//创建结束日期
	private String eiinsdateend;
	
	/** 场景id集合 */
	protected List<Integer> planEiids;


	public List<Integer> getPlanEiids() {
		return planEiids;
	}

	public void setPlanEiids(List<Integer> planEiids) {
		this.planEiids = planEiids;
	}
	public String getEsyscoding_like() {
		return esyscoding_like;
	}
	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	public String getEiname() {
		return einame;
	}
	public void setEiname(String einame) {
		this.einame = einame;
	}
	public String getEilabel() {
		return eilabel;
	}
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	public String getEiinsdate_ge() {
		return eiinsdate_ge;
	}
	public void setEiinsdate_ge(String eiinsdate_ge) {
		this.eiinsdate_ge = eiinsdate_ge;
	}
	public String getEiinsdate_le() {
		return eiinsdate_le;
	}
	public void setEiinsdate_le(String eiinsdate_le) {
		this.eiinsdate_le = eiinsdate_le;
	}
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	public String getEiusername() {
		return eiusername;
	}
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	public String getPlanmode() {
		return planmode;
	}
	public void setPlanmode(String planmode) {
		this.planmode = planmode;
	}
	public String getPlanprocessid() {
		return planprocessid;
	}
	public void setPlanprocessid(String planprocessid) {
		this.planprocessid = planprocessid;
	}
	public String getPlanlevel() {
		return planlevel;
	}
	public void setPlanlevel(String planlevel) {
		this.planlevel = planlevel;
	}
	public String getPlansuccess() {
		return plansuccess;
	}
	public void setPlansuccess(String plansuccess) {
		this.plansuccess = plansuccess;
	}
	public String getPlanstatus() {
		return planstatus;
	}
	public void setPlanstatus(String planstatus) {
		this.planstatus = planstatus;
	}
	public String getEiuserid() {
		return eiuserid;
	}
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	public Integer[] getIdsNotIn() {
		return idsNotIn;
	}
	public void setIdsNotIn(Integer[] idsNotIn) {
		this.idsNotIn = idsNotIn;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public String getEiorgsyscoding_like() {
		return eiorgsyscoding_like;
	}
	public void setEiorgsyscoding_like(String eiorgsyscoding_like) {
		this.eiorgsyscoding_like = eiorgsyscoding_like;
	}
	/**  
	 * 获取participants  
	 * @return participants 
	 */
	public String getParticipants() {
		return participants;
	}
	/**  
	 * 设置participants  
	 * @param participants
	 */
	
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	/**  
	 * 获取assest  
	 * @return assest 
	 */
	public String getAssest() {
		return assest;
	}
	/**  
	 * 设置assest  
	 * @param assest
	 */
	
	public void setAssest(String assest) {
		this.assest = assest;
	}
	/**  
	 * 获取assesteiid  
	 * @return assesteiid 
	 */
	public String getAssesteiid() {
		return assesteiid;
	}
	/**  
	 * 设置assesteiid  
	 * @param assesteiid
	 */
	
	public void setAssesteiid(String assesteiid) {
		this.assesteiid = assesteiid;
	}
	/**  
	 * 获取eiinsdatestart  
	 * @return eiinsdatestart 
	 */
	public String getEiinsdatestart() {
		return eiinsdatestart;
	}
	/**  
	 * 设置eiinsdatestart  
	 * @param eiinsdatestart
	 */
	
	public void setEiinsdatestart(String eiinsdatestart) {
		this.eiinsdatestart = eiinsdatestart;
	}
	/**  
	 * 获取eiinsdateend  
	 * @return eiinsdateend 
	 */
	public String getEiinsdateend() {
		return eiinsdateend;
	}
	/**  
	 * 设置eiinsdateend  
	 * @param eiinsdateend
	 */
	
	public void setEiinsdateend(String eiinsdateend) {
		this.eiinsdateend = eiinsdateend;
	}
	/**  
	 * 获取senceClassify  
	 * @return senceClassify 
	 */
	public String getSenceClassify() {
		return senceClassify;
	}
	/**  
	 * 设置senceClassify  
	 * @param senceClassify
	 */
	
	public void setSenceClassify(String senceClassify) {
		this.senceClassify = senceClassify;
	}
	
	
	
}