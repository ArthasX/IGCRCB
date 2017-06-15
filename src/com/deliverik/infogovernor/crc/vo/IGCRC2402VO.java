/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.text.NumberFormat;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:事件平均解决时间VO 
 * </p>
 * 
 * @version 1.0
 */

public class IGCRC2402VO extends BaseVO implements Serializable{

	public IGCRC2402VO() {
		super();
	}
	
	public IGCRC2402VO(IGCRC2402VO timeSum, String userId, String name) {
		super();
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(1);
		this.userId = userId;
		this.name = name;
		//计算平均时间重新保存到对象中
		if(timeSum.getGrade1Count() > 0){
			this.grade1Str = nf.format(timeSum.getGrade1()/new Double(timeSum.getGrade1Count()));
		}else{
			this.grade1Str = "0";
		}
		if(timeSum.getGrade2Count() > 0){
			this.grade2Str = nf.format(timeSum.getGrade2()/new Double(timeSum.getGrade2Count()));
		}else{
			this.grade2Str = "0";
		}
		if(timeSum.getGrade3Count() > 0){
			this.grade3Str = nf.format(timeSum.getGrade3()/new Double(timeSum.getGrade3Count()));
		}else{
			this.grade3Str = "0";
		}
		if(timeSum.getGrade4Count() > 0){
			this.grade4Str = nf.format(timeSum.getGrade4()/new Double(timeSum.getGrade4Count()));
		}else{
			this.grade4Str = "0"; 
		}
		if(timeSum.getGrade5Count() > 0){
			this.grade5Str = nf.format(timeSum.getGrade5()/new Double(timeSum.getGrade5Count()));
		}else{
			this.grade5Str = "0";
		}
		if(timeSum.getGrade6Count() > 0){
			this.grade6Str = nf.format(timeSum.getGrade6()/new Double(timeSum.getGrade6Count()));
		}else{
			this.grade6Str = "0";
		}
		if(timeSum.getGrade7Count() > 0){
			this.grade7Str = nf.format(timeSum.getGrade7()/new Double(timeSum.getGrade7Count()));
		}else{
			this.grade7Str = "0";
		}
		if(timeSum.getGrade8Count() > 0){
			this.grade8Str = nf.format(timeSum.getGrade8()/new Double(timeSum.getGrade8Count()));
		}else{
			this.grade8Str = "0";
		}
		this.pridNUM = timeSum.getPridNUM();
		this.prid_In = timeSum.getPrid_In();
	}
	/**   */	
	
	private static final long serialVersionUID = 1L;
	
	/** 流程数量*/
	protected Integer pridNUM;
	/** 流程主键集合*/
	protected String prid_In;
	/** id */
	protected String userId;
	/** 姓名 */
	protected String name;
	/** 事件级别1 */
	protected String grade1Str;
	/** 事件级别2 */
	protected String grade2Str;
	/** 事件级别3 */
	protected String grade3Str;
	/** 事件级别4 */
	protected String grade4Str;
	/** 事件级别5 */
	protected String grade5Str;
	/** 事件级别6 */
	protected String grade6Str;
	/** 事件级别7 */
	protected String grade7Str;
	/** 事件级别8*/
	protected String grade8Str;
	
	
	/** 事件级别1 */
	protected long grade1;
	/** 事件级别2 */
	protected long grade2;
	/** 事件级别3 */
	protected long grade3;
	/** 事件级别4 */
	protected long grade4;
	/** 事件级别5 */
	protected long grade5;
	/** 事件级别6 */
	protected long grade6;
	/** 事件级别7 */
	protected long grade7;
	/** 事件级别8*/
	protected long grade8;
	
