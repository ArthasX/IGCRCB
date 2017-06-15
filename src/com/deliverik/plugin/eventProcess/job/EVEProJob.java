/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.eventProcess.job;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.plugin.eventProcess.bl.EVEProBL;
import com.system.plugins.utils.PluginsDataUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯����ͬ��
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
public class EVEProJob implements Job{
	
	public static final String JOB_NAME = "EVENTPROCESS_JOB";
	
	public static final String JOB_EXPRESSION = "0 0/1 * * * ?";//�� �� ʱ �� �� ��;

	public void execute(JobExecutionContext context) throws JobExecutionException {

		if (context != null)
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
		path.append("eventProcess");
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
				EVEProBL ctlBL = (EVEProBL) WebApplicationSupport.getBean("eveproBL");
				ctlBL.dataSynchronism();
			}else{
				//ͣ��״̬��ɾ����ʷ����
				JobManager.removeJob(JOB_NAME);
			}
		} catch (Exception e) {
			throw new JobExecutionException(e.getMessage());
		}
	}
}
