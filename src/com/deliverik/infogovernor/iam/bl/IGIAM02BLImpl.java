/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 概述: 内审工作管理业务逻辑接口实现
 * 功能描述： 内审工作管理业务逻辑接口实现
 * 创建人：赵敏
 * 创建记录： 2012-7-25
 * 修改记录：
 */
public class IGIAM02BLImpl implements IGIAM02BL {

	static Log log = LogFactory.getLog(IGIAM02BLImpl.class);
	
	/**
	 * 内审工作管理业务逻辑接口
	 */
	private InternalauditJobBL internalauditJobBL;
	
	protected FileUploadBL fileUploadBL;
	
	protected AttachmentBL attachmentBL;
	
	/**
	 * 获取internalauditJobBL
	 * @return finternalauditJobBL internalauditJobBL
	 */
	public InternalauditJobBL getInternalauditJobBL() {
		return internalauditJobBL;
	}

	/**
	 * 设置internalauditJobBL
	 * @param internalauditJobBL  internalauditJobBL
	 */
	public void setInternalauditJobBL(InternalauditJobBL internalauditJobBL) {
		this.internalauditJobBL = internalauditJobBL;
	}
	
	/**
	 * 获取fileUploadBL
	 * @return ffileUploadBL fileUploadBL
	 */
	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}

	/**
	 * 设置fileUploadBL
	 * @param fileUploadBL  fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * 获取attachmentBL
	 * @return fattachmentBL attachmentBL
	 */
	public AttachmentBL getAttachmentBL() {
		return attachmentBL;
	}

	/**
	 * 设置attachmentBL
	 * @param attachmentBL  attachmentBL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 内审工作查询
	 */
	public IGIAM02DTO searchIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========内审工作查询开始========");
		//内审项目表查询条件初始化
		InternalauditJobSearchCondImpl cond = new InternalauditJobSearchCondImpl();
		//实例化form
		IGIAM0201Form form = dto.getIgiam0201form();
		//查询条件实例化
		cond.setIajIapId_q(form.getIajIapId_q());
		cond.setIajName_like(form.getIajName_like());
		cond.setIajYear_q(form.getIajYear_q());
		int totalCount = internalauditJobBL.getSearchCount(cond);
		//查询数据不存在
		if (totalCount == 0) {
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<InternalauditJobInfo> interList = internalauditJobBL.searchInternalauditJob(cond, 
				pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setInternalauditJobList(interList);
		log.debug("========内审工作查询结束========");
		return dto;
	}

	/**
	 * 查找内审工作
	 */
	public IGIAM02DTO dsearchIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========内审工作明细详细查询开始========");
		IGIAM0203Form form = dto.getIgiam0203form();
		InternalauditJobInfo info = internalauditJobBL.searchInternalauditJobByPK(form.getIajid());
		List<Attachment> attkeyList = null;
		if (info.getIajattkey() != null) {		
			//查找已上传附件
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
		log.debug("========内审工作明细详细查询结束========");
		return dto;
	}

	/**
	 * 内审工作修改
	 */
	public IGIAM02DTO updateIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========内审工作修改处理开始========");
		IGIAM0203Form form = dto.getIgiam0203form();
		//删除附件
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
		iajTB.setIajyear(form.getIajyear());//计划年度
		iajTB.setIajattkey(form.getIajattkey());//附件  form.getIajattkey()
		iajTB.setIajdesc(form.getIajdesc());//工作内容描述
		iajTB.setIajiapid(form.getIajiapid());//内置项目ID
		iajTB.setIajinserttime(form.getIajinserttime());//登记时间
		iajTB.setIajname(form.getIajname());//工作名称
		iajTB.setIajovertime(form.getIajovertime());//实际工作结束日期
		iajTB.setIajstarttime(form.getIajstarttime());//实际工作开始日期
		iajTB.setIajuserid(form.getIajuserid());//登记人ID
		InternalauditJobInfo info = internalauditJobBL.updateInternalauditJob(iajTB);
		if(null != info){
			dto.addMessage(new ActionMessage("IGIAJ0201.I002", "内审工作"));
		}else{
			throw new BLException("IGIAM0201.E002","内审工作修改失败！");
		}
		log.debug("========内审工作修改处理结束========");
		return dto;
	}

	/**
	 * 内审工作删除
	 */
	public IGIAM02DTO deleteIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========内审工作 删除处理开始========");
		String iajids = dto.getIajids();
		if(StringUtils.isNotEmpty(iajids)){
			String [] id = iajids.split(",");
			for(int i=0; i<id.length; i++){
				String temp = StringUtils.replace(id[i], ",", "");
				try{
					Integer pk = new Integer(temp);
					internalauditJobBL.deleteInternalauditJobByPK(pk);	
				}catch(BLException e){
					throw new BLException("IGIAM0201.E003","内审工作删除失败！");
				}
			}
			dto.addMessage(new ActionMessage("IGIAJ0201.I003", "内审工作"));
		}
		log.debug("========内审工作删除处理结束========");
		return dto;
	}

	/**
	 * 内置工作管理新增
	 */
	public IGIAM02DTO insertIAMAction(IGIAM02DTO dto) throws BLException {
		log.debug("========内审工作新增处理开始========");
		
		IGIAM0202Form attachFile = (IGIAM0202Form) dto.getAttachFile();
		if(attachFile.getFileMap() != null){
			String attkey = insertFileAction(dto);
			attachFile.setIajattkey(attkey);
		}
		IGIAM0202Form form = (IGIAM0202Form) dto.getAttachFile();

		//获取当前系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String iajinserttime = sdf.format(new Date());

		InternalauditJobTB iajTB = new InternalauditJobTB();
		iajTB.setIajyear(form.getIajyear());//计划年度
		iajTB.setIajattkey(attachFile.getIajattkey());//附件  form.getIajattkey()
		iajTB.setIajdesc(form.getIajdesc());//工作内容描述
		iajTB.setIajiapid(form.getIajiapid());//内置项目ID
		iajTB.setIajinserttime(iajinserttime);//登记时间
		iajTB.setIajname(form.getIajname());//工作名称
		iajTB.setIajovertime(form.getIajovertime());//实际工作结束日期
		iajTB.setIajstarttime(form.getIajstarttime());//实际工作开始日期
		iajTB.setIajuserid(form.getIajuserid());//登记人ID
		
		InternalauditJobInfo info = internalauditJobBL.registInternalauditJob(iajTB);

		//新增是否成功
		if(null != info){
			dto.addMessage(new ActionMessage("IGIAJ0201.I001", "内审工作"));
		}else{
			throw new BLException("IGIAJ0201.E001","内审工作新增失败！");
		}
		
		dto.setIgiam0202form(form);
		log.debug("========内审工作新增处理结束========");
		return dto;
	}

	private String insertFileAction(IGIAM02DTO dto) throws BLException {
		IGIAM0202Form form = dto.getAttachFile();
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

	private String updateFileAction(IGIAM02DTO dto) throws BLException {
		IGIAM0203Form form = dto.getIgiam0203form();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测

		String attkey = null;
		//查找已上传附件
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
