package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;


/**
 * �����ʲ���ѯҳ����FORM
 * IGCOM0101Form ActionForm
 */
public class IGDRM0108Form extends BaseForm {

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
	private Integer prid;//����ID
	//��������
	private String flowType;
	/** �豸ID */
	protected String eiid;
	/** Ԥ���޸��������� */
	protected String cycleTime;
	
	/**ģ��ƥ��Ԥ�����ı���������*/
	private String planContent;
	/** �洢����like*/
	protected String esyscoding_like;
	
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
	public Integer getPrid() {
		return prid;
	}
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	public String getFlowType() {
		return flowType;
	}
	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}
	
}
