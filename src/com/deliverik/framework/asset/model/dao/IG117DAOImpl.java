package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.entity.IG117TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * 资产信息DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class IG117DAOImpl extends BaseHibernateDAOImpl<IG117Info> implements IG117DAO {

	/**
	 * 构造函数
	 */
	public IG117DAOImpl(){
		super(IG117TB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG117Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eid"));
		List<IG117Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param eid 主键
	 * @return 检索结果
	 */
	public IG117Info findByPK(Serializable eid) {

		IG117Info entity = super.findByPK(eid);
		if(entity == null) return null;

		return entity;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG117SearchCond cond){
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
	public List<IG117Info> findByCond(final IG117SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("esyscoding"));
		List<IG117Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	/**
	 * 新增类型下级用
	 */
	
	public List<IG117Info> findByCond(final IG117SearchCond cond,final String orderType){
		DetachedCriteria c = getCriteria(cond);
		if("assetdomain".equals(orderType)){//查询角色资产管理内容树的结点全名使用
			c.addOrder(Order.asc("esyscoding"));
		}else{
			c.addOrder(Order.desc("eparcoding"));
		}
		
		List<IG117Info> ret = findByCriteria(c);
		return ret;
	}
	
	public List<IG117Info> findByCondCoding(final IG117SearchCond cond)
	{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("esyscoding"));
		List<IG117Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG117SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getEcategory())){
			if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				//c.add(Expression.ne("esyscoding", "999007"));
			    c.add(Expression.ne("esyscoding", "999008"));	
			    c.add(Expression.ne("esyscoding", "999014"));//发票资产
			}else if(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				c.add(Expression.ne("esyscoding", "999008"));	
				c.add(Expression.ne("esyscoding", "999014"));//发票资产
			}
//			else if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
//					&& CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
//				c.add(Expression.ne("esyscoding", "999007"));	
//			}
		} else {
//			if(!StringUtils.isEmpty(cond.getEname())){
//			}else{
//				c.add(Expression.ne("esyscoding", "999007"));
//			}
			c.add(Expression.ne("esyscoding", "999007"));
			c.add(Expression.ne("esyscoding", "999008"));
			if(StringUtils.isNotEmpty(cond.getType()) && "0".equals(cond.getType())){
    			c.add(Expression.ne("esyscoding", "999014"));//发票资产
			}
		}
		//资产模型ID
		if( !StringUtils.isEmpty(cond.getEidStr())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEidStr())));
		}	
		//资产模型编号
		if( !StringUtils.isEmpty(cond.getElabel())){
			c.add(Expression.eq("elabel", cond.getElabel()));
		}	
		//资产模型名
		if( !StringUtils.isEmpty(cond.getEname())){
			c.add(Expression.like("ename", "%" + cond.getEname() + "%"));
		}	
		
		//资产模型分类
		if( !StringUtils.isEmpty(cond.getEcategory_q())){
			c.add(Expression.eq("ecategory", cond.getEcategory()));
		}
		//资产模型分类
		if( !StringUtils.isEmpty(cond.getEcategory()) && 
				!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory()) 
				&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
			c.add(Expression.eq("ecategory", cond.getEcategory()));
		}
		//资产模型一级子类
		if( !StringUtils.isEmpty(cond.getEkey1())){
			c.add(Expression.eq("ekey1", cond.getEkey1()));
		}
		//资产模型二级子类
		if( !StringUtils.isEmpty(cond.getEkey2())){
			c.add(Expression.eq("ekey2", cond.getEkey2()));
		}
		//资产模型三级子类
		if( !StringUtils.isEmpty(cond.getEkey3())){
			c.add(Expression.eq("ekey3", cond.getEkey3()));
		}
		
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("esyscoding", cond.getEsyscoding()));
		}
		if( !StringUtils.isEmpty(cond.getEsyscoding_q())){
			c.add(Expression.like("eparcoding", cond.getEsyscoding_q()));
//			if("999".equals(cond.getEsyscoding_q())){
//				c.add(Expression.ne("esyscoding", "999007"));
//				c.add(Expression.ne("esyscoding", "999008"));
//			}
		}
		if( cond.getSelectList()!=null && cond.getSelectList().size()>0){
			c.add(Expression.in("esyscoding", cond.getSelectList()));
		}
		if( cond.getDelList()!=null && cond.getDelList().size()>0){
			c.add(Expression.not(Expression.in("esyscoding", cond.getDelList())));
		}
		
		//设备登记_类型选择tree
		if( !StringUtils.isEmpty(cond.getEsyscoding_tree()) && StringUtils.isEmpty(cond.getEparcoding())){
			c.add(Expression.eq("esyscoding", cond.getEsyscoding_tree()));
//			if(!StringUtils.isEmpty(cond.getEparcoding())){
//				c.add(Expression.or(Expression.eq("esyscoding", cond.getEsyscoding_tree()),Expression.eq("eparcoding", cond.getEparcoding())));
//			}
		}else{
			//类型登记_上级类型选择tree
			if(!StringUtils.isEmpty(cond.getEparcoding())){
				c.add(Expression.eq("eparcoding", cond.getEparcoding()));
			}
		}
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEparcoding()) && StringUtils.isEmpty(cond.getEsyscoding_tree())){
			c.add(Expression.eq("eparcoding", cond.getEparcoding()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_q())){
			c.add(Expression.eq("eparcoding", cond.getEparcoding_q()));
		}
		
		if( !StringUtils.isEmpty(cond.getEstatus())){
			c.add(Expression.eq("estatus", cond.getEstatus()));
		}
	
		//Entity tree 子结点集合
		if( !StringUtils.isEmpty(cond.getSyscoding_q())){
			c.add(Expression.like("esyscoding", cond.getSyscoding_q()+"%"));
		}
		//资产模型in条件
		if( cond.getEsyscodingList()!=null && cond.getEsyscodingList().size()>0){
			c.add(Expression.in("esyscoding", cond.getEsyscodingList()));
		}

		//资产模型状态修改
		if( !StringUtils.isEmpty(cond.getEparcoding_status())){
			c.add(Expression.eq("eparcoding", cond.getEparcoding_status()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_status_start())){
			c.add(Expression.eq("esyscoding", cond.getEparcoding_status_start()));
		}
		
		//查询not like Esyscoding_nq的模型
		if( !StringUtils.isEmpty(cond.getEsyscoding_nq())){
			c.add(Expression.not(Expression.like("esyscoding", cond.getEsyscoding_nq()+"%")));
		}
		
		if( cond.getDelList_q()!=null && cond.getDelList_q().size()>0){
			for(String esys:cond.getDelList_q()){
				c.add(Expression.not(Expression.like("esyscoding", esys+"%")));
			}
			
		}
		
		return c;
	}
	
	protected DetachedCriteria getCriterias(IG117SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}

}
