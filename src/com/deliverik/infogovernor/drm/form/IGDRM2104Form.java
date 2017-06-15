package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �豸�༭����FORM
 * 
 */
public class IGDRM2104Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	private String  einame ; // �ʲ�����
	private String  ename ; // �ʲ����
	private String  eilabel ; // �ʲ����
	private String  eiinsdate_ge ;// �ʲ��Ǽ��մ��ڵ���
	private String  eiinsdate_le ;// �ʲ��Ǽ��� С�ڵ���
	private String  eiorgsyscoding ; // �ʲ��������������
	private String orgname;
	private String  esyscoding ; // �ʲ�ģ�Ͳ����
	private String  eiuserid ; // �ʲ�������
	private String  eiusername ; // �ʲ�����������
	private String planlevel;
	private String planstatus;
	private String planmode;
	private String plantype;
	private String participants;
	private String assest;
	private String assesteiid;
	private String relationEiid;
	private String selectEiids;
	/** �豸ID */
	protected String eiid;
	protected String eid;
	protected String cid;
	protected String[] eiids;
	/** Ԥ���޸��������� */
	protected String cycleTime;
	
	/**ģ��ƥ��Ԥ�����ı���������*/
	private String planContent;
	/** �洢����like*/
	protected String esyscoding_like;
	//������ʼ����
	private String eiinsdatestart;
	//������������
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
	 * ��ȡparticipants  
	 * @return participants 
	 */
	public String getParticipants() {
		return participants;
	}
	/**  
	 * ����participants  
	 * @param participants
	 */
	
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	/**  
	 * ��ȡassest  
	 * @return assest 
	 */
	public String getAssest() {
		return assest;
	}
	/**  
	 * ����assest  
	 * @param assest
	 */
	
	public void setAssest(String assest) {
		this.assest = assest;
	}
	/**  
	 * ��ȡassesteiid  
	 * @return assesteiid 
	 */
	public String getAssesteiid() {
		return assesteiid;
	}
	/**  
	 * ����assesteiid  
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
	 * ��ȡeiinsdatestart  
	 * @return eiinsdatestart 
	 */
	public String getEiinsdatestart() {
		return eiinsdatestart;
	}
	/**  
	 * ����eiinsdatestart  
	 * @param eiinsdatestart
	 */
	
	public void setEiinsdatestart(String eiinsdatestart) {
		this.eiinsdatestart = eiinsdatestart;
	}
	/**  
	 * ��ȡeiinsdateend  
	 * @return eiinsdateend 
	 */
	public String getEiinsdateend() {
		return eiinsdateend;
	}
	/**  
	 * ����eiinsdateend  
	 * @param eiinsdateend
	 */
	
	public void setEiinsdateend(String eiinsdateend) {
		this.eiinsdateend = eiinsdateend;
	}
	
}
