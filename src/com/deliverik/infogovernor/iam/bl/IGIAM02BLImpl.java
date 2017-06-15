/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.iam.bl.task.InternalauditJobBL;
import com.deliverik.infogovernor.iam.dto.IGIAM02DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0201Form;
import com.deliverik.infogovernor.iam.form.IGIAM0202Form;
import com.deliverik.infogovernor.iam.form.IGIAM0203Form;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditJobSearchCondImpl;
import com.deliverik.infogovernor.iam.model.entity.InternalauditJobTB;

/**
 * @author zhaomin
 *
 */
/**
 * ����: ����������ҵ���߼��ӿ�ʵ��
 * ���������� ����������ҵ���߼��ӿ�ʵ��
 * �����ˣ�����
 * ������¼�� 2012-7-25
 * �޸ļ�¼��
 */
public class IGIAM02BLImpl implements IGIAM02BL {

	static Log log = LogFactory.getLog(IGIAM02BLImpl.class);
	
	/**
	 * ����������ҵ���߼��ӿ�
	 */
	private InternalauditJobBL internalauditJobBL;
	
	protected FileUploadBL fileUploadBL;
	
	protected AttachmentBL attachmentBL;
	
	/**
	 * ��ȡinternalauditJobBL
	 * @return finternalauditJobBL internalauditJobBL
	 */
	public InternalauditJobBL getInternalauditJobBL() {
		return internalauditJobBL;
	}

	/**
	 * ����internalauditJobBL
	 * @param internalauditJobBL  internalauditJobBL
	 */
	public void setInternalauditJobBL(InternalauditJobBL internalauditJobBL) {
		this.internalauditJobBL = internalauditJobBL;
	}
	
