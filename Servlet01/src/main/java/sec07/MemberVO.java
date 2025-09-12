package sec07;

import java.util.Date;

public class MemberVO {
	
	private String memID;
	private String memPWD;
	private String memName;
	private String memEmail;
	private Date memJoinDate;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String memID, String memPWD, String memName, String memEmail, Date memJoinDate) {
		super();
		this.memID = memID;
		this.memPWD = memPWD;
		this.memName = memName;
		this.memEmail = memEmail;
		this.memJoinDate = memJoinDate;
	}

	public String getMemID() {
		return memID;
	}

	public void setMemID(String memID) {
		this.memID = memID;
	}

	public String getMemPWD() {
		return memPWD;
	}

	public void setMemPWD(String memPWD) {
		this.memPWD = memPWD;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public Date getMemJoinDate() {
		return memJoinDate;
	}

	public void setMemJoinDate(Date memJoinDate) {
		this.memJoinDate = memJoinDate;
	}
	
	
	
}
