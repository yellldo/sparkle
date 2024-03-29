package io.github.yellldo.generator.entity;

/**
 * ClassName : GeneratorConstant<br>
 * Description : 代码生成常量 <br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
public class GeneratorConstant {

    /**
     * 数据库类型
     */
    public static final String DATABASE_TYPE = "mysql";
    /**
     * 数据库名称
     */
    public static final String DATABASE_NAME = "nacos_devtest_prod";

    /**
     * 生成代码的临时目录
     */
    public static final String TEMP_PATH = "sparkle_gen_temp/";

    /**
     * java类型文件后缀
     */
    public static final String JAVA_FILE_SUFFIX = ".java";
    /**
     * mapper文件类型后缀
     */
    public static final String MAPPER_FILE_SUFFIX = "Mapper.java";
    /**
     * service文件类型后缀
     */
    public static final String SERVICE_FILE_SUFFIX = "Service.java";
    /**
     * service impl文件类型后缀
     */
    public static final String SERVICEIMPL_FILE_SUFFIX = "ServiceImpl.java";
    /**
     * controller文件类型后缀
     */
    public static final String CONTROLLER_FILE_SUFFIX = "Controller.java";
    /**
     * mapper xml文件类型后缀
     */
    public static final String MAPPERXML_FILE_SUFFIX = "Mapper.xml";
    /**
     * entity模板
     */
    public static final String ENTITY_TEMPLATE = "entity.ftl";
    /**
     * mapper模板
     */
    public static final String MAPPER_TEMPLATE = "mapper.ftl";
    /**
     * service接口模板
     */
    public static final String SERVICE_TEMPLATE = "service.ftl";
    /**
     * service impl接口模板
     */
    public static final String SERVICEIMPL_TEMPLATE = "serviceImpl.ftl";
    /**
     * controller接口模板
     */
    public static final String CONTROLLER_TEMPLATE = "controller.ftl";
    /**
     * mapper xml接口模板
     */
    public static final String MAPPERXML_TEMPLATE = "mapperXml.ftl";

}
