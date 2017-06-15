package com.deliverik.framework.soc.asset.model.dao;

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
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0607VW;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * �ʲ����ϵ��ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0119DAOImpl extends BaseHibernateDAOImpl<SOC0119Info> implements SOC0119DAO {

	/**
	 * ���캯��
	 */
	public SOC0119DAOImpl(){
		super(SOC0119TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	@Override
	public List<SOC0119Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eirid"));
		List<SOC0119Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eirid ����
	 * @return �������
	 */
	@Override
	public SOC0119Info findByPK(Serializable eirid) {

		SOC0119Info entityitemrelation = super.findByPK(eirid);
		if(entityitemrelation == null) return null;

		return entityitemrelation;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0119SearchCond cond){
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
	public List<SOC0119Info> findByCond(final SOC0119SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eirrelation"));
		c.addOrder(Order.asc("pareiid"));
		List<SOC0119Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0119SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//ͨ���ʲ�ID��������������������ʲ��Ĺ�����ϵ
		if( !StringUtils.isEmpty(cond.getEiid())){
			c.add(Expression.or(
					Expression.eq("pareiid", Integer.parseInt(cond.getEiid())),
					Expression.eq("cldeiid", Integer.parseInt(cond.getEiid()))));
		}	

		//ͨ���ʲ�ID������������������ʲ��Ĺ�����ϵ��
		if(cond.getPareiid()!=null){
			c.add(Expression.eq("pareiid", cond.getPareiid()));
		}	
		//ͨ���ʲ�ID�ӷ���������������ʲ��Ĺ�����ϵ
		if( cond.getCldeiid()!=null){
			c.add(Expression.eq("cldeiid", cond.getCldeiid()));
		}
		//�ʲ����ϵ
		if( !StringUtils.isEmpty(cond.getEirrelation())){
			if((CommonDefineUtils.MODULE_RELATION_ENTIY_ID+"#"+CommonDefineUtils.MODULE_RELATION_MODULE_ID).equals(cond.getEirrelation())){
				c.add(Expression.or(Expression.eq("eirrelation", CommonDefineUtils.MODULE_RELATION_ENTIY_ID), Expression.eq("eirrelation", CommonDefineUtils.MODULE_RELATION_MODULE_ID)));
			}else{
				c.add(Expression.eq("eirrelation", cond.getEirrelation()));
			}
		}
		//�ʲ���״̬
		if( !StringUtils.isEmpty(cond.getEirstatus())){
			c.add(Expression.eq("eirstatus", cond.getEirstatus()));
		}
		//�ʲ���ϵ��
		if(!StringUtils.isEmpty(cond.getEirrelationcode())){
			c.add(Expression.eq("eirrelationcode", cond.getEirrelationcode()));
		}
		//�ʲ����ϵ˵��
		if( !StringUtils.isEmpty(cond.getEirdesc())){
			c.add(Expression.like("eirdesc", "%"+cond.getEirdesc()+"%"));
		}
		//ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
		if( !StringUtils.isEmpty(cond.getEirinfo())){
			c.add(Expression.like("eirinfo", "%" + cond.getEirinfo() + "%"));
		}
		//�����ʲ���汾
		if(cond.getParversion()!=null){
			c.add(Expression.eq("parversion", cond.getParversion()));
		}
		//�����ʲ�С�汾
		if( cond.getParsmallversion()!=null){
			c.add(Expression.eq("parsmallversion", cond.getParsmallversion()));
		}
		//�����ʲ���汾
		if( cond.getCldversion()!=null){
			c.add(Expression.eq("cldversion", cond.getCldversion()));
		}
		//�����ʲ�С�汾
		if( cond.getCldsmallversion()!=null){
			c.add(Expression.eq("cldsmallversion", cond.getCldsmallversion()));
		}
		//�߼�ɾ����ʶ
		if( !StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		if( cond !=null){
			if(cond.getEirrelation_in()!=null){
				if(cond.getEirrelation_in().length>0){
					c.add(Expression.in("eirrelation", cond.getEirrelation_in()));
				}
			}
		}
		return c;
	}
	
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0119Info> searchMaxEntityItemRelation(final SOC0119SearchCond cond) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list = null;
				query.append(session.getNamedQuery("EntityItemRelationDAO.searchMaxEntityItemRelationVW1").getQueryString());
				if(cond.getPareiid()!=null) {
					query.append(" AND a.pareiid="+cond.getPareiid());
					query.append(" AND a.parversion ="+cond.getParversion());
					query.append(" AND a.parsmallversion ="+cond.getParsmallversion());
					if(StringUtils.isNotEmpty(cond.getEirrelation())){
						query.append(" AND a.eirrelation ='"+cond.getEirrelation()+"'");
					}
					if(StringUtils.isNotEmpty(cond.getEirrelations())){
						query.append(" AND a.eirrelation in("+cond.getEirrelations()+")");
					}
				} else if(cond.getCldeiid()!=null) {
					query.append(" AND a.cldeiid ="+cond.getCldeiid());
					query.append(" AND a.cldversion ="+cond.getCldversion());
					query.append(" AND a.cldsmallversion ="+cond.getCldsmallversion());
					if(StringUtils.isNotEmpty(cond.getEirrelation())){
						query.append(" AND a.eirrelation ='"+cond.getEirrelation()+"'");
					}
				}else if(StringUtils.isNotEmpty(cond.getPareiids())&&StringUtils.isNotEmpty(cond.getCldeiids())){
					query.append(" AND (a.pareiid in ("+cond.getPareiids()+") or a.cldeiid in ("+cond.getCldeiids()+")");
				}else if(StringUtils.isNotEmpty(cond.getCldeiids())&&StringUtils.isEmpty(cond.getPareiids())){
					query.append(" AND a.cldeiid in ("+cond.getCldeiids()+")");
				}else if(StringUtils.isEmpty(cond.getCldeiids())&&StringUtils.isNotEmpty(cond.getPareiids())){
					query.append(" AND a.pareiid in ("+cond.getPareiids()+")");
				}
				
				//query.append(session.getNamedQuery("EntityItemRelationDAO.searchMaxEntityItemRelationVW2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0119TB.class);
				setFetchPoint(q, 0, 0);
				list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0119Info>) execute(action);
	}
	
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0119Info> searchMaxEntityItemRelation(final SOC0119SearchCond cond,final int start, final int count) {
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<SOC0118Info> list = null;
				query.append(session.getNamedQuery("EntityItemRelationDAO.searchMaxEntityItemRelationVW1").getQueryString());
				if(cond.isFlag()==true){
					if(StringUtils.isNotEmpty(cond.getPareiids())&&StringUtils.isNotEmpty(cond.getCldeiids())){
						query.append(" AND (pareiid in ("+cond.getPareiids()+") and cldeiid in ("+cond.getCldeiids()+")) ");
						query.append(" and eirrelation ='"+cond.getEirrelation()+"' ");
					}else if(StringUtils.isNotEmpty(cond.getCldeiids())&&StringUtils.isEmpty(cond.getPareiids())){
						query.append(" AND cldeiid in ("+cond.getCldeiids()+") ");
						query.append(" and eirrelation ='"+cond.getEirrelation()+"' ");
					}else if(StringUtils.isEmpty(cond.getCldeiids())&&StringUtils.isNotEmpty(cond.getPareiids())){
						query.append(" AND pareiid in ("+cond.getPareiids()+") ");
						query.append(" and eirrelation ='"+cond.getEirrelation()+"' ");
					}else{
						query.append(" and 1=2 and eirrelation ='"+cond.getEirrelation()+"' ");
					}
				}else{
					query.append(" and eirrelation ='"+cond.getEirrelation()+"' ");
				}
				query.append(session.getNamedQuery("EntityItemRelationDAO.searchMaxEntityItemRelationVW2").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(SOC0119TB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				
				return list;
			}
		};
		return (List<SOC0119Info>) execute(action);
	}
	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid){
		String sql = "delete from soc0119 where pareiid = :eiid or cldeiid = :eiid";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eiid", eiid);
		q.executeUpdate();
		
	}
	
	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid,String eirrelationcode){
		String sql = "delete from soc0119 where pareiid = :eiid or cldeiid = :eiid and eirrelationcode = :eirrelationcode ";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eiid", eiid);
		q.setParameter("eirrelationcode", eirrelationcode);
		q.executeUpdate();
		
	}
	
	/**
	 * ����eiid ��ѯ������ص�eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid(final SOC0119SearchCond cond){
		String sql = "select pareiid from soc0119 where eirrelation = :relationStr and  cldeiid =  :eiid";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("eiid", cond.getCldeiid());
		q.setParameter("relationStr", cond.getEirrelation());
		
		List<Integer> eiids = q.list();
		return eiids;
	}
	
	/**
	 * ���������ϵ��ѯ
	 * @param cond
	 * @return
	 */
	public List<Integer> searchCldeiidByPareiid(final SOC0119SearchCond cond){
		
		String sql = "";
		if(StringUtils.isNotEmpty(cond.getEirrelation()))
			sql = "select cldeiid from soc0119 where eirrelation = :relationStr and pareiid =:pareiid";
		else
			sql ="select cldeiid from soc0119 where pareiid =:pareiid";
		
		if(StringUtils.isNotBlank(cond.getDeleteflag())){
			sql = sql + " and deleteflag = '" + cond.getDeleteflag() + "' ";
		}
		
		SQLQuery q = getSession().createSQLQuery(sql);
		if(StringUtils.isNotEmpty(cond.getEirrelation()))
			q.setParameter("relationStr", cond.getEirrelation());
		q.setParameter("pareiid", cond.getPareiid());
		List<Integer> eiids = q.list();
		return eiids;
	}
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<SOC0119Info> findByCondBySql(final SOC0119SearchCond cond, final int start, final int count){
        HibernateCallback action = new HibernateCallback(){
            public Object doInHibernate(Session session)throws HibernateException, SQLException {
                session.flush();
                //��ȡquery
                StringBuffer query = new StringBuffer();
                query.append( session.getNamedQuery("SOC0607DAO.checkExistEntityItemRelation").getQueryString());

                getSql(cond, query);
                
                //��ȡSQLQuery
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(cond);
                q.addEntity("a",SOC0607VW.class);
                setFetchPoint(q, 0, 0);
                List<SOC0119Info> list = null;
                list = q.list();
                session.clear();
                return list;
            }
            
        };
        return (List<SOC0119Info>)execute(action);
    }
	
    private void getSql(final SOC0119SearchCond cond, StringBuffer query) {
        if(cond.getPareiid()!=null) {
            query.append(" AND a.pareiid = :pareiid ");
        } 
        if(cond.getParversion()!=null) {
            query.append(" AND a.parversion = :parversion ");
        } 
        if(cond.getCldeiid()!=null) {
            query.append(" AND a.cldeiid = :cldeiid ");
        }
        if(cond.getCldversion()!=null) {
            query.append(" AND a.cldversion = :cldversion ");
        }
        if(StringUtils.isNotEmpty(cond.getDeleteflag())) {
            query.append(" AND a.deleteflag = :deleteflag ");
        }
        //ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
        if(StringUtils.isNotEmpty(cond.getEirinfo())){
            query.append(" AND a.eirinfo like ('%'||:eirinfo||'%') ");
        }
        //�ʲ����ϵ˵��
        if( !StringUtils.isEmpty(cond.getEirdesc())){
            query.append(" AND a.eirdesc like ('%'||:eirdesc||'%') ");
        }
        //�ʲ���״̬
        if( !StringUtils.isEmpty(cond.getEirstatus())){
            query.append(" AND a.eirstatus = :eirstatus ");
        }
        //ͨ���ʲ�ID��������������������ʲ��Ĺ�����ϵ
        if( !StringUtils.isEmpty(cond.getEiid())){
            query.append(" AND (a.pareiid = :eiid OR a.cldeiid = :eiid) ");
        }
        //�ʲ����ϵ
        if( !StringUtils.isEmpty(cond.getEirrelation())){
            if((CommonDefineUtils.MODULE_RELATION_ENTIY_ID+"#"+CommonDefineUtils.MODULE_RELATION_MODULE_ID).equals(cond.getEirrelation())){
                query.append(" AND (a.eirrelation = '").append(CommonDefineUtils.MODULE_RELATION_ENTIY_ID).append("' ");
                query.append(" OR a.eirrelation = '").append(CommonDefineUtils.MODULE_RELATION_MODULE_ID).append("') ");
            }else{
                query.append(" AND a.eirrelation = :eirrelation ");
            }
        }
    }
    
	/**
	 * ����eiid_in ��ѯ������ص�eiid
	 * @param eiid
	 * @return
	 */
    @SuppressWarnings("unchecked")
	public List<Integer> searchRelationByEiid_in(final SOC0119SearchCond cond){
		String sql = "select pareiid from soc0119 where eirrelation = :relationStr and  cldeiid in ( :eiid ) and deleteflag = '0'";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameterList("eiid", cond.getCldriid_in());
		q.setParameter("relationStr", cond.getEirrelation());
		
		List<Integer> eiids = q.list();
		return eiids;
	}
}
