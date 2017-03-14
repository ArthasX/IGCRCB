/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * ���̶���_������Vo
 * 
 */
@SuppressWarnings("serial")
public class IGPRD01071VO extends BaseVO implements Serializable {

	/** δ��Ӳ����߶���List */
	protected List<Role> roleList;
	
	/** ����Ӳ����߶���List  */
	protected List<IG222Info> processParticipantDefList;
	
	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;
	
	/** ����Ӳ����߶���ListSize */
	protected Integer processParticipantDefListSize;
	
	/** ����״̬_�����߼��� */
	protected Map<Integer, List<IG222Info>> processParticipantDefMap;

	/**
	 * ���췽��
	 * @param roleList List<Role>,processParticipantDefList List<ProcessParticipantDef>
	 */
	
	public IGPRD01071VO(List<Role> roleList,List<IG222Info> processParticipantDefList) {
		this.roleList = roleList;
		this.processParticipantDefList = processParticipantDefList;
		if(processParticipantDefList == null) {
			processParticipantDefListSize = 0;
		} else {
			processParticipantDefListSize = processParticipantDefList.size();
		}
	}
	
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public void setProcessParticipantDefList(
			List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}
	

	/**
	 * ��ȡδ��Ӳ����߶���List
	 * @return List<Role>
	 */
	
	public List<Role> getRoleList() {
		return roleList;
	}

	
	/**
	 * ��ȡ����Ӳ����߶���List
	 * @return List<ProcessParticipant>
	 */

	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}

	/**
	 * ����״̬��Ϣȡ��
	 * 
	 * @return ����״̬��Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}
	
	/**
	 * ����״̬��Ϣ�趨
	 *
	 * @param processStatusDef ����״̬��Ϣ
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * ����Ӳ����߶���ListSize
	 * 
	 * @return ����Ӳ����߶���ListSize
	 */
	public Integer getProcessParticipantDefListSize() {
		return processParticipantDefListSize;
	}
	
	/**
	 * ����״̬_�����߼���ȡ��
	 * @return ����״̬_�����߼���
	 */
	public Map<Integer, List<IG222Info>> getProcessParticipantDefMap() {
		return processParticipantDefMap;
	}

	/**
	 * ����״̬_�����߼����趨
	 * @param processParticipantDefMap ����״̬_�����߼���
	 */
	public void setProcessParticipantDefMap(
			Map<Integer, List<IG222Info>> processParticipantDefMap) {
		this.processParticipantDefMap = processParticipantDefMap;
	}
}
