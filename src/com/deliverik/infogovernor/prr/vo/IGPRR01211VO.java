/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: ���̴���_��������ѯִ����VO
 * @Author  
 * @History 2013-02-28     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01211VO extends BaseVO implements Serializable {

	/** �����˼��� */
	protected List<UserRoleInfo> lst_UserRoleInfo;

	/**
	 * �����˼���ȡ��
	 *
	 * @return lst_UserRoleInfo �����˼���
	 */
	public List<UserRoleInfo> getLst_UserRoleInfo() {
		return lst_UserRoleInfo;
	}

	/**
	 * �����˼����趨
	 *
	 * @param lst_UserRoleInfo �����˼���
	 */
	public void setLst_UserRoleInfo(List<UserRoleInfo> lst_UserRoleInfo) {
		this.lst_UserRoleInfo = lst_UserRoleInfo;
	}
	
}
