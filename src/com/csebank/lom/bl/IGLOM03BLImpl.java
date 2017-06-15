/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.csebank.lom.bl.task.AdvanCescostBL;
import com.csebank.lom.bl.task.AdvanceDetailVWBL;
import com.csebank.lom.bl.task.AdvanceSummaryBL;
import com.csebank.lom.bl.task.LoanPayDetailBL;
import com.csebank.lom.bl.task.PersonLoanDetailVWBL;
import com.csebank.lom.bl.task.PersonLoanSummaryVWBL;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0301Form;
import com.csebank.lom.form.IGLOM0303Form;
import com.csebank.lom.form.IGLOM0304Form;
import com.csebank.lom.form.IGLOM0307Form;
import com.csebank.lom.form.IGLOM0313Form;
import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.condition.AdvanCescostSearchCondImpl;
import com.csebank.lom.model.condition.AdvanceSummarySearchCondImpl;
import com.csebank.lom.model.condition.LoanPayDetailSearchCondImpl;
import com.csebank.lom.model.entity.AdvanCescostTB;
import com.csebank.lom.model.entity.AdvanceSummaryTB;
import com.csebank.lom.model.entity.LoanPayDetailTB;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;

/**
 *  Ԥ֧����BLʵ��
 */
public class IGLOM03BLImpl extends BaseBLImpl implements IGLOM03BL {
	
	static Log log = LogFactory.getLog(IGLOM03BLImpl.class);

	/** Ԥ֧����BL */
	protected AdvanCescostBL advanCescostBL;
	
	/** �軹��BL */
	protected LoanPayDetailBL loanPayDetailBL;
	
	/** Ԥ֧����BL */
	protected AdvanceSummaryBL advanceSummaryBL;
	
	/** Ԥ֧��Աͳ��BL */
	protected PersonLoanSummaryVWBL personLoanSummaryVWBL;
	
	/** ��Ա�����ϸBL */
	protected PersonLoanDetailVWBL personLoanDetailVWBL;
	
	/** Ԥ֧��ϸBL */
	protected AdvanceDetailVWBL advanceDetailVWBL;

	/**
	 * Ԥ֧����BL�趨
	 * @param advanCescostBL Ԥ֧����BL
	 */
	public void setAdvanCescostBL(AdvanCescostBL advanCescostBL) {
		this.advanCescostBL = advanCescostBL;
	}
	
	/**
	 * �軹��BL�趨
	 * @param loanPayDetailBL
	 */
	public void setLoanPayDetailBL(LoanPayDetailBL loanPayDetailBL) {
		this.loanPayDetailBL = loanPayDetailBL;
	}
	
	/**
	 * Ԥ֧����BL�趨
	 * @param advanceSummaryBL
	 */
	public void setAdvanceSummaryBL(AdvanceSummaryBL advanceSummaryBL) {
		this.advanceSummaryBL = advanceSummaryBL;
	}
	
	/**
	 * Ԥ֧��Աͳ���趨
	 * @param personLoanSummaryVWBL
	 */
	public void setPersonLoanSummaryVWBL(PersonLoanSummaryVWBL personLoanSummaryVWBL) {
		this.personLoanSummaryVWBL = personLoanSummaryVWBL;
	}
	
	/**
	 * ��Ա�����ϸBL�趨
	 * @param personLoanDetailVWBL
	 */
	public void setPersonLoanDetailVWBL(PersonLoanDetailVWBL personLoanDetailVWBL) {
		this.personLoanDetailVWBL = personLoanDetailVWBL;
	}
	
	/**
	 * Ԥ֧��ϸBL�趨
	 * @param advanceDetailVWBL
	 */
	public void setAdvanceDetailVWBL(AdvanceDetailVWBL advanceDetailVWBL) {
		this.advanceDetailVWBL = advanceDetailVWBL;
	}

