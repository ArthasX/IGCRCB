package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCond;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;


/**
 * <p>
 * 资产模型属性业务逻辑实现
 * </p>
 */
public class IG225BLImpl extends BaseBLImpl implements IG225BL {

	/** Configuration DAO */
	protected IG225DAO ig225DAO;
	
	/** 资产模型BL */
	protected IG117BL ig117BL;

	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}

	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}
	
	/**
	 * <p>
	 * 新的资产模型属性信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产模型属性信息对象实例取得
	 */

	public IG225TB getIG225TBInstance() {
		return new IG225TB();
	}

	/**
	 * 根据检索条件取得资产模型属性信息条数
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @return 资产模型属性信息条数
	 */
	public int getIG225InfoSearchCount(IG225SearchCond cond){

		return ig225DAO.getSearchCount(cond);
	}

	/**
	 * 根据资产模型属性主键取得资产模型属性信息
	 * 
	 * @param cid 资产模型属性主键
	 * @return 资产模型属性信息
	 * @throws BLException 
	 */
	public IG225Info searchIG225InfoByKey(Integer cid) throws BLException{

		return checkExistConfiguration(cid);
	}

	/**
	 * 取得各资产模型的模型属性信息
	 * 
	 * @param list 资产模型集合
	 * @param cseq 资产模型属性是否显示标识（1显示属性，0不显示，null检索全部属性）
	 * @return 各资产模型的模型属性信息
	 */
	public Map<String,List<IG225Info>> searchIG225Info(List<IG117Info> list,Integer cseq){
		Map<String,List<IG225Info>> map = new LinkedHashMap<String,List<IG225Info>>();
		IG225SearchCondImpl cond = new IG225SearchCondImpl();
		if(cseq!=null){
			cond.setCseq(cseq);//属性是否显示，1代表显示属性，0代表不显示
		}
		//资产配置信息分层次查询
		for(IG117Info e : list){
			cond.setEid(e.getEid().toString());
			List<IG225Info> configurationList = ig225DAO.findByCond(cond, 0, 0);
			map.put(e.getEname(), configurationList);
		}

		return map;
	}
	
	/**
	 * 根据资产模型ID取得其所有继承属性信息列表
	 * 
	 * @param eid 模型属性ID
	 * @return 资产模型属性信息列表
	 */
	public List<IG225Info> searchIG225InfoByEid(Integer eid) throws BLException{
		List<IG117Info> list = ig117BL.getParentNodes(eid);
		List<IG225Info> configlist = new ArrayList<IG225Info>();
		IG225SearchCondImpl cond = new IG225SearchCondImpl();
		cond.setCstatus("1");//1启用
		//资产配置信息分层次查询
		for(IG117Info e : list){
			cond.setEid(e.getEid().toString());
			List<IG225Info> configurationList = ig225DAO.findByCond(cond, 0, 0);
			configlist.addAll(configurationList);
		}

		return configlist;
	}
	
	/**
	 * 根据检索条件取得资产模型属性信息列表(分页查询用)
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 资产模型属性信息列表
	 */
	public List<IG225Info> searchIG225Info(IG225SearchCond cond, int start, int count){

		List<IG225Info> ret = ig225DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 保存资产模型属性信息处理
	 * 
	 * @param configuration 资产模型属性信息
	 * @return 保存后的资产模型属性信息
	 * @throws BLException
	 */
	public IG225Info registIG225Info(IG225Info configuration) throws BLException{
		if(null!=configuration.getClabel()&&!configuration.getClabel().equals("")){
			checkNotExistConfiguration(configuration.getClabel());
		}
		IG225Info ret = ig225DAO.save(configuration);
		return ret;
	}

	/**
	 * 删除资产模型属性信息处理
	 * 
	 * @param ig225Info 删除的资产模型属性信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG225Info(IG225Info ig225Info) throws BLException{
		checkExistConfiguration(ig225Info.getCid());
		ig225DAO.delete(ig225Info);
	}

	/**
	 * 根据资产模型属性主键删除资产模型属性信息处理
	 * 
	 * @param cid 删除资产模型属性信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(Integer cid) throws BLException{
		IG225Info ret = checkExistConfiguration(cid);
		ig225DAO.delete(ret);
	}

	/**
	 * 变更资产模型属性信息处理
	 * 
	 * @param ig225Info 变更前的资产模型属性信息
	 * @return 资产模型属性信息
	 * @throws BLException
	 */
	public IG225Info updateIG225Info(IG225Info ig225Info) throws BLException{
		checkExistConfiguration(ig225Info.getCid());
		IG225Info ret = ig225DAO.save(ig225Info);
		return ret;
	}

	/**
	 * 资产模型属性信息不存在检查
	 * 
	 * @param clabel 配置编号 
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistConfiguration(String clabel) throws BLException{
		IG225SearchCondImpl cond = new IG225SearchCondImpl();
		cond.setClabel(clabel);
		
		List<IG225Info> infoList = ig225DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size() >0 ) {
			throw new BLException(BLErrorType.CONFIGURATION_ALREADY_EXISTS,
					"IGCO10000.E003","资产模型属性");
		}
	}
	
	/**
	 * 资产模型属性信息存在检查
	 * 
	 * @param cid 配置ID
	 * @return 资产模型属性信息
	 * @throws BLException 
	 */
	protected IG225Info checkExistConfiguration(Integer cid) throws BLException{
		IG225Info info = ig225DAO.findByPK(cid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","资产模型属性");
		}
		
		return info;
	}

	/**
	 * 根据资产模型属性主键删除资产模型属性信息处理
	 * 
	 * @param cid 删除资产模型属性信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG225InfoByKey(Integer cid) throws BLException {
		IG225Info Configuration = checkExistConfiguration(cid);
		ig225DAO.delete(Configuration);
		
	}
	
	/**
	 * 根据检索条件取得资产模型属性信息列表
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @return 资产模型属性信息列表
	 */
	public List<IG225Info> searchIG225Info(IG225SearchCond cond) {
		List<IG225Info> ret = ig225DAO.findByCond(cond,0,0);
		return ret;
	}
}
