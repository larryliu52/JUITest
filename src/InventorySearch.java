package finalprojectgroup2test2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import database.DatabaseConnection;
import dto.*;
import javax.swing.*;



public class InventorySearch extends InventorySearchBuild{
    String dealerID;
    Inventory inventory;
    ArrayList<Vehicle> vehiclesCollection;

    public InventorySearch(String dealerID) throws FileNotFoundException {
        super();
        this.dealerID = dealerID;
        this.buildUI();
    }

    public void buildUI() throws FileNotFoundException {
        this.inventoryConnection();
        this.buildNorthPanel();
        this.createWestPanelComponents();
        this.defineWestPanelComponents();
        this.initializationWestPanelButtonCondition();
        this.buildWestPanel();
        this.buildCentralPanel();
        this.defineSouthPanelComponents();
        this.buildSouthPanel();
        this.showResults(new DatabaseConnection().getVehiclesForDealer(this.dealerID));
    }

    public void inventoryConnection() {

        Inventory i = new Inventory("D1");
        i.setVehicles(new DatabaseConnection().getVehiclesForDealer(this.dealerID));

        this.inventory = i;
        this.vehiclesCollection = new DatabaseConnection().getVehiclesForDealer(this.dealerID);
    }

    public void buildNorthPanel() {
        //northPanel.setPreferredSize(new Dimension(500, 500));
        northPanel = new JPanel() {
            public void paintComponent(Graphics g) {
                ImageIcon backImage = new ImageIcon("//users/liulanze/Downloads/2019 Spring NEU Seattle/JAVA OOP/Final Project/cover1.jpeg");
                g.drawImage(backImage.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
            }
        };

        labelSortBy = new JLabel("Sort by:");
        JCBSortBy = new JComboBox(new String[] {"Distance: Nearest(Default)", "Price: Lowest", "Price: Highest", "Year: Newest", "Year: Oldest", "Mileage: Lowest", "Mileage: Highest"});

        northPanel.setOpaque(true);
        northPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        northPanel.add(labelSortBy, BorderLayout.EAST);
        northPanel.add(JCBSortBy, BorderLayout.EAST);

        northPanel.add(Box.createRigidArea(new Dimension(100, 100)));
        northPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        getContentPane().add(northPanel, BorderLayout.NORTH);
    }


    public void createWestPanelComponents() {

        labelCategory = new JLabel("Category");
        labelEmpty = new JLabel("");
        labelYear = new JLabel("Year");
        labelTo = new JLabel("to");
        labelTo2 = new JLabel("to");
        labelMileage = new JLabel("Mileage");
        labelOrLess = new JLabel("or less");
        labelPrice = new JLabel("Price");
        labelMake = new JLabel("Make");
        labelModel = new JLabel("Model");
        labelType = new JLabel("Type");
        labelSeatCount = new JLabel("Seat Count");
        JBSearch = new JButton("Search");
    }


    public void defineWestPanelComponents() throws FileNotFoundException {
        File yearFile = new File("YearItems.txt");
        Scanner scanner = new Scanner(yearFile);
        while(scanner.hasNextLine()){
            yearSetItems.add(scanner.nextLine());

        }

        File mileageFile = new File("MileageItems.txt");
        scanner = new Scanner(mileageFile);
        while(scanner.hasNextLine()){
            mileageSetItems.add(scanner.nextLine());
        }

        File minPriceFile = new File("MinPriceItems.txt");
        scanner = new Scanner(minPriceFile);
        while(scanner.hasNextLine()){
            minPriceFilterResults.add(scanner.nextLine());
        }

        File maxPriceFile = new File("MaxPriceItems.txt");
        scanner = new Scanner(maxPriceFile);
        while(scanner.hasNextLine()){
            maxPriceFilterResults.add(scanner.nextLine());
        }

        File makeFile = new File("MakeItems.txt");
        scanner = new Scanner(makeFile);
        while(scanner.hasNextLine()){
            makeSetItems.add(scanner.nextLine());
        }

        File typeFile = new File("TypeItems.txt");
        scanner = new Scanner(typeFile);
        while(scanner.hasNextLine()){
            typeSetItems.add(scanner.nextLine());
        }

        File seatFile = new File("SeatFile.txt");
        scanner = new Scanner(seatFile);
        while(scanner.hasNextLine()){
            seatCountItems.add(scanner.nextLine());
        }


        for (int i=0; i<inventory.getVehicles().size(); i++) {
            modelSetItems.add(inventory.getVehicle(i).getModel());
        }


        bottonNew = new JCheckBox("New");
        bottonUsed = new JCheckBox("Used");
        JCBYear1 = new JComboBox(yearSetItems.toArray());
        JCBYear2 = new JComboBox(yearSetItems.toArray());
        JCBMileage1 = new JComboBox(mileageSetItems.toArray());
        JCBPrice1 = new JComboBox(minPriceFilterResults.toArray());
        JCBPrice2 = new JComboBox(maxPriceFilterResults.toArray());
        JCBMake = new JComboBox(makeSetItems.toArray());
        JCBModel = new JComboBox(modelSetItems.toArray());
        JCBModel.addItem("--Please choose a preferred model");
        JCBType = new JComboBox(typeSetItems.toArray());
        JCBSeatCount = new JComboBox(seatCountItems.toArray());
    }


    public void buildWestPanel() {
        westLayout = new BoxLayout(westPanel, BoxLayout.Y_AXIS);
        westPanel.setLayout(westLayout);

        //adding filters
        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelCategory);
        westPanel.add(bottonNew);
        westPanel.add(bottonUsed);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelYear);
        westPanel.add(JCBYear1);
        westPanel.add(labelTo2);
        westPanel.add(JCBYear2);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelMileage);
        westPanel.add(JCBMileage1);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelPrice);
        westPanel.add(JCBPrice1);
        westPanel.add(labelTo);
        westPanel.add(JCBPrice2);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelModel);
        westPanel.add(JCBModel);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelMake);
        westPanel.add(JCBMake);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelType);
        westPanel.add(JCBType);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(labelSeatCount);
        westPanel.add(JCBSeatCount);

        westPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        westPanel.add(JBSearch);
        westPanel.setBorder(BorderFactory.createTitledBorder("Filter Results"));
        //this.addListeners(); test if collection works
		this.setActionListener();

        /*
        when the window is max, westScrollPanel will contain all filters(does not need to scroll down)
        with height of 764, the height may be changed when adding new filters
         */
        westPanel.setPreferredSize(new Dimension(300, 764));


        /*
        westPanelOut should be BorderLayout to make sure the filters wont collapse when there are too many
         */
        westPanelOut = new JPanel();
        westPanelOut.setLayout(new BorderLayout());
        westPanelOut.add(westPanel, BorderLayout.NORTH);
        westScrollPane = new JScrollPane(westPanelOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        westScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        getContentPane().add(westScrollPane, BorderLayout.WEST);
    }

    public void initializationWestPanelButtonCondition() {
        bottonNew.setSelected(true);
        bottonUsed.setSelected(true);
        JCBYear1.setSelectedIndex(JCBYear1.getItemCount()-1);
        JCBYear2.setSelectedIndex(JCBYear2.getItemCount()-1);
        JCBMileage1.setSelectedIndex(JCBMileage1.getItemCount()-1);
        JCBPrice1.setSelectedIndex(JCBPrice1.getItemCount()-1);
        JCBPrice2.setSelectedIndex(JCBPrice2.getItemCount()-1);
        JCBMake.setSelectedIndex(JCBMake.getItemCount()-1);
        JCBModel.setSelectedIndex(JCBModel.getItemCount()-1);
        JCBType.setSelectedIndex(JCBType.getItemCount()-1);
        JCBSeatCount.setSelectedIndex(JCBSeatCount.getItemCount()-1);

    }





    /*
    get user's filter search result and save it on filtercontent
    */
    public FilterContent getFilterValue() {
        FilterContent filtercontent = new FilterContent();
            //Category
			if(bottonNew.isSelected()) {
				filtercontent.setNeedNew(true);
			}
			else {
				filtercontent.setNeedUsed(false);
			}
			if(bottonUsed.isSelected()) {
				filtercontent.setNeedUsed(true);
			}
			else{
				filtercontent.setNeedUsed(false);
			}
            //Make
			filtercontent.setMake((String)JCBMake.getSelectedItem());
            //Model
			filtercontent.setModel((String)JCBModel.getSelectedItem());
            //Type
			filtercontent.setType((String)JCBType.getSelectedItem());
            //year
            //start year
			filtercontent.setLowYear((String)JCBYear1.getSelectedItem());
            //end year
            filtercontent.setHighYear((String)JCBYear2.getSelectedItem());
            //price
            //start price
            filtercontent.setLowPrice((String)JCBPrice1.getSelectedItem());
            //end price
            filtercontent.setHighPrice((String)JCBPrice2.getSelectedItem());
            //Mileage
            filtercontent.setMileage((String)JCBMileage1.getSelectedItem());
            //Seat Count
            filtercontent.setSeatCount((String)JCBSeatCount.getSelectedItem());
            //verify year filer validation
			if(filtercontent.isValidate()){
				return filtercontent;
			}
			else {
				if(filtercontent.yearValidate && !filtercontent.priceValidate){
					this.PriceErrorMessage();
				}
				else if(!filtercontent.yearValidate && filtercontent.priceValidate){
					this.YearErrorMessage();
				}
				else {
					this.YearErrorMessage();
					this.PriceErrorMessage();
				}
			}
			return new FilterContent();
    }
    //show YearErrorMessage if year range is not valid
    public void YearErrorMessage() {
        String message=" Please enter a valid year range!";
        JOptionPane.showMessageDialog(new JFrame(), message,"Dialog",JOptionPane.INFORMATION_MESSAGE);
    }
    //show PriceErrorMessage if price range is not valid
    public void PriceErrorMessage() {
        String message=" Please enter a valid price range!";
        JOptionPane.showMessageDialog(new JFrame(), message,"Dialog",JOptionPane.INFORMATION_MESSAGE);
    }
    
    //add actionListener to JBSearch
    public void setActionListener() {

        JBSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FilterContent searchResult = getFilterValue();
				category=searchResult.getCategory();
                min_year = searchResult.getLowYear();
				max_year = searchResult.getHighYear();
				max_mileage = searchResult.getMileage();
				min_price = searchResult.getLowPrice().replace("$","").replace(",","");
				max_price = searchResult.getHighPrice().replace("$","").replace(",","");
				model=searchResult.getModel();
				make=searchResult.getMake();
				type=searchResult.getType();
				seat_count=searchResult.getSeatCount();
                InventorySearcherImplement inventorySearcherImplement = new InventorySearcherImplement();
				tempVehicles = inventorySearcherImplement.search_inventory(vehiclesCollection,searchResult.needNew , searchResult.needUsed, min_year, max_year, max_mileage, min_price, max_price, model, make, type, seat_count);
				showResults(tempVehicles);
            }
        });

        JCBSortBy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Vehicle> sortedinventory = new ArrayList<>();
                vehicleServices vs = new vehicleServices();
                if (JCBSortBy.getSelectedItem().equals("Price: Lowest")) {
                    //TODO: need to use backend vehicleService package to get vehicleServiceSort Imp and SortType
					System.out.println("selected");
                    sortedinventory = vs.Sort(1, tempVehicles);
                } else if (JCBSortBy.getSelectedItem().equals("Price: Highest")) {
                    sortedinventory = vs.Sort(2, tempVehicles);
                } else if (JCBSortBy.getSelectedItem().equals("Year: Newest")) {
                    sortedinventory = vs.Sort(3, tempVehicles);
                } else if (JCBSortBy.getSelectedItem().equals("Year: Oldest")) {
                    sortedinventory = vs.Sort(4, tempVehicles);
                } else if (JCBSortBy.getSelectedItem().equals("Mileage: Lowest")) {
                    sortedinventory = vs.Sort(5, tempVehicles);
                } else if (JCBSortBy.getSelectedItem().equals("Mileage: Highest")) {
                    sortedinventory = vs.Sort(6, tempVehicles);
                } /*else if (JCBSortBy.getSelectedItem().equals("Distance: Nearest(Default)")) {
                    sortedinventory = vehicleService.Sort(SortType.DISTANCE_ASC, inventory);
                }
*/
                showResults(sortedinventory);
            }
        });

        /*JBBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //TODO define what OlderFrame we want to show
                    new OlderFrame().setVisible(true);
                } catch (IOException e1) {
                    System.out.println("Error in Going to Home");
                    e1.printStackTrace();
                }
                dispose();
            }
        });*/
    }


    public void buildCentralPanel() {
        this.centerPanel.setBorder(BorderFactory.createTitledBorder("Results"));
        //centerPanel.setPreferredSize(new Dimension(getWidth(),764));
        this.centerPanel.setLayout(new BoxLayout(this.centerPanel, BoxLayout.Y_AXIS));

        this.centerPanelOut = new JPanel();
        this.centerPanelOut.setLayout(new BorderLayout());
        this.centerPanelOut.add(this.centerPanel, BorderLayout.NORTH);
        this.centerScrollPane = new JScrollPane(this.centerPanelOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.centerScrollPane.getVerticalScrollBar().setUnitIncrement(15);
        getContentPane().add(this.centerScrollPane, BorderLayout.CENTER);
    }

    //Show results in centerPanel
    private void showResults(ArrayList<Vehicle> vehiclesCollection){
        this.centerPanel.removeAll();
        for(int i=0; i<vehiclesCollection.size(); i++){
            ResultPanel resultPanel = new ResultPanel(vehiclesCollection.get(i).getVehicleId() + ".jpeg");
            resultPanel.resultYear.setText(resultPanel.resultYear.getText() + vehiclesCollection.get(i).getYear());
            resultPanel.resultMileage.setText(resultPanel.resultMileage.getText() + vehiclesCollection.get(i).getMileage());
            resultPanel.resultMake.setText(resultPanel.resultMake.getText() + vehiclesCollection.get(i).getMake());
            resultPanel.resultPrice.setText(resultPanel.resultPrice.getText() + vehiclesCollection.get(i).getPrice());
            resultPanel.vehicleID.setText(vehiclesCollection.get(i).getVehicleId());
            this.centerPanel.add(resultPanel);
        }
        this.centerPanel.revalidate();
    }

    public void defineSouthPanelComponents() {
        JBBack = new JButton("Back");
    }

    public void buildSouthPanel() {
        southPanel.add(JBBack);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
        getContentPane().setVisible(true);
    }

    public static void main(String[] args) throws FileNotFoundException {
        InventorySearch is = new InventorySearch("D10");
        is.setVisible(true);
    }

}

