/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG512DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * 流程关系业务逻辑实现
 * 
 */
public class IG512BLImpl extends BaseBLImpl implements IG512BL{
	
	/** 比较器，按建立时间*/
	protected static final ProcessRecordRelationComparator processRecordRelationComparator = new ProcessRecordRelationComparator();
	
	
	/** Ig512 DAO */
	protected IG512DAO ig512DAO;
	
	public void setIg512DAO(
			IG512DAO ig512DAO) {
		this.ig512DAO = ig512DAO;
	}
	
	/**
	 * 获取流程关系实例
	 * @return Ig512TB
	 */
	public IG512TB getIG512TBInstance(){
		return new IG512TB();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG512SearchCond cond){
		
		return ig512DAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param prrid 流程关系ID
	 * @return 流程关系
	 */
	public IG512Info searchIG512InfoByKey(Integer prrid) throws BLException{
		
		return checkExistProcessRecordRelation(prrid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程关系信息
	 */
	public List<IG512Info> searchIG512InfoAll(){
		
		return ig512DAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG512Info> searchIG512Info(IG512SearchCond cond, int start, int count){
		
		return ig512DAO.findByCond(cond,start,count);
	}

	/**
	 * 登录处理
	 * 
	 * @param ig512Info 登录数据
	 * @return 流程关系
	 */
	public IG512Info registIG512Info(IG512Info ig512Info) throws BLException{
		
		return ig512DAO.save(ig512Info);
	}

	/**
	 * 删除处理
	 * 
	 * @param prrid 流程关系ID
	 * @return
	 */
	public void deleteIG512Info(Integer prrid) throws BLException{
		
		IG512Info processRecordRelation = checkExistProcessRecordRelation(prrid);
		
		ig512DAO.delete(processRecordRelation);
	}

	/**
	 * 变更处理
	 * 
	 * @param ig512Info 变更数据
	 * @return 流程关系
	 */
	public IG512Info updateIG512Info(IG512Info ig512Info) throws BLException{
		
		checkExistProcessRecordRelation(ig512Info.getPrrid());
		return ig512DAO.save(ig512Info);
	}

	/**
	 * 流程关系存在检查
	 * 
	 * @param prrid 流程关系ID
	 * @return 流程关系
	 * @throws BLException 
	 */
	protected IG512Info checkExistProcessRecordRelation(Integer prrid) throws BLException{
		IG512Info info = ig512DAO.findByPK(prrid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程关系基本");
		}
		return info;
	}
	
	/**
	 * 流程关系按建立时间排序（升序）
	 * 
	 * @param ig512InfoList 流程关系列表
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> ig512InfoList) {
		if(ig512InfoList != null && ig512InfoList.size() > 0) {
			Collections.sort(ig512InfoList, processRecordRelationComparator);
		}
	}
	
}

	/**
	 * 比较器，按建立时间（升序）
	 * 
	 * */
	class ProcessRecordRelationComparator implements Comparator<IG512Info> {
	
		public int compare(IG512Info arg0, IG512Info arg1) {
			int flag = arg0.getPrrid().compareTo(arg1.getPrrid());
			return flag;
		}
	
	}
