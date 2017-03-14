/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG113DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;

/**
 * <p>����:����־��Ϣҵ���߼�ʵ��</p>
 * <p>����������1.�洢����±���־</p>
 * <p>          2.�������־ֵ</p>
 * <p>          3.�������־ֵ��������</p>
 * <p>          4.�������̼�¼ID��ȡ����־ֵ��Ϣ����</p>
 * <p>          5.���ݲ�ѯ������ȡ����־ֵ��Ϣ����</p>
 * <p>          6.���ݱ���־ID��ȡ����־ֵ��Ϣ����</p>
 * <p>          7.��ȡ����־ʵ��</p>
 * <p>          8.����־ֵ��Ϣ���ڼ��</p>
 * <p>������¼��</p>
 */
public class IG113BLImpl extends BaseBLImpl implements IG113BL {

	/** ����־��Ϣ����DAO */
	protected IG113DAO ig113DAO;

	
	
	public void setIg113DAO(IG113DAO ig113DAO) {
		this.ig113DAO = ig113DAO;
	}

	/**
	 * ���ܣ��洢����±���־
	 * @param ����־List
	 * 
	 */
	public void saveOrUpdIG113Info(List<IG113Info> prInfoList)throws BLException {
		ig113DAO.saveOrUpdateAll(prInfoList);
	}

	/**
	 * ���ܣ��������־ֵ
	 * @param ����־ֵ����
	 * @throws BLException
	 */
	public IG113Info registIG113Info(IG113Info ig113Info) throws BLException{
		IG113Info recordLogVarInfo = ig113DAO.save(ig113Info);
		//ig113DAO.saveOrUpdateAll(RecordLogVarInfoList);
		return recordLogVarInfo;
	}
	
	/**
	 * ���ܣ��������־ֵ
	 * @param ����־ֵ����
	 * @throws BLException
	 */
	public void UpdateIG113Info(List<IG113Info> ig113InfoList) throws BLException{
		ig113DAO.saveOrUpdateAll(ig113InfoList);
	}
	
	/**
	 * ���ܣ��������̼�¼ID��ȡ����־ֵ��Ϣ����
	 * @param ����־ֵ��Ϣ����
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByIG036Info(Integer rlid){
		IG113SearchCondImpl cond = new IG113SearchCondImpl();
		cond.setRlid(rlid);
		List<IG113Info> prInfoList = ig113DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	/**
	 * ���ܣ����ݲ�ѯ������ȡ����־ֵ��Ϣ����
	 * @param ����־ֵ��Ϣ����
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByCond(IG113SearchCond cond){
		List<IG113Info> prInfoList = ig113DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	
	/**
	 * ���ܣ����ݱ���־ID��ȡ����־ֵ��Ϣ����
	 * @param rlvid ����־ID
	 * @throws BLException 
	 */
	public IG113Info searchIG113InfoByRlvid(Integer rlvid) throws BLException{
		return checkExistRecordLogVarInfo(rlvid);
	}
	
	/**
	 * ���ܣ���ȡ����־ʵ��
	 * 
	 * @return RecordLogVarInfoTB
	 */
	
	public IG113TB getIG113TBInstance(){
		return new IG113TB();
	}
	
	/**
	 * ���ܣ�����־ֵ��Ϣ���ڼ��
	 * 
	 * @param piid ����־ID
	 * @return ����־ֵ��Ϣ
	 * @throws BLException 
	 */
	private IG113Info checkExistRecordLogVarInfo(Integer rlvid) throws BLException{
		IG113Info info = ig113DAO.findByPK(rlvid);
		if( info == null) {
			throw new BLException(BLErrorType.COMMON_ERROR_TYPE,
					"IGCO10000.E004","����־����");
		}
		
		return info;
	}

}
