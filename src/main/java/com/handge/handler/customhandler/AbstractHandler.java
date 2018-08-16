package com.handge.handler.customhandler;

import com.google.protobuf.MessageLite;
import com.handge.proto2hive.HiveWriter;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by gxy on 18-7-30.
 */
public abstract class AbstractHandler<T extends MessageLite> {

    /**
     * 统一异常处理方法
     */
    public void handler(T t) {
        try {
            this.handle(t);
        } catch (Exception e) {
            exceptionCaught(e);
        }
    }


    /**
     * 暴露给子类的业务逻辑处理方法
     *
     * @param t 消息对象
     * @throws Exception
     */
    public abstract void handle(T t) throws Exception;


    /**
     * 此处因为最终处理逻辑相同，所以在父类中实现
     */
    public void execute(String objectStr, String tableName) {
        HashMap<String, String> map = new HashMap<>();
        Arrays.stream(objectStr.split("\n")).forEach(s -> {
            String[] kv = s.split(":");
            map.put(kv[0], kv[1]);
        });

        StringBuffer sql = new StringBuffer();
        sql.append("create table ");
        sql.append(tableName);
        sql.append("(");
        int keySize = map.keySet().size();
        final int[] index = {1};
        map.keySet().forEach(key -> {
            if (index[0] == keySize) sql.append(key + " string");
            else sql.append(key + " string, ");
            index[0]++;
        });
        sql.append(")");

        try {
            new HiveWriter().createTable(sql.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }

    /**
     * 异常处理
     *
     * @param cause
     */
    void exceptionCaught(Throwable cause) {

    }
}
