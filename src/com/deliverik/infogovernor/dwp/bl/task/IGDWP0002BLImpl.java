/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0002SearchCond;
import com.deliverik.infogovernor.dwp.model.dao.IGDWP0002DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�������Ϣʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0002BLImpl extends BaseBLImpl implements IGDWP0002BL{

	/** �ճ������ƻ�������Ϣʵ��DAO */
	protected IGDWP0002DAO igdwp0002DAO;

	/**
	 * �ճ������ƻ�������Ϣʵ��DAO�趨
	 * @param igdwp0002DAO �ճ������ƻ�������Ϣʵ��DAO
	 */
	public void setIgdwp0002DAO(IGDWP0002DAO igdwp0002dao) {
		igdwp0002DAO = igdwp0002dao;
	}
	
	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public IGDWP0002Info searchByPk(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0002SearchCond cond){
		return this.igdwp0002DAO.getSearchCount(cond);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGDWP0002Info> search(IGDWP0002SearchCond cond){
		return this.igdwp0002DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGDWP0002Info> search(IGDWP0002SearchCond cond,int start, int count){
		return this.igdwp0002DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IGDWP0002Info regist(IGDWP0002Info instance) throws BLException {
		return this.igdwp0002DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IGDWP0002Info update(IGDWP0002Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return this.igdwp0002DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		this.igdwp0002DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void delete(IGDWP0002Info instance) throws BLException {
		this.igdwp0002DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 * @param pk ����
	 * @return ʵ��
	 */
	private IGDWP0002Info checkExistInstance(Integer pk) throws BLException{
		IGDWP0002Info instance = this.igdwp0002DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
