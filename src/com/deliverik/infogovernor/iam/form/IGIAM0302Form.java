/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.iam.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
 * 概述: 审计报告新增form 功能描述：审计报告新增 创建人：惠涌智 创建记录： 2012-8-9 修改记录：
 */
public class IGIAM0302Form extends BaseForm {
	/** 主键ID */
	protected Integer apid;

	/** 审计报告类型 */
	protected String apreporttype;

	/** 审计项目ID */
	protected Integer approjectid;

	/** 项目名称 */
	protected String approjectname;

	/** 项目年度 */
	protected String approjectyear;

	/** 审计报告附件KEY */
	protected String apattkey;

	/** 内审项目信息实体 */
	protected InternalauditprjTB internalauditprjTB;

	/** 将要删除的附件id串 */
	protected String deletekeys;

	/** 附件 */
	protected Map<Integer, FormFile> fileMap = null;

	public Integer getApid() {
		return apid;
	}

	public void setApid(Integer apid) {
		this.apid = apid;
	}

	public String getApreporttype() {
		return apreporttype;
	}

	public void setApreporttype(String apreporttype) {
		this.apreporttype = apreporttype;
	}

	public Integer getApprojectid() {
		return approjectid;
	}

	public void setApprojectid(Integer approjectid) {
		this.approjectid = approjectid;
	}

	public String getApprojectname() {
		return approjectname;
	}

	public void setApprojectname(String approjectname) {
		this.approjectname = approjectname;
	}

	public String getApprojectyear() {
		return approjectyear;
	}

	public void setApprojectyear(String approjectyear) {
		this.approjectyear = approjectyear;
	}

	public String getApattkey() {
		return apattkey;
	}

	public void setApattkey(String apattkey) {
		this.apattkey = apattkey;
	}

	public InternalauditprjTB getInternalauditprjTB() {
		return internalauditprjTB;
	}

	public void setInternalauditprjTB(InternalauditprjTB internalauditprjTB) {
		this.internalauditprjTB = internalauditprjTB;
	}

	public String getDeletekeys() {
		return deletekeys;
	}

	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}

	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		this.fileMap = new HashMap<Integer, FormFile>();
	}

	/**
	 * 获取附件
	 * 
	 * @return 获取附件
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * 设置附件
	 * 
	 * @param index
	 *            附件数组索引
	 * @param file
	 *            附件
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}
}
