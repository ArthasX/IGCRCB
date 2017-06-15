/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0001SearchCond;
import com.deliverik.infogovernor.dwp.model.dao.IGDWP0001DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�ʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0001BLImpl extends BaseBLImpl implements IGDWP0001BL{

	/** �ճ������ƻ�ʵ��DAO */
	protected IGDWP0001DAO igdwp0001DAO;

	/**
	 * �ճ������ƻ�ʵ��DAO�趨
	 * @param igdwp0001DAO �ճ������ƻ�ʵ��DAO
	 */
	public void setIgdwp0001DAO(IGDWP0001DAO igdwp0001dao) {
		igdwp0001DAO = igdwp0001dao;
	}
	
	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public IGDWP0001Info searchByPk(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0001SearchCond cond){
		return this.igdwp0001DAO.getSearchCount(cond);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGDWP0001Info> search(IGDWP0001SearchCond cond){
		return this.igdwp0001DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGDWP0001Info> search(IGDWP0001SearchCond cond,int start, int count){
		return this.igdwp0001DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IGDWP0001Info regist(IGDWP0001Info instance) throws BLException {
		return this.igdwp0001DAO.save(instance);
	}
	
	/**
	 * �޸Ĵ���
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IGDWP0001Info update(IGDWP0001Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return this.igdwp0001DAO.save(instance);
	}
	
	/**
	 * ɾ������
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException {
		this.igdwp0001DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void delete(IGDWP0001Info instance) throws BLException {
		this.igdwp0001DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 * @param pk ����
	 * @return ʵ��
	 */
	private IGDWP0001Info checkExistInstance(Integer pk) throws BLException{
		IGDWP0001Info instance = this.igdwp0001DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
}
