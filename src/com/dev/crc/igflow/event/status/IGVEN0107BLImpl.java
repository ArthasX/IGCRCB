package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.ven.bl.task.MonitoringWorkBL;
import com.deliverik.infogovernor.ven.bl.task.RiskMonitoringBL;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCondImpl;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;
import com.deliverik.infogovernor.ven.model.entity.RiskMonitoringTB;

/**
 * 
 * ���ܣ�ָ�ɼ�鹤�������ü�鹤����������Ϊ�����
 * @author ʷ����   2014-9-9
 */
public class IGVEN0107BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGVEN0107BLImpl.class);

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	private IG599BL ig599BL;
	
	/** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;
	
	/**  ��⹤�����ҵ���߼��ӿ�BL*/
	protected MonitoringWorkBL monitoringWorkBL;
	
	/**  ���ռ�������ҵ���߼��ӿ� */
	protected RiskMonitoringBL riskMonitoringBL;
    
	/** ִ�й��� */
	private String STATUSNAME_ZXGZ = "ִ�й���";


	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	/**
	 * ��⹤�����ҵ���߼��ӿ�BL�趨
	 * @param monitoringWorkBL the ��⹤�����ҵ���߼��ӿ�BL
	 */
	public void setMonitoringWorkBL(MonitoringWorkBL monitoringWorkBL) {
		this.monitoringWorkBL = monitoringWorkBL;
	}

	/**
	 * @param ig599bl the ig599BL to set
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	/**
	 * ���ռ�������ҵ���߼��ӿ��趨
	 * @param riskMonitoringBL the ���ռ�������ҵ���߼��ӿ�
	 */
	public void setRiskMonitoringBL(RiskMonitoringBL riskMonitoringBL) {
		this.riskMonitoringBL = riskMonitoringBL;
	}
	/** ���� */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** ǰ���� */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ���ʼ========");

		    //��־������Ϣ�趨
	        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
	        
	        //��װ����״̬����
	        participant.setStatusname(STATUSNAME_ZXGZ);
	        
	        setNextPoint(bean);
	        
	        	        
			log.debug("========ָ�ɹ������̲�������ǰ�������ò����ߴ������========");
	}
	
	/**
	 * ������һ���ڵ�
	 * @param bean
	 */
	@SuppressWarnings("unused")
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub

		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��Ա");
		String result = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�����");
		String resultCommont = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "���˵��");
		String ret = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����");
		String resultABC = "";
		if("����".equals(result)){
			resultABC = "A";
		}else if("��������".equals(result)){
			resultABC = "B";
		}else if("�����ش�����".equals(result)){
			resultABC = "C";
		}
		
        if(StringUtils.isNotEmpty(rcrid)){
        	
        	MonitoringWorkTB rcrBean = (MonitoringWorkTB) monitoringWorkBL.searchMonitoringWorkByPK(Integer.parseInt(rcrid));
        	
        	
        	RiskMonitoringTB riskMonitoringtb = (RiskMonitoringTB) riskMonitoringBL.searchRiskMonitoringByPK(rcrBean.getRmid());
        	
        	MonitoringWorkSearchCondImpl cond = new MonitoringWorkSearchCondImpl();
        	cond.setRmid(riskMonitoringtb.getRmid());
        	Integer sum = monitoringWorkBL.getSearchCount(cond);
        	cond.setResult_isNotNull("1");
        	//��ѯ���Ѿ�����Ĺ�������
			int count = monitoringWorkBL.getSearchCount(cond);
			//������Ѵ�����ɵ�����
			Integer rate = (int) ((((double)(count+1) /(double)sum))*100);
			
			//�������Ϊ100,������������
			if(rate == 100){
				Date time  = new Date();
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd hh:mm");
				//�������ʱ��
				riskMonitoringtb.setRmenddate(format1.format(time));
			}
			//�������
			riskMonitoringtb.setRmrate(rate.toString());
			//��������
			this.riskMonitoringBL.updateRiskMonitoring(riskMonitoringtb);
			
        	IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
        	ig599Cond.setPrid(bean.getLogInfo().getPrid());
        	ig599Cond.setPivarname("����");
        	
        	List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(ig599Cond);
        	
        	if(rcrBean!=null){
        		MonitoringWorkTB rcrTB = (MonitoringWorkTB)SerializationUtils.clone(rcrBean);
        		//���ý��
        		rcrTB.setResult(resultABC);
        		//���ý��˵��
        		rcrTB.setResultdesc(resultCommont);
        		if(ig599InfoList!=null && ig599InfoList.size()>0){
        			rcrTB.setMwattachkey(ig599InfoList.get(0).getPiattkey());        			
        		}
        		monitoringWorkBL.updateMonitoringWork(rcrTB);
        	}			
        }
	}
}