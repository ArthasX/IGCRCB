/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * @Description: ���̶���_������Vo
 * @Author  
 * @History 2013-01-06     �½� 
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGPRR01181VO extends BaseVO implements Serializable {/**��������Ϣ����*/
	
	/**�û���ɫ��Ϣ*/
	List<UserRoleInfo> userRoleInfo;
	
	
	/**
	 *<p>�û���ɫ��Ϣ userRoleInfoȡ��</p>
	 *<p>2013-1-9����2:09:24</p>
	 */
	public List<UserRoleInfo> getUserRoleInfo() {
		return userRoleInfo;
	}

	/**
	 *<p>�û���ɫ��Ϣ userRoleInfo����</p>
	 *<p>2013-1-9����2:09:24</p>
	 */
	public void setUserRoleInfo(List<UserRoleInfo> userRoleInfo) {
		this.userRoleInfo = userRoleInfo;
	}
	
}
