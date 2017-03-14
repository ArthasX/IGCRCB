package com.deliverik.infogovernor.scheduling.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.infogovernor.adapter.MailAdapter;

public class MailJob implements Job {

	private static Log log = LogFactory.getLog(MailJob.class);
	public static final String GROUP_NAME = "MAIL_GROUP";

	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("邮件发送开始");
		String title = (String) context.getJobDetail().getJobDataMap().get("title");
		String content = (String) context.getJobDetail().getJobDataMap().get("content");
		String[] receiverArr = (String[]) context.getJobDetail().getJobDataMap().get("receiverArr");
		String[] ccArr = (String[]) context.getJobDetail().getJobDataMap().get("ccArr");
		String[] bccArr = (String[]) context.getJobDetail().getJobDataMap().get("bccArr");
		context.getJobDetail().getJobDataMap().clear();
		if (bccArr != null && bccArr.length > 0) {
			MailAdapter.getInstance().sendMail(title, content,
			receiverArr, ccArr, bccArr);
		} else if (ccArr != null && ccArr.length > 0) {
			MailAdapter.getInstance().sendMail(title, content,
			receiverArr, ccArr);
		} else {
			MailAdapter.getInstance().sendMail(title, content,
			receiverArr);
		}
	}
}