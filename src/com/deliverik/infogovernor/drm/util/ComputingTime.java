/**
 * 
 */
package com.deliverik.infogovernor.drm.util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;

/**
 * ����Ԥ��ʱ��
 * @author Administrator
 *
 */
public class ComputingTime {
	/**ÿ���ڵ��Ԥ�ڿ�ʼʱ��*/
	protected Map<String,Integer> nodeTimeMap = new HashMap<String,Integer>();
	/**��¼���ߵ�����*/
	protected List<StepLine> lineArr = new ArrayList<StepLine>();
	/**��¼�߷�������*/
	protected Map<String,IG333Info> stepMap = new HashMap<String,IG333Info>();
	
	/**  
	 * ��ȡnodeTimeMap  
	 * @return nodeTimeMap 
	 */
	public Map<String, Integer> getNodeTimeMap() {
		return nodeTimeMap;
	}
	/**  
	 * ����nodeTimeMap  
	 * @param nodeTimeMap
	 */
	
	public void setNodeTimeMap(Map<String, Integer> nodeTimeMap) {
		this.nodeTimeMap = nodeTimeMap;
	}
	/**  
	 * ��ȡlineArr  
	 * @return lineArr 
	 */
	public List<StepLine> getLineArr() {
		return lineArr;
	}
	/**  
	 * ����lineArr  
	 * @param lineArr
	 */
	
	public void setLineArr(List<StepLine> lineArr) {
		this.lineArr = lineArr;
	}
	/**  
	 * ��ȡstepMap  
	 * @return stepMap 
	 */
	public Map<String, IG333Info> getStepMap() {
		return stepMap;
	}
	/**  
	 * ����stepMap  
	 * @param stepMap
	 */
	
	public void setStepMap(Map<String, IG333Info> stepMap) {
		this.stepMap = stepMap;
	}
	/**
	 * ���ݵ�����Ԥ����ʱ���㼼���ָ������������ʱ
	 * @param prid ����ID
	 * @param pdid ����ID
	 * @return
	 * @throws BLException
	 */
	public String getMaxTime(String prid) throws BLException{
		//��ȡ���̵�prid
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		List<IG333Info> ig333List = new ArrayList<IG333Info>(); 
		int maxTime = 0;
		if(StringUtils.isNotEmpty(prid)){
			IG500Info ig500Info =  ig500BL.searchIG500InfoByKey(Integer.valueOf(prid));
			if(ig500Info!=null){
				String prpdid = ig500Info.getPrpdid();
				cond.setPdid(prpdid);
				cond.setPpsdid("null");
				ig333List = ig333BL.searchIG333Info(cond);
			}
		}
		Map<String,IG333Info> ig333Map = new HashMap<String, IG333Info>();
		if(ig333List!=null && ig333List.size()>0){
			for(IG333Info ig333Info:ig333List){
					ig333Map.put(ig333Info.getPsdid(), ig333Info);
			}
		}
		maxTime = countTotalTime(ig333Map);		
		return String.valueOf(maxTime);
		
	}
	
	/**
	 * ��¼ÿ���ڵ�Ŀ�ʼʱ��
	 * @param pdid
	 * @param ppsdid
	 * @return
	 * @throws BLException
	 */
	
	public Map<String,String> getOrderStep(String pdid,String ppsdid) throws BLException{
		Map<String,String> map = new HashMap<String,String>();
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		//�ж��Ƿ�Ϊ������
		cond.setPpsdid(ppsdid);
		List<IG333Info> ig333List = ig333BL.searchIG333Info(cond);
		Map<String,IG333Info> ig333Map = new HashMap<String, IG333Info>();
		if(ig333List!=null && ig333List.size()>0){
			for(IG333Info ig333Info:ig333List){
				ig333Map.put(ig333Info.getPsdid(), ig333Info);
			}
		}
		stepMap = ig333Map;
		String beginStepid = "";
		for(String psdid:ig333Map.keySet()){
			IG333Info ig333Info = ig333Map.get(psdid);
			if("Z".equals(ig333Info.getPsdcode())){
				beginStepid = psdid;
				nodeTimeMap.put(psdid,0); 
			}
		}
		lineArr = new ArrayList<StepLine>();
		if(stepMap.get(beginStepid)!=null){
			countStep(stepMap.get(beginStepid),null);
		}
		for(int index = 0;index<lineArr.size();index++){
			List<IG333Info> ig333InfoList = lineArr.get(index).getStepArr();
			for(int ig333Index = 0;ig333Index<ig333InfoList.size();ig333Index++){
				IG333Info info = ig333InfoList.get(ig333Index);
				if(ig333Index == 0){
					map.put(info.getPsdid(), info.getBysequence() == null ? "" : info.getBysequence().replace(" ", ""));
				}else{
					IG333Info beforeInfo = ig333InfoList.get(ig333Index-1);
					Integer total = beforeInfo.getBysequence() == null ? 0 : Integer.parseInt(map.get(beforeInfo.getPsdid())) + Integer.parseInt(beforeInfo.getBysequence().replace(" ", ""));
					if(map.get(info.getPsdid())==null){
						map.put(info.getPsdid(), total.toString());
					}else if(Integer.parseInt(map.get(info.getPsdid()))<total){
						map.put(info.getPsdid(), total.toString());
					}
				}
				
			}
		}
		Map<String,String> newMap = sortMapByValue(map);
		return newMap;
	}


