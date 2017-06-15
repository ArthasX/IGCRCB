package com.deliverik.infogovernor.drm.vo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.infogovernor.drm.model.StructureRoleInfo;

/**
 * 数据分类列表信息检索结果ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM10031VO extends BaseVO implements Serializable{
	
	/** 数据分类列表信息检索结果 */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;
	/** 数据详细信息检索结果集 */
	protected List<CodeDetailDef> codeDetailDefInfoList; 
	
	/**应急组织架构角色关系*/
	protected List<StructureRoleInfo> structureRoleList;
	/**应急组织架构每个层中的人员*/
	protected Map<String, List<UserTB>> userRoleMap;
	
	/** 数据分类信息 */
	protected CodeCategoryDefInfo codeCategoryDefInfo ;

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

	/**
	 * 构造函数
	 * @param entityData　数据分类列表信息检索结果
	 */
	public IGDRM10031VO(List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	
	/**
	 * 数据分类列表信息检索结果取得
	 * @return 数据分类列表信息检索结果
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}

	/**  
	 * 获取codeDetailDefInfoList  
	 * @return codeDetailDefInfoList 
	 */
	public List<CodeDetailDef> getCodeDetailDefInfoList() {
		return codeDetailDefInfoList;
	}

	/**  
	 * 设置codeDetailDefInfoList  
	 * @param codeDetailDefInfoList
	 */
	
	public void setCodeDetailDefInfoList(List<CodeDetailDef> codeDetailDefInfoList) {
		this.codeDetailDefInfoList = codeDetailDefInfoList;
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
	 * 获取codeCategoryDefInfo  
	 * @return codeCategoryDefInfo 
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}

	/**  
	 * 设置codeCategoryDefInfo  
	 * @param codeCategoryDefInfo
	 */
	
	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}

	
	
}


