package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0107VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0109VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0117VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0118VWDAO;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0107VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RehearseDAO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;



/**
 * 资产信息业务逻辑实现
 * 
 */
public class SOC0118VWBLImpl extends BaseBLImpl implements SOC0118VWBL {

	/** 角色组织架构关系表DAO接口 */
	protected RehearseDAO rehearseDAO;
	
	
	/** EntityItem DAO */
	protected SOC0118VWDAO soc0118VWDAO;
	
//	/** EntityItemVW DAO */
//	protected SOC0124DAO soc0124DAO;
	
	/** UserRoleVWDAO DAO */
	protected UserRoleVWDAO userRoleVWDAO;
	
	/** ConfigurationDAO */
	protected SOC0109VWDAO soc0109VWDAO;
	
	/** ConfigItemDAO */
	protected SOC0107VWDAO soc0107VWDAO;
	
	/** EntityItem DAO */
	protected SOC0117VWDAO soc0117VWDAO;
	
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 


	/**
	 * @param rehearseDAO the rehearseDAO to set
	 */
	public void setRehearseDAO(RehearseDAO rehearseDAO) {
		this.rehearseDAO = rehearseDAO;
	}

	/**
	 * @param soc0118vwdao the soc0118VWDAO to set
	 */
	public void setSoc0118VWDAO(SOC0118VWDAO soc0118vwdao) {
		soc0118VWDAO = soc0118vwdao;
	}

