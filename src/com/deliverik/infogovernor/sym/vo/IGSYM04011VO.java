/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��Ȩ��ѯVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04011VO extends BaseVO implements Serializable {

	/**
	 * �û�����List
	 */
	
	protected List<User> userList;

	/**
	 * ���췽��
	 * @param userList List<User>
	 */
	
	public IGSYM04011VO(List<User> userList) {
		this.userList = userList;
	}
	
	/**
	 * ��ȡ�û�����List
	 * @return List<User>
	 */
	
	public List<User> getUserList() {
		return userList;
	}
}
