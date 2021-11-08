package com.java.factory;

import java.util.HashMap;

import com.java.guest.command.WriteCommand;
import com.java.guest.command.WriteOkCommand;
import com.java.member.command.DeleteCommand;
import com.java.member.command.DeleteOkCommand;
import com.java.member.command.IdCheckCommand;
import com.java.member.command.LoginCommand;
import com.java.member.command.LoginOkCommand;
import com.java.member.command.LogoutCommand;
import com.java.member.command.MainCommand;
import com.java.member.command.RegisterCommand;
import com.java.member.command.RegisterOkcommand;
import com.java.member.command.UpdateCommand;
import com.java.member.command.UpdateOkCommand;
import com.java.member.command.ZipcodeCommand;

public class FactoryURI {
	
	public HashMap<String, Object> getURIMap(){
		HashMap<String, Object> commandMap = new HashMap<String,Object>();
		
		// member
		RegisterCommand register = new RegisterCommand();
		commandMap.put("/member/register.do", register);
		
		RegisterOkcommand registerOk = new RegisterOkcommand();
		commandMap.put("/member/registerOk.do", registerOk);
		commandMap.put("/member/idCheck.do", new IdCheckCommand());
		commandMap.put("/member/zipcode.do", new ZipcodeCommand());
		
		commandMap.put("/member/login.do", new LoginCommand());
		commandMap.put("/member/loginOk.do", new LoginOkCommand());
		commandMap.put("/member/main.do", new MainCommand());
		commandMap.put("/member/logout.do", new LogoutCommand());
		
		commandMap.put("/member/delete.do",new DeleteCommand());
		commandMap.put("/member/deleteOk.do",new DeleteOkCommand());
		
		commandMap.put("/member/update.do",new UpdateCommand());
		commandMap.put("/member/updateOk.do",new UpdateOkCommand());
		
		//방명록
		commandMap.put("/guest/write.do", new WriteCommand());
		commandMap.put("/guest/writeOk.do", new WriteOkCommand());
		
		commandMap.put("/guest/delete.do", new com.java.guest.command.DeleteCommand());
		commandMap.put("/guest/update.do", new com.java.guest.command.UpdateCommand());
		commandMap.put("/guest/updateOk.do", new com.java.guest.command.UpdateOkCommand());
		
		//게시판
		commandMap.put("/board/write.do",new com.java.board.command.WriteCommand());
		commandMap.put("/board/writeOk.do", new com.java.board.command.WriteOkCommand());
		
		commandMap.put("/board/list.do", new com.java.board.command.ListCommand());
		
		return commandMap;
	}
}











