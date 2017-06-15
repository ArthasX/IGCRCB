package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;

/**
 * 资产信息业务逻辑
 * 
 */
public interface IG013BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产信息对象实例取得
	 * <p>
	 * 
	 * @return 资产信息对象实例
	 */

	public IG013TB geIG013TBInstance();

	/**
	 * 根据检索条件取得资产信息件数
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息件数
	 */
	public int getIG013InfoSearchCount(IG013SearchCond cond);

	/**
	 * 根据资产信息主键取得资产信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 资产信息
	 */
	public IG013Info searchIG013InfoByKey(Integer eiid) throws BLException;
	
	/**
	 * 根据检索条件取得资产信息列表
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息列表
	 */
	public List<IG013Info> searchIG013Info(IG013SearchCond cond);

	/**
	 * 根据检索条件取得资产信息列表(分页查询用)
	 * 
	 * @param cond 资产信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产信息列表
	 */
	public List<IG013Info> searchIG013Info(IG013SearchCond cond, int start, int count);

	/**
	 * 新增资产信息处理
	 * 
	 * @param IG013Info 资产信息
	 * @return 资产信息
	 * @throws BLException
	 */
	public IG013Info registEntityItemAndConfigItem(IG013Info ig013Info) throws BLException;

	/**
	 * 删除资产信息处理
	 * 
	 * @param ig013Info 资产信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013Info(IG013Info ig013Info) throws BLException;
	
	/**
	 * 根据资产信息主键删除资产信息处理
	 * 
	 * @param eiid 删除资产信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013InfoByKey(Integer eiid) throws BLException;

	/**
	 * 变更资产信息处理
	 * 
	 * @param ig013Info 资产信息
	 * @return 资产信息
	 * @throws BLException
	 */
	public IG013Info updateIG013Info(IG013Info ig013Info) throws BLException;
	
	/**
	 * 资产信息不存在检查
	 * 
	 * @param eilabel 资产编号
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG013Info(String eilabel) throws BLException;
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
	public IG688Info searchIG688InfoByKey(Integer eiid) throws BLException;

	/**
	 * 资产及其所属模型信息条件检索结果件数取得
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息件数
	 */
	public int getIG688InfoSearchCount(IG688SearchCond cond);
	
	/**
	 * 根据检索条件取得资产及其所属模型信息列表
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息列表
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond);


	/**
	 * 根据检索条件取得资产及其所属模型信息列表(分页查询用)
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产及其所属模型信息列表
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond, int start, int count);
	
	/**
	 * 判断登陆用户是否有查看该资产属性信息的权限
	 * 
	 * @param user 用户信息
	 * @param ig688Info 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG688InfoDomain(User user,IG688Info ig688Info) throws BLException;
	
	/**
	 * 新增资产信息处理（平台保留）
	 * 
	 * @param entityItem 资产信息
	 * @return 资产信息
	 * @throws BLException
	 */
	public IG013Info registIG013Info(IG013Info ig013Info) throws BLException;
	
	/**
	 * 获取当前可用资产编号 资产key+年+编号 （位数：4+2+6）
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号（平台保留）
	 */
	public String searchNextIG013InfoLable(IG013SearchCond cond) throws BLException;

	/**
	 * 获取当前可用资产编号 资产key+设备类型code+编号 （位数：10+2+7）阜新银行专用
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号（平台保留）
	 */
	public String searchNextIG013InfoLableFX(IG013SearchCond cond) throws BLException;

	/**
	 *  获取资产历史版本更新时间
	 * 
	 * @param eiid 资产ID
	 * @return 各版本更新时间
	 * @throws BLException 
	 */
	public List<IG887Info> searchVersionUpdateTime(Integer eiid) throws BLException;
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count);
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
	public IG749Info searchIG749InfoByKey(Integer eiid) throws BLException;
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion);
	
	/**
	 * 判断登陆用户是否有查看该资产属性信息的权限
	 * 
	 * @param user 用户信息
	 * @param ig499Info 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG499InfoDomain(User user,IG499Info ig499Info) throws BLException;

}
