/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.dto;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.soc.srv.form.IGSRV0217Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�����_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class IGSRV02DTO extends BaseDTO implements Serializable {
	
	/**�¼���¼ID*/
	protected Integer prid;
	
	/**�¼��û�ID*/
	protected String userid;
	
	/**�¼��û�����*/
	protected String username;
	
	/**�¼���ɫID*/
	protected Integer roleid;
	
	/**�¼���ɫ����*/
	protected String rolename;
	
	/**�¼�״̬����Ա״̬*/
	protected String status;
	
	/**���̶���id*/
	protected Integer pdid;
	
	/**���̱���*/
	protected List<IG007Info> processInfoDef;
	
	/**������*/
	protected List<IG337Info> processParticipantList;

	/**��־*/
	protected Map<IG036Info, List<Attachment>> recordLogAttachmentMap;

	/** ��ť */
	protected List<String> actionnameList;
	
	/** ��ɫ */
	protected List<Role> roleList;

	/** �û���ɫ */
	protected List<UserRoleInfo> userRoleList;

	/**�¼�����*/
	protected IG500Info process;
	
	/**���̱�������ֵ*/
	protected List<IG599Info> processInfo;
	
	/**�¼���ѯ�ӿ�*/
	protected IG500SearchCond prSearchCond;
	
	/**�¼���ݷ���ҳ*/
	protected IGSRV0217Form igsrv0217Form;
	
	/**�¼�����List*/
	protected List<IG500Info> processList;
	
	/**�¼�ȷ�ϱ�־*/
	protected String confirmflag;
	
	/**�¼�������*/
	private Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;

	/**�¼�������*/
	protected String urgency;
	
	/**�¼�Ԥ�ƽ��ʱ��*/
	protected String resolveTime;
	
	/**�����Ա��Ϣ*/
	protected Map<String,String> perMap;
	
	/**�����б���Ϣ*/
	protected Map<Integer,String[]> optionMap;
	
	/**�û���Ϣ*/
	protected User user;
	
	/**�¼��鿴ҳͼ����ʾ��ʶ*/
	protected String confirmImgFlag;
	
	/**�¼��鿴ҳ���븴�˰�ť��ʾ��ʶ*/
	protected String canDoFlag;
	
	/**���̹�ϵ��Ϣ�����б�*/
	protected List<IG512Info> processRecordRelationList;
	
	/**���񹤵���ϵ��Ϣ�����б�*/
	protected List<IG715Info> serviceProcessRecordRelationList;
	
	/** �¼���ѯ�������� */
	protected List<IG380Info> processDefinitionList;
	
	/** ����״̬��־���� */
	protected List<IG224Info> recordStatusLogList;
	
	protected String isAdmin;
	
	/** ���������ֶ� */
	protected String pSort;
	/** �����ֶ� */
	protected String pOrder;
	/** �����������ֶ� */
	protected String prtitle;

	public String getPsort_order() {
		return psort_order;
	}

	public void setPsort_order(String psort_order) {
		this.psort_order = psort_order;
	}

	protected String psort_order;
	
	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	/**
	 * @return the canDoFlag
	 */
	public String getCanDoFlag() {
		return canDoFlag;
	}

	/**
	 * @param canDoFlag the canDoFlag to set
	 */
	public void setCanDoFlag(String canDoFlag) {
		this.canDoFlag = canDoFlag;
	}

	/**
	 * @return the confirmImgFlag
	 */
	public String getConfirmImgFlag() {
		return confirmImgFlag;
	}

	/**
	 * @param confirmImgFlag the confirmImgFlag to set
	 */
	public void setConfirmImgFlag(String confirmImgFlag) {
		this.confirmImgFlag = confirmImgFlag;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(String resolveTime) {
		this.resolveTime = resolveTime;
	}

	/**
	 * ��ȡ�¼���¼ID
	 * @return �¼���¼ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * �����¼���¼ID
	 * @param prid �¼���¼ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��ȡ�¼��û�ID
	 * @return �¼��û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �����¼��û�ID
	 * @param userid �¼��û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ��ȡ�¼��û�����
	 * @return �¼��û�����
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �����¼��û�����
	 * @param username �¼��û�����
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ȡ�¼���ɫID
	 * @return �¼���ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �����¼���ɫID
	 * @param roleid �¼���ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ��ȡ�¼���ɫ����
	 * @return �¼���ɫ����
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * �����¼���ɫ����
	 * @param rolename �¼���ɫ����
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * ��ȡ�¼�״̬����Ա״̬
	 * @return �¼�״̬����Ա״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * �����¼�״̬����Ա״̬
	 * @param status �¼�״̬����Ա״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ��ȡ���̶���id
	 * @return ���̶���id
	 */
	public Integer getPdid() {
		return pdid;
	}

	/**
	 * �������̶���id
	 * @param pdid ���̶���id
	 */
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
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
	public Map<IG036Info, List<Attachment>> getRecordLogAttachmentMap() {
		return recordLogAttachmentMap;
	}

	/**
	 * ������־
	 * @param recordLogAttachmentMap ��־
	 */
	public void setRecordLogAttachmentMap(
			Map<IG036Info, List<Attachment>> recordLogAttachmentMap) {
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

	public Map<Integer, String[]> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<Integer, String[]> optionMap) {
		this.optionMap = optionMap;
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
	 * ��ȡ�¼�����
	 * @return �¼�����
	 */
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * �����¼�����
	 * @param process �¼�����
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
	 * ��ȡ�¼���ѯ�ӿ�
	 * @return �¼���ѯ�ӿ�
	 */
	public IG500SearchCond getPrSearchCond() {
		return prSearchCond;
	}

	/**
	 * �����¼���ѯ�ӿ�
	 * @param prSearchCond �¼���ѯ�ӿ�
	 */
	public void setPrSearchCond(IG500SearchCond prSearchCond) {
		this.prSearchCond = prSearchCond;
	}

	/**
	 * ��ȡ�¼���ݷ���ҳ
	 * @return �¼���ݷ���ҳ
	 */
	public IGSRV0217Form getIgsrv0217Form() {
		return igsrv0217Form;
	}

	/**
	 * �����¼���ݷ���ҳ
	 * @param igsvc0217Form �¼���ݷ���ҳ
	 */
	public void setIgsrv0217Form(IGSRV0217Form igsrv0217Form) {
		this.igsrv0217Form = igsrv0217Form;
	}

	/**
	 * ��ȡ�¼�����List
	 * @return �¼�����List
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * �����¼�����List
	 * @param processList �¼�����List
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
	
	/**
	 * ��ȡ�¼�������
	 * @return �¼�������
	 */
	public Map<String, TreeNode> getTreeNodeMap() {
		return treeNodeMap;
	}

	/**
	 * �����¼�������
	 * @param treeNodeMap �¼�������
	 */
	public void setTreeNodeMap(Map<String, TreeNode> treeNodeMap) {
		this.treeNodeMap = treeNodeMap;
	}

	/**
	 * ��ȡ�¼�ȷ�ϱ�־
	 * @return �¼�ȷ�ϱ�־
	 */
	public String getConfirmflag() {
		return confirmflag;
	}

	/**
	 * �����¼�ȷ�ϱ�־
	 * @param confirmflag �¼�ȷ�ϱ�־
	 */
	public void setConfirmflag(String confirmflag) {
		this.confirmflag = confirmflag;
	}

	/**
	 * ��ȡ�����Ա��Ϣ
	 * @return �����Ա��Ϣ
	 */
	public Map<String, String> getPerMap() {
		return perMap;
	}

	/**
	 * ���������Ա��Ϣ
	 * @param perMap �����Ա��Ϣ
	 */
	public void setPerMap(Map<String, String> perMap) {
		this.perMap = perMap;
	}

	/**
	 * ��ȡ���̹�ϵ��Ϣ�����б�
	 * @return ���̹�ϵ��Ϣ�����б�
	 */
	public List<IG512Info> getProcessRecordRelationList() {
		return processRecordRelationList;
	}

	/**
	 * �������̹�ϵ��Ϣ�����б�
	 * @param processRecordRelationList ���̹�ϵ��Ϣ�����б�
	 */
	public void setProcessRecordRelationList(
			List<IG512Info> processRecordRelationList) {
		this.processRecordRelationList = processRecordRelationList;
	}

	/**
	 * ��ȡ���񹤵���ϵ��Ϣ�����б�
	 * @return ���񹤵���ϵ��Ϣ�����б�
	 */
	public List<IG715Info> getServiceProcessRecordRelationList() {
		return serviceProcessRecordRelationList;
	}

	/**
	 * ���÷��񹤵���ϵ��Ϣ�����б�
	 * @param serviceProcessRecordRelationList ���񹤵���ϵ��Ϣ�����б�
	 */
	public void setServiceProcessRecordRelationList(
			List<IG715Info> serviceProcessRecordRelationList) {
		this.serviceProcessRecordRelationList = serviceProcessRecordRelationList;
	}

	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	public void setProcessDefinitionList(
			List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}
	
	/**
	 * ����״̬��־����ȡ��
	 * @return ����״̬��־����
	 */
	public List<IG224Info> getRecordStatusLogList() {
		return recordStatusLogList;
	}

	/**
	 * ����״̬��־�����趨
	 * @param recordStatusLogList ����״̬��־����
	 */
	public void setRecordStatusLogList(List<IG224Info> recordStatusLogList) {
		this.recordStatusLogList = recordStatusLogList;
	}

	public String getPSort() {
		return pSort;
	}

	public void setPSort(String sort) {
		pSort = sort;
	}

	public String getPOrder() {
		return pOrder;
	}

	public void setPOrder(String order) {
		pOrder = order;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	
	
}
