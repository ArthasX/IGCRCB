package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.dao.IG036DAO;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;

/**
 * <p>
 * 日志信息业务逻辑实现
 * </p>
 */
public class IG036BLImpl extends BaseBLImpl implements IG036BL{
	
	/**历史记录基本信息操作*/
	protected IG036DAO ig036DAO;
	
	/**
	 * 设置历史记录基本信息操作
	 * @param ig036DAO IG036DAO
	 */
	public void setIg036DAO(IG036DAO ig036DAO) {
		this.ig036DAO = ig036DAO;
	}

	/**
	 * <p>
	 * 添加日志信息
	 * </p>
	 * 
	 * @param ig036Info 日志信息
	 * @return 日志信息
	 * @throws BLException
	 */
	
	public IG036Info registIG036Info(IG036Info ig036Info) throws BLException{
		return ig036DAO.save(ig036Info);
	}

	/**
	 * <p>
	 * 修改日志信息
	 * </p>
	 * 
	 * @param ig036Info 日志信息
	 * @return 日志信息
	 * @throws BLException
	 */
	
	public IG036Info updateG036Info(IG036Info ig036Info) throws BLException{
		checkExistIG036Info(ig036Info.getRlid());
		return ig036DAO.save(ig036Info);
	}
	
	/**
	 * 流程日志信息存在检查
	 * 
	 * @param rlid 流程日志ID
	 * @return  流程日志信息
	 * @throws BLException 
	 */
	private IG036Info checkExistIG036Info(Integer rlid) throws BLException{
		IG036Info info = ig036DAO.findByPK(rlid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程日志基本");
		}
		return info;
	}

	/**
	 * 根据主键查询日志信息
	 * 
	 * @param pk 主键值
	 * @return 日志信息
	 * @throws BLException
	 */
	public IG036Info searchIG036InfoByPK(Integer pk) throws BLException{
		return ig036DAO.findByPK(pk);
		
	}
	
	/**
	 * <p>
	 * 获取指定流程记录的所有日志信息
	 * </p>
	 * 
	 * @param processId 流程记录ID
	 * @return 日志信息集合
	 * @throws BLException
	 */
	
	public List<IG036Info> searchIG036InfoByPrid(Integer processId){
		IG036SearchCondImpl cond = new IG036SearchCondImpl();
		cond.setPrid(processId);
		return ig036DAO.findByCond(cond, 0, 0);
		
	}
	
	/**
	 * 根据查询条件获取日志信息集合
	 * @param 日志参数值信息集合
	 * @throws BLException
	 */
	public List<IG036Info> searchIG036InfoByCond(IG036SearchCond cond){
		List<IG036Info> recordlogList = ig036DAO.findByCond(cond, 0, 0);
		return recordlogList;
	}
	
	/**
	 * 获取日志信息实例
	 * 
	 * @return 日志信息实体
	 * @throws BLException
	 */
	
	public IG036TB getIG036TBInstance(){
		return new IG036TB();
	}

}
