/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ǩ��VO
 * </p>
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM11011VO extends BaseVO{
	
	/**��ǩ��Map*/
	protected List<Map<String,Object>> signinMap ;

	/**
	 * ��ǩ��Mapȡ��
	 * @return signinMap ��ǩ��Map
	 */
	public List<Map<String, Object>> getSigninMap() {
		return signinMap;
	}

	/**
	 * ��ǩ��Map�趨
	 * @param signinMap ��ǩ��Map
	 */
	public void setSigninMap(List<Map<String, Object>> signinMap) {
		this.signinMap = signinMap;
	}
	
}
