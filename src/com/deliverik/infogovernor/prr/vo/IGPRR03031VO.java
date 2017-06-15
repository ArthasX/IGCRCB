/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �û���ѯvo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR03031VO extends BaseVO{

	/** �û���ɫMap */
	protected Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap;

	/**
	 * �û���ɫMapȡ��
	 * @return userRoleInfoMap �û���ɫMap
	 */
	public Map<Integer, Map<String, List<UserRoleInfo>>> getUserRoleInfoMap() {
		return userRoleInfoMap;
	}

	/**
	 * �û���ɫMap�趨
	 * @param userRoleInfoMap �û���ɫMap
	 */
	public void setUserRoleInfoMap(
			Map<Integer, Map<String, List<UserRoleInfo>>> userRoleInfoMap) {
		this.userRoleInfoMap = userRoleInfoMap;
	}
	
}
