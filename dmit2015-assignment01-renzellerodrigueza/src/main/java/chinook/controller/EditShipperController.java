package chinook.controller;

import java.io.Serializable;

import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import chinook.entity.Shipper;
import chinook.service.ShipperServices;;

@Named
@ViewScoped
public class EditShipperController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ShipperServices shipperService;
	private int shipperId;
	private Shipper currentShipper;
	
	
	public int getShipperId() {
		return shipperId;
	}

	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}

	public Shipper getCurrentShipper() {
		return currentShipper;
	}

	public void setCurrentShipper(Shipper currentShipper) {
		this.currentShipper = currentShipper;
	}

	
	public void findShipperById() {
		if (shipperId <= 0) {
			Messages.addGlobalError("Bad request. Please use a link within the system");
			return;
		}
		
		Shipper queryResult = shipperService.findOneById(shipperId);
		if ( queryResult == null ) {
			Messages.addGlobalError("Bad request. Unknown Shipper ID {0}", shipperId);
			return;
		}
		
		currentShipper = queryResult;		
	}
	
	public String updateShipper() {
		shipperService.update(currentShipper);
		currentShipper = null;
		Messages.addFlashGlobalInfo("Updated was successful.");

		return "/public/viewShippers?faces-redirect=true";
	}
	
	public String removeShipper() {
		String outcome = "/public/viewShippers?faces-redirect=true";
		try {
			shipperService.delete(currentShipper);
			currentShipper = null;
			Messages.addFlashGlobalInfo("Delete was successful.");
		} catch (EJBTransactionRolledbackException e) {
			Messages.addGlobalError("This category cannot be deleted.");
			outcome = null;
		} catch (Exception e) {
			Messages.addGlobalError("Delete was not successful.");
			outcome = null;
		}
		return outcome;
	}
	
	public String cancel() {
		currentShipper = null;
		return "/public/viewShippers?faces-redirect=true";
	}
}