	/**
	 * ��ȡfileUploadBL
	 * @return ffileUploadBL fileUploadBL
	 */
	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}

	/**
	 * ����fileUploadBL
	 * @param fileUploadBL  fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * ��ȡattachmentBL
	 * @return fattachmentBL attachmentBL
	 */
	public AttachmentBL getAttachmentBL() {
		return attachmentBL;
	}

	/**
	 * ����attachmentBL
	 * @param attachmentBL  attachmentBL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * ��������ѯ
	 */
	public IGIAM02DTO searchIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========��������ѯ��ʼ========");
		//������Ŀ���ѯ������ʼ��
		InternalauditJobSearchCondImpl cond = new InternalauditJobSearchCondImpl();
		//ʵ����form
		IGIAM0201Form form = dto.getIgiam0201form();
		//��ѯ����ʵ����
		cond.setIajIapId_q(form.getIajIapId_q());
		cond.setIajName_like(form.getIajName_like());
		cond.setIajYear_q(form.getIajYear_q());
		int totalCount = internalauditJobBL.getSearchCount(cond);
		//��ѯ���ݲ�����
		if (totalCount == 0) {
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<InternalauditJobInfo> interList = internalauditJobBL.searchInternalauditJob(cond, 
				pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setInternalauditJobList(interList);
		log.debug("========��������ѯ����========");
		return dto;
	}

	/**
	 * ����������
	 */
	public IGIAM02DTO dsearchIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========��������ϸ��ϸ��ѯ��ʼ========");
		IGIAM0203Form form = dto.getIgiam0203form();
		InternalauditJobInfo info = internalauditJobBL.searchInternalauditJobByPK(form.getIajid());
		List<Attachment> attkeyList = null;
		if (info.getIajattkey() != null) {		
			//�������ϴ�����
			attkeyList = attachmentBL.searchAttachmentsByAttkey(info.getIajattkey());
		} 
		form.setIajdesc(info.getIajdesc());
		form.setIajiapid(info.getIajiapid());
		form.setIajinserttime(info.getIajinserttime());
		form.setIajyear(info.getIajyear());
		form.setIajname(info.getIajname());
		form.setIajstarttime(info.getIajstarttime());
		form.setIajovertime(info.getIajovertime());
		form.setInternalauditprjTB(info.getInternalauditprjTB());
		form.setIajattkey(info.getIajattkey());
		
		dto.setIgiam0203form(form);
		dto.setAttkeyList(attkeyList);
		log.debug("========��������ϸ��ϸ��ѯ����========");
		return dto;
	}

	/**
	 * �������޸�
	 */
	public IGIAM02DTO updateIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========�������޸Ĵ���ʼ========");
		IGIAM0203Form form = dto.getIgiam0203form();
		//ɾ������
		if(StringUtils.isNotEmpty(form.getDeletekeys())){
			String[] keys = form.getDeletekeys().split(",");
			for(String key : keys){
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
			
		}

		if(form.getFileMap().size() > 0){
			String attkey = updateFileAction(dto);
			form.setIajattkey(attkey);
		}

		InternalauditJobTB iajTB = new InternalauditJobTB();
		iajTB.setIajid(form.getIajid());
		iajTB.setIajyear(form.getIajyear());//�ƻ����
		iajTB.setIajattkey(form.getIajattkey());//����  form.getIajattkey()
		iajTB.setIajdesc(form.getIajdesc());//������������
		iajTB.setIajiapid(form.getIajiapid());//������ĿID
		iajTB.setIajinserttime(form.getIajinserttime());//�Ǽ�ʱ��
		iajTB.setIajname(form.getIajname());//��������
		iajTB.setIajovertime(form.getIajovertime());//ʵ�ʹ�����������
		iajTB.setIajstarttime(form.getIajstarttime());//ʵ�ʹ�����ʼ����
		iajTB.setIajuserid(form.getIajuserid());//�Ǽ���ID
		InternalauditJobInfo info = internalauditJobBL.updateInternalauditJob(iajTB);
		if(null != info){
			dto.addMessage(new ActionMessage("IGIAJ0201.I002", "������"));
		}else{
			throw new BLException("IGIAM0201.E002","�������޸�ʧ�ܣ�");
		}
		log.debug("========�������޸Ĵ������========");
		return dto;
	}

	/**
	 * ������ɾ��
	 */
	public IGIAM02DTO deleteIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========������ ɾ������ʼ========");
		String iajids = dto.getIajids();
		if(StringUtils.isNotEmpty(iajids)){
			String [] id = iajids.split(",");
			for(int i=0; i<id.length; i++){
				String temp = StringUtils.replace(id[i], ",", "");
				try{
					Integer pk = new Integer(temp);
					internalauditJobBL.deleteInternalauditJobByPK(pk);	
				}catch(BLException e){
					throw new BLException("IGIAM0201.E003","������ɾ��ʧ�ܣ�");
				}
			}
			dto.addMessage(new ActionMessage("IGIAJ0201.I003", "������"));
		}
		log.debug("========������ɾ���������========");
		return dto;
	}

	/**
	 * ���ù�����������
	 */
	public IGIAM02DTO insertIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========��������������ʼ========");
		
		IGIAM0202Form attachFile = (IGIAM0202Form) dto.getAttachFile();
		if(attachFile.getFileMap() != null){
			String attkey = insertFileAction(dto);
			attachFile.setIajattkey(attkey);
		}
		IGIAM0202Form form = (IGIAM0202Form) dto.getAttachFile();

		//��ȡ��ǰϵͳʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String iajinserttime = sdf.format(new Date());

		InternalauditJobTB iajTB = new InternalauditJobTB();
		iajTB.setIajyear(form.getIajyear());//�ƻ����
		iajTB.setIajattkey(attachFile.getIajattkey());//����  form.getIajattkey()
		iajTB.setIajdesc(form.getIajdesc());//������������
		iajTB.setIajiapid(form.getIajiapid());//������ĿID
		iajTB.setIajinserttime(iajinserttime);//�Ǽ�ʱ��
		iajTB.setIajname(form.getIajname());//��������
		iajTB.setIajovertime(form.getIajovertime());//ʵ�ʹ�����������
		iajTB.setIajstarttime(form.getIajstarttime());//ʵ�ʹ�����ʼ����
		iajTB.setIajuserid(form.getIajuserid());//�Ǽ���ID
		
		InternalauditJobInfo info = internalauditJobBL.registInternalauditJob(iajTB);

		//�����Ƿ�ɹ�
		if(null != info){
			dto.addMessage(new ActionMessage("IGIAJ0201.I001", "������"));
		}else{
			throw new BLException("IGIAJ0201.E001","����������ʧ�ܣ�");
		}
		
		dto.setIgiam0202form(form);
		log.debug("========�����������������========");
		return dto;
	}

	private String insertFileAction(IGIAM02DTO dto) throws BLException {
		IGIAM0202Form form = dto.getAttachFile();
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

	private String updateFileAction(IGIAM02DTO dto) throws BLException {
		IGIAM0203Form form = dto.getIgiam0203form();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����

		String attkey = null;
		//�������ϴ�����
		List<Attachment> attkeyList = null;
		if (form.getIajattkey() != null) {		
			attkeyList = attachmentBL.searchAttachmentsByAttkey(form.getIajattkey());
		} 
		if (attkeyList.size() > 0) {
			attkey = form.getIajattkey();
		}else{
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
