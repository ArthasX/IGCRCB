/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 *  预支费用BL实现
 */
public class IGLOM03BLImpl extends BaseBLImpl implements IGLOM03BL {
	
	static Log log = LogFactory.getLog(IGLOM03BLImpl.class);

	/** 预支费用BL */
	protected AdvanCescostBL advanCescostBL;
	
	/** 借还款BL */
	protected LoanPayDetailBL loanPayDetailBL;
	
	/** 预支汇总BL */
	protected AdvanceSummaryBL advanceSummaryBL;
	
	/** 预支人员统计BL */
	protected PersonLoanSummaryVWBL personLoanSummaryVWBL;
	
	/** 人员借款明细BL */
	protected PersonLoanDetailVWBL personLoanDetailVWBL;
	
	/** 预支明细BL */
	protected AdvanceDetailVWBL advanceDetailVWBL;

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
	 * 预支汇总BL设定
	 * @param advanceSummaryBL
	 */
	public void setAdvanceSummaryBL(AdvanceSummaryBL advanceSummaryBL) {
		this.advanceSummaryBL = advanceSummaryBL;
	}
	
	/**
	 * 预支人员统计设定
	 * @param personLoanSummaryVWBL
	 */
	public void setPersonLoanSummaryVWBL(PersonLoanSummaryVWBL personLoanSummaryVWBL) {
		this.personLoanSummaryVWBL = personLoanSummaryVWBL;
	}
	
	/**
	 * 人员借款明细BL设定
	 * @param personLoanDetailVWBL
	 */
	public void setPersonLoanDetailVWBL(PersonLoanDetailVWBL personLoanDetailVWBL) {
		this.personLoanDetailVWBL = personLoanDetailVWBL;
	}
	
	/**
	 * 预支明细BL设定
	 * @param advanceDetailVWBL
	 */
	public void setAdvanceDetailVWBL(AdvanceDetailVWBL advanceDetailVWBL) {
		this.advanceDetailVWBL = advanceDetailVWBL;
	}

