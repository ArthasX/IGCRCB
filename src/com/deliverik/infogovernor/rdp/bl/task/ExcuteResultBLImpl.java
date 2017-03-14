/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;
import com.deliverik.infogovernor.rdp.model.condition.ExcuteResultSearchCond;
import com.deliverik.infogovernor.rdp.model.dao.ExcuteResultDAO;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultPK;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultTB;

/**
  * ����: ExcuteResultҵ���߼�ʵ��
  * ��������: ExcuteResultҵ���߼�ʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public class ExcuteResultBLImpl extends BaseBLImpl implements
		ExcuteResultBL {

	/** ExcuteResultDAO�ӿ� */
	protected ExcuteResultDAO excuteResultDAO;
	
	/**
	 * ExcuteResultDAO�ӿ��趨
	 *
	 * @param excuteResultDAO ExcuteResultDAO�ӿ�
	 */
	public void setExcuteResultDAO(ExcuteResultDAO excuteResultDAO) {
		this.excuteResultDAO = excuteResultDAO;
	}

	/**
	 * ExcuteResultʵ��ȡ��
	 *
	 * @return ExcuteResultʵ��
	 */
	public ExcuteResultTB getExcuteResultTBInstance() {
		return new ExcuteResultTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ExcuteResultInfo> searchExcuteResult() {
		return excuteResultDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ExcuteResultInfo searchExcuteResultByPK(ExcuteResultPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ExcuteResultSearchCond cond) {
		return excuteResultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ExcuteResultInfo> searchExcuteResult(
			ExcuteResultSearchCond cond) {
		return excuteResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ExcuteResultInfo> searchExcuteResult(
			ExcuteResultSearchCond cond, int start,
			int count) {
		return excuteResultDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ExcuteResultInfo registExcuteResult(ExcuteResultInfo instance)
		throws BLException {
		return excuteResultDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ExcuteResultInfo updateExcuteResult(ExcuteResultInfo instance)
		throws BLException {
		checkExistInstance(new ExcuteResultPK(instance.getHostid(), instance.getTaskid()));
		return excuteResultDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteExcuteResultByPK(ExcuteResultPK pk)
		throws BLException {
		excuteResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteExcuteResult(ExcuteResultInfo instance)
		throws BLException {
		excuteResultDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ExcuteResultInfo checkExistInstance(ExcuteResultPK pk)
		throws BLException {
		ExcuteResultInfo instance = excuteResultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}