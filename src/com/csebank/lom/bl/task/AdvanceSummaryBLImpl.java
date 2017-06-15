/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.SchedulerException;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.job.AdvanceSummaryJob;
import com.csebank.lom.job.JOBCONSTANTS;
import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.LoanPayDetail;
import com.csebank.lom.model.condition.AdvanceSummarySearchCond;
import com.csebank.lom.model.condition.AdvanceSummarySearchCondImpl;
import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.csebank.lom.model.condition.LoanPayDetailSearchCondImpl;
import com.csebank.lom.model.dao.AdvanceSummaryDAO;
import com.csebank.lom.model.entity.AdvanCescostTB;
import com.csebank.lom.model.entity.AdvanceSummaryTB;
import com.csebank.lom.model.entity.AdvanceSummaryTBPK;
import com.csebank.lom.model.entity.LoanPayDetailTB;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;

/**
 * Ԥ֧����ҵ���߼��ӿ�ʵ��
 */
public class AdvanceSummaryBLImpl extends BaseBLImpl implements AdvanceSummaryBL {
	
	static Log log = LogFactory.getLog(AdvanceSummaryBLImpl.class);
	
	/** AdvanceSummary DAO */
	protected AdvanceSummaryDAO advanceSummaryDAO;
	
	/** Ԥ֧����BL */
	protected AdvanCescostBL advanCescostBL;
	
	/** �軹��BL */
	protected LoanPayDetailBL loanPayDetailBL;
	
