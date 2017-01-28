package chinook.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chinook.entity.Shipper;
import chinook.service.ShipperServices;


@Named
@RequestScoped
public class ViewShipperController {
	
	@Inject
	private ShipperServices shipperService;
	
	public List<Shipper> getAllArtists() {
		return shipperService.findAllOrderByName();
	}
	
}