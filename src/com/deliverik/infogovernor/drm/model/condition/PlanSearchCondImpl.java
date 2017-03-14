/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;


/**
 * ����: �������������ӿ� ʵ��
 * ��������: �������������ӿ� ʵ��
 * ������¼: 2014/05/21 wym
 * �޸ļ�¼: 
 */
public class PlanSearchCondImpl implements
		PlanSearchCond {

	private Integer eiid ;
	/**��������*/
	private String einame;
	/**�������*/
	private String eilabel;
	/**�������ڴ��ڵ���*/
	private String eiinsdate_ge;
	/**��������С�ڵ���*/
	private String eiinsdate_le;
	/**������*/
	private String eiorgsyscoding;
	/**����������ƥ��*/
	private String eiorgsyscoding_like;
	/**ģ�Ͳ����*/
	private String esyscoding;
	/**�����û�����*/
	private String eiusername;
	/**�����û�id*/
	private String eiuserid;
	/**Ԥ��ģʽ(��һ,����)*/
	private String  planmode;
	/**������������id*/
	private String planprocessid;
	/**���յȼ�*/
	private String  planlevel;
	/**�����Է�ɹ�*/
	private String  plansuccess;
	/**Ԥ��״̬(��ִ��,����ִ��)*/
	private String planstatus;
	/**��������ָ����id*/
	private Integer[] idsNotIn;
	
	/** �洢����like*/
	protected String esyscoding_like;
	/**ģ��ƥ��Ԥ�����ı���������*/
	private String planContent;
	/**���������Ԥ����������id*/
	private Integer prid;
	protected String participants;
	protected 	String assest;
	protected String assesteiid;
	private String senceClassify;//��������
	//������ʼ����
	private String eiinsdatestart;
	//������������
	private String eiinsdateend;
	
	/** ����id���� */
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
	/**  
	 * ��ȡsenceClassify  
	 * @return senceClassify 
	 */
	public String getSenceClassify() {
		return senceClassify;
	}
	/**  
	 * ����senceClassify  
	 * @param senceClassify
	 */
	
	public void setSenceClassify(String senceClassify) {
		this.senceClassify = senceClassify;
	}
	
	
	
}