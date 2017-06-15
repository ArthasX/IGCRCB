/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.rpt.model.dao;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCond;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.entity.SOC0203TB;


/**
 * 
 * @Description:�Զ����������б�DAOʵ��
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfigurationDAOImpl������ΪSOC0203DAOImpl
 */
@SuppressWarnings("deprecation")
public class SOC0203DAOImpl extends BaseHibernateDAOImpl<SOC0203Info> implements SOC0203DAO {
   /**
    * ���캯��
    */
   public SOC0203DAOImpl(){
       super(SOC0203TB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<SOC0203Info> findAll() {
       List<SOC0203Info> ret = findByCond(new SOC0203SearchCondImpl(), 0, 0);
       return ret;
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public SOC0203Info findByPK(Serializable id) {
       SOC0203Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final SOC0203SearchCond cond){
       DetachedCriteria c = getCriteria(cond);
       return getCount(c);
   }
   /**
    * ������������
    * @param cond ��������
    * @param start ������¼��ʼ�к�
    * @param count ������¼����
    * @return ��������б�
    */
   public List<SOC0203Info> findByCond(final SOC0203SearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<SOC0203Info> ret = findByCriteria(c, start, count);
       return ret;
   }
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   protected DetachedCriteria getCriteria(SOC0203SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getDataid())){
    	   c.add(Expression.eq("dataid", cond.getDataid()));
       }
       return c;
   }
}

