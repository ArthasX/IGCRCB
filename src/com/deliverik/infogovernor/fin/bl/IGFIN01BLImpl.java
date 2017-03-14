/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.fin.bl.task.BudgetBL;
import com.deliverik.infogovernor.fin.bl.task.ExpenseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN01DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0102Form;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCondImpl;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCondImpl;
import com.deliverik.infogovernor.prj.bl.task.PbsummaryVWBL;
import com.deliverik.infogovernor.prj.bl.task.ProjectBL;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.Project;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCondImpl;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCondImpl;
import com.deliverik.infogovernor.util.SVCHelper;

/**
 * 预算逻辑实现
 * 
 */
public class IGFIN01BLImpl extends BaseBLImpl implements IGFIN01BL {

	static Log log = LogFactory.getLog(IGFIN01BLImpl.class);

	// protected BudgetTBDAO budgetTBDAO;

	// protected ExpenseTBDAO expenseTBDAO;

	protected ExpenseBL expenseBL;

	protected ProjectBL projectBL;
	
	protected PbsummaryVWBL pbsummaryVWBL;
	
	public void setProjectBL(ProjectBL projectBL) {
		this.projectBL = projectBL;
	}

	public void setExpenseBL(ExpenseBL expenseBL) {
		this.expenseBL = expenseBL;
	}

	protected BudgetBL budgetBL;

	public void setBudgetBL(BudgetBL budgetBL) {
		this.budgetBL = budgetBL;
	}

	public BudgetBL getBudgetBL() {
		return budgetBL;
	}
	
	/**
	 * 设置pbsummaryVWBL
	 * @param pbsummaryVWBL  pbsummaryVWBL
	 */
	public void setPbsummaryVWBL(PbsummaryVWBL pbsummaryVWBL) {
		this.pbsummaryVWBL = pbsummaryVWBL;
	}

	public IGFIN01DTO insertBudgetTBDAOAction(IGFIN01DTO dto)
			throws BLException {
		log.debug("========预算登记处理开始========");
		Budget budget = this.budgetBL.save(dto.getBudget());

		dto.setBudget(budget);

		dto.addMessage(new ActionMessage("IGCO10000.I004", "预算信息"));

		log.debug("========预算登记处理终了========");
		return dto;
	}

