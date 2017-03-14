/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCond;
import com.deliverik.infogovernor.drm.model.entity.ResponseStrategyTB;

/**
  * ����: ������Ӧ����ҵ���߼��ӿ�
  * ��������: ������Ӧ����ҵ���߼��ӿ�
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
public interface ResponseStrategyBL extends BaseBL {

	/**
	 * ������Ӧ����ʵ��ȡ��
	 *
	 * @return ������Ӧ����ʵ��
	 */
	public ResponseStrategyTB getResponseStrategyTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ResponseStrategyInfo searchResponseStrategyByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ResponseStrategySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy(ResponseStrategySearchCond cond) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy(
			ResponseStrategySearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ResponseStrategyInfo registResponseStrategy(ResponseStrategyInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ResponseStrategyInfo updateResponseStrategy(ResponseStrategyInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteResponseStrategyByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteResponseStrategy(ResponseStrategyInfo instance)
		throws BLException;

}