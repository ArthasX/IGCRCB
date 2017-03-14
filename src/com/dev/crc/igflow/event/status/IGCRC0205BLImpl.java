/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/***
 * �¼����� - �رսڵ����
 * ���ܣ� �ж��Ƿ�����澯������У�������ظ澯״̬�޸�Ϊ�ر�
 * @time 2014/09/04
 * @author wanglei
 * @version 1.0
 * @mail wanglei@deliverik.com
 */
public class IGCRC0205BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־����ȡ�� */
	protected static final Log log = LogFactory.getLog(IGCRC0205BLImpl.class);
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ���ɸ澯��ҵ���߼�BL */
	private IgalarmBL igalarmBL;

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * ���ɸ澯��ҵ���߼�BL����
	 * @param igalarmBL ���ɸ澯��ҵ���߼�BL
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}

	/**
	 * ǰ����
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========�¼����̹رսڵ����ʼ========");
		//��ѯ���ʽ������
		ArrayList<LinkedHashMap> alarmList = (ArrayList<LinkedHashMap>)flowSearchBL.searchPublicTableValue("�澯��Ϣ", bean.getLogInfo().getPrid(), "");
		String var = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����ԭ��");
		if(StringUtils.isEmpty(var)){
			var = "";
		}
		for(int i=0;i<alarmList.size();i++){
			//��ȡ�澯ID
			String alarmId = (String) alarmList.get(i).get("�澯ID");
			if(StringUtils.isNotEmpty(alarmId)){
				//�澯��Ϣ��ѯ
				IgalarmSearchCondImpl cond = new IgalarmSearchCondImpl();
				cond.setSerial(alarmId);
				cond.setLasttime((String) alarmList.get(i).get("����ʱ��"));
				List<IgalarmInfo> igalarms = igalarmBL.searchIgalarm(cond);
				for (IgalarmInfo igalarmInfo : igalarms) {
					IgalarmTB tb = (IgalarmTB)SerializationUtils.clone(igalarmInfo);
					
					//�����̹ر�֮ǰ���޸��澯���ˣ���ô�ø澯��¼Ϊ�Զ��޸�  by wangxing 2015/11/17
					if("0".equals(tb.getStatus())){
						tb.setStatus("2");
						SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						tb.setRecoveryTime(df.format(new Date()));
					}
					
					//�������+����ԭ��ĳ��ȳ���1000����ȡǰ996λ+'...'
					String description = "";
					if(StringUtils.isEmpty(tb.getDescription())){
						description = var;
					}else{
						description = tb.getDescription() + var;
					}
					if(description.length()>1000){
						description = description.substring(0,995)+"...";
					}
					tb.setDescription(description);
					igalarmBL.updateIgalarm(tb);
				}
			}
		}
		log.debug("========�¼����̹رսڵ�������========");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
