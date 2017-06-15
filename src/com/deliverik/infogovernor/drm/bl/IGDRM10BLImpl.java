/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;
import org.hibernate.type.Type;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeCategoryDefBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCondImpl;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.model.entity.CodeCategoryDefTB;
import com.deliverik.framework.model.entity.CodeDetailDefTB;
import com.deliverik.framework.model.entity.CodeDetailDefTBPK;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prd.model.entity.IG893VW;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.CustomQueryBL;
import com.deliverik.infogovernor.drm.bl.task.EmergencyLogBL;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.bl.task.StructureRoleBL;
import com.deliverik.infogovernor.drm.dto.IGDRM10DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1001Form;
import com.deliverik.infogovernor.drm.form.IGDRM1002Form;
import com.deliverik.infogovernor.drm.form.IGDRM1003Form;
import com.deliverik.infogovernor.drm.form.IGDRM1004Form;
import com.deliverik.infogovernor.drm.form.IGDRM1010Form;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.StructureRoleSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EmergencyLogTB;
import com.deliverik.infogovernor.drm.model.entity.StructureRoleTB;
import com.deliverik.infogovernor.drm.push.MessagePushBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.deliverik.infogovernor.util.DateUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * ��������ɫ��֯�ܹ���ϵ��ϢBLʵ��
 * �����ˣ�
 * ������¼�� 2014/06/25
 * �޸ļ�¼��
 */