//This class is to show results in centerPanel
class ResultPanel extends JPanel{

    ImageIcon imageIcon;
    Image image;
    JLabel resultPrice, resultLocation, resultMake, resultYear, resultMileage, resultCondition, vehicleID;
    JButton checkButton;
    String imagePath;
    ResultPanel(String imagePath) {
        this.showImage(imagePath);
        this.showInfo();
    }

    private void showImage(String imagePath){
        this.imagePath = imagePath;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.imageIcon = new ImageIcon(imagePath);
        this.image = this.imageIcon.getImage();
        Image newImage = this.image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        this.imageIcon = new ImageIcon(newImage);
        JLabel jLabel = new JLabel(this.imageIcon);
        this.add(jLabel);
        this.setBorder(BorderFactory.createEmptyBorder(10,0,10,10));
    }

    private void showInfo(){
        this.createComponents();
        this.addComponents();
        this.addListeners();
    }

    private void createComponents(){
        this.setBorder(BorderFactory.createTitledBorder(""));
        this.checkButton = new JButton("Check Availability");
        this.resultCondition = new JLabel("Condition: ");
        this.resultLocation = new JLabel("Location: ");
        this.resultMake = new JLabel("Make: ");
        this.resultMileage = new JLabel("Mileage: ");
        this.resultYear = new JLabel("Year: ");
        this.resultPrice = new JLabel("Price: ");
        this.vehicleID = new JLabel();
        this.checkButton.setPreferredSize(new Dimension(200,50));
        this.resultPrice.setPreferredSize(new Dimension(100,50));
        this.resultLocation.setPreferredSize(new Dimension(150,50));
        this.resultMileage.setPreferredSize(new Dimension(150,50));
        this.resultCondition.setPreferredSize(new Dimension(150,50));
        this.resultYear.setPreferredSize(new Dimension(100,50));
        this.resultMake.setPreferredSize(new Dimension(100,50));
    }

