/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserInfo;

/**
 * @Description: ����OAִ����VO
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01091VO extends BaseVO implements Serializable {

	/** �û��б� */
	protected List<UserInfo> userInfoList;
	
	/**
	 * ���췽��
	 * @param userInfoList�û��б�
	 */
	public IGPRR01091VO(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	/**
	 * �û��б�ȡ��
	 * @return �û��б�
	 */
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	
}