	/**
	 * @param userRoleVWDAO the userRoleVWDAO to set
	 */
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}

	/**
	 * @param soc0109vwdao the soc0109VWDAO to set
	 */
	public void setSoc0109VWDAO(SOC0109VWDAO soc0109vwdao) {
		soc0109VWDAO = soc0109vwdao;
	}

	/**
	 * @param soc0107vwdao the soc0107VWDAO to set
	 */
	public void setSoc0107VWDAO(SOC0107VWDAO soc0107vwdao) {
		soc0107VWDAO = soc0107vwdao;
	}

	/**
	 * @param soc0117vwdao the soc0117VWDAO to set
	 */
	public void setSoc0117VWDAO(SOC0117VWDAO soc0117vwdao) {
		soc0117VWDAO = soc0117vwdao;
	}

	/**
	 * <p>
	 * 新的资产信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产信息对象实例取得
	 */

	public SOC0118VW getEntityItemTBInstance() {
		return new SOC0118VW();
	}

	/**
	 * 根据检索条件取得资产信息结果条数
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息结果条数
	 */
	public int getEntityItemSearchCount(SOC0118VWSearchCond cond){

		return soc0118VWDAO.getSearchCount(cond);
	}

	/**
	 * 根据资产信息主键取得资产信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 资产信息
	 * @throws BLException 
	 */
	public SOC0118VWInfo searchEntityItemByKey(SOC0118VWPK pk) throws BLException{

		return checkExistEntityItem(pk);
	}
	
	/**
	 * 根据检索条件取得资产信息列表
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息检索结果列表
	 */
	public List<SOC0118VWInfo> searchEntityItem(SOC0118VWSearchCond cond){

		List<SOC0118VWInfo> ret = soc0118VWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得资产信息列表
	 * 
	 * @param cond 资产信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产信息检索结果列表
	 */
	public List<SOC0118VWInfo> searchEntityItem(SOC0118VWSearchCond cond, int start, int count){

		List<SOC0118VWInfo> ret = soc0118VWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 保存资产信息处理（平台保留）
	 * 
	 * @param entityItem 保存的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public SOC0118VWInfo registEntityItem(SOC0118VWInfo entityItem) throws BLException{
		checkNotExistEntityItem(entityItem.getEilabel());
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		return ret;
	}
	
	/**
	 * 风险事件登记
	 * 
	 * @param entityItem 保存的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public SOC0118VWInfo registRiskCase(SOC0118VWInfo entityItem) throws BLException{
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		return ret;
	}
	
	/**
	 * 资产模型信息存在检查
	 * 
	 * @param eid 资产ID
	 * @return 资产模型信息
	 * @throws BLException 
	 */
	private SOC0117VWInfo checkExistEntity(String eid) throws BLException{
		SOC0117VWInfo info = soc0117VWDAO.findByPK(eid);
		if( info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产模型基本");
		}
		
		return info;
	}
	
	/**
	 * 根据资产模型ID获取其全部的上级资产模型信息
	 * 
	 * @param eid 资产模型ID
	 * @return 上级资产模型信息结果列表
	 * @throws BLException 
	 */
	private List<SOC0117VWInfo> getParentNodes(String eid) throws BLException{
		checkExistEntity(eid);
		SOC0117VWInfo entity = soc0117VWDAO.findByPK(eid);
		String esyscoding = entity.getEsyscoding();
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
		cond.setEsyscodingList(list);
		return soc0117VWDAO.findByCond(cond, 0, 0);
	}
	
	
	/**
	 * 根据资产模型ID取得其所有继承属性信息检索结果列表
	 * 
	 * @param eid 模型属性ID
	 * @return 资产模型属性信息检索结果列表
	 * @throws BLException 
	 */
	private List<SOC0109VWInfo> searchConfigurationByEid(String eid) throws BLException{
		List<SOC0117VWInfo> list = getParentNodes(eid);
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
	 * 保存资产信息处理
	 * 
	 * @param entityItem 保存的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public SOC0118VWInfo registEntityItemAndConfigItem(SOC0118VWInfo entityItem) throws BLException{
		checkNotExistEntityItem(entityItem.getEilabel());
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		
		List<SOC0109VWInfo> configurationList = searchConfigurationByEid(ret.getEid());
		for(SOC0109VWInfo configuration : configurationList) {
			SOC0107VW configItem = new SOC0107VW();
			//设备ID
			configItem.setEiid(ret.getEiid());
			//模型属性ID
			configItem.setCid(configuration.getCid());
			//模型ID
			configItem.setEid(ret.getEid());
			//模型层次码
			configItem.setEsyscoding(ret.getEsyscoding());
			
			//默认属性：设备状态
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(configuration.getClabel())){
				configItem.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
			}
			//大版本号
			configItem.setCiversion("0");
			//小版本号
			configItem.setCismallversion(0);
			
			//更新时间
			configItem.setCiupdtime(ret.getEiupdtime());
			
			soc0107VWDAO.save(configItem);
		}
		return ret;
	}

	/**
	 * 变更资产信息处理
	 * 
	 * @param entityItem 变更的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public SOC0118VWInfo updateEntityItem(SOC0118VWInfo entityItem) throws BLException{
		checkExistEntityItem(new SOC0118VWPK(entityItem.getId(),entityItem.getEiid()));
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		return ret;
	}

	/**
	 * 删除资产信息处理
	 * 
	 * @param entityItem 删除的资产信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItem(SOC0118VWInfo entityItem) throws BLException{
		checkExistEntityItem(new SOC0118VWPK(entityItem.getId(),entityItem.getEiid()));
		
		soc0118VWDAO.delete(entityItem);
	}
	
	/**
	 * 根据资产信息主键删除资产信息处理
	 * 
	 * @param eiid 删除资产信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItemByKey(SOC0118VWPK pk) throws BLException{
		SOC0118VWInfo entityItem = checkExistEntityItem(pk);
		soc0118VWDAO.delete(entityItem);
	}

	/**
	 * 资产信息不存在检查
	 * 
	 * @param elabel 资产编号
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistEntityItem(String eilabel) throws BLException{
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		
		cond.setEilabel(eilabel);
		
		List<SOC0118VWInfo> infoList = soc0118VWDAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS, "IGCO10000.E003","资产");
		}
	}
	
	/**
	 * 资产信息存在检查
	 * 
	 * @param eiid 资产ID
	 * @return 资产信息
	 * @throws BLException 
	 */
	protected SOC0118VWInfo checkExistEntityItem(SOC0118VWPK pk) throws BLException{
		SOC0118VWInfo info = soc0118VWDAO.findByPK(pk);
		if( info == null) {
			throw new BLException("IGCO10000.E004","资产基本");
		}
		
		return info;
	}
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
//	public SOC0124Info searchEntityItemVWByKey(Integer eiid) throws BLException{
//		checkExistEntityItem(eiid);
//		SOC0124Info ret = this.soc0124DAO.findByPK(eiid);
//		return ret;
//	}

	/**
	 * 资产及其所属模型信息条件检索结果件数取得
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息条件检索结果件数
	 */
//	public int getEntityItemVWSearchCount(SOC0124SearchCond cond){
//
//		return soc0124DAO.getSearchCount(cond);
//	}

	/**
	 * 根据检索条件取得资产及其所属模型信息列表
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息检索结果列表
	 */
//	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond){
//		
//		List<SOC0124Info> ret = soc0124DAO.findByCond(cond, 0, 0);
//		return ret;
//	}
	
	/**
	 * 根据检索条件取得资产及其所属模型信息列表
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产及其所属模型信息检索结果列表
	 */
//	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond, int start, int count){
//
//		List<SOC0124Info> ret = soc0124DAO.findByCond(cond,start,count);
//		return ret;
//	}
	
	/**
	 * 判断登陆用户是否有查看该资产配置信息的权限
	 * 
	 * @param user 用户信息
	 * @param entityItemVWInfo 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkEntityItemDomain(User user,SOC0118VWInfo entityItemVWInfo) throws BLException{
		Integer id = entityItemVWInfo.getId();
		String eid = entityItemVWInfo.getEid();
		SOC0117VWInfo info = soc0117VWDAO.findByPK(new SOC0117VWPK(id,eid));
		//无匹配角色类型则表示没有权限控制
		String roleType = EntityCategory.getRoleType(info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//无权限控制 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(entityItemVWInfo.getEiuserid())) {
				return true;
			} else {
				//资产登记人可见，资产所属模型对应的管理角色负责人可见
				UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
				//构造查询条件
				cond.setUserid(user.getUserid());//用户ID
				cond.setRoletype(roleType);//角色类型
				cond.setRolemanager(true);//角色负责人
				List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
				if(userRoleInfoList.isEmpty()) {
					return false;
				} else {
					return true;
				}
			}
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_B.equals(mode)) {
			UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
			//构造查询条件
			cond.setUserid(user.getUserid());//用户ID
			cond.setRoletype(roleType);//角色类型
			List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
			//如果userRoleInfoList的长度大于0，表示该用户具有资产管理角色
			if (userRoleInfoList.size() > 0) {		
				for (UserRoleInfo userRoleInfo : userRoleInfoList) {
					if (StringUtils.isNotEmpty(userRoleInfo.getAssetdomain()) && StringUtils.isNotEmpty(userRoleInfo.getRoledomain())) {							
						if (info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(entityItemVWInfo.getEsyscoding())){
								//如果是组件或者服务记录只需满足管理内容就表示该用户具有查看资产配置信息的权限
								if (entityItemVWInfo.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(entityItemVWInfo.getEsyscoding())&&StringUtils.isNotEmpty(entityItemVWInfo.getEiorgsyscoding())){
								//如果不是组件和服务记录需同时满足管理域与管理内容才表示该用户具有查看资产配置信息的权限
								if (entityItemVWInfo.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& entityItemVWInfo.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
									return true;
								}				
							}
						}
					}
				}
			}
			return false;
		} else {
			//不可见
			return false;
		}
		
	}
	
	/**
	 * 获取当前可用资产编号 资产key+年+编号 （位数：4+2+6）
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号（平台保留）
	 */
	public String searchNextEntityItemLable(SOC0118VWSearchCond cond) throws BLException{
		String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
		if(StringUtils.isEmpty(eiLabel)) {
			eiLabel = cond.getEilabel() + EntityItemKeyWords.LABEL_MIN_ID;
		} else {
			Integer label = new Integer(eiLabel.substring(EntityItemKeyWords.LABEL_LEFT_LENGTH));
			if(EntityItemKeyWords.LABEL_MAX_ID.equals(label.toString())) {
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGASM0000.E001");
			} else {
				eiLabel = cond.getEilabel() + StringUtils.leftPad(String.valueOf(label + 1) , EntityItemKeyWords.LABEL_LENGTH, EntityItemKeyWords.LABEL_LEFT_PAD);
			}
		}
		
		return eiLabel;
	}

	/**
	 * 获取当前可用资产编号 资产key+设备类型code+编号 （位数：10+2+7）阜新银行专用
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号（平台保留）
	 */
	public String searchNextEntityItemLableFX(SOC0118VWSearchCond cond) throws BLException{
		String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
		// 唐晓娜 修改于2010-7-2
		if(StringUtils.isEmpty(eiLabel)) {
			eiLabel = cond.getEilabel() + EntityItemKeyWords.LABEL_MIN_ID_FX;
		} else {
			Integer label = new Integer(eiLabel.substring(EntityItemKeyWords.LABEL_LEFT_LENGTH_FX));
			if(EntityItemKeyWords.LABEL_MAX_ID_FX.equals(label.toString())) {
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGASM0000.E001");
			} else {
				if(String.valueOf(label + 1).length()>3){
					eiLabel=cond.getEilabel()+String.valueOf(label + 1);
				}else {
					eiLabel = cond.getEilabel() + StringUtils.leftPad(String.valueOf(label + 1) , EntityItemKeyWords.LABEL_LENGTH_FX, EntityItemKeyWords.LABEL_LEFT_PAD);
				}
			}
		}
		// 唐晓娜 修改于2010-7-2
		return eiLabel;
	}
	
	/**
	 *  获取资产历史版本更新时间
	 * 
	 * @param eiid 资产ID
	 * @return 各版本更新时间
	 * @throws BLException 
	 */
//	public List<SOC0128Info> searchVersionUpdateTime(Integer eiid) throws BLException {
//		checkExistEntityItem(eiid);
//		return this.soc0128DAO.searchVersionUpdateTime(eiid);
//	}
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0118VWInfo> searchDeviceService(final SOC0124SearchCond cond, final int start, final int count) {
		return this.soc0118VWDAO.searchDeviceService(cond, start, count);
	}
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
//	public SOC0123Info searchEntityItemEntityVWByKey(Integer eiid) throws BLException {
//		checkExistEntityItem(eiid);
//		SOC0123Info ret = this.soc0123DAO.findByPK(eiid);
//		return ret;
//	}
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0139VW> searchSwitchService(final String eiid,final String version,final String smallversion){
		return soc0118VWDAO.searchSwitchService(eiid, version, smallversion);	
	}
	
	public String searchEntityESyscoding(String strEilabel){
		return soc0118VWDAO.searchEntityESyscoding(strEilabel);
	}
	
	public List<CodeDetailEntity> searchCodeDetailSQL(SOC0118VWSearchCond cond){
		return soc0118VWDAO.findByCondSQL(cond, 0, 0);
	}

	public List<TableSpaceInfo> searchTableRelationInfo(
			SOC0118VWSearchCondImpl soc0118VWCond, int start, int count) {
		return soc0118VWDAO.searchTableRelationInfo(soc0118VWCond,start,count);
	}

	public void updateCutValue(IGCIM1001Form igcim1001Form) {
		this.soc0118VWDAO.updateCutValue(igcim1001Form);
	}

	public List<SOC0437Info> searchCutItem(SOC0437SearchCond cond, int start, int count) {
		return soc0118VWDAO.searchCutItem(cond,start,count);
	}
	public Integer searchCutItemCount(SOC0437SearchCond cond) {
		return soc0118VWDAO.searchCutItemCount(cond);
	}
	/**
	 * 清空资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(final SOC0118VWSearchCond cond) throws BLException{
		return soc0118VWDAO.clearEidesc(cond);
	}

	/**
	 * 批量插入
	 * @param soc0118VWList
	 * @throws Exception
	 */
	public void saveEntityItems(List<SOC0118VW> soc0118VWList)throws Exception{
			soc0118VWDAO.saveEntityItems(soc0118VWList);
		
	}
	
	/**
	 * 执行sql
	 * @param sql
	 * @return
	 */
	public Integer executeSQL(String sql)throws BLException{
		return  soc0118VWDAO.executeSQL(sql);
	}
	public int getNetDeviceInfoListCount(NetDeviceSearchCond cond){
		return soc0118VWDAO.getNetDeviceCount(cond);
	}
	
	public List<NetDeviceInfo> searchNetDeviceInfoList(NetDeviceSearchCond cond, int start, int count){
		return soc0118VWDAO.searchNetDeviceListByCond(cond, start, count);
	}
	
	/**
	 * 清空指定eiid的资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118VWSearchCond cond)throws BLException{
		return soc0118VWDAO.clearEidescByEiid(cond);
	}
	
	/**
	 * 删除eiid和eirootmark在 给定范围内的资产
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids)throws BLException{
		return soc0118VWDAO.delByEiid(eiids);
	}
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
//	public SOC0605Info searchSOC0605InfoByKey(Integer eiid) throws BLException{
//		checkExistEntityItem(eiid);
//		SOC0605Info ret = this.soc0605DAO.findByPK(eiid);
//		return ret;
//	}
	
	/**
	 * 判断登陆用户是否有查看该资产配置信息的权限
	 * 
	 * @param user 用户信息
	 * @param SOC0605Info 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkSOC0605InfoDomain(User user,SOC0605Info soc0605Info) throws BLException{
		
		//无匹配角色类型则表示没有权限控制
		String roleType = EntityCategory.getRoleType(soc0605Info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//无权限控制 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(soc0605Info.getEiuserid())) {
				return true;
			} else {
				//资产登记人可见，资产所属模型对应的管理角色负责人可见
				UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
				//构造查询条件
				cond.setUserid(user.getUserid());//用户ID
				cond.setRoletype(roleType);//角色类型
				cond.setRolemanager(true);//角色负责人
				List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
				if(userRoleInfoList.isEmpty()) {
					return false;
				} else {
					return true;
				}
			}
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_B.equals(mode)) {
			UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
			//构造查询条件
			cond.setUserid(user.getUserid());//用户ID
			cond.setRoletype(roleType);//角色类型
			List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
			//如果userRoleInfoList的长度大于0，表示该用户具有资产管理角色
			if (userRoleInfoList.size() > 0) {		
				for (UserRoleInfo userRoleInfo : userRoleInfoList) {
					if (StringUtils.isNotEmpty(userRoleInfo.getAssetdomain()) && StringUtils.isNotEmpty(userRoleInfo.getRoledomain())) {							
						if (soc0605Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||soc0605Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(soc0605Info.getEsyscoding())){
								//如果是组件或者服务记录只需满足管理内容就表示该用户具有查看资产配置信息的权限
								if (soc0605Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(soc0605Info.getEsyscoding())&&StringUtils.isNotEmpty(soc0605Info.getEiorgsyscoding())){
								//如果不是组件和服务记录需同时满足管理域与管理内容才表示该用户具有查看资产配置信息的权限
								if (soc0605Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& soc0605Info.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
									return true;
								}				
							}
						}
					}
				}
			}
			return false;
		} else {
			//不可见
			return false;
		}
		
	}
	/**
	 * 获取主机信息
	 * 配置一致性对比 中 根据业务系统 查询主机时 使用
	 * @param cond
	 * @return
	 */
	public List<Map<String,String>> searchHostList(SOC0118VWSearchCond cond)throws BLException{
		return soc0118VWDAO.searchHostList(cond);
	}
	
	public void deleteEntityItemByEilabel(String eilabel) throws BLException {
		soc0118VWDAO.deleteEntityItemByEilabel(eilabel);
	}
	
	public int getEntityItemSearchCountByHost(SOC0118VWSearchCondImpl cond)
		throws BLException {
		return soc0118VWDAO.getEntityItemSearchCountByHost(cond);
	}

	public List<SOC0118VWInfo> searchEntityItemByHost(SOC0118VWSearchCondImpl cond,
		int fromCount, int pageDispCount) throws BLException {
	return soc0118VWDAO.searchEntityItemByHost(cond,fromCount,pageDispCount);
	}

	/**
	 * 风险新的编号生成规则
	 * 风险领域缩写+X+二级分类序号+三级分类序号+风险检查项序号
	 * （两位或三位） X     （两位）         （两位）      （三位） IG-X0101-001
	 * @param cond 资产信息检索条件
	 * @date 2014/07/20
	 * @author zhangqiang
	 * @return 资产编号（平台保留）
	 * 
	 */
	public String searchNewNextEntityItemLable(SOC0118VWSearchCond cond) throws BLException{
		//SOC0118VWSearchCondImpl searchCond = new SOC0118VWSearchCondImpl();
		//String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
		// 设置cond检索条件
		//searchCond.setEilabel("IG-X");
		String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
		if(StringUtils.isEmpty(eiLabel)) {
			eiLabel = cond.getEilabel() + "-001";
		} else {
			
//			IG-X0101-001
			Integer lastThree = Integer.parseInt(eiLabel.substring(eiLabel.length()-3));
			if(lastThree<999){
				lastThree+=1;
			}
			int length = lastThree.toString().length();
			if(length>2){
				eiLabel = cond.getEilabel()+"-"+lastThree;
			}else if(length==2){
				eiLabel = cond.getEilabel()+"-0"+lastThree;
			}else if(length==1){
				eiLabel = cond.getEilabel()+"-00"+lastThree;
			}
		}
		
		return eiLabel;
	}
	
	/**
	 * 查询风险库分布情况
	 * @return map key:{riskcont:风险点数量,riskesyscoding:风险点层次码(6位),inspectcont:检查项,inspectesyscoding:检查项层次码(6位),名称}
	 */
	public List<Map> getRiskRepository()throws BLException{
		return soc0118VWDAO.getRiskRepository();
	}
	
	/**
	 * 获取 风险点+检查项  条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchAssessRisk(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchAssessRisk(cond, start, count);
	}
	/**
	 * 获取 评估工作选择的本年度风险点+检查项  条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchRiskInfo(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchRiskInfo(cond, start, count);
	}
	/**
	 * 主键检索处理
	 * @param pk主键
	 * @return 检索结果
	 */
	public List<SOC0118VWInfo> findByPKs(List<SOC0118VWPK> PKs){
		return soc0118VWDAO.findByPKs(PKs);
	}
	/**
	 * 查询应急资源关联的资产集合
	 * @return List<SOC0118VWInfo>
	 */
	public List<SOC0118VWInfo> getEmergencyRelationList(SOC0118VWSearchCond cond, final int start, final int count){
		return soc0118VWDAO.getEmergencyRelationList(cond, start, count);
	}
	/**
	 * 查询应急资源关联的资产集合
	 * @return List<SOC0118VWInfo>
	 */
	public Integer getEmergencyRelationCount(SOC0118VWSearchCond cond){
		return soc0118VWDAO.getEmergencyRelationCount(cond);
	}
}
