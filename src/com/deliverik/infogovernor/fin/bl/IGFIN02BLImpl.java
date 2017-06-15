/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.fin.bl.task.BudgetBL;
import com.deliverik.infogovernor.fin.bl.task.ExpenseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN02DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0201Form;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCondImpl;

/**
 * 费用逻辑实现
 * 
 */
public class IGFIN02BLImpl extends BaseBLImpl implements IGFIN02BL {

	static Log log = LogFactory.getLog(IGFIN02BLImpl.class);

	protected BudgetBL budgetBL;
	protected ExpenseBL expenseBL;
	protected FileUploadBL fileUploadBL;
	protected AttachmentBL attachmentBL;

	public BudgetBL getBudgetBL() {
		return budgetBL;
	}

	public void setBudgetBL(BudgetBL budgetBL) {
		this.budgetBL = budgetBL;
	}

	public ExpenseBL getExpenseBL() {
		return expenseBL;
	}

	public void setExpenseBL(ExpenseBL expenseBL) {
		this.expenseBL = expenseBL;
	}

	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	public IGFIN02DTO insertExpenseTBDAOAction(IGFIN02DTO dto)
			throws BLException {
		Expense expense = dto.getExpense();
		IGFIN0201Form form = (IGFIN0201Form) dto.getExpense();
		Integer bid = expense.getBid();
		if (this.getBudgetBL().findByPK(bid) == null) {
			return null;
		}
		String attkey = insertFileAction(dto);
		form.setExattkey(attkey);
		Expense retExpense = this.expenseBL.save(form);
		dto.setExpense(retExpense);
		dto.addMessage(new ActionMessage("IGCO10000.I004", "费用信息"));
		log.debug("========费用登记处理终了========");
		return dto;
	}

	private String insertFileAction(IGFIN02DTO dto) throws BLException {
		IGFIN0201Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测
		Map a = form.getFileMap();
		String attkey = null;
		if (a != null && a.size() > 0) {
			attkey = IGStringUtils.getAttKey();
			attachment.setAttkey(attkey);
		}
		Iterator iterator = a.keySet().iterator();

		while (iterator.hasNext()) {
			FormFile file = (FormFile) a.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// 根目录
				pathBuf.append(rootPath);
				// 机能ID
				pathBuf.append("fin");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// 文件上传处理
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							+ "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// 上传文件名保存
				attachment.setAttname(attkey + "_" + fileName.toString());
				// 上传文件名URL
				attachment.setAtturl("fin");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}

	public IGFIN02DTO searchExpenseAction(IGFIN02DTO dto) throws BLException {
		log.debug("========费用检索处理开始========");
		int totalCount = this.expenseBL.getSearchCount(dto
				.getExpenseSearchCond());
		if (totalCount == 0) {
			log.debug("========费用检索数据不存在========");
			// 费用检索数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========费用检索数据件数过多========");
			// 费用检索数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		// 当前页预算信息取得
		List<Expense> expenseList = this.expenseBL.findByCond(dto
				.getExpenseSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setExpenseList(expenseList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========费用检索处理终了========");
		return dto;
	}

	public IGFIN02DTO initIGFIN0206Action(IGFIN02DTO dto) throws BLException {
		log.debug("========费用详细信息画面初期显示处理开始========");
		// 预算基本信息查询
		Expense expense = this.expenseBL.findByPK(dto.getBid());
		dto.setExpense(expense);
		if(StringUtils.isNotEmpty(expense.getExattkey())){
			List<Attachment> attachmentList = attachmentBL
			.searchAttachmentsByAttkey(expense.getExattkey());
			dto.setAttachmentList(attachmentList);			
		}
		log.debug("========费用详细信息画面初期显示处理终了========");
		return dto;
	}

	public IGFIN02DTO deleteExpenseAction(IGFIN02DTO dto) throws BLException {
		log.debug("========费用删除处理开始========");
		// 费用删除处理
		this.expenseBL.delete(dto.getDeleteExpense());
		dto.addMessage(new ActionMessage("IGCO10000.I006", "费用"));
		log.debug("========费用删除处理终了========");
		return dto;
	}

	public List<Expense> findExpenseByBid(String bid) throws BLException {
		ExpenseSearchCondImpl expenseSearchCond = new ExpenseSearchCondImpl();
		expenseSearchCond.setBid(Integer.valueOf(bid));
		List<Expense> expenseList = this.expenseBL.findByCond(
				expenseSearchCond, 0, 0);
		return expenseList;
	}
}
