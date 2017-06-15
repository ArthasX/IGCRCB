/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.asset.model.entity.IG499VW;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼҵ���߼��ӿ�
  * ��������: ��ͬ�ʲ���Ϣ��ͼҵ���߼��ӿ�
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public interface IG499BL extends BaseBL {

	/**
	 * ��ͬ�ʲ���Ϣ��ͼʵ��ȡ��
	 *
	 * @return ��ͬ�ʲ���Ϣ��ͼʵ��
	 */
	public IG499VW getIG499VWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG499Info> searchIG499Info();

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG499SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG499Info> searchIG499Info(
			IG499SearchCond cond, int start,
			int count);
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchImprestCount(IG499SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG499Info> findImprestByCond(IG499SearchCond cond, 
			int start, int count);
}