package drawAssembly;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MyParamer.MyParamer;
import drawMain.SimpleDraw;
import enums.ColorButtons;
import enums.Messages;
import enums.ToolButtons;
/**
 * 画板容器类
 * @author Xinhai Cao
 *
 */
public class DrawPanel extends JPanel implements MouseMotionListener,PropertyChangeListener,MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**参数存储对象*/
	MyParamer paramer = new MyParamer();
	/**主类*/
	SimpleDraw drawPaint;
	/** 输入框的X位置 */
	int textX = 0;
	/** 输入框的Y位置 */
	int textY = 0;
	/** 输入的字符 */
	String textT = "";
	/**输入框高度*/
	int textHeight = 0;
	public DrawPanel(SimpleDraw drawPaint) {
		this.drawPaint = drawPaint;
		this.setLayout(null);
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		this.addPropertyChangeListener(Messages.MOUSE_LOCATION.toString(), drawPaint);
	}
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		g.drawImage(paramer.snapshot, 0, 0, this);
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		paramer.stopX = arg0.getX();
		paramer.stopY = arg0.getY();	
		//画图位置计算
		int x1 = Math.min(paramer.startX, arg0.getX());
		int y1 = Math.min(paramer.startY, arg0.getY());
		int x2 = Math.abs(paramer.startX - arg0.getX());
		int y2 = Math.abs(paramer.startY - arg0.getY());
		/**画笔*/
		Graphics2D g2 = (Graphics2D) this.getGraphics();
		//设置画笔颜色
		g2.setColor(paramer.color.getColor());
		//设置画笔宽度
		g2.setStroke(new BasicStroke(paramer.lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		switch (paramer.tool.getMessage()) {
		case "直线":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.drawLine(paramer.startX, paramer.startY, paramer.stopX, paramer.stopY);
			break;
		case "铅笔":
			g2.drawLine(paramer.startX, paramer.startY, paramer.stopX, paramer.stopY);
			paramer.startX = arg0.getX();
			paramer.startY = arg0.getY();
			break;
		case "圆":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.drawOval(x1, y1, Math.max(x2, y2), Math.max(x2, y2));
			break;
		case "填充圆":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.fillOval(x1, y1, Math.max(x2, y2), Math.max(x2, y2));
			break;
		case "椭圆":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.drawOval(x1, y1, x2, y2);
			break;
		case "填充椭圆":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.fillOval(x1, y1, x2, y2);
			break;
		case "矩形":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.drawRect(x1, y1, x2, y2);
			break;
		case "填充矩形":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.fillRect(x1, y1, x2, y2);
			break;
		case "圆角矩形":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.drawRoundRect(x1, y1, x2, y2, 20, 20);
			break;
		case "填充圆角矩形":
			g2.drawImage(paramer.snapshot, 0, 0, this);
			g2.fillRoundRect(x1, y1, x2, y2, 20, 20);
			break;
		case "橡皮擦":
			g2.setColor(Color.WHITE);
			g2.drawLine(paramer.startX, paramer.startY, arg0.getX(), arg0.getY());
			paramer.startX = arg0.getX();
			paramer.startY = arg0.getY();
			break;
		}
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		paramer.x = arg0.getX();
		paramer.y = arg0.getY();
		firePropertyChange(Messages.MOUSE_LOCATION.toString(), null, paramer);
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		String str = arg0.getPropertyName();
		switch(str) {
		case "COLOR_BUTTON":
			ColorButtons cb = (ColorButtons) arg0.getNewValue();
			paramer.color = cb;
			break;
		case "TOOL_BUTTON":
			ToolButtons tb = (ToolButtons) arg0.getNewValue();
			paramer.tool = tb;
			break;
		}
		firePropertyChange(Messages.MOUSE_LOCATION.toString(), null, paramer);
	}
	@Override//点击
	public void mouseClicked(MouseEvent arg0) {
		if (paramer.tool.getMessage().equals("文本")) {
			if (null == paramer.text) {
				textX = arg0.getX();
				textY = arg0.getY();
				paramer.text = new JTextArea();
				paramer.text.setBorder(BorderFactory.createDashedBorder(Color.red));
				paramer.text.setBounds(textX, textY, 200, 20);
				this.add(paramer.text);
				textHeight = paramer.text.getHeight();
				paramer.text.requestFocus();
				repaint();
			}
		}
	}
	@Override//进入
	public void mouseEntered(MouseEvent arg0) {
		Cursor cur1 = new Cursor(Cursor.CROSSHAIR_CURSOR);
		switch (paramer.tool.getMessage()) {
		case "直线":
		case "圆":
		case "填充圆":
		case "椭圆":
		case "填充椭圆":
		case "矩形":
		case "填充矩形":
		case "圆角矩形":
		case "填充圆角矩形":
			drawPaint.dp.setCursor(cur1);
			break;
		case "橡皮擦":
			Cursor cur2 = Toolkit.getDefaultToolkit().createCustomCursor(
					new ImageIcon(DrawPanel.class.getResource("/images/Rubber_icon.png")).getImage(),new Point(10,20), "stick");
			drawPaint.dp.setCursor(cur2);
			break;
		case "铅笔":
			Cursor cur3 = Toolkit.getDefaultToolkit().createCustomCursor(
					new ImageIcon(DrawPanel.class.getResource("/images/Pencil_icon.png")).getImage(),new Point(10,20), "stick");
			drawPaint.dp.setCursor(cur3);
			break;
		case "文本":
			Cursor cur4 = new Cursor(Cursor.TEXT_CURSOR);
			drawPaint.dp.setCursor(cur4);
			break;
		}
		
	}
	@Override//退出
	public void mouseExited(MouseEvent arg0) {
		
	}
	@Override//按下
	public void mousePressed(MouseEvent arg0) {
		paramer.startX = arg0.getX();
		paramer.startY = arg0.getY();
		if ((null != paramer.text) && (!isContains(paramer.text, arg0.getX(), arg0.getY()))) {
			textT = paramer.text.getText();
			remove(paramer.text);
			paramer.text = null;
			repaint();
		}
	}
	@Override//松开
	public void mouseReleased(MouseEvent arg0) {
		if ((paramer.tool.getMessage().equals("文本")) && (null != paramer.text)) {
			// 输入框存在时，不拍照
		} else {
			if (!textT.isEmpty()) {
				Graphics2D g2 = (Graphics2D) this.getGraphics();
				g2.setColor(paramer.color.getColor());
				g2.drawString(textT, textX, textY + textHeight*2/3);
				textT = "";
				textX = textY = 0;
			}
			takeSnapshot();
		}
	}
	/**拍照*/
	public void takeSnapshot() {
		try {
			Point p = this.getLocationOnScreen();
			paramer.snapshot = new Robot().createScreenCapture(new Rectangle((int) p.getX(), (int) p.getY(), this.getWidth(), this.getHeight()));
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	/**判断点击位置是否在输入框内*/
	private boolean isContains(JTextArea area, int x, int y) {
		boolean flag = true;
		Rectangle rect = area.getBounds();
		if ((x < rect.x) || (x > rect.x + rect.width)) {
			flag = false;
		}
		if ((y < rect.y) || (y > rect.y + rect.height)) {
			flag = false;
		}
		return flag;
	}
}