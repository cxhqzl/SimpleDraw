package drawMain;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import drawAssembly.ColorPanel;
import drawAssembly.DrawPanel;
import drawAssembly.MenuPanel;
import drawAssembly.StatusPanel;
import drawAssembly.ToolPanel;
import enums.Messages;
/**
 * ��������
 * @author Xinhai Cao
 *
 */
public class SimpleDraw extends JFrame implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**��ɫ��ť*/
	public ColorPanel cp = new ColorPanel(this);
	/**��������*/
	public DrawPanel dp = new DrawPanel(this);
	/**�˵�����*/
	public MenuPanel mp = new MenuPanel(this);
	/**״̬������*/
	public StatusPanel sp = new StatusPanel();
	/**���߰�ť*/
	ToolPanel tp = new ToolPanel(this);
	public SimpleDraw() {
		super("����");
		this.setBounds(300,100,900,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����رճ���ʱֱ���˳�
		this.setLayout(new BorderLayout());
		add(cp,BorderLayout.EAST);
		add(dp,BorderLayout.CENTER);
		add(mp,BorderLayout.NORTH);
		add(sp,BorderLayout.SOUTH);
		add(tp,BorderLayout.WEST);
		
		addPropertyChangeListener(Messages.MOUSE_LOCATION.toString(), sp);
		addPropertyChangeListener(Messages.COLOR_BUTTON.toString(), dp);
		addPropertyChangeListener(Messages.TOOL_BUTTON.toString(), dp);
	}
	
	public static void main(String[] args) {
		new SimpleDraw();
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		firePropertyChange(arg0.getPropertyName(), arg0.getOldValue(), arg0.getNewValue());
	}

}
