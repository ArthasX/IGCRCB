/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.task.DealBL;
import com.csebank.lom.bl.task.DealOrgVWBL;
import com.csebank.lom.bl.task.DealVWBL;
import com.csebank.lom.bl.task.EentertainmentBL;
import com.csebank.lom.bl.task.GoutstockBL;
import com.csebank.lom.bl.task.LoanPayDetailBL;
import com.csebank.lom.bl.task.RecptionBL;
import com.csebank.lom.bl.task.RecptionGuestBL;
import com.csebank.lom.bl.task.RecptionOrgVWBL;
import com.csebank.lom.bl.task.RecptionVWBL;
import com.csebank.lom.dto.IGLOM01DTO;
import com.csebank.lom.form.IGLOM0101Form;
import com.csebank.lom.form.IGLOM0102Form;
import com.csebank.lom.form.IGLOM0103Form;
import com.csebank.lom.form.IGLOM0107Form;
import com.csebank.lom.form.IGLOM0115Form;
import com.csebank.lom.model.Deal;
import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.RecptionCost;
import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.RecptionGuestInfo;
import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.EentertainmentSearchCondImpl;
import com.csebank.lom.model.condition.GoutstockSearchCondImpl;
import com.csebank.lom.model.condition.RecptionGuestSearchCondImpl;
import com.csebank.lom.model.entity.DealTB;
import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;

/**
 *  �Ӵ�����BLʵ��
 */
public class IGLOM01BLImpl extends BaseBLImpl implements IGLOM01BL {
	
	static Log log = LogFactory.getLog(IGLOM01BLImpl.class);

	/** �Ӵ�����BL */
	protected RecptionBL recptionBL;
	protected DealBL dealBL;

	/** �Ӵ�����BL */
	protected RecptionGuestBL recptionGuestBL;

	/** �Ӵ�����BL */
	protected RecptionVWBL recptionVWBL;
	protected DealVWBL dealVWBL;

	/** ���ŽӴ�����BL */
	protected RecptionOrgVWBL recptionOrgVWBL;
	protected DealOrgVWBL dealOrgVWBL;
	
	/** ���BL */
	protected LoanPayDetailBL loanPayDetailBL;
	
	/** ʳ���д�BL */
	protected EentertainmentBL eentertainmentBL;
	
	/** ��Ʒ����BL */
	protected GoutstockBL goutstockBL;

	/**
	 * �Ӵ�����BL�趨
	 * @param recptionBL �Ӵ�����BL
	 */
	public void setRecptionBL(RecptionBL recptionBL) {
		this.recptionBL = recptionBL;
	}

	/**
	 * �Ӵ�����BL�趨
	 * @param recptionGuestBL �Ӵ�����BL
	 */
	public void setRecptionGuestBL(RecptionGuestBL recptionGuestBL) {
		this.recptionGuestBL = recptionGuestBL;
	}

	/**
	 * �Ӵ�����BL�趨 
	 * @param recptionVWBL �Ӵ�����BL
	 */
	public void setRecptionVWBL(RecptionVWBL recptionVWBL) {
		this.recptionVWBL = recptionVWBL;
	}

	/**
	 * ���ŽӴ�����BL�趨
	 * @param recptionOrgVWBL ���ŽӴ�����BL
	 */
	public void setRecptionOrgVWBL(RecptionOrgVWBL recptionOrgVWBL) {
		this.recptionOrgVWBL = recptionOrgVWBL;
	}

	/**
	 * ���BL�趨
	 * @param loanPayDetailBL ���BL
	 */
	public void setLoanPayDetailBL(LoanPayDetailBL loanPayDetailBL) {
		this.loanPayDetailBL = loanPayDetailBL;
	}

	/**
	 * ʳ���д�BL�趨
	 * @param eentertainmentBL ʳ���д�BL
	 */
	public void setEentertainmentBL(EentertainmentBL eentertainmentBL) {
		this.eentertainmentBL = eentertainmentBL;
	}

	/**
	 * ��Ʒ����BL�趨
	 * @param goutstockBL ��Ʒ����BL
	 */
	public void setGoutstockBL(GoutstockBL goutstockBL) {
		this.goutstockBL = goutstockBL;
	}

