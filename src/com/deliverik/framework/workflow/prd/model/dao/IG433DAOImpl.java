/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG433Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG433TB;
import com.deliverik.framework.workflow.prr.model.IG003Info;



 /**
  * ����:��������DAOʵ����
  * ���������������������ʵ����в���
  *           
  * ������¼���κ���    2010/11/26
  */
@SuppressWarnings("deprecation")
public class IG433DAOImpl extends BaseHibernateDAOImpl<IG433Info> implements IG433DAO {
   /**
    * ���캯��
    */
   public IG433DAOImpl(){
       super(IG433TB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<IG433Info> findAll() {
       return null;
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public IG433Info findByPK(Serializable id) {
       IG433Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final IG433SearchCond cond){
       DetachedCriteria c = getCriteria(cond);
       return getCount(c);
   }

   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   
   protected DetachedCriteria getCriteria(IG433SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       
       if(cond.getPaprid()!=null){
    	   c.add(Expression.eq("paprid", cond.getPaprid()));
       }
       
       return c;
   }
   
   
	/**
	 * ���ܣ���������������ͼ��
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG433Info> findByCond(final IG433SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				setFetchPoint(q, start, count);
				List<IG003Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG433Info>) execute(action);
	}
	
	/**
	 * ���ܣ�������������ʵ�壩
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG433Info> findByCond_Entity(
			IG433SearchCond cond, int start, int count) {
		DetachedCriteria c = getCriteria(cond);
		List<IG433Info> ret = findByCriteria(c, start, count);
		lazyLoad(ret);
		return ret;
	}
	
	protected void lazyLoad(List<IG433Info> list){
		if(list==null || list.isEmpty()){
			return ;
		}
		for(IG433Info processAssessment:list){
			Hibernate.initialize(processAssessment.getAttachmentList());
		}
		
		
	}
	
}

