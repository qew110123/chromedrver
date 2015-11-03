package com.scz.dom;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.soap.Detail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Landchina {

	private WebDriver webDriver;

	/**
	 * 0,火狐；1，
	 * 
	 * @param i
	 */
	public Landchina(int i) {
		if (i == 0) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\javac_eclipse\\TaoBaoDates\\chromedriver.exe");

			webDriver = new ChromeDriver();
			webDriver
					.get("http://www.landchina.com/default.aspx?tabid=261&wmguid=20aae8dc-4a0c-4af5-aedf-cc153eb6efdf&p=");
			// 获取标题元素值
			webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String title = webDriver.getTitle();
			System.out.println("商品标题: " + title);
			// 获取淘宝价格
			WebElement detail = webDriver.findElement(By
					.xpath("//*[@id=\"TAB_contentTable\"]"));
			WebElement atr = detail.findElement(By.xpath("tbody"));
			List<WebElement> liList = atr.findElements(By.xpath("tr"));
			System.out.println(liList.size());
			int i1 = 0;
			for (WebElement web : liList) {
				if (0 != i1) {
					List<WebElement> tb_pic_tb_s50 = web.findElements(By
							.xpath("td[@class='queryCellBordy']"));
					int i11 = 0;
					for (WebElement webElement : tb_pic_tb_s50) {
						if (i11 % 4 == 1) {
							WebElement a = webElement
									.findElement(By.xpath("a"));
							System.out.println("链接为：" + a.getAttribute("href"));
							System.out.println("标题为：" + a.getText());
						}
						i11 += 1;
					}
				}
				i1 += 1;
			}
			// 退出
			webDriver.quit();

		}
	}
	public static void page (){
		System.setProperty("webdriver.chrome.driver",
				"D:\\javac_eclipse\\TaoBaoDates\\chromedriver.exe");

		 ChromeDriver webDriver1 = new ChromeDriver();
		webDriver1
				.get("http://www.landchina.com/default.aspx?tabid=261&wmguid=20aae8dc-4a0c-4af5-aedf-cc153eb6efdf&p=");
		// 获取标题元素值
		webDriver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = webDriver1.getTitle();
		System.out.println("商品标题: " + title);
		
//		WebElement detail = webDriver1.findElement(By
//				.xpath("td[@class='pager']"));
		
//		List<WebElement> tb_pic_tb_s50 = webDriver1.findElements(By
//				.xpath("td[@class=\"pager\"]"));
		WebElement detail = webDriver1.findElement(By
				.xpath("//*[@id=\"mainModuleContainer_471_1111_1111\"]")).findElement(By.xpath("tbody")).findElement(By.xpath("tr")).findElement(By.xpath("tr"));
		System.out.println(detail);
		List<WebElement> tb_pic_tb_s50 = detail.findElements(By
				.xpath("a"));
		System.out.println("13");
		System.out.println(tb_pic_tb_s50);
//		List<WebElement> liList = tb_pic_tb_s50.findElements(By.xpath("a"));
//		System.out.println(liList);
		for (WebElement webElement : tb_pic_tb_s50) {
			System.out.println("23323232");
			System.out.println(webElement.getText());
			if ("2".equals(webElement.getText())) {
				System.out.println("323233");
				System.out.println(webElement);
				webElement.click();
			}
		}
//		WebElement atr = detail.findElement(By.xpath("tbody"));
//		List<WebElement> liList = atr.findElements(By.xpath("tr"));
//		System.out.println(liList.size());
//		int i1 = 0;
//		for (WebElement web : liList) {
//			if (0 != i1) {
//				List<WebElement> tb_pic_tb_s50 = web.findElements(By
//						.xpath("td[@class='queryCellBordy']"));
//				int i11 = 0;
//				for (WebElement webElement : tb_pic_tb_s50) {
//					if (i11 % 4 == 1) {
//						WebElement a = webElement
//								.findElement(By.xpath("a"));
//						System.out.println("链接为：" + a.getAttribute("href"));
//						System.out.println("标题为：" + a.getText());
//					}
//					i11 += 1;
//				}
//			}
//			i1 += 1;
//		}
		// 退出
		webDriver1.quit();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Landchina(0);
//		Landchina.page();
	}

}
