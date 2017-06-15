/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.fin.bl;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.fin.bl.task.BudgetBL;
import com.deliverik.infogovernor.fin.bl.task.ExpenseBL;
import com.deliverik.infogovernor.fin.dto.IGFIN03DTO;
import com.deliverik.infogovernor.fin.form.IGFIN0301Form;
import com.deliverik.infogovernor.fin.form.IGFIN0302Form;
import com.deliverik.infogovernor.fin.model.Budget;
import com.deliverik.infogovernor.fin.model.Expense;
import com.deliverik.infogovernor.fin.model.condition.BudgetSearchCond;
import com.deliverik.infogovernor.fin.model.condition.ExpenseSearchCond;

/**
 * 图形显示逻辑实现
 *
 */
@SuppressWarnings("unchecked")
public  class IGFIN03BLImpl extends BaseBLImpl implements IGFIN03BL {

	//private static Log log = LogFactory.getLog(IGFIN03BLImpl.class);
	
	private boolean showflag;//是否显示实际金额名称
	
	//protected   ExpenseTBDAO expenseTBDAO;
	
	//protected   BudgetTBDAO  budgetTBDAO;
	
	protected BudgetBL budgetBL;

	public void setBudgetBL(BudgetBL budgetBL) {
		this.budgetBL = budgetBL;
	}
     
    protected ExpenseBL expenseBL;
	
	

	public void setExpenseBL(ExpenseBL expenseBL) {
		this.expenseBL = expenseBL;
	}


	

	

	public List<Budget> findBudgetByCondition(IGFIN03DTO dto) throws BLException {

		//String count="0";
		BudgetSearchCond cond = dto.getBudgetSearchCond();

		List<Budget> finInfoList = budgetBL.findByCond(cond, 0, 0);

		return finInfoList;
	}

	public ArrayList findExpenseByCondition(IGFIN03DTO dto,boolean flag) throws BLException {
		//按bid查询对应的实际费用
		Double count= 0.0;
		ArrayList countList = new ArrayList();//一个预算可以对应多个费用
		ExpenseSearchCond cond = dto.getExpenseSearchCond();

		List<Expense> finInfoList = expenseBL.findByCond(cond, 0, 0);
		for(int i=0,j=finInfoList.size();i<j;i++){
			String exname = "";
			count = finInfoList.get(i).getExamount();//一个预算可以对应多个费用
			exname = finInfoList.get(i).getExapvname();//实际金额名称
			if(flag){
				countList.add("seriesName='"+exname+"';"+String.valueOf(count));
			}else{
				countList.add(count);
			}
	
		}

		return countList;
	}

	public String getXmlByCondition(IGFIN0301Form form) throws BLException {
		
		form.setSelectMode("fin");
		if("S".equals(form.getShowType())){
			//分段显示版显示实际金额名称
			showflag=true;
		}else{
			//不分段显示版
			showflag=false;
		}
		//按预算类别及时间查出所有的预算对象，并取得预算金额拼入xml。然后取得每个对象的bid,按照bid查询实际费用，再拼入xml
		IGFIN03DTO igfin03DTO = new IGFIN03DTO();
		form.setBopentime(form.getYear());//起始年份
		form.setBclosetime(String.valueOf(Integer.parseInt(form.getYear())+1));//结束年份为 起始年份+1
		igfin03DTO.setBudgetSearchCond(form);
		List<Budget> budgetList = findBudgetByCondition(igfin03DTO);
		//如果不存在该类型的预算则直接返回
		if(budgetList.size()==0){
			return "";
		}
		
		ArrayList xmllist = new ArrayList();//存储IGFIN0302Form
		//将查询到的信息存储到xmlform中
		for(int i=0,j=budgetList.size();i<j;i++){
			Budget bg = budgetList.get(i);
			Double bamount = bg.getBamount();//预算金额
			String btitle = bg.getBtitle();//预算名称
			Integer bid = 0;			
			bid = bg.getBid();//预算id
			IGFIN03DTO dto = new IGFIN03DTO();
			form.setBid(bid);
			dto.setExpenseSearchCond(form);
			ArrayList examountList = findExpenseByCondition(dto,showflag);//实际费用金额list
			
			IGFIN0302Form xmlform = new IGFIN0302Form();//存储显示图形的相关信息（预算id、预算名称、预算金额、费用金额）
			xmlform.setBid(bid);
			xmlform.setBamount(bamount);
			xmlform.setBtitle(btitle);
			xmlform.setExamountList(examountList);
			xmllist.add(xmlform);
		}
		
		//根据xmlform的信息生成显示图形的xml
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		xml.append("<chart caption='预算与支出统计' baseFontSize='12'  xaxisname='预算名称' PYaxisname='数值 ' bgcolor='#FFFFFF' decimals='0' numberPrefix='' numberSuffix='' sNumberSuffix='%25' setAdaptiveSYMin='1' showPlotBorder='1' palette='3' useRoundEdges='1' ");
		xml.append(" subcaption='");
		xml.append(form.getYear());
		xml.append("年度' ");
		xml.append(">");
		//取得x轴
		xml.append(getBtitleToXml(xmllist));
		//取得data信息
		if("S".equals(form.getShowType())){
			//分段显示版
			xml.append(getXmlInfo(xmllist));
		}else{
			//不分段显示版
			xml.append(getXmlTotalInfo(xmllist));
		}

		xml.append("</chart>");
		dataXml = xml.toString();
		form.setFinxml(dataXml);
		return dataXml;
	}
	
