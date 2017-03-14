/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sya.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.sya.bl.task.InstitutionBL;
import com.deliverik.infogovernor.sya.dto.IGSYA01DTO;
import com.deliverik.infogovernor.sya.form.IGSYA0101Form;
import com.deliverik.infogovernor.sya.form.IGSYA0102Form;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;
import com.deliverik.infogovernor.sya.model.condition.InstitutionSearchCondImpl;
import com.deliverik.infogovernor.sya.model.entity.InstitutionTB;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * �ƶ�ҵ���߼�ʵ��
 * 
 */
public class IGSYA01BLImpl extends BaseBLImpl implements IGSYA01BL {

	static Log log = LogFactory.getLog(IGSYA01BLImpl.class);

	/** �ƶ���ϢBL */
	protected InstitutionBL institutionBL;

	protected FileUploadBL fileUploadBL;

	protected AttachmentBL attachmentBL;

	/**
	 * �ƶ���ϢBL�趨
	 * 
	 * @param riskcheckproblemsuperviseVWBL
	 *            �ƶ���ϢBL
	 */
	public void setInstitutionBL(InstitutionBL institutionBL) {
		this.institutionBL = institutionBL;
	}

	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * �ƶȲ�ѯ����
	 * 
	 * @param dto
	 *            IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSYA01DTO search(IGSYA01DTO dto) throws BLException {
		User user = dto.getUser();
		InstitutionSearchCondImpl cond = new InstitutionSearchCondImpl();
		IGSYA0101Form form = dto.getIgSYA0101Form();
		cond.setCreatetime_from(form.getCreatetime_from());
		cond.setCreatetime_to(form.getCreatetime_to());
		cond.setInname(form.getInname());
		cond.setIntype(form.getIntype());
		// ��ѯ��¼����
//		int totalCount = institutionBL.getSearchCount(cond);
		int totalCount = institutionBL.searchInstitution(cond, 0, 0).size();
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<InstitutionInfo> tsInfos = institutionBL.searchInstitution(cond, pDto.getFromCount(), pDto.getPageDispCount());
		List<InstitutionInfo> newList = new ArrayList<InstitutionInfo>();
		for (InstitutionInfo institutionInfo : tsInfos) {
			InstitutionTB institutionTB = (InstitutionTB)SerializationUtils.clone(institutionInfo);
			institutionTB.setIntype(institutionInfo.getIntype().split("_tree_")[1]);
			newList.add(institutionTB);
		}
		
		pDto.setTotalCount(totalCount);

		dto.setInstitutionList(newList);
		return dto;
	}

	/**
	 * ��������
	 * 
	 * @param instance
	 *            ����ʵ��
	 * @return ����ʵ��
	 */
	public IGSYA01DTO regist(IGSYA01DTO dto) throws BLException {
		log.debug("========�ƶ���������ʼ========");
		IGSYA0102Form form = dto.getAttachFile();
		InstitutionTB tb = new InstitutionTB();
		this.copyProperties(tb, form);
		// IGSYM0502Form form = dto.getAttachFile();
		if (form.getFileList(0).getFile() != null && !form.getFileList(0).getFile().getFileName().equals("")) {
			String attkey = insertFileListAction(dto);
			form.setAttkey(attkey);
			tb.setAttkey(attkey);
		}

		tb.setCreatetime(IGStringUtils.getCurrentDateTime());
		// ��ȡ��ǰ��¼�û���Ϣ
		User user = dto.getUser();
		tb.setInuserid(user.getUserid());
		tb.setInusername(user.getUsername());
		tb.setInorgid(user.getOrgid());
		tb.setInorgname(user.getOrgname());
		InstitutionInfo result = institutionBL.registInstitution(tb);
		// dto.setRegTrainingInfo(result);
		log.debug("========�ƶ������������========");
		return dto;
	}



