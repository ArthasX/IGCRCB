/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC0208VW;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/**
  * ����: ���ɸ澯��DAOʵ��
  * ��������: ���ɸ澯��DAOʵ��
  * ������¼: 2014/06/21
  * �޸ļ�¼: 2014/07/09
  * 				����ȡ����String��������ת����Int����
  */
public class IgalarmDAOImpl extends
		BaseHibernateDAOImpl<IgalarmInfo> implements IgalarmDAO {

	/**
	 * ���캯��
	 */
	public IgalarmDAOImpl(){
		super(IgalarmTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgalarmInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgalarmInfo findByPK(Serializable pk) {
		IgalarmInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IgalarmSearchCond cond){
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
	public List<IgalarmInfo> findByCond(final IgalarmSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("pk"));
		c.addOrder(Order.desc("lasttime"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IgalarmSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���(��ȫƥ��)
		if(StringUtils.isNotEmpty(cond.getSerial())){
			c.add(Restrictions.eq("serial", cond.getSerial()));
		}
		if(StringUtils.isNotEmpty(cond.getStartDate())){
			c.add(Restrictions.gt("lasttime", cond.getStartDate()));
		}
		if(StringUtils.isNotEmpty(cond.getEndDate())){
			c.add(Restrictions.lt("lasttime", cond.getEndDate()));
		}
		if(StringUtils.isNotEmpty(cond.getAppname())){
			c.add(Restrictions.like("appname", String.format("%%%s%%", cond.getAppname())));
		}
		if(StringUtils.isNotEmpty(cond.getSummary())){
			c.add(Restrictions.like("summary", String.format("%%%s%%",  cond.getSummary())));
		}
		if(StringUtils.isNotEmpty(cond.getStatus())){
			// ��ѯ�澯��ϸʱ��ѯȫ��״̬
			if("C".equals(cond.getStatus())){
			
			//Ϊ�˱���������"StringUtils.isEmpty(cond.getStatus())"���߼�(ͬʱ����������"C"����)  by wangxing 2015/11/17 16:44 
			}else if("ALL".equals(cond.getStatus())){
				
			}else{
				c.add(Restrictions.eq("status", cond.getStatus()));
			}
		}
		// ���״̬Ϊ�գ�Ĭ�ϲ���ʾ�ر�״̬��
		if(StringUtils.isEmpty(cond.getStatus())){
			c.add(Restrictions.ne("status", "2"));
		}
		//����������ת����
		if(cond.getAlarmIds() != null && cond.getAlarmIds().length > 0){
			Integer[] a = new Integer[cond.getAlarmIds().length];
			for(int i=0;i<a.length;i++){
			a[i] =  Integer.parseInt(cond.getAlarmIds()[i]);
			c.add(Restrictions.in("pk", a));
			}
		}
		// ����/�ָ�ʱ��
		if(StringUtils.isNotEmpty(cond.getLasttime())){
			c.add(Restrictions.eq("lasttime", cond.getLasttime()));
		}
		// �Ƿ���ʾ��ʶ(0��ʾ��1����ʾ)
		if(StringUtils.isNotEmpty(cond.getIsShow())){
			c.add(Restrictions.eq("isShow", cond.getIsShow()));
		}
		// �¼������
		if(StringUtils.isNotEmpty(cond.getPedeventid())){
			c.add(Restrictions.eq("pedeventid", cond.getPedeventid()));
		}
		if(StringUtils.isNotEmpty(cond.getIpaddr())){
			c.add(Restrictions.eq("ipaddr", cond.getIpaddr()));
		}
		if(StringUtils.isNotEmpty(cond.getShieldflag())){
			c.add(Restrictions.eq("shieldflag", cond.getShieldflag()));
		}
		
		/** 2016/10/14�޸�   ���ܣ��������������߽���(1.�����¼�/�ָ��¼� 2.ip��ַ 3.��������)    gongyunpeng */
		//��������(1Ϊ���� 2Ϊ����)
		if(StringUtils.isNotEmpty(cond.getAppnamestatus())){
			if("1".equals(cond.getAppnamestatus())){
				c.addOrder(Order.desc("appname"));
			}else{
				c.addOrder(Order.asc("appname"));
			}
		}
		//ip��ַ(1Ϊ���� 2Ϊ����)
		if(StringUtils.isNotEmpty(cond.getIpaddrstatus())){
			if("1".equals(cond.getIpaddrstatus())){
				c.addOrder(Order.desc("ipaddr"));
			}else{
				c.addOrder(Order.asc("ipaddr"));
			}		
		}
		//����ʱ��(1Ϊ���� 2Ϊ����)
		if(StringUtils.isNotEmpty(cond.getLasttimestatus())){
			if( "1".equals(cond.getLasttimestatus())){
				c.addOrder(Order.desc("lasttime"));
			}else{
				c.addOrder(Order.asc("lasttime"));
			}
		}
		//�ָ��¼�(1Ϊ���� 2Ϊ����)
		if(StringUtils.isNotEmpty(cond.getRecoverytimestatus())){
			if( "1".equals(cond.getRecoverytimestatus())){
				c.addOrder(Order.desc("recoveryTime"));
			}else{
				c.addOrder(Order.asc("recoveryTime"));
			}
		}
				
		return c;
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<IGCRC0208VWInfo> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryAlarmEvent").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				if(StringUtils.isNotEmpty(cond.getOrder())){
					query.append(" order by pr.").append(cond.getOrder()).append("  ").append(cond.getSing());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IGCRC0208VW",IGCRC0208VW.class);
				setFetchPoint(q, start, count);
				List<IGCRC0208VWInfo> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IGCRC0208VWInfo>) execute(action);
	}
	
	private void getProcessInfoSQL(IG500SearchCond cond,StringBuffer query){
		if(cond.getVarnames()!=null&&cond.getVarvalues()!=null){
			StringBuffer addSql = new StringBuffer();
			for(int i=0;i<cond.getVarnames().length;i++){
				if(StringUtils.isNotEmpty(cond.getVarvalues()[i])){
					if(cond.getVarvalues()[i].indexOf("_time_") >= 0){
						String[] infos = cond.getVarvalues()[i].split("_time_",2);
						String vs1 = infos[0];
						String vs2 = null;
						if(infos.length > 1){
							vs2 = infos[1];
						}
						addSql.append(" inner join ig599 pi").append(i).append(" on pi").append(i).append(".prid = pr.prid and pi").append(i).append(".pivarname = '").append(cond.getVarnames()[i]).append("' ");
						if(StringUtils.isNotEmpty(vs1)){
							addSql.append(" and pi").append(i).append(".pivarvalue >= '").append(vs1).append("' ");
						}
						if(StringUtils.isNotEmpty(vs2)){
							addSql.append(" and pi").append(i).append(".pivarvalue <= '").append(vs2).append("' ");
						}
					}else{
						String varvalue = cond.getVarvalues()[i];
						// ���α�֧�ָ��ڵ�ģ����ѯ
						if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_tree_")){
							varvalue = varvalue.split("_tree_")[0];
						}
						addSql.append(" inner join ig599 pi").append(i).append(" on pi").append(i).append(".prid = pr.prid and pi").append(i).append(".pivarname = '").append(cond.getVarnames()[i]).append("' and pi").append(i).append(".pivarvalue like '%").append(varvalue).append("%' ");
					}
				}
			}
			if(cond.getVarnames_in()!=null && cond.getVarvalues_in()!=null){
				for(int i=0;i<cond.getVarnames_in().length;i++){
					if(StringUtils.isNotEmpty(cond.getVarvalues_in()[i])){
						String varvalue_in = cond.getVarvalues_in()[i];
						addSql.append(" inner join ig599 pm").append(i).append(" on pm").append(i).append(".prid = pr.prid and pm").append(i).append(".pivarname in (").append(cond.getVarnames_in()[i]).append(") and pm").append(i).append(".pivarvalue in (").append(varvalue_in).append(") ");
					}
				}
			}
			if(StringUtils.isNotEmpty(addSql.toString())){
				query.append(" ").append(addSql.toString());
			}
		}
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param query sql
	 * @return �����ü���������
	 */
	protected void getSQL(IG500SearchCond cond, StringBuffer query){
		if( !StringUtils.isEmpty(cond.getPrtitle())){
			query.append(" AND pr.prtitle like ('%'||:prtitle||'%') ");
		}
		if( !StringUtils.isEmpty(cond.getPrserialnum())){
			query.append(" AND pr.prserialnum like ('%'||:prserialnum||'%') ");
		}
		if( !StringUtils.isEmpty(cond.getPrusername())){
			query.append(" AND pr.prusername like ('%'||:prusername||'%') ");
		}
		if(cond.getPrtypes()!=null&&cond.getPrtypes().length>0){
            String appendSQL= " AND pr.prtype IN (";
            for(String str:cond.getPrtypes()){
                appendSQL+="'"+str+"',";
            }
            appendSQL = appendSQL.substring(0,appendSQL.length()-1);
            appendSQL +=" )";
            query.append(appendSQL);
        }
		//��ѯһ����������id
        if(cond.getPrpdid_like_or() != null && cond.getPrpdid_like_or().length > 0){
            String[] prpdid_like_or = cond.getPrpdid_like_or();
            query.append(" AND ( ");
            for (int i = 0; i < prpdid_like_or.length; i++) {
                query.append(" prpdid like '").append(prpdid_like_or[i]).append("%' ");
                if(i < prpdid_like_or.length - 1){
                    query.append(" or ");
                }
            }
            query.append(" ) ");
        }
		// ��ѯ����ʱ����ѯָ���û��Ƿ���������
		if( !StringUtils.isEmpty(cond.getPpusername_like())){
			query.append(" AND exists (select 1 from ig337 pp where pr.prid = pp.prid and pp.ppusername like ('%'||:ppusername_like||'%') ) ");
		}
		// ��ѯ����ʱ����ѯָ���û��Ƿ���������
		if( !StringUtils.isEmpty(cond.getPpuserid())){
			query.append(" AND exists (select 1 from ig337 pp where pr.prid = pp.prid and pp.ppuserid = :ppuserid ");
			if(!StringUtils.isEmpty(cond.getPpstatus())){
				query.append(" and ppstatus like :ppstatus ");
			}
			// ��ѯ�����ǣ���ѯ�ƶ��û��Ƿ��Ѿ�ȷ��
			if(StringUtils.isNotBlank(cond.getPpbacktime_isNull())){
				if("0".equals(cond.getPpbacktime_isNull())){
					query.append("and pp.ppbacktime is not null) ");
				}else if("1".equals(cond.getPpbacktime_isNull())){
					query.append("and pp.ppbacktime is null) ");
				}				
			}else{
				query.append("and ppproctime is not null) ");
			}
		}
		if( !StringUtils.isEmpty(cond.getPrstatus())){
			query.append(" AND pr.prstatus = :prstatus");
		}
		if( !StringUtils.isEmpty(cond.getPrurgency())){
			query.append(" AND pr.prurgency = :prurgency");
		}
		if( !StringUtils.isEmpty(cond.getPropentime())){
			query.append(" AND pr.propentime >= :propentime");
		}
		if( !StringUtils.isEmpty(cond.getPrclosetime())){
			if(cond.getPrclosetime().length() == 10) {
				query.append(" AND pr.propentime <= (:prclosetime ||' 23:59')");
			} else {
				query.append(" AND pr.propentime <= :prclosetime");
			}
		}
		//�������ݲ�ѯ
		if( !StringUtils.isEmpty(cond.getPrdesc())){
			query.append(" AND pr.prdesc like ('%'||:prdesc||'%')");
		}
		//������Դ
		if( !StringUtils.isEmpty(cond.getPrassetname())){
		    query.append(" AND pr.prassetname = :prassetname");
		}

		//��������ID
		if(StringUtils.isNotEmpty(cond.getPrpdid())){
			query.append(" AND pr.prpdid like (:prpdid||'%')");
		}
		//���̼�¼����
		if(StringUtils.isNotEmpty(cond.getPrtype())){
			//���Թ�����ѯ��
			if("W".equals(cond.getPrtype())) {
				query.append(" AND pr.prtype = 'WD'");
				query.append(" AND pr.prassetcategory = '1'");
			} else {
				query.append(" AND pr.prtype = :prtype");
			}
		}
		if(StringUtils.isNotEmpty(cond.getProrgid_like())){
			query.append(" AND pr.prorgid like (:prorgid_like||'%') ");
		}
		if(cond.getPrroleid()!=null&&cond.getPrroleid()>0){
			query.append(" and pr.prroleid = :prroleid ");
		}
		if(StringUtils.isNotEmpty(cond.getProrgid_in())){
			query.append(" AND prorgid IN ('").append(cond.getProrgid_in()).append("')");
		}
		if(StringUtils.isNotEmpty(cond.getPrid_in())){
			query.append(" AND prid IN (").append(cond.getPrid_in()).append(")");
		}
		if(StringUtils.isNotEmpty(cond.getPdactname())){
			query.append(" and pd.pdactname = :pdactname ");
		}
		if(cond.getPrroleid_in() != null && cond.getPrroleid_in().size() > 0){
			query.append(" and pr.prroleid in (");
			for(int i=0;i<cond.getPrroleid_in().size();i++){
				if(i > 0){
					query.append(",");
				}
				query.append(cond.getPrroleid_in().get(i));
			}
			query.append(") ");
		}
		if(cond.getPrroleid_not_in() != null && cond.getPrroleid_not_in().size() > 0){
			query.append(" and pr.prroleid not in (");
			for(int i=0;i<cond.getPrroleid_not_in().size();i++){
				if(i > 0){
					query.append(",");
				}
				query.append(cond.getPrroleid_not_in().get(i));
			}
			query.append(") ");
		}
		
		//δ�ر�����
		if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("Y")){
			query.append(" AND pr.prstatus != 'C'");
		}
		
		if(StringUtils.isNotEmpty(cond.getPropentime_like())){
			query.append(" and pr.propentime like :propentime_like || '%'");
		}
		
		if(StringUtils.isNotEmpty(cond.getPrclosetime_like())){
			query.append(" and pr.prclosetime like :prclosetime_like || '%' ");
		}
		
		if(StringUtils.isNotEmpty(cond.getContent())){
			query.append(" and (");
			query.append(" pr.prtitle like '%' || :content || '%' ");
			query.append(" or pr.prdesc like '%' || :content || '%' ");
			query.append(" or exists (select 1 from ig599 ti where pr.prid = ti.prid and ti.pivarvalue like '%' || :content || '%' )");
			query.append(")");
		}
		if(StringUtils.isNotEmpty(cond.getPrstatus_ne())){
			query.append(" and pr.prstatus <> :prstatus_ne ");
		}
		//�Ƿ�Ϊ�澯�¼�
		if(StringUtils.isNotBlank(cond.getAlarm_Is())){
			if("1".equals(cond.getAlarm_Is())){
				query.append(" and exists (select 1 from ig599 pp where pp.prid = pr.prid and pp.pivarname like '�¼���Դ' and pp.pivarvalue like '��ظ澯') ");
			}else if("0".equals(cond.getAlarm_Is())){
				query.append(" and exists (select 1 from ig599 pp where pp.prid = pr.prid and pp.pivarname like '�¼���Դ' and pp.pivarvalue  not like '��ظ澯') ");
			}
		}
		
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG500DAO.queryAlarmEventCount").getQueryString());
				getProcessInfoSQL(cond,query);
				query.append(" where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}
	
	/**
	 * ������������(û��Ĭ������)
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgalarmInfo> findByCondNoSort(final IgalarmSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
}