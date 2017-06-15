/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0206SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0206DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0206TB;

/**
  * ����: ģ��ӳ���ҵ���߼�ʵ��
  * ��������: ģ��ӳ���ҵ���߼�ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateMappingBLImpl�����޸�ΪSOC0206BLImpl
  */
public class SOC0206BLImpl extends BaseBLImpl implements
		SOC0206BL {

	/** ģ��ӳ���DAO�ӿ� */
	protected SOC0206DAO soc0206DAO;
	
	/**
	 * ģ��ӳ���DAO�ӿ��趨
	 *
	 * @param soc0206DAO ģ��ӳ���DAO�ӿ�
	 */
	public void setSoc0206DAO(SOC0206DAO soc0206DAO) {
		this.soc0206DAO = soc0206DAO;
	}

	/**
	 * ģ��ӳ���ʵ��ȡ��
	 *
	 * @return ģ��ӳ���ʵ��
	 */
	public SOC0206TB getSOC0206Instance() {
		return new SOC0206TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0206Info> searchSOC0206() {
		return soc0206DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0206Info searchSOC0206ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0206SearchCond cond) {
		return soc0206DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0206Info> searchSOC0206(
			SOC0206SearchCond cond) {
		return soc0206DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0206Info> searchSOC0206(
			SOC0206SearchCond cond, int start,
			int count) {
		return soc0206DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0206Info registSOC0206(SOC0206Info instance)
		throws BLException {
		return soc0206DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0206Info updateSOC0206(SOC0206Info instance)
		throws BLException {
		checkExistInstance(instance.getRtmId());
		return soc0206DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0206ByPK(Integer pk)
		throws BLException {
		soc0206DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0206(SOC0206Info instance)
		throws BLException {
		soc0206DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0206Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0206Info instance = soc0206DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**����IDɾ��*/
	public Integer deleteByRtId(Integer rtId){
		int tmp=soc0206DAO.deleteByRtId(rtId);
		return tmp;
	}
}