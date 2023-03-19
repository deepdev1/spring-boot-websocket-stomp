package com.basic.websocketstomp;

import com.basic.websocketstomp.model.ChatMessage;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WebSocketController {
    @GetMapping("/stomp-broadcast")
    public String getWebSocketBroadcast() {
        return "stomp-broadcast";
    }

    @MessageMapping("/broadcast")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage chatMessage) throws Exception {
        ChatMessage chatMessageNew = new ChatMessage(chatMessage.getFrom(), chatMessage.getText(), "ALL");
//        System.out.println(chatMessageNew);
        return chatMessageNew;
    }


}