	/**
	 * ��MAP��value��������
	 * @param oriMap
	 * @return
	 */
	public Map<String, String> sortMapByValue(Map<String, String> oriMap) {
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
		if (oriMap != null && !oriMap.isEmpty()) {
			List<Map.Entry<String, String>> entryList = new ArrayList<Map.Entry<String, String>>(
					oriMap.entrySet());
			Collections.sort(entryList,
					new Comparator<Map.Entry<String, String>>() {
						public int compare(Entry<String, String> entry1,
								Entry<String, String> entry2) {
							int value1 = 0, value2 = 0;
							try {
								value1 = getInt(entry1.getValue());
								value2 = getInt(entry2.getValue());
							} catch (NumberFormatException e) {
								value1 = 0;
								value2 = 0;
							}
							//�ж��Ƿ�Ϊ�رսڵ㣬����ǹرսڵ������������
							if(value1-value2==0){
									if(Integer.parseInt(entry1.getKey())<Integer.parseInt(entry2.getKey())){
										return -1;
									}else{
										return 1;
									}
								}
							return value1 - value2;
						}
					});
			Iterator<Map.Entry<String, String>> iter = entryList.iterator();
			Map.Entry<String, String> tmpEntry = null;
			while (iter.hasNext()) {
				tmpEntry = iter.next();
				sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
			}
		}
		return sortedMap;
	}

