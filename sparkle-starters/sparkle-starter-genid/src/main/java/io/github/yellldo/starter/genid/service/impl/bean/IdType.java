package io.github.yellldo.starter.genid.service.impl.bean;

/**
 * ClassName : IdType<br>
 * Description : IdType<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
public enum IdType {

    /**
     * 秒
     */
    SECONDS("seconds"),

    /**
     * 毫秒
     */
    MILLISECONDS("milliseconds"),

    /**
     * SHORTID
     */
    SHORTID("short_id");

    private String name;

    IdType(String name) {
        this.name = name;
    }

    public static IdType parse(String name) {
        if ("seconds".equals(name)) {
            return SECONDS;
        } else if ("milliseconds".equals(name)) {
            return MILLISECONDS;
        } else if ("short_id".equals(name)) {
            return SHORTID;
        }
        throw new IllegalArgumentException("Illegal IdType name <[" + name
                + "]>, available names are seconds and milliseconds");
    }

    public static IdType parse(long type) {
        if (type == 1) {
            return MILLISECONDS;
        } else if (type == 0) {
            return SECONDS;
        } else if (type == 2) {
            return SHORTID;
        }

        throw new IllegalArgumentException("Illegal IdType value <[" + type
                + "]>, available values are 0 (for seconds) and 1 (for milliseconds)");
    }

    public long value() {
        switch (this) {
            case SECONDS:
                return 0;
            case MILLISECONDS:
                return 1;
            case SHORTID:
                return 2;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

}
