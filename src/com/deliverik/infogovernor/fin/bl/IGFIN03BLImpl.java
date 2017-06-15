/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * ͼ����ʾ�߼�ʵ��
 *
 */
@SuppressWarnings("unchecked")
public  class IGFIN03BLImpl extends BaseBLImpl implements IGFIN03BL {

	//private static Log log = LogFactory.getLog(IGFIN03BLImpl.class);
	
	private boolean showflag;//�Ƿ���ʾʵ�ʽ������
	
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
		//��bid��ѯ��Ӧ��ʵ�ʷ���
		Double count= 0.0;
		ArrayList countList = new ArrayList();//һ��Ԥ����Զ�Ӧ�������
		ExpenseSearchCond cond = dto.getExpenseSearchCond();

		List<Expense> finInfoList = expenseBL.findByCond(cond, 0, 0);
		for(int i=0,j=finInfoList.size();i<j;i++){
			String exname = "";
			count = finInfoList.get(i).getExamount();//һ��Ԥ����Զ�Ӧ�������
			exname = finInfoList.get(i).getExapvname();//ʵ�ʽ������
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
			//�ֶ���ʾ����ʾʵ�ʽ������
			showflag=true;
		}else{
			//���ֶ���ʾ��
			showflag=false;
		}
		//��Ԥ�����ʱ�������е�Ԥ����󣬲�ȡ��Ԥ����ƴ��xml��Ȼ��ȡ��ÿ�������bid,����bid��ѯʵ�ʷ��ã���ƴ��xml
		IGFIN03DTO igfin03DTO = new IGFIN03DTO();
		form.setBopentime(form.getYear());//��ʼ���
		form.setBclosetime(String.valueOf(Integer.parseInt(form.getYear())+1));//�������Ϊ ��ʼ���+1
		igfin03DTO.setBudgetSearchCond(form);
		List<Budget> budgetList = findBudgetByCondition(igfin03DTO);
		//��������ڸ����͵�Ԥ����ֱ�ӷ���
		if(budgetList.size()==0){
			return "";
		}
		
		ArrayList xmllist = new ArrayList();//�洢IGFIN0302Form
		//����ѯ������Ϣ�洢��xmlform��
		for(int i=0,j=budgetList.size();i<j;i++){
			Budget bg = budgetList.get(i);
			Double bamount = bg.getBamount();//Ԥ����
			String btitle = bg.getBtitle();//Ԥ������
			Integer bid = 0;			
			bid = bg.getBid();//Ԥ��id
			IGFIN03DTO dto = new IGFIN03DTO();
			form.setBid(bid);
			dto.setExpenseSearchCond(form);
			ArrayList examountList = findExpenseByCondition(dto,showflag);//ʵ�ʷ��ý��list
			
			IGFIN0302Form xmlform = new IGFIN0302Form();//�洢��ʾͼ�ε������Ϣ��Ԥ��id��Ԥ�����ơ�Ԥ������ý�
			xmlform.setBid(bid);
			xmlform.setBamount(bamount);
			xmlform.setBtitle(btitle);
			xmlform.setExamountList(examountList);
			xmllist.add(xmlform);
		}
		
		//����xmlform����Ϣ������ʾͼ�ε�xml
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		xml.append("<chart caption='Ԥ����֧��ͳ��' baseFontSize='12'  xaxisname='Ԥ������' PYaxisname='��ֵ ' bgcolor='#FFFFFF' decimals='0' numberPrefix='' numberSuffix='' sNumberSuffix='%25' setAdaptiveSYMin='1' showPlotBorder='1' palette='3' useRoundEdges='1' ");
		xml.append(" subcaption='");
		xml.append(form.getYear());
		xml.append("���' ");
		xml.append(">");
		//ȡ��x��
		xml.append(getBtitleToXml(xmllist));
		//ȡ��data��Ϣ
		if("S".equals(form.getShowType())){
			//�ֶ���ʾ��
			xml.append(getXmlInfo(xmllist));
		}else{
			//���ֶ���ʾ��
			xml.append(getXmlTotalInfo(xmllist));
		}

