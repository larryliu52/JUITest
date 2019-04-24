package dto;

import java.util.Collection;

public class Inventory {

	/*public Inventory(String dealerId){
		this.dealerId = dealerId;
	}*/

	private String vehicleId;
	
	private String dealerId;

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}
}