	private String insertFileListAction(IGSYA01DTO dto) throws BLException {
		IGSYA0102Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����
		String attkey = null;
		if (form.getFileListInfo().get(0).getFile() != null) {
			attkey = IGStringUtils.getAttKey();
			attachment.setAttkey(attkey);
		}
		List<FormFileInfo> astFormFileInfo = form.getFileListInfo();
		for (int i = 0; i < astFormFileInfo.size(); i++) {
			FormFile file = astFormFileInfo.get(i).getFile();
			if (file != null && file.getFileSize() > 0) {
				// �ϴ��ļ����ڵ����
				// �ϴ��ļ�·��
				String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// ��Ŀ¼
				pathBuf.append(rootPath);
				// ����ID
				pathBuf.append("sya");
				pathBuf.append(File.separator);
				StringBuffer fileName = new StringBuffer();
				fileName.append(file.getFileName());
				// �ļ��ϴ�����
				try {
					this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
				} catch (FileNotFoundException e) {
					log.debug(e.getMessage());
				} catch (IOException e) {
					log.debug(e.getMessage());
				}
				// �ϴ��ļ�������
				attachment.setAttname(attkey + "_" + fileName.toString());
				// �ϴ��ļ���URL
				attachment.setAtturl("sya");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}

	/**
	 * <p>
	 * Description: ֪ͨ�����ʼ��
	 * </p>
	 * 
	 * @param dto
	 *            IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */

	public IGSYA01DTO init(IGSYA01DTO dto) throws BLException {
		log.debug("========�ƶȻ�����Ϣ��ѯ����ʼ========");
		IGSYA0102Form form = dto.getIgSYA0102Form();
		InstitutionInfo ts = institutionBL.searchInstitutionByPK(form.getInid());
		if (ts == null) {
			throw new BLException("IGCO10000.E004", "�ƶ�");
		}
		form.setAttkey(ts.getAttkey());
		form.setIndesc(ts.getIndesc());
		form.setInname(ts.getInname());
		form.setIntype(ts.getIntype());
		// �����ʼ��ģʽ
		form.setMode("1");

		if (StringUtils.isNotEmpty(ts.getAttkey())) {
			List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(ts.getAttkey());
			if (!list.isEmpty()) {
				Attachment attachment = list.get(0);
				AttachmentTB aTB = (AttachmentTB) SerializationUtils.clone(attachment);
				form.setAttacthname(aTB.getAttname().toString().substring(aTB.getAttname().toString().indexOf("_") + 1));
			}
		}
		dto.setIgSYA0102Form(form);
		dto.addMessage(new ActionMessage("IGCO10000.I001", "�ƶȻ�����Ϣ"));
		log.debug("=======�ƶȻ�����Ϣ��ѯ��������========");
		return dto;
	}


	/**
	 * <p>
	 * Description: ���
	 * </p>
	 * 
	 * @param dto
	 *            IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYA01DTO update(IGSYA01DTO dto) throws BLException {
		IGSYA0102Form form = dto.getAttachFile();
		if (StringUtils.isNotEmpty(form.getDeletekeys())) {
			String[] keys = form.getDeletekeys().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}

		}
		if (form.getFileListInfo().get(0).getFile() != null && !form.getFileListInfo().get(0).getFile().getFileName().equals("")) {
			String attkey = updateFileListAction(dto);
			form.setAttkey(attkey);
		}
		InstitutionInfo ts = institutionBL.searchInstitutionByPK(form.getInid());
		InstitutionTB tb = (InstitutionTB) SerializationUtils.clone(ts);

		tb.setInname(form.getInname());
		tb.setIndesc(form.getIndesc());
		tb.setAttkey(form.getAttkey());
		tb.setIntype(form.getIntype());
		institutionBL.updateInstitution(tb);
		return dto;
	}


	/**
	 * �޸Ĵ���������
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private String updateFileListAction(IGSYA01DTO dto) throws BLException {
		IGSYA0102Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// �ϴ��ļ����

		String attkey = form.getAttkey();

		if (attkey == null || attkey.equals("")) {
			attkey = IGStringUtils.getAttKey();
		}
		attachment.setAttkey(attkey);

		if (form.getFileListInfo().get(0).getFile() != null) {
			List<FormFileInfo> astFormFileInfo = form.getFileListInfo();
			for (int i = 0; i < astFormFileInfo.size(); i++) {
				FormFile file = astFormFileInfo.get(i).getFile();
				if (file != null && file.getFileSize() > 0) {
					// �ϴ��ļ����ڵ����
					// �ϴ��ļ�·��
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();
					// ��Ŀ¼
					pathBuf.append(rootPath);
					// ����ID
					pathBuf.append("sya");
					pathBuf.append(File.separator);
					StringBuffer fileName = new StringBuffer();
					fileName.append(file.getFileName());
					// �ļ��ϴ�����
					try {
						this.fileUploadBL.saveFile(file, pathBuf.toString(), attkey + "_" + fileName.toString());
					} catch (FileNotFoundException e) {
						log.debug(e.getMessage());
					} catch (IOException e) {
						log.debug(e.getMessage());
					}
					// �ϴ��ļ�������
					attachment.setAttname(attkey + "_" + fileName.toString());
					// �ϴ��ļ���URL
					attachment.setAtturl("sya");
					this.attachmentBL.registAttachment(attachment);
				}
			}
		}
		return attkey;
	}

	/**
	 * ɾ
	 */
	public IGSYA01DTO deleteTrain(IGSYA01DTO dto) throws BLException {
		log.debug("========�ƶ�ɾ����ʼ========");
		IGSYA0102Form form = dto.getIgSYA0102Form();
		institutionBL.deleteInstitutionByPK(Integer.valueOf(form.getInid()));
		log.debug("========�ƶȽ���========");
		return dto;
	}

}
