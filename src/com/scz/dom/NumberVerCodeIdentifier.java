package com.scz.dom;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.media.jai.JAI;
import javax.media.jai.RenderedOp;

public class NumberVerCodeIdentifier {
	static {
		System.setProperty("com.sun.media.jai.disableMediaLib", "true");
	}

	// 字典
	private static String a0 = "000111100";
	private static String a1 = "001111110";

	private static String a2 = "011111110";
	private static String a22 = "011011000";

	private static String a3 = "001111100";
	private static String a4 = "000000110";

	private static String a5 = "111111111";// 前
	private static String a52 = "011111111";// 前
	private static String a53 = "001011000";// 后

	private static String a6 = "000111100000111100";
	private static String a7 = "001100000";
	private static String a8 = "001111100000111100";
	private static String a9 = "001111000";

	public String recognize(BufferedImage image) {

		String result = "";

		BufferedImage newim[] = new BufferedImage[4];
		if (null == image) {
			throw new RuntimeException("iamage为null");
		}
		// 将图像分成四块，因为要处理的文件有四个数字。
		newim[0] = generateSingleColorBitMap(image.getSubimage(7, 5, 8, 11));
		newim[1] = generateSingleColorBitMap(image.getSubimage(20, 5, 8, 11));
		newim[2] = generateSingleColorBitMap(image.getSubimage(33, 5, 8, 11));
		newim[3] = generateSingleColorBitMap(image.getSubimage(46, 5, 8, 11));

		for (int k = 0; k < 4; k++) {
			int iw = newim[k].getWidth(null);
			int ih = newim[k].getHeight(null);

			StringBuffer numstr = new StringBuffer();
			// 因为是二值图像，这里的方法将像素读取出来的同时，转换为0，1的图像数组。
			for (int i = 0; i < ih; i++) {
				for (int j = 0; j < iw; j++) {

					int t = newim[k].getRGB(j, i);
					if (t == -1)
						numstr.append("0");
					else
						numstr.append("1");
					;

				}
			}
			// 得到像匹配的数字串。

			String straaa = numstr.toString().substring(0, 9)
					+ numstr.toString().substring(79);
			// System.out.println(numstr.toString());

			boolean bye = true;
			if (straaa.equals(a6)) {
				result = result + 6;
				// System.out.println(6);
				bye = false;
			}
			if (straaa.equals(a8)) {
				result = result + 8;
				// System.out.println(8);
				bye = false;
			}

			if (numstr.toString().substring(0, 9).equals(a5)
					|| numstr.toString().substring(0, 9).equals(a52)
					|| numstr.toString().substring(79).equals(a53)) {
				result = result + 5;
				// System.out.println(5);
				bye = false;
			}

			String aaaaa = numstr.toString().substring(79);

			if (bye) {
				if (aaaaa.equals(a0)) {
					result = result + 0;
					// System.out.println(0);
				}

				if (aaaaa.equals(a1)) {
					result = result + 1;// System.out.println(1);
				}
				if (aaaaa.equals(a2) || aaaaa.equals(a22)) {
					result = result + 2;// System.out.println(2);
				}
				if (aaaaa.equals(a3)) {
					result = result + 3;// System.out.println(3);
				}

				if (aaaaa.equals(a4)) {
					result = result + 4;// System.out.println(4);
				}

				if (aaaaa.equals(a7)) {
					result = result + 7;// System.out.println(7);
				}

				if (aaaaa.equals(a9)) {
					result = result + 9;// System.out.println(9);
				}
			}

		}
		// System.out.println(result);
		return result;

	}

	/**
	 * 单色位图转换
	 * 
	 * @return
	 */
	private static BufferedImage generateSingleColorBitMap(Image colorImage) {
		BufferedImage image = new BufferedImage(8, 11,
				BufferedImage.TYPE_BYTE_GRAY);
		Graphics g = image.getGraphics();
		g.drawImage(colorImage, 0, 0, null);
		g.dispose();
		RenderedOp ro = JAI.create("binarize", image, new Double(100));
		BufferedImage bi = ro.getAsBufferedImage();
		return bi;
	}

	/**
	 * 测试
	 * 
	 * @author sunyang
	 */
	public static void main(String args[]) {

		NumberVerCodeIdentifier nvi = new NumberVerCodeIdentifier();

		String res = "";
		try {
			res = nvi.recognize(ImageIO.read(new File("d:\\111.bmp")));
			System.out.println(res + "11");

			// res = nvi.recognize(ImageIO.read(new
			// URL("http://******.com/validationCode.jsp")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(res);
	}

}
