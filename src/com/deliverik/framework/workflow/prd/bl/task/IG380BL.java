/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * <p>
 * ���̶���ҵ���߼�
 * </p>
 */

public interface IG380BL extends BaseBL {
	
	/**
	 * ��ȡ���̶���ʵ��
	 * 
	 * @return IG380TB
	 * @throws BLException
	 */
	
	public IG380TB getIG380TBInstance();

	/**
	 * ��������ģ��ID��ȡ���̶��弯��
	 * @param processTemplateId ����ģ��ID
	 * @return  List<ProcessDefinition>
	 */
	
	public List<IG380Info> searchIG380InfoByPtid(Integer processTemplateId);
	
	/**
	 * �������̶���ID��ȡ���̶���
	 * @param pdid ���̶���ID
	 * @return ProcessTemplate
	 * @throws BLException
	 */
	public IG380Info searchIG380InfoByKey(String pdid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getIG380InfoSearchCount(IG380SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���������¶�����Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getIG380InfoSearchLastCount(IG380SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ��������ʷ������Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getIG380InfoSearchHistoryCount(IG380SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�����̶���������Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchLastIG380Info(IG380SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ�����̶�����ʷ��Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchHistoryIG380Info(IG380SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchIG380Info(IG380SearchCond cond, int start, int count);
	
	/**
	 * ���̶�����Ϣ
	 * 
	 * @param ig380Info ���̶�����Ϣ
	 * @return ���̶���
	 */
	public IG380Info registIG380Info(IG380Info ig380Info) throws BLException;

	/**
	 * ɾ�����̶�����Ϣ
	 * 
	 * @param pdid ���̶�������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380InfoByKey(String pdid) throws BLException;
	
	/**
	 * ɾ�����̶�����Ϣ
	 * 
	 * @param ig380Info ���̶�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG380Info(IG380Info ig380Info) throws BLException;

	/**
	 * �������̶�����Ϣ
	 * 
	 * @param ig380Info ���̶�����Ϣ
	 * @return ���̶���
	 * @throws BLException
	 */
	public IG380Info updateIG380Info(IG380Info ig380Info) throws BLException;
	
	/**
	 * ���̶��岻���ڼ��
	 * 
	 * @param ptid ����ģ��ID
	 * @param pdname ���̶�������
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG380Info(Integer ptid, String pdname) throws BLException;
	
	/**
	 * �����û�ID��ȡ���û���������̶�����Ϣ����б�
	 * @param userid �û�ID
	 * @param pdstatus �Զ�������״̬
	 * @return ���̶�����Ϣ����б�
	 */
	public List<IG380Info> findSelfDefinitionByUserId(String userid, String pdstatus);
	
	/**
	 * �����û�ID��ȡ���û���������̶�����Ϣ����б�(��ά�ƻ���)
	 * @return ���̶�����Ϣ����б�
	 */
	public List<IG380Info> findSelfDefinitionAll();
	
	/**
	 * �����û�ID��ȡ���û����̶�����Ϣ����б�
	 * @param userid �û�ID
	 * @return ������Ϣ����б�
	 */
	public List<IG380Info> findSelfDefinitionByUserIdCom(String userid, Integer ptid
			, String pdstatus);
	
	/**
	 * ���̶�������ֵȡ��
	 * @param firstsite ������λ��ʶ
	 * @param pdsequence ��������
	 * @return PDID����ֵ
	 */
	public String getPdidNextValue(String firstsite,String pdsequence);
	
	/**
	 * ���̶������汾����
	 * 
	 * @param pdid ���̶���ID
	 */
	public String upgradeProcessDefVersion(String pdid) throws BLException;
	
	/**
	 * ���̶��帴�ƴ���
	 * 
	 * @param pdid ���̶���ID
	 * @param pdsequence ���ж���
	 */
	public String copyProcessDefVersion(String pdid,String pdsequence) throws BLException;
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 * @throws BLException
	 */
	public StringBuffer exportXML(String pdid) throws BLException;
	
	/**
	 * XML�ű����봦��
	 *
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(Element element) throws BLException;
	
	/**
     * ���ݼ�������ȡ�����̶��弰״̬�����߿ɷ����������͵���Ϣ
     * 
     * @param cond ���̶����������
     * @return ���̶�����Ϣ�б�
     */
    public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond);
    
    /**
     * ���ݼ�������ȡ��ȱʡȨ�޵���ط�����Զ����������͵���Ϣ
     * 
     * @param cond ���̶����������
     * @return ���̶�����Ϣ�б�
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond);
    
	/**
	 * ��������ͼXML
	 * @param e ����ͼ�ڵ�
	 * @param sbf XML�ַ���
	 */
	public void display(Element e, StringBuffer sbf);
}
