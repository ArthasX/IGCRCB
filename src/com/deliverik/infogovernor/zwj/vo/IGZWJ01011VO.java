/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.zwj.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.User;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��Ա��ϢVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGZWJ01011VO extends BaseVO{
	/**	 * �û�����List */	
	protected List<User> userList;

	/**
	 * �û�����Listȡ��
	 * @return the userList
	 */
	public List<User> getUserList() {
		return userList;
	}

	/**
	 * �û�����List����
	 * @param userList the userList to set
	 */
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
