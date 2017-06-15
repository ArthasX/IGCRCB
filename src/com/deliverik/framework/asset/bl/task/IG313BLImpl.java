package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.condition.IG313SearchCond;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG313DAO;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;


/**
 * 资产关系业务逻辑实现
 * 
 * @author 
 */
public class IG313BLImpl extends BaseBLImpl implements IG313BL {

	/** ig313 DAO */
	protected IG313DAO ig313DAO;

	public void setIg313DAO(IG313DAO ig313DAO) {
		this.ig313DAO = ig313DAO;
	}
	
	/**
	 * <p>
	 * 新的资产关系信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产关系信息对象实例取得
	 */

	public IG313TB getIG313TBInstance() {
		return new IG313TB();
	}

	/**
	 * 根据检索条件取得资产关系信息结果条数
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息结果条数
	 */
	public int getIG313InfoSearchCount(IG313SearchCond cond){

		return ig313DAO.getSearchCount(cond);
	}

	
	/**
	 * 根据资产关系信息主键取得资产关系信息
	 * 
	 * @param eirid 资产关系信息主键
	 * @return 资产关系信息
	 * @throws BLException 
	 */
	public IG313Info searchIG313InfoByKey(Integer eirid) throws BLException{

		return checkExistEntityItemRelation(eirid);
	}
	
	/**
	 * 根据检索条件取得资产关系信息列表
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息检索结果列表
	 */

