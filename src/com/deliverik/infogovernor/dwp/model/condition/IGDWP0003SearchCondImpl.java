/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�����Ϣ��ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0003SearchCondImpl implements IGDWP0003SearchCond{

	/** ������ϢID */
	protected Integer prid;

	/**
	 * ������ϢIDȡ��
	 * @return prid ������ϢID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ������ϢID�趨
	 * @param prid ������ϢID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
}
