/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Word����������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0 2016-6-14
 */
public class WordUtils {
	
	/** ��ǰʵ������ */
	private static WordUtils entity = null;
	
	/**
	 * ����ģʽ��˽�л����췽��
	 */
	private WordUtils(){}
	
	/**
	 * ��ȡ������ʵ������
	 * @return ʵ������
	 */
	public static WordUtils getInstance(){
		if(entity == null){
			entity = new WordUtils();
		}
		return entity;
	}
	
	/**
	 * ����������ʽ
	 * @param document �ĵ���Ϣ
	 * @param id ����ID
	 * @param name ��������
	 * @param level ����㼶
	 */
	public void createStyle(WordDocument document,String id,String name,int level){
		
		//���������С
		int fontSize = 36 - ((level - 1) * 4);
		if(fontSize < 24){
			fontSize = 24;
		}

		//��ȡ��ʽ����
		Style style = document.createStyle();
		//������ʽID
		style.setId(id);
		//������ʽ����
		style.setName(name);
		
		//���ö�����ʽ
		PPr ppr = new PPr();
		//�����ʽ�����Ϣ
		NumPr numPr = new NumPr();
		numPr.setNumId(101);
		numPr.setIlvl(level - 1);
		ppr.setNumPr(numPr);
		
		//�������з�ʽ
		Tab tab = ppr.addNewTab();
		tab.setPos(432);
		tab.setVal(Align.LEFT);
		
		//�������
		Spacing spacing = new Spacing();
		spacing.setBefore(360);
	    spacing.setAfter(360);
	    spacing.setLine(360);
	    spacing.setLineRule(LineSpacingRule.AUTO);
		ppr.setSpacing(spacing);
		
		ppr.setOutlineLvl(level);
		style.setPpr(ppr);
		
		//���������Ϣ
		RPr rpr = new RPr();
		Font font = new Font();
        font.setAscii("Arial");
        font.setEastAsia("����");
        font.setHAnsi("Arial");
        rpr.setFont(font);
        rpr.setKern(36);
        rpr.setFontSize(fontSize);
        rpr.setSzCs(20);
		style.setRpr(rpr);
	}
	
	/**
	 * ����ĵ���Ź���
	 * @param document �ĵ�����
	 */
	public void addNumberProjectNumbering(WordDocument document){
		
		//������Ź���
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
