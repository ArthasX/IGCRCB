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
 * Description: ϵͳ����_ϵͳ����_�û�����_���ݽ�ɫ���Ͳ�ѯ�û�VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04081VO extends BaseVO implements Serializable {

	/**
	 * �û�List
	 */
	
	protected List<User> userList;
	
	/**
	 * ���췽��
	 * @param userList List<User>
	 */
	
	public IGSYM04081VO(List<User> userList) {
		this.userList = userList;
	}
	/**
	 * ��ȡ�û�
	 * @return List<User>
	 */
	
	public List<User> getUserList() {
		return userList;
	}

}
