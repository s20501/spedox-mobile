package com.example.spedox_mobile;

import com.example.spedox_mobile.enums.IcotermsEnum;
import com.example.spedox_mobile.enums.ShipmentDirectionEnum;
import com.example.spedox_mobile.enums.ShipmentStatusEnum;
import com.example.spedox_mobile.enums.ShipmentTypeEnum;
import com.example.spedox_mobile.models.ClientModel;
import com.example.spedox_mobile.models.DocumentModel;
import com.example.spedox_mobile.models.ShipmentModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShipmentModelTest {

    private ShipmentModel shipmentModel;

    @Before
    public void setUp() {
        // Create a sample ShipmentModel object for testing
        String id = "123456";
        List<DocumentModel> documents = new ArrayList<>();
        ShipmentStatusEnum status = ShipmentStatusEnum.SHIPMENT_DELIVERED;
        String blNumber = "BL123456";
        ClientModel clientModel = new ClientModel();
        ClientModel shipper = new ClientModel();
        ClientModel consignee = new ClientModel();
        ShipmentDirectionEnum direction = ShipmentDirectionEnum.IMPORT;
        IcotermsEnum icoterms = IcotermsEnum.DELIVERED_AT_PLACE;
        String portOfLoading = "Port A";
        Date loadingDate = new Date();
        String portOfDestination = "Port B";
        Date destinationDate = new Date();
        ShipmentTypeEnum type = ShipmentTypeEnum.LESS_THAN_CONTAINER_LOAD;
        String value = "1000";
        String valueCurrency = "USD";
        boolean insurance = true;

        shipmentModel = new ShipmentModel(
                id, documents, status, blNumber, clientModel, shipper, consignee, direction, icoterms,
                portOfLoading, loadingDate, portOfDestination, destinationDate, type, value, valueCurrency, insurance
        );
    }

    @Test
    public void testGetDocuments() {
        List<DocumentModel> documents = shipmentModel.getDocuments();
        Assert.assertNotNull(documents);
        Assert.assertEquals(0, documents.size());
    }

    @Test
    public void testGetStatus() {
        ShipmentStatusEnum status = shipmentModel.getStatus();
        Assert.assertEquals(ShipmentStatusEnum.SHIPMENT_DELIVERED, status);
    }

    @Test
    public void testGetBlNumber() {
        String blNumber = shipmentModel.getBlNumber();
        Assert.assertEquals("BL123456", blNumber);
    }

    // Add more test methods for other getters and constructor parameters

    @Test
    public void testIsInsurance() {
        boolean hasInsurance = shipmentModel.isInsurance();
        Assert.assertTrue(hasInsurance);
    }
}