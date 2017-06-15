package com.deliverik.framework.user.bl.task;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.condition.ActionSearchCond;
import com.deliverik.framework.user.model.dao.ActionTBDAO;

/**
 * <p>
 * 菜单信息业务逻辑实现
 * </p>
 */
public class ActionBLImpl extends BaseBLImpl implements ActionBL {
	
	/** 菜单信息相关操作DAO */
	
	protected ActionTBDAO actionTBDAO;

	/**
	 * 菜单信息相关操作DAO设定
	 * @param actionTBDAO 菜单信息相关操作DAO
	 */
	
	public void setActionTBDAO(ActionTBDAO actionTBDAO) {
		this.actionTBDAO = actionTBDAO;
	}
	
	/**
	 * 根据检索条件取得菜单信息结果条数
	 * 
	 * @param cond 菜单信息检索条件
	 * @return 菜单信息结果条数
	 */
	public int getActionSearchCount(ActionSearchCond cond){

		return actionTBDAO.getSearchCount(cond);
	}

	
	/**
	 * 根据菜单信息主键取得菜单信息
	 * 
	 * @param actname 菜单信息主键
	 * @return 菜单信息
	 * @throws BLException 
	 */
	public Action searchActionByKey(String actname) throws BLException{

		return checkExistAction(actname);
	}
	
	/**
	 * 根据检索条件取得菜单信息列表
	 * 
	 * @param cond 菜单信息检索条件
	 * @return 菜单信息检索结果列表
	 */

	public List<Action> searchAction(ActionSearchCond cond){

		List<Action> ret = actionTBDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据检索条件取得菜单信息列表
	 * 
	 * @param cond 菜单信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 菜单信息检索结果列表
	 */
	public List<Action> searchAction(ActionSearchCond cond, int start, int count){

		List<Action> ret = actionTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 保存菜单信息处理
	 * 
	 * @param action 保存的菜单信息数据
	 * @return 菜单信息
	 * @throws BLException
	 */
	public Action registAction(Action Action) throws BLException{
		Action ret = actionTBDAO.save(Action);
		return ret;
	}

	/**
	 * 变更菜单信息处理
	 * 
	 * @param action 变更的菜单信息数据
	 * @return 菜单信息
	 * @throws BLException
	 */
	public Action updateAction(Action action) throws BLException{
		checkExistAction(action.getActname());
		Action ret = actionTBDAO.save(action);
		return ret;
	}

	/**
	 * 删除菜单信息处理
	 * 
	 * @param action 删除的菜单信息数据
	 * @return
	 * @throws BLException
	 */
	public void deleteAction(Action action) throws BLException{
		checkExistAction(action.getActname());
		actionTBDAO.delete(action);
	}
	
	/**
	 * 根据菜单信息主键删除菜单信息处理
	 * 
	 * @param actname 删除菜单信息的主键
	 * @return
	 * @throws BLException
	 */

	public void deleteActionByKey(String actname) throws BLException {
		Action action = checkExistAction(actname);
		actionTBDAO.delete(action);
	}
	
	/**
	 * 菜单信息存在检查
	 * 
	 * @param actname 菜单信息ID
	 * @return 菜单信息
	 * @throws BLException 
	 */
	protected Action checkExistAction(String actname) throws BLException{
		Action info = actionTBDAO.findByPK(actname);
		if( info == null) {
			throw new BLException("IGCO10000.E004","菜单基本");
		}
		
		return info;
	}
	
	/**
	 * 查询用户菜单权限
	 * @param userid 用户ID
	 * @return 用户菜单权限
	 */
	public List<Action> searchUserAction(String userid) {
		return actionTBDAO.findUserAction(userid);
	}
	
	/**
     * 一级菜单主键值取得
     * 
     * @param 菜单ID
     * @return 子菜单主键值
     */
    public String getActnameNextValue(String parActname) {
        if (!StringUtils.isEmpty(parActname)) {
            return actionTBDAO.getActnameNextValue(parActname);
        } else {
            return "";
        }
    }
}
