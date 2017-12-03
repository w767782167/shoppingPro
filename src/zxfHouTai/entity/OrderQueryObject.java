package zxfHouTai.entity;

import com.etcxm.entity.QueryObject;
import com.etcxm.utils.StringUtils;

public class OrderQueryObject extends QueryObject{
	private String orderNum;
	private String userName;
	
	public void customQuery(){
		if(StringUtils.hasLength(orderNum)){

			super.addQuery(" orderNum=? ", orderNum);
		}
		if(StringUtils.hasLength(userName)){
			
			super.addQuery(" userName= ?", userName);
		}
	
	}
	
	public OrderQueryObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderQueryObject(String orderNum, String userName) {
		super();
		this.orderNum = orderNum;
		this.userName = userName;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "OrderQueryObject [orderNum=" + orderNum + ", userName="
				+ userName + "]\n";
	}
	
}
