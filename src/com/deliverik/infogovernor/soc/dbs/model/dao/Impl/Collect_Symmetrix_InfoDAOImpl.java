/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.soc.dbs.model.dao.Impl;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_InfoDAO;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;


/**
 * 
 * @Description:�洢������ϢDAOʵ��
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_InfoDAOImpl extends BaseHibernateDAOImpl<Collect_Symmetrix_Info> implements Collect_Symmetrix_InfoDAO {
   /**
    * ���캯��
    */
   public Collect_Symmetrix_InfoDAOImpl(){
       super(Collect_Symmetrix_InfoTB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<Collect_Symmetrix_Info> findAll() {
	   DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public Collect_Symmetrix_Info findByPK(Serializable id) {
       Collect_Symmetrix_Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final Collect_Symmetrix_InfoSearchCond cond){
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
   public List<Collect_Symmetrix_Info> findByCond(final Collect_Symmetrix_InfoSearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteria(cond);
	   c.addOrder(Order.asc("symm_id"));
		List<Collect_Symmetrix_Info> ret = findByCriteria(c, start, count);
		return ret;
   }
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   @SuppressWarnings("deprecation")
protected DetachedCriteria getCriteria(Collect_Symmetrix_InfoSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
     
		if(StringUtils.isNotEmpty(cond.getSymm_id())) {
			c.add(Expression.eq("symm_id", cond.getSymm_id()));
		}
		
		//�洢����
		if(StringUtils.isNotEmpty(cond.getSymm_id_like())){
			c.add(Expression.like("symm_id", "%"+cond.getSymm_id_like()+"%"));
		}
		
		//�洢����
		if(StringUtils.isNotEmpty(cond.getSymm_type())){
			c.add(Expression.eq("symm_type", cond.getSymm_type()));
		}
		
		//�洢����
		if(cond.getSymm_typeStr()!=null&&cond.getSymm_typeStr().length>0){
			c.add(Expression.in("symm_type", cond.getSymm_typeStr()));
		}
       return c;
   }
}

