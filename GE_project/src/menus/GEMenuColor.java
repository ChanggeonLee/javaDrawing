package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants;
import constants.GEConstants.EColorMenuItems;
import fames.GEDrawingPanel;

public class GEMenuColor extends JMenu{
	private GEDrawingPanel drawingPanel;
	private ColorMenuHandler colorMenuHandler;
	
	public GEMenuColor(String label){
		super(label);
		
		colorMenuHandler = new ColorMenuHandler();
		
		for( EColorMenuItems btn : EColorMenuItems.values() ){
			JMenuItem menuItem = new JMenuItem(btn.toString());
			menuItem.addActionListener(colorMenuHandler);
			menuItem.setActionCommand(btn.toString());
			this.add(menuItem);
		}
	}
	
	public void init(GEDrawingPanel drawingPanel){
		this.drawingPanel = drawingPanel;
	}
	
	public void setLineColor() {
		Color lineColor = JColorChooser.showDialog(null, GEConstants.TITLE_LINECOLOR, null);
		drawingPanel.setLineColor(lineColor);;
	}
	
	public void setFillColor() {
		Color fillColor = JColorChooser.showDialog(null, GEConstants.TITLE_FILLCOLOR, null);
		drawingPanel.setFillColor(fillColor);
	}
	
	public void clearLineColor(){
		drawingPanel.setLineColor(GEConstants.DEFAULT_LINE_COLOR);
	}
	
	public void clearFillColor(){
		drawingPanel.setFillColor(GEConstants.DEFAULT_FILL_COLOR);
	}

	private class ColorMenuHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			switch (EColorMenuItems.valueOf(e.getActionCommand())){
				case SetLineColor:
					setLineColor();
					break;
				case SetFillColor:
					setFillColor();
					break;
				case ClearLineColor:
					clearFillColor();
					break;
				case ClearFillColor:
					clearFillColor();
					break;	
			}
		}
	}
}