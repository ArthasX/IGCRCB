/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.condition;

import java.util.List;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: vCloud��֯��ƽ̨��������ʵ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class VCD06SearchCondImpl implements VCD06SearchCond {

	/** ��֯���� */
	protected List<String> vorgs;

	/**
	 * ��֯����ȡ��
	 * @return vorgs ��֯����
	 */
	public List<String> getVorgs() {
		return vorgs;
	}

	/**
	 * ��֯�����趨
	 * @param vorgs ��֯����
	 */
	public void setVorgs(List<String> vorgs) {
		this.vorgs = vorgs;
	}
}
