package com.example.spedox_mobile;

import com.example.spedox_mobile.enums.DocumentStatusEnum;
import com.example.spedox_mobile.enums.DocumentTypeEnum;
import com.example.spedox_mobile.models.DocumentModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DocumentModelTest {

    private DocumentModel documentModel;

    @Before
    public void setUp() {
        // Create a sample DocumentModel object for testing
        String fileName = "document.pdf";
        DocumentStatusEnum documentStatus = DocumentStatusEnum.APPROVED;
        DocumentTypeEnum documentType = DocumentTypeEnum.INVOICE;

        documentModel = new DocumentModel(fileName, documentStatus, documentType);
    }

    @Test
    public void testGetFileName() {
        String fileName = documentModel.getFileName();
        Assert.assertEquals("document.pdf", fileName);
    }

    @Test
    public void testGetDocumentStatus() {
        DocumentStatusEnum documentStatus = documentModel.getDocumentStatus();
        Assert.assertEquals(DocumentStatusEnum.APPROVED, documentStatus);
    }

    @Test
    public void testGetDocumentType() {
        DocumentTypeEnum documentType = documentModel.getDocumentType();
        Assert.assertEquals(DocumentTypeEnum.INVOICE, documentType);
    }
}
