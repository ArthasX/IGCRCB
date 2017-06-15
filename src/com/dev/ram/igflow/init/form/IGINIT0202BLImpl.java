/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 风险评估流程    领导审批状态表单值初始化
 * </p>
 */
public class IGINIT0202BLImpl extends BaseBLImpl implements
		WorkFlowInitFormHandlerBL {
	
	static Log log = LogFactory.getLog(IGINIT0202BLImpl.class);
	
	/** 风险检查信息BL */
	protected AssessmentScoreVWBL assessmentScoreVWBL;
	
	/**
	 * assessmentScoreVWBL设定
	 */
	public void setAssessmentScoreVWBL(AssessmentScoreVWBL assessmentScoreVWBL) {
		this.assessmentScoreVWBL = assessmentScoreVWBL;
	}

	/**
	 * 流程状态表单值初始化
	 * 
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException {
		log.debug("======== 风险评估流程    领导审批状表单初始化处理开始========");
		Map<String, Object> map = new HashMap<String, Object>();
		
		float score = 0;
		AssessmentScoreVWSearchCondImpl cond = new AssessmentScoreVWSearchCondImpl();
		cond.setPrid(param.getPrid());
		//查询指定流程的评分记录
		List<AssessmentScoreVWInfo> list = assessmentScoreVWBL.searchAssessmentScore(cond);
		//计算总分
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
		map.put("评估得分", totalScore);

		log.debug("======== 风险评估流程    领导审批状表单初始化处理结束========");
		return map;
	}

}
