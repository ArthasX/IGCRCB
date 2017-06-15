/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl.NamedParamMap;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg898MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg898MapVWTB;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图DAO实现
  * 功能描述: 报表字段与流程公有表单值映射关系视图DAO实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class PdfIg898MapVWDAOImpl extends
		BaseHibernateDAOImpl<PdfIg898MapVWInfo> implements PdfIg898MapVWDAO {

	/**
	 * 构造函数
	 */
	public PdfIg898MapVWDAOImpl(){
		super(PdfIg898MapVWTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfIg898MapVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfIg898MapVWInfo findByPK(Serializable pk) {
		PdfIg898MapVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PdfIg898MapVWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PdfIg898MapVWInfo> findByCond(final PdfIg898MapVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if ("0".equals(cond.getOrderby())) {
		    c.addOrder(Order.asc("pvcolpidid"));
		    c.addOrder(Order.asc("pvrownumber"));
		} else if ("1".equals(cond.getOrderby())) {
		    c.addOrder(Order.asc("pvrownumber"));
		}
		return findByCriteria(c, start, count);
	}

	/**
     * 取得表格类型表单的行数
     *
     * @param cond 检索条件
     * @return 表格表单行数
     */
    @SuppressWarnings("rawtypes")
	public String getMaxRowNumber(final PdfIg898MapVWSearchCond cond){
        String sql =  "select pvrownumber from PdfIg898MapVWTB " +
        		"where prid=:prid and pvrownumber like:pvrownumber and pdatabinding=:pdatabinding order by length(pvrownumber) asc,pvrownumber desc";
        NamedParamMap paramMap = getNamedParamMap();
        paramMap.setInteger("prid", cond.getPrid());
        paramMap.setString("pdatabinding", cond.getPdatabinding());
        if(StringUtils.isNotEmpty(cond.getPvrownumber())){
        	paramMap.setString("pvrownumber", cond.getPvrownumber()+ "%");
        }else{
        	paramMap.setString("pvrownumber", "%");
        }
        List resultList = findByNamedParamMap(sql, paramMap);
        if (resultList.size() == 0) {
            return null;
        } else {
            if (StringUtils.isEmpty((String)resultList.get(0))) {
                return null;
            } else {
            	int maxLength = ((String)resultList.get(0)).split("_").length;
            	String maxResult = (String)resultList.get(0);
            	if("TQ2001".equals(cond.getPdatabinding())||"TM1001".equals(cond.getPdatabinding())||"TB13001".equals(cond.getPdatabinding())){
            		for(int i =1;i<resultList.size();i++){
                		if(isEqualLength(maxLength,((String)resultList.get(i)).split("_").length)){
                			String[] firstObj = ((String)resultList.get(i-1)).split("_");
                			String[] secondObj = ((String)resultList.get(i)).split("_");
                			if(Integer.parseInt(firstObj[0])<Integer.parseInt(secondObj[0])){
                				maxResult = (String)resultList.get(i);
                			}
                		}
                	}
            	}else{
            		for(int i =1;i<resultList.size();i++){
                		if(isEqualLength(maxLength,((String)resultList.get(i)).split("_").length)){
                			String[] firstObj = ((String)resultList.get(i-1)).split("_");
                			String[] secondObj = ((String)resultList.get(i)).split("_");
                			if(Integer.parseInt(firstObj[firstObj.length-1])<Integer.parseInt(secondObj[secondObj.length-1])){
                				maxResult = (String)resultList.get(i);
                			}
                		}
                	}
            	}
                return maxResult;
            }
        }
    }
    /*
     * 判断是否是一样的长度
     */
    public boolean isEqualLength(int obj1,int obj2){
    	if(obj1==obj2){
    		return true;
    	}
    	return false;
    }
    
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(PdfIg898MapVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getPrid()!=null&&cond.getPrid()>0) {
		    c.add(Expression.eq("prid", cond.getPrid()));
		}
		if (StringUtils.isNotEmpty(cond.getPvrownumber())) {
			c.add(Expression.like("pvrownumber", cond.getPvrownumber()+"%"));
		}
		if (StringUtils.isNotEmpty(cond.getPdatabinding())) {
		    if ("null".equals(cond.getPdatabinding())) {
		        c.add(Expression.sql("(pdatabinding is null or pdatabinding = '')"));
		    } else {
		        c.add(Expression.eq("pdatabinding", cond.getPdatabinding()));
		    }
		}
		c.add(Expression.isNotNull("databinding"));
		return c;
	}

}