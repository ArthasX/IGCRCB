package com.deliverik.infogovernor.soc.iop.bl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.iop.IOPKeyWords;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP01DTO;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0101Form;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0102Form;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * IP�εǼ�ҵ���߼�ʵ��
 * 
 */
public class IGIOP01BLImpl extends BaseBLImpl implements IGIOP01BL {

	static Log log = LogFactory.getLog(IGIOP01BLImpl.class);

	private SOC0118BL soc0118BL;



	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * �Ǽ�IP��
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO regIP(IGIOP01DTO dto) throws BLException {
			// �Ǽ�IP ��������IP�εĹ�ϵ
		IGIOP0102Form form = dto.getIgiop0102Form();
		
		SOC0118TB subNetInfo = (SOC0118TB)soc0118BL.searchEntityItemByKey(form.getEiid());
		//����״̬��ʶ ������IP
		subNetInfo.setEistatus("N");
		//��ȡ����������
		String netMask = subNetInfo.getEilabel().substring(0, subNetInfo.getEilabel().indexOf("_"));
		//��ȡ�����ڵ�IP
		List<String> ips = getIPBySubNet(subNetInfo.getEiname(), getByte(netMask).indexOf("0"));
		
		User user = dto.getUser();
		//��ǰ����
		String curDate = DateUtils.getCurrentYear()+"/"+DateUtils.getCurrentMonth()+"/"+DateUtils.getCurrentDate();
		List<SOC0118TB> ipList = new ArrayList<SOC0118TB>();
		
		for (String ip : ips) {
			// ���� ip�ʲ�
			SOC0118TB ipTB = soc0118BL.getEntityItemTBInstance();
			ipTB.setEid(IOPKeyWords.IP_EID);
			ipTB.setEidesc("");
			ipTB.setEiinsdate(curDate);
			ipTB.setEilabel(netMask + "_" + ip);
			ipTB.setEiname(ip);
			ipTB.setEiorgsyscoding(user.getOrgid());
			ipTB.setEirootmark(subNetInfo.getEiid());
			ipTB.setEismallversion(0);
			ipTB.setEistatus("");
			ipTB.setEiupdtime("");
			ipTB.setEiuserid(user.getUserid());
			ipTB.setEiusername(user.getUsername());
			ipTB.setEiversion(0);
			ipTB.setEsyscoding(IOPKeyWords.IP_EISYSCODING);
			ipList.add(ipTB);
		}
		try{
			soc0118BL.saveEntityItems(ipList);
		}catch (Exception e) {
			throw new BLException();
		}
		
		dto.addMessage(new ActionMessage("IGIOP0102.I005",ipList.size()));
		
		return dto;
	}
	/**
	 * �Ǽ�����
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO regSubNet(IGIOP01DTO dto) throws BLException {

		IGIOP0101Form form = dto.getIgiop0101Form();

		//**************��������ε�����*************
		List<String> subNets = getGatWays(form.getSubnet(),form.getIpFrom(),form.getIpTo());
		

		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();

		cond.setEiname_in(subNets);

		// ��������Ѿ����� ��Ҫ�Ǽǵ�����  ���˳����εǼ�
		if (soc0118BL.getEntityItemSearchCount(cond) > 0) {
			dto.addMessage(new ActionMessage("IGIOP0101.E002"));
			return dto;
		}

		// ****************��ʼ�Ǽ�IP*************

		// �Ǽ�IP���ʲ�
		User user = dto.getUser();
		
		//�����������ʲ��ļ���
		List<SOC0118TB> subNetInfos = new ArrayList<SOC0118TB>();
		for(String subNet :subNets){
			// ���������ʲ�
			SOC0118TB subNetTB = soc0118BL.getEntityItemTBInstance();
	
			subNetTB.setEid(IOPKeyWords.IPS_EID);
			subNetTB.setEidesc(null);
			subNetTB.setEiinsdate(form.getCreatDate());
			subNetTB.setEilabel(form.getSubnet() + "_" + subNet);
			subNetTB.setEiname(subNet);
			subNetTB.setEiorgsyscoding(user.getOrgid());
			subNetTB.setEirootmark(null);
			subNetTB.setEismallversion(0);
			subNetTB.setEistatus("");
			subNetTB.setEiupdtime("");
			subNetTB.setEiuserid(user.getUserid());
			subNetTB.setEiusername(user.getUsername());
			subNetTB.setEiversion(0);
			subNetTB.setEsyscoding(IOPKeyWords.IPS_EISYSCODING);
			subNetInfos.add(subNetTB);
		}
		
		try{
			soc0118BL.saveEntityItems(subNetInfos);
		}catch (Exception e) {
			e.printStackTrace();
			throw new BLException();
		}
		
		dto.addMessage(new ActionMessage("IGIOP0101.I001",subNetInfos.size()));
		
		return dto;
	}

	/**
	 * ����IP
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO saveIP(IGIOP01DTO dto)throws BLException{
		
		
		List<SOC0118TB> ipList = dto.getTempIPList();
		
		try{
			soc0118BL.saveEntityItems(ipList);
		}catch (Exception e) {
			e.printStackTrace();
			
			throw new BLException();
		}
		dto.addMessage(new ActionMessage("IGIOP0101.I001",ipList.size()));
		return dto;
	}
	
	
	
	/**
	 * ɾ��������ɾ�������ڵ�IP
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO delSubNet(IGIOP01DTO dto)throws BLException{
		IGIOP0102Form form = dto.getIgiop0102Form();
		
		 int result = soc0118BL.delByEiid(form.getDelEiids());
		 
		 
		return dto;
	}

	/**
	 * ����������Ϣ
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO searchIPS(IGIOP01DTO dto)throws BLException{
		IGIOP0102Form form = dto.getIgiop0102Form();

		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		cond.setEid(form.getEid());
		
		cond.setEiname(form.getEiname());
		
		cond.setEilabel_like(form.getSubnet());

		// �豸��Ϣ��ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========IP����Ϣ��ѯ���ݲ�����========");
			// �豸��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGIOP0102.E001"));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========IP����Ϣ��ѯ���ݼ�������========");
			// �豸��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGIOP0102.E002", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		// ��ǰҳ�豸��Ϣȡ��
		List<SOC0118Info> IPSList = this.soc0118BL.searchEntityItem(cond,
				pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setSoc0118List(IPSList);

		return dto;
	}
	
	/**
	 * ���������ڵ�����IP
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	public IGIOP01DTO recoveryAllIP(IGIOP01DTO dto) throws BLException{
		
		IGIOP0102Form form = dto.getIgiop0102Form();
		
		SOC0118TB subNetTB = (SOC0118TB)soc0118BL.searchEntityItemByKey(form.getEiid());
		
		subNetTB.setEidesc(null);
		
		soc0118BL.updateEntityItem(subNetTB);
		
		SOC0118SearchCondImpl soc0118cond = new SOC0118SearchCondImpl();
		
		soc0118cond.setEirootmark(form.getEiid());
		
		soc0118cond.setEid(form.getEid());
		
		Integer result = soc0118BL.clearEidesc(soc0118cond);
		
		
		dto.addMessage(new ActionMessage("IGIOP0102.I003",result));
		
		return  dto;
		
	}
	
	/**
	 * �鿴������IP
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO showIP(IGIOP01DTO dto)throws BLException{
		
		IGIOP0102Form form = dto.getIgiop0102Form();
		

		SOC0118SearchCondImpl soc0118cond = new SOC0118SearchCondImpl();
		
		soc0118cond.setEirootmark(form.getEiid());
		soc0118cond.setEid(IOPKeyWords.IP_EID);
		List<SOC0118Info> ipList = soc0118BL.searchEntityItem(soc0118cond);
		dto.setSoc0118List(ipList);
		if(ipList.size()==0){
			dto.addMessage(new ActionMessage("IGIOP0102.E006"));
		}
		return dto;
	}
	
	/**
	 * ����IP�ʲ���eiid ��ѯ
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO searchIPByEiids(IGIOP01DTO dto){
		IGIOP0102Form form = dto.getIgiop0102Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		List<Integer> eiids = Arrays.asList(form.getEiids());
		
		cond.setEiids(eiids);
		cond.setEid(IOPKeyWords.IP_EID);
		List<SOC0118Info> ipList = soc0118BL.searchEntityItem(cond);
		
		dto.setSoc0118List(ipList);
		
		return dto;
	}
	
	/**
	 * IP����
	 * @param dto
	 * @return
	 */
	public IGIOP01DTO allotIP(IGIOP01DTO dto)throws BLException{
		
		IGIOP0102Form form = dto.getIgiop0102Form();
		
		Integer[] eiids = form.getEiids();
		
		String[] eidesc = form.getEidesc();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < eiids.length; i++) {
			sb.append("update soc0118 set eidesc = '"+eidesc[i]+"' where eiid = "+eiids[i]+";");
		}
		
