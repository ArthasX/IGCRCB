/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�û���ѯvo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD02011VO extends BaseVO{

	/** �û���ɫ��Ϣ���� */
	protected List<UserRoleInfo> userroleList;;
	
	/**
	 * �û���ɫ��Ϣ����ȡ��
	 * @return �û���ɫ��Ϣ����
	 */
	public List<UserRoleInfo> getUserroleList() {
		return userroleList;
	}

	/**
	 * �û���ɫ��Ϣ�����趨
	 * @param userroleList �û���ɫ��Ϣ����
	 */
	public void setUserroleList(List<UserRoleInfo> userroleList) {
		this.userroleList = userroleList;
	}
}
