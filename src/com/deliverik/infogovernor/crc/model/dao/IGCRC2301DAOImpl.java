/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.dao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2301VW;
/**
 * 概述: 程序开发统计视图DAO实现 
 * 功能描述: 程序开发统计视图DAO实现 
 * 创建记录: yukexin 2014-8-12 11:11:31
 * 修改记录:
 */
public class IGCRC2301DAOImpl extends BaseHibernateDAOImpl<IGCRC2301VWInfo> implements IGCRC2301DAO{

	
	/**
	 * 构造函数
	 */
	public IGCRC2301DAOImpl() {
		super(IGCRC2301VW.class);
	}

	
	/**
     * 根据对象比对结果
     * @param cond 检索条件
     * @return 检索结果列表
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC2301VWInfo> searchIGCRC2301VWInfo(final IGCRC2301Cond cond) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC2301VWDAO.entityItemIGCRC2301VWDAO").getQueryString());
	                // 拼接查询条件
	                getSql(query, cond);
	                SQLQuery q = session.createSQLQuery(query.toString());
	                if(cond.getPropentime()!=null){
	                	q.setString("prclosetime", cond.getPropentime());
	                }else{
	                	q.setString("prclosetime", "");
	                }
	                q.setProperties(cond);
	                q.addEntity("t",IGCRC2301VW.class);
	                List<IGCRC2301VWInfo> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<IGCRC2301VWInfo>) execute(action);
	}

    /**
	 * 条件检索处理
	 * 		查询处理驳回次数，只需要prid集合即可
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> searchList(final IGCRC2301Cond cond) {
		// TODO Auto-generated method stub
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(" select g.prid as prid ");
                query.append(" from ig036 f ");
                query.append(" left join ig677 g on f.prid=g.prid and g.ppstatus='Y' and g.prclosetime is not null and g.prpdid like '01102%' ");
                query.append(" where  1=1 and f.prid in ( select distinct(prid) from ig677 where ppstatus = 'Y' and  prclosetime is not null and prpdid like '01102%' ) ");
                query.append(" and rltype like '2' ");
                query.append(" and psname in ('测试更新','测试','确认') ");
                query.append(" and rldesc not in ('删除参与者','添加参与者') ");
                                
                // 拼接查询条件
                getSql2(query, cond);
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
	 * 条件检索处理
	 *		查询处理工单的总数,只需要prid集合即可
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<Integer> searchListSum(final IGCRC2301Cond cond){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append(" select prid from ig677 d  ");
                query.append(" where  d.ppuserid= '");
                query.append(cond.getUserid());
                query.append("' ");
                query.append("and prid in (");
                query.append("select prid from ig500 where prpdid like '01102%') ");
                
                if(cond.getMonth()!=null && cond.getYear()!=null && !(cond.getMonth().equals("")) && !(cond.getYear().equals("")) ){
                	query.append(" and d.prclosetime like '"
            				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
            						: cond.getYear())
            				+ "/"
            				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
            						: "" + cond.getMonth()) + "%'");
                }
                query.append(" and d.prclosetime is not null");
                query.append(" and d.ppstatus = 'Y' ");
                query.append(" group by prid");
                
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
    private void getSql(StringBuffer query, IGCRC2301Cond cond){
    	//年月
		query.append(" and g.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
		
		query.append(" group by g.ppusername,g.ppuserid");
    }
    
    /**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
    private void getSql2(StringBuffer query, IGCRC2301Cond cond){
    	//年月
    	
    	query.append(" and g.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
    	String flag = cond.getFlag();
    	String userid = cond.getUserid();
    	if(userid != null){
    		query.append(" and g.ppuserid = '");
    		query.append(userid);
    		query.append("' ");
    	}
    	//测试更新驳回
    	if(flag.equals("1")){
    		query.append(" and f.psdcode = 'X' ");
    		query.append(" and f.rldesc = '不通过' ");
    	}
    	//测试驳回
    	if(flag.equals("2")){
    		query.append(" and f.psdcode = 'W' ");
    		query.append(" and f.rldesc = '审批不通过' ");
    	}
    	//确认驳回
    	if(flag.equals("3")){
    		query.append(" and f.psdcode = 'V' ");
    		query.append(" and f.rldesc = '确认不通过' ");
    	}
		query.append(" group by g.prid ");
    }
    
    
}