	/** 事件级别1 个数*/
	protected int grade1Count;
	/** 事件级别2 个数*/
	protected int grade2Count;
	/** 事件级别3 个数*/
	protected int grade3Count;
	/** 事件级别4 个数*/
	protected int grade4Count;
	/** 事件级别5 个数*/
	protected int grade5Count;
	/** 事件级别6 个数*/
	protected int grade6Count;
	/** 事件级别7 个数*/
	protected int grade7Count;
	/** 事件级别8 个数*/
	protected int grade8Count;
	/**
	 * 姓名取得
	 * @return name  姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 姓名设定
	 * @param name  姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 事件级别1取得
	 * @return grade1  事件级别1
	 */
	public long getGrade1() {
		return grade1;
	}
	/**
	 * 事件级别1设定
	 * @param grade1  事件级别1
	 */
	public void setGrade1(long grade1) {
		this.grade1 = grade1;
	}
	/**
	 * 事件级别2取得
	 * @return grade2  事件级别2
	 */
	public long getGrade2() {
		return grade2;
	}
	/**
	 * 事件级别2设定
	 * @param grade2  事件级别2
	 */
	public void setGrade2(long grade2) {
		this.grade2 = grade2;
	}
	/**
	 * 事件级别3取得
	 * @return grade3  事件级别3
	 */
	public long getGrade3() {
		return grade3;
	}
	/**
	 * 事件级别3设定
	 * @param grade3  事件级别3
	 */
	public void setGrade3(long grade3) {
		this.grade3 = grade3;
	}
	/**
	 * 事件级别4取得
	 * @return grade4  事件级别4
	 */
	public long getGrade4() {
		return grade4;
	}
	/**
	 * 事件级别4设定
	 * @param grade4  事件级别4
	 */
	public void setGrade4(long grade4) {
		this.grade4 = grade4;
	}
	/**
	 * 事件级别5取得
	 * @return grade5  事件级别5
	 */
	public long getGrade5() {
		return grade5;
	}
	/**
	 * 事件级别5设定
	 * @param grade5  事件级别5
	 */
	public void setGrade5(long grade5) {
		this.grade5 = grade5;
	}
	/**
	 * 事件级别6取得
	 * @return grade6  事件级别6
	 */
	public long getGrade6() {
		return grade6;
	}
	/**
	 * 事件级别6设定
	 * @param grade6  事件级别6
	 */
	public void setGrade6(long grade6) {
		this.grade6 = grade6;
	}
	/**
	 * 事件级别7取得
	 * @return grade7  事件级别7
	 */
	public long getGrade7() {
		return grade7;
	}
	/**
	 * 事件级别7设定
	 * @param grade7  事件级别7
	 */
	public void setGrade7(long grade7) {
		this.grade7 = grade7;
	}
	/**
	 * 事件级别8取得
	 * @return grade8  事件级别8
	 */
	public long getGrade8() {
		return grade8;
	}
	/**
	 * 事件级别8设定
	 * @param grade8  事件级别8
	 */
	public void setGrade8(long grade8) {
		this.grade8 = grade8;
	}
	/**
	 * 事件级别1个数取得
	 * @return grade1Count  事件级别1个数
	 */
	public int getGrade1Count() {
		return grade1Count;
	}
	/**
	 * 事件级别1个数设定
	 * @param grade1Count  事件级别1个数
	 */
	public void setGrade1Count(int grade1Count) {
		this.grade1Count = grade1Count;
	}
	/**
	 * 事件级别2个数取得
	 * @return grade2Count  事件级别2个数
	 */
	public int getGrade2Count() {
		return grade2Count;
	}
	/**
	 * 事件级别2个数设定
	 * @param grade2Count  事件级别2个数
	 */
	public void setGrade2Count(int grade2Count) {
		this.grade2Count = grade2Count;
	}
	/**
	 * 事件级别3个数取得
	 * @return grade3Count  事件级别3个数
	 */
	public int getGrade3Count() {
		return grade3Count;
	}
	/**
	 * 事件级别3个数设定
	 * @param grade3Count  事件级别3个数
	 */
	public void setGrade3Count(int grade3Count) {
		this.grade3Count = grade3Count;
	}
	/**
	 * 事件级别4个数取得
	 * @return grade4Count  事件级别4个数
	 */
	public int getGrade4Count() {
		return grade4Count;
	}
	/**
	 * 事件级别4个数设定
	 * @param grade4Count  事件级别4个数
	 */
	public void setGrade4Count(int grade4Count) {
		this.grade4Count = grade4Count;
	}
	/**
	 * 事件级别5个数取得
	 * @return grade5Count  事件级别5个数
	 */
	public int getGrade5Count() {
		return grade5Count;
	}
	/**
	 * 事件级别5个数设定
	 * @param grade5Count  事件级别5个数
	 */
	public void setGrade5Count(int grade5Count) {
		this.grade5Count = grade5Count;
	}
	/**
	 * 事件级别6个数取得
	 * @return grade6Count  事件级别6个数
	 */
	public int getGrade6Count() {
		return grade6Count;
	}
	/**
	 * 事件级别6个数设定
	 * @param grade6Count  事件级别6个数
	 */
	public void setGrade6Count(int grade6Count) {
		this.grade6Count = grade6Count;
	}
	/**
	 * 事件级别7个数取得
	 * @return grade7Count  事件级别7个数
	 */
	public int getGrade7Count() {
		return grade7Count;
	}
	/**
	 * 事件级别7个数设定
	 * @param grade7Count  事件级别7个数
	 */
	public void setGrade7Count(int grade7Count) {
		this.grade7Count = grade7Count;
	}
	/**
	 * 事件级别8个数取得
	 * @return grade8Count  事件级别8个数
	 */
	public int getGrade8Count() {
		return grade8Count;
	}
	/**
	 * 事件级别8个数设定
	 * @param grade8Count  事件级别8个数
	 */
	public void setGrade8Count(int grade8Count) {
		this.grade8Count = grade8Count;
	}

