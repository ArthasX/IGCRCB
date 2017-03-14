/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0201Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0202Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0203Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0205Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0206Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0207Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0210Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0212Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0213Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0802Form;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
/**
 * 概述: 资产域定义业务用DTO
 * 功能描述: 资产域定义业务用DTO
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGCIM02DTO extends BaseDTO implements Serializable {

	/**
	 * 资产域定义表检索条件接口
	 */
	protected SOC0111SearchCond eiDomainDefSearchCond;
	
	/**
	 * 资产域明细表检索条件接口
	 */
	protected SOC0126SearchCond eiDomainDetailVWSearchCond;
	
	/**
	 * 导入对象表检索条件接口
	 */
	protected SOC0120SearchCond importVersionSearchCond;
	
	/**
	 * 导入程序类型
	 */
	protected List<SOC0113Info> eiImportProgrammeList;
	
	/** 域明细信息 */
	protected List<SOC0138Info> eiDomainDetailCIOneInfoList;
	
	protected List<SOC0136Info> eiDomainDetailCIInfoList;
	
	/**
	 * 导入类型信息
	 */
	protected List<LabelValueBean> impTypeList;
	/**
	 * 最新版域信息
	 */
	protected List<LabelValueBean> domainList;
	
	/**
	 * 查询类型
	 */
	protected List<LabelValueBean> typeList;
	
	/**
	 * 国际化信息
	 */
	protected Locale locale;

	/** 资产域定义信息 */
	protected IGCIM0202Form igcim0202Form;
	
	/** 资产域定义详细信息 */
	protected IGCIM0205Form igcim0205Form;
	
	/** 导入对象信息 */
	protected IGCIM0206Form igcim0206Form;
	

	/** 导入对象信息 */
	protected IGCIM0207Form igcim0207Form;
	
	/** 资产域定义版本Form */
	protected IGCIM0212Form igcim0212Form;
	
	/** 域CI查询条件信息*/
	protected IGCIM0213Form igcim0213Form;
	
	/** 条件信息*/
	protected IGCIM0802Form igcim0802Form;
	
	/** 调整 */
	protected String deleteflag;
	
	/** 实体名 */
	protected String impeiname;
	
	/** 版本号 */
	protected Integer impversion;

	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	/** 资产域定义检索结果 */
	protected SOC0111Info eiDomainDefInfo;

	/** 资产域定义检索结果 */
	protected List<SOC0111Info> eiDomainDefInfoList;
	
	/** 导入对象检索结果 */
	protected List<SOC0120Info> importVersionInfoList;
	
	/** 导入对象检索结果 */
	protected SOC0120Info importVersionInfo;
	
	/** 预删除资产域定义信息 */
	protected String[] deleteEiddid;
	
	/** 预删除对象信息 */
	protected String[] deleteImpeiid;

	/**
	 * 已添加导入资产
	 */
	protected String[] owneiddids;

	/**
	 * 未添加导入资产
	 */
	protected String[] eiddids;

	/** 版本号 */
	protected Integer eiddversion;

	/** eidomaindetail主键 */
	protected Integer eiddid;
	
	/** 控制台显示FORM */
	protected IGCIM0201Form igcim0201Form;
	
	/** 控制台任务列表ci2 */
	protected List<SOC0115Info> eiWaitTaskList;
	
	
	/** 控制台显示FORM */
	protected IGCIM0210Form igcim0210Form;
	
	/** 控制台任务 */
	protected SOC0115Info eiWaitTask;
	/** 用户信息 */
	protected User user;
	
	/** 资产域定义详细信息 */
	protected IGCIM0203Form igcim0203Form;
	
	/**采集对象集合*/
	protected List<CR03Info> cr03InfoList;
	
	protected List<CR03VWInfo> cr03VWInfoList;
	
	protected Integer eiid;
	
	
	
	public List<CR03VWInfo> getCr03VWInfoList() {
		return cr03VWInfoList;
	}
	public void setCr03VWInfoList(List<CR03VWInfo> cr03VWInfoList) {
		this.cr03VWInfoList = cr03VWInfoList;
	}
	public Integer getEiid() {
		return eiid;
	}
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	public IGCIM0203Form getIgcim0203Form() {
		return igcim0203Form;
	}
	public void setIgcim0203Form(IGCIM0203Form igcim0203Form) {
		this.igcim0203Form = igcim0203Form;
	}
	/**
	 * 用户信息取得
	 * 
	 * @return 用户信息
	 */
	public User getUser() {
		return user;
	}
	/**
	 * 用户信息设置
	 * 
	 * @param User 用户信息 
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 资产域定义表检索条件接口取得
	 * 
	 * @return 资产域定义表检索条件接口
	 */
	public SOC0111SearchCond getEiDomainDefSearchCond() {
		return eiDomainDefSearchCond;
	}

	/**
	 * 资产域定义表检索条件接口设置
	 * 
	 * @param eiDomainDefSearchCond资产域定义表检索条件接口
	 */
	public void setEiDomainDefSearchCond(
			SOC0111SearchCond eiDomainDefSearchCond) {
		this.eiDomainDefSearchCond = eiDomainDefSearchCond;
	}

	/**
	 * 国际化信息取得
	 * 
	 * @return 国际化信息
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * 国际化信息设置
	 * 
	 * @param locale国际化信息
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * 资产域定义信息取得
	 * 
	 * @return 资产域定义信息
	 */
	public IGCIM0202Form getIgcim0202Form() {
		return igcim0202Form;
	}

	/**
	 * 资产域定义信息设置
	 * 
	 * @param igcim0202Form资产域定义信息
	 */
	public void setIgcim0202Form(IGCIM0202Form igcim0202Form) {
		this.igcim0202Form = igcim0202Form;
	}

	/**
	 * 已添加导入资产取得
	 */
	public String[] getOwneiddids() {
		return owneiddids;
	}

	/**
	 * 已添加导入资产设置
	 */
	public void setOwneiddids(String[] owneiddids) {
		this.owneiddids = owneiddids;
	}

	/**
	 * 未添加导入资产取得
	 */
	public String[] getEiddids() {
		return eiddids;
	}

	/**
	 * 未添加导入资产设置
	 */
	public void setEiddids(String[] eiddids) {
		this.eiddids = eiddids;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * 主键设定
	 * @param eiddid主键
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getEiddversion() {
		return eiddversion;
	}

	/**
	 * 版本号设定
	 * @param eiddversion版本号
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}

	/**
	 * 检索最大件数取得
	 * 
	 * @return 检索最大件数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 检索最大件数设定
	 * 
	 * @param maxSearchCount检索最大件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 翻页用DTO取得
	 * 
	 * @return 翻页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 翻页用DTO设定
	 * 
	 * @param pagingDto翻页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 资产域定义检索结果取得
	 * 
	 * @return 资产域定义检索结果
	 */
	public List<SOC0111Info> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * 资产域定义检索结果设定
	 * 
	 * @param eiDomainDefInfoList资产域定义检索结果
	 */
	public void setEiDomainDefInfoList(List<SOC0111Info> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * 资产域定义详细信息取得
	 * @return 资产域定义详细信息
	 */
	public IGCIM0205Form getIgcim0205Form() {
		return igcim0205Form;
	}
	/**
	 * 资产域定义详细信息设定
	 * @param igcim0205Form资产域定义详细信息
	 */
	public void setIgcim0205Form(IGCIM0205Form igcim0205Form) {
		this.igcim0205Form = igcim0205Form;
	}

	/**
	 * 控制台显示FORM取得
	 * 
	 * @return 控制台显示FORM
	 */
	public IGCIM0201Form getIgcim0201Form() {
		return igcim0201Form;
	}

	/**
	 * 控制台显示FORM设定
	 * 
	 * @param igcim0201Form 控制台显示FORM
	 */
	public void setIgcim0201Form(IGCIM0201Form igcim0201Form) {
		this.igcim0201Form = igcim0201Form;
	}

	/**
	 * 控制台任务列表
	 * 
	 * @return 控制台任务列表取得
	 */
	public List<SOC0115Info> getEiWaitTaskList() {
		return eiWaitTaskList;
	}

	/**
	 * 控制台任务列表设定
	 * 
	 * @param eiWaitTaskList 控制台任务列表
	 */
	public void setEiWaitTaskList(List<SOC0115Info> eiWaitTaskList) {
		this.eiWaitTaskList = eiWaitTaskList;
	}
	
	/**
	 * 预删除资产域定义信息取得
	 * @return 预删除资产域定义信息
	 */
	public String[] getDeleteEiddid() {
		return deleteEiddid;
	}

	/**
	 * 预删除资产域定义信息设定
	 * @param deleteEiddid预删除资产域定义信息
	 */
	public void setDeleteEiddid(String[] deleteEiddid) {
		this.deleteEiddid = deleteEiddid;
	}
	
	/**
	 * 导入对象信息
	 * @return 导入对象信息
	 */
	public IGCIM0206Form getIgcim0206Form() {
		return igcim0206Form;
	}
	
	/**
	 * 导入对象信息
	 * @param igcim0206Form导入对象信息
	 */
	public void setIgcim0206Form(IGCIM0206Form igcim0206Form) {
		this.igcim0206Form = igcim0206Form;
	}
	
	/**
	 * 导入对象检索结果 
	 * @return 导入对象检索结果 
	 */
	public List<SOC0120Info> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * 导入对象检索结果 
	 * @param importVersionInfoList导入对象检索结果 
	 */
	public void setImportVersionInfoList(
			List<SOC0120Info> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * 导入对象表检索条件接口取得
	 * @return 导入对象表检索条件接口
	 */
	public SOC0120SearchCond getImportVersionSearchCond() {
		return importVersionSearchCond;
	}

	/**
	 * 导入对象表检索条件接口设定
	 * @param importVersionSearchCond导入对象表检索条件接口
	 */
	public void setImportVersionSearchCond(
			SOC0120SearchCond importVersionSearchCond) {
		this.importVersionSearchCond = importVersionSearchCond;
	}

	/**
	 * 预删除对象信息
	 * @return 预删除对象信息
	 */
	public String[] getDeleteImpeiid() {
		return deleteImpeiid;
	}

	/**
	 * 预删除对象信息
	 * @param deleteImpeiid预删除对象信息
	 */
	public void setDeleteImpeiid(String[] deleteImpeiid) {
		this.deleteImpeiid = deleteImpeiid;
	}

	/**
	 * 调整取得
	 * @return 调整
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 调整设定
	 * @param deleteflag调整
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * 实体名设定
	 * @param impeiname实体名
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * 版本号设定
	 * @param impversion版本号
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}
	/**
	 * 导入对象信息
	 * @return 导入对象信息
	 */
	public IGCIM0207Form getIgcim0207Form() {
		return igcim0207Form;
	}
	/**
	 * 导入对象信息设定
	 * @param igcim0207Form导入对象信息
	 */
	public void setIgcim0207Form(IGCIM0207Form igcim0207Form) {
		this.igcim0207Form = igcim0207Form;
	}

	/**
	 * 控制台显示FORM取得
	 * 
	 * @return 控制台显示FORM
	 */
	public IGCIM0210Form getIgcim0210Form() {
		return igcim0210Form;
	}

	/**
	 * 控制台显示FORM设定
	 * 
	 * @param igcim0210Form 控制台显示FORM
	 */
	public void setIgcim0210Form(IGCIM0210Form igcim0210Form) {
		this.igcim0210Form = igcim0210Form;
	}

	/**
	 * 控制台任务取得
	 * 
	 * @return 控制台任务
	 */
	public SOC0115Info getEiWaitTask() {
		return eiWaitTask;
	}

	/**
	 * 控制台任务设定
	 * 
	 * @param eiWaitTask 控制台任务
	 */
	public void setEiWaitTask(SOC0115Info eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}
	
	/**
	 * 导入程序类型取得
	 * @return 导入程序类型
	 */
	public List<SOC0113Info> getEiImportProgrammeList() {
		return eiImportProgrammeList;
	}

	/**
	 * 导入程序类型设定
	 * @param eiImportProgrammeList导入程序类型
	 */
	public void setEiImportProgrammeList(
			List<SOC0113Info> eiImportProgrammeList) {
		this.eiImportProgrammeList = eiImportProgrammeList;
	}
	
	/**
	 * 导入对象检索结果
	 * @return 导入对象检索结果
	 */
	public SOC0120Info getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * 导入对象检索结果
	 * @param importVersionInfo导入对象检索结果
	 */
	public void setImportVersionInfo(SOC0120Info importVersionInfo) {
		this.importVersionInfo = importVersionInfo;
	}
	
	/**
	 * 导入类型取得
	 * @return 导入类型
	 */
	public List<LabelValueBean> getImpTypeList() {
		return impTypeList;
	}
	/**
	 * 导入类型设定
	 * @param impTypeList导入类型
	 */
	public void setImpTypeList(List<LabelValueBean> impTypeList) {
		this.impTypeList = impTypeList;
	}
	/**
	 * 资产域定义版本Form取得
	 * @return 资产域定义版本Form
	 */
	public IGCIM0212Form getIgcim0212Form() {
		return igcim0212Form;
	}
	/**
	 * 资产域定义版本Form设定
	 * @param igcim0212Form资产域定义版本Form
	 */
	public void setIgcim0212Form(IGCIM0212Form igcim0212Form) {
		this.igcim0212Form = igcim0212Form;
	}
	/**
	 * 资产域定义检索结果取得
	 * @return 资产域定义检索结果
	 */
	public SOC0111Info getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}
	/**
	 * 资产域定义检索结果设定
	 * @param eiDomainDefInfo资产域定义检索结果
	 */
	public void setEiDomainDefInfo(SOC0111Info eiDomainDefInfo) {
		this.eiDomainDefInfo = eiDomainDefInfo;
	}
	/**
	 * 最新版域信息取得
	 * @return 最新版域信息
	 */
	public List<LabelValueBean> getDomainList() {
		return domainList;
	}
	/**
	 * 最新版域信息设定
	 * @param domainList最新版域信息
	 */
	public void setDomainList(List<LabelValueBean> domainList) {
		this.domainList = domainList;
	}
	
	/**
	 * 查询类型取得
	 * @return 查询类型
	 */
	public List<LabelValueBean> getTypeList() {
		return typeList;
	}
	/**
	 * 查询类型设定
	 * @param typeList查询类型
	 */
	public void setTypeList(List<LabelValueBean> typeList) {
		this.typeList = typeList;
	}
	
	
	/**
	 * 域明细信息取得
	 * @return 域明细信息
	 */
	public IGCIM0213Form getIgcim0213Form() {
		return igcim0213Form;
	}
	/**
	 * 域明细信息设定
	 * @param igcim0213Form域明细信息
	 */
	public void setIgcim0213Form(IGCIM0213Form igcim0213Form) {
		this.igcim0213Form = igcim0213Form;
	}
	
	/**
	 * 资产域明细表检索条件接口取得
	 * @return 资产域明细表检索条件接口
	 */
	public SOC0126SearchCond getEiDomainDetailVWSearchCond() {
		return eiDomainDetailVWSearchCond;
	}
	
	/**
	 * 资产域明细表检索条件接口设定
	 * @param eiDomainDetailVWSearchCond资产域明细表检索条件接口
	 */
	public void setEiDomainDetailVWSearchCond(
			SOC0126SearchCond eiDomainDetailVWSearchCond) {
		this.eiDomainDetailVWSearchCond = eiDomainDetailVWSearchCond;
	}
	public List<SOC0136Info> getSOC0136InfoList() {
		return eiDomainDetailCIInfoList;
	}
	public void setSOC0136InfoList(
			List<SOC0136Info> eiDomainDetailCIInfoList) {
		this.eiDomainDetailCIInfoList = eiDomainDetailCIInfoList;
	}
	
	/**
	 * 域明细信息取得
	 * @return 域明细信息
	 */
	public List<SOC0138Info> getSOC0138InfoList() {
		return eiDomainDetailCIOneInfoList;
	}

	/**
	 * 域明细信息设定
	 * @param eiDomainDetailInfoList域明细信息
	 */
	public void setSOC0138InfoList(
			List<SOC0138Info> eiDomainDetailCIOneInfoList) {
		this.eiDomainDetailCIOneInfoList = eiDomainDetailCIOneInfoList;
	}
	
	public IGCIM0802Form getIgcim0802Form() {
		return igcim0802Form;
	}
	public void setIgcim0802Form(IGCIM0802Form igcim0802Form) {
		this.igcim0802Form = igcim0802Form;
	}
	public List<CR03Info> getCr03InfoList() {
		return cr03InfoList;
	}
	public void setCr03InfoList(List<CR03Info> cr03InfoList) {
		this.cr03InfoList = cr03InfoList;
	}
	
}
