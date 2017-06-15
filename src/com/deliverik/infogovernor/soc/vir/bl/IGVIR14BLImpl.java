/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����Դ����BLʵ��
 * </p>
 * 
 * @version 1.0
 */
public class IGVIR14BLImpl extends BaseBLImpl implements IGVIR14BL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGVIR14BLImpl.class);
	
	/** vCenter����BL */
	protected VIM01BL vim01BL;
	
	/** vCenter����BL */
	protected VIMBL vimBL;
	
	/** vm��ϢBL */
	protected VIM03BL vim03BL;
	
	/**���̴���BL*/
    protected WorkFlowOperationBL workFlowOperationBL;
    
	/**
	 * vCenter����BL�趨
	 * @param vim01BL vCenter����BL
	 */
	public void setVim01BL(VIM01BL vim01bl) {
		vim01BL = vim01bl;
	}

	/**
	 * vCenter����BL�趨
	 * @param vimBL vCenter����BL
	 */
	public void setVimBL(VIMBL vimBL) {
		this.vimBL = vimBL;
	}

	/**
	 * vm��ϢBL�趨
	 * @param vim03BL vm��ϢBL
	 */
	public void setVim03BL(VIM03BL vim03bl) {
		vim03BL = vim03bl;
	}

    /**
     * �������̴���BL
     * @param workFlowOperationBL ���̴���BL
     */
    public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
        this.workFlowOperationBL = workFlowOperationBL;
    }

    /**
     * ��ѯδ�رյ���ά���̺���Դ������������
     * 
     * @param dto
     * @return
     * @throws BLException
     */
	public IGVIR14DTO getProcessCountAction(IGVIR14DTO dto) throws BLException {
	    log.debug("============= ��ѯδ�رյ���ά���̺���Դ����������������ʼ ==============");
	    
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
	    cond.setPrActive("Y"); // δ�ر�
	    // δ�رյ��¼�����
	    cond.setPrpdid(IGVIR14BLType.PRPDID_INCIDENT);
        List<IG500Info> processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer incidentCount = processRecordList.size();
        dto.setIncidentCount(incidentCount);
        
        // δ�رյ���������
        cond.setPrpdid(IGVIR14BLType.PRPDID_PROBLEM);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer problemCount = processRecordList.size();
        dto.setProblemCount(problemCount);
        
        // δ�رյı������
        cond.setPrpdid(IGVIR14BLType.PRPDID_CHANGE);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer changeCount = processRecordList.size();
        dto.setChangeCount(changeCount);
        
        // δ�رյ���Դ��������
        cond.setPrpdid(IGVIR14BLType.PRPDID_RESNEW);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer resnewCount = processRecordList.size();
        dto.setResnewCount(resnewCount);
        
        // δ�رյ���Դ��������
        cond.setPrpdid(IGVIR14BLType.PRPDID_RESADJUST);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer resadjustCount = processRecordList.size();
        dto.setResadjustCount(resadjustCount);
        
        // δ�رյ���Դ��������
        cond.setPrpdid(IGVIR14BLType.PRPDID_RESRECOVER);
        processRecordList = workFlowOperationBL.searchProcessRecord(cond );
        Integer resrecoverCount = processRecordList.size();
        dto.setResrecoverCount(resrecoverCount);
        
	    log.debug("============= ��ѯδ�رյ���ά���̺���Դ������������������� ==============");
	    return dto;
	}
	
	/**
	 * ��ѯδ�رյ���ά���̺���Դ���������б�
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR14DTO searchProcessList(IGVIR14DTO dto) throws BLException {
	    log.debug("============== ��ѯδ�رյ���ά���̺���Դ���������б���ʼ ============");
	    
	    IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPrActive("Y"); // δ�ر�
        // δ�رյ���ά����
        cond.setPrpdid_like_or(new String[]{IGVIR14BLType.PRPDID_INCIDENT, IGVIR14BLType.PRPDID_PROBLEM, IGVIR14BLType.PRPDID_CHANGE});
        List<IG500Info> omprocessRecordList = workFlowOperationBL.searchProcessRecord(cond );
	    dto.setOmprocessRecordList(omprocessRecordList);
	    
	    // δ�رյ���Դ��������
	    cond.setPrpdid_like_or(new String[]{IGVIR14BLType.PRPDID_RESNEW, IGVIR14BLType.PRPDID_RESADJUST, IGVIR14BLType.PRPDID_RESRECOVER});
	    List<IG500Info> resprocessRecordList = workFlowOperationBL.searchProcessRecord(cond );
	    dto.setResprocessRecordList(resprocessRecordList);
	    
	    log.debug("============== ��ѯδ�رյ���ά���̺���Դ���������б������ ============");
	    return dto;
	}
	
	/**
	 * ��ȡ����������ĸ���
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR14DTO getVMCount4HostActon(IGVIR14DTO dto) throws BLException{
	    log.debug("============== ��ȡ����������ĸ�������ʼ ==============");
	    
	    IGVIR1403Form form = dto.getIgvir1403Form();
	    
	    Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        
        int totalCount = vim03BL.getVMCount4HostCountByCond(cond);
        // ��ȡ��ҳbean
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
        vmcountMap.put("name", "�������");
        List<Integer> vmcount = new LinkedList<Integer>();
        for (Object[] objs : vmcountList) {
            String hostname =  objs[0] == null ? "δ֪" : objs[0].toString();
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
	    log.debug("============== ��ȡ����������ĸ���������� ==============");
	    return dto;
	}
	
	/**
     * ��Դ����ͳ�����ݲ�ѯ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVMApplyStatisticsDataAction(IGVIR14DTO dto) throws BLException{
        log.debug("==============��Դ����ͳ�����ݲ�ѯ������ʼ============");
        //dto����ȡ��
        IGVIR1401Form form = dto.getIgvir1401Form();
        //ʵ������ѯ����
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
        log.debug("==============��Դ����ͳ�����ݲ�ѯ��������============");
        return dto;
    }
    
    /**
     * ��ʼ��������Ϣ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchVCenterConnectionAction(IGVIR14DTO dto) throws BLException{
        log.debug("============��ѯvCenter������Ϣ������ʼ============");
        List<VIM01Info> list = vim01BL.searchVIM01();
        List<LabelValueBean> labelValueList = new ArrayList<LabelValueBean>();
        for(VIM01Info info:list){
            LabelValueBean bean = new LabelValueBean();
            bean.setLabel(info.getVcname());
            bean.setValue(info.getVcid() + "");
            labelValueList.add(bean);
        }
        dto.setLabelValueBeanList(labelValueList);
        log.debug("============��ѯvCenter������Ϣ��������============");
        return dto;
    }
    
    /**
     * Host��Ϣ��ѯ
     * @param dto
     * @return
     * @throws BLException
     */
    public IGVIR14DTO searchHostInfosAction(IGVIR14DTO dto) throws BLException {
        log.debug("============Host��Ϣ��ѯ������ʼ===========");
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
        log.debug("============Host��Ϣ��ѯ��������===========");
        return dto;
    }
}