	/**
	 * 预支费用变更初期显示处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO initAdvanCescostAction(IGLOM03DTO dto) throws BLException {

		log.debug("========预支费用变更画面初期显示处理开始========");	
		IGLOM0301Form form = dto.getIglom0301Form();
		AdvanCescost ac = advanCescostBL.searchAdvanCescostByKey(form.getAcid());
		
		//画面显示设定
		form.setAcamount(ac.getAcamount());
		form.setAcdate(ac.getAcdate());
		form.setActype(ac.getActype());
		form.setAcchequenum(ac.getAcchequenum());
		form.setAcserial(ac.getAcserial());
		form.setAccomment(ac.getAccomment());
		form.setAcstatus(ac.getAcstatus());
		form.setAcfreezeamount(ac.getAcfreezeamount());
		
		//变更标识
		form.setMode("1");

		dto.setIglom0301Form(form);
		
		log.debug("========预支费用变更画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 预支费用登记新增
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO insertAdvanCescostAction(IGLOM03DTO dto) throws BLException {
		log.debug("========预支费用登记处理开始========");
		//输入Form取得
		IGLOM0301Form form = dto.getIglom0301Form();
		//负数时为调整
		if(form.getAcamount().doubleValue() < 0 ) {
			form.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_ADJUST);
		} else {
			form.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_UNCREDIT);
		}
		form.setAcinsdate(IGStringUtils.getCurrentDate());
		form.setAcinstime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
		form.setAcfreezeamount(new BigDecimal(0));
		form.setAcinvoiceamount(new BigDecimal(0));
		//预支费用登录
		AdvanCescost ac = this.advanCescostBL.registAdvanCescost(form);
		
		//修改预支汇总信息
		this.advanceSummaryBL.insertAdvanCescost(ac);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "预支费用") );

		log.debug("========预支费用登记处理终了========");
		return dto;
	}

	/**
	 * 预支费用更新
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO updateAdvanCescostAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========预支费用变更处理开始========");
		
		IGLOM0301Form form = dto.getIglom0301Form();
		
		AdvanCescost ac = this.advanCescostBL.searchAdvanCescostByKey(form.getAcid());
		
		AdvanCescostTB acTB = (AdvanCescostTB)SerializationUtils.clone(ac);
//		//不可用时，增加金额则修改状态为可用
//		if(IGLOMCONSTANTS.ADVANCESCOST_STATUS_DISABLE.equals(acTB.getAcstatus())) {
//			if(form.getAcamount() > acTB.getAcamount()) {
//				acTB.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_ENABLE);
//			}
//		}
//		//减少金额不能大于冻结金额
//		if(form.getAcamount() < acTB.getAcfreezeamount()) {
//			throw new BLException("IGLOM0301.E001" , acTB.getAcfreezeamount().toString());  
//		}
		
		acTB.setAcamount(form.getAcamount());
		acTB.setAcdate(form.getAcdate());
		acTB.setActype(form.getActype());
		acTB.setAcchequenum(form.getAcchequenum());
		acTB.setAccomment(form.getAccomment());
		
		//预支费用登录
		this.advanCescostBL.updateAdvanCescost(acTB);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "预支费用信息") );

		log.debug("========预支费用变更处理终了========");
		
		return dto;
	}



	
	/**
	 * 预支费用信息查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvanCescostAction(IGLOM03DTO dto) throws BLException {

		log.debug("========预支费用信息查询处理开始========");
		
		//预支费用信息查询件数取得 
		int totalCount = this.advanCescostBL.getSearchCount(dto.getAdvanCescostSearchCond());
		
		if (totalCount == 0) {
			log.debug("========预支费用信息查询数据不存在========");
			//预支费用信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========预支费用信息查询数据件数过多========");
			//预支费用信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<AdvanCescost> advanCescostList = this.advanCescostBL.searchAdvanCescost(dto.getAdvanCescostSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		
		dto.setAdvanCescostList(advanCescostList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========预支费用信息查询处理终了========");
		return dto;
	}

	/**
	 * 预支费用删除处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteAdvanCescostAction(IGLOM03DTO dto) throws BLException {

		log.debug("========预支费用信息删除处理开始========");
		
		for( int i = 0; i < dto.getDeleteAcid().length; i++){
			
			String acid = dto.getDeleteAcid()[i];
			//删除预支费用
			this.advanCescostBL.deleteAdvanCescost(Integer.parseInt(acid));
			
		}

		dto.addMessage(new ActionMessage("IGCO10000.I006","预支费用信息"));

		log.debug("========预支费用信息删除处理结束========");
		
		return dto;
	}





	/**
	 * 借款初期显示处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO initLoanPayDetailAction(IGLOM03DTO dto) throws BLException {

		log.debug("========借款画面初期显示处理开始========");	
		IGLOM0303Form form = dto.getIglom0303Form();
		LoanPayDetail rp = loanPayDetailBL.searchLoanPayDetailByKey(form.getLpdid());
		
		//画面显示设定
		form.setLpdamount(rp.getLpdamount());
		form.setLpdcomment(rp.getLpdcomment());
		form.setLpddate(rp.getLpddate());
		form.setLpdstatus(rp.getLpdstatus());
		form.setLpdtype(rp.getLpdtype());
		form.setLpduser(rp.getLpduser());
		
		//变更标识
		form.setMode("1");

		dto.setIglom0303Form(form);
		
		log.debug("========借款画面初期显示处理终了========");
		return dto;
	}
	
	/**
	 * 可用金额取得
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAvailableAmountAction(IGLOM03DTO dto) throws BLException {
		log.debug("========可用金额取得处理开始========");
		dto.setAvailableAmount(this.advanceSummaryBL.searchAvailableAmount());
		log.debug("========可用金额取得处理终了========");
		return dto;
	}

	/**
	 * 借款申请新增
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO insertLoanPayDetailAction(IGLOM03DTO dto) throws BLException {
		log.debug("========借款申请处理开始========");
		
		//输入Form取得
		IGLOM0303Form form = dto.getIglom0303Form();

		//获取可用金额
		BigDecimal enable = this.advanceSummaryBL.searchAvailableAmount();
		
		//借款金额不能大于可用金额
		if(form.getLpdamount().doubleValue() > enable.doubleValue()) {
			throw new BLException("IGLOM0304.E001" , enable.toString());  
		}
		
		//状态待审批    (借款时: 0:已确认 1:待审批 2:审批已通过 3:审批未通过 4:已还款 5:已冲抵)
		form.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_DAISHENPI);
		//借还款区分  (0:借款 1:现金还款 2:支票还款)
		form.setLpdtype(IGLOMCONSTANTS.LPD_TYPE_LOAN);
		
		form.setLpddate(IGStringUtils.getCurrentDate());
		
		form.setLpdtime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
		//借款登录
		LoanPayDetail loanPayDetail = this.loanPayDetailBL.registLoanPayDetail(dto.getIglom0303Form());
		
		//修改预支汇总信息
		this.advanceSummaryBL.loan(loanPayDetail);
		
		form.setLpdid(loanPayDetail.getLpdid());
		
		dto.setIglom0303Form(form);
				
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "借款信息") );

		log.debug("========借款申请处理终了========");
		return dto;
	}

	
	/**
	 * 借款信息查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailAction(IGLOM03DTO dto) throws BLException {

		log.debug("========借款信息查询处理开始========");
		
		//借款信息查询取得 
		int totalCount = this.loanPayDetailBL.getSearchCount(dto.getLoanPayDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========借款信息查询数据不存在========");
			//借款信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========借款信息查询数据件数过多========");
			//借款信息查询数据过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<LoanPayDetail> loanPayDetailList = this.loanPayDetailBL.searchLoanPayDetail(dto.getLoanPayDetailSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		
		dto.setLoanPayDetailList(loanPayDetailList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========借款信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 借款信息查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailNoPagingAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========借款信息查询处理开始========");
		
		//当前页信息取得
		List<LoanPayDetail> loanPayDetailList = this.loanPayDetailBL.searchLoanPayDetail(dto.getLoanPayDetailSearchCond(), 0, 0);
		
		dto.setLoanPayDetailList(loanPayDetailList);
		
		log.debug("========借款信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 冲抵计财部借款汇总处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchLoanPayDetailSummaryAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========冲抵计财部借款预支费用列表查询处理开始========");
		
		IGLOM0307Form form = dto.getIglom0307Form();
		
		//汇总金额
		String[] deleteLpdid = form.getDeleteLpdid();
		
		if(deleteLpdid == null) {
			throw new BLException("IGCO10000.E004","冲抵计财部借款记录");
		}
		BigDecimal money = new BigDecimal(0);
		for(String lpdid : deleteLpdid) {
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			money = LOMHelper.getAdd(money, lpd.getLpdinvoiceamount());
		}
		form.setMoney(money);
		
		//查询未冲抵预支费用
		AdvanCescostSearchCondImpl cond = new AdvanCescostSearchCondImpl();
		
		cond.setAcstatus_q(IGLOMCONSTANTS.ADVANCESCOST_STATUS_UNCREDIT);
		
		//当前页信息取得
		List<AdvanCescost> advanCescostList = this.advanCescostBL.searchAdvanCescost(cond, 0, 0);
		
		dto.setAdvanCescostList(advanCescostList);
		
		log.debug("========冲抵计财部借款预支费用列表查询处理终了========");
		return dto;
	}
	
	/**
	 * 冲抵计财部借款处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO loanPayDetailCredit(IGLOM03DTO dto) throws BLException {

		log.debug("========冲抵计财部借款处理开始========");
		
		IGLOM0307Form form = dto.getIglom0307Form();
		
		//预支费用记录
		AdvanCescost ac = this.advanCescostBL.searchAdvanCescostByKey(form.getAcid());
		
		//修改预支费用状态为已冲抵
		AdvanCescostTB acTB = (AdvanCescostTB)SerializationUtils.clone(ac);
		//已冲抵
		acTB.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_CREDIT);
		//还款现金金额 = 预支金额 - 还款发票金额
		acTB.setAcfreezeamount(LOMHelper.getSubtract(ac.getAcamount(),form.getMoney()));
		//还款发票金额
		acTB.setAcinvoiceamount(form.getMoney());
		//冲抵日期
		acTB.setAccreditdate(IGStringUtils.getCurrentDate());

		this.advanceSummaryBL.credit(acTB);
		//库存金额
		//acTB.setAcstockamount(this.advanceSummaryBL.searchStockAmount());
		
		this.advanCescostBL.updateAdvanCescost(acTB);
		
		//修改还款记录状态为已冲抵
		String[] deleteLpdid = form.getDeleteLpdid();
		
		if(deleteLpdid == null) {
			throw new BLException("IGCO10000.E004","冲抵计财部借款记录");
		}
		
		for(String lpdid : deleteLpdid) {
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(lpd);
			//已冲抵
			lpdTB.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_CREDIT);
			//预支费用ID
			lpdTB.setAcid(ac.getAcid());
			//库存金额
			//lpdTB.setLpdstockamount(this.advanceSummaryBL.searchStockAmount());
			this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		}
		
		//当发票金额小于预支金额时，自动追加一条金额为负数的预支记录，金额为扣除的金额，状态为现金冲抵
		if(acTB.getAcfreezeamount().doubleValue() > 0) {
			AdvanCescostTB acTBInstance = new AdvanCescostTB();
			/** 预支金额 */
			acTBInstance.setAcamount(acTB.getAcfreezeamount().multiply(new BigDecimal(-1)));
			
