/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/***
 * �¼����� - ������ڵ����
 * ���ܣ� �ж��Ƿ�����澯������У����¼�����Ÿ�����澯��
 * @time 2014/07/22
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGCRC0203BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־����ȡ�� */
	protected static final Log log = LogFactory.getLog(IGCRC0203BLImpl.class);
	
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
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/**
	 * ����
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========�¼����̴�����ڵ����ʼ========");
		//��ѯ���ʽ������
		ArrayList<LinkedHashMap> alarmList = (ArrayList<LinkedHashMap>)flowSearchBL.searchPublicTableValue("�澯��Ϣ", bean.getLogInfo().getPrid(), "");
		String lasttime = ""; 
		//��ȡ�澯ID
		String alarmShowId = "";
		for(int i=0;i<alarmList.size();i++){
			if(StringUtils.isEmpty(lasttime)){
				lasttime = (String) alarmList.get(i).get("����ʱ��");
				alarmShowId = (String) alarmList.get(i).get("�澯ID");
			}else{
				String s1 = lasttime;
				String s2 = (String) alarmList.get(i).get("����ʱ��");
				int res = s1.compareTo(s2);
				if(res < 0){
					lasttime = (String) alarmList.get(i).get("����ʱ��");
					alarmShowId = (String) alarmList.get(i).get("�澯ID");
				}
			}
		}
		for(int i=0;i<alarmList.size();i++){
			//��ȡ�澯ID
			String alarmId = (String) alarmList.get(i).get("�澯ID");
			if(!"".equals(alarmId)){
				//�澯��Ϣ��ѯ
				IgalarmSearchCondImpl cond = new IgalarmSearchCondImpl();
				cond.setSerial(alarmId);
				cond.setLasttime((String) alarmList.get(i).get("����ʱ��"));
				List<IgalarmInfo> igalarms = igalarmBL.searchIgalarm(cond);
				for (IgalarmInfo igalarmInfo : igalarms) {
					IgalarmTB tb = (IgalarmTB)SerializationUtils.clone(igalarmInfo);
					//��ѯ���̻�����Ϣ
					List<ProcessRecordInfo> infos = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), "");
					//��״̬����Ϊ�ر�
					tb.setPedeventid(infos.get(0).getPrserialnum());
					/** 
					 * 2014-9-9 wanglei
					 * ����ũ������Ϣ�Ƽ����չ���ƽ̨��������б�_20140901.xls
					 * 47-1
					 * 
					 * 	�����澯�����¼��󣬺ϲ�Ϊһ����
					 * ������20���澯������1���¼���ֻ��ʾһ���ܵĸ澯����������ܸ澯��
					 * 	���Բ鿴�����кϲ��ĸ澯��Ϣ�����ڹ��������¼����̵ĸ澯��������Ҳ
					 * 	��Ҫ�ϲ�������
					 */
					// IsShow�ֶ�ֵΪ0ʱ��ʾ��Ϊ1ʱ����ʾ
					if(!tb.getLasttime().equals(lasttime)){
						tb.setIsShow("1");
					}else{
						if(!tb.getSerial().equals(alarmShowId)){
							tb.setIsShow("1");
						}
					}
					/** 
					 * 2014-9-16 wanglei
					 * ����ũ��������Ϣ�Ƽ����չ���ƽ̨���������б�_0916
					 * 132
					 * 133
					 * 	�����澯��Ϣ�ϲ���һ���¼�����Ӧ��ֻ��ʾһ��������������ʾ�����������������澯�Ĵ���ʱ����һ���ģ������Ǹ澯��Ų�һ����
					 * �����¼����󣬡����Ƿ������¼�������Ӧ��Ϊ�ǣ����ڻ���Ϊ��
					 */
					tb.setIsCreateOrder("1");
					igalarmBL.updateIgalarm(tb);
				}
			}
		}
		log.debug("========�¼����̴�����ڵ�������========");
	}

}
