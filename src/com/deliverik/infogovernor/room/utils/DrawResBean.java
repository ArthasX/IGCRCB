package com.deliverik.infogovernor.room.utils;

import java.io.Serializable;

/**
 * @Description: DrawResBean
 * 
 * @Author	wangfeng
 * @History 2013-05-29     �½� 
 * @Version V1.0
 */
public class DrawResBean implements Serializable{

	private static final long serialVersionUID = 1L;

	/** ���ƽ�� */
	private int drawFlag = -1;
	
	/** ���x */
	private int ox1 = 0;
	/** ���y */
	private int oy1 = 0;
	
	/** �Ϸ�x */
	private int ox2 = 0;
	/** �Ϸ�y */
	private int oy2 = 0;
	
	/** �Ҳ�x */
	private int ox3 = 0;
	/** �Ҳ�y */
	private int oy3 = 0;
	
	/** �·�x */
	private int ox4 = 0;
	/** �·�y */
	private int oy4 = 0;
	/**
	 * ���ƽ��ȡ��
	 *
	 * @return drawFlag ���ƽ��
	 */
	public int getDrawFlag() {
		return drawFlag;
	}
	/**
	 * ���ƽ���趨
	 *
	 * @param drawFlag ���ƽ��
	 */
	public void setDrawFlag(int drawFlag) {
		this.drawFlag = drawFlag;
	}
	/**
	 * ���xȡ��
	 *
	 * @return ox1 ���x
	 */
	public int getOx1() {
		return ox1;
	}
	/**
	 * ���x�趨
	 *
	 * @param ox1 ���x
	 */
	public void setOx1(int ox1) {
		this.ox1 = ox1;
	}
	/**
	 * ���yȡ��
	 *
	 * @return oy1 ���y
	 */
	public int getOy1() {
		return oy1;
	}
	/**
	 * ���y�趨
	 *
	 * @param oy1 ���y
	 */
	public void setOy1(int oy1) {
		this.oy1 = oy1;
	}
	/**
	 * �Ϸ�xȡ��
	 *
	 * @return ox2 �Ϸ�x
	 */
	public int getOx2() {
		return ox2;
	}
	/**
	 * �Ϸ�x�趨
	 *
	 * @param ox2 �Ϸ�x
	 */
	public void setOx2(int ox2) {
		this.ox2 = ox2;
	}
	/**
	 * �Ϸ�yȡ��
	 *
	 * @return oy2 �Ϸ�y
	 */
	public int getOy2() {
		return oy2;
	}
	/**
	 * �Ϸ�y�趨
	 *
	 * @param oy2 �Ϸ�y
	 */
	public void setOy2(int oy2) {
		this.oy2 = oy2;
	}
	/**
	 * �Ҳ�xȡ��
	 *
	 * @return ox3 �Ҳ�x
	 */
	public int getOx3() {
		return ox3;
	}
	/**
	 * �Ҳ�x�趨
	 *
	 * @param ox3 �Ҳ�x
	 */
	public void setOx3(int ox3) {
		this.ox3 = ox3;
	}
	/**
	 * �Ҳ�yȡ��
	 *
	 * @return oy3 �Ҳ�y
	 */
	public int getOy3() {
		return oy3;
	}
	/**
	 * �Ҳ�y�趨
	 *
	 * @param oy3 �Ҳ�y
	 */
	public void setOy3(int oy3) {
		this.oy3 = oy3;
	}
	/**
	 * �·�xȡ��
	 *
	 * @return ox4 �·�x
	 */
	public int getOx4() {
		return ox4;
	}
	/**
	 * �·�x�趨
	 *
	 * @param ox4 �·�x
	 */
	public void setOx4(int ox4) {
		this.ox4 = ox4;
	}
	/**
	 * �·�yȡ��
	 *
	 * @return oy4 �·�y
	 */
	public int getOy4() {
		return oy4;
	}
	/**
	 * �·�y�趨
	 *
	 * @param oy4 �·�y
	 */
	public void setOy4(int oy4) {
		this.oy4 = oy4;
	}
}