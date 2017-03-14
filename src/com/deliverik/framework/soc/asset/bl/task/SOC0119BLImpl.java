package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0119DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.utility.IGStringUtils;


/**
 * 资产关系业务逻辑实现
 * 
 * @author 
 */
public class SOC0119BLImpl extends BaseBLImpl implements SOC0119BL {

	/** EntityItemRelation DAO */
	protected SOC0119DAO soc0119DAO;
	
	/**
	 * EntityItemRelationDAO设定
	 *
	 * @param soc0119DAO EntityItemRelationDAO
	 */
	public void setSoc0119DAO(SOC0119DAO soc0119DAO) {
		this.soc0119DAO = soc0119DAO;
	}

	/**
	 * 根据eiid删除关系数据
	 * @param eiid
	 */
	public void delByEiid(Integer eiid)throws BLException{
		this.soc0119DAO.delByEiid(eiid);
	}
	/**
	 * 根据eiid删除关系数据
	 * @param eiid
	 */
	public void delByEiid(Integer eiid,String eirrelationcode)throws BLException{
		this.soc0119DAO.delByEiid( eiid, eirrelationcode);
	}
	/**
	 * <p>
	 * 新的资产关系信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产关系信息对象实例取得
	 */

	public SOC0119TB getEntityItemRelationTBInstance() {
		return new SOC0119TB();
	}

	/**
	 * 根据检索条件取得资产关系信息结果条数
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息结果条数
	 */
	public int getEntityItemRelationSearchCount(SOC0119SearchCond cond){

		return soc0119DAO.getSearchCount(cond);
	}

	
	/**
	 * 根据资产关系信息主键取得资产关系信息
	 * 
	 * @param eirid 资产关系信息主键
	 * @return 资产关系信息
	 * @throws BLException 
	 */
	public SOC0119Info searchEntityItemRelationByKey(Integer eirid) throws BLException{

		return checkExistEntityItemRelation(eirid);
	}
	
