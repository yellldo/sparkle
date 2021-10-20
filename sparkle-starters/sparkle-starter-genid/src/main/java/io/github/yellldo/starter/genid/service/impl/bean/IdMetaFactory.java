package io.github.yellldo.starter.genid.service.impl.bean;

/**
 * ClassName : IdMetaFactory<br>
 * Description : IdMetaFactory<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
public class IdMetaFactory {

    private static IdMeta maxPeak = new IdMeta((byte) 10, (byte) 20, (byte) 30, (byte) 1, (byte) 1, (byte) 1);

    private static IdMeta minGranularity = new IdMeta((byte) 10, (byte) 10, (byte) 40, (byte) 1, (byte) 1, (byte) 1);

    private static IdMeta shortId = new IdMeta((byte) 10, (byte) 10, (byte) 30, (byte) 1, (byte) 1, (byte) 1);

    public static IdMeta getIdMeta(IdType type) {
        if (IdType.SECONDS.equals(type)) {
            return maxPeak;
        } else if (IdType.MILLISECONDS.equals(type)) {
            return minGranularity;
        } else if (IdType.SHORTID.equals(type)) {
            return shortId;
        }
        return null;
    }
}
