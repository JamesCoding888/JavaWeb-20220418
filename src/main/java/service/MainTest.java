package service;
public class MainTest {
	public static void main(String[] args) {
		String webImageUrl = "http://";
		System.out.println(webImageUrl.indexOf('/'));
		System.out.println(webImageUrl.indexOf("d"));
		System.out.println(webImageUrl.indexOf(":",3));
		System.out.println(webImageUrl.indexOf("/",6));
		System.out.println(webImageUrl.indexOf("http://"));
		System.out.println(webImageUrl.indexOf("http://") >= 0);
	}
}
