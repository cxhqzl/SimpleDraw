package enums;

public enum ToolButtons {
	Word("Word","�ı�"),Line("Line","ֱ��"),Pencil("Pencil","Ǧ��"),Circle("Circle","Բ"),
	fillCircle("fillCircle","���Բ"),Oval("Oval","��Բ"),fillOval("fillOval","�����Բ"),
	Rect("Rect","����"),fillRect("fillRect","������"),roundRect("roundRect","Բ�Ǿ���"),
	rounFilldRect("roundFillRect","���Բ�Ǿ���"),Rubber("Rubber","��Ƥ��");
	/**ͼƬ����*/
	private String imageName;
	/**��ť��ʾ��Ϣ*/
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
