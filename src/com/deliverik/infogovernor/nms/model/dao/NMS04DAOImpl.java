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
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS04Info;
import com.deliverik.infogovernor.nms.model.NMS04VWInfo;
import com.deliverik.infogovernor.nms.model.condition.NMS04SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS04VWSearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS04TB;
import com.deliverik.infogovernor.nms.model.entity.NMS04VW;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��Ϣʵ��DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS04DAOImpl extends BaseHibernateDAOImpl<NMS04Info> implements NMS04DAO {
	/**
	 * ���췽��
	 */
	public NMS04DAOImpl(){
		super(NMS04TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS04SearchCond cond){
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
	public List<NMS04Info> findByCond(NMS04SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS04SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
     * ������汾��ѯ�豸��Ϣ
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    @SuppressWarnings("unchecked")
    public List<NMS04VWInfo> searchDeviceByGroup(final NMS04VWSearchCond cond, final Integer version) {
        HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                StringBuffer n16where = new StringBuffer();
                String n8where = "";
                if(StringUtils.isNotEmpty(cond.getUserid())){
                    n16where.append(" n16.userid = '" + cond.getUserid() + "' ") ;
                    n8where = " (n8.userid = '" + cond.getUserid() + "' or n8.userid is null or n8.userid = '' ) " ;
                } else {
                    n16where.append(" (n16.userid is null or n16.userid = '') ");
                    n8where = " (n8.userid is null or n8.userid = '') ";
                }
                
                if(StringUtils.isNotEmpty(cond.getShowType())){
                    if("1".equals(cond.getShowType())){
                        n16where.append(" and (n16.showtype ='" + cond.getShowType() + "' or n16.showtype is null or n16.showtype = '' )");
                    } else {
                        n16where.append(" and n16.showtype ='" + cond.getShowType() + "'");
                    }
                } else {
                    n16where.append(" and (n16.showtype is null or n16.showtype = '' )");
                }
                
                query.append("SELECT n4.*, n5.gid, n5.gversion, n16.x, n16.y FROM nms05_" + version + " n5 ")
                .append(" LEFT JOIN nms04 n4 ON (n5.did = n4.id) ")
                .append(" LEFT JOIN (SELECT * FROM nms16_" + version + " n16 WHERE " + n16where +") n16 ON (n5.did = n16.did AND n5.gid = n16.gid AND n5.gversion = n16.gversion)")
                .append(" WHERE NOT EXISTS (SELECT * FROM nms08 n8 WHERE n5.did = n8.did AND n5.gid = n8.gid AND n5.gversion = n8.gversion AND " + n8where + ") ");
                
                
                // ƴ�Ӳ�ѯ����
                getSql(cond, query);
                query.append(" order by n4.type desc ");
                SQLQuery q = session.createSQLQuery(query.toString());
                
                q.setProperties(cond);
                q.addEntity("n5",NMS04VW.class);
                
                setFetchPoint(q, 0, 0);
                List<NMS04VWInfo> list = q.list();
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<NMS04VWInfo>) execute(action);
    }
    
    private void getSql(NMS04VWSearchCond cond, StringBuffer query){
        if(null != cond.getGid()){
            query.append(" and n5.gid =:gid ");
        }
        if(null != cond.getGversion()){
            query.append(" and n5.gversion =:gversion ");
        }
    }
}
