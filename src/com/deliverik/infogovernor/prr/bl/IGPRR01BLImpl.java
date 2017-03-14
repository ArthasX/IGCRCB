/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.bl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.TableFormColumnValueInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.ActionBL;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.ActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.UserRoleVW;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prd.model.entity.IG893VW;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG463TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561VW;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0101Form;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.form.IGPRR0104Form;
import com.deliverik.infogovernor.prr.form.IGPRR0109Form;
import com.deliverik.infogovernor.prr.form.IGPRR0113Form;
import com.deliverik.infogovernor.prr.form.IGPRR0121Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01036VO;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.util.CodeDefine;
import com.dev.crc.igflow.event.status.IGFXK0402BLImpl;

/**
 * @Description: ��������ҵ���߼�ʵ��_ҵ�������� drm
 * @Author  
 * @History 2010-9-13     �½� 
 * 			2012-3-20	  ����  120320�� ��������ʱ������ɾ�����ύ���͡��ύ��ȷ�ϡ��ĸ���
 * 			2012-3-30     ����  120330�� �Զ������̸������ÿ������⡢��������ʾ
 * 			2012-4-06     ����  ���Ӷ�˽�б�����ֵ���浽Ig007TB��
 * 			2013-01-08     ���� =20130108 ��ť��Ӳ�����
 * 			2013-02-25     ����  130225 ���̻�������޸�
 * 			2015-04-02     ����  150402 ���������жϵ�ǰ��¼���Ƿ��ǵ�ǰ����ģ������̹���Ա
 * @Version V1.0
 */
public class IGPRR01BLImpl extends BaseBLImpl implements IGPRR01BL {

    static Log log = LogFactory.getLog(IGPRR01BLImpl.class);	
    
	
    // ���ο���log
    static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
	protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	protected final static DecimalFormat df = new DecimalFormat("0.0");
	
	// 1Сʱ=60����=3600��=3600000
	protected final static double hours = 60.0D * 60 * 1000;

	/** ������ϢBL */
	protected AttachmentBL attachmentBL;

	/** ������ϢBL */
	protected OrganizationBL organizationBL;
	
	/** �˵�BL */
	protected ActionBL actionBL;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	
	protected IGFXK0402BLImpl igfxk0402bl;
	
	/**���̶���BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**�û���ɫ��Ȩ��ϢBL*/
	protected UserRoleBL userRoleBL;
	
	/**��ɫ��Ϣҵ��BL*/
	protected RoleBL roleBL;
	
	/** �û����� */
	protected UserBL userBL;
 
    /**CodeDetailBL*/
    protected CodeDetailBL codeDetailBL;
    
	/** ���ŷ���BL */
	protected SendMessageBL sendMessageBL;
	
	/** ����BL */
	protected FileUploadBL fileUploadBL;
	
	/** ��ϳ���ʵ����ϵ��BL */
	protected IG483BL ig483BL;
	
	/** ��ϳ���������BL */
	protected IG480BL ig480BL;
	
	/**
	 * @param ig480bl the ig480BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	/**
	 * @param ig484bl the ig484BL to set
	 */
	public void setIg483BL(IG483BL ig483bl) {
		ig483BL = ig483bl;
	}

	/**
	 * ������ϢBL�趨
	 * @param attachmentBL ������ϢBL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	/**
	 * @return the igfxk0402bl
	 */
	public IGFXK0402BLImpl getIgfxk0402bl() {
		return igfxk0402bl;
	}



	/**
	 * @param igfxk0402bl the igfxk0402bl to set
	 */
	public void setIgfxk0402bl(IGFXK0402BLImpl igfxk0402bl) {
		this.igfxk0402bl = igfxk0402bl;
	}



