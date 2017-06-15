package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * �ʲ���������ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG800DAOImpl extends BaseHibernateDAOImpl<IG800Info> implements IG800DAO {

	/**
	 * ���캯��
	 */
	public IG800DAOImpl(){
		super(IG800TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG800Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ciid"));
		List<IG800Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param ciid ����
	 * @return �������
	 */
	public IG800Info findByPK(Serializable ciid) {

		IG800Info IG800 = super.findByPK(ciid);
		if(IG800 == null) return null;

		return IG800;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG800SearchCond cond){
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
	public List<IG800Info> findByCond(final IG800SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("cid"));
		if(cond.getEiid() !=null){
			c.addOrder(Order.desc("civersion"));
			c.addOrder(Order.desc("cismallversion"));
			//c.addOrder(Order.desc("ciid"));
		}
		List<IG800Info> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG800SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�ʲ�ID
		if(cond.getEiid()!=null){
			c.add(Expression.eq("eiid", cond.getEiid()));
		}	
		
		//�ʲ�ģ��ID
		if( !StringUtils.isEmpty(cond.getEid())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEid())));
		}	

		//�ʲ����԰汾��
		if(StringUtils.isNotEmpty(cond.getCiversion())){
			c.add(Expression.eq("civersion", Integer.parseInt(cond.getCiversion())));
		}	
		
		//�ʲ�ģ������id
		if( cond.getCid()!=null && cond.getCid()!=0){
			c.add(Expression.eq("cid", cond.getCid()));
		}
		
		//�ʲ�����ֵ
		if(!StringUtils.isEmpty(cond.getCivalue())){
			c.add(Expression.eq("civalue", cond.getCivalue()));
		}
		
		//�ʲ�����С�汾
		if(!StringUtils.isEmpty(cond.getCismallversion())){
			c.add(Expression.eq("cismallversion", Integer.parseInt(cond.getCismallversion())));
		}
		
		return c;
	}
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	@SuppressWarnings("rawtypes")
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion) {
		String sql =  "SELECT MAX(ci.cismallversion) FROM IG800TB ci WHERE eiid = :eiid AND civersion = :civersion";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("eiid", eiid);
		p.setInteger("civersion", civersion);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (Integer) l.get(0);
	}
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();StringBuffer sql =  new StringBuffer();
				sql.append("SELECT a.eiid from ig013 a where 1=1");
				String ci = null;
				if(value != null) {
					for(String key : value.keySet()) {
						sql.append(" and exists (select 1 from ig050 b where a.eiid = b.eiid and b.cname='");
						sql.append(key).append("'");
						ci = value.get(key);
						if(ci == null) {
							//������
						} else if("".equals(ci)) {
							sql.append(" and b.civalue=''");
						} else {
							sql.append(" and b.civalue='").append(value.get(key)).append("'");
						}
						sql.append(")");
					}
				}
				sql.append(" group by a.eiid");
				SQLQuery q = session.createSQLQuery(sql.toString());
				List<Integer> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Integer>) execute(action);
	}
}
