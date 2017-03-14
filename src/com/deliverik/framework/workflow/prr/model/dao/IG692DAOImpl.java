/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG692SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;

/**
 * <p>
 *  ����:���񹤵�ͳ��DAOʵ��
 * </p>
 * <p>
 *  ������¼: ���� 2010/10/28 ���񹤵�ͳ��DAOʵ��
 * </p>
 */

public class IG692DAOImpl extends BaseHibernateDAOImpl<IG933Info> implements IG692DAO{

	/**
	 * ���캯��
	 */
	public IG692DAOImpl(){
		super(IG933TB.class);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<List<String>> findByCond(
			final IG692SearchCond cond, final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();		   
			    Map<String,String> userMap = getUserMap(session);  //�����û�ӳ��
			    
			    String CountSQL ="select code.cvalue as type,";
			    query.append(CountSQL);
			    query.append(QuerybyUser(userMap));	 			   
				query.append(session.getNamedQuery("IG692DAO.findByCond").getQueryString());
				
			    getSQL1(cond,query);
			    getSQL2(cond,query);
			    query.append(" ");
			    query.append(session.getNamedQuery("IG692DAO.findByCond2").getQueryString());
			    SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);	
				List serviceFormCountList = q.list();
				
				/**�����б�����*/
				List<List<String>> lineList = getServiceFormCount(session,userMap,serviceFormCountList,cond,0);
				
				
				session.clear();

				return lineList;
			}
		};
		return (List<List<String>>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<List<String>> findByCond2(
			final IG692SearchCond cond, final int start,final int count) {
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();		   
			    Map<String,String> entityItemMap = getEntityItemMap(session);  //�����û�ӳ��
			    
			    String CountSQL ="select code.cvalue as type,";
			    query.append(CountSQL);
			    query.append(QuerybyEntityItem(entityItemMap));	 			   
				query.append(session.getNamedQuery("IG692DAO.findByCond3").getQueryString());
				
			    getSQL1(cond,query);
			    getSQL2(cond,query);
			    query.append(" ");
			    query.append(session.getNamedQuery("IG692DAO.findByCond2").getQueryString());
			    SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);	
				List serviceFormCountList = q.list();
				
				/**�����б�����*/
				List<List<String>> lineList = getServiceFormCount(session,entityItemMap,serviceFormCountList,cond,1);
				
				
				session.clear();

				return lineList;
			}
		};
		return (List<List<String>>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL1(IG692SearchCond cond, StringBuffer query){
		//ʱ�俪ʼ
		if( StringUtils.isNotEmpty(cond.getDate_from()) ){
			query.append(" AND sf.SFINSTIME >=:date_from ");
		}	
		//ʱ�����
		if( StringUtils.isNotEmpty(cond.getDate_to()) ){
			query.append(" AND sf.SFINSTIME <=:date_to ");
		}	
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL2(IG692SearchCond cond, StringBuffer query){
		//�ʲ�
		if( StringUtils.isNotEmpty(cond.getSfcid())){
			query.append(" AND code.pcid =:sfcid ");
		}	
	}
	
	/**
	 * ��ȡ ��̬��ת�е�sql
	 * @param userList
	 * @return
	 */
	private StringBuffer QuerybyUser(Map<String,String>userList){
		
		StringBuffer sql = new StringBuffer();
		Set<String> keySet = userList.keySet();
		 Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String userid = iterator.next();
			sql.append("sum(case when u.userid='"+userid+"'then 1 else 0 end) as user"+userid+",");	
		}		
		return sql;
	}
	/**
	 * ��ȡ ��̬��ת�е�sql
	 * @param userList
	 * @return
	 */
	private StringBuffer QuerybyEntityItem(Map<String,String>entityList){
		
		StringBuffer sql = new StringBuffer();
		Set<String> keySet = entityList.keySet();
		 Iterator<String> iterator = keySet.iterator();
		while(iterator.hasNext()){
			String eiid = iterator.next();
			sql.append("sum(case when e.eiid ="+eiid+" then 1 else 0 end) as item"+eiid+",");	
		}		
		return sql;
	}
	/**�����û�ӳ��*/
	private Map<String,String> getUserMap(List<Object> userList){
		
		Map<String,String> userMap = new HashMap<String,String>();
		
		for (int i = 0; i < userList.size(); i++) {
			Object[] obj = (Object[])userList.get(i);
			userMap.put(obj[0].toString(), obj[1].toString());		
		} 
		return userMap;
	}
	/**
	 * ���ɱ�ͷ
	 * @param userMap
	 * @return
	 */
	private List<String> createLabel(Map<String, String>userMap,int i){
		
		List<String> lineLabel = new ArrayList<String>();
		
		if (!userMap.isEmpty()) {
		//	String head = i==0?"���\\��Ա":"���\\�ʲ�";
			String head ="���";
			lineLabel.add(head);
			Set<String> keySet = userMap.keySet();
			Iterator<String> iterator = keySet.iterator();
			while(iterator.hasNext()){
				String userid = iterator.next();
				lineLabel.add(userMap.get(userid));	
			}
			if(i!=0){
			lineLabel.add("����");
			}
			lineLabel.add("�ܼ�");
		}	
        return lineLabel;
	}
	/**
	 * �����û��б�
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String,String> getUserMap(Session session){
		
	    String userQuery ="SELECT distinct u.userid,u.username FROM IG933 sf,user  u " +
	    		"where sf.SFREGISTERID = u.userid";
	    SQLQuery q = session.createSQLQuery(userQuery);
	    List<Object> userList = q.list();
	    return getUserMap(userList);
	}
	/**
	 * �����û��б�
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String,String> getEntityItemMap(Session session){
		
	    String userQuery ="SELECT distinct e.eiid,e.einame FROM IG933 sf,IG013 e " +
	    		          "where sf.sfeiid = e.eiid";
	    SQLQuery q = session.createSQLQuery(userQuery);
	    List<Object> entityItemList = q.list();
	    return getUserMap(entityItemList);
	}
	/**
	 * ���� ���񹤵�ͳ���б�
	 * @param session
	 * @param userMap
	 * @param list
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List<List<String>> getServiceFormCount(Session session,Map<String,String>userMap,List list,IG692SearchCond cond,int head){
		
		List<List<String>> lineList = new ArrayList<List<String>>();
		
		//���ɱ�ͷ
		List<String> lineLabel = createLabel(userMap,head);              				
		lineList.add(lineLabel);
		for(int i =0;i<list.size();i++){
		  Object obj[] = (Object[])(list.get(i));
		  List<String> entity = new ArrayList<String>();
		  for(int j=0;j<obj.length;j++){		  
			  entity.add(obj[j].toString());
		  }
		  lineList.add(entity);
		}
		
		if(list.size()>0){
		//���ɱ�β
		List<String> endList = new ArrayList<String>();
		 endList = head==0?getEndLabelbyUser(session, userMap, cond):getEndLabelbyEntityItem(session, userMap, cond);
		
	    //���ɱ�β
		//�����β
		lineList.add(endList);
		}
		return lineList;
	}
	/**
	 * ����ͳ�� ��β ��Ա
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List<String> getEndLabelbyUser(Session session,Map<String,String>userMap,IG692SearchCond cond){
		List<String> endList = new ArrayList<String>();
		StringBuffer endSQL = new StringBuffer();
		endSQL.append("select ");
		endSQL.append(QuerybyUser(userMap));
		//����sql
		endSQL.append(session.getNamedQuery("IG692DAO.findByCond").getQueryString());
		//��������1
	    getSQL1(cond, endSQL);
	    //��������2
	    getSQL2(cond,endSQL);
		SQLQuery q = session.createSQLQuery(endSQL.toString());
		q.setProperties(cond);
		List listEnd = q.list();
		
		for (int i = 0; i < listEnd.size(); i++) {
			endList.add("�ܼ�");
			Object[] objend = (Object[])listEnd.get(i);
			for (int j = 0; j < objend.length; j++) {			
				endList.add(objend[j].toString());
			}		
		}	
		return endList;
	}
	/**
	 * ����ͳ�� ��β ��Ա
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List<String> getEndLabelbyEntityItem(Session session,Map<String,String>userMap,IG692SearchCond cond){
		List<String> endList = new ArrayList<String>();
		StringBuffer endSQL = new StringBuffer();
		endSQL.append("select ");
		endSQL.append(QuerybyEntityItem(userMap));	
		//����sql
		endSQL.append(session.getNamedQuery("IG692DAO.findByCond3").getQueryString());
		//��������1
	    getSQL1(cond, endSQL);
	    //��������2
	    getSQL2(cond,endSQL);
		SQLQuery q = session.createSQLQuery(endSQL.toString());
		q.setProperties(cond);
		List listEnd = q.list();
		
		for (int i = 0; i < listEnd.size(); i++) {
			endList.add("�ܼ�");
			Object[] objend = (Object[])listEnd.get(i);
			for (int j = 0; j < objend.length; j++) {			
				endList.add(objend[j].toString());
			}		
		}	
		return endList;
	}
}
