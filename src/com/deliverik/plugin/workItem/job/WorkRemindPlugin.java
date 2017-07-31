/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.plugin.workItem.job;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * 
 * @Description 初始化添加/移除工作实例提醒Job类
 *
 * @date 2017年6月22日
 *
 * @author wangliang@deliverik.com
 *
 * @version 1.0
 *
 */
public class WorkRemindPlugin implements PlugIn{
	
	private static final Log log = LogFactory.getLog(WorkRemindPlugin.class);
	
	/**
	 * 销毁
	 */
	public void destroy() {
		
	}

	/**
	 * 初始化
	 */
	public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
		try{
			log.debug("============开始============");
			
			//取得CodeDetailBL
			CodeDetailBL ctlBL = (CodeDetailBL) WebApplicationSupport.getBean("codeDetailBL");
			
			//校验工作项短信提醒开关处于开启状态下方可进行提醒工作实例
			CodeDetailTBPK ofPk = new CodeDetailTBPK();
			ofPk.setCcid("177");
			ofPk.setCid("6");
			//取得短信开关基础数据
			CodeDetail ofCodeDetal = ctlBL.searchCodeDetailByPK(ofPk);
			
			//获取codedetial中短信提醒时间，拼接表达式
			CodeDetailTBPK timePk = new CodeDetailTBPK();
			timePk.setCcid("178");
			timePk.setCid("1");
			//取得短信提醒时间（小时）基础数据
			CodeDetail timeCodeDetal = ctlBL.searchCodeDetailByPK(timePk);
			//定义表达式
			String expression = "0 0 "+Integer.parseInt(timeCodeDetal.getCvalue())+" * * ?";
			
			if("1".equals(ofCodeDetal.getCvalue())){
				//校验工作项短信提醒开关处于开启状态下处理Job提醒
				if(JobManager.isJobAdded(WorkRemindJob.JOB_NAME)){
					
					JobManager.removeJob(WorkRemindJob.JOB_NAME);
					JobManager.addJob(WorkRemindJob.JOB_NAME, new WorkRemindJob(), expression);
				}else{
					
					JobManager.addJob(WorkRemindJob.JOB_NAME, new WorkRemindJob(), expression);
				}
			}
			
			
			log.debug("============结束============");
		}catch(Exception e){
			log.error("",e);
			throw new ServletException(e);
		}
	}

}
