package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.TableSpaceTB;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0437TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0437VW;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;
import com.deliverik.infogovernor.soc.model.entity.NetDeviceTB;

/**
 * �ʲ���ϢDAOʵ��
 * 
 */
@SuppressWarnings({"deprecation","unchecked","rawtypes"})
public class SOC0118VWDAOImpl extends BaseHibernateDAOImpl<SOC0118VWInfo>
		implements SOC0118VWDAO {

	/**
	 * ���캯��
	 */
	public SOC0118VWDAOImpl() {
		super(SOC0118VW.class);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	@Override
	public List<SOC0118VWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eiid"));
		List<SOC0118VWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param eiid
	 *            ����
	 * @return �������
	 */
	@Override
	public SOC0118VWInfo findByPK(Serializable pk) {
		SOC0118VWInfo result = super.findByPK(pk);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * ������������
	 * 
	 * @param pk����
	 * @return �������
	 */
	public List<SOC0118VWInfo> findByPKs(List<SOC0118VWPK> PKs) {
		Set<SOC0118VWInfo> set = new LinkedHashSet<SOC0118VWInfo>();
		for (SOC0118VWPK pk : PKs) {

			SOC0118VWInfo result = super.findByPK(pk);
			if (result != null)
				set.add(result);
		}
		List<SOC0118VWInfo> list = new LinkedList<SOC0118VWInfo>();
		list.addAll(set);
		return list;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0118VWSearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<SOC0118VWInfo> findByCond(final SOC0118VWSearchCond cond,
			final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if (StringUtils.isNotEmpty(cond.getEid())
				&& ("CM08010002".equals(cond.getEid()) || "CM08010001"
						.equals(cond.getEid()))) {
			c.addOrder(Order.asc("eiid"));
		}
		c.addOrder(Order.asc("eid"));
		c.addOrder(Order.asc("eilabel"));
		List<SOC0118VWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0118VWSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getId() != null && cond.getId() > 0) {
			c.add(Expression.eq("id", cond.getId()));
		}
		// �洢���͹���
		if (!StringUtils.isEmpty(cond.getEsyscoding_eq())) {
			c.add(Expression.eq("esyscoding", cond.getEsyscoding_eq()));
		}
		// �ʲ�ģ��ID
		if (!StringUtils.isEmpty(cond.getEid())) {
			c.add(Expression.eq("eid", cond.getEid()));
		}
		// �ʲ�����
		if (!StringUtils.isEmpty(cond.getEiname())) {
			c.add(Expression.like("einame", "%" + cond.getEiname() + "%"));
		}

		// �ʲ�����(��ȫƥ��)
		if (!StringUtils.isEmpty(cond.getEiname_equal())) {
			c.add(Expression.eq("einame", cond.getEiname_equal()));
		}

		// �ʲ����
		if (!StringUtils.isEmpty(cond.getEilabel())) {
			c.add(Expression.eq("eilabel", cond.getEilabel()));
		}
		// �ʲ��������������
		if (!StringUtils.isEmpty(cond.getEiorgsyscoding())) {
			c.add(Expression.like("eiorgsyscoding", cond.getEiorgsyscoding()
					+ "%"));
		}

		// �ʲ�ģ��in����
		if (cond.getEilabel_list() != null && cond.getEilabel_list().size() > 0) {
			c.add(Expression.in("eilabel", cond.getEilabel_list()));
		}
		// �ʲ�ID
		if (StringUtils.isNotEmpty(cond.getEiid())) {
			c.add(Expression.eq("eiid", Integer.parseInt(cond.getEiid())));
		}
		// �ʲ��汾
		if (cond.getEiversion() != null && cond.getEiversion() > 0) {
			c.add(Expression.eq("eiversion", cond.getEiversion()));
		}
		// �ʲ�С�汾
		if (cond.getEismallversion() != null && cond.getEismallversion() > 0) {
			c.add(Expression.eq("eismallversion", cond.getEismallversion()));
		}
		// �ʲ�����ʵ��ID
		if (cond.getEirootmark() != null && cond.getEirootmark() > 0) {
			c.add(Expression.eq("eirootmark", cond.getEirootmark()));
		}

		if (cond.getEiids() != null && cond.getEiids().size() > 0) {
			c.add(Expression.in("eiid", cond.getEiids()));
		}

		if (cond.getEids() != null && cond.getEids().length > 0) {
			c.add(Expression.in("eid", cond.getEids()));
		}
		if (cond.getEid_arr() != null && cond.getEid_arr().length > 0) {
			c.add(Expression.in("eid", cond.getEid_arr()));
		}
		// �洢���͹���
		if (!StringUtils.isEmpty(cond.getEsyscoding_like())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding_like() + "%"));
		}
		// ����ҵ��ϵͳ�Ĺ�����Ա����
		// if(StringUtils.isNotEmpty(cond.getMagName())){
		// c.add(Expression.sql("  eiid in (select a.eiid from soc0118 a "+
		// "left join soc0107 b on(b.eiid = a.eiid and b.cid in('CI030100010002','CI030100010003') and a.eiversion = b.civersion and a.eismallversion = b.cismallversion)"+
		// "where a.esyscoding like '999003001%' and b.civalue like '"+cond.getMagName()+"%')"));
		// }
		// ����einame���� ����
		if (cond.getEiname_in() != null && cond.getEiname_in().size() > 0) {
			c.add(Expression.in("einame", cond.getEiname_in()));
		}

		if (StringUtils.isNotEmpty(cond.getEilabel_like())) {
			c.add(Expression.like("eilabel", "%" + cond.getEilabel_like() + "%"));
		}
		// IP��ѯʱ �Ƿ���� ����
		if (StringUtils.isNotEmpty(cond.getEidesc_falg())) {
			if ("0".equals(cond.getEidesc_falg())) {
				c.add(Expression.eq("eidesc", ""));
			} else {
				c.add(Expression.not(Expression.eq("eidesc", "")));
			}
		}
		if (StringUtils.isNotEmpty(cond.getEiupdtime_from())) {
			c.add(Expression.ge("eiupdtime", cond.getEiupdtime_from()));
		}
		if (StringUtils.isNotEmpty(cond.getEiupdtime_to())) {
			c.add(Expression.le("eiupdtime", cond.getEiupdtime_to()));
		}
		if (StringUtils.isNotEmpty(cond.getEiinsdate_gt())) {
			c.add(Expression.ge("eiinsdate", cond.getEiinsdate_gt()));
		}
		if (StringUtils.isNotEmpty(cond.getEiinsdate_lt())) {
			c.add(Expression.le("eiinsdate", cond.getEiinsdate_lt()));
		}

		return c;
	}

	/**
	 * ��ȡ�ʲ�������ֵ �ʲ�key+��+��� ��λ����4+2+6��
	 * 
	 * @param cond
	 *            �ʲ���Ϣ��������
	 * @return �ʲ�������ֵ��ƽ̨������
	 */

	public String searchMaxEntityItemLable(final SOC0118VWSearchCond cond) {
		String sql = "select max(ei.eilabel) from SOC0118VW ei where ei.eilabel like :eilabel";
		NamedParamMap p = getNamedParamMap();
		p.setString("eilabel", cond.getEilabel() + "%");
		List l = findByNamedParamMap(sql, p);
		if (l.size() == 0)
			return null;
		return (String) l.get(0);
	}

	/**
	 * �豸��ط����¼����
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<SOC0118VWInfo> searchDeviceService(
			final SOC0124SearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118VWInfo> list = null;

				query.append(session.getNamedQuery(
						"DeviceServiceVWDAO.findByCond").getQueryString());

				// �ʲ�������ģ��
				if (!StringUtils.isEmpty(cond.getEsyscoding())) {
					query.append(" AND V.esyscoding like (:esyscoding||'%') ");
				}
				// �ʲ�����
				if (!StringUtils.isEmpty(cond.getEiname())) {
					query.append(" AND V.einame like ('%' || :einame || '%') ");
				}

				// �ʲ���Ǽ���FROM
				if (!StringUtils.isEmpty(cond.getEiupdtime_from())) {
					query.append(" AND V.eiinsdate >= :eiupdtime_from");
				}
				// �ʲ���Ǽ���TO
				if (!StringUtils.isEmpty(cond.getEiupdtime_to())) {
					query.append(" AND V.eiinsdate <= :eiupdtime_to");
				}

				query.append(" ) ) as vm ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0118VW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();

				return list;
			}
		};
		return (List<SOC0118VWInfo>) execute(action);
	}

	/**
	 * �豸��ط����¼����
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<SOC0139VW> searchSwitchService(final String eiid,
			final String version, final String smallversion) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select row_numBER() OVER(order by a.switchname) as switchid,A.switchname,B.switchip,C.switchdomain,D.effectivecfg from ");
				query.append("(select  civalue as switchname,eiid from  SOC0107 ");
				query.append("    where  cid = 'CI010100060006' and eiid="
						+ eiid + " and civersion=" + version
						+ " and cismallversion=" + smallversion);
				query.append("  )A  left join ");
				query.append("(select  civalue as switchip,eiid from  SOC0107 ");
				query.append("    where  cid = 'CI010100060007' and eiid="
						+ eiid + " and civersion=" + version
						+ " and cismallversion=" + smallversion);
				query.append(")B  on A.eiid = B.eiid");
				query.append("     left join ");
				query.append(" (select  civalue as switchdomain,eiid from  SOC0107 ");
				query.append("    where  cid = 'CI010100060008' and eiid="
						+ eiid + " and civersion=" + version
						+ " and cismallversion=" + smallversion);
				query.append("	)C on B.eiid = C.eiid ");
				query.append("    left join ");
				query.append(" (select  civalue as effectivecfg,eiid from  SOC0107 ");
				query.append("    where  cid = 'CI010200180002' and eiid="
						+ eiid + " and civersion=" + version
						+ " and cismallversion=" + smallversion);
				query.append("	)D  on C.eiid = D.eiid ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0139VW.class);
				List<SOC0139VW> list = q.list();
				session.clear();

				return list;
			}
		};
		return (List<SOC0139VW>) execute(action);
	}

	/**
	 * cx��¼����
	 * 
	 * @param strEilabel
	 *            ��������
	 * @return ��������б�
	 */
	public String searchEntityESyscoding(final String strEilabel) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select esyscoding from SOC0118VW where eilabel='");
				query.append(strEilabel);
				query.append("'");
				SQLQuery q = session.createSQLQuery(query.toString());
				List<String> list = q.list();
				session.clear();
				return list.size() > 0 && list.get(0) != null ? list.get(0)
						: null;
			}
		};
		return (String) execute(action);
	}

	public List<CodeDetailEntity> findByCondSQL(final SOC0118VWSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("CodeDetailTBDAO.findQuery")
						.getQueryString());
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				System.out.println(query.toString());
				q.setProperties(cond);
				// q.addEntity(CodeDetailEntity.class);
				setFetchPoint(q, start, count);
				List<Object[]> list = q.list();
				List<CodeDetailEntity> list1 = changeEmployeeEntity(list);
				return list1;
			}
		};
		return (List<CodeDetailEntity>) execute(action);
	}

	/**
	 * ת������
	 * 
	 */
	protected List<CodeDetailEntity> changeEmployeeEntity(List<Object[]> olist) {
		List<CodeDetailEntity> tblist = new ArrayList<CodeDetailEntity>();
		if (olist != null) {
			// ��objectתΪEmployeeSignupStatTB
			// ��Ϊobj[0]Ϊ��ҳ���� ���Դ�obj[1]��ʼ
			for (Object[] obj : olist) {
				CodeDetailEntity tb = new CodeDetailEntity();
				if (obj[0] != null) {
					tb.setCcid(obj[0].toString());
				}
				if (obj[1] != null) {
					tb.setCid(obj[1].toString());
				}
				if (obj[2] != null) {
					tb.setCvalue(obj[2].toString());
				}
				if (obj[3] != null) {
					tb.setPccid(obj[3].toString());
				}
				if (obj[4] != null) {
					tb.setPcid(obj[4].toString());
				}
				if (obj[5] != null) {
					tb.setUpdtime(obj[5].toString());
				}
				if (obj[6] != null) {
					tb.setSyscoding(obj[6].toString());
				}
				if (obj[7] != null) {
					tb.setPsyscoding(obj[7].toString());
				}
				if (obj[8] != null) {
					tb.setCdstatus(obj[8].toString());
				}
				if (obj[9] != null) {
					tb.setBusinesscode(obj[9].toString());
				}
				if (obj[10] != null) {
					tb.setCdinfo(obj[10].toString());
				}
				tblist.add(tb);
			}
		}
		return tblist;
	}

	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(SOC0118VWSearchCond cond, StringBuffer query) {
		if (!StringUtils.isEmpty(cond.getCcid())) {
			query.append(" and ccid='" + cond.getCcid() + "'");
		}
		if (!StringUtils.isEmpty(cond.getPcid())) {
			query.append(" and pcid='" + cond.getPcid() + "'");
		}
		if (!StringUtils.isEmpty(cond.getCdstatus())) {
			query.append(" and cdstatus='" + cond.getCdstatus() + "'");
		}
		query.append(" order by ccid,cid");
	}

	public List<TableSpaceInfo> searchTableRelationInfo(
			final SOC0118VWSearchCondImpl cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				List<TableSpaceInfo> list = null;
				query.append(session.getNamedQuery(
						"SOC0118VWDAO.searchTableRelation").getQueryString());
				if (StringUtils.isNotEmpty(cond.getBusinessName())) {
					query.append(" and f.businessName like('%"
							+ cond.getBusinessName() + "%') ");
				}
				if (StringUtils.isNotEmpty(cond.getInstanceName())) {
					query.append(" and f.instanceName like('%"
							+ cond.getInstanceName() + "%') ");
				}
				if (StringUtils.isNotEmpty(cond.getTableSpaceName())) {
					query.append(" and f.tableSpaceName like('%"
							+ cond.getTableSpaceName().toUpperCase() + "%') ");
				}
				if (StringUtils.isNotEmpty(cond.getTableName())) {
					query.append(" and f.tableName like('%"
							+ cond.getTableName().toUpperCase() + "%') ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(TableSpaceTB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();

				return list;
			}
		};
		return (List<TableSpaceInfo>) execute(action);
	}

	public Integer updateCutValue(final IGCIM1001Form igcim1001Form) {
		String sql = "select count(*) from SOC0437TB where eiid = :eiid";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("eiid", Integer.parseInt(igcim1001Form.getEiid()));
		List l = findByNamedParamMap(sql, p);
		final int count = Integer.parseInt(String.valueOf(l.get(0)));
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if (count > 0) {
					query.append("update soc0437 set cvalue='"
							+ igcim1001Form.getCvalue() + "' where eiid="
							+ igcim1001Form.getEiid() + "");
				} else {
					query.append("insert into soc0437(eiid,cvalue) values("
							+ igcim1001Form.getEiid() + ",'"
							+ igcim1001Form.getCvalue() + "')");
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(SOC0437TB.class);

				int i = q.executeUpdate();

				session.clear();

				return Integer.valueOf(i);
			}
		};
		return (Integer) execute(action);
	}

	public List<SOC0437Info> searchCutItem(final SOC0437SearchCond cond,
			final int start, final int count) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("SOC0437DAO.searchCutItem")
						.getQueryString());
				if (StringUtils.isNotEmpty(cond.getDB_eq())) {
					query.append(" and a.dbname like '%" + cond.getDB_eq()
							+ "%'");
				}
				if (StringUtils.isNotEmpty(cond.getInstance_eq())) {
					query.append(" and a.instance like '%"
							+ cond.getInstance_eq() + "%'");
				}
				if (StringUtils.isNotEmpty(cond.getTablespace_eq())) {
					query.append(" and a.tsname like '%"
							+ cond.getTablespace_eq() + "%'");
				}
				if (StringUtils.isNotEmpty(cond.getEid())) {
					query.append(" and a.eid = '" + cond.getEid() + "'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(SOC0437VW.class);

				setFetchPoint(q, start, count);

				List<SOC0437VW> list = q.list();
				session.clear();

				return list;
			}
		};
		return (List<SOC0437Info>) execute(action);
	}

	public Integer searchCutItemCount(final SOC0437SearchCond cond) {

		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				getHibernateTemplate().setCacheQueries(false);
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("SOC0437DAO.searchCutItem")
						.getQueryString());
				if (StringUtils.isNotEmpty(cond.getDB_eq())) {
					query.append(" and a.dbname like '%" + cond.getDB_eq()
							+ "%'");
				}
				if (StringUtils.isNotEmpty(cond.getInstance_eq())) {
					query.append(" and a.instance like '%"
							+ cond.getInstance_eq() + "%'");
				}
				if (StringUtils.isNotEmpty(cond.getTablespace_eq())) {
					query.append(" and a.tsname like '%"
							+ cond.getTablespace_eq() + "%'");
				}
				if (StringUtils.isNotEmpty(cond.getEid())) {
					query.append(" and a.eid = '" + cond.getEid() + "'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(SOC0437VW.class);
				List<SOC0437VW> list = q.list();
				session.clear();

				return list.size();
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ����ʲ���˵��
	 * 
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(SOC0118VWSearchCond cond) {
		String sql = "update  soc0118 set eidesc = null where eirootmark = :eirootmark and eidesc is not null";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eirootmark", cond.getEirootmark());
		return q.executeUpdate();
	}

	/**
	 * ���ָ��eiid���ʲ���˵��
	 * 
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118VWSearchCond cond) {
		String sql = "update soc0118 set eidesc = null where eiid in (:eiids)";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameterList("eiids", cond.getEiids());
		return q.executeUpdate();
	}

	/**
	 * ִ��sql
	 * 
	 * @param sql
	 * @return
	 */
	public Integer executeSQL(String sql) {

		SQLQuery q = getSession().createSQLQuery(sql);

		return q.executeUpdate();
	}

	/**
	 * ��������
	 * 
	 * @param soc0118List
	 * @throws Exception
	 */
	public void saveEntityItems(List<SOC0118VW> soc0118List) throws Exception {

		Session session = getSessionFactory().openSession();
		try {
			Transaction tx = session.beginTransaction();
			Connection conn = session.connection();
			String sql = "insert into SOC0118VW ( " + "eid, " + "eidesc, "
					+ "eiinsdate, " + "eilabel, " + "einame, "
					+ "eiorgsyscoding, " + "eirootmark, " + "eismallversion, "
					+ "eistatus, " + "eiupdtime, " + "eiuserid, "
					+ "eiusername, " + "eiversion, " + "esyscoding,"
					+ "fingerPrint) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			for (int j = 0; j < soc0118List.size(); j++) {
				SOC0118VW soc0118 = soc0118List.get(j);
				stmt.setString(1, soc0118.getEid());
				stmt.setString(2, soc0118.getEidesc());
				stmt.setString(3, soc0118.getEiinsdate());
				stmt.setString(4, soc0118.getEilabel());
				stmt.setString(5, soc0118.getEiname());
				stmt.setString(6, soc0118.getEiorgsyscoding());
				if (soc0118.getEirootmark() == null) {
					stmt.setNull(7, Types.NULL);
				} else {
					stmt.setInt(7, soc0118.getEirootmark());
				}
				stmt.setInt(8, soc0118.getEismallversion());
				stmt.setString(9, soc0118.getEistatus());
				stmt.setString(10, soc0118.getEiupdtime());
				stmt.setString(11, soc0118.getEiuserid());
				stmt.setString(12, soc0118.getEiusername());
				stmt.setInt(13, Integer.parseInt(soc0118.getEiversion()));
				stmt.setString(14, soc0118.getEsyscoding());
				stmt.setString(15, soc0118.getFingerPrint());

				stmt.executeUpdate();

			}
			tx.commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}

	}

	/**
	 * ��ѯ�����豸��¼����
	 * 
	 * @param cond
	 *            ��������
	 * @return �������count
	 */
	public int getNetDeviceCount(final NetDeviceSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				Integer count = null;
				query.append("select ei.eiid as eiid,ei.eilabel as eilabel,ci.civalue as civalue,ei.eiupdtime as eiupdtime,'' as fingerprint "
						+ "from soc0118 ei,soc0107 ci "
						+ "where ei.esyscoding='999001028005' and ci.cid='CI010100490002' and ei.eiid=ci.eiid and ei.eiversion=ci.civersion and ei.eismallversion=ci.cismallversion "
						+ "and ei.eilabel like '%"
						+ cond.getEilabel_lk_ip()
						+ "%' "
						+ "and ei.eilabel like '%"
						+ cond.getEilabel_lk_devname() + "%' ");
				if (StringUtils.isNotEmpty(cond.getCivalue_eq())) {
					query.append("and ci.civalue = '" + cond.getCivalue_eq()
							+ "'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(NetDeviceTB.class);
				// setFetchPoint(q, start, count);
				count = q.list().size();
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * ��ѯ�����豸��¼����
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<NetDeviceInfo> searchNetDeviceListByCond(
			final NetDeviceSearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<NetDeviceInfo> list = null;
				query.append("select ei.eiid as eiid,ei.eilabel as eilabel,ci.civalue as civalue,ei.eiupdtime as eiupdtime,'' as fingerprint "
						+ "from soc0118 ei,soc0107 ci "
						+ "where ei.esyscoding='999001028005' and ci.cid='CI010100490002' and ei.eiid=ci.eiid and ei.eiversion=ci.civersion and ei.eismallversion=ci.cismallversion "
						+ "and ei.eilabel like '%"
						+ cond.getEilabel_lk_ip()
						+ "%' "
						+ "and ei.eilabel like '%"
						+ cond.getEilabel_lk_devname() + "%' ");
				if (StringUtils.isNotEmpty(cond.getCivalue_eq())) {
					query.append("and ci.civalue = '" + cond.getCivalue_eq()
							+ "'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				// q.setProperties(cond);
				q.addEntity(NetDeviceTB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<NetDeviceInfo>) execute(action);
	}

	/**
	 * ɾ��eiid��eirootmark�� ������Χ�ڵ��ʲ�
	 * 
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids) {
		String sql = "delete from soc0118 where eiid in (:eiids) or eirootmark in(:eiids)";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameterList("eiids", eiids);
		return q.executeUpdate();
	}

	/**
	 * ��ȡ������Ϣ ����һ���ԶԱ� �� ����ҵ��ϵͳ ��ѯ����ʱ ʹ��
	 * 
	 * @param cond
	 * @return
	 */
	public List<Map<String, String>> searchHostList(SOC0118VWSearchCond cond) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		StringBuffer sql = new StringBuffer();
		Session session = getSession();
		sql.append(session.getNamedQuery("SOC0118VW.searchHost")
				.getQueryString());

		if (StringUtils.isNotEmpty(cond.getEiid())) {
			sql.append(" and t.eiid = '" + cond.getEiid() + "'");
		}
		// ����ҵ��ϵͳid ��ѯ������ص���������
		if (cond.getSystemId() != null && cond.getSystemId() > 0) {
			sql.append(" and t.eiid in ("
					+ "select eirootmark from soc0118 where eiid in ("
					+ "select cldeiid from soc0119 where pareiid = '"
					+ cond.getSystemId() + "'))");
		}

		if (StringUtils.isNotEmpty(cond.getEnvironmentType())) {
			sql.append(" and t.hj = (select ccdvalue from soc0151 where ccdid = "
					+ cond.getEnvironmentType() + ")");
		}
		if (cond.isClumped()) {
			sql.append(" and (t.sjkjq = '��' or t.fwqjq='��' or t.qtjq='��')");
		}

		List<Object[]> list = session.createSQLQuery(sql.toString()).list();
		for (Object[] arrObj : list) {
			Map<String, String> entity = new HashMap<String, String>();
			entity.put("eiid", arrObj[0].toString());
			entity.put("einame", arrObj[1].toString());
			entity.put("ip", arrObj[2].toString());

			result.add(entity);
		}
		return result;
	}

	public void deleteEntityItemByEilabel(String eilabel) {
		String sql = "delete from soc0118 where eilabel =:eilabel";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eilabel", eilabel);
		q.executeUpdate();
	}

	public int getEntityItemSearchCountByHost(final SOC0118VWSearchCondImpl cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				Integer count = null;
				query.append("select count(*) from soc0118 a left join soc0145 b on (a.eiid=b.eiid and a.eiversion=b.eiversion and a.eismallversion=b.eismallversion and b.cid='CI010100010071') where 1=1");
				if (StringUtils.isNotEmpty(cond.getEsyscoding_eq())) {
					query.append(" and a.esyscoding like '"
							+ cond.getEsyscoding_eq() + "%'");
				}
				if (StringUtils.isNotEmpty(cond.getEiname())) {
					query.append(" and a.einame like '%" + cond.getEiname()
							+ "%'");
				}
				if (cond.getEirootmark() != null) {
					query.append(" and a.eirootmark=" + cond.getEirootmark());
				}
				if (StringUtils.isNotEmpty(cond.getEiupdtime_from())) {
					query.append(" and a.eiupdtime>='"
							+ cond.getEiupdtime_from() + "'");
				}
				if (StringUtils.isNotEmpty(cond.getEiupdtime_to())) {
					query.append(" and a.eiupdtime<='" + cond.getEiupdtime_to()
							+ "'");
				}
				if (StringUtils.isNotEmpty(cond.getEitype())) {
					query.append(" and a.fingerprint='" + cond.getEitype()
							+ "'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				count = q.list().size();
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	public List<SOC0118VWInfo> searchEntityItemByHost(
			final SOC0118VWSearchCondImpl cond, final int fromCount,
			final int pageDispCount) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118VWInfo> list = null;
				query.append("select a.eiid,a.eid,b.civalue as eidesc,a.einame,a.eilabel,a.eiinsdate,a.eiorgsyscoding,a.esyscoding,");
				query.append("a.eiupdtime,a.eistatus,a.eiversion,a.eiuserid,a.eiusername,a.eismallversion,a.eirootmark,a.fingerprint");
				query.append(" from soc0118 a left join soc0145 b on (a.eiid=b.eiid and a.eiversion=b.eiversion and a.eismallversion=b.eismallversion and b.cid='CI010100010071') where 1=1");
				if (StringUtils.isNotEmpty(cond.getEsyscoding_eq())) {
					query.append(" and a.esyscoding like '"
							+ cond.getEsyscoding_eq() + "%'");
				}
				if (StringUtils.isNotEmpty(cond.getEiname())) {
					query.append(" and a.einame like '%" + cond.getEiname()
							+ "%'");
				}
				if (cond.getEirootmark() != null) {
					query.append(" and a.eirootmark=" + cond.getEirootmark());
				}
				if (StringUtils.isNotEmpty(cond.getEiupdtime_from())) {
					query.append(" and a.eiupdtime>='"
							+ cond.getEiupdtime_from() + "'");
				}
				if (StringUtils.isNotEmpty(cond.getEiupdtime_to())) {
					query.append(" and a.eiupdtime<='" + cond.getEiupdtime_to()
							+ "'");
				}
				if (StringUtils.isNotEmpty(cond.getEitype())) {
					query.append(" and b.civalue='" + cond.getEitype() + "'");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0118VW.class);
				setFetchPoint(q, fromCount, pageDispCount);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0118VWInfo>) execute(action);
	}

	/**
	 * ��ѯ���տ�ֲ����
	 * 
	 * @return map
	 *         key:{riskcont:���յ�����,riskesyscoding:���յ�����(6λ),inspectcont:�����,
	 *         inspectesyscoding:���������(6λ),����}
	 */
	public List<Map> getRiskRepository() {

		Session session = getSession();
		String sql = session.getNamedQuery("SOC0118VWDAO.getRiskRepository")
				.getQueryString();
		// String sql =
		// "select t1.riskcont,t1.riskesyscoding ,t2.inspectcont,t2.inspectesyscoding,t2.ename from(  select a.*,b.ename from (select count(a.eid) as riskcont,substr(a.esyscoding,1,9) as riskesyscoding "
		// +"	from soc0118 a "
		// +"		where substr(a.esyscoding,1,6)= '999017'  "
		// +"		group by substr(a.esyscoding,1,9) )a "
		// +"	left join soc0117 b on  a.riskesyscoding = b.esyscoding) t1 "
		// +" left join "
		// +"	( select a.*,b.ename from (select count(a.eid) as inspectcont,substr(a.esyscoding,1,9) as inspectesyscoding "
		// +"	from soc0118 a "
		// +"		where substr(a.esyscoding,1,6)= '999018' "
		// +"		group by substr(a.esyscoding,1,9) )a "
		// +"	left join soc0117 b on  a.inspectesyscoding = b.esyscoding) t2 on t1.ename = t2.ename";
		SQLQuery q = session.createSQLQuery(sql);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("riskcont", Hibernate.STRING);
		q.addScalar("riskesyscoding", Hibernate.STRING);
		q.addScalar("inspectcont", Hibernate.STRING);
		q.addScalar("inspectesyscoding", Hibernate.STRING);
		q.addScalar("ename", Hibernate.STRING);

		// q.list();
		return q.list();
	}

	/**
	 * ��ѯӦ����Դ�������ʲ�����
	 * 
	 * @return List<SOC0118VWInfo>
	 */
	public List<SOC0118VWInfo> getEmergencyRelationList(
			SOC0118VWSearchCond cond, final int start, final int count) {

		Session session = getSession();
		String sql = "select 	vw.id,	vw.eiid,	vw.eid,	vw.eidesc,	vw.einame,	vw.eilabel,	vw.eiinsdate,	vw.eiorgsyscoding,	vw.esyscoding,	vw.eiupdtime,	vw.eistatus,	vw.eiversion,	vw.eiuserid,	vw.eiusername,	vw.eismallversion,	vw.eirootmark,	err.ercode||'_'||(select ername from EMERGENCYRESOURCE where ercode = err.ercode) as fingerprint "
				+ "from errelation err	left join soc0118vw vw	on err.eiid = vw.id||'_'||vw.eiid	where err.deleteflag <> 1 ";
		if (StringUtils.isNotEmpty(cond.getEsyscoding_like()))
			sql = sql + " and err.ercode like '%" + cond.getEsyscoding_like()
					+ "%' ";
		if (StringUtils.isNotEmpty(cond.getEiname()))
			sql = sql + " and vw.einame like '%" + cond.getEiname() + "%' ";
		if (StringUtils.isNotEmpty(cond.getEiusername()))
			sql = sql + " and vw.eiusername like '%" + cond.getEiusername()
					+ "%' ";
		if (StringUtils.isNotEmpty(cond.getEiinsdate_lt()))
			sql = sql + " and vw.eiinsdate <= '" + cond.getEiinsdate_lt()
					+ "' ";
		if (StringUtils.isNotEmpty(cond.getEiinsdate_gt()))
			sql = sql + " and vw.eiinsdate >= '" + cond.getEiinsdate_gt()
					+ "' ";
		if (StringUtils.isNotEmpty(cond.getEiidNotIn()))
			sql = sql + " and err.eiid not in ('"
					+ cond.getEiidNotIn().replaceAll(",", "\',\'") + "') ";
		sql = sql + " order by err.ercode ";
		SQLQuery q = session.createSQLQuery(sql);
		q.addEntity(SOC0118VW.class);
		setFetchPoint(q, start, count);
		List<SOC0118VWInfo> list = null;
		list = q.list();
		session.clear();
		return list;
	}

	/**
	 * ��ѯӦ����Դ�������ʲ�����
	 * 
	 * @return List<SOC0118VWInfo>
	 */
	public Integer getEmergencyRelationCount(SOC0118VWSearchCond cond) {

		Session session = getSession();
		String sql = "select count(err.errid) from errelation err	left join soc0118vw vw	on err.eiid = vw.id||'_'||vw.eiid	where err.deleteflag <> 1";
		if (StringUtils.isNotEmpty(cond.getEsyscoding_like()))
			sql = sql + " and err.ercode like '%" + cond.getEsyscoding_like()
					+ "%' ";
		if (StringUtils.isNotEmpty(cond.getEiname()))
			sql = sql + " and vw.einame like '%" + cond.getEiname() + "%' ";
		if (StringUtils.isNotEmpty(cond.getEiusername()))
			sql = sql + " and vw.eiusername like '%" + cond.getEiusername()
					+ "%' ";
		if (StringUtils.isNotEmpty(cond.getEiinsdate_lt()))
			sql = sql + " and vw.eiinsdate <= '" + cond.getEiinsdate_lt()
					+ "' ";
		if (StringUtils.isNotEmpty(cond.getEiinsdate_gt()))
			sql = sql + " and vw.eiinsdate >= '" + cond.getEiinsdate_gt()
					+ "' ";
		if (StringUtils.isNotEmpty(cond.getEiidNotIn()))
			sql = sql + " and err.eiid not in ('"
					+ cond.getEiidNotIn().replaceAll(",", "\',\'") + "') ";
		SQLQuery q = session.createSQLQuery(sql);
		Integer count = (Integer) q.list().get(0);
		session.clear();
		return count;
	}
}
