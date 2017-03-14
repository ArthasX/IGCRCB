package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备编辑画面FORM
 * 
 */
public class IGDRM2104Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	private String  einame ; // 资产名称
	private String  ename ; // 资产编号
	private String  eilabel ; // 资产编号
	private String  eiinsdate_ge ;// 资产登记日大于等于
	private String  eiinsdate_le ;// 资产登记日 小于等于
	private String  eiorgsyscoding ; // 资产所属机构层次码
	private String orgname;
	private String  esyscoding ; // 资产模型层次码
	private String  eiuserid ; // 资产管理人
	private String  eiusername ; // 资产管理人姓名
	private String planlevel;
	private String planstatus;
	private String planmode;
	private String plantype;
	private String participants;
	private String assest;
	private String assesteiid;
	private String relationEiid;
	private String selectEiids;
	/** 设备ID */
	protected String eiid;
	protected String eid;
	protected String cid;
	protected String[] eiids;
	/** 预案修改提醒周期 */
	protected String cycleTime;
	
	/**模糊匹配预案的文本框类属性*/
	private String planContent;
	/** 存储过滤like*/
	protected String esyscoding_like;
	//创建起始日期
	private String eiinsdatestart;
	//创建结束日期
	private String eiinsdateend;
	
	public String getEsyscoding_like() {
		return esyscoding_like;
	}
	public void setEsyscoding_like(String esyscoding_like) {
		this.esyscoding_like = esyscoding_like;
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
	public String getEiuserid() {
		return eiuserid;
	}
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}
	public String getEiusername() {
		return eiusername;
	}
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}
	public String getPlanlevel() {
		return planlevel;
	}
	public void setPlanlevel(String planlevel) {
		this.planlevel = planlevel;
	}
	public String getPlanstatus() {
		return planstatus;
	}
	public void setPlanstatus(String planstatus) {
		this.planstatus = planstatus;
	}
	public String getPlanmode() {
		return planmode;
	}
	public void setPlanmode(String planmode) {
		this.planmode = planmode;
	}
	public String getPlantype() {
		return plantype;
	}
	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	
	public String getEiid() {
		return eiid;
	}
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	public String getCycleTime() {
		return cycleTime;
	}
	public void setCycleTime(String cycleTime) {
		this.cycleTime = cycleTime;
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
	public String getRelationEiid() {
		return relationEiid;
	}
	public void setRelationEiid(String relationEiid) {
		this.relationEiid = relationEiid;
	}
	public String getSelectEiids() {
		return selectEiids;
	}
	public void setSelectEiids(String selectEiids) {
		this.selectEiids = selectEiids;
	}
	public String[] getEiids() {
		return eiids;
	}
	public void setEiids(String[] eiids) {
		this.eiids = eiids;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
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
	
}
