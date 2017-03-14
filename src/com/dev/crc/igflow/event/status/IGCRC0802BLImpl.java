/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.crc.igflow.event.status;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.EntityItem;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValue;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;

/***
 * ����������̹رսڵ�ǰ����
 * @time 2014/06/26
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGCRC0802BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGCRC0802BLImpl.class);
	
	/** ���¹���API�� */
	private FlowSetBL flowSetBL;

    /** ��ѯ�๦��API�� */
    private FlowSearchBL flowSearchBL;

	/** ��������ϢBL */
    private SOC0118BL soc0118BL;
    
    /** ����ҵ��BL */
    private AttachmentBL attachmentBL;
    
    /** ���̴���BL */
    private WorkFlowOperationBL workFlowOperationBL;
	
    /** ���̱������� */
	private IG599BL ig599BL;
    
	/**
	 * ע����¹���API��
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ע���ѯ����API��
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * ��������ϢBL����
     * @param soc0118bl ��������ϢBL
     */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		this.soc0118BL = soc0118bl;
	}

	/**
     * ����ҵ��BL����
     * @param soc0118bl ��������ϢBL
     */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * ���̱��������趨
	 * 
	 * @param ig599bl
	 *            ig599BL
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}
	
	/**
     * ǰ����
     */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================����������̹رյ�ǰ�ô���ʼ=====================");	
		List<ProcessRecordInfo> list = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
		//�����ʲ���ض���
		EntityItem entityItem = new EntityItem();
		//�����ʲ�����
		entityItem.setEiname(flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�ĵ�����"));
		//�����ʲ�˵��
		entityItem.setEidesc(flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "�ĵ�����"));
		
		//��ȡ�ʲ����
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DOCUMENT_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = soc0118BL.searchNextEntityItemLable(cond);
		//�����ʲ����
		entityItem.setEilabel(eilabel);
		
		//��ȡ�ʲ���������Ϣ
		List<ParticipantInfo> participantInfo =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "�����������");
		
		//��ȡ��������Ϣ
		List<ParticipantInfo> expInfo =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), IGPRDCONSTANTS.PROCESS_START_STATUS_LABEL);
		//�����ʲ��������������-��Ӧ�ύ����(���������ڲ���)
		entityItem.setEiorgsyscoding(expInfo.get(0).getOrgid());
		//�����ʲ�����ģ�Ͳ����
		entityItem.setEsyscoding("999013");
		//�����ʲ�������ID
		entityItem.setEiuserid(participantInfo.get(0).getUserid());
		//�����ʲ�����������
		entityItem.setEiusername(participantInfo.get(0).getUsername());
		
		//�����ʲ�������Ϣ�б�
		List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
		
		//�ʲ������б�
		String[] itemNames = new String[]{"�ĵ�����","�ĵ�����","�ĵ��ܼ�","�ĵ����","�ĵ���������","������Ҫ��","�洢��ʽ","�Ƿ������","���λ��"};
		for(int i=0;i<itemNames.length;i++){
			//����ʲ�������Ϣ
			EntityItemConfigValue configItem = new EntityItemConfigValue();
			configItem.setName(itemNames[i]);
			String value = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), itemNames[i]);
			configItem.setValue(value);
			configItems.add(configItem);
		}
		
		//��ȡ���̸���
		IG036SearchCondImpl cond036 = new IG036SearchCondImpl();
		cond036.setPrid(bean.getLogInfo().getPrid());//����ID
		cond036.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);//������־
		//�����û���ɫ���ҽ�ɫ��־
		List<IG036Info> lst_IG036Info = workFlowOperationBL.searchUserRoleRecondLog(cond036);
		
		//��ȡ������Ϣ
		List<Attachment> lst_attachment = new ArrayList<Attachment>();
		for(IG036Info info : lst_IG036Info){
			if(info.getRlattkey() != null && !info.getRlattkey().isEmpty()){
				lst_attachment = attachmentBL.searchAttachmentsByAttkey(info.getRlattkey());
			}
		}
		
		//����ĵ��ļ�
		String docname = "";
		if(lst_attachment != null && lst_attachment.size() > 0){
			docname = lst_attachment.get(0).getAttname().split("_")[lst_attachment.get(0).getAttname().split("_").length-1].replace(".", "_1.");
		}
		EntityItemConfigValue configItem = new EntityItemConfigValue();
		configItem.setName("�ĵ��ļ�");
		configItem.setValue(docname);	
		configItem.setFile(null);
		configItems.add(configItem);
		
		//���"�鵵����"����������
		configItem = new EntityItemConfigValue();
		configItem.setName("�鵵����");
		configItem.setValue(participantInfo.get(0).getOrgname());
		configItems.add(configItem);
		
		entityItem.setConfigItems(configItems);

		//����ʲ�
		Integer eiid = flowSetBL.createEntityItem(entityItem);

		if(!"".equals(docname)){
			//�ļ�����
			StringBuffer rfilename = new StringBuffer();
			rfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
			rfilename.append(lst_attachment.get(0).getAtturl());
			rfilename.append(File.separator);
			rfilename.append(lst_attachment.get(0).getAttname());
			
			StringBuffer cfilename = new StringBuffer();
			cfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
			cfilename.append("asm"+File.separator);
			cfilename.append(eiid);
			//����Ŀ���ļ���
			boolean isCreate = new File(cfilename.toString()).mkdir();
			if(!isCreate){
				log.error(cfilename.toString()+"����ʧ��");
			}
			
			cfilename.append(File.separator);
			cfilename.append(docname);
			
			try{
				FileUtils.copyFile(new File(rfilename.toString()), new File(cfilename.toString()));
			}catch (Exception e) {
				log.error("�ļ�����ʧ��",e);
			}
		}
		
		
		//��ȡ�ĵ����
		String documentNum = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),"�ĵ����");
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPivarname("�ĵ����");
		ig599Cond.setPivarvalue(documentNum);
		List<IG599Info> ig500List = ig599BL.searchIG599InfosByCond(ig599Cond);
		//�ж��ĵ�����Ƿ����
		if(null != ig500List && ig500List.size() > 0){
			for (IG599Info ig599Info : ig500List) {
				//�ų���ǰ���̱��֮�������������ʾ��Ϣ
				if(!bean.getLogInfo().getPrid().equals(ig599Info.getPrid())){
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCRC0803.E002");
				}
			}
		}
		
		//����ĵ���ų���99 ��ʾ��Ϣ
		if(documentNum != null && documentNum.length() > 10){
			if(Integer.parseInt(documentNum.substring(10)) > 99){
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCRC0803.E001");
			}
		}
		
		log.debug("=====================����������̹رյ�ǰ�ô���ʼ=====================");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}