    private void addComponents(){
        this.add(this.resultPrice);
        this.add(this.resultCondition);
        this.add(this.resultMake);
        this.add(this.resultYear);
        this.add(this.resultMileage);
        this.add(this.resultLocation);
        this.add(this.checkButton);
    }

    protected void removeCheckButton(){
        this.remove(this.checkButton);
    }

    private void addListeners(){
        this.checkButton.addActionListener((e -> {DetailTest detailTest = new DetailTest(this);}));
    }
}

//This class is for test only
class DetailTest extends JFrame{
    ResultPanel carDetail;
    DetailTest(ResultPanel result){
        this.showDetail(result);
    }

    private void showDetail(ResultPanel result){
        this.setTitle(result.vehicleID.getText());
        this.setSize(400,300);
        this.setLocation(790,380);
        this.carDetail = new ResultPanel(result.imagePath);
        this.carDetail.resultPrice.setText(result.resultPrice.getText());
        this.carDetail.resultCondition.setText(result.resultCondition.getText());
        this.carDetail.vehicleID.setText(result.vehicleID.getText());
        this.carDetail.resultMake.setText(result.resultMake.getText());
        this.carDetail.resultLocation.setText(result.resultLocation.getText());
        this.carDetail.resultMileage.setText(result.resultMileage.getText());
        this.carDetail.resultYear.setText(result.resultYear.getText());
        this.carDetail.add(this.carDetail.vehicleID);
        this.carDetail.removeCheckButton();
        this.add(this.carDetail);
        this.setVisible(true);
    }
}

