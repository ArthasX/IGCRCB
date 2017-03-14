/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.risk.bl.task.AuditCheckRelationBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditDefBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditDefResultVWBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditInsBL;
import com.deliverik.infogovernor.risk.bl.task.RiskAuditResultBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.dto.IGRIS01DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0102Form;
import com.deliverik.infogovernor.risk.form.IGRIS0104Form;
import com.deliverik.infogovernor.risk.form.IGRIS0105Form;
import com.deliverik.infogovernor.risk.form.IGRIS0110Form;
import com.deliverik.infogovernor.risk.form.IGRIS0112Form;
import com.deliverik.infogovernor.risk.form.IGRIS0113Form;
import com.deliverik.infogovernor.risk.form.IGRIS0114Form;
import com.deliverik.infogovernor.risk.form.IGRIS0115Form;
import com.deliverik.infogovernor.risk.form.IGRIS0117Form;
import com.deliverik.infogovernor.risk.model.AuditCheckRelation;
import com.deliverik.infogovernor.risk.model.RiskAudit;
import com.deliverik.infogovernor.risk.model.RiskAuditDef;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;
import com.deliverik.infogovernor.risk.model.RiskAuditIns;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.AuditCheckRelationSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditDefSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditInsSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskAuditResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditDefTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditInsTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditResultTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditTB;

/**
 * ��ư汾ҵ���߼�ʵ��
 *
 */
public class IGRIS01BLImpl extends BaseBLImpl implements IGRIS01BL {

	static Log log = LogFactory.getLog(IGRIS01BLImpl.class);
	
	/** ��ư汾��ϢBL */
	protected RiskAuditBL riskAuditBL;
	
	/** ��Ʒ�����ϢBL */
	protected RiskAuditInsBL riskAuditInsBL;
	
	/** �������ϢBL */
	protected RiskAuditDefBL riskAuditDefBL;
	
	/** ��������������������ͼ��ϢBL */
	protected RiskAuditDefResultVWBL riskAuditDefResultVWBL;
	
	/** ���������ϢBL */
	protected RiskAuditResultBL riskAuditResultBL;
	
	/** ��Ʒ��ռ���ϵ��ϢBL */
	protected AuditCheckRelationBL auditCheckRelationBL;
	
	/** ���ռ����ϢBL */
	protected RiskCheckBL riskCheckBL;
	
	/** ���ռ������ϢBL */
	protected RiskCheckResultBL riskCheckResultBL;
	
