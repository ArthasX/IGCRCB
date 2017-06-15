/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG224DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;

/**
 * ����״̬��־ҵ���߼�ʵ��
 * 
 */
public class IG224BLImpl extends BaseBLImpl implements IG224BL{
	
	/** ����״̬��־ʵ��DAO*/
	protected IG224DAO ig224DAO;
	
	/**
	 * ����״̬��־ʵ��DAO�趨
	 * @param ig224DAO ����״̬��־ʵ��DAO
	 */
	public void setIg224DAO(
			IG224DAO ig224DAO) {
		this.ig224DAO = ig224DAO;
	}
	
	/**
	 * ��ȡ����״̬��־ʵ��
	 * @return RecordStatusLogTB
	 */
	public IG224TB getIG224TBInstance(){
		return new IG224TB();
	}
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG224SearchCond cond){
		
		return ig224DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param rslid ����״̬��־ID
	 * @return ����״̬��־
	 */
	public IG224Info searchIG224InfoByKey(Integer rslid) throws BLException{
		
		return checkExistRecordStatusLog(rslid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ������״̬��־��Ϣ
	 */
	public List<IG224Info> searchIG224InfoAll(){
		
		return ig224DAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG224Info> searchIG224Info(IG224SearchCond cond, int start, int count){
		
		return ig224DAO.findByCond(cond,start,count);
	}
	
	/**
	 * ��ǰ����״̬��־��Ϣȡ��
	 * 
	 * @param prid ����ID
	 * @param prstatus ����״̬
	 * @return ��ǰ����״̬��־��Ϣ
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224Info(Integer prid, String prstatus) throws BLException{
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		if(StringUtils.isNotEmpty(prstatus)){//Ӧ���ϰ�
			if(prstatus.length() > 3){
				if(prstatus.indexOf("_") > 0){
					cond.setPsdid(prstatus.split("_")[0]);
					cond.setPsdnum(Integer.valueOf(prstatus.split("_")[1]));
				}else{
					cond.setPsdid(prstatus);
				}
			}else{
				cond.setPrstatus(prstatus);
			}
		}
		cond.setNowstatus("Y");
		cond.setCurrentPrstatus(true);
		return ig224DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ��ǰ����״̬��־��Ϣȡ��
	 * 
	 * @param prid ����ID
	 * @param prstatus ����״̬
	 * @return ��ǰ����״̬��־��Ϣ
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224InfoByPsdid(Integer prid, String psdid) throws BLException{
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		if (psdid.indexOf("_") > -1) {
			cond.setPsdid(psdid.split("_")[0]);
			cond.setPsdnum(Integer.parseInt(psdid.split("_")[1]));
		} else {
			cond.setPsdid(psdid);
		}
		cond.setCurrentPrstatus(true);
		return ig224DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ��¼����
	 * 
	 * @param ig224Info ��¼����
	 * @return ����״̬��־
	 */
	public IG224Info registIG224Info(IG224Info ig224Info) throws BLException{
		
		return ig224DAO.save(ig224Info);
	}

	/**
	 * ɾ������
	 * 
	 * @param rslid ����״̬��־ID
	 * @return
	 */
	public void deleteIG224Info(Integer rslid) throws BLException{
		
		IG224Info recordStatusLog = checkExistRecordStatusLog(rslid);
		
		ig224DAO.delete(recordStatusLog);
	}

	/**
	 * �������
	 * 
	 * @param ig224Info �������
	 * @return ����״̬��־
	 */
	public IG224Info updateIG224Info(IG224Info ig224Info) throws BLException{
		
		checkExistRecordStatusLog(ig224Info.getRslid());
		return ig224DAO.save(ig224Info);
	}

	/**
	 * ����״̬��־���ڼ��
	 * 
	 * @param rslid ����״̬��־ID
	 * @return ����״̬��־
	 * @throws BLException 
	 */
	protected IG224Info checkExistRecordStatusLog(Integer rslid) throws BLException{
		IG224Info info = ig224DAO.findByPK(rslid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����״̬��־����");
		}
		return info;
	}
	/**
	 * ������������ dashboard ���ݳ�ʼ��ר��
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond){
		
		return ig224DAO.findByCondOrderByRslopentime(cond);
		
	}
}
