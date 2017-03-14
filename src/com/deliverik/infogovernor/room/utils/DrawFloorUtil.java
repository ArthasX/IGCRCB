package com.deliverik.infogovernor.room.utils;

import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.deliverik.framework.utility.ResourceUtility;


public class DrawFloorUtil {

	/** png格式图片拓展名 */
	private final String FILE_TYPE_PNG = ".png";
	
	/** swf格式图片拓展名 */
	private final String FILE_TYPE_SWF = ".swf";
	
	/** 生成图片目录（需要改成配置文件） */
	private final String IMG_PATH = ResourceUtility.getString("DATA_CENTER_IMG_PATH");// /opt/IG/DataCenterPath/
	
	/**
	 * 绘制地板
	 * 
	 * @param imgName	图片名称
	 * @param xCount	横向地板块数
	 * @param yCount	纵向地板块数
	 * @return
	 */
	public DrawResBean drawFloor(String imgName, int xCount, int yCount) {
		
		// 最终返回结果
		DrawResBean drbean = new DrawResBean();
		
		File file = new File(IMG_PATH + imgName + FILE_TYPE_PNG);
		
		// 计算画布大小
		int width;
		int height;
		if (yCount == xCount || yCount < xCount) {
			width = 45 * xCount + 59 * yCount;// The whole img's width
			height = 24 * xCount + 23 * yCount;// The whole img's height
		} else {
//			width = 59 * xCount + 45 * yCount;// The whole img's width
//			height = 23 * xCount + 24 * yCount;// The whole img's height
			width = 45 * xCount + 59 * yCount;// The whole img's width
			height = 24 * xCount + 23 * yCount;// The whole img's height
		}
		
		// 设置原点位置
		int startX = 45 * (xCount - 1);// The first img in X
		int startY = height - 1;// The first img in Y
		
		try {
			// ----------------------------------
			// 绘制机房地板
			// ----------------------------------
			// 加载源图片
			InputStream d1 = new FileInputStream(IMG_PATH + "db1.png");
			InputStream d2 = new FileInputStream(IMG_PATH + "db2.png");
			BufferedImage imgd1 = ImageIO.read(d1);
			BufferedImage imgd2 = ImageIO.read(d2);

			BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) bi.getGraphics();
			bi = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
			g.dispose();
			g = bi.createGraphics();
			
			// 画图算法
			for (int i = xCount; i > 0; i--) {
				for (int j = yCount; j > 0; j--) {
					
					int xv = (startX + (j * 59)) - (i * 45) - 14;
					int yv = (startY - (j * 23)) - (i * 24);
					
					if (i == xCount && j == 1) {// Left
						drbean.setOx1(xv);
						drbean.setOy1(yv + 23);
					} else if (i == xCount && j == yCount) {// Up
						drbean.setOx2(xv + 59);
						drbean.setOy2(yv);
					} else if (i == 1 && j == yCount) {// Right
						drbean.setOx3(width);
						drbean.setOy3(yv + 23);
					} else if (i == 1 && j == 1) {// Down
						drbean.setOx4(xv + 59 - 14);
						drbean.setOy4(yv + 2 * 23);
					}
					
					int stype = 1;
					
					if (i % 2 == 0) {
						if (j % 2 == 1) {
							stype = 1;
						} else if (j % 2 == 0) {
							stype = 2;
						}
					} else if (i % 2 == 1) {
						if (j % 2 == 1) {
							stype = 2;
						} else if (j % 2 == 0) {
							stype = 1;
						}
					}
					
					if (stype == 1) {
						g.drawImage(imgd1, xv, yv, imgd1.getWidth(), imgd1.getHeight(), null, null);
					}else{
						g.drawImage(imgd2, xv, yv, imgd2.getWidth(), imgd2.getHeight(), null, null);
					}
				}
			}
			ImageIO.write(bi, "png", file);
		} catch (Exception e) {
			System.out.println("未找到源图片。");
			drbean.setDrawFlag(-1);
			return drbean;
		}
		
		// ----------------------------------
		// 将生成的图片转换成SWF格式
		// ----------------------------------
		int flag = SWFUtil.png2swf(IMG_PATH + imgName + FILE_TYPE_PNG, IMG_PATH, imgName + FILE_TYPE_SWF);
		drbean.setDrawFlag(flag);
		
