import javax.swing.*;
import java.awt.*;


public class ListingWith {
    private DefaultListModel<String> listModel;
    private JList<String> itemList;
    
    public ListingWith() {
        // Frame setup
        JFrame frame = new JFrame("Listing Component");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // List Model
        listModel = new DefaultListModel<>();
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");

        // JList to display items
        itemList = new JList<>(listModel);
        frame.add(new JScrollPane(itemList), BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Add Item Button
        JButton addButton = new JButton("Add Item");
        addButton.addActionListener(e -> {
            String newItem = JOptionPane.showInputDialog(frame, "Enter item name:");
            if (newItem != null && !newItem.trim().isEmpty()) {
                listModel.addElement(newItem);
            }
        });

        // Remove Item Button
        JButton removeButton = new JButton("Remove Item");
        removeButton.addActionListener(e -> {
            int selectedIndex = itemList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Select an item to remove!");
            }
        });

        // Add buttons to panel
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        // Add panel to frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListingWith::new);
    }
}
