// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package personal.project;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class bookings extends JFrame {
   private static final Logger logger = Logger.getLogger(bookings.class.getName());
   private List<Object[]> bookingList = new ArrayList();
   private int currentIndex = -1;
   private JButton btnDelete;
   private JButton btnExit;
   private JButton btnFind;
   private JButton btnFirst;
   private JButton btnLast;
   private JButton btnNext;
   private JButton btnPrevious;
   private JButton btnSave;
   private JLabel jLabel1;
   private JLabel jLabel2;
   private JLabel jLabel3;
   private JLabel jLabel4;
   private JLabel jLabel5;
   private JLabel jLabel6;
   private JLabel jLabel7;
   private JLabel jLabel8;
   private JMenu jMenu1;
   private JMenu jMenu2;
   private JMenu jMenu3;
   private JMenu jMenu4;
   private JMenuBar jMenuBar1;
   private JMenuBar jMenuBar2;
   private JTextField txtAmount;
   private JTextField txtBookingID;
   private JTextField txtBookingStatus;
   private JTextField txtCheckInDate;
   private JTextField txtCheckOutDate;
   private JTextField txtCreatedBy;
   private JTextField txtGuestID;
   private JTextField txtRoomID;

   private void loadBookings() {
      this.bookingList.clear();
      String sql = "SELECT booking_id, guest_id, room_id, created_by, check_in_date, check_out_date, booking_status, total_amount FROM bookings";

      try {
         Connection conn = DatabaseConnection.getConnection();

         try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            try {
               ResultSet rs = stmt.executeQuery();

               try {
                  while(rs.next()) {
                     this.bookingList.add(new Object[]{rs.getInt("booking_id"), rs.getInt("guest_id"), rs.getInt("room_id"), rs.getInt("created_by"), rs.getDate("check_in_date"), rs.getDate("check_out_date"), rs.getString("booking_status"), rs.getBigDecimal("total_amount")});
                  }
               } catch (Throwable var10) {
                  if (rs != null) {
                     try {
                        rs.close();
                     } catch (Throwable var9) {
                        var10.addSuppressed(var9);
                     }
                  }

                  throw var10;
               }

               if (rs != null) {
                  rs.close();
               }
            } catch (Throwable var11) {
               if (stmt != null) {
                  try {
                     stmt.close();
                  } catch (Throwable var8) {
                     var11.addSuppressed(var8);
                  }
               }

               throw var11;
            }

            if (stmt != null) {
               stmt.close();
            }
         } catch (Throwable var12) {
            if (conn != null) {
               try {
                  conn.close();
               } catch (Throwable var7) {
                  var12.addSuppressed(var7);
               }
            }

            throw var12;
         }

         if (conn != null) {
            conn.close();
         }
      } catch (SQLException e) {
         JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
      }

   }

   private void showRecord(int index) {
      if (this.bookingList.isEmpty()) {
         JOptionPane.showMessageDialog(this, "No records found.");
      } else {
         if (index < 0) {
            index = 0;
         }

         if (index >= this.bookingList.size()) {
            index = this.bookingList.size() - 1;
         }

         this.currentIndex = index;
         Object[] record = this.bookingList.get(this.currentIndex);
         this.txtBookingID.setText(String.valueOf(record[0]));
         this.txtGuestID.setText(String.valueOf(record[1]));
         this.txtRoomID.setText(String.valueOf(record[2]));
         this.txtCreatedBy.setText(String.valueOf(record[3]));
         this.txtCheckInDate.setText(String.valueOf(record[4]));
         this.txtCheckOutDate.setText(String.valueOf(record[5]));
         this.txtBookingStatus.setText(String.valueOf(record[6]));
         this.txtAmount.setText(String.valueOf(record[7]));
      }
   }

   private void clearFields() {
      this.txtBookingID.setText("");
      this.txtGuestID.setText("");
      this.txtRoomID.setText("");
      this.txtCreatedBy.setText("");
      this.txtCheckInDate.setText("");
      this.txtCheckOutDate.setText("");
      this.txtBookingStatus.setText("");
      this.txtAmount.setText("");
   }

   public bookings() {
      this.setLocationRelativeTo((Component)null);
      this.setTitle("BOOKINGS");
      this.initComponents();
   }

   private void initComponents() {
      this.jMenuBar1 = new JMenuBar();
      this.jMenu1 = new JMenu();
      this.jMenu2 = new JMenu();
      this.jMenuBar2 = new JMenuBar();
      this.jMenu3 = new JMenu();
      this.jMenu4 = new JMenu();
      this.btnSave = new JButton();
      this.btnPrevious = new JButton();
      this.btnFirst = new JButton();
      this.btnFind = new JButton();
      this.btnLast = new JButton();
      this.btnDelete = new JButton();
      this.btnNext = new JButton();
      this.btnExit = new JButton();
      this.jLabel1 = new JLabel();
      this.jLabel2 = new JLabel();
      this.jLabel3 = new JLabel();
      this.jLabel4 = new JLabel();
      this.jLabel5 = new JLabel();
      this.jLabel6 = new JLabel();
      this.jLabel7 = new JLabel();
      this.jLabel8 = new JLabel();
      this.txtBookingID = new JTextField();
      this.txtGuestID = new JTextField();
      this.txtRoomID = new JTextField();
      this.txtCreatedBy = new JTextField();
      this.txtCheckInDate = new JTextField();
      this.txtCheckOutDate = new JTextField();
      this.txtBookingStatus = new JTextField();
      this.txtAmount = new JTextField();
      this.jMenu1.setText("null");
      this.jMenuBar1.add(this.jMenu1);
      this.jMenu2.setText("null");
      this.jMenuBar1.add(this.jMenu2);
      this.jMenu3.setText("File");
      this.jMenuBar2.add(this.jMenu3);
      this.jMenu4.setText("Edit");
      this.jMenuBar2.add(this.jMenu4);
      this.setDefaultCloseOperation(3);
      this.btnSave.setText("SAVE");
      this.btnSave.addActionListener(this::btnSaveActionPerformed);
      this.btnPrevious.setText("PREVIOUS");
      this.btnPrevious.addActionListener(this::btnPreviousActionPerformed);
      this.btnFirst.setText("FIRST");
      this.btnFirst.addActionListener(this::btnFirstActionPerformed);
      this.btnFind.setText("FIND");
      this.btnFind.addActionListener(this::btnFindActionPerformed);
      this.btnLast.setText("LAST");
      this.btnLast.addActionListener(this::btnLastActionPerformed);
      this.btnDelete.setText("DELETE");
      this.btnDelete.addActionListener(this::btnDeleteActionPerformed);
      this.btnNext.setText("NEXT");
      this.btnNext.addActionListener(this::btnNextActionPerformed);
      this.btnExit.setText("EXIT");
      this.btnExit.addActionListener(this::btnExitActionPerformed);
      this.jLabel1.setText("BOOKING_ID");
      this.jLabel2.setText("GUEST_ID");
      this.jLabel3.setText("ROOM_ID");
      this.jLabel4.setText("CREATED_BY");
      this.jLabel5.setText("CHECK_IN_DATE");
      this.jLabel6.setText("CHECK_OUT_DATE");
      this.jLabel7.setText("BOOKING_STATUS");
      this.jLabel8.setText("TOTAL_AMOUNT");
      GroupLayout layout = new GroupLayout(this.getContentPane());
      this.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(25, 25, 25).addComponent(this.btnPrevious).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnFind).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.btnDelete).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnExit)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.jLabel5)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.txtCheckInDate, -2, 104, -2).addComponent(this.txtCheckOutDate, -2, 113, -2))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3).addComponent(this.jLabel4)).addGap(27, 27, 27).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.txtRoomID, -2, 71, -2).addComponent(this.txtGuestID, -2, 71, -2).addComponent(this.txtBookingID, -2, 71, -2).addComponent(this.txtCreatedBy, -2, 113, -2)))).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addComponent(this.btnSave).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.btnFirst).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.btnLast).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.btnNext)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel8).addGap(18, 18, 18).addComponent(this.txtAmount, -1, 80, 32767).addContainerGap()))).addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jLabel7).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.txtBookingStatus)))));
      layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel7).addComponent(this.txtBookingID, -2, -1, -2).addComponent(this.txtBookingStatus)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.txtRoomID, -2, -1, -2))).addGroup(layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.txtAmount, -2, -1, -2))))).addComponent(this.txtGuestID, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.txtCreatedBy, -2, 22, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel5).addComponent(this.txtCheckInDate, -2, 22, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.txtCheckOutDate, -2, 22, -2)).addGap(32, 32, 32).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.btnSave).addComponent(this.btnFirst).addComponent(this.btnLast).addComponent(this.btnNext)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.btnPrevious).addComponent(this.btnFind).addComponent(this.btnDelete).addComponent(this.btnExit)).addContainerGap()));
      this.pack();
   }

   private void btnSaveActionPerformed(ActionEvent evt) {
      String guestIdStr = this.txtGuestID.getText().trim();
      String roomIdStr = this.txtRoomID.getText().trim();
      String createdByStr = this.txtCreatedBy.getText().trim();
      String checkInStr = this.txtCheckInDate.getText().trim();
      String checkOutStr = this.txtCheckOutDate.getText().trim();
      String status = this.txtBookingStatus.getText().trim();
      String amountStr = this.txtAmount.getText().trim();
      if (guestIdStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Enter the Guest ID");
         this.txtGuestID.requestFocus();
      } else if (roomIdStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Enter the Room ID");
         this.txtRoomID.requestFocus();
      } else if (createdByStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Enter the Created By (staff ID)");
         this.txtCreatedBy.requestFocus();
      } else if (checkInStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Enter the Check-In Date (YYYY-MM-DD)");
         this.txtCheckInDate.requestFocus();
      } else if (checkOutStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Enter the Check-Out Date (YYYY-MM-DD)");
         this.txtCheckOutDate.requestFocus();
      } else {
         if (status.isEmpty()) {
            status = "Confirmed";
         }

         if (amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter the Total Amount");
            this.txtAmount.requestFocus();
         } else {
            int guestId;
            int roomId;
            int createdBy;
            Date checkIn;
            Date checkOut;
            BigDecimal amount;
            try {
               guestId = Integer.parseInt(guestIdStr);
               roomId = Integer.parseInt(roomIdStr);
               createdBy = Integer.parseInt(createdByStr);
               checkIn = Date.valueOf(checkInStr);
               checkOut = Date.valueOf(checkOutStr);
               amount = new BigDecimal(amountStr);
            } catch (IllegalArgumentException var22) {
               JOptionPane.showMessageDialog(this, "Check your entries: IDs must be numbers, dates must be YYYY-MM-DD, amount must be a number.");
               return;
            }

            String sql = "INSERT INTO bookings (guest_id, room_id, created_by, check_in_date, check_out_date, booking_status, total_amount) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try {
               Connection conn = DatabaseConnection.getConnection();

               try {
                  PreparedStatement stmt = conn.prepareStatement(sql);

                  try {
                     stmt.setInt(1, guestId);
                     stmt.setInt(2, roomId);
                     stmt.setInt(3, createdBy);
                     stmt.setDate(4, checkIn);
                     stmt.setDate(5, checkOut);
                     stmt.setString(6, status);
                     stmt.setBigDecimal(7, amount);
                     stmt.executeUpdate();
                     JOptionPane.showMessageDialog(this, "Booking saved successfully!");
                     this.clearFields();
                     this.loadBookings();
                     this.currentIndex = -1;
                  } catch (Throwable var23) {
                     if (stmt != null) {
                        try {
                           stmt.close();
                        } catch (Throwable var21) {
                           var23.addSuppressed(var21);
                        }
                     }

                     throw var23;
                  }

                  if (stmt != null) {
                     stmt.close();
                  }
               } catch (Throwable var24) {
                  if (conn != null) {
                     try {
                        conn.close();
                     } catch (Throwable var20) {
                        var24.addSuppressed(var20);
                     }
                  }

                  throw var24;
               }

               if (conn != null) {
                  conn.close();
               }
            } catch (SQLIntegrityConstraintViolationException var25) {
               JOptionPane.showMessageDialog(this, "Guest ID, Room ID, or Created By doesn't exist in their tables.", "Save Blocked", 2);
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

         }
      }
   }

   private void btnPreviousActionPerformed(ActionEvent evt) {
      if (this.bookingList.isEmpty()) {
         this.loadBookings();
      }

      this.showRecord(this.currentIndex - 1);
   }

   private void btnFirstActionPerformed(ActionEvent evt) {
      this.loadBookings();
      this.showRecord(0);
   }

   private void btnFindActionPerformed(ActionEvent evt) {
      String bookingIdStr = this.txtBookingID.getText().trim();
      if (bookingIdStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Enter a Booking ID to search");
         this.txtBookingID.requestFocus();
      } else {
         int bookingId;
         try {
            bookingId = Integer.parseInt(bookingIdStr);
         } catch (NumberFormatException var13) {
            JOptionPane.showMessageDialog(this, "Booking ID must be a number.");
            return;
         }

         String sql = "SELECT booking_id, guest_id, room_id, created_by, check_in_date, check_out_date, booking_status, total_amount FROM bookings WHERE booking_id = ?";

         try {
            Connection conn = DatabaseConnection.getConnection();

            try {
               PreparedStatement stmt = conn.prepareStatement(sql);

               try {
                  stmt.setInt(1, bookingId);
                  ResultSet rs = stmt.executeQuery();

                  try {
                     if (rs.next()) {
                        this.txtBookingID.setText(String.valueOf(rs.getInt("booking_id")));
                        this.txtGuestID.setText(String.valueOf(rs.getInt("guest_id")));
                        this.txtRoomID.setText(String.valueOf(rs.getInt("room_id")));
                        this.txtCreatedBy.setText(String.valueOf(rs.getInt("created_by")));
                        this.txtCheckInDate.setText(String.valueOf(rs.getDate("check_in_date")));
                        this.txtCheckOutDate.setText(String.valueOf(rs.getDate("check_out_date")));
                        this.txtBookingStatus.setText(rs.getString("booking_status"));
                        this.txtAmount.setText(String.valueOf(rs.getBigDecimal("total_amount")));
                     } else {
                        JOptionPane.showMessageDialog(this, "No booking found with that Booking ID.");
                     }
                  } catch (Throwable var14) {
                     if (rs != null) {
                        try {
                           rs.close();
                        } catch (Throwable var12) {
                           var14.addSuppressed(var12);
                        }
                     }

                     throw var14;
                  }

                  if (rs != null) {
                     rs.close();
                  }
               } catch (Throwable var15) {
                  if (stmt != null) {
                     try {
                        stmt.close();
                     } catch (Throwable var11) {
                        var15.addSuppressed(var11);
                     }
                  }

                  throw var15;
               }

               if (stmt != null) {
                  stmt.close();
               }
            } catch (Throwable var16) {
               if (conn != null) {
                  try {
                     conn.close();
                  } catch (Throwable var10) {
                     var16.addSuppressed(var10);
                  }
               }

               throw var16;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
         }

      }
   }

   private void btnLastActionPerformed(ActionEvent evt) {
      this.loadBookings();
      this.showRecord(this.bookingList.size() - 1);
   }

   private void btnDeleteActionPerformed(ActionEvent evt) {
      String bookingIdStr = this.txtBookingID.getText().trim();
      if (bookingIdStr.isEmpty()) {
         JOptionPane.showMessageDialog(this, "Enter the Booking ID to delete");
         this.txtBookingID.requestFocus();
      } else {
         int bookingId;
         try {
            bookingId = Integer.parseInt(bookingIdStr);
         } catch (NumberFormatException var16) {
            JOptionPane.showMessageDialog(this, "Booking ID must be a number.");
            return;
         }

         String checkSql = "SELECT COUNT(*) FROM bookings WHERE booking_id = ?";

         try {
            Connection conn;
            label170: {
               conn = DatabaseConnection.getConnection();

               try {
                  label171: {
                     PreparedStatement checkStmt = conn.prepareStatement(checkSql);

                     label172: {
                        try {
                           checkStmt.setInt(1, bookingId);
                           ResultSet rs = checkStmt.executeQuery();

                           label153: {
                              try {
                                 rs.next();
                                 if (rs.getInt(1) == 0) {
                                    JOptionPane.showMessageDialog(this, "No booking found with that Booking ID.");
                                    break label153;
                                 }
                              } catch (Throwable var21) {
                                 if (rs != null) {
                                    try {
                                       rs.close();
                                    } catch (Throwable var13) {
                                       var21.addSuppressed(var13);
                                    }
                                 }

                                 throw var21;
                              }

                              if (rs != null) {
                                 rs.close();
                              }
                              break label172;
                           }

                           if (rs != null) {
                              rs.close();
                           }
                        } catch (Throwable var22) {
                           if (checkStmt != null) {
                              try {
                                 checkStmt.close();
                              } catch (Throwable var12) {
                                 var22.addSuppressed(var12);
                              }
                           }

                           throw var22;
                        }

                        if (checkStmt != null) {
                           checkStmt.close();
                        }
                        break label171;
                     }

                     if (checkStmt != null) {
                        checkStmt.close();
                     }
                     break label170;
                  }
               } catch (Throwable var23) {
                  if (conn != null) {
                     try {
                        conn.close();
                     } catch (Throwable var11) {
                        var23.addSuppressed(var11);
                     }
                  }

                  throw var23;
               }

               if (conn != null) {
                  conn.close();
               }

               return;
            }

            if (conn != null) {
               conn.close();
            }
         } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            return;
         }

         int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this booking?", "Confirm Delete", 0);
         if (confirm == 0) {
            String deleteSql = "DELETE FROM bookings WHERE booking_id = ?";

            try {
               Connection conn = DatabaseConnection.getConnection();

               try {
                  PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);

                  try {
                     deleteStmt.setInt(1, bookingId);
                     int rows = deleteStmt.executeUpdate();
                     if (rows > 0) {
                        JOptionPane.showMessageDialog(this, "Deleted successfully!");
                        this.clearFields();
                        this.loadBookings();
                        this.currentIndex = -1;
                     } else {
                        JOptionPane.showMessageDialog(this, "No matching record found.");
                     }
                  } catch (Throwable var17) {
                     if (deleteStmt != null) {
                        try {
                           deleteStmt.close();
                        } catch (Throwable var15) {
                           var17.addSuppressed(var15);
                        }
                     }

                     throw var17;
                  }

                  if (deleteStmt != null) {
                     deleteStmt.close();
                  }
               } catch (Throwable var18) {
                  if (conn != null) {
                     try {
                        conn.close();
                     } catch (Throwable var14) {
                        var18.addSuppressed(var14);
                     }
                  }

                  throw var18;
               }

               if (conn != null) {
                  conn.close();
               }
            } catch (SQLIntegrityConstraintViolationException var19) {
               JOptionPane.showMessageDialog(this, "Cannot delete: this booking has related records (e.g. payments, reviews).", "Delete Blocked", 2);
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }

         }
      }
   }

   private void btnNextActionPerformed(ActionEvent evt) {
      if (this.bookingList.isEmpty()) {
         this.loadBookings();
      }

      this.showRecord(this.currentIndex + 1);
   }

   private void btnExitActionPerformed(ActionEvent evt) {
      int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to Exit?", "Confirm Exit", 0);
      if (confirm == 0) {
         this.dispose();
      }

   }

   public static void main(String[] args) {
      try {
         for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (UnsupportedLookAndFeelException | ReflectiveOperationException ex) {
         logger.log(Level.SEVERE, (String)null, ex);
      }

      EventQueue.invokeLater(() -> (new bookings()).setVisible(true));
   }
}
