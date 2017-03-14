/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.dto;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.infogovernor.prd.form.IGPRD0301Form;
import com.deliverik.infogovernor.prd.form.IGPRD0302Form;
import com.deliverik.infogovernor.prd.form.IGPRD0303Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:流程组定义工具dto 
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD03DTO extends BaseDTO{
	
	protected IGPRD0301Form igprd0301Form;
	protected IGPRD0302Form igprd0302Form;
	protected IGPRD0303Form igprd0303Form;
	protected IG480Info processGroupDefinition;
	protected List<IG480Info> processGroupDefinitionList;
	protected IG380Info precessDefinition;
	protected List<IG380Info> innerPds;
	protected List<IG380Info> outerPds;
	
	/** 登录用户 */
	protected User user;
	

	/** 流程定义信息最大检索件数 */
	protected int maxSearchCount;
	
	
	/** 分页用DTO */
	protected PagingDTO pagingDto;
	
	/**severlet 上传附件*/
	protected FileItem fileItem;
	
	/**attkey */
	protected String attKey;
	
	
	public String getAttKey() {
        return attKey;
    }

    public void setAttKey(String attKey) {
        this.attKey = attKey;
    }

    public FileItem getFileItem() {
        return fileItem;
    }

    public void setFileItem(FileItem fileItem) {
        this.fileItem = fileItem;
    }

    /**
	 * igprd0301Form   取得
	 * @return igprd0301Form igprd0301Form
	 */
	public IGPRD0301Form getIgprd0301Form() {
		return igprd0301Form;
	}

	/**
	 * igprd0301Form   设定
	 * @param igprd0301Form igprd0301Form
	 */
	public void setIgprd0301Form(IGPRD0301Form igprd0301Form) {
		this.igprd0301Form = igprd0301Form;
	}

	/**
	 * processGroupDefineList   取得
	 * @return processGroupDefineList processGroupDefineList
	 */
	public List<IG480Info> getProcessGroupDefinitionList() {
		return processGroupDefinitionList;
	}

	/**
	 * processGroupDefineList   设定
	 * @param processGroupDefineList processGroupDefineList
	 */
	public void setProcessGroupDefinitionList(List<IG480Info> processGroupDefinitionList) {
		this.processGroupDefinitionList = processGroupDefinitionList;
	}

	/**
	 * maxSearchCount   取得
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * maxSearchCount   设定
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * pagingDto   取得
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * pagingDto   设定
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * igprd0302Form   取得
	 * @return igprd0302Form igprd0302Form
	 */
	public IGPRD0302Form getIgprd0302Form() {
		return igprd0302Form;
	}

	/**
	 * igprd0302Form   设定
	 * @param igprd0302Form igprd0302Form
	 */
	public void setIgprd0302Form(IGPRD0302Form igprd0302Form) {
		this.igprd0302Form = igprd0302Form;
	}

	/**
	 * processGroupDefinition   取得
	 * @return processGroupDefinition processGroupDefinition
	 */
	public IG480Info getProcessGroupDefinition() {
		return processGroupDefinition;
	}

	/**
	 * igprd030Form   取得
	 * @return igprd030Form igprd030Form
	 */
	public IGPRD0303Form getIgprd0303Form() {
		return igprd0303Form;
	}

	/**
	 * igprd030Form   设定
	 * @param igprd030Form igprd030Form
	 */
	public void setIgprd0303Form(IGPRD0303Form igprd0303Form) {
		this.igprd0303Form = igprd0303Form;
	}

	/**
	 * precessDefinition   取得
	 * @return precessDefinition precessDefinition
	 */
	public IG380Info getPrecessDefinition() {
		return precessDefinition;
	}

	/**
	 * precessDefinition   设定
	 * @param precessDefinition precessDefinition
	 */
	public void setPrecessDefinition(IG380Info precessDefinition) {
		this.precessDefinition = precessDefinition;
	}

	/**
	 * processGroupDefinition   设定
	 * @param processGroupDefinition processGroupDefinition
	 */
	public void setProcessGroupDefinition(IG480Info processGroupDefinition) {
		this.processGroupDefinition = processGroupDefinition;
	}

	/**
	 * innerPds   取得
	 * @return innerPds innerPds
	 */
	public List<IG380Info> getInnerPds() {
		return innerPds;
	}

	/**
	 * innerPds   设定
	 * @param innerPds innerPds
	 */
	public void setInnerPds(List<IG380Info> innerPds) {
		this.innerPds = innerPds;
	}

	/**
	 * outerPds   取得
	 * @return outerPds outerPds
	 */
	public List<IG380Info> getOuterPds() {
		return outerPds;
	}

	/**
	 * outerPds   设定
	 * @param outerPds outerPds
	 */
	public void setOuterPds(List<IG380Info> outerPds) {
		this.outerPds = outerPds;
	}

	/**
	 * 登录用户取得
	 * @return 登录用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 登录用户设定
	 * @param user 登录用户
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}
