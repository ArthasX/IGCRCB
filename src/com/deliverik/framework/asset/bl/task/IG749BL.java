/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.condition.IG749SearchCond;
import com.deliverik.framework.asset.model.entity.IG749VW;

/**
  * ����: �ʲ�ģ����ͼҵ���߼��ӿ�
  * ��������: �ʲ�ģ����ͼҵ���߼��ӿ�
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public interface IG749BL extends BaseBL {

	/**
	 * �ʲ�ģ����ͼʵ��ȡ��
	 *
	 * @return �ʲ�ģ����ͼʵ��
	 */
	public IG749VW getIG749VWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG749Info> searchIG749Info();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public IG749Info searchIG749InfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(IG749SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<IG749Info> searchIG749Info(
			IG749SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param ig749Info����ʵ��
	 * @return ����ʵ��
	 */
	public IG749Info registIG749Info(IG749Info ig749Info)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param ig749Info�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG749Info updateIG749Info(IG749Info ig749Info)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteIG749InfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteIG749Info(IG749Info ig749Info)
		throws BLException;

}