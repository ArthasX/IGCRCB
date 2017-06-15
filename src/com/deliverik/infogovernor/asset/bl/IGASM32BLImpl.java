package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.asset.bl.task.RiskcaseVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM32DTO;
import com.deliverik.infogovernor.asset.form.IGASM3202Form;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;

/**
 * �ĵ����ù���ҵ���߼�ʵ��
 *
 */
public class IGASM32BLImpl extends BaseBLImpl implements IGASM32BL {

	static Log log = LogFactory.getLog(IGASM32BLImpl.class);

	/** �汾��������ʶ */
	public static final String SAVE_VERSION_UP = "1";

	/** �汾�Ų�������ʶ */
	public static final String SAVE_VERSION = "0";
	
	public static final String  EIRRELATIONCODE="'013-001','013-002','013-003','013-006','013-010'";
	
	/** �ʲ���ϢBL */
//	protected IG117BL ig117BL;
	protected SOC0117BL soc0117BL;

	/** ��������ϢBL */
//	protected IG013BL soc0118BL;
	protected SOC0118BL soc0118BL;
	// TODO
	/** �ʲ�������BL */
//	protected IG800BL soc0107BL;
	protected SOC0107BL soc0107BL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;
	
	/** �������ϵBL */
//	protected IG313BL soc0119BL;
	protected SOC0119BL soc0119BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	
	/** �ʲ�������ϵ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** �ʲ�ȡֵ��Χ��������BL */
//	protected IG545BL ig545BL;
	protected SOC0151BL soc0151BL;
	
	/** ����BL */
	protected OrganizationBL organizationBL;
	
	/** ������BL */
//	protected IG225BL soc0109BL;
	protected SOC0109BL soc0109BL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** �����¼�BL */
	protected RiskcaseVWBL riskcaseVWBL;

