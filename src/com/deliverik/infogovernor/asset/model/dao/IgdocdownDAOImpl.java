/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 下载记录表DAO实现
  * 功能描述: 下载记录表DAO实现
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IgdocdownDAOImpl extends
		BaseHibernateDAOImpl<IgdocdownInfo> implements IgdocdownDAO {

	/**
	 * 构造函数
	 */
	public IgdocdownDAOImpl(){
		super(IgdocdownTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IgdocdownInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IgdocdownInfo findByPK(Serializable pk) {
		IgdocdownInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IgdocdownSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IgdocdownInfo> findByCond(final IgdocdownSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
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