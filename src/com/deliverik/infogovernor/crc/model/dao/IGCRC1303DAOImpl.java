package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;
import com.deliverik.infogovernor.crc.model.entity.DownBean;
import com.deliverik.infogovernor.crc.model.entity.IGCRC1303VW;
/**
 * 概述: 文档统计视图DAO实现 
 * 功能描述: 文档统计视图DAO实现 
 * 创建记录: 史凯龙 2014/07/22
 * 修改记录:
 */
public class IGCRC1303DAOImpl extends BaseHibernateDAOImpl<IGCRC1303VWInfo> implements IGCRC1303DAO{

	
	/**
	 * 构造函数
	 */
	public IGCRC1303DAOImpl() {
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
	public List<IGCRC1303VWInfo> searchIGCRC1303VWInfo(final IGCRC1303Cond cond, final int start,
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
                query.append("select ig9.PIVARVALUE " +
                			 "from ig500 ig5,ig599 ig9 " +
                			 "where ig5.PRTITLE like '%文档借阅%' " +
                			 		"and ig9.PRID=ig5.PRID " +
                			 		"and ig9.PIVARNAME like '文档分类'");
                
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
     * 查询被下载的文档的类型
     */
	public List<String> searchDownType(){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select map.civalue " +
                				"from	(select distinct(ddid),civalue " +
                							"from igdocdown ig,soc0107 soc " +
                							"where soc.EIID=ig.EIID " +
                							"and soc.CIVALUE like '%_tree_%') map");
                SQLQuery q = session.createSQLQuery(query.toString()); 
                
           
                List<String> bean = q.list();
                
                List<String> list = new ArrayList<String>();
                
                //从结果中取出一级分类
                for(int i=0;i<bean.size();i++){
                	String[] strs = bean.get(i).split("_");
                	String str = strs[strs.length-1];
                	String[] strs2 = str.split("-");
                	list.add(i, strs2[0]);
                }
                session.clear();
                session.close();
                return list;
            }
        };
		return (List<String>) execute(action);
	}
	
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IGCRC1303Cond cond) {
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
    private void getSql(StringBuffer query, IGCRC1303Cond cond){
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
