/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.iam.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.deliverik.infogovernor.iam.bl.task.AUDITPROJECTBL;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.dto.IGIAM03DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;
import com.deliverik.infogovernor.iam.form.IGIAM0301Form;
import com.deliverik.infogovernor.iam.form.IGIAM0302Form;
import com.deliverik.infogovernor.iam.form.IGIAM0303Form;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.AUDITPROJECTSearchCondImpl;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
 * ����: 
 * ����������
 * �����ˣ���ӿ��
 * ������¼�� 2012-8-8
 * �޸ļ�¼��
 */
public class IGIAM03BLImpl extends BaseBLImpl implements IGIAM03BL {
	
	static Log log = LogFactory.getLog(IGIAM03BLImpl.class);
	/** ��Ʊ���ҵ���߼��ӿ�*/
	private AUDITPROJECTBL auditProjectBL ;

	protected FileUploadBL fileUploadBL;
	
	protected AttachmentBL attachmentBL;
	
	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	public AttachmentBL getAttachmentBL() {
		return attachmentBL;
	}
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	public AUDITPROJECTBL getAuditProjectBL() {
		return auditProjectBL;
	}
	public void setAuditProjectBL(AUDITPROJECTBL auditProjectBL) {
		this.auditProjectBL = auditProjectBL;
	}
	