	/**
	 * ������ϢBL�趨
	 * @param organizationBL ������ϢBL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	/**
	 * ���ŷ���BL�趨
	 *
	 * @param sendMessageBL ���ŷ���BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
     * @param CodeDetailBL the codeDetailBL to set
     */
    public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
        this.codeDetailBL = codeDetailBL;
    }
    
	public void setActionBL(ActionBL actionBL) {
		this.actionBL = actionBL;
	}

	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * �û���ɫBL�趨
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ��ɫBL�趨
	 * @param roleBL ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	/**
	 * �û�BL�趨
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ����BL�趨
	 * @param fileUploadBL ����BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	/**
     * ��ǰ�����������ð汾��PDIDȡ�ô���7λ��PDIDȡ�ô���
     *
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     */
    public IGPRR01DTO searchPdid7BitAction(IGPRR01DTO dto) throws BLException {
        log.debug("========��ǰ�����������ð汾��PDIDȡ�ô���ʼ========");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like(dto.getPdid());
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = this.workFlowDefinitionBL.searchProcessDefinition(condImpl);
        if (ig380infoList.size() == 0) {
            throw new BLException("IGCO10000.E027", dto.getPdid());
        } else {
            dto.setPdid(ig380infoList.get(0).getPdid());
        }
        log.debug("========��ǰ�����������ð汾��PDIDȡ�ô�������========");
        return dto;
    }
	
	/**
	 * �����ɫ��Ϣ��ѯ����
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchInitProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException {
		
		log.debug("========�����ɫ��Ϣ��ѯ����ʼ========");
		List<LabelValueBean> roleList = this.workFlowDefinitionBL.searchInitProcessParticipantRole(dto.getUser().getUserid(), dto.getPdid());
		if(roleList.isEmpty()) {
			throw new BLException("IGCO10000.E004","�����ɫ����");
		}
		dto.setLabelList(roleList);
		log.debug("========�����ɫ��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ���ݲ����˽�ɫID������״̬�Ȳ�ѯ��Ӧ�����̲����ߵĶ���������Ȩ�޵������Ϣ
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	private IGPRR01DTO searchProcessParticipantDefByRoleAndProcessStatusAction(IGPRR01DTO dto) throws BLException {
		log.debug("========��ѯ��Ӧ�����̲����ߵĶ���������Ȩ�޴���ʼ========");
		String psdid = dto.getPsdid();//����״̬ID
		Integer roleid = dto.getRoleid();
		boolean flag = true;
		if(StringUtils.isNotEmpty(psdid) && dto.getLabelList() != null && dto.getLabelList().size() > 0){
			//�趨�����߱���Ȩ��
			if(roleid!=null){
				for(int i=0,j=dto.getLabelList().size();i<j;i++){
					//����
					if(dto.getIgPRR0101Form() != null) {
						if(roleid.toString().equals(dto.getLabelList().get(i).getValue())){
							flag = false;
							break;
						}
					} else {//����
						if(roleid.toString().equals(dto.getLabelList().get(i).getValue().split("_")[1])){
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag){
				//����
				if(dto.getIgPRR0101Form() != null) {
					roleid = Integer.parseInt(dto.getLabelList().get(0).getValue());
				} else {//����
					roleid = Integer.parseInt(dto.getLabelList().get(0).getValue().split("_")[1]);
				}
			}
			List<IG893Info> participantVariableVW = null;
			if(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y.equals(dto.getIsFormGlobalControl())){
				participantVariableVW = this.workFlowOperationBL.searchParticipantMaxVariableVW(psdid, roleid,dto.getLs_proStatusParticipantMap());
			}else{
				participantVariableVW = this.workFlowOperationBL.searchParticipantVariableVW(psdid,roleid);
			}
			dto.setParticipantVariableVWList(participantVariableVW);
			//�����߿��Ӱ�ťȡ��
			List<IG309Info> lst_ParticipantVisibleButtonVWInfo =
					this.workFlowDefinitionBL.searchVisibleButton(dto.getPsdid(), roleid);
			
			dto.setLst_ParticipantVisibleButtonVWInfo(lst_ParticipantVisibleButtonVWInfo);
		} else {
			if(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y.equals(dto.getIsFormGlobalControl())){
				dto.setParticipantVariableVWList(this.workFlowOperationBL.searchParticipantMaxVariableVW(psdid, roleid,dto.getLs_proStatusParticipantMap()));
			}else{
				dto = getNotCurrentFormAccessPower(dto);
			}
		}

		log.debug("========��ѯ��Ӧ�����̲����ߵĶ���������Ȩ�޴�������========");
		return dto;
	}
	
	/**
	 * ����״̬��ֵ��ʼ������
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	@SuppressWarnings("unchecked")
	private IGPRR01DTO searchProcessVariableAction(IGPRR01DTO dto) throws BLException {
		log.debug("========����״̬��ֵ��ʼ������ʼ========");
		//ȡ�ø�����״̬��ǰ�������Ϣ����
		IG373SearchCondImpl cond = new IG373SearchCondImpl();
		cond.setPsdid(dto.getPsdid());
		List<IG373Info> lst_IG373 = this.workFlowDefinitionBL.searchInitFormEventHandler(cond);
		//����״̬��ֵ��ʼ������BL
		WorkFlowInitFormHandlerBL initBL = null;
		Map<String, Object> map_Value = null;
		if(lst_IG373.size() > 0) {
		    String strPrserialnum = "";
		    if (igflowlog.isDebugEnabled()) {
		        if (dto.getProcessStatusDef() != null) {
		            strPrserialnum = dto.getProcess().getPrserialnum();
		        }
		    }
		    igflowlog.debug("========================" + strPrserialnum  + "����ʼ���¼���ʼ========================");
		    igflowlog.debug("��������ID��"+dto.getWorkFlowParameterInfo().getPdid());
		    igflowlog.debug("����״̬��"+(dto.getProcessStatusDef() == null ? "����(Z)" : dto.getProcessStatusDef().getPsdname()));
            igflowlog.debug("����ID��"+dto.getWorkFlowParameterInfo().getParprid());
            igflowlog.debug("�ʲ�ID��"+dto.getWorkFlowParameterInfo().getEiid());
            igflowlog.debug("������"+dto.getWorkFlowParameterInfo().getParameters());
			for(IG373Info ig373 : lst_IG373) {
				try {
					initBL = (WorkFlowInitFormHandlerBL)WebApplicationSupport.getBean(ig373.getPiidblid());
				} catch (Exception e) {
					throw new BLException("IGCO10000.E004", "����ʼ���¼�����");
				}
				igflowlog.debug("����BL:" +ig373.getPiidblid());
				map_Value = initBL.initForm(dto.getWorkFlowParameterInfo());
			}
			igflowlog.debug("========================" + strPrserialnum  + "����ʼ���¼�����========================");
		}
		Map<String, Object> initTableFormValueMap = new HashMap<String, Object>();
		if(map_Value != null){
			//ȡ�ñ��ʽ���Ķ�����Ϣ
			Map<String, List<IG007Info>> columnInfoMap = dto.getColumnInfoMap();
			Map<String, IG007Info> fullNameMap = new HashMap<String, IG007Info>();
			if(columnInfoMap != null){
				Map<String, IG007Info> pidMap = new HashMap<String, IG007Info>();
				Set<Entry<String,List<IG007Info>>> entrySet = columnInfoMap.entrySet();
				for(Iterator<Entry<String, List<IG007Info>>> iterator = entrySet.iterator();iterator.hasNext();){
					Entry<String, List<IG007Info>> entry = iterator.next();
					List<IG007Info> list = entry.getValue();
					if(list != null){
						for(IG007Info pid:list){
							pidMap.put(pid.getPidid(), pid);
						}
					}
				}
				for(Iterator<Entry<String, List<IG007Info>>> iterator = entrySet.iterator();iterator.hasNext();){
					Entry<String, List<IG007Info>> entry = iterator.next();
					List<IG007Info> list = entry.getValue();
					if(list != null){
						for(IG007Info pid:list){
							IG007Info cpid = pid;
							String fullName = cpid.getPidname();
							while(StringUtils.isNotEmpty(cpid.getPpidid())){
								cpid = pidMap.get(cpid.getPpidid());
								fullName = cpid.getPidname() + "#" + fullName;
							}
							fullNameMap.put(fullName, pid);
						}
					}
				}
			}
			Set<Entry<String, Object>> set = map_Value.entrySet();
			for(Iterator<Entry<String, Object>> iter = set.iterator();iter.hasNext();){
				Entry<String, Object> entry = iter.next();
				Object value = entry.getValue();
				if(value != null){
					if(value instanceof java.util.List){
						List<TableFormColumnValueInfo> initTableValueInfos = (List<TableFormColumnValueInfo>) value;
						if(initTableValueInfos != null){
							List<IG898Info> tableColumnValueList = new ArrayList<IG898Info>(initTableValueInfos.size());
							for(TableFormColumnValueInfo tv:initTableValueInfos){
								IG007Info pid = fullNameMap.get(tv.getFullName());
								if(pid != null){
									IG898TB pv = new IG898TB();
									pv.setPvrownumber(tv.getRownumber());
									pv.setPvalue(tv.getValue());
									pv.setPidid(pid.getPpidid());
									pv.setPvcolpidid(pid.getPidid());
									tableColumnValueList.add(pv);
								}
								
							}
							Map<String, Map<String, Map<String, String>>> valueMap = new HashMap<String, Map<String,Map<String,String>>>();
							for(IG898Info pv:tableColumnValueList){
								if(valueMap.get(pv.getPidid()) == null){
									Map<String, String> one = new HashMap<String, String>();
									one.put(pv.getPvcolpidid(), pv.getPvalue());
									Map<String, Map<String, String>> two = new LinkedHashMap<String, Map<String,String>>();
									two.put(pv.getPvrownumber(), one);
									valueMap.put(pv.getPidid(), two);
								}else{
									if(valueMap.get(pv.getPidid()).get(pv.getPvrownumber()) == null){
										Map<String, String> one = new HashMap<String, String>();
										one.put(pv.getPvcolpidid(), pv.getPvalue());
										valueMap.get(pv.getPidid()).put(pv.getPvrownumber(), one);
									}else{
										valueMap.get(pv.getPidid()).get(pv.getPvrownumber()).put(pv.getPvcolpidid(), pv.getPvalue());
									}
								}
							}
							initTableFormValueMap.put(entry.getKey(), valueMap);
						}
					}else{
						initTableFormValueMap.put(entry.getKey(), value);
					}
				}
			}
		}
		dto.setInitFormValueMap(initTableFormValueMap);
		log.debug("========����״̬��ֵ��ʼ����������========");
		return dto;
	}
	
	/**
	 * ȡ�����߱���Ȩ����Ϣ������ǰ���������Ϣ���ϵĽ���,�����е�Ԫ��Ҫ����ǰ�����жԱ��������ý��и�ֵ
	 */
	private IGPRR01DTO setVarAccess(List<IG007Info> processInfoDefList,IGPRR01DTO dto) throws BLException {
		List<IG007Info> varList = new ArrayList<IG007Info>();//��������Ȩ�ޱ��������Ϣ�Ľ���
		List<IG007Info> notinvarList = new ArrayList<IG007Info>();//���治������Ȩ�ޱ����еı���Ϣ
		if(processInfoDefList!=null){
			List<IG893Info> participantVariableVWList = dto.getParticipantVariableVWList();
			for(int i=0,j=processInfoDefList.size();i<j;i++){
				IG007TB pid = (IG007TB)SerializationUtils.clone(processInfoDefList.get(i));
				boolean flag = true;
				if(participantVariableVWList != null){
					for(int n=0,m = participantVariableVWList.size();n<m;n++){
						IG893Info pipd = participantVariableVWList.get(n);
						//�жϱ���Ϣ�Ƿ������̲�����Ȩ�ޱ���������
						if(pid.getPidid().equals(pipd.getPidid())){
							pid.setPidaccess(pipd.getPidaccess());
							pid.setPidrequired(pipd.getPidrequired());
							//add by wanglongyu 20120406 ��������˽�б���Ȩ��
							//pid.setPrivateaccess(pipd.getPrivateAccess());
							varList.add(pid);
							flag = false;
							break;
						}
					}
				}
				if(flag){
					pid.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE);
					//add by wanglongyu 20120406 ��������˽�б���Ȩ��
					//pid.setPrivateaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_HIDE);
					notinvarList.add(pid);
				}
			}
		}
		

		dto.setVarList(varList);
		dto.setNotinvarList(notinvarList);
		return dto;
	}
	
	/**
	 * ��varList��notinvarList��ǰ����ı�����Ϣ���ϱȽϣ���������ǰ���������Ϣ�����еı�������ǰ�����е����ý��и�ֵ
	 */
	private IGPRR01DTO setVarValue(IGPRR01DTO dto) throws BLException {
		List<IG007Info> varList = dto.getVarList();//��������Ȩ�ޱ��������Ϣ�Ľ���
		List<IG007Info> notinvarList = dto.getNotinvarList();//���治������Ȩ�ޱ����еı���Ϣ
		Map<String, Object> initFormValueMap = dto.getInitFormValueMap(); //����ʼ�������еı�ֵ
		Map<String, IG007Info> variableObjectmap = new LinkedHashMap<String, IG007Info>();
		if(varList!=null){
			for(IG007Info pidInfo:varList){
				IG007TB pid = (IG007TB)SerializationUtils.clone(pidInfo);
				if(initFormValueMap != null && initFormValueMap.get(pid.getPidname()) != null){
					if("8".equals(pid.getPidtype())){
						setTableColumnValue(dto,initFormValueMap.get(pid.getPidname()));
					}else{
						String value = (String) initFormValueMap.get(pid.getPidname());
						pid.setPidvalue(value);
					}
				}
				variableObjectmap.put(pid.getPidid(), pid);
			}
		}
		
		if(notinvarList!=null){
			for(IG007Info pidInfo:notinvarList){
				IG007TB pid = (IG007TB)SerializationUtils.clone(pidInfo);
				if(initFormValueMap != null && initFormValueMap.get(pid.getPidname()) != null){
					if("8".equals(pid.getPidtype())){
						setTableColumnValue(dto,initFormValueMap.get(pid.getPidname()));
					}else{
						String value = (String) initFormValueMap.get(pid.getPidname());
						pid.setPidvalue(value);
					}
				}
				variableObjectmap.put(pid.getPidid(), pid);
			}
		}

		dto.setProcessInfoDefmap(variableObjectmap);
		return dto;
	}
	
	/**
	 * ���ñ��ʽ��ֵ
	 * @param dto
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private IGPRR01DTO setTableColumnValue(IGPRR01DTO dto,Object value){
		Map<String, Map<String, Map<String, String>>> tableColumnValueMap = dto.getTableColumnValueMap();
		if(value != null && value instanceof java.util.Map){
			Map<String, Map<String, Map<String, String>>> valueMap = (Map<String, Map<String, Map<String, String>>>) value;
			if(tableColumnValueMap == null || tableColumnValueMap.size() == 0){
				tableColumnValueMap = valueMap;
			}else{
				Set<Entry<String, Map<String, Map<String, String>>>> set = valueMap.entrySet();
				for(Iterator<Entry<String, Map<String, Map<String, String>>>> iter = set.iterator();iter.hasNext();){
					Entry<String, Map<String, Map<String, String>>> next = iter.next();
					String key = next.getKey();
					Map<String, Map<String, String>> map = next.getValue();
					if(tableColumnValueMap.get(key) == null){
						tableColumnValueMap.put(key, map);
					}else{
						Set<Entry<String,Map<String,String>>> set2 = map.entrySet();
						for(Iterator<Entry<String, Map<String, String>>> iter2 = set2.iterator();iter2.hasNext();){
							Entry<String, Map<String, String>> next2 = iter2.next();
							String key2 = next2.getKey();
							Map<String, String> map2 = next2.getValue();
							if(tableColumnValueMap.get(key).get(key2) == null){
								tableColumnValueMap.get(key).put(key2, map2);
							}else{
								Set<Entry<String,String>> set3 = map2.entrySet();
								for(Iterator<Entry<String, String>> iter3 = set3.iterator();iter3.hasNext();){
									Entry<String, String> next3 = iter3.next();
									String key3 = next3.getKey();
									String value3 = next3.getValue();
									tableColumnValueMap.get(key).get(key2).put(key3, value3);
								}
							}
						}
					}
				}
			}
			dto.setTableColumnValueMap(tableColumnValueMap);
		}
		return dto;
	}
	
	
	/**
	 * ҳ���ʼ����ȷ���ò�������ҳ���п��Խ��еĲ���
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO getActionListForInit(IGPRR01DTO dto) throws BLException {
		log.debug("=======ҳ���ʼ������ʼ========");
		String pdid = dto.getPdid();//���̶���ID
		//��ѯ������������
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
		
		dto.getIgPRR0101Form().setPrpdname(pd.getPdname());
		
		//��ǰ���̶����Ƿ�Ϊ����״̬
		if(pd!=null && IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(pd.getPdstatus())){
			dto.getIgPRR0101Form().setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
		}
		
		//���ݲ����˽�ɫID������״̬�Ȳ�ѯ��Ӧ�����̲����ߵĶ���������Ȩ�޵������Ϣ
		dto = searchProcessParticipantDefByRoleAndProcessStatusAction(dto);
		//��ѯָ��״̬ǰ���������Ϣ����
		dto = searchProcessVariableAction(dto);
		//��ѯ����Ϣ����
		List<IG007Info> processInfoDefList  = workFlowOperationBL.getProcessInfoDefs(pdid);
		//ȡ�����߱���Ȩ����Ϣ������ǰ�������б����Ľ���,�����е�Ԫ��Ҫ������ǰ����ѡ�еı�����ֵ
		dto = setVarAccess(processInfoDefList,dto);
		//��varList��notinvarList��ǰ����ı������ϱȽϣ���������ǰ�����еı�������ǰ���������õ�ֵ���и�ֵ(���ñ���ֵ)
		dto = setVarValue(dto);
		
		log.debug("========ҳ���ʼ����������========");
		return dto;
	}
	
	/**
	 * ���̷���ҳ���ʼ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0101Action(IGPRR01DTO dto) throws BLException {
		//��ȡ����form
		IGPRR0101Form form = dto.getIgPRR0101Form();
		//��ȡ�û�
		User user = dto.getUser();
		//��ȡ�����ɫ�б�
		searchInitProcessParticipantRoleAction(dto);
		searchProcessTitleDef(dto);
		//�趨���̻�����Ϣ
		String orgname = "";
		form.setPrinfo(user.getUsermobile());
		form.setPruserid(user.getUserid());
		form.setPrusername(user.getUsername());
		form.setProrgid(user.getOrgid());
		//��ʼ��������
		dto.setColumnInfoMap(workFlowOperationBL.initTableFormAction(dto.getPdid()));
		//��ѯ��һ������ 
		if(user.getOrgid().length()>4){
			String orgpar = user.getOrgid().subSequence(0, user.getOrgid().length()-3).toString();
			OrganizationSearchCondImpl condImpl = new OrganizationSearchCondImpl();
			condImpl.setOrgsyscoding(orgpar);
			List<Organization> searchOrganization = organizationBL.searchOrganization(condImpl);
			if(searchOrganization !=null && searchOrganization.size()>0){
				orgname = searchOrganization.get(0).getOrgname()+"��"+user.getOrgname();
			}
			
		}else{
			orgname = user.getOrgname();
		}
		form.setProrgname(orgname);
		//�趨����״̬ID
		IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
		psdcond.setPdid(dto.getPdid());
		psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
		psdcond.setFatherflag("Y");
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
		if(psdList.isEmpty()){
			throw new BLException("IGFLOW0000.E001","״̬������Ϣ");
		}else if(psdList.size() > 1){
			throw new BLException("IGFLOW0000.E002","״̬������Ϣ");
		}
		dto.setProcessStatusDef(psdList.get(0));
		dto.setPsdid(psdList.get(0).getPsdid());
		form.setPsdid(dto.getPsdid());
		//��ȡ����ť�б�
		getActionListForInit(dto);
		//��ȡ���������б�ֵ
		getOrgLabelValueBeans(dto);
		//��ȡ״̬��˽�б�ֵ
		getStatusPrivateValue(dto);
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �������� 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public synchronized IGPRR01DTO createProcessAction(IGPRR01DTO dto) throws BLException {
		log.debug("========���̷�����ʼ========");
		// ���̷���Form
		IGPRR0101Form form = dto.getIgPRR0101Form();
		User user = dto.getUser();
		//��ѯ���̱�����
		List<IG007Info> prinfoDefList = workFlowDefinitionBL.searchProcessInfoDefsByPdid(form.getPrpdid());
		Map<String, IG007Info> prinfoMap = new HashMap<String, IG007Info>();
		for(IG007Info info : prinfoDefList){
			prinfoMap.put(info.getPidid(), info);
		}
		//������̱�����Ϣ
		List<IG599Info> prInfoList = new ArrayList<IG599Info>();	
		// ����Ӧ���ʲ�MAP
		if(form.getPivarvalue() != null){
			for(int i=0;i<form.getPivarvalue().length;i++){
				IG599TB prInfo = workFlowOperationBL.getProcessInfoTBInstance();
				prInfo.setPivarlabel(form.getPivarlabel()[i]);
				prInfo.setPivarname(form.getPivarname()[i]);
				prInfo.setPivartype(form.getPivartype()[i]);
				prInfo.setPivarvalue(form.getPivarvalue()[i]);
				prInfo.setPidid(form.getPidid()[i]);
				prInfo.setPidmode(form.getPidmode()[i]);
				prInfo.setPidaccess(form.getPidaccess()[i]);
				prInfo.setPrivatescope(form.getPrivatescope()[i]);
				if(form.getPidcomment() != null && form.getPidcomment().length > i){
					prInfo.setPidcomment(form.getPidcomment()[i]);
				}
				if("F".equals(form.getPivartype()[i])){
					IG007Info def = prinfoMap.get(form.getPidid()[i]);
					if(StringUtils.isNotEmpty(def.getPiddefault())){
						List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(def.getPiddefault());
						List<Attachment> attList = new ArrayList<Attachment>();
						for(Attachment att:list){
							boolean flag = true;
							if(StringUtils.isNotEmpty(form.getDelFileMutiStr())){
								for(String defFile:form.getDelFileMutiStr().split("#")){
									if((att.getAttid() + "").equals(defFile.split("_")[0])){
										flag = false;
										break;
									}
								}
							}
							if(flag){
								attList.add(att);
							}
						}
						if(attList.size() > 0){
							String key = IGStringUtils.getAttKey();
							for(Attachment att:attList){
								StringBuffer rfilename = new StringBuffer();
								rfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
								rfilename.append(File.separator);
								rfilename.append(att.getAtturl());
								rfilename.append(File.separator);
								rfilename.append(att.getAttname());
								StringBuffer cfilename = new StringBuffer();
								cfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
								cfilename.append(File.separator);
								cfilename.append(att.getAtturl());
								cfilename.append(File.separator);
								cfilename.append(key);
								cfilename.append("_");
								cfilename.append(att.getAttname().substring(att.getAttname().indexOf("_") + 1));
								try{
									FileUtils.copyFile(new File(rfilename.toString()), new File(cfilename.toString()));
								}catch (Exception e) {
									log.error("",e);
								}
								AttachmentTB attTB = new AttachmentTB();
								attTB.setAttkey(key);
								attTB.setAttname(key + "_" + att.getAttname().substring(att.getAttname().indexOf("_") + 1));
								attTB.setAtturl(att.getAtturl());
								attachmentBL.registAttachment(attTB);
							}
							prInfo.setPiattkey(key);
						}
					}
				}
				if("4".equals(form.getPivartype()[i])){
					IG007Info def = prinfoMap.get(form.getPidid()[i]);
					if(StringUtils.isNotEmpty(def.getPiddefault())){
						String pieids = form.getPieids();
						Set<String> set = new HashSet<String>();
						if(StringUtils.isNotEmpty(pieids)){
							for(String s:pieids.split("#")){
								set.add(s.replaceAll("EIID", ""));
							}
						}
						String eiids = def.getPiddefault();
						Map<Integer, String> map = form.getEntityMap();
						int index = 0;
						for(Integer n:map.keySet()){
							if(n>index){
								index = n;
							}
						}
						for(String s:eiids.split("#")){
							if(!set.contains(s)){
								index ++;
								map.put(index, prInfo.getPidid()+"#"+s+"#"+"1");
							}
						}
						form.setEntityMap(map);
					}
				}
				prInfoList.add(prInfo);
			}
		}
		
		//���󶨸���MAP����================================================================
		Map<String,FormFile> fileMapMuti=new LinkedHashMap<String,FormFile>();
		if((form.getAtt() != null) &&(form.getFileMapMuti() != null)){
			for(int i=0;i<form.getAtt().length;i++){
				String[] sp=(form.getAtt())[i].split("_");
				if(form.getFileMapMuti().get(Integer.parseInt(sp[1]))!=null){
				fileMapMuti.put((form.getAtt())[i], form.getFileMapMuti().get(Integer.parseInt(sp[1])));
				}
			}
		}	
		Map<String,List<Attachment>> copyMap=new LinkedHashMap<String,List<Attachment>>();
		
		//��װ���ʽ��ֵ��Ϣ
		Map<String, Object> tableFormValueMap = new HashMap<String, Object>();
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_VALUE, form.getColumn_value());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_ROWNUMBER, form.getColumn_rownumber());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_PIDID, form.getColumn_pidid());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE, form.getFileMapTable());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_ADD_FLAG, form.getAddTableColumnFileStr());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_DELETE_FLAG, form.getDelTableColumnFileStr());
		//��װ��Ա����Ϣ
		Map<String, List<IG506TB>> participantFormInfo = packingParticipantList(form.getPar_userid(), form.getPar_username(), form.getPar_orgid(), form.getPar_orgname(), form.getPar_roleid(), form.getPar_rolename(), form.getPar_pidid(),form.getPar_phone());
		IG500Info processRecord = workFlowOperationBL.launchProcess(form,user,form.getPrroleid(),form.getFileMap(),fileMapMuti,form.getPts(),
				prInfoList,form.getRlcomment(),form.getPsdid(),form.getAction(),copyMap, dto.getAuthorizeuser(),form.getEntityMap(),tableFormValueMap,participantFormInfo,form.getIsServiceStart(),form.getParprid());
		dto.setProcess(processRecord);
		// ������̼�¼ID
		Integer prid = processRecord.getPrid();
		dto.setPrid(prid);
		
		if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(processRecord.getPrstatus())) {
			//��ѯ��״̬�ɽ��з��ɵĽڵ��б�
			List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAssignedStatusDef(form.getPsdid(),form.getAction());
			if((lst_ProcessStatusDef!=null) && (lst_ProcessStatusDef.size()>0)) {
				dto.setAssignParticipant(false);
			}
		}
		if(form.getAction() != null && form.getAction().compareTo("10") >= 0){
			dto.addMessage(new ActionMessage("IGPRR0101.I001"));
		}else{
			dto.addMessage(new ActionMessage("IGPRR0101.I002"));
		}
		log.debug("========���̷���������========");
		return dto;
	}

	
	//======================================����==================================================

	/**
	 * �Ƚ�ʱ��
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	private String getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		// long time= 24L * 60L * 60L * 1000L;��������֮��
		Date d1 = sdf.parse(timeA);
		Date d2 = sdf.parse(timeB);
		return df.format((d2.getTime() - d1.getTime()) / hours).replace(".0", "");
	}
	
	/**
	 * <p>
	 * Description: ��ȡ����������Ϣ
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	
	public IGPRR01DTO getProcessRecord(IGPRR01DTO dto) throws BLException {
		log.debug("========��ȡ����������Ϣ����ʼ========");
		IG500SearchCondImpl prCond = new IG500SearchCondImpl();
		prCond.setPrid(dto.getPrid());
		prCond.setPrserialnum(dto.getSerialNum());
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prCond);
		IG500Info process = prList.get(0);
		IGPRR0102Form form = dto.getIgPRR0102Form();
		if(form == null){
			form = new IGPRR0102Form();
		}
		form.setPrid(process.getPrid());
		dto.setPrid(process.getPrid());
//		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
	    List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(process.getPrid());
	
		//��ȡ��ǰ������������ʲ�����̬�ʲ�����Ϣ
		List<IG731Info> processInfoEntityList = workFlowOperationBL.searchProcessInfoEntityByPrid(process.getPrid());
		dto.setProcessInfoEntityList(processInfoEntityList);
		dto.setProcessInfo(processInfolist);
		
		Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
		for(int i=0;i<processInfolist.size();i++){
			if(processInfolist.get(i).getPiattkey()!=null){
				//recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(prid);
				List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
				map.put(processInfolist.get(i).getPivarname(), list);
			}
			//˽�б�������
			List<IG899TB> privateInfoList = processInfolist.get(i).getProcessPrivateInfofList();
			if(privateInfoList != null){
				for(int j=0; j<privateInfoList.size();j++){
					if(privateInfoList.get(j).getPpiattkey()!=null){
						List<Attachment> listPrivate = workFlowOperationBL.searchProcessInofAtt(privateInfoList.get(j).getPpiattkey());
						if(StringUtils.isEmpty(privateInfoList.get(j).getUserid())){
							map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getRoleid(), listPrivate);
						}else{
							map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getUserid(), listPrivate);
						}
					}
				}
			}
//		recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
		}
		dto.setTextAreaMap(map);
		dto.setPdid(process.getPrpdid());
		dto.setProcess(process);
		
		//�������趨��ǰ����״̬��Ӧ��psdid
		//���ҵ�ǰ��������״̬��ID
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(process.getPrpdid());
		//��ֹ״̬��ͬ�ڹر�
		if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(process.getPrstatus())
				||IGPRDCONSTANTS.PROCESS_END_STATUS.equals(process.getPrstatus()) ) {
			cond.setPsdcode(IGPRDCONSTANTS.PROCESS_END_STATUS);
		} else {
			//ҳ��ûָ��״̬ʱ��Ĭ��ȡ��һ����ǰ״̬
			if(dto.getIgPRR0102Form() == null || StringUtils.isEmpty(dto.getIgPRR0102Form().getPrstatus())) {
				List<String>  lst_status = this.workFlowOperationBL.searchCurrentRecordStatus(process.getPrid());
				if(lst_status.isEmpty()) {
					cond.setPsdcode(process.getPrstatus());
				} else {
					String psdid_num = this.workFlowOperationBL.searchCurrentRecordStatus(process.getPrid()).get(0);
					if (psdid_num.indexOf("_") > -1) {
						cond.setPsdid(psdid_num.split("_")[0]);
					} else {
						cond.setPsdid(psdid_num);
					}
				}
			} else {
				//ҳ��ָ����״̬
				String psdid_num = dto.getIgPRR0102Form().getPrstatus();
				if (psdid_num.length() == 1) {
					cond.setPsdcode(psdid_num);
				} else if (psdid_num.indexOf("_") > -1) {
					cond.setPsdid(psdid_num.split("_")[0]);
				} else {
					cond.setPsdid(psdid_num);
				}
//				cond.setPsdid(dto.getIgPRR0102Form().getPrstatus());
			}
		}
		List<IG333Info> pslist = this.workFlowDefinitionBL.searchProcessStatusDef(cond);
		if(pslist!=null && pslist.size()==1){
			dto.setPsdid(pslist.get(0).getPsdid());
		}
		
		log.debug("========��ȡ����������Ϣ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ȡָ��״̬�Ĳ�����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGPRR01DTO getProcessParticipantsByStatus(IGPRR01DTO dto) throws BLException {
		log.debug("========��ȡָ��״̬�Ĳ����ߴ���ʼ========");
		String status = dto.getStatus();

		List<IG337Info> pplist = new ArrayList<IG337Info>();
		if (status == null) {
			pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(), dto.getProcess().getPrstatus());
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(dto.getPrid());
			if (dto.getStatus().indexOf("_") > -1) {
				ppCond.setPsdid(dto.getStatus().split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(dto.getStatus().split("_")[1]));
			} else {
				ppCond.setPsdid(dto.getStatus());
			}
			pplist = workFlowOperationBL.searchProcessParticipants(ppCond);
		}
		
		if(pplist.isEmpty() && !"C".equals(status)){
			//throw new BLException("IGCO10000.E004","�����߻���");
			dto.setStatus("");
		} else {
			//״̬�����ߴ���
			dto = this.getProcessParticipants(dto,pplist);
		}
		log.debug("========��ȡָ��״̬�Ĳ����ߴ�������========");
		return dto;
	}
	private IGPRR01DTO getProcessParticipants(IGPRR01DTO dto,List<IG337Info> pplist ) {
		// ��ִ�����б�
		List<IG337Info> l1 = new ArrayList<IG337Info>();
		// δִ�����б�
		List<IG337Info> l2 = new ArrayList<IG337Info>();
		// ��ִ����Ա����
		Map<String, List<IG337Info>> m1 = new LinkedHashMap<String, List<IG337Info>>();
		// δִ����Ա����
		Map<String, List<IG337Info>> m2 = new LinkedHashMap<String, List<IG337Info>>();
		// ������Ա�ʹ�
		String comment = "";
		comment = this.appendLogTitleCssBegin(comment);
		// ��ִ�����ͷ���
		for (IG337Info pp : pplist) {
			// δִ�����б��ʼ��
			if (StringUtils.isEmpty(pp.getPpproctime())) {
				l2.add(pp);
			}
			// ��ִ�����б��ʼ��
			if (!StringUtils.isEmpty(pp.getPpproctime())) {
				l1.add(pp);
			}

			
			//====>130225Begin �жϵ�ǰ����������Ƿ����δ��Ȩֵ����
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getPsdassign())){
				if(StringUtils.isEmpty(pp.getPpproctime()) && pp.getPporgid().equals(dto.getPporgid())
						&& IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
						&& !IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp
								.getPpsubstatus())){
					dto.setHasDutyPerson(true);
				}
			}else{
			//====>130225End	
				// �жϵ�ǰ�����ɫ�Ƿ����δ��Ȩֵ����
				if (pp.getPproleid().equals(dto.getRoleid())
						&& IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
						&& !IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp
								.getPpsubstatus())) {
					dto.setHasDutyPerson(true);
				}
			}

		}
		
		//====>130225Begin ҳ����ʾ�������޸�
		if(dto.getProcessStatusDef()!= null){
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
				// ����ִ����Ա�����ŷ���
				for (IG337Info pp : l1) {
					if (m1.get(pp.getPporgname()) == null) {
						// �ò��Ų�����ʱ�Ĳ���
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m1.put(pp.getPporgname(), l);

					} else {
						// �ò����Ѵ���ʱ�Ĳ���
						m1.get(pp.getPporgname()).add(pp);
					}
				}
				// ��δִ����Ա�����ŷ���
				for (IG337Info pp : l2) {

					if (m2.get(pp.getPporgname()) == null) {
						// �ò��Ų�����ʱ�Ĳ�
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m2.put(pp.getPporgname(), l);

					} else {
						// �ò����Ѵ���ʱ�Ĳ���
						m2.get(pp.getPporgname()).add(pp);
					}
				}
			}else{
				// ����ִ����Ա�����ŷ���
				for (IG337Info pp : l1) {

					if (m1.get(pp.getPprolename()) == null) {
						// �ò��Ų�����ʱ�Ĳ���
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m1.put(pp.getPprolename(), l);

					} else {
						// �ò����Ѵ���ʱ�Ĳ���
						m1.get(pp.getPprolename()).add(pp);
					}
				}
				// ��δִ����Ա�����ŷ���
				for (IG337Info pp : l2) {

					if (m2.get(pp.getPprolename()) == null) {
						// �ò��Ų�����ʱ�Ĳ�
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m2.put(pp.getPprolename(), l);

					} else {
						// �ò����Ѵ���ʱ�Ĳ���
						m2.get(pp.getPprolename()).add(pp);
					}
				}
			}
		}
		//====>130225End

		// ����ִ����Ա�����ַ���ƴ��
		if (null != m1 && m1.size() > 0) {
			// ��ִ�д����˲�Ϊ��ʱ����
			comment = "�Ѵ���";
			for (String org : m1.keySet()) {

				// List<ProcessParticipant> res = m1.get(org);
				comment = comment + org + "��";
				for (IG337Info pp : m1.get(org)) {
					String name = StringUtils.isEmpty(pp.getPpusername()) ? "δָ��":pp.getPpusername();
					comment = comment + name + "��";
				}
				// ��ƴ��ʱ����ı�㶪������
				comment = comment.substring(0, comment.length() - 1);
				comment = comment + "��,";

			}
			// ��ƴ��ʱ����ı�㶪������
			comment = comment.substring(0, comment.length() - 1);
		}
		// ��δִ����Ա�����ַ���ƴ��
		comment = comment + "</br>δ����";
		if (null != m2 && m2.size() > 0) {
			// δִ�д����˲�Ϊ��ʱ�Ĵ���
			for (String org : m2.keySet()) {

				comment = comment + org + "��";
				for (IG337Info pp : m2.get(org)) {
					String name = StringUtils.isEmpty(pp.getPpusername()) ? "δָ��":pp.getPpusername();
					comment = comment + name + "��";
				}
				// ��ƴ��ʱ����ı�㶪������
				comment = comment.substring(0, comment.length() - 1);
				comment = comment + "��,";

			}
			// ��ƴ��ʱ����ı�㶪������
			comment = comment.substring(0, comment.length() - 1);
		}
		comment = comment.replace("��null��", "��δָ����") + "</span>";

		dto.setStatus(comment.replaceAll(",", "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
		return dto;
	}
	/**
	 * <p>
	 * ��¼��־����ʽ��ƴ�ӿ�ʼ����ʱ�Ǽ�¼��Ա��Ϣʱ����
	 * </p>
	 * 
	 * @param massage ��־������Ϣ
	 * @return ����HTML��ǩ����־������Ϣ
	 */

	private String appendLogTitleCssBegin(String massage) {
		return massage + "<span>";
	}
	/**
	 * <p>
	 * ��¼��Ա��־����ƴ�ӣ���ʱ��¼��Ա��Ϣʱ����
	 * </p>
	 * 
	 * @param rolename ��ɫ����
	 * @param username �û�����
	 * @return ����HTML��ǩ����־������Ϣ����", "��β����ȥ��ĩβ����λ
	 */

	@SuppressWarnings("unused")
	private String appendLogContent(String rolename, String username) {
		String str ="";
		if("�Ѵ���".equals(username)||"δ����".equals(username)){
			str = rolename+ "(" + username + ")"+ ", ";
		}else{
			str = rolename+ (StringUtils.isEmpty(username) ? ", " : "(" + username + ")"+ ", ");
			
		}
		return str;
	}
	/**
	 * <p>
	 * ��¼��־����ʽ��ƴ�ӽ�������ʱ�Ǽ�¼��Ա��Ϣʱ����
	 * </p>
	 * 
	 * @param massage ��־������Ϣ
	 * @return ����HTML��ǩ����־������Ϣ
	 */

	@SuppressWarnings("unused")
	private String appendLogTitleCssEnd(String massage) {
		massage=massage.substring(0, massage.length() - 2);
		return massage + "</span>";
	}
	
	/**
	 * <p>
	 * Description: ��ȡ����־��¼
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getVarRecordLogs(IGPRR01DTO dto) throws BLException {
		
		List<IG113Info> list = workFlowOperationBL.searchRecordLogVarInfoByRecordId(dto.getRlid());
		
		dto.setVarLogList(list);
		
		return dto;
	}

	/**
	 * <p>
	 * Description: ��ȡ��ʷ��¼ 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getRecordLogs(IGPRR01DTO dto) throws BLException {
		log.debug("========��ȡ��ʷ��¼����ʼ========");
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","��������");
		}
		//��������־
		String cl_tab = IGPRDCONSTANTS.RECORDLOG_TYPE_CL_NAME;
		
		//ϵͳ����־
		String xtrz_tab = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ_NAME;
		
		//<������־���ͣ�������־��Ϣ>
		Map<String,List<IG036Info>> map = new LinkedHashMap<String,List<IG036Info>>();
		
		List<IG036Info> recordLogList = null;
		//����������־Ȩ�޲�ѯ������־
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pr.getPrpdid());
		
		if(IGPRDCONSTANTS.RECORDLOG_PERMISSION_YES.equals(pd.getPermission())){
			//��Ȩ��
			recordLogList = this.getRecordLogsByUserRole(dto);
		}else{
			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
		}
		
		if(recordLogList!=null && recordLogList.size()>0){
			dto.setRecordLogList(recordLogList);
			for(IG036Info recordLog:recordLogList){
				//�ж�������־����
				if(IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(recordLog.getRltype())){
					//����
					setRecordLogMap(map,cl_tab,recordLog);
					dto.setHasCLRecord("1");
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_GX.equals(recordLog.getRltype())){
					//����
					setRecordLogMap(map,cl_tab,recordLog);			
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_SH.equals(recordLog.getRltype())){
					//���
					setRecordLogMap(map,cl_tab,recordLog);
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_TJ.equals(recordLog.getRltype())){
					//�ύ
					setRecordLogMap(map,cl_tab,recordLog);
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_ZZ.equals(recordLog.getRltype())){
					//��ֹ
					setRecordLogMap(map,cl_tab,recordLog);
				}
			}

			//��ϵͳ����־�ŵ����
			for(IG036Info recordLog:recordLogList){
				//�ж�������־����
				if(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(recordLog.getRltype())){
					//ϵͳ��־
					setRecordLogMap(map,xtrz_tab,recordLog);
				}
			}
			
			Set<Map.Entry<String,List<IG036Info>>> set = map.entrySet();
			for(Iterator<Map.Entry<String,List<IG036Info>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<String,List<IG036Info>> entry = iter.next();
				//req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
				if(entry.getKey().equals(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ_NAME)){
					continue;
				}
				List<IG036Info> rlist = entry.getValue();
				List<IG036Info> rnlist = new ArrayList<IG036Info>();
				for(IG036Info rl : rlist){
				String psname = "";
				String rolename = "";
					IG036TB rltb = (IG036TB)SerializationUtils.clone(rl);
					
					if(rolename.equals(rltb.getRlrolename())){
						rltb.setRlrolename("");
					}else
					{
						rolename = rltb.getRlrolename();
					}
					
					if(psname.equals(rltb.getPsname())){
						rltb.setPsname("");
					}else
					{
						psname = rltb.getPsname();
						rltb.setRlrolename(rolename);
					}
					
					rnlist.add(rltb);
				}
				map.put(entry.getKey(), rnlist);
			}
			
			
			dto.setRecordLogMap(map);
		}
		
		
		dto.setPdid(pr.getPrpdid());

		
		log.debug("========��ȡ��ʷ��¼��������========");
		return dto;
	}
	
	/**
	 * ����������־��Ϣ
	 * @param lmap
	 * @param type
	 * @param recordlog
	 * @param attlist
	 * @param name_list
	 * @throws BLException
	 */
	private void setRecordLogMap(Map<String,List<IG036Info>> map, String type, IG036Info recordlog) throws BLException {
		List<IG036Info> list = map.get(type);
		if(list!=null && !list.contains(recordlog)){
			list.add(recordlog);
		}else if(list==null){
			list = new ArrayList<IG036Info>();
			list.add(recordlog);
		}
		map.put(type, list);
		
	}
	
	/**
	 * �����û���ɫ��ȡ��־
	 * @param dto
	 */
	private List<IG036Info> getRecordLogsByUserRole(IGPRR01DTO dto) throws BLException{
		User user = dto.getUser();
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(user.getUserid());

		IG036SearchCondImpl recond =  new IG036SearchCondImpl();
		recond.setPrid(dto.getPrid());
		//���̹���Ա���Կ���ȫ����־��Ϣ
		if(!dto.isAdminRole()){

			List<Integer> roleidList = new ArrayList<Integer>();
			for(UserRoleInfo userrole:userroleList){
				roleidList.add(userrole.getRoleid());
			}
			
			recond.setRoleid(roleidList);
		}
		recond.setNotEqualrlType(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		//���ս�ɫ���Ͳ�ѯ��ϵͳ����־
		List<IG036Info> rlList = workFlowOperationBL.searchUserRoleRecondLog(recond);
		
		//��ѯϵͳ����־,ϵͳ����־������ɫ����
		IG036SearchCondImpl recond2 =  new IG036SearchCondImpl();
		recond2.setPrid(dto.getPrid());
		recond2.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		List<IG036Info> rlList2 = workFlowOperationBL.searchUserRoleRecondLog(recond2);

		rlList2.addAll(rlList);
		
		return rlList2;
	}
	
	/**
	 * <p>
	 * Description: ��������ID��ѯ�����˸����̵����̼�¼
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getProcessRecordByRelations(IGPRR01DTO dto) throws BLException{
		
		//��ѯ��ݷ�������̹�ϵ
		IG512SearchCondImpl prrCond = new IG512SearchCondImpl();
		prrCond.setParprid(dto.getPrid());
		List<IG512Info> processRecordRelationList = workFlowOperationBL.searchProcessRecordRelation(prrCond);//����
		prrCond.setParprid(null);
		prrCond.setCldprid(dto.getPrid());
		processRecordRelationList.addAll(workFlowOperationBL.searchProcessRecordRelation(prrCond));//����
		//������ʱ����������
		workFlowOperationBL.orderByTimeAsc(processRecordRelationList);
		
		dto.setLst_IG512Info(processRecordRelationList);
		
		return dto;
	}
	
	/**
	 *�鿴����_��ɫ��Ϣ��ѯ����
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchReadProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException {
		log.debug("========�鿴����_��ɫ��Ϣ��ѯ����ʼ========");
		// ��ǰ�û�ID
		String userid = dto.getUser().getUserid();
		
		// ���������Ȩ,��ѯʱ������Ȩ��Ȩ�޲�ѯ����
		if(dto.getAuthorizeuser() != null){
			userid = dto.getAuthorizeuser().getUserid();
		}
		
		IGPRR0102Form form = dto.getIgPRR0102Form();
		if(form.getPrid() == null && form.getPrid() == 0) {
			throw new BLException("IGCO10000.E004","��������");
		}
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		if(pr == null) {
			throw new BLException("IGCO10000.E004","��������");
		}
		
		//��ȡ��ǰ���̽ڵ�״̬��Ϣ
		dto.setProcessStatusDef(this.workFlowDefinitionBL.searchProcessStatusDefByKey(dto.getPsdid()));
		
		List<LabelValueBean> roleList = new ArrayList<LabelValueBean>();
		//���δ��������ɫ
		List<IG337Info> lst_ProcessParticipant = new ArrayList<IG337Info>();
		List<UserRoleInfo> userRoleList = userRoleBL.getUserRoles(userid);
		//�Ƿ����Ա
		for(UserRoleInfo ur : userRoleList) {
			if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(ur.getRoletype())) {
				dto.setAdminRole(true);
				break;
			}
		}
		//��ȡ�ɴ����ɫ
		List<IG337Info> ppList = new ArrayList<IG337Info>();
		if (dto.getStatus() == null) {
			ppList = workFlowOperationBL.searchProcessParticipantTodoRole(form.getPrid(), dto.getProcess().getPrstatus());
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(form.getPrid());
			ppCond.setPpproctimeIsNull("Y");
			if (dto.getStatus().indexOf("_") > -1) {
				ppCond.setPsdid(dto.getStatus().split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(dto.getStatus().split("_")[1]));
			} else {
				ppCond.setPsdid(dto.getStatus());
			}
			ppList = workFlowOperationBL.searchProcessParticipants(ppCond);
		}
		dto.setProcessParticipantList(ppList);
		List<Integer> doneRoleList = new ArrayList<Integer>();
		List<String> doneOrgList = new ArrayList<String>();
		//OA�ж��Ƿ���Ȩֵ���˻��ɫ���������ύ
		if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
			//��ȡ�Ѵ����ɫ
			List<IG337Info> ppDoneList = new ArrayList<IG337Info>();
			if (dto.getStatus() == null) {
				ppDoneList = workFlowOperationBL.searchProcessParticipantDoneRole(form.getPrid(), dto.getProcess().getPrstatus());
			} else {
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(form.getPrid());
				ppCond.setPpproctimeIsNull("N");
				if (dto.getStatus().indexOf("_") > -1) {
					ppCond.setPsdid(dto.getStatus().split("_")[0]);
					ppCond.setPsdnum(Integer.parseInt(dto.getStatus().split("_")[1]));
				} else {
					ppCond.setPsdid(dto.getStatus());
				}
				ppDoneList = workFlowOperationBL.searchProcessParticipants(ppCond);
			}
			
			//�жϲ����������Ƿ�Ϊ����
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
				for (IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) ||
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) ||
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
									&& IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						doneOrgList.add(pp.getPporgid());
					}
				}
			}else{
				for (IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) ||
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) ||
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
									&& IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						doneRoleList.add(pp.getPproleid());
					}
				}
			}
		}
		
		//�Ƿ���ʱ��ɫ�����ˣ���ʱ��ɫ������ֻ�����ύ�����ܸɱ��
		boolean tempRoleManager = true;
		
		for (IG337Info pp : ppList) {
			//====>130225Begin ���������¼�û���ͬʱ��ȡ��������������
			if(dto.getUser().getUserid().equals(pp.getPpuserid())){
				dto.setPporgid(pp.getPporgid());
			}
			//====>130225End
			for (UserRoleInfo ur : userRoleList) {
				if (pp.getPproleid().equals(ur.getRoleid())) {
					//OAģʽ��ƥ��USERID
					String rolename = ur.getRolename();
					if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
						if(StringUtils.isNotEmpty(pp.getPpuserid())) {
							if(pp.getPpuserid().equals(userid)) {
								if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager())) {
									rolename += "�������ˣ�";
								} else if(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
									rolename += "��ֵ���ˣ�";
								}
								//�жϲ����������Ƿ�Ϊ����
								if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
									if(!doneOrgList.contains(pp.getPporgid())){
										roleList.add(new LabelValueBean(rolename,String.valueOf(ur.getRoleid())));
										lst_ProcessParticipant.add(pp);
									}
								}else{
									if(!doneRoleList.contains(ur.getRoleid())) {
										roleList.add(new LabelValueBean(rolename ,String.valueOf(ur.getRoleid())));
										lst_ProcessParticipant.add(pp);
									}
								}
								if(tempRoleManager && IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager())) {
									tempRoleManager = false;
								}
							}
						}
					} else {
//						if(StringUtils.isEmpty(pp.getPpuserid()) || pp.getPpuserid().equals(userid)) {//֧�ִ��洦��
					        String username = pp.getPpusername();
							roleList.add(new LabelValueBean(rolename + "��"+ (StringUtils.isEmpty(username) ? "δָ��" : username) +"��", pp.getPpid() + "_" + ur.getRoleid() + "_" + (StringUtils.isEmpty(pp.getPpuserid()) ? userid : pp.getPpuserid())));
							lst_ProcessParticipant.add(pp);
//						}
					}
					break;
				}
			}
		}
		
		if(roleList.size() > 0 && dto.getRoleid() == null) {
			dto.setRoleid(Integer.parseInt(roleList.get(0).getValue().split("_")[1]));
			boolean flag = true;//�趨ָ����ɫ��Ӧ������
			for(IG337Info pp : lst_ProcessParticipant) {
				if(pp.getPproleid().equals(dto.getRoleid()) && userid.equals(pp.getPpuserid())) {//ƥ���û�
					dto.setProcessParticipant(pp);
					flag = false;
					break;
				}
			}
			if(flag){
				dto.setProcessParticipant(lst_ProcessParticipant.get(0));
			}
		} else {
			boolean flag = true;//�趨ָ����ɫ��Ӧ������
			for(IG337Info pp : lst_ProcessParticipant) {
				if(pp.getPproleid().equals(dto.getRoleid()) && userid.equals(pp.getPpuserid())) {//ƥ���û�
					dto.setProcessParticipant(pp);
					flag = false;
					break;
				}
			}
			if(flag) {
				for(IG337Info pp : lst_ProcessParticipant) {
					if(pp.getPproleid().equals(dto.getRoleid()) && StringUtils.isEmpty(pp.getPpuserid())) {//�û���ƥ����ƥ���ɫ
						dto.setProcessParticipant(pp);
						break;
					}
				}
			}
		}
		
		//����ǵ�ǰ�ڵ���OAģʽ����ִ����ֻ��ָ����ѡ�����ɫ���ˡ���OAģʽ����ָ���õ�¼�û�������ĸ����̴����ɫ����
		if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
			//����ʱ��ɫ��ɫ������
			if(tempRoleManager) {
				//�жϲ����������Ƿ�Ϊ����
				if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
					if(dto.getProcessParticipant() != null){
						//�ж��Ƿ��Ǹ�����
						if(IGPRDCONSTANTS.ROLEMANAGER.equals(dto.getProcessParticipant().getPprolemanager())){
							dto.setRoleManager(true);
						}
						//�ж��Ƿ���ֵ����
						if(IGPRDCONSTANTS.DUTYPERSON.equals(dto.getProcessParticipant().getPpdutyperson())){
							dto.setDutyPerson(true);
						}
					}
				}else{
					//�Ƿ���ѡ�����ɫ������
					dto.setRoleManager(this.userRoleBL.checkRoleManagerByID(userid, dto.getRoleid()));
					//�Ƿ���ѡ�����ɫֵ����
					dto.setDutyPerson(this.userRoleBL.checkRoleDutyflagByID(userid, dto.getRoleid()));
				}
			} else {
				form.setTempRoleManager(true);
			}
		} else {
			List<IG337Info> manager = workFlowOperationBL.queryRolemanager(userid, form.getPrid());
			if(!manager.isEmpty()) {
				dto.setRoleManager(true);
			}
		}
		dto.setLabelList(roleList);
		dto.setPdid(pr.getPrpdid());
		log.debug("========�鿴����_��ɫ��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ҳ���ʼ����ȷ���ò�������ҳ���п��Խ��еĲ���
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO getActionList(IGPRR01DTO dto) throws BLException {
		log.debug("=======ҳ���ʼ������ʼ========");
		Integer roleid = dto.getRoleid();//��ǰ�����ߵĽ�ɫID
		String pdid = dto.getPdid();//���̶���ID
		Integer prid = dto.getPrid();//����ID 
		if(prid != null && prid != 0) {
			IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
//			dto.setPsdcode(pr.getPrstatus());
			dto.setProcessName(pr.getPrpdname());
			IGPRR0102Form form = dto.getIgPRR0102Form();
			form.setPrtitle(pr.getPrtitle());
			form.setPrurgency(pr.getPrurgency());
			form.setPrimpact(pr.getPrimpact());
			form.setPrdesc(pr.getPrdesc());
		}
		String psdcode = dto.getPsdcode();//����״̬����
		//���ݲ����˽�ɫID������״̬�Ȳ�ѯ��Ӧ�����̲����ߵĶ���������Ȩ�޵������Ϣ
		dto = searchProcessParticipantDefByRoleAndProcessStatusAction(dto);
		//���ݲ����˽�ɫID������״̬��prid�Ȳ�ѯ��Ӧ������״̬�ı����������Ϣ
		dto = searchProcessVariableAction(dto);
		//��ѯ����Ϣ����
		List<IG007Info> processInfoDefList  = workFlowOperationBL.getProcessInfoDefs(pdid);
		if(roleid != null && roleid > 0) {
			//�����߿��Ӱ�ťȡ��
			List<IG309Info> lst_ParticipantVisibleButtonVWInfo =
				this.workFlowDefinitionBL.searchVisibleButton(dto.getProcessStatusDef().getPsdid(), roleid);
			
			//�ж��Ƿ�Ϊ����״̬
			if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psdcode) && (prid == null || prid == 0)){
				//ȡ�����߱���Ȩ����Ϣ������ǰ�������б����Ľ���,�����е�Ԫ��Ҫ������ǰ����ѡ�еı�����ֵ
				//��ѯ������������
				IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
				dto.setProcessName(pd.getPdname());
				//��ǰ���̶����Ƿ�Ϊ����״̬
				if(pd!=null && IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(pd.getPdstatus())){
					dto.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
				}
				dto = setVarAccess(processInfoDefList,dto);
				
				//��varList��notinvarList��ǰ����ı������ϱȽϣ���������ǰ�����еı�������ǰ���������õ�ֵ���и�ֵ(���ñ���ֵ)
				dto = setVarValue(dto);
				
			}else{
				//�Ƿ���״̬(��processInfo������һ״̬��ǰ������±������б���Ϣ��ֵ)
				//��ѯProcessInfo
				List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(prid);
				
				Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
				for(int i=0;i<processInfolist.size();i++){
					if(processInfolist.get(i).getPiattkey()!=null){
						//recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(prid);
						List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
						map.put(processInfolist.get(i).getPivarname(), list);
					}
					//˽�б�������
					List<IG899TB> privateInfoList = processInfolist.get(i).getProcessPrivateInfofList();
					if(privateInfoList != null){
						for(int j=0; j<privateInfoList.size();j++){
							if(privateInfoList.get(j).getPpiattkey()!=null){
								List<Attachment> listPrivate = workFlowOperationBL.searchProcessInofAtt(privateInfoList.get(j).getPpiattkey());
								if(StringUtils.isEmpty(privateInfoList.get(j).getUserid())){
									map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getRoleid(), listPrivate);
								}else{
									map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getUserid(), listPrivate);
								}
							}
						}
					}
	//			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
				}
				dto.setTextAreaMap(map);
				
				//ȡ�����߱���Ȩ����Ϣ������ǰ�������б����Ľ���,�����е�Ԫ��Ҫ������ǰ����ѡ�еı�����ֵ
				
				//��ǰ�����ߵı���Ȩ�޼���������̶���ı���Ϣ���Ͻ��бȽ�(���ñ���Ȩ��)
				dto = setVarAccess(processInfoDefList,dto);
				
				//����������״̬����ʱ�ı���ֵ��ǰ�����еı���ֵ���бȽ�
				dto = setProcessInfoVarValue(processInfolist,dto);
				
				//��varList��notinvarList��ǰ����ı������ϱȽϣ���������ǰ�����еı�������ǰ���������õ�ֵ���и�ֵ(���ñ���ֵ)
				dto = setVarValue(dto);
			}
			//�ж��Ƿ�����Ҫȷ�ϲ���
			boolean show_button_confim = false;
			//��ǰ������δȷ��
			if(dto.getProcessParticipant() != null
					&& !IGPRDCONSTANTS.PARTICIPANT_SUBSTATUS_CONFIRM.equals(dto.getProcessParticipant().getPpsubstatus())) {
				for(IG309Info button : lst_ParticipantVisibleButtonVWInfo) {
					if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(button.getVbid())) {
						show_button_confim = true;
						break;
					}
				}
			}
			
			//�����ȷ�ϰ�ť������ȷ��/����/��ֹ��ť��û����ɾ��ȷ�ϰ�ť
			IG309Info button = null;
			for(Iterator<IG309Info> iter = lst_ParticipantVisibleButtonVWInfo.iterator(); iter.hasNext();) {
				button = iter.next();
				if(show_button_confim) {
					if(isCommitButton(button.getVbid())) {
						iter.remove();
					}
				} else if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(button.getVbid())) {
					iter.remove();
				}
			}
			
			//���нڵ�ֻ�ܿ�������/��ֹ�ͣ��ύ��ȷ�ϣ���ť��
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
				for(Iterator<IG309Info> iter = lst_ParticipantVisibleButtonVWInfo.iterator(); iter.hasNext();) {
					button = iter.next();
					if(isCommitButton(button.getVbid()) && !IGPRDCONSTANTS.BUTTON_SUBMIT.equals(button.getVbid())) {
						iter.remove();
					}
				}
			}
			
			//�������ط���ť�����ѯ�ɷ�����������͡�
			for(Iterator<IG309Info> iter = lst_ParticipantVisibleButtonVWInfo.iterator(); iter.hasNext();) {
			    button = iter.next();
			    if(IGPRDCONSTANTS.BUTTON_PROCESS.equals(button.getVbid())) {
			        IG911SearchCondImpl ig911cond = new IG911SearchCondImpl();
			        ig911cond.setPdid(dto.getPdid());
			        ig911cond.setPsdid(dto.getPsdid());
			        ig911cond.setRoleid(dto.getRoleid());
			        int ig911SearchCount = workFlowDefinitionBL.getIg911RelevantPdidCount(ig911cond);
			        if (ig911SearchCount == 1) {
			            dto.setIsMoreRelevantProcess("0");
			            IG911Info ig911Info = workFlowDefinitionBL.searchIg911RelevantPdid(ig911cond).get(0);
			            dto.setRelevantPdid(ig911Info.getRelevantPdid());
			        } else if (ig911SearchCount > 1) {
			            dto.setIsMoreRelevantProcess("1");
			        } else {
			            IG931SearchCondImpl ig931cond = new IG931SearchCondImpl();
                        ig931cond.setPdid(dto.getPdid());
                        ig931cond.setPsdid(dto.getPsdid());
                        int ig931SearchCount = workFlowDefinitionBL.getIg931RelevantPdidCount(ig931cond);
                        if (ig931SearchCount == 1) {
                            dto.setIsMoreRelevantProcess("0");
                            IG931Info ig931info = workFlowDefinitionBL.searchIg931RelevantPdid(ig931cond).get(0);
                            dto.setRelevantPdid(ig931info.getRelevantPdid());
                        } else {
                            dto.setIsMoreRelevantProcess("1");
                        }
			        }
			        break;
			    }
			}
			
			dto.setLst_ParticipantVisibleButtonVWInfo(lst_ParticipantVisibleButtonVWInfo);
			//ͨ���ڵ����þ���ͨ��ɫ�Ƿ�ɴ��洦��
			IG333Info psd = dto.getProcessStatusDef();
			if("N".equals(psd.getReplaceDispose())){
				//ȡ�õ�ǰ��¼�û� 
				User user = dto.getUser();
				//Ĭ�ϵ�ǰ�û��ǵ�ǰ������ 
				boolean flag = true; 
				//ȡ�����̵�ǰ�����˼���
				List<IG337Info> list = dto.getProcessParticipantList();
				if(list != null){
					for(IG337Info info : list){
						if(user.getUserid().equals(info.getPpuserid())){
							flag = false;
							break;
						}
					}
				}
				//�����ǰ��¼�û��������̵�ǰ������ ɾ����ťȨ���Լ�����дȨ��
				if(flag){
					//ɾ����ťȨ��
					dto.setLst_ParticipantVisibleButtonVWInfo(null);
				}
			}
		}else{
			//��ѯProcessInfo
			List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(prid);
			
			Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
			for(int i=0;i<processInfolist.size();i++){
				if(processInfolist.get(i).getPiattkey()!=null){
					//recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(prid);
					List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
					map.put(processInfolist.get(i).getPivarname(), list);
				}
				//˽�б�������
				List<IG899TB> privateInfoList = processInfolist.get(i).getProcessPrivateInfofList();
				if(privateInfoList != null){
					for(int j=0; j<privateInfoList.size();j++){
						if(privateInfoList.get(j).getPpiattkey()!=null){
							List<Attachment> listPrivate = workFlowOperationBL.searchProcessInofAtt(privateInfoList.get(j).getPpiattkey());
							if(StringUtils.isEmpty(privateInfoList.get(j).getUserid())){
								map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getRoleid(), listPrivate);
							}else{
								map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getUserid(), listPrivate);
							}
						}
					}
				}
//			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
			}
			dto.setTextAreaMap(map);
			
			//ȡ�����߱���Ȩ����Ϣ������ǰ�������б����Ľ���,�����е�Ԫ��Ҫ������ǰ����ѡ�еı�����ֵ
			
			//��ǰ�����ߵı���Ȩ�޼���������̶���ı���Ϣ���Ͻ��бȽ�(���ñ���Ȩ��)
			dto = setVarAccess(processInfoDefList,dto);
			
			//����������״̬����ʱ�ı���ֵ��ǰ�����еı���ֵ���бȽ�
			dto = setProcessInfoVarValue(processInfolist,dto);
			
			//��varList��notinvarList��ǰ����ı������ϱȽϣ���������ǰ�����еı�������ǰ���������õ�ֵ���и�ֵ(���ñ���ֵ)
			dto = setVarValue(dto);
		}
		//���нڵ�ֻ�ܿ������ºͣ��ύ��ȷ�ϣ���ť��
		if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
			//�жϵ�¼�û���ѡ�����ɫ�Ƿ��ǲ��нڵ�super��ɫ
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(dto.getPrid());
			cond.setPpstatus(dto.getProcessStatusDef().getPsdcode());
			if (!IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())) {
				cond.setPproleid(dto.getRoleid());
			}
//			cond.setPpuserid(dto.getUser().getUserid());
			List<IG337Info> ppList = this.workFlowOperationBL.searchProcessParticipants(cond);
			for(IG337Info participant : ppList) {
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(participant.getPpsuper())) {
					if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
						dto.setSuperFlag(IGPRDCONSTANTS.MODE_OA);//OAģʽ
					} else {
						dto.setSuperFlag(IGPRDCONSTANTS.MODE_NORMAL);//��ͨģʽ
					}
				}
			}
		}
		//����״̬���ܴ���
		if(workFlowOperationBL.checkPendStatus(dto.getPrid(), dto.getProcessStatusDef().getPsdid())) {
			//ɾ����ťȨ��
			dto.setLst_ParticipantVisibleButtonVWInfo(null);
		}
				
		log.debug("========ҳ���ʼ����������========");
		return dto;
	}
	
	/**
	 *����ǰ�����б��������ö����̱������и�ֵ
	 */
	private IGPRR01DTO setProcessInfoVarValue(List<IG599Info> processInfolist,IGPRR01DTO dto) throws BLException {
		List<IG007Info> varList = dto.getVarList();//��������Ȩ�ޱ��������Ϣ�Ľ���
		List<IG007Info> notinvarList =dto.getNotinvarList();//���治������Ȩ�ޱ����еı���Ϣ

		if(varList!=null){
			for(int i=0,j=varList.size();i<j;i++){
				IG007TB pid = (IG007TB)SerializationUtils.clone(varList.get(i));
				if(processInfolist!=null){
					for(int n=0,m=processInfolist.size();n<m;n++){
						IG599Info pipd = processInfolist.get(n);
						
						//�жϱ���Ϣ�Ƿ���processInfolist��,��������丳ֵ
						if(pid.getPidid().equals(pipd.getPidid())){
							pid.setPidvalue(pipd.getPivarvalue());
							pid.setPiid(pipd.getPiid());
							pid.setPidcomment(pipd.getPidcomment());
							//add by wanglongyu 20120406 ���Ӷ�˽�б���ֵ��ȡ��
							if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
								if(null == pipd.getProcessPrivateInfofList() || pipd.getProcessPrivateInfofList().size() == 0){
									pid.setProcessPrivateInfoList(null);
								}else{
									pid.setProcessPrivateInfoList(pipd.getProcessPrivateInfofList());
								}
							}
							varList.remove(i);
							varList.add(i,pid);
							break;
						}
					}
				}
			}
		}
		
		if(notinvarList!=null){
			for(int i=0,j=notinvarList.size();i<j;i++){
				IG007TB pid = (IG007TB)SerializationUtils.clone(notinvarList.get(i));
				if(processInfolist!=null){
					for(int n=0,m=processInfolist.size();n<m;n++){
						IG599Info pipd = processInfolist.get(n);
						//�жϱ���Ϣ�Ƿ���processInfolist��,��������丳ֵ
						if(pid.getPidid().equals(pipd.getPidid())){
							pid.setPidvalue(pipd.getPivarvalue());
							pid.setPiid(pipd.getPiid());
							//add by wanglongyu 20120406 ���Ӷ�˽�б���ֵ��ȡ��
							if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
								if(null == pipd.getProcessPrivateInfofList() || pipd.getProcessPrivateInfofList().size() == 0){
									pid.setProcessPrivateInfoList(null);
								}else{
									pid.setProcessPrivateInfoList(pipd.getProcessPrivateInfofList());
									//���˽�б���Ϊ��ɫ,���������е�value
									if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equalsIgnoreCase(pid.getPrivatescope())){
										for(IG899TB tb : pipd.getProcessPrivateInfofList()){
											pid.setPidvalue(tb.getPpivalue());
										}
									}
								}
							}
							notinvarList.remove(i);
							notinvarList.add(i,pid);
							break;
						}
					}
				}

			}
		}
		
		//�ı���󶨸���ֵ��װ
