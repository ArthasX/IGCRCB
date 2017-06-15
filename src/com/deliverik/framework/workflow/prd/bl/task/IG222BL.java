/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;

/**
 * ���̲����߶���ҵ���߼�
 *
 */
public interface IG222BL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG222InfoSearchCount(IG222SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param ppdid ���̲�����ID
	 * @return ���̲�������Ϣ
	 */
	public IG222Info searchIG222InfoByKey(String ppdid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG222Info> searchIG222InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param IG222 ��¼����
	 * @return ���̲�������Ϣ
	 */
	public IG222Info registIG222Info(IG222Info processParticipantDef) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param ppdid ���̲�����ID
	 * @return ���̲����߶�����Ϣ
	 */
	public IG222Info deleteIG222Info(String ppdid) throws BLException;
	
	/**
	 * ɾ������
	 * 
	 * @param IG222 ���̲�����
	 * @return
	 */
	public void deleteIG222Info(IG222Info processParticipantDef) throws BLException;

	/**
	 * �������
	 * 
	 * @param IG222 �������
	 * @return ���̲�������Ϣ
	 */
	public IG222Info updateIG222Info(IG222Info processParticipantDef) throws BLException;
	
	/**
	 * ��ȡָ���û����еķ������̵Ľ�ɫ
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid, String pdid);
	
	/**
	 * ��ȡ�������̵Ľ�ɫ(��ά�ƻ���)
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	public List<LabelValueBean> searchInitProcessParticipantRoleAll(String pdid);
	
		/**
	 * PPDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PPDID����ֵ
	 */
	public String getPpdidSequenceNextValue(String psdid);
	
	/**
	 * �����߿��Ӱ�ť��ѯ
	 * 
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ���Ӱ�ť�б�
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid);
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ����ͨȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid);
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ��ȱʡȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG222Info> searchIG222InfoRun(IG222SearchCond cond);
	
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

}
