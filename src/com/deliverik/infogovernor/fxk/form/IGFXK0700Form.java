/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表单form信息
 * </p>
 * 2014-6-16
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK0700Form extends BaseForm {
	/**用户*/
	protected User user;
	
	/**风险计划查询条数*/
	protected int prlistsize;
	/**风险清单查询条数*/
	protected int qdlistsize;
	/**问题整改查询条数*/
	protected int qmlistsize;
	/**风险评估查询条数*/
	protected int pglistsize;
	/**风险提示查询条数*/
	protected int risklistsize;
	/**清单正在执行*/
	protected int qdExcing;
	/**清单年度*/
	protected int qdYear;
	
	
	/**评估正在执行的*/
	protected int pgExcing;
	
	/**评估年度*/
	protected int pgYear;
	
	/**风险计划个人选择标识1 个人 0 全部*/
	protected String riskselecttype;
	/**风险评估个人选择标识1 个人 0 全部*/
	protected String pgworkselecttype;
	/** 接收人员姓名 */
	protected String[] usname;
	/** 接收人员ID */
	protected String[] usid;
	/** 风险提示名称 */
	protected String rwname;

	/** 下发起者id */
	protected String nuserid;

	/** 下发起者名字 */
	protected String nusername;

	/** 下发者机构名 */
	protected String norgname;

	/** 下发者机构码 */
	protected String norgid;

	/** 下发时间 */
	protected String ntime;

	/** 下发者联系方式 */
	protected String ntel;

	/** 风险提示描述 */
	protected String rwcontext;

	/** 提示附件 */
	protected String rwkey;

	/** 接收者id */
	protected String apuserid;

	/** 接收者名字用于查询 */
	protected String username_s;

	/** 接收机构码用于查询 */
	protected String orgid_s;
	/** 接收机构名用于查询 */
	protected String orgname_s;

	/** 判断是机构还是人员 */
	protected String type;
	/** 接收者名字 */
	protected String apusername;

	/** 接收机构码 */
	protected String[] aporgid;
	
	/**
	 * 评估正在执行的取得
	 * @return pgExcing 评估正在执行的
	 */
	public int getPgExcing() {
		return pgExcing;
	}

	/**
	 * 评估正在执行的设定
	 * @param pgExcing 评估正在执行的
	 */
	public void setPgExcing(int pgExcing) {
		this.pgExcing = pgExcing;
	}

	/**风险点条数*/
	protected int riskCount;
	
	/**检查项条数*/
	protected int checkCount;
	
	/**
	 * 风险点条数取得
	 * @return riskCount 风险点条数
	 */
	public int getRiskCount() {
		return riskCount;
	}

	/**
	 * 风险点条数设定
	 * @param riskCount 风险点条数
	 */
	public void setRiskCount(int riskCount) {
		this.riskCount = riskCount;
	}

	/**
	 * 检查项条数取得
	 * @return checkCount 检查项条数
	 */
	public int getCheckCount() {
		return checkCount;
	}

	/**
	 * 检查项条数设定
	 * @param checkCount 检查项条数
	 */
	public void setCheckCount(int checkCount) {
		this.checkCount = checkCount;
	}

	public int getRisklistsize() {
		return risklistsize;
	}

	public void setRisklistsize(int risklistsize) {
		this.risklistsize = risklistsize;
	}

	public int getPrlistsize() {
		return prlistsize;
	}

	public void setPrlistsize(int prlistsize) {
		this.prlistsize = prlistsize;
	}

	public int getQdlistsize() {
		return qdlistsize;
	}

	public void setQdlistsize(int qdlistsize) {
		this.qdlistsize = qdlistsize;
	}

	public int getQmlistsize() {
		return qmlistsize;
	}

	public void setQmlistsize(int qmlistsize) {
		this.qmlistsize = qmlistsize;
	}

	public int getPglistsize() {
		return pglistsize;
	}

	public void setPglistsize(int pglistsize) {
		this.pglistsize = pglistsize;
	}
	/**
	 * 用户取得
	 * @return user 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户设定
	 * @param user 用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	

	/**
	 * 判断是机构还是人员取得
	 * 
	 * @return type 判断是机构还是人员
	 */

	public String getType() {
		return type;
	}

	/**
	 * 判断是机构还是人员设定
	 * 
	 * @param type
	 *            判断是机构还是人员
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 接收者名字用于查询取得
	 * 
	 * @return username_s 接收者名字用于查询
	 */
	public String getUsername_s() {
		return username_s;
	}

	/**
	 * 接收者名字用于查询设定
	 * 
	 * @param username_s
	 *            接收者名字用于查询
	 */
	public void setUsername_s(String username_s) {
		this.username_s = username_s;
	}

	/**
	 * 接收机构码取得
	 * 
	 * @return orgid_s 接收机构码
	 */
	public String getOrgid_s() {
		return orgid_s;
	}

	/**
	 * 接收机构码设定
	 * 
	 * @param orgid_s
	 *            接收机构码
	 */
	public void setOrgid_s(String orgid_s) {
		this.orgid_s = orgid_s;
	}

	/**
	 * 接收机构名取得
	 * 
	 * @return orgname_s 接收机构名
	 */
	public String getOrgname_s() {
		return orgname_s;
	}

	/**
	 * 接收机构名设定
	 * 
	 * @param orgname_s
	 *            接收机构名
	 */
	public void setOrgname_s(String orgname_s) {
		this.orgname_s = orgname_s;
	}

	/**
	 * 接收者id取得
	 * 
	 * @return apuserid 接收者id
	 */
	public String getApuserid() {
		return apuserid;
	}

	/**
	 * 接收者id设定
	 * 
	 * @param apuserid
	 *            接收者id
	 */
	public void setApuserid(String apuserid) {
		this.apuserid = apuserid;
	}

	/**
	 * 接收机构码取得
	 * 
	 * @return aporgid 接收机构码
	 */

	public String[] getAporgid() {
		return aporgid;
	}

	/**
	 * 接收机构码设定
	 * 
	 * @param aporgid
	 *            接收机构码
	 */
	public void setAporgid(String[] aporgid) {
		this.aporgid = aporgid;
	}

	/** 接收机构名称 */
	protected String[] aporgname;

	/**
	 * 接收机构名称取得
	 * 
	 * @return aporgname 接收机构名称
	 */
	public String[] getAporgname() {
		return aporgname;
	}

	/**
	 * 接收机构名称设定
	 * 
	 * @param aporgname
	 *            接收机构名称
	 */
	public void setAporgname(String[] aporgname) {
		this.aporgname = aporgname;
	}

	public String attachDel;

	protected FormFile file;

	protected String attacthname;
	// 是否删除附件
	protected String delfile;
	public String deletekeys;
	
	/**附件列表*/
	public List<Attachment>attachmentList;
	
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public String getRwname() {
		return rwname;
	}

	public void setRwname(String rwname) {
		this.rwname = rwname;
	}

	public String getNuserid() {
		return nuserid;
	}

	public void setNuserid(String nuserid) {
		this.nuserid = nuserid;
	}

	public String getNusername() {
		return nusername;
	}

	public void setNusername(String nusername) {
		this.nusername = nusername;
	}

	public String getNorgname() {
		return norgname;
	}

	public void setNorgname(String norgname) {
		this.norgname = norgname;
	}

	public String getNorgid() {
		return norgid;
	}

	public void setNorgid(String norgid) {
		this.norgid = norgid;
	}

	public String getNtime() {
		return ntime;
	}

	public void setNtime(String ntime) {
		this.ntime = ntime;
	}

	public String getNtel() {
		return ntel;
	}

	public void setNtel(String ntel) {
		this.ntel = ntel;
	}

	public String getRwcontext() {
		return rwcontext;
	}

	public void setRwcontext(String rwcontext) {
		this.rwcontext = rwcontext;
	}

	public String getRwkey() {
		return rwkey;
	}

	public void setRwkey(String rwkey) {
		this.rwkey = rwkey;
	}

	public String getApusername() {
		return apusername;
	}

	public void setApusername(String apusername) {
		this.apusername = apusername;
	}

	/**
	 * fileList取得
	 * 
	 * @return fileList fileList
	 */
	public List<FormFileInfo> getFileList() {
		return fileList;
	}

	/**
	 * fileList设定
	 * 
	 * @param fileList
	 *            fileList
	 */
	public void setFileList(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}

	public String getAttachDel() {
		return attachDel;
	}

	public void setAttachDel(String attachDel) {
		this.attachDel = attachDel;
	}

	public FormFile getFile() {
		return file;
	}

	public void setFile(FormFile file) {
		this.file = file;
	}

	public String getAttacthname() {
		return attacthname;
	}

	public void setAttacthname(String attacthname) {
		this.attacthname = attacthname;
	}

	public String getDelfile() {
		return delfile;
	}

	public void setDelfile(String delfile) {
		this.delfile = delfile;
	}

	public String getDeletekeys() {
		return deletekeys;
	}

	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}

	protected List<FormFileInfo> fileList;

	public IGFXK0700Form() {

		fileList = new ArrayList<FormFileInfo>();

		fileList.add(new FormFileInfo());
	}

	public List<FormFileInfo> getFileListInfo() {
		return fileList;
	}

	public void setFileListInfo(List<FormFileInfo> fileList) {
		this.fileList = fileList;
	}

	public FormFileInfo getFileList(int index) {

		int size = fileList.size();
		if (index > size - 1) {
			for (int i = 0; i < index - size + 1; i++) {
				fileList.add(new FormFileInfo());
			}
		}
		return fileList.get(index);
	}

	/**
	 * 接收人员姓名取得
	 * 
	 * @return usname 接收人员姓名
	 */
	public String[] getUsname() {
		return usname;
	}

	/**
	 * 接收人员姓名设定
	 * 
	 * @param usname
	 *            接收人员姓名
	 */
	public void setUsname(String[] usname) {
		this.usname = usname;
	}

	/**
	 * 接收人员ID取得
	 * 
	 * @return usid 接收人员ID
	 */
	public String[] getUsid() {
		return usid;
	}

	/**
	 * 接收人员ID设定
	 * 
	 * @param usid
	 *            接收人员ID
	 */
	public void setUsid(String[] usid) {
		this.usid = usid;
	}

	/**
	 * 评估年度取得
	 * @return pgYear 评估年度
	 */
	public int getPgYear() {
		return pgYear;
	}

	/**
	 * 清单正在执行取得
	 * @return qdExcing 清单正在执行
	 */
	public int getQdExcing() {
		return qdExcing;
	}

	/**
	 * 清单正在执行设定
	 * @param qdExcing 清单正在执行
	 */
	public void setQdExcing(int qdExcing) {
		this.qdExcing = qdExcing;
	}

	/**
	 * 清单年度取得
	 * @return qdYear 清单年度
	 */
	public int getQdYear() {
		return qdYear;
	}

	/**
	 * 清单年度设定
	 * @param qdYear 清单年度
	 */
	public void setQdYear(int qdYear) {
		this.qdYear = qdYear;
	}

	/**
	 * 评估年度设定
	 * @param pgYear 评估年度
	 */
	public void setPgYear(int pgYear) {
		this.pgYear = pgYear;
	}

	/**
	 * 风险计划个人选择标识1个人0全部取得
	 * @return riskselecttype 风险计划个人选择标识1个人0全部
	 */
	public String getRiskselecttype() {
		return riskselecttype;
	}

	/**
	 * 风险计划个人选择标识1个人0全部设定
	 * @param riskselecttype 风险计划个人选择标识1个人0全部
	 */
	public void setRiskselecttype(String riskselecttype) {
		this.riskselecttype = riskselecttype;
	}

	/**
	 * 风险评估个人选择标识1个人0全部取得
	 * @return pgworkselecttype 风险评估个人选择标识1个人0全部
	 */
	public String getPgworkselecttype() {
		return pgworkselecttype;
	}

	/**
	 * 风险评估个人选择标识1个人0全部设定
	 * @param pgworkselecttype 风险评估个人选择标识1个人0全部
	 */
	public void setPgworkselecttype(String pgworkselecttype) {
		this.pgworkselecttype = pgworkselecttype;
	}

	

}