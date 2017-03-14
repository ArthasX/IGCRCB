/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.entity.IncidentTendencyTB;



/**
 * 
 * @Description:�¼�����ͳ�Ʊ�DAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class IncidentTendencyDAOImpl extends BaseHibernateDAOImpl<IncidentTendency> implements IncidentTendencyDAO {
	
   /**
    * ���캯��
    */
   public IncidentTendencyDAOImpl(){
       super(IncidentTendencyTB.class);
   }
   
   /**
    * ȫ������
    * @return ���������
    */
   public List<IncidentTendency> findAll() {
       return null;
   }
   
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public IncidentTendency findByPK(Serializable id) {
       IncidentTendency result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final IncidentTendencySearchCond cond){
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
   public List<IncidentTendency> findByCond(final IncidentTendencySearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<IncidentTendency> ret = findByCriteria(c, start, count);
       return ret;
   }
   
   
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   protected DetachedCriteria getCriteria(IncidentTendencySearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getItyear())){
			c.add(Expression.eq("ityear", cond.getItyear()));
       }
       if(StringUtils.isNotEmpty(cond.getItmonth())){
			c.add(Expression.eq("itmonth", cond.getItmonth()));
       }
       if(StringUtils.isNotEmpty(cond.getItday())){
			c.add(Expression.eq("itday", cond.getItday()));
       }
       if(StringUtils.isNotEmpty(cond.getItdefid())){
			c.add(Expression.eq("itdefid", cond.getItdefid()));
       }
       if(StringUtils.isNotEmpty(cond.getItdefiname())){
			c.add(Expression.eq("itdefiname", cond.getItdefiname()));
       }
       if(StringUtils.isNotEmpty(cond.getItcreateYear())){
			c.add(Expression.eq("itcreateyear", cond.getItcreateYear()));
       }
       if(StringUtils.isNotEmpty(cond.getItcreateMonth())){
			c.add(Expression.eq("itcreatemonth", cond.getItcreateMonth()));
       }
       if(StringUtils.isNotEmpty(cond.getItcreateDay())){
			c.add(Expression.eq("itcreateday", cond.getItcreateDay()));
       }

       return c;
   }
}

