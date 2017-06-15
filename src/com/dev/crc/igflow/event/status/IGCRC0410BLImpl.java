package com.dev.crc.igflow.event.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream.Check;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.risk.bl.task.CheckWorkResultBL;
import com.deliverik.infogovernor.risk.bl.task.CheckworkInfoResultBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkResultTB;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * 
 * ���ܣ�ָ�ɼ�鹤�������ü�鹤����������Ϊ�����
 * @author ʷ����   2014-9-9
 */
public class IGCRC0410BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** ��־����ȡ�� */
	static Log log = LogFactory.getLog(IGCRC0410BLImpl.class);

	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

	/** ��ѯ�๦��API�� */
	private FlowSearchBL flowSearchBL;
	
	private CheckworkInfoResultBL checkworkInfoResultBL;
	
	private IG599BL ig599BL;
	
	private CheckWorkResultBL checkWorkResultBL;
	
	/** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** ���ռ����ϢBL */
	protected RiskCheckResultBL riskCheckResultBL;
    
	/** ִ�й��� */
	private String STATUSNAME_ZXGZ = "ִ�й���";

	
	/**
	 * @param checkworkInfoResultBL the checkworkInfoResultBL to set
	 */
	public void setCheckworkInfoResultBL(CheckworkInfoResultBL checkworkInfoResultBL) {
		this.checkworkInfoResultBL = checkworkInfoResultBL;
	}

	/**
	 * @param checkWorkResultBL the checkWorkResultBL to set
	 */
	public void setCheckWorkResultBL(CheckWorkResultBL checkWorkResultBL) {
		this.checkWorkResultBL = checkWorkResultBL;
	}

	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * @param ��ѯ�๦��API��
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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
	 * @param riskCheckResultBL the riskCheckResultBL to set
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
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
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub

		//
		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��Ա");
		String result = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�����");
		String resultCommont = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "���˵��");
		String ret = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����");
//		attachmentBL
		String resultABC = "";
		if("����".equals(result)){
			resultABC = "A";
		}else if("��������".equals(result)){
			resultABC = "B";
		}else if("�����ش�����".equals(result)){
			resultABC = "C";
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String dateStr = format.format(date);
		
        if(StringUtils.isNotEmpty(rcrid)){
        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	
        	CheckworkInfoResultSearchCondImpl cond = new CheckworkInfoResultSearchCondImpl();
        	cond.setRcrid(Integer.parseInt(rcrid));
        	//��ѯ�������������ʲ����ڴ�����������   //�϶�ֻ��һ������Ϊ������У�һ����鹤��ֻ�ܶ�Ӧһ���������
        	List<CheckworkInfoResultInfo> info = checkworkInfoResultBL.searchCheckworkInfoResult(cond, 0, 0);
        	
        	if(info!=null && info.size()>0){
        		//����������
        		CheckWorkResultInfo cwrInfo =  checkWorkResultBL.searchCheckWorkResultByPK(info.get(0).getCwrid());
        		
        		CheckworkInfoResultSearchCondImpl cond2 = new CheckworkInfoResultSearchCondImpl();
        		
        		cond2.setCwrid(cwrInfo.getCwrid());
        		//��ѯ����������϶��ж������������Ǹ�����������Ӧ��鹤��������
        		List<CheckworkInfoResultInfo> info2 = checkworkInfoResultBL.searchCheckworkInfoResult(cond2, 0, 0);
        		
        		Integer[] rcrid_in = new Integer[info2.size()];
				for(int i =0;i<info2.size();i++){
					rcrid_in[i] = info2.get(i).getRcrid();
				}
				//�������
				Integer rate = 0;
				
				RiskCheckResultSearchCondImpl rcrsCond = new RiskCheckResultSearchCondImpl();
				rcrsCond.setRcrid_in(rcrid_in);
				//��ѯ���ܵ�����
				int sum = this.riskCheckResultBL.getSearchCountForRate(rcrsCond);
				//���ô���ʱ��Ϊ�յ�����������δ�����
				rcrsCond.setRcrrealtime_isNull("1");
				//��ѯ���Ѿ���Ҫ����Ĺ�������������δ���������
				int count = this.riskCheckResultBL.getSearchCountForRate(rcrsCond);
				//������Ѵ�����ɵ�����
				rate = (int) (((1-(double)(count-1) /(double)sum))*100);
				
				CheckWorkResultInfo cwrinfo = this.checkWorkResultBL.searchCheckWorkResultByPK(info.get(0).getCwrid());
				CheckWorkResultTB tb = (CheckWorkResultTB)cwrinfo;
				//�������Ϊ100,������������
				if(rate == 100){
					Date time  = new Date();
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					tb.setCwrrealtime(format1.format(time));
				}else if(rate >100){
					rate = 100;
					Date time  = new Date();
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					tb.setCwrrealtime(format1.format(time));
				}else if (rate < 100) {// �������С��100,�������δ���
					tb.setCwrrealtime("");
				}
				//���������²��뵽�ü��������
				tb.setCwrrate(rate.toString());
				this.checkWorkResultBL.updateCheckWorkResult(tb);
        	}
        	IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
        	ig599Cond.setPrid(bean.getLogInfo().getPrid());
        	ig599Cond.setPivarname("����");
        	
        	List<IG599Info> ig599InfoList = ig599BL.searchIG599InfosByCond(ig599Cond);
        	
        	
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setRcrtestmode("�����");
        		rcrTB.setRcrresult(resultABC);
        		rcrTB.setRcrcomment(resultCommont);
        		rcrTB.setRcrrealtime(dateStr);
        		if(ig599InfoList!=null && ig599InfoList.size()>0){
        			rcrTB.setRcrattch(ig599InfoList.get(0).getPiattkey());        			
        		}
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}			
        }
        
        //�������
		
	}
}