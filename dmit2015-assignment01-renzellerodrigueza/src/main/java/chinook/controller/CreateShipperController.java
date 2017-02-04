package chinook.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import chinook.entity.Shipper;
import chinook.service.ShipperServices;


@Named
@ViewScoped
public class CreateShipperController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ShipperServices shipperService;
	
	private Shipper currentShipper = new Shipper();
	
	public void createShipper() {
		shipperService.add(currentShipper);
		currentShipper = new Shipper();
		Messages.addGlobalInfo("Successfully created new Shipper");
	}

	public Shipper getCurrentShipper() {
		return currentShipper;
	}

	public void setCurrentShipper(Shipper currentShipper) {
		this.currentShipper = currentShipper;
	}


	

}