	public void setAdvanceSummaryDAO(
			AdvanceSummaryDAO advanceSummaryDAO) {
		this.advanceSummaryDAO = advanceSummaryDAO;
	}
	
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
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(AdvanceSummarySearchCond cond){
		
		return advanceSummaryDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param year ���
	 * @param month �·�
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanceSummary searchAdvanceSummaryByKey(String year, String month) throws BLException{
		
		return checkExistAdvanceSummary(new AdvanceSummaryTBPK(year, month));
	}
	
	/**
	 * ����Ԥ֧���ܼ�������
	 * 
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanceSummary searchCurrentAdvanceSummary() throws BLException{
		
		String date = IGStringUtils.getCurrentDate();
		
		return checkExistAdvanceSummary(new AdvanceSummaryTBPK(date.substring(0,4),date.substring(5,7)));
	}
	

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanceSummary> searchAdvanceSummary(AdvanceSummarySearchCond cond, int start, int count){
		
		return advanceSummaryDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param advanceSummary ��¼����
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanceSummary registAdvanceSummary(AdvanceSummary advanceSummary) throws BLException{
		
		return advanceSummaryDAO.save(advanceSummary);
	}

	/**
	 * �������
	 * 
	 * @param advanceSummary �������
	 * @return Ԥ֧������Ϣ
	 */
	public AdvanceSummary updateAdvanceSummary(AdvanceSummary advanceSummary) throws BLException{
		
		checkExistAdvanceSummary(new AdvanceSummaryTBPK(advanceSummary.getAsyear(),advanceSummary.getAsmonth()));
		return advanceSummaryDAO.save(advanceSummary);
	}

	/**
	 * Ԥ֧������Ϣ���ڼ��
	 * 
	 * @param rsid Ԥ֧����ID
	 * @return Ԥ֧������Ϣ
	 * @throws BLException 
	 */
	protected AdvanceSummary checkExistAdvanceSummary(AdvanceSummaryTBPK key) throws BLException{
		AdvanceSummary info = advanceSummaryDAO.findByPK(key);
		if( info == null) {
			throw new BLException("IGCO10000.E004","Ԥ֧���ܻ���");
		}
		return info;
	}
	
	/**
	 * Ԥ֧��������
	 * 
	 * ����Ԥ֧��� = ����Ԥ֧��� + ����Ԥ֧���
	 * ������� = ������� + ����Ԥ֧���		
	 * 
	 * @param advanCescost ����Ԥ֧������Ϣ
	 */
	public void insertAdvanCescost(AdvanCescost advanCescost) throws BLException{
		
		int i = getSearchCount(new AdvanceSummarySearchCondImpl());
		
		//��һ������
		if(i == 0) {
			try {
				JobManager.removeJob(JOBCONSTANTS.ADVANCESUMMARY_MONITOR,
						JOBCONSTANTS.ADVANCESUMMARY_MONITOR_GROUP,
						JOBCONSTANTS.ADVANCESUMMARY_MONITOR_TRI,
						JOBCONSTANTS.ADVANCESUMMARY_MONITOR_TRI_GROUP);
				JobManager.addJob(JOBCONSTANTS.ADVANCESUMMARY_MONITOR,
						JOBCONSTANTS.ADVANCESUMMARY_MONITOR_GROUP,
						JOBCONSTANTS.ADVANCESUMMARY_MONITOR_TRI,
						JOBCONSTANTS.ADVANCESUMMARY_MONITOR_TRI_GROUP,
						new AdvanceSummaryJob(), JOBCONSTANTS.ADVANCESUMMARY_MONITOR_PARSE);
			} catch (SchedulerException e) {
				log.error("Ԥ֧���ܶ�ʱ�����쳣��"+e.getMessage());
				throw new BLException("IGLOM0301.E002"); 
			} catch (ParseException e) {
				log.error("Ԥ֧���ܶ�ʱ����ʱ����ʽ�쳣��"+e.getMessage());
				throw new BLException("IGLOM0301.E002");
			}
			String date = IGStringUtils.getCurrentDate();
			AdvanceSummaryTB asTB = new AdvanceSummaryTB();
			asTB.setAsyear(date.substring(0,4));//���
			asTB.setAsmonth(date.substring(5,7));//�·�
				asTB.setAsprebalance(new BigDecimal(0));//�������
				asTB.setAsadvancescost(new BigDecimal(0));//����Ԥ֧���
				asTB.setAsloan(new BigDecimal(0));//�����
				asTB.setAsinvoice(new BigDecimal(0));//���·�Ʊ���
				asTB.setAspay(new BigDecimal(0));//���»�����
				asTB.setAsbalance(new BigDecimal(0));//�������
				asTB.setAsfreeze(new BigDecimal(0));//������
				advanceSummaryDAO.save(asTB);
		}
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//����Ԥ֧��� = ����Ԥ֧��� + ����Ԥ֧���
		asTB.setAsadvancescost(LOMHelper.getAdd(as.getAsadvancescost(),advanCescost.getAcamount()));
		
		//ʵ�������Ԥ֧�ܽ��
		BigDecimal subAdd = LOMHelper.getAdd(as.getAsadvancescost(),advanCescost.getAcamount());
		//�����������Ԥ֧�ܽ��
		BigDecimal subTract = LOMHelper.getSubtract(new BigDecimal(9999999999.99),as.getAsadvancescost());
		
		if(subAdd.doubleValue() > 9999999999.99){
			throw new BLException("IGLOM0307.E002", subTract.toString());
		}
		
		//������� = ������� + ����Ԥ֧���
		asTB.setAsbalance(LOMHelper.getAdd(as.getAsbalance(),advanCescost.getAcamount()));
		
		if(asTB.getAsbalance().doubleValue() < 0) {
			throw new BLException("IGLOM0307.E001",as.getAsbalance() + "");
		}
		
		advanceSummaryDAO.save(asTB);
		
		//�޸�Ԥ֧��¼�����
		AdvanCescostTB acTB = (AdvanCescostTB)SerializationUtils.clone(advanCescost);
		
		acTB.setAcstockamount(searchStockAmount());
		
		this.advanCescostBL.updateAdvanCescost(acTB);
	}
	
	/**
	 * ������봦��
	 * 
	 * ������ = ������ + ��������		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void loan(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//������ = ������ + ��������	
		asTB.setAsfreeze(LOMHelper.getAdd(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
	}
	
	/**
	 * ���ɾ������
	 * 
	 * �������� = ������ - ����¼���		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void deleteLoan(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//������ = ������ - ����¼���	
		asTB.setAsfreeze(LOMHelper.getSubtract(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
	}
	
	/**
	 * �������ͨ������
	 * 
	 * ������ = ������ - ������¼�Ľ����		
	 * ����� = ����� + ������¼�Ľ����		
	 * ������� = ������� - ������¼�Ľ����		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void approveYes(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//������ = ������ - ������¼�Ľ����
		asTB.setAsfreeze(LOMHelper.getSubtract(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		//����� = ����� + ������¼�Ľ����
		asTB.setAsloan(LOMHelper.getAdd(as.getAsloan(),loanPayDetail.getLpdamount()));
		
		//������� = ������� - ������¼�Ľ����
		asTB.setAsbalance(LOMHelper.getSubtract(as.getAsbalance(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//�޸Ľ���¼ʱ��
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(loanPayDetail);
		
		lpdTB.setLpdtime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
		
		lpdTB.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
	}
	
	/**
	 * ���������ͨ������
	 * 
	 * ������ = ������ - ������¼�Ľ����		
	 * 
	 * @param loanPayDetail �����Ϣ
	 */
	public void approveNo(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//������ = ������ - ������¼�Ľ����
		asTB.setAsfreeze(LOMHelper.getSubtract(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
	}
	
	/**
	 * ����ȷ�ϴ���,����¼������Ѹ���
	 * 	
	 * �ֽ𣺱��»����� = ���»����� + �����ֽ���		
	 *       ������� = ������� + �����ֽ���		
	 *       ����� = ����� - �����ֽ���		
	 * 
	 * @param loanPayDetail �����Ϣ
	 * 
	 */
	public void payConfirm(LoanPayDetail loanPayDetail) throws BLException{
		//��ȡ�ѻ����ֽ������ѻ��Ʊ��
		BigDecimal[] db = this.loanPayDetailBL.searchAmountdAndInvoice(loanPayDetail.getLpdid());
		if(loanPayDetail.getLpdamount().doubleValue() < db[1].doubleValue() && db[0].doubleValue() > 0) {
			//���<��Ʊ���ֽ�<0
			throw new BLException("IGLOM0313.E003");
		} else if (LOMHelper.getSubtract(loanPayDetail.getLpdamount(),LOMHelper.getAdd(db[0],db[1])).doubleValue() > 0){
			//���=�ֽ�+��Ʊ
//			throw new BLException("IGLOM0313.E004");
		}
		//�޸Ļ����¼�����
		LoanPayDetailSearchCondImpl cond = new LoanPayDetailSearchCondImpl();
		
		cond.setLdid_invoice(loanPayDetail.getLpdid());
		
		List<LoanPayDetail> lpdList = this.loanPayDetailBL.searchLoanPayDetail(cond, 0, 0);
		
		BigDecimal stockAmount = searchStockAmount();
		
		for(LoanPayDetail bean : lpdList) {
			
			LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(bean);
			//�ֽ𻹿�ʱ��������� = ������� + �����ֽ���
			if(IGLOMCONSTANTS.LPD_TYPE_PAY.equals(bean.getLpdtype())) {
				
				stockAmount = stockAmount.add(bean.getLpdamount());
			
			}
			
			lpdTB.setLpdstockamount(stockAmount);
			
			this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		}
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//���»����� = ���»����� + �����ֽ���
		asTB.setAspay(LOMHelper.getAdd(asTB.getAspay(),db[0]));
		
		//������� = ������� + �����ֽ���
		asTB.setAsbalance(LOMHelper.getAdd(asTB.getAsbalance(),db[0]));
		
		//���·�Ʊ�� = ���·�Ʊ�� + ���Ʊ��
		asTB.setAsinvoice(LOMHelper.getAdd(asTB.getAsinvoice(),db[1]));
		
		//����� = ����� - ���Ʊ���- �����ֽ���
		asTB.setAsloan(LOMHelper.getSubtract(asTB.getAsloan(),loanPayDetail.getLpdamount()));
		
		
		BigDecimal money = LOMHelper.getSubtract(LOMHelper.getAdd(db[0],db[1]),loanPayDetail.getLpdamount());
		//�������ܽ����ڽ����ʱ��׷��һ��������Ϊ�����ļ�¼
		//������� = ������� - �������ܽ��  - ����
		BigDecimal stock = asTB.getAsbalance();
		asTB.setAsbalance(LOMHelper.getSubtract(asTB.getAsbalance(),LOMHelper.getSubtract(LOMHelper.getAdd(db[0],db[1]),loanPayDetail.getLpdamount())));
		
		if(asTB.getAsbalance().doubleValue() < 0) {
			throw new BLException("IGLOM0313.E002",stock.toString());
		}
		advanceSummaryDAO.save(asTB);

		if(money.doubleValue() != 0) {
			
			LoanPayDetailTB lpdTB = new LoanPayDetailTB();
			lpdTB.setLpdinvoiceamount(new BigDecimal(0));
			lpdTB.setLpdactinvoice(new BigDecimal(0));
			lpdTB.setLpdactuser(loanPayDetail.getLpduser());
			lpdTB.setLpduser(loanPayDetail.getLpduser());
			lpdTB.setLpdtype(IGLOMCONSTANTS.LPD_TYPE_PAY);
			lpdTB.setLpdamount(money.multiply(new BigDecimal(-1)));
			lpdTB.setLpddate(IGStringUtils.getCurrentDate());
			lpdTB.setLpdtime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
			lpdTB.setLdid(loanPayDetail.getLpdid());
			lpdTB.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN);
			lpdTB.setLpduserorg(loanPayDetail.getLpduserorg());
			lpdTB.setLpdstockamount(asTB.getAsbalance());
			
			if(money.doubleValue() > 0) {
				lpdTB.setLpdinvoicecomment("�����ֽ�");
				this.loanPayDetailBL.registLoanPayDetail(lpdTB);
			}else if(money.doubleValue() < 0){

				lpdTB.setLpdinvoicecomment("�ֽ𻹿�");
				this.loanPayDetailBL.registLoanPayDetail(lpdTB);
			}
			
		}
		
		//�޸Ľ���¼�����
//		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(loanPayDetail);
//		
//		lpd.setLpdstockamount(searchStockAmount());
//		
//		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
	}
	
	/**
	 * ���������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 	
	 * �ֽ𣺱��»����� = ���»����� + �����ֽ���		
	 *       ������� = ������� + �����ֽ���		
	 *       ����� = ����� - �����ֽ���		
	 * 
	 * @param loanPayDetail ������Ϣ
	 * 
	 */
	public void addPayByCash(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//���»����� = ���»����� + �����ֽ���
		asTB.setAspay(LOMHelper.getAdd(as.getAspay(),loanPayDetail.getLpdamount()));
		
		//������� = ������� + �����ֽ���
		asTB.setAsbalance(LOMHelper.getAdd(as.getAsbalance(),loanPayDetail.getLpdamount()));
		
		//����� = ����� - �����ֽ���
		asTB.setAsloan(LOMHelper.getSubtract(as.getAsloan(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//�޸Ľ���¼�����
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
		//�޸Ļ����¼�����
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLpdid()));
		
		lpdTB.setLpdstockamount(lpd.getLpdstockamount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		
	}
	
	/**
	 * ���������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 
	 * ��Ʊ�����·�Ʊ�� = ���·�Ʊ�� + ���Ʊ��		
	 *       ����� = ����� - ���Ʊ���			
	 * 
	 * @param loanPayDetail ������Ϣ
	 */
	public void addPayByInvoice(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//���·�Ʊ�� = ���·�Ʊ�� + ���Ʊ��
		asTB.setAsinvoice(LOMHelper.getAdd(as.getAsinvoice(),loanPayDetail.getLpdinvoiceamount()));
		
		//����� = ����� - ���Ʊ���
		asTB.setAsloan(LOMHelper.getSubtract(as.getAsloan(),loanPayDetail.getLpdinvoiceamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//�޸Ľ���¼�����
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
		//�޸Ļ����¼�����
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLpdid()));
		
		lpdTB.setLpdstockamount(lpd.getLpdstockamount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
	}
	/**
	 * ɾ�������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 	
	 * �ֽ𣺱��»����� = ���»����� - �����ֽ���		
	 * 		������� = ������� - �����ֽ���		
	 * 		����� = ����� + �����ֽ���		
	 * 
	 * @param loanPayDetail ������Ϣ
	 * 
	 */
	public void delPayByCash(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//���»����� = ���»����� - �����ֽ���
		asTB.setAspay(LOMHelper.getSubtract(as.getAspay(),loanPayDetail.getLpdamount()));
		
		//������� = ������� - �����ֽ���
		asTB.setAsbalance(LOMHelper.getSubtract(as.getAsbalance(),loanPayDetail.getLpdamount()));
		
		//����� = ����� + �����ֽ���
		asTB.setAsloan(LOMHelper.getAdd(as.getAsloan(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//�޸Ľ���¼�����
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
	}
	
	/**
	 * ɾ�������,����¼������Ѹ���(���ϣ���Ϊ����ȷ��ʱ����payConfirmͳһ����)
	 * 
	 * ��Ʊ�����·�Ʊ�� = ���·�Ʊ�� - ���Ʊ��		
	 * 		 ����� = ����� + ���Ʊ���		
	 * 
	 * @param loanPayDetail ������Ϣ
	 */
	public void delPayByInvoice(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//���·�Ʊ�� = ���·�Ʊ�� - ���Ʊ��
		asTB.setAsinvoice(LOMHelper.getSubtract(as.getAsinvoice(),loanPayDetail.getLpdinvoiceamount()));
		
		//����� = ����� + ���Ʊ���
		asTB.setAsloan(LOMHelper.getAdd(as.getAsloan(),loanPayDetail.getLpdinvoiceamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//�޸Ľ���¼�����
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
	}
	
	
	/**
	 * ��ֽ���
	 * 
	 * ��Ʊ���С��Ԥ֧���ʱ���ÿ������	
	 * 
	 * @param advanCescost Ԥ֧��Ϣ
	 * 
	 */
	public void credit(AdvanCescost advanCescost) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//������� = ������� - �����ֽ���
		asTB.setAsbalance(LOMHelper.getSubtract(as.getAsbalance(),advanCescost.getAcfreezeamount()));
		
		if(asTB.getAsbalance().doubleValue() < 0 ) {
			throw new BLException("IGLOM0307.E001",as.getAsbalance() + "");
		}
		
		advanceSummaryDAO.save(asTB);
		
	}
	
	/**
	 * ���ý��ȡ��
	 * 
	 * ���ý�� = ������� - ������
	 * 
	 * @return ���ý��
	 */
	public BigDecimal searchAvailableAmount() throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		BigDecimal availableAmount = LOMHelper.getSubtract(as.getAsbalance(),as.getAsfreeze());
		
		if(availableAmount == new BigDecimal(0)) {
			throw new BLException("IGLOM0303.E001");
		}
		return availableAmount;
	}
	
	/**
	 * �����ȡ��
	 * 
	 * ����� = �������	
	 * 
	 * @return �����
	 */
	public BigDecimal searchStockAmount() throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		return as.getAsbalance();
	}
	
	public List<AdvanceSummary> searchAdvanceSummaryByEmp(
			AdvancesummaryCond cond, int start, int count) {
		return advanceSummaryDAO.findByCond(cond,start,count);
		
	}
	
   public int getSearchCount(AdvancesummaryCond cond){
  		
		return advanceSummaryDAO.getSearchCount(cond);
	}


}
