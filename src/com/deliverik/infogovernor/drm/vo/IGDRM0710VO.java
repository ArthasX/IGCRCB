/**
 * 
 */
package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.util.StepUtil;

/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class IGDRM0710VO  extends BaseVO implements Serializable {
	/** ������ϸ��Ϣ */
	private Map<String,Object> drillDetailMap;

	/**Ӧ��ָ�ӵ���������*/
	private List<EvaluationContentInfo> evaluationContentList;
	/**Ӧ�����õ���������*/
	private List<EvaluationContentInfo> senceContentList;
	
	
	/**Ӧ��ָ����������*/
	private EvaluationContentInfo emEvaluationContent;
	/**Ӧ��������������*/
	private EvaluationContentInfo seEvaluationContent;
	/**��������*/
	private List<EvaluationContentInfo> evaluationList;
	
	/**������������*/
	private EvaluationContentInfo evaluationInfo;
	/**�ڵ���ϸ*/
	private StepUtil step;
	
	
	/**  
	 * ��ȡstep  
	 * @return step 
	 */
	public StepUtil getStep() {
		return step;
	}

	/**  
	 * ����step  
	 * @param step
	 */
	
	public void setStep(StepUtil step) {
		this.step = step;
	}

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
	 * ��ȡevaluationList  
	 * @return evaluationList 
	 */
	public List<EvaluationContentInfo> getEvaluationList() {
		return evaluationList;
	}

	/**  
	 * ����evaluationList  
	 * @param evaluationList
	 */
	
	public void setEvaluationList(List<EvaluationContentInfo> evaluationList) {
		this.evaluationList = evaluationList;
	}

	/**  
	 * ��ȡevaluationContentList  
	 * @return evaluationContentList 
	 */
	public List<EvaluationContentInfo> getEvaluationContentList() {
		return evaluationContentList;
	}

	/**  
	 * ����evaluationContentList  
	 * @param evaluationContentList
	 */
	
	public void setEvaluationContentList(
			List<EvaluationContentInfo> evaluationContentList) {
		this.evaluationContentList = evaluationContentList;
	}

	/**  
	 * ��ȡdrillDetailMap  
	 * @return drillDetailMap 
	 */
	public Map<String, Object> getDrillDetailMap() {
		return drillDetailMap;
	}

	/**  
	 * ����drillDetailMap  
	 * @param drillDetailMap
	 */
	
	public void setDrillDetailMap(Map<String, Object> drillDetailMap) {
		this.drillDetailMap = drillDetailMap;
	}

	/**  
	 * ��ȡsenceContentList  
	 * @return senceContentList 
	 */
	public List<EvaluationContentInfo> getSenceContentList() {
		return senceContentList;
	}

	/**  
	 * ����senceContentList  
	 * @param senceContentList
	 */
	
	public void setSenceContentList(List<EvaluationContentInfo> senceContentList) {
		this.senceContentList = senceContentList;
	}

	/**  
	 * ��ȡemEvaluationContent  
	 * @return emEvaluationContent 
	 */
	public EvaluationContentInfo getEmEvaluationContent() {
		return emEvaluationContent;
	}

	/**  
	 * ����emEvaluationContent  
	 * @param emEvaluationContent
	 */
	
	public void setEmEvaluationContent(EvaluationContentInfo emEvaluationContent) {
		this.emEvaluationContent = emEvaluationContent;
	}

	/**  
	 * ��ȡseEvaluationContent  
	 * @return seEvaluationContent 
	 */
	public EvaluationContentInfo getSeEvaluationContent() {
		return seEvaluationContent;
	}

	/**  
	 * ����seEvaluationContent  
	 * @param seEvaluationContent
	 */
	
	public void setSeEvaluationContent(EvaluationContentInfo seEvaluationContent) {
		this.seEvaluationContent = seEvaluationContent;
	}
	
}