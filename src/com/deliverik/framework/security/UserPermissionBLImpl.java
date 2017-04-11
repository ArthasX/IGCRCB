/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.security;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.bl.task.ActionBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.dao.RoleActionVWDAO;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;

/**
 * Implementation of UserPermissionBL interface. It represents a specified
 * user's access rights to system operations, including menus and buttons
 * according to the user's roles.
 * 
 * @author: Jian Chen
 */

public class UserPermissionBLImpl extends BaseBLImpl implements UserPermissionBL {

	static Log log = LogFactory.getLog(UserPermissionBLImpl.class);
	
	/** �û���ɫDAO */
	protected UserRoleVWDAO userRoleVWDAO;
	
	/** ��ɫ�˵���ȨDAO */
	protected RoleActionVWDAO roleActionVWDAO;
	
	/** �˵�BL */
	protected ActionBL actionBL;
	
	/**
	 * �޲ι��캯��
	 */
	public UserPermissionBLImpl(){
		
	}
	
	/**
	 * �вι��캯��
	 * @param userId �û�ID
	 */
	public UserPermissionBLImpl(String userId) throws BLException{
		initUserPermission(userId);
	}
	
	/**
	 * �û���ɫDAO�趨
	 * @param userRoleVWDAO �û���ɫDAO
	 */
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}

	/**
	 * ��ɫ�˵���ȨDAO�趨
	 * @param roleActionVWDAO ��ɫ�˵���ȨDAO 
	 */
	public void setRoleActionVWDAO(RoleActionVWDAO roleActionVWDAO) {
		this.roleActionVWDAO = roleActionVWDAO;
	}
	
	/**
	 * �˵�BL�趨
	 * @param actionBL �˵�BL
	 */
	public void setActionBL(ActionBL actionBL) {
		this.actionBL = actionBL;
	}
	
	/**
	 * �û��˵�Ȩ�޳�ʼ��
	 * @param userid �û�ID
	 * @return �û��˵�Ȩ��
	 * @throws BLException
	 */
	public UserPermission initUserPermission(String userid) throws BLException {
		
		//�����û��˵�Ȩ�޶���
		UserPermission perm = new UserPermission();
		perm.setUserId(userid);//�趨��¼�û�
		//��ȡ�û�����Ȩ�˵�����
		List<Action> raiList = this.actionBL.searchUserAction(userid);
		//һ���˵�����
		Action firstAction = null;
		//�����˵�����
		Action secondAction = null;
		//�����˵�����
		Action thirdAction = null;
		//�û��˵�Ȩ�޼���
		List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList 
		= new ArrayList<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>();
		//һ���˵�����
		Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>> firstMap = null;
		//�����˵�����
		Map<Action,List<Map<Action,List<Action>>>> secondMap = null;
		//�����˵�����
		Map<Action,List<Action>> thirdMap = null;
		for(int i=0;i<raiList.size();i++){
			Action action = raiList.get(i);
			perm.addAction(action.getActname(),action.getActsortid());
			//����һ���˵�
			if("M1".equals(action.getActtype())){
				firstAction = action;
				firstMap = new LinkedHashMap<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>();
				firstMap.put(firstAction, new ArrayList<Map<Action,List<Map<Action,List<Action>>>>>());
				actionList.add(firstMap);
			}
			//��������˵�
			if("M2".equals(action.getActtype())){
				secondAction = action;
				secondMap = new LinkedHashMap<Action,List<Map<Action,List<Action>>>>();
				secondMap.put(secondAction, new ArrayList<Map<Action,List<Action>>>());
				if(firstMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "���һ���˵�");
				}
				firstMap.get(firstAction).add(secondMap);
			}
			//���������˵�
			if("M3".equals(action.getActtype())){
				thirdAction = action;
				thirdMap = new LinkedHashMap<Action,List<Action>>();
				thirdMap.put(thirdAction, new ArrayList<Action>());
				if(secondMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "��ض����˵�");
				}
				secondMap.get(secondAction).add(thirdMap);
			}
			//���찴ť����ʱ����
			if("M4".equals(action.getActtype())){
				if(thirdMap == null) {
					throw new BLException("IGCO10000.E004",action.getActlabel() + "��������˵�");
				}
				thirdMap.get(thirdAction).add(action);
			}
		}
		perm.setActionList(actionList);
		return perm;
	}
	
	
	
}
