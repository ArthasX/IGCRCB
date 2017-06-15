/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.scheduling.jobs;
import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.deliverik.framework.utility.ResourceUtility;

/**
 * ����: ����״̬���Ѽ��ϱ�������ʼ������
 * �����������������״̬���Ѽ��ϱ��������Quartz��
 * ������¼��
 * �޸ļ�¼��
 */
public class IGProcessNoticeStrategyJOBInit implements PlugIn {
	
	static Log log = LogFactory.getLog(IGProcessNoticeStrategyJOBInit.class);
	
	public void init(ActionServlet actionservlet, ModuleConfig moduleconfig)
			throws ServletException {
		String IGProcessNoticeStrategyJOB_SWITCH = ResourceUtility.getString("IGProcessNoticeStrategyJOB_SWITCH");//�Ƿ�������Ѳ����
		String IGPROCESSNOTIEC_JOB = "IGPROCESSNOTIEC_JOB"; //JOB ����
		String IGProcessNoticeStrategyJOB_TIME = ResourceUtility.getString("IGProcessNoticeStrategyJOB_TIME"); //��Ѳʱ��
		try{
			//��������ü�ع��ܣ���ɾ��ԭ�е�JOB
			if("0".equals(IGProcessNoticeStrategyJOB_SWITCH)){
				if(JobManager.isJobAdded(IGPROCESSNOTIEC_JOB)){
					JobManager.removeJob(IGPROCESSNOTIEC_JOB);
				}
				return;
			}else{//������ü�ع���,���������JOB
				if(JobManager.isJobAdded(IGPROCESSNOTIEC_JOB)){
					JobManager.removeJob(IGPROCESSNOTIEC_JOB);
					JobManager.addJob(IGPROCESSNOTIEC_JOB,new IGProcessNoticeStrategyJOB(), IGProcessNoticeStrategyJOB_TIME);
				}else{
					JobManager.addJob(IGPROCESSNOTIEC_JOB,new IGProcessNoticeStrategyJOB(), IGProcessNoticeStrategyJOB_TIME);
					log.debug("========����״̬���Ѽ��ϱ��������========");
				}
			}
		}catch(Exception e){
			log.error("����״̬���Ѽ��ϱ����ʼ�������쳣��", e);
		}
		
	}
	
	public void destroy() {
		
	}
}
