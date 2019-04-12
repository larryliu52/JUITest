package FinalGUITest;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CarSearchUI extends JFrame {
    JPanel searchPanel, infoPanel, contentPanel, pricePanel, locationPanel, conditionPanel, yearPanel, makePanel, mileagePanel, infoPanelOut, searchPanelOut;
    JLabel priceLabel, locationLabel, conditionLabel, yearLabel, makeLabel, toPriceLabel, toYearLabel, mileageLabel;
    JButton searchButton;
    JCheckBox allCondition, newCondition, usedCondition, certifiedPreOwnedCondition;
    JComboBox minPrice, maxPrice, milesWithin, oldYear, newYear, make, mileage;
    JTextField zipCode;
    JScrollPane searchScroll, resultScroll;

    List<JPanel> resultList;
    CarSearchUI() throws IOException {
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
        this.setSize(1800,300);
        this.setLocation(790,380);
        this.setVisible(true);
    }

    private void addComponents() throws IOException {

        //set layouts of panels
//        this.searchPanel.setLayout(new GridLayout(6,1));
        this.searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        this.infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        //set borders of panels
        Border emptyBorder = BorderFactory.createEmptyBorder(15,0,15,0);
        this.searchPanel.setBorder(emptyBorder);
        this.infoPanel.setBorder(emptyBorder);
        this.pricePanel.setBorder(emptyBorder);
        this.locationPanel.setBorder(emptyBorder);
        this.conditionPanel.setBorder(emptyBorder);
        this.yearPanel.setBorder(emptyBorder);
        this.makePanel.setBorder(emptyBorder);
        this.mileagePanel.setBorder(emptyBorder);

        this.pricePanel.setPreferredSize(new Dimension(200,50));
        this.locationPanel.setPreferredSize(new Dimension(200,50));
        this.conditionPanel.setPreferredSize(new Dimension(200,50));
        this.yearPanel.setPreferredSize(new Dimension(200,50));
        this.makePanel.setPreferredSize(new Dimension(200,50));
        this.mileagePanel.setPreferredSize(new Dimension(200,50));


        //add labels
        this.pricePanel.add(priceLabel);
        this.locationPanel.add(locationLabel);
        this.conditionPanel.add(conditionLabel);
        this.yearPanel.add(yearLabel);
        this.makePanel.add(makeLabel);
        this.mileagePanel.add(mileageLabel);

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
        this.makePanel.add(make);
        this.mileagePanel.add(mileage);


        //add panels
        this.searchPanel.add(this.pricePanel);
        this.searchPanel.add(this.locationPanel);
        this.searchPanel.add(this.conditionPanel);
        this.searchPanel.add(this.yearPanel);
        this.searchPanel.add(this.mileagePanel);
        this.searchPanel.add(this.makePanel);
        this.searchPanel.add(this.searchButton);


        //test result list
        for(int i=1 ; i<4 ; i++){
            String imagePath = Integer.toString(i)+".jpeg";
            ResultPanel resultPanel = new ResultPanel(imagePath);
            this.infoPanel.add(resultPanel);
        }


        //add scroll panels
        //pin the panel
        this.infoPanelOut.setLayout(new BorderLayout());
        this.infoPanelOut.add(infoPanel, BorderLayout.NORTH);
        this.searchPanelOut.setLayout(new BorderLayout());
        this.searchPanelOut.add(searchPanel, BorderLayout.NORTH);

        //pin the west panel/search panel
        this.setLayout(new BorderLayout());
        this.add(searchScroll, BorderLayout.WEST);
        searchScroll.setPreferredSize(new Dimension(450,15));


        this.add(resultScroll,BorderLayout.CENTER);

    }

    private void createComponents() throws IOException {
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
        this.make = new JComboBox();
        this.mileage = new JComboBox();

        this.infoPanelOut = new JPanel();
        this.searchPanelOut = new JPanel();

        this.searchButton = new JButton("Search");
        this.certifiedPreOwnedCondition = new JCheckBox();

        //create result list






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
        this.mileageLabel.setText("Mileage");

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

        //add make
        this.make.addItem("Audi");

        //add mileage
        this.mileage.addItem("20000 miles");

        //set scroll panel
        this.searchScroll = new JScrollPane(searchPanelOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.searchScroll.getVerticalScrollBar().setUnitIncrement(1);
        this.resultScroll = new JScrollPane(infoPanelOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.resultScroll.getVerticalScrollBar().setUnitIncrement(1);

    }
    public static void main(String [] args) throws IOException {
        CarSearchUI carSearchUI = new CarSearchUI();
    }
}
class ResultPanel extends JPanel{

    ImageIcon imageIcon;
    Image image;

    JLabel resultPrice, resultLocation, resultMake, resultYear, resultMileage, resultCondition;
    JButton checkButton;
    ResultPanel(String imagePath) {
//        this.setLayout(new GridLayout(1,7));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.imageIcon = new ImageIcon(imagePath);
        this.image = this.imageIcon.getImage();
        Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(newImage);
        JLabel jLabel = new JLabel(this.imageIcon);
        this.add(jLabel);
        this.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));

        this.createComponents();
        this.addComponents();
    }
    private void showImage(){

    }
    private void showInfo(){

    }
    private void createComponents(){
        this.checkButton = new JButton("Check availability");
        this.resultCondition = new JLabel("Condition: ");
        this.resultLocation = new JLabel("Location: ");
        this.resultMake = new JLabel("Make: ");
        this.resultMileage = new JLabel("Mileage: ");
        this.resultYear = new JLabel("Year: ");
        this.resultPrice = new JLabel("Price: ");
        this.checkButton.setPreferredSize(new Dimension(200,50));
        this.resultPrice.setPreferredSize(new Dimension(100,50));
        this.resultLocation.setPreferredSize(new Dimension(150,50));
        this.resultMileage.setPreferredSize(new Dimension(150,50));
        this.resultCondition.setPreferredSize(new Dimension(150,50));
        this.resultYear.setPreferredSize(new Dimension(100,50));
        this.resultMake.setPreferredSize(new Dimension(100,50));


    }
    private void addComponents(){
        this.add(resultPrice);
        this.add(resultCondition);
        this.add(resultMake);
        this.add(resultYear);
        this.add(resultMileage);
        this.add(resultLocation);
        this.add(this.checkButton);


    }
}
