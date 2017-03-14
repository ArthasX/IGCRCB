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
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.drm.form.IGDRM0903Form;
import com.deliverik.infogovernor.drm.form.IGDRM0904Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
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
public class IGDRM09DTO extends BaseDTO implements Serializable {

	/**�����¼ID*/
	protected Integer prid;
	
	/**������ʵ��id*/
	protected Integer pgrid;
	
	public Integer getPgrid() {
		return pgrid;
	}

	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**����û�ID*/
	protected String userid;
	
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
	
	protected String prstatus;
	
	protected String prpdidLike;
	
	/**���̱���*/
	protected List<IG007Info> processInfoDef;
	
	/**������*/
	protected List<IG337Info> processParticipantList;

	/**��־*/
	protected Map<String, List<IG036Info>> recordLogAttachmentMap;

	/** ��ť */
	protected List<String> actionnameList;
	
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
	
	protected IGDRM0904Form igdrm0904Form;
	
	protected IG483Info groupProcessRecord;
	
	protected List<IG484Info> groupProcessRecordMembers;
	
	protected String groupProcessRecordXML;
	
	protected String xmlHeight;
	
	protected List<IG036Info> noticeList;
	
	
	
	
	
	public String getXmlHeight() {
		return xmlHeight;
	}

	public void setXmlHeight(String xmlHeight) {
		this.xmlHeight = xmlHeight;
	}

	public String getGroupProcessRecordXML() {
		return groupProcessRecordXML;
	}

	public void setGroupProcessRecordXML(String groupProcessRecordXML) {
		this.groupProcessRecordXML = groupProcessRecordXML;
	}

	/**
	 * igdrm0904Form   ȡ��
	 * @return igdrm0904Form igdrm0904Form
	 */
	public IGDRM0904Form getIgdrm0904Form() {
		return igdrm0904Form;
	}

	/**
	 * igdrm0904Form   �趨
	 * @param igdrm0904Form igdrm0904Form
	 */
	public void setIgdrm0904Form(IGDRM0904Form igdrm0904Form) {
		this.igdrm0904Form = igdrm0904Form;
	}

	protected String isAdmin;
	
	protected User user;
	
	/** ������תJSP */
	protected String forwardJsp;
	
	/** ���̲�ѯform */
	protected IGWKM0101Form igwkm0101From;

	/** �������ѯ����map */
	protected Map<String, IG007Info> processInfoQueryMap;
		
	/** ���form */
	protected IGDRM0903Form igdrm0903Form;
	
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
	
	/**
	 * prstatus   ȡ��
	 * @return prstatus prstatus
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * prstatus   �趨
	 * @param prstatus prstatus
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * prpdidLike   ȡ��
	 * @return prpdidLike prpdidLike
	 */
	public String getPrpdidLike() {
		return prpdidLike;
	}

	/**
	 * prpdidLike   �趨
	 * @param prpdidLike prpdidLike
	 */
	public void setPrpdidLike(String prpdidLike) {
		this.prpdidLike = prpdidLike;
	}

	/** ��������(�����б�) (��ѯ)��Ϣ���� */
	protected List<LabelValueBean> orgList;
	
	/** �����б� */
	protected List<LabelValueBean> labelValueBeanList;
	
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

	/**
	 * �����б�ֵ��Ϣȡ��
     * @return �����б�ֵ��Ϣ    
	 */
    public List<LabelValueBean> getLabelValueBeanList() {
        return labelValueBeanList;
    }

    /**
     * �����б�ֵ��Ϣ�趨
     * @param labelValueBeanList �����б�ֵ��Ϣ
     */
    public void setLabelValueBeanList(List<LabelValueBean> labelValueBeanList) {
        this.labelValueBeanList = labelValueBeanList;
    }

	/**
	 * igdrm00903Form   ȡ��
	 * @return igdrm00903Form igdrm00903Form
	 */
	public IGDRM0903Form getIgdrm0903Form() {
		return igdrm0903Form;
	}

	/**
	 * igdrm00903Form   �趨
	 * @param igdrm00903Form igdrm00903Form
	 */
	public void setIgdrm0903Form(IGDRM0903Form igdrm0903Form) {
		this.igdrm0903Form = igdrm0903Form;
	}

	public IG483Info getGroupProcessRecord() {
		return groupProcessRecord;
	}

	public void setGroupProcessRecord(IG483Info groupProcessRecord) {
		this.groupProcessRecord = groupProcessRecord;
	}

	public List<IG484Info> getGroupProcessRecordMembers() {
		return groupProcessRecordMembers;
	}

	public void setGroupProcessRecordMembers(
			List<IG484Info> groupProcessRecordMembers) {
		this.groupProcessRecordMembers = groupProcessRecordMembers;
	}

	public List<IG036Info> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<IG036Info> noticeList) {
		this.noticeList = noticeList;
	}


}
