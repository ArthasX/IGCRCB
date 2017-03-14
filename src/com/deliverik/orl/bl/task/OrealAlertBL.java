/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.orl.model.OrealAlertInfo;
import com.deliverik.orl.model.condition.OrealAlertSearchCond;
import com.deliverik.orl.model.entity.OrealAlertTB;

/**
 * ������ŷ���Ÿ澯��ҵ���߼��ӿ�
 * ����������ŷ���Ÿ澯��ҵ���߼��ӿ�
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public interface OrealAlertBL extends BaseBL {

	/**
	 * ŷ���Ÿ澯��ʵ��ȡ��
	 *
	 * @return ŷ���Ÿ澯��ʵ��
	 */
	public OrealAlertTB getOrealAlertTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OrealAlertInfo> searchOrealAlert();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws BLException 
	 */
	public int getSearchCount(OrealAlertSearchCond cond) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws BLException 
	 */
	public List<OrealAlertInfo> searchOrealAlertByCond(OrealAlertSearchCond cond) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException 
	 */
	public List<OrealAlertInfo> searchOrealAlertByCond(OrealAlertSearchCond cond, int start, int count) throws BLException;
}