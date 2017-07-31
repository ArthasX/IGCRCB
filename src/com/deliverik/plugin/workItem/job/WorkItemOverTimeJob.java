package com.deliverik.plugin.workItem.job;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.bl.task.WorkInstanceBL;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;

public class WorkItemOverTimeJob implements Job{
	
    private static Log log = LogFactory.getLog(WorkItemOverTimeJob.class);
	
	public static final String JOB_NAME = "WORKITEMOVERTIME_JOB";
	
	public static final String JOB_EXPRESSION = "0 0 1 * * ?";	//�� �� ʱ �� �� ��;
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		log.info("<<<<<<<<<<ʵ�����ʱ������Job��ʼ>>>>>>>>>>");		
		////��ѯ���г�����ǰʱ��Ĺ�����,�������й������Ӧ�Ĺ����Ƿ��Ѿ�����������Ѿ���������ѯ�����ʱ��
		
		WorkInstanceBL ctlBL = (WorkInstanceBL) WebApplicationSupport.getBean("workInstanceBL");
		WorkDefinitionBL ctldefBL = (WorkDefinitionBL) WebApplicationSupport.getBean("workDefinitionBL");
		List<Map<String,String>> resultMap = ctlBL.getExcutedMaxTime();
		if(resultMap!=null&&resultMap.size()>0){
			for(Map<String,String> tempMap:resultMap){
				WorkDefinitionTB workDefinitionTB = new WorkDefinitionTB();
				//��ȡ�����������
				WorkDefinitionInfo workDefinitionInfo;
				try {
					workDefinitionInfo = ctldefBL.searchWorkDefinitionByPK(Integer.parseInt(tempMap.get("wdid")));
					//Copy�������TB
					BeanUtils.copyProperties(workDefinitionInfo, workDefinitionTB);
					workDefinitionTB.setActualFinishDate(tempMap.get("maxovertime"));
					ctldefBL.updateWorkDefinition(workDefinitionTB);
					log.info("<<<<<<<<<<ʵ�����ʱ�����ɶ�ʱ����Job��������>>>>>>>>>>");
				} catch (NumberFormatException e) {
					log.debug("���ɸ���ʵ�����ʱ�䶨ʱ����ʧ�ܣ�"+e.getMessage());
					e.printStackTrace();
				} catch (BLException e) {
					log.debug("���ɸ���ʵ�����ʱ�䶨ʱ����ʧ�ܣ�"+e.getMessage());
					e.printStackTrace();
				}
				
			}
		}
		log.info("<<<<<<<<<<ʵ�����ʱ������Job����>>>>>>>>>>");
	}

}
