/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
 * 内审项目管理逻辑实现
 *
 */
public class IGIAM01BLImpl extends BaseBLImpl implements IGIAM01BL {

	static Log log = LogFactory.getLog(IGIAM01BLImpl.class);
	
	/** 内审项目表相关操作TaskBL */
	protected InternalauditprjBL internalauditprjBL;
	
	protected FileUploadBL fileUploadBL;
	
	protected AttachmentBL attachmentBL;
	
	protected IG599BL ig599BL;
	
	
	/**
     * ig599BL设定
     *
     * @param ig599bl ig599BL
     */
    public void setIg599BL(IG599BL ig599bl) {
        ig599BL = ig599bl;
    }

    /** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * internalauditprjBL取得
	 *
	 * @return internalauditprjBL internalauditprjBL
	 */
	public InternalauditprjBL getinternalauditprjBL() {
		return internalauditprjBL;
	}
	
	/**
	 * internalauditprjBL设定
	 *
	 * @param internalauditprjBL internalauditprjBL
	 */
	public void setinternalauditprjBL(InternalauditprjBL internalauditprjBL) {
		this.internalauditprjBL = internalauditprjBL;
	}
	/**
	 * internalauditprjBL取得
	 *
	 * @return internalauditprjBL internalauditprjBL
	 */
	public InternalauditprjBL getInternalauditprjBL() {
		return internalauditprjBL;
	}

	/**
	 * internalauditprjBL设定
	 *
	 * @param internalauditprjBL internalauditprjBL
	 */
	public void setInternalauditprjBL(InternalauditprjBL internalauditprjBL) {
		this.internalauditprjBL = internalauditprjBL;
	}

