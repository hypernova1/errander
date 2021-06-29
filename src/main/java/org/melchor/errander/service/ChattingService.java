package org.melchor.errander.service;

import lombok.RequiredArgsConstructor;
import org.melchor.errander.domain.Chatting;
import org.melchor.errander.exception.AppException;
import org.melchor.errander.repository.ChattingRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChattingService {

    private final ChattingRepository chattingRepository;

    public Chatting getByErrandId(Long errandId) {
        Chatting chatting = chattingRepository.findByErrandId(errandId)
                .orElseThrow(() -> new AppException("채팅방을 찾을 수 없습니다."));

        return chatting;
    }
}
