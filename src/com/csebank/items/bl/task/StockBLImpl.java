package com.csebank.items.bl.task;

import java.io.Serializable;
import java.util.List;

import com.csebank.items.model.Stock;
import com.csebank.items.model.condition.StockSearchCond;
import com.csebank.items.model.condition.StockSearchCondImpl;
import com.csebank.items.model.dao.StockTBDAO;
import com.csebank.items.model.entity.StockTB;
import com.csebank.items.util.CSEHelper;
import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

public class StockBLImpl extends BaseBLImpl implements StockBL{
	
	private StockTBDAO stockTBDAO;

	public void setStockTBDAO(StockTBDAO stockTBDAO) {
		this.stockTBDAO = stockTBDAO;
	}

	public Stock addToStock(Stock stock,String type) throws BLException {
		StockSearchCondImpl cond = new StockSearchCondImpl();
		cond.setCategory(stock.getCategory());
		cond.setSeqcode(stock.getSeqcode());
		cond.setStockorg(stock.getStockorg());
		
		if(DefineUtils.STOCK_PRENUM_RK.equals(type)){//入库
			cond.setStockorg(DefineUtils.DEFAULT_ORGNO);
			List<Stock> stockList = stockTBDAO.findByCond(cond, 0, 0);
			if(stockList == null || stockList.size() == 0){
				stock = stockTBDAO.save(stock);
			} else {
				Stock oldStock = stockList.get(0);
				StockTB stockTB = new StockTB();
				stockTB.clone(oldStock);
				stockTB.setStockid(oldStock.getStockid());
				stockTB.setInamount(stock.getInamount() + oldStock.getInamount());
				stockTB.setOutamount(stock.getOutamount() + oldStock.getOutamount());
				stockTB.setStocknum(stock.getStocknum() + oldStock.getStocknum());
				stockTB.setUserid(stock.getUserid());
				stockTB.setUsername(stock.getUsername());
				stockTB.setUptime(stock.getUptime());
				stock = stockTBDAO.save(stockTB);
			}
		} else if (DefineUtils.STOCK_PRENUM_TZ.equals(type)){//调整
			
			List<Stock> stockList = stockTBDAO.findByCond(cond, 0, 0);
			Stock oldStock = stockList.get(0);
			if(oldStock.getStocknum() + stock.getPrenum() < 0){
				throw new BLException("", "");
			}
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			stockTB.setStocknum(oldStock.getStocknum() + stock.getPrenum());
			stockTB.setUptime(CSEHelper.getCurrentTime());
			stockTB.setUsername(stock.getUsername());
			stock = stockTBDAO.save(stockTB);
		} else if (DefineUtils.STOCK_PRENUM_SH.equals(type)){//损耗
			List<Stock> stockList = stockTBDAO.findByCond(cond, 0, 0);
			Stock oldStock = stockList.get(0);
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			Integer pernum = oldStock.getPrenum();
//			if(pernum == null){
//				pernum = 0;
//			}
			stockTB.setPrenum(pernum + stock.getPrenum());
			stockTB.setUptime(CSEHelper.getCurrentTime());
			stockTB.setUsername(stock.getUsername());
			stock = stockTBDAO.save(stockTB);
		} else if (DefineUtils.STOCK_PRENUM_XH.equals(type)){//销毁
			List<Stock> stockList = stockTBDAO.findByCond(cond, 0, 0);
			Stock oldStock = stockList.get(0);
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			Integer pernum = oldStock.getPrenum();
			stockTB.setPrenum(pernum + stock.getPrenum());
			stockTB.setUptime(CSEHelper.getCurrentTime());
			stockTB.setUsername(stock.getUsername());
			stock = stockTBDAO.save(stockTB);
		} else if (DefineUtils.STOCK_PRENUM_SL.equals(type)){//申领
			//List<Stock> stockList = stockTBDAO.findByCond(cond, 0, 0);

			Stock oldStock = stockTBDAO.findByPK(stock.getStockid());
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			//stockTB.setPrenum(oldStock.getPrenum()+stock.getPrenum());
			stockTB.setUptime(CSEHelper.getCurrentTime());
			stockTB.setUserid(stock.getUserid());
			stockTB.setUsername(stock.getUsername());
			stock = stockTBDAO.save(stockTB);
			
		} else if (DefineUtils.STOCK_PRENUM_SP.equals(type)){//审批
			stock = stockTBDAO.save(stock);
			
		}else if (DefineUtils.STOCK_PRENUM_SLXG.equals(type)){//审领修改
			stock = stockTBDAO.save(stock);
			
		} else if (DefineUtils.STOCK_PRENUM_SLSC.equals(type)){//审领删除
			stock = stockTBDAO.save(stock);
			
		}else if (DefineUtils.STOCK_PRENUM_CK.equals(type)){//出库
			stock = stockTBDAO.save(stock);
			
		} else if (DefineUtils.STOCK_PRENUM_XB.equals(type)){//下拨
			Stock oldStock = stockTBDAO.findByPK(stock.getStockid());

			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			stockTB.setPrenum(oldStock.getPrenum()+stock.getPrenum());
			stockTB.setUptime(CSEHelper.getCurrentTime());
			stockTB.setUserid(stock.getUserid());
			stockTB.setUsername(stock.getUsername());
			stock = stockTBDAO.save(stockTB);
			
		} else if(DefineUtils.STOCK_PRENUM_JS.equals(type)){//接收
			cond.setStockorg(stock.getStockorg());//当前用户机构
			List<Stock> stockList = stockTBDAO.findByCond(cond, 0, 0);
			if(stockList == null || stockList.size() == 0){
				stock = stockTBDAO.save(stock);
			} else {
				Stock oldStock = stockList.get(0);
				StockTB stockTB = new StockTB();
				stockTB.clone(oldStock);
				stockTB.setStockid(oldStock.getStockid());
				stockTB.setInamount(stock.getInamount() + oldStock.getInamount());
				stockTB.setOutamount(stock.getOutamount() + oldStock.getOutamount());
				stockTB.setStocknum(stock.getStocknum() + oldStock.getStocknum());
				stockTB.setUserid(stock.getUserid());
				stockTB.setUsername(stock.getUsername());
				stockTB.setUptime(stock.getUptime());
				stock = stockTBDAO.save(stockTB);
			}
		} else if (DefineUtils.STOCK_PRENUM_SY.equals(type)){//使用
			List<Stock> stockList = stockTBDAO.findByCond(cond, 0, 0);
			Stock oldStock = stockList.get(0);
			StockTB stockTB = new StockTB();
			stockTB.clone(oldStock);
			stockTB.setStockid(oldStock.getStockid());
			stockTB.setStocknum(oldStock.getStocknum() - stock.getPrenum());
			stockTB.setUptime(CSEHelper.getCurrentTime());
			stockTB.setUsername(stock.getUsername());
			stock = stockTBDAO.save(stockTB);
		}
		return stock;
	}

	public List<Stock> searchStock(StockSearchCond cond, int start, int count) {
		List<Stock> stockList = stockTBDAO.findByCond(cond, start, count);
		return stockList;
	}

	public Stock findStockByPk(Serializable stockid) {
		Stock stock = stockTBDAO.findByPK(stockid);
		return stock;
	}

	public Stock saveOrUpdateStock(Stock stock) {
		stock = stockTBDAO.save(stock);
		return stock;
	}


}
