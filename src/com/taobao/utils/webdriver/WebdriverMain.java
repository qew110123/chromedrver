package com.taobao.utils.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMain {

	private WebDriver webDriver;

	/**
	 * 0,火狐；1，
	 * 
	 * @param i
	 */
	public WebdriverMain(int i) {
		if (i == 0) {
//			System.setProperty("webdriver.chrome.driver",
//					"D:\\work\\TaoBaoDates\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					"D:\\javac_eclipse\\TaoBaoDates\\chromedriver.exe");
			
			webDriver = new ChromeDriver();
			webDriver
					.get("https://item.taobao.com//item.htm?spm=a217s.1199822.1998507273.3.9UbFUz&id=41057112476");
			// 获取标题元素值
			webDriver.manage().timeouts()
			.implicitlyWait(10,
					TimeUnit.SECONDS);
			String title = webDriver.getTitle();
			System.out.println("商品标题: " + title);
			// 获取淘宝价格
			WebElement detail = webDriver.findElement(By
					.xpath("//*[@id=\"J_PromoPriceNum\"]"));
			String test = detail.getText();
			System.out.println("商品淘宝价格：" + test);
			//库存量
			WebElement J_isku=webDriver.findElement(By.xpath("//*[@id=\"J_isku\"]"));
			WebElement tb_skin=J_isku.findElement(By.xpath("div[@class='tb-skin']"));
			WebElement tb_amount_tb_clearfix=tb_skin.findElement(By.xpath("dl[@class='tb-amount tb-clearfix']"));
			WebElement dd=tb_amount_tb_clearfix.findElement(By.xpath("dd"));
			WebElement em=dd.findElement(By.xpath("em"));
			WebElement j_SpanStock=em.findElement(By.id("J_SpanStock"));
			System.out.println("库存量=="+j_SpanStock.getText());
			//图片地址
			WebElement J_UlThumb=webDriver.findElement(By.id("J_UlThumb"));
			List<WebElement> liList=J_UlThumb.findElements(By.xpath("li"));
			System.out.println("商品图片数目==="+liList.size());
			for(WebElement web:liList){
				if(!"0".equals(web.getAttribute("data-index"))){
					WebElement tb_pic_tb_s50=web.findElement(By.xpath("div[@class='tb-pic tb-s50']"));
					WebElement a=tb_pic_tb_s50.findElement(By.xpath("a"));
					WebElement img=a.findElement(By.xpath("img"));
					System.out.println("图片地址=="+img.getAttribute("data-src"));
				}
			}
			//店铺名称
//			WebElement details=webDriver.findElement(By.id("detail"));
//			WebElement tb_clear=details.findElement(By.xpath("div[@class='tb-detail-bd tb-clear']"));
//			WebElement tb_sidebar=tb_clear.findElement(By.xpath("div[@class='tb-sidebar tb-clear']"));
			WebElement details=webDriver.findElement(By.id("J_ShopInfo"));
			WebElement tb_shop_info_wrap=details.findElement(By.xpath("div[@class='tb-shop-info-wrap']"));
			WebElement tb_shop_info_hd=tb_shop_info_wrap.findElement(By.xpath("div[@class='tb-shop-info-hd']"));
			WebElement tb_shop_name=tb_shop_info_hd.findElement(By.xpath("div[@class='tb-shop-name']"));
			WebElement shopDl=tb_shop_name.findElement(By.xpath("dl"));
			WebElement shopDd=shopDl.findElement(By.xpath("dd"));
			WebElement strong=shopDd.findElement(By.xpath("strong"));
			WebElement shopA=strong.findElement(By.xpath("a"));
			System.out.println("店铺名称=="+shopA.getText());
			// 商品详情 ul class='attributes-list' id=''
			WebElement xianqing_root = webDriver.findElement(By
					.xpath("//*[@id=\"attributes\"]"));
			WebElement attributes_list = xianqing_root.findElement(By
					.className("attributes-list"));
			List<WebElement> li_list = attributes_list.findElements(By
					.xpath("li[@title]"));
			System.out.println("====商品详情=================");
			for (WebElement list : li_list) {
				System.out.println(list.getText());
			}
			System.out.println("====商品详情=================");
			// 商品评价class==tb-tab-anchor
			WebElement pjia = webDriver.findElement(By.id("J_TabBarWrap"));
			List<WebElement> t = pjia.findElements(By.xpath("div"));
			for(WebElement web : t) {
				if ("tb-tabbar-mid-wrap tb-clearfix".equals(web
						.getAttribute("class"))) {
					List<WebElement> webs = web.findElements(By.xpath("div"));
					for (WebElement ws : webs) {
						if ("tb-tabbar-inner-wrap".equals(ws
								.getAttribute("class"))) {
							WebElement wul = ws.findElement(By.id("J_TabBar"));
							List<WebElement> wli = wul.findElements(By
									.xpath("li"));
							for (WebElement li : wli) {
								if ("selected".equals(li.getAttribute("class"))
										|| li.getText().startsWith("累计评论")) {
									System.out.println("=====【累计评论】=======");
									li.click();
									// 等待10秒，页面元素加载完成
									webDriver.manage().timeouts()
											.implicitlyWait(10,
													TimeUnit.SECONDS);
									WebElement reviews = webDriver
											.findElement(By.id("J_MainWrap"));
									List<WebElement> div_list = reviews
											.findElements(By.xpath("div"));
									for (WebElement div : div_list) {
										if ("sub-wrap".equals(div
												.getAttribute("class"))) {
											// List<WebElement>
											// subList=div.findElements(By.xpath("div"));
											WebElement subList = div
													.findElement(By
															.id("reviews"));
											WebElement revList = subList
													.findElement(By
															.xpath("div[@class='tb-reviewsbd']"));
											WebElement revsList = revList
													.findElement(
															By.xpath("div[@class='tb-r-goods']"));
											WebElement revs=revsList.findElement(By.xpath("div[@class='tb-revbd']"));
											WebElement revss=revs.findElement(By.xpath("ul[@class='tb-r-comments']"));
											List<WebElement> revssList=revss.findElements(By.xpath("li"));
											System.out.println("本页评论总数==="+revssList.size());
											for (WebElement rev : revssList) {
												System.out
														.println("=================================================");
												try{
												WebElement tb_r_bd=rev.findElement(By.xpath("div[@class='tb-r-bd']"));
												//标记
												WebElement tb_r_spu_ratting=tb_r_bd.findElement(By.xpath("ul[@class='tb-r-spu-ratting']"));
												System.out
														.println("标记： "+tb_r_spu_ratting.getText());
												//评论内容
												WebElement tb_rev_item =tb_r_bd.findElement(By.xpath("div[@class='tb-rev-item ']"));
												WebElement tb_r_cnt =tb_rev_item.findElement(By.xpath("div[@class='tb-r-cnt ']"));
												System.out
														.println("评论内容=="+tb_r_cnt.getText());
												//评论时间
												WebElement tb_r_act_bar=tb_rev_item.findElement(By.xpath("div[@class='tb-r-act-bar']"));
												WebElement tb_r_info=tb_r_act_bar.findElement(By.xpath("div[@class='tb-r-info']"));
												WebElement tb_r_date=tb_r_info.findElement(By.xpath("span[@class='tb-r-date']"));
												System.out
														.println("评论时间=="+tb_r_date.getText());
												//商品分类
												WebElement tb_r_sku=tb_r_info.findElement(By.xpath("span[@class='tb-r-sku']"));
												System.out
														.println("商品分类=="+tb_r_sku.getText());
												}catch (Exception e) {
												}
												System.out
												.println("=================================================");
											}
										}
									}
									System.out.println("=====【累计评论】=======");
								}
							}
						}
					}
				}
			}
			// pjia.click();
			// reviews

			//退出
			 webDriver.quit();

		}
	}

	public static void main(String[] args) {
		new WebdriverMain(0);
	}

}
