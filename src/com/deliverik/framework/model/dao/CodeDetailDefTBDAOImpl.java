package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;
import com.deliverik.framework.model.entity.CodeDetailDefTB;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * 数据信息DAO实现
 * 
 */
@SuppressWarnings({"deprecation","rawtypes"})
public class CodeDetailDefTBDAOImpl extends BaseHibernateDAOImpl<CodeDetailDef> implements CodeDetailDefTBDAO {

	static Log log = LogFactory.getLog(CodeDetailDefTBDAOImpl.class);

	/**
	 * 构造函数
	 */
	public CodeDetailDefTBDAOImpl(){
		super(CodeDetailDefTB.class);
	}

	/**
	 * DAO初期化处理
	 */
	@Override
	protected void initDao() throws Exception {
		getHibernateTemplate().setCacheQueries(true);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	@Override
	public List<CodeDetailDef> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ccid"));
		List<CodeDetailDef> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public CodeDetailDef findByPK(Serializable pk) {

		CodeDetailDef codeDetail = super.findByPK(pk);
		if(codeDetail == null) return null;

		return codeDetail;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CodeDetailDefSearchCond cond){
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
	public List<CodeDetailDef> findByCond(final CodeDetailDefSearchCond cond, 
			final int start, final int count,int orderbyFlag){
		DetachedCriteria c = getCriteria(cond);
		if (orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0) {
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("cid"));
		} else if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1){
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("pccid"));
			c.addOrder(Order.asc("pcid"));
			c.addOrder(Order.asc("cid"));
		} 
		List<CodeDetailDef> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CodeDetailDef> findByCond(final CodeDetailDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getSyscoding())){
			c.add(Expression.like("syscoding", cond.getSyscoding()+"%"));
		}
		//分类CD
		if( !StringUtils.isEmpty(cond.getCcid())){
			c.add(Expression.eq("ccid", cond.getCcid()));
		}	
		//状态
		if( !StringUtils.isEmpty(cond.getCdstatus())){
			c.add(Expression.eq("cdstatus", cond.getCdstatus()));
		}
		if(StringUtils.isNotEmpty(cond.getPccid())){
			c.add(Expression.eq("pccid", cond.getPccid()));
		}
		if(StringUtils.isNotEmpty(cond.getPcid())){
			c.add(Expression.eq("pcid", cond.getPcid()));
		}
		if( !StringUtils.isEmpty(cond.getSyscoding_q())){
		    c.add(Expression.eq("syscoding", cond.getSyscoding_q()));
		}
		if(StringUtils.isNotEmpty(cond.getCvalue_like())){
			c.add(Expression.like("cvalue", cond.getCvalue_like()+"%"));
		}
		List<CodeDetailDef> ret = findByCriteria(c, 0, 0);
		return ret;
	}
	
	/**
	 * 根据层次码查询该分类下的所有最末级业务系统分类
	 * @param syscoding
	 * @return
	 */
	public List<CodeDetailDef> getFinalBusSys(String syscoding){
		
		
		List<CodeDetailDef> result = new ArrayList<CodeDetailDef>();
		
		String sql = "select * from codedetaildef where syscoding like :syscoding and syscoding not in (select psyscoding from codedetaildef where syscoding like :syscoding)";
		
		SQLQuery q = getSession().createSQLQuery(sql);
		
		q.addEntity(CodeDetailDefTB.class);
		
		q.setParameter("syscoding", syscoding+"%");
		
		result = q.list();
		
		return result; 
	}
	
	
	public List<CodeDetailDef> findByCond(final CodeDetailDefSearchCond cond,int orderbyFlag){
		DetachedCriteria c = getCriteria(cond);
		if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2){//查1级结点树
			c.addOrder(Order.asc("syscoding"));
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("pccid"));
			c.addOrder(Order.asc("pcid"));
			c.addOrder(Order.asc("cid"));
		}else if(orderbyFlag==CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3){//查1级结点及其子结点树
			c.addOrder(Order.asc("syscoding"));
			c.addOrder(Order.asc("ccid"));
			c.addOrder(Order.asc("pccid"));
			c.addOrder(Order.asc("pcid"));
			c.addOrder(Order.asc("cid"));
		}
		List<CodeDetailDef> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CodeDetailDefSearchCond cond){
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
		
		if(StringUtils.isNotEmpty(cond.getCvalue_like())){
			c.add(Expression.like("cvalue", cond.getCvalue_like()+"%"));
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
			" select max( c.updtime ) from CodeDetailDefTB c" +
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
		
		String sql =  "select max(cd.syscoding) from CodeDetailDefTB cd where cd.psyscoding = :syscoding";
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
		
		String sql =  "select max(cd.syscoding) from CodeDetailDefTB cd where cd.ccid = :ccid";
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

     String sql =  "select max(cd.cid) from CodeDetailDefTB cd where cd.ccid = :ccid";
		NamedParamMap p = getNamedParamMap();
		p.setString("ccid", ccid);
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}

}
