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
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * ��ϳ������������ڵ㣨��һҳ���������һ������ť�¼�
 * ��������ʱ��������һ����ϳ������̶���
 * ��������ʱ������һ����ϳ������̶��壨���޸ģ�
 */
public class IGDRMBTN0201BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0201BLImpl.class);

	/** ���¹���API�� */
	private FlowSetBL flowSetBL;
    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;
    /** ���̶��幦��BL */
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    /** ����ʵ������BL */
    protected IG500BL ig500BL;
    /**���̲����߶���ҵ���߼�����BL*/
   	protected IG560BL ig560BL;
   	/** �����鶨�幦��BL */
   	protected IG480BL ig480BL;
   	
	/**
	 * @param ig480bl the �����鶨�幦��BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}
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
	 * �������������ڵ㣨��һҳ���������һ������ť�¼�
	 * @param WorkFlowStatusEventBeanInfo bean
	 * @throws BLException
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========Ԥ����������𱣴水ť����ʼ========");
		//��ϳ�����������ʵ����Ϣ
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//��������
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		//Ԥ������
		String pddesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "��������");
		//����Ӧ�����ò���
		String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "����Ӧ�����ò���");
		//ԭ��������prid
		String oprid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "���峡������ID");
		//������������ >-����Ӧ�����ò���pdidΪ��
		if(StringUtils.isEmpty(stepPdid)){
			//���stepPdidΪ�� ��Ϊ�������̵ĵ�һ��
			
			// ��ѯ����ģ����Ϣ
			IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(19);
			// ��ȡ���̶���ID
			String pgdid = workFlowDefinitionBL.getProcessDefinitionPK(pt.getFirstsite(),pt.getPdsequence());
			//�����鶨��id
			IG480TB ig480TB = new IG480TB();
			ig480TB.setPgdid(pgdid);
			ig480TB.setPgdname(prtitle);//��ϳ�������
			ig480TB.setPgddesc(pddesc);//��ϳ�������
			ig480TB.setPgdcrtime(IGStringUtils.getCurrentDate()); // ����ʱ��
			ig480TB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE); // ���̶���״̬��Ĭ��Ϊͣ��
			ig480TB.setPtid(19);
			//xml��֯��ʽ
			//��ʼ��֯����
			StringBuffer jsonTemp = new StringBuffer("<GroupFlow ");
			jsonTemp.append(" contentHeight= \""+400+"\">");
			jsonTemp.append(" <BaseProperties pgdid= \""+pgdid+"\"");
			jsonTemp.append(" pgdname=  \""+prtitle+"\"/>");
			jsonTemp.append("<WebFlows>");
			//��֯��β����
			//��֯��β����
			jsonTemp.append("</" + "WebFlows>");
			jsonTemp.append("<FlowActions>");
			jsonTemp.append("</FlowActions>");
			jsonTemp.append("</GroupFlow>");
			ig480TB.setPgdxml(jsonTemp.toString());
			ig480BL.registIG480(ig480TB);
			// �����̶���ID�趨��������
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			ppivInfo.setFormname("����Ӧ�����ò���");
			ppivInfo.setFormvalue(pgdid);
			flowSetBL.setPublicProcessInfoValue(ppivInfo);
		}else{//---------------------�������ƴ��޸�----------------
			//��������>����
			String newPdid = workFlowDefinitionBL.copyProcessDefVersion(stepPdid);
			// �����̶���ID�趨��������
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			ppivInfo.setFormname("����Ӧ�����ò���");
			ppivInfo.setFormvalue(newPdid);
			flowSetBL.setPublicProcessInfoValue(ppivInfo);
			// �������̶���״̬Ϊ����-��������
	    	IG380Info pdInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(newPdid);
	    	IG380TB pdTB = (IG380TB) SerializationUtils.clone(pdInfo);
	    	pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
	    	workFlowDefinitionBL.updateProcessDefinition(pdTB);
	    	//ԭӦ����Դ�ʲ�ID
			String oldEiid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "ԭӦ����Դ�ʲ�ID");
			//����ԭ �ʲ���-Ӧ����Դ��ig731����
			if(!"".equals(oldEiid)){
				flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "Ӧ����Դ", Integer.valueOf(oldEiid), null);
			}
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
			ig560Cond.setPidid_l(stepPdid);
			List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
			List<IG560Info> ig560NewList = new ArrayList<IG560Info>();
			for(int i=0;i<ig560List.size();i++){
				IG560TB ig560tb = new IG560TB();
				ig560tb = (IG560TB)SerializationUtils.clone(ig560List.get(i));
				ig560tb.setDvid(null);
				ig560tb.setPidid(newPdid+ig560List.get(i).getPidid().substring(7));
				ig560tb.setPsdid(newPdid+ig560List.get(i).getPsdid().substring(7));
				ig560NewList.add(ig560tb);
			}
			ig560BL.saveOrUpdateAll(ig560NewList);
		}
		//������������title����-ig500
		IG500TB prTB = (IG500TB)SerializationUtils.clone(ig500Info);
		prTB.setPrtitle(prtitle);
		ig500BL.updateIG500Info(prTB);
		
		
	}
	
	
	/**
	 * ͨ����·����ȡ����·��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAbsolutePathByClass(){
		String webPath = this.getClass().getResource("/").getPath().replaceAll("^\\/", "");
		webPath = webPath.replaceAll("[\\\\\\/]WEB-INF[\\\\\\/]classes[\\\\\\/]?", "/");
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		webPath = webPath.replaceAll("%20", " ");
		if (webPath.matches("^[a-zA-Z]:.*?$")) {

		} else {
			webPath = "/" + webPath;
		}
		webPath += "/";
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		return webPath;
	}
}
