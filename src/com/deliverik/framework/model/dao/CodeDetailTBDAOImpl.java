package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * ������ϢDAOʵ��
 * 
 */
@SuppressWarnings({"deprecation","rawtypes"})
public class CodeDetailTBDAOImpl extends BaseHibernateDAOImpl<CodeDetail> implements CodeDetailTBDAO {

	static Log log = LogFactory.getLog(CodeDetailTBDAOImpl.class);

	/**
	 * ���캯��
	 */
	public CodeDetailTBDAOImpl(){
		super(CodeDetailTB.class);
	}

	/**
	 * DAO���ڻ�����
	 */
	protected void initDao() throws Exception {
		getHibernateTemplate().setCacheQueries(true);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<CodeDetail> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ccid"));
		List<CodeDetail> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public CodeDetail findByPK(Serializable pk) {

		CodeDetail codeDetail = super.findByPK(pk);
		if(codeDetail == null) return null;

		return codeDetail;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CodeDetailSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeDetail> findByCond(final CodeDetailSearchCond cond, 
			final int start, final int count,int orderbyFlag){
		DetachedCriteria c = getCriteria(cond);
		if (orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0) {
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("cdorder"));
			c.addOrder(Order.asc("cid"));
		} else if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1){
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("cdorder"));
			c.addOrder(Order.asc("pccid"));
			c.addOrder(Order.asc("pcid"));
			c.addOrder(Order.asc("cid"));
		} 
		List<CodeDetail> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	public List<CodeDetail> findByCond(final CodeDetailSearchCond cond,int orderbyFlag){
		DetachedCriteria c = getCriteria(cond);
		if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2){//��1�������
			c.addOrder(Order.asc("syscoding"));
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("cdorder"));
			c.addOrder(Order.asc("pccid"));
			c.addOrder(Order.asc("pcid"));
			c.addOrder(Order.asc("cid"));
		}else if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3){//��1����㼰���ӽ����
			c.addOrder(Order.asc("syscoding"));
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("cdorder"));
			c.addOrder(Order.asc("pccid"));
			c.addOrder(Order.asc("pcid"));
			c.addOrder(Order.asc("cid"));
		}
		List<CodeDetail> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CodeDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//����CD
		if( !StringUtils.isEmpty(cond.getCcid())){
			c.add(Expression.eq("ccid", cond.getCcid()));
		}	
		//����CD
		if( !StringUtils.isEmpty(cond.getCid())){
			c.add(Expression.eq("cid", cond.getCid()));
		}	
		//����CD(��)
		if( !StringUtils.isEmpty(cond.getPccid())){
			c.add(Expression.eq("pccid", cond.getPccid()));
		}
		//����CD(��)
		if( !StringUtils.isEmpty(cond.getPcid())){
			c.add(Expression.eq("pcid", cond.getPcid()));
		}
		
		//״̬
		if( !StringUtils.isEmpty(cond.getCdstatus())){
			c.add(Expression.eq("cdstatus", cond.getCdstatus()));
		}
		
		//״̬
		if( !StringUtils.isEmpty(cond.getBusinesscode_like())){
			c.add(Expression.like("businesscode", "%"+cond.getBusinesscode_like()+"%"));
			c.add(Expression.ne("businesscode",CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD));
		}
		
		//������
		if( !StringUtils.isEmpty(cond.getCvalue())){
			c.add(Expression.eq("cvalue", cond.getCvalue()));
		}
		
		//��1�����
//		if( cond.getClevel()==null){
//			c.add(Expression.eq("pccid", cond.getClevel()));
//		}
		//��1����㼰���ӽ����
		if( !StringUtils.isEmpty(cond.getSyscoding_q())){
			c.add(Expression.like("syscoding", cond.getSyscoding_q()+"%"));
		}
		
		if( !StringUtils.isEmpty(cond.getSyscoding())){
			c.add(Expression.eq("syscoding", cond.getSyscoding()));
		}
		if(!StringUtils.isEmpty(cond.getCdinfo_eq())){
			c.add(Expression.eq("cdinfo", cond.getCdinfo_eq()));
		}
		if(cond.getCidList()!=null&&cond.getCidList().size()>0){
			c.add(Expression.in("cid", cond.getCidList()));
		}
		return c;
	}

	/**
	 * �������ڼ�������
	 * 
	 * @param ccid �������ID
	 * @param pccid ���������ID
	 * @param pcid ������ID
	 * @return ��������
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid){
		String sql = 
			" select max( c.updtime ) from CodeDetailTB c" +
			"  where c.ccid = :ccid ";
		
		NamedParamMap p = getNamedParamMap();

		p.setString("ccid", ccid);

		if (pccid != null) {
			sql = sql + " and pccid = :pccid ";
			p.setString("pccid", pccid);
		}

		if (pcid != null) {
			sql = sql + " and pcid = :pcid ";
			p.setString("pcid", pcid);
		}

		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		
		return (String) l.get(0);
	}
	
	/**
	 * ��ѯ�¼��������
	 * @param syscoding ���������
	 * @return �¼��������
	 */
	
	public String getSyscoding(final String syscoding){
		
		String sql =  "select max(cd.syscoding) from CodeDetailTB cd where cd.psyscoding = :syscoding";
		NamedParamMap p = getNamedParamMap();
		p.setString("syscoding", syscoding);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
	/**
	 * ��ѯ�¼��������
	 * @param ccid ���ڵ��ʶ
	 * @return �¼��������
	 */
	public String getSyscodingLevel1(final String ccid){
		
		String sql =  "select max(cd.syscoding) from CodeDetailTB cd where cd.ccid = :ccid";
		NamedParamMap p = getNamedParamMap();
		p.setString("ccid", ccid);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
	/**
	 * ��ѯ�������cid
	 * @param ccid ���id
	 * @return �������cid
	 */
	public String getMaxcid(final String ccid){

     String sql =  "select max(cd.cid) from CodeDetailTB cd where cd.ccid = :ccid";
		NamedParamMap p = getNamedParamMap();
		p.setString("ccid", ccid);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
}
