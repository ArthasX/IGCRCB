/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.dev.vim.igflow.jobs;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM02BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯����_��Դ����_�Զ�������ɼ��
 * </p>
 * 
 * @version 1.0
 */

public class IGVIM0102JOB implements Job {

	private static Log log = LogFactory.getLog(IGVIM0102JOB.class);
	
	private static VIM02BL vim02BL = (VIM02BL) WebApplicationSupport.getBean("vim02BL");
	private static VIM03BL vim03BL = (VIM03BL) WebApplicationSupport.getBean("vim03BL");
	private static FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
    public static final String JOB_NAME = "AUTODEPLOY_MONITOR_JOB_";
    public static final String JOB_GROUP_NAME = "AUTODEPLOY_MONITOR_JOB_GROUP";
    public static final String TRIGGER_NAME = "AUTODEPLOY_MONITOR_TRIGGER_";
    public static final String TRIGGER_GROUP_NAME = "AUTODEPLOY_MONITOR_TRIGGER_GROUP";
    
	/**
	 * ���
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("============== Quartz�����¡�������ʼ =============");
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Integer pid = (Integer) jobDataMap.get("pid");
        Integer prid = (Integer) jobDataMap.get("prid");
        String executorid = (String) jobDataMap.get("executorid");

        Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        boolean stop = false;
        while(!stop) {
            log.debug("***************** �����������û ****************");
            cond.setPid_eq(pid);
            List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
            boolean completed = true;
            boolean hasError = false;
            try {
                
                // ���������Ϣ
                for (VIM03Info vim03Info : vim03List) {
                    
                    // �����쳣�����
                    if ("-1".equals(vim03Info.getProgress())) {
                        hasError = true;
                    }
                    
                    // ����Ϊ������ɵ����
                    boolean jobAdded = JobManager.isJobAdded(IGVIM0101JOB.JOB_NAME + vim03Info.getId(),
                            IGVIM0101JOB.JOB_GROUP_NAME);
                    if (jobAdded) {
                        completed = false;
                    }
                    
                }
                
                // �������
                if (completed) {
                    String butName = "";
                    
                    VIM02Info vim02info = vim02BL.searchVIM02ByPK(pid);
                    VIM02TB vim02tb = (VIM02TB) SerializationUtils.clone(vim02info);
                    if (!hasError) {
                        butName = "����ɹ�";
                        vim02tb.setProgress("100");
                    } else {
                        butName = "�����쳣";
                        vim02tb.setProgress("-1");
                    }
                    vim02BL.updateVIM02(vim02tb);
                    
                    log.debug("============= ������� ԾǨ����״̬����ʼ ===================");
                    flowOptBL.transitionProcess(prid, executorid, butName, IGStringUtils.getCurrentDateTime());
                    log.debug("============= ������� ԾǨ����״̬������� ===================");
                    log.debug("***************** ��������� ****************");
                    
                    stop = true;
                } else {
                    
                    log.debug("***************** �����㻹û���� ****************");
                    Thread.sleep(3 * 1000);
                }
                
            } catch (SchedulerException e) {
            } catch (ParseException e) {
            }
            catch (BLException e) {
                log.debug("=============== ԾǨ����״̬ʱ�쳣 ===============");
                log.error("ԾǨ����״̬ʱ�쳣", e);
            } 
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        log.debug("============== Quartz�����¡���������� =============");
    }

}