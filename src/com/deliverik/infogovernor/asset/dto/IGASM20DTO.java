/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM2001Form;
import com.deliverik.infogovernor.asset.form.IGASM2002Form;
import com.deliverik.infogovernor.asset.form.IGASM2003Form;
import com.deliverik.infogovernor.asset.form.IGASM2005Form;
import com.deliverik.infogovernor.asset.form.IGASM2006Form;
import com.deliverik.infogovernor.asset.form.IGASM2007Form;
import com.deliverik.infogovernor.asset.form.IGASM2010Form;
import com.deliverik.infogovernor.asset.form.IGASM2012Form;
import com.deliverik.infogovernor.asset.form.IGASM2013Form;
/**
 * 概述: 资产域定义业务用DTO
 * 功能描述: 资产域定义业务用DTO
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM20DTO extends BaseDTO implements Serializable {

	/**
	 * 资产域定义表检索条件接口
	 */
	protected EiDomainDefSearchCond eiDomainDefSearchCond;
	
	/**
	 * 资产域明细表检索条件接口
	 */
	protected EiDomainDetailMaxVWSearchCond eiDomainDetailVWSearchCond;
	
	/**
	 * 导入对象表检索条件接口
	 */
	protected ImportVersionSearchCond importVersionSearchCond;
	
	/**
	 * 导入程序类型
	 */
	protected List<EiImportProgrammeInfo> eiImportProgrammeList;
	
	/** 域明细信息 */
	protected List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList;
	
	
	protected List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList;
	
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
	

	/** 资产域定义信息 */
	protected IGASM2002Form igasm2002Form;
	
	/** 资产域定义详细信息 */
	protected IGASM2005Form igasm2005Form;
	
	/** 导入对象信息 */
	protected IGASM2006Form igasm2006Form;
	
	/** 导入对象信息 */
	protected IGASM2007Form igasm2007Form;
	
	/** 资产域定义版本Form */
	protected IGASM2012Form igasm2012Form;
	
	/** 域CI查询条件信息*/
	protected IGASM2013Form igasm2013Form;
	
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
	protected EiDomainDefInfo eiDomainDefInfo;

	/** 资产域定义检索结果 */
	protected List<EiDomainDefInfo> eiDomainDefInfoList;
	
	/** 导入对象检索结果 */
	protected List<ImportVersionInfo> importVersionInfoList;
	
	/** 导入对象检索结果 */
	protected ImportVersionInfo importVersionInfo;
	
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
	protected IGASM2001Form igasm2001Form;
	
	/** 控制台任务列表 */
	protected List<EiWaitTaskInfo> eiWaitTaskList;
	
	/** 控制台显示FORM */
	protected IGASM2010Form igasm2010Form;
	
	/** 控制台任务 */
	protected EiWaitTaskInfo eiWaitTask;
	/** 用户信息 */
	protected User user;
	
	/** 资产域定义详细信息 */
	protected IGASM2003Form igasm2003Form;
	
	public IGASM2003Form getIgasm2003Form() {
		return igasm2003Form;
	}
	public void setIgasm2003Form(IGASM2003Form igasm2003Form) {
		this.igasm2003Form = igasm2003Form;
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
	public EiDomainDefSearchCond getEiDomainDefSearchCond() {
		return eiDomainDefSearchCond;
	}

	/**
	 * 资产域定义表检索条件接口设置
	 * 
	 * @param eiDomainDefSearchCond资产域定义表检索条件接口
	 */
	public void setEiDomainDefSearchCond(
			EiDomainDefSearchCond eiDomainDefSearchCond) {
		this.eiDomainDefSearchCond = eiDomainDefSearchCond;
	}


	/**
	 * 资产域定义信息取得
	 * 
	 * @return 资产域定义信息
	 */
	public IGASM2002Form getIgasm2002Form() {
		return igasm2002Form;
	}

	/**
	 * 资产域定义信息设置
	 * 
	 * @param igasm2002Form资产域定义信息
	 */
	public void setIgasm2002Form(IGASM2002Form igasm2002Form) {
		this.igasm2002Form = igasm2002Form;
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
	public List<EiDomainDefInfo> getEiDomainDefInfoList() {
		return eiDomainDefInfoList;
	}

	/**
	 * 资产域定义检索结果设定
	 * 
	 * @param eiDomainDefInfoList资产域定义检索结果
	 */
	public void setEiDomainDefInfoList(List<EiDomainDefInfo> eiDomainDefInfoList) {
		this.eiDomainDefInfoList = eiDomainDefInfoList;
	}

	/**
	 * 资产域定义详细信息取得
	 * @return 资产域定义详细信息
	 */
	public IGASM2005Form getIgasm2005Form() {
		return igasm2005Form;
	}
	/**
	 * 资产域定义详细信息设定
	 * @param igasm2005Form资产域定义详细信息
	 */
	public void setIgasm2005Form(IGASM2005Form igasm2005Form) {
		this.igasm2005Form = igasm2005Form;
	}

	/**
	 * 控制台显示FORM取得
	 * 
	 * @return 控制台显示FORM
	 */
	public IGASM2001Form getIgasm2001Form() {
		return igasm2001Form;
	}

	/**
	 * 控制台显示FORM设定
	 * 
	 * @param igasm2001Form 控制台显示FORM
	 */
	public void setIgasm2001Form(IGASM2001Form igasm2001Form) {
		this.igasm2001Form = igasm2001Form;
	}

	/**
	 * 控制台任务列表
	 * 
	 * @return 控制台任务列表取得
	 */
	public List<EiWaitTaskInfo> getEiWaitTaskList() {
		return eiWaitTaskList;
	}

	/**
	 * 控制台任务列表设定
	 * 
	 * @param eiWaitTaskList 控制台任务列表
	 */
	public void setEiWaitTaskList(List<EiWaitTaskInfo> eiWaitTaskList) {
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
	public IGASM2006Form getIgasm2006Form() {
		return igasm2006Form;
	}
	
	/**
	 * 导入对象信息
	 * @param igasm2006Form导入对象信息
	 */
	public void setIgasm2006Form(IGASM2006Form igasm2006Form) {
		this.igasm2006Form = igasm2006Form;
	}
	
	/**
	 * 导入对象检索结果 
	 * @return 导入对象检索结果 
	 */
	public List<ImportVersionInfo> getImportVersionInfoList() {
		return importVersionInfoList;
	}

	/**
	 * 导入对象检索结果 
	 * @param importVersionInfoList导入对象检索结果 
	 */
	public void setImportVersionInfoList(
			List<ImportVersionInfo> importVersionInfoList) {
		this.importVersionInfoList = importVersionInfoList;
	}

	/**
	 * 导入对象表检索条件接口取得
	 * @return 导入对象表检索条件接口
	 */
	public ImportVersionSearchCond getImportVersionSearchCond() {
		return importVersionSearchCond;
	}

	/**
	 * 导入对象表检索条件接口设定
	 * @param importVersionSearchCond导入对象表检索条件接口
	 */
	public void setImportVersionSearchCond(
			ImportVersionSearchCond importVersionSearchCond) {
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
	public IGASM2007Form getIgasm2007Form() {
		return igasm2007Form;
	}
	/**
	 * 导入对象信息设定
	 * @param igasm2007Form导入对象信息
	 */
	public void setIgasm2007Form(IGASM2007Form igasm2007Form) {
		this.igasm2007Form = igasm2007Form;
	}

	/**
	 * 控制台显示FORM取得
	 * 
	 * @return 控制台显示FORM
	 */
	public IGASM2010Form getIgasm2010Form() {
		return igasm2010Form;
	}

	/**
	 * 控制台显示FORM设定
	 * 
	 * @param igasm2010Form 控制台显示FORM
	 */
	public void setIgasm2010Form(IGASM2010Form igasm2010Form) {
		this.igasm2010Form = igasm2010Form;
	}

	/**
	 * 控制台任务取得
	 * 
	 * @return 控制台任务
	 */
	public EiWaitTaskInfo getEiWaitTask() {
		return eiWaitTask;
	}

	/**
	 * 控制台任务设定
	 * 
	 * @param eiWaitTask 控制台任务
	 */
	public void setEiWaitTask(EiWaitTaskInfo eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}
	
	/**
	 * 导入程序类型取得
	 * @return 导入程序类型
	 */
	public List<EiImportProgrammeInfo> getEiImportProgrammeList() {
		return eiImportProgrammeList;
	}

	/**
	 * 导入程序类型设定
	 * @param eiImportProgrammeList导入程序类型
	 */
	public void setEiImportProgrammeList(
			List<EiImportProgrammeInfo> eiImportProgrammeList) {
		this.eiImportProgrammeList = eiImportProgrammeList;
	}
	
	/**
	 * 导入对象检索结果
	 * @return 导入对象检索结果
	 */
	public ImportVersionInfo getImportVersionInfo() {
		return importVersionInfo;
	}

	/**
	 * 导入对象检索结果
	 * @param importVersionInfo导入对象检索结果
	 */
	public void setImportVersionInfo(ImportVersionInfo importVersionInfo) {
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
	public IGASM2012Form getIgasm2012Form() {
		return igasm2012Form;
	}
	/**
	 * 资产域定义版本Form设定
	 * @param igasm2012Form资产域定义版本Form
	 */
	public void setIgasm2012Form(IGASM2012Form igasm2012Form) {
		this.igasm2012Form = igasm2012Form;
	}
	/**
	 * 资产域定义检索结果取得
	 * @return 资产域定义检索结果
	 */
	public EiDomainDefInfo getEiDomainDefInfo() {
		return eiDomainDefInfo;
	}
	/**
	 * 资产域定义检索结果设定
	 * @param eiDomainDefInfo资产域定义检索结果
	 */
	public void setEiDomainDefInfo(EiDomainDefInfo eiDomainDefInfo) {
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
	public List<EiDomainDetailMaxVWInfo> getEiDomainDetailVWInfoList() {
		return eiDomainDetailVWInfoList;
	}

	/**
	 * 域明细信息设定
	 * @param eiDomainDetailInfoList域明细信息
	 */
	public void setEiDomainDetailVWInfoList(
			List<EiDomainDetailMaxVWInfo> eiDomainDetailVWInfoList) {
		this.eiDomainDetailVWInfoList = eiDomainDetailVWInfoList;
	}
	
	/**
	 * 域明细信息取得
	 * @return 域明细信息
	 */
	public IGASM2013Form getIgasm2013Form() {
		return igasm2013Form;
	}
	/**
	 * 域明细信息设定
	 * @param igasm2013Form域明细信息
	 */
	public void setIgasm2013Form(IGASM2013Form igasm2013Form) {
		this.igasm2013Form = igasm2013Form;
	}
	
	/**
	 * 资产域明细表检索条件接口取得
	 * @return 资产域明细表检索条件接口
	 */
	public EiDomainDetailMaxVWSearchCond getEiDomainDetailVWSearchCond() {
		return eiDomainDetailVWSearchCond;
	}
	
	/**
	 * 资产域明细表检索条件接口设定
	 * @param eiDomainDetailVWSearchCond资产域明细表检索条件接口
	 */
	public void setEiDomainDetailVWSearchCond(
			EiDomainDetailMaxVWSearchCond eiDomainDetailVWSearchCond) {
		this.eiDomainDetailVWSearchCond = eiDomainDetailVWSearchCond;
	}
	public List<EiDomainDetailCIInfo> getEiDomainDetailCIInfoList() {
		return eiDomainDetailCIInfoList;
	}
	public void setEiDomainDetailCIInfoList(
			List<EiDomainDetailCIInfo> eiDomainDetailCIInfoList) {
		this.eiDomainDetailCIInfoList = eiDomainDetailCIInfoList;
	}
	
	
	
}
