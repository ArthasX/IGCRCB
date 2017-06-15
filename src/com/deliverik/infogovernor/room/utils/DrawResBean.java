package com.deliverik.infogovernor.room.utils;

import java.io.Serializable;

/**
 * @Description: DrawResBean
 * 
 * @Author	wangfeng
 * @History 2013-05-29     新建 
 * @Version V1.0
 */
public class DrawResBean implements Serializable{

	private static final long serialVersionUID = 1L;

	/** 绘制结果 */
	private int drawFlag = -1;
	
	/** 左侧x */
	private int ox1 = 0;
	/** 左侧y */
	private int oy1 = 0;
	
	/** 上方x */
	private int ox2 = 0;
	/** 上方y */
	private int oy2 = 0;
	
	/** 右侧x */
	private int ox3 = 0;
	/** 右侧y */
	private int oy3 = 0;
	
	/** 下方x */
	private int ox4 = 0;
	/** 下方y */
	private int oy4 = 0;
	/**
	 * 绘制结果取得
	 *
	 * @return drawFlag 绘制结果
	 */
	public int getDrawFlag() {
		return drawFlag;
	}
	/**
	 * 绘制结果设定
	 *
	 * @param drawFlag 绘制结果
	 */
	public void setDrawFlag(int drawFlag) {
		this.drawFlag = drawFlag;
	}
	/**
	 * 左侧x取得
	 *
	 * @return ox1 左侧x
	 */
	public int getOx1() {
		return ox1;
	}
	/**
	 * 左侧x设定
	 *
	 * @param ox1 左侧x
	 */
	public void setOx1(int ox1) {
		this.ox1 = ox1;
	}
	/**
	 * 左侧y取得
	 *
	 * @return oy1 左侧y
	 */
	public int getOy1() {
		return oy1;
	}
	/**
	 * 左侧y设定
	 *
	 * @param oy1 左侧y
	 */
	public void setOy1(int oy1) {
		this.oy1 = oy1;
	}
	/**
	 * 上方x取得
	 *
	 * @return ox2 上方x
	 */
	public int getOx2() {
		return ox2;
	}
	/**
	 * 上方x设定
	 *
	 * @param ox2 上方x
	 */
	public void setOx2(int ox2) {
		this.ox2 = ox2;
	}
	/**
	 * 上方y取得
	 *
	 * @return oy2 上方y
	 */
	public int getOy2() {
		return oy2;
	}
	/**
	 * 上方y设定
	 *
	 * @param oy2 上方y
	 */
	public void setOy2(int oy2) {
		this.oy2 = oy2;
	}
	/**
	 * 右侧x取得
	 *
	 * @return ox3 右侧x
	 */
	public int getOx3() {
		return ox3;
	}
	/**
	 * 右侧x设定
	 *
	 * @param ox3 右侧x
	 */
	public void setOx3(int ox3) {
		this.ox3 = ox3;
	}
	/**
	 * 右侧y取得
	 *
	 * @return oy3 右侧y
	 */
	public int getOy3() {
		return oy3;
	}
	/**
	 * 右侧y设定
	 *
	 * @param oy3 右侧y
	 */
	public void setOy3(int oy3) {
		this.oy3 = oy3;
	}
	/**
	 * 下方x取得
	 *
	 * @return ox4 下方x
	 */
	public int getOx4() {
		return ox4;
	}
	/**
	 * 下方x设定
	 *
	 * @param ox4 下方x
	 */
	public void setOx4(int ox4) {
		this.ox4 = ox4;
	}
	/**
	 * 下方y取得
	 *
	 * @return oy4 下方y
	 */
	public int getOy4() {
		return oy4;
	}
	/**
	 * 下方y设定
	 *
	 * @param oy4 下方y
	 */
	public void setOy4(int oy4) {
		this.oy4 = oy4;
	}
}