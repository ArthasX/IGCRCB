/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.orl.model.OrealPMVWInfo;
import com.deliverik.orl.model.condition.OrealPMVWSearchCond;
import com.deliverik.orl.model.entity.OrealPMVW;

/**
 * ������ŷ���ż��ָ����ͼҵ���߼��ӿ�
 * ����������ŷ���ż��ָ����ͼҵ���߼��ӿ�
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public interface OrealPMVWBL extends BaseBL {

	/**
	 * ���ָ����ͼʵ��ȡ��
	 *
	 * @return ���ָ����ͼʵ��
	 */
	public OrealPMVW getOrealPMVWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OrealPMVWInfo> searchOrealPMVW();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws BLException 
	 */
	public int getSearchCount(OrealPMVWSearchCond cond) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws BLException 
	 */
	public List<OrealPMVWInfo> searchOrealPMVWByCond(OrealPMVWSearchCond cond) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException 
	 */
	public List<OrealPMVWInfo> searchOrealPMVWByCond(OrealPMVWSearchCond cond, int start, int count) throws BLException;
}