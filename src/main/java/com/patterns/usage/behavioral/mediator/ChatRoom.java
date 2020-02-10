package com.patterns.usage.behavioral.mediator;

import com.patterns.utils.PatternHelper;

import java.util.Calendar;

public class ChatRoom implements ChatRoomMediator {

    @Override
    public void showMessage(User user, String message) {
        Calendar calendar = Calendar.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.getTime().toString())
                .append("\n")
                .append(user.getName())
                .append(" : ")
                .append(message);
        PatternHelper.print(sb.toString());
    }
}
