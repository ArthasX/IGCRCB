package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VW;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * �ʲ���ϢDAOʵ��
 * 
 */
public class SOC0117VWDAOImpl extends BaseHibernateDAOImpl<SOC0117VWInfo> implements SOC0117VWDAO {

	/**
	 * ���캯��
	 */
	public SOC0117VWDAOImpl(){
		super(SOC0117VW.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	@Override
	public List<SOC0117VWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eid"));
		List<SOC0117VWInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	@Override
	public SOC0117VWInfo findByPK(Serializable pk) {
		SOC0117VWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0117VWSearchCond cond){
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
	public List<SOC0117VWInfo> findByCond(final SOC0117VWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("esyscoding"));
		List<SOC0117VWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}
	/**
	 * ���������¼���
	 */
	
	public List<SOC0117VWInfo> findByCond(final SOC0117VWSearchCond cond,final String orderType){
		DetachedCriteria c = getCriteria(cond);
		if("assetdomain".equals(orderType)){//��ѯ��ɫ�ʲ������������Ľ��ȫ��ʹ��
			c.addOrder(Order.asc("esyscoding"));
		}else{
			c.addOrder(Order.desc("eparcoding"));
		}
		
		List<SOC0117VWInfo> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ��ȡ���EID��
	 * @param cond
	 * @return
	 */
	public List<SOC0117VWInfo> findMaxEidByCond(final SOC0117VWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("eid"));
		
		List<SOC0117VWInfo> ret = findByCriteria(c);
		return ret;
	}
	
	public List<SOC0117VWInfo> findByCondCoding(final SOC0117VWSearchCond cond)
	{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("esyscoding"));
		List<SOC0117VWInfo> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ��ѯģ�����ʲ�������ר��Ԥ����Ӧ����Դר�ã�
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("SOC0117VWDAO.getEntityNum").getQueryString();
		
		Query q = session.createSQLQuery(sql);
		
		q.setParameter("esyscoding", rootEsyscoding+"%");
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> result  = q.list();
		
		return result;
		
	}
	/**
	 * ��ѯģ�����ʲ��������°�Ӧ����Դר�ã�
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode){
		
		Session session = getSession();
		String sql = " SELECT a.erid ,  a.ername ,  a.ercode ,  a.erparcode,  COUNT(b.eiid) AS account "
				+"FROM  emergencyresource a LEFT JOIN errelation b ON( b.ercode LIKE  '000%' AND b.deleteflag <> '1'  ) "
				+" WHERE  a.ercode LIKE '000%' GROUP BY  a.erid ,  a.ername ,  a.ercode ,  a.erparcode ORDER BY  ercode";
		if(!"allTree".equals(rootErcode)){
			sql = session.getNamedQuery("SOC0117VWDAO.getEntityNumNEW").getQueryString();
		}
		
		Query q = session.createSQLQuery(sql);
		
		if(!"allTree".equals(rootErcode)){
			q.setParameter("ercode", rootErcode+"%");
		}		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		List<Map<String, Object>> result  = q.list();
		
		return result;
		
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0117VWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���ݿ�id
		if(cond.getId()!=null)
			c.add(Restrictions.eq("id", cond.getId()));
		if( !StringUtils.isEmpty(cond.getEcategory())){
			if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				//c.add(Restrictions.ne("esyscoding", "999007"));
				c.add(Restrictions.ne("esyscoding", "999008"));	
			}else if(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				c.add(Restrictions.ne("esyscoding", "999008"));	
			}
//			else if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
//					&& CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
//				c.add(Expression.ne("esyscoding", "999007"));	
//			}
		} else {
//			if(!StringUtils.isEmpty(cond.getEname())){
//			}else{
//				c.add(Expression.ne("esyscoding", "999007"));
//			}
			c.add(Restrictions.ne("esyscoding", "999007"));
			c.add(Restrictions.ne("esyscoding", "999008"));
		}
		//�ʲ�ģ��ID
		if( !StringUtils.isEmpty(cond.getEidStr())){
			c.add(Restrictions.eq("eid", cond.getEidStr()));
		}	
		//�ʲ�ģ��ID LIKE
		if( !StringUtils.isEmpty(cond.getEidStr_like())){
			c.add(Restrictions.like("eid", cond.getEidStr_like() + "%"));
		}	
		//�ʲ�ģ�ͱ��
		if( !StringUtils.isEmpty(cond.getElabel())){
			c.add(Restrictions.eq("elabel", cond.getElabel()));
		}	
		//�ʲ�ģ����
		if( !StringUtils.isEmpty(cond.getEname())){
			c.add(Restrictions.like("ename", "%" + cond.getEname() + "%"));
		}	
		
		//�ʲ�ģ�ͷ���
		if( !StringUtils.isEmpty(cond.getEcategory_q())){
			c.add(Restrictions.eq("ecategory", cond.getEcategory()));
		}
		//�ʲ�ģ�ͷ���
		if( !StringUtils.isEmpty(cond.getEcategory()) && 
				!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory()) 
				&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
			c.add(Restrictions.eq("ecategory", cond.getEcategory()));
		}
		//�ʲ�ģ��һ������
		if( !StringUtils.isEmpty(cond.getEkey1())){
			c.add(Restrictions.eq("ekey1", cond.getEkey1()));
		}
		//�ʲ�ģ�Ͷ�������
		if( !StringUtils.isEmpty(cond.getEkey2())){
			c.add(Restrictions.eq("ekey2", cond.getEkey2()));
		}
		//�ʲ�ģ����������
		if( !StringUtils.isEmpty(cond.getEkey3())){
			c.add(Restrictions.eq("ekey3", cond.getEkey3()));
		}
		
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding()));
		}
		if( !StringUtils.isEmpty(cond.getEsyscoding_q())){
			c.add(Restrictions.like("eparcoding", cond.getEsyscoding_q()));
//			if("999".equals(cond.getEsyscoding_q())){
//				c.add(Expression.ne("esyscoding", "999007"));
//				c.add(Expression.ne("esyscoding", "999008"));
//			}
		}
		if( cond.getSelectList()!=null && cond.getSelectList().size()>0){
			c.add(Restrictions.in("esyscoding", cond.getSelectList()));
		}
		if( cond.getDelList()!=null && cond.getDelList().size()>0){
			c.add(Restrictions.not(Restrictions.in("esyscoding", cond.getDelList())));
		}
		
		//�豸�Ǽ�_����ѡ��tree
		if( !StringUtils.isEmpty(cond.getEsyscoding_tree()) && StringUtils.isEmpty(cond.getEparcoding())){
			c.add(Restrictions.eq("esyscoding", cond.getEsyscoding_tree()));
//			if(!StringUtils.isEmpty(cond.getEparcoding())){
//				c.add(Expression.or(Expression.eq("esyscoding", cond.getEsyscoding_tree()),Expression.eq("eparcoding", cond.getEparcoding())));
//			}
		}else{
			//���͵Ǽ�_�ϼ�����ѡ��tree
			if(!StringUtils.isEmpty(cond.getEparcoding())){
				c.add(Restrictions.eq("eparcoding", cond.getEparcoding()));
			}
		}
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEparcoding()) && StringUtils.isEmpty(cond.getEsyscoding_tree())){
			c.add(Restrictions.eq("eparcoding", cond.getEparcoding()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_q())){
			c.add(Restrictions.eq("eparcoding", cond.getEparcoding_q()));
		}
		
		if( !StringUtils.isEmpty(cond.getEstatus())){
			c.add(Restrictions.eq("estatus", cond.getEstatus()));
		}
	
		//Entity tree �ӽ�㼯��
		if( !StringUtils.isEmpty(cond.getSyscoding_q())){
			c.add(Restrictions.like("esyscoding", cond.getSyscoding_q()+"%"));
		}
		//�ʲ�ģ��in����
		if( cond.getEsyscodingList()!=null && cond.getEsyscodingList().size()>0){
			c.add(Restrictions.in("esyscoding", cond.getEsyscodingList()));
		}

		//�ʲ�ģ��״̬�޸�
		if( !StringUtils.isEmpty(cond.getEparcoding_status())){
			c.add(Restrictions.eq("eparcoding", cond.getEparcoding_status()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_status_start())){
			c.add(Restrictions.eq("esyscoding", cond.getEparcoding_status_start()));
		}
		
		//��ѯnot like Esyscoding_nq��ģ��
		if( !StringUtils.isEmpty(cond.getEsyscoding_nq())){
			c.add(Restrictions.not(Restrictions.like("esyscoding", cond.getEsyscoding_nq()+"%")));
		}
		
		if( cond.getDelList_q()!=null && cond.getDelList_q().size()>0){
			for(String esys:cond.getDelList_q()){
				c.add(Restrictions.not(Restrictions.like("esyscoding", esys+"%")));
			}
			
		}
		
		return c;
	}
	
	protected DetachedCriteria getCriterias(SOC0117VWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}

	/**
	 * ��ȡ���EID��,����������
	 * @param cond
	 * @return
	 */
	public Integer findMaxEidByCondNotLikeCM(){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("SOC0117VWDAO.getEidNotLkeCmNum").getQueryString();
		
		Query q = session.createSQLQuery(sql);
		
		
		BigDecimal eid = (BigDecimal)q.uniqueResult();
		
		
		return eid.intValue();
	}
	/**
	 * ��ȡ�ɵ���һ���ʲ��б�
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0117VWInfo> searchEntityForExport(final SOC0117VWSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                
                StringBuffer queryString = new StringBuffer();

                queryString.append(session.getNamedQuery("SOC0117VWDAO.searchEntityForExport").getQueryString());
                
				SQLQuery q = session.createSQLQuery(queryString.toString());
				
				q.addEntity(SOC0117VW.class);
				
				List<SOC0117VWInfo> list = q.list();
				
				session.clear();
				
				return list;
             }
         };
		return (List<SOC0117VWInfo>) execute(action);
	}
	

}
