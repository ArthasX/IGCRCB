/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.soc.vir.bl.task.VCD02BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD03BL;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD02TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯����_��Դ����_�Զ�������ɼ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIM3002JOB implements Job {
	private static Log log = LogFactory.getLog(IGVIM0102JOB.class);

	private static VCD02BL vcd02BL = (VCD02BL) WebApplicationSupport
			.getBean("vcd02BL");
	private static VCD03BL vcd03BL = (VCD03BL) WebApplicationSupport
			.getBean("vcd03BL");
	private static FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport
			.getBean("flowOptBL");
	public static final String JOB_NAME = "VCLOUD_AUTODEPLOY_MONITOR_JOB_";
	public static final String JOB_GROUP_NAME = "VCLOUD_AUTODEPLOY_MONITOR_JOB_GROUP";
	public static final String TRIGGER_NAME = "VCLOUD_AUTODEPLOY_MONITOR_TRIGGER_";
	public static final String TRIGGER_GROUP_NAME = "VCLOUD_AUTODEPLOY_MONITOR_TRIGGER_GROUP";

	/**
	 * ���
	 * 
	 * @param context
	 */

	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("============== Quartz�����¡�������ʼ =============");
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		Integer pid = (Integer) jobDataMap.get("pid");
		Integer prid = (Integer) jobDataMap.get("prid");
		String executorid = (String) jobDataMap.get("executorid");

		VCD03SearchCondImpl cond = new VCD03SearchCondImpl();
		boolean stop = false;
		while (!stop) {
			cond.setPid(pid);
			cond.setPrid(prid);
			List<VCD03Info> vcd03List = vcd03BL.searchVCD03(cond);
			boolean completed = true;
			boolean hasError = false;
			try {

				// ���������Ϣ
				for (VCD03Info vcd03Info : vcd03List) {

					// �����쳣�����
					if ("-1".equals(vcd03Info.getProgress())) {
						hasError = true;
					}

					// ����Ϊ������ɵ����
					boolean jobAdded = JobManager.isJobAdded(
							IGVIM3001JOB.JOB_NAME + vcd03Info.getId(),
							IGVIM3001JOB.JOB_GROUP_NAME);
					if (jobAdded) {
						completed = false;
					}

				}

				// �������
				if (completed) {
					String butName = "";
					VCD02Info vcd02info = vcd02BL.searchVCD02ByPK(pid);
					VCD02TB vcd02tb = (VCD02TB) SerializationUtils
							.clone(vcd02info);
					if (!hasError) {
						butName = "����ɹ�";
						vcd02tb.setProgress("100");
					} else {
						butName = "�����쳣";
						vcd02tb.setProgress("-1");
					}
					vcd02BL.updateVCD02(vcd02tb);

					log.debug("============= ������� ԾǨ����״̬����ʼ ===================");
					flowOptBL.transitionProcess(prid, executorid, butName,
							IGStringUtils.getCurrentDateTime());
					log.debug("============= ������� ԾǨ����״̬������� ===================");
					stop = true;
				} else {
					Thread.sleep(3 * 1000);
				}

			} catch (SchedulerException e) {
			} catch (ParseException e) {
			} catch (BLException e) {
				log.debug("=============== ԾǨ����״̬ʱ�쳣 ===============");
				log.error("ԾǨ����״̬ʱ�쳣", e);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		log.debug("============== Quartz�����¡���������� =============");
	}
}
