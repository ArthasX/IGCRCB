/**
 * 
 */
package com.deliverik.infogovernor.drm.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.workflow.prd.model.IG333Info;

/**
 * @author Administrator
 *
 */
public class StepLine {
	/**�ڵ㼯��*/
	private List<IG333Info> stepArr = new ArrayList<IG333Info>();
	/**��¼�ڵ��psdid*/
	private String lineName = "";
	/**��¼ÿ���ڵ��Ԥ��ʱ��*/
	/**��¼ÿ���ߵ�ʱ��*/
	private Integer lineCountTime = 0;

	

	/**  
	 * ��ȡstepArr  
	 * @return stepArr 
	 */
	public List<IG333Info> getStepArr() {
		return stepArr;
	}

	/**  
	 * ����stepArr  
	 * @param stepArr
	 */
	
	public void setStepArr(List<IG333Info> stepArr) {
		this.stepArr = stepArr;
	}

	/**  
	 * ��ȡlineCountTime  
	 * @return lineCountTime 
	 */
	public Integer getLineCountTime() {
		return lineCountTime;
	}

	/**  
	 * ����lineCountTime  
	 * @param lineCountTime
	 */
	
	public void setLineCountTime(Integer lineCountTime) {
		this.lineCountTime = lineCountTime;
	}

	/**  
	 * ����lineName  
	 * @param lineName
	 */
	
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	/**
	 * ��ӽڵ�
	 * @param ig333Info
	 */
	public void addStep(IG333Info ig333Info){
		stepArr.add(ig333Info);
		lineName+=(ig333Info.getPsdid()+",");
		if(StringUtils.isNotEmpty(ig333Info.getBysequence())){
			lineCountTime += Integer.parseInt(ig333Info.getBysequence().replaceAll(" ", ""));
		}
	}
	
	public String getLineName(){
		return lineName.length()>0?lineName.substring(0,lineName.length()-1):"";
	}
	/**
	 * ��¡��������
	 */
	public StepLine clone(){
		StepLine copyLine = new StepLine();
		
		copyLine.lineCountTime = this.lineCountTime+0;
		
		copyLine.lineName = this.lineName+"";
		
		copyLine.stepArr.addAll(this.stepArr);
		
		return copyLine;
	}
	
}
