/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;


/**
 * 
 * @Description:�洢������ϢBL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_InfoBL extends BaseBL{
   /**
    * �־û�����
    * @param Collect_Symmetrix_Infoʵ����
    * @return Collect_Symmetrix_Infoʵ����
    */
 public Collect_Symmetrix_Info saveCollect_Symmetrix_Info(Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException;

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public Collect_Symmetrix_Info findCollect_Symmetrix_InfoByPK(Integer id) throws BLException;

   /**
    * ȫ������
    * @return ���������
    */
 public List<Collect_Symmetrix_Info> findAllCollect_Symmetrix_Info() throws BLException;

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(Collect_Symmetrix_InfoSearchCond cond) throws BLException;

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<Collect_Symmetrix_Info> findCollect_Symmetrix_InfoByCond(Collect_Symmetrix_InfoSearchCond cond, int start, int count) throws BLException;

    /**
     * ɾ������
     * @param Collect_Symmetrix_Infoʵ����
     */
 public void deleteCollect_Symmetrix_Info(Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException;

 /**
  * �޸Ĵ���
  * @param collect_Symmetrix_Info
  * @throws BLException
  */
 public Collect_Symmetrix_Info updateCollect_Symmetrix_Info(Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException;

}

