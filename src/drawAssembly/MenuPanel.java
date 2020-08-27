package drawAssembly;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import drawMain.SimpleDraw;

/**
 * 菜单容器类
 * @author Xinhai Cao
 *
 */
public class MenuPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**菜单条*/
	JMenuBar menuBar = new JMenuBar();
	/**文件菜单项*/
	JMenu menuFile = new JMenu("文件");
	/**子菜单*/
	JMenu menuLine = new JMenu("选择线宽");
	/**编辑菜单项*/
	JMenu menuEdit = new JMenu("编辑");
	JMenuItem m;//menuFile中的子菜单项
	SimpleDraw drawPaint;
	public MenuPanel(SimpleDraw drawPaint) {
		this.drawPaint = drawPaint;
		this.setBackground(null);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		m = new JMenuItem("打开");
		menuFile.add(m);
		m.addActionListener(this);
		m = new JMenuItem("保存");
		menuFile.add(m);
		m.addActionListener(this);
		m = new JMenuItem("退出");
		menuFile.add(m);
		m.addActionListener(this);
		
		menuEdit.add(menuLine);
		m = new JMenuItem("清除画布");
		menuEdit.add(m);
		m.addActionListener(this);
		
		m = new JMenuItem("2");
		menuLine.add(m);
		m.addActionListener(this);
		m = new JMenuItem("4");
		menuLine.add(m);
		m.addActionListener(this);
		m = new JMenuItem("6");
		menuLine.add(m);
		m.addActionListener(this);
		m = new JMenuItem("8");
		menuLine.add(m);
		m.addActionListener(this);
		m = new JMenuItem("10");
		menuLine.add(m);
		m.addActionListener(this);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		
		this.add(menuBar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String select = e.getActionCommand();
		switch(select) {
		case "打开":
			FileDialog openFile = new FileDialog(drawPaint, "打开文件", FileDialog.LOAD);
			openFile.setVisible(true);

			String path1 = openFile.getDirectory();
			String name1 = openFile.getFile();
			if (path1 == null || name1 == null)
				return;
			File file1 = new File(path1, name1);
			try {
				drawPaint.dp.paramer.snapshot = ImageIO.read(file1);
				drawPaint.dp.repaint();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "图片打开失败！");
			}
			break;
		case "保存":
			FileDialog saveFile = new FileDialog(drawPaint, "保存文件", FileDialog.SAVE);
			saveFile.setVisible(true);
			
			String path2 = saveFile.getDirectory();
			String name2 = saveFile.getFile();
			if (path2 == null || name2 == null)
				return;
			File file2 = new File(path2, name2);
			BufferedOutputStream b = null;
			try {
				b = new BufferedOutputStream(new FileOutputStream(file2));
				ImageIO.write(drawPaint.dp.paramer.snapshot, "png", b);

			} catch (IOException e2) {
				e2.printStackTrace();
			} finally {
				try {
					if (b != null)
						b.close();
				} catch (IOException e3) {
					System.out.println("关闭失败！");
				}
			}
			break;
		case "退出":
			drawPaint.dispose();
			drawPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
		case "2":
			drawPaint.dp.paramer.lineWidth = 2;
			break;
		case "4":
			drawPaint.dp.paramer.lineWidth = 4;
			break;
		case "6":
			drawPaint.dp.paramer.lineWidth = 6;
			break;
		case "8":
			drawPaint.dp.paramer.lineWidth = 8;
			break;
		case "10":
			drawPaint.dp.paramer.lineWidth = 10;
			break;
		case "清除画布":
			drawPaint.dp.paramer.snapshot = null;
			drawPaint.dp.repaint();
			break;
		}
	}
}