		int result = soc0118BL.executeSQL(sb.toString());
		
		dto.addMessage(new ActionMessage("IGIOP0102.I004",eiids.length));
		
		return dto;
		
	}
	
	/***
	 * ����ip
	 * @param ipFrom
	 * @param ipTo
	 * @param equalStr
	 * @return
	 */
	private List<String> getIP(String ipFrom, String ipTo, String equalStr) {
		List<String> result = new ArrayList<String>();
		String[] ipStr1 = ipFrom.substring(equalStr.length() + 1,
				ipFrom.length()).split("\\.");
		String[] ipStr2 = ipTo.substring(equalStr.length() + 1, ipTo.length())
				.split("\\.");
		for (int i = Integer.parseInt(ipStr1[0]); i <= Integer
				.parseInt(ipStr2[0]); i++) {
			if (0 == ipStr1.length - 1) {
				String ip = equalStr + "." + i;

				result.add(ip);
			} else {
				String tempIpTo = "";
				String tempIpFrom = "";
				if (i != Integer.parseInt(ipStr2[0])) {
					tempIpTo = equalStr + "." + i + ".255";
				} else {
					tempIpTo = equalStr
							+ ipTo.substring(
									ipTo.indexOf(".", equalStr.length()),
									ipTo.length());
				}
				if (i == Integer.parseInt(ipStr1[0])) {
					tempIpFrom = (equalStr + "." + i)
							+ ipFrom.substring(
									ipFrom.indexOf(".",
											(equalStr + "." + i).length()),
									ipFrom.length());
				} else {
					tempIpFrom = equalStr + "." + i + ".0";
				}
				result.addAll(getIP(tempIpFrom, tempIpTo, equalStr + "." + i));
			}
		}

		return result;

	}
	public List<String> getIP(String ipFrom, String ipTo) {
		
		//�Ƚϳ�����IP֮����ͬ�Ķ�
		String equalStr = "";
		String[] com1 = ipFrom.split("\\.");
		String[] com2 = ipTo.split("\\.");
		for (int i = 0; i < com2.length; i++) {
			if(com1[i].equals(com2[i])){
				equalStr+=com1[i]+".";
				continue;
			}else{
				break;
			}
		}
		
		equalStr = equalStr.substring(0, equalStr.lastIndexOf("."));
		return getIP(ipFrom, ipTo, equalStr);
	}
	
	/**
	 * �������������IP�μ�������
	 * @param netMask ��������
	 * @param fromIP	��ʼIP
	 * @param toIP	��ֹIP
	 * @return ���صļ���
	 */
	public List<String> getGatWays(String netMask,String fromIP,String toIP){
		List<String> gatWays = new ArrayList<String>();
		//��ȡ��������������λ�ĳ���
		int netLength = getByte(netMask).indexOf("0");
		
		String gatWay1 = praseIPFromByte(getByte(fromIP).substring(0, netLength)+"00000000000000000000000000000000".substring(netLength));
		String gatWay2 = praseIPFromByte(getByte(toIP).substring(0, netLength)+"00000000000000000000000000000000".substring(netLength));
		
		gatWays.add(gatWay1);
		if(gatWay1.equals(gatWay2)){
			return gatWays;
		}
		String tempGatWay =null;
		while(true){
			if(tempGatWay==null){
				tempGatWay =gatWay1;
				continue;
			}
			if(tempGatWay.equals(gatWay2)){
				break;
			}
			 tempGatWay = getNextGatWay(tempGatWay,netLength);
			 gatWays.add(tempGatWay);
		}
		return gatWays;
	}
	
	public static void main(String[] args) {
		IGIOP01BLImpl d = new IGIOP01BLImpl();
		
		List<String> l =d.getGatWays("255.255.255.252","57.0.0.0","57.0.253.255");
		List<String> k = d.getIPBySubNet("192.168.0.0", 20);
		for (String string : k) {
			System.out.println(string);
		}
	}
	
	/**
	 * ת��IPΪ������
	 * @param s
	 * @return
	 */
	public String getByte(String s){
		String result ="";
		String[] arrS = s.split("\\.");
		for (String str : arrS) {
			String byteStr = new  BigInteger(str).toString(2);
			result += byteStr.length()==8?byteStr:"00000000".substring(byteStr.length())+byteStr;
		}
		return result;
	}


	/**
	 * ������ת��ΪIP
	 * @param byteStr
	 * @return
	 */
	public String praseIPFromByte(String byteStr){
		StringBuilder IP  = new StringBuilder();
		for(int i = 0;i<32;i=i+8){
			if(IP.length()>0){
				IP.append(".");
			}
			IP.append(new BigInteger(byteStr.substring(i, i+8), 2).toString());
		}
		return IP.toString();
	}
	
	/**
	 * ��ȡ��һ��������ַ
	 * @param gatWay
	 * @param netLength
	 * @return
	 */
	public String getNextGatWay(String gatWay,int netLength){
		String nexGatWay = "";
		
		//��ǰ���صĶ�����
		String gatWayByteStr = getByte(gatWay);
		//��ǰ���ص�����Ϊ�Ķ�����������
		BigInteger i = new BigInteger(gatWayByteStr.substring(0,netLength),2);
		//����λ��ֵ��1
		i=i.add(BigInteger.ONE);
		//��һ�����صĶ�������ʽ
		String nexGatWayStr = "00000000000000000000000000000000".substring(0,netLength-i.toString(2).length())+i.toString(2)+"00000000000000000000000000000000".substring(netLength);
		//ת��ΪIP��ʽ
		nexGatWay = praseIPFromByte(nexGatWayStr);
		return nexGatWay;
	}
	/**
	 * ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP01DTO updateSubNet(IGIOP01DTO dto) throws BLException{
		IGIOP0102Form form = dto.getIgiop0102Form();
		SOC0118TB sunNetTB= (SOC0118TB)soc0118BL.searchEntityItemByKey(form.getUpeiid());
		sunNetTB.setEidesc(form.getUpeidesc());
		soc0118BL.updateEntityItem(sunNetTB);
		return dto;
	}
	
	
	
	/**
	 * ���������������ɸ��������ڵ�IP
	 * @param subNet
	 * @param netMask
	 * @return
	 */
	public List<String> getIPBySubNet(String subNet,Integer netLength){
		//���巵�ؽ����
		List<String> ipList = new ArrayList<String>();
		//��������λ,����λ,�������Ķ������ַ�
		String netStr,hostStr,subNetStr="";
		//�õ������Ķ������ַ�
		subNetStr = getByte(subNet);
		//�õ�����������λ�������ַ�
		netStr = subNetStr.substring(0,netLength);
		//�õ������ڵ�����λ������
		hostStr = subNetStr.substring(netLength);
		
		BigInteger tempNum = null;
		
		while(true){
			if(tempNum==null){
				tempNum =new BigInteger(hostStr,2);
			}
			//����λ��һ�ó���һ������IP
			tempNum=tempNum.add(BigInteger.ONE);
			//����ó��µ������Ķ�����
			String newHostStr = "00000000000000000000000000000000".substring(0,32-netLength-tempNum.toString(2).length())+tempNum.toString(2);
			if(newHostStr.indexOf("0")==-1){
				break;
			}
			ipList.add(praseIPFromByte(netStr+newHostStr));
		}
		return ipList;
	}

}
