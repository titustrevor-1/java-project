package personal.project;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author titus
 */
public class rooms extends javax.swing.JFrame {
    private java.util.List<Object[]> roomList = new java.util.ArrayList<>();
    private int currentIndex = -1;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(rooms.class.getName());


    /**
     * Creates new form rooms
     */
    public rooms() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("ROOMS");
    }
    private void loadRooms() {
        roomList.clear();
        String sql = "SELECT room_id, room_number, room_type_id, status_id, floor_number FROM rooms";

        try (java.sql.Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {
while (rs.next()) {
                roomList.add(new Object[]{
                    rs.getInt("room_id"),
                    rs.getString("room_number"),
                    rs.getInt("room_type_id"),
                    rs.getInt("status_id"),
                    rs.getInt("floor_number")
                });
            }
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
private void showRecord(int index) {
    if (roomList.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No records found.");
        return;
    }
    if (index < 0) index = 0;
    if (index >= roomList.size()) index = roomList.size() - 1;
    currentIndex = index;

    Object[] record = roomList.get(currentIndex);
    txtRoomID.setText(String.valueOf(record[0]));
    txtRoomNumber.setText((String) record[1]);
    txtRoomTypeID.setText(String.valueOf(record[2]));
    txtRoomstatus.setText(String.valueOf(record[3]));
    txtFloorNumber.setText(String.valueOf(record[4]));

}
private void clearFields() {
    txtRoomID.setText("");
    txtRoomNumber.setText("");
    txtRoomTypeID.setText("");
    txtRoomstatus.setText("");
    txtFloorNumber.setText("");
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrevious = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        txtRoomNumber = new javax.swing.JTextField();
        txtRoomID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtRoomTypeID = new javax.swing.JTextField();
        txtRoomstatus = new javax.swing.JTextField();
        txtFloorNumber = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPrevious.setText("PREVIOUS");
        btnPrevious.addActionListener(this::btnPreviousActionPerformed);

        btnFind.setText("FIND");
        btnFind.addActionListener(this::btnFindActionPerformed);

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        btnExit.setText("EXIT");
        btnExit.addActionListener(this::btnExitActionPerformed);

        btnSave.setText("SAVE");
        btnSave.addActionListener(this::btnSaveActionPerformed);

        btnFirst.setText("FIRST");
        btnFirst.addActionListener(this::btnFirstActionPerformed);

        btnLast.setText("LAST");
        btnLast.addActionListener(this::btnLastActionPerformed);

        btnNext.setText("NEXT");
        btnNext.addActionListener(this::btnNextActionPerformed);

        txtRoomID.addActionListener(this::txtRoomIDActionPerformed);

        jLabel1.setText("Room ID");

        jLabel2.setText("Room Number");

        jLabel3.setText("Room TypeID");

        jLabel4.setText("Room Status");

        jLabel5.setText("Floor Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFloorNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                    .addComponent(txtRoomstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRoomTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnPrevious)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnFind)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDelete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnExit))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSave)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnFirst)
                            .addGap(18, 18, 18)
                            .addComponent(btnLast)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnNext)
                            .addGap(1, 1, 1)))
                    .addContainerGap(138, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRoomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtFloorNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRoomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRoomTypeID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRoomstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(214, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(290, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSave)
                        .addComponent(btnFirst)
                        .addComponent(btnLast)
                        .addComponent(btnNext))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrevious)
                        .addComponent(btnFind)
                        .addComponent(btnDelete)
                        .addComponent(btnExit))
                    .addGap(46, 46, 46)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (roomList.isEmpty()) {
        loadRooms();
    }
        showRecord(currentIndex - 1);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
         String roomNumber = txtRoomNumber.getText().trim();
        if (roomNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a room number to search");
            txtRoomNumber.requestFocus();
            return;
        }

        String sql = "SELECT room_id, room_number, room_type_id, status_id, floor_number FROM rooms WHERE room_number = ?";
        try (java.sql.Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, roomNumber);
            try (java.sql.ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
    txtRoomID.setText(String.valueOf(rs.getInt("room_id")));
    txtRoomNumber.setText(rs.getString("room_number"));
    txtRoomTypeID.setText(String.valueOf(rs.getInt("room_type_id")));
    txtRoomstatus.setText(String.valueOf(rs.getInt("status_id")));
    txtFloorNumber.setText(String.valueOf(rs.getInt("floor_number")));
} else {
    JOptionPane.showMessageDialog(this, "No room found with that room number.");
}
            }
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

        String roomNumber = txtRoomNumber.getText().trim();

        if (roomNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the room number to delete");
            txtRoomNumber.requestFocus();
            return;
        }

        String checkSql = "SELECT COUNT(*) FROM rooms WHERE room_number = ?";
        try (java.sql.Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {

            checkStmt.setString(1, roomNumber);
            try (java.sql.ResultSet rs = checkStmt.executeQuery()) {
                rs.next();
                if (rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(this, "No room found with that room number.");
                    return;
                }
            }
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this room?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String deleteSql = "DELETE FROM rooms WHERE room_number = ?";
        try (java.sql.Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {

            deleteStmt.setString(1, roomNumber);
            int rows = deleteStmt.executeUpdate();

            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Deleted successfully!");
                clearFields();
                loadRooms();
                currentIndex = -1;
            } else {
                JOptionPane.showMessageDialog(this, "No matching record found.");
            }

        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this,
                "Cannot delete: this room has related records (e.g. bookings, housekeeping).",
                "Delete Blocked", JOptionPane.WARNING_MESSAGE);
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
        
    }
    
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
    
       String roomNumber = txtRoomNumber.getText().trim();
       String roomTypeIdStr = txtRoomTypeID.getText().trim();
       String statusIdStr = txtRoomstatus.getText().trim();
       String floorNumberStr = txtFloorNumber.getText().trim();

if (roomNumber.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Enter the room number");
    txtRoomNumber.requestFocus();
    return;
}
if (roomTypeIdStr.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Enter the room type ID");
    txtRoomTypeID.requestFocus();
    return;
}
if (statusIdStr.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Enter the status ID");
    txtRoomstatus.requestFocus();
    return;
}
if (floorNumberStr.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Enter the floor number");
    txtFloorNumber.requestFocus();
    return;
}

        int roomTypeId, statusId, floorNumber;
        try {
            roomTypeId = Integer.parseInt(roomTypeIdStr);
            statusId = Integer.parseInt(statusIdStr);
            floorNumber = Integer.parseInt(floorNumberStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Room Type ID, Status ID, and Floor Number must be numbers.");
            return;
        }

        String sql = "INSERT INTO rooms (room_number, room_type_id, status_id, floor_number) VALUES (?, ?, ?, ?)";
        try (java.sql.Connection conn = DatabaseConnection.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, roomNumber);
            stmt.setInt(2, roomTypeId);
            stmt.setInt(3, statusId);
            stmt.setInt(4, floorNumber);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Room saved successfully!");
            clearFields();
            loadRooms();
            currentIndex = -1;

        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(this,
                "That room number already exists, or the Room Type ID / Status ID doesn't exist.",
                "Save Blocked", JOptionPane.WARNING_MESSAGE);
        } catch (java.sql.SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        loadRooms();
        showRecord(0);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        loadRooms();
        showRecord(roomList.size() - 1);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (roomList.isEmpty()) {
            loadRooms();
        }
        showRecord(currentIndex + 1);
    }//GEN-LAST:event_btnNextActionPerformed

    private void txtRoomIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoomIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomIDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new rooms().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtFloorNumber;
    private javax.swing.JTextField txtRoomID;
    private javax.swing.JTextField txtRoomNumber;
    private javax.swing.JTextField txtRoomTypeID;
    private javax.swing.JTextField txtRoomstatus;
    // End of variables declaration//GEN-END:variables

}