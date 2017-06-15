/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR03SearchCond;
import com.deliverik.infogovernor.soc.model.dao.CR03DAO;
import com.deliverik.infogovernor.soc.model.entity.CR03PK;
import com.deliverik.infogovernor.soc.model.entity.CR03TB;

/**
  * ����: ����ԭ������������ϵ��ҵ���߼�ʵ��
  * ��������: ����ԭ������������ϵ��ҵ���߼�ʵ��
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
public class CR03BLImpl extends BaseBLImpl implements CR03BL {

	/** ����ԭ������������ϵ��DAO�ӿ� */
	protected CR03DAO cr03DAO;
	
	/**
	 * ����ԭ������������ϵ��DAO�ӿ��趨
	 *
	 * @param cR03DAO ����ԭ������������ϵ��DAO�ӿ�
	 */
	public void setCr03DAO(CR03DAO cr03DAO) {
		this.cr03DAO = cr03DAO;
	}

	/**
	 * ����ԭ������������ϵ��ʵ��ȡ��
	 *
	 * @return ����ԭ������������ϵ��ʵ��
	 */
	public CR03TB getCR03TBInstance() {
		return new CR03TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CR03Info> searchCR03() {
		return cr03DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CR03Info searchCR03ByPK(CR03PK pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CR03SearchCond cond) {
		return cr03DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CR03Info> searchCR03(CR03SearchCond cond) {
		return cr03DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CR03Info> searchCR03(CR03SearchCond cond, int start, int count) {
		return cr03DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CR03Info registCR03(CR03Info instance) throws BLException {
		return cr03DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CR03Info updateCR03(CR03Info instance) throws BLException {
//		checkExistInstance(new CR03PK(instance.getType(), instance.getIp(),instance.getHost(),instance.getCollecttime()));
		return cr03DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCR03ByPK(CR03PK pk) throws BLException {
		cr03DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCR03(CR03Info instance) throws BLException {
		cr03DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CR03Info checkExistInstance(CR03PK pk) throws BLException {
		CR03Info instance = cr03DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public List<CR03Info> findByCondMax(CR03SearchCond cond, int start, int count) {
		return cr03DAO.findByCondMax(cond, start, count);
	}
	
	/**
	 * ������������[������ڵĵ����type]
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CR03VWInfo> findByCondMaxAndEsyscoding(final CR03SearchCond cond, final int start, final int count){
		return cr03DAO.findByCondMaxAndEsyscoding(cond, start, count);
	}
	
	/**
	 * ���������������ȡ��[������ڵĵ����type]
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCountByCondMaxAndEsyscoding(final CR03SearchCond cond){
		return cr03DAO.getSearchCountByCondMaxAndEsyscoding(cond);
	}
	
	public List<CR03VWInfo> getRciVersions(final CR03SearchCond cond, final int start, final int count){
		return cr03DAO.getRciVersions(cond, start, count);
	}

}