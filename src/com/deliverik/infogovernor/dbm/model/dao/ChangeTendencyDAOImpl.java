/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.dbm.model.dao;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.entity.ChangeTendencyTB;



/**
 * 
 * @Description:�������ͳ�Ʊ�DAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class ChangeTendencyDAOImpl extends BaseHibernateDAOImpl<ChangeTendency> implements ChangeTendencyDAO {
	
   /**
    * ���캯��
    */
   public ChangeTendencyDAOImpl(){
       super(ChangeTendencyTB.class);
   }
   
   
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final ChangeTendencySearchCond cond){
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
   public List<ChangeTendency> findByCond(final ChangeTendencySearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<ChangeTendency> ret = findByCriteria(c, start, count);
       return ret;
   }
   
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   protected DetachedCriteria getCriteria(ChangeTendencySearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getCtyear())){
			c.add(Expression.eq("ctyear", cond.getCtyear()));
       }
       if(StringUtils.isNotEmpty(cond.getCtmonth())){
			c.add(Expression.eq("ctmonth", cond.getCtmonth()));
       }
       if(StringUtils.isNotEmpty(cond.getCtday())){
			c.add(Expression.eq("ctday", cond.getCtday()));
       }

       return c;
   }
}

