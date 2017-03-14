/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG731DAO;

/**
 * <p>����:�������ʲ���ϵҵ���߼�ʵ��</p>
 * <p>����������1.������������</p>
 * <p>          2.������������</p>
 * <p>          3.ȫ����������</p>
 * <p>          4.��������</p>
 * <p>          5.ɾ������</p>
 * <p>          6.�������</p>
 * <p>          7.ͨ������ID��������</p>
 * <p>������¼:</p>
 */
public class IG731BLImpl extends BaseBLImpl implements IG731BL {
	
	/** �������ʲ���ϵDAO���� */
	protected IG731DAO ig731DAO;

	/**
	 * �������ʲ���ϵDAO
	 * @param ig731DAO�������ʲ���ϵDAO
	 */
	public void setIg731DAO(
			IG731DAO ig731DAO) {
		this.ig731DAO = ig731DAO;
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	
	public int getIG731InfoSearchCount(IG731SearchCond cond) {
		return ig731DAO.getSearchCount(cond);
	}
	
	

	/**
	 * ���ܣ�������������
	 * 
	 * @param pieid ����״̬ԾǨ����ID
	 * @return ����״̬ԾǨ������Ϣ
	 * @throws BLException 
	 */
	
	public IG731Info searchIG731InfoByKey(Integer pieid) throws BLException {
		return ig731DAO.findByPK(pieid);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG731Info> searchIG731Info(
			IG731SearchCond cond) {
		return ig731DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 * 
	 * @return ��������б�
	 */
	
	public List<IG731Info> searchProcessInfoEntityAll() {
		return ig731DAO.findAll();
	}

	/**
	 * ���ܣ���������
	 * 
	 * @param IG731Info ��������
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	
	public IG731Info registIG731Info(
			IG731Info processInfoEntity) throws BLException {
		return ig731DAO.save(processInfoEntity);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param pieid ɾ������״̬ԾǨ��������
	 * @throws BLException
	 */
	
	public void deleteIG731Info(Integer pieid) throws BLException {
		IG731Info processInfoEntity = ig731DAO.findByPK(pieid);
		ig731DAO.delete(processInfoEntity);
	}

	/**
	 * ���ܣ��������
	 * 
	 * @param ig731Info �������
	 * @return ����״̬ԾǨ����
	 * @throws BLException
	 */
	
	public IG731Info updateIG731Info(
			IG731Info ig731Info) throws BLException {
		return ig731DAO.save(ig731Info);
	}
	
	/**
	 * ���ܣ�ͨ������ID��������
	 * @param prid ����ID
	 * @return ��������б�
	 */
	
	public List<IG731Info> searchIG731InfoByPrid(Integer prid) {
		IG731SearchCondImpl cond = new IG731SearchCondImpl();
		cond.setPrid(prid);
		return ig731DAO.findByCond(cond, 0, 0);
	}


	/**
	 * ͨ������prid��ѯ��ص�ҵ��ϵͳ�ʲ�
	 * @param prid
	 * @return ��������б�
	 */
	public List<IG731Info> searchIG731InfoBySePrid(Integer prid,String flowType){
		return ig731DAO.searchIG731InfoBySePrid(prid,flowType);
	}

	
	/**
	 * ��������prid��ѯ������eiid
	 * @param prid ����id
	 * @param flowType ��������
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid( Integer prid, String flowType){
		return ig731DAO.searchSenceBySePrid(prid,flowType);
	}
}
