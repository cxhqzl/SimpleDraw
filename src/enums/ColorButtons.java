package enums;
import java.awt.Color;

public enum ColorButtons {
	Red_color(Color.red,"��ɫ"),		Magenta_color(Color.magenta,"���ɫ"),Pink_color(Color.pink,"�ۺ�ɫ"),
	Green_color(Color.green,"��ɫ"),	Cyan_color(Color.cyan,"��ɫ"),Blue_color(Color.blue,"��ɫ"),
	Yellow_color(Color.yellow,"��ɫ"),Orange_color(Color.orange,"�ۻ�ɫ"),
	Black_color(Color.black,"��ɫ"),Gray_color(Color.gray,"��ɫ"),	Darkgray_color(Color.darkGray,"���ɫ");
	
	/**��ť��ʾ��Ϣ*/
	private String message;
	/**��ť��ɫ*/
	private Color color;
	
	private ColorButtons(Color color,String message) {
		this.color = color;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	
}
