package cn.lxcourse.jsoup.util;

import cn.lxcourse.jsoup.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 爬虫工具
 */
public class JsoupUtils {

    /**
     * 爬取京东商品列表
     * @param keywords
     * @return
     * @throws Exception
     */
    public static List<Content> getJDGoods(String keywords) throws Exception {
        String url = "https://search.jd.com/Search?keyword=Java" + keywords;
        Document document = Jsoup.parse(new URL(url), 300000);
        //商品列表
        Element j_goodsList = document.getElementById("J_goodsList");
        Elements glEtemElements = j_goodsList.getElementsByClass("gl-item");

        List<Content> list = new ArrayList<>();
        for (Element element : glEtemElements) {

            String imgSrc = element.getElementsByTag("img").eq(0).attr("source-data-lazy-img");
            String price = element.getElementsByClass("p-price").eq(0).text();
            String title = element.getElementsByClass("p-name").eq(0).text();

            Content content = new Content();
            content.setImgSrc(imgSrc);
            content.setPrice(price);
            content.setTitle(title);

            list.add(content);
        }

        return list;
    }

    /**
     * 爬取工行融e购商品列表
     * @param keywords
     * @return
     * @throws Exception
     */
    public static List<Content> getRongYiGouGoods(String keywords) throws Exception {
        //https://mall.icbc.com.cn/searchproducts/pv.jhtml?query=java
        String url = "https://mall.icbc.com.cn/searchproducts/pv.jhtml?query=" + keywords;

        Document document = Jsoup.parse(new URL(url), 30000);
        Element ajaxQueryContent = document.getElementById("ajaxQueryContent");

        Elements liElements = ajaxQueryContent.getElementsByTag("li");

        List<Content> list = new ArrayList<>();

        for (Element el : liElements) {
            String src = el.getElementsByTag("img").eq(0).attr("src");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).select("a").eq(0).attr("title");
            Content content = new Content();
            content.setTitle(title);
            content.setPrice(price);
            content.setImgSrc(src);
            list.add(content);
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        //getJDGoods("Java").forEach(System.out::println);
        getRongYiGouGoods("java").forEach(System.out::println);
    }
}
