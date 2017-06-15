package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ������Ϣҵ���߼�
 * 
 */
public interface IG601BL extends BaseBL{

	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param eiid ������Ϣ����
	 * @return ������Ϣ
	 */
	public IG601Info searchIG601InfoByKey(Integer eiid);

	/**
	 * ���ݼ�������ȡ�û�����Ϣ�������
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�������
	 */
	public int getIG601InfoSearchCount(IG601SearchCond cond);

	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ��������б�
	 */
	public List<IG601Info> searchIG601Info(IG601SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	public List<IG601Info> searchIG601Info(IG601SearchCond cond, int start, int count);
	
	/**
	 * �½�������Ϣ����
	 * 
	 * @param ig601Info ������Ϣ
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer registIG601Info(IG601Info ig601Info) throws BLException;

	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param ig601Info ɾ���Ļ�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601Info(IG601Info ig601Info) throws BLException;

	/**
	 * ���ݻ�������ɾ��������Ϣ����
	 * 
	 * @param eiid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601InfoByKey(Integer eiid) throws BLException;

	/**
	 * ���������Ϣ����
	 * 
	 * @param ig601Info ���ǰ�Ļ�����Ϣ
	 * @throws BLException
	 */
	public void updateIG601Info(IG601Info ig601Info) throws BLException;


}
