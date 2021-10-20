package io.github.yellldo.starter.genid.service;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName : Id<br>
 * Description : 反解ID对象<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/15
 */
@Data
@NoArgsConstructor
public class Id implements Serializable {


    /**
     * 主机节点
     */
    private long machine;
    /**
     * 序列
     */
    private long seq;
    /**
     * 时间
     */
    private long time;
    /**
     * 生成方法
     */
    private long genMethod;
    /**
     * 生成类型
     */
    private long type;
    /**
     * 版本
     */
    private long version;

    public Id(long machine, long seq, long time, long genMethod, long type,
              long version) {
        super();
        this.machine = machine;
        this.seq = seq;
        this.time = time;
        this.genMethod = genMethod;
        this.type = type;
        this.version = version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append("machine=").append(machine).append(",");
        sb.append("seq=").append(seq).append(",");
        sb.append("time=").append(time).append(",");
        sb.append("genMethod=").append(genMethod).append(",");
        sb.append("type=").append(type).append(",");
        sb.append("version=").append(version).append("]");

        return sb.toString();
    }

}
