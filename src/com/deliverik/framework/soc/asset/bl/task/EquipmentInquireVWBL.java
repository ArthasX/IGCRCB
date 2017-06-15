/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.condition.EquipmentInquireVWSearchCond;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ
 * �����ˣ�����͢
 * ������¼�� 2013-02-01
 * �޸ļ�¼��
 */
public interface EquipmentInquireVWBL extends BaseBL{

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EquipmentInquireVWInfo> getEquipmentAndIP(final EquipmentInquireVWSearchCond cond, final int start, final int count);
	/**
	 * �������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������
	 */
	public int getEquipmentAndIPCount(final EquipmentInquireVWSearchCond cond);
}
