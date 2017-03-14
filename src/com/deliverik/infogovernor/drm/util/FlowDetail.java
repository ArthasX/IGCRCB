/**
 * 
 */
package com.deliverik.infogovernor.drm.util;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;


/**
 * @author Administrator
 *
 */
public class FlowDetail{
	/**�ڵ�*/
	protected IG333Info ig333Info;
	/**��������*/
	protected String duty;
	/**����Ӧ����Դ*/
	protected Map<String,List<SOC0118VWInfo>> soc0118Map;
	
	/**Ӧ����Դ*/
	protected List<SOC0118VWInfo> soc0118List;
	
	/**������*/
	protected Map<String,UserInfo> userMap;
	
	/**���ӽڵ�*/
	protected List<FlowDetail> childStepList;
	/**���*/
	protected String sequence;
	
	/**  
	 * ��ȡsequence  
	 * @return sequence 
	 */
	public String getSequence() {
		return sequence;
	}
	/**  
	 * ����sequence  
	 * @param sequence
	 */
	
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	/**  
	 * ��ȡuserMap  
	 * @return userMap 
	 */
	public Map<String, UserInfo> getUserMap() {
		return userMap;
	}
	/**  
	 * ����userMap  
	 * @param userMap
	 */
	
	public void setUserMap(Map<String, UserInfo> userMap) {
		this.userMap = userMap;
	}
	/**  
	 * ��ȡig333Info  
	 * @return ig333Info 
	 */
	public IG333Info getIg333Info() {
		return ig333Info;
	}
	/**  
	 * ����ig333Info  
	 * @param ig333Info
	 */
	
	public void setIg333Info(IG333Info ig333Info) {
		this.ig333Info = ig333Info;
	}
	/**  
	 * ��ȡduty  
	 * @return duty 
	 */
	public String getDuty() {
		return duty;
	}
	/**  
	 * ����duty  
	 * @param duty
	 */
	
	public void setDuty(String duty) {
		this.duty = duty;
	}
	/**  
	 * ��ȡchildStepList  
	 * @return childStepList 
	 */
	public List<FlowDetail> getChildStepList() {
		return childStepList;
	}
	/**  
	 * ����childStepList  
	 * @param childStepList
	 */
	
	public void setChildStepList(List<FlowDetail> childStepList) {
		this.childStepList = childStepList;
	}
	/**  
	 * ��ȡsoc0118Map  
	 * @return soc0118Map 
	 */
	public Map<String, List<SOC0118VWInfo>> getSoc0118Map() {
		return soc0118Map;
	}
	/**  
	 * ����soc0118Map  
	 * @param soc0118Map
	 */
	
	public void setSoc0118Map(Map<String, List<SOC0118VWInfo>> soc0118Map) {
		this.soc0118Map = soc0118Map;
	}
	/**  
	 * ��ȡsoc0118List  
	 * @return soc0118List 
	 */
	public List<SOC0118VWInfo> getSoc0118List() {
		return soc0118List;
	}
	/**  
	 * ����soc0118List  
	 * @param soc0118List
	 */
	
	public void setSoc0118List(List<SOC0118VWInfo> soc0118List) {
		this.soc0118List = soc0118List;
	}
	
	
	
}
