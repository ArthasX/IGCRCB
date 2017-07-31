/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.workItem.job;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.plugin.workItem.bl.WorkRemindBL;
import com.system.plugins.utils.PluginsDataUtils;

import nl.justobjects.pushlet.util.Log;

/**
 * 
 * @Description ����ʵ������Job��
 *
 * @date 2017��6��22��
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkRemindJob implements Job{
	
	public static final String JOB_NAME = "WORKREMIND_JOB";
	
//	public static final String JOB_EXPRESSION = "0 0/1 * * * ?";//�� �� ʱ �� �� ��;
//	public static final String JOB_EXPRESSION = "0 0/5 * * * ?";//�� �� ʱ �� �� ��;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		Log.info("<<<<<<<<<<����ʵ������Job����ؿ�ʼ>>>>>>>>>>");

		if (context == null)
			return;
		//ȡ�������ļ�·��
		PluginsDataUtils pdUtil = new PluginsDataUtils();
		StringBuffer path = new StringBuffer();
		path.append(pdUtil.getAbsolutePathByClass());
		path.append(File.separator);
		path.append("WEB-INF");
		path.append(File.separator);
		path.append("plugin");
		path.append(File.separator);
		path.append("workItem");
		path.append(File.separator);
		path.append("config");
		path.append(File.separator);
		path.append("config.properties");
		Properties prop = new Properties();
		try {
			//�鿴����Ƿ�����
			prop.load(new FileInputStream(path.toString()));
			//����״̬������ִ���߼�
			if("Y".equals(prop.getProperty("PLUGIN_STATUS"))){
				
				//����ʵ������BLȡ��
				WorkRemindBL ctlBL = (WorkRemindBL) WebApplicationSupport.getBean("workremindBL");
				//����BL������Ҫ���ѵĹ���ʵ��
				ctlBL.workInstanceRemind();
			}else{
				//ͣ��״̬��ɾ����ʷ����
				JobManager.removeJob(JOB_NAME);
			}
		} catch (Exception e) {
			throw new JobExecutionException(e.getMessage());
		}
		
		Log.info("<<<<<<<<<<����ʵ������Job����ؽ���>>>>>>>>>>");
	}
}
