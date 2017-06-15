/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG599DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/**
 * <p>����:���̱�����Ϣҵ���߼�ʵ��</p>
 * <p>����������1.�����������̱���</p>
 * <p>          2.�������̱���</p>
 * <p>          3.�������̱�������ֵ</p>
 * <p>          4.�������̱�������ֵ</p>
 * <p>          5.�������̱�������ֵ(��������)</p>
 * <p>          6.�������̼�¼ID��ȡ���̱�������ֵ��Ϣ����</p>
 * <p>          7.�Զ������̹ر�״̬������Ϣ����ȡ��</p>
 * <p>          8.���ݲ�ѯ������ȡ���̱�������ֵ��Ϣ����</p>
 * <p>          9.�������̱���ID��ȡ���̱�������ֵ��Ϣ����</p>
 * <p>          10.��ȡ����ʵ��</p>
 * <p>          11.���̱�������ֵ��Ϣ���ڼ��</p>
 * <p>������¼��</p>
 */
public class IG599BLImpl extends BaseBLImpl implements IG599BL {

	/** ���̱���ҵ���߼�DAO*/
	protected IG599DAO ig599DAO;

	/**
	 * ���̱���ҵ���߼�DAO
	 * 
	 * @param ig599DAO ���̱���ҵ���߼�DAO
	 */
	public void setIg599DAO(IG599DAO ig599DAO) {
		this.ig599DAO = ig599DAO;
	}

	/**
	 * ���ܣ������������̱���
	 * @param ���̱���List
	 * @return ���̱���List
	 * @throws BLException
	 */
	public List<IG599Info> saveOrUpdIG599Infos(List<IG599Info> prInfoList)
			throws BLException {
		List<IG599Info> newList = new ArrayList<IG599Info>();
		String pidaccess = null;
		for(IG599Info pi : prInfoList){
			pidaccess = pi.getPidaccess();
			IG599TB processInfo = (IG599TB)ig599DAO.save(pi);
			processInfo.setPidaccess(pidaccess);
			newList.add(processInfo);
		}
		
		return newList;
		//ig599DAO.saveOrUpdateAll(prInfoList);
	}

	/**
	 * ���ܣ��������̱���
	 * @param IG599Info ���̱���
	 * @return ProcessInfo ���̱���
	 */
	public IG599Info saveIG599Info(IG599Info prInfo)
			throws BLException {
		return ig599DAO.save(prInfo);
	}

	/**
	 * ���ܣ��������̱�������ֵ
	 * @param ���̱�������ֵ����
	 * @throws BLException
	 */
	public void registIG599Infos(List<IG599Info> ig599InfoList) throws BLException{
		ig599DAO.saveOrUpdateAll(ig599InfoList);
	}
	
	/**
	 * ���ܣ��������̱�������ֵ
	 * @param ���̱�������ֵ
	 * @throws BLException
	 */
	public void updateIG599Info(IG599Info pi) throws BLException{
		ig599DAO.save(pi);
	}
	
	/**
	 * ���ܣ��������̱�������ֵ���������£�
	 * @param ���̱�������ֵ����
	 * @throws BLException
	 */
	public void updateIG599Infos(List<IG599Info> ig599InfoList) throws BLException{
		ig599DAO.saveOrUpdateAll(ig599InfoList);
	}
	
	/**
	 * ���ܣ��������̼�¼ID��ȡ���̱�������ֵ��Ϣ����
	 * @param ����ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchIG599InfosByKey(Integer processId){
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(processId);
		List<IG599Info> prInfoList = ig599DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	/**
	 * ���ݲ�ѯ������ȡ���̱�������ֵ��Ϣ����
	 * @param ���̱�������ֵ��Ϣ����
	 * @throws BLException
	 */
	public List<IG599Info> searchIG599InfosByCond(IG599SearchCond cond){
		List<IG599Info> prInfoList = ig599DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	
	/**
	 * ���ܣ��������̱���ID��ȡ���̱�������ֵ��Ϣ����
	 * @param piid ���̱���ID
	 * @throws BLException 
	 */
	public IG599Info searchIG599InfoByPiid(Integer piid) throws BLException{
		return checkExistProcessInfo(piid);
	}
	
	/**
	 * ���ܣ���ȡ����ʵ��
	 * 
	 * @return ProcessInfoTB
	 */
	
	public IG599TB getIG599TBInstance(){
		return new IG599TB();
	}
	
	/**
	 * ���ܣ����̱�������ֵ��Ϣ���ڼ��
	 * 
	 * @param piid ���̱���ID
	 * @return ���̱�������ֵ��Ϣ
	 * @throws BLException 
	 */
	private IG599Info checkExistProcessInfo(Integer piid) throws BLException{
		IG599Info info = ig599DAO.findByPK(piid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̱�������ֵ����");
		}
		
		return info;
	}
	
	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchIG599InfoForClose(Integer prid, String pdid, String userid){
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);
		cond.setPdid(pdid);
		cond.setUserid(userid);
		List<IG599Info> prInfoList = ig599DAO.searchIG599InfoForClose(cond);
		return prInfoList;
	}
	
	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchIG599InfoForSee(Integer prid, String pdid, String userid){
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPrid(prid);
		cond.setPdid(pdid);
		cond.setUserid(userid);
		List<IG599Info> prInfoList = ig599DAO.searchIG599InfoForSee(cond);
		return prInfoList;
	}
	
	
	/**
	 * ���ܣ���ѯ��ǰ�����ˮ��
	 * @param prserialnum ��ˮ��
	 * @param label ����
	 * @return �����ˮ��
	 */
	public String searchMaxSerialnum(String serialnum, String label) {
		String strSerialnum = ig599DAO.searchMaxSerialnum(serialnum, label);
		return strSerialnum;
	}
}
