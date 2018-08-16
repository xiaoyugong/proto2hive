package com.handge.util;

import com.handge.handler.customhandler.AbstractHandler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gxy on 18-8-1.
 */
public class HandlerUtil {

    private final static Map<String, AbstractHandler> instanceCache = new ConcurrentHashMap<>();
    // 初始化所有handler
    static {
        try {
            //扫描指定包下的所有DataHandler实现类
            List<Class> classes = ClassUtil.getAllClassBySubClass(AbstractHandler.class, true,"com.handge.handler.customhandler");
            for (Class claz : classes) {
                //以其Handler的SimpleName为key handler实例为value缓存到map中
                instanceCache.put(claz.getSimpleName(), (AbstractHandler) claz.newInstance());
            }
            System.out.println("handler init success handler Map: " +  instanceCache);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AbstractHandler getHandlerInstance(String name) {
        return instanceCache.get(name);
    }
}