//		dto.setTextAreaMap(textAreaList);
		
		dto.setVarList(varList);
		dto.setNotinvarList(notinvarList);
		return dto;
	}
	
	/**
	 * ���ñ�����
	 */
	private IGPRR01DTO initDefVar(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = dto.getIgPRR0102Form();
		if(dto.getProcessInfoDefmap()!=null){
			int length = dto.getProcessInfoDefmap().size();
			form.setPivarvalue(new String[length]);
			form.setPivarassetname(new String[length]);
			form.setPivarprname(new String[length]);
			form.setPivarprjname(new String[length]);
			form.setPivarrolename(new String[length]);
			form.setPivartreename(new String[length]);
			form.setPivarradio(new String[length]);
			form.setPivarcheckbox(new String[length]);
			form.setPidcomment(new String[length]);
			form.setPivarlabel(new String[length]);
			form.setPivarname(new String[length]);
			form.setPivartype(new String[length]);
			form.setPrivatescope(new String[length]);
			//120509Begin
		}else{
			dto = searchProcessInfoForSearch(dto);
		}
		//120509End
			
		if(dto.getRealmap()!=null){
			dto.setVarmap(dto.getRealmap());
		}else{
			dto.setVarmap(dto.getProcessInfoDefmap());
		}
		//���ɼ�Ȩ�������õķ����̲����߿ɼ�����Ϣ�����̸���״̬��Ҫ��ʾ   start wangtingzhi 20130422
		Map<String,IG007Info> processInfoDefnewmap=getPorcesssInfoDefNewMap(dto.getPrid(),dto.getPdid(),dto.getUser());
		if(processInfoDefnewmap!=null){
			if (StringUtils.isEmpty(dto.getHid())||"0".equals(dto.getHid())) {
				dto.setHid("1");
			}
			Map<String, IG007Info> varmap = dto.getVarmap();
			if(varmap==null||varmap.size()==0){
				dto.setVarmap(processInfoDefnewmap);
			}else{
				Set<Map.Entry<String, IG007Info>> varset = varmap.entrySet();
				for(Iterator<Map.Entry<String, IG007Info>> variter = varset.iterator();variter.hasNext();){
					IG007Info varInfo = variter.next().getValue();
					Set<Map.Entry<String, IG007Info>> newset = processInfoDefnewmap.entrySet();
					for(Iterator<Map.Entry<String, IG007Info>> newiter = newset.iterator();newiter.hasNext();){
						IG007Info newInfo = newiter.next().getValue();
						if(varInfo.getPidid().equals(newInfo.getPidid())){
							if(StringUtils.isEmpty(varInfo.getPidaccess())||(StringUtils.isNotEmpty(newInfo.getPidaccess())&&(Integer.valueOf(newInfo.getPidaccess())>Integer.valueOf(varInfo.getPidaccess())))){
								IG007TB varTB = (IG007TB) SerializationUtils.clone(varInfo);
								varTB.setPidaccess(newInfo.getPidaccess());
								varmap.put(newInfo.getPidid(), varTB);
								break;
							}
						}
					}
				}
			}
		}
		//���ɼ�Ȩ�������õķ����̲����߿ɼ�����Ϣ�����̸���״̬��Ҫ��ʾ   end wangtingzhi 20130422
		if(!"1".equalsIgnoreCase(dto.getHid())){
			dto.setHid("0");
		}
		if(dto.getVarmap()!=null){
			Set<Map.Entry<String,IG007Info>> cset = dto.getVarmap().entrySet();
			//=============================>wuzhenqiu ��չ��Ϣ�Ƿ���ʾ
			for(Iterator<Map.Entry<String,IG007Info>> iter = cset.iterator();iter.hasNext();){
				Map.Entry<String,IG007Info> entry = iter.next();
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(entry.getValue().getPidaccess()) ||
				   IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(entry.getValue().getPidaccess())	){
					dto.setHid("1");
					break;
				}
			}
		}
		//<============================
		
        form.setProcessName(dto.getProcessName());
		
		
		return dto;
	}
		
	/**
	 * �������̶���ID���û���ɫ�������û��ɲ鿴�����̵ı�
	 * @param pdid
	 * @param user
	 * @return
	 */
	private Map<String, IG007Info> getPorcesssInfoDefNewMap(Integer prid,String pdid,
			User user) {
		Map<String,IG007Info> processInfoDefnewmap=new LinkedHashMap<String, IG007Info>();
		List<IG007Info> ig007InfoList=new ArrayList<IG007Info>();
		String userid = user.getUserid();
		//ȡ�õ�ǰ�û������н�ɫ
		UserRoleSearchCondImpl condRole = new UserRoleSearchCondImpl();
		condRole.setUserid(userid);
		List<UserRole> roleList = userRoleBL.searchUserRole(condRole);
		if(roleList!=null&&roleList.size()>0){
			for(UserRole userRole:roleList){
				IG701SearchCondImpl cond=new IG701SearchCondImpl();
				cond.setPdid(pdid);
				cond.setRoleid(userRole.getRoleid());
				List<IG701Info> ig701InfoList= workFlowDefinitionBL.searchRoleForm(cond);
				if(ig701InfoList!=null&&ig701InfoList.size()>0){
					for(IG701Info ig701Info:ig701InfoList){
						if(ig701Info.getProcessInfoDef()!=null){
							ig007InfoList.add(ig701Info.getProcessInfoDef());
						}
					}
				}
			}
		}
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(prid);
		if(ig007InfoList!=null && ig007InfoList.size()>0){
			//�������̱����ҵ�����������еı������壬�����̱�����ֵ���������Ӧ�����̱�������Ķ��󣬲��������̱��������������̱���Ȩ��(pidaccess)����Ϊֻ��
			for(IG007Info pid:ig007InfoList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						pitb.setPidvalue(temp_pi.getPivarvalue());
						pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						processInfoDefnewmap.put(pidid, pitb);
						break;
					}
				}
			}
		}
		return processInfoDefnewmap;
	}

	/**
	 * ���̹���Ա�ɼ����б�����
	 */
	private IGPRR01DTO initDefVarForAdmin(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//ȡ������
		IG500Info pr = dto.getProcess();
		
		//��ѯ�����̵����ж���ı�����
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pr.getPrpdid());
		List<IG007Info> infoDefList = workFlowOperationBL.searchProcessInfoDefByCond(cond);

		//��ѯ�����̵����б�����
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(pr.getPrid());
		
		if(infoDefList!=null && infoDefList.size()>0){
			Map<String,IG007Info> realmap = new LinkedHashMap<String,IG007Info>();
			//�������̱����ҵ�����������еı������壬�����̱�����ֵ���������Ӧ�����̱�������Ķ��󣬲��������̱��������������̱���Ȩ��(pidaccess)����Ϊ��д
			for(IG007Info pid:infoDefList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						IG599TB temppi = (IG599TB)SerializationUtils.clone(temp_pi);
						pitb.setPidvalue(temppi.getPivarvalue());
						//�����ǰ�û�����ȫ�ֿ�������Ȩ�ޱ�������ԭȨ�ޣ�������ֻ��Ȩ��
						if(!IGPRR01BLType.FORM_GLOBAL_CONTROL_Y.equals(dto.getIsFormGlobalControl())){
							pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						}else{
							pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE);
						}
						//pitb.setPrivateaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL);
						pitb.setPiid(temppi.getPiid());
						if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
							if(null == temppi.getProcessPrivateInfofList() || temppi.getProcessPrivateInfofList().size() == 0){
								pitb.setProcessPrivateInfoList(null);
							}else{
								pitb.setProcessPrivateInfoList(temppi.getProcessPrivateInfofList());
							}
						}
						realmap.put(pidid, pitb);
						break;
					}
				}
				
			}
			dto.setRealmap(realmap);
		}
		
		if(dto.getRealmap()!=null){
			dto.setVarmap(dto.getRealmap());
			int length = dto.getVarmap().size();
			form.setPivarvalue(new String[length]);
			form.setPivarassetname(new String[length]);
			form.setPivarprname(new String[length]);
			form.setPivarprjname(new String[length]);
			form.setPivarrolename(new String[length]);
			form.setPivartreename(new String[length]);
			form.setPivarradio(new String[length]);
			form.setPivarcheckbox(new String[length]);
			form.setPivarlabel(new String[length]);
			form.setPivarname(new String[length]);
			form.setPivartype(new String[length]);
			form.setPrivatescope(new String[length]);
			form.setPidcomment(new String[length]);
			dto.setHid("1");
		}else{
			dto.setVarmap(dto.getProcessInfoDefmap());
			dto.setHid("0");
		}
		
		
        form.setProcessName(dto.getProcessName());
		
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ����ԾǨ 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public synchronized IGPRR01DTO flow(IGPRR01DTO dto) throws BLException {
		log.debug("========����ԾǨ����ʼ========");
		// ���̼�¼�����
		IGPRR0102Form form = dto.getIgPRR0102Form();
		
		// ���������Ǹ��°�ť������û�н�ɫ��Ϣ��ֻ�����²���   20130121 ��͢־ start
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		// 201302121 ��͢־  end
		
		//OAģʽ��ʱ��ɫ�����ˣ������ύ�������������˵�������
		dto.setTempRoleManager(form.isTempRoleManager());
		// ��ǰ�û���Ϣ
		User user = dto.getUser();
		
		// �����Ȩ,����Ȩ����Ϣ����
		if(dto.getAuthorizeuser() != null){
			user = dto.getAuthorizeuser();
		}
		dto.setAssignPageType(psd.getAssignPageType());
		User authorizeuser = dto.getAuthorizeuser();
		//������̱�����Ϣ
		List<IG599Info> processInfoList = new ArrayList<IG599Info>();
		if(dto.isAssignParticipant()) {
			if(form.getPivarvalue() != null){
				for(int i=0;i<form.getPivarvalue().length;i++){
					IG599TB prInfo = workFlowOperationBL.getProcessInfoTBInstance();
					prInfo.setPivarlabel(form.getPivarlabel()[i]);
					prInfo.setPivarname(form.getPivarname()[i]);
					prInfo.setPivartype(form.getPivartype()[i]);
					prInfo.setPivarvalue(form.getPivarvalue()[i]);
					prInfo.setPidid(form.getPidid()[i]);
					if(StringUtils.isNotEmpty(form.getPiid()[i])) {
						prInfo.setPiid(Integer.parseInt(form.getPiid()[i]));
					}
					if(form.getPidcomment() != null && form.getPidcomment().length > i){
						prInfo.setPidcomment(form.getPidcomment()[i]);
					}
					prInfo.setPidaccess(form.getPidaccess()[i]);
					prInfo.setPidmode(form.getPidmode()[i]);
					prInfo.setPrivatescope(form.getPrivatescope()[i]);
					prInfo.setPrid(dto.getPrid());
					processInfoList.add(prInfo);
				}
			}
		}
		dto.setNodetype(psd.getPsdtype());
		
		String datetime = IGStringUtils.getCurrentDateTime();
		
		//��ѯ��ǰ����
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		if(StringUtils.isEmpty(form.getPrtype())){
			form.setPrtype(pr.getPrtype());
		}
		//ȡ����Ա����Ϣ
		Map<String, List<IG506TB>> participantFormInfo = packingParticipantList(form.getPar_userid(), form.getPar_username(), form.getPar_orgid(), form.getPar_orgname(), form.getPar_roleid(), form.getPar_rolename(), form.getPar_pidid(),form.getPar_phone());
		//�����ɾ�������ӵĻ���id���ܻ᲻������ʱ���޸�
		List<IG599Info> prInfoList = new ArrayList<IG599Info>();
		if(dto.isAssignParticipant()) {
			
			if(form.getPivarvalue() != null){
				//============================>wuzhenqiu
				boolean flag = false;
				for(int i=0;i<form.getPivarvalue().length;i++){
					if(form.getPivarvalue()[i]!=null){
						flag = true;
						break;
					}
				}
				if(flag){
					for(int i=0;i<form.getPivarvalue().length;i++){
						if(StringUtils.isNotEmpty(form.getPiid()[i])){
							IG599Info pi = workFlowOperationBL.getProcessInfoByID(Integer.parseInt(form.getPiid()[i]));
							//����ǿ�д��������ֻ�豣��ֵ���
							if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(form.getPidaccess()[i])) {
								if(!form.getPivarvalue()[i].equals(pi.getPivarvalue())) {
									IG599TB piTB = (IG599TB)SerializationUtils.clone(pi);
									piTB.setPivarvalue(form.getPivarvalue()[i]);
									if("5".equals(pi.getPivartype())){
										piTB.setPivarvalue(workFlowOperationBL.getProcessFormValue(dto.getProcess().getPrid(), form.getPivarvalue()[i]));
									}
									if("P".equals(pi.getPivartype())){
										List<IG506TB> list = participantFormInfo.get(pi.getPidid());
										piTB.setPivarvalue(workFlowOperationBL.getParticipantFormValue(pi.getPrid(), list, form.getPivarvalue()[i]));
									}
									prInfoList.add(piTB);
								}
							}
						}
					}
				}
				//<===========================
			}
			
			//���󶨸�������
			if(form.getAtt()!=null){
				List<IG599Info> textAreaPIList = new ArrayList<IG599Info>();
				Set<String> att = new HashSet<String>();
				for(String attFormLabel:form.getAtt()){
				    att.add(attFormLabel.split("_")[0]);
				}
				if(form.getPivarlabel() != null) {
					for(int i=0;i<form.getPivarlabel().length;i++){
					    if(att.contains(form.getPivarlabel()[i])){
					        IG599Info pi = workFlowOperationBL.getProcessInfoByID(Integer.parseInt(form.getPiid()[i]));
					        if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pi.getPidmode())){
	                            continue;
	                        }
					        if(pi.getPiattkey()!=null){
	                            Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
	                            //����฽�������ֻ�ܲ���һ����������
	                            for(int k=0;k<form.getAtt().length;k++){
	                                if(pi.getPivarlabel().equals(form.getAtt()[k].split("_")[0])){
	                                    if(form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])) != null){
	                                        filemap.put(k, form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])));
	                                    }
	                                }
	                                
	                            }
	                            workFlowOperationBL.addProcessInfoAtt(filemap, pi.getPiattkey());
	                        }else{
	                            Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
	                            for(int k=0;k<form.getAtt().length;k++){
	                                if(pi.getPivarlabel().equals(form.getAtt()[k].split("_")[0])){
	                                    if(form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])) != null){
	                                    filemap.put(k, form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])));
	                                    }
	                                }
	                                
	                            }
	                            pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
	                            
	                            textAreaPIList.add(pi);
	                        }
					    }
					}
				}
				
				for(int i=0;i<textAreaPIList.size();i++){
					boolean flag = true;
					for(int j=0;j<prInfoList.size();j++){
						if(prInfoList.get(j).getPiid().equals(textAreaPIList.get(i).getPiid())){
							IG599TB piTB = (IG599TB) prInfoList.get(j);
							piTB.setPiattkey(textAreaPIList.get(i).getPiattkey());
							prInfoList.remove(j);
							prInfoList.add(j, piTB);
							if(flag){
								flag = false;
							}
						}
					}
					if(flag){
						prInfoList.add(textAreaPIList.get(i));
					}
				}
			}
			
			//�ı���󶨸���ɾ��
			if(form.getDelFileMutiStr() !=null && form.getDelFileMutiStr().length()>0){
				String[] delFileMutiStr=form.getDelFileMutiStr().split("#");
				for(int i=0;i<delFileMutiStr.length;i++){
				//�ȸ��ݸ���id��ѯ
				String[] strid = delFileMutiStr[i].split("_");
				Attachment att= workFlowOperationBL.delAttachment(strid[0]);
				//��ɾ��
				
				//����󶨵��ı����Ѿ�û�и�����,��ô�����丽���ֶ�Ϊ��
				if(att != null  && strid.length>0 ){
					List<Attachment> list=  workFlowOperationBL.searchProcessInofAtt(att.getAttkey());
					if(list.size() == 0){
						//�ÿո����ֶ�
						IG599TB piTB = (IG599TB) workFlowOperationBL.getProcessInfoByID(Integer.parseInt(strid[1]));
						piTB.setPiattkey("");
						workFlowOperationBL.updateProcessInfo(piTB);
						
						IG899SearchCondImpl cond = new IG899SearchCondImpl();
						cond.setPiid(Integer.parseInt(strid[1]));
						if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equalsIgnoreCase(piTB.getPidmode())){
							cond.setUserid(user.getUserid());
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equalsIgnoreCase(piTB.getPidmode())){
							cond.setRoleid(form.getPrroleid());
						}
						List<IG899Info> privateInfoList = workFlowOperationBL.searchProcessPrivateInfo(cond);
						if(privateInfoList != null && privateInfoList.size()>0){
							for(int iNum = 0; iNum < privateInfoList.size(); iNum++){
								IG899TB privateInfoTB = (IG899TB)privateInfoList.get(iNum);
								privateInfoTB.setPpiattkey("");
								workFlowOperationBL.updateProcessPrivateInfo(privateInfoTB);
							}
						}
					}
				
				}
				}
				
			} 
			
			workFlowOperationBL.saveOrUpdProcessInfos(prInfoList);
			
		}
		
		//�ʲ�������
		String pieids = form.getPieids();
		//ɾ���������ʲ���ϵ
		if(StringUtils.isNotEmpty(pieids)){
			String[] ids = pieids.split("#");
			for(String pieid : ids){
				if(StringUtils.isNotEmpty(pieid)){
					workFlowOperationBL.deleteProcessInfoEntityById(Integer.parseInt(pieid));
				}
			}
		}
		//�����������ʲ���ϵ 20130905 wangtingzhi start
		Map<Integer, String> entityMap = form.getEntityMap();
		//��������״̬��˽�б� ig561��¼���������ֲ������ʲ����ڲ�ͬ��״̬ 2015��2��13��15:38:44
		Map<String,String> entitySaveMap=null;
		if(entityMap != null && entityMap.size() > 0){
			//��ѯ����Ϣ
			List<IG599Info> list = workFlowOperationBL.getProcessInfo(dto.getProcess().getPrid());
			entitySaveMap=workFlowOperationBL.saveProcessInfoEntity(list, entityMap);
		}
		//�����������ʲ���ϵ 20130905 wangtingzhi end
		
		//������ֵ������� 20130626 start wangtingzhi
		if(form.isUpdateTableValue()){
			workFlowOperationBL.saveTableFormValue(dto.getProcess(), form.getColumn_value(), form.getColumn_pidid(), form.getColumn_rownumber(),form.getFileMapTable(),form.getAddTableColumnFileStr(),form.getDelTableColumnFileStr());
		}
		
		//����״̬��˽�б��������õ�������ģ����總����
		this.saveOrUpdateStatusVars(form,processInfoList,form.getAtt(),form.getFileMapMuti(),form.getDelFileMutiStr(),dto.getPsdid());
		//����״̬���� wyw
		workFlowOperationBL.registIG561Info(processInfoList,dto.getPsdid(), user.getUserid(),entitySaveMap);
		
		//����Ǹ��²�����ֻ�����£��������κβ�������֤
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction()) || IGPRDCONSTANTS.BUTTON_PROCESS.equals(dto.getAction())) {
			Integer roleid = null;
			if(form.getPrroleid() != null && form.getPrroleid() > 0) {
				roleid = form.getPrroleid();
			}
			IG036Info recordLog = workFlowOperationBL.addRecordLog(form.getPrid(), dto.getUser(), roleid, form.getRlcomment(),
					psd.getPsdname(), form.getFileMap(),form.getLog_type(), IGPRDCONSTANTS.BUTTON_UPDATE, form.getPrstatus());
            //�ύ���ͷ�ϵͳ��־ʱ����Ҫ��¼����־
            if(!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(form.getLog_type()) && prInfoList!=null && !prInfoList.isEmpty()){
                workFlowOperationBL.addRecordLogVarInfo(prInfoList, recordLog);
            }
			dto.addMessage(new ActionMessage("IGPRR0102.I002"));
			if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())){
			    WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
			    bean.setPbdid(dto.getAction());//��ťID
			    bean.setBfstatus(form.getPsdid());//״̬ID
			    //��־������Ϣ
			    WorkFlowLog logInfo = new WorkFlowLog();
			    logInfo.setPrid(dto.getPrid());
			    logInfo.setExecutorid(user.getUserid());
			    logInfo.setExecutorRoleid(form.getPrroleid());
			    if(authorizeuser != null) {
			        logInfo.setAuthuserid(authorizeuser.getUserid());
			    }
			    bean.setLogInfo(logInfo);
			    this.workFlowOperationBL.processStatusButtonTreatmentExecute(bean);
			}
			
			return dto;
		}
		
		//��ȡ�����߽�ɫ��Ϣ
		Role role = roleBL.getRole(dto.getRoleid());
		
		//�ж��Ƿ����ָ��������ҳ��
		//��ѯ��״̬�ɽ��з��ɵĽڵ��б�
		 List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAssignedStatusDef(form.getPsdid(), form.getAction());
		if(dto.isAssignParticipant()) {
			String action = dto.getAction();
			//�ɷ��ɽڵ�Ǹ��²�������ָ��������
			if(isCommitButton(action)) {
				//====>130225Begin	û��ԾǨȨ�޵��˲��ɼ�����ҳ
				boolean flag = false;//ԾǨ��ʶtrue����ȨԾǨ��false����ȨԾǨ
				IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
				cond337.setPrid(pr.getPrid());
				cond337.setPpuserid(user.getUserid());
				if (form.getPrstatus().indexOf("_") > -1) {
					cond337.setPsdid(form.getPrstatus().split("_")[0]);
					cond337.setPsdnum(Integer.parseInt(form.getPrstatus().split("_")[1]));
				} else {
					cond337.setPsdid(form.getPrstatus());
				}
//				cond337.setPpstatus(pr.getPrstatus());
				List<IG337Info> lstIg337 = workFlowOperationBL.searchProcessParticipants(cond337);
				if(lstIg337 != null && !lstIg337.isEmpty()){
					//�жϵ�ǰ�ڵ��Ƿ���OAģʽ
					IG333Info lst_Ig333 = this.workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
					if(IGPRDCONSTANTS.MODE_OA.equals(lst_Ig333.getPsdmode())){
						for (IG337Info info337 : lstIg337) {
							if(IGPRDCONSTANTS.ROLEMANAGER.equals(info337.getPprolemanager())
									|| (IGPRDCONSTANTS.DUTYPERSON.equals(info337.getPpdutyperson()) &&
										IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(info337.getPpsubstatus()))) {
								flag = true;
								break;
							}
						}
					}else{
						flag = true;
					}
					
				}else{
					flag = true;
				}
				//����ǿɷ��ɽڵ㣬����ת���趨ִ����ҳ��
				if(!lst_ProcessStatusDef.isEmpty() && flag) {
				//====>130225End
					dto.setNodetype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_ASSIGN);
					dto.setPsdflag(IGPRDCONSTANTS.NEED_ASSIGN);
					form.setIsInit("assign");
					dto.setAction(IGPRDCONSTANTS.BUTTON_UPDATE);
					//��ѯ�ɷ��ɲ�����
				}
			}
		}
		
		//��ȡ��ǰ�����߼�¼
		//��ѯ��ǰ��������Ϣ
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(form.getPrid());
//		cond.setPpstatus(psd.getPsdcode());
		if(StringUtils.isEmpty(form.getPrstatus())) {
			cond.setPsdid(form.getPsdid());
		} else {
			if (form.getPrstatus().indexOf("_") > -1) {
				cond.setPsdid(form.getPrstatus().split("_")[0]);
				cond.setPsdnum(Integer.parseInt(form.getPrstatus().split("_")[1]));
			} else {
				cond.setPsdid(form.getPrstatus());
			}
		}
