/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

import java.util.List;


/**
  * 概述: 场景检索条件接口
  * 功能描述: 场景检索条件接口
  * 创建记录: 2014/05/21 wym
  * 修改记录: 
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
	 * 获取participants  
	 * @return participants 
	 */
	public String getParticipants();
	/**  
	 * 获取assest  
	 * @return assest 
	 */
	public String getAssest();
	
	/**  
	 * 获取assesteiid  
	 * @return assesteiid 
	 */
	public String getAssesteiid();
	
	/**  
	 * 获取eiinsdatestart  
	 * @return eiinsdatestart 
	 */
	public String getEiinsdatestart();
	/**  
	 * 获取eiinsdateend  
	 * @return eiinsdateend 
	 */
	public String getEiinsdateend();
	
	/**  
	 * 获取senceClassify  
	 * @return senceClassify 
	 */
	public String getSenceClassify();
}