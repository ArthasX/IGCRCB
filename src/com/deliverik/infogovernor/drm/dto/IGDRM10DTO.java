/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.dto;

import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.igflow.resultset.RoleInfo;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.infogovernor.drm.form.IGDRM1001Form;
import com.deliverik.infogovernor.drm.form.IGDRM1003Form;
import com.deliverik.infogovernor.drm.form.IGDRM1004Form;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;
import com.deliverik.infogovernor.drm.util.FlowDetail;

/**
 * 角色组织架构关系DTO
 */
@SuppressWarnings("serial")
public class IGDRM10DTO extends BaseDTO {
	
	/** 用户信息 */
	protected User user;
	
	/**允许查询的最大记录数*/
	protected int maxSearchCount;
	/**分页Bean*/
	protected PagingDTO pagingDto;
	/**角色组织架构关系List*/
	protected List<StructureRoleInfo> relationlist;
	/**rolelist*/
	protected List<RoleInfo> rolelist;
	protected IGDRM1001Form igdrm1001Form;
	protected IGDRM1003Form igdrm1003Form;
	protected IGDRM1004Form igdrm1004Form;
	
	/** 预案id */
	protected String planEiid;

	/** Ajax返回结果 */
	protected String jsonResult;
	
	/** 文件输出流 */
	protected OutputStream ops;
	
	/** 工作台信息 */
	protected Map<String, String> workbenchMap;
	

	
	
	/**
	 * 用户信息取得
	 * @return user 用户信息
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 用户信息设定
	 * @param user 用户信息
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public OutputStream getOps() {
		return ops;
	}

	public void setOps(OutputStream ops) {
		this.ops = ops;
	}
	/**CodeDetailDef*/
	protected CodeDetailDef codDetailDef;
	/** 数据分类信息检索结果 */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;
	
	/** 数据分类信息 */
	protected CodeCategoryDefInfo codeCategoryDefInfo;
	
	/** 数据详细信息检索结果集 */
	protected List<CodeDetailDef> codeDetailDefList;
	
	/** 数据详细信息 */
	protected CodeDetailDef codeDetailDef;
	/**组织机构过滤标识*/
	protected String orgFlag;
	/**组织机构的标识符*/
	protected String syscoding;
	/**应急组织架构角色关系*/
	protected List<StructureRoleInfo> structureRoleList;
	/**应急组织架构每个层中的人员*/
	protected Map<String, List<UserTB>> userRoleMap;

	/**
	 * 组织架构层次集合
	 * 
	 * /** 组织架构Map <组织架构层次吗,相关岗位List<岗位信息Map>>
	 */
	protected LinkedHashMap<String, LinkedHashMap<String, Object>> orgArr;

	public LinkedHashMap<String, LinkedHashMap<String, Object>> getOrgArr() {
		return orgArr;
	}

