package com.deliverik.framework.user.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.condition.ActionSearchCond;

/**
 * <p>
 * 菜单信息业务逻辑
 * </p>
 */
public interface ActionBL extends BaseBL {
	
	/**
	 * 根据检索条件取得菜单信息条数
	 * 
	 * @param cond 菜单信息检索条件
	 * @return 菜单信息条数
	 */
	
	public int getActionSearchCount(ActionSearchCond cond);

	/**
	 * 根据菜单信息主键取得菜单信息
	 * 
	 * @param actname 菜单信息主键
	 * @return 菜单信息
	 * @throws BLException 
	 */
	public Action searchActionByKey(String actname) throws BLException;
	
	/**
	 * 根据检索条件取得菜单信息列表
	 * 
	 * @param cond 菜单信息检索条件
	 * @return 菜单信息列表
	 */
	
	public List<Action> searchAction(ActionSearchCond cond);
	
	/**
	 * 根据检索条件取得菜单信息列表(分页查询用)
	 * 
	 * @param cond 菜单信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 菜单信息列表
	 */
	
	public List<Action> searchAction(ActionSearchCond cond, int start, int count);
	
	/**
	 * 保存菜单信息处理
	 * 
	 * @param action 保存的菜单信息
	 * @return 保存后菜单信息
	 * @throws BLException
	 */
	public Action registAction(Action action) throws BLException;
	
	/**
	 * 删除菜单信息处理
	 * 
	 * @param action 删除的菜单信息
	 * @return
	 * @throws BLException
	 */
	public void deleteAction(Action action) throws BLException;
	
	/**
	 * 根据菜单信息主键删除菜单信息处理
	 * 
	 * @param actname 删除菜单信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteActionByKey(String actname) throws BLException;


	/**
	 * 变更菜单信息处理
	 * 
	 * @param action 变更菜单信息
	 * @return 变更后菜单信息
	 * @throws BLException
	 */
	public Action updateAction(Action action) throws BLException;
	
	/**
	 * 查询用户菜单权限
	 * @param userid 用户ID
	 * @return 用户菜单权限
	 */
	public List<Action> searchUserAction(String userid);
	
	/**
     * 一级菜单主键值取得
     * 
     * @param 菜单ID
     * @return 子菜单主键值
     */
    public String getActnameNextValue(String parActname);
}
