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
 * 数据信息DAO实现
 * 
 */
@SuppressWarnings({"deprecation","rawtypes"})
public class CodeDetailTBDAOImpl extends BaseHibernateDAOImpl<CodeDetail> implements CodeDetailTBDAO {

	static Log log = LogFactory.getLog(CodeDetailTBDAOImpl.class);

	/**
	 * 构造函数
	 */
	public CodeDetailTBDAOImpl(){
		super(CodeDetailTB.class);
	}

	/**
	 * DAO初期化处理
	 */
	protected void initDao() throws Exception {
		getHibernateTemplate().setCacheQueries(true);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<CodeDetail> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ccid"));
		List<CodeDetail> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CodeDetail findByPK(Serializable pk) {

		CodeDetail codeDetail = super.findByPK(pk);
		if(codeDetail == null) return null;

		return codeDetail;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CodeDetailSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
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
		if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2){//查1级结点树
			c.addOrder(Order.asc("syscoding"));
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("cdorder"));
			c.addOrder(Order.asc("pccid"));
			c.addOrder(Order.asc("pcid"));
			c.addOrder(Order.asc("cid"));
		}else if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3){//查1级结点及其子结点树
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CodeDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//分类CD
		if( !StringUtils.isEmpty(cond.getCcid())){
			c.add(Expression.eq("ccid", cond.getCcid()));
		}	
		//数据CD
		if( !StringUtils.isEmpty(cond.getCid())){
			c.add(Expression.eq("cid", cond.getCid()));
		}	
		//分类CD(父)
		if( !StringUtils.isEmpty(cond.getPccid())){
			c.add(Expression.eq("pccid", cond.getPccid()));
		}
		//数据CD(父)
		if( !StringUtils.isEmpty(cond.getPcid())){
			c.add(Expression.eq("pcid", cond.getPcid()));
		}
		
		//状态
		if( !StringUtils.isEmpty(cond.getCdstatus())){
			c.add(Expression.eq("cdstatus", cond.getCdstatus()));
		}
		
		//状态
		if( !StringUtils.isEmpty(cond.getBusinesscode_like())){
			c.add(Expression.like("businesscode", "%"+cond.getBusinesscode_like()+"%"));
			c.add(Expression.ne("businesscode",CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD));
		}
		
		//类名称
		if( !StringUtils.isEmpty(cond.getCvalue())){
			c.add(Expression.eq("cvalue", cond.getCvalue()));
		}
		
		//查1级结点
//		if( cond.getClevel()==null){
//			c.add(Expression.eq("pccid", cond.getClevel()));
//		}
		//查1级结点及其子结点树
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
	 * 更新日期检索处理
	 * 
	 * @param ccid 代码分类ID
	 * @param pccid 父代码分类ID
	 * @param pcid 父代码ID
	 * @return 更新日期
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
	 * 查询下级最大层次码
	 * @param syscoding 父级层次码
	 * @return 下级最大层次码
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
	 * 查询下级最大层次码
	 * @param ccid 根节点标识
	 * @return 下级最大层次码
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
	 * 查询本级最大cid
	 * @param ccid 层次id
	 * @return 本级最大cid
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
