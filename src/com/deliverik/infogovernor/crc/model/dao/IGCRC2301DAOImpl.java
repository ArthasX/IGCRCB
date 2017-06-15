/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: ���򿪷�ͳ����ͼDAOʵ�� 
 * ��������: ���򿪷�ͳ����ͼDAOʵ�� 
 * ������¼: yukexin 2014-8-12 11:11:31
 * �޸ļ�¼:
 */
public class IGCRC2301DAOImpl extends BaseHibernateDAOImpl<IGCRC2301VWInfo> implements IGCRC2301DAO{

	
	/**
	 * ���캯��
	 */
	public IGCRC2301DAOImpl() {
		super(IGCRC2301VW.class);
	}

	
	/**
     * ���ݶ���ȶԽ��
     * @param cond ��������
     * @return ��������б�
     */
	@SuppressWarnings("unchecked")
	public List<IGCRC2301VWInfo> searchIGCRC2301VWInfo(final IGCRC2301Cond cond) {
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException, SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                query.append(session.getNamedQuery("EntityItemIGCRC2301VWDAO.entityItemIGCRC2301VWDAO").getQueryString());
	                // ƴ�Ӳ�ѯ����
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
	 * ������������
	 * 		��ѯ�����ش�����ֻ��Ҫprid���ϼ���
	 * @param cond ��������
	 * @return ��������б�
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
                query.append(" and psname in ('���Ը���','����','ȷ��') ");
                query.append(" and rldesc not in ('ɾ��������','��Ӳ�����') ");
                                
                // ƴ�Ӳ�ѯ����
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
	 * ������������
	 *		��ѯ������������,ֻ��Ҫprid���ϼ���
	 * @param cond ��������
	 * @return ��������б�
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
    private void getSql(StringBuffer query, IGCRC2301Cond cond){
    	//����
		query.append(" and g.propentime like '"
				+ (cond.getYear() == null || "".equals(cond.getYear()) ? "%"
						: cond.getYear())
				+ "/"
				+ (cond.getMonth() == null || "".equals(cond.getMonth()) ? ""
						: "" + cond.getMonth()) + "%'");
		
		query.append(" group by g.ppusername,g.ppuserid");
    }
    
    /**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
    private void getSql2(StringBuffer query, IGCRC2301Cond cond){
    	//����
    	
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
    	//���Ը��²���
    	if(flag.equals("1")){
    		query.append(" and f.psdcode = 'X' ");
    		query.append(" and f.rldesc = '��ͨ��' ");
    	}
    	//���Բ���
    	if(flag.equals("2")){
    		query.append(" and f.psdcode = 'W' ");
    		query.append(" and f.rldesc = '������ͨ��' ");
    	}
    	//ȷ�ϲ���
    	if(flag.equals("3")){
    		query.append(" and f.psdcode = 'V' ");
    		query.append(" and f.rldesc = 'ȷ�ϲ�ͨ��' ");
    	}
		query.append(" group by g.prid ");
    }
    
    
}
