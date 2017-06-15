/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.job;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;

/**
 * ����: ���̲�����ѯJobִ��
 * ������¼��2013/09/05
 * �޸ļ�¼��
 */
public class ProcessTacticsPollingJob implements Job {

    private static Log log = LogFactory.getLog(ProcessTacticsPollingJob.class);

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	log.debug("========���̲�����ѯJobִ�д���ʼ========");
    	JobKey key = context.getJobDetail().getKey();
		if (key != null)
			return;
    	//��ȡBL
        IG334BL ig334BL = (IG334BL) WebApplicationSupport.getBean("ig334BL");
        //��ȡBL
        IG335BL ig335BL = (IG335BL) WebApplicationSupport.getBean("ig335BL");
        //��ȡjob����
        String jobName = key.getName();
        //����job���ƽ�ȡ�ַ���,����Ϊpdid
        String[] jobNames = jobName.split(ProcessTacticsPollingJobInit.JOB_NAME);
        //����pdidʱ
        if(jobNames.length == 2){
        	try {
        		//������״̬
        		//����pdid��ȡ���̲�����Ϣ 
        		IG334SearchCondImpl ig334Cond = new IG334SearchCondImpl();
        		ig334Cond.setPdid_like(jobNames[1]);
        		List<IG334VWInfo> ig334vwInfos = ig334BL.findByCondTactics(ig334Cond);
        		
				//�������̲����趨��BLִ��init����
				for (int i = 0; i < ig334vwInfos.size(); i++) {
					//�趨BLִ�У�δ�趨��������
					if(StringUtils.isNotEmpty(ig334vwInfos.get(i).getProcessbl())) {
						WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(ig334vwInfos.get(i).getProcessbl());
						wfthBL.initExecute(ig334vwInfos.get(i).getPdid(),ig334vwInfos.get(i).getPsdid());
					}else {//Ϊ��ʱ����Ĭ�ϵ�����״̬���Դ�����
						WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(IGPRDCONSTANTS.PROCESS_TACTICS_STATUS);
						wfthBL.initExecute(ig334vwInfos.get(i).getPdid(),ig334vwInfos.get(i).getPsdid());
					}
				}
				
				
				//����������
				ig334Cond = new IG334SearchCondImpl();
				ig334Cond.setPdid_eq(jobNames[1]);
				List<IG334Info> ig334Infos = ig334BL.searchIG334(ig334Cond);
				if (!ig334Infos.isEmpty()) {
					String pididTemp = ig334Infos.get(0).getPidid();
					IG335SearchCondImpl ig335Cond = new IG335SearchCondImpl();
					ig335Cond.setPidid_eq(pididTemp);
					ig335Cond.setPsdid_eq(IGPRDCONSTANTS.MAIN_PROCESS_FLAG);//IG335������������������ص�Ĭ��ֵ
					List<IG335Info> ig335Infos = ig335BL.searchIG335(ig335Cond);
					if(!ig335Infos.isEmpty()){
						for(IG335Info ig335Info : ig335Infos){//����������ڴ洢IG335�����Կ��ܻ���ڶ�������Ҫ����ѭ������
							if(StringUtils.isNotEmpty(ig335Info.getProcessbl())) {
								WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(ig335Info.getProcessbl());
								wfthBL.initExecute(ig335Info.getPdid(),null);
							}else {//Ϊ��ʱ����Ĭ�ϵ�����������Դ�����
								WorkFlowTacticsHandlerBL wfthBL = (WorkFlowTacticsHandlerBL) WebApplicationSupport.getBean(IGPRDCONSTANTS.PROCESS_TACTICS_WHOLE);
								wfthBL.initExecute(ig335Info.getPdid(),null);
							}
						}
					}
				}
			} catch (BLException e) {
				log.debug(e.getMessage());
			}
        }
		log.debug("========���̲�����ѯJobִ�д������========");
    }
}