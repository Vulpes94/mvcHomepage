package com.java.guest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.java.database.ConnectionProvider;
import com.java.database.JdbcUtil;
import com.java.guest.dto.GuestDto;

public class GuestDao {
	private static GuestDao instance =new GuestDao();
	
	public static GuestDao getInstance() {
		return instance;
	}
	
	public int insert(GuestDto guestDto) {
		int check = 0;
		Connection conn =null;
		PreparedStatement pstmt =null;
		
		try {
			String sql = "INSERT INTO guest VALUES(guest_num_seq.nextval,?,?,?,sysdate)";
			conn = ConnectionProvider.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, guestDto.getName());
			pstmt.setString(2, guestDto.getPassword());
			pstmt.setString(3, guestDto.getMessage().replace("\r\n", "<br/>"));
			
			check = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	}
	
	public ArrayList<GuestDto> guestList(int startRow, int endRow){
		ArrayList<GuestDto> guestList =null;
		Connection conn =null;
		PreparedStatement pstmt =null;	
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM "
						+ "(SELECT ROWNUM AS rnum, a.* FROM "
							+ "(SELECT * FROM GUEST ORDER BY num DESC ) a) b "
						+ "WHERE b.rnum >= ? AND b.rnum <=?";
			conn = ConnectionProvider.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			guestList =new ArrayList<GuestDto>();
			while (rs.next()) {
				GuestDto guestDto =new GuestDto();
				guestDto.setNum(rs.getInt("num"));
				guestDto.setName(rs.getString("name"));
				guestDto.setPassword(rs.getString("password"));
				guestDto.setMessage(rs.getString("message"));
				guestDto.setWriteDate(new Date(rs.getTimestamp("write_date").getTime()));
				
				guestList.add(guestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return guestList;	
	}
	
	public int delete(int num) {
		int check = 0;
		Connection conn =null;
		PreparedStatement pstmt =null;	
		
		try {
			String sql = "DELETE FROM guest WHERE num=?";
			conn = ConnectionProvider.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			check = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	}
	
	public GuestDto upSelect(int num) {
		GuestDto guestDto =null;
		Connection conn =null;
		PreparedStatement pstmt =null;	
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM guest WHERE num=?";
			conn = ConnectionProvider.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				guestDto = new GuestDto();
				guestDto.setNum(rs.getInt("num"));
				guestDto.setName(rs.getString("name"));
				guestDto.setPassword(rs.getString("password"));
				guestDto.setMessage(rs.getString("message").replace("<br/>", "\r\n"));
				guestDto.setWriteDate(
						new Date(rs.getTimestamp("write_date").getTime()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return guestDto;
	}
	
	public int update(GuestDto guestDto) {
		int check = 0;
		Connection conn =null;
		PreparedStatement pstmt =null;	
		
		try {
			String sql = "UPDATE guest SET password=?,message=? WHERE num=?";
			conn = ConnectionProvider.getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, guestDto.getPassword());
			pstmt.setString(2, guestDto.getMessage().replace("\r\n", "<br/>"));
			pstmt.setInt(3, guestDto.getNum());
			
			check = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}
	
	public int getCount() {
		int count = 0;
		Connection conn =null;
		PreparedStatement pstmt =null;	
		ResultSet rs = null;
		
		try {
			String sql = "SELECT COUNT(*) FROM guest";
			conn = ConnectionProvider.getConnection();
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) count =rs.getInt(1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return count;
	}
	
}








