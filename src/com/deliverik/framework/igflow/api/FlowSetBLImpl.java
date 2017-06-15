/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.api;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.parameter.EntityItemInfo;
import com.deliverik.framework.igflow.parameter.PrivateProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValueInfo;
import com.deliverik.framework.igflow.parameter.StatusParticipantInfo;
import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * ���̸��¹���API
 */
public class FlowSetBLImpl extends BaseBLImpl implements FlowSetBL {
    
	/** ���̶���BL */
    protected WorkFlowDefinitionBL workFlowDefinitionBL; 
    
    /** ���̴���BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** �ʲ�������ϢBL */
	protected SOC0118BL soc0118BL;
	
	/** �ʲ�����BL */
	protected SOC0107BL soc0107BL;
	
	/** ��ɫBL */
	protected RoleBL roleBL;

	/** �û�BL */
	protected UserBL userBL;

	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** �ʲ�ģ��BL */
	protected SOC0117BL soc0117BL;
	
	/** �ʲ��������Զ���BL */
	protected SOC0109BL soc0109BL;
	
	/** �����ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
    /**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * �ʲ�������ϢBL�趨
	 *
	 * @param soc0118BL �ʲ�������ϢBL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}
	
	/**
	 * �ʲ�����BL�趨
	 * 
	 * @param soc0107BL �ʲ�����BL
	 */
	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}
	
	/**
	 * ��ɫBL�趨
	 * 
	 * @param roleBL ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * �û�BL�趨
	 * 
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * �û���ɫBL�趨
	 * 
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * �ʲ�ģ��BL�趨
	 * @param soc0117BL �ʲ�ģ��BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	/**
	 * �ʲ��������Զ���BL�趨
	 * @param soc0109BL �ʲ��������Զ���BL
	 */
	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}

	/**
	 * �����ϴ�BL�趨
	 * @param fileUploadBL �����ϴ�BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	/**
	 * ����ʲ�����
	 * @param eiid �ʲ�ID
	 * @param lst_EntityItemConfigValueInfo �ʲ�������Ϣ
	 * @throws BLException
	 */
	public void createConfigItem(Integer eiid, List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo) throws BLException {
		if(eiid == null || eiid == 0) throw new BLException("IGFLOW0000.E001","�ʲ�ID");
		if(lst_EntityItemConfigValueInfo == null || lst_EntityItemConfigValueInfo.size() == 0)
			throw new BLException("IGFLOW0000.E001","�ʲ�������Ϣ");
		//��װ�ʲ�������Ϣ
		SOC0118Info entity = soc0118BL.searchEntityItemByKey(eiid);
		if(entity.getEiversion() != null || entity.getEiversion() > 0) {
			throw new BLException("IGFLOW0000.E005", entity.getEiname() + "�Ѱ���������Ϣ");
		}
		//�����ʲ�������Ϣ
		//��ѯ�ʲ���������Ϣ
		List<SOC0117Info> parentNodes = soc0117BL.getParentNodes(entity.getEsyscoding());
		List<SOC0109Info> configurations = new ArrayList<SOC0109Info>();
		SOC0109SearchCondImpl configcond = new SOC0109SearchCondImpl();
		configcond.setCseq(1);
		for(SOC0117Info e:parentNodes){
			configcond.setEid(e.getEid().toString());
			configurations.addAll(soc0109BL.searchConfiguration(configcond, 0, 0));
		}
		Map<String, EntityItemConfigValueInfo> configItemValueMap = new HashMap<String, EntityItemConfigValueInfo>();
		for(EntityItemConfigValueInfo configItem: lst_EntityItemConfigValueInfo){
			configItemValueMap.put(configItem.getName(), configItem);
		}
		for(SOC0109Info configuration:configurations){
			SOC0107TB configItem = new SOC0107TB();
			//�豸ID
			configItem.setEiid(entity.getEiid());
			//ģ������ID
			configItem.setCid(configuration.getCid());
			//ģ��ID
			configItem.setEid(entity.getEid());
			//ģ�Ͳ����
			configItem.setEsyscoding(entity.getEsyscoding());
			//��汾��
			configItem.setCiversion(1);
			//С�汾��
			configItem.setCismallversion(0);
			//����ʱ��
			configItem.setCiupdtime(entity.getEiupdtime());
			//����������ֵ
			EntityItemConfigValueInfo valueInfo = configItemValueMap.get(configuration.getCname());
			if(valueInfo != null){
				configItem.setCivalue(valueInfo.getValue());
				//���������Դ���
				if("1".equals(configuration.getCattach())){
					String fileName = uploadAssetFormFile(valueInfo.getFile(), entity.getEiid(), 1);
					configItem.setCivalue(fileName);
				}
			}
			soc0107BL.registSOC0107(configItem);
		}
		SOC0118TB instance = (SOC0118TB) SerializationUtils.clone(entity);
		instance.setEiversion(1);
		soc0118BL.updateEntityItem(instance);
	}
	
	/**
	 * ����ʲ�
	 * ���������벻����ʱ���쳣
	 * ����ģ����Ϣ������ʱ���쳣
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ�ID
	 * @throws BLException
	 */
	public Integer createEntityItem(EntityItemInfo entityItem) throws BLException {
		if(entityItem == null) throw new BLException("IGFLOW0000.E001","�ʲ������Ϣ");
		if(StringUtils.isEmpty(entityItem.getEsyscoding())) throw new BLException("IGFLOW0000.E001","�ʲ�����ģ����Ϣ");
		if(StringUtils.isEmpty(entityItem.getEiorgsyscoding())) throw new BLException("IGFLOW0000.E001","�ʲ�����������Ϣ");
		//��ѯ�ʲ�����ģ����Ϣ
		SOC0117SearchCondImpl entitycond = new SOC0117SearchCondImpl();
		entitycond.setEsyscoding(entityItem.getEsyscoding());
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(entitycond);
		if(entitylist == null || entitylist.isEmpty()){
			throw new BLException("IGFLOW0000.E001","�ʲ�����ģ����Ϣ");
		}else if(entitylist.size() > 1){
			throw new BLException("IGFLOW0000.E002","�ʲ�����ģ����Ϣ");
		}
		//��װ�ʲ�������Ϣ
		SOC0118TB instance = soc0118BL.getEntityItemTBInstance();
		instance.setEid(entitylist.get(0).getEid().toString());
		instance.setEidesc(entityItem.getEidesc());
		instance.setEiinsdate(IGStringUtils.getCurrentDate());
		instance.setEilabel(entityItem.getEilabel());
		instance.setEiname(entityItem.getEiname());
		instance.setEiorgsyscoding(entityItem.getEiorgsyscoding());
		instance.setEismallversion(0);
		instance.setEistatus(entityItem.getEistatus());
		instance.setEiuserid(entityItem.getEiuserid());
		instance.setEiusername(entityItem.getEiusername());
		instance.setEiversion(0);
		instance.setEsyscoding(entityItem.getEsyscoding());
		instance.setEiupdtime(IGStringUtils.getCurrentDateTime());
		instance.setFingerPrint(entityItem.getFingerPrint());
		SOC0118Info entity = soc0118BL.registEntityItem(instance);
		//�����ʲ�������Ϣ
		if(entityItem.getConfigItems() != null && entityItem.getConfigItems().size() > 0){
			//��ѯ�ʲ���������Ϣ
			List<SOC0117Info> parentNodes = soc0117BL.getParentNodes(entity.getEid());
			List<SOC0109Info> configurations = new ArrayList<SOC0109Info>();
			SOC0109SearchCondImpl configcond = new SOC0109SearchCondImpl();
			configcond.setCseq(1);
			for(SOC0117Info e:parentNodes){
				configcond.setEid(e.getEid().toString());
				configurations.addAll(soc0109BL.searchConfiguration(configcond, 0, 0));
			}
			Map<String, EntityItemConfigValueInfo> configItemValueMap = new HashMap<String, EntityItemConfigValueInfo>();
			for(EntityItemConfigValueInfo configItem:entityItem.getConfigItems()){
				configItemValueMap.put(configItem.getName(), configItem);
			}
			for(SOC0109Info configuration:configurations){
				SOC0107TB configItem = new SOC0107TB();
				//�豸ID
				configItem.setEiid(entity.getEiid());
				//ģ������ID
				configItem.setCid(configuration.getCid());
				//ģ��ID
				configItem.setEid(entity.getEid());
				//ģ�Ͳ����
				configItem.setEsyscoding(entity.getEsyscoding());
				//��汾��
				configItem.setCiversion(1);
				//С�汾��
				configItem.setCismallversion(0);
				//����ʱ��
				configItem.setCiupdtime(entity.getEiupdtime());
				//����������ֵ
				EntityItemConfigValueInfo valueInfo = configItemValueMap.get(configuration.getCname());
				if(valueInfo != null){
					configItem.setCivalue(valueInfo.getValue());
					//���������Դ���
					if("1".equals(configuration.getCattach())){
						String fileName = uploadAssetFormFile(valueInfo.getFile(), entity.getEiid(), 1);
						if(fileName == null && !"".equals(valueInfo.getValue()) ){
							fileName = valueInfo.getValue();
						}
						configItem.setCivalue(fileName);
					}
				}
				soc0107BL.registSOC0107(configItem);
			}
			instance = (SOC0118TB) SerializationUtils.clone(entity);
			instance.setEiversion(1);
			soc0118BL.updateEntityItem(instance);
		}
		return entity.getEiid();
	}

	/**
	 * ״̬������ɾ��
	 * 
	 * @param statusParticipantInfo ״̬��������Ϣ
	 * @throws BLException
	 */
	public void deleteStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException {
		//�����û�
		User user = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getExecutorid());
		//��Ȩ�û�
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(statusParticipantInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getAuthuserid());
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(statusParticipantInfo.getLogInfo().getPrid());
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(statusParticipantInfo.getLogInfo().getPrid());
		if(StringUtils.isNotEmpty(statusParticipantInfo.getStatuscode())){
			//���̸��죬code�뽫������ʵ�����壬��״̬ID����  wangtingzhi 20140513
			//���̸��죬code�뽫������ʵ�����壬��״̬ID����  wangtingzhi 20140513
//			cond.setPpstatus(statusParticipantInfo.getStatuscode());
			cond.setPsdid(statusParticipantInfo.getStatuscode());
		}else{
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(process.getPrpdid());
			psdCond.setPsdname(statusParticipantInfo.getStatusname());
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "״̬��" + statusParticipantInfo.getStatusname() + "��");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "״̬��" + statusParticipantInfo.getStatusname() + "��");
			}
			//���̸��죬code�뽫������ʵ�����壬��״̬ID����  wangtingzhi 20140513
