/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.util;

import com.deliverik.framework.office.word.WordDocument;
import com.deliverik.framework.office.word.model.AbstractNum;
import com.deliverik.framework.office.word.model.Font;
import com.deliverik.framework.office.word.model.Lvl;
import com.deliverik.framework.office.word.model.Num;
import com.deliverik.framework.office.word.model.NumPr;
import com.deliverik.framework.office.word.model.Numbering;
import com.deliverik.framework.office.word.model.PPr;
import com.deliverik.framework.office.word.model.RPr;
import com.deliverik.framework.office.word.model.Spacing;
import com.deliverik.framework.office.word.model.Style;
import com.deliverik.framework.office.word.model.Tab;
import com.deliverik.framework.office.word.utils.Align;
import com.deliverik.framework.office.word.utils.LineSpacingRule;
import com.deliverik.framework.office.word.utils.LvlJcType;
import com.deliverik.framework.office.word.utils.NumberFormat;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 导出Word辅助工具类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0 2016-6-14
 */
public class WordUtils {
	
	/** 当前实例对象 */
	private static WordUtils entity = null;
	
	/**
	 * 单例模式，私有化构造方法
	 */
	private WordUtils(){}
	
	/**
	 * 获取工具类实例对象
	 * @return 实例对象
	 */
	public static WordUtils getInstance(){
		if(entity == null){
			entity = new WordUtils();
		}
		return entity;
	}
	
	/**
	 * 创建标题样式
	 * @param document 文档信息
	 * @param id 标题ID
	 * @param name 标题名称
	 * @param level 标题层级
	 */
	public void createStyle(WordDocument document,String id,String name,int level){
		
		//计算字体大小
		int fontSize = 36 - ((level - 1) * 4);
		if(fontSize < 24){
			fontSize = 24;
		}

		//获取样式对象
		Style style = document.createStyle();
		//设置样式ID
		style.setId(id);
		//设置样式名称
		style.setName(name);
		
		//设置段落样式
		PPr ppr = new PPr();
		//添加样式编号信息
		NumPr numPr = new NumPr();
		numPr.setNumId(101);
		numPr.setIlvl(level - 1);
		ppr.setNumPr(numPr);
		
		//创建排列方式
		Tab tab = ppr.addNewTab();
		tab.setPos(432);
		tab.setVal(Align.LEFT);
		
		//设置填充
		Spacing spacing = new Spacing();
		spacing.setBefore(360);
	    spacing.setAfter(360);
	    spacing.setLine(360);
	    spacing.setLineRule(LineSpacingRule.AUTO);
		ppr.setSpacing(spacing);
		
		ppr.setOutlineLvl(level);
		style.setPpr(ppr);
		
		//添加字体信息
		RPr rpr = new RPr();
		Font font = new Font();
        font.setAscii("Arial");
        font.setEastAsia("黑体");
        font.setHAnsi("Arial");
        rpr.setFont(font);
        rpr.setKern(36);
        rpr.setFontSize(fontSize);
        rpr.setSzCs(20);
		style.setRpr(rpr);
	}
	
	/**
	 * 添加文档编号规则
	 * @param document 文档对象
	 */
	public void addNumberProjectNumbering(WordDocument document){
		
		//创建编号规则
		Numbering numbering = document.createNumbering();
		AbstractNum absNum = new AbstractNum();
		absNum.setAbstractNumId(101);
		for(int i=0;i<9;i++){
			Lvl l = new Lvl();
			l.setIlvl(i);
			l.setStart(1);
			l.setNumFmt(NumberFormat.DECIMAL);
			StringBuffer b = new StringBuffer();
			for(int k=0;k<=i;k++){
				if(k > 0){
					b.append(".");
				}
				b.append("%");
				b.append(k+1);
			}
			l.setLvlText(b.toString());
			l.setLvlJc(LvlJcType.LEFT);
			absNum.AddLvl(l);
		}
		numbering.setAbstractNum(absNum);
		Num num = new Num();
		num.setAbstractNumId(101);
		num.setNumId(101);
		numbering.setNum(num);
	}

}
