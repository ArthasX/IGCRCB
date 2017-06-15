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
	/**流程PRID*/
	protected String prid;
	/**评估意见*/
	protected String suggestion;
	/**显示的流程prid*/
	protected String flowPrid;
	
	/**评估总体评价*/
	private EvaluationContentInfo evaluationInfo;
	
	
	
	/**  
	 * 获取evaluationInfo  
	 * @return evaluationInfo 
	 */
	public EvaluationContentInfo getEvaluationInfo() {
		return evaluationInfo;
	}

	/**  
	 * 设置evaluationInfo  
	 * @param evaluationInfo
	 */
	
	public void setEvaluationInfo(EvaluationContentInfo evaluationInfo) {
		this.evaluationInfo = evaluationInfo;
	}
	/**  
	 * 获取flowPrid  
	 * @return flowPrid 
	 */
	public String getFlowPrid() {
		return flowPrid;
	}

	/**  
	 * 设置flowPrid  
	 * @param flowPrid
	 */
	
	public void setFlowPrid(String flowPrid) {
		this.flowPrid = flowPrid;
	}

	/**  
	 * 获取prid  
	 * @return prid 
	 */
	public String getPrid() {
		return prid;
	}

	/**  
	 * 设置prid  
	 * @param prid
	 */
	
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**  
	 * 获取suggestion  
	 * @return suggestion 
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**  
	 * 设置suggestion  
	 * @param suggestion
	 */
	
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	
	
	
}
