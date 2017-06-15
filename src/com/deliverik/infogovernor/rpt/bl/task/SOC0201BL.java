/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.rpt.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCond;


/**
 * 
 * @Description:�Զ��������ɱ�BL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��REPORT_GDATA_ITEMBL������ΪSOC0201BL
 */
public interface SOC0201BL extends BaseBL{
   /**
    * �־û�����
    * @param SOC0201ʵ����
    * @return SOC0201ʵ����
    */
 public SOC0201Info saveSOC0201(SOC0201Info soc0201) throws BLException;

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public SOC0201Info findSOC0201ByPK(Integer id) throws BLException;

   /**
    * ȫ������
    * @return ���������
    */
 public List<SOC0201Info> findAllSOC0201() throws BLException;

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(SOC0201SearchCond cond) throws BLException;

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<SOC0201Info> findSOC0201ByCond(SOC0201SearchCond cond, int start, int count) throws BLException;

    /**
     * ɾ������
     * @param REPORT_GDATA_ITEMʵ����
     */
 public void deleteSOC0201(SOC0201Info rEPORT_GDATA_ITEM) throws BLException;

}

