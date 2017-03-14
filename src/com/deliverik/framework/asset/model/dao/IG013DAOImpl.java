package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * �ʲ���ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG013DAOImpl extends BaseHibernateDAOImpl<IG013Info> implements IG013DAO {

	/**
	 * ���캯��
	 */
	public IG013DAOImpl(){
		super(IG013TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG013Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eiid"));
		List<IG013Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eiid ����
	 * @return �������
	 */
	public IG013Info findByPK(Serializable eiid) {

		IG013Info entityitem = super.findByPK(eiid);
		if(entityitem == null) return null;

		return entityitem;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG013SearchCond cond){
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
	public List<IG013Info> findByCond(final IG013SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eid"));
		c.addOrder(Order.asc("eilabel"));
		List<IG013Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG013SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�ʲ�ģ��ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEid())));
		}	
		//�ʲ�����
		if( !StringUtils.isEmpty(cond.getEiname())){
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%"));
		}	
		
		//�ʲ�����(��ȫƥ��)
		if( !StringUtils.isEmpty(cond.getEiname_equal())){
			c.add(Expression.eq("einame", cond.getEiname_equal()));
		}	
		
		//�ʲ����
		if( !StringUtils.isEmpty(cond.getEilabel())){
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}
		//�ʲ��������������
		if( !StringUtils.isEmpty(cond.getEiorgsyscoding())){
			c.add(Expression.like("eiorgsyscoding", cond.getEiorgsyscoding()+"%"));
		}
		
		//�ʲ�ģ��in����
		if( cond.getEilabel_list()!=null && cond.getEilabel_list().size()>0){
			c.add(Expression.in("eilabel", cond.getEilabel_list()));
		}
		//�ʲ�ID
		if(StringUtils.isNotEmpty(cond.getEiid())){
			c.add(Expression.eq("eiid", Integer.parseInt(cond.getEiid())));
		}
		//�ʲ��汾
		if(cond.getEiversion() != null && cond.getEiversion() > 0){
			c.add(Expression.eq("eiversion", cond.getEiversion()));
		}
		//�ʲ�С�汾
		if(cond.getEismallversion() != null && cond.getEismallversion() > 0){
			c.add(Expression.eq("eismallversion", cond.getEismallversion()));
		}
		
		return c;
	}
	
	/**
	 * ��ȡ�ʲ�������ֵ �ʲ�key+��+��� ��λ����4+2+6��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ�������ֵ��ƽ̨������
	 */
	
	@SuppressWarnings("rawtypes")
	public String searchMaxIG013InfoLable(final IG013SearchCond cond) {
		String sql =  "select max(ei.eilabel) from IG013TB ei where ei.eilabel like :eilabel";
		NamedParamMap p = getNamedParamMap();
		p.setString("eilabel", cond.getEilabel() + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<IG013Info> list =null;
				
				query.append(session.getNamedQuery("IG013DAO.findByCond").getQueryString());
				
				//�ʲ�������ģ��
				if( !StringUtils.isEmpty(cond.getEsyscoding())){
					query.append(" AND V.esyscoding like (:esyscoding||'%') ");
				}
				//�ʲ�����
				if( !StringUtils.isEmpty(cond.getEiname())){
					query.append(" AND V.einame like ('%' || :einame || '%') ");
				}
				
				//�ʲ���Ǽ���FROM
				if( !StringUtils.isEmpty(cond.getEiupdtime_from())){
					query.append(" AND V.eiinsdate >= :eiupdtime_from");
				}
				//�ʲ���Ǽ���TO
				if( !StringUtils.isEmpty(cond.getEiupdtime_to())){
					query.append(" AND V.eiinsdate <= :eiupdtime_to");
				}
				
				query.append(" ) ) vm ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(IG013TB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IG013Info>) execute(action);
	}
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion){
		
		HibernateCallback action = new HibernateCallback(){  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();		
				query.append("select rownumber()over() as switchid,A.switchname,B.switchip,C.switchdomain,D.effectivecfg from ");
				query.append("(select  civalue as switchname,eiid from  IG800 ");
				query.append("    where  cid = 1059 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("  )A  left join ");
				query.append("(select  civalue as switchip,eiid from  IG800 ");
				query.append("    where  cid = 1121 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append(  ")B  on A.eiid = B.eiid");
				query.append("     left join ");
				query.append(" (select  civalue as switchdomain,eiid from  IG800 ");
				query.append("    where  cid = 1122 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("	)C on B.eiid = C.eiid ");
				query.append("    left join ");
				query.append(" (select  civalue as effectivecfg,eiid from  IG800 "); 
				query.append("    where  cid = 1056 and eiid="+eiid+" and civersion="+version+" and cismallversion="+smallversion);
				query.append("	)D  on C.eiid = D.eiid ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SwitchConfigItemVW.class);
				List<SwitchConfigItemVW> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SwitchConfigItemVW>) execute(action);
	}
	
}
