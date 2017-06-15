/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

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
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0602VW;

/**
 * �豸��Ϣ��ͼDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0602DAOImpl extends BaseHibernateDAOImpl<SOC0602Info> implements SOC0602DAO {

	/**
	 * ���캯��
	 * 
	 */
	public SOC0602DAOImpl(){
		super(SOC0602VW.class);
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0602SearchCond cond){
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
	public List<SOC0602Info> findByCond(final SOC0602SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		c.addOrder(Order.asc("eilabel"));
		List<SOC0602Info> ret = findByCriteria(c, start, count);
		return ret;
	}


    /**
     * ������������ģ����ѯ�豸���������豸���ڻ��񣬻���
     * 
     * @param cond
     * @param start
     * @param count
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> findZhiJiLocation(final SOC0602SearchCond cond) {
        HibernateCallback action = new HibernateCallback() {

            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(session.getNamedQuery("SOC0602DAO.traceZhuJiLocation").getQueryString());
                if(!StringUtils.isEmpty(cond.getEiname())){
                    query.append(" AND LOWER(A.EINAME) LIKE LOWER('%"+cond.getEiname()+"%')");
                }
                
                if(!StringUtils.isEmpty(cond.getEilabel())){
                    query.append(" AND LOWER(A.EILABEL) LIKE LOWER('%"+cond.getEilabel()+"%')");
                }
                if(cond.getRoom_eiid()!=null){
                    query.append(" AND B.ROOM_EIID ="+cond.getRoom_eiid());
                }
                SQLQuery q = session.createSQLQuery(query.toString());
                List<Object[]> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<Object[]>) execute(action);
    }
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0602SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if (cond.getEiid()!=null) {
			c.add(Expression.eq("eiid", cond.getEiid()));
		}

		if (cond.getContainer_eiid()!=null) {
			c.add(Expression.eq("container_eiid", cond.getContainer_eiid()));
		}

		if (StringUtils.isNotEmpty(cond.getEilabel())) {
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}

		if (StringUtils.isNotEmpty(cond.getEiname())) {
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%"));
		}

		if (StringUtils.isNotEmpty(cond.getU_total())) {
			c.add(Expression.eq("u_width", cond.getU_total()));
		}
		
		if(StringUtils.isNotEmpty(cond.getEsyscoding())){
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + "%"));
		}

		if("Y".equals(cond.getInJiguiFlg())){
			c.add(Expression.isNotNull("u_value"));
		}else if("N".equals(cond.getInJiguiFlg())){
			c.add(Expression.or(Expression.isNull("u_value"),Expression.eq("u_value","")));
		}
		
		if(StringUtils.isNotEmpty(cond.getInroomFlg())){
			c.add(Expression.eq("inroomFlg", cond.getInroomFlg()));
		}
		
		if(cond.getEiStatuses()!=null){
			c.add(Expression.in("eistatus", cond.getEiStatuses()));
		}
		if(cond.getCabinet()!=null){
			if("0".equals(cond.getCabinet())){//0:ȫ������(����û������������豸)
				c.add(Expression.or(Expression.isNull("cabinet"), Expression.eq("cabinet", "")));
			}else{//����:��ǰ����
				c.add(Expression.eq("cabinet", cond.getCabinet()));
			}
		}	
		return c;
	}
}
