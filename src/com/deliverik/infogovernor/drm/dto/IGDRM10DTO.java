/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ��ɫ��֯�ܹ���ϵDTO
 */
@SuppressWarnings("serial")
public class IGDRM10DTO extends BaseDTO {
	
	/** �û���Ϣ */
	protected User user;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;
	/**��ҳBean*/
	protected PagingDTO pagingDto;
	/**��ɫ��֯�ܹ���ϵList*/
	protected List<StructureRoleInfo> relationlist;
	/**rolelist*/
	protected List<RoleInfo> rolelist;
	protected IGDRM1001Form igdrm1001Form;
	protected IGDRM1003Form igdrm1003Form;
	protected IGDRM1004Form igdrm1004Form;
	
	/** Ԥ��id */
	protected String planEiid;

	/** Ajax���ؽ�� */
	protected String jsonResult;
	
	/** �ļ������ */
	protected OutputStream ops;
	
	/** ����̨��Ϣ */
	protected Map<String, String> workbenchMap;
	

	
	
	/**
	 * �û���Ϣȡ��
	 * @return user �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
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
	/** ���ݷ�����Ϣ������� */
	protected List<CodeCategoryDefInfo> codeCategoryDefInfoList;
	
	/** ���ݷ�����Ϣ */
	protected CodeCategoryDefInfo codeCategoryDefInfo;
	
	/** ������ϸ��Ϣ��������� */
	protected List<CodeDetailDef> codeDetailDefList;
	
	/** ������ϸ��Ϣ */
	protected CodeDetailDef codeDetailDef;
	/**��֯�������˱�ʶ*/
	protected String orgFlag;
	/**��֯�����ı�ʶ��*/
	protected String syscoding;
	/**Ӧ����֯�ܹ���ɫ��ϵ*/
	protected List<StructureRoleInfo> structureRoleList;
	/**Ӧ����֯�ܹ�ÿ�����е���Ա*/
	protected Map<String, List<UserTB>> userRoleMap;

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
	 * �����ѯ������¼��ȡ��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * ��ҳBeanȡ��
	 * @return ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	/**
	 * ��ҳBean�趨
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
	 * @return the ���ݷ�����Ϣ�������
	 */
	public List<CodeCategoryDefInfo> getCodeCategoryDefInfoList() {
		return codeCategoryDefInfoList;
	}
	/**
	 * @param ���ݷ�����Ϣ������� the codeCategoryDefInfoList to set
	 */
	public void setCodeCategoryDefInfoList(
			List<CodeCategoryDefInfo> codeCategoryDefInfoList) {
		this.codeCategoryDefInfoList = codeCategoryDefInfoList;
	}
	/**
	 * @return the ���ݷ�����Ϣ
	 */
	public CodeCategoryDefInfo getCodeCategoryDefInfo() {
		return codeCategoryDefInfo;
	}
	/**
	 * @param ���ݷ�����Ϣ the codeCategoryDefInfo to set
	 */
	public void setCodeCategoryDefInfo(CodeCategoryDefInfo codeCategoryDefInfo) {
		this.codeCategoryDefInfo = codeCategoryDefInfo;
	}
	/**
	 * @return the ������ϸ��Ϣ���������
	 */
	public List<CodeDetailDef> getCodeDetailDefList() {
		return codeDetailDefList;
	}
	/**
	 * @param ������ϸ��Ϣ��������� the codeDetailDefList to set
	 */
	public void setCodeDetailDefList(List<CodeDetailDef> codeDetailDefList) {
		this.codeDetailDefList = codeDetailDefList;
	}
	/**
	 * @return the ������ϸ��Ϣ
	 */
	public CodeDetailDef getCodeDetailDef() {
		return codeDetailDef;
	}
	/**
	 * @param ������ϸ��Ϣ the codeDetailDef to set
	 */
	public void setCodeDetailDef(CodeDetailDef codeDetailDef) {
		this.codeDetailDef = codeDetailDef;
	}
	/**
	 * @return the ��֯�������˱�ʶ
	 */
	public String getOrgFlag() {
		return orgFlag;
	}
	/**
	 * @param ��֯�������˱�ʶ the orgFlag to set
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
	 * ��ȡsyscoding  
	 * @return syscoding 
	 */
	public String getSyscoding() {
		return syscoding;
	}
	/**  
	 * ����syscoding  
	 * @param syscoding
	 */
	
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
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
	 * Ajax���ؽ��ȡ��
	 * @return jsonResult Ajax���ؽ��
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * Ajax���ؽ���趨
	 * @param jsonResult Ajax���ؽ��
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * ����̨��Ϣȡ��
	 * @return workbenchMap ����̨��Ϣ
	 */
	public Map<String, String> getWorkbenchMap() {
		return workbenchMap;
	}

	/**
	 * ����̨��Ϣ�趨
	 * @param workbenchMap ����̨��Ϣ
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