package edu.kh.project.chatting.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.kh.project.chatting.model.dao.ChattingMapper;
import edu.kh.project.chatting.model.dto.ChattingRoom;
import edu.kh.project.chatting.model.dto.Message;
import edu.kh.project.common.utility.Util;
import edu.kh.project.member.model.dto.Member;

@Service
public class ChattingServiceImpl implements ChattingService{

    @Autowired
    private ChattingMapper mapper;

    @Override
    public List<ChattingRoom> selectRoomList(int memberNo) {
        return mapper.selectRoomList(memberNo);
    }
    
    @Override
    public int checkChattingNo(Map<String, Integer> map) {
        return mapper.checkChattingNo(map);
    }

    @Override
    public int createChattingRoom(Map<String, Integer> map) {
        int result = mapper.createChattingRoom(map);
        
        if(result > 0) {
        	return (int)map.get("chattingNo");
        }
    	return 0;
    }


    @Override
    public int insertMessage(Message msg) {
        msg.setMessageContent(Util.XSSHandling(msg.getMessageContent()));
//        msg.setMessageContent(Util.newLineHandling(msg.getMessageContent()));
        return mapper.insertMessage(msg);
    }

    @Override
    public int updateReadFlag(Map<String, Object> paramMap) {
        return mapper.updateReadFlag(paramMap);
    }

    @Override
    public List<Message> selectMessageList( Map<String, Object> paramMap) {
        System.out.println(paramMap);
        List<Message> messageList = mapper.selectMessageList(  Integer.parseInt( String.valueOf(paramMap.get("chattingNo") )));
        
        if(!messageList.isEmpty()) {
            int result = mapper.updateReadFlag(paramMap);
        }
        return messageList;
    }

    // 채팅 상대 검색
	@Override
	public List<Member> selectTarget(Map<String, Object> map) {
		return mapper.selectTarget(map);
	}

    

    
    
    

    
    
}
