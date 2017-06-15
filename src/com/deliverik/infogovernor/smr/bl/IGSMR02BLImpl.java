/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0201Form;
import com.deliverik.infogovernor.smr.form.IGSMR0202Form;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
 * �������ҵ���߼�ʵ��
 *
 */
public class IGSMR02BLImpl  extends BaseBLImpl implements IGSMR02BL{

	static Log log = LogFactory.getLog(IGSMR02BLImpl.class);
	
	/** �������BL */
	protected ApproveSuggestionBL approveSuggestionBL;
	
	/** ��������ϢBL */
	protected IG500BL ig500BL;
	
	/** ����ϢBL */
	protected IG007BL ig007BL;
	
	/**
	 * �������BL�趨
	 *
	 * @param approveSuggestionBL �������BL
	 */
	public void setApproveSuggestionBL(ApproveSuggestionBL approveSuggestionBL) {
		this.approveSuggestionBL = approveSuggestionBL;
	}
	
	/**
	 * ��������ϢBL�趨
	 *
	 * @param ig500BL ��������ϢBL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * ����ϢBL�趨
	 *
	 * @param ig007BL ����ϢBL
	 */
	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	/**
	 * ������Ч���������Ϣ��ѯ����
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestion(IGSMR02DTO dto) throws BLException{
		log.debug("=========���������ѯ����ʼ=========");
		IGSMR0201Form form = dto.getIgSMR0201Form();
		
		//��ѯ������Ϣ
		IG500Info ig500Info = this.ig500BL.searchIG500InfoByKey(form.getPrid());
		dto.setIg500Info(ig500Info);
		
		//��ѯ����Ϣ
		dto.setPidname(this.ig007BL.searchIG007InfoByKey(form.getPidid()).getPidname());
		
		// ��ȡ��ѯ����
		ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
		cond.setPrid_eq(form.getPrid());
		cond.setPidid_eq(form.getPidid());
		cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);
		cond.setPsdcode_eq(ig500Info.getPrstatus());
		cond.setRownumber_eq(form.getRownumber());
		
		// ��ѯĳ��������Ч���������
		List<ApproveSuggestionInfo> lstApprove = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
		if(lstApprove != null && lstApprove.size() > 0){
			dto.setApproveSuggestionInfo(lstApprove.get(0));
		}
		
		log.debug("=========���������ѯ�������=========");
		return dto;
	}
	
	/**
	 * ���������������Ϣ��ѯ����
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestionAllByPidid(IGSMR02DTO dto) throws BLException{
		log.debug("=========���������ѯ����ʼ=========");
		IGSMR0202Form form = dto.getIgSMR0202Form();
		
		// ��ȡ��ѯ����
		ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
		cond.setPrid_eq(form.getPrid());
		cond.setPidid_eq(form.getPidid());
		cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);
		cond.setRownumber_eq(form.getRownumber());
		
		// ��ѯĳ�����������������
		List<ApproveSuggestionInfo> lstApprove = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
		dto.setLstApproveSuggestionInfo(lstApprove);
		
		//��ѯ������Ϣ
		IG500Info ig500Info = this.ig500BL.searchIG500InfoByKey(form.getPrid());
		dto.setIg500Info(ig500Info);
		
		log.debug("=========���������ѯ�������=========");
		return dto;
	}
	
	/**
	 * ����������淽��
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO saveApproveSuggestion(IGSMR02DTO dto) throws BLException{
		log.debug("=========����������洦��ʼ=========");
		// ��ȡ��¼�û�
		User user = dto.getUser();
		// ��ȡ�������Form
		IGSMR0201Form form = dto.getIgSMR0201Form();
		
		// ��ȡ�������ʵ��
		ApproveSuggestionTB instance = this.approveSuggestionBL.getApproveSuggestionTBInstance();
		
		if(form.getId() != null && form.getId() != 0){
			instance.setId(form.getId()); // �����������
		}
		
		instance.setPidid(form.getPidid());// ����������
		instance.setPrid(form.getPrid());
		instance.setPsdcode(form.getPsdcode());//״̬��ʶ
		instance.setPsdname(form.getPsdname());//״̬����
		instance.setStatus(IGSMRCONSTANT.APPROVE_STATUS_YES);//���״̬
		instance.setSuggestion(form.getSuggestion());//�����Ϣ
		instance.setUserid(user.getUserid());//�������û�ID
		instance.setUsername(user.getUsername());//����������
		instance.setInserttime(IGStringUtils.getCurrentDateTime());//����ʱ��
		instance.setRownumber(form.getRownumber());
		// �����������
		ApproveSuggestionInfo approveSuggestionInfo = null;
		if(form.getId() != null && form.getId() > 0){
			instance.setId(form.getId()); // �����������
			if(StringUtils.isNotEmpty(form.getSuggestion())) {
				approveSuggestionInfo = this.approveSuggestionBL.updateApproveSuggestionInfo(instance);
			} else {
				this.approveSuggestionBL.deleteApproveSuggestionInfoByPK(form.getId());
			}
		} else {
			if(StringUtils.isNotEmpty(form.getSuggestion())) {
				approveSuggestionInfo = this.approveSuggestionBL.registApproveSuggestionInfo(instance);
			}
		}
		
		dto.setApproveSuggestionInfo(approveSuggestionInfo);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "�����������") );
		
		log.debug("=========����������洦�����=========");
		return dto;
	}
}
