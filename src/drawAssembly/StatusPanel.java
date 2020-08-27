package drawAssembly;

import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import MyParamer.*;
/**
 * ״̬��������
 * @author Xinhai Cao
 *
 */
public class StatusPanel extends JPanel implements PropertyChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**��ʾ״̬����Ϣ*/
	JLabel jl = new JLabel("״̬��");
	
	public StatusPanel() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(jl);
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		MyParamer mp = (MyParamer) arg0.getNewValue();
		jl.setText("���λ�ã�["+mp.x+","+mp.y+"]" + "      ��ѡ����:["+mp.tool.getMessage()+"]" + 
				"     ��ѡ��ɫ:["+mp.color.getMessage()+ "]"+"      �������:["+mp.lineWidth+"]");
	}
}
