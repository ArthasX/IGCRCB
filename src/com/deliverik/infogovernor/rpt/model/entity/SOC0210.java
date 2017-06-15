/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利
 */
package com.deliverik.infogovernor.rpt.model.entity;

/**
 * 概述: word对象
 * 功能描述: 用来取某个word文档图片的对象
 * 创建记录: 杨龙全 2012/06/13
 * 修改记录: 卢嘉元 2012/08/09 将DocTemObj表名改为SOC0210
 */
public class SOC0210 {
	/**文档中标识*/
	private String flag;
	/**文档所在路径*/
	private String docPath;
	/**取的图片号*/
	private Integer shapeIndex;
	/**图片识别字符串*/
	private String imgStr;
	/**文件名字*/
	private String docName;
	/**所在位置序号*/
	private Integer locationNum;
	
	public SOC0210() {
	}

	public SOC0210(String flag, String docPath, Integer shapeIndex,
			String imgStr, String docName) {
		super();
		this.flag = flag;
		this.docPath = docPath;
		this.shapeIndex = shapeIndex;
		this.imgStr = imgStr;
		this.docName = docName;
	}



	/**
	 * 文档中标识取得
	 *
	 * @return flag 文档中标识
	 */
	public String getFlag() {
		return flag;
	}



	/**
	 * 文档中标识设定
	 *
	 * @param flag 文档中标识
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}



	/**
	 * 文档所在路径取得
	 *
	 * @return docPath 文档所在路径
	 */
	public String getDocPath() {
		return docPath;
	}



	/**
	 * 文档所在路径设定
	 *
	 * @param docPath 文档所在路径
	 */
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}



	/**
	 * 取的图片号取得
	 *
	 * @return shapeIndex 取的图片号
	 */
	public Integer getShapeIndex() {
		return shapeIndex;
	}



	/**
	 * 取的图片号设定
	 *
	 * @param shapeIndex 取的图片号
	 */
	public void setShapeIndex(Integer shapeIndex) {
		this.shapeIndex = shapeIndex;
	}



	/**
	 * 图片识别字符串取得
	 *
	 * @return imgStr 图片识别字符串
	 */
	public String getImgStr() {
		return imgStr;
	}



	/**
	 * 图片识别字符串设定
	 *
	 * @param imgStr 图片识别字符串
	 */
	public void setImgStr(String imgStr) {
		this.imgStr = imgStr;
	}



	/**
	 * 文件名字取得
	 *
	 * @return docName 文件名字
	 */
	public String getDocName() {
		return docName;
	}



	/**
	 * 文件名字设定
	 *
	 * @param docName 文件名字
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}

	/**
	 * 所在位置序号取得
	 *
	 * @return locationNum 所在位置序号
	 */
	public Integer getLocationNum() {
		return locationNum;
	}

	/**
	 * 所在位置序号设定
	 *
	 * @param locationNum 所在位置序号
	 */
	public void setLocationNum(Integer locationNum) {
		this.locationNum = locationNum;
	}


	
}
