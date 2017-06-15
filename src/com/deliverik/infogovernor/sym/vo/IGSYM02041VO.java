/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM02041VO extends BaseVO implements Serializable {

	/**
	 * ��ɫ�����˼���
	 */
	protected Map<UserRoleInfo,List<UserInfo>> managerMap;
	
	/**
	 * ��ɫ����
	 */
	protected Map<String,String> roleMap;
	
	/**
	 * �ֻ����ͼ���,0ֵ��,1������
	 */
	protected Map<String,String> mobileMap;

	/**
	 * ��ȡ��ɫ�����˼���
	 * @return Map<UserRoleInfo, List<UserInfo>>
	 */
	public Map<UserRoleInfo, List<UserInfo>> getManagerMap() {
		return managerMap;
	}

	/**
	 * ���ý�ɫ�����˼���
	 * @param managerMap Map<UserRoleInfo, List<UserInfo>>
	 */
	public void setManagerMap(Map<UserRoleInfo, List<UserInfo>> managerMap) {
		this.managerMap = managerMap;
	}
	
	/**
	 * ��ȡ��ɫ����
	 * @return Map<String,String>
	 */
	public Map<String,String> getRoleMap() {
		return roleMap;
	}

	/**
	 * ���ý�ɫ����
	 * @param roleMap Map<String,String>
	 */
	public void setRoleMap(Map<String,String> roleMap) {
		this.roleMap = roleMap;
	}
	
	/**
	 * ��ȡ�ֻ����ͼ���
	 * @return Map<String,String>
	 */
	public Map<String,String> getMobileMap() {
		return mobileMap;
	}

	/**
	 * �����ֻ����ͼ���
	 * @param mobileMap Map<String,String>
	 */
	public void setMobileMap(Map<String,String> mobileMap) {
		this.mobileMap = mobileMap;
	}
	
}