	/**
	 * Ԥ֧���ñ��������ʾ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO initAdvanCescostAction(IGLOM03DTO dto) throws BLException {

		log.debug("========Ԥ֧���ñ�����������ʾ����ʼ========");	
		IGLOM0301Form form = dto.getIglom0301Form();
		AdvanCescost ac = advanCescostBL.searchAdvanCescostByKey(form.getAcid());
		
		//������ʾ�趨
		form.setAcamount(ac.getAcamount());
		form.setAcdate(ac.getAcdate());
		form.setActype(ac.getActype());
		form.setAcchequenum(ac.getAcchequenum());
		form.setAcserial(ac.getAcserial());
		form.setAccomment(ac.getAccomment());
		form.setAcstatus(ac.getAcstatus());
		form.setAcfreezeamount(ac.getAcfreezeamount());
		
		//�����ʶ
		form.setMode("1");

		dto.setIglom0301Form(form);
		
		log.debug("========Ԥ֧���ñ�����������ʾ��������========");
		return dto;
	}

	/**
	 * Ԥ֧���õǼ�����
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO insertAdvanCescostAction(IGLOM03DTO dto) throws BLException {
		log.debug("========Ԥ֧���õǼǴ���ʼ========");
		//����Formȡ��
		IGLOM0301Form form = dto.getIglom0301Form();
		//����ʱΪ����
		if(form.getAcamount().doubleValue() < 0 ) {
			form.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_ADJUST);
		} else {
			form.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_UNCREDIT);
		}
		form.setAcinsdate(IGStringUtils.getCurrentDate());
		form.setAcinstime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
		form.setAcfreezeamount(new BigDecimal(0));
		form.setAcinvoiceamount(new BigDecimal(0));
		//Ԥ֧���õ�¼
		AdvanCescost ac = this.advanCescostBL.registAdvanCescost(form);
		
		//�޸�Ԥ֧������Ϣ
		this.advanceSummaryBL.insertAdvanCescost(ac);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "Ԥ֧����") );

		log.debug("========Ԥ֧���õǼǴ�������========");
		return dto;
	}

	/**
	 * Ԥ֧���ø���
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO updateAdvanCescostAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========Ԥ֧���ñ������ʼ========");
		
		IGLOM0301Form form = dto.getIglom0301Form();
		
		AdvanCescost ac = this.advanCescostBL.searchAdvanCescostByKey(form.getAcid());
		
		AdvanCescostTB acTB = (AdvanCescostTB)SerializationUtils.clone(ac);
//		//������ʱ�����ӽ�����޸�״̬Ϊ����
//		if(IGLOMCONSTANTS.ADVANCESCOST_STATUS_DISABLE.equals(acTB.getAcstatus())) {
//			if(form.getAcamount() > acTB.getAcamount()) {
//				acTB.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_ENABLE);
//			}
//		}
//		//���ٽ��ܴ��ڶ�����
//		if(form.getAcamount() < acTB.getAcfreezeamount()) {
//			throw new BLException("IGLOM0301.E001" , acTB.getAcfreezeamount().toString());  
//		}
		
		acTB.setAcamount(form.getAcamount());
		acTB.setAcdate(form.getAcdate());
		acTB.setActype(form.getActype());
		acTB.setAcchequenum(form.getAcchequenum());
		acTB.setAccomment(form.getAccomment());
		
		//Ԥ֧���õ�¼
		this.advanCescostBL.updateAdvanCescost(acTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "Ԥ֧������Ϣ") );

		log.debug("========Ԥ֧���ñ����������========");
		
		return dto;
	}



	
	/**
	 * Ԥ֧������Ϣ��ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvanCescostAction(IGLOM03DTO dto) throws BLException {

		log.debug("========Ԥ֧������Ϣ��ѯ����ʼ========");
		
		//Ԥ֧������Ϣ��ѯ����ȡ�� 
		int totalCount = this.advanCescostBL.getSearchCount(dto.getAdvanCescostSearchCond());
		
		if (totalCount == 0) {
			log.debug("========Ԥ֧������Ϣ��ѯ���ݲ�����========");
			//Ԥ֧������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ԥ֧������Ϣ��ѯ���ݼ�������========");
			//Ԥ֧������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<AdvanCescost> advanCescostList = this.advanCescostBL.searchAdvanCescost(dto.getAdvanCescostSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		
		dto.setAdvanCescostList(advanCescostList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========Ԥ֧������Ϣ��ѯ��������========");
		return dto;
	}

	/**
	 * Ԥ֧����ɾ������
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteAdvanCescostAction(IGLOM03DTO dto) throws BLException {

		log.debug("========Ԥ֧������Ϣɾ������ʼ========");
		
		for( int i = 0; i < dto.getDeleteAcid().length; i++){
			
			String acid = dto.getDeleteAcid()[i];
			//ɾ��Ԥ֧����
			this.advanCescostBL.deleteAdvanCescost(Integer.parseInt(acid));
			
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","Ԥ֧������Ϣ"));

		log.debug("========Ԥ֧������Ϣɾ���������========");
		
		return dto;
	}





	/**
	 * ��������ʾ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO initLoanPayDetailAction(IGLOM03DTO dto) throws BLException {

		log.debug("========���������ʾ����ʼ========");	
		IGLOM0303Form form = dto.getIglom0303Form();
		LoanPayDetail rp = loanPayDetailBL.searchLoanPayDetailByKey(form.getLpdid());
		
		//������ʾ�趨
		form.setLpdamount(rp.getLpdamount());
		form.setLpdcomment(rp.getLpdcomment());
		form.setLpddate(rp.getLpddate());
		form.setLpdstatus(rp.getLpdstatus());
		form.setLpdtype(rp.getLpdtype());
		form.setLpduser(rp.getLpduser());
		
		//�����ʶ
		form.setMode("1");

		dto.setIglom0303Form(form);
		
		log.debug("========���������ʾ��������========");
		return dto;
	}
	
	/**
	 * ���ý��ȡ��
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAvailableAmountAction(IGLOM03DTO dto) throws BLException {
		log.debug("========���ý��ȡ�ô���ʼ========");
		dto.setAvailableAmount(this.advanceSummaryBL.searchAvailableAmount());
		log.debug("========���ý��ȡ�ô�������========");
		return dto;
	}

	/**
	 * �����������
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO insertLoanPayDetailAction(IGLOM03DTO dto) throws BLException {
		log.debug("========������봦��ʼ========");
		
		//����Formȡ��
		IGLOM0303Form form = dto.getIglom0303Form();

		//��ȡ���ý��
		BigDecimal enable = this.advanceSummaryBL.searchAvailableAmount();
		
		//�����ܴ��ڿ��ý��
		if(form.getLpdamount().doubleValue() > enable.doubleValue()) {
			throw new BLException("IGLOM0304.E001" , enable.toString());  
		}
		
		//״̬������    (���ʱ: 0:��ȷ�� 1:������ 2:������ͨ�� 3:����δͨ�� 4:�ѻ��� 5:�ѳ��)
		form.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_DAISHENPI);
		//�軹������  (0:��� 1:�ֽ𻹿� 2:֧Ʊ����)
		form.setLpdtype(IGLOMCONSTANTS.LPD_TYPE_LOAN);
		
		form.setLpddate(IGStringUtils.getCurrentDate());
		
		form.setLpdtime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
		//����¼
		LoanPayDetail loanPayDetail = this.loanPayDetailBL.registLoanPayDetail(dto.getIglom0303Form());
		
		//�޸�Ԥ֧������Ϣ
		this.advanceSummaryBL.loan(loanPayDetail);
		
		form.setLpdid(loanPayDetail.getLpdid());
		
		dto.setIglom0303Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�����Ϣ") );

		log.debug("========������봦������========");
		return dto;
	}

	
	/**
	 * �����Ϣ��ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailAction(IGLOM03DTO dto) throws BLException {

		log.debug("========�����Ϣ��ѯ����ʼ========");
		
		//�����Ϣ��ѯȡ�� 
		int totalCount = this.loanPayDetailBL.getSearchCount(dto.getLoanPayDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========�����Ϣ��ѯ���ݲ�����========");
			//�����Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�����Ϣ��ѯ���ݼ�������========");
			//�����Ϣ��ѯ���ݹ���
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<LoanPayDetail> loanPayDetailList = this.loanPayDetailBL.searchLoanPayDetail(dto.getLoanPayDetailSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		
		dto.setLoanPayDetailList(loanPayDetailList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �����Ϣ��ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailNoPagingAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========�����Ϣ��ѯ����ʼ========");
		
		//��ǰҳ��Ϣȡ��
		List<LoanPayDetail> loanPayDetailList = this.loanPayDetailBL.searchLoanPayDetail(dto.getLoanPayDetailSearchCond(), 0, 0);
		
		dto.setLoanPayDetailList(loanPayDetailList);
		
		log.debug("========�����Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ּƲƲ������ܴ���
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailSummaryAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========��ּƲƲ����Ԥ֧�����б��ѯ����ʼ========");
		
		IGLOM0307Form form = dto.getIglom0307Form();
		
		//���ܽ��
		String[] deleteLpdid = form.getDeleteLpdid();
		
		if(deleteLpdid == null) {
			throw new BLException("IGCO10000.E004","��ּƲƲ�����¼");
		}
		BigDecimal money = new BigDecimal(0);
		for(String lpdid : deleteLpdid) {
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			money = LOMHelper.getAdd(money, lpd.getLpdinvoiceamount());
		}
		form.setMoney(money);
		
		//��ѯδ���Ԥ֧����
		AdvanCescostSearchCondImpl cond = new AdvanCescostSearchCondImpl();
		
		cond.setAcstatus_q(IGLOMCONSTANTS.ADVANCESCOST_STATUS_UNCREDIT);
		
		//��ǰҳ��Ϣȡ��
		List<AdvanCescost> advanCescostList = this.advanCescostBL.searchAdvanCescost(cond, 0, 0);
		
		dto.setAdvanCescostList(advanCescostList);
		
		log.debug("========��ּƲƲ����Ԥ֧�����б��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��ּƲƲ�����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO loanPayDetailCredit(IGLOM03DTO dto) throws BLException {

		log.debug("========��ּƲƲ�����ʼ========");
		
		IGLOM0307Form form = dto.getIglom0307Form();
		
		//Ԥ֧���ü�¼
		AdvanCescost ac = this.advanCescostBL.searchAdvanCescostByKey(form.getAcid());
		
		//�޸�Ԥ֧����״̬Ϊ�ѳ��
		AdvanCescostTB acTB = (AdvanCescostTB)SerializationUtils.clone(ac);
		//�ѳ��
		acTB.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_CREDIT);
		//�����ֽ��� = Ԥ֧��� - ���Ʊ���
		acTB.setAcfreezeamount(LOMHelper.getSubtract(ac.getAcamount(),form.getMoney()));
		//���Ʊ���
		acTB.setAcinvoiceamount(form.getMoney());
		//�������
		acTB.setAccreditdate(IGStringUtils.getCurrentDate());

		this.advanceSummaryBL.credit(acTB);
		//�����
		//acTB.setAcstockamount(this.advanceSummaryBL.searchStockAmount());
		
		this.advanCescostBL.updateAdvanCescost(acTB);
		
		//�޸Ļ����¼״̬Ϊ�ѳ��
		String[] deleteLpdid = form.getDeleteLpdid();
		
		if(deleteLpdid == null) {
			throw new BLException("IGCO10000.E004","��ּƲƲ�����¼");
		}
		
		for(String lpdid : deleteLpdid) {
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(lpd);
			//�ѳ��
			lpdTB.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_CREDIT);
			//Ԥ֧����ID
			lpdTB.setAcid(ac.getAcid());
			//�����
			//lpdTB.setLpdstockamount(this.advanceSummaryBL.searchStockAmount());
			this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		}
		
		//����Ʊ���С��Ԥ֧���ʱ���Զ�׷��һ�����Ϊ������Ԥ֧��¼�����Ϊ�۳��Ľ�״̬Ϊ�ֽ���
		if(acTB.getAcfreezeamount().doubleValue() > 0) {
			AdvanCescostTB acTBInstance = new AdvanCescostTB();
			/** Ԥ֧��� */
			acTBInstance.setAcamount(acTB.getAcfreezeamount().multiply(new BigDecimal(-1)));
			
