/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG229Info;
import com.deliverik.framework.workflow.prd.model.condition.IG229SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG229TB;

/**
 * ����:����������ϸ��¼��daoʵ����
 * �����������������������ϸ��¼��ʵ����в���
 *           
 * ������¼��wangxiaoqiang    2010/11/29
 */
@SuppressWarnings("deprecation")
public class IG229DAOImpl extends BaseHibernateDAOImpl<IG229Info> implements IG229DAO {
   /**
    * ���캯��
    */
   public IG229DAOImpl(){
       super(IG229TB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<IG229Info> findAll() {
       return null;
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public IG229Info findByPK(Serializable id) {
       IG229Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final IG229SearchCond cond){
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
   public List<IG229Info> findByCond(final IG229SearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteria(cond);
	   List<IG229Info> ret = findByCriteria(c, start, count);
	   return ret;
   }
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
 
protected DetachedCriteria getCriteria(IG229SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       
       if(cond.getPadprid()!=null){
    	   c.add(Expression.eq("padprid", cond.getPadprid()));
       }
       return c;
   }
}

