/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCond;
import com.deliverik.infogovernor.drm.model.dao.ResponseStrategyDAO;
import com.deliverik.infogovernor.drm.model.entity.ResponseStrategyTB;

/**
  * ����: ������Ӧ����ҵ���߼�ʵ��
  * ��������: ������Ӧ����ҵ���߼�ʵ��
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
public class ResponseStrategyBLImpl extends BaseBLImpl implements
		ResponseStrategyBL {

	/** ������Ӧ����DAO�ӿ� */
	protected ResponseStrategyDAO responseStrategyDAO;
	
	/**
	 * ������Ӧ����DAO�ӿ��趨
	 *
	 * @param responseStrategyDAO ������Ӧ����DAO�ӿ�
	 */
	public void setResponseStrategyDAO(ResponseStrategyDAO responseStrategyDAO) {
		this.responseStrategyDAO = responseStrategyDAO;
	}

	/**
	 * ������Ӧ����ʵ��ȡ��
	 *
	 * @return ������Ӧ����ʵ��
	 */
	public ResponseStrategyTB getResponseStrategyTBInstance() {
		return new ResponseStrategyTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy() {
		return responseStrategyDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ResponseStrategyInfo searchResponseStrategyByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ResponseStrategySearchCond cond) {
		return responseStrategyDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ResponseStrategyInfo> searchResponseStrategy(
ResponseStrategySearchCond cond) throws BLException {
		return responseStrategyDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return responseStrategyDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ResponseStrategyInfo registResponseStrategy(ResponseStrategyInfo instance)
		throws BLException {
		return responseStrategyDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ResponseStrategyInfo updateResponseStrategy(ResponseStrategyInfo instance)
		throws BLException {
		checkExistInstance(instance.getRsid());
		return responseStrategyDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteResponseStrategyByPK(Integer pk)
		throws BLException {
		responseStrategyDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteResponseStrategy(ResponseStrategyInfo instance)
		throws BLException {
		responseStrategyDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ResponseStrategyInfo checkExistInstance(Integer pk)
		throws BLException {
		ResponseStrategyInfo instance = responseStrategyDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}