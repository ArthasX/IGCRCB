/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.kgm.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.condition.AttachmentSearchCondImpl;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeDAO;
import com.deliverik.infogovernor.kgm.model.dao.KnowledgeVWDAO;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTB;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTBPK;



 /**
  * ����:֪ʶ����Ϣҵ���߼�ʵ��
  * ����������֪ʶ����Ϣҵ���߼�ʵ��
  * ������¼��wangxiaoqiang 2010/12/07
  * �޸ļ�¼��
  */
public class KnowledgeBLImpl extends BaseBLImpl implements KnowledgeBL {
	
	/** ֪ʶ����ϢDAO */
	protected KnowledgeDAO knowledgeDAO;
	
	/** ���°�֪ʶ��ϢDAO */
	protected KnowledgeVWDAO knowledgeVWDAO;
	
	/**����BL*/
	protected AttachmentBL attachmentBL;

	/**
	 * ���°�֪ʶ��ϢDAO
	 * @param knowledgeVWDAO ���°�֪ʶ��ϢDAO
	 */
	public void setKnowledgeVWDAO(KnowledgeVWDAO knowledgeVWDAO) {
		this.knowledgeVWDAO = knowledgeVWDAO;
	}

	/**
	 * ֪ʶ����ϢDAO
	 * 
	 * @param knowledgeDAO ֪ʶ����ϢDAO
	 */
	public void setKnowledgeDAO(KnowledgeDAO knowledgeDAO) {
		this.knowledgeDAO = knowledgeDAO;
	}

	/**
	 * ����BL�趨
	 * @param attachmentBL����BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * �־û�����
	 * 
	 * @param Knowledgeʵ����
	 * @return Knowledgeʵ����
	 */
	public Knowledge registKnowledge(Knowledge knowledge) throws BLException {
		KnowledgeTB knowledgeTB = (KnowledgeTB)SerializationUtils.clone(knowledge);
		if(StringUtils.isEmpty(knowledgeTB.getKnserial())){
			knowledgeTB.setKnserial(this.getKnserial());
		}
		return knowledgeDAO.save(knowledgeTB);
	}

	

	/**
	 * ������������
	 * 
	 * @param id ����
	 * @return �������
	 */
	public Knowledge searchKnowledgeByPK(KnowledgeTBPK pk) throws BLException {
		Knowledge knowledge = knowledgeDAO.findByPK(pk);
		
		AttachmentSearchCondImpl cond = new AttachmentSearchCondImpl();
		cond.setAttkey(knowledge.getKnattkey());
		
		List<Attachment> attachmentList = new ArrayList<Attachment>();
		if(knowledge.getKnattkey()!=null &&(!"".equals(knowledge.getKnattkey()))){
			attachmentList = attachmentBL.searchAttachmentsByAttkey(knowledge.getKnattkey());
			knowledge.setAttachmentList(attachmentList);
		}
		return knowledge;
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<Knowledge> searchAllKnowledge() throws BLException {
		return knowledgeDAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(KnowledgeSearchCond cond) throws BLException {
		return knowledgeDAO.getSearchCount(cond);
	}
	/**
	 * ֪ʶ���к�ȡ��
	 * 
	 * @param cond ��������
	 * @return ֪ʶ���к�
	 */
	public String getKnserial() throws BLException {
		String knserial = knowledgeDAO.getKnserial();
		if(knserial ==null){
			knserial = "K000001";
		}else{
			int num = Integer.parseInt(knserial.substring(1,knserial.length()));
			knserial = "K" + StringUtils.leftPad(String.valueOf(num+1), 6 ,"0");
		}
		return knserial;
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Knowledge> searchKnowledgeByCond(KnowledgeSearchCond cond,
			int start, int count) throws BLException {
		return knowledgeDAO.findByCond(cond, start, count);
	}

	/**
	 * ɾ������
	 * 
	 * @param Knowledgeʵ����
	 */
	public void deleteKnowledge(Knowledge knowledge) throws BLException {
		knowledgeDAO.delete(knowledge);
	}

	/**
	 * �������
	 * 
	 * @param knowledge�������
	 * @return ֪ʶ����Ϣ
	 */
	public Knowledge updateKnowledge(Knowledge knowledge)
			throws BLException {
		KnowledgeTBPK pk = new KnowledgeTBPK(knowledge.getKnid(),knowledge.getKnversion());
		Knowledge kl= checkExistKnowledge(pk);
		KnowledgeTB klTB = (KnowledgeTB)knowledge;
		if(StringUtils.isNotEmpty(kl.getKnserial())){
			klTB.setKnserial(kl.getKnserial());
		}else{
			klTB.setKnserial(this.getKnserial());
		}
		return knowledgeDAO.save(klTB);
	}
	
	/**
	 * ֪ʶ����Ϣ���ڼ��
	 * 
	 * @param ֪ʶ���̹�����ϢID
	 * @return ֪ʶ���̹�����Ϣ
	 * @throws BLException
	 */
	protected Knowledge checkExistKnowledge(KnowledgeTBPK pk)
			throws BLException {
		Knowledge info = knowledgeDAO.findByPK(pk);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "֪ʶ�������Ϣ");
		}
		return info;
	}
	
	/**
	 * ��������id
	 * 
	 * @return ���id��
	 * @throws BLException
	 */
	public Integer getMaxknid() throws BLException {
		Integer knid = knowledgeDAO.getMaxgKnid();
		return knid;
	}
	
	/**
	 * ��������id
	 * 
	 * @return ���id��
	 * @throws BLException
	 */
	public Integer getMaxVersion(Integer knid) throws BLException {
		Integer knversion = knowledgeDAO.getMaxVersion(knid);
		return knversion;
	}
	
	/**
	 * ��������id
	 * 
	 * @return ���id��
	 * @throws BLException
	 */
	public int getSearchNotCheckCount(KnowledgeSearchCond knowledgeSearchCond) throws BLException {
		int knversion = knowledgeDAO.getSearchNotCheckCount(knowledgeSearchCond);
		return knversion;
	}

	/**
	 * ֪ʶ��ʷ�汾ȡ��
	 * @param knowledgeSearchCond
	 * @return
	 * @throws BLException
	 */
	public List<Knowledge> getKnowledgeHistory(KnowledgeSearchCond knowledgeSearchCond) throws BLException {
		
		List<Knowledge> knowledgeList_pro = knowledgeDAO.findByCond_History(knowledgeSearchCond, 0, 0);
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();
		for(int i=0;i<knowledgeList_pro.size();i++){
			List<Attachment> attachmentList = new ArrayList<Attachment>();
			Knowledge knowledge = knowledgeList_pro.get(i);
			if(StringUtils.isNotEmpty(knowledgeList_pro.get(i).getKnattkey())){
				attachmentList = attachmentBL.searchAttachmentsByAttkey(knowledge.getKnattkey());
				knowledge.setAttachmentList(attachmentList);
			}
			knowledgeList.add(knowledge);
		}
		return knowledgeList;
	}
	
	/**
	 * ����֪ʶid������ǰ��Ч֪ʶ����
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public Knowledge searchKnowledgeByByKnid(KnowledgeSearchCond cond) throws BLException {
		return knowledgeDAO.findByKnid(cond);
	}
}