	public IGFIN01DTO searchBudgetAction(IGFIN01DTO dto) throws BLException {
		log.debug("========预算检索处理开始========");
		log.debug(dto.getBudgetSearchCond());
		int totalCount = this.budgetBL
				.getSearchCount(dto.getBudgetSearchCond());

		if (totalCount == 0) {
			log.debug("========预算检索数据不存在========");
			// 预算检索数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========预算检索数据件数过多========");
			// 预算检索数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页预算信息取得
		List<Budget> budgetList = this.budgetBL.findByCond(
				dto.getBudgetSearchCond(), pDto.getFromCount(),
				pDto.getPageDispCount());
		
		List<IGFIN0102Form> budgetFormList = new ArrayList<IGFIN0102Form>();
		if(budgetList!=null&&budgetList.size()>0){
			for(Budget budget : budgetList){
				IGFIN0102Form form = new IGFIN0102Form();
				//查询预算与项目的关系表
				PbsummaryVWSearchCondImpl cond = new PbsummaryVWSearchCondImpl();
				cond.setBid(budget.getBid());
				List<Pbsummary> list = pbsummaryVWBL.searchPbsummary(cond, 0, 0);
				boolean isHasProject = false;
				for(Pbsummary pbsummary : list){
					//判断预算下是否有项目
					if(pbsummary.getPid()!=null&&pbsummary.getPid()!=0){
						isHasProject = true;
						break;
					}
				}
				//判断预算下是否有项目
				if(isHasProject){
					form.setFirstbamount("N");
				}else{
					form.setFirstbamount("Y");
				}
				form.setByear(budget.getByear());
				form.setPquality(budget.getPquality());
				form.setBamount(budget.getBamount());
				form.setBtitle(budget.getBtitle());
				form.setBtype(budget.getBtype());
				form.setBdesc(budget.getBdesc());
				form.setBid(budget.getBid());
				form.setBcelse(budget.getBcelse());
				form.setBcimplement(budget.getBcimplement());
				form.setBzdevelop(budget.getBzdevelop());
				form.setBzelse(budget.getBzelse());
				form.setBzhardware(budget.getBzhardware());
				form.setBzproject(budget.getBzproject());
				form.setBzsoftware(budget.getBzsoftware());
				budgetFormList.add(form);
			}
		}
		pDto.setTotalCount(totalCount);

		dto.setBudgetFormList(budgetFormList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========预算检索处理终了========");
		return dto;
	}

	/**
	 * 预算变更前的显示
	 */
	public IGFIN01DTO initIGFIN0102Action(IGFIN01DTO dto) throws BLException {
		log.debug("========预算变更初期显示处理开始========");
		// 预算基本信息查询
		IGFIN0102Form form = dto.getIgfin0102Form();
		Budget budget = this.budgetBL.findByPK(form.getBid());
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#.##");

		//查询预算与项目的关系表
		PbsummaryVWSearchCondImpl cond = new PbsummaryVWSearchCondImpl();
		cond.setBid(form.getBid());
		List<Pbsummary> list = pbsummaryVWBL.searchPbsummary(cond, 0, 0);
		
		double bzdevelop = 0.0;
		double bzhardware = 0.0;
		double bzsoftware = 0.0;
		double bzproject = 0.0;
		double bzelse = 0.0;
		double bcimplement = 0.0;
		double bcelse = 0.0;
		//判断预算下是否有项目以及预算的已用金额
		if(list!=null&&list.size()>0){
			for (Pbsummary bsummary : list) {
				bzdevelop = SVCHelper.getAdd(bzdevelop, bsummary.getUse1());
				bzhardware = SVCHelper.getAdd(bzhardware, bsummary.getUse2());
				bzsoftware = SVCHelper.getAdd(bzsoftware, bsummary.getUse3());
				bzproject = SVCHelper.getAdd(bzproject, bsummary.getUse4());
				bzelse = SVCHelper.getAdd(bzelse, bsummary.getUse5());
				bcimplement = SVCHelper.getAdd(bcimplement, bsummary.getUse6());
				bcelse = SVCHelper.getAdd(bcelse, bsummary.getUse7());
			}
		}else{
			form.setFirstbamount("Y");
		}
		form.setByear(budget.getByear());
		form.setPquality(budget.getPquality());
		form.setBamount(budget.getBamount());
		form.setBtitle(budget.getBtitle());
		form.setBtype(budget.getBtype());
		form.setBdesc(budget.getBdesc());
		form.setBid(budget.getBid());
		form.setRemark(budget.getRemark());
		form.setPstorecode(budget.getPstorecode());
		form.setPneeddispart(budget.getPneeddispart());
		form.setPbuggetform(budget.getPbuggetform());
		form.setPuse(budget.getPuse());
		form.setBamount_show(df.format(form.getBamount()));
		form.setBcelse(Double.parseDouble(df.format(budget.getBcelse())));
		form.setBcimplement(Double.parseDouble(df.format(budget.getBcimplement())));
		form.setBzdevelop(Double.parseDouble(df.format(budget.getBzdevelop())));
		form.setBzelse(Double.parseDouble(df.format(budget.getBzelse())));
		form.setBzhardware(Double.parseDouble(df.format(budget.getBzhardware())));
		form.setBzproject(Double.parseDouble(df.format(budget.getBzproject())));
		form.setBzsoftware(Double.parseDouble(df.format(budget.getBzsoftware())));
		form.setBzdevelop_check(df.format(bzdevelop));
		form.setBzhardware_check(df.format(bzhardware));
		form.setBzsoftware_check(df.format(bzsoftware));
		form.setBzproject_check(df.format(bzproject));
		form.setBzelse_check(df.format(bzelse));
		form.setBcimplement_check(df.format(bcimplement));
		form.setBcelse_check(df.format(bcelse));
		log.debug("========预算变更初期显示处理终了========");

		return dto;
	}

	public IGFIN01DTO initIGFIN0103Action(IGFIN01DTO dto) throws BLException {
		log.debug("========预算详细信息画面初期显示处理开始========");
		// 预算基本信息查询
		Budget budget = this.budgetBL.findByPK(dto.getBid());

		dto.setBudget(budget);

		log.debug("========预算详细信息画面初期显示处理终了========");

		return dto;
	}

	public IGFIN01DTO deleteBudgetAction(IGFIN01DTO dto) throws BLException {

		log.debug("========预算删除处理开始========");
		Integer bid = dto.getDeleteBudget();

		ExpenseSearchCondImpl cond = new ExpenseSearchCondImpl();
		cond.setBid(bid);

		List<Expense> expenseList = this.expenseBL.findByCond(cond, 0, 0);
		if (expenseList != null && expenseList.size() > 0) {
			return null;
		}

		// 预算删除处理
		this.budgetBL.delete(bid);
		dto.addMessage(new ActionMessage("IGCO10000.I006", "预算"));
		log.debug("========预算删除处理终了========");
		return dto;
	}

	public IGFIN01DTO updateBudgetAction(IGFIN01DTO dto) throws BLException {

		log.debug("========预算变更处理开始========");

		// 预算变更处理
		this.budgetBL.save(dto.getBudget());

		dto.addMessage(new ActionMessage("IGCO10000.I005", "预算基本信息"));
		log.debug("========预算变更处理终了========");

		return dto;
	}

	@SuppressWarnings("unchecked")
	public IGFIN01DTO findBudgetByPcode(IGFIN01DTO dto) throws BLException {

		BudgetSearchCondImpl budgetSearchCond = new BudgetSearchCondImpl();
		budgetSearchCond.setPcode(dto.getPcode());
		List<Budget> budgetList = this.budgetBL.findByCond(budgetSearchCond, 0, 0);

		ExpenseSearchCondImpl cond = null;
		Map map = new HashMap();
		Map budgetIdNameMap = new HashMap();
		for (Budget budget : budgetList) {
			Integer bid = budget.getBid();
			cond = new ExpenseSearchCondImpl();
			cond.setBid(bid);
			List tempList = expenseBL.findByCond(cond, 0, 0);
			if (map.containsKey(bid)) {
				List tempexList = (List) map.get(bid);
				tempexList.add(tempList);
			} else {
				map.put(bid, tempList);
			}

			if (budgetIdNameMap.containsKey(bid)) {
				continue;
			} else {
				budgetIdNameMap.put(budget.getBid(), budget.getBtitle());
			}

		}
		dto.setBudgetIdExpenseListMap(map);
		dto.setBudgetIdNameMap(budgetIdNameMap);
		return dto;
	}

	/**
	 * 项目登记页面预算集合初始化
	 */
	public IGFIN01DTO initProjectBudgetList(IGFIN01DTO dto) throws BLException {
		// 获取系统当前年份：
		String currentYear = IGStringUtils.getCurrentYear();
		Integer current=Integer.valueOf(currentYear);
		// 取得前年年份
		Integer before=current-2;
		String beforeYear=before.toString();
		//查询结合
		PbsummaryVWSearchCondImpl cond = new PbsummaryVWSearchCondImpl();
		cond.setByear_begin(beforeYear);
		cond.setByear_end(currentYear);
		//获取预算id
		String[] bids=null;
		if(dto.getIgfin0102Form().getBids()!=null){
			bids= dto.getIgfin0102Form().getBids().split(",");
		}
		List<Pbsummary> pbsummaryList = pbsummaryVWBL.searchPbsummary(cond, 0, 0);
		List<Pbsummary> pbsumarydataList = new ArrayList<Pbsummary>();
		for(Pbsummary temp:pbsummaryList){
			boolean flag = true;
			//过滤已选预算
			if(bids!=null&&bids.length>0){
				for(String bid:bids){
					if(temp.getBid().toString().equals(bid)){
						flag = false;
						break;
					}
				}
			}
			//过滤重复预算
			if(pbsumarydataList.size()>0){
				for(Pbsummary pb:pbsumarydataList){
					if(temp.getBid().equals(pb.getBid())){
						flag = false;
						break;
					}
				}
			}
			if(flag){
				pbsumarydataList.add(temp);
			}
		}
		dto.setPbsummaryList(pbsumarydataList);
		return dto;
	}
}
