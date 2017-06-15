/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.csebank.lom.model.entity.GoodsStockVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ���ͳ��DAOʵ��
 *
 */
public class GoodsStockDAOImpl extends BaseHibernateDAOImpl<GoodsStock> implements GoodsStockDAO {

	/**
	 * ���캯��
	 */
	public GoodsStockDAOImpl(){
		super(GoodsStockVW.class);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsStock> getSearchCount(final GoodsStockSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(StringUtils.isNotEmpty(cond.getGoods())){
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockAllDetail").getQueryString());
				}else{
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockDetail").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("GoodsStock",GoodsStockVW.class);
				setFetchPoint(q, 0, 0);
				List<GoodsStock> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};return (List<GoodsStock>) execute(action);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsStock> findByCond(final GoodsStockSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(StringUtils.isNotEmpty(cond.getFlag())){
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockAllDetail").getQueryString());
				}else{
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockDetail").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("GoodsStock",GoodsStockVW.class);
				setFetchPoint(q, start, count);
				List<GoodsStock> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<GoodsStock>) execute(action);
	}

}
