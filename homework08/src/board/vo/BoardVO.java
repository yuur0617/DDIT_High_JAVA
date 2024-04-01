package board.vo;

import java.time.LocalDate;

public class BoardVO {

	private String bdNum; //번호
	private String bdTitle; //제목
	private String bdWriter; // 작성자
	private LocalDate regDt; // 작성날짜
	private String bdContent; //내용
	
	public BoardVO() {}
	
	public BoardVO(String bdTitle, String bdWriter, String bdContent) {
		super();
		this.bdTitle = bdTitle;
		this.bdWriter = bdWriter;
		this.bdContent = bdContent;
	}
	//bdNum getter,setter
	public String getBdNum() {
		return bdNum;
	}
	public void setBdNum(String bdNum) {
		this.bdNum = bdNum;
	}
	
	//bdTitle getter, setter
	public String getBdTitle() {
		return bdTitle;
	}
	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}
	
	//bdWriter getter, setter
	public String getBdWriter() {
		return bdWriter;
	}
	public void setBdWriter(String bdWriter) {
		this.bdWriter = bdWriter;
	}
	
	//regDt getter, setter
	public LocalDate getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDate regDt) {
		this.regDt = regDt;
	}
	
	//bdContent getter, setter
	public String getBdContent() {
		return bdContent;
	}
	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}
	
	
}
