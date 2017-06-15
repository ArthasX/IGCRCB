/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG113DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;

/**
 * <p>概述:表单日志信息业务逻辑实现</p>
 * <p>功能描述：1.存储或更新表单日志</p>
 * <p>          2.保存表单日志值</p>
 * <p>          3.保存表单日志值（批量）</p>
 * <p>          4.根据流程记录ID获取表单日志值信息集合</p>
 * <p>          5.根据查询条件获取表单日志值信息集合</p>
 * <p>          6.根据表单日志ID获取表单日志值信息集合</p>
 * <p>          7.获取表单日志实例</p>
 * <p>          8.表单日志值信息存在检查</p>
 * <p>创建记录：</p>
 */
public class IG113BLImpl extends BaseBLImpl implements IG113BL {

	/** 表单日志信息检索DAO */
	protected IG113DAO ig113DAO;

	
	
	public void setIg113DAO(IG113DAO ig113DAO) {
		this.ig113DAO = ig113DAO;
	}

	/**
	 * 功能：存储或更新表单日志
	 * @param 表单日志List
	 * 
	 */
	public void saveOrUpdIG113Info(List<IG113Info> prInfoList)throws BLException {
		ig113DAO.saveOrUpdateAll(prInfoList);
	}

	/**
	 * 功能：保存表单日志值
	 * @param 表单日志值集合
	 * @throws BLException
	 */
	public IG113Info registIG113Info(IG113Info ig113Info) throws BLException{
		IG113Info recordLogVarInfo = ig113DAO.save(ig113Info);
		//ig113DAO.saveOrUpdateAll(RecordLogVarInfoList);
		return recordLogVarInfo;
	}
	
	/**
	 * 功能：保存表单日志值
	 * @param 表单日志值集合
	 * @throws BLException
	 */
	public void UpdateIG113Info(List<IG113Info> ig113InfoList) throws BLException{
		ig113DAO.saveOrUpdateAll(ig113InfoList);
	}
	
	/**
	 * 功能：根据流程记录ID获取表单日志值信息集合
	 * @param 表单日志值信息集合
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByIG036Info(Integer rlid){
		IG113SearchCondImpl cond = new IG113SearchCondImpl();
		cond.setRlid(rlid);
		List<IG113Info> prInfoList = ig113DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	/**
	 * 功能：根据查询条件获取表单日志值信息集合
	 * @param 表单日志值信息集合
	 * @throws BLException
	 */
	public List<IG113Info> searchIG113InfoByCond(IG113SearchCond cond){
		List<IG113Info> prInfoList = ig113DAO.findByCond(cond, 0, 0);
		return prInfoList;
	}
	
	
	/**
	 * 功能：根据表单日志ID获取表单日志值信息集合
	 * @param rlvid 表单日志ID
	 * @throws BLException 
	 */
	public IG113Info searchIG113InfoByRlvid(Integer rlvid) throws BLException{
		return checkExistRecordLogVarInfo(rlvid);
	}
	
	/**
	 * 功能：获取表单日志实例
	 * 
	 * @return RecordLogVarInfoTB
	 */
	
	public IG113TB getIG113TBInstance(){
		return new IG113TB();
	}
	
	/**
	 * 功能：表单日志值信息存在检查
	 * 
	 * @param piid 表单日志ID
	 * @return 表单日志值信息
	 * @throws BLException 
	 */
	private IG113Info checkExistRecordLogVarInfo(Integer rlvid) throws BLException{
		IG113Info info = ig113DAO.findByPK(rlvid);
		if( info == null) {
			throw new BLException(BLErrorType.COMMON_ERROR_TYPE,
					"IGCO10000.E004","表单日志基本");
		}
		
		return info;
	}

}
