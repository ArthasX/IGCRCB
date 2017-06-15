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
 * ���ݷ����б���Ϣ��������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGDRM10031VO extends BaseVO implements Serializable{
	
	/** ���ݷ����б���Ϣ������� */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;
	/** ������ϸ��Ϣ��������� */
	protected List<CodeDetailDef> codeDetailDefInfoList; 
	
	/**Ӧ����֯�ܹ���ɫ��ϵ*/
	protected List<StructureRoleInfo> structureRoleList;
	/**Ӧ����֯�ܹ�ÿ�����е���Ա*/
	protected Map<String, List<UserTB>> userRoleMap;
	
	/** ���ݷ�����Ϣ */
	protected CodeCategoryDefInfo codeCategoryDefInfo ;

	/**
	 * ��֯�ܹ���μ���
	 * 
	 * /** ��֯�ܹ�Map <��֯�ܹ������,��ظ�λList<��λ��ϢMap>>
	 */
	protected LinkedHashMap<String, LinkedHashMap<String, Object>> orgArr;

	public LinkedHashMap<String, LinkedHashMap<String, Object>> getOrgArr() {
		return orgArr;
	}

	public void setOrgArr(LinkedHashMap<String, LinkedHashMap<String, Object>> orgArr) {
		this.orgArr = orgArr;
	}

	/**
	 * ���캯��
	 * @param entityData�����ݷ����б���Ϣ�������
	 */
	public IGDRM10031VO(List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	
	/**
	 * ���ݷ����б���Ϣ�������ȡ��
	 * @return ���ݷ����б���Ϣ�������
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}

	/**  
	 * ��ȡcodeDetailDefInfoList  
	 * @return codeDetailDefInfoList 
	 */
	public List<CodeDetailDef> getCodeDetailDefInfoList() {
		return codeDetailDefInfoList;
	}

	/**  
	 * ����codeDetailDefInfoList  
	 * @param codeDetailDefInfoList
	 */
	
	public void setCodeDetailDefInfoList(List<CodeDetailDef> codeDetailDefInfoList) {
		this.codeDetailDefInfoList = codeDetailDefInfoList;
	}

	/**  
	 * ��ȡstructureRoleList  
	 * @return structureRoleList 
	 */
	public List<StructureRoleInfo> getStructureRoleList() {
		return structureRoleList;
	}

	/**  
	 * ����structureRoleList  
	 * @param structureRoleList
	 */
	
	public void setStructureRoleList(List<StructureRoleInfo> structureRoleList) {
		this.structureRoleList = structureRoleList;
	}

	/**  
	 * ��ȡuserRoleMap  
	 * @return userRoleMap 
	 */
	public Map<String, List<UserTB>> getUserRoleMap() {
		return userRoleMap;
	}

	/**  
	 * ����userRoleMap  
	 * @param userRoleMap
	 */
	
	public void setUserRoleMap(Map<String, List<UserTB>> userRoleMap) {
		this.userRoleMap = userRoleMap;
	}

	/**  
	 * ��ȡcodeCategoryDefInfo  
	 * @return codeCategoryDefInfo 
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}

	/**  
	 * ����codeCategoryDefInfo  
	 * @param codeCategoryDefInfo
	 */
	
	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}

	
	
}