	private int getInt(String str) {
		int i = 0;
		try {
			Pattern p = Pattern.compile("^\\d+");
			Matcher m = p.matcher(str);
			if (m.find()) {
				i = Integer.valueOf(m.group());
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return i;
	}

	
	
	
	/**
	 * Ԥ��ÿ���ڵ�Ԥ����ʱ
	 * @param prid ����ID
	 * @param pdid ����ID
	 * @return
	 * @throws BLException
	 */
	public Map<Integer,Map<String,String>> getStepUseTime(String prid) throws BLException{
		//ͨ����ѯ���̻�ȡ���̶���ID
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		//ͨ��prid��ѯ���̽ڵ�Ĵ����¼
		IG224BL ig224BL = (IG224BL) WebApplicationSupport.getBean("ig224BL");
		IG224SearchCondImpl ig224Cond = new IG224SearchCondImpl();
		ig224Cond.setPrid(Integer.parseInt(prid));
		List<IG224Info> ig224List = ig224BL.searchIG224Info(ig224Cond, 0, 0);
		//ת����map���ڲ�ѯ�˽ڵ�Ĵ���ʱ��
		Map<String,IG224Info> ig224Map = new HashMap<String, IG224Info>();
		if(ig224List!=null && ig224List.size()>0){
			for(IG224Info ig224Info:ig224List){
				ig224Map.put(ig224Info.getPsdid(), ig224Info);
			}
		}
		//��ȡ�����̵Ķ���ID
		IG500Info ig500Info =  ig500BL.searchIG500InfoByKey(Integer.valueOf(prid));
		Map<Integer,Map<String,String>> stepTimeMap = new HashMap<Integer,Map<String,String>>();
		if(ig500Info!=null){
			String prpdid = ig500Info.getPrpdid();
			IG333SearchCondImpl cond = new IG333SearchCondImpl();
			cond.setPdid(prpdid);
			List<IG333Info> ig333List = ig333BL.searchIG333Info(cond);
			Map<String,IG333Info> ig333Map = new HashMap<String, IG333Info>();
			if(ig333List!=null && ig333List.size()>0){
				for(IG333Info ig333Info:ig333List){
					ig333Map.put(ig333Info.getPsdid(), ig333Info);
				}
			}
			stepMap = ig333Map;
			String beginStepid = "";
			for(String psdid:ig333Map.keySet()){
				IG333Info ig333Info = ig333Map.get(psdid);
				if("Z".equals(ig333Info.getPsdcode())){
					beginStepid = psdid;
					nodeTimeMap.put(psdid,0); 
				}
					
			}
			lineArr = new ArrayList<StepLine>();
			if(stepMap.get(beginStepid)!=null){
				countStep(stepMap.get(beginStepid),null);
			}
			for(int index = 0;index<lineArr.size();index++){
				List<IG333Info> ig333InfoList = lineArr.get(index).getStepArr();
				Map<String,String> map = new HashMap<String,String>();
				for(IG333Info info:ig333InfoList){
					map.put(info.getPsdid(), info.getBysequence());
				}
				stepTimeMap.put(index, map);
			}
			
		}
		return null;
	}
	
	/**
	 * ��ȡ��ʱ��
	 * @param nodeArr
	 * @return
	 */
	public Integer countTotalTime(Map<String,IG333Info> nodeArr){
		stepMap = nodeArr;
		String beginStepid = "";
		for(String psdid:nodeArr.keySet()){
			IG333Info ig333Info = nodeArr.get(psdid);
			if("Z".equals(ig333Info.getPsdcode())){
				beginStepid = psdid;
				nodeTimeMap.put(psdid,0); 
			}
				
		}
		lineArr = new ArrayList<StepLine>();
		
		if(stepMap.get(beginStepid)!=null){
			countStep(stepMap.get(beginStepid),null);
		}
		// System.out.println("��ʼ��ӡÿ���ڵ�Ŀ�ʼʱ��");
		Integer totalCount = 0;
		for(int index = 0;index<lineArr.size();index++){
			StepLine stepLine = lineArr.get(index);
			// System.out.println(stepLine.getLineName()+">>>>"+stepLine.getLineCountTime());
			if(stepLine.getLineCountTime()>totalCount){
				totalCount = stepLine.getLineCountTime();
			}
			// System.out.println("��ӡÿ���ڵ�Ŀ�ʼʱ�����");
			// System.out.println("���ʱ����"+totalCount);
		}
		return totalCount;
	}
	
	/**
	 * ��ȡ���̵��߷�
	 * @param curStep
	 * @param stepLine
	 */
	public void countStep(IG333Info curStep,StepLine stepLine){
		
		if("C".equals(curStep.getPsdcode())||"B".equals(curStep.getPsdcode())||"".equals(curStep.getFingerPrint())){
			if (stepLine != null)
				stepLine.addStep(curStep);
			return;
		}
		
		String[] nextIds= curStep.getFingerPrint().split("_");
		if(nextIds==null||nextIds.length==0){
			return;
		}
		// System.out.println("��ǰ�ڵ���"+curStep.getPsdid());
		if(stepLine == null){
			stepLine = new StepLine();
			// System.out.println("�����һ����");
			lineArr.add(stepLine);
		}
		stepLine.addStep(curStep);
		StepLine tempStepLine = null;
		if(nextIds.length>1){
			tempStepLine = stepLine.clone();
		}
		for(int i = 0 ;i<nextIds.length;i++){
			String nextId = nextIds[i];
			// System.out.println("��ʼ����ڵ�Ϊ"+curStep.getPsdid()+"�ĺ�ڵ㡷��"+nextId);
			if(i==0){
				countStep(stepMap.get(nextId),stepLine);
			}else{
				StepLine cloneLine = tempStepLine.clone();
				countStep(stepMap.get(nextId),cloneLine);
				lineArr.add(cloneLine);
				// System.out.println("������һ�׷�֧");
			}
		}
	}
	
	/**
	 * ��ȡ���̸��ڵ��Ԥ��ʱ��  yyyy/MM/dd HH:mm
	 * @param resultMap
	 * @param propentime ���̷���ʱ��
	 * @return
	 * @throws BLException 
	 */
	public Map<String,String> getOrderStepEstimateTime(String pdid,String ppsdid,String propentime) throws BLException{
		//��ȡ���ڵ��뿪ʼʱ��ļ������
		Map<String,String> resultMap = this.getOrderStep(pdid, ppsdid);
		//��ȡ�����Ԥ�ƿ�ʼʱ��
		if(resultMap != null && !resultMap.isEmpty()){
			for(Entry<String,String> entry : resultMap.entrySet()){
				String value = entry.getValue();
				String time = null;
				if(StringUtils.isNotBlank(value)){
					SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
					try {
						Date propenDate = format.parse(propentime);
						Calendar calendar=Calendar.getInstance();   
						calendar.setTime(propenDate); 
						calendar.add(Calendar.MINUTE, Integer.parseInt(value)); //����+
						time = format.format(calendar.getTime());
						
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				entry.setValue(time);
			}
		}
		return resultMap;
	}
}
