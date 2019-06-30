package com.hyhcoder.quickframe;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hyhcoder
 * 通用表基本结构生成
 */
public class CommonGenerator {
	
	/**
	 * 读取控制台内容
	 */
	private static String scanner(String tip) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder help = new StringBuilder();
		help.append("请输入" + tip + "：");
		System.out.println(help.toString());
		if (scanner.hasNext()) {
			String ipt = scanner.next();
			if (StringUtils.isNotEmpty(ipt)) {
				return ipt;
			}
		}
		throw new MybatisPlusException("请输入正确的" + tip + "！");
	}
	
	public static void main(String[] args) {
		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();
		
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		// 项目路径
		String projectPath = System.getProperty("user.dir") + "/quickframe-mbg";
		// 生成文件的输出目录
		gc.setOutputDir(projectPath + "/src/main/java");
		// 是否覆盖已有文件
		gc.setFileOverride(false);
		gc.setAuthor("hyhcoder");
		// 是否打开输出目录
		gc.setOpen(false);
		// 指定生成的主键的ID类, 默认为null
		gc.setIdType(null);
		// 是否填充xml的baseResultMap
		gc.setBaseResultMap(true);
		gc.setBaseColumnList(true);
		// 指定Mapper名称
		gc.setMapperName("%sMapper");
		// 指定xml的名称
		gc.setXmlName("%sMapper");
		// 设置指定model名
		gc.setEntityName("%sDo");
		mpg.setGlobalConfig(gc);
		
		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl("jdbc:mysql://192.168.40.130:3306/mall?useUnicode=true&useSSL=false&characterEncoding=utf8");
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("123456");
		mpg.setDataSource(dsc);
		
		// 包配置
		PackageConfig pc = new PackageConfig();
		// 父包模块名
		pc.setModuleName("");
		pc.setParent("com.hyhcoder.quickframe");
		// Entity包名
		pc.setEntity("model");
		
		// Service包名
		// pc.setService("service");
		// Service Impl包名
		// pc.setServiceImpl("serviceImpl");
		// Controller包名
		// pc.setController("controller");
		
		// Mapper包名
		pc.setMapper("mapper");
		// Mapper XML包名
		pc.setXml("xml");
		mpg.setPackageInfo(pc);
		
		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		
		// 如果模板引擎是 freemarker
		String templatePath = "/templates/mapper.xml.ftl";
		
		// 自定义输出配置
		List<FileOutConfig> focList = new ArrayList<>();
		// 自定义配置会被优先输出
		focList.add(new FileOutConfig(templatePath) {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
				return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo
						.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		
		// 加载配置
		cfg.setFileOutConfigList(focList);
		mpg.setCfg(cfg);
		
		// 配置模板
		TemplateConfig templateConfig = new TemplateConfig();
		// 这里下面如果配置为null,那么该模块就不自动生成
		templateConfig.setXml(null);
		templateConfig.setController(null);
		templateConfig.setService(null);
		templateConfig.setServiceImpl(null);
		mpg.setTemplate(templateConfig);
		
		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// 数据库表映射到实体的命名策略
		strategy.setNaming(NamingStrategy.underline_to_camel);
		// 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		// 启动lombok注解
		strategy.setEntityLombokModel(true);
		// 生成 @RestController 控制器
		// strategy.setRestControllerStyle(true);
		// 需要生成包括的表明
		strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
		// 驼峰转连字符
		strategy.setControllerMappingHyphenStyle(true);
		// 增加表前缀
		//strategy.setTablePrefix(pc.getModuleName() + "_");
		mpg.setStrategy(strategy);
		
		// 自定义继承的Entity类全称
		// strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
		// 自定义继承的Controller类全称
		// strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
		// 自定义基础的Entity类，公共字段
		// strategy.setSuperEntityColumns("id");
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
}