		return drbean;
	}

	/**
	 * 获取坐标
	 * 
	 * @param xCount	横向地板块数
	 * @param yCount	纵向地板块数
	 * @return DrawResBean
	 */
	public DrawResBean getDrawResBean(int xCount, int yCount){
		// 最终返回结果
		DrawResBean drbean = new DrawResBean();
		// 计算画布大小
		int width = 45 * xCount + 59 * yCount;// The whole img's width
		int height = 24 * xCount + 23 * yCount;// The whole img's height

		// 设置原点位置
		int startX = 45 * (xCount - 1);// The first img in X
		int startY = height - 1;// The first img in Y
		
		
		// 画图算法
		for (int i = xCount; i > 0; i--) {
			for (int j = yCount; j > 0; j--) {
				
				int xv = (startX + (j * 59)) - (i * 45) - 14;
				int yv = (startY - (j * 23)) - (i * 24);
				
				if (i == xCount && j == 1) {// Left
					drbean.setOx1(xv);
					drbean.setOy1(yv + 23);
				} else if (i == xCount && j == yCount) {// Up
					drbean.setOx2(xv + 59);
					drbean.setOy2(yv);
				} else if (i == 1 && j == yCount) {// Right
					drbean.setOx3(width);
					drbean.setOy3(yv + 23);
				} else if (i == 1 && j == 1) {// Down
					drbean.setOx4(xv + 59 - 14);
					drbean.setOy4(yv + 2 * 23);
				}
			}
		}
		return drbean;
	}
	
	
	/**
	 * 绘制地板
	 * 
	 * @param imgName	图片名称
	 * @param xCount	横向地板块数
	 * @param yCount	纵向地板块数
	 * @return
	 */
	public String imgUpload(String imgName, int xCount, int yCount) {
		
		File file = new File(IMG_PATH + imgName + FILE_TYPE_PNG);
		
		// 计算画布大小
		int width = 45 * xCount + 59 * yCount;// The whole img's width
		int height = 24 * xCount + 23 * yCount;// The whole img's height
		
		// 设置原点位置
		int startX = 45 * (xCount - 1);// The first img in X
		int startY = height - 1;// The first img in Y
		
		try {
			// ----------------------------------
			// 绘制机房地板
			// ----------------------------------
			// 加载源图片
			InputStream d1 = new FileInputStream(IMG_PATH + "db1.png");
			InputStream d2 = new FileInputStream(IMG_PATH + "db2.png");
			BufferedImage imgd1 = ImageIO.read(d1);
			BufferedImage imgd2 = ImageIO.read(d2);

			BufferedImage bi = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = (Graphics2D) bi.getGraphics();
			bi = g.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
			g.dispose();
			g = bi.createGraphics();
			
			// 画图算法
			for (int i = xCount; i > 0; i--) {
				for (int j = yCount; j > 0; j--) {
					
					int xv = (startX + (j * 59)) - (i * 45) - 14;
					int yv = (startY - (j * 23)) - (i * 24);
					
					int stype = 1;
					
					if (i % 2 == 0) {
						if (j % 2 == 1) {
							stype = 1;
						} else if (j % 2 == 0) {
							stype = 2;
						}
					} else if (i % 2 == 1) {
						if (j % 2 == 1) {
							stype = 2;
						} else if (j % 2 == 0) {
							stype = 1;
						}
					}
					
					if (stype == 1) {
						g.drawImage(imgd1, xv, yv, imgd1.getWidth(), imgd1.getHeight(), null, null);
					}else{
						g.drawImage(imgd2, xv, yv, imgd2.getWidth(), imgd2.getHeight(), null, null);
					}
				}
			}
			ImageIO.write(bi, "png", file);
		} catch (Exception e) {
			System.out.println("未找到源图片。");
			return "error";
		}
		
		// ----------------------------------
		// 将生成的图片转换成SWF格式
		// ----------------------------------
		SWFUtil.png2swf(IMG_PATH + imgName + FILE_TYPE_PNG, IMG_PATH, imgName + FILE_TYPE_SWF);
		
		return "ok";
	}
	
}