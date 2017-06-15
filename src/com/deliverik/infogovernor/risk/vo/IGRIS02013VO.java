/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��鹤��ִ�в�ѯVO
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGRIS02013VO extends BaseVO implements Serializable{
	/** ���ռ������Ϣ������� */
	protected List<IGRIS02012VO> igris02012voList;

	/**
	 * ���ռ������Ϣ�������ȡ��
	 * @return igris02012voList ���ռ������Ϣ�������
	 */
	public List<IGRIS02012VO> getIgris02012voList() {
		return igris02012voList;
	}

	/**
	 * ���ռ������Ϣ��������趨
	 * @param igris02012voList ���ռ������Ϣ�������
	 */
	public void setIgris02012voList(List<IGRIS02012VO> igris02012voList) {
		this.igris02012voList = igris02012voList;
	}
}
