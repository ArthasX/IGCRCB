/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @Description 工作实例提醒Job类
 *
 * @date 2017年6月22日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkRemindJob implements Job{
	
	public static final String JOB_NAME = "WORKREMIND_JOB";
	
//	public static final String JOB_EXPRESSION = "0 0/1 * * * ?";//秒 分 时 日 月 周;
//	public static final String JOB_EXPRESSION = "0 0/5 * * * ?";//秒 分 时 日 月 周;

	public void execute(JobExecutionContext context) throws JobExecutionException {
		Log.info("<<<<<<<<<<工作实例提醒Job类加载开始>>>>>>>>>>");

		if (context == null)
			return;
		//取得配置文件路径
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
			//查看插件是否启用
			prop.load(new FileInputStream(path.toString()));
			//启用状态下正常执行逻辑
			if("Y".equals(prop.getProperty("PLUGIN_STATUS"))){
				
				//工作实例提醒BL取得
				WorkRemindBL ctlBL = (WorkRemindBL) WebApplicationSupport.getBean("workremindBL");
				//调用BL查阅需要提醒的工作实例
				ctlBL.workInstanceRemind();
			}else{
				//停用状态下删除历史任务
				JobManager.removeJob(JOB_NAME);
			}
		} catch (Exception e) {
			throw new JobExecutionException(e.getMessage());
		}
		
		Log.info("<<<<<<<<<<工作实例提醒Job类加载结束>>>>>>>>>>");
	}
}
