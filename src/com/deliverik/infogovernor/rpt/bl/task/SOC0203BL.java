/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.rpt.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCond;


/**
 * 
 * @Description:�Զ����������б�BL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfigurationBL������ΪSOC0203BL
 */
public interface SOC0203BL extends BaseBL{
   /**
    * �־û�����
    * @param SOC0203ʵ����
    * @return SOC0203ʵ����
    */
 public SOC0203Info saveSOC0203(SOC0203Info soc0203) throws BLException;

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public SOC0203Info findSOC0203ByPK(Integer id) throws BLException;

   /**
    * ȫ������
    * @return ���������
    */
 public List<SOC0203Info> findAllSOC0203() throws BLException;

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(SOC0203SearchCond cond) throws BLException;

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<SOC0203Info> findSOC0203ByCond(SOC0203SearchCond cond, int start, int count) throws BLException;

    /**
     * ɾ������
     * @param SOC0203ʵ����
     */
 public void deleteSOC0203(SOC0203Info soc0203) throws BLException;

}

