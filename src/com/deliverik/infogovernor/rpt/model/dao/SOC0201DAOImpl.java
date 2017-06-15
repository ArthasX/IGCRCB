/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.rpt.model.dao;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0201TB;


/**
 * 
 * @Description:�Զ��������ɱ�DAOʵ��
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��REPORT_GDATA_ITEMDAOImpl������ΪSOC0201DAOImpl
 */
@SuppressWarnings("deprecation")
public class SOC0201DAOImpl extends BaseHibernateDAOImpl<SOC0201Info> implements SOC0201DAO {
   /**
    * ���캯��
    */
   public SOC0201DAOImpl(){
       super(SOC0201TB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<SOC0201Info> findAll() {
       return null;
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public SOC0201Info findByPK(Serializable id) {
       SOC0201Info result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final SOC0201SearchCond cond){
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
   public List<SOC0201Info> findByCond(final SOC0201SearchCond cond, final int start, final int count){
       DetachedCriteria c = getCriteria(cond);
       c.addOrder(Order.desc("r_time"));
       List<SOC0201Info> ret = findByCriteria(c, start, count);
       return ret;
   }
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   protected DetachedCriteria getCriteria(SOC0201SearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       if(StringUtils.isNotEmpty( cond.getR_path())){
			c.add(Expression.eq("r_path", cond.getR_path()));
		}
       if(cond.getR_rcid()!=null&&cond.getR_rcid()!=0){
			c.add(Expression.eq("r_rcid", cond.getR_rcid()));
       }
       if(StringUtils.isNotEmpty( cond.getR_time())){
			c.add(Expression.eq("r_time", cond.getR_time()));
		}
       if(StringUtils.isNotEmpty( cond.getR_category())){
			c.add(Expression.eq("r_category", cond.getR_category()));
		}
       return c;
   }
}

