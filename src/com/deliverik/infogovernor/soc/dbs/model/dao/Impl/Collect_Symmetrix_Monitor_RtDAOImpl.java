/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao.Impl;

 import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
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
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_Monitor_RtTB;


/**
 * 
 * @Description:�洢ʵʱ��ϢDAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_Monitor_RtDAOImpl extends BaseHibernateDAOImpl<Collect_Symmetrix_Monitor_Rt> implements Collect_Symmetrix_Monitor_RtDAO {
   /**
    * ���캯��
    */
   public Collect_Symmetrix_Monitor_RtDAOImpl(){
       super(Collect_Symmetrix_Monitor_RtTB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<Collect_Symmetrix_Monitor_Rt> findAll() {
       return null;
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public Collect_Symmetrix_Monitor_Rt findByPK(Serializable id) {
       Collect_Symmetrix_Monitor_Rt result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final Collect_Symmetrix_Monitor_RtSearchCond cond){
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
   public List<Collect_Symmetrix_Monitor_Rt> findByCond(final Collect_Symmetrix_Monitor_RtSearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteria(cond);
	   c.addOrder(Order.asc("savetime"));
	   return findByCriteria(c, start, count);
   }
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   @SuppressWarnings("deprecation")
protected DetachedCriteria getCriteria(Collect_Symmetrix_Monitor_RtSearchCond cond){
	  DetachedCriteria c = getDetachedCriteria();
      if(!StringUtils.isEmpty(cond.getSavetime())){
			c.add(Expression.ge("savetime", cond.getSavetime()));
      }
      if(!StringUtils.isEmpty(cond.getSymm_id())){
			c.add(Expression.eq("symm_id", cond.getSymm_id()));
      }
      return c;
   }
   

   /**
	 * ��ȡ���ʱ��
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Date getMaxSaveTime(final Collect_Symmetrix_Monitor_RtSearchCond cond){
			
		HibernateCallback action = new HibernateCallback() {
					
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append("select max(savetime) from cst.collect_symmetrix_monitor_rt");
				query.append(" where symm_id='"+cond.getSymm_id()+"'");
				SQLQuery q = session.createSQLQuery(query.toString());
				
				List<String>list = q.list();
				
				session.clear();
				
				return list.size()>0&&list.get(0)!=null?new Date(list.get(0).substring(0,14)+"59:59"):new Date();
			}				
		};
		return (Date) execute(action);		
	}
}

