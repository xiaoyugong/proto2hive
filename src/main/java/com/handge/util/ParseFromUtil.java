package com.handge.util;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import com.handge.proto.MessageOuterClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * Created by gxy on 18-8-1.
 */
public abstract class ParseFromUtil {

    private final static ConcurrentMap<String, Method> methodCache = new ConcurrentHashMap<>();

    static {
        //找到指定包下所有protobuf实体类
        List<Class> classes = ClassUtil.getAllClassBySubClass(MessageLite.class, true, "com.handge.proto");
        classes.stream()
                .filter(protoClass -> !Objects.equals(protoClass, MessageOuterClass.Message.class))
                .forEach(protoClass -> {
                    try {
                        //反射获取parseFrom方法并缓存到map
                        methodCache.put(protoClass.getSimpleName(), protoClass.getMethod("parseFrom", ByteString.class));

                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                });

        System.out.println("method init success method Map: " +  methodCache);
    }

    /**
     * 根据Frame类解析出其中的body
     *
     * @param msg
     * @return
     */
    public static ArrayList parse(MessageOuterClass.Message msg) throws InvocationTargetException, IllegalAccessException {
        String messageName = msg.getMessageName();
        ByteString body = msg.getPayload();

        ArrayList list = new ArrayList();
        Method method = methodCache.get(messageName);
        if (method == null) {
            throw new RuntimeException("unknown Message type :" + messageName);
        }
        list.add(messageName);
        list.add(method.invoke(null, body));
        return list;
    }
}
