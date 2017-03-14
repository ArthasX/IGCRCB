/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;


/**
  * ����: �������������ӿ�
  * ��������: �������������ӿ�
  * ������¼: 2014/05/21 wym
  * �޸ļ�¼: 
  */
public interface PlanSearchCond {
	
	public Integer getEiid();
	public String getEiinsdate_ge();
	public String getEiinsdate_le();
	public String getEilabel();
	public String getEiname();
	public String getEiorgsyscoding();
	public String getEiuserid();
	public String getEiusername();
	public String getEsyscoding();
	public String getPlanlevel();
	public String getPlanmode();
	public String getPlanprocessid();
	public String getPlanstatus();
	public String getPlansuccess();
	public Integer[] getIdsNotIn();
	public String getEsyscoding_like();
	public String getPlanContent();
	public Integer getPrid();
	public String getEiorgsyscoding_like();

	public List<Integer> getPlanEiids();
	/**  
	 * ��ȡparticipants  
	 * @return participants 
	 */
	public String getParticipants();
	/**  
	 * ��ȡassest  
	 * @return assest 
	 */
	public String getAssest();
	
	/**  
	 * ��ȡassesteiid  
	 * @return assesteiid 
	 */
	public String getAssesteiid();
	
	/**  
	 * ��ȡeiinsdatestart  
	 * @return eiinsdatestart 
	 */
	public String getEiinsdatestart();
	/**  
	 * ��ȡeiinsdateend  
	 * @return eiinsdateend 
	 */
	public String getEiinsdateend();
	
	/**  
	 * ��ȡsenceClassify  
	 * @return senceClassify 
	 */
	public String getSenceClassify();
}