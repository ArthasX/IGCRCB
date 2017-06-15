/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCond;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004VW;

/**
  * ����: �澯����ģ���DAOʵ��
  * ��������: �澯����ģ���DAOʵ��
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Mss00004DAOImpl extends
		BaseHibernateDAOImpl<Mss00004Info> implements Mss00004DAO {

	/**
	 * ���캯��
	 */
	public Mss00004DAOImpl(){
		super(Mss00004TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Mss00004Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Mss00004Info findByPK(Serializable pk) {
		Mss00004Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Mss00004SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Mss00004Info> findByCond(final Mss00004SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("tempstate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Mss00004SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getRuletempname())){
			c.add(Expression.eq("ruletempname", cond.getRuletempname()));
		}
		if(!StringUtils.isEmpty(cond.getTypeid())){
			c.add(Expression.eq("typeid", cond.getTypeid()));
		}
		if(cond.getTempstates() != null){
			c.add(Expression.eq("tempstate", cond.getTempstates()));
		}
		//��ѯ������������IP
		if(cond.getTempidList() != null){
			if(cond.getTempidList().size() == 0) {
				List<Integer> none = new ArrayList<Integer>();
				none.add(-1);
				c.add(Expression.or(Expression.in("ruletempid", none),Expression.eq("typeid", "0000")));
			}else
				c.add(Expression.or(Expression.in("ruletempid", cond.getTempidList()),Expression.eq("typeid", "0000")));
		}
		if(StringUtils.isNotEmpty(cond.getSummary())){
			c.add(Expression.like("summary", "%"+cond.getSummary()+"%"));
		}
		return c;
	}

	@SuppressWarnings("unchecked")
	public List<Mss00004VWInfo> findByCondVW(final Mss00004SearchCond cond,final int start,final int end) {
		
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("  select * from ( select m.ruletempid,m.ruletempname,m.typeid,m.rulecondition,m.tempstate,m.createtime,m.tempdesc,m.summary,c.conditionCount  ");
				query.append(" from mss00004 m left join  ");
				query.append(" (select n.ruletempid,count(n.ruleconditionid) as conditionCount from mss00003 n group  by n.ruletempid ) c on m.ruletempid = c.ruletempid) Z where 1=1 ");
				getSQL(cond,query);
				query.append(" order by tempstate desc,ruletempid desc ");
				SQLQuery q = session.createSQLQuery(query.toString());
//				q.setProperties(cond);
				q.addEntity("Mss00004VW",Mss00004VW.class);
				setFetchPoint(q, start, end);
				List<DateWorkVWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Mss00004VWInfo>) execute(action);
	}

	public void getSQL(Mss00004SearchCond cond, StringBuffer query) {
		if(!StringUtils.isEmpty(cond.getRuletempname())){
			query.append(" and ruletempname like '%"+cond.getRuletempname()+"%' ");
		}
		if(cond.getTempstates() != null){
			query.append(" and tempstate = "+cond.getTempstates());
		}
		//��ѯ������������IP
		if(cond.getTempidList() != null){
			if(cond.getTempidList().size() != 0) {
				query.append(" and (ruletempid in (");
				List<Integer> ids = cond.getTempidList();
				for(int i = 0; i < ids.size(); i++){
					query.append(ids.get(i));
					if(i < ids.size() -1 ) query.append(",");
				}
			}else{
				query.append(" and (ruletempid in (-1");
			}
			query.append(") or typeid = '0000')");
		}
		if(StringUtils.isNotEmpty(cond.getTypeid())){
			query.append(" and typeid = '"+cond.getTypeid()+"' ");
		}
		if(StringUtils.isNotEmpty(cond.getSummary())){
			query.append(" and summary like '%" + cond.getSummary() + "%' ");
		}
	}
}