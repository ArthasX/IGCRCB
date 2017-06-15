/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG202DAO;

/**
 * <p>����:��ͨ����ҵ���߼��ӿ�</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.ȫ����������</p>
 * <p>          3.������������</p>
 * <p>          4.ɾ������</p>
 * <p>          5.�������</p>
 * <p>          6.���̹�ͬ�������ڼ��</p>
 * <p>������¼��
 */
public class IG202BLImpl extends BaseBLImpl implements IG202BL {

	/** ig202DAO DAO */
	protected IG202DAO ig202DAO;
	
	/**
	 * ���̹�ͨ��������DAO
	 * 
	 * @param ig202DAO���̹�ͨ��������DAO
	 */
	public void setIg202DAO(
			IG202DAO ig202DAO) {
		this.ig202DAO = ig202DAO;
	}


	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG202InfoSearchCount(IG202SearchCond cond){
		
		return ig202DAO.getSearchCount(cond);
	}

	
	/**
	 * ���ܣ�ȫ����������
	 * @param cond ��������
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG202Info> searchIG202Info(IG202SearchCond cond){
		
		List<IG202Info> ret = ig202DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG202Info> searchIG202Info(IG202SearchCond cond, int start, int count){
		
		List<IG202Info> ret = ig202DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * ���ܣ����봦��
	 * @param ig202Info
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public IG202Info registIG202Info(IG202Info ig202Info) throws BLException{
		
		return ig202DAO.save(ig202Info);
	}

	/**
	 * ���ܣ�ɾ������
	 * @param ppdid ɾ���������̲���������
	 * @throws BLException
	 */
	public void deleteIG202Info(Integer ppdid) throws BLException{

		IG202Info processInfoDefGeneral = checkExistIG202Info(ppdid);
		
		ig202DAO.delete(processInfoDefGeneral);
	}
	
	/**
	 * ���ܣ�ɾ������
	 * @param IG222 ���̲�����
	 * @throws BLException
	 */
	public void deleteIG202Info(IG202Info processInfoDefGeneral) throws BLException{
		IG202Info ppd = checkExistIG202Info(processInfoDefGeneral.getPidid());
		
		ig202DAO.delete(ppd);
	}

	/**
	 * ���ܣ��������
	 * @param IG222 �������
	 * @return ���̲�������Ϣ
	 * @throws BLException
	 */
	public IG202Info updateIG202Info(IG202Info processInfoDefGeneral) throws BLException{
		
		checkExistIG202Info(processInfoDefGeneral.getPidid());
		
		return ig202DAO.save(processInfoDefGeneral);
	}
	
	/**
	 * ���ܣ�����������������
	 * @param pidid
	 * @return processInfoDefGeneral
	 */
	public IG202Info findIG202InfoByPK(Integer pidid) throws BLException{
		return this.checkExistIG202Info(pidid);
	}
	
	/**
	 * ���ܣ����̹�ͬ�������ڼ��
	 * @param pidid ���̲�����ID
	 * @return ���̲�������Ϣ
	 * @throws BLException 
	 */
	protected IG202Info checkExistIG202Info(Integer pidid) throws BLException{
		IG202Info info = ig202DAO.findByPK(pidid);
		if( info == null) {
		//	throw new BLException("","");
		}
		return info;
	}
	
	/**
	 * ���ܣ�ȫ����������
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG202Info> searchIG202InfoAll(){
		return ig202DAO.findAll();
	}
	
	/**
	 * ���ܣ�����������¼��
	 * @param cond ��������
	 * @return ����������¼��
	 */
	public int searchIG202InfoCount(final IG202SearchCond cond){
		return ig202DAO.searchIG202InfoCount(cond);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG202Info> searchIG202InfoFromVW(final IG202SearchCond cond, final int start, final int count){
		return ig202DAO.searchIG202Info(cond,start,count);
	}
}
