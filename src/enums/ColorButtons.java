package enums;
import java.awt.Color;

public enum ColorButtons {
	Red_color(Color.red,"红色"),		Magenta_color(Color.magenta,"洋红色"),Pink_color(Color.pink,"粉红色"),
	Green_color(Color.green,"绿色"),	Cyan_color(Color.cyan,"青色"),Blue_color(Color.blue,"蓝色"),
	Yellow_color(Color.yellow,"黄色"),Orange_color(Color.orange,"桔黄色"),
	Black_color(Color.black,"黑色"),Gray_color(Color.gray,"灰色"),	Darkgray_color(Color.darkGray,"深灰色");
	
	/**按钮提示信息*/
	private String message;
	/**按钮颜色*/
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