	/**
	 * id取得
	 * @return userId  id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * id设定
	 * @param userId  id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 事件级别1取得
	 * @return grade1Str  事件级别1
	 */
	public String getGrade1Str() {
		return grade1Str;
	}

	/**
	 * 事件级别1设定
	 * @param grade1Str  事件级别1
	 */
	public void setGrade1Str(String grade1Str) {
		this.grade1Str = grade1Str;
	}

	/**
	 * 事件级别2取得
	 * @return grade2Str  事件级别2
	 */
	public String getGrade2Str() {
		return grade2Str;
	}

	/**
	 * 事件级别2设定
	 * @param grade2Str  事件级别2
	 */
	public void setGrade2Str(String grade2Str) {
		this.grade2Str = grade2Str;
	}

	/**
	 * 事件级别3取得
	 * @return grade3Str  事件级别3
	 */
	public String getGrade3Str() {
		return grade3Str;
	}

	/**
	 * 事件级别3设定
	 * @param grade3Str  事件级别3
	 */
	public void setGrade3Str(String grade3Str) {
		this.grade3Str = grade3Str;
	}

	/**
	 * 事件级别4取得
	 * @return grade4Str  事件级别4
	 */
	public String getGrade4Str() {
		return grade4Str;
	}

	/**
	 * 事件级别4设定
	 * @param grade4Str  事件级别4
	 */
	public void setGrade4Str(String grade4Str) {
		this.grade4Str = grade4Str;
	}

	/**
	 * 事件级别5取得
	 * @return grade5Str  事件级别5
	 */
	public String getGrade5Str() {
		return grade5Str;
	}

	/**
	 * 事件级别5设定
	 * @param grade5Str  事件级别5
	 */
	public void setGrade5Str(String grade5Str) {
		this.grade5Str = grade5Str;
	}

	/**
	 * 事件级别I取得
	 * @return grade6Str  事件级别6
	 */
	public String getGrade6Str() {
		return grade6Str;
	}

	/**
	 * 事件级别6设定
	 * @param grade6Str  事件级别6
	 */
	public void setGrade6Str(String grade6Str) {
		this.grade6Str = grade6Str;
	}

	/**
	 * 事件级别7取得
	 * @return grade7Str  事件级别7
	 */
	public String getGrade7Str() {
		return grade7Str;
	}

	/**
	 * 事件级别7设定
	 * @param grade7Str  事件级别7
	 */
	public void setGrade7Str(String grade7Str) {
		this.grade7Str = grade7Str;
	}

	/**
	 * 事件级别8取得
	 * @return grade8Str  事件级别8
	 */
	public String getGrade8Str() {
		return grade8Str;
	}

	/**
	 * 事件级别8设定
	 * @param grade8Str  事件级别8
	 */
	public void setGrade8Str(String grade8Str) {
		this.grade8Str = grade8Str;
	}

	/**
	 * 流程主键集合获取
	 * @return the prid_In
	 */
	public String getPrid_In() {
		return prid_In;
	}

	/**
	 * 流程主键集合设定
	 * @param prid_In
	 */
	public void setPrid_In(String prid_In) {
		this.prid_In = prid_In;
	}

	/**
	 * 流程数量获取
	 * @return the pridNUM
	 */
	public Integer getPridNUM() {
		return pridNUM;
	}

	/**
	 * 流程数量设定
	 * @param pridNUM
	 */
	public void setPridNUM(Integer pridNUM) {
		this.pridNUM = pridNUM;
	}
}
