package drawAssembly;

import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MyParamer.*;
/**
 * 状态栏容器类
 * @author Xinhai Cao
 *
 */
public class StatusPanel extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**显示状态栏信息*/
	JLabel jl = new JLabel("状态栏");
	
	public StatusPanel() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(jl);
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		MyParamer mp = (MyParamer) arg0.getNewValue();
		jl.setText("鼠标位置：["+mp.x+","+mp.y+"]" + "      已选工具:["+mp.tool.getMessage()+"]" + 
				"     已选颜色:["+mp.color.getMessage()+ "]"+"      线条宽度:["+mp.lineWidth+"]");
	}
}
