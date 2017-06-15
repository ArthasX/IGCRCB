package com.deliverik.infogovernor.drm.igflow.button;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * ��ϳ����޶� ������ڵ㣨��һҳ���������һ������ť�¼�
 * �����޶��ĳ�����������
 * 
 */
public class IGDRMBTN0202BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0202BLImpl.class);

	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    /** ���̶��幦��BL */
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    protected IG500BL ig500BL;
    /**���̲����߶���ҵ���߼�����BL*/
   	protected IG560BL ig560BL;
   	
   	protected IG333BL ig333BL;
	/**
	 * @param ig560bl the ig560BL to set
	 */
	public void setIg560BL(IG560BL ig560bl) {
		ig560BL = ig560bl;
	}
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * @param ig333bl the ig333BL to set
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
	/**
	 * �����޶�������ڵ㣨��һҳ���������һ������ť�¼�
	 * @param WorkFlowStatusEventBeanInfo bean
	 * @throws BLException
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========Ԥ����������𱣴水ť����ʼ========");
		//String oldXml = null;
		IG380TB new380TB = null;
		//��һ������������ʵ����Ϣ
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//��������
		//String prtitle = ig500Info.getPrtitle();
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		// Ԥ������
		String pddesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		//ԭ����Ӧ�����ò���
		String opdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����Ӧ�����ò���");
		//ԭ��������prid
		String oprid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "���峡������ID");
		//�޶�
		if(StringUtils.isNotEmpty(opdid)){
			//����ԭ���̶���ID
			workFlowDefinitionBL.upgradeProcessDefVersion(opdid);
			//���̰汾��
			String version = StringUtils.leftPad(String.valueOf(Integer.parseInt(opdid.substring(5, 7)) + 1), 2, "0");
			//�°汾����pdid 0240101
			String pdid = opdid.substring(0, 5) + version;
			// ��ȡ���̶���
			IG380Info cptInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			// �������̶��������Ϣ-ԭ���̿���
			IG380TB cptTB = (IG380TB) SerializationUtils.clone(cptInfo);
			cptTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
			// �������̶���
			workFlowDefinitionBL.updateProcessDefinition(cptTB);
			// ��ȡ�°汾������Ϣ
			IG380Info ptInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			// �������̶��������Ϣ
			new380TB = (IG380TB) SerializationUtils.clone(ptInfo);
			new380TB.setPdname(prtitle); // Ԥ������
			new380TB.setPddesc(pddesc); // Ԥ������
			if ("01".equals(bean.getPbdid())) {
				//oldXml = ptInfo.getPdxml();
				//new380TB.setPdxml(null);
			}
			// �������̶��������Ϣ-�޶����̹ر�
			new380TB.setPdcrtdate(IGStringUtils.getCurrentDate()); // ����ʱ��
			new380TB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
			
			// �������̶���
			workFlowDefinitionBL.updateProcessDefinition(new380TB);
			// �������������
			//clearRelatedData(pdid);
			// �����̶���ID�趨��������
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			ppivInfo.setFormname("����Ӧ�����ò���");
			ppivInfo.setFormvalue(pdid);
			flowSetBL.setPublicProcessInfoValue(ppivInfo);
			//������������title����
			IG500TB prTB = (IG500TB) SerializationUtils.clone(ig500Info);
			prTB.setPrtitle(prtitle);
			ig500BL.updateIG500Info(prTB);
			//ԭ����-Ӧ����Դ�ʲ�List
			List<ProcessInfoEntityInfo> piList = flowSearchBL.searchProcessEntityItem(Integer.valueOf(oprid), "Ӧ����Դ");
			//ԭӦ����Դ�ʲ�ID
			//String oldEiidStr = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "ԭӦ����Դ�ʲ�ID");
			//Eiversion(Eiid
			//String[] oldEiidArr = oldEiidStr.split("_");
			//����ԭ �ʲ���-Ӧ����Դ��ig731����
			if(null!=piList){
				for(ProcessInfoEntityInfo piInfo : piList){
					//Ӧ����Դ��Ϣ
					EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(piInfo.getEiid());
					//�����������̺�Ӧ����Դ�ʲ�������ϵ
					flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "Ӧ����Դ", piInfo.getEiid(), eiInfo.getEiversion());
				}
			}
			//����״̬����Ĭ��ֵ������������
			//��ѯ����״̬������Ĭ��ֵ-ig560�� - 
			IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
			ig560Cond.setPidid_l(opdid);
			List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
			List<IG560Info> ig560NewList = new ArrayList<IG560Info>();
			for(int i=0;i<ig560List.size();i++){
				IG560TB ig560tb = new IG560TB();
				ig560tb = (IG560TB)SerializationUtils.clone(ig560List.get(i));
				ig560tb.setDvid(null);
				ig560tb.setPidid(pdid+ig560List.get(i).getPidid().substring(7));
				ig560tb.setPsdid(pdid+ig560List.get(i).getPsdid().substring(7));
				ig560NewList.add(ig560tb);
			}
			ig560BL.saveOrUpdateAll(ig560NewList);
			
			//�����ڵ���Ϣ ���� fingerPrint�������һ�ڵ�id���ֶΣ� - ���̺����� 
			IG333SearchCondImpl sCond = new IG333SearchCondImpl();
			sCond.setPdid(pdid);
			List<IG333Info> psLst = ig333BL.searchIG333Info(sCond);
			for(int i=0;i<psLst.size();i++){
				String fingerPrint = psLst.get(i).getFingerPrint();
				if(StringUtils.isEmpty(fingerPrint)){
					continue;
				}
				String[] fingerArr = fingerPrint.split("_");
				String upFinger = "";
				for(int j=0;j<fingerArr.length;j++){
					//02401 + 02 + 001  version->02
					String fin = fingerArr[j].substring(0, 5) + version + fingerArr[j].substring(7);
					upFinger += (""==upFinger)?fin:("_"+fin);
				}
				IG333TB ig333TB = (IG333TB)SerializationUtils.clone(psLst.get(i));
				ig333TB.setFingerPrint(upFinger);
				ig333BL.updateIG333Info(ig333TB);
			}
				
		}else{
			log.error("ԭ����Ӧ�����ò������̶���ID�����ڣ�");
		}
	}
	
	

}
