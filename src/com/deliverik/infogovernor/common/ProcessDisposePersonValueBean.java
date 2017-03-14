package com.deliverik.infogovernor.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG337Info;

public class ProcessDisposePersonValueBean {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(ProcessDisposePersonValueBean.class);
	
	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private ProcessDisposePersonValueBean() {

	}

	/**
	 * <p>
	 * Discription:初始化参数
	 * </p>
	 * 
	 * @update byf
	 */
	private static String getProcessParticipants(List<IG337Info> pplist) {
	
		// 未执行人列表
		List<IG337Info> l2 = new ArrayList<IG337Info>();
		// 未执行人员分组
		Map<String, List<IG337Info>> m2 = new LinkedHashMap<String, List<IG337Info>>();
		// 参与人员字符串
		StringBuffer comment = new StringBuffer();
		appendLogTitleCssBegin(comment);
		// 对执行类型分组
		for (IG337Info pp : pplist) {
			// 未执行人列表初始化
			if (StringUtils.isEmpty(pp.getPpproctime())) {
				l2.add(pp);
			}
		}
		// 对未执行人员按部门分组
		for (IG337Info pp : l2) {
			if (m2.get(pp.getPprolename()) == null) {
				// 该部门不存在时的操作
				List<IG337Info> l = new ArrayList<IG337Info>();
				l.add(pp);
				m2.put(pp.getPprolename(), l);
			} else {
				// 该部门已存在时的操作
				m2.get(pp.getPprolename()).add(pp);
			}
		}

		// 对未执行人员进行字符串拼接
		if (null != m2 && m2.size() > 0) {
			// 未执行处理人不为空时的处理
			int idx = 0;
			for (String org : m2.keySet()) {
				if(idx > 0){
					comment.append(",");
				}
				idx ++;
				comment.append(org);
				comment.append("(");
				List<IG337Info> list = m2.get(org);
				for(int i=0;i<list.size();i++){
					IG337Info pp = list.get(i);
					if(i>0){
						comment.append("、");
					}
					String name = StringUtils.isEmpty(pp.getPpusername()) ? "未指定":pp.getPpusername();
					comment.append(name);
				}
				// 对拼接时多出的标点丢弃处理
				comment.append(")");
			}
		}
		
		return comment.toString().replace("(null)", "(未指定)").replaceAll(",", "<br/>");
//		return comment.toString().replace("(null)", "(未指定)").replaceAll(",", "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
	}
	
	/**
	 * <p>
	 * 记录日志标题式样拼接开始，暂时是记录人员信息时调用
	 * </p>
	 * 
	 * @param massage 日志描述信息
	 * @return 含有HTML标签的日志描述信息
	 */

	private static void appendLogTitleCssBegin(StringBuffer massage) {
		massage.append("<span>");
	}

	/**
	 * <p>
	 * Description: 获取流程处理人信息
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update byf
	 */
	public static String getDisposePersonInfo(String prid,String prstatus) {
		log.debug("根据流程id和流程状态查询当前状态处理人开始");
		
		WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");
		
		List<IG337Info> pplist;
		
		String disposePerson="";
		try {
			List<String> statuses = workFlowOperationBL.searchCurrentRecordStatus(Integer.parseInt(prid));
			pplist = new ArrayList<IG337Info>();
			if(statuses != null){
				for(String str:statuses){
					prstatus = str.indexOf("_") >= 0 ? str.split("_")[0] : str;
					List<IG337Info> list = workFlowOperationBL.searchProcessParticipant(Integer.parseInt(prid), prstatus);
					if(!list.isEmpty()){
						pplist.addAll(list);
					}
				}
			}
			if(pplist.isEmpty() && !"C".equals(prstatus)){
				disposePerson="";
			} else {
				//状态参与者处理
				disposePerson=getProcessParticipants(pplist);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			log.debug(e);
		} catch (BLException e) {
			e.printStackTrace();
			log.debug(e);
		}
		
		log.debug("根据流程id和流程状态查询当前状态处理人结束");
		
		return disposePerson;
	}

}
