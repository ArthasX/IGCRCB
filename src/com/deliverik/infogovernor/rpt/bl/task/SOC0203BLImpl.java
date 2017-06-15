/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.rpt.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0203DAO;


/**
 * 
 * @Description:�Զ����������б�BLʵ����
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfigurationBLImpl������ΪSOC0203BLImpl
 */
public class SOC0203BLImpl extends BaseBLImpl implements SOC0203BL{

  protected SOC0203DAO soc0203DAO;

 public void setSoc0203DAO(SOC0203DAO soc0203DAO) {
 this.soc0203DAO = soc0203DAO;
 }

   /**
    * �־û�����
    * @param SOC0203ʵ����
    * @return SOC0203ʵ����
    */
 public SOC0203Info saveSOC0203(SOC0203Info soc0203) throws BLException{
 return soc0203DAO.save(soc0203);
 }

   /**
    * ������������
    * @param id ����
    * @return �������
    */
 public SOC0203Info findSOC0203ByPK(Integer id) throws BLException{
 return soc0203DAO.findByPK(id);
 }

   /**
    * ȫ������
    * @return ���������
    */
 public List<SOC0203Info> findAllSOC0203() throws BLException{
 return soc0203DAO.findAll();
 }

   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
 public int getSearchCount(SOC0203SearchCond cond) throws BLException{
 return soc0203DAO.getSearchCount(cond);
 }

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
 public List<SOC0203Info> findSOC0203ByCond(SOC0203SearchCond cond, int start, int count) throws BLException{
 return soc0203DAO.findByCond(cond, start, count);
 }

    /**
     * ɾ������
     * @param SOC0203ʵ����
     */
 public void deleteSOC0203(SOC0203Info soc0203) throws BLException{
	 soc0203DAO.delete(soc0203);
 }

}

