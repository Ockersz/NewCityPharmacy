package Controller;

import Model.Prescription;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;

public class PrescriptionController {

    public boolean uploadPrescription(int customerId, List<Path> imageFile) {
        Prescription obj = new Prescription();
        return obj.uploadPrescription(customerId, imageFile);
    }

    public List<Prescription> getPrescriptionDetail(int customerId) {

        Prescription obj = new Prescription();
        return obj.getPrescriptionDetails(customerId);
    }

    public List<ImageIcon> getPrescriptionImages(int prescriptionId) {

        Prescription obj = new Prescription();
        return obj.getPrescriptionImages(prescriptionId);
    }

    public List<Prescription> getPrescriptionDetail() {
        Prescription obj = new Prescription();
        return obj.getPrescriptionDetails();
    }

    public List<Prescription> getPendingPrescriptionDetails() {
        Prescription obj = new Prescription();
        return obj.getPendingPrescriptionDetails();
    }

    public List<Prescription> getRejectedPrescriptionDetails() {
        Prescription obj = new Prescription();
        return obj.getRejectedPrescriptionDetails();
    }

    public Date getPresDate(int prescriptionId) {
        Prescription obj = new Prescription();
        return obj.getPresDate(prescriptionId);
    }

    public int getCusName(int prescriptionId) {
        Prescription obj = new Prescription();
        return obj.getCusName(prescriptionId);
    }

    public int getCustomerId(int prescriptionId) {
        Prescription obj = new Prescription();
        return obj.getCustomerId(prescriptionId);
    }

    public boolean confirmPrescription(int prescriptionId) {
        Prescription obj = new Prescription();
        return obj.confirmPrescription(prescriptionId);
    }

    public boolean rejectPrescription(int prescriptionId) {
        Prescription obj = new Prescription();
        return obj.rejectPrescription(prescriptionId);
    }

    public String getPrescriptionStatus(int prescriptionId) {
        Prescription obj = new Prescription();
        return obj.getPrescriptionStatus(prescriptionId);
    }
}
