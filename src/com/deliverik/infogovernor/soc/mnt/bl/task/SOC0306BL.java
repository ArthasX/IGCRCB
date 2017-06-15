/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.mnt.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;


/**
 * 
 * @Description:���������Ϣ��ͼBL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface SOC0306BL extends BaseBL{
   /**
    * �־û�����
    * @param Soc0306ʵ����
    * @return Soc0306ʵ����
    */
 public SOC0306Info saveSoc0306(SOC0306Info soc0306Info) throws BLException;

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public SOC0306Info findSoc0306ByPK(Integer id) throws BLException;

   /**
    * ȫ������
    * @return ���������
    */
 public List<SOC0306Info> findAllSoc0306() throws BLException;

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(SOC0306SearchCond cond) throws BLException;

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<SOC0306Info> findSoc0306ByCond(SOC0306SearchCond cond, int start, int count) throws BLException;

    /**
     * ɾ������
     * @param Soc0306ʵ����
     */
 public void deleteSoc0306(SOC0306Info soc0306Info) throws BLException;
 
 /**
  * ��ѯȱʧ�����ܵ�������
  * @param yestoday ���������
  * @return ��������б�
  */
 @SuppressWarnings("unchecked")
 public List searchSymmetrixAlarm(String yestoday);

}

