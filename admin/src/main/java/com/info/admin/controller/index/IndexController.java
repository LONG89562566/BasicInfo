package com.info.admin.controller.index;

import com.info.admin.controller.base.BaseController;
import com.info.admin.result.JsonResult;
import com.info.admin.result.JsonResultCode;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);


	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(HttpServletRequest request, HttpServletResponse response, Model model, Long areaId) {

		logger.info("[IndexController][index] :查询订单统计数据");
		try {

		} catch (Exception ex) {
			logger.error("[IndexController][index] :exception", ex);
		}
		return "index";
	}

	@RequestMapping(value = "/home", method = { RequestMethod.GET, RequestMethod.POST })
	public String home(HttpServletRequest request, HttpServletResponse response, Model model, Long areaId) {

		logger.info("[IndexController][home] :跳转首页");
		try {

		} catch (Exception ex) {
			logger.error("[IndexController][index] :exception", ex);
		}
		return "home";
	}

	/**
	 * 根据时间统计一个周期内各个区域的订单数量
	 */
	@RequestMapping(value = "/index/getOrderNum", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getOrderNum(HttpServletRequest request, HttpServletResponse response, Integer timeType) {
		logger.info("[IndexController][getOrderNum] :根据时间类型统计各个区域的订单数量");
		// 根据时间类型统计各个区域的订单数量
		return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", null);
	}

	/**
	 * 根据时间统计一个周期内各个区域的订单金额
	 */
	@RequestMapping(value = "/index/getOrderAmount", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getOrderAmount(HttpServletRequest request, HttpServletResponse response, Model model,
			Integer timeType) {
		logger.info("[IndexController][getOrderAmount] :根据时间类型统计各个区域的订单总金额");
		// 根据时间类型统计各个区域的订单总金额
		return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", null);
	}

	/**
	 * 根据时间统计一个周期内各个区域的买家数量
	 */
	@RequestMapping(value = "/index/getBuyerCount", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getBuyerCount(HttpServletRequest request, HttpServletResponse response, Model model,
			Integer timeType) {
		logger.info("[IndexController][getBuyerCount] :根据时间类型统计各个区域的买家数量");
		// 根据时间类型统计各个区域的买家数量
		return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", null);
	}

	/**
	 * 查询当天订单详情 显示所有
	 */
	@RequestMapping(value = "/index/orderList", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrders(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getOrders] :查询今日订单详情");
		try {

		} catch (Exception ex) {
			logger.error("[IndexController][getOrders] :exception", ex);
		}
		return "stat/orderView";
	}

	/**
	 * 查询统计订单的详细信息每个买家只显示一个
	 */
	@RequestMapping(value = "/index/ordersBybuyer", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrdersByDay(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getOrdersByDay] :查询今日订单详情");
		try {


		} catch (Exception ex) {
			logger.error("[IndexController][getOrdersByDay] :exception", ex);
		}
		return "stat/orderBuyerView";
	}

	/**
	 * 当天订单总额
	 */
	@RequestMapping(value = "/index/todayOrders", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrdersByToday(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getOrdersBySellerByDay] :查询订单详情");
		try {

		} catch (Exception ex) {
			logger.error("[IndexController][getOrdersByToday] :exception", ex);
		}
		return "stat/orderSellerView";
	}

	/**
	 * 查询入驻买家详情
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index/buyers", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBuyers(HttpServletRequest request, HttpServletResponse response,Model model) {
		logger.info("[IndexController][getBuyers] :查询入驻买家详情");
		try {

		} catch (Exception ex) {
			logger.error("[IndexController][getBuyers]exception", ex);
		}
		return "stat/buyerView";
	}

	/**
	 * 查询入驻卖家详情
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index/sellers", method = { RequestMethod.GET, RequestMethod.POST })
	public String getSellers(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getSellers] :查询今日入驻卖家详情");
		try {

		} catch (Exception ex) {
			logger.error("[IndexController][getSellers]exception", ex);
		}
		return "stat/sellerView";
	}

	/**
	 * 查询消费前十的买家
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/getTopTenCost", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenCost(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenIncomes] :查询收入前十的卖家");
		try {
			// 消费前十的买家
			List<Map<String, Object>> topTenBuyers = null;
			if (CollectionUtils.isNotEmpty(topTenBuyers)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenBuyers);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenIncomes]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询收入前十的卖家
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenIncomes", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenIncomes(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenIncomes] :查询收入前十的卖家");
		try {
			// 收入前十的卖家
			List<Map<String, Object>> topTenIncomes = null;
			if (CollectionUtils.isNotEmpty(topTenIncomes)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenIncomes);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenIncomes]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询销售量前十的菜品
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenGoods", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenGoods(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenGoods] :查询销售量前十的菜品");
		try {
			// 销售量前十的菜品
			List<Map<String, Object>> topTenGoods = null;
			if (CollectionUtils.isNotEmpty(topTenGoods)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenGoods);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenGoods]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询业绩前十的销售
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenSales", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenSales(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenSales] :查询业绩前十的销售");
		try {
			// 业绩前十的销售
			List<Map<String, Object>> topTenSales = null;
			if (CollectionUtils.isNotEmpty(topTenSales)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenSales);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenSales]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询订单项前十的买家
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenWidelyBuyers", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenWidelyBuyers(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenWidelyBuyers] :查询订单项前十的买家");
		try {
			// 订单项前十的买家
			List<Map<String, Object>> topTenWidelyBuyers = null;
			if (CollectionUtils.isNotEmpty(topTenWidelyBuyers)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenWidelyBuyers);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenWidelyBuyers]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

}