/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_��ɫ������VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04071VO extends BaseVO implements Serializable {

	/**
	 * ��ɫ������map
	 */
	protected Map<Integer, UserInfo> userInfoMap;
	
	/**
	 * ���췽��
	 * @param userInfoMap Map<Integer, UserInfo>
	 */
	
	public IGSYM04071VO(Map<Integer, UserInfo> userInfoMap) {
		this.userInfoMap = userInfoMap;
	}
	/**
	 * ��ȡ��ɫ������map
	 * @return Map<Integer, UserInfo>
	 */
	public Map<Integer, UserInfo> getUserInfoMap() {
		return userInfoMap;
	}

}
