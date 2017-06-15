/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: 
 * 功能描述：
 * 创建人：惠涌智
 * 创建记录： 2012-8-8
 * 修改记录：
 */
public class IGIAM03BLImpl extends BaseBLImpl implements IGIAM03BL {
	
	static Log log = LogFactory.getLog(IGIAM03BLImpl.class);
	/** 审计报告业务逻辑接口*/
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
	 * 查询设计报告信息
	 * @param dto
	 * @return
	 */
	public IGIAM03DTO searchIAM03DTOAction(IGIAM03DTO dto){
		log.debug("========内审工作查询开始========");
		//声明查询条件类
		AUDITPROJECTSearchCondImpl cond = new AUDITPROJECTSearchCondImpl();
		//获得form
		IGIAM0301Form form = dto.getIgiam0301Form();
		//设置查询条件值
		cond.setProjectName(form.getApprojectname());
		cond.setAuditReportType(form.getApreporttype());
		cond.setApprojectyear(form.getApprojectyear());
		//查询数据总数
		int totalCount = auditProjectBL.getSearchCount(cond);
		//查询数据不存在
		if (totalCount == 0) {
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		List<AUDITPROJECTInfo> projectList = auditProjectBL.searchAUDITPROJECT(cond,pDto.getFromCount(),pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setAuditProjectInfoList(projectList);
		return dto ;
	}
	
	/**
	 * 审计报告详细信息查看
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO dsearchIAMAction(IGIAM03DTO dto) throws BLException {
		
		log.debug("========审计报告查看查询处理开始========");
		//实例化form
		IGIAM0303Form form = dto.getIgiam0303Form();
		//调用DAO接口查询
		AUDITPROJECTInfo tb = auditProjectBL.searchAUDITPROJECTByPK(form.getApid());
		List<Attachment> attkeyList = null;
		if (tb.getApattkey() != null && !tb.getApattkey().equals("")) {
			//查找已上传附件
			attkeyList = attachmentBL.searchAttachmentsByAttkey(tb.getApattkey());
		}
		//重新实例化form
		form.setApid(tb.getApid());
		form.setApprojectid(tb.getApprojectid());
		form.setApprojectname(tb.getApprojectname());
		form.setApprojectyear(tb.getApprojectyear());
		form.setApreporttype(tb.getApreporttype());
		form.setApattkey(tb.getApattkey());
		
		dto.setAttkeyList(attkeyList);
		log.debug("========审计报告查看查询处理结束========");
		return dto;
	}
	
	/**
	 * 保存审计报告
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO insertIAMAction(IGIAM03DTO dto) throws BLException {
		log.debug("========审计报告新增处理开始========");
		
		//保存附件
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

		//新增是否成功
		if(null != info){
			dto.addMessage(new ActionMessage("IGIAJ0201.I001", "审计报告"));
		}else{
			throw new BLException("IGIAJ0201.E001","审计报告新增失败！");
		}
		
		dto.setIgiam0302Form(attachFile);
		log.debug("========审计报告新增处理结束========");
		return dto;
	}

	/**
	 * 删除审计报告
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO deleteIAMAction(IGIAM03DTO dto) throws BLException {
		log.debug("========审计报告删除处理开始========");
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
					throw new BLException("IGIAM0201.E003","审计报告删除失败！");
				}
			}
			dto.addMessage(new ActionMessage("IGIAM0303.I001", "审计报告删除成功"));
		}
		log.debug("========审计报告删除处理结束========");
		return dto;
	}
	
	/**
	 * 更新审计报告信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIAM03DTO updateIAMAction(IGIAM03DTO dto) throws BLException {
		log.debug("========审计报告更新处理开始========");
		//实例化form
		IGIAM0303Form form = dto.getIgiam0303Form();
		if (StringUtils.isNotEmpty(form.getDeletekeys())) {
			//删除附件
			String[] keys = form.getDeletekeys().split(",");
			for (String key : keys) {
				Attachment attachment = attachmentBL.searchAttachmentByKey(Integer.parseInt(key));
				attachmentBL.deleteAttachment(attachment);
			}
		}
		if(form.getFileMap().size() > 0){
			//更新附件
			String attkey = updateFileAction(dto);
			form.setApattkey(attkey);
		}
		
		//查询数据
		AUDITPROJECTTB info = (AUDITPROJECTTB)this.auditProjectBL.searchAUDITPROJECTByPK(form.getApid());
		
		//设置新值
		info.setApattkey(form.getApattkey());
		info.setApprojectid(form.getApprojectid());
		info.setApprojectname(form.getApprojectname());
		info.setApprojectyear(form.getApprojectyear());
		info.setApreporttype(form.getApreporttype());

		//调用业务方法更新数据
		this.auditProjectBL.updateAUDITPROJECT(info);
		
		dto.addMessage(new ActionMessage("IGIAJ0101.I001", "内审项目"));
		
		log.debug("========审计报告更新处理结束========");
		return dto;
	}
	
	/**
	 * 保存附件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private String insertFileAction(IGIAM03DTO dto) throws BLException {
		IGIAM0302Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测

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
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// 根目录
				pathBuf.append(rootPath);
				// 机能ID
				pathBuf.append("iam");
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
				attachment.setAtturl("iam");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		
		return attkey;
	}
	
	/**
	 * 更新文件操作处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	private String updateFileAction(IGIAM03DTO dto) throws BLException {
		
		IGIAM0303Form form = dto.getIgiam0303Form();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测

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
				// 上传文件存在的情况
				// 上传文件路径
				String rootPath = ResourceUtility
						.getString("UPLOAD_FILE_ROOT_PATH");
				StringBuffer pathBuf = new StringBuffer();
				// 根目录
				pathBuf.append(rootPath);
				// 机能ID
				pathBuf.append("iam");
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
				attachment.setAtturl("iam");
				this.attachmentBL.registAttachment(attachment);
			}
		}
		return attkey;
	}
}
