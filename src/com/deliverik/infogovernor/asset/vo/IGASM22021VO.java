package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * CI����ԱȽ����������֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM22021VO extends BaseVO implements Serializable{
	
	/** CI����ԱȽ��������� */
	protected List<CIResultInfo> ciResultList;

	/**
	 * CI����ԱȽ���������ȡ��
	 * @return CI����ԱȽ���������
	 */
	public List<CIResultInfo> getCiResultList() {
		return ciResultList;
	}

	/**
	 * CI����ԱȽ�������������
	 * @param ciResultList CI����ԱȽ���������
	 */
	public void setCiResultList(List<CIResultInfo> ciResultList) {
		this.ciResultList = ciResultList;
	}
}


