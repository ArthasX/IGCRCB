/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/**
 * <p>
 * ���̱�����Ϣҵ���߼�
 * </p>
 */

public interface IG599BL extends BaseBL {


	/**
	 * �������̱�������ֵ
	 * @param ���̱�������ֵ����
	 * @throws BLException
	 */
	public void registIG599Infos(List<IG599Info> ig599InfoList) throws BLException;
	
	/**
	 * �������̱�������ֵ
	 * @param ���̱�������ֵ
	 * @throws BLException
	 */
	public void updateIG599Info(IG599Info pi) throws BLException;
	
	/**
	 * �������̱�������ֵ
	 * @param ���̱�������ֵ����
	 * @throws BLException
	 */
	public void updateIG599Infos(List<IG599Info> ig599InfoList) throws BLException;

	/**
	 * �������̼�¼ID��ȡ���̱�������ֵ��Ϣ����
	 * @param ���̱�������ֵ��Ϣ����
	 * @throws BLException
	 */
	public List<IG599Info> searchIG599InfosByKey(Integer processId);
	
	/**
	 * �������̱���ID��ȡ���̱�������ֵ��Ϣ����
	 * @param piid ���̱���ID
	 * @throws BLException 
	 */
	public IG599Info searchIG599InfoByPiid(Integer piid) throws BLException;
	
	/**
	 * ��ȡ����ʵ��
	 * 
	 * @return ProcessInfoTB
	 * @throws BLException
	 */
	
	public IG599TB getIG599TBInstance();
	
	/**
	 * �������̱�������ֵ��ƽ̨������
	 * @param ���̱�������ֵ����
	 * @throws BLException
	 */
	public List<IG599Info> saveOrUpdIG599Infos(List<IG599Info> ig599InfoList) throws BLException;
	
	/**
	 * �������̱�������ֵ��ƽ̨������
	 * @param ���̱�������ֵ����
	 * @throws BLException
	 */
	public IG599Info saveIG599Info(IG599Info ig599Info) throws BLException;
	
	/**
	 * ���ݲ�ѯ������ȡ���̱�������ֵ��Ϣ����
	 * @param ���̱�������ֵ��Ϣ����
	 * @throws BLException
	 */
	public List<IG599Info> searchIG599InfosByCond(IG599SearchCond cond);
	
	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchIG599InfoForClose(Integer prid, String pdid, String userid);
	
	/**
	 * �Զ������̹ر�״̬������Ϣ����ȡ��
	 * ��ȱʡ�����Ͷ��������������ͨģʽ����ɫ���ˣ�OAģʽ���û�ID���ˣ�
	 * @param ����ID
	 * @param ���̶���ID
	 * @param �û�ID
	 * @return ���̱�������ֵ��Ϣ����
	 */
	public List<IG599Info> searchIG599InfoForSee(Integer prid, String pdid, String userid);
	
	/**
	 * ���ܣ���ѯ��ǰ�����ˮ��
	 * @param prserialnum ��ˮ��
	 * @param label ����
	 * @return �����ˮ��
	 */
	public String searchMaxSerialnum(String serialnum, String label);
}
