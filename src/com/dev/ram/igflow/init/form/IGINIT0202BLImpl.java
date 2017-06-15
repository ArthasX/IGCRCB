/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ram.igflow.init.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.infogovernor.ram.bl.task.AssessmentScoreVWBL;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCondImpl;

/**
 * <p>
 * ������������    �쵼����״̬��ֵ��ʼ��
 * </p>
 */
public class IGINIT0202BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGINIT0202BLImpl.class);
	
	/** ���ռ����ϢBL */
	protected AssessmentScoreVWBL assessmentScoreVWBL;
	
	/**
	 * assessmentScoreVWBL�趨
	 */
	public void setAssessmentScoreVWBL(AssessmentScoreVWBL assessmentScoreVWBL) {
		this.assessmentScoreVWBL = assessmentScoreVWBL;
	}

	/**
	 * ����״̬��ֵ��ʼ��
	 * 
	 * @param param ���̴�������ӿ�
	 * @return ��ֵ���ϣ�<����-ֵ>��
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		log.debug("======== ������������    �쵼����״����ʼ������ʼ========");
		Map<String, Object> map = new HashMap<String, Object>();
		
		float score = 0;
		AssessmentScoreVWSearchCondImpl cond = new AssessmentScoreVWSearchCondImpl();
		cond.setPrid(param.getPrid());
		//��ѯָ�����̵����ּ�¼
		List<AssessmentScoreVWInfo> list = assessmentScoreVWBL.searchAssessmentScore(cond);
		//�����ܷ�
		for(AssessmentScoreVWInfo info :list){
			score += Float.parseFloat(info.getPpivalue());
		}
		if(list.size() > 0){
			score = score / list.size();
		}
		String totalScore = String.valueOf(score);
		if(totalScore.indexOf(".") > -1 && totalScore.substring(totalScore.indexOf("."), totalScore.length()).length() > 2){
			totalScore = totalScore.substring(0, totalScore.indexOf(".") + 3 );
		}
		map.put("�����÷�", totalScore);

		log.debug("======== ������������    �쵼����״����ʼ���������========");
		return map;
	}

}
