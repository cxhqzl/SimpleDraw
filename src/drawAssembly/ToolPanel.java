package drawAssembly;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import enums.*;
import drawMain.SimpleDraw;

/**
 * 工具按钮容器类
 * @author Xinhai Cao
 *
 */
public class ToolPanel extends JPanel implements PropertyChangeListener,ActionListener,ItemListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SimpleDraw drawPaint;
	
	public ToolPanel(SimpleDraw drawPaint) {
		this.drawPaint = drawPaint;
		setLayout(new GridLayout(14,1));
		
		ToolButtons[] tb = ToolButtons.values();
		for(int i=0;i<tb.length;i++) {
			JButton btn = createButton(tb[i].getImageName(),tb[i].toString(),tb[i].getMessage(),null);
			btn.setBackground(Color.white);
			add(btn);
		}
		addPropertyChangeListener(Messages.TOOL_BUTTON.toString(), drawPaint);
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
		String imgLocation = "/images/"+ imageName+ ".png";
		URL imageURL = ToolPanel.class.getResource(imgLocation);

		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
	
		if (imageURL != null) {                      //image found
			button.setIcon(new ImageIcon(imageURL, altText));
		} 
		else {                                     //no image found
			button.setText(altText);
			System.err.println("Resource not found: "+ imgLocation);
		}
		return button;
		}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		ToolButtons tools = ToolButtons.valueOf(name);
		firePropertyChange(Messages.TOOL_BUTTON.toString(), null, tools);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice c = (Choice) e.getItemSelectable();
		drawPaint.dp.paramer.lineWidth = Integer.parseInt(c.getSelectedItem());
	}
}