	/**
	 * 根据检索条件取得资产关系信息列表
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息检索结果列表
	 */

	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond){

		List<SOC0119Info> ret = soc0119DAO.findByCond(cond,0,0);
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
	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond, int start, int count){

		List<SOC0119Info> ret = soc0119DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存资产关系信息处理
	 * 
	 * @param entityItemRelation 保存的资产关系信息数据
	 * @return 资产关系信息
	 * @throws BLException 
	 */
	public SOC0119Info registEntityItemRelation(SOC0119Info entityItemRelation) throws BLException{
		//checkNotExistEntityItemRelation(entityItemRelation.getPareiid(),entityItemRelation.getCldeiid());
		SOC0119Info ret = soc0119DAO.save(entityItemRelation);
		return ret;
	}

	/**
	 * 变更资产关系信息处理
	 * 
	 * @param entityItemRelation 变更的资产关系信息数据
	 * @return 资产关系信息
	 * @throws BLException 
	 */
	public SOC0119Info updateEntityItemRelation(SOC0119Info entityItemRelation) throws BLException{
		checkExistEntityItemRelation(entityItemRelation.getEirid());
		SOC0119Info ret = soc0119DAO.save(entityItemRelation);
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
	public void upgradeEntityItemRelation(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException {
		//当前时间
		String dataTime = IGStringUtils.getCurrentDateTime();
		//检索关系表中资产最新版本关系（正向）
		SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
		condPar.setPareiid(eiid);//资产ID
		condPar.setParversion(eiversion);//资产大版本
		condPar.setParsmallversion(eismallversion);//资产小版本
		List<SOC0119Info> eirList = this.searchMaxEntityItemRelation(condPar);
		SOC0119TB eirTB = null;
		for(SOC0119Info eir : eirList) {
			eirTB = (SOC0119TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setParversion(neweiversion);
			eirTB.setParsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			this.soc0119DAO.save(eirTB);
		}
		//检索关系表中资产最新版本关系（反向）
		SOC0119SearchCondImpl condCld = new SOC0119SearchCondImpl();
		condCld.setCldeiid(eiid);//资产ID
		condCld.setCldversion(eiversion);//资产大版本
		condCld.setCldsmallversion(eismallversion);//资产小版本
		eirList = this.searchMaxEntityItemRelation(condCld);
		for(SOC0119Info eir : eirList) {
			eirTB = (SOC0119TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setCldversion(neweiversion);
			eirTB.setCldsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			this.soc0119DAO.save(eirTB);
		}
		
	}

	/**
	 * 删除资产关系信息处理
	 * 
	 * @param entityItemRelation 删除的资产关系信息数据
	 * @return
	 * @throws BLException 
	 */
	public void deleteEntityItemRelation(SOC0119Info entityItemRelation) throws BLException{
		checkExistEntityItemRelation(entityItemRelation.getEirid());
		soc0119DAO.delete(entityItemRelation);
	}

	/**
	 * 资产关系信息不存在检查
	 * 
	 * @param pareiid 资产ID（正向）
	 * @param cldeiid 资产ID（反向）
	 * @throws BLException 
	 */
	protected void checkNotExistEntityItemRelation(Integer pareiid, Integer cldeiid) throws BLException{
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		
		cond.setPareiid(pareiid);
		cond.setCldeiid(cldeiid);
		
		List<SOC0119Info> infoList = soc0119DAO.findByCond(cond, 0, 0);
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
	protected SOC0119Info checkExistEntityItemRelation(Integer eirid) throws BLException{
		SOC0119Info info = soc0119DAO.findByPK(eirid);
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

	public void deleteEntityItemRelationByKey(Integer eirid) throws BLException {
		SOC0119Info entityItemRelation = checkExistEntityItemRelation(eirid);
		soc0119DAO.delete(entityItemRelation);
		
	}
	
	/**
	 * 资产关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0119Info> searchMaxEntityItemRelation(SOC0119SearchCond cond) {
		return this.soc0119DAO.searchMaxEntityItemRelation(cond);
	}

	public List<SOC0119Info> searchMaxEntityItemRelation(
			SOC0119SearchCond cond, int start, int count) {
		return this.soc0119DAO.searchMaxEntityItemRelation(cond, start, count);
	}
	
	/**
	 * 根据eiid 查询与其相关的eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid(SOC0119SearchCond cond) throws BLException{
		return this.soc0119DAO.searchRelationByEiid(cond);
	}
	
	/**
	 * 密码关联关系查询
	 * @param cond
	 * @return
	 */
	public List<Integer> searchCldeiidByPareiid(final SOC0119SearchCond cond)throws BLException{
		return this.soc0119DAO.searchCldeiidByPareiid(cond);
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
	public void upgradeEntityItemRelationOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion, String[] cldeiids)
			throws BLException {
		//当前时间
		String dataTime = IGStringUtils.getCurrentDateTime();
		//检索关系表中资产最新版本关系（正向）
		SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
		condPar.setPareiid(eiid);//资产ID
		condPar.setParversion(eiversion);//资产大版本
		condPar.setParsmallversion(eismallversion);//资产小版本
		condPar.setDeleteflag("0");
		List<SOC0119Info> eirList = this.searchEntityItemRelation(condPar);
		SOC0119TB eirTB = null;
		for(SOC0119Info eir : eirList) {
			eirTB = (SOC0119TB)SerializationUtils.clone(eir);
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
			this.soc0119DAO.save(eirTB);
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
	public void upgradeEntityItemRelationByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException {
		//当前时间
		String dataTime = IGStringUtils.getCurrentDateTime();
		//检索关系表中资产最新版本关系（正向）
		SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
		condPar.setPareiid(eiid);//资产ID
		condPar.setParversion(eiversion);//资产大版本
		condPar.setParsmallversion(eismallversion);//资产小版本
		condPar.setDeleteflag("0");
		List<SOC0119Info> eirList = this.searchEntityItemRelation(condPar);
		SOC0119TB eirTB = null;
		for(SOC0119Info eir : eirList) {
			//无模式
			if(!"C".equals(eir.getEirstatus())) {
				eirTB = (SOC0119TB)SerializationUtils.clone(eir);
				eirTB.setEirid(null);
				eirTB.setParversion(neweiversion);
				eirTB.setParsmallversion(neweismallversion);
				eirTB.setEirupdtime(dataTime);
				eirTB.setDeleteflag("0");
				eirTB.setCldversion(eirTB.getCldEntityItemVW().getEiversion());
				eirTB.setCldsmallversion(eirTB.getCldEntityItemVW().getEismallversion());
				this.soc0119DAO.save(eirTB);
			}
		}
		
	}

	/**
     * 根据检索条件取得资产关系信息列表
     * 
     * @param cond 资产关系信息检索条件
     * @return 资产关系信息检索结果列表
     */
    public List<SOC0119Info> searchEntityItemRelationBySql(SOC0119SearchCond cond,int start, int count){

        List<SOC0119Info> ret = soc0119DAO.findByCondBySql(cond,start,count);
        return ret;
    }
    
    /**
   	 * 根据eiid_in 查询与其相关的eiid
   	 * @param eiid
   	 * @return
   	 */
   	public List<Integer> searchRelationByEiid_in(final SOC0119SearchCond cond){
   		return soc0119DAO.searchRelationByEiid_in(cond);
   	}
}
