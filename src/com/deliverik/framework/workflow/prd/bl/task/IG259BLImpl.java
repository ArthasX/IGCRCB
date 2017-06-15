/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG259DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;

/**
 * <p>
 * 流程模板信息处理业务逻辑实现 
 * </p>
 */

public class IG259BLImpl extends BaseBLImpl implements IG259BL{
	
	/**流程模板操作*/
	protected IG259DAO ig259DAO;
	
	/**
	 * 设置流程模板操作
	 * @param ig259DAO
	 */
	public void setIg259DAO(IG259DAO ig259DAO) {
		this.ig259DAO = ig259DAO;
	}
	
	/**
	 * 获流程模板实例
	 * 
	 * @return ProcessTemplateTB
	 * @throws BLException
	 */
	
	public IG259TB getIG259TBInstance(){
		return new IG259TB();
	}
	
	
	/**
	 * 获取使用中的流程模板信息
	 * @param processType String
	 * @return ProcessTemplate
	 * @throws BLException
	 */
	
	public IG259Info searchIG259ByPrType(String processType){
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(processType);
		cond.setPtstatus("a");
		List<IG259Info> list= ig259DAO.findByCond(cond, 0, 0);
		if(list.isEmpty()){
			return null;
		}else{
			return list.get(0);
		}
	}
	/**
	 * 条件检索流程模板信息
	 * @param cond 流程模板信息检索条件
	 * @return 流程模板信息结果列表
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond) {
		List<IG259Info> processTemplateList = ig259DAO.findByCond(cond, 0, 0);
		return processTemplateList;
	}
	
	/**
	 * 条件检索流程模板信息
	 * @param cond 流程模板信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 流程模板信息结果列表
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond, int start, int count) {
		List<IG259Info> processTemplateList = ig259DAO.findByCond(cond, start, count);
		return processTemplateList;
	}
	
	/**
	 * 根据流程模板ID获取流程模板
	 * @param ptid 流程模板ID
	 * @return 流程模板信息
	 * @throws BLException
	 */
	public IG259Info searchIG259InfoByKey(Integer ptid) throws BLException {
		return checkExistIG259Info(ptid);
	}
	
	/**
	 * 新增处理
	 * 
	 * @param Ig273 新增数据
	 * @return 资产信息
	 */
	
	public IG259Info registIG259Info(
			IG259Info ig259Info) throws BLException{
		return ig259DAO.save(ig259Info);
	}
	
	/**
	 * 删除处理
	 * 
	 * @param ptid 流程模版ID
	 * @return
	 */
	
	public void deleteIG259InfoByKey(Integer ptid) throws BLException{
		IG259Info processTemplate = checkExistIG259Info(ptid);
		ig259DAO.delete(processTemplate);
	}
	
	/**
	 * 变更处理
	 * 
	 * @param processTemplate 变更数据
	 * @return 流程状态跃迁规则
	 */
	
	public IG259Info updateIG259Info(
			IG259Info processTemplate) throws BLException{
		return ig259DAO.save(processTemplate);
	}
	
	/**
	 * 流程模版存在检查
	 * 
	 * @param ptid 流程模版ID
	 * @return 流程模版
	 * @throws BLException 
	 */
	
	protected IG259Info checkExistIG259Info(Integer ptid) throws BLException{
		IG259Info info = ig259DAO.findByPK(ptid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程模版基本");
		}
		return info;
	}
}
