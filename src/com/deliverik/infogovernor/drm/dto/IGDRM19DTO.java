/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0102Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0110Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM19DTO extends BaseDTO implements Serializable {

	/**�����¼ID*/
	protected Integer prid;
	
	/**����û�ID*/
	protected String userid;
	protected String prtitle;
	
	/**����û�����*/
	protected String username;
	
	/**�����ɫID*/
	protected Integer roleid;
	
	/**�����ɫ����*/
	protected String rolename;
	
	/**���״̬����Ա״̬*/
	protected String status;
	
	/**���̶���id*/
	protected String pdid;
	
	protected String prtype;
	
	/**���̱���*/
	protected List<IG007Info> processInfoDef;
	
	/**������*/
	protected List<IG337Info> processParticipantList;

	/**��־*/
	protected Map<String, List<IG036Info>> recordLogAttachmentMap;

	/** ��ť */
	protected List<String> actionnameList;

	/** ��ֵ */
	protected List<IG599Info> processInfoList;

	/** ״̬���� */
	protected List<IG333Info> processStatusDefList;

	
	/** ��ɫ */
	protected List<Role> roleList;

	/** �û���ɫ */
	protected List<UserRoleInfo> userRoleList;

	/**�������*/
	protected IG500Info process;
	
	/**���̱�������ֵ*/
	protected List<IG599Info> processInfo;
	
	/**�����ѯ�ӿ�*/
	protected IG500SearchCond prSearchCond;
	
	/**�������List*/
	protected List<IG500Info> processList;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	protected Map<String,String> nameURLMap;
	
	protected List<IG259Info> processTemplateList;
	
	protected List<IG380Info> processDefinitionList;
	
	protected String isAdmin;
	
	protected User user;
	
	/** ������תJSP */
	protected String forwardJsp;
	
	/** ���̲�ѯform */
	protected IGWKM0101Form igwkm0101From;

	/** �������ѯ����map */
	protected Map<String, IG007Info> processInfoQueryMap;
		
	/** ���form */
	protected IGWKM0102Form igwkm0102From;
	
	/** ���е�ǰ�����˵ı��¹��� */
	protected List<CurrentMonthWorkVWInfo> currentManagerList;
	
	/** ��ѯ����*/
	protected String type;

	/** �˵���ʶ */
	protected String actname;
	
	/** ��¼�˿ɼ��˵����� */
	protected UserPermission userPermission;
	
	/** �Զ�������ͨ�ò�ѯform */
	protected IGWKM0110Form igwkm0110Form;
	
	/** �ⲿ�����¼���ѯҳ����ʾ����� */
	protected int maxCnt;
	
	/** �ⲿ�����¼���ѯҳ���ҳ����*/
	protected PagingDTO pDto;
	
	/** �ⲿ�����¼���ѯ��Ϣ���� */
	protected List<IG500Info> scForOutList;
	
	/** ��������(�����б�) (��ѯ)��Ϣ���� */
	protected List<LabelValueBean> orgList;
	
	
	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * �˵���ʶȡ��
	 *
	 * @return actname �˵���ʶ
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * �˵���ʶ�趨
	 *
	 * @param actname �˵���ʶ
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}

	/**
	 * ��¼�˿ɼ��˵�����ȡ��
	 *
	 * @return userPermission ��¼�˿ɼ��˵�����
	 */
	public UserPermission getUserPermission() {
		return userPermission;
	}

	/**
	 * ��¼�˿ɼ��˵������趨
	 *
	 * @param userPermission ��¼�˿ɼ��˵�����
	 */
	public void setUserPermission(UserPermission userPermission) {
		this.userPermission = userPermission;
	}

	private List<IG333Info> iG333InfoList;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public List<IG259Info> getProcessTemplateList() {
		return processTemplateList;
	}

	public void setProcessTemplateList(List<IG259Info> processTemplateList) {
		this.processTemplateList = processTemplateList;
	}

	public Map<String, String> getNameURLMap() {
		return nameURLMap;
	}

	public void setNameURLMap(Map<String, String> nameURLMap) {
		this.nameURLMap = nameURLMap;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * ��ȡ�����¼ID
	 * @return �����¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���ñ����¼ID
	 * @param prid �����¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ȡ����û�ID
	 * @return ����û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ���ñ���û�ID
	 * @param userid ����û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ����û�����
	 * @return ����û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ���ñ���û�����
	 * @param username ����û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ȡ�����ɫID
	 * @return �����ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ���ñ����ɫID
	 * @param roleid �����ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ȡ�����ɫ����
	 * @return �����ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * ���ñ����ɫ����
	 * @param rolename �����ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��ȡ���״̬����Ա״̬
	 * @return ���״̬����Ա״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ���ñ��״̬����Ա״̬
	 * @param status ���״̬����Ա״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ��ȡ���̱���
	 * @return ���̱���
	 */
	public List<IG007Info> getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * �������̱���
	 * @param processInfoDef ���̱���
	 */
	public void setProcessInfoDef(List<IG007Info> processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	/**
	 * ��ȡ������
	 * @return ������
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * ���ò�����
	 * @param processParticipantList ������
	 */
	public void setProcessParticipantList(
			List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * ��ȡ��־
	 * @return ��־
	 */
	public Map<String, List<IG036Info>> getRecordLogAttachmentMap() {
		return recordLogAttachmentMap;
	}

	/**
	 * ������־
	 * @param recordLogAttachmentMap ��־
	 */
	public void setRecordLogAttachmentMap(
			Map<String, List<IG036Info>> recordLogAttachmentMap) {
		this.recordLogAttachmentMap = recordLogAttachmentMap;
	}

	/**
	 * ��ȡ��ť
	 * @return ��ť
	 */
	public List<String> getActionnameList() {
		return actionnameList;
	}

	/**
	 * ���ð�ť
	 * @param actionnameList ��ť
	 */
	public void setActionnameList(List<String> actionnameList) {
		this.actionnameList = actionnameList;
	}

	/**
	 * ��ȡ��ɫ
	 * @return ��ɫ
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * ���ý�ɫ
	 * @param roleList ��ɫ
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * ��ȡ�û���ɫ 
	 * @return �û���ɫ 
	 */
	public List<UserRoleInfo> getUserRoleList() {
		return userRoleList;
	}

	/**
	 * �����û���ɫ 
	 * @param userRoleList �û���ɫ 
	 */
	public void setUserRoleList(List<UserRoleInfo> userRoleList) {
		this.userRoleList = userRoleList;
	}

	/**
	 * ��ȡ�������
	 * @return �������
	 */
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * ���ñ������
	 * @param process �������
	 */
	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * ��ȡ���̱�������ֵ
	 * @return ���̱�������ֵ
	 */
	public List<IG599Info> getProcessInfo() {
		return processInfo;
	}

	/**
	 * �������̱�������ֵ
	 * @param processInfo ���̱�������ֵ
	 */
	public void setProcessInfo(List<IG599Info> processInfo) {
		this.processInfo = processInfo;
	}

	/**
	 * ��ȡ�����ѯ�ӿ�
	 * @return �����ѯ�ӿ�
	 */
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	/**
	 * ���ñ����ѯ�ӿ�
	 * @param prSearchCond �����ѯ�ӿ�
	 */
	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	/**
	 * ��ȡ�������List
	 * @return �������List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * ���ñ������List
	 * @param processList �������List
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	/**
	 * ��ȡ�����ѯ������¼��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡ��ҳBean
	 * @return ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

    /**
     * @return the ���̶���id
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param ���̶���id the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

	/**
	 * ������תJSPȡ��
	 * @return ������תJSP
	 */
	public String getForwardJsp() {
		return forwardJsp;
	}

	/**
	 * ������תJSP�趨
	 * @param forwardJsp������תJSP
	 */
	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	/**
	 * ���̲�ѯformȡ��
	 * @return ���̲�ѯform
	 */
	public IGWKM0101Form getIgwkm0101From() {
		return igwkm0101From;
	}

	/**
	 * ���̲�ѯform�趨
	 * @param igwkm0101From ���̲�ѯform
	 */
	public void setIgwkm0101From(IGWKM0101Form igwkm0101From) {
		this.igwkm0101From = igwkm0101From;
	}

	/**
	 * �������ѯ����mapȡ��
	 * @return �������ѯ����map
	 */
	public Map<String, IG007Info> getProcessInfoQueryMap() {
		return processInfoQueryMap;
	}

	/**
	 * �������ѯ����map�趨
	 * @param processInfoQueryMap �������ѯ����map
	 */
	public void setProcessInfoQueryMap(Map<String, IG007Info> processInfoQueryMap) {
		this.processInfoQueryMap = processInfoQueryMap;
	}

	/**
	 * ���е�ǰ�����˵ı��¹���ȡ��
	 * @return ���е�ǰ�����˵ı��¹���
	 */
	public List<CurrentMonthWorkVWInfo> getCurrentManagerList() {
		return currentManagerList;
	}

	/**
	 * ���е�ǰ�����˵ı��¹����趨
	 * @param currentManagerList ���е�ǰ�����˵ı��¹���
	 */
	public void setCurrentManagerList(
			List<CurrentMonthWorkVWInfo> currentManagerList) {
		this.currentManagerList = currentManagerList;
	}
	/**
	 * ���formȡ��
	 * @return ���form
	 */
	public IGWKM0102Form getIgwkm0102From() {
		return igwkm0102From;
	}
	/**
	 * ���form�趨
	 * @param igwkm0102From ���form
	 */
	public void setIgwkm0102From(IGWKM0102Form igwkm0102From) {
		this.igwkm0102From = igwkm0102From;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public void setIG333InfoList(List<IG333Info> iG333InfoList) {
		this.iG333InfoList = iG333InfoList;
	}

	/**
	 * iG333InfoListȡ��
	 * @return iG333InfoList iG333InfoList
	 */
	public List<IG333Info> getiG333InfoList() {
		return iG333InfoList;
	}

	/**
	 * iG333InfoList�趨
	 * @param iG333InfoList iG333InfoList
	 */
	public void setiG333InfoList(List<IG333Info> iG333InfoList) {
		this.iG333InfoList = iG333InfoList;
	}
	
	/**
	 * �ⲿ�����¼���ѯҳ����ʾ�����Ϣ��ȡ��
	 * @return �ⲿ�����¼���ѯҳ����ʾ�����Ϣ��
	 */
	public int getMaxCnt() {
		return maxCnt;
	}

	/**
	 * �ⲿ�����¼���ѯҳ����ʾ�����Ϣ���趨
	 * @param maxCnt �ⲿ�����¼���ѯҳ����ʾ�����Ϣ��
	 */
	public void setMaxCnt(int maxCnt) {
		this.maxCnt = maxCnt;
	}
	
	/**
	 * �ⲿ�����¼���ѯҳ���ҳ����ȡ��
	 * @return �ⲿ�����¼���ѯҳ���ҳ����
	 */
	public PagingDTO getpDto() {
		return pDto;
	}

	/**
	 * �ⲿ�����¼���ѯҳ���ҳ�����趨
	 * @param pDto �ⲿ�����¼���ѯҳ���ҳ����
	 */
	public void setpDto(PagingDTO pDto) {
		this.pDto = pDto;
	}
	
	/**
	 * �ⲿ�����¼���ѯ��Ϣ����ȡ��
	 * @return �ⲿ�����¼���ѯ��Ϣ����
	 */
	public List<IG500Info> getScForOutList() {
		return scForOutList;
	}

	/**
	 * �ⲿ�����¼���ѯ��Ϣ�����趨
	 * @param scForOutList �ⲿ�����¼���ѯ��Ϣ����
	 */
	public void setScForOutList(List<IG500Info> scForOutList) {
		this.scForOutList = scForOutList;
	}

	public List<LabelValueBean> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<LabelValueBean> orgList) {
		this.orgList = orgList;
	}

	/**
	 * �Զ�������ͨ�ò�ѯformȡ��
	 * @return igwkm0110Form �Զ�������ͨ�ò�ѯform
	 */
	public IGWKM0110Form getIgwkm0110Form() {
		return igwkm0110Form;
	}

	/**
	 * �Զ�������ͨ�ò�ѯform�趨
	 * @param igwkm0110Form �Զ�������ͨ�ò�ѯform
	 */
	public void setIgwkm0110Form(IGWKM0110Form igwkm0110Form) {
		this.igwkm0110Form = igwkm0110Form;
	}
	
}
