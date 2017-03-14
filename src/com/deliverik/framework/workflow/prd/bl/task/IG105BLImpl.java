/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG105DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;

/**
 * ����: ���̲����趨��Ϣҵ���߼�ʵ��
 * �������������̲����趨��Ϣҵ���߼�ʵ��
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public class IG105BLImpl extends BaseBLImpl implements
	IG105BL {

	/** �����¼�����DAO */
	protected IG105DAO ig105DAO;

	/**
	 * �����¼�����DAO
	 * 
	 * @param processStrategyDefDAO�����¼�����DAO
	 */
	public void setIg105DAO(
			IG105DAO ig105DAO) {
		this.ig105DAO = ig105DAO;
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond��������
	 * @return ���������������
	 */
	public int getSearchCount(IG105SearchCond cond) {
		return ig105DAO.getSearchCount(cond);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param pk���̲����趨��Ϣ����
	 * @return ���̲����趨��Ϣ
	 */
	public IG105Info searchIG105InfoByKey(IG105PK pk)
			throws BLException {

		return ig105DAO.findByPK(pk);
	}

	/**
	 * ���ܣ�ȫ����������
	 * 
	 * @return ȫ�����̲����趨��Ϣ
	 */
	public List<IG105Info> searchIG105InfoAll() {
		return ig105DAO.findAll();
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<IG105Info> searchIG105Info(
			IG105SearchCond cond, int start, int count) {
		return ig105DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG105Info> searchIG105Info(IG105SearchCond cond) {
		return ig105DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ���ܣ���¼����
	 * 
	 * @param processStrategyDef��¼����
	 * @return ���̲����趨��Ϣ
	 */
	public IG105Info registIG105Info(IG105Info ig105Info)
			throws BLException {
		return ig105DAO.save(ig105Info);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param pk���̲����趨��Ϣ����
	 */
	public void deleteIG105Info(IG105PK pk) throws BLException {

		IG105Info processStrategyDef = checkExistIG105Info(pk);

		ig105DAO.delete(processStrategyDef);
	}

	/**
	 * ���ܣ��������
	 * 
	 * @param processStrategyDef�������
	 * @return ���̲����趨��Ϣ
	 */
	public IG105Info updateIG105Info(IG105Info ig105Info)
			throws BLException {
		IG105PK pk = new IG105PK(ig105Info.getPdid(), ig105Info.getPrstatus(), 
				ig105Info.getPrurgency(), ig105Info.getPsdversion());
		checkExistIG105Info(pk);
		return ig105DAO.save(ig105Info);
	}

	/**
	 * ���ܣ����̲����趨��Ϣ���ڼ��
	 * 
	 * @param pk���̲����趨��Ϣ����
	 * @return ���̲����趨��Ϣ
	 * @throws BLException
	 */
	protected IG105Info checkExistIG105Info(IG105PK pk)
			throws BLException {
		IG105Info info = ig105DAO.findByPK(pk);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "���̲����趨����");
		}
		return info;
	}
	
	/**
	 * ���ܣ���ȡָ�����̶���ID��ǰ�������汾��
	 * @param pdid���̶���ID
	 * @return ��ǰ�������汾��
	 */
	public Integer getMaxgPsdversion(String pdid) {
		return ig105DAO.getMaxgPsdversion(pdid);
	}
	
}
