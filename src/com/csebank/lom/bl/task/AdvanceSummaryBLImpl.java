/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 预支汇总业务逻辑接口实现
 */
public class AdvanceSummaryBLImpl extends BaseBLImpl implements AdvanceSummaryBL {
	
	static Log log = LogFactory.getLog(AdvanceSummaryBLImpl.class);
	
	/** AdvanceSummary DAO */
	protected AdvanceSummaryDAO advanceSummaryDAO;
	
	/** 预支费用BL */
	protected AdvanCescostBL advanCescostBL;
	
	/** 借还款BL */
	protected LoanPayDetailBL loanPayDetailBL;
	
	public void setAdvanceSummaryDAO(
			AdvanceSummaryDAO advanceSummaryDAO) {
		this.advanceSummaryDAO = advanceSummaryDAO;
	}
	
	/**
	 * 预支费用BL设定
	 * @param advanCescostBL 预支费用BL
	 */
	public void setAdvanCescostBL(AdvanCescostBL advanCescostBL) {
		this.advanCescostBL = advanCescostBL;
	}
	
	/**
	 * 借还款BL设定
	 * @param loanPayDetailBL
	 */
	public void setLoanPayDetailBL(LoanPayDetailBL loanPayDetailBL) {
		this.loanPayDetailBL = loanPayDetailBL;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(AdvanceSummarySearchCond cond){
		
		return advanceSummaryDAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param year 年度
	 * @param month 月份
	 * @return 预支汇总信息
	 */
	public AdvanceSummary searchAdvanceSummaryByKey(String year, String month) throws BLException{
		
		return checkExistAdvanceSummary(new AdvanceSummaryTBPK(year, month));
	}
	
	/**
	 * 本月预支汇总检索处理
	 * 
	 * @return 预支汇总信息
	 */
	public AdvanceSummary searchCurrentAdvanceSummary() throws BLException{
		
		String date = IGStringUtils.getCurrentDate();
		
		return checkExistAdvanceSummary(new AdvanceSummaryTBPK(date.substring(0,4),date.substring(5,7)));
	}
	

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<AdvanceSummary> searchAdvanceSummary(AdvanceSummarySearchCond cond, int start, int count){
		
		return advanceSummaryDAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param advanceSummary 登录数据
	 * @return 预支汇总信息
	 */
	public AdvanceSummary registAdvanceSummary(AdvanceSummary advanceSummary) throws BLException{
		
		return advanceSummaryDAO.save(advanceSummary);
	}

	/**
	 * 变更处理
	 * 
	 * @param advanceSummary 变更数据
	 * @return 预支汇总信息
	 */
	public AdvanceSummary updateAdvanceSummary(AdvanceSummary advanceSummary) throws BLException{
		
		checkExistAdvanceSummary(new AdvanceSummaryTBPK(advanceSummary.getAsyear(),advanceSummary.getAsmonth()));
		return advanceSummaryDAO.save(advanceSummary);
	}

	/**
	 * 预支汇总信息存在检查
	 * 
	 * @param rsid 预支汇总ID
	 * @return 预支汇总信息
	 * @throws BLException 
	 */
	protected AdvanceSummary checkExistAdvanceSummary(AdvanceSummaryTBPK key) throws BLException{
		AdvanceSummary info = advanceSummaryDAO.findByPK(key);
		if( info == null) {
			throw new BLException("IGCO10000.E004","预支汇总基本");
		}
		return info;
	}
	
	/**
	 * 预支新增处理
	 * 
	 * 本月预支金额 = 本月预支金额 + 输入预支金额
	 * 本月余额 = 本月余额 + 输入预支金额		
	 * 
	 * @param advanCescost 新增预支费用信息
	 */
	public void insertAdvanCescost(AdvanCescost advanCescost) throws BLException{
		
		int i = getSearchCount(new AdvanceSummarySearchCondImpl());
		
		//第一次运行
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
				log.error("预支汇总定时任务异常："+e.getMessage());
				throw new BLException("IGLOM0301.E002"); 
			} catch (ParseException e) {
				log.error("预支汇总定时任务时间表达式异常："+e.getMessage());
				throw new BLException("IGLOM0301.E002");
			}
			String date = IGStringUtils.getCurrentDate();
			AdvanceSummaryTB asTB = new AdvanceSummaryTB();
			asTB.setAsyear(date.substring(0,4));//年度
			asTB.setAsmonth(date.substring(5,7));//月份
				asTB.setAsprebalance(new BigDecimal(0));//上月余额
				asTB.setAsadvancescost(new BigDecimal(0));//本月预支金额
				asTB.setAsloan(new BigDecimal(0));//借款金额
				asTB.setAsinvoice(new BigDecimal(0));//本月发票金额
				asTB.setAspay(new BigDecimal(0));//本月还款金额
				asTB.setAsbalance(new BigDecimal(0));//本月余额
				asTB.setAsfreeze(new BigDecimal(0));//冻结金额
				advanceSummaryDAO.save(asTB);
		}
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//本月预支金额 = 本月预支金额 + 输入预支金额
		asTB.setAsadvancescost(LOMHelper.getAdd(as.getAsadvancescost(),advanCescost.getAcamount()));
		
		//实际输入的预支总金额
		BigDecimal subAdd = LOMHelper.getAdd(as.getAsadvancescost(),advanCescost.getAcamount());
		//还允许输入的预支总金额
		BigDecimal subTract = LOMHelper.getSubtract(new BigDecimal(9999999999.99),as.getAsadvancescost());
		
		if(subAdd.doubleValue() > 9999999999.99){
			throw new BLException("IGLOM0307.E002", subTract.toString());
		}
		
		//本月余额 = 本月余额 + 输入预支金额
		asTB.setAsbalance(LOMHelper.getAdd(as.getAsbalance(),advanCescost.getAcamount()));
		
		if(asTB.getAsbalance().doubleValue() < 0) {
			throw new BLException("IGLOM0307.E001",as.getAsbalance() + "");
		}
		
		advanceSummaryDAO.save(asTB);
		
		//修改预支记录库存金额
		AdvanCescostTB acTB = (AdvanCescostTB)SerializationUtils.clone(advanCescost);
		
		acTB.setAcstockamount(searchStockAmount());
		
		this.advanCescostBL.updateAdvanCescost(acTB);
	}
	
	/**
	 * 借款申请处理
	 * 
	 * 冻结金额 = 冻结金额 + 输入借款金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void loan(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//冻结金额 = 冻结金额 + 输入借款金额	
		asTB.setAsfreeze(LOMHelper.getAdd(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
	}
	
	/**
	 * 借款删除处理
	 * 
	 * 冻冻结金额 = 冻结金额 - 借款记录金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void deleteLoan(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//冻结金额 = 冻结金额 - 借款记录金额	
		asTB.setAsfreeze(LOMHelper.getSubtract(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
	}
	
	/**
	 * 借款审批通过处理
	 * 
	 * 冻结金额 = 冻结金额 - 审批记录的借款金额		
	 * 借款金额 = 借款金额 + 审批记录的借款金额		
	 * 本月余额 = 本月余额 - 审批记录的借款金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void approveYes(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//冻结金额 = 冻结金额 - 审批记录的借款金额
		asTB.setAsfreeze(LOMHelper.getSubtract(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		//借款金额 = 借款金额 + 审批记录的借款金额
		asTB.setAsloan(LOMHelper.getAdd(as.getAsloan(),loanPayDetail.getLpdamount()));
		
		//本月余额 = 本月余额 - 审批记录的借款金额
		asTB.setAsbalance(LOMHelper.getSubtract(as.getAsbalance(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//修改借款记录时间
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(loanPayDetail);
		
		lpdTB.setLpdtime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
		
		lpdTB.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
	}
	
	/**
	 * 借款审批不通过处理
	 * 
	 * 冻结金额 = 冻结金额 - 审批记录的借款金额		
	 * 
	 * @param loanPayDetail 借款信息
	 */
	public void approveNo(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//冻结金额 = 冻结金额 - 审批记录的借款金额
		asTB.setAsfreeze(LOMHelper.getSubtract(as.getAsfreeze(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
	}
	
	/**
	 * 还款确认处理,借款记录库存金额已更新
	 * 	
	 * 现金：本月还款金额 = 本月还款金额 + 还款现金金额		
	 *       本月余额 = 本月余额 + 还款现金金额		
	 *       借款金额 = 借款金额 - 还款现金金额		
	 * 
	 * @param loanPayDetail 借款信息
	 * 
	 */
	public void payConfirm(LoanPayDetail loanPayDetail) throws BLException{
		//获取已还款现金数和已还款发票数
		BigDecimal[] db = this.loanPayDetailBL.searchAmountdAndInvoice(loanPayDetail.getLpdid());
		if(loanPayDetail.getLpdamount().doubleValue() < db[1].doubleValue() && db[0].doubleValue() > 0) {
			//借款<发票且现金<0
			throw new BLException("IGLOM0313.E003");
		} else if (LOMHelper.getSubtract(loanPayDetail.getLpdamount(),LOMHelper.getAdd(db[0],db[1])).doubleValue() > 0){
			//借款=现金+发票
//			throw new BLException("IGLOM0313.E004");
		}
		//修改还款记录库存金额
		LoanPayDetailSearchCondImpl cond = new LoanPayDetailSearchCondImpl();
		
		cond.setLdid_invoice(loanPayDetail.getLpdid());
		
		List<LoanPayDetail> lpdList = this.loanPayDetailBL.searchLoanPayDetail(cond, 0, 0);
		
		BigDecimal stockAmount = searchStockAmount();
		
		for(LoanPayDetail bean : lpdList) {
			
			LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(bean);
			//现金还款时，本月余额 = 本月余额 + 还款现金金额
			if(IGLOMCONSTANTS.LPD_TYPE_PAY.equals(bean.getLpdtype())) {
				
				stockAmount = stockAmount.add(bean.getLpdamount());
			
			}
			
			lpdTB.setLpdstockamount(stockAmount);
			
			this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		}
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//本月还款金额 = 本月还款金额 + 还款现金金额
		asTB.setAspay(LOMHelper.getAdd(asTB.getAspay(),db[0]));
		
		//本月余额 = 本月余额 + 还款现金金额
		asTB.setAsbalance(LOMHelper.getAdd(asTB.getAsbalance(),db[0]));
		
		//本月发票额 = 本月发票额 + 还款发票额
		asTB.setAsinvoice(LOMHelper.getAdd(asTB.getAsinvoice(),db[1]));
		
		//借款金额 = 借款金额 - 还款发票金额- 还款现金金额
		asTB.setAsloan(LOMHelper.getSubtract(asTB.getAsloan(),loanPayDetail.getLpdamount()));
		
		
		BigDecimal money = LOMHelper.getSubtract(LOMHelper.getAdd(db[0],db[1]),loanPayDetail.getLpdamount());
		//当还款总金额大于借款金额时，追加一条还款金额为负数的记录
		//本月余额 = 本月余额 - （还款总金额  - 借款金额）
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
				lpdTB.setLpdinvoicecomment("返还现金");
				this.loanPayDetailBL.registLoanPayDetail(lpdTB);
			}else if(money.doubleValue() < 0){

				lpdTB.setLpdinvoicecomment("现金还款");
				this.loanPayDetailBL.registLoanPayDetail(lpdTB);
			}
			
		}
		
		//修改借款记录库存金额
//		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(loanPayDetail);
//		
//		lpd.setLpdstockamount(searchStockAmount());
//		
//		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
	}
	
	/**
	 * 新增还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 	
	 * 现金：本月还款金额 = 本月还款金额 + 还款现金金额		
	 *       本月余额 = 本月余额 + 还款现金金额		
	 *       借款金额 = 借款金额 - 还款现金金额		
	 * 
	 * @param loanPayDetail 还款信息
	 * 
	 */
	public void addPayByCash(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//本月还款金额 = 本月还款金额 + 还款现金金额
		asTB.setAspay(LOMHelper.getAdd(as.getAspay(),loanPayDetail.getLpdamount()));
		
		//本月余额 = 本月余额 + 还款现金金额
		asTB.setAsbalance(LOMHelper.getAdd(as.getAsbalance(),loanPayDetail.getLpdamount()));
		
		//借款金额 = 借款金额 - 还款现金金额
		asTB.setAsloan(LOMHelper.getSubtract(as.getAsloan(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//修改借款记录库存金额
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
		//修改还款记录库存金额
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLpdid()));
		
		lpdTB.setLpdstockamount(lpd.getLpdstockamount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		
	}
	
	/**
	 * 新增还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 
	 * 发票：本月发票额 = 本月发票额 + 还款发票额		
	 *       借款金额 = 借款金额 - 还款发票金额			
	 * 
	 * @param loanPayDetail 还款信息
	 */
	public void addPayByInvoice(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//本月发票额 = 本月发票额 + 还款发票额
		asTB.setAsinvoice(LOMHelper.getAdd(as.getAsinvoice(),loanPayDetail.getLpdinvoiceamount()));
		
		//借款金额 = 借款金额 - 还款发票金额
		asTB.setAsloan(LOMHelper.getSubtract(as.getAsloan(),loanPayDetail.getLpdinvoiceamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//修改借款记录库存金额
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
		//修改还款记录库存金额
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLpdid()));
		
		lpdTB.setLpdstockamount(lpd.getLpdstockamount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
	}
	/**
	 * 删除还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 	
	 * 现金：本月还款金额 = 本月还款金额 - 还款现金金额		
	 * 		本月余额 = 本月余额 - 还款现金金额		
	 * 		借款金额 = 借款金额 + 还款现金金额		
	 * 
	 * @param loanPayDetail 还款信息
	 * 
	 */
	public void delPayByCash(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//本月还款金额 = 本月还款金额 - 还款现金金额
		asTB.setAspay(LOMHelper.getSubtract(as.getAspay(),loanPayDetail.getLpdamount()));
		
		//本月余额 = 本月余额 - 还款现金金额
		asTB.setAsbalance(LOMHelper.getSubtract(as.getAsbalance(),loanPayDetail.getLpdamount()));
		
		//借款金额 = 借款金额 + 还款现金金额
		asTB.setAsloan(LOMHelper.getAdd(as.getAsloan(),loanPayDetail.getLpdamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//修改借款记录库存金额
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
		
	}
	
	/**
	 * 删除还款处理,借款记录库存金额已更新(作废，改为还款确认时调用payConfirm统一处理)
	 * 
	 * 发票：本月发票额 = 本月发票额 - 还款发票额		
	 * 		 借款金额 = 借款金额 + 还款发票金额		
	 * 
	 * @param loanPayDetail 还款信息
	 */
	public void delPayByInvoice(LoanPayDetail loanPayDetail) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//本月发票额 = 本月发票额 - 还款发票额
		asTB.setAsinvoice(LOMHelper.getSubtract(as.getAsinvoice(),loanPayDetail.getLpdinvoiceamount()));
		
		//借款金额 = 借款金额 + 还款发票金额
		asTB.setAsloan(LOMHelper.getAdd(as.getAsloan(),loanPayDetail.getLpdinvoiceamount()));
		
		advanceSummaryDAO.save(asTB);
		
		//修改借款记录库存金额
		LoanPayDetailTB lpd = (LoanPayDetailTB)SerializationUtils.clone(this.loanPayDetailBL.searchLoanPayDetailByKey(loanPayDetail.getLdid()));
		
		lpd.setLpdstockamount(searchStockAmount());
		
		this.loanPayDetailBL.updateLoanPayDetail(lpd);
	}
	
	
	/**
	 * 冲抵借款处理
	 * 
	 * 发票金额小于预支金额时，用库存金额冲抵	
	 * 
	 * @param advanCescost 预支信息
	 * 
	 */
	public void credit(AdvanCescost advanCescost) throws BLException{
		
		AdvanceSummary as = searchCurrentAdvanceSummary();
		
		AdvanceSummaryTB asTB = (AdvanceSummaryTB)SerializationUtils.clone(as);
		
		//本月余额 = 本月余额 - 还款现金金额
		asTB.setAsbalance(LOMHelper.getSubtract(as.getAsbalance(),advanCescost.getAcfreezeamount()));
		
		if(asTB.getAsbalance().doubleValue() < 0 ) {
			throw new BLException("IGLOM0307.E001",as.getAsbalance() + "");
		}
		
		advanceSummaryDAO.save(asTB);
		
	}
	
	/**
	 * 可用金额取得
	 * 
	 * 可用金额 = 本月余额 - 冻结金额
	 * 
	 * @return 可用金额
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
	 * 库存金额取得
	 * 
	 * 库存金额 = 本月余额	
	 * 
	 * @return 库存金额
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
