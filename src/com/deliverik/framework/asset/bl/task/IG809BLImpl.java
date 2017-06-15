/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.asset.model.dao.IG809DAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �ʲ���ϵͼ�ļ���Ϣҵ���߼��ӿ�
 *
 */
public class IG809BLImpl extends BaseBLImpl implements IG809BL{

	/** ig809 DAO */
	protected IG809DAO ig809DAO;
	
	public void setIg809DAO(
			IG809DAO ig809DAO) {
		this.ig809DAO = ig809DAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG809SearchCond cond){
		
		return ig809DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param eirfid ����
	 */
	public IG809Info searchIG809InfoByKey(Integer eirfid) throws BLException{
		
		return ig809DAO.findByPK(eirfid);
	}
	
	/**
	 * ȫ���������� 
	 */
	public List<IG809Info> searchIG809InfoAll(){
		
		return ig809DAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG809Info> searchIG809Info(IG809SearchCond cond, int start, int count){
		
		return ig809DAO.findByCond(cond,start,count);
	}
	
	/**
	 * ��¼����
	 * 
	 * @param ig809Info ��¼����
	 * @return �ʲ���ϵͼ�ļ���Ϣ
	 */
	public IG809Info registIG809Info(IG809Info ig809Info) throws BLException{
		
		return ig809DAO.save(ig809Info);
	}

	/**
	 * ɾ������
	 * 
	 * @param eirfid ����
	 * @return
	 */
	public void deleteIG809Info(Integer eirfid) throws BLException{
		
		IG809Info entityItemRealationFile = checkExistEntityItemRelationFile(eirfid);
		ig809DAO.delete(entityItemRealationFile);
	}
	
	/**
	 * ɾ������
	 * 
	 * @param ig809Info �ʲ���ϵͼ�ļ���Ϣ
	 * @return
	 */
	public void deleteIG809Info(IG809Info ig809Info) throws BLException{

		ig809DAO.delete(ig809Info);
	}

	/**
	 * �������
	 * 
	 * @param �������
	 * @return �ʲ���ϵͼ�ļ���Ϣ
	 */
	public IG809Info updateIG809Info(IG809Info entityItemRealationFile) throws BLException{
		
		checkExistEntityItemRelationFile(entityItemRealationFile.getEirfid());
		return ig809DAO.save(entityItemRealationFile);
	}
	
	/**
	 * ��Ϣ���ڼ��
	 * 
	 * @param eirfid ����
	 * @throws BLException 
	 */
	protected IG809Info checkExistEntityItemRelationFile(Integer eirfid) throws BLException{
		IG809Info eirf = ig809DAO.findByPK(eirfid);
		if( eirf == null) {
			throw new BLException("IGCO10000.E004","�ʲ���ϵͼ����");
		}
		return eirf;
	}
	
}
