/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.model.KnowledgeProcess;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCond;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeProcessSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeProcessDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeProcessTB;

/**
 * ����:֪ʶ���̹�����Ϣҵ���߼�ʵ��
 * ����������֪ʶ���̹�����Ϣҵ���߼�ʵ��
 * ������¼������ 2010/12/07
 * �޸ļ�¼��
 */
public class KnowledgeProcessBLImpl extends BaseBLImpl implements
		KnowledgeProcessBL {

	/** ֪ʶ���̹�����ϢDAO */
	protected KnowledgeProcessDAO knowledgeProcessDAO;

	/**
	 * ֪ʶ���̹�����ϢDAO
	 * 
	 * @param knowledgeProcessDAO ֪ʶ���̹�����ϢDAO
	 */
	public void setKnowledgeProcessDAO(KnowledgeProcessDAO knowledgeProcessDAO) {
		this.knowledgeProcessDAO = knowledgeProcessDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond��������
	 * @return ���������������
	 */
	public int getSearchCount(KnowledgeProcessSearchCond cond) {
		return knowledgeProcessDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param kpid֪ʶ���̹�����ϢID
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public KnowledgeProcess searchKnowledgeProcessByKey(Integer kpid)
			throws BLException {
		return checkExistKnowledgeProcess(kpid);
	}

	/**
	 * ȫ����������
	 * 
	 * @return ȫ��֪ʶ���̹�����Ϣ
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessAll() {
		return knowledgeProcessDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeProcess(KnowledgeProcessSearchCond cond,
			int start, int count) {
		return knowledgeProcessDAO.findByCond(cond, start, count);
	}

	/**
	 * ��¼����
	 * 
	 * @param knowledgeProcess��¼����
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public KnowledgeProcess registKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException {
		return knowledgeProcessDAO.save(knowledgeProcess);
	}

	/**
	 * ɾ������
	 * 
	 * @param kpid֪ʶ���̹�����ϢID
	 */
	public void deleteKnowledgeProcess(Integer kpid) throws BLException {

		KnowledgeProcess knowledgeProcess = checkExistKnowledgeProcess(kpid);

		knowledgeProcessDAO.delete(knowledgeProcess);
	}

	/**
	 * �������
	 * 
	 * @param knowledgeProcess�������
	 * @return ֪ʶ���̹�����Ϣ
	 */
	public KnowledgeProcess updateKnowledgeProcess(KnowledgeProcess knowledgeProcess)
			throws BLException {
		checkExistKnowledgeProcess(knowledgeProcess.getKpid());
		return knowledgeProcessDAO.save(knowledgeProcess);
	}

	/**
	 * ֪ʶ���̹�����Ϣ���ڼ��
	 * 
	 * @param ֪ʶ���̹�����ϢID
	 * @return ֪ʶ���̹�����Ϣ
	 * @throws BLException
	 */
	protected KnowledgeProcess checkExistKnowledgeProcess(Integer kpid)
			throws BLException {
		KnowledgeProcess info = knowledgeProcessDAO.findByPK(kpid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "֪ʶ���̹�������");
		}
		return info;
	}
	
	/**
	 * ���̹���֪ʶ����
	 * 
	 * @param prid����ID
	 * @param knidList֪ʶID����
	 * @param knversionList֪ʶ�汾����
	 */
	public void processRelateKnowledge(Integer prid, List<Integer> knidList, List<Integer> knversionList) throws BLException {
		this.registKnowledgeRelation(prid, null, knidList, knversionList, IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);
	}
	
	/**
	 * ֪ʶ�������̴���
	 * 
	 * @param knid֪ʶID
	 * @param pridList����ID����
	 */
	public void knowledgeRelateProcess(Integer knid, Integer knversion, List<Integer> pridList) throws BLException {
		this.registKnowledgeRelation(knid, knversion, pridList, null, IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS);
	}
	
	/**
	 * ���񹤵�����֪ʶ����
	 * 
	 * @param sfid���񹤵�ID
	 * @param knidList֪ʶID����
	 * @param knversionList֪ʶ�汾����
	 */
	public void serviceRelateKnowledge(Integer sfid, List<Integer> knidList, List<Integer> knversionList) throws BLException {
		this.registKnowledgeRelation(sfid, null, knidList, knversionList, IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);
	}
	
	/**
	 * ֪ʶ�������񹤵�����
	 * 
	 * @param knid֪ʶID
	 * @param knversion֪ʶ�汾
	 * @param sfidList���񹤵�ID����
	 */
	public void knowledgeRelateService(Integer knid, Integer knversion, List<Integer> pridList) throws BLException {
		this.registKnowledgeRelation(knid, knversion, pridList, null, IGKGMCONSTANTS.KNOWLEDGE_RELATE_SERVICE);
	}
	
	/**
	 * ֪ʶ��������
	 * 
	 * @param id֪ʶ������ID����񹤵�ID
	 * @param knversion֪ʶ�汾
	 * @param idList֪ʶ������ID���ϻ���񹤵�ID����
	 * @param knversionList֪ʶ�汾����
	 */
	protected void registKnowledgeRelation(Integer id, Integer knversion, List<Integer> idList,
			List<Integer> knversionList, String connecttype) throws BLException {
		if(idList != null) {
			int i = 0;
			for(Integer key : idList){
				if(key != null && key > 0) {
					KnowledgeProcessTB kpTB = new KnowledgeProcessTB();
					if(IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS.equals(connecttype)) {//֪ʶ��������
						kpTB.setKnid(id);
						kpTB.setPrid(key);
						kpTB.setKnversion(knversion);
					} else if(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE.equals(connecttype)) {//���̹���֪ʶ
						kpTB.setPrid(id);
						kpTB.setKnid(key);
						kpTB.setKnversion(knversionList.get(i++));
						kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_YES);//�Ƿ���Ч��ʶ
					} else if(IGKGMCONSTANTS.KNOWLEDGE_RELATE_SERVICE.equals(connecttype)) {//֪ʶ�������񹤵�
						kpTB.setKnid(id);
						kpTB.setSfid(key);
						kpTB.setKnversion(knversion);
					} else if(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE.equals(connecttype)) {//���񹤵�����֪ʶ
						kpTB.setSfid(id);
						kpTB.setKnid(key);
						kpTB.setKnversion(knversionList.get(i++));
						kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_YES);//�Ƿ���Ч��ʶ
					}
					kpTB.setConnecttype(connecttype);//��������
					this.registKnowledgeProcess(kpTB);
				}
			}
		}
	}
	
	/**
	 * ���̴����в鿴��֪ʶ��������
	 * 
	 * @param ����ID
	 * @param ֪ʶID
	 * @param ֪ʶ�汾
	 */
	public void registKnowledgeProcess(Integer prid, Integer knid, Integer knversion) throws BLException {
		List<KnowledgeProcess> kpList = checkExistKnowledgeProcessByKpEffect(prid, knid, knversion);
		if(kpList.isEmpty()) {
			KnowledgeProcessTB kpTB = new KnowledgeProcessTB();
			kpTB.setPrid(prid);//����ID
			kpTB.setKnid(knid);//֪ʶID
			kpTB.setKnversion(knversion);//֪ʶ�汾
			kpTB.setConnecttype(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);//��������
			kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_NO);//�Ƿ���Ч��ʶ
			this.registKnowledgeProcess(kpTB);
		} else if(kpList.size() > 1){
			throw new BLException("IGCO10000.E004", "֪ʶ���̹�������");
		} else {
			KnowledgeProcessTB kpTB = (KnowledgeProcessTB)SerializationUtils.clone(kpList.get(0));
			kpTB.setKnversion(knversion);
			this.updateKnowledgeProcess(kpTB);
		}
	}
	
	/**
	 * ���񹤵������в鿴��֪ʶ��������
	 * 
	 * @param ���񹤵�ID
	 * @param ֪ʶID
	 * @param ֪ʶ�汾
	 */
	public void registKnowledgeService(Integer sfid, Integer knid, Integer knversion) throws BLException {
		List<KnowledgeProcess> ksList = checkExistKnowledgeServiceByKpEffect(sfid, knid, knversion);
		if(ksList.isEmpty()) {
			KnowledgeProcessTB kpTB = new KnowledgeProcessTB();
			kpTB.setSfid(sfid);//���񹤵�ID
			kpTB.setKnid(knid);//֪ʶID
			kpTB.setKnversion(knversion);//֪ʶ�汾
			kpTB.setConnecttype(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);//��������
			kpTB.setKpEffect(IGKGMCONSTANTS.KPEFFECT_NO);//�Ƿ���Ч��ʶ
			this.registKnowledgeProcess(kpTB);
		} else if(ksList.size() > 1){
			throw new BLException("IGCO10000.E004", "֪ʶ���񹤵���������");
		} else {
			KnowledgeProcessTB kpTB = (KnowledgeProcessTB)SerializationUtils.clone(ksList.get(0));
			kpTB.setKnversion(knversion);
			this.updateKnowledgeProcess(kpTB);
		}
	}
	
	/**
	 * ���̴����в鿴��֪ʶ������Ϣ���ڼ��
	 * 
	 * @param ����ID
	 * @param ֪ʶID
	 * @param ֪ʶ�汾
	 * @return ������Ϣ����
	 */
	protected List<KnowledgeProcess> checkExistKnowledgeProcessByKpEffect(Integer prid, Integer knid, Integer knversion) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setPrid(prid);//����ID
		cond.setKnid(knid);//֪ʶID
		cond.setKnversion(knversion);//֪ʶ�汾
		cond.setConnecttype(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);//��������
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���񹤵������в鿴��֪ʶ������Ϣ���ڼ��
	 * 
	 * @param ���񹤵�ID
	 * @param ֪ʶID
	 * @param ֪ʶ�汾
	 * @return ������Ϣ
	 */
	protected List<KnowledgeProcess> checkExistKnowledgeServiceByKpEffect(Integer sfid, Integer knid, Integer knversion) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setSfid(sfid);//���񹤵�ID
		cond.setKnid(knid);//֪ʶID
		cond.setKnversion(knversion);//֪ʶ�汾
		cond.setConnecttype(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);//��������
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ָ�����̹���֪ʶ���ϲ�ѯ����
	 * 
	 * @param prid����ID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByPrid(Integer prid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.PROCESS_RELATE_KNOWLEDGE);//���̹���֪ʶ
		cond.setPrid(prid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ָ��֪ʶ�������̼��ϲ�ѯ����
	 * 
	 * @param knid֪ʶID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchProcessByKnid(Integer knid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS);//֪ʶ��������
		cond.setKnid(knid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ָ�����񹤵�����֪ʶ���ϲ�ѯ����
	 * 
	 * @param sfid���񹤵�ID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeServiceBySfid(Integer sfid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.SERVICE_RELATE_KNOWLEDGE);//���񹤵�����֪ʶ
		cond.setSfid(sfid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ָ��֪ʶ�������񹤵����ϲ�ѯ����
	 * 
	 * @param knid֪ʶID
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchServiceByKnid(Integer knid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setConnecttype(IGKGMCONSTANTS.KNOWLEDGE_RELATE_SERVICE);//֪ʶ�������񹤵�
		cond.setKnid(knid);
		return knowledgeProcessDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ֪ʶ���������̻���񹤵���ѯ����
	 * @param knid
	 * @return ��������б�
	 */
	public List<KnowledgeProcess> searchKnowledgeProcessByKnid(Integer knid) {
		KnowledgeProcessSearchCondImpl cond = new KnowledgeProcessSearchCondImpl();
		cond.setKnid(knid);
		cond.setConnecttype(IGKGMCONSTANTS.KNOWLEDGE_RELATE_PROCESS);
		cond.setKpEffect(IGKGMCONSTANTS.KPEFFECT_YES);
		return knowledgeProcessDAO.findByCond_KnowledgeProcess(cond, 0, 0);
	}
	
}
