package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;

/**
 * 数据信息DAO接口
 * 
 */
public interface CodeDetailTBDAO extends BaseHibernateDAO<CodeDetail> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<CodeDetail> findAll();

	/**
	 * 主键检索处理
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CodeDetail findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CodeDetailSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CodeDetail> findByCond(final CodeDetailSearchCond cond, 
			final int start, final int count,int orderbyFlag);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CodeDetail> findByCond(final CodeDetailSearchCond cond,int orderbyFlag);

	/**
	 * 更新日期检索处理
	 * 
	 * @param ccid 代码分类ID
	 * @param pccid 父代码分类ID
	 * @param pcid 父代码ID
	 * @return 更新日期
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid);
	
	/**
	 * 查询下级最大层次码
	 * @param syscoding 父级层次码
	 * @return 下级最大层次码
	 */
	
	public String getSyscoding(final String syscoding);
	
	/**
	 * 查询下级最大层次码
	 * @param ccid 根节点标识
	 * @return 下级最大层次码
	 */
	
	public String getSyscodingLevel1(final String ccid);
	
	/**
	 * 查询本级最大cid
	 * @param ccid 层次id
	 * @return 本级最大cid
	 */
	
	public String getMaxcid(final String ccid);
	
}
