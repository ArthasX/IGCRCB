/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**	
 * ����: ���ռ�⹤��ִ�в�ѯVO
 * ������¼��yukexin    2014-12-15 ����10:30:49	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGVEN02013VO extends BaseVO implements Serializable{
	/** ���ռ������Ϣ������� */
	protected List<IGVEN02012VO> igven02012voList;

	/**
	 * ���ռ������Ϣ�������ȡ��
	 * @return igven02012voList ���ռ������Ϣ�������
	 */
	public List<IGVEN02012VO> getIgven02012voList() {
		return igven02012voList;
	}

	/**
	 * ���ռ������Ϣ��������趨
	 * @param igven02012voList ���ռ������Ϣ�������
	 */
	public void setIgven02012voList(List<IGVEN02012VO> igven02012voList) {
		this.igven02012voList = igven02012voList;
	}
}
