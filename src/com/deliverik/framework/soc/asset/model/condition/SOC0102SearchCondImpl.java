/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: ����ʲ����������ʵ��
  * ��������: ����ʲ����������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0102SearchCondImpl implements
		SOC0102SearchCond {
	
	/** ����ʲ�����(1:����, 2:�޸�) */
	protected String aucmptype;
	
	/** ����CI��ʶ */
	public List<String> topCIList;

	/**
	 * ����ʲ�����ȡ��
	 * @return ����ʲ�����
	 */
	public String getAucmptype() {
		return aucmptype;
	}

	/**
	 * ����ʲ������趨
	 * @param aucmptype ����ʲ�����
	 */
	public void setAucmptype(String aucmptype) {
		this.aucmptype = aucmptype;
	}

	/**
	 * ����CI��ʶȡ��
	 * @return ����CI��ʶ
	 */
	public List<String> getTopCIList() {
		return topCIList;
	}

	/**
	 * ����CI��ʶ�趨
	 * @param topCIList ����CI��ʶ
	 */
	public void setTopCIList(List<String> topCIList) {
		this.topCIList = topCIList;
	}
	
}