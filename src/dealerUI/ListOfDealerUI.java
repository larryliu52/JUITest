
	package dealerUI;

	import UI.InventorySearch;
	import dto.Dealer;
import searchDealerLogic.SearchDealerResult;

import java.awt.Container;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

	public class ListOfDealerUI extends JFrame{
		
		public JFrame frame;
		private JButton clickForDetails;
		private Container c;
		private ArrayList<Dealer> dlist = new ArrayList<>();
		private List<SingleDealerPanelUI> slist = new ArrayList<>();
		public ListOfDealerUI(ArrayList<Dealer> dealers) {
			
		  	dlist = dealers;

				
			createComponents();
			setLayout();
			addComponents();
			addListeners();
			display();
		}
		
		private void display() {
			
			frame.setSize(800, 700);
			frame.setVisible(true);
			clickForDetails.setSize(10, 10);
		}

		private void addComponents() {
			frame.setTitle("List Of Dealers");
			
			for (int i = 0; i < dlist.size(); i++) {
				SingleDealerPanelUI singleDealerPanelUI = new SingleDealerPanelUI(dlist.get(i));
		         c.add(singleDealerPanelUI);
		         slist.add(singleDealerPanelUI);
		    }
			
			c.add(clickForDetails);
		}

		private void setLayout() {
			
			GridLayout gl = new GridLayout(7,2);
			c = frame.getContentPane();
			c.setLayout(gl);
			
		}

		private void createComponents() {
			frame = new JFrame();
			c = new Container();
			clickForDetails = new JButton("Click For Details");
			
		}

		private void addListeners(){
			clickForDetails.addActionListener(e -> {
				for(int i=0; i<slist.size() ;i++){
					if(slist.get(i).radioButton3.isSelected()){
						try {
							InventorySearch inventorySearch = new InventorySearch(dlist.get(i).getId());
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
	}

	

