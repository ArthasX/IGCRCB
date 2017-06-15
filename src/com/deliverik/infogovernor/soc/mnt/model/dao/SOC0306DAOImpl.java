/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.mnt.model.dao;

 import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0306TB;


/**
 * 
 * @Description:���������Ϣ��ͼDAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class SOC0306DAOImpl extends BaseHibernateDAOImpl<SOC0306Info> implements SOC0306DAO {
   /**
    * ���캯��
    */
   public SOC0306DAOImpl(){
       super(SOC0306TB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<SOC0306Info> findAll() {
	   DetachedCriteria c= getDetachedCriteria();
	   c.addOrder(Order.desc("id"));
	   List<SOC0306Info> ret = findByCriteria(c);
       return ret;
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public SOC0306Info findByPK(Serializable id) {
       SOC0306Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final SOC0306SearchCond cond){
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
   public List<SOC0306Info> findByCond(final SOC0306SearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       List<SOC0306Info> ret = findByCriteria(c, start, count);
       return ret;
   }
   
   /**
    * ��ѯȱʧ�����ܵ�������
    * @param yestoday ���������
    * @return ��������б�
    */
   @SuppressWarnings("unchecked")
   public List searchSymmetrixAlarm(final String yestoday){
	   HibernateCallback action = new  HibernateCallback(){

		public Object doInHibernate(Session session) throws HibernateException,
				SQLException {
			session.flush();
			StringBuffer query = new StringBuffer();
			query.append("SELECT SYMM_ID,SYMM_TYPE FROM (");
			query.append(" SELECT SYMM_ID,SYMM_TYPE FROM COLLECT_SYMMETRIX_INFO  AS A ");
			query.append(" LEFT JOIN (SELECT SYMID,DATA_TIMES FROM COLLECT_SYSTEM_DAY WHERE DATA_TIMES='"+yestoday+"' UNION");
			query.append(" SELECT DATAID,POLL_TIME AS DATA_TIMES FROM CX_COLLECT_PORT_DAY WHERE POLL_TIME='"+yestoday+"' UNION");
			query.append(" SELECT SYMM_ID AS DATAID,SAVETIME AS DATA_TIMES FROM COLLECT_SYMMETRIX_MONITOR_DAY WHERE SAVETIME='"+yestoday+"' UNION");
			query.append(" SELECT DATAID,DATA_TIMES FROM COLLECT_PORT_LEVEL_STATISTICS_DAY WHERE DATA_TIMES='"+yestoday+"') AS B ");
			query.append(" ON A.SYMM_ID = B.SYMID WHERE B.DATA_TIMES IS NULL");
			query.append(" ) E GROUP BY SYMM_ID,SYMM_TYPE");
			SQLQuery q = session.createSQLQuery(query.toString());
			List list = q.list();
			session.clear();
			return list;
		}
		   
	   };
	   
	   return (List) execute(action);
   }
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
protected DetachedCriteria getCriteria(SOC0306SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty(cond.getSymmid())){
    	   c.add(Expression.eq("symmid", cond.getSymmid()));
       }
       //�澯ʱ���
		if( !StringUtils.isEmpty(cond.getDataitmes_f())){
			c.add(Expression.ge("dataitmes", cond.getDataitmes_f()));
		}
		 //�澯ʱ�䵽
		if( !StringUtils.isEmpty(cond.getDataitmes_t())){
			c.add(Expression.le("dataitmes", cond.getDataitmes_t()));
		}
		//�¸澯
		if( StringUtils.isEmpty(cond.getReaddate())){
			c.add(Expression.or(Expression.isNull("readdate"), Expression.eq("readdate","")));
		}
       return c;
   }

}

