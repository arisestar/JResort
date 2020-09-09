// exercise on pg 745-

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JResort extends JFrame implements ItemListener
{	

	// data field variables and constants for this class
	final int BASE_PRICE = 200;
	final int WEEKEND_PREMIUM =100;
	final int BREAKFAST_PREMIUM = 20;
	final int GOLF_PERMIUM = 75;
	int totalPrice = BASE_PRICE;

	// Create 3 JCheckBox objects
	JCheckBox  weekendBox = new JCheckBox("Weekend Premium $" + WEEKEND_PREMIUM, false);

	JCheckBox breakfastBox = new JCheckBox(" breakfast $" +BREAKFAST_PREMIUM);

	JCheckBox golfBox = new JCheckBox("Golf $" + GOLF_PREMIUM);

	// create four Jlabel objects 

	JLabel resortLabel = new JLabel("Resort Price Calculator");
	JLabel optionExplainLabel = new JLabel("Base price for a room is $" + BASE_PRICE + ".");
	JLabel optionExplainLabel2 = new JLabel("Check the options you want to add.");
	JLabel priceLabel = new Jlabel("the price for your stay is");

	// create 1 JTextField object
	JTextField priceField = new JTextField(4);

	// constructor method for this class 

	public JResort()

	{
		super("Resort Price Estimator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		// add the various GUI components to the frame 
		add(resortLabel);
		add(optionExplainLabel);
		add(optionExplainLabel2);
		add(weekendBox);
		add(breakfastBox);
		add(golfBox);
		add(priceLabel);
		add(priceField);

		// set the priceField value when the GUI loads
		priceField.setText("$" + totalPrice);

		// add the event listeners for the checkBox objects 
		weekendBox.addItemListener(this);
		breakfastBox.addItemListener(this);
		golfBox.addItemListener(this);




	}
	
	// event handling method for this GUI

	@Override
	public void  itemStateChanged(ItemEvent event)
	{
		Object source = event.getSource();
		int select = event.getStateChange();
	
		// Decide which component triggered this event
		// Adjust the totalPrice accordingly
		if(source == weekendBox)
		{
			// if the box is checked, add the premium
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += WEEKEND_PREMIUM;
			}
			else
			{
				totalPrice -= WEEKEND_PREMIUM;
			}
		}
		else if(source == breakfastBox)
		{
			// if the box is checked, add the premium
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += BREAKFAST_PREMIUM;
			}
			else
			{
				totalPrice -= BREAKFAST_PREMIUM;
			}
		}
		else // we're really saying the source == golfBox here
		{
			// if the box is checked, add the premium
			if(select == ItemEvent.SELECTED)
			{
				totalPrice += GOLF_PREMIUM;
			}
			else
			{
				totalPrice -= GOLF_PREMIUM;
			}
		}


		 


		priceField.setText("$" + totalPrice);



	}// event of the event handling method

	public static void main(String[] args) 
	{
		// create an object from the JResort class
		JResort aFrame = new JResort();
		aFrame.setSize(300, 200);
		aFrame.setVisible(true);
	}
}