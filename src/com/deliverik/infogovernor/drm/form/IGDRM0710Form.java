/**
 * 
 */
package com.deliverik.infogovernor.drm.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;

/**
 * @author Administrator
 *
 */
public class IGDRM0710Form  extends BaseForm {
	/**����PRID*/
	protected String prid;
	/**�������*/
	protected String suggestion;
	/**��ʾ������prid*/
	protected String flowPrid;
	
	/**������������*/
	private EvaluationContentInfo evaluationInfo;
	
	
	
	/**  
	 * ��ȡevaluationInfo  
	 * @return evaluationInfo 
	 */
	public EvaluationContentInfo getEvaluationInfo() {
		return evaluationInfo;
	}

	/**  
	 * ����evaluationInfo  
	 * @param evaluationInfo
	 */
	
	public void setEvaluationInfo(EvaluationContentInfo evaluationInfo) {
		this.evaluationInfo = evaluationInfo;
	}
	/**  
	 * ��ȡflowPrid  
	 * @return flowPrid 
	 */
	public String getFlowPrid() {
		return flowPrid;
	}

	/**  
	 * ����flowPrid  
	 * @param flowPrid
	 */
	
	public void setFlowPrid(String flowPrid) {
		this.flowPrid = flowPrid;
	}

	/**  
	 * ��ȡprid  
	 * @return prid 
	 */
	public String getPrid() {
		return prid;
	}

	/**  
	 * ����prid  
	 * @param prid
	 */
	
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**  
	 * ��ȡsuggestion  
	 * @return suggestion 
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**  
	 * ����suggestion  
	 * @param suggestion
	 */
	
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	
	
}
