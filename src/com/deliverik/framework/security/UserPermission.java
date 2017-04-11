/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.user.model.Action;

/**
 * UserPermission bean to be set in user's session. It represents a specified
 * user's access rights to system operations, including menus and buttons
 * according to the user's roles.
 * �˵�Ȩ�޶���
 */

public class UserPermission implements Serializable {

	public static final long serialVersionUID = 1L;
	
	/** �û�ID */
	protected String userId = null;
	
	/** �û��˵�Ȩ�޼���*/
	protected Map<String,String> actionMap = new HashMap<String,String>();
	
	/** �û��˵�Ȩ�޼���,ҳ��head����*/
	protected List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList = null;

	/**
	 * �޲ι��캯��
	 */
	public UserPermission() {
		
	}
	
	/**
	 * �вι��캯��
	 * @param userId �û�ID
	 */
	public UserPermission(String userId) {
		this.userId = userId;
	}
	
	/**
	 * �ж��û��Ƿ��ָ���˵��ɼ�
	 * @param actname �˵�ID
	 * @return true���ɼ���false�����ɼ�
	 */
	public boolean checkPermission(String actname) {
		if (userId != null){
			return actionMap.containsKey(actname);
		}
		return false;
	}
	
	/**
	 * ָ���˵�ACTSORTIDȡ��
	 * @param actname �˵�ID
	 * @return ACTSORTID
	 */
	public String getActsortid(String actname) {
		if (checkPermission(actname)){
			return actionMap.get(actname);
		} else {
			return "";
		}
	}
	
	/**
	 * ��Ӳ˵�
	 * @param actname �˵�ID
	 */
	public void addAction(String actname, String actsortid) {
		actionMap.put(actname,actsortid);
	}
	
	/**
	 * �˵����ϴ�Сȡ��
	 * @return �˵����ϴ�С
	 */
	public int getActionSize(){
		if (actionMap != null ) {
			return actionMap.size();
		} else {
			return 0;
		}
	}
	
	/**
	 * �û��˵�Ȩ�޼���ȡ��
	 * @return �û��˵�Ȩ�޼���
	 */
	public Map<String, String> getActionMap() {
		return actionMap;
	}
	
	/**
	 * �û��˵�Ȩ�޼����趨
	 * @param actionMap �û��˵�Ȩ�޼���
	 */
	public void setActionMap(Map<String, String> actionMap) {
		this.actionMap = actionMap;
	}

	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * �û�ID�趨
	 * @param userId �û�ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * �û��˵�Ȩ�޼���ȡ��
	 * @return �û��˵�Ȩ�޼���
	 */
	public List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> getActionList() {
		return actionList;
	}

	/**
	 * �û��˵�Ȩ�޼����趨
	 * @param actionList �û��˵�Ȩ�޼���
	 */
	public void setActionList(
			List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList) {
		this.actionList = actionList;
	}

	/**
	 * @author ����
	 * @date 20170410
	 * @param actName �˵���
	 * @param list  X���˵��б�    List &ltMap&ltAction,T&gt&gt
	 * @return  &ltT&gt  X-1���˵�  
	 */
	public <T> T  getMenuList(String actName,List<Map<Action,T>> list){
		//Action act;
		for (int i = 0; i < list.size(); i++) {
			Map<Action,T>  map = list.get(i);
			for (Action act :map.keySet()) {
				//act=(Action)a;
				//log.info("M:"+act.getActname());
				if (actName.equals(act.getActname())) {
				//	log.info(act.getActname());					
					return (T)map.get(act);
				}
			}
		}
		return null;
	}
}