	/**
	 * fileUploadBL取得
	 *
	 * @return fileUploadBL fileUploadBL
	 */
	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}

	/**
	 * fileUploadBL设定
	 *
	 * @param fileUploadBL fileUploadBL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * attachmentBL取得
	 *
	 * @return attachmentBL attachmentBL
	 */
	public AttachmentBL getAttachmentBL() {
		return attachmentBL;
	}

	/**
	 * attachmentBL设定
	 *
	 * @param attachmentBL attachmentBL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * 内审项目管理信息分页查询处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO searchIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========内审项目的分页查询开始========");
		//内审项目表查询条件初始化
		InternalauditprjSearchCondImpl cond = new InternalauditprjSearchCondImpl();
		//实例化form
		IGIAM0102Form form = dto.getIgIAM0102Form();
		//查询条件实例化
		cond.setIapYear_eq(form.getIapYear());//年度
		cond.setIapName_like(form.getIapName());//审计项目名称
		cond.setIapStatus_eq(form.getIapStatus());//状态
		cond.setIapOpenTimeFrom_ge(form.getIapOpenTimeFrom());//审计日期从
		cond.setIapOpenTimeTo_le(form.getIapOpenTimeTo());//审计日期到
		cond.setIapType_eq(form.getIapType());//审计状态
		//查询结果数
		int totalCount = internalauditprjBL.getSearchCount(cond);
		//查询数据不存在
		if (totalCount == 0) {
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<InternalauditprjInfo> interList = internalauditprjBL.searchInternalauditprj(cond, 
				pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		//查询内审项目是否存在检查问题
		List<IGIAM0101Form> formList = new ArrayList<IGIAM0101Form>();
		for(InternalauditprjInfo info : interList){
			IGIAM0101Form iForm = new IGIAM0101Form();
			iForm.setIapId(info.getIapId());
			iForm.setIapName(info.getIapName());//内审项目名称
			iForm.setIapYear(info.getIapYear());//年度
			iForm.setIapObject(info.getIapObject());//审计对象
			iForm.setIapWay(info.getIapWay());//审计方式
			iForm.setIapUserName(info.getIapUserName());//审计人员
			iForm.setIapStatus(info.getIapStatus());//状态
			iForm.setIapSource(info.getIapSource());//检查来源
			iForm.setIapOpenTime(info.getIapOpenTime());//检查开始时间
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
		//将查询结果集封装到dto中
		dto.setInternalauditprjInfoList(formList);
		log.debug("========内审项目的分页查询结束========");
		return dto;
	}
	
	/**
	 * 内审项目修改查询处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO dsearchIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========内审项目查看查询处理开始========");
		//实例化form
		IGIAM0101Form form = dto.getIgIAM0101Form();
		//调用DAO接口查询
		InternalauditprjInfo info = internalauditprjBL.searchInternalauditprjByPK(form.getIapId());
		List<Attachment> attkeyList = null;
		if (info.getIapAttKey() != null && !info.getIapAttKey().equals("")) {
			//查找已上传附件
			attkeyList = attachmentBL.searchAttachmentsByAttkey(info.getIapAttKey());
		}
		//重新实例化form
		form.setIapYear(info.getIapYear());//年度
		form.setIapStatus(info.getIapStatus());//状态
		form.setIapName(info.getIapName());//内审项目名称
		form.setIapWay(info.getIapWay());//审计方式
		form.setIapObject(info.getIapObject());//审计对象
		form.setIapUserName(info.getIapUserName());//审计人员
		form.setIapOpenTime(info.getIapOpenTime());//审计开始日期
		form.setIapCloseTime(info.getIapCloseTime());//审计结束日期
		form.setIapObjective(info.getIapObjective());//审计目的
		form.setIapScope(info.getIapScope());//审计范围
		form.setIapBasis(info.getIapBasis());//审计依据
		form.setIapDesc(info.getIapDesc());//审计内容及要点
		form.setIapSource(info.getIapSource());//审计检查来源
		form.setIapCooperator(info.getIapCooperator());//配合人员
		form.setIapSuggestion(info.getIapSuggestion());//建议
		form.setIapType(info.getIapType());//审计状态
		form.setIapAttKey(info.getIapAttKey());//附件
		
		dto.setAttkeyList(attkeyList);
		log.debug("========内审项目查看查询处理结束========");
		return dto;
	}
	
	/**
	 * 内审项目更新处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO updateIAMAction(IGIAM01DTO dto) throws BLException {

		log.debug("========内审项目更新处理开始========");
		//实例化form
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
		
		//邮寄快件登记表实体接口初始化
		InternalauditprjInfo info = internalauditprjBL.searchInternalauditprjByPK(form.getIapId());
		//使SysPostInfo中的内容由SysPostInfoTB接收使其实体化
		InternalauditprjTB infoTB = (InternalauditprjTB) SerializationUtils.clone(info);

		infoTB.setIapId(form.getIapId());//主键
		infoTB.setIapYear(form.getIapYear());//年度
		infoTB.setIapStatus(form.getIapStatus());//状态
		infoTB.setIapName(form.getIapName());//内审项目名称
		infoTB.setIapObject(form.getIapObject());//审计对象
		infoTB.setIapWay(form.getIapWay());//审计方式
		infoTB.setIapUserName(form.getIapUserName());//审计人员
		infoTB.setIapOpenTime(form.getIapOpenTime());//审计开始日期
		infoTB.setIapCloseTime(form.getIapCloseTime());//审计结束日期
		infoTB.setIapObjective(form.getIapObjective());//审计目的
		infoTB.setIapScope(form.getIapScope());//审计范围
		infoTB.setIapBasis(form.getIapBasis());//审计依据
		infoTB.setIapDesc(form.getIapDesc());//审计内容及要点
		infoTB.setIapAttKey(form.getIapAttKey());//附件
		
		//判断配合人员是否为空
		if (form.getIapCooperator() != null) {
			infoTB.setIapCooperator(form.getIapCooperator());//配合人员
		}
		//判断建议是否为空
		if (form.getIapSuggestion() != null) {
			infoTB.setIapSuggestion(form.getIapSuggestion());//建议
		}
		//判断审计检查来源是否为空
		if (form.getIapSource() != null) {
			infoTB.setIapSource(form.getIapSource());//审计检查来源
		}
		//调用业务方法更新数据
		InternalauditprjInfo internalauditprj = internalauditprjBL.updateInternalauditprj(infoTB);
		if (internalauditprj.getIapType().equals("0")) {
			//返回消息信息
			dto.addMessage(new ActionMessage("IGIAJ0101.I001", "内审项目"));
		} else {
			//返回消息信息
			dto.addMessage(new ActionMessage("IGIAJ0301.I001", "外审项目"));
		}
		log.debug("========内审项目更新处理结束========");
		return dto;
	}
	
	/**
	 * 内审项目删除处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO deleteIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========内审项目删除处理开始========");
		//取得内审项目管理表主键
		Integer iapId = dto.getIgIAM0101Form().getIapId();
		//根据主键进行逐渐查询
		InternalauditprjInfo info = internalauditprjBL.searchInternalauditprjByPK(iapId);
		//不存在抛出异常
		if (info == null) {
			throw new BLException("IGCO10000.E004", "删除内审项目基本");
		}
		//调用业务方法删除数据
		internalauditprjBL.deleteInternalauditprjByPK(iapId);
		
		//返回消息信息
		dto.addMessage(new ActionMessage("IGIAM0101.I002", "内审项目"));
		log.debug("========内审项目删除处理结束========");
		return dto;
	}
	
	/**
	 * 内审项目添加处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	public IGIAM01DTO insertIAMAction(IGIAM01DTO dto) throws BLException {
		
		log.debug("========内审项目添加处理开始========");
		//实例化附件信息
		IGIAM0101Form attachFile = (IGIAM0101Form)dto.getAttachFile();
		if (attachFile.getFileMap() != null) {
			String attkey = insertFileAction(dto);
			attachFile.setIapAttKey(attkey);
		}
		dto.setIgIAM0101Form(attachFile);
		//实例化form
		IGIAM0101Form form = dto.getIgIAM0101Form();
		//审计管理表实体接口初始化
		InternalauditprjTB infoTB = new InternalauditprjTB();
		
		infoTB.setIapId(form.getIapId());//主键
		infoTB.setIapYear(form.getIapYear());//年度
		infoTB.setIapStatus(form.getIapStatus());//状态
		infoTB.setIapName(form.getIapName());//内审项目名称
		infoTB.setIapObject(form.getIapObject());//审计对象
		infoTB.setIapWay(form.getIapWay());//审计方式
		infoTB.setIapUserName(form.getIapUserName());//审计人员
		infoTB.setIapOpenTime(form.getIapOpenTime());//审计开始日期
		infoTB.setIapCloseTime(form.getIapCloseTime());//审计结束日期
		infoTB.setIapObjective(form.getIapObjective());//审计目的
		infoTB.setIapScope(form.getIapScope());//审计范围
		infoTB.setIapBasis(form.getIapBasis());//审计依据
		infoTB.setIapDesc(form.getIapDesc());//审计内容及要点
		infoTB.setIapType(form.getIapType());//审计状态
		infoTB.setIapSource(form.getIapSource());//审计检查来源
		infoTB.setIapAttKey(form.getIapAttKey());//附件
		
		//调用业务方法添加数据
		internalauditprjBL.registInternalauditprj(infoTB);
		//返回消息信息
		dto.addMessage(new ActionMessage("IGIAM0101.I002", "内审项目"));
		log.debug("========内审项目添加处理结束========");
		return dto;
	}

	/**
	 * 添加文件操作处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	private String insertFileAction(IGIAM01DTO dto) throws BLException {
		IGIAM0101Form form = dto.getAttachFile();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测

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
	 * 内审工作登记页内审项目弹出页查询
	 */
	public IGIAM01DTO helpSearch(IGIAM01DTO dto) throws BLException {
		log.debug("========内审工作登记页内审项目弹出页查询处理开始========");
		//内审项目表查询条件初始化
		InternalauditprjSearchCondImpl cond = new InternalauditprjSearchCondImpl();
		//实例化form
		IGIAM0102Form form = dto.getIgIAM0102Form();
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		if(!"1".equals(form.getIapType())){
			//如果是内审项目则设置状态
			cond.setIapStatus_eq(form.getIapStatus());//内审项目状态
		}
		cond.setIapType_eq(form.getIapType());//项目类型
		cond.setIapYear_eq(form.getIapYear());//项目年份
		cond.setIapOpenTimeFrom_ge(form.getIapOpenTimeFrom());//审计开始时间
		cond.setIapOpenTimeTo_le(form.getIapOpenTimeTo());//审计结束时间
		cond.setIapName_like(form.getIapName());//项目名称
		List<InternalauditprjInfo> interList = internalauditprjBL.searchInternalauditprj(cond, pDto.getFromCount(), pDto.getPageDispCount());
		//查询结果数
		int totalCount = internalauditprjBL.getSearchCount(cond);
		//查询数据不存在
		if (totalCount == 0) {
			return dto;
		}
		
		pDto.setTotalCount(totalCount);
		dto.setHelpSearchList(interList);
		log.debug("========内审工作登记页内审项目弹出页查询处理结束========");
		return dto;
	}
	
	/**
	 * 内审工作登记页内审项目弹出页查询
	 */
	public IGIAM01DTO auditProjectHelpSearch(IGIAM01DTO dto) throws BLException {
		log.debug("========内审工作登记页内审项目弹出页查询处理开始========");
		//内审项目表查询条件初始化
		InternalauditprjSearchCondImpl cond = new InternalauditprjSearchCondImpl();
		//实例化form
		IGIAM0102Form form = dto.getIgIAM0102Form();
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		if(!"1".equals(form.getIapType())){
			//如果是内审项目则设置状态
			cond.setIapStatus_eq(form.getIapStatus());//内审项目状态
		}
		cond.setIapType_eq(form.getIapType());//项目类型
		cond.setIapYear_eq(form.getIapYear());//项目年份
		cond.setIapOpenTimeFrom_ge(form.getIapOpenTimeFrom());//审计开始时间
		cond.setIapOpenTimeTo_le(form.getIapOpenTimeTo());//审计结束时间
		cond.setIapName_like(form.getIapName());//项目名称
		List<InternalauditprjInfo> interList = internalauditprjBL.auditProjectHelpSearch(cond, pDto.getFromCount(), pDto.getPageDispCount());
		//查询结果数
		int totalCount = internalauditprjBL.auditProjectHelpSearchConut(cond);
		//查询数据不存在
		if (totalCount == 0) {
			return dto;
		}
		
		pDto.setTotalCount(totalCount);
		dto.setHelpSearchList(interList);
		log.debug("========内审工作登记页内审项目弹出页查询处理结束========");
		return dto;
	}

	/**
	 * 更新文件操作处理
	 * 
	 * @param dto IGIAM01DTO
	 * @return IGIAM01DTO
	 */
	private String updateFileAction(IGIAM01DTO dto) throws BLException {
		
		IGIAM0101Form form = dto.getIgIAM0101Form();
		AttachmentTB attachment = new AttachmentTB();
		// 上传文件检测

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
