/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0606VW;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * �ʲ���������Ϣ��ͼDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class SOC0606DAOImpl extends BaseHibernateDAOImpl<SOC0606Info> implements SOC0606DAO {

	
	/** EntityItem DAO */
	protected SOC0118DAO soc0118DAO;

	public void setSoc0118DAO(SOC0118DAO soc0118dao) {
		soc0118DAO = soc0118dao;
	}

	/**
	 * ���캯��
	 * 
	 */
	public SOC0606DAOImpl(){
		super(SOC0606VW.class);
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0606SearchCond cond){
//		DetachedCriteria c = getCriteria(cond);
		List<SOC0606Info> ret = this.findByCond(cond);
		return ret.size();
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0606Info> findByCond(final SOC0606SearchCond cond, final int start, final int count){
//		DetachedCriteria c = getCriteria(cond);
//		c.addOrder(Order.asc("eiid"));
//		c.addOrder(Order.asc("clabel"));
//		List<ConfigItemVWInfo> ret = findByCriteria(c, start, count);
		List<SOC0606Info> ret = this.findByCond(cond);
		return ret;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0606SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		c.add(Expression.eq("eiid", cond.getEiid()));

		return c;
	}
	
	
	@SuppressWarnings("unchecked")
	public  List<SOC0606Info> findByCond(final SOC0606SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
//				EntityItemBL entityItemBL = (EntityItemBL) WebApplicationSupport.getBean("entityItemBL");
//				
//				EntityItem entityItem = entityItemBL.searchEntityItemByKey(Integer.parseInt(cond.getEiid()));
				
//				EntityItem entityItem = entityItemDAO.findByPK(Integer.parseInt(cond.getEiid()));
//				if( entityItem == null) {
//					throw new BLException(BLErrorType.ENTITY_ITEM_NOT_EXISTS_ERROR,
//							"IGCO10000.E004","�ʲ�����");
//				}
//				
				
				String esyscoding = cond.getEsyscoding_q();
				int level = CommonDefineUtils.TREE_LEVEL_CODE;
				int ccid = CommonDefineUtils.CCID_LENGTH + level;
				List<String> esyscodingList = new ArrayList<String>();
				esyscodingList.add(esyscoding.substring(0,ccid));
				while(esyscoding.length()>ccid){
					ccid=ccid+CommonDefineUtils.CCID_LENGTH;
					esyscodingList.add(esyscoding.substring(0,ccid));
				}
				SOC0109SearchCondImpl impl = new SOC0109SearchCondImpl();
				impl.setEsyscodingList(esyscodingList);
				
				query.append( session.getNamedQuery("SOC0606DAO.ConfigItemQuery").getQueryString());
				
				if(StringUtils.isNotEmpty(cond.getCname())) {
					query.append( " AND cname like :cname");
				}
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					query.append( " AND clabel = :clabel");
				}
				
				if(StringUtils.isNotEmpty(cond.getCiversion())){//���汾��ѯ
					query.append( session.getNamedQuery("SOC0606DAO.ConfigItemQueryAppend2").getQueryString());
				}else{
					query.append( session.getNamedQuery("SOC0606DAO.ConfigItemQueryAppend").getQueryString());
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ci",SOC0606VW.class);

				q.setProperties(impl);
				
				if(StringUtils.isNotEmpty(cond.getCiversion())){
					q.setInteger("civersion",Integer.valueOf(cond.getCiversion()));
				}
				
				q.setInteger("eiid", Integer.parseInt(cond.getEiid()));
				
				if(StringUtils.isNotEmpty(cond.getCname())) {
					q.setString("cname", "%" + cond.getCname() + "%");
				}
				
				//clabel
				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
					q.setString("clabel", cond.getClabel_q());
				}
				
				List<SOC0606Info> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<SOC0606Info>) execute(action);
	}
	
	@SuppressWarnings("unchecked")
	public  List<SOC0606Info> initFindByCond(final SOC0606SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
//				EntityItemBL entityItemBL = (EntityItemBL) WebApplicationSupport.getBean("entityItemBL");
//				
//				EntityItem entityItem = entityItemBL.searchEntityItemByKey(Integer.parseInt(cond.getEiid()));
				
//				EntityItem entityItem = entityItemDAO.findByPK(Integer.parseInt(cond.getEiid()));
//				if( entityItem == null) {
//					throw new BLException(BLErrorType.ENTITY_ITEM_NOT_EXISTS_ERROR,
//							"IGCO10000.E004","�ʲ�����");
//				}
//				
				
				String esyscoding = cond.getEsyscoding_q();
				int level = CommonDefineUtils.TREE_LEVEL_CODE;
				int ccid = CommonDefineUtils.CCID_LENGTH + level;
				List<String> esyscodingList = new ArrayList<String>();
				esyscodingList.add(esyscoding.substring(0,ccid));
				while(esyscoding.length()>ccid){
					ccid=ccid+CommonDefineUtils.CCID_LENGTH;
					esyscodingList.add(esyscoding.substring(0,ccid));
				}
				SOC0109SearchCondImpl impl = new SOC0109SearchCondImpl();
				impl.setEsyscodingList(esyscodingList);
				
				query.append( session.getNamedQuery("SOC0606DAO.InitConfigItemQuery").getQueryString());
				
//				if(StringUtils.isNotEmpty(cond.getCname())) {
//					query.append( " AND cname like :cname");
//				}
//				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
//					query.append( " AND clabel = :clabel");
//				}
				
				query.append( session.getNamedQuery("SOC0606DAO.InitConfigItemQueryAppend").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ci",SOC0606VW.class);
				impl.setEid(cond.getEid_q());
				q.setProperties(impl);
				
//				q.setInteger("eid", Integer.parseInt(cond.getEid()));
				
//				if(StringUtils.isNotEmpty(cond.getCname())) {
//					q.setString("cname", "%" + cond.getCname() + "%");
//				}
//				
//				//clabel
//				if(StringUtils.isNotEmpty(cond.getClabel_q())) {
//					q.setString("clabel", cond.getClabel_q());
//				}
				
				List<SOC0606Info> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<SOC0606Info>) execute(action);
	}
}
