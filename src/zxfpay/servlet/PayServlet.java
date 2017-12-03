package zxfpay.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zxfpay.utils.PaymentUtil;

//该Servlet处理支付请求并进行重定向

public class PayServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String p0_Cmd = "Buy", p1_MerId = "10001126856", p2_Order = request
				.getParameter("p2_Order"), p3_Amt = request
				.getParameter("p3_Amt"), p4_Cur = "CNY", p5_Pid = "", p6_Pcat = "", p7_Pdesc = "", p8_Url = "http://localhost:8080/shoppingPro/backServlet", p9_SAF = "", pa_MP = "", pd_FrpId = request
				.getParameter("pd_FrpId"), pr_NeedResponse = "1";
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue);
		String url = "https://www.yeepay.com/app-merchant-proxy/node?"
				+ "&p0_Cmd="
				+ p0_Cmd
				+ "&p1_MerId="
				+ p1_MerId
				+ "&p2_Order="
				+ p2_Order
				+ "&p3_Amt="
				+ p3_Amt
				+ "&p4_Cur="
				+ p4_Cur
				+ "&p5_Pid="
				+ p5_Pid
				+ "&p6_Pcat="
				+ p6_Pcat
				+ "&p7_Pdesc="
				+ p7_Pdesc
				+ "&p8_Url="
				+ p8_Url
				+ "&p9_SAF="
				+ p9_SAF
				+ "&pa_MP="
				+ pa_MP
				+ "&pd_FrpId="
				+ pd_FrpId
				+ "&pr_NeedResponse="
				+ pr_NeedResponse + "&hmac=" + hmac;
		response.sendRedirect(url);
	}
}
