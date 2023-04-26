
/**
 * PrintBill.java
 * The Print Bill class
 *
 * @Author CTS Unique Touch Pro
 * @Version v1.0 05th April 2022
 * @Date April 05, 2022
 */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class PrintGuestBill {
    String bookingNo, bookingDate, checkinDate, checkoutDate, roomType,
            roomNo, bookingStatus, guestNo, billToGuestNo, guestName, billToGuestName,
            bpaid;
    String staffReceptionistNo, staffReceptionistName, billNo, billDate,
            billStatus, chargeNo, chargeDate, serviceType, serviceNote;
    String name, phone, email, password, role;
    Boolean paid;
    Double quantity, unitPrice, lineTotal = 0.0, billTotal = 0.0;

    public void printGuestBill(String bookingNo) throws Exception {

        // Protected Java Database Connection
        DatabaseAccess da = new DatabaseAccess();

        try {
            // Decalare the name and file path
            String fileName = "bills/GuestBill.txt";

            // Set file printing parameters
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            // Bill Header
            pw.println();
            pw.println();
            StringAlignUtils util = new StringAlignUtils(100,
                    StringAlignUtils.Alignment.CENTER);
            pw.println(util.format("IMPERIAL HOTEL INC."));
            pw.println(util.format("Lord Street, San Fernando"));
            pw.println(util.format("Come in as guests. Leave as family."));
            pw.println();
            pw.println();

            // Get Booking data from the database
            String query = "SELECT * FROM BOOKING WHERE BookingNo = ?";
            da.ps = da.con.prepareStatement(query);
            da.ps.setString(1, bookingNo);
            da.rst = da.ps.executeQuery();

            while (da.rst.next()) {
                bookingNo = da.rst.getString(1);
                bookingDate = da.rst.getString(2);
                checkinDate = da.rst.getString(3);
                checkoutDate = da.rst.getString(4);
                roomType = da.rst.getString(5);
                roomNo = da.rst.getString(6);
                bookingStatus = da.rst.getString(7);
                guestNo = da.rst.getString(8);
                billToGuestNo = da.rst.getString(9);
                staffReceptionistNo = da.rst.getString(10);
                paid = da.rst.getBoolean(11);
            }

            // Display Guest Name on the bill
            query = "SELECT Name FROM GUEST WHERE GuestNo = ?";
            da.ps = da.con.prepareStatement(query);
            da.ps.setString(1, guestNo);
            da.rst = da.ps.executeQuery();
            while (da.rst.next()) {
                guestName = da.rst.getString(1);
            }
            // Display BillTo Guest Name on the bill
            query = "SELECT Name FROM GUEST WHERE GuestNo = ?";
            da.ps = da.con.prepareStatement(query);
            da.ps.setString(1, billToGuestNo);
            da.rst = da.ps.executeQuery();

            while (da.rst.next()) {
                billToGuestName = da.rst.getString(1);
            }
            // Display Staff Name on the bill
            query = "SELECT Name FROM STAFF WHERE StaffNo = ?";
            da.ps = da.con.prepareStatement(query);
            da.ps.setString(1, staffReceptionistNo);
            da.rst = da.ps.executeQuery();

            while (da.rst.next()) {
                staffReceptionistName = da.rst.getString(1);
            }
            // Display Paid: Yes or No on the bill
            if (paid.equals(true))
                bpaid = "Yes";
            else
                bpaid = "No";

            // Display Booking info on Header of the text file
            pw.println(util.format("Booking Information"));

            pw.println(util.format("-------------------------------------------------------------------------------"));
            pw.println(String.format("%10s%-15s%-4s%-4s%-25s%-15s%-4s%-4s",
                    "", "Booking No", ": ", bookingNo, "", "Booking Date", ": ", bookingDate));
            pw.println(String.format("%10s%-15s%-4s%-4s%-19s%-15s%-4s%-4s",
                    "", "Checkin Date", ":", checkinDate, "", "Checkout Date", ": ",
                    checkoutDate));
            pw.println(String.format("%10s%-15s%-4s%-4s%-23s%-15s%-4s%-4s",
                    "", "Room Type", ":", roomType, "", "Room No", ": ", roomNo));
            pw.println(String.format("%10s%-15s%-4s%-4s%-15s%-10s%-15s%-4s%-4s%-4s", "", "Guest", ":", guestNo,
                    guestName, "", "Bill To", ": ",
                    billToGuestNo, billToGuestName));
            pw.println(String.format("%10s%-15s%-4s%-4s%-20s%-15s%-4s%-4s%-4s", "", "Booking Status", ":",
                    bookingStatus, "", "Receptionist", ": ",
                    staffReceptionistNo, staffReceptionistName));
            pw.println(String.format("%10s%-15s%-4s%-4s", "", "Paid", ":",
                    bpaid));
            pw.println();
            // Display Billing info on Header of the Text file
            pw.println(util.format("Billing Information"));

            pw.println(util.format("-------------------------------------------------------------------------------"));
            pw.println();
            query = "SELECT BillNo, BillDate, BillStatus, StaffNo FROM BILL WHERE BookingNo = ?";
            da.ps = da.con.prepareStatement(query);
            da.ps.setString(1, bookingNo);
            da.rst = da.ps.executeQuery();

            while (da.rst.next()) {
                billNo = da.rst.getString(1);
                billDate = da.rst.getString(2);
                billStatus = da.rst.getString(3);
                staffReceptionistNo = da.rst.getString(4);
            }

            // Display Staff Name on the bill
            query = "SELECT Name FROM STAFF WHERE StaffNo = ?";
            da.ps = da.con.prepareStatement(query);
            da.ps.setString(1, staffReceptionistNo);
            da.rst = da.ps.executeQuery();

            while (da.rst.next()) {
                staffReceptionistName = da.rst.getString(1);
            }
            pw.println(String.format("%10s%-15s%-4s%-4s%-25s%-15s%-4s%-4s",
                    "", "Bill No", ": ", billNo, "", "Bill Date", ": ", billDate));
            pw.println(String.format("%10s%-15s%-4s%-4s%-25s%-15s%-4s%-4s%-4s", "", "Bill Status", ": ", billStatus, "",
                    "Receptionist", ": ",
                    staffReceptionistNo, staffReceptionistName));
            pw.println();

            // Display Charges info on Body of the Text file
            pw.println(util.format("Bill Charges"));

            pw.println(util.format("-------------------------------------------------------------------------------"));
            pw.println(String.format("%10s%-5s%-13s%-13s%-40s%-10s%-12s%-10s", "", "No", "Date", "Service", "Details",
                    "Quantity", "Unit Price", "Ln Total"));
            pw.println();
            query = "SELECT ChargeNo, ChargeDate, ServiceType, ServiceNote, Quantity, UnitPrice FROM CHARGES WHERE BillNo = ?";
            da.ps = da.con.prepareStatement(query);
            da.ps.setString(1, billNo);
            da.rst = da.ps.executeQuery();
            while (da.rst.next()) {
                chargeNo = da.rst.getString(1);
                chargeDate = da.rst.getString(2);
                serviceType = da.rst.getString(3);
                serviceNote = da.rst.getString(4);
                quantity = da.rst.getDouble(5);
                unitPrice = da.rst.getDouble(6);
                lineTotal = quantity * unitPrice;
                billTotal = billTotal + lineTotal;

                pw.println(String.format("%10s%-5s%-13s%-13s%-41s%5s%13s %13s", "", chargeNo, chargeDate, serviceType,
                        serviceNote, quantity,
                        String.format("%7.2f", unitPrice), String.format("%,.2f", lineTotal)));
            }

            pw.println(String.format("%81s%13s", "", "------------"));
            pw.println(String.format("%87s%13s%13s", "", "Bill Total",
                    String.format("%,.2f", billTotal)));
            pw.println(String.format("%81s%13s", "", "------------"));
            pw.println();
            pw.println(util.format("Thank you for your business"));
            pw.println(util.format("Hope you enjoyed your stay"));
            pw.println(util.format("Please come again!!!"));

            new ProcessBuilder("notepad", fileName).start();
            pw.flush();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
