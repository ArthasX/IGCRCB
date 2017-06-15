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
	/**节点集合*/
	private List<IG333Info> stepArr = new ArrayList<IG333Info>();
	/**记录节点的psdid*/
	private String lineName = "";
	/**记录每个节点的预计时间*/
	/**记录每条线的时间*/
	private Integer lineCountTime = 0;

	

	/**  
	 * 获取stepArr  
	 * @return stepArr 
	 */
	public List<IG333Info> getStepArr() {
		return stepArr;
	}

	/**  
	 * 设置stepArr  
	 * @param stepArr
	 */
	
	public void setStepArr(List<IG333Info> stepArr) {
		this.stepArr = stepArr;
	}

	/**  
	 * 获取lineCountTime  
	 * @return lineCountTime 
	 */
	public Integer getLineCountTime() {
		return lineCountTime;
	}

	/**  
	 * 设置lineCountTime  
	 * @param lineCountTime
	 */
	
	public void setLineCountTime(Integer lineCountTime) {
		this.lineCountTime = lineCountTime;
	}

	/**  
	 * 设置lineName  
	 * @param lineName
	 */
	
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	/**
	 * 添加节点
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
	 * 科隆连线数组
	 */
	public StepLine clone(){
		StepLine copyLine = new StepLine();
		
		copyLine.lineCountTime = this.lineCountTime+0;
		
		copyLine.lineName = this.lineName+"";
		
		copyLine.stepArr.addAll(this.stepArr);
		
		return copyLine;
	}
	
}
