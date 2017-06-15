package com.deliverik.framework.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCond;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * �ʲ�ģ������ҵ���߼�
 * </p>
 */
public interface IG225BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�ģ��������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�ģ��������Ϣ����ʵ��
	 */

	public IG225TB getIG225TBInstance();

	/**
	 * �����ʲ�ģ����������ȡ���ʲ�ģ��������Ϣ
	 * 
	 * @param cid �ʲ�ģ����������
	 * @return �ʲ�ģ��������Ϣ
	 */
	public IG225Info searchIG225InfoByKey(Integer cid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ����
	 */
	public int getIG225InfoSearchCount(IG225SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<IG225Info> searchIG225Info(IG225SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<IG225Info> searchIG225Info(IG225SearchCond cond, int start, int count);

	/**
	 * �����ʲ�ģ��IDȡ��������̳����Ե�������Ϣ�б�
	 * 
	 * @param eid ģ������ID
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<IG225Info> searchIG225InfoByEid(Integer eid) throws BLException;
	
	/**
	 * �½��ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration �ʲ�ģ��������Ϣ
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public IG225Info registIG225Info(IG225Info ig225Info) throws BLException;

	/**
	 * ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param ig225Info �ʲ�ģ��������Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG225Info(IG225Info ig225Info) throws BLException;

	/**
	 * �����ʲ�ģ����������ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cid �ʲ�ģ��������Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteIG225InfoByKey(Integer cid) throws BLException;

	/**
	 * ����ʲ�ģ��������Ϣ����
	 * 
	 * @param ig225Info �ʲ�ģ��������Ϣ
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public IG225Info updateIG225Info(IG225Info ig225Info) throws BLException;

	/**
	 * ȡ�ø��ʲ�ģ�͵�ģ��������Ϣ��ƽ̨������
	 * 
	 * @param list �ʲ�ģ�ͼ���
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ
	 *            1:��ʾ����
	 *            0:������ʾ����
	 *            null:ȫ������
	 * @return ���ʲ�ģ�͵�ģ��������Ϣ
	 */
	public Map<String,List<IG225Info>> searchIG225Info(List<IG117Info> list,Integer cseq);
	
}