//		cond.setPsdid(psd.getPsdid());
		cond.setPpproctimeIsNull("Y");
		cond.setPproleid(form.getPrroleid());
		IG337Info curentpp = null;
		List<IG337Info> ppList = this.workFlowOperationBL.searchProcessParticipants(cond);
		if(form.getPpid() != null && form.getPpid() > 0) {
			curentpp = this.workFlowOperationBL.searchProcessParticipantByKey(form.getPpid());
		}
		if(ppList != null){
			for(IG337Info pp:ppList){
				if (user.getUserid().equals(pp.getPpuserid())) {
					curentpp = pp;
				}
			}
		}
		
		//����˽�б���
		processInfoList = setAttkey(processInfoList,form.getPrroleid(), user.getUserid(), form.getAtt(),form.getFileMapMuti(), form.getDelFileMutiStr());
		this.workFlowOperationBL.registProcessPrivateInfo(processInfoList, form.getPrroleid(), user.getUserid(),curentpp==null?"":curentpp.getPporgid());
		
		if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())) {//OAģʽ
			//�ύ
			if(isCommitButton(dto.getAction())) {
				if(curentpp == null){
					throw new BLException("IGCO10000.E004","�����߻���");
				}
				//�жϵ�¼�û��Ƿ���ֵ���˻�����
				boolean flag = false;
				
				//�жϲ����������Ƿ�Ϊ����
				if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
					//�ж��Ƿ��Ǹ�����
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(curentpp.getPprolemanager())){
						flag = true;
					}
					//�ж��Ƿ���ֵ����
					if(IGPRDCONSTANTS.DUTYPERSON.equals(curentpp.getPpdutyperson())){
						flag = true;
					}
				}else{
					flag =  this.userRoleBL.checkRoleDutyflagByID(user.getUserid(), form.getPrroleid()) || this.userRoleBL.checkRoleManagerByID(user.getUserid(), form.getPrroleid());
				}
				
				if(flag || dto.isTempRoleManager()){//ֵ���˻������ύ����ʱ��ɫ������
					//ֻ�����ύ�˼�¼
					for(IG337Info participant : ppList) {
						if(user.getUserid().equals(participant.getPpuserid())) {
							IG337TB ppTB = (IG337TB)SerializationUtils.clone(participant);
							ppTB.setPpproctime(datetime);
							ppTB.setPbdid(dto.getAction());
							//���²�������Ϣ
							workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(),
									form.getRlcomment(), psd.getPsdname(), form.getFileMap(),form.getLog_type(),
									prInfoList,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
							//δ����Ȩ��ɫֵ���˲����ύ
							if(IGPRDCONSTANTS.DUTYPERSON.equals(participant.getPpdutyperson()) &&
									!IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(participant.getPpsubstatus())) {
								if(!IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())) {
									dto.setAction(IGPRDCONSTANTS.BUTTON_UPDATE);
								}
							}
							break;
						}
					}
				} else {//ִ�����ύֻ�������ʱ�䣬״̬��ԾǨ���൱�ڸ���
					for(IG337Info participant : ppList) {
						if(user.getUserid().equals(participant.getPpuserid())) {
							IG337TB ppTB = (IG337TB)SerializationUtils.clone(participant);
							if(!IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())) {
								ppTB.setPpproctime(datetime);
								ppTB.setPbdid(dto.getAction());
								dto.setAction(IGPRDCONSTANTS.BUTTON_UPDATE);
							}
							//���²�������Ϣ
							workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(), form.getRlcomment(), psd.getPsdname(), 
									form.getFileMap(),form.getLog_type(),prInfoList,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
							break;
						}
					}
				}
			} else if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())) {
					//��¼������־
					IG036Info recordLog = workFlowOperationBL.addRecordLog(form.getPrid(), dto.getUser(),form.getPrroleid(),
							form.getRlcomment(), psd.getPsdname(), form.getFileMap(),form.getLog_type(), dto.getAction(), form.getPrstatus());
					
	
					//�ύ���ͷ�ϵͳ��־ʱ����Ҫ��¼����־
					if(!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(form.getLog_type()) && prInfoList!=null && !prInfoList.isEmpty()){
						//���±�������û�и��´����¼ʱ������־���͸�Ϊ������
						if(prInfoList.size() > 0 && StringUtils.isEmpty(form.getRlcomment())&&!IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(recordLog.getRltype())) {
							IG036TB recordLogTB = (IG036TB)SerializationUtils.clone(recordLog);
							recordLogTB.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
							recordLogTB.setRldesc(IGPRDCONSTANTS.RLDESC_DATA);
							workFlowOperationBL.updateRecordLog(recordLogTB);
						}
						workFlowOperationBL.addRecordLogVarInfo(prInfoList, recordLog);
					}
				
			} else if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(dto.getAction())) {//ȷ�ϴ���
				for(IG337Info participant : ppList) {
					if(user.getUserid().equals(participant.getPpuserid())) {
						IG337TB ppTB = (IG337TB)SerializationUtils.clone(participant);
						ppTB.setPpsubstatus(IGPRDCONSTANTS.PARTICIPANT_SUBSTATUS_CONFIRM);//�޸Ĳ�������״̬Ϊ��ȷ��
						ppTB.setPpbacktime(datetime);//ȷ��ʱ��
						ppTB.setPbdid(dto.getAction());
						//���²�������Ϣ
						workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(), form.getRlcomment(), psd.getPsdname(), 
								form.getFileMap(),form.getLog_type(),prInfoList,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
						break;
					}
				}
			}
			
		} else {//��ͨģʽ
			//====>Ŀ�깤���޸� Begin
			IG337TB ppTB = null;
			//��ָ��������Ϊ��ǰ������
			if(curentpp != null){
				ppTB = (IG337TB) SerializationUtils.clone(curentpp);
			}
			if(ppTB == null) {
				for (IG337Info pp : ppList) {
					if(StringUtils.isEmpty(pp.getPpuserid())){
						ppTB = (IG337TB)SerializationUtils.clone(pp);
						break;
					}
				}
			}
			//��û�в����û���Ϣʱ��ȡ�ò����ɫ��Ϣ
			if(ppTB == null){
//				IG337Info pp = workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrroleid(), 
//						psd.getPsdcode());
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(form.getPrid());
				ppCond.setPproleid(form.getPrroleid());
				ppCond.setPpuseridIsNull("Y");
				if (form.getPrstatus().indexOf("_") > -1) {
					cond.setPsdid(form.getPrstatus().split("_")[0]);
					cond.setPsdnum(Integer.parseInt(form.getPrstatus().split("_")[1]));
				} else {
					cond.setPsdid(form.getPrstatus());
				}
//				ppCond.setPsdid(psd.getPsdid());
				List<IG337Info> pprList = workFlowOperationBL.searchProcessParticipants(ppCond);
				if(pprList == null || pprList.size() == 0) {
					throw new BLException("IGCO10000.E004","�����߻���");
				}
				ppTB = (IG337TB)SerializationUtils.clone(pprList.get(0));
			}
			//====>Ŀ�깤���޸� End
			if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(dto.getAction())) {
				ppTB.setPpsubstatus(IGPRDCONSTANTS.PARTICIPANT_SUBSTATUS_CONFIRM);//�޸Ĳ�������״̬Ϊ��ȷ��
				ppTB.setPpbacktime(datetime);//ȷ��ʱ��
				ppTB.setPbdid(dto.getAction());
			} else if(isCommitButton(dto.getAction())) {
				ppTB.setPpproctime(datetime);
				ppTB.setPbdid(dto.getAction());
			}
			if(authorizeuser!= null) {//��Ȩģʽ
				ppTB.setPpuserid(authorizeuser.getUserid());
				ppTB.setPpusername(authorizeuser.getUsername());
				ppTB.setPporgid(authorizeuser.getOrgid());
				ppTB.setPporgname(authorizeuser.getOrgname());
				ppTB.setPpproxyuserid(dto.getUser().getUserid());//���ô�����id
			}else{//��ͨģʽ
				ppTB.setPpuserid(dto.getUser().getUserid());
				ppTB.setPpusername(dto.getUser().getUsername());
				ppTB.setPporgid(dto.getUser().getOrgid());
				ppTB.setPporgname(dto.getUser().getOrgname());
			}
			//���²�������Ϣ�����������°�ť
			if(!IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())
					&& !IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(dto.getAction())) {
				String log_type = form.getLog_type();
				if("assign".equals(form.getIsInit())) {
					log_type = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
				}
				workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(), form.getRlcomment(), 
						psd.getPsdname(), 
						form.getFileMap(),log_type,prInfoList,dto.getAuthorizeuser(), form.getAction(), form.getPrstatus());
			} else {
				//��¼��־
				IG036Info recordLog = workFlowOperationBL.addRecordLog(form.getPrid(), dto.getUser(), ppTB.getPproleid(), form.getRlcomment(),
						psd.getPsdname(), form.getFileMap(),form.getLog_type(), dto.getAction(), form.getPrstatus());
				//���±�������û�и��´����¼ʱ������־���͸�Ϊ������
				if(prInfoList.size() > 0 && StringUtils.isEmpty(form.getRlcomment())&&!IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(recordLog.getRltype())) {
					IG036TB recordLogTB = (IG036TB)SerializationUtils.clone(recordLog);
					recordLogTB.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
					recordLogTB.setRldesc(IGPRDCONSTANTS.RLDESC_DATA);
					workFlowOperationBL.updateRecordLog(recordLogTB);
				}
				//��¼����־
				workFlowOperationBL.addRecordLogVarInfo(prInfoList, recordLog);
			}
			
		}
		
		//���´��������Ĺ�����
		if(authorizeuser!= null) {
			IG463TB processProxyWorkTB;
			IG463SearchCondImpl processProxyWorkSearchCond = new IG463SearchCondImpl();
			processProxyWorkSearchCond.setPpwprid(pr.getPrid());
			processProxyWorkSearchCond.setPpwauthorizeuserid(authorizeuser.getUserid());
			processProxyWorkSearchCond.setPpwproxyuserid(user.getUserid());
			List<IG463Info> processProxyWorkList = workFlowOperationBL.searchProcessProxyWork(processProxyWorkSearchCond);
			//�ж�ĳһ������Ϣ�Ƿ񱣴��ڴ����˹������У�������ڸ���ʱ�䣬�������
			if(processProxyWorkList != null && processProxyWorkList.size()>0){
				processProxyWorkTB = (IG463TB)SerializationUtils.clone(processProxyWorkList.get(0));
				processProxyWorkTB.setPpwoptiontime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));
			}else{
				processProxyWorkTB = new IG463TB();
				processProxyWorkTB.setPpwauthorizeuserid(authorizeuser.getUserid());
				processProxyWorkTB.setPpwcloseflag("0");
				processProxyWorkTB.setPpwoptiontime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));
				processProxyWorkTB.setPpwprid(pr.getPrid());
				processProxyWorkTB.setPpwproxyuserid(dto.getUser().getUserid());
				processProxyWorkTB.setPpwproxyusername(dto.getUser().getUsername());
				processProxyWorkTB.setPpwprserialnum(pr.getPrserialnum());
				processProxyWorkTB.setPpwprtitle(pr.getPrtitle());
				processProxyWorkTB.setPpwprtype(pr.getPrtype());
			}
			
			workFlowOperationBL.updateProcessProxyWork(processProxyWorkTB);
		}
		
		
		//�ж��Ƿ�ִ����doflow�����ύ�ఴťҲҪ������ť�¼�
		boolean flag_doflow = true;
		if((dto.getAction() != null && dto.getAction().compareTo("10") >= 0)
				&& !"1".equals(dto.getAssignFlag())) {
			String[] participants = form.getParticipants();
			if(!dto.isAssignParticipant()) {
				String[] ppsupers = form.getPpsupers();
				//��װ�ڵ����������
				if(participants != null) {
					//Ϊ�˴��ʱ�����·���ʱ��Ҫɾ��֮ǰ�Ĳ�����start
					Set<String> set_Status = new HashSet<String>();
					for(String str : participants) {
						set_Status.add(str.split("_", 3)[0]);
					}
					for(String status : set_Status) {
						IG337SearchCondImpl sppCond = new IG337SearchCondImpl();
						sppCond.setPrid(pr.getPrid());
						if (status.indexOf("_") > -1) {
							sppCond.setPsdid(status.split("_")[0]);
							sppCond.setPsdnum(Integer.parseInt(status.split("_")[1]));
						} else {
							sppCond.setPsdid(status);
						}
						List<IG337Info> sppList = workFlowOperationBL.searchProcessParticipants(sppCond);
						for(IG337Info pp : sppList) {
							workFlowOperationBL.removeProcessParticipant(pp,user,form.getPrroleid(),
									"ɾ����" + pp.getPprolename()
									+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
									IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
									IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, dto.getAction(), form.getPrstatus());
						}
					}
					//Ϊ�˴��ʱ�����·���ʱ��Ҫɾ��֮ǰ�Ĳ�����end
					
					String[] array = null;
					for(String str : participants) {
						array = str.split("_", 3);
						String ppsuper = null;
						if(ppsupers != null) {
							for(String per : ppsupers) {
								if((array[0] + "_" + array[1]).equals(per)) {
									ppsuper = per;
									break;
								}
							}
						}
						workFlowOperationBL.addParticipant(dto.getUser(), dto.getPrid(), pr.getPrpdid(), array[0],
								array[1], array[2], ppsuper, authorizeuser, dto.getAction(), form.getPrstatus());
					}
				}
			}
			
			if(!dto.isAssignParticipant() || lst_ProcessStatusDef == null || lst_ProcessStatusDef.isEmpty()) {
				String psdid = form.getPrstatus();
				if(StringUtils.isEmpty(psdid)) {
					psdid = form.getPsdid();
				}
				if(authorizeuser!= null) {
					//ƥ��ԾǨ
					this.workFlowOperationBL.doFlow(dto.getPrid(), dto.getUser(), form.getPrroleid(), datetime, role.getRolename(), psdid, dto.getAction(), form.getPrdesc(), 
							dto.getNodetype(), null, form.getPpsuper(), authorizeuser);
					flag_doflow = false;
				} else {
					//ƥ��ԾǨ
					this.workFlowOperationBL.doFlow(dto.getPrid(), dto.getUser(), form.getPrroleid(), datetime, role.getRolename(), psdid, dto.getAction(), form.getPrdesc(), 
							dto.getNodetype(), null, form.getPpsuper(), null);
					flag_doflow = false;
				}
				//��ѯԾǨ���������Ϣ
				IG500Info aftDoFlowPrInfo = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
				if("C".equals(aftDoFlowPrInfo.getPrstatus())){
					sendMessageToOpener(aftDoFlowPrInfo.getPruserid(), aftDoFlowPrInfo, "�ѹر�!");
				}
			}
		}
		
		//���ִ���˰�ť�������ִ����ҳ��
		if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(form.getAction())) {
			searchAdjustParticipantAction(this.workFlowDefinitionBL.searchAdjustStatus(form.getPsdid()), dto);
		}
		
		//this.workFlowOperationBL.registAndUpdateProcessPrivateInfo(processInfoList, form.getPrroleid(), user.getUserid(), form.getAtt(),form.getFileMapMuti(), form.getDelFileMutiStr());
		//���ύ��ť�¼�����
		if(flag_doflow) {
			WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
			bean.setPbdid(form.getAction());//��ťID
			if (form.getPsdid().indexOf("_") > -1) {
				bean.setBfstatus(form.getPsdid().split("_")[0]);//״̬ID
				bean.setBfstatus(form.getPsdid().split("_")[1]);//״̬ID���
			} else {
				bean.setBfstatus(form.getPsdid());//״̬ID
			}
			//��־������Ϣ
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setPrid(dto.getPrid());
			logInfo.setExecutorid(user.getUserid());
			logInfo.setExecutorRoleid(form.getPrroleid());
			if(authorizeuser != null) {
				logInfo.setAuthuserid(authorizeuser.getUserid());
			}
			bean.setLogInfo(logInfo);
			this.workFlowOperationBL.processStatusButtonTreatmentExecute(bean);
		}
		if(dto.isAssignParticipant()) {
			dto.addMessage(new ActionMessage("IGPRR0102.I002"));
		} else {
			dto.addMessage(new ActionMessage("IGPRR0113.I001"));
		}
		log.debug("========����ԾǨ��������========");
		return dto;
	}
	
	/**
	 * ���ø���ID
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	private  List<IG599Info> setAttkey(List<IG599Info> processInfoList,Integer roleid, String userid,String[] attStr,Map<Integer, FormFile> fileMapMuti, String delStr) throws BLException {
		//�ı���󶨸�������
		List<String> existStr = new ArrayList<String>();
		if(attStr!=null){
			for(int i = 0; i < attStr.length; i++){
				String[] att = attStr[i].split("_");
				if(existStr.contains(att[0])){
					continue;
				}
				Integer piid;
				for(int j = 0; j < processInfoList.size();j++){
					IG599TB piTB = (IG599TB)processInfoList.get(j);
					if(att[0].equals(piTB.getPivarlabel()) && IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(piTB.getPidmode())){
						piid = piTB.getPiid();
						IG599Info pi = workFlowOperationBL.getProcessInfoByID(piid);
						if(IGPRDCONSTANTS.PIDMODE_PUBLIC.equalsIgnoreCase(pi.getPidmode())){
							continue;
						}
						IG899SearchCondImpl cond = new IG899SearchCondImpl();
						cond.setPiid(piid);
						if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equalsIgnoreCase(piTB.getPrivatescope())){
							cond.setUserid(userid);
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equalsIgnoreCase(piTB.getPrivatescope())){
							cond.setRoleid(roleid);
						}
						List<IG899Info> privateInfoList =  workFlowOperationBL.searchProcessPrivateInfo(cond);
						//˽�б�û�������Ϣ
						if(privateInfoList == null || privateInfoList.size() == 0){
							Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
							for(int k = 0; k < attStr.length;k++){
								if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
									if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
										filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
										if(!existStr.contains(pi.getPivarlabel())){
											existStr.add(pi.getPivarlabel());
										}
									}
								}
							}
							pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
							piTB.setPiattkey(pi.getPiattkey());
							processInfoList.set(j, piTB);
						}else{
							//˽�б��������Ϣ�����и���
							for(int iNum = 0; iNum < privateInfoList.size(); iNum++){
								IG899TB privateInfoTB = (IG899TB)privateInfoList.get(iNum);
								if(StringUtils.isNotEmpty(privateInfoTB.getPpiattkey())){
									Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
									for(int k = 0; k < attStr.length;k++){
										if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
											if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
												filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
												if(!existStr.contains(pi.getPivarlabel())){
													existStr.add(pi.getPivarlabel());
												}
											}
										}
									}
									workFlowOperationBL.addProcessInfoAtt(filemap, privateInfoTB.getPpiattkey());
								}else{
									Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
									for(int k = 0; k < attStr.length;k++){
										if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
											if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
												filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
												if(!existStr.contains(pi.getPivarlabel())){
													existStr.add(pi.getPivarlabel());
												}
											}
										}
									}
									pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
									piTB.setPiattkey(pi.getPiattkey());
									processInfoList.set(j, piTB);
								}
							}
						}
					}
				}
			}
		}
		
		return processInfoList;
	}
	
	
	
	/**
	 * ����ͼ��ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlActionForDrm(IGPRR01DTO dto) throws BLException {	
		

		StringBuffer isFocused = new StringBuffer();

		if(dto.getPrid() != null && dto.getPrid() > 0) {
			//��ȡ���̻�����Ϣ
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
			dto.setPdid(process.getPrpdid());
			
			List<String> list = workFlowOperationBL.searchCurrentRecordStatus(dto.getPrid());
			for(int i=0;i<list.size();i++){
				if(i > 0){
					isFocused.append(",");
				}
				
				if (!list.get(i).equals("null")) {
					String psdid = list.get(i).indexOf("_") >= 0 ? list.get(i).split("_")[0] : list.get(i);
					IG333Info info = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
					isFocused.append(list.get(i));
					if(info != null && StringUtils.isNotEmpty(info.getPpsdid())){
						isFocused.append(",");
						isFocused.append(info.getPpsdid());
					}
				} // end if 
			}
		}
		if(dto.getDprid() != null && dto.getDprid() > 0) {
			IG599SearchCondImpl piCond = new IG599SearchCondImpl();
			piCond.setPrid(dto.getDprid());
			piCond.setPivarname("���̶���ID");
			List<IG599Info> piList = workFlowOperationBL.searchProcessInfoByCond(piCond);
			if (piList != null && piList.size() > 0) {
				dto.setPdid(piList.get(0).getPivarvalue());
			}
		}
		if(StringUtils.isNotEmpty(dto.getPdid())) {
			//��ȡ���̶�����Ϣ
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(dto.getPdid());

			//��ȡ����ͼXML
			if(pd.getPdxml() != null){
				try{
					Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
					Element root = document.getRootElement();
					//���ҵ�ǰ����״̬�����Ľ��,������Ϊ������ʾ
					searchStep(root,isFocused.toString());
					dto.setFlowChartXml(document.asXML().replaceAll("\"", "'"));
					dto.setXmlheight(getXMLHeight(dto.getFlowChartXml()));
				}catch (DocumentException e) {
					throw new BLException("IGPRD0104.E005","��ǰ����������״̬ͼ�����ڡ�");
				}
			}
		}
		return dto;
	}
	
	
	
	/**
	 * ����ͼ��ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlAction(IGPRR01DTO dto) throws BLException {	
		
		StringBuffer isFocused = new StringBuffer();
		
		if(dto.getPrid() != null && dto.getPrid() > 0) {
			//��ȡ���̻�����Ϣ
			getProcessRecord(dto);
			List<String> list = workFlowOperationBL.searchCurrentRecordStatus(dto.getPrid());
			for(int i=0;i<list.size();i++){
				if(i > 0){
					isFocused.append(",");
				}
				String psdid = list.get(i).indexOf("_") >= 0 ? list.get(i).split("_")[0] : list.get(i);
				IG333Info info = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
				isFocused.append(list.get(i));
				if(info != null && StringUtils.isNotEmpty(info.getPpsdid())){
					isFocused.append(",");
					isFocused.append(info.getPpsdid());
				}
			}
		}

		if(StringUtils.isNotEmpty(dto.getPdid())) {
			//��ȡ���̶�����Ϣ
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(dto.getPdid());
			if(StringUtils.isEmpty(isFocused.toString())){
				if(dto.getPrid() != null && dto.getPrid() > 0) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(pr.getPrstatus()) 
							|| IGPRDCONSTANTS.PROCESS_TERMINATE.equals(pr.getPrstatus())){
						isFocused.append(pd.getPdid()).append("002");
					}
				}
			}
			
			//��ȡ����ͼXML
			if(pd.getPdxml() != null){
				try{
					Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
					Element root = document.getRootElement();
					//���ҵ�ǰ����״̬�����Ľ��,������Ϊ������ʾ
					searchStep(root,isFocused.toString());
					dto.setFlowChartXml(document.asXML().replaceAll("\"", "'"));
					dto.setXmlheight(getXMLHeight(dto.getFlowChartXml()));
				}catch (DocumentException e) {
					throw new BLException("IGPRD0104.E005","��ǰ����������״̬ͼ�����ڡ�");
				}
			}
		}
		return dto;
	}
	

	/**
	 * ����ͼ��ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchGroupFlowChartXml(IGPRR01DTO dto) throws BLException {
		if(dto.getPrid() != null && dto.getPrid() > 0) {
			//��ȡ���̻�����Ϣ
			IG483Info ig483info = ig483BL.searchIG483ByPK(dto.getPrid());
			if(null!=ig483info){
				dto.setPdid(ig483info.getPgdid());
				//��ȡ������״̬
				if(!StringUtils.isBlank(ig483info.getPgrclosetime())){
					//���������ʵ���йر�ʱ�� ���������ʵ���ѹر�
					dto.setStatus("C");
				}
			}
		}
		if(StringUtils.isNotEmpty(dto.getPdid())) {
			//��ȡ���̶�����Ϣ
			IG480Info pgd = ig480BL.searchIG480ByPK(dto.getPdid());
			//��ȡ����ͼXML
			if(null != pgd.getPgdxml()){
				try{
					Document document = DocumentHelper.parseText(new String(pgd.getPgdxml()));
					dto.setFlowChartXml(document.asXML().replaceAll("\"", "'"));
				}catch (DocumentException e) {
					throw new BLException("IGPRD0104.E005","��ǰ����������״̬ͼ�����ڡ�");
				}
			}
		}
		return dto;
	}
	
	/**
	 * ���ҵ�ǰ����״̬�����Ľ��,������Ϊ������ʾ
	 * 
	 * @param root
	 * @param psdid
	 */
	@SuppressWarnings("unchecked")
	private void searchStep(Element root, String psdids) {
		for (Iterator<Element> steps = root.elementIterator("Steps"); steps.hasNext();) {
			Element stepsElement = (Element) steps.next();
			for (Iterator<Element> step = stepsElement.elementIterator("Step"); step.hasNext();) {
				Element stepElement = (Element) step.next();
				for (Iterator<Element> baseProperties = stepElement.elementIterator("BaseProperties"); baseProperties.hasNext();) {
					Element bp = (Element) baseProperties.next();
					for (Iterator<Attribute> i = bp.attributeIterator(); i.hasNext();) {
						for (Iterator<Attribute> m = stepsElement.attributeIterator(); m.hasNext();) {
							Attribute stepAttribute = (Attribute) m.next();
							if("isFocusedId".equals(stepAttribute.getName())){
								stepAttribute.setValue(psdids);
								return;
							}
						}
					}

				}
			}
		}
	}
	
	
	/**
	 * <p>
	 * Description: ��ȡִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchProcessExecutorsAction(IGPRR01DTO dto) throws BLException {
		log.debug("========ִ���˲�ѯ����ʼ========");
		// ��ȡ����ӽ�ɫ
		List<IG602Info> lst_ProcessExecutorVW = workFlowOperationBL.searchProcessExecutors(dto.getUser().getUserid(), dto.getPrid());
		dto.setProcessExecutorVWList(lst_ProcessExecutorVW);
		log.debug("========ִ���˲�ѯ��������========");
		return dto;
	}
	

	/**
	 * <p>
	 * Description: ִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO adjustExecutorsAction(IGPRR01DTO dto) throws BLException {
		log.debug("========����ִ���˴���ʼ========");
		IGPRR0104Form form = dto.getIgPRR0104Form();
		User user = dto.getUser();
		String[] participants = form.getParticipants();
		List<IG337Info> pplist = workFlowOperationBL.queryRolemanager(user.getUserid(), dto.getPrid());
		List<Integer> lst_ppid_nodo = new ArrayList<Integer>();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		List<String> userList = new ArrayList<String>();
		if(participants != null) {
			for(IG337Info pp : pplist) {
				for(int i = 0; i < participants.length; i++) {
					if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(participants[i])) {
						lst_ppid_nodo.add(pp.getPpid());//˵����ִ�����ڲ����߱��д��ڣ�����Ҫ���д���
						participants[i] = null;
						break;
					}
	 			}
			}
			//����֪ͨ
			String datetime = IGStringUtils.getCurrentDateTime();
			//ȡ��״̬��Ϣ
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPsdcode(pr.getPrstatus());
			psdCond.setPdid(pr.getPrpdid());
			List<IG333Info> ig333List = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			IG333Info psdInfo = null;
			if(ig333List !=null && ig333List.size() > 0){
				psdInfo = ig333List.get(0);
			}else{
				throw new BLException("IGFLOW0000.E001", "״̬��" + pr.getPrstatus() + "��");
			}
			//����������
			Role role = null;
			User executor = null;
			for(String participant : participants) {
				if(participant != null) {
					role = this.roleBL.searchRoleByKey(new Integer(participant.split("_", 2)[0]));
					executor = this.userBL.searchUserByKey(participant.split("_", 2)[1]);
					userList.add(executor.getUserid());
					IG337TB ppTB = this.workFlowOperationBL.getProcessParticipantTBInstance();
					ppTB.setPproleid(role.getRoleid());
					ppTB.setPprolename(role.getRolename());
					ppTB.setPpuserid(executor.getUserid());
					ppTB.setPpusername(executor.getUsername());
					ppTB.setPporgid(executor.getOrgid());
					ppTB.setPporgname(executor.getOrgname());
					ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);//����������
					ppTB.setPpinittime(datetime);
					ppTB.setPrid(form.getPrid());
					ppTB.setPpstatus(pr.getPrstatus());
					this.workFlowOperationBL.addProcessParticipant(ppTB, user, role.getRoleid(),
							"(" + psdInfo.getPsdname() + ")��ӣ�" + ppTB.getPprolename()
							+ (StringUtils.isEmpty(ppTB.getPpusername()) ? "" : "(" + ppTB.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_ASSIGNPERSON_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL,
							dto.getAuthorizeuser(), dto.getAction(), null);
				}
			}
		}
		for(IG337Info pp : pplist) {
			if(!lst_ppid_nodo.contains(pp.getPpid())) {
				this.workFlowOperationBL.removeProcessParticipant(pp, user, pp.getPproleid(),
						"ɾ����" + pp.getPprolename()
						+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
						IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL,
						dto.getAuthorizeuser(), dto.getAction(), null);
			}
		}
		this.workFlowOperationBL.sendMessage(
				this.workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus()),
				userList, null, null, null, null, pr);
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========����ִ���˴�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ȡOAģʽִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchAssignOAPersonAction(IGPRR01DTO dto) throws BLException {
		log.debug("========ִ���˲�ѯ����ʼ========");
		IGPRR0109Form form = dto.getIgPRR0109Form();
		//��ȡOAģʽִ����
		UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
		cond.setRoleida(form.getRoleid());
		List<UserInfo> userlist = this.userBL.searchUserInfo(cond);
		List<String> useridList = new ArrayList<String>();
		UserInfo ui = null;
		for(Iterator<UserInfo> iter = userlist.iterator(); iter.hasNext();) {
			ui = iter.next();
			//���˽�ɫ�����˺�ֵ���� 
			if(IGPRDCONSTANTS.ROLEMANAGER.equals(ui.getRolemanager()) || 
					IGPRDCONSTANTS.DUTYPERSON.equals(ui.getDutyflag())) {
				iter.remove();
			}
		}
		
		//��ȡ���̲�����
		IG337SearchCondImpl ppCond = new IG337SearchCondImpl(); 
		
		ppCond.setPrid(form.getPrid());
		
		ppCond.setPproleid(form.getRoleid());
		
		ppCond.setPpstatus(workFlowOperationBL.searchProcessRecordByKey(form.getPrid()).getPrstatus());
		
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(ppCond);
		
		IG337Info pp = null;
		for(Iterator<IG337Info> iter = pplist.iterator(); iter.hasNext();) {
			pp = iter.next();
			//��ɫ�����˺�ֵ����
			if(!IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) && 
					!IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
				useridList.add(pp.getPpuserid());
			}
		}
				
		//��ʼ����ѡ��
		if(useridList.size() > 0) {
			form.setPpuserids(useridList.toArray(new String[0]));
		}
		dto.setUserInfoList(userlist);
		form.setRolename(this.roleBL.searchRoleByKey(form.getRoleid()).getRolename());
		log.debug("========ִ���˲�ѯ��������========");
		return dto;
	}
	

	/**
	 * <p>
	 * Description: ִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO assignOAPersonAction(IGPRR01DTO dto) throws BLException {
		log.debug("========ִ���˴���ʼ========");
		IGPRR0109Form form = dto.getIgPRR0109Form();
		
		User user = dto.getUser();
		//ִ����ID
		String[] ppuserid = form.getPpuserids();
		
		//��ȡ������Ϣ
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		
		//��ȡ���̲�����
		IG337SearchCondImpl cond = new IG337SearchCondImpl(); 
		
		cond.setPrid(form.getPrid());
		
		cond.setPproleid(form.getRoleid());
		
		cond.setPpstatus(pr.getPrstatus());
		
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(cond);
		
		IG337Info pp = null;
		if(ppuserid != null) {
			for(Iterator<IG337Info> iter = pplist.iterator(); iter.hasNext();) {
				pp = iter.next();
				//��ɫ�����˺�ֵ����
				if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
						IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
					iter.remove();
					continue;
				}
				for(int i = 0; i < ppuserid.length; i++) {
					if(ppuserid[i].equals(pp.getPpuserid())) {//�Ѵ���ִ����
						iter.remove();//ʣ�µľ�����Ҫɾ����ִ����
						ppuserid[i] = "";//ʣ�²�Ϊ�յľ�����Ҫ��ӵ�ִ����
						continue;
					}
				}
			}
			//ɾ��ִ����
			for(IG337Info participant : pplist) {
				workFlowOperationBL.removeProcessParticipant(participant,user,form.getRoleid(),
						"ɾ����" + participant.getPprolename()
						+ (StringUtils.isEmpty(participant.getPpusername()) ? "" : "(" + participant.getPpusername() + ")"),
						IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), null);
			}
			//���ִ����
			User implementor = null;
			String datetime = IGStringUtils.getCurrentDateTime();
			//����֪ͨ�б�
			List<String> userList = new ArrayList<String>();
			for(String userid : ppuserid) {
				if(StringUtils.isNotEmpty(userid)) {
					implementor = this.userBL.searchUserByKey(userid);
					IG337TB ppTB = this.workFlowOperationBL.getProcessParticipantTBInstance();
					ppTB.setPproleid(form.getRoleid());
					ppTB.setPprolename(form.getRolename());
					ppTB.setPpuserid(implementor.getUserid());
					ppTB.setPpusername(implementor.getUsername());
					ppTB.setPporgid(implementor.getOrgid());
					ppTB.setPporgname(implementor.getOrgname());
					ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);//����������
					ppTB.setPpinittime(datetime);
					ppTB.setPrid(form.getPrid());
					ppTB.setPpstatus(pr.getPrstatus());
					this.workFlowOperationBL.addProcessParticipant(ppTB, user,form.getRoleid(),
							"��ӣ�" + ppTB.getPprolename()
							+ (StringUtils.isEmpty(ppTB.getPpusername()) ? "" : "(" + ppTB.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_ASSIGNPERSON_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, dto.getAuthorizeuser(), dto.getAction(), null);
					userList.add(implementor.getUserid());
					
				}
			}
			this.workFlowOperationBL.sendMessage(
					this.workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus()),
					userList, null, null, null, null, pr);
		}
		dto.setProcess(pr);
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========ִ���˴�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ����״̬��־�鿴 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGPRR01DTO searchRecordStatusLogAction(IGPRR01DTO dto) throws BLException {
		log.debug("========�Զ��幤��״̬��־�鿴����ʼ========");
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","���̻���");
		}
		dto.setRecordStatusLogList(this.workFlowOperationBL.searchRecordStatusLog(dto.getPrid()));
		
		log.debug("========�Զ��幤��״̬��־�鿴��������========");
		return dto;
	}
	
	/**
	 * ���̹رպ���ʾ���б�����
	 */
	private IGPRR01DTO initDefVarOnClose(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//ȡ������
		IG500Info pr = dto.getProcess();
		
		//��ѯ�����̵����ж���ı�����
		List<IG007Info> infoDefList = workFlowOperationBL.getProcessInfoDefs(pr.getPrpdid());

		//��ѯ�����̵����б�����
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(pr.getPrid());
		
		if(infoDefList!=null && infoDefList.size()>0){
			Map<String,IG007Info> realmap = new LinkedHashMap<String,IG007Info>();
			//�������̱����ҵ�����������еı������壬�����̱�����ֵ���������Ӧ�����̱�������Ķ��󣬲��������̱��������������̱���Ȩ��(pidaccess)����Ϊֻ��
			for(IG007Info pid:infoDefList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						IG599TB temppi = (IG599TB)SerializationUtils.clone(temp_pi);
						pitb.setPidvalue(temppi.getPivarvalue());
						pitb.setPiid(temppi.getPiid());
						pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						//pitb.setPrivateaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL);
						if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
							if(null == temppi.getProcessPrivateInfofList() || temppi.getProcessPrivateInfofList().size() == 0){
								pitb.setProcessPrivateInfoList(null);
							}else{
								pitb.setProcessPrivateInfoList(temppi.getProcessPrivateInfofList());
							}
							pitb.setPidaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL);
							dto.setRoleid(9999);
						}
						realmap.put(pidid, pitb);
						break;
					}
				}
				
			}
			dto.setRealmap(realmap);
		}
		
		if(dto.getRealmap()!=null){
			dto.setVarmap(dto.getRealmap());
			dto.setHid("1");
		}else{
			dto.setVarmap(dto.getProcessInfoDefmap());
			dto.setHid("0");
		}
		
		
        form.setProcessName(dto.getProcessName());
		
		
		return dto;
	}
	
	
	/**
	 * ���̴���ҳ���ʼ������
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0102Action(IGPRR01DTO dto) throws BLException {
		//��ȡ����form
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//��ȡ�û�
		//User user = dto.getUser();
		
		//��ѯ����
		dto = getProcessRecord(dto);
		//��ѯ������ֵ
		dto = searchTableColumnValue(dto);
		//��ѯ�Ƿ����ȫ�ֿ��Ʊ�
		dto = isFormGlobalControl(dto);
		//��ʼ��������
		dto.setColumnInfoMap(workFlowOperationBL.initTableFormAction(dto.getPdid()));
		//��ʼ�����̱�ֵ
		initProcessInfoFormValue(dto);
		//��ʼ����Ա���ֵ
		initParticipantFormValue(dto);
		searchProcessTitleDef(dto);
		form.setPdid(dto.getPdid());
		
		//�������̴���ʱ��
		if (dto.getProcess().getPrclosetime()==null) {//��ǰ����״̬Ϊδ�ر�״̬
			//����ʱ��ĵ�ǰϵͳʱ���ȥ���̷���ʱ��
			try {
				dto.setDealtime(getBetweenTimeNumber(dto.getProcess().getPropentime(),IGStringUtils.getCurrentDateTime()));
			} catch (Exception e) {
				throw new BLException("IGPRR0102.E008");
			}
		}else{//��ǰ����״̬Ϊ�ر�״̬
			//����ʱ������̹ر�ʱ���ȥ���̷���ʱ��
			try {
				dto.setDealtime(getBetweenTimeNumber(dto.getProcess().getPropentime(),dto.getProcess().getPrclosetime()));
			} catch (Exception e) {
				throw new BLException("IGPRR0102.E008");
			}	
		}
		
		//��ȡ���������б�ֵ
		getOrgLabelValueBeans(dto);
		
		//��������״̬�������ݵ�ǰ����״̬ȡ�ò�����
		//��ȡ���̵�ǰ״̬����
		if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getProcess().getPrstatus()) && !IGPRDCONSTANTS.PROCESS_TERMINATE.equals(dto.getProcess().getPrstatus())) {
			List<String> lst_status = this.workFlowOperationBL.searchCurrentRecordStatus(dto.getProcess().getPrid());
			if(lst_status.size() > 1) {
				List<LabelValueBean> lst_LabelValueBean = new ArrayList<LabelValueBean>();
				IG333SearchCondImpl cond = new IG333SearchCondImpl();
				cond.setPdid(dto.getProcess().getPrpdid());
				IG333Info ig333Info = null;
				//���ҳ���õ�ǰ״̬�����б�
				for(String status : lst_status) {
					String psdid = "";
					if (status.indexOf("_") > -1) {
						psdid = status.split("_")[0];
					} else {
						psdid = status;
					}
					ig333Info = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
					lst_LabelValueBean.add(new LabelValueBean(ig333Info.getPsdname(), status));
				}
				dto.setLst_status(lst_LabelValueBean);
			}
			if(StringUtils.isEmpty(form.getPrstatus())) {
				//δָ��״̬ʱ��Ĭ����ʾ��һ��������״̬��Ϣ
				if(lst_status.isEmpty()) {
					dto.setStatus("");
				} else {
					dto.setStatus(lst_status.get(0));
				}
			} else {
				dto.setStatus(form.getPrstatus());
			}
		} else {
			//�رջ���ֹ״̬
			dto.setStatus(dto.getProcess().getPrstatus());
		}
		dto.setPsdcode(dto.getStatus());
		
		//��ȡ�����ɫ�б�
		dto = searchReadProcessParticipantRoleAction(dto);
		//====>130225Begin
		dto.setPsdassign(dto.getProcessStatusDef()!=null?dto.getProcessStatusDef().getPsdassign():"");
		//====>130225End
		//ȡ����־��Ϣ
		dto = getRecordLogs(dto);
		
		//��ѯ��������(�����̱���������������)
		dto = getProcessRecordByRelations(dto);
		
		//�ǹر�״̬
		if(StringUtils.isNotEmpty(dto.getStatus()) && !IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getStatus()) && !IGPRDCONSTANTS.PROCESS_TERMINATE.equals(dto.getStatus()) ){
			//��ȡ�����ɫ��Ϣ
			dto = getProcessParticipantsByStatus(dto);
			
			//��������̹���Ա��ɼ���д���б�
			List<Role> roleList = roleBL.getRoleByType(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
			Role role = roleList.get(0);
			if(dto.isAdminRole()){
				//List<LabelValueBean> roleList1 = new ArrayList<LabelValueBean>();
				List<LabelValueBean> roleList1 = dto.getLabelList();
				roleList1.add(new LabelValueBean(role.getRolename(),"0" + "_" + role.getRoleid() + "_" + dto.getUser().getUserid()));
				dto.setLabelList(roleList1);
			}
			
			//ȡ�ð�ť
			dto = getActionList(dto);
		
			//��������̹���Ա��ɼ���д���б�����ֻ��������Ա����
			if(role.getRoleid().equals(dto.getRoleid())
					|| (StringUtils.isNotEmpty(dto.getPpidstr())
							&& role.getRoleid().toString().equals(dto.getPpidstr().split("_")[1]))
					|| (dto.getLabelList() != null && dto.getLabelList().size() > 0
							&& role.getRoleid().toString().equals(dto.getLabelList().get(0).getValue().split("_")[1]))){//���̹���Ա
				if(dto.getLst_ParticipantVisibleButtonVWInfo() != null) {
					dto.getLst_ParticipantVisibleButtonVWInfo().clear();
				}
				dto = initDefVarForAdmin(dto);
				dto.setRoleManager(false);
				dto.setSuperFlag(null);
			} else {
				//���ñ�����
				dto = initDefVar(dto);
				dto.setAdminRole(false);
			}
		}  else {
			//���̹���Ա���б��ɼ�
			if(dto.isAdminRole()){
				dto = initDefVarOnClose(dto);
			} else {
				//���ݲ���Ȩ����ʾ
				dto = searchProcessInfoForSearch(dto);
				if(dto.getRealmap()!=null){
					dto.setVarmap(dto.getRealmap());
				}else{
					dto.setVarmap(dto.getProcessInfoDefmap());
				}
				//�������̲�����ʱ����ʾ�����̵ı���Ϣ
				if(dto.getVarmap()==null||dto.getVarmap().size()<0){
					Map<String,IG007Info> processInfoDefnewmap=new HashMap<String, IG007Info>();
					processInfoDefnewmap=getPorcesssInfoDefNewMap(dto.getPrid(),dto.getPdid(),dto.getUser());
					if(processInfoDefnewmap!=null&&processInfoDefnewmap.size()>0){
						//ɾ�����صı�
						dto.setVarmap(processInfoDefnewmap);
						dto.setHid("1");
					}
				}
			}
			dto.addMessage(new ActionMessage("IGPRR0102.I004"));
		}
		//

		//��У��δͨ��ʱ�����ý�ɫ
		if((dto.getRoleid()!= null && dto.getRoleid()!=0 )&& (form.getIserr()!=null && form.getIserr()!=1)){
			form.setPpidstr(dto.getPpidstr());
		}
		if((form.getIserr()!=null && form.getIserr()==1)){
			form.setIserr(0);
		}
		form.setPsdid(dto.getPsdid());//����״̬ID�����ر�ʹ��
		
		//��ȡ״̬˽�б�ֵ
		this.getStatusPrivateValue(dto);
	    //���̴��ڹر�״̬�����̲鿴��ʾ����Ҫ��״̬������������ʽ��ʾ 
        this.statusCloseSeeOperate(dto) ;       
		return dto;
	}
	
	/**
	 * ������תJSPȡ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchForwardJsp(IGPRR01DTO dto) throws BLException {
		log.debug("========������תJSPҳ���ѯ����ʼ========");
		String forward = workFlowOperationBL.searchForwardJsp(dto.getPdid(), dto.getPrid(), dto.getPjdtype(), dto.getUser());
		dto.setForwardJsp(forward);
		log.debug("========������תJSPҳ���ѯ�������========");
		return dto;
	}
	
	/**
	 * ��ͨ�ڵ�SUPER���ɳ�ʼ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0113Action(IGPRR01DTO dto) throws BLException {
		log.debug("========�����߲�ѯ����ʼ========");
		IGPRR0113Form form = dto.getIgPRR0113Form();
		//��ѯ��ǰ�ڵ���Ϣ
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		form.setPsdassign(psd.getPsdassign());
		form.setPsdtype(psd.getPsdtype());
		form.setPsdmode(psd.getPsdmode());
		if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
			//��ѯ�ɱ����ɻ���
			List<IG299Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusOrgDefInfoByPsdid(form.getPsdid());
			List<Organization> org_List = new ArrayList<Organization>();
			if(lst_ProcessStatusRoleDef!=null){
				for(IG299Info pro:lst_ProcessStatusRoleDef){
					org_List.add(pro.getOrg());
				}
			}
			// ��ȡ����ӻ���
			List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
			if(pplist != null){
				String[] ids = new String[pplist.size()];
				for(int i = 0; i < pplist.size(); i++){
					ids[i] = pplist.get(i).getPporgid() + "_"+pplist.get(i).getPporgname();
					//�趨���첿�Ž�ɫID
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(pplist.get(i).getPpsuper())) {
						form.setPpsuperorgid(pplist.get(i).getPporgid()+"_"+pplist.get(i).getPporgname());
					}
				}
				form.setParticipants(ids);
			}
			
			dto.setOrg_List(org_List);
		}else{
			//��ѯ���趨��ɫ
			List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(form.getPsdid());
			// ��ȡ����ӽ�ɫ
			IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
			ppcond.setPrid(form.getPrid());
			ppcond.setPsdid(form.getPsdid());
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(ppcond);
//			List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
//			IG333Info psd = this.ig333BL.searchIG333InfoByKey(form.getPsdid());
//			form.setPsdassign(psd.getPsdassign());
//			form.setPsdtype(psd.getPsdtype());
//			form.setPsdmode(psd.getPsdmode());
			if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign()) || "0".equals(form.getFlag())) {
				List<Role> lst_Role = new ArrayList<Role>();
				for(IG298Info psrd : lst_ProcessStatusRoleDef) {
					lst_Role.add(psrd.getRole());
				}
				dto.setRoleList(lst_Role);
			} 
			if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
//			} else if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
				Map<Role, List<IG602Info>> map_ParticipantToBeAssign = new LinkedHashMap<Role, List<IG602Info>>();
				UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
				for(IG298Info psrd : lst_ProcessStatusRoleDef) {
					cond.setRoleid(psrd.getRoleid());
					if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
						cond.setOrgid_like(dto.getUser().getOrgid());
					}
					map_ParticipantToBeAssign.put(psrd.getRole(),
							this.workFlowOperationBL.searchSuperAssignExecutors(psrd.getRole().getRoleid(), form.getPrid()));
				}
				dto.setMap_ParticipantToBeAssign(map_ParticipantToBeAssign);
			}
			if(!pplist.isEmpty()) {
				String[] ids = new String[pplist.size()];
				for(int i = 0; i < pplist.size(); i++) {
					if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign()) || "0".equals(form.getFlag())) {
						ids[i] = pplist.get(i).getPproleid() + "_";
//					} else if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
					} 
					if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
						ids[i] = pplist.get(i).getPproleid() + "_" + (pplist.get(i).getPpuserid() == null ? "" : pplist.get(i).getPpuserid());
					}
					//�趨���첿�Ž�ɫID
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(pplist.get(i).getPpsuper())) {
						form.setPpsuperid(pplist.get(i).getPproleid());
					}
				}
				form.setParticipants(ids);
			}
		}
		
		log.debug("========�����߲�ѯ��������========");
		return dto;
	}
	
	/**
	 * SUPER��ɫ�����߷��ɴ���
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantBySuper(IGPRR01DTO dto) throws BLException {
		log.debug("========�����߷��ɴ���ʼ========");
		IGPRR0113Form form = dto.getIgPRR0113Form();
		//��ȡ������Ϣ
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		dto.setProcess(pr);
		List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
		String selected_participants = form.getSelected_participants();
		List<String> lst_Selected = null;
		if(StringUtils.isNotEmpty(selected_participants)) {
			lst_Selected = Arrays.asList(selected_participants.split("###"));
		} else {
			lst_Selected = new ArrayList<String>();
		}
		List<Integer> lst_ppid_nodo = new ArrayList<Integer>();
		String[] participants = form.getParticipants();
		List<IG337Info> participantPptypeRList = new ArrayList<IG337Info>();
		if(participants != null) {
			for(IG337Info pp : pplist) {
			    if (pp.getPptype().equals(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE)) {
			        participantPptypeRList.add(pp);
			    }
				for(int i = 0; i < participants.length; i++) {
					if(StringUtils.isEmpty(form.getFlag())) {//Super����
						//�ж��Ƿ��ָ����
						if(IGPRDCONSTANTS.MODE_NORMAL.equals(form.getPsdmode()) && IGPRDCONSTANTS.PSDASSIGN_USER.equals(form.getPsdassign())) {
							if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(participants[i])) {
								lst_ppid_nodo.add(pp.getPpid());//˵����ִ�����ڲ����߱��д��ڣ�����Ҫ���д���
								participants[i] = null;
								break;
							}
						} else {
							if((pp.getPproleid() + "_").equals(participants[i])) {
								lst_ppid_nodo.add(pp.getPpid());//˵����ִ�����ڲ����߱��д��ڣ�����Ҫ���д���
								participants[i] = null;
								break;
							}
						}
					} else if("0".equals(form.getFlag())) {//����Ա������ɫ
						if((pp.getPproleid() + "_").equals(participants[i])) {
							lst_ppid_nodo.add(pp.getPpid());//˵����ִ�����ڲ����߱��д��ڣ�����Ҫ���д���
							participants[i] = null;
							break;
						}
					} else if("1".equals(form.getFlag())) {//����Ա������Ա������δָ����Ա�Ľ�ɫ
						if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(participants[i])) {
							lst_ppid_nodo.add(pp.getPpid());//˵����ִ�����ڲ����߱��д��ڣ�����Ҫ���д���
							participants[i] = null;
							break;
						} 
	//					else if(participants[i] != null && !participants[i].startsWith(pp.getPproleid() + "_")) {
	//						lst_ppid_nodo.add(pp.getPpid());//˵����ִ�����ڲ����߱��д��ڣ�����Ҫ���д���
	//						participants[i] = null;
	//						break;
	//					}
					}
				}
			}
		}
		String datetime = IGStringUtils.getCurrentDateTime();
		//����������
		List<IG337Info> participantList= new ArrayList<IG337Info>();
		List<String> userList = new ArrayList<String>();
		UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
		List<UserInfo> uilist = null;
		if(participants != null){
			Role role = null;
			User executor = null;
			for(String participant : participants){
				if(StringUtils.isNotEmpty(participant)) {
					role = this.roleBL.searchRoleByKey(new Integer(participant.split("_", 2)[0]));
					IG337TB newParticipant = this.workFlowOperationBL.getProcessParticipantTBInstance();
					newParticipant.setPrid(form.getPrid());
					newParticipant.setPpinittime(datetime);
					newParticipant.setPpstatus(pr.getPrstatus());
					
					String psdid = "";
					if(form.getPrstatus() == null) {
						//do nothing
					} else {
						psdid = form.getPrstatus();
						if (psdid.length() > 1) {
							if (psdid.indexOf("_") > -1) {
								newParticipant.setPsdid(psdid.split("_")[0]);
								newParticipant.setPsdnum(new Integer(psdid.split("_")[1]));
							} else {
								newParticipant.setPsdid(psdid);
							}
						} else {
							//do nothing
						}
					}
					newParticipant.setPproleid(role.getRoleid());
					newParticipant.setPprolename(role.getRolename());
					if(role.getRoleid().equals(form.getPpsuperid())) {
						newParticipant.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
					}
					if(IGPRDCONSTANTS.MODE_NORMAL.equals(form.getPsdmode())) {//��ͨģʽ���Լ���
						if(StringUtils.isEmpty(participant.split("_", 2)[1])) {
							newParticipant.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
						} else {
							executor = this.userBL.searchUserByKey(participant.split("_", 2)[1]);
							userList.add(executor.getUserid());
							newParticipant.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							
							newParticipant.setPpuserid(executor.getUserid());
							
							newParticipant.setPpusername(executor.getUsername());
							
							newParticipant.setPporgid(executor.getOrgid());
							
							newParticipant.setPporgname(executor.getOrgname());
						}
						participantList.add(newParticipant);
					} else {
							cond.setRoleida(role.getRoleid());
							//�����OAģʽ����ֵ���˺ͽ�ɫ��������Ϊ������
							uilist = this.userBL.searchUserInfo(cond);
							
							//��ɫ�����˴��ڱ�ʶ
							boolean flag = true;
							
							for(UserInfo info : uilist) {
								//�Ƿ��ɫ������
								if(IGPRDCONSTANTS.ROLEMANAGER.equals(info.getRolemanager())) {
									flag = false;
									IG337TB tb = (IG337TB)SerializationUtils.clone(newParticipant);
									tb.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
									tb.setPpuserid(info.getUserida());
									tb.setPpusername(info.getUsername());
									tb.setPporgid(info.getOrgida());
									tb.setPporgname(info.getOrgname());
									participantList.add(tb);
								}
								//�Ƿ�ֵ����
								if(IGPRDCONSTANTS.DUTYPERSON.equals(info.getDutyflag())) {
									IG337TB tb = (IG337TB)SerializationUtils.clone(newParticipant);
									tb.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
									tb.setPpuserid(info.getUserida());
									tb.setPpusername(info.getUsername());
									tb.setPporgid(info.getOrgida());
									tb.setPporgname(info.getOrgname());
									participantList.add(tb);
								}
							}
							
							if(flag) {
								throw new BLException("IGCO10000.E004","��ɫ��"+ newParticipant.getPprolename() + "�������˻���");
							}
						}
					}
				} 
			}
		//��Ӳ�����
		for(IG337Info pp : participantList) {
			this.workFlowOperationBL.addProcessParticipant(pp, dto.getUser(),form.getRoleid(),
					"��ӣ�" + pp.getPprolename()
					+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
					IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE,null,
					IGPRDCONSTANTS.RECORDLOG_TYPE_CL, dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
			// ��Ӿ�����ԱΪ������ʱ����ɾ��ָ��Ϊ��ɫ�Ĳ�������Ϣ��
		    for (int i = 0 ; i < participantPptypeRList.size() ; i++) {
		        IG337Info ig337info = participantPptypeRList.get(i);
		        if (ig337info.getPproleid().equals(pp.getPproleid())) {
		            this.workFlowOperationBL.removeProcessParticipant(ig337info, dto.getUser(), ig337info.getPproleid(),
                            "ɾ����" + ig337info.getPprolename()
                            + (StringUtils.isEmpty(ig337info.getPpusername()) ? "" : "(" + ig337info.getPpusername() + ")"),
                            IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
                            IGPRDCONSTANTS.RECORDLOG_TYPE_CL,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
		            participantPptypeRList.remove(ig337info);
		            i--;
		        }
            }
		}
		for(IG337Info pp : pplist) {
			//��ת��ɫ
			if("0".equals(form.getFlag())) {
				if(!lst_ppid_nodo.contains(pp.getPpid()) && lst_Selected.contains(
						pp.getPproleid() + "_")) {
					this.workFlowOperationBL.removeProcessParticipant(pp, dto.getUser(), pp.getPproleid(),
							"ɾ����" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
				}
			} else {
				if(!lst_ppid_nodo.contains(pp.getPpid()) && lst_Selected.contains(
						pp.getPproleid() + "_"
								+ (StringUtils.isEmpty(pp.getPpuserid()) ? "" : pp.getPpuserid()))) {
					this.workFlowOperationBL.removeProcessParticipant(pp, dto.getUser(), pp.getPproleid(), 
							"ɾ����" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
				}
			}
		}
		//���鵱ǰ״̬���в������Ƿ������,ȫ��������������һ�������˵ļ�¼ԾǨ
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		//�������ӵĲ����߷�֪ͨ
		boolean flag = false;
		String psdid = "";
		if(form.getPrstatus() == null) {
			//do nothing
		} else {
			psdid = form.getPrstatus();
			if (psdid.length() > 1) {
				if (psdid.indexOf("_") > -1) {
					flag = true;
					psdid = psdid.split("_")[0];
				} else {
					flag = true;
				}
			} else {
				//do nothing
			}
		}
		if(flag) {
			this.workFlowOperationBL.sendMessage(psdid,
					userList, null, null, null, null, pr);
		} else {
			this.workFlowOperationBL.sendMessage(
					this.workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus()),
					userList, null, null, null, null, pr);
		}
		dto.addMessage(new ActionMessage("IGPRR0113.I001"));
		log.debug("========�����߷��ɴ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ͨ������״̬������id��ѯ������
	 * </p>
	 * 
	 * @param dto IGSVC02DTO
	 * @return IGSVC02DTO
	 * @throws BLException
	 * @author   
	 */
	
	private IGPRR01DTO getProcessParticipantsByStatusPrid(IGPRR01DTO dto) throws BLException {
		
		String status = dto.getStatus();
		if(StringUtils.isNotEmpty(status)) {
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(), status);
			dto.setProcessParticipantList(pplist);
		}
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ͨ������id��login�û���ѯ��Ȩ��
	 * </p>
	 * 
	 * @param dto IGSVC02DTO
	 * @return IGSVC02DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGPRR01DTO getAuthorizeuser(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = (IGPRR0102Form) dto.getIgPRR0102Form();
		// ����id��ѯ���̼�¼
		IG500TB processRecordTB = (IG500TB) workFlowOperationBL.searchProcessRecordByKey(form.getPrid());

		// ���̽ڵ��ѯ��������
		IG333SearchCondImpl pscond = new IG333SearchCondImpl();
//		pscond.setPsdcode(processRecordTB.getPrstatus());
		pscond.setPsdcode(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(processRecordTB.getPrstatus())?IGPRDCONSTANTS.PROCESS_END_STATUS:processRecordTB.getPrstatus());
		pscond.setPdid(processRecordTB.getPrpdid());

		// ���̽ڵ�״̬��Ϣ��ѯ
		List<IG333Info> list = workFlowDefinitionBL.searchProcessStatusDef(pscond);
		String psmode = list.get(0).getPsdmode();

		IG711SearchCondImpl cond = new IG711SearchCondImpl();
		// BLȡ��

		cond.setLoginUser(dto.getUser().getUserid());
		cond.setPaflag("1");// ��Ȩ��
		List<IG711Info> processAccreditList = null;

		// ���ڵ�ģʽΪOAģʽʱֱ���ж���Ȩ
		if (psmode.equals(IGPRR01BLType.PROCESSMODE_OA)) {
			// ��Ȩ��Ϣ��ѯ
			processAccreditList = workFlowOperationBL.searchProcessAccredit(cond);
			if (processAccreditList != null && processAccreditList.size() > 0) {

				String patype = processAccreditList.get(0).getPatype();
				String auid = processAccreditList.get(0).getPaiid();
				List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(auid);
				boolean workflag = true;
				boolean hasAuthorizeuser = false;
				// ��һ������Ȩģʽ
				if ("1".equals(patype)) {

					if (!form.getPrid().equals(
							processAccreditList.get(0).getPaprocessid())) {
						workflag = false;
					}
				}
				// ���й�����Ȩģʽ
				if ("0".equals(patype) || workflag) {
					dto.setPrid(form.getPrid());
					dto.setStatus(form.getPrstatus());
					dto = getProcessParticipantsByStatusPrid(dto);
					List<IG337Info> pplist = dto
							.getProcessParticipantList();
					if (pplist != null) {
						for (int i = 0; i < pplist.size(); i++) {
							if (pplist.get(i).getPpproctime() == null) {// ���û�δ��������
								if (auid.equals(pplist.get(i).getPpuserid())) {// �����û�id����
									hasAuthorizeuser = true;
									break;
								} else if (userroleList != null) {// ���ս�ɫ����
									for (UserRoleInfo uri : userroleList) {
										if (uri.getRoleid().equals(
												pplist.get(i).getPproleid())) {
											hasAuthorizeuser = true;
											break;
										}
									}
								}
							}
						}
					}

				}
				if (hasAuthorizeuser) {

					User authorizeuser = userBL.searchUserByKey(auid);
					dto.setAuthorizeuser(authorizeuser);
				}

			}
		} else
		// ���ڵ�ģʽΪ��ͨģʽʱ���ж��Ƿ��ǵ�ǰ��¼�û�����ع��������ж���Ȩ
		if (psmode.equals(IGPRR01BLType.PROCESSMODE_MO)) {

			// ������ع�����ʶ
			Boolean falg = false;

			// ��ȡ�û���Ϣ
			User user = dto.getUser();

			// ��ѯ��ǰ�û���ɫ
			List<UserRoleInfo> roleList = userRoleBL.getUserRoles(user
					.getUserid());

			IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
			List<IG337Info> ppList;
			for (UserRoleInfo ur : roleList) {// ѭ��������ǰ�û���ɫ
				// ���ò�����Ա��ѯ����
				ppcond.setPrid(form.getPrid());
				ppcond.setPpstatus(processRecordTB.getPrstatus());
				ppcond.setPproleid(ur.getRoleid());
				// ��ѯ������Ա��Ϣ
				ppList = this.workFlowOperationBL
						.searchProcessParticipants(ppcond);

				// �жϽ�����Ƿ�Ϊ��
				if (ppList != null && ppList.size() > 0) {// ��Ϊ��˵���ǵ�ǰ�û�����ع���
					// falgֵ����Ϊ
					falg = true;
					// �Ƴ�ѭ��
					break;
				}
			}

			// falgֵΪfalseʱ˵����Ϊ��ǰ�û�����ع������������Ȩ�ж�
			if (!falg) {
				// ��Ȩ��Ϣ��ѯ
				processAccreditList = workFlowOperationBL.searchProcessAccredit(cond);

				if (processAccreditList != null
						&& processAccreditList.size() > 0) {

					String patype = processAccreditList.get(0).getPatype();
					String auid = processAccreditList.get(0).getPaiid();
					List<UserRoleInfo> userroleList = userRoleBL
							.getUserRoles(auid);
					boolean workflag = true;
					boolean hasAuthorizeuser = false;
					// ��һ������Ȩģʽ
					if ("1".equals(patype)) {

						if (!form.getPrid().equals(
								processAccreditList.get(0).getPaprocessid())) {
							workflag = false;
						}
					}
					// ���й�����Ȩģʽ
					if ("0".equals(patype) || workflag) {
						dto.setPrid(form.getPrid());
						dto.setStatus(form.getPrstatus());
						dto = getProcessParticipantsByStatusPrid(dto);
						List<IG337Info> pplist = dto
								.getProcessParticipantList();
						if (pplist != null) {
							for (int i = 0; i < pplist.size(); i++) {
								if (pplist.get(i).getPpproctime() == null) {// ���û�δ��������
									if (auid
											.equals(pplist.get(i).getPpuserid())) {// �����û�id����
										hasAuthorizeuser = true;
										break;
									} else if (userroleList != null) {// ���ս�ɫ����
										for (UserRoleInfo uri : userroleList) {
											if (uri
													.getRoleid()
													.equals(
															pplist
																	.get(i)
																	.getPproleid())) {
												hasAuthorizeuser = true;
												break;
											}
										}
									}
								}
							}
						}

					}
					if (hasAuthorizeuser) {

						User authorizeuser = userBL.searchUserByKey(auid);
						dto.setAuthorizeuser(authorizeuser);
					}

				}
			}
		}

		return dto;
	}
	
	public IGPRR01DTO terminate(IGPRR01DTO dto) throws BLException {
		log.debug("========����Ա��ֹ����ʼ========");
		//IGPRR0106Form form = dto.getIgPRR0106Form();
		IGPRR0102Form form = dto.getIgPRR0102Form();
		User user = dto.getUser();
		//����Ա����
		List<Role> roleList = roleBL.getRoleByType(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
		form.setRoleid(roleList.get(0).getRoleid());
		if(0 == roleList.size()){
			throw new BLException("IGCO10000.E004","���̹���Ա��ɫ");
		}
		form.setPrrolename(roleList.get(0).getRolename());
		String datetime = IGStringUtils.getCurrentDateTime();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		if(pr == null){
			throw new BLException("IGCO10000.E004","��������");
		}
		
		//������ֹʱ���Ե������⴦��  start  wangtingzhi 20130422
		//�Զ����¼�����BL
		WorkFlowEventHandlerBL bl = null;
		//��ȡԴ״̬�����¼��б�
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPdid(pr.getPrpdid());
		cond.setPedtype(IGPRDCONSTANTS.PROCESS_TERMINATE);
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		if(pedList!=null&&!pedList.isEmpty()){
			igflowlog.debug("========================"
                    + pr.getPrserialnum()
                    + "�����¼���ʼ========================");
		    igflowlog.debug("�����������ƣ�" + pr.getPrpdname());
		    igflowlog.debug("��������ID��" + pr.getPrpdid());
            igflowlog.debug("����ID��" + pr.getPrid());
            igflowlog.debug("�����û�ID��" + user.getUserid());
            igflowlog.debug("�����ɫID��" + form.getRoleid());
            for(IG413Info ped:pedList){
            	try {
	                bl = (WorkFlowEventHandlerBL)WebApplicationSupport.getBean(ped.getPedblid());
	            } catch (Exception e) {
	                throw new BLException("IGCO10000.E004", "�����¼�����");
	            }
	            igflowlog.debug("����BL" + ped.getPedorder()+":"+ ped.getPedblid());
	          //ǰ���������Ϣ
	    		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
	    		bean.setPdid(pr.getPrpdid());
	    		bean.setPbdid(IGPRDCONSTANTS.BUTTON_TERMINATE);
	    		bean.setBfstatus(pr.getPrstatus());
	    		bean.setAfstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
	    		bean.setCrtroleid(pr.getPrroleid());
	    		bean.setCrtuserid(pr.getPruserid());
	    		//��־������Ϣ
	    		WorkFlowLog logInfo = new WorkFlowLog();
	    		logInfo.setPrid(pr.getPrid());
	    		logInfo.setExecutorid(user.getUserid());
	    		logInfo.setExecutorRoleid(form.getRoleid());
	    		bean.setLogInfo(logInfo);
	            bl.afterTreatmentExecute(bean);
            }
		}
		
		//��ѯ��ǰ�ڵ�ڵ������ 
		IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
		ppcond.setPrid(pr.getPrid());
		ppcond.setPpstatus(pr.getPrstatus());
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(ppcond);
		if(pplist!=null){
			for(IG337Info pp:pplist){
				if(StringUtils.isEmpty(pp.getPpproctime())){
					IG337TB ppTB = (IG337TB) SerializationUtils.clone(pp);
					ppTB.setPpproctime(IGStringUtils.getCurrentDateTime());
					workFlowOperationBL.updateProcessParticipant(ppTB);
				}
			}
		}
		
		//��ȡ��ǰ����״̬
		String currentStatus = workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus());
		
		//������ֹʱ���Ե������⴦��  end  wangtingzhi 20130422
		//���������ֹ��״̬��־
		workFlowOperationBL.addRecordStatusLog(pr.getPrid(), pr.getPrpdid(), pr.getPrtype(), currentStatus, IGPRDCONSTANTS.PROCESS_TERMINATE, WorkFlowConstDefine.STATUSTYPE_END_TERMINATE, pr.getPid());
		IG500TB processRecord = (IG500TB)SerializationUtils.clone(pr);
		processRecord.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
		processRecord.setPrclosetime(datetime);
		workFlowOperationBL.updateProcessRecord(pr.getPrstatus(),processRecord,user,form.getPrroleid(),form.getRlcomment(),
				IGPRDCONSTANTS.COMMENT_TERMINATE_MESSAGE,form.getFileMap(),
				IGPRDCONSTANTS.RECORDLOG_TYPE_CL, dto.getAuthorizeuser(), null, form.getPrstatus());
		dto.setProcess(pr);
		sendMessageToOpener(pr.getPruserid(), pr,"��ֹ");
		dto.addMessage(new ActionMessage("IGPRR0106.I001",dto.getPrid()));
		log.debug("========����Ա��ֹ��������========");
		return dto;
	}
	
	/**
	 * �������߷�����
	 * 
	 * @param userid
	 * @param prid
	 * @throws BLException 
	 */
	private void sendMessageToOpener(String userid, IG500Info ig500, String sms) throws BLException{
		List<String> lst_Userid = new ArrayList<String>();
		lst_Userid.add(userid);
		String message ="����("+ig500.getPrtitle()+")��"+ig500.getPrpdname()+"������"+sms+"��";
		this.workFlowOperationBL.sendMessage(
				this.workFlowDefinitionBL.searchProcessStatusKey(ig500.getPrpdid(), IGPRDCONSTANTS.PROCESS_TERMINATE.equals(ig500.getPrstatus())?IGPRDCONSTANTS.PROCESS_END_STATUS:ig500.getPrstatus()),
				lst_Userid, message, null, null, null, ig500);
	}
	//�ı��򸽼����
	public IGPRR01DTO getProcessInfoAtt(IGPRR01DTO dto) throws BLException {
		log.debug("========��ȡ�ı��򸽼���ô���ʼ========");
		List<IG036Info> recordLogList = null;
		
			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
			dto.setRecordLogList(recordLogList);
		log.debug("========��ȡ�ı��򸽼���ô�������========");
		return dto;
	}
	public Map<String,List<Attachment>> getProcessInfo(int prid) throws BLException{
		//��ѯProcessInfo
		List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(prid);
		Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
		for(int i=0;i<processInfolist.size();i++){
			if(processInfolist.get(i).getPiattkey()!=null){
				List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
				map.put(processInfolist.get(i).getPivarname(), list);
			}
		}
		return map;
	}

	/**
	 * ɾ��������Ϣ
	 * 
	 * @param attid
	 * @param rlid
	 * @throws BLException
	 */
	public boolean deleteFile(Integer attid, Integer rlid) throws BLException{
		
		// ���ݸ���������ѯ������Ϣ
		Attachment attachment = this.attachmentBL.searchAttachmentByKey(attid);
		// ����ɾ��������Ϣ
		if(attachment != null){
			this.attachmentBL.deleteAttachment(attachment);
		}else{
			return false;
		}
		return true;
	}
	
	/**
	 * �����ɫ��Ϣ��ѯ����
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	private IGPRR01DTO searchProcessTitleDef(IGPRR01DTO dto) throws BLException {
		
		log.debug("========�������������ѯ����ʼ========");
		//�������������ѯ����
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPdid(dto.getPdid());
		List<IG243Info> lstProcessTitleDef = this.workFlowDefinitionBL.searchProcessTitleDef(cond);
		if(lstProcessTitleDef == null || lstProcessTitleDef.size() ==0) {
			IG243TB tb = new IG243TB();
			tb.setPtitleaccess(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT);
			tb.setPdescaccess(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT);
			dto.setPtdTB(tb);
		}else{
			dto.setPtdTB((IG243TB)lstProcessTitleDef.get(0));
		}
		log.debug("========�������������ѯ��������========");
		return dto;
	}
	
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ�������û�����ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantDefToBeAssignAction(IGPRR01DTO dto) throws BLException {
		log.debug("========ָ��״̬�ɷ��ɽ�ɫ��ѯ�������û�������ʼ========");
		//��ѯ���趨��ɫ
		List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(dto.getProcessStatusDef().getPsdid());
		Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserRoleInfo>>();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		for(IG298Info psrd : lst_ProcessStatusRoleDef) {
			cond.setRoleid(psrd.getRoleid());
			if(IGPRDCONSTANTS.PSDORG_YES.equals(dto.getProcessStatusDef().getPsdorg())) {
				cond.setOrgid_like(dto.getUser().getOrgid());
			}
			map_ParticipantDefToBeAssign.put(psrd.getRole(), this.userRoleBL.searchUserRoleVW(cond));
		}
		dto.setMap_ParticipantDefToBeAssign(map_ParticipantDefToBeAssign);
		IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
		ppdCond.setPsdid(dto.getProcessStatusDef().getPsdid());
		List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
		if(!lst_ProcessParticipantDef.isEmpty()) {
			String[] ids = new String[lst_ProcessParticipantDef.size()];
			for(int i = 0; i < lst_ProcessParticipantDef.size(); i++) {
				if(StringUtils.isNotEmpty(lst_ProcessParticipantDef.get(i).getUserid())) {
					ids[i] = lst_ProcessParticipantDef.get(i).getRoleid() + "_" + lst_ProcessParticipantDef.get(i).getUserid();
				}
			}
			dto.getIgPRR0102Form().setParticipants(ids);
			dto.getIgPRR0102Form().setParticipants_(ids);
		}
		log.debug("========ָ��״̬�ɷ��ɽ�ɫ��ѯ�������û����������========");
		return dto;
	}
	
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ���������û�����ѯ
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchRoleDefToBeAssignAction(IGPRR01DTO dto) throws BLException {
		log.debug("========�ɲ������̽�ɫ��ѯ���������û�������ʼ========");
		//��ѯ���趨��ɫ
		List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(dto.getProcessStatusDef().getPsdid());
		List<Role> lst_Role = new ArrayList<Role>();
		for(IG298Info psrd : lst_ProcessStatusRoleDef) {
			lst_Role.add(psrd.getRole());
		}
		dto.setRoleList(lst_Role);
		IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
		ppdCond.setPsdid(dto.getProcessStatusDef().getPsdid());
		List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
		if(!lst_ProcessParticipantDef.isEmpty()) {
			String[] ids = new String[lst_ProcessParticipantDef.size()];
			for(int i = 0; i < lst_ProcessParticipantDef.size(); i++) {
				ids[i] = lst_ProcessParticipantDef.get(i).getRoleid() + "_";
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(lst_ProcessParticipantDef.get(i).getPpdsuper())) {
					dto.getIgPRR0102Form().setPpsuper(lst_ProcessParticipantDef.get(i).getRoleid().toString());
				}
			}
			dto.getIgPRR0102Form().setParticipants(ids);
			dto.getIgPRR0102Form().setParticipants_(ids);
		}
		log.debug("========�ɲ������̽�ɫ��ѯ���������û����������========");
		return dto;
	}
	

	@SuppressWarnings("unchecked")
	private String getXMLHeight(String xml) throws BLException{
		Document document;
		String xmlheight = "";
		try {
			document = (Document) DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Integer> yList = new ArrayList<Integer>();
			for (Iterator<Element> steps = root.elementIterator("Steps"); steps.hasNext();) {
				Element stepsElement = (Element) steps.next();
				for(Iterator<Element> step = stepsElement.elementIterator("Step"); step.hasNext();){
					Element stepElement = (Element) step.next();
					for(Iterator<Element> vml = stepElement.elementIterator("VMLProperties"); vml.hasNext();){
						Element vmlElement = (Element) vml.next();
						String y = vmlElement.attributeValue("y").replace("px", "");
						yList.add(Integer.parseInt(new DecimalFormat("#0").format(Double.parseDouble(y))));
					}
				}
			}
			Collections.sort(yList);
			xmlheight = (yList.get(yList.size()-1) + 100) + "";
		} catch (DocumentException e) {
			throw new BLException("IGPRR0102.E007","ȡ������ͼ�߶ȳ���");
		}
		return xmlheight;
	}
	
	/**
	 * �ɷ��ɲ����߲�ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAssignParticipantAction(IGPRR01DTO dto) throws BLException {
		log.debug("========�ɷ��ɲ����߲�ѯ����ʼ========");
		List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(dto.getPsdid(), dto.getAction());
		if(lst_ProcessStatusDef != null && !lst_ProcessStatusDef.isEmpty()) {
			dto.setMap_AssignParticipant(new LinkedHashMap<IG333Info, IGPRR01036VO>());
			dto.setLst_participant(new ArrayList<String>());
			dto.setLst_ppsuper(new ArrayList<String>());
			for(IG333Info psd : lst_ProcessStatusDef) {
				//�Ƿ��нڵ㣬���нڵ���Զ�̬���Ӳ����ɫ����ָ��super��ɫ
				if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())) {
					if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())){
						dto = searchAssignRoleAction(psd, dto);
					} else {//��ͨģʽ
						//�жϿɱ����ɲ���������
						if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign())) {
							dto = searchAssignRoleAction(psd, dto);
						} else {
							dto = searchAssignUserAction(psd, dto);
						}
					}
				} else {
					if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())){
						dto = searchAssignRoleAction(psd, dto);
					} else {//��ͨģʽ
						//�жϿɱ����ɲ���������
						if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign())) {
							dto = searchAssignRoleAction(psd, dto);
						} else {
							dto = searchAssignUserAction(psd, dto);
						}
					}
				}
			}
		}
		log.debug("========�ɷ��ɲ����߲�ѯ�������========");
		return dto;
	}
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ��ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	private IGPRR01DTO searchAssignUserAction(IG333Info psd, IGPRR01DTO dto) throws BLException {
		log.debug("========ָ��״̬�ɷ����û���ѯ����ʼ========");
		//��ѯ���趨��ɫ
		List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
		Map<Role, List<UserInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserInfo>>();
		UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
		for(IG298Info psrd : lst_ProcessStatusRoleDef) {
			userInfoCond.setRoleida(psrd.getRoleid());
			if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
				userInfoCond.setOrgida(dto.getUser().getOrgid());
			}
			//��ָ����������
			if(StringUtils.isNotEmpty(dto.getAssign_orgsyscoding())) {
				userInfoCond.setOrgida(dto.getAssign_orgsyscoding());
			}
			map_ParticipantDefToBeAssign.put(psrd.getRole(), this.userBL.searchUserInfo(userInfoCond));
		}
		IGPRR01036VO vo = new IGPRR01036VO();
		vo.setMap_ParticipantDefToBeAssignByRole(map_ParticipantDefToBeAssign);
		dto.getMap_AssignParticipant().put(psd, vo);
		
		//��ѯ����Ӳ�����
		List<IG337Info> lst_ProcessParticipant =
			this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), psd.getPsdcode());
		if(!lst_ProcessParticipant.isEmpty()) {
			for(IG337Info pp : lst_ProcessParticipant) {
				if(StringUtils.isNotEmpty(pp.getPpuserid())) {
					dto.getLst_participant().add(psd.getPsdid() + "_" + pp.getPproleid()
							+ "_" + pp.getPpuserid());
				} else {
					dto.getLst_participant().add(psd.getPsdid() + "_" + pp.getPproleid()
							+ "_");
				}
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(pp.getPpsuper())) {
					dto.getLst_ppsuper().add(psd.getPsdid() + "_" + pp.getPproleid());
				} else {
					dto.getLst_ppsuper().add("");
				}
			}
		}
		
		//���û����Ӳ����ߣ������Ĭ�ϲ�����
		if(lst_ProcessParticipant.isEmpty()) {
			IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
			ppdCond.setPsdid(psd.getPsdid());
			List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
			if(!lst_ProcessParticipantDef.isEmpty()) {
				for(IG222Info ppd : lst_ProcessParticipantDef) {
					if(StringUtils.isNotEmpty(ppd.getUserid())) {
						dto.getLst_participant().add(psd.getPsdid() + "_" + ppd.getRoleid()
								+ "_" + ppd.getUserid());
					}
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(ppd.getPpdsuper())) {
						dto.getLst_ppsuper().add(psd.getPsdid() + "_" + ppd.getRoleid());
					} else {
						dto.getLst_ppsuper().add("");
					}
				}
			}
		}
		log.debug("========ָ��״̬�ɷ����û���ѯ�������========");
		return dto;
	}
	
	/**
	 * ָ��״̬�ɷ��ɽ�ɫ��ѯ
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	private IGPRR01DTO searchAssignRoleAction(IG333Info psd, IGPRR01DTO dto) throws BLException {
		log.debug("========ָ��״̬�ɷ��ɽ�ɫ��ѯ����ʼ========");
		//�����ǰ���ɫ���ɣ����ǰ���������
		if(psd != null){
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
				List<IG299Info> lst_ProcessStatusOrgDef = this.workFlowDefinitionBL.searchProcessStatusOrgDefInfoByPsdid(psd.getPsdid());
				Map<Organization, List<UserInfo>> map_ParticipantDefToBeAssignByOrg = new LinkedHashMap<Organization, List<UserInfo>>();
				if(lst_ProcessStatusOrgDef != null){
					for(IG299Info psrd:lst_ProcessStatusOrgDef){
						map_ParticipantDefToBeAssignByOrg.put(psrd.getOrg(), null);
					}
				}
				IGPRR01036VO vo = new IGPRR01036VO();
				vo.setMap_ParticipantDefToBeAssignByOrg(map_ParticipantDefToBeAssignByOrg);
				dto.getMap_AssignParticipant().put(psd, vo);
			}else{
				//��ѯ���趨��ɫ
				List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
				Map<Role, List<UserInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserInfo>>();
				for(IG298Info psrd : lst_ProcessStatusRoleDef) {
					map_ParticipantDefToBeAssign.put(psrd.getRole(), null);
				}
				IGPRR01036VO vo = new IGPRR01036VO();
				vo.setMap_ParticipantDefToBeAssignByRole(map_ParticipantDefToBeAssign);
				dto.getMap_AssignParticipant().put(psd, vo);
			}
		}
		
		//��ѯ����Ӳ�����
		List<IG337Info> lst_ProcessParticipant =
			this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), psd.getPsdcode());
		if(!lst_ProcessParticipant.isEmpty()) {
			for(IG337Info pp : lst_ProcessParticipant) {
				if(StringUtils.isNotEmpty(pp.getPpuserid())) {
					dto.getLst_participant().add(psd.getPsdcode() + "_" + pp.getPproleid()
							+ "_" + pp.getPpuserid());
				} else {
					dto.getLst_participant().add(psd.getPsdcode() + "_" + pp.getPproleid()
							+ "_");
				}
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(pp.getPpsuper())) {
					dto.getLst_ppsuper().add(psd.getPsdcode() + "_" + pp.getPproleid());
				} else {
					dto.getLst_ppsuper().add("");
				}
			}
		}
		if(lst_ProcessParticipant.isEmpty()) {
			IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
			ppdCond.setPsdid(psd.getPsdid());
			List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
			if(!lst_ProcessParticipantDef.isEmpty()) {
				for(IG222Info ppd : lst_ProcessParticipantDef) {
					dto.getLst_participant().add(psd.getPsdcode() + "_" + ppd.getRoleid() + "_");
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(ppd.getPpdsuper())) {
						dto.getLst_ppsuper().add(psd.getPsdcode() + "_" + ppd.getRoleid());
					} else {
						dto.getLst_ppsuper().add("");
					}
				}
			}
		}
		
		log.debug("========ָ��״̬�ɷ��ɽ�ɫ��ѯ�������========");
		return dto;
	}
	
	/**
	 * �ɵ��������߲�ѯ
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAdjustParticipantAction(List<IG333Info> lst_ProcessStatusDef, IGPRR01DTO dto) throws BLException {
		log.debug("========�ɵ��������߲�ѯ����ʼ========");
		if(lst_ProcessStatusDef != null && !lst_ProcessStatusDef.isEmpty()) {
			dto.setMap_AssignParticipant(new LinkedHashMap<IG333Info, IGPRR01036VO>());
			dto.setLst_participant(new ArrayList<String>());
			List<IG298Info> lst_ProcessStatusRoleDef = null;
			List<Role> lst_Role = null;
			Map<Role, List<UserInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserInfo>>();
			UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
			RoleSearchCondImpl roleCond = new RoleSearchCondImpl();
			IG213SearchCondImpl processRoleCond = new IG213SearchCondImpl();
			Map<String, String> map_ParticipantDoneFlag = new LinkedHashMap<String, String>();
			for(IG333Info psd : lst_ProcessStatusDef) {
				//�Ƿ������˿ɱ�����
				if(IGPRDCONSTANTS.NEED_ASSIGN.equals(psd.getPsdflag())) {
					//��ѯ�ɱ����ɵĽ�ɫ�趨
					lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
					for(IG298Info psrd : lst_ProcessStatusRoleDef) {
						userInfoCond.setRoleida(psrd.getRoleid());
						if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
							userInfoCond.setOrgida(dto.getUser().getOrgid());
						} else {
							userInfoCond.setOrgida(null);
						}
						map_ParticipantDefToBeAssign.put(psrd.getRole(), this.userBL.searchUserInfo(userInfoCond));
					}
				} else {
					//��ѯ��ɫ��Χ�趨
					processRoleCond.setPdid(psd.getPdid());
					List<IG213Info> lst_ProcessRoleTypeDef= this.workFlowDefinitionBL.searchProcessRoleTypeDef(processRoleCond);
					for(IG213Info bean : lst_ProcessRoleTypeDef) {
						roleCond.setRoletype(bean.getRoletype());
						lst_Role = this.roleBL.searchRole(roleCond);
						for(Role role : lst_Role) {
							userInfoCond.setRoleida(role.getRoleid());
							if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
								userInfoCond.setOrgida(dto.getUser().getOrgid());
							} else {
								userInfoCond.setOrgida(null);
							}
							map_ParticipantDefToBeAssign.put(role, this.userBL.searchUserInfo(userInfoCond));
						}
					}
				}
				IGPRR01036VO vo = new IGPRR01036VO();
				vo.setMap_ParticipantDefToBeAssignByRole(map_ParticipantDefToBeAssign);
				dto.getMap_AssignParticipant().put(psd, vo);
				//��ѯ����Ӳ�����
				IG337SearchCondImpl cond = new IG337SearchCondImpl();
				cond.setPrid(dto.getPrid());
				cond.setPsdid(psd.getPsdid());
				cond.setPsdnum(dto.getPsdnum());
				List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
//					this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), psd.getPsdcode());
				if(!lst_ProcessParticipant.isEmpty()) {
					for(IG337Info pp : lst_ProcessParticipant) {
						map_ParticipantDoneFlag.put(psd.getPsdid() + "_" + pp.getPproleid()
									+ "_" + pp.getPpuserid(), StringUtils.isEmpty(pp.getPpproctime()) ? "0" : "1");
						if(StringUtils.isNotEmpty(pp.getPpuserid())) {
							dto.getLst_participant().add(psd.getPsdid() + "_" + pp.getPproleid()
									+ "_" + pp.getPpuserid());
						}
					}
				}
			}
			dto.setMap_ParticipantDoneFlag(map_ParticipantDoneFlag);
		}
		log.debug("========�ɵ��������߲�ѯ�������========");
		return dto;
	}
	
	/**
	 * �ж��Ƿ��ύ�ఴť
	 * 
	 * @param pbdid ��ťID
	 * @return �Ƿ�
	 * @throws BLException
	 */
	private boolean isCommitButton(String pbdid) throws BLException {
		if(StringUtils.isEmpty(pbdid)) {
			throw new BLException("IGCO10000.E004","��ť��ʶ"); 
		}
		if(pbdid.compareTo(IGPRDCONSTANTS.BUTTON_SUBMIT) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p>
	 * Description: ��ͨ�û�����ִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO adjustExecutorsForNormalUserAction(IGPRR01DTO dto) throws BLException {
		log.debug("========����ִ���˴���ʼ========");
		IGPRR0102Form form = dto.getIgPRR0102Form();
		String selected_participants = form.getSelected_participants();
		List<String> lst_Selected = null;
		if(StringUtils.isNotEmpty(selected_participants)) {
			lst_Selected = Arrays.asList(selected_participants.split("###"));
		}
		
		User user = dto.getUser();
		String[] participants = form.getParticipants();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		//��װ����������
		String datetime = IGStringUtils.getCurrentDateTime();
		//����������
		List<String> userList = new ArrayList<String>();
		Role role = null;
		User executor = null;
		IG333Info psDef = null;
		//��ȡ�ɵ��������ߵ�״̬�б�
		List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAdjustStatus(form.getPsdid());
		//�ɵ��������ߵ�״̬����
		Set<String> lst_AdjustStatus = new HashSet<String>();
		for(IG333Info psd : lst_ProcessStatusDef) {
			lst_AdjustStatus.add(psd.getPsdid());
		}
		//״̬-��Ա�б�
		Map<String, List<String>> map_Participants = new LinkedHashMap<String, List<String>>();
		if(participants != null) {
			String[] array = null;
			for(String str : participants) {
				array = str.split("_", 3);
				if(map_Participants.containsKey(array[0])) {
					map_Participants.get(array[0]).add(str.substring(str.indexOf("_") + 1));
				} else {
					lst_AdjustStatus.remove(array[0]);//�޳����趨��״̬
					map_Participants.put(array[0], new ArrayList<String>());
					map_Participants.get(array[0]).add(str.substring(str.indexOf("_") + 1));
				}
			}
			Set<Map.Entry<String, List<String>>> set = map_Participants.entrySet();
			if(set.size() > 0) {
				Map.Entry<String, List<String>> entry = null;
				for(Iterator<Map.Entry<String, List<String>>> iter = set.iterator(); iter.hasNext();){
					entry = iter.next();
					List<Integer> lst_ppid_nodo = new ArrayList<Integer>();
					IG337SearchCondImpl cond = new IG337SearchCondImpl();
					cond.setPrid(dto.getPrid());
					cond.setPsdid(entry.getKey());
					List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
//						this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), entry.getKey());
					for(IG337Info pp : lst_ProcessParticipant) {
						for(int i = 0; i < entry.getValue().size(); i++) {
							if(StringUtils.isNotEmpty(entry.getValue().get(i))) {
								if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(
										entry.getValue().get(i).split("_", 2)[0] + "_" + entry.getValue().get(i).split("_", 2)[1])) {
									lst_ppid_nodo.add(pp.getPpid());//˵����ִ�����ڲ����߱��д��ڣ�����Ҫ���д���
									entry.getValue().set(i, null);
									break;
								}
							}
						}
					}
					for(String participant : entry.getValue()) {
						if(StringUtils.isNotEmpty(participant)) {
							role = this.roleBL.searchRoleByKey(new Integer(participant.split("_", 2)[0]));
							executor = this.userBL.searchUserByKey(participant.split("_", 2)[1]);
							psDef = workFlowDefinitionBL.searchProcessStatusDefByKey(entry.getKey());
							//ֻ֪ͨ��ǰ״̬������
							if(form.getPrstatus().startsWith(entry.getKey())) {
								userList.add(executor.getUserid());
							}
							IG337TB ppTB = this.workFlowOperationBL.getProcessParticipantTBInstance();
							ppTB.setPproleid(role.getRoleid());
							ppTB.setPprolename(role.getRolename());
							ppTB.setPpuserid(executor.getUserid());
							ppTB.setPpusername(executor.getUsername());
							ppTB.setPporgid(executor.getOrgid());
							ppTB.setPporgname(executor.getOrgname());
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);//����������
							ppTB.setPpinittime(datetime);
							ppTB.setPrid(form.getPrid());
							ppTB.setPpstatus(psDef.getPsdcode());
							ppTB.setPsdid(psDef.getPsdid());
							this.workFlowOperationBL.addProcessParticipant(ppTB, user, form.getPrroleid(),
									"��ӣ�" + ppTB.getPprolename() + "(" + ppTB.getPpusername() + ")",
									IGPRDCONSTANTS.COMMENT_ASSIGNPERSON_MESSAGE,null,
									IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
						}
					}
					for(IG337Info pp : lst_ProcessParticipant) {
						if(!lst_ppid_nodo.contains(pp.getPpid()) && lst_Selected.contains(
								pp.getPsdid() + "_" + pp.getPproleid() + "_"
										+ (StringUtils.isEmpty(pp.getPpuserid()) ? "" : pp.getPpuserid()))) {
							this.workFlowOperationBL.removeProcessParticipant(pp, user, form.getPrroleid(),
									"ɾ����" + pp.getPprolename()
									+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
									IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
									IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
						}
					}
				}
			}
			for(String status : lst_AdjustStatus) {
				IG337SearchCondImpl cond = new IG337SearchCondImpl();
				cond.setPrid(dto.getPrid());
				cond.setPsdid(status);
				List<IG337Info> list = workFlowOperationBL.searchProcessParticipants(cond);
				for(IG337Info pp : list) {
					if(lst_Selected.contains(
							pp.getPsdid() + "_" + pp.getPproleid() + "_"
									+ (StringUtils.isEmpty(pp.getPpuserid()) ? "" : pp.getPpuserid()))) {
						this.workFlowOperationBL.removeProcessParticipant(pp, user, form.getPrroleid(), 
								"ɾ����" + pp.getPprolename()
								+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
								IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
								IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
					}
				}
			}
		}
		//������ť�¼�
		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		bean.setPbdid(IGPRDCONSTANTS.BUTTON_EXECUTOR);//��ťID
		bean.setBfstatus(form.getPsdid());//״̬ID
		//��־������Ϣ
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setPrid(dto.getPrid());
		logInfo.setExecutorid(user.getUserid());
		logInfo.setExecutorRoleid(form.getPrroleid());
		if(dto.getAuthorizeuser() != null) {
			logInfo.setAuthuserid(dto.getAuthorizeuser().getUserid());
		}
		bean.setLogInfo(logInfo);
		this.workFlowOperationBL.processStatusButtonTreatmentExecute(bean);
		//���鵱ǰ״̬���в������Ƿ������,ȫ��������������һ�������˵ļ�¼ԾǨ
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		this.workFlowOperationBL.sendMessage(form.getPsdid(),
				userList, null, null, null, null, pr);
		
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========����ִ���˴�������========");
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ɱ���ִ����
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO saveExecutorsAction(IGPRR01DTO dto) throws BLException {
		log.debug("========����ִ���˴���ʼ========");
		IGPRR0102Form form = dto.getIgPRR0102Form();
		User user = dto.getUser();
		String[] participants = form.getParticipants();
		User authorizeuser = dto.getAuthorizeuser();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		String[] ppsupers = form.getPpsupers();
		//��װ�ڵ����������
		if(participants != null) {
			//Ϊ�˴��ʱ�����·���ʱ��Ҫɾ��֮ǰ�Ĳ�����start
			Set<String> set_Status = new HashSet<String>();
			for(String str : participants) {
				set_Status.add(str.split("_", 3)[0]);
			}
			for(String status : set_Status) {
				for(IG337Info pp : workFlowOperationBL.searchProcessParticipant(pr.getPrid(), status)) {
					workFlowOperationBL.removeProcessParticipant(pp,user,form.getPrroleid(),
							"ɾ����" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, dto.getAction(), form.getPrstatus());
				}
			}
			//Ϊ�˴��ʱ�����·���ʱ��Ҫɾ��֮ǰ�Ĳ�����end
			
			String[] array = null;
			for(String str : participants) {
				array = str.split("_", 3);
				String ppsuper = null;
				if(ppsupers != null) {
					for(String per : ppsupers) {
						if((array[0] + "_" + array[1]).equals(per)) {
							ppsuper = per;
							break;
						}
					}
				}
				workFlowOperationBL.addParticipant(dto.getUser(), dto.getPrid(), pr.getPrpdid(), array[0],
						array[1], array[2], ppsuper, authorizeuser, dto.getAction(), form.getPrstatus());
			}
		}
		//�������ҳ��û�й�ѡ�κβ����ˣ���Ϊ�����б����¼���  start wangtingzhi  20130617
		else{
			List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAssignedStatusDef(form.getPsdid(), form.getAction());
			if(lst_ProcessStatusDef != null){
				for(IG333Info psd : lst_ProcessStatusDef){
					for(IG337Info pp : workFlowOperationBL.searchProcessParticipant(pr.getPrid(), psd.getPsdcode())) {
						workFlowOperationBL.removeProcessParticipant(pp,user,form.getPrroleid(),
								"ɾ����" + pp.getPprolename()
								+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
								IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
								IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, dto.getAction(), form.getPrstatus());
					}
				}
			}
		}
		//�������ҳ��û�й�ѡ�κβ����ˣ���Ϊ�����б����¼���  end wangtingzhi  20130617

		//���鵱ǰ״̬���в������Ƿ������,ȫ��������������һ�������˵ļ�¼ԾǨ
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========����ִ���˴�������========");
		return dto;
	}
	
	/**
	 * ��ȡ�ǵ�ǰ�ڵ�����˵ı��ɼ�Ȩ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO getNotCurrentFormAccessPower(IGPRR01DTO dto) throws BLException{
		//��ǰ��¼�û�IDȡ��
		String userid = dto.getUser().getUserid();
		//����ȡ��
		IG500Info pr = dto.getProcess();
		//ȡ�õ�ǰ�û������н�ɫ
		UserRoleSearchCondImpl condRole = new UserRoleSearchCondImpl();
		condRole.setUserid(userid);
		List<UserRole> roleList = userRoleBL.searchUserRole(condRole);
		//��ǰ�û�������Ľڵ�
		List<IG337Info> ppList = new ArrayList<IG337Info>();
		//��ǰ�����Ѿ����й��Ľڵ�
		//ȡ�����̵�ǰ�Ѿ����й���״̬���� 
		IG337SearchCondImpl condPP = new IG337SearchCondImpl();
		condPP.setPrid(dto.getPrid());
		List<IG337Info> lstProcessParticipant = workFlowOperationBL.searchIG337InfoRun(condPP);
		for(IG337Info pp :lstProcessParticipant){
			//������ָ������ɫ�����
			Integer pproleid = pp.getPproleid();
			for(UserRole role : roleList){
				if(role.getRoleid().equals(pproleid)){
					ppList.add(pp);
				}
			}
		}
		
		//��ѯ��ǰ���̵�����״̬����
		IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
		psdcond.setPdid(pr.getPrpdid());
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
		if(psdList != null && ppList.size() > 0){
			Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();
			for(IG333Info psd:psdList){
				psdMap.put(psd.getPsdid(), psd);
			}
			Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap = new HashMap<IG333Info, List<IG337Info>>();
			for(IG337Info pp:ppList){
				if(ls_proStatusParticipantMap.get(psdMap.get(pp.getPsdid())) == null){
					List<IG337Info> temp = new ArrayList<IG337Info>();
					temp.add(pp);
					ls_proStatusParticipantMap.put(psdMap.get(pp.getPsdid()), temp);
				}else{
					ls_proStatusParticipantMap.get(psdMap.get(pp.getPsdid())).add(pp);
				}
			}
			List<IG893Info> participantVariableVWList = workFlowOperationBL.searchParticipantMaxVariableVW(dto.getPsdid(), dto.getRoleid(), ls_proStatusParticipantMap);
			List<IG893Info> participantVariable = new ArrayList<IG893Info>();
			if(participantVariableVWList != null){
				for(IG893Info pv:participantVariableVWList){
					IG893VW pvVW = new IG893VW();
					pvVW.setPidid(pv.getPidid());
					if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pv.getPidaccess())){
						pvVW.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
					}else{
						pvVW.setPidaccess(pv.getPidaccess());
					}
					pvVW.setPidrequired(pv.getPidrequired());
					pvVW.setPidlabel(pv.getPidlabel());
					pvVW.setPidname(pv.getPidname());
					pvVW.setPiddesc(pv.getPiddesc());
					pvVW.setPidtype(pv.getPidtype());
					pvVW.setPsdid(pv.getPsdid());
					pvVW.setRoleid(pv.getRoleid());
					participantVariable.add(pvVW);
				}
			}
			dto.setParticipantVariableVWList(participantVariable);
		}
		return dto;
	}

	
	//120509Begin
	/**
	 * �Զ������̷ǹر�״̬������Ϣ����ȡ��
	 */
	private IGPRR01DTO searchProcessInfoForSearch(IGPRR01DTO dto) throws BLException {
		if(null == dto.getRoleid()){
			dto.setRoleid(0);
		}
		String userid = dto.getUser().getUserid();
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//ȡ������
		IG500Info pr = dto.getProcess();
		
		//ȡ�õ�ǰ�û������н�ɫ
		UserRoleSearchCondImpl condRole = new UserRoleSearchCondImpl();
		condRole.setUserid(userid);
		List<UserRole> roleList = userRoleBL.searchUserRole(condRole);
		
		List<String> ppstatusList = new ArrayList<String>();//������Ȩ�޵�״̬
		
		//ȡ�����̵�ǰ�Ѿ����й���״̬���� 
		IG337SearchCondImpl condPP = new IG337SearchCondImpl();
		condPP.setPrid(dto.getPrid());
		List<IG337Info> lstProcessParticipant = workFlowOperationBL.searchIG337InfoRun(condPP);
		for(IG337Info pp :lstProcessParticipant){
			//������ָ������ɫ�����
			Integer pproleid = pp.getPproleid();
			for(UserRole role : roleList){
				if(role.getRoleid().equals(pproleid)){
					if(!ppstatusList.contains(pp.getPpstatus())){
						ppstatusList.add(pp.getPsdid());
					}
				}
			}
		}
		
		List<IG007Info> infoDefList = null;
		if(ppstatusList.size() > 0){
			//��ѯ�����̵����ж���ı�����
			IG007SearchCondImpl condInfo = new IG007SearchCondImpl();
			//pdid
			condInfo.setPdid(pr.getPrpdid());
			
			//���ݲ�ѯ����ȡ��ppdid��
			StringBuffer buf = new StringBuffer("(");
			for(String status : ppstatusList){
				buf.append("'").append(status).append("',");
			}
			String str = buf.substring(0, buf.length()-1) + ")";
			condInfo.setPsdid_like(str);
			infoDefList = workFlowDefinitionBL.searchIG007InfoRun(condInfo);
		}
		
		//��ѯ�����̵����б�����
		List<IG599Info> piList = workFlowOperationBL.searchProcessInfoForSee(pr.getPrid(),pr.getPrpdid(), userid);
		
		if(infoDefList!=null && infoDefList.size()>0){
			Map<String,IG007Info> realmap = new LinkedHashMap<String,IG007Info>();
			//�������̱����ҵ�����������еı������壬�����̱�����ֵ���������Ӧ�����̱�������Ķ��󣬲��������̱��������������̱���Ȩ��(pidaccess)����Ϊֻ��
			for(IG007Info pid:infoDefList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						pitb.setPidvalue(temp_pi.getPivarvalue());
						pitb.setPidcomment(temp_pi.getPidcomment());
						//�����ǰ�û�����ȫ�ֿ�������Ȩ�ޱ�������ԭȨ�ޣ�������ֻ��Ȩ��
						pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						if("1".equalsIgnoreCase(temp_pi.getPidmode())){
							if(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL.equalsIgnoreCase(temp_pi.getPidaccess())){
								pitb.setPidaccess(temp_pi.getPidaccess());
								pitb.setPiid(temp_pi.getPiid());
							}
							pitb.setProcessPrivateInfoList(temp_pi.getProcessPrivateInfofList());
							//��˽�б�Ϊ��ɫ��ʱ�򣬵�ǰ��¼�˲鿴ʱ��û��roleid�����Բ�ѯ�����߱� ֻҪ��������ɵ�״̬roleid��˽�б���ͬ����roleid����Ϊ9999��ȫ����ʾ
							if("0".equalsIgnoreCase(temp_pi.getPrivatescope()) && temp_pi.getProcessPrivateInfofList() != null && temp_pi.getProcessPrivateInfofList().size() > 0){
								if(dto.getRoleid() == null || dto.getRoleid() <= 0){
									List<IG899TB> lstPrivate = temp_pi.getProcessPrivateInfofList();
									IG337SearchCondImpl condImpl = new IG337SearchCondImpl();
									condImpl.setPrid(dto.getPrid());
									condImpl.setPpproctimeIsNull("N");
									condImpl.setPpuserid(userid);
									List<IG337Info> processParticipantList = this.workFlowOperationBL.searchProcessParticipants(condImpl);
									for(IG337Info info : processParticipantList){
										for(IG899TB tb : lstPrivate){
											if(info.getPproleid().equals(tb.getRoleid())){
												//����Ϊ���Ȩ�� ����ҳ����ʾ
												dto.setRoleid(9999);
												break;
											}
										}
									}
								}
							}
						}
						realmap.put(pidid, pitb);
						break;
					}
				}
				
			}
			dto.setRealmap(realmap);
		}
		
		if(dto.getRealmap()!=null){
			dto.setProcessInfoDefmap(dto.getRealmap());
			dto.setHid("1");
		}else{
			dto.setHid("0");
		}
		
		form.setProcessName(dto.getProcessName());
		
		return dto;
	}

	/**
	 * ��ѯ�������̵�����ID
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchActionSortID(IGPRR01DTO dto) throws BLException {
		log.debug("========��ѯ�������̵�����ID��ʼ========");
		String pdid = dto.getProcess().getPrpdid();
		ActionSearchCondImpl cond = new ActionSearchCondImpl();
		cond.setActurl_like("/IGCOM0202.do?linkID=IGPRR0101&psdcode=Z&pdid="+pdid);
		List<Action> actionInfo = actionBL.searchAction(cond);
		for(Action action : actionInfo){
			String sortid = "";
			if(StringUtils.isNotEmpty(action.getActsortid())){
				sortid = action.getActsortid();
				if(action.getActsortid().length()> 4){
					sortid = sortid.substring(0, 4);
				}
			}
			if(StringUtils.isNotEmpty(sortid)){
				dto.setActsortid(sortid);
			}
		}
		log.debug("========��ѯ�������̵�����ID����========");
		return dto;
	}

	/**
	 * �ɲ������̽�ɫȡ��
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessRoleListAction(IGPRR01DTO dto) throws Exception {
		log.debug("========�ɲ������̽�ɫ��ѯ����ʼ========");
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setPdid(dto.getProcessStatusDef().getPdid());
		dto.setRoleList(roleBL.searchRoleForSelfDef(cond,0,0));
		log.debug("========�ɲ������̽�ɫ��ѯ�������========");
		return dto;
	}

	public IGPRR01DTO getServiceProcessRecordRelation(IGPRR01DTO dto) throws BLException {
		log.debug("========��ȡ���̹������񹤵���Ϣ����ʼ========");
		//��ѯ�÷��񹤵������ϵ����
		List<IG715Info> serviceProcessRecordRelationList = workFlowOperationBL.searchServiceProcessRecordRelationByPrid(dto.getPrid());//����
		dto.setIg715InfoList(serviceProcessRecordRelationList);
		log.debug("========��ȡ���̹������񹤵���Ϣ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ���񹤵���ݷ���ҳ���ʼ�� 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author masai@deliverik.com
	 * @update
	 */
	public IGPRR01DTO quickQuestionInitAction(IGPRR01DTO dto) throws BLException {
		
		log.debug("========���񹤵���ݷ�������ҳ���ʼ����ʼ========");
		IGPRR0101Form form = dto.getIgPRR0101Form();
		IG933Info serviceForm = this.workFlowOperationBL.searchServiceFormByKey(form.getParprid());
		
		form.setPrinfo(dto.getUser().getUsermobile());
		form.setPrtitle(serviceForm.getSftitle());//����
		form.setPrdesc(serviceForm.getSfdesc());//����
		form.setPrplantime(serviceForm.getSfinstime());//���ⷢ���¼�

		log.debug("========���񹤵���ݷ�������ҳ���ʼ������========");
		
		return dto;
		
	}
	/**
	 * <p>
	 * Description: ��ݷ���ҳ���ʼ�� 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGPRR01DTO quickInitAction(IGPRR01DTO dto) throws BLException {
		log.debug("========�����ݷ���ҳ���ʼ����ʼ========");
		IGPRR0101Form form = dto.getIgPRR0101Form();
		IG500Info pr = this.workFlowOperationBL.searchProcessRecordByKey(form.getParprid());
		form.setPrtitle(pr.getPrtitle());//����
		form.setPrdesc(pr.getPrdesc());//����
//		form.setPrurgency(pr.getPrurgency());//�����̶�
//		form.setPrimpact(pr.getPrimpact());//Ӱ��̶�

		log.debug("========�����ݷ���ҳ���ʼ������========");
		return dto;
	}
	
	/**
     * <p>
     * Description: ȡ�������Զ���ķ���ҳ��URL��Ϣ
     * </p>
     * 
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     * @throws BLException
     * @update
     */
    
    public IGPRR01DTO getAssignPageAction(IGPRR01DTO dto) throws BLException {
        log.debug("========�����Զ���ķ���ҳ��URL��Ϣȡ�ÿ�ʼ========");
        
        CodeDetailSearchCondImpl codedetailcond = new CodeDetailSearchCondImpl();
        codedetailcond.setCcid(CodeDefine.getCodeDefine("ASSIGN_PAGE_TYPE").getCcid());
        codedetailcond.setCid(dto.getAssignPageType());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(codedetailcond,
                  CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String[] assignPages = cds.get(0).getCdinfo().split("#");
        IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(dto.getPsdid());
        dto.setAssignPage(psd.getAssignPageType());
        dto.setAssignChangePage(assignPages[1]);
        
        log.debug("========�����Զ���ķ���ҳ��URL��Ϣȡ������========");
        
        return dto;
    }
    
    /**
     * �ж��Ƿ����ȫ�ֿ��Ʊ�
     * @param dto
     * @return
     * @throws BLException
     */
    public IGPRR01DTO isFormGlobalControl(IGPRR01DTO dto) throws BLException{
    	log.debug("=============�ж��Ƿ����ȫ�ֿ��Ʊ���ʼ==============");
    	//��ǰ��¼�û�ȡ��
    	User user = dto.getUser();
    	//������Ϣȡ��
    	IG500Info processrecord = dto.getProcess();
    	//��ѯ��ʶȫ�ֿ��Ʊ��Ľڵ㶨��
    	IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
    	psdcond.setPdid(processrecord.getPrpdid());
    	psdcond.setFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y);
    	List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
    	//����������ж���ڵ��ȫ�ֿ��ƣ����жϸ��û��Ƿ��и�Ȩ�ޣ�����������û�и�Ȩ��
    	if(psdList!=null&&!psdList.isEmpty()){
    		//��ѯ�����̵����в�����
    		IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
    		ppcond.setPrid(dto.getPrid());
    		List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(ppcond);
    		Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap = new HashMap<IG333Info, List<IG337Info>>();
    		UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
    		urcond.setUserid(user.getUserid());
    		List<UserRole> urlist = userRoleBL.searchUserRole(urcond);
    		for(IG333Info psd:psdList){
    			for(IG337Info pp:ppList){
    				if(psd.getPsdcode().equals(pp.getPpstatus())){
    					for(UserRole ur : urlist){
    						if(ur.getRoleid().equals(pp.getPproleid())){
    							if(ls_proStatusParticipantMap.get(psd)==null){
    								List<IG337Info> temp = new ArrayList<IG337Info>();
    								temp.add(pp);
    								ls_proStatusParticipantMap.put(psd, temp);
    							}else{
    								ls_proStatusParticipantMap.get(psd).add(pp);
    							}
    							break;
    						}
    					}
    				}
    			}
    		}
    		
    		if(ls_proStatusParticipantMap.size()>0){
    			dto.setIsFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y);
    			dto.setLs_proStatusParticipantMap(ls_proStatusParticipantMap);
    		}else{
    			dto.setIsFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_N);
    		}
    	}else{
    		dto.setIsFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_N);
    	}
    	log.debug("=============�ж��Ƿ����ȫ�ֿ��Ʊ�����==============");
    	return dto;
    }
	
	//====>130225Begin 
	/**
	 * ���ݻ�����ѯִ����
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchProcessExecutor(IGPRR01DTO dto) throws BLException {
		log.debug("========���ݻ�����ѯִ���˿�ʼ========");
		
		IGPRR0121Form form = dto.getIgPRR0121Form();
		
		//��ǰ������
		IG337SearchCondImpl cond = new IG337SearchCondImpl(); 
		cond.setPrid(form.getPrid());
		cond.setPpstatus(form.getPrstatus());
		cond.setPporgid_eq(form.getPporgid());
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(cond);
		
		// ��ѯָ����ִ���˽�ɫID��Ϣ
		IG001SearchCondImpl cond_role = new IG001SearchCondImpl();
		cond_role.setProtype_eq(IGPRDCONSTANTS.OA_ROLE_C);
		List<IG001Info> lst_role = this.workFlowDefinitionBL.searchOARoleConfig(cond_role);
		if(lst_role == null || lst_role.isEmpty()){
			throw new BLException("IGPRD0119.E001");
		}
		// ��ѯָ����ִ�����û���Ϣ
		List<UserRoleInfo> lstAll = new ArrayList<UserRoleInfo>();
		for (IG001Info info : lst_role) {
			UserRoleVWSearchCondImpl cond_urvw = new UserRoleVWSearchCondImpl();
			cond_urvw.setRoleid(info.getProroleid());
			cond_urvw.setOrgid_like(form.getPporgid());
			lstAll.addAll(userRoleBL.searchUserRoleVW(cond_urvw));
		}
		
		// ����ʾ��ִ�����й��˵������˺�ֵ���˼��Ѵ�����ɵĲ�����
		List<UserRoleInfo> lst_UserRoleVW = new ArrayList<UserRoleInfo>();
		List<String> lst_user = new ArrayList<String>();
		for (IG337Info ig337Info : pplist) {
			if((IGPRDCONSTANTS.ROLEMANAGER.equals(ig337Info.getPprolemanager())
				|| IGPRDCONSTANTS.DUTYPERSON.equals(ig337Info.getPpdutyperson()))
				|| StringUtils.isNotEmpty(ig337Info.getPpproctime())){
				lst_user.add(ig337Info.getPpuserid());
			}
		}
		try {
			for (UserRoleInfo userRoleInfo : lstAll) {
				if(!lst_user.contains(userRoleInfo.getUserid())){
					lst_user.add(userRoleInfo.getUserid());
					//lst_UserRoleVW.add(userRoleInfo);
					
					//�õ����Ա༭�Ķ��� 20130314 ȡ�û���ȫ��
					UserRoleVW uvw = new UserRoleVW();
					BeanUtils.copyProperties(uvw, userRoleInfo);
					uvw.setOrgname(getCompleteOrgName(uvw.getOrgid()));
					lst_UserRoleVW.add(uvw);
				}
			}
		} catch (Exception e) {
			log.error("",e);
		}
		dto.setLst_UserRoleVW(lst_UserRoleVW);
		
		log.debug("========���ݻ�����ѯִ���˽���========");
		return dto;
	}
	
	/**
	 * ��ִ�������Ϊ������
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO addProcessExecutor(IGPRR01DTO dto) throws BLException {
		IGPRR0121Form form = dto.getIgPRR0121Form();
		//��ǰ������
		IG337SearchCondImpl cond = new IG337SearchCondImpl(); 
		cond.setPrid(form.getPrid());
		cond.setPpstatus(form.getPrstatus());
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(cond);
		
		// ɾ��������
		List<IG337Info> lst_remove = new ArrayList<IG337Info>();
		for (IG337Info ig337Info : pplist) {
			if((!IGPRDCONSTANTS.ROLEMANAGER.equals(ig337Info.getPprolemanager())
				&& !IGPRDCONSTANTS.DUTYPERSON.equals(ig337Info.getPpdutyperson()))
				&& StringUtils.isEmpty(ig337Info.getPpproctime())){
				lst_remove.add(ig337Info);
				this.workFlowOperationBL.removeProcessParticipant(ig337Info);
			}
		}
		
		// ȡ��δɾ��������
		pplist.removeAll(lst_remove);
		lst_remove = null;
		List<String> lst_user = new ArrayList<String>();
		for (IG337Info info : pplist) {
			lst_user.add(info.getPpuserid());
		}
		
		// ��ѯ��ӵĲ�������Ϣ
		List<UserRoleInfo> lst_UserRoleVW = new ArrayList<UserRoleInfo>();
		int[] urids = form.getUrids();
		UserRoleVWSearchCondImpl condVW = new UserRoleVWSearchCondImpl();
		for (int i = 0; i < urids.length; i++) {
			condVW.setUrid_eq(urids[i]);
			lst_UserRoleVW.addAll(this.userRoleBL.searchUserRoleVW(condVW));
		}
		
		// ��Ӳ�����
		// ��ǰ�û�
		User currUser = dto.getUser();
		OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
		orgcond.setOrgsyscoding(form.getPporgid());
		List<Organization> lst_org = organizationBL.searchOrganization(orgcond);
		Organization organization = new OrganizationTB();
		if(lst_org != null && !lst_org.isEmpty()){
			organization = lst_org.get(0);
		}
		for (UserRoleInfo userRolevw : lst_UserRoleVW) {
			// ���������Ѵ��ڵ��û������
			if(lst_user.contains(userRolevw.getUserid())){
				continue;
			}
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(process.getPrpdid());
			psdCond.setPsdcode(form.getPrstatus());		
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "״̬");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "״̬");
			} else {
				// ������ʵ��
				IG337TB instance = workFlowOperationBL.getProcessParticipantTBInstance();
				instance.setPrid(form.getPrid());
				instance.setPpinittime(IGStringUtils.getCurrentDateTime());
				instance.setPpstatus(form.getPrstatus());
				//????
				instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
				instance.setPpuserid(userRolevw.getUserid());
				instance.setPpusername(userRolevw.getUsername());
				instance.setPporgid(organization.getOrgsyscoding());
				instance.setPporgname(organization.getOrgsyscoding());
				instance.setPprolemanager(IGPRDCONSTANTS.NOT_ROLEMANAGER);
				instance.setPpdutyperson(IGPRDCONSTANTS.NOT_DUTYPERSON);
				instance.setPproleid(userRolevw.getRoleid());
				instance.setPprolename(userRolevw.getRolename());
				workFlowOperationBL.addProcessParticipant(instance, currUser,
						userRolevw.getRoleid(),
						"��ӣ�"+userRolevw.getUsername(), "��Ӳ�����", 
						null, IGPRDCONSTANTS.RECORDLOG_TYPE_CL, null, null, null);
			   }
			}
		
		return dto;
	}
	//====>130225End
	
	/**
	 * ����super����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantByOrgSuper(IGPRR01DTO dto) throws BLException {
		log.debug("=================����super���ɿ�ʼ=================");
		//ҳ����Ϣȡ��
		IGPRR0113Form form = dto.getIgPRR0113Form();
		//������Ϣ��ѯ
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		dto.setProcess(pr);
		//��������Ϣȡ��
		List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
		//��ѡ��������Ϣȡ��
		String[] participants = form.getParticipants();
		List<String[]> orgList = new ArrayList<String[]>();
		if(participants!=null){
			for(String s:participants){
				String[] split = s.split("_");
				if(split!=null&&split.length==2){
					String [] temp = {split[0],split[1]};
					orgList.add(temp);
				}
			}
		}
		//Ҫɾ���Ĳ�������Ϣ����
		List<IG337Info> deleteppList = new ArrayList<IG337Info>();
		//�Ѿ���ӹ��Ļ�����
		List<String> alreadyexistorg = new ArrayList<String>();
		if(pplist!=null){
			for(IG337Info pp:pplist){
				boolean flag = true;
				for(String[] org:orgList){
					if(pp.getPporgid().equals(org[0])){
						flag = false;
						if(!alreadyexistorg.contains(pp.getPporgid())){
							alreadyexistorg.add(pp.getPporgid());
						}
						break;
					}
				}
				if(flag){
					deleteppList.add(pp);
				}
			}
		}
		//ɾ����ȥ���Ĳ�����
		if(!deleteppList.isEmpty()){
			for(IG337Info pp:deleteppList){
				this.workFlowOperationBL.removeProcessParticipant(pp, dto.getUser(), pp.getPproleid(), 
						"ɾ����" + pp.getPprolename()
						+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
						IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
						IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
			}
		}
		//����±���ѡ�Ĳ�����
		if(orgList.size()>alreadyexistorg.size()){
			//��ѯ���ý�ɫ��Ϣ
			//�����˶�Ӧ��ɫ
			List<Integer> role_a = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_A);
			if(role_a == null || role_a.isEmpty()){
				throw new BLException("IGCO10000.E004","�����˻���");
			}
			//ֵ���˶�Ӧ��ɫ
			List<Integer> role_b = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_B);
			UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
			List<UserRoleInfo> urList = null;
			List<IG337Info> addppList = new ArrayList<IG337Info>();
			for(String[] orgs:orgList){
				if(StringUtils.isNotEmpty(orgs[0])&&!alreadyexistorg.contains(orgs[0])){
					//��ѯ��Ӧ��������Ϣ
					urcond.setOrgid_like(orgs[0]);
					urcond.setRoleid_in(role_a);
					urList = userRoleBL.searchUserRoleVW(urcond);
					if(urList==null||urList.isEmpty()){
						throw new BLException("IGCO10000.E004","��"+ orgs[1] + "�������˻���");
					}else{
						for(UserRoleInfo ur:urList){
							IG337TB ppTB = workFlowOperationBL.getProcessParticipantTBInstance();
							ppTB.setPrid(form.getPrid());
							ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
							ppTB.setPpstatus(form.getPrstatus());
							ppTB.setPproleid(ur.getRoleid());
							ppTB.setPprolename(ur.getRolename());
							ppTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
							ppTB.setPpuserid(ur.getUserid());
							ppTB.setPpusername(ur.getUsername());
							ppTB.setPporgid(orgs[0]);
							ppTB.setPporgname(orgs[1]);
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							addppList.add(ppTB);
						}
					}
					//��ѯ��Ӧֵ������Ϣ
					if(role_b!=null&&!role_b.isEmpty()){
						urcond.setRoleid_in(role_b);
						urList = userRoleBL.searchUserRoleVW(urcond);
						if(urList!=null){
							for(UserRoleInfo ur:urList){
								IG337TB ppTB = workFlowOperationBL.getProcessParticipantTBInstance();
								ppTB.setPrid(form.getPrid());
								ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
								ppTB.setPpstatus(form.getPrstatus());
								ppTB.setPproleid(ur.getRoleid());
								ppTB.setPprolename(ur.getRolename());
								ppTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
								ppTB.setPpuserid(ur.getUserid());
								ppTB.setPpusername(ur.getUsername());
								ppTB.setPporgid(orgs[0]);
								ppTB.setPporgname(orgs[1]);
								ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
								addppList.add(ppTB);
							}
						}
					}
				}
			}
			//����BL��Ӳ�����
			if(!addppList.isEmpty()){
				for(IG337Info addpp:addppList){
					this.workFlowOperationBL.addProcessParticipant(addpp, dto.getUser(),form.getRoleid(),
							"��ӣ�" + addpp.getPprolename()
							+ (StringUtils.isEmpty(addpp.getPpusername()) ? "" : "(" + addpp.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
				}
			}
		}

		//���鵱ǰ״̬���в������Ƿ������,ȫ��������������һ�������˵ļ�¼ԾǨ
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		dto.addMessage(new ActionMessage("IGPRR0113.I001"));
		log.debug("=================����super��������=================");
		return dto;
	}
	
	/**
	 * ���������б�ֵȡ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO getOrgLabelValueBeans(IGPRR01DTO dto) throws BLException {
		log.debug("=============��ȡ���������б�ֵ������ʼ===============");
		//��û�����Χ�����б�
		List<IG123Info> orgList = workFlowDefinitionBL.searchProcessOrgScopeByPdid(dto.getPdid());
		List<LabelValueBean> labelList = new ArrayList<LabelValueBean>();
		if(orgList!=null){
			for(IG123Info info:orgList){
				LabelValueBean label = new LabelValueBean();
				label.setLabel(info.getOrgname());
				label.setValue(info.getOrgid()+"_org_"+info.getOrgname());
				labelList.add(label);
			}
		}
		dto.setProcessOrgSelectedOptions(labelList);
		log.debug("=============��ȡ���������б�ֵ��������===============");
		return dto;
	}
	/**
	 * <p>
	 * ȡ�øý��Ļ���ȫ��
	 * </p>
	 * @param  syscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */

	public String getCompleteOrgName(String syscoding) {
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		StringBuffer orgname = new StringBuffer();
		
		ArrayList<String> codelist = new ArrayList<String>();
		if(syscoding.length()==7){
			codelist.add(syscoding);
		}else{
			String pcode = syscoding.substring(0, 7);
			codelist.add(pcode);
			String childs = syscoding.substring(7);
			int j = childs.length()/3;
			for(int i=1;i<=j;i++){
				codelist.add(pcode+childs.substring(0, 3*i));
			}
			
		}
		
		
		//form.setComplete_name(syscoding);
		//form.setIs_in_use("1");
		form.setSyscoding_area(codelist);
		dto.setOrganizationSearchCond(form);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��ý�ɫ��������¼�������
		for(int i=0,j=ret.size();i<j;i++){
			String syscode = ret.get(i).getOrgsyscoding();
			if(syscoding.contains(syscode)){
				if(i>0){
					orgname.append("-");
				}
				orgname.append(ret.get(i).getOrgname());
			}
			
		}
		return orgname.toString();
	}
	
	/**
	 * ��ѯ������ֵ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO searchTableColumnValue(IGPRR01DTO dto) throws BLException {
		log.debug("=============������ֵ��ѯ������ʼ==============");
		//������Ϣȡ��
		IG500Info process = dto.getProcess();
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(process.getPrid());
		List<IG898Info> tableColumnValueList = workFlowOperationBL.searchTableFormValue(cond);
		Map<String, List<Attachment>> tableAttMap = new HashMap<String, List<Attachment>>();
		if(tableColumnValueList != null){
			Map<String, Map<String, Map<String, String>>> tableColumnValueMap = new HashMap<String, Map<String,Map<String,String>>>();
			for(IG898Info columnValue:tableColumnValueList){
				if(tableColumnValueMap.get(columnValue.getPidid()) == null){
					Map<String, Map<String, String>> one = new LinkedHashMap<String, Map<String,String>>();
					Map<String, String> two = new LinkedHashMap<String, String>();
					two.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
					one.put(columnValue.getPvrownumber(), two);
					tableColumnValueMap.put(columnValue.getPidid(), one);
				}else{
					if(tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()) == null){
						Map<String, String> temp = new LinkedHashMap<String, String>();
						temp.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
						tableColumnValueMap.get(columnValue.getPidid()).put(columnValue.getPvrownumber(), temp);
					}else{
						tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()).put(columnValue.getPvcolpidid(), columnValue.getPvalue());
					}
				}
				if(StringUtils.isNotEmpty(columnValue.getPvalue())){
					try {
						if(columnValue.getPvalue().getBytes("UTF-8").length == 32){
							List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(columnValue.getPvalue());
							tableAttMap.put(columnValue.getPvalue(), attList);
						}
					} catch (UnsupportedEncodingException e) {
						log.error("",e);
					}
				}
			}
			dto.setTableColumnValueMap(tableColumnValueMap);
		}
		
		List<IG731Info> pieList = workFlowOperationBL.searchProcessInfoEntityByPrid(process.getPrid());
		Map<String, IG731Info> pieMap = new HashMap<String, IG731Info>();
		if(pieList != null){
			for(IG731Info pie : pieList){
				String key = pie.getPieid() + "";
				pieMap.put(key, pie);
			}
		}
		//���ñ������и���
		if(tableAttMap.size() > 0){
			dto.setTableAttMap(tableAttMap);
		}
		dto.setPieMap(pieMap);
		log.debug("=============������ֵ��ѯ��������==============");
		return dto;
	}
	
	/**
	 * ȡ�����̲�������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantInfoActon(IGPRR01DTO dto) throws BLException {
		log.debug("=============ȡ�����̲�������Ϣ������ʼ===================");
		//������Ϣȡ��
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(process);
		dto.setStatus(process.getPrstatus());
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPsdcode(process.getPrstatus());
		cond.setPdid(process.getPrpdid());
		List<IG333Info> psdList = this.workFlowDefinitionBL.searchProcessStatusDef(cond);
		if(psdList.size() > 0){
			dto.setProcessStatusDef(psdList.get(0));
		}
		getProcessParticipantsByStatus(dto);
		IGPRR0102Form form = new IGPRR0102Form();
		form.setPrid(process.getPrid());
		form.setPrstatus(process.getPrstatus());
		dto.setIgPRR0102Form(form);
		getAuthorizeuser(dto);
		log.debug("=============ȡ�����̲�������Ϣ��������===================");
		return dto;
	}
	
	/**
	 * ��ֵ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO copyProcessInfoValueAction(IGPRR01DTO dto) throws BLException {
		log.debug("==============��ֵ���Ʋ�����ʼ=================");
		//����ȡ��
		IGPRR0102Form form = dto.getIgPRR0102Form();
		/* ----------������ͨ��ֵ---------- */
		//��ѯ�����̵����б�����
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(form.getHistoryPrid());
		Map<String, IG599Info> historyPrInfoMap = new HashMap<String, IG599Info>();
		if(piList != null){
			for(IG599Info pi:piList){
				historyPrInfoMap.put(pi.getPidid(), pi);
			}
		}
		//ȡ�õ�ǰ���ı�ֵ
		Map<String, IG007Info> varmap = dto.getVarmap();
		//����֮��ı�ֵmap����
		Map<String, IG007Info> pivarmap = new LinkedHashMap<String, IG007Info>();
		if(varmap != null){
			Set<Entry<String, IG007Info>> set = varmap.entrySet();
			for(Iterator<Entry<String, IG007Info>> iter = set.iterator();iter.hasNext();){
				Entry<String, IG007Info> entry = iter.next();
				String key = entry.getKey();
				IG007Info info = entry.getValue();
				IG599Info value = historyPrInfoMap.get(key);
				IG007TB pidTB = (IG007TB) SerializationUtils.clone(info);
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(info.getPidaccess()) && value != null){
					pidTB.setPidvalue(value.getPivarvalue());
					//�����˽�б�����˽�б���ֵ���Ƹ���ǰ��
					if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(info.getPidmode())){
						pidTB.setProcessPrivateInfoList(value.getProcessPrivateInfofList());
					}
				}
				pivarmap.put(key, pidTB);
			}
		}
		dto.setVarmap(pivarmap);
		/* ----------���Ʊ���ֵ---------- */
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(form.getHistoryPrid());
		List<IG898Info> tableColumnValueList = workFlowOperationBL.searchTableFormValue(cond);
		if(tableColumnValueList != null){
			Map<String, Map<String, Map<String, String>>> tableColumnValueMap = new HashMap<String, Map<String,Map<String,String>>>();
			for(IG898Info columnValue:tableColumnValueList){
				String value = columnValue.getPvalue();
				if(StringUtils.isNotEmpty(columnValue.getAttkey())){
					value = "";
				}
				if(tableColumnValueMap.get(columnValue.getPidid()) == null){
					Map<String, Map<String, String>> one = new LinkedHashMap<String, Map<String,String>>();
					Map<String, String> two = new LinkedHashMap<String, String>();
					two.put(columnValue.getPvcolpidid(), value);
					one.put(columnValue.getPvrownumber(), two);
					tableColumnValueMap.put(columnValue.getPidid(), one);
				}else{
					if(tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()) == null){
						Map<String, String> temp = new LinkedHashMap<String, String>();
						temp.put(columnValue.getPvcolpidid(), value);
						tableColumnValueMap.get(columnValue.getPidid()).put(columnValue.getPvrownumber(), temp);
					}else{
						tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()).put(columnValue.getPvcolpidid(), value);
					}
				}
			}
			dto.setTableColumnValueMap(tableColumnValueMap);
		}
		
		List<IG731Info> pieList = workFlowOperationBL.searchProcessInfoEntityByPrid(form.getHistoryPrid());
		Map<String, IG731Info> pieMap = new HashMap<String, IG731Info>();
		if(pieList != null){
			for(IG731Info pie : pieList){
				String key = pie.getPieid() + "";
				pieMap.put(key, pie);
			}
		}
		dto.setPieMap(pieMap);
		log.debug("==============��ֵ���Ʋ�������=================");
		return dto;
	}
	
	/**
	 * ��ʼ���������ֵ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO initProcessInfoFormValue(IGPRR01DTO dto) throws BLException {
		List<IG505Info> list = workFlowOperationBL.searchIG505InfoByprid(dto.getProcess().getPrid());
		Map<String, IG505Info> processInfoFormValueMap = new LinkedHashMap<String, IG505Info>();
		if(list != null){
			for(IG505Info pv:list){
				String key = pv.getPiprrid() + "";
				processInfoFormValueMap.put(key, pv);
			}
		}
		dto.setProcessInfoFormValueMap(processInfoFormValueMap);
		return dto;
	}
	
	/**
	 * ��ʼ����Ա���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO initParticipantFormValue(IGPRR01DTO dto) throws BLException {
		List<IG506Info> list = workFlowOperationBL.searchIG506InfoByprid(dto.getProcess().getPrid());
		Map<String, IG506Info> participantFormValueMap = new LinkedHashMap<String, IG506Info>();
		if(list != null){
			for(IG506Info pv:list){
				String key = pv.getPiuid() + "";
				participantFormValueMap.put(key, pv);
			}
		}
		dto.setParticipantFormValueMap(participantFormValueMap);
		return dto;
	}
	
	/**
	 * ��װ��Ա��ʵ����Ϣ
	 * @param par_userids ��Աid����
	 * @param par_usernames ��Ա���Ƽ���
	 * @param par_orgids ��Ա�����뼯��
	 * @param par_orgnames ��Ա�������Ƽ���
	 * @param par_roleids ��Ա��ɫid����
	 * @param par_rolenames ��Ա��ɫ���Ƽ���
	 * @param par_pidids ��Ӧ������id����
	 * @return
	 */
	public Map<String, List<IG506TB>> packingParticipantList(String[] par_userids,String[] par_usernames,String[] par_orgids,String[] par_orgnames,Integer[] par_roleids,String[] par_rolenames,String[] par_pidids,String [] par_phone){
		Map<String, List<IG506TB>> participantFormInfo = new HashMap<String, List<IG506TB>>();
		if(par_userids == null 
				|| par_usernames == null
				|| par_orgids == null
				|| par_orgnames == null
				|| par_roleids == null
				|| par_rolenames == null
				|| par_pidids == null
				|| par_phone == null){
			return participantFormInfo;
		}
		for(int i=0;i<par_userids.length;i++){
			String pidid = par_pidids[i];
			IG506TB entry = new IG506TB();
			entry.setPiorgid(par_orgids[i]);
			entry.setPiorgname(par_orgnames[i]);
			entry.setPiroleid(Integer.valueOf(par_roleids[i]));
			entry.setPirolename(par_rolenames[i]);
			entry.setPiuserid(par_userids[i]);
			entry.setPiusername(par_usernames[i]);
			entry.setPiphone(par_phone[i]);
			if(participantFormInfo.get(pidid) == null){
				List<IG506TB> temp = new ArrayList<IG506TB>();
				temp.add(entry);
				participantFormInfo.put(pidid, temp);
			}else{
				participantFormInfo.get(pidid).add(entry);
			}
		}
		return participantFormInfo;
	}
	
	/**
	 * ���������̵�����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGPRR01DTO searchChileFlowChartAction(IGPRR01DTO dto) throws BLException {
		log.debug("===============����������ͼ���ɲ�����ʼ==============");
		IG333Info info = workFlowDefinitionBL.searchProcessStatusDefByKey(dto.getPsdid());
		if(info != null){
			String xml = info.getPsdxml();
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(info.getPsdtype())
				&& dto.getPrid() != null && dto.getPrid() > 0){
				IG224SearchCondImpl cond = new IG224SearchCondImpl();
				cond.setPrid(dto.getPrid());
				cond.setPpsdid(info.getPsdid());
				cond.setNowstatus("Y");
				cond.setCurrentPrstatus(true);
				List<IG224Info> list = workFlowOperationBL.searchProcessStatusLog(cond);
				Set<Integer> set = new LinkedHashSet<Integer>();
				for(IG224Info sl:list){
					if(sl.getPsdnum() != null && sl.getPsdnum() > 0){
						set.add(sl.getPsdnum());
					}
				}
				if(set.size() > 0){
					try {
						Document document = DocumentHelper.parseText(xml);
						Element root = document.getRootElement();
						List<Element> steps = new ArrayList<Element>();
						int height = 0;
						for(Iterator<Element> step = root.element("Steps").elementIterator("Step");step.hasNext();){
							Element next = step.next();
							steps.add(next);
							int g = Integer.valueOf(next.element("VMLProperties").attributeValue("y").replace("px", "")) + 100;
							if(g > height){
								height = g;
							}
						}
						List<Element> actions = new ArrayList<Element>();
						for(Iterator<Element> action = root.element("Actions").elementIterator("Action");action.hasNext();){
							Element next = action.next();
							actions.add(next);
						}
						
						String startid = "";
						String endid = "";
						int index = 0;
						
						document = DocumentHelper.createDocument();
						Element rootElement = document.addElement("WebFlow");
						Element stepsElement = rootElement.addElement("Steps");
						Element actionsElement = rootElement.addElement("Actions");
						for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
							Integer next = iter.next();
							for(Element e:steps){
								String type = e.element("BaseProperties").attributeValue("stepType");
								if((("BeginStep".equals(type) || "EndStep".equals(type)) && index == 0) || (!"BeginStep".equals(type) && !"EndStep".equals(type))){
									Element step = stepsElement.addElement("Step");
									Element baseProperties = step.addElement("BaseProperties");
									baseProperties.addAttribute("id", e.element("BaseProperties").attributeValue("id") + "_" + next);
									baseProperties.addAttribute("text", e.element("BaseProperties").attributeValue("text"));
									baseProperties.addAttribute("stepType", type);
									baseProperties.addAttribute("psdtype", e.element("BaseProperties").attributeValue("psdtype"));
									Element vmlProperties = step.addElement("VMLProperties");
									vmlProperties.addAttribute("width", e.element("VMLProperties").attributeValue("width"));
									vmlProperties.addAttribute("height", e.element("VMLProperties").attributeValue("height"));
									vmlProperties.addAttribute("x", e.element("VMLProperties").attributeValue("x"));
									int y = height * index + Integer.valueOf(e.element("VMLProperties").attributeValue("y").replace("px", ""));
									vmlProperties.addAttribute("y", y + "");
									if("BeginStep".equals(type)){
										startid = e.element("BaseProperties").attributeValue("id");
									}
									if("EndStep".equals(type)){
										endid = e.element("BaseProperties").attributeValue("id");
									}
								}
							}
							index ++;
						}
						for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
							Integer next = iter.next();
							for(Element e:actions){
								String id = e.element("BaseProperties").attributeValue("id") + "_" + next;
								String actionType = e.element("BaseProperties").attributeValue("actionType");
								String from = e.element("BaseProperties").attributeValue("from").equals(startid) ? e.element("BaseProperties").attributeValue("from") + "_1"  : e.element("BaseProperties").attributeValue("from") + "_" + next;
								String to = e.element("BaseProperties").attributeValue("to").equals(endid) ? e.element("BaseProperties").attributeValue("to") + "_1" : e.element("BaseProperties").attributeValue("to") + "_" + next;
								Element action = actionsElement.addElement("Action");
								Element baseProperties = action.addElement("BaseProperties");
								baseProperties.addAttribute("id", id);
								baseProperties.addAttribute("actionType", actionType);
								baseProperties.addAttribute("from", from);
								baseProperties.addAttribute("to", to);
							}
						}
						xml = document.asXML().replaceAll("\"", "'");
					} catch (Exception e) {
						log.error("",e);
					}
				}
			}
			dto.setFlowChartXml(xml);
		}
		log.debug("===============����������ͼ���ɲ�������==============");
		return dto;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessInfoLog(IGPRR01DTO dto) throws BLException {
		log.debug("=================����־��ѯ������ʼ=================");
		if(dto.getPrid() != null && dto.getPrid() > 0){
			//dto����ȡ��
			Integer prid = dto.getPrid();
			User user = dto.getUser();
			//��ѯ��ǰ����
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
			//��Ȩ�޼���
			List<IG893Info> variableList = null;
			//��ѯ��ǰ״̬
			List<String> statuses = workFlowOperationBL.searchCurrentRecordStatus(prid);
			//��ǰ�û���ǰ���̴����ɫ
			Integer roleid = null;
			
			//ȡ��״̬����ID
			String psdid = null;
			if(statuses != null && !statuses.isEmpty()){
				psdid = statuses.get(0).indexOf("_") > 0 ? statuses.get(0).split("_")[0] : statuses.get(0);
				//��ѯ��ǰ������
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(prid);
				ppCond.setPpproctimeIsNull("Y");
				ppCond.setPpstatus(psdid);
				//��ѯ��ǰ�ڵ������
				List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(ppCond);
				//�Ҳ�����Ӧ��ǰ�û��Ĵ����˼�¼ʱ�������в����˽�ɫ������ѯ�����������뵱ǰ�û�ͬ��ɫ������
				List<Integer> roleid_in = new ArrayList<Integer>();
				//������ǰ�����ˣ��ҵ���ǰ�û���Ӧ�Ĳ������û�
				for(IG337Info info:ppList){
					if(!roleid_in.contains(info.getPproleid())){
						roleid_in.add(info.getPproleid());
					}
					if(user.getUserid().equals(info.getPpuserid())){
						roleid = info.getPproleid();
					}
				}
				if(roleid == null){
					UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
					urcond.setRoleid_in(roleid_in);
					urcond.setUserid(user.getUserid());
					List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(urcond);
					if(roleList != null && roleList.size() > 0){
						roleid = roleList.get(0).getRoleid();
					}
				}
			}
			if(roleid != null){
				variableList = workFlowOperationBL.searchParticipantVariableVW(psdid,roleid);
			}else{
				dto.setProcess(process);
				getNotCurrentFormAccessPower(dto);
				variableList = dto.getParticipantVariableVWList();
			}
			if(variableList != null){
				//Ȩ�޼��ϣ�תΪMap������ͨ��������ID���ҵ�Ȩ��
				Map<String, IG893Info> variableMap = new HashMap<String, IG893Info>();
				for(IG893Info info:variableList){
					variableMap.put(info.getPidid(), info);
				}
				IG113SearchCondImpl cond = new IG113SearchCondImpl();
				cond.setPrid(dto.getPrid());
				List<IG113Info> list = workFlowOperationBL.searchRecordLogVarInfoByCond(cond);
				List<IG113Info> dataList = new ArrayList<IG113Info>();
				for(IG113Info info:list){
					IG893Info variable = variableMap.get(info.getPidid());
					if(variable != null){
						if(!IGPRDCONSTANTS.PROCESSTITLE_HIDE.equals(variable.getPidaccess())){
							dataList.add(info);
						}
					}
				}
				dto.setVarLogList(dataList);
			}
		}
		log.debug("=================����־��ѯ��������=================");
		return dto;
	}
	
	/**
	 * ��������prid��ȡ���̹�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchSerialNum(IGPRR01DTO dto) throws BLException {
		log.debug("===============��������prid��ȡ���̹����ſ�ʼ==============");
		IG500Info prInfo = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		if(prInfo != null){
			String serialNum = prInfo.getPrserialnum();
			dto.setSerialNum(serialNum);
		}
		log.debug("===============��������prid��ȡ���̹����Ž���==============");
		return dto;
	}

    /**
     * ��ȡ״̬��˽�б�ֵ����ֵ���� processInfoDefmap
     * �����ʲ���Ϣ����
     * @Title: getStatusPrivateValue
     * @param dto
     * @throws BLException
     */
    private void getStatusPrivateValue(IGPRR01DTO dto) throws BLException {
        log.debug("===========��ȡ״̬��˽�б�ֵ��ʼ================");
        //״̬��˽�б�ֵ�������û��ʵ��ֵ����ȡ��ѯĬ��ֵ��
        String prid=null;
        if(dto.getPrid()!=null&&dto.getPrid()!=0){
            prid=String.valueOf(dto.getPrid());
        }
        //��ѯĬ��ֵ��ʵ��ֵ
        Map<String, IG561Info> map = workFlowOperationBL.searchStatusValue(dto.getPdid(), dto.getPsdid(),prid);
        Map<String, IG007Info> processInfoDefmap = dto.getProcessInfoDefmap();
        if(processInfoDefmap==null){
            return;
        }
        for(Entry<String, IG007Info> entry:processInfoDefmap.entrySet()){
            IG007TB ig007TB=(IG007TB)entry.getValue();
            if(map.get(entry.getKey())!=null){
                IG561Info ig561Info= map.get(entry.getKey());
                ig007TB.setPidvalue(ig561Info.getPivarvalue());//ֱ�Ӹ���ָ��ָ�򣬲��ش�
                //����Ǹ������򽫸�����ֵ���루�����߼�����ѯ�Ѿ��ϴ�����ATT����Ĭ��Att��
                if("F".equals(ig561Info.getPivartype())){
                    if(StringUtils.isNotEmpty(ig561Info.getPiattkey()))
                        ig007TB.setPidvalue(ig561Info.getPiattkey());
                }
//              ig007TB.setPiddefault(ig561Info.getPivarvalue());
//              if(ig561Info.getPvlid()!=null&&ig561Info.getPvlid()!=0){
//                  ig007TB.setPiid(ig561Info.getPvlid());
//              }
            }
        }
        //������ʾ���������ʲ�����prossinfolist��
        List<IG599Info> pilist = dto.getProcessInfo();
        List<IG599Info> deletelist= new ArrayList<IG599Info>();
        if(pilist==null){
            return ;
        }
        for(IG599Info info:pilist){
            boolean flag=true;
            if("4".equals(info.getPivartype())&&"2".equals(info.getPidmode())){
                flag=false;
            }
            for(Entry<String, IG561Info> entry:map.entrySet()){
                IG561Info ig561TB=entry.getValue();
                if(info.getPiid().intValue()==(ig561TB.getPiid()!=null?ig561TB.getPiid().intValue():0)){
                    flag=true;
                    //��ʵ���ʲ�����
                    this.copyProperties(info, ig561TB);
                    //������ʲ�ֵ�������(״̬��˽�б����¼ʵ���ʲ���ֵ���������ֲ����ڵ��в������ʲ�)
                    if("4".equals(info.getPivartype())){
                        ((IG599TB)info).setPivarvalue("");
                    }
                }
            }
            if(!flag){
                deletelist.add(info);
            }
        }
        //������ɿ�����ȫ��ɾ��������û��ʵ��ֵ��ֻ��Ĭ��ֵ��
        pilist.removeAll(deletelist);
        log.debug("===========��ȡ״̬��˽�б�ֵ����================");
    }
	
    
    /**
     * @throws BLException 
     * ���̴��ڹر�״̬�����̲鿴��ʾ����Ҫ��״̬�������б���ʽ��ʾ 
     * @Title: statusCloseSeeOperate
     * @Description: ���̴��ڹر�״̬�����̲鿴��ʾ����Ҫ��״̬�������б���ʽ��ʾ 
     * @param dto
     * @throws
     */
    private void statusCloseSeeOperate(IGPRR01DTO dto) throws BLException{
        //������ǹر�״ֱ̬�ӷ���
        if(!dto.getPsdid().endsWith("002")){
            return;
        }
        IG560SearchCondImpl cond560 = new IG560SearchCondImpl();
        cond560.setPidid_l(dto.getPdid());
        List<IG560Info> list_560=workFlowDefinitionBL.searchIG560TBInfo(cond560);
        Map<String,IG560Info> defaultmap = new HashMap<String, IG560Info>();
        //���α����ȴ���ȫ�ֵĺ�������ĸ���
        for(IG560Info info:list_560 ){
            if(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall())){
                defaultmap.put(info.getPidid(), info);
            }
        }
        //Ĭ��ֵ�ڵ㴦��
        for(IG560Info info:list_560 ){
            if(!(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall()))){
                //pidid+psdid ��Ϊkey
                defaultmap.put(info.getPidid()+info.getPsdid(), info);
            }
        }
        
        String prid=null;
        if(dto.getPrid()!=null&&dto.getPrid()!=0){
            prid=String.valueOf(dto.getPrid());
        }
        String userid=dto.getUser().getUserid();
        List<IG561VWInfo> list561VW = workFlowOperationBL.searchIG561VW(prid, userid, false);
        if(list561VW==null||list561VW.size()==0){
            return;
        }
        //keyΪpidid
        Map<String,List<IG561VWInfo>> map= new HashMap<String, List<IG561VWInfo>>();
        for(IG561VWInfo ig561vwInfo :list561VW){
            //��info ���д������pidaccess Ϊֻ���������Ĭ��ֵ��Ĭ��ֵ����.
            IG561VW tb= (IG561VW)SerializationUtils.clone(ig561vwInfo);
            //���������ʲ�Ϊ��
            if(("F".equals(tb.getPivartype())&&StringUtils.isEmpty(tb.getPiattkey()))
                    ||
               ("4".equals(tb.getPivartype())&&StringUtils.isEmpty(tb.getPivarvalue()))){
                //�����ȫ��Ĭ��ֵ��ȫ��Ĭ��ֵ����
                String defaultvalue=null;
                if(defaultmap.get(tb.getPidid())!=null){
                    defaultvalue= defaultmap.get(tb.getPidid()).getDfvalue();
                }
                //����нڵ������Ĭ��ֵ���򸲸�ȫ��Ĭ��ֵ
                if(defaultmap.get(tb.getPidid()+tb.getPsdid())!=null){
                    defaultvalue= defaultmap.get(tb.getPidid()+tb.getPsdid()).getDfvalue();
                }
                if(StringUtils.isNotEmpty(defaultvalue)){
                    tb.setPivarvalue("def_"+defaultvalue);
                }
            }
            //��װ����map
            if(map.get(tb.getPidid())!=null){
                List<IG561VWInfo> list= map.get(tb.getPidid());
                list.add(tb);
            }else{
                List<IG561VWInfo> list= new ArrayList<IG561VWInfo>();
                list.add(tb);
                map.put(tb.getPidid(), list);
            }
        }
        dto.setStatusclosedetails(map);
    }
    
    /**
     * ����״̬��˽�б�����ֵ
     */
    private void saveOrUpdateStatusVars(IGPRR0102Form form, List<IG599Info> processInfoList, String[] attStr, Map<Integer, FormFile> fileMapMuti,
            String delFileMutiStr,String psdid) throws BLException {
        //״̬��˽�б�����ת���߼�
        List<String> existStr = new ArrayList<String>();
        if(attStr!=null){
            for(int i = 0; i < attStr.length; i++){
                String[] att = attStr[i].split("_");
                if(existStr.contains(att[0])){
                    continue;
                }
                Integer piid;
                for(int j = 0; j < processInfoList.size();j++){
                    IG599TB piTB = (IG599TB)processInfoList.get(j);
                    if(att[0].equals(piTB.getPivarlabel()) && IGPRDCONSTANTS.PIDMODE_STATUS.equalsIgnoreCase(piTB.getPidmode())){
                        piid = piTB.getPiid();
                        IG599Info pi = workFlowOperationBL.getProcessInfoByID(piid);
                        if(IGPRDCONSTANTS.PIDMODE_PUBLIC.equalsIgnoreCase(pi.getPidmode())){
                            continue;
                        }
                        IG561SearchCondImpl cond = new IG561SearchCondImpl();
                        cond.setPiid_q(piid.toString());
                        cond.setPsdid_l(psdid);
                        List<IG561Info> statusInfos =  workFlowOperationBL.searchIG561Info(cond);
                        //״̬û�������Ϣ
                        if(statusInfos == null || statusInfos.size() == 0){
                            Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
                            for(int k = 0; k < attStr.length;k++){
                                if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
                                    if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
                                        filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
                                        if(!existStr.contains(pi.getPivarlabel())){
                                            existStr.add(pi.getPivarlabel());
                                        }
                                    }
                                }
                            }
                            pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
                            piTB.setPiattkey(pi.getPiattkey());
                            processInfoList.set(j, piTB);
                        }else{
                            //˽�б��������Ϣ�����и���
                            for(int iNum = 0; iNum < statusInfos.size(); iNum++){
                                IG561TB ig561TB = (IG561TB)statusInfos.get(iNum);
                                if(StringUtils.isNotEmpty(ig561TB.getPiattkey())){
                                    Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
                                    for(int k = 0; k < attStr.length;k++){
                                        if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
                                            if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
                                                filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
                                                if(!existStr.contains(pi.getPivarlabel())){
                                                    existStr.add(pi.getPivarlabel());
                                                }
                                            }
                                        }
                                    }
                                    workFlowOperationBL.addProcessInfoAtt(filemap, ig561TB.getPiattkey());
                                }else{
                                    Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
                                    for(int k = 0; k < attStr.length;k++){
                                        if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
                                            if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
                                                filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
                                                if(!existStr.contains(pi.getPivarlabel())){
                                                    existStr.add(pi.getPivarlabel());
                                                }
                                            }
                                        }
                                    }
                                    pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
                                    piTB.setPiattkey(pi.getPiattkey());
                                    processInfoList.set(j, piTB);
                                }
                            }
                        }
                    }
                }
            }
        }
    }



    
}

