package com.chain.blog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

/**
 * @author: chain
 * @create: 2020/01/31
 **/
public class MarkdownUtil {
    /**
     * markDOWN转成html格式
     */
    public static String markdownToHtml(String markdown){
        Parser parser=Parser.builder().build();
        Node node=parser.parse(markdown);
        HtmlRenderer renderer=HtmlRenderer.builder().build();
        return  renderer.render(node);
    }

    /**
     * 增加扩展  标题 表格生成
     */
    public static  String markdownToHtmlExtensions(String markdown){
        //<h>生成id
        Set<Extension> headExtensions= Collections.singleton(HeadingAnchorExtension.create());
        List<Extension> table_extensions = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(table_extensions)
                .build();
        Node node=parser.parse(markdown);

        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(headExtensions)
                .extensions(table_extensions)
                .attributeProviderFactory(new AttributeProviderFactory() {
                    @Override
                    public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                        return new AttributeProvider() {
                            //处理标签属性
                            @Override
                            public void setAttributes(Node node, String s, Map<String, String> map) {
                                if (node instanceof  Link){
                                    map.put("target","_blank");
                                }
                                if (node instanceof TableBlock){
                                    map.put("class","ui celled table");
                                }
                            }
                        };
                    }
                })
                .build();

        return renderer.render(node);

    }

}