	/**
	 * 把预算名称设置为显示图形的x轴坐标
	 * @param ArrayList
	 * @return
	 * @throws BLException
	 */
	private String getBtitleToXml(ArrayList xmllist)  throws BLException {
		StringBuffer xml = new StringBuffer();
		
		xml.append("<categories font='Arial' fontSize='12' fontColor='000000'>");
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);
			xml.append("<category label='");
			xml.append(form.getBtitle());
			xml.append("' />");
		}
		xml.append("</categories>");

		return xml.toString();
	}
	
	/**
	 * 把form中取出的值作为显示图形(整体数据显示)的数据部分拼为xml格式
	 * @param ArrayList
	 * @return
	 * @throws BLException
	 */
	private String getXmlTotalInfo(ArrayList xmllist)  throws BLException {
		StringBuffer xml = new StringBuffer();
		
		//拼写xml预算部分
		xml.append("<dataset>");
		xml.append("<dataSet seriesName='预算金额' color='AFD8F8' showValues='0'>");
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);	
			xml.append("<set value='");
			xml.append(form.getBamount());
			xml.append("' />");
		}
		xml.append("</dataSet>");
		xml.append("</dataset>");
		
		//拼写xml实际费用部分
		xml.append("<dataset>");
		xml.append("<dataSet seriesName='实际金额' color='F984A1' showValues='0'>");
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);
			ArrayList examountList = form.getExamountList();
			Double count = 0.0; 
			for(int n=0,m=examountList.size();n<m;n++){
				count+=(Double)examountList.get(n);			
			}
			xml.append("<set value='");
			xml.append(String.valueOf(count));
			xml.append("' />");

		}
		xml.append("</dataSet>");
		xml.append("</dataset>");

		return xml.toString();
	}
	
	
	/**
	 * 把form中取出的值作为显示图形(分段数据显示)的数据部分拼为xml格式
	 * @param ArrayList
	 * @return
	 * @throws BLException
	 */
	private String getXmlInfo(ArrayList xmllist)  throws BLException {
		StringBuffer xml = new StringBuffer();
		
		//拼写xml预算部分
		xml.append("<dataset>");
		xml.append("<dataSet seriesName='预算金额' color='AFD8F8' showValues='0'>");
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);	
			xml.append("<set value='");
			xml.append(form.getBamount());
			xml.append("' />");
		}
		xml.append("</dataSet>");
		xml.append("</dataset>");
		
		//拼写xml实际费用部分
		ArrayList bufferList  = new ArrayList();//存储dataSet标签
		//确定最多有几个dataSet标签,并写入bufferList对应的位置
		int x=0;//保存最多应该有几个dataSet标签的数目
		int b=0;//a记录上一条记录存在几个实际费用，b则记录当前的
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);			
			ArrayList examountList = form.getExamountList();
			
			b=examountList.size();
			x=b>x?b:x;//保存最多应该有几个dataSet标签的数目

		}
		//拼写<dataSet>标签头
		for(int i=0;i<x;i++){
			StringBuffer titlexml = new StringBuffer();
			titlexml.append("<dataSet ; showValues='0'>");//seriesName='实际金额'
			bufferList.add(titlexml);	
		}
		
		//拼写set标签
		for(int i=0,j=xmllist.size();i<j;i++){	
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);
			ArrayList examountList = form.getExamountList();
			//按最大标签数循环
			for(int n=0;n<x;n++){
				StringBuffer setxml = new StringBuffer();
				String exname = "seriesName='实际金额'";//实际金额名称
				String count = "";//实际金额值
				if(examountList.size()>=x){
					String temp = (String)(examountList.get(n)==null?'0':examountList.get(n));
					if(!"0".equals(temp)){
						exname = temp.split(";")[0];
						count = temp.split(";")[1];
					}else{
		
						count = "0";
					}
					setxml.append("<set value='");
					setxml.append(count);
					setxml.append("' />");

				}else{
					if((n+1)<=examountList.size()){
						String temp = (String)(examountList.get(n)==null?'0':examountList.get(n));
						if(!"0".equals(temp)){
							exname = temp.split(";")[0];
							count = temp.split(";")[1];
						}else{
							
							count = "0";
						}
						
						setxml.append("<set value='");
						setxml.append(count);
						setxml.append("' />");
					}else{
						setxml.append("<set value='0' />");
						
					}
					
				}
				
				
				StringBuffer titlexml = (StringBuffer)bufferList.get(n);
				StringBuffer newTitlexml = new StringBuffer();
				String temp = titlexml.toString();
				//拼写完整的<dataSet>头 。未完成，因为控件所限,每个<dataSet>只能有一个seriesName属性,即无论实际金额有几部分组成，在该<dataSet>标签下的值只能显示这一个seriesName的值
				if(i==0){
					newTitlexml.append(temp.split(";")[0]+exname+temp.split(";")[1]);
					newTitlexml.append(setxml.toString());
					
					//titlexml.append(setxml.toString());
					bufferList.set(n, newTitlexml);
				}else{
					
					titlexml.append(setxml.toString());
					bufferList.set(n, titlexml);
				}
				

			}	

		}

		//将dataSet标签结尾标志补上
		for(int i=0,j=bufferList.size();i<j;i++){
			StringBuffer titlexml = (StringBuffer)bufferList.get(i);
			titlexml.append("</dataSet>");
			bufferList.set(i, titlexml);
		}
		//将bufferlist中的内容加入到xml中
		xml.append("<dataset>");
		for(int i=0,j=bufferList.size();i<j;i++){
			StringBuffer titlexml = (StringBuffer)bufferList.get(i);
			xml.append(titlexml.toString());
		}
		xml.append("</dataset>");
		
		return xml.toString();
	}
	
}
