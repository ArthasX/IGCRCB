/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������̴���ڵ�ǰ����
 * </p>
 * <strong> ����������أ���������˴���ʱ�䣬����ǵȴ����򿪷��ڵ�����ԾǨ����յ�ǰ�����˵Ĵ���ʱ�� </strong>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0301BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	protected static final Log log = LogFactory.getLog(IGCRC0301BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;

	/** ������API */
	protected FlowSetBL flowSetBL;

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ������API�趨
	 * 
	 * @param flowSetBL
	 *            ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("==============��յ�ǰ�����û��Ĵ���ʱ�俪ʼ===============");
		if (bean.getBfstatus().equals("0108301007")) {
			//��ѯ�����̷�����
			List<Integer> list = flowSearchBL.searchProcessRelationForCld(bean.getLogInfo().getPrid());
			if(list != null && list.size() > 0){
				ProcessRecordInfo info = null;
				long l = 0;
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				for(Integer prid:list){
					List<ProcessRecordInfo> prs = flowSearchBL.searchProcessInfo(prid, null);
					String time = prs.get(0).getPrclosetime();
					try {
						Date d = sdf.parse(time);
						if(d.getTime() > l){
							l = d.getTime();
							info = prs.get(0);
						}
					} catch (ParseException e) {
						log.error("",e);
					}
				}
				flowSetBL.setStatusParticipantRehandle(bean.getLogInfo().getPrid(),
						"���⴦��", info.getPrroleid(), info.getPruserid());
			}
		} else {
			flowSetBL.setStatusParticipantAllRehandle(bean.getLogInfo()
					.getPrid(), bean.getAfstatus());
		}
		log.debug("==============��յ�ǰ�����û��Ĵ���ʱ�����===============");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {

	}

}
