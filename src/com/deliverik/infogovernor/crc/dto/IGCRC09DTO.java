/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⴦��DTO
 * </p>
 * 
 * @author ʷ����@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC09DTO extends BaseDTO{

	/** �û���Ϣ */
	protected User user;
	
	/** ������Ϣ���� */
	protected List<IG500Info> processList;
	
	protected IGWKM0101Form igwkm0101form;
	
	/** ������Ϣ */
	protected Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo;
	
	/** �������ѯ����map */
	protected Map<String, IG007Info> processInfoQueryMap;

	/** ��ֵ*/
	protected List<IG599Info> processInfoList;
	/** ������*/
	protected List<IG337Info> processParticipantList;
	/** ״̬����*/
	protected List<IG333Info> processStatusDefList;
	
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

	/**
	 * ������Ϣ����ȡ��
	 * @return processList ������Ϣ����
	 */
	public List<IG500Info> getProcessList() {
		return processList;
	}

	/**
	 * ������Ϣ�����趨
	 * @param processList ������Ϣ����
	 */
	public void setProcessList(List<IG500Info> processList) {
		this.processList = processList;
	}

	
	/**
	 * @return the igwkm0101form
	 */
	public IGWKM0101Form getIgwkm0101form() {
		return igwkm0101form;
	}

	/**
	 * @param igwkm0101form the igwkm0101form to set
	 */
	public void setIgwkm0101form(IGWKM0101Form igwkm0101form) {
		this.igwkm0101form = igwkm0101form;
	}

	/**
	 * ������Ϣȡ��
	 * @return assignInfo ������Ϣ
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfo() {
		return assignInfo;
	}

	/**
	 * ������Ϣ�趨
	 * @param assignInfo ������Ϣ
	 */
	public void setAssignInfo(Map<IG333Info, Map<Role, List<UserInfo>>> assignInfo) {
		this.assignInfo = assignInfo;
	}

	/**
	 * �������ѯ����mapȡ��
	 * @return processInfoQueryMap �������ѯ����map
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

	public List<IG599Info> getProcessInfoList() {
		return processInfoList;
	}

	public void setProcessInfoList(List<IG599Info> processInfoList) {
		this.processInfoList = processInfoList;
	}

	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	public void setProcessParticipantList(List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}
}
