/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM01BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR14DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1401Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1403Form;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.vim.VIMBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机资源管理BL实现
 * </p>
 * 
 * @version 1.0
 */
public class IGVIR14BLImpl extends BaseBLImpl implements IGVIR14BL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGVIR14BLImpl.class);
	
	/** vCenter连接BL */
	protected VIM01BL vim01BL;
	
	/** vCenter操作BL */
	protected VIMBL vimBL;
	
	/** vm信息BL */
	protected VIM03BL vim03BL;
	
	/**流程处理BL*/
    protected WorkFlowOperationBL workFlowOperationBL;
    
	/**
	 * vCenter连接BL设定
	 * @param vim01BL vCenter连接BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}

	/**
	 * vCenter操作BL设定
	 * @param vimBL vCenter操作BL
	 */
	public void setVimBL(VIMBL vimBL) {
		this.vimBL = vimBL;
	}

	/**
	 * vm信息BL设定
	 * @param vim03BL vm信息BL
	 */
	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

    /**
     * 设置流程处理BL
     * @param workFlowOperationBL 流程处理BL
     */
    public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
        this.workFlowOperationBL = workFlowOperationBL;
    }

    /**
     * 查询未关闭的运维流程和资源管理流程数量
     * 
     * @param dto
     * @return
     * @throws BLException
     */
	public IGVIR14DTO getProcessCountAction(IGVIR14DTO dto) throws BLException {
	    log.debug("============= 查询未关闭的运维流程和资源管理流程数量处理开始 ==============");
	    
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
	    cond.setPrActive("Y"); // 未关闭
	    // 未关闭的事件数量
	    cond.setPrpdid(IGVIR14BLType.PRPDID_INCIDENT);
        List<IG500Info> processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer incidentCount = processRecordList.size();
        dto.setIncidentCount(incidentCount);
        
        // 未关闭的问题数量
        cond.setPrpdid(IGVIR14BLType.PRPDID_PROBLEM);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer problemCount = processRecordList.size();
        dto.setProblemCount(problemCount);
        
        // 未关闭的变更数量
        cond.setPrpdid(IGVIR14BLType.PRPDID_CHANGE);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer changeCount = processRecordList.size();
        dto.setChangeCount(changeCount);
        
        // 未关闭的资源新增数量
        cond.setPrpdid(IGVIR14BLType.PRPDID_RESNEW);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer resnewCount = processRecordList.size();
        dto.setResnewCount(resnewCount);
        
        // 未关闭的资源调整数量
        cond.setPrpdid(IGVIR14BLType.PRPDID_RESADJUST);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer resadjustCount = processRecordList.size();
        dto.setResadjustCount(resadjustCount);
        
        // 未关闭的资源回收数量
        cond.setPrpdid(IGVIR14BLType.PRPDID_RESRECOVER);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer resrecoverCount = processRecordList.size();
        dto.setResrecoverCount(resrecoverCount);
        
	    log.debug("============= 查询未关闭的运维流程和资源管理流程数量处理结束 ==============");
	    return dto;
	}
	
	/**
	 * 查询未关闭的运维流程和资源申请流程列表
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR14DTO searchProcessList(IGVIR14DTO dto) throws BLException {
	    log.debug("============== 查询未关闭的运维流程和资源申请流程列表处理开始 ============");
	    
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPrActive("Y"); // 未关闭
        // 未关闭的运维流程
        cond.setPrpdid_like_or(new String[]{IGVIR14BLType.PRPDID_INCIDENT, IGVIR14BLType.PRPDID_PROBLEM, IGVIR14BLType.PRPDID_CHANGE});
        List<IG500Info> omprocessRecordList = workFlowOperationBL.searchProcessRecord(cond );
	    dto.setOmprocessRecordList(omprocessRecordList);
	    
	    // 未关闭的资源申请流程
	    cond.setPrpdid_like_or(new String[]{IGVIR14BLType.PRPDID_RESNEW, IGVIR14BLType.PRPDID_RESADJUST, IGVIR14BLType.PRPDID_RESRECOVER});
	    List<IG500Info> resprocessRecordList = workFlowOperationBL.searchProcessRecord(cond );
	    dto.setResprocessRecordList(resprocessRecordList);
	    
	    log.debug("============== 查询未关闭的运维流程和资源申请流程列表处理结束 ============");
	    return dto;
	}
	
	/**
	 * 获取主机下虚机的个数
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR14DTO getVMCount4HostActon(IGVIR14DTO dto) throws BLException{
	    log.debug("============== 获取主机下虚机的个数处理开始 ==============");
	    
	    IGVIR1403Form form = dto.getIgvir1403Form();
	    
	    Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        
        int totalCount = vim03BL.getVMCount4HostCountByCond(cond);
        // 获取分页bean
        List<Object[]> vmcountList = vim03BL.getVMCount4HostByCond(cond, form.getFromCount(), form.getPageDispCount());
        form.setTotalCount(totalCount);
//        vmcountList.add(new Object[]{"192.168.1.1", 10});
//        vmcountList.add(new Object[]{"192.168.1.4", 13});
//        vmcountList.add(new Object[]{"192.168.1.3", 14});
//        vmcountList.add(new Object[]{"192.168.1.5", 11});
//        vmcountList.add(new Object[]{"192.168.1.2", 12});
//        vmcountList.add(new Object[]{"192.168.1.8", 17});
//        vmcountList.add(new Object[]{"192.168.1.6", 15});
//        vmcountList.add(new Object[]{"192.168.1.7", 13});
//        
//        Collections.sort(vmcountList,new Comparator<Object[]>(){
//            public int compare(Object[] arg0, Object[] arg1) {
//                Integer a = Integer.parseInt(arg0[1].toString());
//                Integer b = Integer.parseInt(arg1[1].toString());
//                
//                return a.compareTo(b); 
//            }
//        });
        
        List<String> hostList = new LinkedList<String>();
        Map<String, Object> vmcountMap = new HashMap<String, Object>();
        vmcountMap.put("name", "虚机数量");
        List<Integer> vmcount = new LinkedList<Integer>();
        for (Object[] objs : vmcountList) {
            String hostname =  objs[0] == null ? "未知" : objs[0].toString();
            hostList.add(hostname);
            vmcount.add(Integer.parseInt(objs[1].toString()));
        }
        vmcountMap.put("data", vmcount);
        List<Map<String, Object>> vmcountMapList = new LinkedList<Map<String,Object>>();
        vmcountMapList.add(vmcountMap);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", hostList);
        map.put("value", vmcountMapList);
        map.put("page", form);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        //json = json.replace("\"", "");
        System.out.println(json);
//	    dto.setVmcountList(vmcountList);
        dto.setVmcountJson(json);
	    log.debug("============== 获取主机下虚机的个数处理结束 ==============");
	    return dto;
	}
	
	/**
     * 资源申请统计数据查询
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVMApplyStatisticsDataAction(IGVIR14DTO dto) throws BLException{
        log.debug("==============资源申请统计数据查询操作开始============");
        //dto参数取得
        IGVIR1401Form form = dto.getIgvir1401Form();
        //实例化查询条件
        IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPropentime(form.getPropentime_from());
        cond.setPrclosetime(form.getPropentime_to());
        cond.setPrpdid("01002");
        List<IG500Info> list = workFlowOperationBL.searchProcessRecord(cond);
        Map<String, Integer[]> map = new LinkedHashMap<String, Integer[]>();
        Map<String, List<Integer>> pridMap = new HashMap<String, List<Integer>>();
        for(IG500Info info:list){
            if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
                continue;
            }
            if(map.get(info.getProrgname()) == null){
                Integer[] counts = new Integer[4];
                counts[0] = 1;
                if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPrstatus())){
                    counts[1] = 0;
                    counts[2] = 1;
                }else{
                    counts[1] = 1;
                    counts[2] = 0;
                }
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(info.getPrid());
                pridMap.put(info.getProrgname(), temp);
                map.put(info.getProrgname(), counts);
            }else{
                pridMap.get(info.getProrgname()).add(info.getPrid());
                map.get(info.getProrgname())[0] ++;
                if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPrstatus())){
                    map.get(info.getProrgname())[2] ++;
                }else{
                    map.get(info.getProrgname())[1] ++;
                }
            }
        }
        Vim03SearchCondImpl vim03cond = new Vim03SearchCondImpl();
        for(Iterator<String> iter = map.keySet().iterator();iter.hasNext();){
            String key = iter.next();
            List<Integer> prids = pridMap.get(key);
            vim03cond.setPrid_in(prids);
            int count = vim03BL.getSearchCount(vim03cond);
            map.get(key)[3] = count;
        }
        dto.setVmApplyStatisticsDataMap(map);
        log.debug("==============资源申请统计数据查询操作结束============");
        return dto;
    }
    
    /**
     * 初始化连接信息
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVCenterConnectionAction(IGVIR14DTO dto) throws BLException{
        log.debug("============查询vCenter连接信息操作开始============");
        List<VIM01Info> list = vim01BL.searchVIM01();
        List<LabelValueBean> labelValueList = new ArrayList<LabelValueBean>();
        for(VIM01Info info:list){
            LabelValueBean bean = new LabelValueBean();
            bean.setLabel(info.getVcname());
            bean.setValue(info.getVcid() + "");
            labelValueList.add(bean);
        }
        dto.setLabelValueBeanList(labelValueList);
        log.debug("============查询vCenter连接信息操作结束============");
        return dto;
    }
    
    /**
     * Host信息查询
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchHostInfosAction(IGVIR14DTO dto) throws BLException {
        log.debug("============Host信息查询操作开始===========");
        Map<Integer, List<Host>> map = new LinkedHashMap<Integer, List<Host>>();
        if(dto.getVcid() != null && dto.getVcid() > 0){
        	map.put(dto.getVcid(), vimBL.searchHostByVcid(dto.getVcid()));
        }else{
            List<VIM01Info> vim01List = vim01BL.searchVIM01();
            for(VIM01Info info:vim01List){
            	if(StringUtils.isNotEmpty(dto.getHostname())){
            		List<Host> list = vimBL.searchHostByVcid(info.getVcid());
            		List<Host> temp = new ArrayList<Host>();
            		for(Host host : list){
            			if(host.getName().startsWith(dto.getHostname())){
            				temp.add(host);
            			}
            		}
            		if(temp.size() > 0){
            			map.put(info.getVcid(), temp);
            		}
            	}else{
            		map.put(info.getVcid(), vimBL.searchHostByVcid(info.getVcid()));
            	}
            }
        }
        dto.setHostMap(map);
        log.debug("============Host信息查询操作结束===========");
        return dto;
    }
}
