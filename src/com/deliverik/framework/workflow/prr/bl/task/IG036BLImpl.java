package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG036DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>
 * ��־��Ϣҵ���߼�ʵ��
 * </p>
 */
public class IG036BLImpl extends BaseBLImpl implements IG036BL{
	
	/**��ʷ��¼������Ϣ����*/
	protected IG036DAO ig036DAO;
	
	/**
	 * ������ʷ��¼������Ϣ����
	 * @param ig036DAO IG036DAO
	 */
	public void setIg036DAO(IG036DAO ig036DAO) {
		this.ig036DAO = ig036DAO;
	}

	/**
	 * <p>
	 * �����־��Ϣ
	 * </p>
	 * 
	 * @param ig036Info ��־��Ϣ
	 * @return ��־��Ϣ
	 * @throws BLException
	 */
	
	public IG036Info registIG036Info(IG036Info ig036Info) throws BLException{
		return ig036DAO.save(ig036Info);
	}

	/**
	 * <p>
	 * �޸���־��Ϣ
	 * </p>
	 * 
	 * @param ig036Info ��־��Ϣ
	 * @return ��־��Ϣ
	 * @throws BLException
	 */
	
	public IG036Info updateG036Info(IG036Info ig036Info) throws BLException{
		checkExistIG036Info(ig036Info.getRlid());
		return ig036DAO.save(ig036Info);
	}
	
	/**
	 * ������־��Ϣ���ڼ��
	 * 
	 * @param rlid ������־ID
	 * @return  ������־��Ϣ
	 * @throws BLException 
	 */
	private IG036Info checkExistIG036Info(Integer rlid) throws BLException{
		IG036Info info = ig036DAO.findByPK(rlid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","������־����");
		}
		return info;
	}

	/**
	 * ����������ѯ��־��Ϣ
	 * 
	 * @param pk ����ֵ
	 * @return ��־��Ϣ
	 * @throws BLException
	 */
	public IG036Info searchIG036InfoByPK(Integer pk) throws BLException{
		return ig036DAO.findByPK(pk);
		
	}
	
	/**
	 * <p>
	 * ��ȡָ�����̼�¼��������־��Ϣ
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @return ��־��Ϣ����
	 * @throws BLException
	 */
	
	public List<IG036Info> searchIG036InfoByPrid(Integer processId){
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setPrid(processId);
		return ig036DAO.findByCond(cond, 0, 0);
		
	}
	
	/**
	 * ���ݲ�ѯ������ȡ��־��Ϣ����
	 * @param ��־����ֵ��Ϣ����
	 * @throws BLException
	 */
	public List<IG036Info> searchIG036InfoByCond(IG036SearchCond cond){
		List<IG036Info> recordlogList = ig036DAO.findByCond(cond, 0, 0);
		return recordlogList;
	}
	
	/**
	 * ��ȡ��־��Ϣʵ��
	 * 
	 * @return ��־��Ϣʵ��
	 * @throws BLException
	 */
	
	public IG036TB getIG036TBInstance(){
		return new IG036TB();
	}

}
