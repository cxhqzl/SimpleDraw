package enums;

public enum Messages {
	MOUSE_LOCATION(0,"鼠标位置"),COLOR_BUTTON(1,"颜色按钮"),TOOL_BUTTON(2,"工具按钮");
	private int index;
	private String name;
	
	private Messages(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