	public void setOrgArr(LinkedHashMap<String, LinkedHashMap<String, Object>> orgArr) {
		this.orgArr = orgArr;
	}
	public CodeDetailDef getCodDetailDef() {
        return codDetailDef;
    }
    public void setCodDetailDef(CodeDetailDef codDetailDef) {
        this.codDetailDef = codDetailDef;
    }
    public List<StructureRoleInfo> getRelationlist() {
        return relationlist;
    }
    public void setRelationlist(List<StructureRoleInfo> relationlist) {
        this.relationlist = relationlist;
    }
    public List<RoleInfo> getRolelist() {
        return rolelist;
    }
    public void setRolelist(List<RoleInfo> rolelist) {
        this.rolelist = rolelist;
    }
    /**
	 * 允许查询的最大记录数取得
	 * @return 允许查询的最大记录数
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	/**
	 * 允许查询的最大记录数设定
	 * @param maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * 分页Bean取得
	 * @return 分页Bean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	/**
	 * 分页Bean设定
	 * @param pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * @return the igdrm1001Form
	 */
	public IGDRM1001Form getIgdrm1001Form() {
		return igdrm1001Form;
	}
	/**
	 * @param igdrm1001Form the igdrm1001Form to set
	 */
	public void setIgdrm1001Form(IGDRM1001Form igdrm1001Form) {
		this.igdrm1001Form = igdrm1001Form;
	}
	/**
	 * @return the 数据分类信息检索结果
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}
	/**
	 * @param 数据分类信息检索结果 the codeCategoryDefInfoList to set
	 */
	public void setCodeCategoryDefInfoList(
			List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	/**
	 * @return the 数据分类信息
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}
	/**
	 * @param 数据分类信息 the codeCategoryDefInfo to set
	 */
	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}
	/**
	 * @return the 数据详细信息检索结果集
	 */
	public List<CodeDetailDef> getCodeDetailDefList() {
		return codeDetailDefList;
	}
	/**
	 * @param 数据详细信息检索结果集 the codeDetailDefList to set
	 */
	public void setCodeDetailDefList(List<CodeDetailDef> codeDetailDefList) {
		this.codeDetailDefList = codeDetailDefList;
	}
	/**
	 * @return the 数据详细信息
	 */
	public CodeDetailDef getCodeDetailDef() {
		return codeDetailDef;
	}
	/**
	 * @param 数据详细信息 the codeDetailDef to set
	 */
	public void setCodeDetailDef(CodeDetailDef codeDetailDef) {
		this.codeDetailDef = codeDetailDef;
	}
	/**
	 * @return the 组织机构过滤标识
	 */
	public String getOrgFlag() {
		return orgFlag;
	}
	/**
	 * @param 组织机构过滤标识 the orgFlag to set
	 */
	public void setOrgFlag(String orgFlag) {
		this.orgFlag = orgFlag;
	}
	/**
	 * @return the igdrm1003Form
	 */
	public IGDRM1003Form getIgdrm1003Form() {
		return igdrm1003Form;
	}
	/**
	 * @param igdrm1003Form the igdrm1003Form to set
	 */
	public void setIgdrm1003Form(IGDRM1003Form igdrm1003Form) {
		this.igdrm1003Form = igdrm1003Form;
	}
	/**
	 * @return the igdrm1004Form
	 */
	public IGDRM1004Form getIgdrm1004Form() {
		return igdrm1004Form;
	}
	/**
	 * @param igdrm1004Form the igdrm1004Form to set
	 */
	public void setIgdrm1004Form(IGDRM1004Form igdrm1004Form) {
		this.igdrm1004Form = igdrm1004Form;
	}
	/**  
	 * 获取syscoding  
	 * @return syscoding 
	 */
	public String getSyscoding() {
		return syscoding;
	}
	/**  
	 * 设置syscoding  
	 * @param syscoding
	 */
	
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}
	/**  
	 * 获取structureRoleList  
	 * @return structureRoleList 
	 */
	public List<StructureRoleInfo> getStructureRoleList() {
		return structureRoleList;
	}
	/**  
	 * 设置structureRoleList  
	 * @param structureRoleList
	 */
	
	public void setStructureRoleList(List<StructureRoleInfo> structureRoleList) {
		this.structureRoleList = structureRoleList;
	}
	/**  
	 * 获取userRoleMap  
	 * @return userRoleMap 
	 */
	public Map<String, List<UserTB>> getUserRoleMap() {
		return userRoleMap;
	}
	/**  
	 * 设置userRoleMap  
	 * @param userRoleMap
	 */
	
	public void setUserRoleMap(Map<String, List<UserTB>> userRoleMap) {
		this.userRoleMap = userRoleMap;
	}

	/**
	 * Ajax返回结果取得
	 * @return jsonResult Ajax返回结果
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * Ajax返回结果设定
	 * @param jsonResult Ajax返回结果
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * 工作台信息取得
	 * @return workbenchMap 工作台信息
	 */
	public Map<String, String> getWorkbenchMap() {
		return workbenchMap;
	}

	/**
	 * 工作台信息设定
	 * @param workbenchMap 工作台信息
	 */
	public void setWorkbenchMap(Map<String, String> workbenchMap) {
		this.workbenchMap = workbenchMap;
	}

	public String getPlanEiid() {
		return planEiid;
	}

	public void setPlanEiid(String planEiid) {
		this.planEiid = planEiid;
	}
}