/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.dev.crc.igflow.event.status.bl.IGFXKDataSendBL;
import com.dev.crc.igflow.event.status.job.IGFXKDataSendJOB;

/***
 * ���չ���رյ�ǰ�ô���
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGFXK0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGFXK0101BLImpl.class);
	
	/** ��ѯ��API */
	private FlowSearchBL flowSearchBL;
	
	/** ���ѷ���BL */
	private IGFXKDataSendBL igFXKDataSendBL;
	
	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ���ѷ���BL�趨
	 * @param igFXKDataSendBL ���ѷ���BL
	 */
	public void setIgFXKDataSendBL(IGFXKDataSendBL igFXKDataSendBL) {
		this.igFXKDataSendBL = igFXKDataSendBL;
	}

	
	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo arg0)
			throws BLException {

	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {
		log.debug("=====================���չ���ر�ǰ�ô���ʼ=====================");
		
		//��ֵȡ��
		String planBeginTime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�ƻ���ʼʱ��");
		String planEndTime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�ƻ�����ʱ��");
		String planType = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "���ռƻ�����");
		
		/**��ѯҳ�����Ϣ*/
		List<ProcessRecordInfo> searchProcessInfo = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
		
		if(null != searchProcessInfo && searchProcessInfo.size() != 0){
			
			Date date=new Date();
			/**����ʱ���ʽ*/
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm");
			
			try {
				/**��ǰʱ��String����*/
				String currTime=sdf.format(date);
				/**��ʱ���Ժ���Ϊ��λ*/
				long nowTime = sdf.parse(currTime).getTime();
				/** �ƻ�����ʱ���Ժ���Ϊ��λ*/
				long endTime = sdf.parse(planEndTime).getTime();
			
				/**��� �ƻ���ʼʱ�䡢�ƻ�����ʱ�䡢�ƻ�����*/
				Map<String, Object> map = new HashMap<String, Object>();
					map.put("bTime", planBeginTime);
					map.put("eTime", planEndTime);
					map.put("title",searchProcessInfo.get(0).getPrtitle());
					map.put("prid",bean.getLogInfo().getPrid());
						
				/**ִ��һֱ���չ�������*/
				igFXKDataSendBL.dataSend(planBeginTime, planEndTime, searchProcessInfo.get(0).getPrtitle());
				
				if ((endTime > nowTime) &&"��ȼƻ�".equals(planType)) {
					/**�ƻ�����ʱ���趨*/
					StringBuffer bf=new StringBuffer();
						bf.append("0 ");
						bf.append(currTime.substring(14, 16));
						bf.append(" ");
						bf.append(currTime.substring(11, 13));
						bf.append(" ");
						bf.append(currTime.substring(8, 10));
						bf.append(" ");
						bf.append(currTime.substring(5, 7));
						bf.append(" ?");
						//����������Ӷ�ʱ����
					JobManager.addJob(IGFXKDataSendJOB.JOB_NAME+ bean.getLogInfo().getPrid(),new IGFXKDataSendJOB(), bf.toString(),map);
				} 
			} catch (Exception e) {
				log.error("",e);
			}
		}
		log.debug("=====================���չ���ر�ǰ�������=====================");
	}
}
