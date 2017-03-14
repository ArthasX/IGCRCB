/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.KnowLedgeInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;

 /**
  * ����:֪ʶ���ѯ��BL�ӿ�
  * ����������֪ʶ���ѯ��BL�ӿ�
  * ������¼��wangxiaoqiang 2010/12/07
  * �޸ļ�¼��
  */
public interface KnowLedgeInfoBL extends BaseBL{
  
   /**
    * ȫ������
    * @return ���������
    */
 public List<KnowLedgeInfo> searchAllKnowLedgeInfo() throws BLException;

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(KnowledgeSearchCond cond) throws BLException;

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<KnowLedgeInfo> searchKnowLedgeInfoByCond(KnowledgeSearchCond cond, int start, int count) throws BLException;
 
 /**
  * ������������
  * @param cond ��������
  * @param start ������¼��ʼ�к�
  * @param count ������¼����
  * @return ��������б�
  */
 public List<KnowLedgeInfo> searchKnowLedgeInfoOrderByTime(KnowledgeSearchCond cond, int start, int count) throws BLException;

	/**
	 * �����������Ĺ���֪ʶ����
	 * @return �������Ĺ���֪ʶ�����б�
	 */
	public List<KnowLedgeInfo> searchKnowLedgeSummary()throws BLException;
}

