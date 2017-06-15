/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;

/**
 * ����:֪ʶ���̹�����Ϣҵ���߼��ӿ�
 * ����������֪ʶ���̹�����Ϣҵ���߼��ӿ�
 * ������¼������ 2010/12/07
 * �޸ļ�¼��
 */
public interface KnowledgeProcessBL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond��������
	 * @return ���������������
	 */
	public int getSearchCount(KnowledgeProcessSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param kpid֪ʶ���̹�����ϢID
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public KnowledgeProcess searchKnowledgeProcessByKey(Integer kpid)
			throws BLException;

	/**
	 * ȫ����������
	 * 
	 * @return ȫ��֪ʶ���̹�����Ϣ
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessAll();

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeProcess(KnowledgeProcessSearchCond cond,
			int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param knowledgeProcess��¼����
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public KnowledgeProcess registKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException;
	
	/**
	 * ���̴����в鿴��֪ʶ��������
	 * 
	 * @param ����ID
	 * @param ֪ʶID
	 * @param ֪ʶ�汾
	 */
	public void registKnowledgeProcess(Integer prid, Integer knid, Integer knversion) throws BLException;
	
	/**
	 * ���񹤵������в鿴��֪ʶ��������
	 * 
	 * @param ���񹤵�ID
	 * @param ֪ʶID
	 * @param ֪ʶ�汾
	 */
	public void registKnowledgeService(Integer sfid, Integer knid, Integer knversion) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param kpid֪ʶ���̹�����ϢID
	 */
	public void deleteKnowledgeProcess(Integer kpid) throws BLException;

	/**
	 * �������
	 * 
	 * @param knowledgeProcess�������
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public KnowledgeProcess updateKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException;
	
	/**
	 * ���̹���֪ʶ����
	 * 
	 * @param prid����ID
	 * @param knidList֪ʶID����
	 * @param knversionList֪ʶ�汾����
	 */
	public void processRelateKnowledge(Integer prid, List<Integer> knidList, List<Integer> knversionList) throws BLException;
	
	/**
	 * ֪ʶ�������̴���
	 * 
	 * @param knid֪ʶID
	 * @param pridList����ID����
	 */
	public void knowledgeRelateProcess(Integer knid, Integer knversion, List<Integer> pridList) throws BLException;
	
	/**
	 * ���񹤵�����֪ʶ����
	 * 
	 * @param sfid���񹤵�ID
	 * @param knidList֪ʶID����
	 * @param knversionList֪ʶ�汾����
	 */
	public void serviceRelateKnowledge(Integer sfid, List<Integer> knidList, List<Integer> knversionList) throws BLException;
	
	/**
	 * ֪ʶ�������񹤵�����
	 * 
	 * @param knid֪ʶID
	 * @param knversion֪ʶ�汾
	 * @param sfidList���񹤵�ID����
	 */
	public void knowledgeRelateService(Integer knid, Integer knversion, List<Integer> pridList) throws BLException;
	
	/**
	 * ָ�����̹���֪ʶ���ϲ�ѯ����
	 * 
	 * @param prid����ID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByPrid(Integer prid);
	
	/**
	 * ָ��֪ʶ�������̼��ϲ�ѯ����
	 * 
	 * @param knid֪ʶID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchProcessByKnid(Integer knid);
	
	/**
	 * ָ�����񹤵�����֪ʶ���ϲ�ѯ����
	 * 
	 * @param sfid���񹤵�ID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeServiceBySfid(Integer sfid);
	
	/**
	 * ָ��֪ʶ�������񹤵����ϲ�ѯ����
	 * 
	 * @param knid֪ʶID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchServiceByKnid(Integer knid);
	
	/**
	 * ֪ʶ���������̻���񹤵���ѯ����
	 * @param knid
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByKnid(Integer knid);
	
}