	/**
	 * ��ѯ��Ʊ�����Ϣ
	 * @param dto
	 * @return
	 */
	public IGIAM03DTO searchIAM03DTOAction(IGIAM03DTO dto){
		log.debug("========��������ѯ��ʼ========");
		//������ѯ������
		AUDITPROJECTSearchCondImpl cond = new AUDITPROJECTSearchCondImpl();
		//���form
		IGIAM0301Form form = dto.getIgiam0301Form();
		//���ò�ѯ����ֵ
		cond.setProjectName(form.getApprojectname());
		cond.setAuditReportType(form.getApreporttype());
		cond.setApprojectyear(form.getApprojectyear());
		//��ѯ��������
		int totalCount = auditProjectBL.getSearchCount(cond);
		//��ѯ���ݲ�����
		if (totalCount == 0) {
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		List<AUDITPROJECTInfo> projectList = auditProjectBL.searchAUDITPROJECT(cond,pDto.getFromCount(),pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setAuditProjectInfoList(projectList);
		return dto ;
	}
	
	/**
	 * ��Ʊ�����ϸ��Ϣ�鿴
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO dsearchIAMAction(IGIAM03DTO dto) throws BLException {
		
		log.debug("========��Ʊ���鿴��ѯ����ʼ========");
		//ʵ����form
		IGIAM0303Form form = dto.getIgiam0303Form();
		//����DAO�ӿڲ�ѯ
		AUDITPROJECTInfo tb = auditProjectBL.searchAUDITPROJECTByPK(form.getApid());
		List<Attachment> attkeyList = null;
		if (tb.getApattkey() != null && !tb.getApattkey().equals("")) {
			//�������ϴ�����
			attkeyList = attachmentBL.searchAttachmentsByAttkey(tb.getApattkey());
		}
		//����ʵ����form
		form.setApid(tb.getApid());
		form.setApprojectid(tb.getApprojectid());
		form.setApprojectname(tb.getApprojectname());
		form.setApprojectyear(tb.getApprojectyear());
		form.setApreporttype(tb.getApreporttype());
		form.setApattkey(tb.getApattkey());
		
		dto.setAttkeyList(attkeyList);
		log.debug("========��Ʊ���鿴��ѯ�������========");
		return dto;
	}
	
	/**
	 * ������Ʊ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO insertIAMAction(IGIAM03DTO dto) throws BLException {
		log.debug("========��Ʊ�����������ʼ========");
		
		//���渽��
		IGIAM0302Form attachFile = (IGIAM0302Form) dto.getAttachFile();
		if(attachFile.getFileMap() != null){
			String attkey = insertFileAction(dto);
			attachFile.setApattkey(attkey);
		}
		
		AUDITPROJECTTB tb = new AUDITPROJECTTB();
		tb.setApattkey(attachFile.getApattkey());
		tb.setApprojectid(attachFile.getApprojectid());
		tb.setApprojectname(attachFile.getApprojectname());
		tb.setApprojectyear(attachFile.getApprojectyear());
		tb.setApreporttype(attachFile.getApreporttype());
		tb.setFingerPrint("");

		AUDITPROJECTInfo info = auditProjectBL.registAUDITPROJECT(tb);

		//�����Ƿ�ɹ�
		if(null != info){
			dto.addMessage(new ActionMessage("IGIAJ0201.I001", "��Ʊ���"));
		}else{
			throw new BLException("IGIAJ0201.E001","��Ʊ�������ʧ�ܣ�");
		}
		
		dto.setIgiam0302Form(attachFile);
		log.debug("========��Ʊ��������������========");
		return dto;
	}

	/**
	 * ɾ����Ʊ���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO deleteIAMAction(IGIAM03DTO dto) throws BLException {
		log.debug("========��Ʊ���ɾ������ʼ========");
		String iajids = dto.getApids();
		if(StringUtils.isNotEmpty(iajids)){
			String [] id = iajids.split(",");
			for(int i=0; i<id.length; i++){
				String temp = StringUtils.replace(id[i], ",", "");
				try{
					Integer pk = new Integer(temp);
					AUDITPROJECTTB tb = (AUDITPROJECTTB)this.auditProjectBL.searchAUDITPROJECTByPK(pk);
					this.auditProjectBL.deleteAUDITPROJECT(tb);
					String key = tb.getApattkey();
					List<Attachment> fileList = this.attachmentBL.searchAttachmentsByAttkey(key);
					Iterator<Attachment> it = fileList.iterator();
					while(it.hasNext()){
						AttachmentTB fileTB = (AttachmentTB)it.next();
						this.attachmentBL.deleteAttachment(fileTB);
					}
				}catch(BLException e){
					throw new BLException("IGIAM0201.E003","��Ʊ���ɾ��ʧ�ܣ�");
				}
			}
			dto.addMessage(new ActionMessage("IGIAM0303.I001", "��Ʊ���ɾ���ɹ�"));
		}
		log.debug("========��Ʊ���ɾ���������========");
		return dto;
	}
	
	/**
	 * ������Ʊ�����Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO updateIAMAction(IGIAM03DTO dto) throws BLException {
		log.debug("========��Ʊ�����´���ʼ========");
		//ʵ����form
		IGIAM0303Form form = dto.getIgiam0303Form();
		if (StringUtils.isNotEmpty(form.getDeletekeys())) {
			//ɾ������
			String[] keys = form.getDeletekeys().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
		}
		if(form.getFileMap().size() > 0){
			//���¸���
			String attkey = updateFileAction(dto);
			form.setApattkey(attkey);
		}
		
		//��ѯ����
		AUDITPROJECTTB info = (AUDITPROJECTTB)this.auditProjectBL.searchAUDITPROJECTByPK(form.getApid());
		
		//������ֵ
		info.setApattkey(form.getApattkey());
		info.setApprojectid(form.getApprojectid());
		info.setApprojectname(form.getApprojectname());
		info.setApprojectyear(form.getApprojectyear());
		info.setApreporttype(form.getApreporttype());

		//����ҵ�񷽷���������
		this.auditProjectBL.updateAUDITPROJECT(info);
		
		dto.addMessage(new ActionMessage("IGIAJ0101.I001", "������Ŀ"));
		
		log.debug("========��Ʊ�����´������========");
		return dto;
	}
	
	/**
	 * ���渽��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private String insertFileAction(IGIAM03DTO dto) throws BLException {
		IGIAM0302Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����

		String attkey = null;
		if (form.getFileMap()!=null) {
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
	 * �����ļ���������
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	private String updateFileAction(IGIAM03DTO dto) throws BLException {
		
		IGIAM0303Form form = dto.getIgiam0303Form();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����

		String attkey = null;
		List<Attachment> attkeyList = null;
		if (form.getApattkey() != null) {		
			attkeyList = attachmentBL.searchAttachmentsByAttkey(form.getApattkey());
		} 
		if (attkeyList.size() > 0) {
			attkey = form.getApattkey();
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
