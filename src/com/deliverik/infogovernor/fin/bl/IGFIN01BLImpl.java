/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * Ԥ���߼�ʵ��
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
	 * ����pbsummaryVWBL
	 * @param pbsummaryVWBL  pbsummaryVWBL
	 */
	public void setPbsummaryVWBL(PbsummaryVWBL pbsummaryVWBL) {
		this.pbsummaryVWBL = pbsummaryVWBL;
	}

	public IGFIN01DTO insertBudgetTBDAOAction(IGFIN01DTO dto)
			throws BLException {
		log.debug("========Ԥ��ǼǴ���ʼ========");
		Budget budget = this.budgetBL.save(dto.getBudget());

		dto.setBudget(budget);

		dto.addMessage(new ActionMessage("IGCO10000.I004", "Ԥ����Ϣ"));

		log.debug("========Ԥ��ǼǴ�������========");
		return dto;
	}

	public IGFIN01DTO searchBudgetAction(IGFIN01DTO dto) throws BLException {
		log.debug("========Ԥ���������ʼ========");
		log.debug(dto.getBudgetSearchCond());
		int totalCount = this.budgetBL
				.getSearchCount(dto.getBudgetSearchCond());

		if (totalCount == 0) {
			log.debug("========Ԥ��������ݲ�����========");
			// Ԥ��������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========Ԥ��������ݼ�������========");
			// Ԥ��������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳԤ����Ϣȡ��
		List<Budget> budgetList = this.budgetBL.findByCond(
				dto.getBudgetSearchCond(), pDto.getFromCount(),
				pDto.getPageDispCount());
		
		List<IGFIN0102Form> budgetFormList = new ArrayList<IGFIN0102Form>();
		if(budgetList!=null&&budgetList.size()>0){
			for(Budget budget : budgetList){
				IGFIN0102Form form = new IGFIN0102Form();
				//��ѯԤ������Ŀ�Ĺ�ϵ��
				PbsummaryVWSearchCondImpl cond = new PbsummaryVWSearchCondImpl();
				cond.setBid(budget.getBid());
				List<Pbsummary> list = pbsummaryVWBL.searchPbsummary(cond, 0, 0);
				boolean isHasProject = false;
				for(Pbsummary pbsummary : list){
					//�ж�Ԥ�����Ƿ�����Ŀ
					if(pbsummary.getPid()!=null&&pbsummary.getPid()!=0){
						isHasProject = true;
						break;
					}
				}
				//�ж�Ԥ�����Ƿ�����Ŀ
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
		log.debug("========Ԥ�������������========");
		return dto;
	}

	/**
	 * Ԥ����ǰ����ʾ
	 */
	public IGFIN01DTO initIGFIN0102Action(IGFIN01DTO dto) throws BLException {
		log.debug("========Ԥ����������ʾ����ʼ========");
		// Ԥ�������Ϣ��ѯ
		IGFIN0102Form form = dto.getIgfin0102Form();
		Budget budget = this.budgetBL.findByPK(form.getBid());
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#.##");

		//��ѯԤ������Ŀ�Ĺ�ϵ��
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
		//�ж�Ԥ�����Ƿ�����Ŀ�Լ�Ԥ������ý��
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
		log.debug("========Ԥ����������ʾ��������========");

		return dto;
	}

	public IGFIN01DTO initIGFIN0103Action(IGFIN01DTO dto) throws BLException {
		log.debug("========Ԥ����ϸ��Ϣ���������ʾ����ʼ========");
		// Ԥ�������Ϣ��ѯ
		Budget budget = this.budgetBL.findByPK(dto.getBid());

		dto.setBudget(budget);

		log.debug("========Ԥ����ϸ��Ϣ���������ʾ��������========");

		return dto;
	}

	public IGFIN01DTO deleteBudgetAction(IGFIN01DTO dto) throws BLException {

		log.debug("========Ԥ��ɾ������ʼ========");
		Integer bid = dto.getDeleteBudget();

		ExpenseSearchCondImpl cond = new ExpenseSearchCondImpl();
		cond.setBid(bid);

		List<Expense> expenseList = this.expenseBL.findByCond(cond, 0, 0);
		if (expenseList != null && expenseList.size() > 0) {
			return null;
		}

		// Ԥ��ɾ������
		this.budgetBL.delete(bid);
		dto.addMessage(new ActionMessage("IGCO10000.I006", "Ԥ��"));
		log.debug("========Ԥ��ɾ����������========");
		return dto;
	}

	public IGFIN01DTO updateBudgetAction(IGFIN01DTO dto) throws BLException {

		log.debug("========Ԥ��������ʼ========");

		// Ԥ��������
		this.budgetBL.save(dto.getBudget());

		dto.addMessage(new ActionMessage("IGCO10000.I005", "Ԥ�������Ϣ"));
		log.debug("========Ԥ������������========");

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
	 * ��Ŀ�Ǽ�ҳ��Ԥ�㼯�ϳ�ʼ��
	 */
	public IGFIN01DTO initProjectBudgetList(IGFIN01DTO dto) throws BLException {
		// ��ȡϵͳ��ǰ��ݣ�
		String currentYear = IGStringUtils.getCurrentYear();
		Integer current=Integer.valueOf(currentYear);
		// ȡ��ǰ�����
		Integer before=current-2;
		String beforeYear=before.toString();
		//��ѯ���
		PbsummaryVWSearchCondImpl cond = new PbsummaryVWSearchCondImpl();
		cond.setByear_begin(beforeYear);
		cond.setByear_end(currentYear);
		//��ȡԤ��id
		String[] bids=null;
		if(dto.getIgfin0102Form().getBids()!=null){
			bids= dto.getIgfin0102Form().getBids().split(",");
		}
		List<Pbsummary> pbsummaryList = pbsummaryVWBL.searchPbsummary(cond, 0, 0);
		List<Pbsummary> pbsumarydataList = new ArrayList<Pbsummary>();
		for(Pbsummary temp:pbsummaryList){
			boolean flag = true;
			//������ѡԤ��
			if(bids!=null&&bids.length>0){
				for(String bid:bids){
					if(temp.getBid().toString().equals(bid)){
						flag = false;
						break;
					}
				}
			}
			//�����ظ�Ԥ��
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