//			cond.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
			cond.setPsdid(lst_ProcessStatusDef.get(0).getPsdid());
		}
		cond.setPproleid(statusParticipantInfo.getRoleid());
		cond.setPpuserid(statusParticipantInfo.getUserid());
		//��ѯ������
		List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
		for(IG337Info pp : lst_ProcessParticipant) {
			workFlowOperationBL.removeProcessParticipant(pp, user, statusParticipantInfo.getLogInfo().getExecutorRoleid(), "", "ɾ��������",
					null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, null, null);
		}
	}
	
	/**
	 * �Ա��Ϊ��λɾ�����б��ʽ��ֵ
	 * �к�Ϊ��ʱɾ���ñ��������ֵ
	 * ������Ϣ�����ڻ����Ϣ������ʱ���쳣
	 * @param tableColumnDefMap ���ʽ���ж���
	 * @param tableColumnFullName ���ʽ����ȫ·������
	 * @param prid ��������
	 * @param rownumber �к�(��Ϊ��)
	 * @throws BLException
	 */
	public void deletePublicTableFormValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber) throws BLException{
		//��������Ϣȡ��
		ProcessInfoDefinitionInfo tableDef = tableColumnDefMap.get(tableColumnFullName);
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPidid(tableDef.getPidid());
		cond.setRownumber(rownumber);
		List<IG898Info> list = workFlowOperationBL.searchTableFormValue(cond);
		if(list != null && list.size() > 0){
			workFlowOperationBL.deleteTableFormValue(list);
		}
	}
	
	/**
	 * �ʲ�������������
	 * 
	 * @param eiid �ʲ�ID
	 * @param eiorgsyscoding ���º���ʲ��������������
	 * @throws BLException
	 */
	public void setEntityItemValue(Integer eiid, String eiorgsyscoding) throws BLException {

		if(eiid == null || eiid <= 0) {
			throw new BLException("IGCO10000.E004","�ʲ�ID");
		}
		if(StringUtils.isEmpty(eiorgsyscoding)) {
			throw new BLException("IGCO10000.E004","���º���ʲ��������������");
		}
		// ����������ѯ�ʲ���Ϣ
		SOC0118Info soc0118Info = this.soc0118BL.searchEntityItemByKey(eiid);
		if(soc0118Info == null){
			throw new BLException("IGFLOW0000.E001", "EiidΪ��" + eiid + "�����ʲ�");
		}
		// �����ʲ���������
		SOC0118TB soc0118TB = (SOC0118TB)SerializationUtils.clone(soc0118Info);
		soc0118TB.setEiorgsyscoding(eiorgsyscoding);
		this.soc0118BL.updateEntityItem(soc0118TB);
	}
	
	/**
	 * �ʲ�����ֵ����
	 * 
	 * @param entityItemConfigValueInfo �ʲ�������Ϣ
	 * @param upgrade �Ƿ�����
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(EntityItemConfigValueInfo entityItemConfigValueInfo,
			boolean upgrade) throws BLException {
		List<SOC0107Info> lst_ConfigItem = soc0107BL.searchSOC0107HistoryByEiid(
				entityItemConfigValueInfo.getEiid(), -1, null, entityItemConfigValueInfo.getName());
		if(lst_ConfigItem.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "���ԣ�" + entityItemConfigValueInfo.getName() + "��");
		} else if(lst_ConfigItem.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "���ԣ�" + entityItemConfigValueInfo.getName() + "��");
		} else {
			SOC0107TB instance = (SOC0107TB)SerializationUtils.clone(lst_ConfigItem.get(0));
			instance.setCivalue(entityItemConfigValueInfo.getValue());
			if(entityItemConfigValueInfo.getFile() != null){
				int version = instance.getEiid();
				if(upgrade){
					version ++;
				}
				String fileName = uploadAssetFormFile(entityItemConfigValueInfo.getFile(), instance.getEiid(), version);
				if(StringUtils.isNotEmpty(fileName)){
					instance.setCivalue(fileName);
				}
			}
			if(upgrade) {
				soc0107BL.saveSOC0107(lst_ConfigItem.get(0).getCiversion(), instance);
			} else {
				//ֵ�仯��ʶ
				if(StringUtils.isEmpty(lst_ConfigItem.get(0).getCivalue())) {
					if(StringUtils.isNotEmpty(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				} else {
					if(!lst_ConfigItem.get(0).getCivalue().equals(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				}
				soc0107BL.updateSOC0107(instance);
			}
		}
	}
	
	/**
	 * �ʲ�����ֵ����
	 * 
	 * @param lst_EntityItemConfigValueInfo �ʲ�������Ϣ����
	 * @param upgrade �Ƿ�����
	 * @throws BLException
	 */
	public void setEntityItemConfigValue(List<EntityItemConfigValueInfo> lst_EntityItemConfigValueInfo,
			boolean upgrade) throws BLException {
		List<SOC0107Info> lst_ConfigItem = null;
		List<SOC0107Info> lst_Instance = new ArrayList<SOC0107Info>();
		Integer eiid = null;
		int currentEiversion = -2;
		for(EntityItemConfigValueInfo entityItemConfigValueInfo : lst_EntityItemConfigValueInfo) {
			lst_ConfigItem = soc0107BL.searchSOC0107HistoryByEiid(
					entityItemConfigValueInfo.getEiid(), -1, null, entityItemConfigValueInfo.getName());
			if(lst_ConfigItem.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "���ԣ�" + entityItemConfigValueInfo.getName() + "��");
			} else if(lst_ConfigItem.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "���ԣ�" + entityItemConfigValueInfo.getName() + "��");
			} else {
				SOC0107TB instance = (SOC0107TB)SerializationUtils.clone(lst_ConfigItem.get(0));
				instance.setCivalue(entityItemConfigValueInfo.getValue());
				if(entityItemConfigValueInfo.getFile() != null){
					int version = instance.getEiid();
					if(upgrade){
						version ++;
					}
					String fileName = uploadAssetFormFile(entityItemConfigValueInfo.getFile(), instance.getEiid(), version);
					if(StringUtils.isNotEmpty(fileName)){
						instance.setCivalue(fileName);
					}
				}
				//ֵ�仯��ʶ
				if(StringUtils.isEmpty(lst_ConfigItem.get(0).getCivalue())) {
					if(StringUtils.isNotEmpty(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				} else {
					if(!lst_ConfigItem.get(0).getCivalue().equals(entityItemConfigValueInfo.getValue())) {
						instance.setCicurver("1");
					}
				}
				lst_Instance.add(instance);
				eiid = lst_ConfigItem.get(0).getEiid();
				currentEiversion = lst_ConfigItem.get(0).getCiversion();
			}
		}
		if(upgrade) {
			soc0107BL.saveSOC0107(eiid, currentEiversion, lst_Instance);
		} else {
			for(SOC0107Info instance : lst_Instance) {
				soc0107BL.updateSOC0107(instance);
			}
		}
	}
	
	/**
	 * ������������ʲ�
	 * <BR>
	 * ������Ϣ�����ڡ�����Ϣ�����ڻ����ʲ���ϢΪ��ʱ���쳣
	 * @param prid ��������
	 * @param pidname ������
	 * @param entitys �ʲ���Ϣ����
	 * @throws BLException
	 */
	public void setProcessEntityItem(Integer prid, String pidname, List<ProcessInfoEntityInfo> entitys) throws BLException{
	    if(prid == 0 || prid <= 0) {
			throw new BLException("IGCO10000.E004","���̶���ID");
		}
		if(entitys == null || entitys.isEmpty()){
			throw new BLException("IGCO10000.E004","����ʲ�");
		}
		Integer piid = null;
		//��ѯ���̱�����
		if(StringUtils.isNotEmpty(pidname)){
			IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
			cond599.setPrid(prid);
			cond599.setPivarname(pidname);
			List<IG599Info> piList = workFlowOperationBL.searchProcessInfoByCond(cond599);
			if(piList != null && piList.size() > 0){
				piid = piList.get(0).getPiid();
			}
		}
		if(piid == null){
			throw new BLException("IGCO10000.E004","��");
		}
		for(ProcessInfoEntityInfo entity:entitys){
			IG731TB processInfoEntity = new IG731TB();
			processInfoEntity.setPrid(prid);
			processInfoEntity.setPiid(piid);
			processInfoEntity.setEiid(entity.getEiid());
			processInfoEntity.setFingerPrint(entity.getFingerPrint());
			processInfoEntity.setEiversion(entity.getEiversion());
			workFlowOperationBL.saveProcessInfoEntity(processInfoEntity);
		}
	}
	
	/**
	 * ˽�б�ֵ����
	 * 
	 * @param privateProcessInfoValueInfo ˽�б���Ϣ
	 * @throws BLException
	 */
	public void setPrivateProcessInfoValue(PrivateProcessInfoValueInfo privateProcessInfoValueInfo) throws BLException {
		//�������̱���¼
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(privateProcessInfoValueInfo.getLogInfo().getPrid());//����ID
		cond.setPivarlabel(privateProcessInfoValueInfo.getFormname());//������
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "����" + privateProcessInfoValueInfo.getFormname() + "��");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "����" + privateProcessInfoValueInfo.getFormname() + "��");
		} else {
			//�������̱���¼ID����˽�б���¼
			IG899SearchCondImpl privateCond = new IG899SearchCondImpl();
			privateCond.setPiid(lst_ProcessInfo.get(0).getPiid());//���̱���¼ID
			privateCond.setRoleid(privateProcessInfoValueInfo.getLogInfo().getExecutorRoleid());//��ɫID
			privateCond.setUserid(privateProcessInfoValueInfo.getLogInfo().getExecutorid());//�û�ID
			List<IG899Info> lst_ProcessPrivateInfo = workFlowOperationBL.searchProcessPrivateInfo(privateCond);
			if(lst_ProcessPrivateInfo.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "����" + privateProcessInfoValueInfo.getFormname() + "��");
			} else if(lst_ProcessPrivateInfo.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "����" + privateProcessInfoValueInfo.getFormname() + "��");
			} else {
				//����˽�б�
				IG899TB private_nstance = (IG899TB)SerializationUtils.clone(lst_ProcessPrivateInfo.get(0));
				private_nstance.setPpivalue(privateProcessInfoValueInfo.getFormvalue());
				workFlowOperationBL.updateProcessPrivateInfo(private_nstance);
				//�������־�������
				IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
				instance.setPivarvalue(privateProcessInfoValueInfo.getFormvalue());
				lst_ProcessInfo.clear();
				lst_ProcessInfo.add(instance);
				//��¼������־
				IG036Info recordLog = workFlowOperationBL.addRecordLog(privateProcessInfoValueInfo.getLogInfo().getPrid(),
						userBL.searchUserByKey(privateProcessInfoValueInfo.getLogInfo().getExecutorid()),
						privateProcessInfoValueInfo.getLogInfo().getExecutorRoleid(), privateProcessInfoValueInfo.getLogInfo().getComment(),
						"���±�", null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null, null);
				//��¼��������־
				workFlowOperationBL.addRecordLogVarInfo(lst_ProcessInfo, recordLog);
			}
		}
	}
	
	/**
	 * ������־���
	 * 
	 * @param logInfo ������־������Ϣ
	 * @param desc ��־��������
	 * @param type ��־����
	 * @throws BLException
	 */
	public void setProcessLog(WorkFlowLogInfo logInfo, String desc, String type) throws BLException {
		workFlowOperationBL.addRecordLog(logInfo.getPrid(),
				userBL.searchUserByKey(logInfo.getExecutorid()),
				logInfo.getExecutorRoleid(), logInfo.getComment(),
				desc, null, type, null, null);
	}

	/**
	 * ���̹�ϵ���
	 * 
	 * @param parprid ������ID
	 * @param cldprid �������ID
	 * @throws BLException
	 */
	public void setProcessRelation(Integer parprid, Integer cldprid) throws BLException {
		IG512TB prrTB = workFlowOperationBL.getProcessRecordRelationTBInstance();
		prrTB.setParprid(parprid);//������ID
		prrTB.setCldprid(cldprid);//�������ID
		prrTB.setPrrinstime(IGStringUtils.getCurrentDateTime());//����ʱ��
		workFlowOperationBL.createProcessRecordRelation(prrTB);
	}

	/**
	 * ���̹����Ÿ���
	 * 
	 * @param prid ����ID
	 * @param serialnum ���̹�����
	 * @throws BLException
	 */
	public void setProcessSerialNum(Integer prid, String serialnum) throws BLException {
		IG500Info ig500Info =  workFlowOperationBL.searchProcessRecordByKey(prid);
		IG500TB ig500TB = (IG500TB)SerializationUtils.clone(ig500Info);
		ig500TB.setPrserialnum(serialnum);
		workFlowOperationBL.updateProcessRecord(ig500TB);
	}
	
	/**
	 * ���б�ֵ����
	 * 
	 * @param publicProcessInfoValueInfo ���б���Ϣ
	 * @throws BLException
	 */
	public void setPublicProcessInfoValue(PublicProcessInfoValueInfo publicProcessInfoValueInfo) throws BLException {
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(publicProcessInfoValueInfo.getLogInfo().getPrid());//����ID
		cond.setPivarlabel(publicProcessInfoValueInfo.getFormname());//������
		List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
		if(lst_ProcessInfo.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "����" + publicProcessInfoValueInfo.getFormname() + "��");
		} else if(lst_ProcessInfo.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "����" + publicProcessInfoValueInfo.getFormname() + "��");
		} else {
			IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
			instance.setPivarvalue(publicProcessInfoValueInfo.getFormvalue());
			workFlowOperationBL.updateProcessInfo(instance);
			lst_ProcessInfo.clear();
			lst_ProcessInfo.add(instance);
			//��¼������־
			IG036Info recordLog = workFlowOperationBL.addRecordLog(publicProcessInfoValueInfo.getLogInfo().getPrid(),
					userBL.searchUserByKey(publicProcessInfoValueInfo.getLogInfo().getExecutorid()),
					publicProcessInfoValueInfo.getLogInfo().getExecutorRoleid(), publicProcessInfoValueInfo.getLogInfo().getComment(),
					"���±�", null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null, null);
			//��¼��������־
			workFlowOperationBL.addRecordLogVarInfo(lst_ProcessInfo, recordLog);
		}
	}
	
	/**
	 * ���ʽ������ֵ�趨(���㼶�����м��� "#" ����)
	 * ����ñ�ȫ·�����ж���map�в�����ʱ���쳣
	 * @param tableColumnDefMap ���ʽ���ж���
	 * @param tableColumnFullName ���ʽ����ȫ·������
	 * @param prid ��������
	 * @param rownumber �к�
	 * @throws BLException
	 */
	public void setPublicTableColumnValue(Map<String, ProcessInfoDefinitionInfo> tableColumnDefMap,String tableColumnFullName,Integer prid,String rownumber,String value) throws BLException {
		try{
			//��������Ϣȡ��
			ProcessInfoDefinitionInfo tableColumnDef = tableColumnDefMap.get(tableColumnFullName);
			//����������Ϣȡ��
			IG007Info pid = workFlowDefinitionBL.searchProcessInfoDefByKey(tableColumnDef.getPpidid());
			IG898TB entry = new IG898TB();
			entry.setPidid(pid.getPidid());
			entry.setPidname(pid.getPidname());
			entry.setPrid(prid);
			entry.setPvalue(value);
			entry.setPvcolname(tableColumnDef.getPidname());
			entry.setPvcolpidid(tableColumnDef.getPidid());
			entry.setPvrownumber(rownumber);
			workFlowOperationBL.registTableFormValue(entry);
		}catch (Exception e) {
			throw new BLException("IGFLOW0000.E001","��������Ϣ");
		}
	}

	/**
	 * �����ɫ�Ͳ��������
	 * 
	 * @param statusParticipantInfo ״̬��������Ϣ
	 * @throws BLException
	 */
	public void setStatusParticipant(StatusParticipantInfo statusParticipantInfo) throws BLException {
		//�����û�
		User user = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getExecutorid());
		//��Ȩ�û�
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(statusParticipantInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(statusParticipantInfo.getLogInfo().getAuthuserid());
		}
		//�����߽�ɫ
		Role role = roleBL.searchRoleByKey(statusParticipantInfo.getRoleid());
		//�������û�
		User participant = null;
		if(StringUtils.isNotEmpty(statusParticipantInfo.getUserid())) {
			participant = userBL.searchUserByKey(statusParticipantInfo.getUserid());
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(statusParticipantInfo.getLogInfo().getPrid());
		//������ʵ��
		IG337TB instance = workFlowOperationBL.getProcessParticipantTBInstance();
		instance.setPrid(statusParticipantInfo.getLogInfo().getPrid());
		if(StringUtils.isNotEmpty(statusParticipantInfo.getStatuscode())){
			if(statusParticipantInfo.getStatuscode().length() > 3) {
				if (statusParticipantInfo.getStatuscode().indexOf("_") > -1) {
					instance.setPsdid(statusParticipantInfo.getStatuscode().split("_")[0]);
					instance.setPsdnum(new Integer(statusParticipantInfo.getStatuscode().split("_")[1]));
					IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(instance.getPsdid());
					instance.setPpstatus(psd.getPsdcode());
				} else {
					instance.setPsdid(statusParticipantInfo.getStatuscode());
					IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(instance.getPsdid());
					instance.setPpstatus(psd.getPsdcode());
				}
			} else {
				instance.setPpstatus(statusParticipantInfo.getStatuscode());
				instance.setPsdid(workFlowDefinitionBL.searchProcessStatusKey(process.getPrpdid(), instance.getPpstatus()));
			}
		}else{
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(process.getPrpdid());
			psdCond.setPsdname(statusParticipantInfo.getStatusname());
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "״̬��" + statusParticipantInfo.getStatusname() + "��");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "״̬��" + statusParticipantInfo.getStatusname() + "��");
			}
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "״̬��" + statusParticipantInfo.getStatusname() + "��");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "״̬��" + statusParticipantInfo.getStatusname() + "��");
			}
			instance.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
			instance.setPsdid(lst_ProcessStatusDef.get(0).getPsdid());
		}
		instance.setPpinittime(IGStringUtils.getCurrentDateTime());
		if(StringUtils.isEmpty(statusParticipantInfo.getUserid())) {
			instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
		} else {
			instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
			instance.setPpuserid(participant.getUserid());
			instance.setPpusername(participant.getUsername());
			instance.setPporgid(participant.getOrgid());
			instance.setPporgname(participant.getOrgname());
			//��ɫ������
			if(userRoleBL.checkRoleManagerByID(participant.getUserid(), role.getRoleid())){
				instance.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
			}
			//��ɫֵ����
			if(userRoleBL.checkRoleDutyflagByID(participant.getUserid(), role.getRoleid())){
				instance.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
			}
			//���������첿��
		}
		instance.setPproleid(role.getRoleid());
		instance.setPprolename(role.getRolename());
		List<IG337Info> todoList = workFlowOperationBL.searchProcessParticipantTodoRole(statusParticipantInfo.getLogInfo().getPrid(),instance.getPpstatus());
		boolean isRepeat = false;
		for(IG337Info todo: todoList){
			if(instance.getPpuserid().equals(todo.getPpuserid()))
				isRepeat = true;
		}
		if(!isRepeat)
			workFlowOperationBL.addProcessParticipant(instance, user, statusParticipantInfo.getLogInfo().getExecutorRoleid(),
					statusParticipantInfo.getLogInfo().getComment(), "��Ӳ�����", 
					null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, null, statusParticipantInfo.getStatuscode());
	}
	
	/**
	 * ���ȫ�������ߴ������ʱ��
	 * 
	 * @param prid ����ID
	 * @param statuscode ״̬��ʶ
	 * @throws BLException
	 */
	public void setStatusParticipantAllRehandle(Integer prid, String statuscode) throws BLException {
		///�Զ������̸��죬״̬code�뽫������ʵ�����壬����״̬��ѯ�����˽���״̬����ID����
		///status ԭΪ״̬code������Ϊ״̬����ID
		///wangtingzhi 20140513
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(statuscode);
		List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(cond);
//		List<IG337Info> ppList = this.workFlowOperationBL.searchProcessParticipant(prid, statuscode);
		for(IG337Info pp:ppList){
			IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
			processParticipant.setPpproctime(null);
			processParticipant.setPbdid(null);
			this.workFlowOperationBL.updateProcessParticipant(processParticipant);
		}
	}

	/**
	 * ���ָ�������ߴ������ʱ��
	 * 
	 * @param prid ����ID
	 * @param statusname ״̬����
	 * @param roleid ��ɫID
	 * @param userid �û�ID
	 * @throws BLException
	 */
	public void setStatusParticipantRehandle(Integer prid, String statusname, Integer roleid, String userid) throws BLException {
		///�Զ������̸��죬״̬code�뽫������ʵ�����壬����״̬��ѯ�����˽���״̬����ID����
		///status ԭΪ״̬code������Ϊ״̬����ID
		///wangtingzhi 20140513
		IG500Info ig500 =  this.workFlowOperationBL.searchProcessRecordByKey(prid);
		IG333SearchCondImpl cond_IG333 = new IG333SearchCondImpl();
		cond_IG333.setPdid(ig500.getPrpdid());
		cond_IG333.setPsdname(statusname);
		List<IG333Info> lst_IG333Info = workFlowDefinitionBL.searchProcessStatusDef(cond_IG333);
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(lst_IG333Info.get(0).getPsdid());
		List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(cond);
		for(IG337Info pp:ppList){
			if(StringUtils.isNotEmpty(pp.getPpuserid())){
				if(pp.getPpuserid().equals(userid)){
					IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
					processParticipant.setPpproctime(null);
					processParticipant.setPbdid(null);
					this.workFlowOperationBL.updateProcessParticipant(processParticipant);
				}
			}else{
				if(pp.getPproleid().equals(roleid)) {
					IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
					processParticipant.setPpproctime(null);
					processParticipant.setPbdid(null);
					this.workFlowOperationBL.updateProcessParticipant(processParticipant);
				}
			}
		}
	}
	
	/**
	 * ����������Ϣ
	 * @param prid ��������
	 * @param valueMap ֵ��������-����ֵ
	 * @throws BLException
	 */
	public void updateProcessRecord(Integer prid,Map<String, Object> valueMap) throws BLException{
		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
		try {
			setPropert(processrecord, valueMap);
		} catch (Exception e) {
			throw new BLException("IGFLOW0000.E005","����ֵ�����쳣��");
		}
		workFlowOperationBL.updateProcessRecord(processrecord);
	}
	
	/**
	 * �ʲ����Ը����ϴ�
	 * �����ϴ�ʧ�������쳣
	 * @param file ��������
	 * @param eiid �ʲ�����
	 * @param eversion �ʲ��汾
	 * @return ������
	 * @throws BLException
	 */
	private String uploadAssetFormFile(FormFile file,Integer eiid,Integer eversion) throws BLException{
		String returnValue = null;
		if(file != null){
			//�ϴ��ļ���·��
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			//ƴ���ϴ��ļ�·��
			StringBuffer pathBuf = new StringBuffer();
			//��Ŀ¼
			pathBuf.append(rootPath);
			//����ID
			pathBuf.append("asm"+File.separator);
			//�豸ID
			pathBuf.append(eiid);
			pathBuf.append(File.separator);
			StringBuffer fileName = new StringBuffer();
			//��չ��ȡ��
			String fileType = "";
			String sFileName = file.getFileName();
			int point = sFileName.lastIndexOf(".");
			if (point != -1) {
				fileType = sFileName.substring(point);
				fileName.append(sFileName.substring(0, point));
			}
			//�ļ�����Ӱ汾��
			fileName.append("_");
			fileName.append(eversion);
			//�ļ���չ��
			fileName.append(fileType);
			//�ļ��ϴ�����
			try {
				fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E005");
			} 
			returnValue = fileName.toString();
		}
		return returnValue;
	}
	
	/**
	 * ���ö���ֵ
	 * @param obj Ҫ����ֵ�Ķ���
	 * @param value ֵ ������-����ֵ
	 */
	@SuppressWarnings("rawtypes")
	private void setPropert(Object obj,Map<String, Object> valueMap) throws Exception{
		Class type = obj.getClass();
		Set<Entry<String, Object>> set = valueMap.entrySet();
		for(Iterator<Entry<String, Object>> iter = set.iterator();iter.hasNext();){
			Entry<String, Object> next = iter.next();
			String key = next.getKey();
			Object value = next.getValue();
			Field field = type.getDeclaredField(key);
			field.setAccessible(true);
			field.set(obj, value);
		}
	}
	
	/**
	 * ��������ʲ���ϵ
	 * @param prid ��������
	 * @param pidname ������
	 * @param eiid �ʲ�ID
	 */
	public Integer setProcessEntityRelation(Integer prid,String pidname,Integer eiid,Integer eiversion,Object... dbFlag) throws BLException{
		if(prid == null || prid == 0){
			throw new BLException("IGFLOW0000.E001","���̻�����Ϣ");
		}
		Integer piid = null;
		if(StringUtils.isNotEmpty(pidname)){
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(prid);//����ID
			cond.setPivarlabel(pidname);//������
			List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
			if(lst_ProcessInfo.size() == 1){
				piid = lst_ProcessInfo.get(0).getPiid();
				IG599TB ig599Tb = (IG599TB) lst_ProcessInfo.get(0);
				ig599Tb.setPivarvalue("N/A");
				workFlowOperationBL.saveProcessInfo(ig599Tb);
			}
		}
		IG731TB entity = new IG731TB();
		entity.setPrid(prid);
		entity.setPiid(piid);
		entity.setEiversion(eiversion == null || eiversion == 0 ? 1 : eiversion);
		entity.setEiid(eiid);
		// Ӧ���޸� �������ݿ��ʶ(�ʲ����� fingerprint��ʾ���ؿ⻹��dblinkԶ�̿�) �Ž� 2016��10��9��
		if(dbFlag!=null&&dbFlag.length>0){
			entity.setFingerPrint(dbFlag[0].toString());
		}
		IG731Info info = workFlowOperationBL.saveProcessInfoEntity(entity);
		return info.getPieid();
	}

	public void setProcessSceneParticipant(Integer sourcePrid,String sourcePivarname,Integer tagPrid,String tagPivarname,String tagPdid) throws BLException {
		String sourcePidid = "";
		if(StringUtils.isNotBlank(sourcePivarname)){
			IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
			ig599Cond.setPivarname(sourcePivarname);
			ig599Cond.setPrid(sourcePrid);
			List<IG599Info> processList =  workFlowOperationBL.searchProcessInfoByCond(ig599Cond);
			if(processList != null){
				sourcePidid = processList.get(0).getPidid();
			}
		}
		
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(sourcePrid);
		cond.setPidname(sourcePivarname);
		cond.setPidid(sourcePidid);
		List<IG898Info> list = workFlowOperationBL.searchTableFormValue(cond);
		
		if(list != null && list.size() >0){
			String tagPidid = "";
			if(StringUtils.isNotBlank(tagPivarname)){
				IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
				ig599Cond.setPivarname(tagPivarname);
				ig599Cond.setPrid(tagPrid);
				List<IG599Info> processList = workFlowOperationBL.searchProcessInfoByCond(ig599Cond);
				if(processList != null){
					tagPidid = processList.get(0).getPidid();
				}
			}
			for(IG898Info info : list){
				IG898TB tb = new IG898TB();
				tb.setPrid(tagPrid);
				tb.setPidid(tagPidid);
				tb.setPidname(tagPivarname);
				String pvcolpidid = "";
				//��ʱ�����ʽ����������ͬ��ѯ
				IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
				ig007Cond.setPidname(info.getPvcolname());
				ig007Cond.setPpdid_like(tagPdid);
				List<IG007Info> processList = workFlowDefinitionBL.searchProcessInfoDef(ig007Cond);
				if(processList != null){
					pvcolpidid = processList.get(0).getPidid();
				}
				tb.setPvcolpidid(pvcolpidid);
				tb.setPvcolname(info.getPvcolname());
				tb.setPvrownumber(info.getPvrownumber());
				tb.setPvalue(info.getPvalue());
				tb.setFingerPrint(info.getFingerPrint());
				workFlowOperationBL.registTableFormValue(tb);
			}
		}
		
	}
}
