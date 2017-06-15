/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.user.model.Action;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_�˵���ȨVO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM04041VO extends BaseVO implements Serializable {

	/**
	 * �˵�����List
	 */
	
	protected List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList;
	
	/**
	 * ���췽��
	 * @param actionList List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public IGSYM04041VO(List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> actionList) {
		this.actionList = actionList;
	}
	
	/**
	 * ��ȡ�˵�����List
	 * @return List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>>
	 */
	
	public List<Map<Action,List<Map<Action,List<Map<Action,List<Action>>>>>>> getActionList() {
		return actionList;
	}
	
}
