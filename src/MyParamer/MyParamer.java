package MyParamer;

import java.awt.image.BufferedImage;

import javax.swing.JTextArea;

import enums.ColorButtons;
import enums.ToolButtons;

public class MyParamer {
	/**�����ʼλ��*/
	public int startX,startY,stopX,stopY;
	/**��굱ǰλ��*/
	public int x,y;
	/**���߰�ť*/
	public ToolButtons tool;
	/**��ɫ��ť*/
	public ColorButtons color;
	/**��ͼ*/
	public BufferedImage snapshot;
	/**�߿�*/
	public int lineWidth;
	/**�ı���*/
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
