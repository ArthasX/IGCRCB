/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件分派节点参与人设置
 * </p>
 * 默认为服务台
 * 监控告警事件有运行管理岗分派
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0202BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象取得 */
	protected static final Log log = LogFactory.getLog(IGCRC0202BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;
	
	/** 系统管理API */
	protected SysManageBL sysManageBL;
	
	/** 运行值班岗角色ID */
	protected static final Integer ROLE_ID = 1210;

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 系统管理API设定
	 * @param sysManageBL 系统管理API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * 前处理
	 */
	@SuppressWarnings("unchecked")
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("==============事件分派节点处理人设置操作开始===============");
		//查询当前节点参与人
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		//查询告警表单信息(如果告警表单有值，则证明为告警事件，分派人为运行值班岗角色下的人，否则为普通事件，分派人为服务台角色下的人)
		//设置参与人标识 true 设置运行值班岗为分派人  false  设置服务台为分派人
		boolean flag = false;
		//告警事件则不走该前处理
		String alarmName = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "事件来源");
		if(StringUtils.isNotBlank(alarmName) && alarmName.equals("监控告警")){
			//如果是告警事件，则当前处理人为发起人，在发起节点的后处理已经经过处理了，该段逻辑已经用不到了
			return ;
		}
		//查询表格式表单定义信息
		Object obj = flowSearchBL.searchPublicTableValue("告警信息", bean.getLogInfo().getPrid(), null);
		//遍历表格式表单，查看表单是否有值
		if(obj != null){
			List<Map<String, Object>> tableFormValue = (List<Map<String, Object>>) obj;
			for(Map<String, Object> map : tableFormValue){
				for(Iterator<Entry<String, Object>> iter = map.entrySet().iterator();iter.hasNext();){
					Entry<String, Object> entry = iter.next();
					Object value = entry.getValue();
					if(value != null && StringUtils.isNotEmpty(value.toString().trim())){
						flag = true;
						break;
					}
				}
				if(flag){
					break;
				}
			}
		}
		//实例化节点参与人对象
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		//设置当前节点
		participant.setStatuscode(bean.getAfstatus());
		//删除当前节点参与人
		flowSetBL.deleteStatusParticipant(participant);
		if(flag){
			//设置运行值班岗为当前节点参与人
			List<UserInfo> userList = sysManageBL.searchUserInfo(ROLE_ID, null);
			for(UserInfo ur:userList){
				participant.setUserid(ur.getUserid());
				participant.setRoleid(ROLE_ID);
				flowSetBL.setStatusParticipant(participant);
			}
		}else{
			//设置服务台为当前节点参与人
			for(ParticipantInfo info:list){
				List<UserInfo> userList = sysManageBL.searchUserInfo(info.getRoleid(), null);
				for(UserInfo ur:userList){
					participant.setRoleid(info.getRoleid());
					participant.setUserid(ur.getUserid());
					flowSetBL.setStatusParticipant(participant);
				}
			}
		}
		
		log.debug("==============事件分派节点处理人设置操作结束===============");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
