package com.example.demo.util;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorUtils {

    //使用时 慎重参数！
    public static void main(String[] args) {
        //autoGenerator("sys_user");
    }

    public static void autoGenerator(String tableName) {
        //全局配置
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(true)
                .setAuthor("Lyz")   //生成用户
                .setOutputDir("D:\\seestech\\cloudE\\eureka_client\\src\\main\\java")  //输出路径
                .setFileOverride(true)  //是否覆盖
                .setIdType(IdType.ID_WORKER) //主键策略
                .setServiceName("%sService")    //service名称
                //.setDateType(DateType.TIME_PACK)
                .setBaseResultMap(true) //生成BaseMap
                .setBaseColumnList(true);   //生成基本的SQL片段
        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)    //数据库类型 Mysql
                .setDriverName("com.mysql.cj.jdbc.Driver") //数据源配置
                .setUrl("jdbc:mysql://116.62.112.164:3306/seestech")
                .setUsername("root")
                .setPassword("seestech2018");
        //数据库表配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true) //是否大小写命名
                .setEntityTableFieldAnnotationEnable(true)  //是否生成注解
                .setNaming(NamingStrategy.underline_to_camel)   //数据库表名与实体名映射策略
                .setInclude(tableName); //需要包含的表名 !需要修改地方!
        //包名策略
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.example.demo") //父类包
                .setMapper("dao")
                .setService("service")
                .setController("control")
                .setEntity("model")
                .setXml("dao.mapper");
        //整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();    //执行
    }
}
