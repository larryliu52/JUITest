package FinalGUITest;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarSearchUI extends JFrame {
    JPanel searchPanel, infoPanel, contentPanel, pricePanel, locationPanel, conditionPanel, yearPanel, makePanel, mileagePanel;
    JLabel priceLabel, locationLabel, conditionLabel, yearLabel, makeLabel, toPriceLabel, toYearLabel, mileageLabel;
    JButton searchButton, checkButton;
    JCheckBox allCondition, newCondition, usedCondition, certifiedPreOwnedCondition, saveResult;
    JComboBox minPrice, maxPrice, milesWithin, oldYear, newYear;
    JTextField zipCode;
    CarSearchUI(){
        this.setTitle("Car Search");
        this.createComponents();
        this.addComponents();
        this.addListeners();
        this.setItVisible();
    }

    private void addListeners() {
        //to be added
    }

    private void setItVisible() {
        this.setSize(800,600);
        this.setLocation(790,380);
        this.setVisible(true);
    }

    private void addComponents() {
        Container container = this.getContentPane();

        //set layouts of panels
        this.searchPanel.setLayout(new GridLayout(6,1));
        this.contentPanel.setLayout(new GridLayout(1,2));

        //set borders of panels
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        this.searchPanel.setBorder(blackLine);
        this.infoPanel.setBorder(blackLine);
        this.pricePanel.setBorder(blackLine);
        this.locationPanel.setBorder(blackLine);
        this.conditionPanel.setBorder(blackLine);
        this.yearPanel.setBorder(blackLine);
        this.makePanel.setBorder(blackLine);

        //add labels
        this.pricePanel.add(priceLabel);
        this.locationPanel.add(locationLabel);
        this.conditionPanel.add(conditionLabel);
        this.yearPanel.add(yearLabel);
        this.makePanel.add(makeLabel);

        //add boxes
        this.conditionPanel.add(this.allCondition);
        this.conditionPanel.add(this.newCondition);
        this.conditionPanel.add(this.usedCondition);
        this.conditionPanel.add(this.certifiedPreOwnedCondition);

        //add combobox
        this.pricePanel.add(minPrice);
        this.pricePanel.add(toPriceLabel);
        this.pricePanel.add(maxPrice);
        this.locationPanel.add(milesWithin);
        this.locationPanel.add(zipCode);
        this.yearPanel.add(oldYear);
        this.yearPanel.add(toYearLabel);
        this.yearPanel.add(newYear);

        //add panels
        this.searchPanel.add(this.pricePanel);
        this.searchPanel.add(this.locationPanel);
        this.searchPanel.add(this.conditionPanel);
        this.searchPanel.add(this.yearPanel);
        this.searchPanel.add(this.makePanel);
        this.searchPanel.add(this.searchButton);
        this.contentPanel.add(searchPanel);
        this.contentPanel.add(infoPanel);
        container.add(this.contentPanel);
    }

    private void createComponents() {
        //create components
        this.searchPanel = new JPanel();
        this.infoPanel = new JPanel();
        this.contentPanel = new JPanel();
        this.pricePanel = new JPanel();
        this.locationPanel = new JPanel();
        this.conditionPanel = new JPanel();
        this.yearPanel = new JPanel();
        this.makePanel = new JPanel();
        this.mileagePanel = new JPanel();
        this.priceLabel = new JLabel();
        this.locationLabel = new JLabel();
        this.conditionLabel = new JLabel();
        this.yearLabel = new JLabel();
        this.makeLabel = new JLabel();
        this.toPriceLabel = new JLabel();
        this.toYearLabel = new JLabel();
        this.mileageLabel = new JLabel();
        this.allCondition = new JCheckBox();
        this.newCondition = new JCheckBox();
        this.usedCondition = new JCheckBox();
        this.minPrice = new JComboBox();
        this.maxPrice = new JComboBox();
        this.milesWithin = new JComboBox();
        this.oldYear = new JComboBox();
        this.newYear = new JComboBox();
        this.zipCode = new JTextField();

        this.searchButton = new JButton("Search");
        this.certifiedPreOwnedCondition = new JCheckBox();

        //initiate components
        this.priceLabel.setText("Price");
        this.locationLabel.setText("Location");
        this.conditionLabel.setText("New/Used");
        this.yearLabel.setText("Year");
        this.makeLabel.setText("Make");
        this.toPriceLabel.setText("to");
        this.toYearLabel.setText("to");
        this.allCondition.setText("All");
        this.newCondition.setText("New");
        this.usedCondition.setText("Used");
        this.certifiedPreOwnedCondition.setText("Certified Pre-Owned");

        //add price
        this.minPrice.addItem("Min Price");
        this.minPrice.addItem("5000");
        this.minPrice.addItem("8000");
        this.minPrice.addItem("10000");
        this.minPrice.addItem("20000");
        this.minPrice.addItem("30000");
        this.maxPrice.addItem("Max Price");
        this.maxPrice.addItem("5000");
        this.maxPrice.addItem("8000");
        this.maxPrice.addItem("10000");
        this.maxPrice.addItem("20000");
        this.maxPrice.addItem("30000");

        //add mile
        this.milesWithin.addItem("5 miles");
        this.milesWithin.addItem("10 miles");
        this.milesWithin.addItem("20 miles");
        this.milesWithin.addItem("30 miles");

        //add year
        for(int i=2000;i<=2019;i++){
            this.oldYear.addItem(i);
            this.newYear.addItem(i);
        }

        //define zip code text field length
        this.zipCode.setColumns(5);
    }
    public static void main(String [] args){
        CarSearchUI carSearchUI = new CarSearchUI();
    }
}