	public List<IG313Info> searchIG313Info(IG313SearchCond cond){

		List<IG313Info> ret = ig313DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得资产关系信息列表
	 * 
	 * @param cond 资产关系信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产关系信息检索结果列表
	 */
	public List<IG313Info> searchIG313Info(IG313SearchCond cond, int start, int count){

		List<IG313Info> ret = ig313DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存资产关系信息处理
	 * 
	 * @param ig313Info 保存的资产关系信息数据
	 * @return 资产关系信息
	 * @throws BLException 
	 */
	public IG313Info registIG313Info(IG313Info ig313Info) throws BLException{
		//checkNotExistEntityItemRelation(entityItemRelation.getPareiid(),entityItemRelation.getCldeiid());
		IG313Info ret = ig313DAO.save(ig313Info);
		return ret;
	}

	/**
	 * 变更资产关系信息处理
	 * 
	 * @param ig313Info 变更的资产关系信息数据
	 * @return 资产关系信息
	 * @throws BLException 
	 */
	public IG313Info updateIG313Info(IG313Info ig313Info) throws BLException{
		checkExistEntityItemRelation(ig313Info.getEirid());
		IG313Info ret = ig313DAO.save(ig313Info);
		return ret;
	}
	
	/**
	 * 资产关系信息版本升级处理
	 * 
	 * @param eiid 变更资产ID
	 * @param eiversion 关系表中资产最新大版本
	 * @param eismallversion 关闭表中资产最新小版本
	 * @param neweiversion 资产最新大版本
	 * @param neweismallversion 资产最新小版本
	 * @throws BLException 
	 */
	public void upgradeIG313Info(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException {
		//当前时间
		String dataTime = IGStringUtils.getCurrentDateTime();
		//检索关系表中资产最新版本关系（正向）
		IG313SearchCondImpl condPar = new IG313SearchCondImpl();
		condPar.setPareiid(eiid);//资产ID
		condPar.setParversion(eiversion);//资产大版本
		condPar.setParsmallversion(eismallversion);//资产小版本
		List<IG313Info> eirList = this.searchMaxIG313Info(condPar);
		IG313TB eirTB = null;
		for(IG313Info eir : eirList) {
			eirTB = (IG313TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setParversion(neweiversion);
			eirTB.setParsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			eirTB.setDeleteflag("0");
			this.ig313DAO.save(eirTB);
		}
		/**
		//检索关系表中资产最新版本关系（反向）
		IG313SearchCondImpl condCld = new IG313SearchCondImpl();
		condCld.setCldeiid(eiid.toString());//资产ID
		condCld.setCldversion(eiversion.toString());//资产大版本
		condCld.setCldsmallversion(eismallversion.toString());//资产小版本
		condCld.setDeleteflag("0");//资产关系可用标志
		eirList = this.searchMaxIG313Info(condCld);
		for(IG313Info eir : eirList) {
			eirTB = (IG313TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setCldversion(neweiversion);
			eirTB.setCldsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			eirTB.setDeleteflag("0");
			this.ig313DAO.save(eirTB);
		}
		*/
		
	}
	
	/**
	 * 删除资产关系信息处理
	 * 
	 * @param ig313Info 删除的资产关系信息数据
	 * @return
	 * @throws BLException 
	 */
	public void deleteIG313Info(IG313Info ig313Info) throws BLException{
		checkExistEntityItemRelation(ig313Info.getEirid());
		ig313DAO.delete(ig313Info);
	}

	/**
	 * 资产关系信息不存在检查
	 * 
	 * @param pareiid 资产ID（正向）
	 * @param cldeiid 资产ID（反向）
	 * @throws BLException 
	 */
	protected void checkNotExistEntityItemRelation(Integer pareiid, Integer cldeiid) throws BLException{
		IG313SearchCondImpl cond = new IG313SearchCondImpl();
		
		cond.setPareiid(pareiid);
		cond.setCldeiid(cldeiid);
		
		List<IG313Info> infoList = ig313DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGCO10000.E003","资产关系");
		}
	}
	
	/**
	 * 资产关系信息存在检查
	 * 
	 * @param eirid 资产关系信息ID
	 * @return 资产关系信息
	 * @throws BLException 
	 */
	protected IG313Info checkExistEntityItemRelation(Integer eirid) throws BLException{
		IG313Info info = ig313DAO.findByPK(eirid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","资产关系");
		}
		
		return info;
	}
	/**
	 * 根据资产关系信息主键删除资产关系信息处理
	 * 
	 * @param eirid 删除资产关系信息的主键
	 * @return
	 * @throws BLException
	 */

	public void deleteIG313InfoByKey(Integer eirid) throws BLException {
		IG313Info entityItemRelation = checkExistEntityItemRelation(eirid);
		ig313DAO.delete(entityItemRelation);
		
	}
	
	/**
	 * 资产关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG313Info> searchMaxIG313Info(IG313SearchCond cond) {
		return this.ig313DAO.searchMaxIG313Info(cond);
	}

	/**
	 * 合同-服务关系更新
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion, String[] cldeiids)
			throws BLException {
		//当前时间
		String dataTime = IGStringUtils.getCurrentDateTime();
		//检索关系表中资产最新版本关系（正向）
		IG313SearchCondImpl condPar = new IG313SearchCondImpl();
		condPar.setPareiid(eiid);//资产ID
		condPar.setParversion(eiversion);//资产大版本
		condPar.setParsmallversion(eismallversion);//资产小版本
		condPar.setDeleteflag("0");
		List<IG313Info> eirList = this.searchIG313Info(condPar);
		IG313TB eirTB = null;
		for(IG313Info eir : eirList) {
			eirTB = (IG313TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setParversion(neweiversion);
			eirTB.setParsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			eirTB.setDeleteflag("0");
			//有模式
			if("C".equals(eir.getEirstatus())) {
				if(cldeiids!=null&&cldeiids.length>0){
					for(int i=0;i<cldeiids.length;i++){
						if(StringUtils.isNotEmpty(cldeiids[i])){
							String cldeiid=cldeiids[i].split("_")[0];
							String cldversion=cldeiids[i].split("_")[1];
							String cldsmallversion=cldeiids[i].split("_")[2];
							String ciid="_"+cldeiids[i].split("_")[3]+"_";
							//判断是否是升级的资产
							if(cldeiid.equals(eirTB.getCldeiid().toString())&&eirTB.getEirinfo().indexOf(ciid)!=-1){
								eirTB.setCldversion(Integer.parseInt(cldversion));
								eirTB.setCldsmallversion(Integer.parseInt(cldsmallversion));
								break;
							}
						}
					}
				}
			} else {
				eirTB.setCldversion(eirTB.getCldEntityItemVW().getEiversion());
				eirTB.setCldsmallversion(eirTB.getCldEntityItemVW().getEismallversion());
			}
			this.ig313DAO.save(eirTB);
		}
		
	}
	
	/**
	 * 更新无模式关系
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException {
		//当前时间
		String dataTime = IGStringUtils.getCurrentDateTime();
		//检索关系表中资产最新版本关系（正向）
		IG313SearchCondImpl condPar = new IG313SearchCondImpl();
		condPar.setPareiid(eiid);//资产ID
		condPar.setParversion(eiversion);//资产大版本
		condPar.setParsmallversion(eismallversion);//资产小版本
		condPar.setDeleteflag("0");
		List<IG313Info> eirList = this.searchIG313Info(condPar);
		IG313TB eirTB = null;
		for(IG313Info eir : eirList) {
			//无模式
			if(!"C".equals(eir.getEirstatus())) {
				eirTB = (IG313TB)SerializationUtils.clone(eir);
				eirTB.setEirid(null);
				eirTB.setParversion(neweiversion);
				eirTB.setParsmallversion(neweismallversion);
				eirTB.setEirupdtime(dataTime);
				eirTB.setDeleteflag("0");
				eirTB.setCldversion(eirTB.getCldEntityItemVW().getEiversion());
				eirTB.setCldsmallversion(eirTB.getCldEntityItemVW().getEismallversion());
				this.ig313DAO.save(eirTB);
			}
		}
		
	}

}
