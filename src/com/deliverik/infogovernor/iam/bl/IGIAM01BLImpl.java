/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
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
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.iam.bl.task.InternalauditprjBL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;
import com.deliverik.infogovernor.iam.form.IGIAM0102Form;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCondImpl;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
 * ������Ŀ�����߼�ʵ��
 *
 */
public class IGIAM01BLImpl extends BaseBLImpl implements IGIAM01BL {

	static Log log = LogFactory.getLog(IGIAM01BLImpl.class);
	
	/** ������Ŀ����ز���TaskBL */
	protected InternalauditprjBL internalauditprjBL;
	
	protected FileUploadBL fileUploadBL;
	
	protected AttachmentBL attachmentBL;
	
	protected IG599BL ig599BL;
	
	
	/**
     * ig599BL�趨
     *
     * @param ig599bl ig599BL
     */
    public void setIg599BL(IG599BL ig599bl) {
        ig599BL = ig599bl;
    }

    /** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * internalauditprjBLȡ��
	 *
	 * @return internalauditprjBL internalauditprjBL
	 */
	public InternalauditprjBL getinternalauditprjBL() {
		return internalauditprjBL;
	}
	
	/**
	 * internalauditprjBL�趨
	 *
	 * @param internalauditprjBL internalauditprjBL
	 */
	public void setinternalauditprjBL(InternalauditprjBL internalauditprjBL) {
		this.internalauditprjBL = internalauditprjBL;
	}
	/**
	 * internalauditprjBLȡ��
	 *
	 * @return internalauditprjBL internalauditprjBL
	 */
	public InternalauditprjBL getInternalauditprjBL() {
		return internalauditprjBL;
	}

	/**
	 * internalauditprjBL�趨
	 *
	 * @param internalauditprjBL internalauditprjBL
	 */
	public void setInternalauditprjBL(InternalauditprjBL internalauditprjBL) {
		this.internalauditprjBL = internalauditprjBL;
	}

