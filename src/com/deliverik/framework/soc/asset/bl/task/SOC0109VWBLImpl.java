package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0109VWDAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0109VW;
import com.deliverik.framework.utility.BLErrorType;


/**
 * <p>
 * 资产模型属性业务逻辑实现
 * </p>
 */
public class SOC0109VWBLImpl extends BaseBLImpl implements SOC0109VWBL {

	/** Configuration DAO */
	protected SOC0109VWDAO soc0109VWDAO;
	
	/** 资产模型BL */
	protected SOC0117VWBL soc0117VWBL;

	/**
	 * @param soc0109vwdao the soc0109VWDAO to set
	 */
	public void setSoc0109VWDAO(SOC0109VWDAO soc0109vwdao) {
		soc0109VWDAO = soc0109vwdao;
	}

	/**
	 * @param soc0117vwbl the soc0117VWBL to set
	 */
	public void setSoc0117VWBL(SOC0117VWBL soc0117vwbl) {
		soc0117VWBL = soc0117vwbl;
	}

	/**
	 * <p>
	 * 新的资产模型属性信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产模型属性信息对象实例取得
	 */

	public SOC0109VW getConfigurationTBInstance() {
		return new SOC0109VW();
	}

	/**
	 * 根据检索条件取得资产模型属性信息条数
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @return 资产模型属性信息条数
	 */
	public int getConfigurationSearchCount(SOC0109VWSearchCond cond){

		return soc0109VWDAO.getSearchCount(cond);
	}

	/**
	 * 根据资产模型属性主键取得资产模型属性信息
	 * 
	 * @param cid 资产模型属性主键
	 * @return 资产模型属性信息
	 * @throws BLException 
	 */
	public SOC0109VWInfo searchConfigurationByKey(String cid) throws BLException{

		return checkExistConfiguration(cid);
	}

	/**
	 * 取得各资产模型的模型属性信息
	 * 
	 * @param list 资产模型集合
	 * @param cseq 资产模型属性是否显示标识（1显示属性，0不显示，null检索全部属性）
	 * @return 各资产模型的模型属性信息
	 */
	public Map<String,List<SOC0109VWInfo>> searchConfiguration(List<SOC0117VWInfo> list,Integer cseq){
		Map<String,List<SOC0109VWInfo>> map = new LinkedHashMap<String,List<SOC0109VWInfo>>();
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		if(cseq!=null){
			cond.setCseq(cseq);//属性是否显示，1代表显示属性，0代表不显示
		}
		//资产配置信息分层次查询
		for(SOC0117VWInfo e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109VWInfo> configurationList = soc0109VWDAO.findByCond(cond, 0, 0);
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
	public List<SOC0109VWInfo> searchConfigurationByEid(String eid) throws BLException{
		List<SOC0117VWInfo> list = soc0117VWBL.getParentNodes(eid);
		List<SOC0109VWInfo> configlist = new ArrayList<SOC0109VWInfo>();
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setCstatus("1");//1启用
		//资产配置信息分层次查询
		for(SOC0117VWInfo e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109VWInfo> configurationList = soc0109VWDAO.findByCond(cond, 0, 0);
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
	public List<SOC0109VWInfo> searchConfiguration(SOC0109VWSearchCond cond, int start, int count){

		List<SOC0109VWInfo> ret = soc0109VWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 保存资产模型属性信息处理
	 * 
	 * @param configuration 资产模型属性信息
	 * @return 保存后的资产模型属性信息
	 * @throws BLException
	 */
	public SOC0109VWInfo registConfiguration(SOC0109VWInfo configuration) throws BLException{
		if(null!=configuration.getClabel()&&!configuration.getClabel().equals("")){
			checkNotExistConfiguration(configuration.getClabel());
		}
		
		SOC0109VW ctb = getConfigurationTBInstance();
		this.copyProperties(ctb, configuration);

		if (StringUtils.isEmpty(configuration.getCid())) {

			// 获取模型ID
			String eid = configuration.getEid();
			
			// 获取模型属性ID
			String cid = getNextCid(eid);
			
			if (cid == null) {
				throw new BLException("IGASM0101.E008","模型属性基本信息");
			} else {
				ctb.setCid(cid);
			}
		}
		
		SOC0109VWInfo ret = soc0109VWDAO.save(ctb);
		return ret;
	}

	/**
	 * 获取模型属性主键
	 * @param eid
	 * @return
	 */
	private String getNextCid(String eid) {
		
		// 拼写模型属性ID
		String cidhead = "CM" + eid.substring(2) + "1";
		// 模型属性id
		String cidstr = "";
		
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setCid_like(cidhead);
		List<SOC0109VWInfo> clist = soc0109VWDAO.findMaxCidByCond(cond);
		
		// 若存在，则取最大值+1
		if (clist != null && clist.size() > 0) {
			String lastCid = clist.get(0).getCid();
			String serinum = lastCid.substring(11);
			if (serinum.equals("999")) {
				return null;
			}
			String nextnum = String.valueOf(Integer.parseInt(serinum) + 1);
			cidstr = cidhead + StringUtils.leftPad(nextnum, 3, "0");
		} 
		// 不存在序列号设为001
		else {
			cidstr = cidhead + "001";
		}
		
		return cidstr;
	}

	/**
	 * 删除资产模型属性信息处理
	 * 
	 * @param configuration 删除的资产模型属性信息
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(SOC0109VWInfo configuration) throws BLException{
		checkExistConfiguration(configuration.getCid());
		soc0109VWDAO.delete(configuration);
	}

	/**
	 * 根据资产模型属性主键删除资产模型属性信息处理
	 * 
	 * @param cid 删除资产模型属性信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(String cid) throws BLException{
		SOC0109VWInfo ret = checkExistConfiguration(cid);
		soc0109VWDAO.delete(ret);
	}

	/**
	 * 变更资产模型属性信息处理
	 * 
	 * @param configuration 变更前的资产模型属性信息
	 * @return 资产模型属性信息
	 * @throws BLException
	 */
	public SOC0109VWInfo updateConfiguration(SOC0109VWInfo configuration) throws BLException{
		checkExistConfiguration(configuration.getCid());
		SOC0109VWInfo ret = soc0109VWDAO.save(configuration);
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
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setClabel(clabel);
		
		List<SOC0109VWInfo> infoList = soc0109VWDAO.findByCond(cond, 0, 0);
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
	protected SOC0109VWInfo checkExistConfiguration(String cid) throws BLException{
		SOC0109VWInfo info = soc0109VWDAO.findByPK(cid);
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
	public void deleteConfigurationByKey(String cid) throws BLException {
		SOC0109VWInfo Configuration = checkExistConfiguration(cid);
		soc0109VWDAO.delete(Configuration);
		
	}
	
	/**
	 * 根据检索条件取得资产模型属性信息列表
	 * 
	 * @param cond 资产模型属性信息检索条件
	 * @return 资产模型属性信息列表
	 */
	public List<SOC0109VWInfo> searchConfiguration(SOC0109VWSearchCond cond) {
		List<SOC0109VWInfo> ret = soc0109VWDAO.findByCond(cond,0,0);
		return ret;
	}
}
