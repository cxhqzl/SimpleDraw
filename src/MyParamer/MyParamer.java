package MyParamer;

import java.awt.image.BufferedImage;

import javax.swing.JTextArea;

import enums.ColorButtons;
import enums.ToolButtons;

public class MyParamer {
	/**鼠标起始位置*/
	public int startX,startY,stopX,stopY;
	/**鼠标当前位置*/
	public int x,y;
	/**工具按钮*/
	public ToolButtons tool;
	/**颜色按钮*/
	public ColorButtons color;
	/**截图*/
	public BufferedImage snapshot;
	/**线宽*/
	public int lineWidth;
	/**文本框*/
	public JTextArea text;
	
	public MyParamer() {
		startX=startY=stopX=stopY=x=y=0;
		tool = ToolButtons.Pencil;
		color = ColorButtons.Black_color;
		snapshot = null;
		lineWidth = 2;
		text = null;
	}
}
