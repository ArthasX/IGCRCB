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
 * ����: �ĵ�ͳ����ͼDAOʵ�� 
 * ��������: �ĵ�ͳ����ͼDAOʵ�� 
 * ������¼: ʷ���� 2014/07/22
 * �޸ļ�¼:
 */
public class IGCRC1303DAOImpl extends BaseHibernateDAOImpl<IGCRC1303VWInfo> implements IGCRC1303DAO{

	
	/**
	 * ���캯��
	 */
	public IGCRC1303DAOImpl() {
		super(IGCRC1303VW.class);
	}

	/**
     * ���ݶ���ȶԽ��
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC1303VWInfo> searchIGCRC1303VWInfo(final IGCRC1303Cond cond, final int start,
			final int count) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC1303VWDAO.entityItemIGCRC1303VWDAO").getQueryString());
	                // ƴ�Ӳ�ѯ����
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
     * ���ݲ�ѯ�������̵Ĳ�������
     */
	public List<String> searchType(){
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                query.append("select ig9.PIVARVALUE " +
                			 "from ig500 ig5,ig599 ig9 " +
                			 "where ig5.PRTITLE like '%�ĵ�����%' " +
                			 		"and ig9.PRID=ig5.PRID " +
                			 		"and ig9.PIVARNAME like '�ĵ�����'");
                
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
     * ��ѯ�����ص��ĵ�������
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
                
                //�ӽ����ȡ��һ������
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
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IGCRC1303Cond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemIGCRC1301VWDAO.getSearchCount").getQueryString());
				
				
				// ƴ�Ӳ�ѯ����
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
    private void getSql(StringBuffer query, IGCRC1303Cond cond){
    	//�ĵ����
        if(StringUtils.isNotEmpty(cond.getEiNumber())){
        	query.append(" and t.eiNumber = '"+cond.getEiNumber()+"'");
        }
        //�ĵ�����
        if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and t.eiName like '%"+cond.getEiName()+"%'");
        }
        //�ĵ�����
        if(StringUtils.isNotEmpty(cond.getEiType())){
        	query.append(" and t.eiType = '"+cond.getEiType()+"'");
        }
        //�ĵ�����
        if(StringUtils.isNotEmpty(cond.getEiSort())){
        	query.append(" and t.eiSort like '%"+cond.getEiSort()+"'");
        }
        //�ĵ��ܼ�
        if(StringUtils.isNotEmpty(cond.getEiDense())){
        	query.append(" and t.eiDense = '"+cond.getEiDense()+"'");
        }
        //����
        if(StringUtils.isNotEmpty(cond.getDepartment())){
        	query.append(" and t.department like '%"+cond.getDepartment()+"%'");
        }
        //������
        /*if(StringUtils.isNotEmpty(cond.getEiName())){
        	query.append(" and EINAME = '"+cond.getEiName()+"'");
        }*/
        //����
        if(StringUtils.isNotEmpty(cond.getContent())){
        	query.append(" and t.content like '%"+cond.getContent()+"%'");
        }

    }
}