@SuppressWarnings("unchecked")
public class IGDRM10BLImpl extends BaseBLImpl implements IGDRM10BL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGDRM10BLImpl.class);
	
	/**��ɫ��֯�ܹ���ϵBL*/
	protected StructureRoleBL structureRoleBL;
	
	protected CodeDetailDefBL codeDetailDefBL;

	protected SysManageBL sysManageBL;
	
	/** ���ݷ�����ϢBL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**��ԱBL*/
	protected UserBL userBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** �Զ����ѯBL */
	protected CustomQueryBL customQueryBL;

	/** Ӧ����ϵBL */
	protected EmergencyRelationBL emergencyRelationBL;
	
	/** �ʲ�ʵ����ͼBL */
	protected SOC0118VWBL soc0118VWBL;

	/** ���Ͷ���BL */
	protected SendMessageBL sendMessageBL;

	/** ��Ϣ����BL */
	protected MessagePushBL messagePushBL;

	/** Ӧ����־BL */
	protected EmergencyLogBL emergencyLogBL;

	/** �ļ��ϴ�BL  */
	protected FileUploadBL fileUploadBL;

	/** ״̬����ֵ��BL */
	protected IG561BL ig561BL;

	public void setIg561BL(IG561BL ig561bl) {
		ig561BL = ig561bl;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setMessagePushBL(MessagePushBL messagePushBL) {
		this.messagePushBL = messagePushBL;
	}

	public void setEmergencyLogBL(EmergencyLogBL emergencyLogBL) {
		this.emergencyLogBL = emergencyLogBL;
	}

	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	public void setEmergencyRelationBL(EmergencyRelationBL emergencyRelationBL) {
		this.emergencyRelationBL = emergencyRelationBL;
	}

	public void setCustomQueryBL(CustomQueryBL customQueryBL) {
		this.customQueryBL = customQueryBL;
	}

	/**
	 * ��ȡuserBL
	 * 
	 * @return userBL
	 */
	public UserBL getUserBL() {
		return userBL;
	}

	/**  
	 * ����userBL  
	 * @param userBL
	 */
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	public void setSysManageBL(SysManageBL sysManageBL) {
        this.sysManageBL = sysManageBL;
    }

    public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
        this.codeDetailDefBL = codeDetailDefBL;
    }

    public void setStructureRoleBL(StructureRoleBL structureRoleBL) {
        this.structureRoleBL = structureRoleBL;
    }

    /**
	 * @param ���ݷ�����ϢBL the codeCategoryDefiBL to set
	 */
	public void setCodeCategoryDefiBL(CodeCategoryDefBL codeCategoryDefiBL) {
		this.codeCategoryDefiBL = codeCategoryDefiBL;
	}

	/**
	 * @param ���̴���BL the workFlowOperationBL to set
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
	 * �ʲ�ʵ����ͼBL�趨
	 * @param soc0118VWBL �ʲ�ʵ����ͼBL
	 */
	public void setSoc0118VWBL(SOC0118VWBL soc0118vwbl) {
		soc0118VWBL = soc0118vwbl;
	}

	/**
     * ��ɫ��֯�ܹ���ϵ��ʼ����ѯ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDRM10DTO initIGDRM1002Action(IGDRM10DTO dto) throws BLException{
        log.info("=======��֯�ܹ���ѯ��ʼ===============");
        IGDRM1002Form form=(IGDRM1002Form)dto.getForm();
        CodeDetailDefSearchCondImpl condcode= new CodeDetailDefSearchCondImpl();
        condcode.setSyscoding_q(form.getSyscoding());
        List<CodeDetailDef> searchCodeDetailDef = codeDetailDefBL.searchCodeDetailDef(condcode);
        if(searchCodeDetailDef==null||searchCodeDetailDef.size()>1){
           throw new BLException("IGDRM1001.E001","û��ѡ����Ч����֯�ܹ���"); 
        }else{
            dto.setCodDetailDef(searchCodeDetailDef.get(0));
        }
        StructureRoleSearchCondImpl cond= new StructureRoleSearchCondImpl();
        cond.setSyscoding_q(form.getSyscoding());
        // ��ѯ��¼����
        List<StructureRoleInfo> list = this.structureRoleBL.searchStructureRole(cond, 0,0);
        dto.setRelationlist(list);
        log.info("=======��֯�ܹ���ѯ����===============");
        return dto;
    }
    
    /**
     * ��ɫ��֯�ܹ���ϵ�޸Ĳ�ѯ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDRM10DTO editIGDRM1002Action(IGDRM10DTO dto) throws BLException{
        log.info("=======��֯�ܹ���ɫ��ϵ������ʼ===============");
        IGDRM1002Form form=(IGDRM1002Form)dto.getForm();
        CodeDetailDefSearchCondImpl condcode= new CodeDetailDefSearchCondImpl();
        condcode.setSyscoding_q(form.getSyscoding());
        List<CodeDetailDef> list = codeDetailDefBL.searchCodeDetailDef(condcode);
        if(list==null||list.size()>1||list.size()==0){
           throw new BLException("IGDRM1001.E001","û��ѡ����Ч����֯�ܹ���"); 
        }
        CodeDetailDef codeinfo= list.get(0);
        RoleInfo roleinfo = sysManageBL.searchRoleInfo(Integer.valueOf(form.getRoleid()));
        StructureRoleTB tb= new StructureRoleTB();
        tb.setRoleid(roleinfo.getRoleid());
        tb.setRolename(roleinfo.getRolename());
        tb.setSyscoding(form.getSyscoding());
        tb.setSname(codeinfo.getCvalue());
        tb.setCid(codeinfo.getCid());
        if(form.getSyscoding().startsWith("130")){
            tb.setSrtype("Y");
        }else{
            tb.setSrtype("R");
        }
        structureRoleBL.registStructureRole(tb);
        log.info("=======��֯�ܹ���ɫ��ϵ��������===============");
        return dto;
    }
    /**
     * ��ɫ��֯�ܹ���ϵ���»���뷽��
     * 
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDRM10DTO searchRole(IGDRM10DTO dto) throws BLException{
        log.info("===========��ɫ��ѯ����ʼ===============");
        IGDRM1002Form form=(IGDRM1002Form)dto.getForm();
        StructureRoleSearchCondImpl cond= new StructureRoleSearchCondImpl();
		if (form.getSyscoding() != null && form.getSyscoding().startsWith("230")) {
            cond.setSrtype("Y");
        }else{
            cond.setSrtype("R");
        }
        cond.setRolename(form.getRolename());
        // ��ѯ��¼����
        int totalCount = this.structureRoleBL.searchRoleCount(cond);
        if (totalCount == 0) {
            log.debug("========��ѯ���ݲ�����========");
            // ��ѯ���ݲ�����
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========��ѯ���ݼ�������========");
            // ��ѯ���ݼ�������
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        dto.getPagingDto().setTotalCount(totalCount);
        List<RoleInfo> rolelist = this.structureRoleBL.searchRole(cond, dto.getPagingDto().getFromCount(), dto.getPagingDto().getPageDispCount());
        dto.setRolelist(rolelist);
        log.info("===========��ɫ��ѯ�������===============");
        return dto;
    }
    /** 
     * @Title: deleteRoleRelation 
     * @param dto
     * @return    
     * IGDRM10DTO    
     * @throws 
     */
	public IGDRM10DTO deleteRoleRelation(IGDRM10DTO dto)throws BLException{
        IGDRM1002Form form=(IGDRM1002Form)dto.getForm();
        structureRoleBL.deleteStructureRoleByPK(Integer.valueOf(form.getSrid()));
        return dto;
    }
    /**
	 * ������Ϣ��ϸ���������ʾ
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1001Action(IGDRM10DTO dto) throws BLException {
		log.debug("========������ϸ��Ϣ���������ʾ����ʼ========");
		
		IGDRM1001Form form = dto.getIgdrm1001Form();
		
		//���ݷ�����Ϣ��ѯ
		CodeCategoryDefInfo codeCategoryInfo = 
			this.codeCategoryDefiBL.searchCodeCategoryDefByPK(form.getCcid());
		
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		//������ϸ��Ϣ��ѯ
		CodeDetailDef codeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		
		//������ϸ��Ϣ��ѯ
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		if("1".equals(form.getClevel())){
			cond.setCcid(form.getCcid());
			codeDetail= null;
		}else{
			cond.setPccid(form.getCcid());
			cond.setPcid(form.getCid());
		}
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
		dto.setCodeCategoryDefInfo(codeCategoryInfo);
		dto.setCodeDetailDefList(codeDetailList);
		dto.setCodeDetailDef(codeDetail);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",codeDetailList.size()));

		log.debug("========������ϸ��Ϣ���������ʾ��������========");
		return dto;
	}
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO deleteCodeDetailDefAction(IGDRM10DTO dto) throws BLException {
		log.debug("========������Ϣɾ������ʼ========");
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		
		pk.setCcid(dto.getIgdrm1001Form().getTempccid());
		pk.setCid(dto.getIgdrm1001Form().getTempcid());
		CodeDetailDefTB codeDetailTB = (CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		String cdstatus = "1" ;
		if("1".equals(dto.getIgdrm1001Form().getCdstatus())){
			checkStop(dto.getIgdrm1001Form().getTempccid(), dto.getIgdrm1001Form().getTempcid());
			cdstatus = "0";
		}
		codeDetailTB.setCdstatus(cdstatus);
		
		this.codeDetailDefBL.updateCodeDetailDef(codeDetailTB);
		
		//Cache����
//		codeListUtils.updateCodeDetailCache(codeDetail.getCcid(), codeDetail.getPccid(),
//				codeDetail.getPcid());
		if("1".equals(cdstatus)){
			dto.addMessage(new ActionMessage( "IGSYM1101.I002", "����") );
		}else{
			dto.addMessage(new ActionMessage( "IGSYM1101.I001", "����") );
		}

		log.debug("========������Ϣɾ����������========");
		return dto;
	}
	/**
	 * У���Ƿ��¼��Ƿ���δͣ�õ�����
	 *
	 * @param ccid
	 * @param cid
	 */
	protected void checkStop(String ccid,String cid) throws BLException {
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		cond.setPccid(ccid);
		cond.setPcid(cid);
		cond.setCdstatus("1");
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond, 2);//������
		if (!codeDetailList.isEmpty()) {
			throw new BLException("IGSYM1101.E001");
		}
	}
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO realdeleteCodeDetailDefAction(IGDRM10DTO dto) throws BLException {
		log.debug("========��������ɾ������ʼ========");
		
		IGDRM1001Form form = dto.getIgdrm1001Form();
		
		//�������Ƿ����ڱ�δ�رյ��Զ�������ʹ�ã�δʹ�ÿ�ɾ��
		//boolean psi_delFlag = true;//���̱������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
		boolean psid_delFlag = false;//���̱���������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
		
		//��ѯIG007���Ƿ����pidtype=T�ļ�¼,�����������ɾ��
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPidtype(IGPRDCONSTANTS.PROCESSVAR_TREE_TYPE);
		List<IG007Info> pidList = this.workFlowOperationBL.searchProcessInfoDefByCond(pidcond);
		
		if(pidList!=null && pidList.size()>0){
			for(IG007Info pid:pidList){
				String pidccid = pid.getCcid();
				//���̱���������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
				if(pidccid!=null && form.getTempccid().equals(pidccid.split("_tree_")[0])){
					psid_delFlag = true;
					break;
				}
				
			}
		}
		
		if(psid_delFlag){
			throw new BLException("IGSYM1101.E003");
		}
		CodeDetailDefSearchCondImpl condImpl = new CodeDetailDefSearchCondImpl();
		condImpl.setSyscoding(form.getSyscoding());
		List<CodeDetailDef> defList = this.codeDetailDefBL.searchCodeDetailDef(condImpl);
		for(CodeDetailDef def : defList){
			CodeDetailDefTB defClone = (CodeDetailDefTB)SerializationUtils.clone(def);
			codeDetailDefBL.deleteCodeDetailDef(defClone);
		}
		//����ɾ����֯�ܹ�������
		StructureRoleSearchCondImpl srcond = new StructureRoleSearchCondImpl();
		srcond.setSyscoding(form.getSyscoding());
		List<StructureRoleInfo> srList = structureRoleBL.searchStructureRole(srcond);
		if(srList!=null&&srList.size()>0){
			for(StructureRoleInfo srInfo : srList){
				StructureRoleTB srInfoClone = (StructureRoleTB)SerializationUtils.clone(srInfo);
				structureRoleBL.deleteStructureRole(srInfoClone);
			}
		}
		log.debug("========��������ɾ����������========");
		return dto;
	}
	/**
	 * ������Ϣ��ϸ���淵����ʾ
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1001BackAction(IGDRM10DTO dto) throws BLException {
	log.debug("========������ϸ��Ϣ���������ʾ����ʼ========");
		
		IGDRM1001Form form = dto.getIgdrm1001Form();
		
		CodeDetailDefTBPK pkey = new CodeDetailDefTBPK();
		pkey.setCcid(form.getCcid());
		pkey.setCid(form.getCid());
		//������ϸ��Ϣ��ѯ
		CodeDetailDef pcodeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pkey);
		//������ϸ��Ϣ��ѯ
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		//���ݷ�����Ϣ��ѯ
		CodeCategoryDefInfo codeCategoryInfo = 
			this.codeCategoryDefiBL.searchCodeCategoryDefByPK(pcodeDetail.getPccid());
		
		if(codeCategoryInfo==null){
			dto.setCodeDetailDef(null);
			form.setClevel("1");
		}else{
			CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
			pk.setCcid(pcodeDetail.getPccid());
			pk.setCid(pcodeDetail.getPcid());
			//������ϸ��Ϣ��ѯ
			CodeDetailDef codeDetail = this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
			dto.setCodeDetailDef(codeDetail);
		}
		if(codeCategoryInfo==null){
			codeCategoryInfo = 
				this.codeCategoryDefiBL.searchCodeCategoryDefByPK(pcodeDetail.getCcid());
			cond.setCcid(pcodeDetail.getCcid());
		}else{
			cond.setPccid(pcodeDetail.getPccid());
			cond.setPcid(pcodeDetail.getPcid());
		}
		
		
		List<CodeDetailDef> codeDetailList = 
			this.codeDetailDefBL.searchCodeDetailDef(cond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		
		dto.setCodeCategoryDefInfo(codeCategoryInfo);
		dto.setCodeDetailDefList(codeDetailList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",codeDetailList.size()));

		log.debug("========������ϸ��Ϣ���������ʾ��������========");
		return dto;
	}
	/**
	 * ���ݷ�����Ϣ��ѯ����
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1003Action(IGDRM10DTO dto) throws BLException {

		log.debug("========���ݷ�����Ϣ��ѯ����ʼ========");
		// ���˱�ʶ
		String orgFlag = dto.getOrgFlag();
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		cond.setTree(true);
		
//		int totalCount = this.codeCategoryDefiBL.getSearchCount(cond);
		// ������Ϣ����
		int totalCount = 0;
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		
		//���ݷ�����Ϣȡ��
		List<CodeCategoryDefInfo> codeCategoryInfoList = 
			this.codeCategoryDefiBL.searchCodeCategoryDefPaging(cond, pDto.getFromCount(), pDto.getPageDispCount());
		if (orgFlag != null && "1".equals(orgFlag)) {
			List<CodeCategoryDefInfo> sList = new ArrayList<CodeCategoryDefInfo>();
			;
			// ������ʾ���
			for (CodeCategoryDefInfo info : codeCategoryInfoList) {
				if (IGDRMCONSTANTS.ORGSTRU_CCID.contains(info.getCcid())) {
					sList.add(info);// ���������֯�ܹ���Ӧ��������
					totalCount++;
				}
			}
			dto.setCodeCategoryDefInfoList(sList);
		} else {
			totalCount = this.codeCategoryDefiBL.getSearchCount(cond);
			dto.setCodeCategoryDefInfoList(codeCategoryInfoList);
		}
		pDto.setTotalCount(totalCount);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ݷ�����Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * ���ݷ���ɾ������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO deleteIGDRM1003Action(IGDRM10DTO dto) throws BLException {
		IGDRM1003Form form = dto.getIgdrm1003Form();
		
		//�������Ƿ����ڱ�δ�رյ��Զ�������ʹ�ã�δʹ�ÿ�ɾ��
		//boolean psi_delFlag = true;//���̱������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
		boolean psid_delFlag = false;//���̱���������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
		
		//��ѯIG007���Ƿ����pidtype=T�ļ�¼,�����������ɾ��
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPidtype(IGPRDCONSTANTS.PROCESSVAR_TREE_TYPE);
		List<IG007Info> pidList = this.workFlowOperationBL.searchProcessInfoDefByCond(pidcond);
		
		if(pidList!=null && pidList.size()>0){
			for(IG007Info pid:pidList){
				String pidccid = pid.getCcid();
				//���̱���������Ƿ�ʹ���˸�����ʹ���˲���ɾ��
				if(pidccid!=null && form.getCcid().equals(pidccid.split("_tree_")[0])){
					psid_delFlag = true;
					break;
				}
				
			}
		}
		
		if(psid_delFlag){
			throw new BLException("IGSYM1101.E003");
		}
		
		for(int i = 0; i < 4; i++){
			String ccid = String.valueOf((Integer.parseInt(form.getCcid())+i));
			this.codeCategoryDefiBL.deleteCodeCategoryDef(ccid);
		}
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I004"));
		
		return dto;
	}
	/**
	 * ���ݷ�����������
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO saveIGDRM1003Action(IGDRM10DTO dto) throws BLException {
		log.debug("========���ݷ�����������ʼ========");
		IGDRM1003Form form = dto.getIgdrm1003Form();
		CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
		List<CodeCategoryDefInfo> infoList = this.codeCategoryDefiBL.searchCodeCategoryDefDescCiid(cond, 0, 1);
		String ccid = "";
		if(infoList == null || infoList.size() == 0){
			ccid = "100";
		}else{
			ccid = infoList.get(0).getCcid();
		}
		ccid = getNewCcid(ccid);
		//��������һ������
		CodeCategoryDefTB cctb = new CodeCategoryDefTB();
		cctb.setCcid(ccid);//���ݷ���ID
		cctb.setCcname(form.getCcname());
		cctb.setCcinfo(form.getCcinfo());
		cctb.setCceditable("3");//3����ǻ������ݣ���ɾ��
		cctb.setPcflag("4");//��������֧��4��Ŀ¼
		
		CodeCategoryDefInfo cc = this.codeCategoryDefiBL.registCodeCategoryDef(cctb);
		
		//����1��
		CodeCategoryDefInfo cc1 = getCodeCategoryDefTB(cc,"һ������","һ������");
		//����2��
		CodeCategoryDefInfo cc2 = getCodeCategoryDefTB(cc1,"��������","��������");
		//����3��
		getCodeCategoryDefTB(cc2,"��������","��������");
		
		
		dto.addMessage(new ActionMessage("IGSYM1101.I003"));
		log.debug("========���ݷ���������������========");
		return dto;
	}
	private String getNewCcid(String ccid)throws BLException{
		if(StringUtils.isEmpty(ccid)){
			return "100";
		}else{
			return String.valueOf(Integer.parseInt(ccid)+1);
		}
	}
	/**
	 * ���ݷ����¼���������
	 */
	private CodeCategoryDefInfo getCodeCategoryDefTB(CodeCategoryDefInfo cci,String ccname,String ccinfo) throws BLException {
		
		Integer id = Integer.valueOf(cci.getCcid());
		
		while(true){
			if(id==999){
				throw new BLException("IGSYM1107.E002");
			}
			id++;
			CodeCategoryDefInfo temp_cc = this.codeCategoryDefiBL.searchCodeCategoryDefByPK(String.valueOf(id));
			if(temp_cc==null){
				break;
			}
		}
		
		String temp_id = "";
		String tmp = String.valueOf(id);
		if(tmp.length()==1){
			temp_id = "00"+tmp;
		}else if(tmp.length()==2){
			temp_id = "0"+tmp;
		}else{
			temp_id = tmp;
		}
		
		CodeCategoryDefTB cctb1 = new CodeCategoryDefTB();
		cctb1.setCcid(temp_id);
		cctb1.setCcname(ccname);
		cctb1.setCcinfo(ccinfo);
		cctb1.setCceditable("3");//3����ǻ������ݣ���ɾ��
		cctb1.setPcflag("4");//��������֧��4��Ŀ¼
		cctb1.setPccid(cci.getCcid());//����ccid
		
		CodeCategoryDefInfo cci1 = this.codeCategoryDefiBL.registCodeCategoryDef(cctb1);
		
		return cci1;
	}
	/**
	 * ������Ϣ�༭���������ʾ
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1004Action(IGDRM10DTO dto) throws BLException {
		log.debug("========������Ϣ�༭���������ʾ����ʼ========");
		IGDRM1004Form form = dto.getIgdrm1004Form();
		
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(form.getCcid());
		pk.setCid(form.getCid());
		
		CodeDetailDefTB codeDetail = 
			(CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
		
		if (codeDetail==null) {
			throw new BLException("IGCO10000.E004","�����������");
		}
		
		//����������Ϣȡ��
		if (StringUtils.isNotEmpty(codeDetail.getPccid())
				&& StringUtils.isNotEmpty(codeDetail.getPcid())) {
			CodeDetailDefTBPK ppk = new  CodeDetailDefTBPK();
			ppk.setCcid(codeDetail.getPccid());
			ppk.setCid(codeDetail.getPcid());
			
			CodeDetailDefTB pCodeDetail = 
				(CodeDetailDefTB)this.codeDetailDefBL.searchCodeDetailDefByPK(ppk);
			
			if (pCodeDetail != null) {
				//����������Ϣ������,���������趨
				form.setPccname(pCodeDetail.getCodeCategoryDef().getCcname());
				form.setPcvalue(pCodeDetail.getCvalue());				
			}
			
		}else{
			form.setPcvalue("");				
		}
		form.setCvalue(codeDetail.getCvalue());
		form.setPccid(codeDetail.getPccid());
		form.setPcid(codeDetail.getPcid());
		form.setCcname(codeDetail.getCodeCategoryDef().getCcname());
		if(StringUtils.isEmpty(codeDetail.getPccid())){
			form.setClevel("1");
		}
		form.setPsyscoding(codeDetail.getPsyscoding());
		form.setSyscoding(codeDetail.getSyscoding());
		form.setCdstatus(codeDetail.getCdstatus());
		form.setBusinesscode(codeDetail.getBusinesscode());
		form.setMode("1");
		
		dto.setIgdrm1004Form(form);
		
		log.debug("========������Ϣ�༭���������ʾ��������========");
		
		return dto;
	}
	/**
	 * ������Ϣ���´���
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO updateCodeDetailDefAction(IGDRM10DTO dto) throws BLException {
		log.debug("========������Ϣ���´���ʼ========");
		
		IGDRM1004Form form = dto.getIgdrm1004Form();
		if("1".equals(form.getClevel())){
			form.setPccid(null);
			checkParCodeDetail(form.getPccid(),form.getPcid());
		}
		if (form.getCcid().equals(form.getPccid()) && form.getCid().equals(form.getPcid())) {
			throw new BLException("IGSYM1104.E002");
		}
		
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		form.setUpdtime(datetime);

		this.codeDetailDefBL.updateCodeDetailDef(form);
		StructureRoleSearchCondImpl cond = new StructureRoleSearchCondImpl();
		cond.setSyscoding_q(form.syscoding);
		List<StructureRoleInfo> srList = structureRoleBL.searchStructureRole(cond);
		for (StructureRoleInfo structureRoleInfo : srList) {
			
			StructureRoleTB srtb = (StructureRoleTB)structureRoleInfo;
			srtb.setSname(form.getCvalue());
			structureRoleBL.updateStructureRole(srtb);
			
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "����") );

		log.debug("========������Ϣ���´�������========");
		return dto;
	}
	/**
	 * У���ϼ��Ƿ����
	 *
	 * @param ccid 
	 * @param cid 
	 */
	protected void checkParCodeDetail(String ccid,String cid) throws BLException {
		if (StringUtils.isNotEmpty(ccid)) {
			if (StringUtils.isNotEmpty(cid)) {
				CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
				
				pk.setCcid(ccid);
				pk.setCid(cid);
				
				CodeDetailDef codeDetail = 
					this.codeDetailDefBL.searchCodeDetailDefByPK(pk);
				
				if (codeDetail == null) {
					throw new BLException("IGCO10000.E004","������������");
				}
				
			} else {
				throw new BLException("IGSYM1104.E001","���ݱ��(��)");
			}
		} else {
			if (StringUtils.isNotEmpty(cid)) {
				throw new BLException("IGSYM1104.E001","���ݷ�����(��)");
			}
		}
	}
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO insertCodeDetailDefAction(IGDRM10DTO dto) throws BLException {
		
		log.debug("========������Ϣ�ǼǴ���ʼ========");

		IGDRM1004Form form = dto.getIgdrm1004Form();
		String syscoding = null;
		if(!"1".equals(form.getClevel())){
			CodeCategoryDefSearchCondImpl cond = new CodeCategoryDefSearchCondImpl();
			cond.setPccid(form.getCcid());
			List<CodeCategoryDefInfo> list = this.codeCategoryDefiBL.searchCodeCategoryDef(cond);
			form.setCcid(list.get(0).getCcid());
			syscoding = this.codeDetailDefBL.getSyscoding(form.getPsyscoding());
			if(syscoding == null){
				syscoding = getSyscoding(form.getPsyscoding()+StringUtils.leftPad("0", CommonDefineUtils.TREE_LEVEL_CODE , "0"),CommonDefineUtils.TREE_LEVEL_CODE);
			}else{
				syscoding = getSyscoding(syscoding,CommonDefineUtils.TREE_LEVEL_CODE);
			}
		}else{
			form.setPccid(null);
			syscoding = this.codeDetailDefBL.getSyscodingLevel1(form.getCcid());
			if(syscoding == null){
				syscoding = getSyscoding(form.getCcid()+StringUtils.leftPad("0", CommonDefineUtils.TREE_LEVEL_CODE , "0"),CommonDefineUtils.TREE_LEVEL_CODE);
			}else{
				syscoding = getSyscoding(syscoding,CommonDefineUtils.TREE_LEVEL_CODE);
			}
		}
		form.setSyscoding(syscoding);
		form.setCdstatus("1");
		checkParCodeDetail(form.getPccid(),form.getPcid());
		String tempcid = this.codeDetailDefBL.getMaxcid(form.getCcid());
		if(tempcid==null){
			form.setCid(getCid(StringUtils.leftPad("0", CommonDefineUtils.CID_LENGTH , "0"), CommonDefineUtils.CID_LENGTH));
		}else{
			form.setCid(getCid(tempcid, CommonDefineUtils.CID_LENGTH));
		}
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		form.setUpdtime(datetime);
		this.codeDetailDefBL.registCodeDetailDef(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����") );

		log.debug("========������Ϣ�ǼǴ�������========");

		return dto;
	}
	/**
	 * ��ȡ��ǰ���ֵ��1���ַ��������㳤�Ȳ�0
	 * 
	 * @param cid ��ǰ����ַ���
	 * @param length ����
	 * @param flag �Ƿ�ƴ��Դ�ַ���
	 * @return
	 */
	private String getCid(String cid ,int length) throws BLException {
		Integer temp = new Integer(cid);
		if(temp == 9999){
			throw new BLException("IGSYM1101.E002","����");
		}
		return StringUtils.leftPad(temp + 1 + "", length , "0");
	}
	/**
	 * ��ȡ��ǰ���ֵ��1���ַ��������㳤�Ȳ�0
	 * 
	 * @param syscoding ��ǰ����ַ���
	 * @param length ����
	 * @return
	 */
	private String getSyscoding(String syscoding ,int length) throws BLException {
		String temp = syscoding.substring(syscoding.length()-length);
		if(temp.equals("999")){
			throw new BLException("IGSYM1101.E002","����");
		}
		return syscoding.substring(0, syscoding.length()-length)+StringUtils.leftPad(Integer.valueOf(temp)+1+"", length , "0");
	}
	/**
	 * ��ѯӦ����֯�ܹ��µ��ĸ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchCodeDetailDef(IGDRM10DTO dto) throws BLException {
		CodeDetailDefSearchCondImpl cond = new  CodeDetailDefSearchCondImpl();
		if(dto.getCodeCategoryDefInfo()!=null){
			cond.setCcid(dto.getCodeCategoryDefInfo().getCcid());
		}
		dto.setCodeDetailDefList(codeDetailDefBL.searchCodeDetailDef(cond));
		return dto;
	}
	
	/**
     * ��ɫ��֯�ܹ���ϵ��ʼ����ѯ
     * 
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDRM10DTO searchRoleAndUser(IGDRM10DTO dto) throws BLException{
    	log.debug("========��ѯӦ����֯�ܹ�ͼ��ʼ========");

		List<String> planUseridList = new ArrayList<String>();

		// �����Ҫ����Ԥ�����й�������Ҫ������ƶ�Ԥ��Ԥ����صĳ�������
		if (StringUtils.isNotEmpty(dto.getPlanEiid())) {
			String sql = " SELECT distinct userid from( "
					+ "SELECT civalue FROM soc0107 WHERE cid = 'CI600000001004'  AND eiid IN ( "
					+ "SELECT cldeiid FROM soc0119  WHERE pareiid = "+dto.getPlanEiid()+" AND eirrelation = '01')"
					+ " ) a LEFT JOIN ig222 b ON a.civalue = substr(b.PSDID,1,7)";
			Map<String, Type> resultFieldMap = new HashMap<String, Type>();
			resultFieldMap.put("userid", Hibernate.STRING);
			List<Map<String, Object>> resultList = customQueryBL.queryBySql(sql, resultFieldMap);


			for (Map<String, Object> map : resultList) {
				planUseridList.add(map.get("userid").toString());
			}
		}

    	StructureRoleSearchCondImpl condStructureRole = new StructureRoleSearchCondImpl();
		// condStructureRole.setSyscoding(syscoding);
    	//��ѯӦ����֯�ܹ�������һ���㼶�Ľ�ɫ����Ա������֯����
    	List<StructureRoleInfo>structureRoleList = structureRoleBL.searchStructureRole(condStructureRole);
    	//��֯�ܹ�Map key=��֯�ܹ��Ĳ����  value = ��صĽ�ɫ�ļ���
		// ��֯�ܹ���μ���
		LinkedHashMap<String, LinkedHashMap<String, Object>> orgArr = new LinkedHashMap<String, LinkedHashMap<String, Object>>();
		Map<String, List<UserTB>> userRoleMap = new HashMap<String, List<UserTB>>();
		// ������ѯ�����и�λ����֯�ܹ�����
    	if(structureRoleList!=null && structureRoleList.size()>0){
    		for(StructureRoleInfo info:structureRoleList){
				// ��֯�ܹ���Map
				LinkedHashMap<String, Object> orgMap = orgArr.get(info.getSyscoding());

				// �����ظ��û�set
				Set<String> userSet = new HashSet<String>();

				if (orgMap == null) {
					orgMap = new LinkedHashMap<String, Object>();
					orgMap.put("name", info.getSname());
					orgMap.put("userSet", userSet);
					orgArr.put(info.getSyscoding(), orgMap);
				}

				// ��λMap
				LinkedHashMap<String, Object> roleArr = (LinkedHashMap<String, Object>) orgMap.get("roleArr");
				if (roleArr == null) {
					roleArr = new LinkedHashMap<String, Object>();
					orgMap.put("roleArr", roleArr);
					
				}
				Map<String, Object> roleMap = new HashMap<String, Object>();
				roleArr.put(info.getRoleid().toString(), roleMap);
				roleMap.put("roleId", info.getRoleid().toString());
				roleMap.put("roleName", info.getRolename());

				List<UserInfo> tempList = userBL.searchUserByRoleId(info.getRoleid());
				List<UserTB> userList = new ArrayList<UserTB>();
				for (int i = 0; i < tempList.size(); i++) {
					UserTB t = (UserTB) tempList.get(i);
					if (StringUtils.isNotEmpty(dto.getPlanEiid()) && !planUseridList.contains(t.getUserid())) {
						continue;
					}
					userSet.add(t.getUserid());
					t.setOrgname(getFullOrgName(t.getOrganizationTB()));
					userList.add(t);
				}
    			userRoleMap.put(info.getRoleid().toString(), userList);
				roleMap.put("sumUser", userList.size());
				roleMap.put("userList", userList);
				// �ò��µ���Ա����
				userSet.addAll((Set<String>) orgMap.get("userSet"));
				orgMap.put("userSet", userSet);
    		}
    	}

		for (Iterator<String> it = orgArr.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			LinkedHashMap<String, Object> orgMap = orgArr.get(key);
			orgMap.put("sumUser", ((Set<String>) orgMap.get("userSet")).size());
		}

    	//������֯����
    	dto.setStructureRoleList(structureRoleList);
    	dto.setUserRoleMap(userRoleMap);

		dto.setOrgArr(orgArr);
    	log.debug("========��ѯӦ����֯�ܹ�ͼ����========");
        return dto;
    }

	/**
	 * ������֯�ܹ���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO exportOrgTree(IGDRM10DTO dto) throws BLException {

		log.debug("=============����Ӧ����֯�ܹ���ʼ===============");
		WritableWorkbook wwb;
		try {

			LinkedHashMap<String, LinkedHashMap<String, Object>> orgArr = dto.getOrgArr();
			wwb = Workbook.createWorkbook(dto.getOps());
			WritableSheet ws = wwb.createSheet("Ӧ����֯�ܹ�", 10); // ����һ��������

			// ���õ�Ԫ������ָ�ʽ
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
			WritableFont rootWf = new WritableFont(WritableFont.ARIAL, 18, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
			WritableCellFormat rootWcf = new WritableCellFormat(rootWf);
			rootWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			rootWcf.setAlignment(Alignment.CENTRE);
			rootWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			rootWcf.setLocked(false);
			// ������Ա��Ϣ�и�ʽ
			WritableCellFormat userWcf = new WritableCellFormat(wf);
			userWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			userWcf.setAlignment(Alignment.LEFT);
			userWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			userWcf.setLocked(false);

			// ��������ʽ
			WritableCellFormat titWcf = new WritableCellFormat(wf);
			titWcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			titWcf.setAlignment(Alignment.LEFT);
			titWcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			titWcf.setBackground(Colour.BLUE_GREY);

			int blankRow = 2, blankCol = 0;
			// ������еĿ��
			// ws.setColumnView(blankCol, 20);
			ws.setColumnView(blankCol + 1, 18);
			ws.setColumnView(blankCol + 2, 20);
			ws.setColumnView(blankCol + 3, 20);
			ws.setColumnView(blankCol + 4, 20);
			ws.setColumnView(blankCol + 5, 20);
			ws.setColumnView(blankCol + 6, 20);
			ws.setColumnView(blankCol + 7, 40);
			Label label = new Label(blankCol + 1, blankRow - 1, "Ӧ����֯�ܹ�", rootWcf);
			
			ws.addCell(label);
			
			ws.addCell(new Label(blankCol + 1, blankRow, "��֯�ܹ���", titWcf));
			ws.addCell(new Label(blankCol + 2, blankRow, "��λ", titWcf));
			ws.addCell(new Label(blankCol + 3, blankRow, "��Ա����", titWcf));
			ws.addCell(new Label(blankCol + 4, blankRow, "��������", titWcf));
			ws.addCell(new Label(blankCol + 5, blankRow, "�ֻ�", titWcf));
			ws.addCell(new Label(blankCol + 6, blankRow, "�绰", titWcf));
			ws.addCell(new Label(blankCol + 7, blankRow, "����", titWcf));

			int curRow = blankRow + 1;
			// ������
			for(Iterator<String> it = orgArr.keySet().iterator();it.hasNext();){
				int startOrgRow = curRow;
				LinkedHashMap<String, Object> orgMap = orgArr.get(it.next());


				ws.addCell(new Label(blankCol + 1, curRow, orgMap.get("name").toString(), userWcf));
				// ��ȡ���µĸ�λ�ļ���
				LinkedHashMap<String, Object> roleArr = (LinkedHashMap<String, Object>) orgMap.get("roleArr");
				// ������λ
				for (Iterator<String> roleIt = roleArr.keySet().iterator(); roleIt.hasNext();) {
					Map<String, Object> roleMap = (Map<String, Object>) roleArr.get(roleIt.next());
					ws.addCell(new Label(blankCol + 2, curRow, roleMap.get("roleName").toString(), userWcf));
					
					int startRoleRow = curRow;

					// ��ȡ��λ�µ���
					List<UserInfo> userList = (List<UserInfo>) roleMap.get("userList");
					if (userList.size() == 0) {
						ws.addCell(new Label(blankCol + 3, curRow, null, userWcf));
						// ����
						ws.addCell(new Label(blankCol + 4, curRow, null, userWcf));
						// �ֻ�
						ws.addCell(new Label(blankCol + 5, curRow, null, userWcf));
						// �绰
						ws.addCell(new Label(blankCol + 6, curRow, null, userWcf));
						// email
						ws.addCell(new Label(blankCol + 7, curRow, null, userWcf));
						curRow++;
					}
					for (int i = 0; i < userList.size(); i++) {
						UserTB user = (UserTB) userList.get(i);
						// ����
						ws.addCell(new Label(blankCol + 3, curRow, user.getUsername(), userWcf));
						// ����
						ws.addCell(new Label(blankCol + 4, curRow, getFullOrgName(user.getOrganizationTB()), userWcf));
						// �ֻ�
						ws.addCell(new Label(blankCol + 5, curRow, user.getUsermobile(), userWcf));
						// �绰
						ws.addCell(new Label(blankCol + 6, curRow, user.getUserphone(), userWcf));
						// email
						ws.addCell(new Label(blankCol + 7, curRow, user.getUseremail(), userWcf));
						curRow++;
					}
					ws.mergeCells(blankCol + 2, startRoleRow, blankCol + 2, curRow - 1);
				}
				ws.mergeCells(blankCol + 1, startOrgRow, blankCol + 1, curRow - 1);
			}
			ws.mergeCells(blankCol + 1, blankRow - 1, blankCol + 7, blankRow - 1);
			wwb.setProtected(false);
			wwb.write();
			wwb.close();

		} catch (IOException e) {
		} catch (RowsExceededException e) {
		} catch (WriteException e) {
		}
		log.debug("=============����Ӧ����֯�ܹ����===============");

		return dto;
	}

	/**
	 * �ݹ��ȡ����ȫ����
	 * 
	 * @param orgTB
	 * @return
	 */
	private String getFullOrgName(OrganizationTB orgTB) {
		if (orgTB.getOrganizationTB() != null && !orgTB.getOrgpar().equals("0001")) {
			String[] parNameArr = orgTB.getOrgparname().split("-");
			String[] orgNameArr = orgTB.getOrgname().split("-");
			return parNameArr[parNameArr.length > 0 ? parNameArr.length - 1 : 0] + "-" + orgNameArr[orgNameArr.length > 0 ? orgNameArr.length - 1 : 0];
		} else {
			return orgTB.getOrgname();
		}
	}

    /**
	 * ���ݷ�����Ϣ��ѯ����
	 *
	 * @param dto IGDRM10DTO
	 * @return IGDRM10DTO
	 */
	public IGDRM10DTO initIGDRM1007Action(IGDRM10DTO dto) throws BLException {
		log.debug("========���ݷ�����Ϣ��ѯ����ʼ========");
		//��ȡccidΪ230��Ӧ����֯�ܹ�
		String ccid = "230";
		//��ȡ����֯�ܹ�����Ϣ
		CodeCategoryDefInfo codeCategoryDefInfo = this.codeCategoryDefiBL.searchCodeCategoryDefByPK(ccid);
		dto.setCodeCategoryDefInfo(codeCategoryDefInfo);
		log.debug("========���ݷ�����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ʼ��������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initWorkFlowAction(IGDRM10DTO dto) throws BLException {
		log.debug("=============��ʼ��������Ϣ������ʼ==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1010Form){
			//����ȡ��
			IGDRM1010Form form = (IGDRM1010Form) dto.getForm();
			//��¼�û�ȡ��
			User user = dto.getUser();
			//�趨����ֵ
			Map<String, Object> map = new HashMap<String, Object>();
			//��ȡ����ʵ��ID
			Integer prid = form.getPrid();
			//��ȡ��ǰ�����û�
			String userid = form.getUserid();
			//��ȡ��ǰ����ڵ�
			String status = form.getStatus();
			//�����ɫ
			Integer roleid = null;
			if(prid != null && prid > 0){
				//��ѯ����ʵ����Ϣ
				IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
				map.put("prid", pr.getPrid());
				map.put("title", pr.getPrtitle());
				map.put("prpdid", pr.getPrpdid());
				map.put("prtype", pr.getPrtype());
				
				
				
				map.put("prCategory", pr.getPrurgency());
				this.getRelProcess(map, prid);
				Map<String, String> timeMap = new HashMap<String, String>();
				timeMap.put("starttime", pr.getPropentime());
				if ("C".equals(pr.getPrstatus())) {
					timeMap.put("endtime", pr.getPrclosetime());
				}
				if (timeMap.get("endtime") != null) {
					timeMap.put("usedtime", this.diffTime(pr.getPropentime(), pr.getPrclosetime(), "/"));
				} else {
					timeMap.put("usedtime", this.diffTime(pr.getPropentime(), DateUtils.getCurrentTime(), "/"));
				}
				map.put("prTime", timeMap);

				//��ʼ��״̬�������ڽڵ���Ϣ����ѯ��ǰ�ڵ�
				if(StringUtils.isEmpty(status)){
					List<String> statusList = workFlowOperationBL.searchCurrentStatus(prid);
					if(!statusList.isEmpty()){
						status = statusList.get(0);
					}
				}
				//��ѯ��ǰ�ڵ㴦����
				List<Map<String, String>> currentUsers = new ArrayList<Map<String,String>>();
				if(StringUtils.isNotEmpty(status)){
					List<IG337Info> participantList = workFlowOperationBL.searchProcessParticipant(prid, status);
					int size = participantList.size();
					if(size > 0){
						IG337Info current = null;
						for(int i=0;i<size;i++){
							Map<String, String> userinfo = new HashMap<String, String>();
							userinfo.put("value", participantList.get(i).getPpuserid());
							userinfo.put("label", participantList.get(i).getPpusername());
							currentUsers.add(userinfo);
							if(StringUtils.isNotEmpty(userid)){
								if(userid.equals(participantList.get(i).getPpuserid())){
									current = participantList.get(i);
								}
							}else{
								if(user.getUserid().equals(participantList.get(i).getPpuserid())){
									current = participantList.get(i);
								}
							}
						}
						if(current == null){
							current = participantList.get(0);
						}
						roleid = current.getPproleid();
						userid = current.getPpuserid();
					}
				}
				map.put("userid", userid);
				map.put("roleid", roleid);
				map.put("status", status);
				map.put("pid", getVariables(pr, roleid, userid, status,currentUsers));
				if(roleid != null && roleid > 0){
					map.put("buttons", workFlowDefinitionBL.searchVisibleButton(status, roleid));
				}

				// �����ָ�����̵�״̬�б�Ĳ�ѯ����
				if (IGDRMCONSTANTS.EME_DIRECT_PRTYPE.equals(pr.getPrtype())) {
					List<Map<String, Object>> directProcessStatusList = this.getDirectProcessStatusList(pr.getPrid());
					for (Map<String, Object> map2 : directProcessStatusList) {
						if (map2.get("people") == null || StringUtils.isEmpty(map2.get("people").toString())) {
							Map<String, String> userMap = this.getDirectProcessStatusInfo(map2.get("psdid").toString());
							map2.put("userids", userMap.get("userids"));
							map2.put("people", userMap.get("usernames"));
						}else{
							map2.put("people", replaceLast(map2.get("people").toString(), ","));
							map2.put("userids", replaceLast(map2.get("userids").toString(), ","));
						}
						if (map2.get("factStartTime") != null) {
							map2.put("factStartTime", map2.get("factStartTime").toString().substring(0, 19));
							if (map2.get("factEndTime") != null) {
								map2.put("factEndTime", map2.get("factEndTime").toString().substring(0, 19));
								map2.put("factUseTime", this.diffTime(map2.get("factStartTime").toString(), map2.get("factEndTime").toString(), "-"));
								map2.put("factEndTime", map2.get("factEndTime").toString().substring(10));
							}
							map2.put("factStartTime", map2.get("factStartTime").toString().substring(10));
						}
					}
					Map<String, Object> psdMap = new HashMap<String, Object>();
					psdMap.put("stepList", directProcessStatusList);
					map.put("psdList", psdMap);

				} else {
					map.put("psdList", IGDRMEmergencyTools.getFlow(pr.getPrid()));

				}

			}
			dto.setJsonResult(new Gson().toJson(map));
		}
		log.debug("=============��ʼ��������Ϣ��������==============");
		return dto;
	}

	private String replaceLast(String str, String pattern) {
		if (StringUtils.isNotEmpty(str)) {
			return str.substring(0, str.lastIndexOf(pattern));
		} else {
			return "";
		}
	}

	/**
	 * ��ѯ״̬�����еĴ�������Ϣ
	 * 
	 * @param psdid
	 * @return
	 * @throws BLException
	 */
	private Map<String, String> getDirectProcessStatusInfo(String psdid) throws BLException {

		StringBuffer sql = new StringBuffer();
		sql.append("SELECT c.psdid ,c.roleid,c.userid,f.username,userids,usernames FROM ig222 c LEFT join (");
		sql.append("SELECT roleid , VARCHAR(replace(replace(xml2clob(xmlagg(xmlelement(NAME a, userid||','))),'<A>',''),'</A>','')) AS userids, ");
		sql.append("VARCHAR(replace(replace(xml2clob(xmlagg(xmlelement(NAME a, username||','))),'<A>',''),'</A>','')) AS usernames from(	");
		sql.append("SELECT roleid,t2.userid,t2.username FROM userrole t1 LEFT JOIN iguser t2 ON t1.USERID = t2.userid) a GROUP BY a.roleid) b ON c.roleid = b.roleid LEFT JOIN iguser f ON c.USERID = f.userid WHERE c.psdid = '" + psdid + "'");

		Map<String, Type> fieldMap = new HashMap<String, Type>();
		fieldMap.put("psdid", Hibernate.STRING);
		fieldMap.put("roleid", Hibernate.STRING);
		fieldMap.put("userid", Hibernate.STRING);
		fieldMap.put("username", Hibernate.STRING);
		fieldMap.put("userids", Hibernate.STRING);
		fieldMap.put("usernames", Hibernate.STRING);
		List<Map<String, Object>> statusInfo = customQueryBL.queryBySql(sql.toString(), fieldMap);

		// ��������setװ����Ա��Ϣ�����ǹ����ظ�����
		Set<String> useridSet = new HashSet<String>();
		Set<String> usernameSet = new HashSet<String>();
		for (Map<String, Object> map : statusInfo) {
			if (map.get("userid") != null && StringUtils.isNotEmpty(map.get("userid").toString())) {
				useridSet.add(map.get("userid").toString());
				usernameSet.add(map.get("username").toString());

			}else if(map.get("userids")!=null){
				useridSet.addAll(Arrays.asList(map.get("userids").toString().split(",")));
				usernameSet.addAll(Arrays.asList(map.get("usernames").toString().split(",")));
			}
		}

		Map<String, String> result = new HashMap<String, String>();
		result.put("userids", StringUtils.join(useridSet.toArray(), ","));
		result.put("usernames", StringUtils.join(usernameSet.toArray(), ","));
		return result;
	}
	/**
	 * ��ѯӦ��ָ�����̽ڵ���Ϣ
	 * 
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	private List<Map<String, Object>> getDirectProcessStatusList(Integer prid) throws BLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT psdid,psdname,min(factstarttime) AS factstarttime ,max(factendtime) AS factendtime, ");
		sql.append("VARCHAR(replace(replace(replace(xml2clob(xmlagg(xmlelement(NAME a, userids||','))),'<A>',''),'</A>',''),'<A/>','')) AS userids, ");
		sql.append("VARCHAR(replace(replace(replace(xml2clob(xmlagg(xmlelement(NAME a, people||','))),'<A>',''),'</A>',''),'<A/>','')) AS people FROM ( ");
		sql.append("SELECT a.psdid,a.psdname, psdcode,rslopentime as factStartTime , rslclosetime as factEndTime,ppuserid as userids,ppusername as people ");
		sql.append("FROM ig333 a LEFT JOIN  ");
		sql.append("(SELECT PPUSERID, PPUSERNAME ,psdid,PPINITTIME , PPPROCTIME,prid  FROM ig337 t  WHERE t.PPPROCTIME IS NOT null AND  prid = " + prid + ")b ON a.psdid = b.psdid  ");
		sql.append("LEFT JOIN ig224 c ON( c.PSDID = a.psdid AND c.PRID = " + prid + ")  ");
		sql.append("WHERE a.pdid = '" + IGDRMCONSTANTS.EMER_PROCESS_PDID + "' ORDER BY rslopentime ASC , rslclosetime ASC , a.PSDCODE DESC ");
		sql.append(") GROUP BY psdid,psdname,psdcode ORDER BY factstarttime ASC , factendtime ASC , PSDCODE DESC");

		Map<String, Type> fieldMap = new HashMap<String, Type>();
		fieldMap.put("psdid", Hibernate.STRING);
		fieldMap.put("psdname", Hibernate.STRING);
		fieldMap.put("factStartTime", Hibernate.STRING);
		fieldMap.put("factEndTime", Hibernate.STRING);
		fieldMap.put("userids", Hibernate.STRING);
		fieldMap.put("people", Hibernate.STRING);

		return this.customQueryBL.queryBySql(sql.toString(), fieldMap);
	}

	/**
	 * ��ѯ�������(�����ָ�����id)
	 * 
	 * @param resultMap
	 * @param prid
	 * @return
	 * @throws BLException
	 */
	private Map<String, Object> getRelProcess(Map<String, Object> resultMap, Integer prid) throws BLException {
		log.debug("==========��ʼ��ѯ���������ָ�����id============");

		EmergencyRelationSearchCondImpl cond = new EmergencyRelationSearchCondImpl();

		cond.setParprid(prid);

		cond.setRelatetype(IGDRMCONSTANTS.DIRECT_RELATE_SCENE);

		List<EmergencyRelationInfo> relArr = emergencyRelationBL.searchEmergencyRelationInfo(cond, 0, 0);

		if (CollectionUtils.isNotEmpty(relArr)) {
			resultMap.put("cldPrid", relArr.get(0).getCldprid() + "");
			IG500Info cldPr = workFlowOperationBL.searchProcessRecordByKey(relArr.get(0).getCldprid());
			resultMap.put("cldPrStatus", cldPr.getPrstatus());
		}
		
		log.debug("==========��ɲ�ѯ���������ָ�����id============");
		return resultMap;
	}
	
	
	
	/**
	 * ����ʱ���
	 * 
	 * @param argTime1
	 *            ����
	 * @param argTime2
	 *            ������
	 * @return
	 */
	private String diffTime(String argTime1, String argTime2, String splitStr) {
		String resultTime = "00:00:00";
		if(StringUtils.isNotEmpty(argTime1)&&StringUtils.isNotEmpty(argTime2)){
			String pattern = "yyyy" + splitStr + "MM" + splitStr + "dd HH:mm";
			if (argTime1.length() > 16) {
				pattern += ":ss";
			}
			DateFormat df = new SimpleDateFormat(pattern);
			try{
				 
				Date d1 = df.parse(argTime1);
				Date d2 = df.parse(argTime2);
				long diff = d2.getTime() - d1.getTime();// �����õ��Ĳ�ֵ��΢�뼶��
				long days = diff / (1000 * 60 * 60 * 24);
				long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
				long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
				long second = ((diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) % (1000 * 60)) / 1000;
				resultTime = (days > 0 ? days + "�� " : "") + (hours > 9 ? hours : "0" + hours) + ":" + (minutes > 9 ? minutes : "0" + minutes) + ":" + (second > 9 ? second : "0" + second);

			} catch (Exception e) {
				log.debug("����ʱ������!");

				log.debug(e.getMessage());
			}
			
		}
		
		return resultTime;
	}

	/**
	 * װ�ر�ֵ
	 * 
	 * @param pr
	 * @param roleid
	 * @param userid
	 * @param status
	 * @param currentUsers
	 * @return
	 * @throws BLException
	 */
	private List<Map<String, Object>> getVariables(IG500Info pr,Integer roleid,String userid,String status, List<Map<String, String>> currentUsers) throws BLException{
		//��ѯ����Ϣ
		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDefsByPdid(pr.getPrpdid());
		//��ѯ��ֵ
		List<IG599Info> pivList = workFlowOperationBL.getProcessInfo(pr.getPrid());
		//��ѯ״̬��ֵ
        Map<String, IG561Info> statusPivMap = workFlowOperationBL.searchStatusValue(pr.getPrpdid(), status,String.valueOf(pr.getPrid()));
		List<IG506Info> list = workFlowOperationBL.searchIG506InfoByprid(pr.getPrid());
		Map<String, IG506Info> participantFormValueMap = new LinkedHashMap<String, IG506Info>();
		if(list != null){
			for(IG506Info pv:list){
				String key = pv.getPiuid() + "";
				participantFormValueMap.put(key, pv);
			}
		}
		//��ѯ��Ȩ��
		List<IG893Info> participantVariableVW = null;
		if (roleid == null) {
			participantVariableVW = getNotCurrentFormAccessPower(userid, status, pr);
		} else {
			participantVariableVW = this.workFlowOperationBL.searchParticipantVariableVW(status, roleid);
		}
		List<Map<String, Object>> pidinfo = new ArrayList<Map<String,Object>>();
		//��Ӵ���ʱ���
		Map<String, Object> rltime = new HashMap<String, Object>();
		rltime.put("id", "rltime");
		rltime.put("name", "����ʱ��");
		rltime.put("type", "A");
		if(roleid != null && roleid > 0){
			rltime.put("access", "3");
		}else{
			rltime.put("access", "2");
		}
		rltime.put("rowwidth", "1");
		rltime.put("required", "0");
		pidinfo.add(rltime);
		
		//��Ӵ�����ѡ��
		Map<String, Object> users = new HashMap<String, Object>();
		users.put("id", "users");
		users.put("name", "������");
		users.put("type", "2");
		users.put("access", "3");
		users.put("rowwidth", "1");
		users.put("required", "0");
		users.put("options", currentUsers);
		users.put("value", userid);
		pidinfo.add(users);
		if(participantVariableVW != null && participantVariableVW.size() > 0){
			Map<String, IG893Info> pvMap = new HashMap<String, IG893Info>();
			for(int i=0;i<participantVariableVW.size();i++){
				pvMap.put(participantVariableVW.get(i).getPidid(), participantVariableVW.get(i));
			}
			Map<String, IG599Info> pivMap = new HashMap<String, IG599Info>();
			for(int i=0;i<pivList.size();i++){
				pivMap.put(pivList.get(i).getPidid(), pivList.get(i));
			}
			for(int i=0;i<pidList.size();i++){
				IG007Info pid = pidList.get(i);
				IG893Info pv = pvMap.get(pid.getPidid());
				if(pv != null && StringUtils.isNotEmpty(pv.getPidaccess())){
					if(pv.getPidaccess().compareTo(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE) > 0){
						Map<String, Object> pi = new HashMap<String, Object>();
						pi.put("id", pid.getPidid());
						pi.put("name", pid.getPidname());
						pi.put("type", pid.getPidtype());
						pi.put("access", pv.getPidaccess());
						pi.put("rowwidth", pid.getRowwidth());
						pi.put("required", pv.getPidrequired());
						pi.put("rows", pid.getPidrows());
						pi.put("code", "");
						if(StringUtils.isNotEmpty(pid.getCcid())){
							pi.put("code", pid.getCcid().split("_")[0]);
						}
						if(StringUtils.isNotEmpty(pid.getPidoption())){
							List<Map<String, String>> options = new ArrayList<Map<String,String>>();
							for(String s:pid.getPidoption().split("#")){
								Map<String, String> option = new HashMap<String, String>();
								option.put("label", s);
								option.put("value", s);
								options.add(option);
							}
							pi.put("options", options);
						}
						//���ñ�ֵ
						setVariableValue(pr,pi,pid,pivMap,statusPivMap,participantFormValueMap,pidList);
						pidinfo.add(pi);
					}
				}
			}
		}
		
		return pidinfo;
	}

	/**
	 * ������ֱ�ֵ
	 * @param pr 
	 * @@param pi
	 * @param pid
	 * @param pivMap
	 * @param statusPivMap
	 * @param participantFormValueMap
	 * @param pidList 
	 * @return
	 * @throws BLException
	 */
	private void setVariableValue(IG500Info pr, Map<String, Object> pi,IG007Info pid, Map<String, IG599Info> pivMap, 
			Map<String, IG561Info> statusPivMap, Map<String, IG506Info> participantFormValueMap, 
			List<IG007Info> pidList) throws BLException {
		Object value = null;
		//��ȡ״̬��ֵ
		IG561Info sv = statusPivMap.get(pid.getPidid());
		//����ʵ��ID
		Integer prid = pr.getPrid();
		//��ʵ��ID
		Integer piid = null;
		//����key
		String attkey = null;
		//��ȡ��ֵ
		IG599Info piv = pivMap.get(pid.getPidid());
		//����״̬��
		if(sv != null){
			value = sv.getPivarvalue();
			piid = sv.getPiid();
			attkey = sv.getPiattkey();
		}else if(piv != null){
			value = piv.getPivarvalue();
			piid = piv.getPiid();
			attkey = piv.getPiattkey();
		}
		//������ֱ�����
		if("P".equals(pid.getPidtype())){
			value = getParticipantVariableValue(value.toString(),participantFormValueMap);
		} else if ("4".equals(pid.getPidtype()) || "W".equals(pid.getPidtype())) {
			if(value != null && !"".equals(value)){
				Object tempVal = getAssetVariableValue(prid, piid);
				if (tempVal == null) {
					String[] valArr = value.toString().split("#");
					List<Map<String, Object>> valList = new ArrayList<Map<String, Object>>();
					for (String string : valArr) {
						Map<String, Object> map = new HashMap<String, Object>();
						if ("N/A".equals(string)) {

						} else {
							String[] entityInfoArr = string.split("_");
							SOC0118VWInfo info = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(entityInfoArr[0]), Integer.parseInt(entityInfoArr[1])));
							map.put("eiid", info.getEiid());
							map.put("einame", info.getEiname());
							map.put("eiversion", entityInfoArr[0]);
							map.put("dataStr", string);
							valList.add(map);
						}
					}
					pi.put("value", valList);
					return;
				} else {
					value = tempVal;
				}
			}
		}else if("8".equals(pid.getPidtype())){
			value = getTableFormValues(prid,pid,pidList);
		}
		//����������
		if(StringUtils.isNotEmpty(attkey)){
			List<Attachment> attList = workFlowOperationBL.searchProcessInofAtt(attkey);
			if(!attList.isEmpty()){
				pi.put("atts", attList);
			}
		}
		if(value != null){
			pi.put("value", value);
		}
	}

	private Object getTableFormValues(Integer prid, IG007Info pid, List<IG007Info> pidList) throws BLException {
		Map<String, Map<String, Map<String, String>>> map = new LinkedHashMap<String, Map<String,Map<String,String>>>();
		//��ѯ�������µı��ʽ����ֵ
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(prid);
		List<IG898Info> tableColumnValueList = workFlowOperationBL.searchTableFormValue(cond);
		if(tableColumnValueList.isEmpty()){
			Map<String, Map<String, String>> temp = new LinkedHashMap<String, Map<String,String>>();
			for(IG007Info info:pidList){
				if(pid.getPidid().equals(info.getPpidid())){
					Map<String, String> value = new HashMap<String, String>();
					value.put("pidid", info.getPidid());
					value.put("value", "");
					temp.put(info.getPidname(), value);
				}
			}
			map.put("1", temp);
		}else{
			for(IG898Info info:tableColumnValueList){
				if(map.get(info.getPvrownumber()) == null){
					map.put(info.getPvrownumber(), new LinkedHashMap<String, Map<String,String>>());
				}
				Map<String, String> value = new HashMap<String, String>();
				value.put("pidid", info.getPvcolpidid());
				value.put("value", info.getPvalue());
				map.get(info.getPvrownumber()).put(info.getPvcolname(), value);
			}
		}
		return map;
	}

	/**
	 * �����ʲ���ֵ
	 * @param prid
	 * @param piid
	 * @return
	 * @throws BLException 
	 */
	private Object getAssetVariableValue(Integer prid, Integer piid) throws BLException {
		if(prid != null && prid > 0 && piid != null && piid > 0){
			//��ѯ���̵�����ʲ�
			IG731SearchCondImpl cond731 = new IG731SearchCondImpl();
			cond731.setPrid(prid);
			cond731.setPiid(piid);
			List<IG731Info> lst_IG731 = workFlowOperationBL.searchProcessInfoEntityByCond(cond731);
			if(!lst_IG731.isEmpty()){
				List<Object> vs = new ArrayList<Object>();
				for(IG731Info pei:lst_IG731){
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("rid", pei.getPieid());
					map.put("eiid", pei.getEiid());
					if("1".equals(pei.getFingerPrint())){
						SOC0118VWPK pk = new SOC0118VWPK();
						pk.setId(Integer.parseInt(pei.getFingerPrint()));
						pk.setEiid(pei.getEiid());
						SOC0118VWInfo entity = soc0118VWBL.searchEntityItemByKey(pk);
						if(entity != null){
							map.put("einame", entity.getEiname());
						}
					}else{
						if(pei.getEntityItemVWTB() != null){
							map.put("einame", pei.getEntityItemVWTB().getEiname());
						}
					}
					map.put("eiversion", pei.getEiversion());
					vs.add(map);
				}
				return vs;
			}
		}
		return null;
	}

	/**
	 * ������Ա��ֵ
	 * @param value
	 * @param participantFormValueMap
	 * @return
	 */
	private Object getParticipantVariableValue(String value, Map<String, IG506Info> participantFormValueMap) {
		//��Ա��ֵ
		if(StringUtils.isNotEmpty(value)){
			List<IG506Info> vs = new ArrayList<IG506Info>();
			for(String s:value.split(",")){
				IG506Info v = participantFormValueMap.get(s);
				if(v != null){
					vs.add(v);
				}
			}
			return vs;
		}
		return null;
	}

	/**
	 * ��ȡ�ǵ�ǰ�ڵ�����˵ı��ɼ�Ȩ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private List<IG893Info> getNotCurrentFormAccessPower(String userid,String status,IG500Info pr) throws BLException{
		//ȡ�õ�ǰ�û������н�ɫ
		UserRoleSearchCondImpl condRole = new UserRoleSearchCondImpl();
		condRole.setUserid(userid);
		List<UserRole> roleList = userRoleBL.searchUserRole(condRole);
		//��ǰ�û�������Ľڵ�
		List<IG337Info> ppList = new ArrayList<IG337Info>();
		//��ǰ�����Ѿ����й��Ľڵ�
		//ȡ�����̵�ǰ�Ѿ����й���״̬���� 
		IG337SearchCondImpl condPP = new IG337SearchCondImpl();
		condPP.setPrid(pr.getPrid());
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
		
		List<IG893Info> participantVariable = new ArrayList<IG893Info>();
		
		//��ѯ��ǰ���̵�����״̬����
		IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
		psdcond.setPdid(pr.getPrpdid());
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
		if (psdList != null && ppList.size() > 0) {
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
			List<IG893Info> participantVariableVWList = workFlowOperationBL.searchParticipantMaxVariableVW(status, null, ls_proStatusParticipantMap);
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
		}
		return participantVariable;
	}
	
	/**
	 * ���̴������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO doFlowAction(IGDRM10DTO dto) throws BLException {
		log.debug("=================���̴��������ʼ=================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1010Form){
			//����ȡ��
			IGDRM1010Form form = (IGDRM1010Form) dto.getForm();
			//��ȡ����ʵ��
			IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
			//��ȡ������ID
			User user = userBL.searchUserByKey(form.getUserid());
			//��ȡ�����ɫID
			Integer roleid = form.getRoleid();
			//��ȡ����ڵ�
			String status = form.getStatus();
			//��ȡ��ֵ��Ϣ
			String result = form.getResult();
			//��ȡ������
			String btnid = form.getBtnid();
			//��ѯ����ʵ����Ϣ
			if(pr != null && user != null && StringUtils.isNotEmpty(status) && StringUtils.isNotEmpty(btnid) && roleid != null && roleid > 0){
				//��ȡ��ǰʱ��
				String datetime = updateVariables(result,pr,status,user);
				if(StringUtils.isEmpty(datetime)){
					datetime = IGStringUtils.getCurrentDateTime();
				}
				//��ȡ��ǰ������
				IG337SearchCondImpl cond = new IG337SearchCondImpl();
				cond.setPrid(form.getPrid());
				if (status.indexOf("_") > -1) {
					cond.setPsdid(status.split("_")[0]);
					cond.setPsdnum(Integer.parseInt(status.split("_")[1]));
				} else {
					cond.setPsdid(status);
				}
				cond.setPpproctimeIsNull("Y");
				cond.setPproleid(roleid);
				cond.setPpuserid(user.getUserid());
				List<IG599Info> processInfo = workFlowOperationBL.getProcessInfo(form.getPrid());
				if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(btnid)){
					IG036Info recordLog = workFlowOperationBL.addRecordLog(form.getPrid(), dto.getUser(), roleid, form.getRlcomment(),
							null, null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL, IGPRDCONSTANTS.BUTTON_UPDATE, status);
					workFlowOperationBL.addRecordLogVarInfo(processInfo, recordLog);
					
					WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
				    bean.setPbdid(btnid);//��ťID
				    bean.setBfstatus(status);//״̬ID
				    //��־������Ϣ
				    WorkFlowLog logInfo = new WorkFlowLog();
				    logInfo.setPrid(pr.getPrid());
				    logInfo.setExecutorid(user.getUserid());
				    logInfo.setExecutorRoleid(roleid);
				    bean.setLogInfo(logInfo);
				    this.workFlowOperationBL.processStatusButtonTreatmentExecute(bean);
				}
				List<IG337Info> ppList = this.workFlowOperationBL.searchProcessParticipants(cond);
				if(!ppList.isEmpty()){
					IG337TB tb = (IG337TB) ppList.get(0);
					//��ѯ״̬��Ϣ
					IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(tb.getPsdid());
					//����ԾǨ����
					if(IGPRDCONSTANTS.BUTTON_SUBMIT.compareTo(btnid) <= 0){
						//���²����˴���ʱ��
						tb.setPpproctime(datetime);
						workFlowOperationBL.updateProcessParticipant(tb, user, roleid, form.getRlcomment(), 
								psd.getPsdname(), 
								null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL,processInfo,null, btnid, status);
						//��������ԾǨ
						workFlowOperationBL.doFlow(pr.getPrid(), user, roleid, datetime, null, status, btnid, null, 
								IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL, null, null, null);
					}else{
						workFlowOperationBL.addRecordLog(pr.getPrid(), user, roleid, form.getRlcomment(),
								psd.getPsdname(), null,IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL, btnid,status);
					}
				}
			}
		}
		log.debug("=================���̴����������=================");
		return dto;
	}

	private String updateVariables(String result, IG500Info pr,String status,User user) throws BLException {
		String rltime = null;
		if(StringUtils.isNotEmpty(result)){
			Gson gson = new Gson();
			//��ѯ��ֵ
			List<IG599Info> list = workFlowOperationBL.getProcessInfo(pr.getPrid());
			Map<String, IG599Info> piMap = new HashMap<String, IG599Info>();
			for(IG599Info pi:list){
				piMap.put(pi.getPidid(), pi);
			}
			Map<String, Object> map = gson.fromJson(result, new TypeToken<HashMap<String, Object>>(){}.getType());
			Map<String, Map<String, Object>> forms = (Map<String, Map<String, Object>>) map.get("forms");
			if(forms != null){
				//����Ϣ����
				List<IG599Info> processInfoList = new ArrayList<IG599Info>();
				//��������ʲ���Ϣ
				Map<String, String> entitySaveMap = new HashMap<String, String>();
				for(Iterator<Entry<String, Map<String, Object>>> iter = forms.entrySet().iterator();iter.hasNext();){
					Entry<String, Map<String, Object>> entry = iter.next();
					String key = entry.getKey();
					Object value = entry.getValue().get("value");
					if("rltime".equals(key)){
						rltime = (String) value;
					}
					IG599TB tb = (IG599TB) piMap.get(key);
					if(tb != null){
						if("4".equals(tb.getPivartype()) || "W".equals(tb.getPivartype())){
							if(value != null){
								tb.setPivarvalue("N/A");
								//��ѯԭ�й�ϵ
								IG731SearchCondImpl cond = new IG731SearchCondImpl();
								cond.setPrid(pr.getPrid());
								cond.setPiid(tb.getPiid());
								List<IG731Info> pieList = workFlowOperationBL.searchProcessInfoEntityByCond(cond);
								Map<String, IG731Info> pieMap = new HashMap<String, IG731Info>();
								for(IG731Info info:pieList){
									pieMap.put(info.getEiid() + "", info);
								}
								for(String s:value.toString().split("_sp_")){
									if(StringUtils.isNotEmpty(s)){
										String[] split = s.split("#");
										String eiid = split[1];
										String version = split[2];
										if(pieMap.get(eiid) == null){
											IG731TB pieTB = new IG731TB();
											pieTB.setEiversion(Integer.parseInt(version));
											//update 2016��7��22��09:04:19 jinna ѡ���ʲ���ʱ��������Զ�̿⣬ԭeiid ��λ�õ�ֵ��ʽ Ϊ ����ʶ_eiid 
											Integer eiidint = null;
											if(StringUtils.isNotBlank(eiid) && eiid.split("_").length > 1){
												String[] eds = eiid.split("_");
												eiidint = Integer.parseInt(eds[1]);
												pieTB.setFingerPrint(eds[0]);
											}else{
												eiidint = Integer.parseInt(eiid);
											}
											pieTB.setEiid(eiidint);
											pieTB.setPiid(tb.getPiid());
											pieTB.setPrid(tb.getPrid());
											IG731Info info = workFlowOperationBL.saveProcessInfoEntity(pieTB);
											entitySaveMap.put(info.getPiid().toString(),info.getPieid().toString());
										}else{
											pieMap.remove(eiid);
										}
									}
								}
								for(Iterator<Entry<String, IG731Info>> pieiter = pieMap.entrySet().iterator();pieiter.hasNext();){
									Entry<String, IG731Info> next = pieiter.next();
									IG731Info pie = next.getValue();
									workFlowOperationBL.deleteProcessInfoEntityById(pie.getPieid());
								}
							}else{
								tb.setPivarvalue("");


							}
						} else if ("F".equals(tb.getPivartype())) {
							String attKey = tb.getPivarvalue();
							if (StringUtils.isNotEmpty(attKey)) {
								tb.setPivarvalue("N/A");
								tb.setPiattkey(attKey);
							}
						}else if("8".equals(tb.getPivartype())){
							tb.setPivarvalue("tab");
							List<Map<String, String>> tableValueList = (List<Map<String, String>>) value;
							if(tableValueList != null && !tableValueList.isEmpty()){
								int size = tableValueList.size();
								String[] column_value = new String[size];
								String[] column_pidid = new String[size];
								String[] column_rownum = new String[size];
								for(int i=0;i<size;i++){
									Map<String, String> column_value_map = tableValueList.get(i);
									column_value[i] = column_value_map.get("value");
									column_pidid[i] = column_value_map.get("pidid");
									column_rownum[i] = column_value_map.get("rownum");
								}
								workFlowOperationBL.saveTableFormValue(pr, column_value, column_pidid, column_rownum, new HashMap<Integer, FormFile>(), null, null);
							}
						}else{
							tb.setPivarvalue(value.toString());
						}
						IG599TB info = (IG599TB) workFlowOperationBL.saveProcessInfo(tb);
						info.setPidaccess("3");
						processInfoList.add(info);
					}
				}
				//����״̬����
				workFlowOperationBL.registIG561Info(processInfoList,status, user.getUserid(),entitySaveMap);
			}
		}
		return rltime;
	}
	
	/**
	 * ��ʼ������̨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO initWorkbenchAction(IGDRM10DTO dto) throws BLException {
		log.debug("================��ʼ������̨������ʼ==================");
		if(dto.getForm() != null && dto.getForm() instanceof IGDRM1010Form){
			//����ȡ��
			IGDRM1010Form form = (IGDRM1010Form) dto.getForm();
			Gson g = new Gson();
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
			if(process != null){
				Map<String, String> map = new LinkedHashMap<String, String>();

				Map<String, Object> resultMap = new HashMap<String, Object>();

				if (process.getPrpdid().startsWith(IGDRMCONSTANTS.DIRECT_PROCESS_DEF_ID)) {
					map.put(process.getPrid() + "", "Ӧ��ָ�ӹ���̨");
					EmergencyRelationSearchCondImpl emeCond = new EmergencyRelationSearchCondImpl();
					emeCond.setParprid(form.getPrid());

					List<EmergencyRelationInfo> emeRelList = emergencyRelationBL.searchEmergencyRelationInfo(emeCond, 0, 0);
					if (!emeRelList.isEmpty()) {
						map.put(emeRelList.get(0).getCldprid() + "", "Ӧ�����ù���̨");
						resultMap.put("recoverStatusArr", g.toJson(IGDRMEmergencyTools.getFlow(emeRelList.get(0).getCldprid())));
					}
				}else{
					map.put(process.getPrid() + "", "Ӧ�����ù���̨");
				}
				dto.setJsonResult(g.toJson(resultMap));
				dto.setWorkbenchMap(map);
			}
		}
		log.debug("================��ʼ������̨��������==================");
		return dto;
	}

	/**
	 * ���Ͷ���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO sendSMS(IGDRM10DTO dto) throws BLException {
		log.debug("=========����̨���Ͷ��ſ�ʼ===========");

		IGDRM1010Form form = (IGDRM1010Form) dto.getForm();

		String[] useridArr = form.getUserids().split(",");

		String msg = form.getMsg();

		for (String userid : useridArr) {
			sendMessageBL.sendSmsToUser(userid, msg);
		}

		log.debug("=========����̨���Ͷ������===========");

		dto.setJsonResult("{msg:'success'}");
		return dto;
	}

	/**
	 * ��ѯ����̨��־
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */

	public IGDRM10DTO searchLog(IGDRM10DTO dto) throws BLException {

		log.debug("===============����̨��ѯ��־��ʼ=================");

		IGDRM1010Form form = (IGDRM1010Form) dto.getForm();

		EmergencyLogSearchCondImpl cond = new EmergencyLogSearchCondImpl();

		cond.setElprid_eq(form.getPrid() + "");

		List<EmergencyLogInfo> emergencyLogList = emergencyLogBL.searchEmergencyLogByCond(cond);

		List<EmergencyLogInfo> newArray = new ArrayList<EmergencyLogInfo>();

		for (EmergencyLogInfo emergencyLogInfo : emergencyLogList) {
			if (!emergencyLogInfo.getEluserid().equals("sys")) {
				newArray.add(emergencyLogInfo);
			}
		}

		dto.setJsonResult("{\"msg\":\"success\",\"data\":" + new Gson().toJson(newArray) + "}");

		log.debug("===============����̨��ѯ��־���=================");

		return dto;

	}

	/**
	 * ����֪ͨ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO sendNotice(IGDRM10DTO dto) throws BLException {

		log.debug("==============����̨����֪ͨ��ʼ===============");

		IGDRM1010Form form = (IGDRM1010Form) dto.getForm();
		
		Integer pushPrid = form.getPrid();

		String noticeContnt = form.getMsg();
		
		String noticeTime = DateUtils.getCurrentTime();

		try {
			Gson gson = new Gson();
			// JSON������ϢMap����
			HashMap<String, Object> dataMap = new HashMap<String, Object>();
			List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
			Map<String, String> map = new HashMap<String, String>();
			map.put("mstime", noticeTime);
			map.put("mscontent", noticeContnt.replaceAll("\r\n", " ").replaceAll("\n", " ").trim());
			listMap.add(map);
			dataMap.put("mscontentList", listMap);
			dataMap.put("type", "3");
			messagePushBL.pushMessage(pushPrid + "", gson.toJson(dataMap));
		} catch (Exception e) {
			log.error(e);
			log.error("δ����mina���ͣ�");
			// δ����mina
			throw new BLException("IGDRM0602.E001", "");
		}
		// ��ʹ�����쳣Ҳ��¼������־
		EmergencyLogTB elTB = new EmergencyLogTB();
		elTB.setEllidtime(noticeTime);
		elTB.setElliinfo(noticeContnt);
		elTB.setEllitype("2");
		elTB.setElprid(pushPrid);
		elTB.setEluserid(form.getSendUserid());
		elTB.setElusername(form.getSendUserName());
		emergencyLogBL.registEmergencyLog(elTB);

		log.debug("==============����̨����֪ͨ���===============");
		return dto;
	}

	/**
	 * �����ϴ�
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO uploadAtt(IGDRM10DTO dto) throws BLException {
		log.debug("=============����̨�����ϴ���ʼ=======");

		IGDRM1010Form form = (IGDRM1010Form) dto.getForm();

		FormFile attFile = form.getFile();

		Map<String, String> resultMap = new HashMap<String, String>();
		if (attFile != null) {

			Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();

			filemap.put(0, attFile);

			String fileName = attFile.getFileName();

			String attKey = fileUploadBL.uploadFile(filemap);


			resultMap.put("msg", "success");

			resultMap.put("attKey", attKey);

			resultMap.put("fileName", fileName);

		} else {
			resultMap.put("msg", "faild");

			resultMap.put("err", "��������Ϊ��");
		}

		dto.setJsonResult(new Gson().toJson(resultMap));

		log.debug("=============����̨�����ϴ����=======");

		return dto;
	}

	/**
	 * ��ѯ�����е�Ԥ�ƻָ�ʱ��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchSenceTimes(IGDRM10DTO dto) throws BLException {
		log.debug("==========����̨��ѯ����Ԥ�ƻָ�ʱ����ʼ==========");

		IGDRM1010Form form = (IGDRM1010Form) dto.getForm();

		String sql = "select civalue from soc0107 where eiid = " + form.getSenceEiid() + " AND cid = 'CI600000001003'  and civersion = '" + form.getSenceEiversion() + "'";
		Map<String, Type> resultField = new HashMap<String, Type>();
		resultField.put("civalue", Hibernate.STRING);
		List<Map<String, Object>> result = customQueryBL.queryBySql(sql, resultField);
		if (CollectionUtils.isNotEmpty(result)) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("times", result.get(0).get("civalue").toString());
			dto.setJsonResult(new Gson().toJson(map));
		}

		log.debug("==========����̨��ѯ����Ԥ�ƻָ�ʱ�����==========");
		return dto;
	}

	/**
	 * ��������״̬��ѯ����˵����ֵ
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO searchDesc(IGDRM10DTO dto) throws BLException {
		log.info("==========����̨��ѯ��������˵����ʼ==========");

		IGDRM1010Form form = (IGDRM1010Form) dto.getForm();
		log.debug("----------prid:" + form.getPrid() + "--------------");
		log.debug("----------psdid:" + form.getPsdid() + "--------------");
		String sql = "select pvlid,pivarvalue from ig561 where prid = " + form.getPrid() + " and psdid = '" + form.getPsdid() + "'  and pivarname = '����˵��'";
		Map<String, Type> resultField = new HashMap<String, Type>();
		resultField.put("pivarvalue", Hibernate.STRING);
		resultField.put("pvlid", Hibernate.STRING);
		List<Map<String, Object>> resultList = this.customQueryBL.queryBySql(sql, resultField);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "SUCCESS");
		if (result != null && result.size() > 0) {
			result.put("desc", resultList.get(0).get("pivarvalue").toString());
			result.put("pvlid", resultList.get(0).get("pvlid").toString());
		} else {
			result.put("desc", "");
		}
		dto.setJsonResult(new Gson().toJson(result));
		log.info("==========����̨��ѯ��������˵�����==========");
		return dto;
	}

	/**
	 * ����״̬��(����˵��)
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM10DTO saveDesc(IGDRM10DTO dto) throws BLException {
		log.info("==========����̨���泡������˵����ʼ==========");
		IGDRM1010Form form = (IGDRM1010Form) dto.getForm();
		IG561TB ig561Tb = (IG561TB) ig561BL.searchIG561ByPK(form.getPvlid());

		ig561Tb.setPivarvalue(form.getPsdValue());

		ig561BL.updateIG561(ig561Tb);

		EmergencyLogSearchCondImpl cond = new EmergencyLogSearchCondImpl();
		cond.setElprid_eq(form.getPrid() + "");

		cond.setPsdid_in(new String[] { form.getPsdid() });

		cond.setEllitype_eq("1");

		cond.setDesc(new String[] { "ellidtime" });

		List<EmergencyLogInfo> emeLogs = emergencyLogBL.searchEmergencyLogByCond(cond);
		if (emeLogs != null && emeLogs.size() > 0) {
			EmergencyLogTB emeLogTb = (EmergencyLogTB) emeLogs.get(0);
			emeLogTb.setElliinfo(form.getPsdValue());
			emergencyLogBL.updateEmergencyLog(emeLogTb);
		}

		dto.setJsonResult("{\"msg\":\"SUCCESS\"}");

		log.info("==========����̨���泡������˵�����==========");

		return dto;
	}

}