	public void setRiskcaseVWBL(RiskcaseVWBL riskcaseVWBL) {
		this.riskcaseVWBL = riskcaseVWBL;
	}
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	public void setSoc0109BL(SOC0109BL soc0109BL) {
		this.soc0109BL = soc0109BL;
	}
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}
	
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	public void setSoc0107BL(SOC0107BL soc0107BL) {
		this.soc0107BL = soc0107BL;
	}

	public void setSoc0119BL(
			SOC0119BL soc0119BL) {
		this.soc0119BL = soc0119BL;
	}

	/**
	 * @param flowSetBL the flowSetBL to set
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	public void setSoc0151BL(
			SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}
	
	/**
	 * �����¼��ǼǴ���
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO insertEntityItemAction(IGASM32DTO dto) throws BLException {
		log.debug("========�����¼��ǼǴ���ʼ========");
		IGASM3202Form form = dto.getIgasm3202Form();
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�����¼�������Ϣ") );

		//�����ʲ���ض��󲢸�Ĭ��ֵ
		SOC0118TB entityItem = new SOC0118TB();
		entityItem.setEiuserid(form.getEiuserid());
		entityItem.setEiusername(form.getEiusername());
		entityItem.setEid(IGASMBL11Type.RISK_CASE_EID);
		entityItem.setEsyscoding(IGASMBL11Type.RISK_CASE_ESYSCODING);
		entityItem.setEiname(form.getFcname());
		entityItem.setEidesc(form.getFcdesc());
		entityItem.setEiversion(1);
		entityItem.setEismallversion(0);
		entityItem.setEistatus("1");
		entityItem.setEiinsdate(IGStringUtils.getCurrentDate());
		dto.setEntityItem(entityItem);
		SOC0118Info entityInfo = soc0118BL.registRiskCase(entityItem);
		
		//�����ʲ����չ�ϵ����
		if(form.getRiskid()!=null && form.getRiskjobid()!=null && !(form.getRiskjobid().equals("")) && !(form.getRiskid().equals(""))){
			Integer riskjobid = Integer.parseInt(form.getRiskjobid());
			Integer riskid = Integer.parseInt(form.getRiskid());
			flowSetBL.setProcessEntityRelation(riskjobid , "��ط����¼�",riskid, entityInfo.getEiid());
		}
		
		dto.setEntityInfo(entityInfo);
		//����ʲ�
		createEntityItem(dto);
		log.debug("========�����¼��ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ����ʲ�
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ�ID
	 * @throws BLException
	 */
	public void createEntityItem(IGASM32DTO dto) 	throws BLException {
		SOC0118Info entityInfo = dto.getEntityInfo();
		IGASM3202Form form = dto.getIgasm3202Form();
		
		dto.setEiid(entityInfo.getEiid());
		
		/** �����¼����� */
		createConfigItem(IGASMBL11Type.FCNAME,form.getFcname(),dto);
		/** �����¼����� */
		createConfigItem(IGASMBL11Type.FCDESC,form.getFcdesc(),dto);
		/** �����¼���Դ */
		createConfigItem(IGASMBL11Type.FCORIGIN,form.getFcorigin(),dto);
		/** �����¼��������� */
		createConfigItem(IGASMBL11Type.FCCATEGORY,form.getFccategory(),dto);
		/** �����������ID */
		createConfigItem(IGASMBL11Type.RISKJOBID,form.getRiskjobid(),dto);
		/** ���յ�ID */
		createConfigItem(IGASMBL11Type.RISKID,form.getRiskid(),dto);
		/** ���յ����ID */
		createConfigItem(IGASMBL11Type.RISKTYPE,form.getRisktype(),dto);
		/** �������ؼ������� */
		createConfigItem(IGASMBL11Type.FCSEVERITYLEVEL,form.getFcseveritylevel(),dto);
		/** ���շ������������� */
		createConfigItem(IGASMBL11Type.FCPOSSIBILITY,form.getFcpossibility(),dto);
		/** ���ռ������� */
		createConfigItem(IGASMBL11Type.FCLEVEL,form.getFclevel(),dto);
		/** ����ʶ��ʱ�� */
		createConfigItem(IGASMBL11Type.RISKCATCHTIME,form.getRiskcatchtime(),dto);
		/** Ӧ���������� */
		createConfigItem(IGASMBL11Type.FCRISKTASK,form.getFcrisktask(),dto);
		/** Ӧ���������� */
		createConfigItem(IGASMBL11Type.FCRISKTASKDESC,form.getFcrisktaskdesc(),dto);
		/** Ӧ�Բ��� */
		createConfigItem(IGASMBL11Type.FCPOLICY,form.getFcpolicy(),dto);
		/** Ӧ��Ŀ�� */
		createConfigItem(IGASMBL11Type.FCOPERATORAIM,form.getFcoperatoraim(),dto);
		/** Ӧ�Բ���ID */
		createConfigItem(IGASMBL11Type.RISKOPERATORDEPT,form.getRiskoperatordept(),dto);
		/** Ӧ�Ը�����ID */
		createConfigItem(IGASMBL11Type.RISKOPERATOR,form.getRiskoperator(),dto);
		/** ���ͷ����ԱID */
		createConfigItem(IGASMBL11Type.RISKCCOPERATOR,form.getRiskccoperator(),dto);
		/** ������ */
		createConfigItem(IGASMBL11Type.RISKREVIEWRESULT,form.getRiskreviewresult(),dto);
		/** �������Ĺ���ID */
		createConfigItem(IGASMBL11Type.RISKDEALID,form.getRiskdealid(),dto);
	}
	
	/**
	 * ����ʲ�����
	 * cid-�ʲ���cid��civalue-�ʲ���civalue��IGASM32DTO
	 * @throws BLException
	 */
	public void createConfigItem(String cid,String civalue,IGASM32DTO dto) throws BLException {
		//�����ʲ�������Ϣ
		SOC0118Info entityItem = dto.getEntityInfo();
		SOC0107TB configItem = new SOC0107TB();
		//ģ��ID
		configItem.setEid(entityItem.getEid());
		//�豸ID
		configItem.setEiid(dto.getEiid());
		//ģ������ID
		configItem.setCid(cid);
		//ģ��ֵ
		configItem.setCivalue(civalue);
		//����ʱ��
		configItem.setCiupdtime(entityItem.getEiinsdate());
		//ģ�Ͳ����
		configItem.setEsyscoding(entityItem.getEsyscoding());
		//��汾��
		configItem.setCiversion(entityItem.getEiversion());
		//С�汾��
		configItem.setCismallversion(0);
		
		//�ʲ����ԵǼ����
		soc0107BL.registSOC0107(configItem);
	}
	
	/**
	 * �����¼���ѯ����
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemAction(IGASM32DTO dto) throws BLException {

		log.debug("========�����¼���ѯ����ʼ========");
		RiskcaseVWSearchCondImpl cond = dto.getRiskcaseVWSearchCond();
		//�ĵ���Ϣ��ѯ����ȡ�� 
		int totalCount = this.riskcaseVWBL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("=======�����¼���Ϣ��ѯ���ݲ�����========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�����¼���ѯ���ݼ�������========");
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		List<RiskcaseVWInfo> entityItemVWInfoList = this.riskcaseVWBL.searchRiskcaseVW(dto.getRiskcaseVWSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		dto.setRiskcaseVWList(entityItemVWInfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�����¼���ѯ��������========");
		return dto;
	}
	
	/**
	 * �����¼���ʷ�汾��ѯ����
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchEntityItemByVersion(IGASM32DTO dto) throws BLException{
		List<RiskcaseVWInfo> entityItemVWInfoList = this.riskcaseVWBL.searchRiskcaseByVersion(dto.getRiskcaseVWSearchCond());
		dto.setRiskcaseVWList(entityItemVWInfoList);
		return dto;
	}
	
	/**
	 * �����¼�Ӧ�Բ���
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO searchRiskPolicyAction(IGASM32DTO dto) throws BLException{
		RiskcaseVWSearchCondImpl cond = new RiskcaseVWSearchCondImpl ();
		cond.setEiid(dto.getEiid());
		List<RiskcaseVWInfo> entityItemVWInfoList = this.riskcaseVWBL.searchRiskcaseVW(cond);
		if(entityItemVWInfoList!=null && entityItemVWInfoList.size()>0){
			for(int num = 0; num<entityItemVWInfoList.size(); num++){
				if(num == 0){
					dto.setRiskPolicy(entityItemVWInfoList.get(num).getFcpolicy());
				}else{
					if(entityItemVWInfoList.get(num).getFcpolicy()!=null 
					&& !entityItemVWInfoList.get(num).getFcpolicy().equals(entityItemVWInfoList.get(num-1).getFcpolicy()))
					{//���汾ֵ����һ�汾ֵ��ͬ
						dto.setRiskPolicy(dto.getRiskPolicy()+"->"+entityItemVWInfoList.get(num).getFcpolicy());
					}
					
				}
			}
		}
		return dto;
	}
	
	/**
	 *�����¼��޸Ĵ���
	 *
	 * @param dto IGASM32DTO
	 * @return IGASM32DTO
	 */
	public IGASM32DTO updateEntityItem(IGASM32DTO dto) throws BLException {
		
		log.debug("========�����¼���Ϣ�༭���������ʾ����ʼ========");
		IGASM3202Form form = dto.getIgasm3202Form();
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(form.getEiid());

		entityItem.setEiname(form.getFcname());
		entityItem.setEidesc(form.getFcdesc());
		entityItem.setEiversion(entityItem.getEiversion()+1);
		entityItem.setEismallversion(0);
		entityItem.setEistatus(form.getEistatus());
		entityItem.setEiupdtime(IGStringUtils.getCurrentDate());
		
		SOC0118Info entityInfo = this.soc0118BL.updateEntityItem(entityItem);
		dto.setEntityInfo(entityInfo);
		//����ʲ�
		createEntityItem(dto);
		dto.addMessage(new ActionMessage("IGCO10000.I005","�����¼���Ϣ"));
		log.debug("========�����¼���Ϣ�༭���������ʾ��������========");
		return dto;
	}
}
