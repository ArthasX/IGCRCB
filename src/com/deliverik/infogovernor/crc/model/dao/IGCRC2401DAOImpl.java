package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2401VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;

/**
 * 
 * ���ܣ�
 */
public class IGCRC2401DAOImpl extends BaseHibernateDAOImpl<IGCRC2401VW>
		implements IGCRC2401DAO {


	/**
	 * ���캯��
	 */
	public IGCRC2401DAOImpl() {
		super(IGCRC2401VW.class);
	}

	/**
	 * ƽ������¼�ʱ��
	 * 
	 * �¼����ʱ��
	 * @param cond
	 *            ��������
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<IGCRC2401VW> getFindStatistics(final IGCRC2401Cond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				if("1".equals(cond.getSign())){
				//�¼�
				query.append(session.getNamedQuery(
						"EntityItemIGCRC2401VWDAO.getDept").getQueryString());
				}else{
				//�澯
					query.append(session.getNamedQuery(
							"EntityItemIGCRC2401VWDAO.getDeptForWarn").getQueryString());
				}
				// ��� �� �� ��ѯ����

				// ƴ�Ӳ�ѯ����
				getSql(query, cond);
				// ��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);
				q.addEntity(IGCRC2401VW.class);
				List<IGCRC2401VWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2401VW>) execute(action);
	}

	/**
	 * ���ܣ�������������
	 *     
	 * @param query
	 * @param cond
	 *            �޸ļ�¼��null
	 */
	private void getSql(StringBuffer query, IGCRC2401Cond cond) {
		// ����
		query.append(" and a.ppproctime is not null and a.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
		// ����
		if (StringUtils.isNotEmpty(cond.getDept())) {
			query.append(" and  ppuserid in (select userid from iguser where orgid = '"
					+ cond.getDept() + "')");
		} else {
			query.append(" and 1=2");
		}
		//���밴��a.ppuserid����,��ǰ̨�㷨��Ҫ
		query.append(" group by a.prid ,a.ppid,a.ppusername ,a.ppuserid,a.ppinittime,a.ppproctime,a.ppbacktime,b.pivarvalue order by a.ppuserid");
	}
	/**
	 * ƽ������¼�ʱ��
	 *  ��ʼʱ��-----ȷ��ʱ��
	 *    
	 * @param cond
	 *            ��������
	 *            zhangq@deliverik.com
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public List<IGCRC2401VW> getFindStatisticsConfirm(final IGCRC2401Cond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if("1".equals(cond.getSign())){
					//�¼�
					query.append(session.getNamedQuery(
							"EntityItemIGCRC2401VWDAO.getDept").getQueryString());
					}else{
					//�澯
						query.append(session.getNamedQuery(
								"EntityItemIGCRC2401VWDAO.getDeptForWarn").getQueryString());
					}
				// ��� �� �� ��ѯ����

				// ƴ�Ӳ�ѯ����
				getSqlConfirm(query, cond);
				// ��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);
				q.addEntity(IGCRC2401VW.class);
				List<IGCRC2401VWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<IGCRC2401VW>) execute(action);
	}

	/**
	 * ���ܣ�������������
	
	 *            �޸ļ�¼��zhangqiang
	 *            
	 *            ��������  ȷ��ʱ��
	 *              zhangq@deliverik.com
	 */
	private void getSqlConfirm(StringBuffer query, IGCRC2401Cond cond) {
		// ����
		query.append(" and a.ppbacktime is not null  and a.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
		// ����
		if (StringUtils.isNotEmpty(cond.getDept())) {
			query.append(" and  ppuserid in (select userid from iguser where orgid = '"
					+ cond.getDept() + "')");
		} else {
			query.append(" and 1=2");
		}
		//���밴��a.ppuserid����,��ǰ̨�㷨��Ҫ
		query.append(" group by a.prid ,a.ppid,a.ppusername ,a.ppuserid,a.ppinittime,a.ppproctime,a.ppbacktime,b.pivarvalue order by a.ppuserid");
	}
}