	/** ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	protected AttachmentBL attachmentBL;
	
	protected IGRIS02BL igris02BL;
	
	
	public void setIgris02BL(IGRIS02BL igris02BL) {
		this.igris02BL = igris02BL;
	}

	/**
	 * @param attachmentTBDAO the attachmentTBDAO to set
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * ���ռ������ϢBL�趨
	 * 
	 * @param riskCheckBL
	 */

	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}
	
	/**
	 * ���ռ����ϢBL�趨
	 * 
	 * @param riskCheckBL
	 */

	public void setRiskCheckBL(RiskCheckBL riskCheckBL) {
		this.riskCheckBL = riskCheckBL;
	}
	
	
	/**
	 * ��Ʒ��ռ���ϵ��ϢBL�趨
	 * 
	 * @param auditCheckRelationBL
	 */

	public void setAuditCheckRelationBL(AuditCheckRelationBL auditCheckRelationBL) {
		this.auditCheckRelationBL = auditCheckRelationBL;
	}
	
	/**
	 * �������ϢBL�趨
	 * 
	 * @param riskAuditDefBL
	 */

	public void setRiskAuditDefBL(RiskAuditDefBL riskAuditDefBL) {
		this.riskAuditDefBL = riskAuditDefBL;
	}

	/**
	 * ��ư汾��ϢBL�趨
	 * 
	 * @param riskAuditBL
	 */
	public void setRiskAuditBL(RiskAuditBL riskAuditBL) {
		this.riskAuditBL = riskAuditBL;
	}
	
	/**
	 * ��Ʒ�����ϢBL�趨
	 * 
	 * @param riskAuditInsBL
	 */
	public void setRiskAuditInsBL(RiskAuditInsBL riskAuditInsBL) {
		this.riskAuditInsBL = riskAuditInsBL;
	}
	
	/**
	 * ��ƽ����ϢBL�趨
	 * 
	 * @param riskAuditResultBL
	 */
	public void setRiskAuditResultBL(RiskAuditResultBL riskAuditResultBL) {
		this.riskAuditResultBL = riskAuditResultBL;
	}

	/**
	 * ��������������������ͼ��ϢBL�趨
	 * 
	 * @param riskAuditDefResultVWBL
	 */
	public void setRiskAuditDefResultVWBL(
			RiskAuditDefResultVWBL riskAuditDefResultVWBL) {
		this.riskAuditDefResultVWBL = riskAuditDefResultVWBL;
	}
	
	/**
	 * ��������BL�趨
	 * 
	 * @param codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	
	//-----------------------------------------------------------��ư汾----------------------------------------------------------------------
	


	/**
	 * ��ư汾��Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========��ư汾��Ϣ��ѯ����ʼ========");
		
		//��ư汾��Ϣ��ѯ����ȡ�� 
		int totalCount = this.riskAuditBL.getSearchCount(dto.getRiskAuditSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��ư汾��Ϣ��ѯ���ݲ�����========");
			//��ư汾��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ư汾��Ϣ��ѯ���ݼ�������========");
			//��ư汾��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ��ư汾��Ϣȡ��
		List<RiskAudit> riskAuditList = this.riskAuditBL.searchRiskAudit(dto.getRiskAuditSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditList(riskAuditList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��ư汾��Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ư汾��Ϣ�ǼǴ���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========��ư汾��Ϣ�ǼǴ���ʼ========");
		
		IGRIS0102Form form = dto.getIgRIS0102Form();
		
		form.setRadate(IGStringUtils.getCurrentDate());
		
		if(dto.getUser() == null) {
			throw new BLException("IGCO10000.E004","��½�û�����");
		}
		form.setRauserid(dto.getUser().getUserid());
		
		form.setRausername(dto.getUser().getUsername());
		
		form.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);
		
		String maxRootID = this.riskAuditBL.getMaxRacode();
		
		if(StringUtils.isEmpty(maxRootID)) {
			form.setRacode(IGRISCONSTANTS.RISKAUDIT_ROOT_MIN_ID);
		} else {
			Integer rootID = new Integer(maxRootID);
			if(IGRISCONSTANTS.RISKAUDIT_ROOT_MAX_ID.equals(rootID.toString())) {
				throw new BLException("IGRIS0102.E002");
			} else {
				form.setRacode(StringUtils.leftPad(String.valueOf(rootID + 1),IGRISCONSTANTS.RISKAUDIT_ROOT_LENGTH,IGRISCONSTANTS.RISKAUDIT_ROOT_LEFT_PAD));
			}
		}
		
		//��ư汾��Ϣ�ǼǴ���
		this.riskAuditBL.registRiskAudit(form);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��ư汾������Ϣ") );
		
		log.debug("========��ư汾��Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ��ư汾��Ϣͣ��/���ô���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditAction(IGRIS01DTO dto) throws BLException {
		log.debug("========��ư汾��Ϣͣ��/���ô���ʼ========");
		IGRIS0102Form form = dto.getIgRIS0102Form();
		
		RiskAudit ra = this.riskAuditBL.searchRiskAuditByKey(form.getRaid());
		
		//���ƶ���
		RiskAuditTB pdTB = (RiskAuditTB)SerializationUtils.clone(ra);
		
		if(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE.equals(form.getRastatus())) {
			pdTB.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_DISABLE);//ͣ��
			log.debug("========ͣ��========");
			dto.addMessage(new ActionMessage( "IGCO10000.I008", "��ư汾") );
		} else if(IGRISCONSTANTS.RISKAUDIT_STATUS_DISABLE.equals(form.getRastatus())) {
			pdTB.setRastatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);//����
			log.debug("========����========");
			dto.addMessage(new ActionMessage( "IGCO10000.I009", "��ư汾") );
		}
		this.riskAuditBL.updateRiskAudit(pdTB);
		log.debug("========��ư汾��Ϣͣ��/���ô�������========");
		return dto;
	}
	
	//-----------------------------------------------------------�����----------------------------------------------------------------------

	/**
	 * <p>
	 * Description: ���������
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO insertRiskAuditDefAction(IGRIS01DTO dto) throws BLException {
		log.debug("========�������������ʼ========");
		//ȡ�õ�ǰ��ѡ�ϼ��������¼�����������code,�����1��Ϊ����������code
		IGRIS0105Form form = dto.getIgRIS0105Form();
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRadparcode_q(form.getRadparcode());
		List<RiskAuditDef> riskAuditDeflist = riskAuditDefBL.searchRiskAuditDef(cond,0,0);//��ý����¼��������
		String syscode = "";	
		String auditnum = ResourceUtility.getString("AUDIT_NUM");//��������Ĳ����
		if(auditnum == null || "".equals(auditnum)){
			auditnum = "6";
		}
		int auditnumInt = Integer.valueOf(auditnum);
		int audit_code_len = 19;//���������Ĭ�ϳ���
		if(auditnumInt>1 && auditnumInt<10){
			audit_code_len = 4+3*(auditnumInt-1);
		}
		if(riskAuditDeflist.size()>0){//�����¼������
			int size = riskAuditDeflist.size()-1;
			RiskAuditDef riskAuditDef = riskAuditDeflist.get(size);
			syscode = riskAuditDef.getRadcode();
			String temp = syscode.substring(syscode.length()-3);
			
			if(temp.substring(temp.length()-3).equals(IGRISCONSTANTS.RISKAUDITDEF_ROOT_MAX_ID)){
				throw new BLException("IGRIS0105.E004","����������Ϣ");
			}
			
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				syscode = syscode.substring(0,syscode.length()-3)+temp;
			}else{//***
				syscode = syscode.substring(0,syscode.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
			form.setRadcode(syscode);
		}else{
			syscode = form.getRadparcode();		
			//�ж��Ƿ��Ѿ��ﵽ�涨�Ĳ����
			if(syscode!=null && syscode.length()>=audit_code_len){
				throw new BLException("IGRIS0105.E005","����������Ϣ");
			}
			form.setRadcode(syscode+"001");
		}
		int radlevel = form.getRadcode().length()-7;
		if (radlevel == 0) {
			form.setRadlevel("1");
		}else{
			int level = radlevel/3+1;
			form.setRadlevel(level+"");
		}
		form.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		this.riskAuditDefBL.registRiskAuditDef(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����������Ϣ") );
		log.debug("========�����������������========");
		return dto;
	}
	
	/**
	 * �������Ϣͣ��/���ô���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditDefAction(IGRIS01DTO dto) throws BLException {
		log.debug("========�������Ϣͣ��/���ô���ʼ========");
		IGRIS0104Form form = dto.getIgRIS0104Form();
		
		RiskAuditDef riskAuditDef = this.riskAuditDefBL.searchRiskAuditDefByKey(form.getRadid());
		
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRadparcode_q(riskAuditDef.getRadcode());
		cond.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);
		if (riskAuditDefList.size()==0) {
			//���ƶ���
			RiskAuditDefTB riskAuditDefTB = (RiskAuditDefTB)SerializationUtils.clone(riskAuditDef);
			
			if(IGRISCONSTANTS.RISKAUDITDEF_STATUS_DISABLE.equals(form.getRadstatus())) {
				riskAuditDefTB.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);//����
				log.debug("========ͣ��========");
				dto.addMessage(new ActionMessage( "IGCO10000.I009", "�����") );
			} else if(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE.equals(form.getRadstatus())) {
				riskAuditDefTB.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_DISABLE);//ͣ��
				log.debug("========����========");
				dto.addMessage(new ActionMessage( "IGCO10000.I008", "�����") );
			}
			this.riskAuditDefBL.updateRiskAuditDef(riskAuditDefTB);
		}else{
			dto.addMessage(new ActionMessage( "IGRIS0105.E003" ,""));
		}
		log.debug("========�������Ϣͣ��/���ô�������========");
		return dto;
	}
	
	/**
	 * �������ϸ��Ϣ�鿴����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0108Action(IGRIS01DTO dto) throws BLException {
		log.debug("========�������ϸ��Ϣ����ʼ========");
		IGRIS0104Form form = dto.getIgRIS0104Form();
		
		RiskAuditDef riskAuditDef = this.riskAuditDefBL.searchRiskAuditDefByKey(form.getRadid());
		
		dto.setRiskAuditDef(riskAuditDef);
		log.debug("========�������ϸ��Ϣ��������========");
		return dto;
	}
	/**
	 * �������ϸ��Ϣ�޸ĳ�ʼ������
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initRiskAuditDefAction(IGRIS01DTO dto) throws BLException{
		log.debug("========�������Ϣ�޸ĳ�ʼ������ʼ========");
		IGRIS0105Form form = dto.getIgRIS0105Form();
		
		RiskAuditDef riskAuditDef = this.riskAuditDefBL.searchRiskAuditDefByKey(form.getRadid());
		
		if (riskAuditDef.getRadparcode().length() == 4) {
			form.setRadparname(riskAuditDef.getRaversion());
			
		}else{			
			RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
			cond.setRadcode_q(riskAuditDef.getRadparcode());
			List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);
			for (RiskAuditDef riskAudit : riskAuditDefList) {
				form.setRadparname(riskAudit.getRadname());
			}
		}
		
		form.setMode("1");
		form.setRaversion(riskAuditDef.getRaversion());
		form.setRaddesc(riskAuditDef.getRaddesc());
		form.setRadfrequency(riskAuditDef.getRadfrequency());
		form.setRadlevel(riskAuditDef.getRadlevel());
		form.setRadname(riskAuditDef.getRadname());
		form.setRadorg(riskAuditDef.getRadorg());
		form.setRadorgcoding(riskAuditDef.getRadorgcoding());
		form.setRadparcode(riskAuditDef.getRadparcode());
		form.setRadrisklevel(riskAuditDef.getRadrisklevel());
		form.setRadstatus(riskAuditDef.getRadstatus());
		form.setRadtype(riskAuditDef.getRadtype());
		form.setRaduserid(riskAuditDef.getRaduserid());
		form.setRadusername(riskAuditDef.getRadusername());
		form.setRadmode(riskAuditDef.getRadmode());
		form.setRaid(riskAuditDef.getRaid());
		form.setRadcode(riskAuditDef.getRadcode());
		
		dto.setIgRIS0105Form(form);
	
		log.debug("========�������ϸ��Ϣ�޸ĳ�ʼ����������========");
		
		return dto;
		
	}
	
	/**
	 * �������ϸ��Ϣ�޸Ĵ���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO editRiskAuditDefAction(IGRIS01DTO dto) throws BLException {
		log.debug("========�������ϸ��Ϣ����ʼ========");
		IGRIS0105Form form = dto.getIgRIS0105Form();
		this.riskAuditDefBL.updateRiskAuditDef(form);
		dto.addMessage(new ActionMessage("IGCO10000.I005","����������Ϣ"));
		log.debug("========�������ϸ��Ϣ��������========");
		return dto;
	}
	/**
	 * �������Ϣȫ���¼���ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefAllAction(IGRIS01DTO dto) throws BLException{
		
		log.debug("========�������Ϣ��ѯ����ʼ========");
		
		IGRIS0104Form form = dto.getIgRIS0104Form();
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRaid(form.getRaid());
		cond.setRadparcode(form.getRadparcode_q());
		//�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.riskAuditDefBL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========�������Ϣ��ѯ���ݲ�����========");
			//�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�������Ϣ��ѯ���ݼ�������========");
			//�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ�������Ϣȡ��
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditDefList(riskAuditDefList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�������Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * �������Ϣ��һ����ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefNextAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========�������Ϣ��ѯ����ʼ========");
		
		//�������Ϣ��ѯ����ȡ�� 
		IGRIS0104Form form = dto.getIgRIS0104Form();
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		cond.setRaid(form.getRaid());
		cond.setRadparcode_q(form.getRadparcode_q());
		int totalCount = this.riskAuditDefBL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========�������Ϣ��ѯ���ݲ�����========");
			//�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�������Ϣ��ѯ���ݼ�������========");
			//�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		//��ǰҳ�������Ϣȡ��
		List<RiskAuditDef> riskAuditDefList = this.riskAuditDefBL.searchRiskAuditDef(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditDefList(riskAuditDefList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ���ڵ��ϼ�����һ������
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 */
	
	public IGRIS01DTO searchAuditTreeAction(IGRIS01DTO dto) throws BLException{
		log.debug("========һ��������ѯ����ʼ========");
		
		IGRIS0104Form form = dto.getIgRIS0104Form();
		RiskAudit riskAudit = this.riskAuditBL.searchRiskAuditByKey(form.getRaid());
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		if (riskAudit == null) {
			return dto;
		}
			
		TreeNode pNode = new TreeNode();
		pNode.setId(riskAudit.getRacode());
		pNode.setName(riskAudit.getRaversion());
		
		RiskAuditDefSearchCondImpl cond1 = new RiskAuditDefSearchCondImpl();
		cond1.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		cond1.setRadparcode_q(riskAudit.getRacode());
		List<RiskAuditDef> riskAuditDeflist = riskAuditDefBL.searchRiskAuditDef(cond1,0,0);//��ý����¼��������
		for (RiskAuditDef riskAuditDef : riskAuditDeflist) {				
			
			//���õ�ǰ����������(�Ӹü��������)			
			RiskAuditDefSearchCondImpl cond2 = new RiskAuditDefSearchCondImpl();
			cond2.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
			cond2.setRadcode(riskAuditDef.getRadcode());
			List<RiskAuditDef> riskAuditDeflist1 = riskAuditDefBL.searchRiskAuditDef(cond2,0,0);//��ý����¼��������

			TreeNode ptNode = new TreeNode();
			ptNode.setId(riskAuditDeflist1.get(0).getRadcode());
			ptNode.setName(riskAuditDeflist1.get(0).getRadname());
			//��Ӻ��ӽ��
			int nowlen = riskAuditDeflist1.get(0).getRadcode().length();
			getChildTreeNodeMap(riskAuditDeflist1,ptNode,nowlen,riskAuditDef.getRadcode());
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
	
		}
		
		treeNodeMap.put(pNode.getId(),pNode);		
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========һ��������ѯ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����code�ĳ���
	 * @author maozhipeng@deliverik.com
	 */
	private void getChildTreeNodeMap(List<RiskAuditDef> ret,TreeNode ptNode,int ptlen,String radcode){

		List<RiskAuditDef> nextret = getNextLevelNodes(ret,ptlen,radcode);//ȡ�øü�����LIST

		for(int i=0,j=nextret.size();i<j;i++){
			String code = nextret.get(i).getRadcode();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getRadcode());
			pdNode.setName(nextret.get(i).getRadname());
				
			getChildTreeNodeMap(ret,pdNode,code.length(),code);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	
	/**
	 * <p>
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����radcode
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 */
	
	private List<RiskAuditDef> getNextLevelNodes(List<RiskAuditDef> ret,int levellen,String radcode) {
		
		List<RiskAuditDef> riskAuditDef = new ArrayList<RiskAuditDef>();
		for(int i=0,j=ret.size();i<j;i++){
			String code = ret.get(i).getRadcode();
			if(code.length()==(levellen+3) && (code.substring(0,code.length()-3)).equals(radcode)){
				riskAuditDef.add(ret.get(i));
			}
			
		}		
		return riskAuditDef;
	}
	
	//-----------------------------------------------------------�������----------------------------------------------------------------------
	/**
	 * ���������Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditResultAction(IGRIS01DTO dto) throws BLException{
		
		log.debug("========���������Ϣ��ѯ����ʼ========");
		
		IGRIS0113Form form = dto.getIgRIS0113Form();
		//�����ѯ��������ǰ�û��Ŀ��������������
		RiskAuditResultSearchCondImpl cond = new RiskAuditResultSearchCondImpl();
		cond.setRaruserid(form.getRaruserid());
		cond.setRaiid(form.getRaiid());
		List<RiskAuditResult> riskAuditResultList = this.riskAuditResultBL.searchRiskAuditResult(cond, 0, 0);
		
		for(Iterator<RiskAuditResult> iter = riskAuditResultList.iterator(); iter.hasNext();) {
			RiskAuditResult riskAuditResult = iter.next();
			RiskAuditInsSearchCondImpl cond1 = new RiskAuditInsSearchCondImpl();
			cond1.setRaistatus(IGRISCONSTANTS.RISKAUDIT_STATUS_ENABLE);
			cond1.setRaiid(riskAuditResult.getRaiid());
			List<RiskAuditIns> riskAuditInsList = this.riskAuditInsBL.searchRiskAuditIns(cond1, 0, 0);
			if (riskAuditInsList.size() == 0) {
				iter.remove();
			}
		}
		List<String> list = new ArrayList<String>();
		Boolean flag = true;
		for (RiskAuditResult riskAuditResult: riskAuditResultList) {
			flag = true;
			String radcode = riskAuditResult.getRiskAuditDefTB().getRadcode();
			for (RiskAuditResult rar: riskAuditResultList) {
				String temp = rar.getRiskAuditDefTB().getRadcode();
				if(radcode.contains(temp) && !radcode.equals(temp)){
					if(radcode.length()>temp.length()){
						if(radcode.substring(0, temp.length()).equals(temp)){
							flag = false;
							break;
						}
					}else{
						if(temp.substring(0, radcode.length()).equals(radcode)){
							flag = false;
							break;
						}
					}
					
				}
			}
			if(flag){
				list.add(radcode);
			}		
		}
		
		List<RiskAuditResult> rdrList = new ArrayList<RiskAuditResult>();
		for (String str : list) {	
			RiskAuditResultSearchCondImpl cond1 = new RiskAuditResultSearchCondImpl();
			cond1.setRaiid(form.getRaiid());
			cond1.setRadcode(str);
			List<RiskAuditResult> rad = this.riskAuditResultBL.searchRiskAuditResult(cond1, 0, 0);
			for (RiskAuditResult riskAuditResult : rad) {
				rdrList.add(riskAuditResult);
			}
		}
		dto.setRiskAuditResultList(rdrList);
		
		log.debug("========���������Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * <p>
	 * Description: ���������ʼ��
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO initRiskAuditResultAction(IGRIS01DTO dto) throws BLException{
		IGRIS0114Form form = dto.getIgRIS0114Form();
		RiskAuditResult riskAuditResult = this.riskAuditResultBL.searchRiskAuditResultByKey(form.getRarid());
		form.setRadid(riskAuditResult.getRadid());
		form.setRaiid(riskAuditResult.getRaiid());
		form.setRarid(riskAuditResult.getRarid());
		form.setRaruserid(riskAuditResult.getRaruserid());
		form.setRarusername(riskAuditResult.getRarusername());
		form.setRardate(riskAuditResult.getRardate());
		form.setRarexecdesc(riskAuditResult.getRarexecdesc());
		form.setRarexecscore(riskAuditResult.getRarexecscore());
		form.setRaroveralldesc(riskAuditResult.getRaroveralldesc());
		form.setRaroverallscore(riskAuditResult.getRaroverallscore());
		form.setRarplandesc(riskAuditResult.getRarplandesc());
		form.setRarplanscore(riskAuditResult.getRarplanscore());
		form.setRadcode(riskAuditResult.getRadcode());
		dto.setIgRIS0114Form(form);
		return dto;
	}
	/**
	 * <p>
	 * Description: �����������
	 * </p>
	 * 
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGRIS01DTO updateRiskAuditResultAction(IGRIS01DTO dto) throws BLException{
		
		IGRIS0114Form form = dto.getIgRIS0114Form();
		String date = IGStringUtils.getCurrentDate();
		form.setRardate(date);
		form.setRaruserid(dto.getUser().getUserid());
		form.setRarusername(dto.getUser().getUsername());
		this.riskAuditResultBL.updateRiskAuditResult(form);
		dto.addMessage(new ActionMessage( "IGRIS0114.I001", "�������") );
		return dto;
	}
	
	/**
	 * ��ȡ�����õ�������κ������б�
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsLabelInUse(IGRIS01DTO dto) throws BLException {
		log.debug("========��ȡ�����õ�������κ������б���ʼ========");
		
		List<LabelValueBean> labelList = this.riskAuditInsBL.searchRiskAuditInsLabelInUse();
		
		dto.setLabelList(labelList);
		
		log.debug("========��ȡ�����õ�������κ������б�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ���ռ���ѯ
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckAction(IGRIS01DTO dto) throws BLException {
		IGRIS0115Form form = dto.getIgRIS0115Form();
		AuditCheckRelationSearchCondImpl cond = new AuditCheckRelationSearchCondImpl();
		cond.setRadid(form.getRadid());
		List<AuditCheckRelation> auditCheckRelationList = this.auditCheckRelationBL.searchAuditCheckRelation(cond, 0, 0);
		List<RiskCheck> riskCheckList = new ArrayList<RiskCheck>();
		for (AuditCheckRelation auditCheckRelation : auditCheckRelationList) {
			RiskCheck riskCheck = this.riskCheckBL.searchRiskCheckByKey(auditCheckRelation.getRcid());
			riskCheckList.add(riskCheck);
		}
		dto.setRiskCheckList(riskCheckList);
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ռ��鿴ҳ
	 * </p>
	 */
	
	public IGRIS01DTO initRiskCheckAction(IGRIS01DTO dto) throws BLException {
		log.debug("========���ռ��鿴����ʼ========");
		IGRIS0115Form form = dto.getIgRIS0115Form();
		RiskCheck rc = this.riskCheckBL.searchRiskCheckByKey(form.getRcid());
		dto.setRiskCheck(rc);
		
		//���ͷ��ռ����Եı��ʽ
		String cronInfo = this.igris02BL.getCronInfo(rc.getRcfrequency(),rc.getRcstartdate());
		dto.setCronInfo(cronInfo);
		
		//��ѯ������Ϣ
		List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(rc.getRcattch());
		dto.setAttachmentList(attachmentList);
		
		log.debug("========���ռ��鿴��������========");
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ռ������ѯ
	 * </p>
	 */
	
	public IGRIS01DTO searchRiskCheckResultAction(IGRIS01DTO dto) throws BLException {
		IGRIS0115Form form = dto.getIgRIS0115Form();
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		cond.setRcid(form.getRcid());
		List<RiskCheckResult> riskCheckResultList = this.riskCheckResultBL.searchRiskCheckResult(cond, 0, 0);
		Map<RiskCheckResult, List<Attachment>> attachmentMap = new HashMap<RiskCheckResult, List<Attachment>>();
		for (RiskCheckResult riskCheckResult : riskCheckResultList) {		
			//��ѯ������Ϣ
			if (StringUtils.isNotEmpty(riskCheckResult.getRcrattch())) {
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(riskCheckResult.getRcrattch());
				attachmentMap.put(riskCheckResult, attachmentList);			
			}else{
				attachmentMap.put(riskCheckResult, new ArrayList<Attachment>());	
			}
		}
		dto.setAttachmentMap(attachmentMap);
		return dto;
	}
	//-----------------------------------------------------------��Ʒ���----------------------------------------------------------------------
	
	/**
	 * ��Ʒ�����Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditInsAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========��Ʒ�����Ϣ��ѯ����ʼ========");
		
		//��Ʒ�����Ϣ��ѯ����ȡ�� 
		int totalCount = this.riskAuditInsBL.getSearchCount(dto.getRiskAuditInsSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��Ʒ�����Ϣ��ѯ���ݲ�����========");
			//��Ʒ�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ʒ�����Ϣ��ѯ���ݼ�������========");
			//��Ʒ�����Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ��Ʒ�����Ϣȡ��
		List<RiskAuditIns> riskAuditInsList = this.riskAuditInsBL.searchRiskAuditIns(dto.getRiskAuditInsSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setRiskAuditInsList(riskAuditInsList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��Ʒ�����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��Ʒ�����Ϣ�ǼǴ���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO insertRiskAuditInsAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========��Ʒ�����Ϣ�ǼǴ���ʼ========");
		
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		form.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE);
		
		//��Ʒ�����Ϣ�ǼǴ���
		RiskAuditIns rai = this.riskAuditInsBL.registRiskAuditIns(form);
		
		RiskAuditDefSearchCondImpl cond = new RiskAuditDefSearchCondImpl();
		
		cond.setRaid(form.getRaid());
		
		List<RiskAuditDef> radList = this.riskAuditDefBL.searchRiskAuditDef(cond, 0, 0);
		
		for(RiskAuditDef rad : radList) {
			RiskAuditResultTB rarTB = new RiskAuditResultTB();
			rarTB.setRadid(rad.getRadid());
			rarTB.setRadcode(rad.getRadcode());
			rarTB.setRaiid(rai.getRaiid());
			this.riskAuditResultBL.registRiskAuditResult(rarTB);
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��Ʒ��������Ϣ") );
		
		log.debug("========��Ʒ�����Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ��Ʒ�����Ϣ�ر�/���ô���
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO changeRiskAuditInsAction(IGRIS01DTO dto) throws BLException {
		log.debug("========��Ʒ�����Ϣ�ر�/���ô���ʼ========");
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		RiskAuditIns rai = this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid());
		
		//���ƶ���
		RiskAuditInsTB pdTB = (RiskAuditInsTB)SerializationUtils.clone(rai);
		
		if(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE.equals(form.getRaistatus())) {
			pdTB.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_DISABLE);//�ر�
			log.debug("========�ر�========");
			dto.addMessage(new ActionMessage( "IGRIS0109.I001") );
		} else if(IGRISCONSTANTS.RISKAUDITINS_STATUS_DISABLE.equals(form.getRaistatus())) {
			pdTB.setRaistatus(IGRISCONSTANTS.RISKAUDITINS_STATUS_ENABLE);//����
			log.debug("========����========");
			dto.addMessage(new ActionMessage( "IGCO10000.I009", "��Ʒ���") );
		}
		this.riskAuditInsBL.updateRiskAuditIns(pdTB);
		log.debug("========��Ʒ�����Ϣ�ر�/���ô�������========");
		return dto;
	}
	
	/**
	 * ��Ʒ�����Ϣ�������
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO updateRiskAuditInsAction(IGRIS01DTO dto) throws BLException {

		log.debug("========��Ʒ�����Ϣ�������ʼ========");
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		RiskAuditIns rai = this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid());
		
		//���ƶ���
		RiskAuditInsTB raiTB = (RiskAuditInsTB)SerializationUtils.clone(rai);
		
		raiTB.setRaistart(form.getRaistart());
		
		raiTB.setRaiend(form.getRaiend());
		
		raiTB.setRaidesc(form.getRaidesc());
		
		//��Ʒ�����Ϣ�������
		this.riskAuditInsBL.updateRiskAuditIns(raiTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��Ʒ��������Ϣ") );

		log.debug("========��Ʒ�����Ϣ�����������========");
		return dto;
	}
	
	/**
	 * ��Ʒ�����Ϣ�����ʼ������
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO initIGRIS0110Action(IGRIS01DTO dto) throws BLException {
		log.debug("========��Ʒ�����Ϣ�����ʼ������ʼ========");
		
		IGRIS0110Form form = dto.getIgRIS0110Form();
		
		RiskAuditIns rai = this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid());
		
		form.setRaicode(rai.getRaicode());
		
		form.setRaistart(rai.getRaistart());
		
		form.setRaiend(rai.getRaiend());
		
		form.setRaidesc(rai.getRaidesc());
		
		form.setRaversion(rai.getRaversion());
		
		form.setMode("1");
		
		log.debug("========��Ʒ�����Ϣ�����ʼ����������========");
		return dto;
	}
	
	/**
	 * ��ȡ�����õ���ư汾�������б�
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditLabelInUse(IGRIS01DTO dto) throws BLException {
		log.debug("========��ȡ�����õ���ư汾�������б���ʼ========");
		List<LabelValueBean> labelList = this.riskAuditBL.searchRiskAuditLabelInUse();
		
		dto.setLabelList(labelList);
		
		log.debug("========��ȡ�����õ���ư汾�������б�������========");
		return dto;
	}
	
	//-----------------------------------------------------------�����----------------------------------------------------------------------
	
	/**
	 * �������Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditDefResultVWAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========�������Ϣ��ѯ����ʼ========");
		
		IGRIS0112Form form = dto.getIgRIS0112Form();
		
		form.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		
		//��ǰҳ�������Ϣȡ��
		List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList = this.riskAuditDefResultVWBL.searchRiskAuditDefResultVW(form, 0, 0);
		
		if(riskAuditDefResultVWInfoList.isEmpty()) {
			dto.addMessage(new ActionMessage( "IGCO10000.E004", "��������") );
		} else {
			String radMaxLevel = this.riskAuditDefResultVWBL.getMaxRadlevel(form);
			if(StringUtils.isNotEmpty(radMaxLevel)) {
				dto.setRadMaxLevel(Integer.parseInt(radMaxLevel));
				List<Integer> list = new ArrayList<Integer>();
				for(int i = 1; i <= Integer.parseInt(radMaxLevel); i++) {
					list.add(i);
				}
				dto.setRadMaxLevelList(list);
			}
		}
		
		String[] rarusername = new String[riskAuditDefResultVWInfoList.size()];
		
		int i = 0;
		
		for(RiskAuditDefResultVWInfo radrVWInfo : riskAuditDefResultVWInfoList) {
			rarusername[i++] = radrVWInfo.getRarusername();
		}
		
		form.setRarusername(rarusername);
		
		dto.setRiskAuditDefResultVWInfoList(riskAuditDefResultVWInfoList);
		
		log.debug("========�������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �������Ϣ���洦��
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO saveRiskAuditResultAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========�������Ϣ���洦��ʼ========");
		
		IGRIS0112Form form = dto.getIgRIS0112Form();
		
		if (form.getRadid() != null && form.getRadid().length > 0 ) {
			for( int i = 0 ; i < form.getRadid().length; i++ ) {
				RiskAuditResultTB rarTB = new RiskAuditResultTB();
				if (StringUtils.isEmpty(form.getRarid()[i])) {
					if(StringUtils.isNotEmpty(form.getRaruserid()[i])) {
						rarTB.setRadid(Integer.parseInt(form.getRadid()[i]));
						rarTB.setRaiid(form.getRaiid());
						rarTB.setRaruserid(form.getRaruserid()[i]);
						rarTB.setRarusername(form.getRarusername()[i]);
						this.riskAuditResultBL.registRiskAuditResult(rarTB);
					}
				} else {
					RiskAuditResult rar = this.riskAuditResultBL.searchRiskAuditResultByKey(Integer.parseInt(form.getRarid()[i]));
					if(StringUtils.isEmpty(form.getRaruserid()[i]) && StringUtils.isNotEmpty(rar.getRaruserid())) {
						rarTB = (RiskAuditResultTB)SerializationUtils.clone(rar);
						rarTB.setRaruserid(null);
						rarTB.setRarusername(null);
						this.riskAuditResultBL.updateRiskAuditResult(rarTB);
					} else if(StringUtils.isNotEmpty(form.getRaruserid()[i]) && StringUtils.isNotEmpty(rar.getRaruserid())) {
						if(!form.getRaruserid()[i].equals(rar.getRaruserid())) {
							rarTB = (RiskAuditResultTB)SerializationUtils.clone(rar);
							rarTB.setRaruserid(form.getRaruserid()[i]);
							rarTB.setRarusername(form.getRarusername()[i]);
							this.riskAuditResultBL.updateRiskAuditResult(rarTB);
						}
					}else if(StringUtils.isNotEmpty(form.getRaruserid()[i]) && StringUtils.isEmpty(rar.getRaruserid())) {
						rarTB = (RiskAuditResultTB)SerializationUtils.clone(rar);
						rarTB.setRaruserid(form.getRaruserid()[i]);
						rarTB.setRarusername(form.getRarusername()[i]);
						this.riskAuditResultBL.updateRiskAuditResult(rarTB);
					}
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGRIS0112.I001") );
		
		log.debug("========�������Ϣ���洦������========");
		return dto;
	}
	
//-----------------------------------------------------------��Ʊ���----------------------------------------------------------------------
	
	/**
	 * ��Ʊ�����Ϣ��ѯ����
	 *
	 * @param dto IGRIS01DTO
	 * @return IGRIS01DTO
	 */
	public IGRIS01DTO searchRiskAuditReportAction(IGRIS01DTO dto) throws BLException {
		
		log.debug("========��Ʊ�����Ϣ��ѯ����ʼ========");
		
		IGRIS0117Form form = dto.getIgRIS0117Form();
		
		form.setRadstatus(IGRISCONSTANTS.RISKAUDITDEF_STATUS_ENABLE);
		
		dto.setRiskAuditIns(this.riskAuditInsBL.searchRiskAuditInsByKey(form.getRaiid()));
		
		//��ǰҳ��Ʊ�����Ϣȡ��
		List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList = this.riskAuditDefResultVWBL.searchRiskAuditDefResultVW(form, 0, 0);
		
		if(riskAuditDefResultVWInfoList.isEmpty()) {
			dto.addMessage(new ActionMessage( "IGCO10000.E004", "����������Ϣ") );
		} else {
			String radMaxLevel = this.riskAuditDefResultVWBL.getMaxRadlevel(form);
			if(StringUtils.isNotEmpty(radMaxLevel)) {
				dto.setRadMaxLevel(Integer.parseInt(radMaxLevel));
				List<Integer> list = new ArrayList<Integer>();
				for(int i = 1; i <= Integer.parseInt(radMaxLevel); i++) {
					list.add(i);
				}
				dto.setRadMaxLevelList(list);
			}
			CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
			
			cond.setCcid(IGRISCONSTANTS.RADRISKLEVEL_CODE);
			List<CodeDetail> radrisklevel = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadrisklevelList(radrisklevel);
			
			cond.setCcid(IGRISCONSTANTS.RADFREQUENCY_CODE);
			List<CodeDetail> radfrequency = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadfrequencyList(radfrequency);
			
			cond.setCcid(IGRISCONSTANTS.RADMODE_CODE);
			List<CodeDetail> radmode = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadmodeList(radmode);
			
			cond.setCcid(IGRISCONSTANTS.RADTYPE_CODE);
			List<CodeDetail> radtype = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRadtypeList(radtype);
			
			cond.setCcid(IGRISCONSTANTS.RARPLANSCORE_CODE);
			List<CodeDetail> rarplanscore = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRarplanscoreList(rarplanscore);
			
			cond.setCcid(IGRISCONSTANTS.RAREXECSCORE_CODE);
			List<CodeDetail> rarexecscore = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRarexecscoreList(rarexecscore);
			
			cond.setCcid(IGRISCONSTANTS.RAROVERALLSCORE_CODE);
			List<CodeDetail> raroverallscore = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			dto.setRaroverallscoreList(raroverallscore);
			/*//ͳ�Ƹ�����������,�ϲ���ʱ�����õ��������Ժ���
			Map<String, Integer> childCountMap = new HashMap<String, Integer>();
			for(RiskAuditDefResultVWInfo radrVWInfo : riskAuditDefResultVWInfoList) {
				if(StringUtils.isNotEmpty(radrVWInfo.getRadcode())) {
					if(childCountMap.containsKey(radrVWInfo.getRadcode())) {
						childCountMap.put(radrVWInfo.getRadcode(), childCountMap.get(radrVWInfo.getRadcode()) + 1);
					} else {
						childCountMap.put(radrVWInfo.getRadcode(), 1);
					}
					Set<Map.Entry<String,Integer>> set = childCountMap.entrySet();
					for(Iterator<Map.Entry<String,Integer>> iter = set.iterator();iter.hasNext();){
						Map.Entry<String,Integer> entry = iter.next();
						if(radrVWInfo.getRadcode().startsWith(entry.getKey())) {
							entry.setValue(entry.getValue() + 1);
						}
					}
					if(!childCountMap.containsKey(radrVWInfo.getRadcode())) {
						childCountMap.put(radrVWInfo.getRadcode(), 1);
					}
					
				}
			}
			dto.setChildCountMap(childCountMap);*/
		}
		
		dto.setRiskAuditDefResultVWInfoList(riskAuditDefResultVWInfoList);
		
		log.debug("========��Ʊ�����Ϣ��ѯ��������========");
		return dto;
	}
}
