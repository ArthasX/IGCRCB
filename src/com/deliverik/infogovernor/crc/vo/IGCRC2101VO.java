/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**	
 * ����: ��Ա������Ϣ��ѯVO 
 * ������¼��yukexin    2014-8-7 10:03:28
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2101VO extends BaseVO{

	/** ��Ա������Ϣ���� */
	protected List<IGCRC2102VO> igcrc2102VOList;

	/** ��Ա����ͳ�Ʒ���ϼƽ�� */
	protected List<Integer> listSum;
	
	/**
	 * ��Ա������Ϣ����ȡ��
	 * @return prList ��Ա������Ϣ����
	 */
	public List<IGCRC2102VO> getIgcrc2102VOList() {
		return igcrc2102VOList;
	}
	
	/**
	 * ��Ա������Ϣ�����趨
	 * @param prList ��Ա������Ϣ����
	 */
	public void setIgcrc2102VOList(List<IGCRC2102VO> igcrc2102voList) {
		igcrc2102VOList = igcrc2102voList;
	}

	/**
	 * ��Ա����ͳ�Ʒ���ϼƽ��ȡ��
	 * @return listSum  ��Ա����ͳ�Ʒ���ϼƽ��
	 */
	public List<Integer> getListSum() {
		return listSum;
	}

	/**
	 * ��Ա����ͳ�Ʒ���ϼƽ���趨
	 * @param listSum  ��Ա����ͳ�Ʒ���ϼƽ��
	 */
	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}

}
