package drawAssembly;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import enums.ColorButtons;
import enums.Messages;
import drawMain.SimpleDraw;
/**
 * 颜色按钮容器类
 * @author Xinhai Cao
 *
 */
public class ColorPanel extends JPanel implements PropertyChangeListener,ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDraw drawPaint;
	public ColorPanel(SimpleDraw drawPaint) {
		this.drawPaint = drawPaint;
		setLayout(new GridLayout(12,1));
		ColorButtons[] cb = ColorButtons.values();
		for(int i=0;i<cb.length;i++) {
			JButton btn = createButton(null,cb[i].toString(),cb[i].getMessage(),null);
			btn.setBackground(cb[i].getColor());
			btn.addActionListener(this);
			add(btn);
		}
		
		addPropertyChangeListener(Messages.COLOR_BUTTON.toString(), drawPaint);
	}
	/**
	 * 创建按钮
	 * @param imageName 图片名称
	 * @param actionCommand 按钮名称
	 * @param toolTipText 鼠标移动到按钮提示信息
	 * @param altText 图像加载失败提示信息
	 * @return 返回值JButton
	 */
	protected JButton createButton(String imageName,String actionCommand,String toolTipText,String altText) {//Look for the image.

		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.setPreferredSize(new Dimension(36, 36));
		return button;
		}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		//firePropertyChange(Messages.COLOR_BUTTON.toString(), null, );
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name = arg0.getActionCommand();
		ColorButtons colors = ColorButtons.valueOf(name);
		firePropertyChange(Messages.COLOR_BUTTON.toString(), null, colors);
	}
}
