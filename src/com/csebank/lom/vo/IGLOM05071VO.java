/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ʳ�ýӴ�����VO
 *
 */
public class IGLOM05071VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * ʳ�ýӴ�����������
	 */
	protected List<Eentertainment> eentertainmentList;

	/**
	 * ʳ�ýӴ�����������ȡ��
	 * @return ʳ�ýӴ�����������
	 */
	public List<Eentertainment> getEentertainmentList() {
		return eentertainmentList;
	}

	/**
	 * ʳ�ýӴ�����������
	 * @param eentertainmentList ʳ�ýӴ�����������
	 */
	public void setEentertainmentList(List<Eentertainment> eentertainmentList) {
		this.eentertainmentList = eentertainmentList;
	}

}
