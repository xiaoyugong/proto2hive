package com.handge.handler.customhandler;

import com.handge.proto.User;

public class UserHandler extends AbstractHandler<User> {
    @Override
    public void handle(User user) throws Exception {
        String objectStr = user.toString();
        String tableName = "t_user";
        execute(objectStr, tableName);
    }
}