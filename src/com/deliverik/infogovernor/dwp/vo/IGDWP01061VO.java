/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�����VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01061VO extends BaseVO{

	/** ������Ϣ���� */
	protected Map<IG333Info,Map<Role, List<UserInfo>>> assignInfoMap;

	/**
	 * ������Ϣ����ȡ��
	 * @return assignInfoMap ������Ϣ����
	 */
	public Map<IG333Info, Map<Role, List<UserInfo>>> getAssignInfoMap() {
		return assignInfoMap;
	}

	/**
	 * ������Ϣ�����趨
	 * @param assignInfoMap ������Ϣ����
	 */
	public void setAssignInfoMap(
			Map<IG333Info, Map<Role, List<UserInfo>>> assignInfoMap) {
		this.assignInfoMap = assignInfoMap;
	}
}
