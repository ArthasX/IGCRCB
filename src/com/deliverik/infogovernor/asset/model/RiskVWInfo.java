/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�Ʋ�ѯ�ӿ� �����գ�
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface RiskVWInfo {
	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public String getEiid();

	/**
	 * syscodingȡ��
	 * @return syscoding syscoding
	 */
	public String getSyscoding();

	/**
	 * ��������ȡ��
	 * @return riskly ��������
	 */
	public String getRiskly();

	/**
	 * ��������ȡ��
	 * @return riskarea ��������
	 */
	public String getRiskarea();

	/**
	 * ������ȡ��
	 * @return riskitem ������
	 */
	public String getRiskitem();

	/**
	 * ���յ㣨���㣩ȡ��
	 * @return einame ���յ㣨���㣩
	 */
	public String getEiname();

	/**
	 * ���صȼ�ȡ��
	 * @return grad ���صȼ�
	 */
	public String getGrad();

	/**
	 * ����������ȡ��
	 * @return poss ����������
	 */
	public String getPoss();

	/**
	 * ���ռ���ȡ��
	 * @return levels ���ռ���
	 */
	public String getLevels();

	/**
	 * ���յ��־ȡ��
	 * @return risksign ���յ��־
	 */
	public String getRisksign();
}