	/**
	 * �Ӵ����������ʾ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecption(IGLOM01DTO dto) throws BLException {

		log.debug("========�Ӵ�������������ʾ����ʼ========");	
		IGLOM0101Form form = dto.getIglom0101Form();
		Recption rp = recptionBL.searchRecptionByKey(form.getRid());
		
		//������ʾ�趨
		form.setRid(rp.getRid());
		form.setOrganizationTB(rp.getOrganizationTB());
		form.setRdescription(rp.getRdescription());
		form.setRetime(rp.getRetime());
		form.setRname(rp.getRname());
		form.setRpporg(rp.getRpporg());
		form.setRscale(rp.getRscale());
		form.setRstandard(rp.getRstandard());
		form.setRstime(rp.getRstime());
		form.setRdate(rp.getRdate());
		//���Ų����
		String rapporgid = rp.getRapporgid();
		form.setRapporgid(rapporgid);
		form.setRapporgname(rp.getOrganizationTB().getOrgname());
		form.setRlodgecost(rp.getRlodgecost());//ס�޷���
		form.setRlodgestandard(rp.getRlodgestandard());//ס�ޱ�׼
		//�����ʶ
		form.setMode("1");

		dto.setIglom0101Form(form);
		
		log.debug("========�Ӵ�������������ʾ��������========");
		return dto;
	}

	/**
	 * �Ӵ��Ǽ�����
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO insertRecptionAction(IGLOM01DTO dto) throws BLException {
		log.debug("========�Ӵ������ǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0101Form form = dto.getIglom0101Form();
		//״̬    ������:1
		form.setRstatus(IGLOMCONSTANTS.REC_STATUS_ENABLE);
		form.setRdate(IGStringUtils.getCurrentDate());
		//�Ӵ�������¼
		Recption rp = this.recptionBL.registRecption(dto.getIglom0101Form());
		form.setRid(rp.getRid());
		dto.setIglom0101Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�Ӵ�����") );

		log.debug("========�Ӵ������ǼǴ�������========");
		return dto;
	}

	/**
	 * �Ӵ���������
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO updateRecptionAction(IGLOM01DTO dto) throws BLException {
		
		log.debug("========�Ӵ������������ʼ========");
		
		//�Ӵ�������¼
		this.recptionBL.updateRecption(dto.getRecption());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�Ӵ�������Ϣ") );

		log.debug("========�Ӵ����������������========");
		
		return dto;
	}



	
	/**
	 * �Ӵ�������Ϣ��ѯ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionAction(IGLOM01DTO dto) throws BLException {

		log.debug("========�Ӵ�������Ϣ��ѯ����ʼ========");
		
		//�Ӵ�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.recptionBL.getSearchCount(dto.getRecptionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�Ӵ�������Ϣ��ѯ���ݲ�����========");
			//�Ӵ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�Ӵ�������Ϣ��ѯ���ݼ�������========");
			//�Ӵ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<RecptionAmount> recptionAmountList = this.recptionBL.searchRecptionAmount(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		List<Recption> recptionList = this.recptionBL.searchRecption(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setRecptionAmountList(recptionAmountList);
		dto.setRecptionList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�Ӵ�������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �Ӵ�����������Ϣ��ѯ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionCostAction(IGLOM01DTO dto) throws BLException {

		log.debug("========�Ӵ�����������Ϣ��ѯ����ʼ========");
		
		//�Ӵ�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.recptionBL.getRecptionCostCount(dto.getRecptionSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�Ӵ������ŷ���Ϣ��ѯ���ݲ�����========");
			//�Ӵ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�Ӵ������ŷ���Ϣ��ѯ���ݼ�������========");
			//�Ӵ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
//		List<Recption> recptionList = this.recptionBL.searchRecption(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		List<RecptionCost> recptionList = this.recptionBL.searchRecptionCost(dto.getRecptionSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());


		pDto.setTotalCount(totalCount);
		
//		dto.setRecptionList(recptionList);
		dto.setRecptionCostList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�Ӵ������ŷ���Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * �Ӵ�������������
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO changeRecptionAction(IGLOM01DTO dto) throws BLException {
		log.debug("========�Ӵ�������������ʼ========");
		IGLOM0103Form form = dto.getIglom0103Form();
		
		Recption rai = this.recptionBL.searchRecptionByKey(form.getRid());
		
		//���ƶ���
		RecptionTB pdTB = (RecptionTB)SerializationUtils.clone(rai);
		
		if(IGLOMCONSTANTS.REC_STATUS_ENABLE.equals(form.getRstatus())) {
			pdTB.setRstatus(IGLOMCONSTANTS.REC_STATUS_DISABLE);//����
			this.recptionBL.updateRecption(pdTB);
			log.debug("========����========");
			dto.addMessage(new ActionMessage("IGLOM0103.I001") );
		} 
		log.debug("========�Ӵ�����������������========");
		return dto;
	}

	/**
	 * �Ӵ�����ɾ������
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionAction(IGLOM01DTO dto) throws BLException {

		log.debug("========�Ӵ�������Ϣɾ������ʼ========");
		
		for( int i = 0; i < dto.getDeleteRid().length; i++){
			//�Ӵ�ID
			String rid = dto.getDeleteRid()[i];
			Recption rt = this.recptionBL.searchRecptionByKey(Integer.parseInt(rid));
			
//			//�жϽ�����Ƿ��������ϸ,������ϸ����ɾ��
//			LoanPayDetailSearchCondImpl lcond = new LoanPayDetailSearchCondImpl();
//			lcond.setRid_q(Integer.parseInt(rid));
//			int lline = this.loanPayDetailBL.getSearchCount(lcond);
//			if(lline > 0){
//				throw new BLException("IGLOM0103.E001", rt.getRname(), "���");
//			}
			
			//�ж�ʳ�ýӴ����Ƿ��������ϸ,������ϸ����ɾ��
			EentertainmentSearchCondImpl econd = new EentertainmentSearchCondImpl();
			econd.setRid_org(Integer.parseInt(rid));
			int eline = this.eentertainmentBL.getSearchCount(econd);
			if(eline > 0){
				throw new BLException("IGLOM0103.E001", rt.getRname(), "��ʳ�þͲ�");
			}
			
			//�ж���Ʒ���Ƿ��������ϸ,������ϸ����ɾ��
			GoutstockSearchCondImpl gcond = new GoutstockSearchCondImpl();
			gcond.setRid(Integer.parseInt(rid));
			int gline = this.goutstockBL.getSearchCount(gcond);
			if(gline > 0){
				throw new BLException("IGLOM0103.E001", rt.getRname(), "������Ʒ����");
			}
			
			
			
			//ɾ���Ӵ�����
			RecptionGuestSearchCondImpl cond = new RecptionGuestSearchCondImpl();
			cond.setRid(Integer.parseInt(rid));
			List<RecptionGuest> rgList = this.recptionGuestBL.searchRecptionGuest(cond, 0, 0);
			for(RecptionGuest rg : rgList) {
				this.recptionGuestBL.deleteRecptionGuest(rg.getRgid());
			}
			//ɾ���Ӵ�����
			this.recptionBL.deleteRecption(Integer.parseInt(rid));
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","�Ӵ�������Ϣ"));

		log.debug("========�Ӵ�������Ϣɾ���������========");
		
		return dto;
	}

	/**
	 * �Ӵ����˳�����ʾ����
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initRecptionGuest(IGLOM01DTO dto) throws BLException {

		log.debug("========�Ӵ����˱�����������ʾ����ʼ========");	
		IGLOM0102Form form = dto.getIglom0102Form();
		RecptionGuest rp = recptionGuestBL.searchRecptionGuestByKey(form.getRgid());
		if ( rp == null ){
			throw new BLException("IGCO10000.E004","�Ӵ�����");
		}
		
		//������ʾ�趨
		form.setRid(rp.getRid());
		form.setRgname(rp.getRgname());
		form.setRgpost(rp.getRgpost());
		form.setRgtel(rp.getRgtel());
		form.setRgunit(rp.getRgunit());
		form.setRgid(rp.getRgid());
		form.setRgdate(rp.getRgdate());
		//�����ʶ
		form.setMode("1");

		dto.setIglom0102Form(form);
		
		log.debug("========�Ӵ����˱�����������ʾ��������========");
		return dto;
	}

	/**
	 * �Ӵ����˵Ǽ�����
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO insertRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {
		
		log.debug("========�Ӵ����˵ǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0102Form form = dto.getIglom0102Form();
		//�Ǽ�ʱ��
		form.setRgdate(IGStringUtils.getCurrentDate());
		//�Ӵ����˵�¼
		this.recptionGuestBL.registRecptionGuest(dto.getIglom0102Form());
		
		dto.setIglom0102Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�Ӵ�������Ϣ") );

		log.debug("========�Ӵ����˵ǼǴ�������========");
		
		return dto;
		
	}

	/**
	 * �Ӵ�������Ϣ��ѯ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========�Ӵ�������Ϣ��ѯ����ʼ========");
		
		
		//�Ӵ�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.recptionGuestBL.getSearchCount(dto.getRecptionGuestSearchCond()); 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�Ӵ�������Ϣ��ѯ���ݼ�������========");
			//�Ӵ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<RecptionGuest> recptionGuestList = this.recptionGuestBL.searchRecptionGuest(dto.getRecptionGuestSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		//�Ӵ�������Ϣȡ��
		Recption recptionData = this.recptionBL.searchRecptionByKey(dto.getRecptionGuestSearchCond().getRid());

		pDto.setTotalCount(totalCount);
		
		dto.setRecptionGuestList(recptionGuestList);
		dto.setRecptionData(recptionData);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�Ӵ�������Ϣ��ѯ��������========");
		
		return dto;
		
	}

	/**
	 * �Ӵ����˸���
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO updateRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {
		
		log.debug("========�Ӵ����˱������ʼ========");
		
		//�Ӵ����˵�¼
		this.recptionGuestBL.updateRecptionGuest(dto.getRecptionGuest());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�Ӵ�������Ϣ") );

		log.debug("========�Ӵ����˱����������========");
		
		return dto;
	}

	/**
	 * �Ӵ�����ɾ������
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO deleteRecptionGuestAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========�Ӵ�������Ϣɾ������ʼ========");
		
		for( int i = 0; i < dto.getDeleteRgid().length; i++){
			
			String rgid = dto.getDeleteRgid()[i];
			//ɾ���Ӵ�����
			this.recptionGuestBL.deleteRecptionGuest(Integer.parseInt(rgid));
			
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","�Ӵ�������Ϣ"));

		log.debug("========�Ӵ�������Ϣɾ���������========");
		
		return dto;
	}

	/**
	 * �Ӵ�ͳ����Ϣ��ѯ
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionVWAction(IGLOM01DTO dto) throws BLException {

		log.debug("========�Ӵ�ͳ����Ϣ��ѯ����ʼ========");


		//��ǰҳ��Ϣȡ��
		List<RecptionVWInfo> recptionList = this.recptionVWBL.searchRecptionVW(dto.getRecptionVWSearchCond(), 0, 0);
	
		dto.setRecptionVWList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========�Ӵ�ͳ����Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * ���ŽӴ�ͳ��
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionOrgVWAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========���ŽӴ�ͳ����Ϣ��ѯ����ʼ========");

		//��ǰҳ��Ϣȡ��
		List<RecptionOrg> recptionOrgList = this.recptionOrgVWBL.searchRecptionOrgVW(dto.getRecptionOrgVWSearchCond(), 0, 0);
	
		dto.setRecptionOrgVWList(recptionOrgList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========���ŽӴ�ͳ����Ϣ��ѯ��������========");
		return dto;
	}


	
	/**
	 * �Ӵ����˲�ѯ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionGuestInfoAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========�Ӵ�������Ϣ��ѯ����ʼ========");
      
		int totalCount = this.recptionGuestBL.getSearchCount(dto.getRecptionGuestInfoCond());
		
		if (totalCount == 0) {
			log.debug("========�Ӵ�������Ϣ��ѯ���ݲ�����========");
			//�ӿ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�Ӵ�������Ϣ��ѯ���ݼ�������========");
			//�Ӵ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}


		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<RecptionGuestInfo> recptionGuestList = this.recptionGuestBL.searchRecptionGuestInfo(dto.getRecptionGuestInfoCond(), pDto.getFromCount(), pDto.getPageDispCount());
        pDto.setTotalCount(totalCount);
		
		dto.setRecptionGuestInfoList(recptionGuestList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�Ӵ����˲�ѯ��������========");
		return dto;
		
	}
	
	/**
	 * ���ݿͻ���Ϣ��ѯ�Ӵ�������Ϣ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchRecptionByGusetAction(IGLOM01DTO dto) throws BLException {

		log.debug("========���ݿͻ���Ϣ��ѯ�Ӵ�������Ϣ����ʼ========");
		
		//�Ӵ�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.recptionBL.getRecptionSearchCount(dto.getRecptionGuestInfoCond());
		
		if (totalCount == 0) {
			log.debug("========�Ӵ�������Ϣ��ѯ���ݲ�����========");
			//�Ӵ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�Ӵ�������Ϣ��ѯ���ݼ�������========");
			//�Ӵ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<GuestRecption> recptionList = this.recptionBL.searchRecptionByGuset(dto.getRecptionGuestInfoCond(), pDto.getFromCount(), pDto.getPageDispCount());


		pDto.setTotalCount(totalCount);
		
//		dto.setRecptionList(recptionList);
		dto.setGuestRecptionList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========���ݿͻ���Ϣ��ѯ�Ӵ�������Ϣ��������========");
		return dto;
	}
	/**
	 * ��������Ͳ�ͳ��
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchDealOrgVWAction(IGLOM01DTO dto)
			throws BLException {

		log.debug("========��������Ͳ�ͳ����Ϣ��ѯ����ʼ========");

		//��ǰҳ��Ϣȡ��
		List<DealOrg> dealOrgList = this.dealOrgVWBL.searchDealOrgVW(dto.getDealOrgVWSearchCond(), 0, 0);
	
		dto.setDealOrgVWList(dealOrgList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========��������Ͳ�ͳ����Ϣ��ѯ��������========");
		return dto;
	}
	public IGLOM01DTO deleteDealAction(IGLOM01DTO dto)throws BLException{
        log.debug("========����Ͳ���Ϣɾ������ʼ========");
     
		for( int i = 0; i < dto.getDeleteRid().length; i++){
			 //�Ӵ�ID
			String rid = dto.getDeleteRid()[i];
			this.dealBL.searchDealByKey(Integer.parseInt(rid));
	      //�ж���Ʒ���Ƿ��������ϸ,������ϸ����ɾ��
			GoutstockSearchCondImpl gcond = new GoutstockSearchCondImpl();
			gcond.setRid(Integer.parseInt(rid));
			int gline = this.goutstockBL.getSearchCount(gcond);
			if(gline > 0){
				throw new BLException("IGLOM0107.E001", "", "��Ʒ");
			}

			//ɾ���Ӵ�����
			this.dealBL.deleteDeal(Integer.parseInt(rid));
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","����Ͳ���Ϣ"));

		log.debug("========����Ͳ���Ϣɾ���������========");
		
		return dto;
	}
	/**
	 * ����Ͳͱ��������ʾ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO initDeal(IGLOM01DTO dto) throws BLException {

		log.debug("========����Ͳͱ�����������ʾ����ʼ========");	
		IGLOM0115Form form = dto.getIglom0115Form();
		Deal rp = dealBL.searchDealByKey(form.getRid());
		
		//������ʾ�趨
		form.setRid(rp.getRid());
		form.setOrganizationTB(rp.getOrganizationTB());
		form.setDealCash(rp.getDealCash());
		form.setDealDesc(rp.getDealDesc());
		form.setDealScale(rp.getDealScale());
		form.setDealTime(rp.getDealTime());
		form.setDeptName(rp.getDeptName());
		form.setInvoiceNumber(rp.getInvoiceNumber());
		form.setOtherJoiner(rp.getOtherJoiner());
		form.setRapporgid(rp.getRapporgid());

		//�����ʶ
		form.setMode("1");

		dto.setIglom0115Form(form);
		
		log.debug("========����Ͳͱ�����������ʾ��������========");
		return dto;
	}
	/**
	 * ����Ͳ���Ϣ�����ѯ
	 * 
	 */
	public IGLOM01DTO searchDealInfo(IGLOM01DTO dto) throws BLException {
	log.debug("========�Ӵ�������Ϣ��ѯ����ʼ========");
		
		//�Ӵ�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.dealBL.getSearchCount(dto.getDealSearchCond());
		
		if (totalCount == 0) {
			log.debug("========����Ͳ���Ϣ��ѯ���ݲ�����========");
			//�Ӵ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========����Ͳ���Ϣ��ѯ���ݼ�������========");
			//�Ӵ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<Deal> dealList = this.dealBL.searchDeal(dto.getDealSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());


		pDto.setTotalCount(totalCount);
		
		dto.setDealList(dealList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========����Ͳ���Ϣ��ѯ��������========");
		return dto;
	}
	public IGLOM01DTO changeDealAction(IGLOM01DTO dto) throws BLException{
		log.debug("========����Ͳ͹�����������ʼ========");
		IGLOM0107Form form = dto.getIglom0107Form();
		
		Deal rai = this.dealBL.searchDealByKey(form.getRid());
		
		//���ƶ���
		DealTB pdTB = (DealTB)SerializationUtils.clone(rai);
		
		if(IGLOMCONSTANTS.REC_STATUS_ENABLE.equals(form.getRstatus())) {
			pdTB.setRstatus(IGLOMCONSTANTS.REC_STATUS_DISABLE);//����
			this.dealBL.updateDeal(pdTB);
			log.debug("========����========");
			dto.addMessage(new ActionMessage("IGLOM0103.I001") );
		} 
		log.debug("========����Ͳ͹���������������========");
		return dto;
	}
	/**
     * ����Ͳ͵Ǽ���Ϣ��⴦��
     * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
     */
	public IGLOM01DTO insetDealInfo(IGLOM01DTO dto)throws BLException{
		log.debug("========����Ͳ���Ϣ�ǼǴ���ʼ========");
		IGLOM0115Form form = dto.getIglom0115Form();//��ȡ����Ͳ͵Ǽ���Ϣform
		form.setRstatus(IGLOMCONSTANTS.REC_STATUS_ENABLE);//����״̬Ϊ1
		Deal deal=this.dealBL.insertDealInfo(form);
		form.setRid(deal.getRid());
		dto.setIglom0115Form(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����Ͳ�") );
		log.debug("=============����Ͳ���Ϣ�Ǽ����=========");
		return dto;
	}
	/**
	 * ����Ͳ�ͳ����Ϣ��ѯ
	 * 
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO searchDealVWAction(IGLOM01DTO dto) throws BLException {

		log.debug("========����Ͳ�ͳ����Ϣ��ѯ����ʼ========");


		//��ǰҳ��Ϣȡ��
		List<DealVWInfo> recptionList = this.dealVWBL.searchDealVW(dto.getDealVWSearchCond(), 0, 0);
	
		dto.setDealVWList(recptionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",""));
		
		log.debug("========����Ͳ�ͳ����Ϣ��ѯ��������========");
		return dto;
	}
	/**
	 * ����Ͳ͹�������
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM01DTO updateDealAction(IGLOM01DTO dto) throws BLException {
		
		log.debug("========����Ͳ͹����������ʼ========");
		
		//�Ӵ�������¼
		this.dealBL.updateDeal(dto.getDeal());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "����Ͳ���Ϣ") );

		log.debug("========����Ͳ͹��������������========");
		
		return dto;
	}

	public DealBL getDealBL() {
		return dealBL;
	}

	public void setDealBL(DealBL dealBL) {
		this.dealBL = dealBL;
	}

	public DealVWBL getDealVWBL() {
		return dealVWBL;
	}

	public void setDealVWBL(DealVWBL dealVWBL) {
		this.dealVWBL = dealVWBL;
	}

	public DealOrgVWBL getDealOrgVWBL() {
		return dealOrgVWBL;
	}

	public void setDealOrgVWBL(DealOrgVWBL dealOrgVWBL) {
		this.dealOrgVWBL = dealOrgVWBL;
	}
}
