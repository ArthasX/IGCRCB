/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS03Info;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS03TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������Ϣʵ��DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class NMS03DAOImpl extends BaseHibernateDAOImpl<NMS03Info> implements NMS03DAO {
	
	/**
	 * ���췽��
	 */
	public NMS03DAOImpl(){
		super(NMS03TB.class);
	}
	
	/**
	 * ���°汾����
	 * @return ���°汾
	 */
	@SuppressWarnings("unchecked")
	public List<NMS03Info> searchNewest(final NMS03SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select * from NMS03 where deleteflag = '0'");
				query.append(" and gid =:gid and version > 0 and version = (select max(version) from NMS03 where gid=:gid) ");
				if(StringUtils.isNotEmpty(cond.getType())) {
					query.append(" and type = :type");
				}
				if(StringUtils.isNotEmpty(cond.getFromIP())) {
					query.append(" and fromIP = :fromIP");
				}
				if(StringUtils.isNotEmpty(cond.getToIP())) {
					query.append(" and toIP = :toIP");
				}
				if(StringUtils.isNotEmpty(cond.getSubNet())) {
					query.append(" and subNet = :subNet");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setParameter("gid", cond.getGid());
				if(StringUtils.isNotEmpty(cond.getType())) {
					q.setParameter("type", cond.getType());
				}
				if(StringUtils.isNotEmpty(cond.getFromIP())) {
					q.setParameter("fromIP", cond.getFromIP());
				}
				if(StringUtils.isNotEmpty(cond.getToIP())) {
					q.setParameter("toIP", cond.getToIP());
				}
				if(StringUtils.isNotEmpty(cond.getSubNet())) {
					q.setParameter("subNet", cond.getSubNet());
				}
				q.addEntity(type);
				List list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<NMS03Info>) execute(action);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS03SearchCond cond){
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
	public List<NMS03Info> findByCond(NMS03SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS03SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��ID
		if(cond.getGid() != null && cond.getGid() > 0){
			c.add(Expression.eq("gid", cond.getGid()));
		}
		//ɾ����ʶ 
		if( !StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//��������
		if( !StringUtils.isEmpty(cond.getType())){
			c.add(Expression.eq("type", cond.getType()));
		}
		//��ʼIP
		if( !StringUtils.isEmpty(cond.getFromIP())){
			c.add(Expression.eq("fromIP", cond.getFromIP()));
		}
		//����IP
		if( !StringUtils.isEmpty(cond.getToIP())){
			c.add(Expression.eq("toIP", cond.getToIP()));
		}
		//���� 
		if( !StringUtils.isEmpty(cond.getSubNet())){
			c.add(Expression.eq("subNet", cond.getSubNet()));
		}
		//�汾
		if(cond.getVersion() != null){
			c.add(Expression.eq("version", cond.getVersion()));
		}
		return c;
	}
}
