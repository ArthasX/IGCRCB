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
	/**节点*/
	protected IG333Info ig333Info;
	/**任务描述*/
	protected String duty;
	/**分类应急资源*/
	protected Map<String,List<SOC0118VWInfo>> soc0118Map;
	
	/**应急资源*/
	protected List<SOC0118VWInfo> soc0118List;
	
	/**参与人*/
	protected Map<String,UserInfo> userMap;
	
	/**孩子节点*/
	protected List<FlowDetail> childStepList;
	/**序号*/
	protected String sequence;
	
	/**  
	 * 获取sequence  
	 * @return sequence 
	 */
	public String getSequence() {
		return sequence;
	}
	/**  
	 * 设置sequence  
	 * @param sequence
	 */
	
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	/**  
	 * 获取userMap  
	 * @return userMap 
	 */
	public Map<String, UserInfo> getUserMap() {
		return userMap;
	}
	/**  
	 * 设置userMap  
	 * @param userMap
	 */
	
	public void setUserMap(Map<String, UserInfo> userMap) {
		this.userMap = userMap;
	}
	/**  
	 * 获取ig333Info  
	 * @return ig333Info 
	 */
	public IG333Info getIg333Info() {
		return ig333Info;
	}
	/**  
	 * 设置ig333Info  
	 * @param ig333Info
	 */
	
	public void setIg333Info(IG333Info ig333Info) {
		this.ig333Info = ig333Info;
	}
	/**  
	 * 获取duty  
	 * @return duty 
	 */
	public String getDuty() {
		return duty;
	}
	/**  
	 * 设置duty  
	 * @param duty
	 */
	
	public void setDuty(String duty) {
		this.duty = duty;
	}
	/**  
	 * 获取childStepList  
	 * @return childStepList 
	 */
	public List<FlowDetail> getChildStepList() {
		return childStepList;
	}
	/**  
	 * 设置childStepList  
	 * @param childStepList
	 */
	
	public void setChildStepList(List<FlowDetail> childStepList) {
		this.childStepList = childStepList;
	}
	/**  
	 * 获取soc0118Map  
	 * @return soc0118Map 
	 */
	public Map<String, List<SOC0118VWInfo>> getSoc0118Map() {
		return soc0118Map;
	}
	/**  
	 * 设置soc0118Map  
	 * @param soc0118Map
	 */
	
	public void setSoc0118Map(Map<String, List<SOC0118VWInfo>> soc0118Map) {
		this.soc0118Map = soc0118Map;
	}
	/**  
	 * 获取soc0118List  
	 * @return soc0118List 
	 */
	public List<SOC0118VWInfo> getSoc0118List() {
		return soc0118List;
	}
	/**  
	 * 设置soc0118List  
	 * @param soc0118List
	 */
	
	public void setSoc0118List(List<SOC0118VWInfo> soc0118List) {
		this.soc0118List = soc0118List;
	}
	
	
	
}
