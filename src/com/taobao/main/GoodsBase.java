package com.taobao.main;

/**
 * 商品基础数据表
 * @author chenxuexing
 *
 */
public class GoodsBase {
	
	/**
	 * url中的id
	 */
	private String id;
	
	/**
	 * 商品URL
	 */
	private String url;
	
	/**
	 * 店铺名称
	 */
	private String shopName;
	
	/**
	 * 商品标题
	 */
	private String title;
	
	/**
	 * 淘宝价格
	 */
	private String price;

	/**
	 * 商品库存量
	 */
	private String stock;
	
	/**
	 * 图片地址1
	 */
	private String pictureUrl1;
	
	/**
	 * 图片地址2
	 */
	private String pictureUrl2;
	
	/**
	 * 图片地址3
	 */
	private String pictureUrl3;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getPictureUrl1() {
		return pictureUrl1;
	}

	public void setPictureUrl1(String pictureUrl1) {
		this.pictureUrl1 = pictureUrl1;
	}

	public String getPictureUrl2() {
		return pictureUrl2;
	}

	public void setPictureUrl2(String pictureUrl2) {
		this.pictureUrl2 = pictureUrl2;
	}

	public String getPictureUrl3() {
		return pictureUrl3;
	}

	public void setPictureUrl3(String pictureUrl3) {
		this.pictureUrl3 = pictureUrl3;
	}
	
	
	
}
