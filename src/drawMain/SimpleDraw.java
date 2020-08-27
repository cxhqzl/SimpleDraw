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
 * 画布主类
 * @author Xinhai Cao
 *
 */
public class SimpleDraw extends JFrame implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**颜色按钮*/
	public ColorPanel cp = new ColorPanel(this);
	/**画板容器*/
	public DrawPanel dp = new DrawPanel(this);
	/**菜单容器*/
	public MenuPanel mp = new MenuPanel(this);
	/**状态栏容器*/
	public StatusPanel sp = new StatusPanel();
	/**工具按钮*/
	ToolPanel tp = new ToolPanel(this);
	public SimpleDraw() {
		super("画板");
		this.setBounds(300,100,900,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击关闭程序时直接退出
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
