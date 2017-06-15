package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG013SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG800DAO;
import com.deliverik.framework.asset.model.dao.IG887DAO;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.dao.IG117DAO;
import com.deliverik.framework.asset.model.dao.IG013DAO;
import com.deliverik.framework.asset.model.dao.IG749DAO;
import com.deliverik.framework.asset.model.dao.IG688DAO;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;



/**
 * 资产信息业务逻辑实现
 * 
 */
public class IG013BLImpl extends BaseBLImpl implements IG013BL {

	/** EntityItem DAO */
	protected IG013DAO ig013DAO;
	
	/** ig688 DAO */
	protected IG688DAO ig688DAO;
	
	/** UserRoleVWDAO DAO */
	protected UserRoleVWDAO userRoleVWDAO;
	
	/** Ig225DAO */
	protected IG225DAO ig225DAO;
	
	/** ConfigItemDAO */
	protected IG800DAO ig800DAO;
	
	/** EntityItem DAO */
	protected IG117DAO ig117DAO;
	
	/** ig887DAO DAO */
	protected IG887DAO ig887DAO;
	
	/** EntityItemEntityVW DAO */
	protected IG749DAO ig749DAO;
	

	public void setIg117DAO(IG117DAO ig117DAO) {
		this.ig117DAO = ig117DAO;
	}

	public void setIg013DAO(IG013DAO ig013DAO) {
		this.ig013DAO = ig013DAO;
	}
	
