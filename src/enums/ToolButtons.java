package enums;

public enum ToolButtons {
	Word("Word","ÎÄ±¾"),Line("Line","Ö±Ïß"),Pencil("Pencil","Ç¦±Ê"),Circle("Circle","Ô²"),
	fillCircle("fillCircle","Ìî³äÔ²"),Oval("Oval","ÍÖÔ²"),fillOval("fillOval","Ìî³äÍÖÔ²"),
	Rect("Rect","¾ØĞÎ"),fillRect("fillRect","Ìî³ä¾ØĞÎ"),roundRect("roundRect","Ô²½Ç¾ØĞÎ"),
	rounFilldRect("roundFillRect","Ìî³äÔ²½Ç¾ØĞÎ"),Rubber("Rubber","ÏğÆ¤²Á");
	/**Í¼Æ¬Ãû³Æ*/
	private String imageName;
	/**°´Å¥ÌáÊ¾ĞÅÏ¢*/
	private String message;
	
	private ToolButtons(String imageName,String message) {
		this.imageName = imageName;
		this.message = message;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
