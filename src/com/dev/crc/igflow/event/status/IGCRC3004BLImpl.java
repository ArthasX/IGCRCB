package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.dev.hac.util.ComUtil;
import com.google.gson.Gson;

public class IGCRC3004BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	static Log log = LogFactory.getLog(IGCRC3004BLImpl.class);
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
	
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	/**
	 * ���ִ�нڵ�ǰ����
	 */
	public void preTreatmentExecute(final WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========���ݻ��ӿڷ������ݴ���ʼ========");
		Integer prid = bean.getLogInfo().getPrid();
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		String desc = IGDRMEmergencyTools.getDesc(prid);
		IGDRMEmergencyTools.changeFlowSystemState(prid, "5",desc);
		
		//�������
		String bgtype = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "������");
		
		//�ƻ���ʼִ��ʱ��
		String starttime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�ƻ�ִ�п�ʼʱ��");
		//�ƻ�����ִ��ʱ��
		String endtime = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�ƻ�ִ�н���ʱ��");
		
		final List<ProcessRecordInfo> processInfo = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(),null);
		//��ѯ��ǰ������в�����
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		//������
		String operator = list.get(0).getUserid();
		//��������
		String reason = processInfo.get(0).getPrtitle();
		//���̵���
		String workNoteNumber = processInfo.get(0).getPrserialnum();
		//ƴ����Ҫ���ݵ�����
		Map<String,Object> dataMap = new HashMap<String,Object>();
		//port����
		List<Map<String,Object>> portMap = new ArrayList<Map<String,Object>>();
		
		//��������
		Map<String,String>jcMap = new HashMap<String,String>();
		jcMap.put("endTime",endtime.replace("/", "-"));
		jcMap.put("operator",operator);
		jcMap.put("reason",reason);
		jcMap.put("startTime",starttime.replace("/", "-"));
		jcMap.put("workNoteNumber",workNoteNumber);
		//����HTTP�ӿ�����
		String url = ResourceUtility.getString("EMERGENT_URL");
		if(bgtype.equals("������")){
			String[] gxpt = (flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����ƽ̨").replace("cv_cev_", "")).split("#");
			dataMap.put("workNote",jcMap );
			dataMap.put("groupname",gxpt);
			url = ResourceUtility.getString("NORMAL_URL");
		}else{
			//��hac��������
			List<Map<String,Object>> maplist = (List<Map<String, Object>>) flowSearchBL.searchPublicTableValue("ƽ̨��ϸ��Ϣ", prid,null);
			/*[
				{����ƽ̨����=EAST����ϵͳ, ƽ̨��Ϣ=SSH:cyccall/watch;, HAC����=7772&12901|12903;},
				{����ƽ̨����=����ҹ��ֺŹ���ϵͳ, ƽ̨��Ϣ=SSH:cyccall/watch;, HAC����=7772&12901|12903;}
			]*/
			//ƽ̨��������
			String[] ptname = new String[maplist.size()];
			//ѭ����������
			if(maplist.size()>0){
				for(int i=0;i<maplist.size();i++){
					String name = maplist.get(i).get("����ƽ̨����").toString();
					String[] hacData = maplist.get(i).get("HAC����").toString().split(";");
					for(String onedata:hacData){
						String[] fendata = onedata.split("&");
						Map<String,Object> portOne = new HashMap<String,Object>();
						portOne.put("portId", fendata[0]);
						portOne.put("accountId", (fendata[1].split("\\|")));
						//port��������
						portMap.add(portOne);
					}
					//ƽ̨���Ʋ�������
					ptname[i] = name;
					
				}
			}
			dataMap.put("workNote",jcMap );
			dataMap.put("port",portMap );
			dataMap.put("groupname",ptname);
			
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(dataMap);
		log.info("========���ݻ��ӿڷ�������:========"+json);
				
        //��ȡ�����ص�����
        final Map<String,Object> jsonmap =  ComUtil.httpRequest(url, "POST", json);
        if(jsonmap==null){
        	Thread deployThread = new Thread(){
     			@Override
     			public void run() {
     				//���������־��
     				WorkFlowLog wfl = new WorkFlowLog();
     				wfl.setPrid(bean.getLogInfo().getPrid());
     				wfl.setExecutorid(processInfo.get(0).getPruserid());	
     				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
     				wfl.setAuthuserid("");
     				wfl.setComment("���ݻ�ͨѶ�ӿ��޷���ͨ:conncet failed");
     				try {
 						flowSetBL.setProcessLog(wfl, "�뱤�ݻ�ͨѶʧ��", Constants.PROCESS_LOG_TYPE_PROCESSING);
 					} catch (BLException e) {
 						e.printStackTrace();
 					}
     			}
     		};
     		deployThread.start();
     		log.error("========���ݻ�ͨѶ�ӿ��޷���ͨ:conncet failed========");
         	throw new BLException("IGHAC0101.E001", "�뱤�ݻ�ͨѶʧ��");
        }else{
        	 if(jsonmap.get("success").toString()=="false"){
         		Thread deployThread = new Thread(){
         			@Override
         			public void run() {
         				//���������־��
         				WorkFlowLog wfl = new WorkFlowLog();
         				wfl.setPrid(bean.getLogInfo().getPrid());
         				wfl.setExecutorid(processInfo.get(0).getPruserid());	
         				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
         				wfl.setAuthuserid("");
         				wfl.setComment("�����룺"+jsonmap.get("errorCode").toString()+"��������Ϣ��"+jsonmap.get("errorMessage").toString()+"��");
         				try {
     						flowSetBL.setProcessLog(wfl, "�뱤�ݻ�ͨѶʧ��", Constants.PROCESS_LOG_TYPE_PROCESSING);
     						log.error("========���ݻ�ͨѶ�ӿ�ʧ��========�����룺"+jsonmap.get("errorCode").toString()+"��������Ϣ��"+jsonmap.get("errorMessage").toString()+"��");
     					} catch (BLException e) {
     						e.printStackTrace();
     					}
         			}
         		};
         		deployThread.start();
             	throw new BLException("IGHAC0101.E001", jsonmap.get("errorMessage").toString());
             }
        }
        log.debug("========���ݻ��ӿڷ������ݴ������========");
    }
       

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// TODO Auto-generated method stub
		Integer prid = bean.getLogInfo().getPrid();
		//�����ַͨ��ҵ��ϵͳID����ҵ��ϵͳӦ������״̬
		IGDRMEmergencyTools.changeFlowSystemState(prid, "4",null);
	}

}
