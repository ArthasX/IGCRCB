/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.Format;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.IgdocdownInfo;
import com.deliverik.infogovernor.asset.model.condition.IgdocdownSearchCond;
import com.deliverik.infogovernor.asset.model.entity.IgdocdownTB;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.entity.IGCRC1303VW;

/**
  * ����: ���ؼ�¼��DAOʵ��
  * ��������: ���ؼ�¼��DAOʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IgdocdownDAOImpl extends
		BaseHibernateDAOImpl<IgdocdownInfo> implements IgdocdownDAO {

	/**
	 * ���캯��
	 */
	public IgdocdownDAOImpl(){
		super(IgdocdownTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgdocdownInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgdocdownInfo findByPK(Serializable pk) {
		IgdocdownInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IgdocdownSearchCond cond){
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
	public List<IgdocdownInfo> findByCond(final IgdocdownSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IgdocdownSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

	

	public List<IgdocdownInfo> insertDate(final IgdocdownSearchCond cond) {
		// TODO Auto-generated method stub
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("insert into igdocdown(eiid,userid,downtime,downlocation,fingerprint) " +
                		"values('");
                query.append(cond.getEiid()+"','");
                query.append(cond.getUserid()+"','");
                
                query.append(cond.getDowntime()+"','");
                query.append(cond.getDownlocation()+"','");
                query.append(cond.getFingerprint()+"')");
                SQLQuery q = session.createSQLQuery(query.toString()); 
                q.executeUpdate();
                
                session.clear();
                session.close();
                return null;
            }
        };
        return (List<IgdocdownInfo>) execute(action);
	}

}