			/** 计财记帐日期 */
			acTBInstance.setAcdate(IGStringUtils.getCurrentDate());
			
			/** 预支方式 */
			acTBInstance.setActype(IGLOMCONSTANTS.ADVANCESCOST_TYPE_CASH);
			
			/** 预支状态 */
			acTBInstance.setAcstatus(IGLOMCONSTANTS.ADVANCESCOST_STATUS_CASH_CREDIT);
			
			/** 库存金额 */
			acTBInstance.setAcstockamount(this.advanceSummaryBL.searchStockAmount());
			
			/** 预支冲抵日期 */
			acTBInstance.setAccreditdate(IGStringUtils.getCurrentDate());
			
			/** 登记人ID */
			acTBInstance.setAcuserid(dto.getUserid());
			
			/** 登记人姓名 */
			acTBInstance.setAcusername(dto.getUsername());
			
			/** 预支登记日期 */
			acTBInstance.setAcinsdate(IGStringUtils.getCurrentDate());
			
			/** 预支登记时间 */
			acTBInstance.setAcinstime(IGLOMCONSTANTS.DATETIME_FORMAT.format(new Date()));
			
			this.advanCescostBL.registAdvanCescost(acTBInstance);
		}
		
		dto.addMessage(new ActionMessage("IGLOM0307.I001"));
		
		log.debug("========冲抵计财部借款处理终了========");
		return dto;
	}

	/**
	 * 借款审批处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO changeLoanPayDetailAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========借款审批处理开始========");

		//取得form
		IGLOM0304Form form = dto.getIglom0304Form();
		
		//借款状态取得
		String lpdstatus = form.getLpdstatus();
		
		for( int i = 0; i < dto.getDeleteLpdid().length; i++){

			//当前借款ID
			String lpdid = dto.getDeleteLpdid()[i];
			
			//当前费用汇总冻结金额为现冻结金额-借款金额
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			
			LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(lpd);
			
			//获取要执行的借款状态
			lpdTB.setLpdstatus(form.getLpdstatus());
			
			if(IGLOMCONSTANTS.LPD_STATUS_YITONGGUO.equals(lpdstatus)){
				//审批通过时插入审批人信息
				lpdTB.setLpdpersion(dto.getUserid());
				lpdTB.setLpdpersionname(dto.getUsername());
				this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
				this.advanceSummaryBL.approveYes(lpd);
				
			}else if(IGLOMCONSTANTS.LPD_STATUS_WEITONGGUO.equals(lpdstatus)){
				//审批未通过时插入审批人信息
				lpdTB.setLpdpersion(dto.getUserid());
				lpdTB.setLpdpersionname(dto.getUsername());
				this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
				this.advanceSummaryBL.approveNo(lpd);
				
			}else if(IGLOMCONSTANTS.LPD_STATUS_YIQUEREN.equals(lpdstatus)){
				//确认时处理
				this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
			}
			
		}
		
		//添加处理结果信息
		if(IGLOMCONSTANTS.LPD_STATUS_YITONGGUO.equals(lpdstatus)){//审批通过
			dto.addMessage(new ActionMessage( "IGLOM0202.I001", "借款审批") );
			
		}else if(IGLOMCONSTANTS.LPD_STATUS_WEITONGGUO.equals(lpdstatus)){//审批未通过
			dto.addMessage(new ActionMessage( "IGLOM0202.I001", "借款审批未通过") );
			
		}else if(IGLOMCONSTANTS.LPD_STATUS_YIQUEREN.equals(lpdstatus)){//确认
			dto.addMessage(new ActionMessage( "IGLOM0202.I001", "借款确认") );
		}

		log.debug("========借款审批处理终了========");
		
		return dto;
	}

	/**
	 * 借款删除处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteLoanPayDetailAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========借款信息删除处理开始========");
		
		//只有待审批状态可以删除(前台校验)
		for( int i = 0; i < dto.getDeleteLpdid().length; i++){

			//当前借款ID
			String lpdid = dto.getDeleteLpdid()[i];
			
			//当前费用汇总冻结金额为现冻结金额-借款金额
			LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(Integer.parseInt(lpdid));
			
			//修改预支费用汇总信息
			this.advanceSummaryBL.deleteLoan(lpd);
			
			//删除借款记录
			this.loanPayDetailBL.deleteLoanPayDetail(Integer.parseInt(lpdid));	
			
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006","借款申请"));


		log.debug("========借款信息删除处理结束========");
		
		return dto;
	}
	
	/**
	 * 人员借款明细查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException {

		log.debug("========人员借款明细查询处理开始========");
		
		//人员借款明细查询件数取得 
		int totalCount = this.personLoanSummaryVWBL.getSearchCount(dto.getPersonLoanSummarySearchCond());
		
		if (totalCount == 0) {
			log.debug("========人员借款明细查询数据不存在========");
			//人员借款明细查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========人员借款明细查询数据件数过多========");
			//人员借款明细查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<PersonLoanSummary> personLoanSummaryList = this.personLoanSummaryVWBL.searchPersonLoanSummaryVW(dto.getPersonLoanSummarySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		
		dto.setPersonLoanSummaryList(personLoanSummaryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========人员借款明细查询处理终了========");
		return dto;
	}
	/**
	 * 人员借款明细导出处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanSummaryAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========人员借款明细导出处理开始========");
		
		//人员借款明细导出件数取得 
		int totalCount = this.personLoanSummaryVWBL.getSearchCount(dto.getPersonLoanSummarySearchCond());
		
		if (totalCount == 0) {
			log.debug("========人员借款明细导出数据不存在========");
			//人员借款明细导出数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========人员借款明细导出数据件数过多========");
			//人员借款明细导出数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//当前页信息取得
		List<PersonLoanSummary> personLoanSummaryList = this.personLoanSummaryVWBL.searchPersonLoanSummaryVW(dto.getPersonLoanSummarySearchCond(), 0, 0);
		
		dto.setPersonLoanSummaryList(personLoanSummaryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========人员借款明细导出处理终了========");
		return dto;
	}
	
	/**
	 * 人员借款明细查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchPersonLoanDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========人员借款明细查询处理开始========");
		
		//人员借款明细查询件数取得 
		int totalCount = this.personLoanDetailVWBL.getSearchCount(dto.getPersonLoanDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========人员借款明细查询数据不存在========");
			//人员借款明细查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========人员借款明细查询数据件数过多========");
			//人员借款明细查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页信息取得
		List<PersonLoanDetail> personLoanDetailList = this.personLoanDetailVWBL.searchPersonLoanDetailVW(dto.getPersonLoanDetailSearchCond(),  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setPersonLoanDetailList(personLoanDetailList);
		
		pDto.setTotalCount(totalCount);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========人员借款明细查询处理终了========");
		return dto;
	}
	
	/**
	 * 人员借款明细导出处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportPersonLoanDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========人员借款明细导出处理开始========");
		
		//人员借款明细导出件数取得 
		int totalCount = this.personLoanDetailVWBL.getSearchCount(dto.getPersonLoanDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========人员借款明细导出数据不存在========");
			//人员借款明细导出数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========人员借款明细导出数据件数过多========");
			//人员借款明细导出数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//当前页信息取得
		List<PersonLoanDetail> personLoanDetailList = this.personLoanDetailVWBL.searchPersonLoanDetailVW(dto.getPersonLoanDetailSearchCond(), 0, 0);
		
		dto.setPersonLoanDetailList(personLoanDetailList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========人员借款明细导出处理终了========");
		return dto;
	}
	
	/**
	 * 预支明细查询处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO searchAdvanceDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========预支明细查询处理开始========");
		
		//预支明细查询件数取得 
		int totalCount = this.advanceDetailVWBL.getSearchCount(dto.getAdvanceDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========预支明细查询数据不存在========");
			//预支明细查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========预支明细查询数据件数过多========");
			//预支明细查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页信息取得
		List<AdvanceDetail> advanceDetailList = this.advanceDetailVWBL.searchAdvanceDetailVW(dto.getAdvanceDetailSearchCond(),  pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setAdvanceDetailList(advanceDetailList);
		
		pDto.setTotalCount(totalCount);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========预支明细查询处理终了========");
		return dto;
	}
	
	/**
	 * 预支明细导出处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO exportAdvanceDetailAction(IGLOM03DTO dto) throws BLException {
		
		log.debug("========预支明细导出处理开始========");
		
		//预支明细导出件数取得 
		int totalCount = this.advanceDetailVWBL.getSearchCount(dto.getAdvanceDetailSearchCond());
		
		if (totalCount == 0) {
			log.debug("========预支明细导出数据不存在========");
			//预支明细导出数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========预支明细导出数据件数过多========");
			//预支明细导出数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//当前页信息取得
		List<AdvanceDetail> advanceDetailList = this.advanceDetailVWBL.searchAdvanceDetailVW(dto.getAdvanceDetailSearchCond(), 0, 0);
		
		dto.setAdvanceDetailList(advanceDetailList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========预支明细导出处理终了========");
		return dto;
	}

	public IGLOM03DTO searchAdvancesummaryAction(IGLOM03DTO dto)
			throws BLException {
           log.debug("========预支月度统计处理开始========");
		
		//预支人员统计查询件数取得 
		int totalCount = this.advanceSummaryBL.getSearchCount(dto.getAdvancesummaryCond());
		
		if (totalCount == 0) {
			log.debug("========预支月度统计查询数据不存在========");
			//预支人员统计查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========预支月度统计查询数据件数过多========");
			//预支人员统计查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//当前页信息取得
		List<AdvanceSummary> advancesummaryList = this.advanceSummaryBL.searchAdvanceSummaryByEmp(dto.getAdvancesummaryCond(), 0, 0);

		dto.setAdvanceSummarylList(advancesummaryList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========预支月度统计查询处理终了========");
		return dto;
	}

	/**
	 * 还款发票查询处理
	 *
	 * @param dto IGLOM01DTO
	 * @return IGLOM01DTO
	 */
	public IGLOM03DTO searchLoanPayInvoiceAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========还款发票查询处理开始========");

		//输入Form取得
		IGLOM0313Form form = dto.getIglom0313Form();
		LoanPayDetailSearchCondImpl cond = new LoanPayDetailSearchCondImpl();
		cond.setLdid_invoice(form.getLdid());
		
		//还款取得
		List<LoanPayDetail> loanPayDetailList = this.loanPayDetailBL.searchLoanPayDetail(cond, 0, 0);
		//借款取得
		LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(form.getLdid());
		BigDecimal[] db = this.loanPayDetailBL.searchAmountdAndInvoice(lpd.getLpdid());
	
		dto.setLoanPayDetailList(loanPayDetailList);
		dto.setLoanPayDetailData(lpd);
		dto.setDb(db);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002"));
		
		log.debug("========还款发票查询处理终了========");
		
		return dto;
		
	}

	/**
	 * 确认还款处理
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 * 
	 */
	public IGLOM03DTO changeLoanPayInvoiceAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========还款确认处理开始========");

		//输入Form取得
		IGLOM0313Form form = dto.getIglom0313Form();

		LoanPayDetail lpd = this.loanPayDetailBL.searchLoanPayDetailByKey(form.getLdid());
		LoanPayDetailTB lpdTB = (LoanPayDetailTB)SerializationUtils.clone(lpd);
		lpdTB.setLpdstatus(IGLOMCONSTANTS.LPD_STATUS_YIHUANKUAN);
		//问题编号0000409
		//lpdTB.setLpdstockamount(this.advanceSummaryBL.searchStockAmount());
		this.loanPayDetailBL.updateLoanPayDetail(lpdTB);
		//修改库存金额
		this.advanceSummaryBL.payConfirm(lpd);
		dto.addMessage(new ActionMessage("IGCO10000.I010","还款"));

		log.debug("========还款确认处理开始========");
		return dto;
	}

	/**
	 * 还款删除发票
	 *
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO deleteLoanPayInvoiceAction(IGLOM03DTO dto)
			throws BLException {

		log.debug("========还款发票删除处理开始========");

		//输入Form取得
		IGLOM0313Form form = dto.getIglom0313Form();
		this.loanPayDetailBL.searchLoanPayDetailByKey(form.getLpdid());
//		//更新库存金额
//		if(IGLOMCONSTANTS.LPD_TYPE_PAY.equals(lpd.getLpdtype())){
//			this.advanceSummaryBL.delPayByCash(lpd);
//			
//		} else if (IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE.equals(lpd.getLpdtype())){
//			this.advanceSummaryBL.delPayByInvoice(lpd);
//		}
		this.loanPayDetailBL.deleteLoanPayDetail(form.getLpdid());
		dto.addMessage(new ActionMessage("IGCO10000.I006","还款记录"));
		
		log.debug("========还款发票删除处理开始========");
		return dto;
	}

	/**
	 * 还款新增处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO insertPayInvioceAction(IGLOM03DTO dto) throws BLException {
		
		//取得form
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
//		//更新库存金额
//		if(IGLOMCONSTANTS.LPD_TYPE_PAY.equals(form.getLpdtype())){
//			this.advanceSummaryBL.addPayByCash(lpd);
//			
//		} else if (IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE.equals(form.getLpdtype())){
//			this.advanceSummaryBL.addPayByInvoice(lpd);
//		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I004","还款"));
		return dto;
	}


	/**
	 * 预支汇总定时任务处理
	 * 
	 * @param dto IGLOM03DTO
	 * @return IGLOM03DTO
	 */
	public IGLOM03DTO advanceSummaryJob(IGLOM03DTO dto) throws BLException {
		
		String date = IGStringUtils.getCurrentDate();
		
		List<AdvanceSummary> asList = advanceSummaryBL.searchAdvanceSummary(new AdvanceSummarySearchCondImpl(), 0, 0);
		
		AdvanceSummaryTB asTB = new AdvanceSummaryTB();
		asTB.setAsyear(date.substring(0,4));//年度
		asTB.setAsmonth(date.substring(5,7));//月份
		
		//第一次运行
		if(asList.isEmpty()) {
			asTB.setAsprebalance(new BigDecimal(0));//上月余额
			asTB.setAsadvancescost(new BigDecimal(0));//本月预支金额
			asTB.setAsloan(new BigDecimal(0));//借款金额
			asTB.setAsinvoice(new BigDecimal(0));//本月发票金额
			asTB.setAspay(new BigDecimal(0));//本月还款金额
			asTB.setAsbalance(new BigDecimal(0));//本月余额
			asTB.setAsfreeze(new BigDecimal(0));//冻结金额
		} else {
			//上月记录
			AdvanceSummary as = asList.get(0);
			asTB.setAsprebalance(as.getAsbalance());//上月余额
			asTB.setAsadvancescost(new BigDecimal(0));//本月预支金额
			asTB.setAsloan(as.getAsloan());//借款金额
			asTB.setAsinvoice(new BigDecimal(0));//本月发票金额
			asTB.setAspay(new BigDecimal(0));//本月还款金额
			asTB.setAsbalance(as.getAsbalance());//本月余额
			asTB.setAsfreeze(as.getAsfreeze());//冻结金额
		}
		advanceSummaryBL.registAdvanceSummary(asTB);
		return dto;
	}
}