	public void setIg688DAO(IG688DAO ig688DAO) {
		this.ig688DAO = ig688DAO;
	}
	
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}

	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}

	public void setIg800DAO(IG800DAO ig800DAO) {
		this.ig800DAO = ig800DAO;
	}
	
	public void setIg887DAO(
			IG887DAO ig887DAO) {
		this.ig887DAO = ig887DAO;
	}
	
	public void setIg749DAO(IG749DAO ig749DAO) {
		this.ig749DAO = ig749DAO;
	}

	/**
	 * <p>
	 * 新的资产信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产信息对象实例取得
	 */

	public IG013TB geIG013TBInstance() {
		return new IG013TB();
	}

	/**
	 * 根据检索条件取得资产信息结果条数
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息结果条数
	 */
	public int getIG013InfoSearchCount(IG013SearchCond cond){

		return ig013DAO.getSearchCount(cond);
	}

	/**
	 * 根据资产信息主键取得资产信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 资产信息
	 * @throws BLException 
	 */
	public IG013Info searchIG013InfoByKey(Integer eiid) throws BLException{

		return checkExistEntityItem(eiid);
	}
	
	/**
	 * 根据检索条件取得资产信息列表
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息检索结果列表
	 */
	public List<IG013Info> searchIG013Info(IG013SearchCond cond){

		List<IG013Info> ret = ig013DAO.findByCond(cond,0,0);
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
	public List<IG013Info> searchIG013Info(IG013SearchCond cond, int start, int count){

		List<IG013Info> ret = ig013DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 保存资产信息处理（平台保留）
	 * 
	 * @param entityItem 保存的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public IG013Info registIG013Info(IG013Info entityItem) throws BLException{
		checkNotExistEntityItem(entityItem.getEilabel(),String.valueOf(entityItem.getEid()));
		IG013Info ret = ig013DAO.save(entityItem);
		return ret;
	}
	
	/**
	 * 资产模型信息存在检查
	 * 
	 * @param eid 资产ID
	 * @return 资产模型信息
	 * @throws BLException 
	 */
	private IG117Info checkExistEntity(Integer eid) throws BLException{
		IG117Info info = ig117DAO.findByPK(eid);
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
	private List<IG117Info> getParentNodes(Integer eid) throws BLException{
		checkExistEntity(eid);
		IG117Info entity = ig117DAO.findByPK(eid);
		String esyscoding = entity.getEsyscoding();
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEsyscodingList(list);
		return ig117DAO.findByCond(cond, 0, 0);
	}
	
	
	/**
	 * 根据资产模型ID取得其所有继承属性信息检索结果列表
	 * 
	 * @param eid 模型属性ID
	 * @return 资产模型属性信息检索结果列表
	 * @throws BLException 
	 */
	private List<IG225Info> searchConfigurationByEid(Integer eid) throws BLException{
		List<IG117Info> list = getParentNodes(eid);
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
	 * 保存资产信息处理
	 * 
	 * @param entityItem 保存的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public IG013Info registEntityItemAndConfigItem(IG013Info entityItem) throws BLException{
		checkNotExistIG013Info(entityItem.getEilabel());
		IG013Info ret = ig013DAO.save(entityItem);
		
		List<IG225Info> configurationList = searchConfigurationByEid(ret.getEid());
		for(IG225Info configuration : configurationList) {
			IG800TB configItem = new IG800TB();
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
			configItem.setCiversion(0);
			//小版本号
			configItem.setCismallversion(0);
			
			//更新时间
			configItem.setCiupdtime(ret.getEiupdtime());
			
			ig800DAO.save(configItem);
		}
		return ret;
	}

	/**
	 * 变更资产信息处理
	 * 
	 * @param ig013Info 变更的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public IG013Info updateIG013Info(IG013Info ig013Info) throws BLException{
		checkExistEntityItem(ig013Info.getEiid());
		IG013Info ret = ig013DAO.save(ig013Info);
		return ret;
	}

	/**
	 * 删除资产信息处理
	 * 
	 * @param ig013Info 删除的资产信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013Info(IG013Info ig013Info) throws BLException{
		checkExistEntityItem(ig013Info.getEiid());
		ig013DAO.delete(ig013Info);
	}
	
	/**
	 * 根据资产信息主键删除资产信息处理
	 * 
	 * @param eiid 删除资产信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013InfoByKey(Integer eiid) throws BLException{
		IG013Info entityItem = checkExistEntityItem(eiid);
		ig013DAO.delete(entityItem);
	}

	/**
	 * 资产信息不存在检查
	 * 
	 * @param elabel 资产编号
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG013Info(String eilabel) throws BLException{
		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		
		cond.setEilabel(eilabel);
		
		List<IG013Info> infoList = ig013DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","资产");
		}
	}
	
	/**
	 * 资产信息不存在检查
	 * 
	 * @param elabel 资产编号
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistEntityItem(String eilabel,String eid) throws BLException{
		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		cond.setEid(eid);
		cond.setEilabel(eilabel);
		
		List<IG013Info> infoList = ig013DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","资产");
		}
	}
	
	/**
	 * 资产信息存在检查
	 * 
	 * @param eiid 资产ID
	 * @return 资产信息
	 * @throws BLException 
	 */
	protected IG013Info checkExistEntityItem(Integer eiid) throws BLException{
		IG013Info info = ig013DAO.findByPK(eiid);
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
	public IG688Info searchIG688InfoByKey(Integer eiid) throws BLException{
		checkExistEntityItem(eiid);
		IG688Info ret = this.ig688DAO.findByPK(eiid);
		return ret;
	}

	/**
	 * 资产及其所属模型信息条件检索结果件数取得
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息条件检索结果件数
	 */
	public int getIG688InfoSearchCount(IG688SearchCond cond){

		return ig688DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得资产及其所属模型信息列表
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息检索结果列表
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond){
		
		List<IG688Info> ret = ig688DAO.findByCond(cond, 0, 0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产及其所属模型信息列表
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产及其所属模型信息检索结果列表
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond, int start, int count){

		List<IG688Info> ret = ig688DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 判断登陆用户是否有查看该资产配置信息的权限
	 * 
	 * @param user 用户信息
	 * @param ig688Info 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG688InfoDomain(User user,IG688Info ig688Info) throws BLException{
		
		//无匹配角色类型则表示没有权限控制
		String roleType = EntityCategory.getRoleType(ig688Info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//无权限控制 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(ig688Info.getEiuserid())) {
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
						if (ig688Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||ig688Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(ig688Info.getEsyscoding())){
								//如果是组件或者服务记录只需满足管理内容就表示该用户具有查看资产配置信息的权限
								if (ig688Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(ig688Info.getEsyscoding())&&StringUtils.isNotEmpty(ig688Info.getEiorgsyscoding())){
								//如果不是组件和服务记录需同时满足管理域与管理内容才表示该用户具有查看资产配置信息的权限
								if (ig688Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& ig688Info.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
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
	 * 判断登陆用户是否有查看该资产配置信息的权限
	 * 
	 * @param user 用户信息
	 * @param entityItemVWInfo 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG499InfoDomain(User user,IG499Info ig499Info) throws BLException{
		
		//无匹配角色类型则表示没有权限控制
		String roleType = EntityCategory.getRoleType(ig499Info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//无权限控制 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(ig499Info.getEiuserid())) {
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
						if (ig499Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||ig499Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(ig499Info.getEsyscoding())){
								//如果是组件或者服务记录只需满足管理内容就表示该用户具有查看资产配置信息的权限
								if (ig499Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(ig499Info.getEsyscoding())&&StringUtils.isNotEmpty(ig499Info.getEiorgsyscoding())){
								//如果不是组件和服务记录需同时满足管理域与管理内容才表示该用户具有查看资产配置信息的权限
								if (ig499Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& ig499Info.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
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
	public String searchNextIG013InfoLable(IG013SearchCond cond) throws BLException{
		String eiLabel = ig013DAO.searchMaxIG013InfoLable(cond);
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
	public String searchNextIG013InfoLableFX(IG013SearchCond cond) throws BLException{
		String eiLabel = ig013DAO.searchMaxIG013InfoLable(cond);
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
	public List<IG887Info> searchVersionUpdateTime(Integer eiid) throws BLException {
		checkExistEntityItem(eiid);
		return this.ig887DAO.searchVersionUpdateTime(eiid);
	}
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count) {
		return this.ig013DAO.searchDeviceService(cond, start, count);
	}
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
	public IG749Info searchIG749InfoByKey(Integer eiid) throws BLException {
		checkExistEntityItem(eiid);
		IG749Info ret = this.ig749DAO.findByPK(eiid);
		return ret;
	}
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion){
		return ig013DAO.searchSwitchService(eiid, version, smallversion);	
	}
}
