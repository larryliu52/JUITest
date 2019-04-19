package finalprojectgroup2test2;


import static finalprojectgroup2test2.InventorySearchBuild.*;

public class FilterContent {
	private String category;
	private String make; 
	private String model;
	private String type;
	
	private String mileage;
	private String seatCount;
	
	private String highPrice;
	private String lowPrice; 
	private String highYear;
	private String lowYear;
	boolean needNew, needUsed;
	boolean yearValidate = false, priceValidate = false;
	public FilterContent() {
			this.lowPrice = "";
			this.highPrice = "";
			this.lowYear = "";
			this.highYear = "";
			this.make = "";
			this.model = "";
			this.type = "";
			this.mileage = "";
			this.seatCount = "";
			this.category = "";

			this.needUsed = true;
			this.needNew = true;
		}
	
	//category
	public String getCategory() {
	return category;
		}
	public void setNeedNew(boolean category) { this.needNew = category; }
	public void setNeedUsed(boolean category){ this.needUsed = category;}
	
	//make
	public String getMake(){
	return make;
		}
	public void setMake(String make) {
	this.make = make;
		}
	
	//model
	public String getModel(){
	return model;
		}
	public void setModel(String model) {
	this.model = model;
		}
	
	//type
	public String getType(){
	return type;
		}
	public void setType(String type) {
	this.type = type;
		}
	
	//highPrice
	public String getHighPrice() {
	return highPrice;
		}
	public void setHighPrice(String highPrice) {
	this.highPrice = highPrice;
		}
	
	//lowPrice
	public String getLowPrice() {
	return lowPrice;
		}
	public void setLowPrice(String lowPrice) {
	this.lowPrice = lowPrice;
		}
	
	//highYeat
	public String getHighYear() {
	return highYear;
		}
	public void setHighYear(String highYear) {
	this.highYear = highYear;
		}
	
	//lowYear
	public String getLowYear() {
	return lowYear;
		}
	public void setLowYear(String lowYear) {
	this.lowYear = lowYear;
		}
	
	//mileage
	public String getMileage() {
	return mileage;
		}
	public void setMileage(String mileage) {
	this.mileage = mileage;
		}
	
	//seatCount
	public String getSeatCount() {
	return seatCount;
		}
	public void setSeatCount(String seatCount) {
	this.seatCount = seatCount;
		}

	@Override
	public String toString() {
		return getLowYear()+"\n"+getHighYear()+"\n"+getLowPrice()+"\n"+getHighPrice()+"\n"+"\n"+getMake()+"\n"+getMileage()+"\n"+getModel();
	}

	public boolean isValidate(){
		if(this.getHighYear().equals(yearSetItems.get(yearSetItems.size()-1))) {
		}
		else{
			int startYear=Integer.valueOf(this.getLowYear());
			int endYear=Integer.valueOf(this.getHighYear());
			if (startYear > endYear) {
				this.yearValidate = false;
			}
			else
				this.yearValidate = true;
		}

		//verify price filter validation
		if(this.getHighPrice().equals(maxPriceFilterResults.get(maxPriceFilterResults.size()-1))||this.getLowPrice()
				.equals(minPriceFilterResults.get(minPriceFilterResults.size()-1))) {
			this.priceValidate = false;
		}
		else{
			double startPrice = Double.valueOf(this.getLowPrice().replace("$","").replace(",",""));
			double endPrice = Double.valueOf(this.getHighPrice().replace("$","").replace(",",""));
			if (startPrice > endPrice) {
				this.priceValidate = false;
			}
			else
				this.priceValidate = true;
		}

		//verify mileage filter validation
		if(this.getMileage().equals(mileageSetItems.get(mileageSetItems.size()-1))) {
			this.mileage = "";
		}

		if(this.getMake().equals(makeSetItems.get(makeSetItems.size()-1))) {
			this.make = "";
		}

		if(this.getSeatCount().equals(seatCountItems.get(seatCountItems.size()-1))) {
			this.seatCount = "";
		}

		if(this.getType().equals(typeSetItems.get(typeSetItems.size()-1))) {
			this.type = "";
		}

		if(this.getModel().equals("--Please choose a preferred model")) {
			this.model = "";
		}

		if(this.priceValidate && this.yearValidate){
			System.out.println(true);
			return true;
		}
		else {
			System.out.println(false);
			return false;
		}
	}
}