		xml.append("</chart>");
		dataXml = xml.toString();
		form.setFinxml(dataXml);
		return dataXml;
	}
	
	/**
	 * ��Ԥ����������Ϊ��ʾͼ�ε�x������
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
	 * ��form��ȡ����ֵ��Ϊ��ʾͼ��(����������ʾ)�����ݲ���ƴΪxml��ʽ
	 * @param ArrayList
	 * @return
	 * @throws BLException
	 */
	private String getXmlTotalInfo(ArrayList xmllist)  throws BLException {
		StringBuffer xml = new StringBuffer();
		
		//ƴдxmlԤ�㲿��
		xml.append("<dataset>");
		xml.append("<dataSet seriesName='Ԥ����' color='AFD8F8' showValues='0'>");
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);	
			xml.append("<set value='");
			xml.append(form.getBamount());
			xml.append("' />");
		}
		xml.append("</dataSet>");
		xml.append("</dataset>");
		
		//ƴдxmlʵ�ʷ��ò���
		xml.append("<dataset>");
		xml.append("<dataSet seriesName='ʵ�ʽ��' color='F984A1' showValues='0'>");
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
	 * ��form��ȡ����ֵ��Ϊ��ʾͼ��(�ֶ�������ʾ)�����ݲ���ƴΪxml��ʽ
	 * @param ArrayList
	 * @return
	 * @throws BLException
	 */
	private String getXmlInfo(ArrayList xmllist)  throws BLException {
		StringBuffer xml = new StringBuffer();
		
		//ƴдxmlԤ�㲿��
		xml.append("<dataset>");
		xml.append("<dataSet seriesName='Ԥ����' color='AFD8F8' showValues='0'>");
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);	
			xml.append("<set value='");
			xml.append(form.getBamount());
			xml.append("' />");
		}
		xml.append("</dataSet>");
		xml.append("</dataset>");
		
		//ƴдxmlʵ�ʷ��ò���
		ArrayList bufferList  = new ArrayList();//�洢dataSet��ǩ
		//ȷ������м���dataSet��ǩ,��д��bufferList��Ӧ��λ��
		int x=0;//�������Ӧ���м���dataSet��ǩ����Ŀ
		int b=0;//a��¼��һ����¼���ڼ���ʵ�ʷ��ã�b���¼��ǰ��
		for(int i=0,j=xmllist.size();i<j;i++){
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);			
			ArrayList examountList = form.getExamountList();
			
			b=examountList.size();
			x=b>x?b:x;//�������Ӧ���м���dataSet��ǩ����Ŀ

		}
		//ƴд<dataSet>��ǩͷ
		for(int i=0;i<x;i++){
			StringBuffer titlexml = new StringBuffer();
			titlexml.append("<dataSet ; showValues='0'>");//seriesName='ʵ�ʽ��'
			bufferList.add(titlexml);	
		}
		
		//ƴдset��ǩ
		for(int i=0,j=xmllist.size();i<j;i++){	
			IGFIN0302Form form = (IGFIN0302Form)xmllist.get(i);
			ArrayList examountList = form.getExamountList();
			//������ǩ��ѭ��
			for(int n=0;n<x;n++){
				StringBuffer setxml = new StringBuffer();
				String exname = "seriesName='ʵ�ʽ��'";//ʵ�ʽ������
				String count = "";//ʵ�ʽ��ֵ
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
				//ƴд������<dataSet>ͷ ��δ��ɣ���Ϊ�ؼ�����,ÿ��<dataSet>ֻ����һ��seriesName����,������ʵ�ʽ���м�������ɣ��ڸ�<dataSet>��ǩ�µ�ֵֻ����ʾ��һ��seriesName��ֵ
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

		//��dataSet��ǩ��β��־����
		for(int i=0,j=bufferList.size();i<j;i++){
			StringBuffer titlexml = (StringBuffer)bufferList.get(i);
			titlexml.append("</dataSet>");
			bufferList.set(i, titlexml);
		}
		//��bufferlist�е����ݼ��뵽xml��
		xml.append("<dataset>");
		for(int i=0,j=bufferList.size();i<j;i++){
			StringBuffer titlexml = (StringBuffer)bufferList.get(i);
			xml.append(titlexml.toString());
		}
		xml.append("</dataset>");
		
		return xml.toString();
	}
	
}
