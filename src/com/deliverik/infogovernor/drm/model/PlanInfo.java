/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;


/**
  * ����: ������ͼ�ӿ�
  * ��������: ������ͼ�ӿ�
  * ������¼: 2014/05/21 wym
  * �޸ļ�¼: 
  */
public interface PlanInfo{
	
	public String getEid();
	public Integer getEiid();
	public String getEiname();
	public String getEilabel();
	public String getEiinsdate();
	public String getEiorgsyscoding();
	public String getEsyscoding();
	public Integer getEiversion();
	public String getEiuserid();
	public Integer getEismallversion();
	public String getEiusername();
	public String getEiupdtime();
	public String getSenceClassify();
	
//	public String getPlanlevel();
//	public String getPlanmode();
//	public String getPlanprocessid();
//	public String getPlanprocessname();
//	public String getPlanstatus();
//	public String getPlansuccess();
	public String getOrgname();
	public String getCdinfo();
	
	//�����ʲ�����
	public String getScename();
	public String getScedes();
	public String getTimes();
	public String getScepdid();
	public String getSceprid();
	public String getIsplan();
	public String getScetype();
	public String getNeedrise();
}