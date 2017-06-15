/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.asset.model.dao.IG809DAO;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 资产关系图文件信息业务逻辑接口
 *
 */
public class IG809BLImpl extends BaseBLImpl implements IG809BL{

	/** ig809 DAO */
	protected IG809DAO ig809DAO;
	
	public void setIg809DAO(
			IG809DAO ig809DAO) {
		this.ig809DAO = ig809DAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG809SearchCond cond){
		
		return ig809DAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param eirfid 主键
	 */
	public IG809Info searchIG809InfoByKey(Integer eirfid) throws BLException{
		
		return ig809DAO.findByPK(eirfid);
	}
	
	/**
	 * 全部检索处理 
	 */
	public List<IG809Info> searchIG809InfoAll(){
		
		return ig809DAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG809Info> searchIG809Info(IG809SearchCond cond, int start, int count){
		
		return ig809DAO.findByCond(cond,start,count);
	}
	
	/**
	 * 登录处理
	 * 
	 * @param ig809Info 登录数据
	 * @return 资产关系图文件信息
	 */
	public IG809Info registIG809Info(IG809Info ig809Info) throws BLException{
		
		return ig809DAO.save(ig809Info);
	}

	/**
	 * 删除处理
	 * 
	 * @param eirfid 主键
	 * @return
	 */
	public void deleteIG809Info(Integer eirfid) throws BLException{
		
		IG809Info entityItemRealationFile = checkExistEntityItemRelationFile(eirfid);
		ig809DAO.delete(entityItemRealationFile);
	}
	
	/**
	 * 删除处理
	 * 
	 * @param ig809Info 资产关系图文件信息
	 * @return
	 */
	public void deleteIG809Info(IG809Info ig809Info) throws BLException{

		ig809DAO.delete(ig809Info);
	}

	/**
	 * 变更处理
	 * 
	 * @param 变更数据
	 * @return 资产关系图文件信息
	 */
	public IG809Info updateIG809Info(IG809Info entityItemRealationFile) throws BLException{
		
		checkExistEntityItemRelationFile(entityItemRealationFile.getEirfid());
		return ig809DAO.save(entityItemRealationFile);
	}
	
	/**
	 * 信息存在检查
	 * 
	 * @param eirfid 主键
	 * @throws BLException 
	 */
	protected IG809Info checkExistEntityItemRelationFile(Integer eirfid) throws BLException{
		IG809Info eirf = ig809DAO.findByPK(eirfid);
		if( eirf == null) {
			throw new BLException("IGCO10000.E004","资产关系图基本");
		}
		return eirf;
	}
	
}