//This class is for temporarily sorting
class vehicleServices{
	static ArrayList<Vehicle> Sort(int sortMode, ArrayList<Vehicle> vehicles){
		if(sortMode == 1){
			for(int i = 0; i<vehicles.size()-1; i++){
				for(int j = i+1; j<vehicles.size(); j++){
					if(Double.valueOf(vehicles.get(i).getPrice().replace("$","").replace(",",
							""))>Double.valueOf(vehicles.get(j).getPrice().replace("$","")
							.replace(",",""))){
						Collections.swap(vehicles,i,j);
					}
				}
			}
		}
		else if(sortMode == 2){
			for(int i = 0; i<vehicles.size()-1; i++){
				for(int j = i+1; j<vehicles.size(); j++){
					if(Double.valueOf(vehicles.get(i).getPrice().replace("$","").replace(",",
							""))<Double.valueOf(vehicles.get(j).getPrice().replace("$","")
							.replace(",",""))){
						Collections.swap(vehicles,i,j);
					}
				}
			}
		}
		else if(sortMode == 3){
			for(int i = 0; i<vehicles.size()-1; i++){
				for(int j = i+1; j<vehicles.size(); j++){
					if(Double.valueOf(vehicles.get(i).getYear())<Double.valueOf(vehicles.get(j).getYear())){
						Collections.swap(vehicles,i,j);
					}
				}
			}
		}
		else if(sortMode == 4){
			for(int i = 0; i<vehicles.size()-1; i++){
				for(int j = i+1; j<vehicles.size(); j++){
					if(Double.valueOf(vehicles.get(i).getYear())>Double.valueOf(vehicles.get(j).getYear())){
						Collections.swap(vehicles,i,j);
					}
				}
			}
		}
		else if(sortMode == 5){
			for(int i = 0; i<vehicles.size()-1; i++){
				for(int j = i+1; j<vehicles.size(); j++){
					if(Double.valueOf(vehicles.get(i).getMileage().replace(",",""))>Double.valueOf
							(vehicles.get(j).getMileage().replace(",",""))){
						Collections.swap(vehicles,i,j);
					}
				}
			}
		}
		else if(sortMode == 6){
			for(int i = 0; i<vehicles.size()-1; i++){
				for(int j = i+1; j<vehicles.size(); j++){
					if(Double.valueOf(vehicles.get(i).getMileage().replace(",",""))<Double.valueOf
							(vehicles.get(j).getMileage().replace(",",""))){
						Collections.swap(vehicles,i,j);
					}
				}
			}
		}


		return vehicles;
	}
}