package com.deliverik.framework.user.model.dao;

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
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.condition.ActionSearchCond;
import com.deliverik.framework.user.model.entity.ActionTB;

/**
 * �˵���ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class ActionTBDAOImpl extends BaseHibernateDAOImpl<Action> implements ActionTBDAO {

	/**
	 * ���캯��
	 */
	public ActionTBDAOImpl(){
		super(ActionTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Action> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("actsortid"));
		List<Action> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param actname ����
	 * @return �������
	 */
	public Action findByPK(Serializable actname) {

		Action act = super.findByPK(actname);
		if(act == null) return null;

		return act;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ActionSearchCond cond){
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
	public List<Action> findByCond(final ActionSearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("actsortid"));
		List<Action> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ActionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�˵���ʾ����
		if( !StringUtils.isEmpty(cond.getActlabel())){
			c.add(Expression.eq("actlabel", cond.getActlabel()));
		}	
		//�˵��������ɫ����
		if( !StringUtils.isEmpty(cond.getActroletype())){
			c.add(Expression.like("actroletype", "%" + cond.getActroletype() + "%" ));
		}
		//ACTNAME
		if( StringUtils.isNotEmpty(cond.getActname_like())){
			c.add(Expression.like("actname", cond.getActname_like()+"%"));
		}
		//ACTURL
		if( StringUtils.isNotEmpty(cond.getActurl_like())){
			c.add(Expression.like("acturl", cond.getActurl_like()+"%"));
		}
		//�˵�����
        if( StringUtils.isNotEmpty(cond.getActtype())){
            c.add(Expression.eq("acttype", cond.getActtype()));
        }
        //�˵����ã�1��ͣ�ã�null�����ã�
        if( StringUtils.isNotEmpty(cond.getActl1id())){
            c.add(Expression.eq("actl1id", Integer.valueOf(cond.getActl1id())));
        } else {
            c.add(Expression.isNull("actl1id"));
        }
		return c;
	}
	
	/**
	 * ��ѯ�û��˵�Ȩ��
	 * @param userid �û�ID
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<Action> findUserAction(final String userid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();			
				query.append(session.getNamedQuery("ActionTBDAO.findUserAction").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("userid", userid);
				q.addEntity("UserAction",ActionTB.class);
				setFetchPoint(q, 0, 0);
				List<Action> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Action>) execute(action);
	}
	
	/**
     * �Ӳ˵�������ֵȡ��
     * 
     * @param ���˵�������
     * @return �Ӳ˵�������ֵ
     */
    @SuppressWarnings("rawtypes")
	public String getActnameNextValue(String parActname) {
        String sql =  "SELECT MAX(actname) FROM ActionTB WHERE actname LIKE :parActname and acttype= :acttype ";
        NamedParamMap p = getNamedParamMap();
        p.setString("parActname", parActname + "%");
        p.setString("acttype", "M2");
        List l = findByNamedParamMap(sql, p);
        if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
            return parActname + StringUtils.leftPad("1", 2, "0");
        } else {
            String id = (String)l.get(0);
            return parActname + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(parActname, "")) + 1) + "", 2, "0"); 
        }
    }
}
