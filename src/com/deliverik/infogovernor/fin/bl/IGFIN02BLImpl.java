/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * �����߼�ʵ��
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
		dto.addMessage(new ActionMessage("IGCO10000.I004", "������Ϣ"));
		log.debug("========���õǼǴ�������========");
		return dto;
	}

	private String insertFileAction(IGFIN02DTO dto) throws BLException {
		IGFIN0201Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����
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
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ����ID
				pathBuf.append("fin");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// �ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey
							+ "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// �ϴ��ļ�������
				attachment.setAttname(attkey + "_" + fileName.toString());
				// �ϴ��ļ���URL
				attachment.setAtturl("fin");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}

	public IGFIN02DTO searchExpenseAction(IGFIN02DTO dto) throws BLException {
		log.debug("========���ü�������ʼ========");
		int totalCount = this.expenseBL.getSearchCount(dto
				.getExpenseSearchCond());
		if (totalCount == 0) {
			log.debug("========���ü������ݲ�����========");
			// ���ü������ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========���ü������ݼ�������========");
			// ���ü������ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		// ��ǰҳԤ����Ϣȡ��
		List<Expense> expenseList = this.expenseBL.findByCond(dto
				.getExpenseSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setExpenseList(expenseList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========���ü�����������========");
		return dto;
	}

	public IGFIN02DTO initIGFIN0206Action(IGFIN02DTO dto) throws BLException {
		log.debug("========������ϸ��Ϣ���������ʾ����ʼ========");
		// Ԥ�������Ϣ��ѯ
		Expense expense = this.expenseBL.findByPK(dto.getBid());
		dto.setExpense(expense);
		if(StringUtils.isNotEmpty(expense.getExattkey())){
			List<Attachment> attachmentList = attachmentBL
			.searchAttachmentsByAttkey(expense.getExattkey());
			dto.setAttachmentList(attachmentList);			
		}
		log.debug("========������ϸ��Ϣ���������ʾ��������========");
		return dto;
	}

	public IGFIN02DTO deleteExpenseAction(IGFIN02DTO dto) throws BLException {
		log.debug("========����ɾ������ʼ========");
		// ����ɾ������
		this.expenseBL.delete(dto.getDeleteExpense());
		dto.addMessage(new ActionMessage("IGCO10000.I006", "����"));
		log.debug("========����ɾ����������========");
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
