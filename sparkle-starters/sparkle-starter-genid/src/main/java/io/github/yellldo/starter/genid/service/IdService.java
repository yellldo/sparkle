package io.github.yellldo.starter.genid.service;

import java.util.Date;

/**
 * ClassName : IdService<br>
 * Description : ID生成接口<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
public interface IdService {

    /**
     * 根据系统时间产生一个全局唯一的ID并且在方法体内返回
     *
     * @return
     */
    long genId();

    /**
     * 反解ID,对产生的ID进行反解，在响应体内返回反解的JSON字符串
     *
     * @param id
     * @return
     */
    Id expId(long id);

    long makeId(long time, long seq);

    long makeId(long time, long seq, long machine);

    long makeId(long genMethod, long time, long seq, long machine);

    long makeId(long type, long genMethod, long time,
                long seq, long machine);

    long makeId(long version, long type, long genMethod,
                long time, long seq, long machine);

    Date transTime(long time);
}