	/**
	 * fileUploadBLȡ��
	 *
	 * @return fileUploadBL fileUploadBL
	 */
	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}

	/**
	 * fileUploadBL�趨
	 *
	 * @param fileUploadBL fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * attachmentBLȡ��
	 *
	 * @return attachmentBL attachmentBL
	 */
	public AttachmentBL getAttachmentBL() {
		return attachmentBL;
	}

	/**
	 * attachmentBL�趨
	 *
	 * @param attachmentBL attachmentBL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * ������Ŀ������Ϣ��ҳ��ѯ����
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO searchIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========������Ŀ�ķ�ҳ��ѯ��ʼ========");
		//������Ŀ���ѯ������ʼ��
		InternalauditprjSearchCondImpl cond = new InternalauditprjSearchCondImpl();
		//ʵ����form
		IGIAM0102Form form = dto.getIgIAM0102Form();
		//��ѯ����ʵ����
		cond.setIapYear_eq(form.getIapYear());//���
		cond.setIapName_like(form.getIapName());//�����Ŀ����
		cond.setIapStatus_eq(form.getIapStatus());//״̬
		cond.setIapOpenTimeFrom_ge(form.getIapOpenTimeFrom());//������ڴ�
		cond.setIapOpenTimeTo_le(form.getIapOpenTimeTo());//������ڵ�
		cond.setIapType_eq(form.getIapType());//���״̬
		//��ѯ�����
		int totalCount = internalauditprjBL.getSearchCount(cond);
		//��ѯ���ݲ�����
		if (totalCount == 0) {
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<InternalauditprjInfo> interList = internalauditprjBL.searchInternalauditprj(cond, 
				pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		//��ѯ������Ŀ�Ƿ���ڼ������
		List<IGIAM0101Form> formList = new ArrayList<IGIAM0101Form>();
		for(InternalauditprjInfo info : interList){
			IGIAM0101Form iForm = new IGIAM0101Form();
			iForm.setIapId(info.getIapId());
			iForm.setIapName(info.getIapName());//������Ŀ����
			iForm.setIapYear(info.getIapYear());//���
			iForm.setIapObject(info.getIapObject());//��ƶ���
			iForm.setIapWay(info.getIapWay());//��Ʒ�ʽ
			iForm.setIapUserName(info.getIapUserName());//�����Ա
			iForm.setIapStatus(info.getIapStatus());//״̬
			iForm.setIapSource(info.getIapSource());//�����Դ
			iForm.setIapOpenTime(info.getIapOpenTime());//��鿪ʼʱ��
			IG599SearchCondImpl condImpl = new IG599SearchCondImpl();
			condImpl.setPivarlabel(IGIAMCONSTANT.PROJECT_LABEL);
			condImpl.setPivarvalue(String.valueOf(info.getIapId()));
			List<IG599Info> ig599Infos =ig599BL.searchIG599InfosByCond(condImpl);
			if(ig599Infos.size()>0){
				iForm.setHasProblem("Y");
			}
			else
				iForm.setHasProblem("N");
			formList.add(iForm);
		}
		//����ѯ�������װ��dto��
		dto.setInternalauditprjInfoList(formList);
		log.debug("========������Ŀ�ķ�ҳ��ѯ����========");
		return dto;
	}
	
	/**
	 * ������Ŀ�޸Ĳ�ѯ����
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO dsearchIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========������Ŀ�鿴��ѯ����ʼ========");
		//ʵ����form
		IGIAM0101Form form = dto.getIgIAM0101Form();
		//����DAO�ӿڲ�ѯ
		InternalauditprjInfo info = internalauditprjBL.searchInternalauditprjByPK(form.getIapId());
		List<Attachment> attkeyList = null;
		if (info.getIapAttKey() != null && !info.getIapAttKey().equals("")) {
			//�������ϴ�����
			attkeyList = attachmentBL.searchAttachmentsByAttkey(info.getIapAttKey());
		}
		//����ʵ����form
		form.setIapYear(info.getIapYear());//���
		form.setIapStatus(info.getIapStatus());//״̬
		form.setIapName(info.getIapName());//������Ŀ����
		form.setIapWay(info.getIapWay());//��Ʒ�ʽ
		form.setIapObject(info.getIapObject());//��ƶ���
		form.setIapUserName(info.getIapUserName());//�����Ա
		form.setIapOpenTime(info.getIapOpenTime());//��ƿ�ʼ����
		form.setIapCloseTime(info.getIapCloseTime());//��ƽ�������
		form.setIapObjective(info.getIapObjective());//���Ŀ��
		form.setIapScope(info.getIapScope());//��Ʒ�Χ
		form.setIapBasis(info.getIapBasis());//�������
		form.setIapDesc(info.getIapDesc());//������ݼ�Ҫ��
		form.setIapSource(info.getIapSource());//��Ƽ����Դ
		form.setIapCooperator(info.getIapCooperator());//�����Ա
		form.setIapSuggestion(info.getIapSuggestion());//����
		form.setIapType(info.getIapType());//���״̬
		form.setIapAttKey(info.getIapAttKey());//����
		
		dto.setAttkeyList(attkeyList);
		log.debug("========������Ŀ�鿴��ѯ�������========");
		return dto;
	}
	
	/**
	 * ������Ŀ���´���
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO updateIAMAction(IGIAM01DTO dto) throws BLException {

		log.debug("========������Ŀ���´���ʼ========");
		//ʵ����form
		IGIAM0101Form form = dto.getIgIAM0101Form();
		if (StringUtils.isNotEmpty(form.getDeletekeys())) {
			String[] keys = form.getDeletekeys().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
		}
		if(form.getFileMap().size() > 0){
			String attkey = updateFileAction(dto);
			form.setIapAttKey(attkey);
		}
		
		//�ʼĿ���ǼǱ�ʵ��ӿڳ�ʼ��
		InternalauditprjInfo info = internalauditprjBL.searchInternalauditprjByPK(form.getIapId());
		//ʹSysPostInfo�е�������SysPostInfoTB����ʹ��ʵ�廯
		InternalauditprjTB infoTB = (InternalauditprjTB) SerializationUtils.clone(info);

		infoTB.setIapId(form.getIapId());//����
		infoTB.setIapYear(form.getIapYear());//���
		infoTB.setIapStatus(form.getIapStatus());//״̬
		infoTB.setIapName(form.getIapName());//������Ŀ����
		infoTB.setIapObject(form.getIapObject());//��ƶ���
		infoTB.setIapWay(form.getIapWay());//��Ʒ�ʽ
		infoTB.setIapUserName(form.getIapUserName());//�����Ա
		infoTB.setIapOpenTime(form.getIapOpenTime());//��ƿ�ʼ����
		infoTB.setIapCloseTime(form.getIapCloseTime());//��ƽ�������
		infoTB.setIapObjective(form.getIapObjective());//���Ŀ��
		infoTB.setIapScope(form.getIapScope());//��Ʒ�Χ
		infoTB.setIapBasis(form.getIapBasis());//�������
		infoTB.setIapDesc(form.getIapDesc());//������ݼ�Ҫ��
		infoTB.setIapAttKey(form.getIapAttKey());//����
		
		//�ж������Ա�Ƿ�Ϊ��
		if (form.getIapCooperator() != null) {
			infoTB.setIapCooperator(form.getIapCooperator());//�����Ա
		}
		//�жϽ����Ƿ�Ϊ��
		if (form.getIapSuggestion() != null) {
			infoTB.setIapSuggestion(form.getIapSuggestion());//����
		}
		//�ж���Ƽ����Դ�Ƿ�Ϊ��
		if (form.getIapSource() != null) {
			infoTB.setIapSource(form.getIapSource());//��Ƽ����Դ
		}
		//����ҵ�񷽷���������
		InternalauditprjInfo internalauditprj = internalauditprjBL.updateInternalauditprj(infoTB);
		if (internalauditprj.getIapType().equals("0")) {
			//������Ϣ��Ϣ
			dto.addMessage(new ActionMessage("IGIAJ0101.I001", "������Ŀ"));
		} else {
			//������Ϣ��Ϣ
			dto.addMessage(new ActionMessage("IGIAJ0301.I001", "������Ŀ"));
		}
		log.debug("========������Ŀ���´������========");
		return dto;
	}
	
	/**
	 * ������Ŀɾ������
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO deleteIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========������Ŀɾ������ʼ========");
		//ȡ��������Ŀ���������
		Integer iapId = dto.getIgIAM0101Form().getIapId();
		//�������������𽥲�ѯ
		InternalauditprjInfo info = internalauditprjBL.searchInternalauditprjByPK(iapId);
		//�������׳��쳣
		if (info == null) {
			throw new BLException("IGCO10000.E004", "ɾ��������Ŀ����");
		}
		//����ҵ�񷽷�ɾ������
		internalauditprjBL.deleteInternalauditprjByPK(iapId);
		
		//������Ϣ��Ϣ
		dto.addMessage(new ActionMessage("IGIAM0101.I002", "������Ŀ"));
		log.debug("========������Ŀɾ���������========");
		return dto;
	}
	
	/**
	 * ������Ŀ��Ӵ���
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO insertIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========������Ŀ��Ӵ���ʼ========");
		//ʵ����������Ϣ
		IGIAM0101Form attachFile = (IGIAM0101Form)dto.getAttachFile();
		if (attachFile.getFileMap() != null) {
			String attkey = insertFileAction(dto);
			attachFile.setIapAttKey(attkey);
		}
		dto.setIgIAM0101Form(attachFile);
		//ʵ����form
		IGIAM0101Form form = dto.getIgIAM0101Form();
		//��ƹ����ʵ��ӿڳ�ʼ��
		InternalauditprjTB infoTB = new InternalauditprjTB();
		
		infoTB.setIapId(form.getIapId());//����
		infoTB.setIapYear(form.getIapYear());//���
		infoTB.setIapStatus(form.getIapStatus());//״̬
		infoTB.setIapName(form.getIapName());//������Ŀ����
		infoTB.setIapObject(form.getIapObject());//��ƶ���
		infoTB.setIapWay(form.getIapWay());//��Ʒ�ʽ
		infoTB.setIapUserName(form.getIapUserName());//�����Ա
		infoTB.setIapOpenTime(form.getIapOpenTime());//��ƿ�ʼ����
		infoTB.setIapCloseTime(form.getIapCloseTime());//��ƽ�������
		infoTB.setIapObjective(form.getIapObjective());//���Ŀ��
		infoTB.setIapScope(form.getIapScope());//��Ʒ�Χ
		infoTB.setIapBasis(form.getIapBasis());//�������
		infoTB.setIapDesc(form.getIapDesc());//������ݼ�Ҫ��
		infoTB.setIapType(form.getIapType());//���״̬
		infoTB.setIapSource(form.getIapSource());//��Ƽ����Դ
		infoTB.setIapAttKey(form.getIapAttKey());//����
		
		//����ҵ�񷽷��������
		internalauditprjBL.registInternalauditprj(infoTB);
		//������Ϣ��Ϣ
		dto.addMessage(new ActionMessage("IGIAM0101.I002", "������Ŀ"));
		log.debug("========������Ŀ��Ӵ������========");
		return dto;
	}

	/**
	 * ����ļ���������
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	private String insertFileAction(IGIAM01DTO dto) throws BLException {
		IGIAM0101Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����

		String attkey = null;
		if (form.getFileMap() != null) {
			attkey = IGStringUtils.getAttKey();
			attachment.setAttkey(attkey);
		}
		Map<Integer, FormFile> map = form.getFileMap();
		Iterator<Integer> iterator = map.keySet().iterator();
		
		while(iterator.hasNext()){
			FormFile file = (FormFile) map.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ����ID
				pathBuf.append("iam");
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
				attachment.setAtturl("iam");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}
	
	/**
	 * �������Ǽ�ҳ������Ŀ����ҳ��ѯ
	 */
	public IGIAM01DTO helpSearch(IGIAM01DTO dto) throws BLException {
		log.debug("========�������Ǽ�ҳ������Ŀ����ҳ��ѯ����ʼ========");
		//������Ŀ���ѯ������ʼ��
		InternalauditprjSearchCondImpl cond = new InternalauditprjSearchCondImpl();
		//ʵ����form
		IGIAM0102Form form = dto.getIgIAM0102Form();
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		if(!"1".equals(form.getIapType())){
			//�����������Ŀ������״̬
			cond.setIapStatus_eq(form.getIapStatus());//������Ŀ״̬
		}
		cond.setIapType_eq(form.getIapType());//��Ŀ����
		cond.setIapYear_eq(form.getIapYear());//��Ŀ���
		cond.setIapOpenTimeFrom_ge(form.getIapOpenTimeFrom());//��ƿ�ʼʱ��
		cond.setIapOpenTimeTo_le(form.getIapOpenTimeTo());//��ƽ���ʱ��
		cond.setIapName_like(form.getIapName());//��Ŀ����
		List<InternalauditprjInfo> interList = internalauditprjBL.searchInternalauditprj(cond, pDto.getFromCount(), pDto.getPageDispCount());
		//��ѯ�����
		int totalCount = internalauditprjBL.getSearchCount(cond);
		//��ѯ���ݲ�����
		if (totalCount == 0) {
			return dto;
		}
		
		pDto.setTotalCount(totalCount);
		dto.setHelpSearchList(interList);
		log.debug("========�������Ǽ�ҳ������Ŀ����ҳ��ѯ�������========");
		return dto;
	}
	
	/**
	 * �������Ǽ�ҳ������Ŀ����ҳ��ѯ
	 */
	public IGIAM01DTO auditProjectHelpSearch(IGIAM01DTO dto) throws BLException {
		log.debug("========�������Ǽ�ҳ������Ŀ����ҳ��ѯ����ʼ========");
		//������Ŀ���ѯ������ʼ��
		InternalauditprjSearchCondImpl cond = new InternalauditprjSearchCondImpl();
		//ʵ����form
		IGIAM0102Form form = dto.getIgIAM0102Form();
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		if(!"1".equals(form.getIapType())){
			//�����������Ŀ������״̬
			cond.setIapStatus_eq(form.getIapStatus());//������Ŀ״̬
		}
		cond.setIapType_eq(form.getIapType());//��Ŀ����
		cond.setIapYear_eq(form.getIapYear());//��Ŀ���
		cond.setIapOpenTimeFrom_ge(form.getIapOpenTimeFrom());//��ƿ�ʼʱ��
		cond.setIapOpenTimeTo_le(form.getIapOpenTimeTo());//��ƽ���ʱ��
		cond.setIapName_like(form.getIapName());//��Ŀ����
		List<InternalauditprjInfo> interList = internalauditprjBL.auditProjectHelpSearch(cond, pDto.getFromCount(), pDto.getPageDispCount());
		//��ѯ�����
		int totalCount = internalauditprjBL.auditProjectHelpSearchConut(cond);
		//��ѯ���ݲ�����
		if (totalCount == 0) {
			return dto;
		}
		
		pDto.setTotalCount(totalCount);
		dto.setHelpSearchList(interList);
		log.debug("========�������Ǽ�ҳ������Ŀ����ҳ��ѯ�������========");
		return dto;
	}

	/**
	 * �����ļ���������
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	private String updateFileAction(IGIAM01DTO dto) throws BLException {
		
		IGIAM0101Form form = dto.getIgIAM0101Form();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����

		String attkey = null;
		List<Attachment> attkeyList = null;
		if (form.getIapAttKey() != null) {		
			attkeyList = attachmentBL.searchAttachmentsByAttkey(form.getIapAttKey());
		} 
		if (attkeyList.size() > 0) {
			attkey = form.getIapAttKey();
		} else {
			attkey = IGStringUtils.getAttKey();
		}
		attachment.setAttkey(attkey);
		Map<Integer, FormFile> map = form.getFileMap();
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext()){
			FormFile file = (FormFile) map.get(iterator.next());
			if (file != null && file.getFileSize() > 0) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ����ID
				pathBuf.append("iam");
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
				attachment.setAtturl("iam");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}
}
