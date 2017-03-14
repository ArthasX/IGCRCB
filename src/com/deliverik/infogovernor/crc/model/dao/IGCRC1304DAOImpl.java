package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC1303VW;

/**
 * 
 * 功能：
 * @author 史凯龙   2014-7-24
 */
public class IGCRC1304DAOImpl extends BaseHibernateDAOImpl<IGCRC1303VWInfo> implements IGCRC1304DAO{

	
	/**
	 * 构造函数
	 */
	public IGCRC1304DAOImpl() {
		super(IGCRC1303VW.class);
	}

	/**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC1303VWInfo> searchIGCRC1304VWInfo(final IGCRC1304Cond cond, final int start,
			final int count) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC1303VWDAO.entityItemIGCRC1303VWDAO").getQueryString());
	                // 拼接查询条件
	                getSql(query, cond);
	                query.append(" order by t.eiid desc");
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.setProperties(cond);
	                q.addEntity("t",IGCRC1303VW.class);
	                setFetchPoint(q, start , count);
	                List<IGCRC1303VWInfo> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IGCRC1303VWInfo>) execute(action);
	}
	
	
	/**
     * 根据查询借阅流程的部门名称
     */
	public List<String> searchType(){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select einame " +
                				"from ig500 ig5,ig731 ig7 ,soc0118 soc " +
                				"where ig5.prpdname like '%文档借阅%' " +
                				"and ig7.prid=ig5.prid  " +
                				"and soc.eiid=ig7.eiid order by soc.eiid");
                
                SQLQuery q = session.createSQLQuery(query.toString()); 

                List<String> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
		return (List<String>) execute(action);
	}
	
	
	/**
     * 根据查询借阅流程的部门流程id
     */
	public List<Integer> searchTypeID(final IGCRC1304Cond cond){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append("select ig5.prid " +
                				"from ig500 ig5,ig731 ig7 ,soc0118 soc  " +
                				"where ig5.prpdname like '%文档借阅%'  " +
                				"and ig7.prid=ig5.prid " +
                				"and soc.eiid=ig7.eiid " +
                				"and soc.eiid like '");
                query.append(cond.getEiid());
                query.append("'");
                SQLQuery q = session.createSQLQuery(query.toString()); 

                List<Integer> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
		return (List<Integer>) execute(action);
	}
	
	
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IGCRC1304Cond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemIGCRC1301VWDAO.getSearchCount").getQueryString());
				
				
				// 拼接查询条件
                getSql(query, cond);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.setProperties(cond);

				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}
	
	/**
     * 查询被下载的文档的部门
     */
	public List<String> searchDownDepart(){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select einame " +
                				"from IGDOCDOWN igdo,soc0118 soc " +
                				"where soc.eiid = igdo.eiid");
                SQLQuery q = session.createSQLQuery(query.toString()); 

                List<String> bean = q.list();
                session.clear();
                session.close();
                return bean;
            }
        };
		return (List<String>) execute(action);
	}
	
	
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
    private void getSql(StringBuffer query, IGCRC1304Cond cond){
    	//文档编号
        if(StringUtils.isNotEmpty(cond.getEiNumber())){
        	query.append(" and t.eiNumber = '"+cond.getEiNumber()+"'");
        }
        //文档名称
        if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and t.eiName like '%"+cond.getEiName()+"%'");
        }
        //文档类型
        if(StringUtils.isNotEmpty(cond.getEiType())){
        	query.append(" and t.eiType = '"+cond.getEiType()+"'");
        }
        //文档分类
        if(StringUtils.isNotEmpty(cond.getEiSort())){
        	query.append(" and t.eiSort like '%"+cond.getEiSort()+"'");
        }
        //文档密级
        if(StringUtils.isNotEmpty(cond.getEiDense())){
        	query.append(" and t.eiDense = '"+cond.getEiDense()+"'");
        }
        //部门
        if(StringUtils.isNotEmpty(cond.getDepartment())){
        	query.append(" and t.department like '%"+cond.getDepartment()+"%'");
        }
        //管理人
        /*if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and EINAME = '"+cond.getEiName()+"'");
        }*/
        //内容
        if(StringUtils.isNotEmpty(cond.getContent())){
        	query.append(" and t.content like '%"+cond.getContent()+"%'");
        }

    }
}
