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
 * �˵�������
 * @author Xinhai Cao
 *
 */
public class MenuPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**�˵���*/
	JMenuBar menuBar = new JMenuBar();
	/**�ļ��˵���*/
	JMenu menuFile = new JMenu("�ļ�");
	/**�Ӳ˵�*/
	JMenu menuLine = new JMenu("ѡ���߿�");
	/**�༭�˵���*/
	JMenu menuEdit = new JMenu("�༭");
	JMenuItem m;//menuFile�е��Ӳ˵���
	SimpleDraw drawPaint;
	public MenuPanel(SimpleDraw drawPaint) {
		this.drawPaint = drawPaint;
		this.setBackground(null);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		m = new JMenuItem("��");
		menuFile.add(m);
		m.addActionListener(this);
		m = new JMenuItem("����");
		menuFile.add(m);
		m.addActionListener(this);
		m = new JMenuItem("�˳�");
		menuFile.add(m);
		m.addActionListener(this);
		
		menuEdit.add(menuLine);
		m = new JMenuItem("�������");
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
		case "��":
			FileDialog openFile = new FileDialog(drawPaint, "���ļ�", FileDialog.LOAD);
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
				JOptionPane.showMessageDialog(this, "ͼƬ��ʧ�ܣ�");
			}
			break;
		case "����":
			FileDialog saveFile = new FileDialog(drawPaint, "�����ļ�", FileDialog.SAVE);
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
					System.out.println("�ر�ʧ�ܣ�");
				}
			}
			break;
		case "�˳�":
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
		case "�������":
			drawPaint.dp.paramer.snapshot = null;
			drawPaint.dp.repaint();
			break;
		}
	}
}