			/** �ƲƼ������� */
			acTBInstance.setAcdate(IGStringUtils.getCurrentDate());
			
			/** Ԥ֧��ʽ */
			acTBInstance.setActype(IGLOMCONSTANTS.ADVANCESCOST_TYPE_CASH);
			
			/** Ԥ֧״̬ */
			acTBInstance.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_CASH_CREDIT);
			
			/** ����� */
			acTBInstance.setAcstockamount(this.advanceSummaryBL.searchStockAmount());
			
			/** Ԥ֧������� */
			acTBInstance.setAccreditdate(IGStringUtils.getCurrentDate());
			
			/** �Ǽ���ID */
			acTBInstance.setAcuserid(dto.getUserid());
			
			/** �Ǽ������� */
			acTBInstance.setAcusername(dto.getUsername());
			
			/** Ԥ֧�Ǽ����� */
			acTBInstance.setAcinsdate(IGStringUtils.getCurrentDate());
			
			/** Ԥ֧�Ǽ�ʱ�� */
			acTBInstance.setAcinstime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
			
			this.advanCescostBL.registAdvanCescost(acTBInstance);
		}
		
		dto.addMessage(new ActionMessage("IGLOM0307.I001"));
		
		log.debug("========��ּƲƲ���������========");
		return dto;
	}

	/**
	 * �����������
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO changeLoanPayDetailAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========�����������ʼ========");

		//ȡ��form
		IGLOM0304Form form = dto.getIglom0304Form();
		
		//���״̬ȡ��
		String lpdstatus = form.getLpdstatus();
		
		for( int i = 0; i < dto.getDeleteLpdid().length; i++){

			//��ǰ���ID
			String lpdid = dto.getDeleteLpdid()[i];
			
			//��ǰ���û��ܶ�����Ϊ�ֶ�����-�����
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			
			LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(lpd);
			
			//��ȡҪִ�еĽ��״̬
			lpdTB.setLpdstatus(form.getLpdstatus());
			
			if(IGLOMCONSTANTS.LPD_STATUS_YITONGGUO.equals(lpdstatus)){
				//����ͨ��ʱ������������Ϣ
				lpdTB.setLpdpersion(dto.getUserid());
				lpdTB.setLpdpersionname(dto.getUsername());
				this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
				this.advanceSummaryBL.approveYes(lpd);
				
			}else if(IGLOMCONSTANTS.LPD_STATUS_WEITONGGUO.equals(lpdstatus)){
				//����δͨ��ʱ������������Ϣ
				lpdTB.setLpdpersion(dto.getUserid());
				lpdTB.setLpdpersionname(dto.getUsername());
				this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
				this.advanceSummaryBL.approveNo(lpd);
				
			}else if(IGLOMCONSTANTS.LPD_STATUS_YIQUEREN.equals(lpdstatus)){
				//ȷ��ʱ����
				this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
			}
			
		}
		
		//��Ӵ�������Ϣ
		if(IGLOMCONSTANTS.LPD_STATUS_YITONGGUO.equals(lpdstatus)){//����ͨ��
			dto.addMessage(new ActionMessage( "IGLOM0202.I001", "�������") );
			
		}else if(IGLOMCONSTANTS.LPD_STATUS_WEITONGGUO.equals(lpdstatus)){//����δͨ��
			dto.addMessage(new ActionMessage( "IGLOM0202.I001", "�������δͨ��") );
			
		}else if(IGLOMCONSTANTS.LPD_STATUS_YIQUEREN.equals(lpdstatus)){//ȷ��
			dto.addMessage(new ActionMessage( "IGLOM0202.I001", "���ȷ��") );
		}

		log.debug("========���������������========");
		
		return dto;
	}

	/**
	 * ���ɾ������
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteLoanPayDetailAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========�����Ϣɾ������ʼ========");
		
		//ֻ�д�����״̬����ɾ��(ǰ̨У��)
		for( int i = 0; i < dto.getDeleteLpdid().length; i++){

			//��ǰ���ID
			String lpdid = dto.getDeleteLpdid()[i];
			
			//��ǰ���û��ܶ�����Ϊ�ֶ�����-�����
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			
			//�޸�Ԥ֧���û�����Ϣ
			this.advanceSummaryBL.deleteLoan(lpd);
			
			//ɾ������¼
			this.loanPayDetailBL.deleteLoanPayDetail(Integer.parseInt(lpdid));	
			
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006","�������"));


		log.debug("========�����Ϣɾ���������========");
		
		return dto;
	}
	
	/**
	 * ��Ա�����ϸ��ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException {

		log.debug("========��Ա�����ϸ��ѯ����ʼ========");
		
		//��Ա�����ϸ��ѯ����ȡ�� 
		int totalCount = this.personLoanSummaryVWBL.getSearchCount(dto.getPersonLoanSummarySearchCond());
		
		if (totalCount == 0) {
			log.debug("========��Ա�����ϸ��ѯ���ݲ�����========");
			//��Ա�����ϸ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ա�����ϸ��ѯ���ݼ�������========");
			//��Ա�����ϸ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<PersonLoanSummary> personLoanSummaryList = this.personLoanSummaryVWBL.searchPersonLoanSummaryVW(dto.getPersonLoanSummarySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		
		dto.setPersonLoanSummaryList(personLoanSummaryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��Ա�����ϸ��ѯ��������========");
		return dto;
	}
	/**
	 * ��Ա�����ϸ��������
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========��Ա�����ϸ��������ʼ========");
		
		//��Ա�����ϸ��������ȡ�� 
		int totalCount = this.personLoanSummaryVWBL.getSearchCount(dto.getPersonLoanSummarySearchCond());
		
		if (totalCount == 0) {
			log.debug("========��Ա�����ϸ�������ݲ�����========");
			//��Ա�����ϸ�������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ա�����ϸ�������ݼ�������========");
			//��Ա�����ϸ�������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ǰҳ��Ϣȡ��
		List<PersonLoanSummary> personLoanSummaryList = this.personLoanSummaryVWBL.searchPersonLoanSummaryVW(dto.getPersonLoanSummarySearchCond(), 0, 0);
		
		dto.setPersonLoanSummaryList(personLoanSummaryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��Ա�����ϸ������������========");
		return dto;
	}
	
	/**
	 * ��Ա�����ϸ��ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========��Ա�����ϸ��ѯ����ʼ========");
		
		//��Ա�����ϸ��ѯ����ȡ�� 
		int totalCount = this.personLoanDetailVWBL.getSearchCount(dto.getPersonLoanDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��Ա�����ϸ��ѯ���ݲ�����========");
			//��Ա�����ϸ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ա�����ϸ��ѯ���ݼ�������========");
			//��Ա�����ϸ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ��Ϣȡ��
		List<PersonLoanDetail> personLoanDetailList = this.personLoanDetailVWBL.searchPersonLoanDetailVW(dto.getPersonLoanDetailSearchCond(),  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setPersonLoanDetailList(personLoanDetailList);
		
		pDto.setTotalCount(totalCount);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��Ա�����ϸ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ��Ա�����ϸ��������
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========��Ա�����ϸ��������ʼ========");
		
		//��Ա�����ϸ��������ȡ�� 
		int totalCount = this.personLoanDetailVWBL.getSearchCount(dto.getPersonLoanDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========��Ա�����ϸ�������ݲ�����========");
			//��Ա�����ϸ�������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��Ա�����ϸ�������ݼ�������========");
			//��Ա�����ϸ�������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ǰҳ��Ϣȡ��
		List<PersonLoanDetail> personLoanDetailList = this.personLoanDetailVWBL.searchPersonLoanDetailVW(dto.getPersonLoanDetailSearchCond(), 0, 0);
		
		dto.setPersonLoanDetailList(personLoanDetailList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========��Ա�����ϸ������������========");
		return dto;
	}
	
	/**
	 * Ԥ֧��ϸ��ѯ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvanceDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========Ԥ֧��ϸ��ѯ����ʼ========");
		
		//Ԥ֧��ϸ��ѯ����ȡ�� 
		int totalCount = this.advanceDetailVWBL.getSearchCount(dto.getAdvanceDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========Ԥ֧��ϸ��ѯ���ݲ�����========");
			//Ԥ֧��ϸ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ԥ֧��ϸ��ѯ���ݼ�������========");
			//Ԥ֧��ϸ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ��Ϣȡ��
		List<AdvanceDetail> advanceDetailList = this.advanceDetailVWBL.searchAdvanceDetailVW(dto.getAdvanceDetailSearchCond(),  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setAdvanceDetailList(advanceDetailList);
		
		pDto.setTotalCount(totalCount);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========Ԥ֧��ϸ��ѯ��������========");
		return dto;
	}
	
	/**
	 * Ԥ֧��ϸ��������
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportAdvanceDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========Ԥ֧��ϸ��������ʼ========");
		
		//Ԥ֧��ϸ��������ȡ�� 
		int totalCount = this.advanceDetailVWBL.getSearchCount(dto.getAdvanceDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========Ԥ֧��ϸ�������ݲ�����========");
			//Ԥ֧��ϸ�������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ԥ֧��ϸ�������ݼ�������========");
			//Ԥ֧��ϸ�������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//��ǰҳ��Ϣȡ��
		List<AdvanceDetail> advanceDetailList = this.advanceDetailVWBL.searchAdvanceDetailVW(dto.getAdvanceDetailSearchCond(), 0, 0);
		
		dto.setAdvanceDetailList(advanceDetailList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========Ԥ֧��ϸ������������========");
		return dto;
	}

	public IGLOM03DTO searchAdvancesummaryAction(IGLOM03DTO dto)
			throws BLException {
           log.debug("========Ԥ֧�¶�ͳ�ƴ���ʼ========");
		
		//Ԥ֧��Աͳ�Ʋ�ѯ����ȡ�� 
		int totalCount = this.advanceSummaryBL.getSearchCount(dto.getAdvancesummaryCond());
		
		if (totalCount == 0) {
			log.debug("========Ԥ֧�¶�ͳ�Ʋ�ѯ���ݲ�����========");
			//Ԥ֧��Աͳ�Ʋ�ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========Ԥ֧�¶�ͳ�Ʋ�ѯ���ݼ�������========");
			//Ԥ֧��Աͳ�Ʋ�ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ǰҳ��Ϣȡ��
		List<AdvanceSummary> advancesummaryList = this.advanceSummaryBL.searchAdvanceSummaryByEmp(dto.getAdvancesummaryCond(), 0, 0);

		dto.setAdvanceSummarylList(advancesummaryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========Ԥ֧�¶�ͳ�Ʋ�ѯ��������========");
		return dto;
	}

	/**
	 * ���Ʊ��ѯ����
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM03DTO searchLoanPayInvoiceAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========���Ʊ��ѯ����ʼ========");

		//����Formȡ��
		IGLOM0313Form form = dto.getIglom0313Form();
		LoanPayDetailSearchCondImpl cond = new LoanPayDetailSearchCondImpl();
		cond.setLdid_invoice(form.getLdid());
		
		//����ȡ��
		List<LoanPayDetail> loanPayDetailList = this.loanPayDetailBL.searchLoanPayDetail(cond, 0, 0);
		//���ȡ��
		LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(form.getLdid());
		BigDecimal[] db = this.loanPayDetailBL.searchAmountdAndInvoice(lpd.getLpdid());
	
		dto.setLoanPayDetailList(loanPayDetailList);
		dto.setLoanPayDetailData(lpd);
		dto.setDb(db);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002"));
		
		log.debug("========���Ʊ��ѯ��������========");
		
		return dto;
		
	}

	/**
	 * ȷ�ϻ����
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * 
	 */
	public IGLOM03DTO changeLoanPayInvoiceAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========����ȷ�ϴ���ʼ========");

		//����Formȡ��
		IGLOM0313Form form = dto.getIglom0313Form();

		LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(form.getLdid());
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(lpd);
		lpdTB.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN);
		//������0000409
		//lpdTB.setLpdstockamount(this.advanceSummaryBL.searchStockAmount());
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		//�޸Ŀ����
		this.advanceSummaryBL.payConfirm(lpd);
		dto.addMessage(new ActionMessage("IGCO10000.I010","����"));

		log.debug("========����ȷ�ϴ���ʼ========");
		return dto;
	}

	/**
	 * ����ɾ����Ʊ
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteLoanPayInvoiceAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========���Ʊɾ������ʼ========");

		//����Formȡ��
		IGLOM0313Form form = dto.getIglom0313Form();
		this.loanPayDetailBL.searchLoanPayDetailByKey(form.getLpdid());
//		//���¿����
//		if(IGLOMCONSTANTS.LPD_TYPE_PAY.equals(lpd.getLpdtype())){
//			this.advanceSummaryBL.delPayByCash(lpd);
//			
//		} else if (IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE.equals(lpd.getLpdtype())){
//			this.advanceSummaryBL.delPayByInvoice(lpd);
//		}
		this.loanPayDetailBL.deleteLoanPayDetail(form.getLpdid());
		dto.addMessage(new ActionMessage("IGCO10000.I006","�����¼"));
		
		log.debug("========���Ʊɾ������ʼ========");
		return dto;
	}

	/**
	 * ������������
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO insertPayInvioceAction(IGLOM03DTO dto) throws BLException {
		
		//ȡ��form
		IGLOM0313Form form = dto.getIglom0313Form();
		
		LoanPayDetailTB lpdTB = new LoanPayDetailTB();
		
		lpdTB.setLpdinvoiceamount(form.getLpdinvoiceamount());
		lpdTB.setLpdinvoicecomment(form.getLpdinvoicecomment());
		lpdTB.setLpdinvoicecor(form.getLpdinvoicecor());
		lpdTB.setLpdinvoicedate(form.getLpdinvoicedate());
		lpdTB.setLpdinvoicenum(form.getLpdinvoicenum());
		lpdTB.setLpdactinvoice(form.getLpdactinvoice());
		lpdTB.setLpdactuser(form.getLpdactuser());
		lpdTB.setLpduser(form.getLpduser());
		lpdTB.setLpdtype(form.getLpdtype());
		lpdTB.setLpdamount(form.getLpdamount());
		lpdTB.setLpddate(form.getLpddate());
		lpdTB.setLpdtime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
		lpdTB.setLdid(form.getLdid());
		lpdTB.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN);
		lpdTB.setLpduserorg(form.getLpduserorg());
		this.loanPayDetailBL.registLoanPayDetail(lpdTB);
//		//���¿����
//		if(IGLOMCONSTANTS.LPD_TYPE_PAY.equals(form.getLpdtype())){
//			this.advanceSummaryBL.addPayByCash(lpd);
//			
//		} else if (IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE.equals(form.getLpdtype())){
//			this.advanceSummaryBL.addPayByInvoice(lpd);
//		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I004","����"));
		return dto;
	}


	/**
	 * Ԥ֧���ܶ�ʱ������
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO advanceSummaryJob(IGLOM03DTO dto) throws BLException {
		
		String date = IGStringUtils.getCurrentDate();
		
		List<AdvanceSummary> asList = advanceSummaryBL.searchAdvanceSummary(new AdvanceSummarySearchCondImpl(), 0, 0);
		
		AdvanceSummaryTB asTB = new AdvanceSummaryTB();
		asTB.setAsyear(date.substring(0,4));//���
		asTB.setAsmonth(date.substring(5,7));//�·�
		
		//��һ������
		if(asList.isEmpty()) {
			asTB.setAsprebalance(new BigDecimal(0));//�������
			asTB.setAsadvancescost(new BigDecimal(0));//����Ԥ֧���
			asTB.setAsloan(new BigDecimal(0));//�����
			asTB.setAsinvoice(new BigDecimal(0));//���·�Ʊ���
			asTB.setAspay(new BigDecimal(0));//���»�����
			asTB.setAsbalance(new BigDecimal(0));//�������
			asTB.setAsfreeze(new BigDecimal(0));//������
		} else {
			//���¼�¼
			AdvanceSummary as = asList.get(0);
			asTB.setAsprebalance(as.getAsbalance());//�������
			asTB.setAsadvancescost(new BigDecimal(0));//����Ԥ֧���
			asTB.setAsloan(as.getAsloan());//�����
			asTB.setAsinvoice(new BigDecimal(0));//���·�Ʊ���
			asTB.setAspay(new BigDecimal(0));//���»�����
			asTB.setAsbalance(as.getAsbalance());//�������
			asTB.setAsfreeze(as.getAsfreeze());//������
		}
		advanceSummaryBL.registAdvanceSummary(asTB);
		return dto;
	}
}
