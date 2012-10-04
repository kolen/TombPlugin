package kendzi.josm.plugin.tomb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class TombDialog extends JDialog {

    private final JPanel contentPanel = new JPanel();
    protected JTable personsTable;
    protected JTextField txtWikipedia;
    protected JTextField txtImage;
    protected JComboBox cbTombType;
    protected JComboBox cbReligion;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            TombDialog dialog = new TombDialog();
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create the dialog.
     */
    public TombDialog() {
        setBounds(100, 100, 700, 400);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel, BorderLayout.WEST);
            panel.setLayout(new BorderLayout(0, 0));
            {
                JLabel lblTomb = new JLabel("Tomb");
                panel.add(lblTomb, BorderLayout.NORTH);
            }
            {
                JPanel panel_1 = new JPanel();
                panel.add(panel_1, BorderLayout.CENTER);
                panel_1.setLayout(new FormLayout(new ColumnSpec[] {
                        ColumnSpec.decode("100px:grow"),
                        ColumnSpec.decode("120px:grow"),},
                        new RowSpec[] {
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,
                        FormFactory.RELATED_GAP_ROWSPEC,
                        FormFactory.DEFAULT_ROWSPEC,}));
                {
                    JLabel lblTombType = new JLabel("Tomb type");
                    panel_1.add(lblTombType, "1, 3, left, default");
                }
                {
                    cbTombType = new JComboBox();
                    cbTombType.setEditable(true);
                    cbTombType.setModel(new DefaultComboBoxModel(new String[] {"", "tombstone", "tumulus", "rock-cut", "war_grave", "mausoleum", "columbarium", "pyramid", "crypt"}));
                    panel_1.add(cbTombType, "2, 3, fill, default");
                }
                {
                    JLabel lblOptionalAttributes = new JLabel("Optional Attributes:");
                    panel_1.add(lblOptionalAttributes, "1, 5, left, default");
                }
                {
                    JLabel lblReligion = new JLabel("Religion");
                    panel_1.add(lblReligion, "1, 7, left, default");
                }
                {
                    cbReligion = new JComboBox();
                    cbReligion.setEditable(true);
                    cbReligion.setModel(new DefaultComboBoxModel(new String[] {"", "christian", "jewish", "muslim"}));
                    panel_1.add(cbReligion, "2, 7, fill, default");
                }
                {
                    JLabel lblTombData = new JLabel("Tomb data");
                    panel_1.add(lblTombData, "1, 9");
                }
                {
                    JLabel lblWikipediaArticle = new JLabel("- wikipedia article");
                    panel_1.add(lblWikipediaArticle, "1, 11, left, default");
                }
                {
                    txtWikipedia = new JTextField();
                    panel_1.add(txtWikipedia, "2, 11, fill, default");
                    txtWikipedia.setColumns(10);
                }
                {
                    JLabel lblImage = new JLabel("- image");
                    panel_1.add(lblImage, "1, 13, left, default");
                }
                {
                    txtImage = new JTextField();
                    panel_1.add(txtImage, "2, 13, fill, default");
                    txtImage.setColumns(10);
                }
            }
        }
        {
            JPanel panel = new JPanel();
            panel.setBorder(new EmptyBorder(0, 3, 0, 0));
            contentPanel.add(panel, BorderLayout.CENTER);
            panel.setLayout(new BorderLayout(0, 0));
            {
                JScrollPane scrollPane = new JScrollPane();
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                panel.add(scrollPane);
                {
                    personsTable = new JTable();
                    personsTable.setModel(new DefaultTableModel(
                            new Object[][] {
                                    {"1", "2", "3"},
                                    {"4", "5", "6"},
                            },
                            new String[] {
                                    "New column", "New column", "New column 1"
                            }
                            ));
                    scrollPane.setViewportView(personsTable);
                }
            }
            {
                JPanel panel_tableButtons = new JPanel();
                panel.add(panel_tableButtons, BorderLayout.SOUTH);
                {
                    JButton btnAddPerson = new JButton("New");
                    btnAddPerson.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                            onAddPerson();
                        }
                    });
                    panel_tableButtons.add(btnAddPerson);
                }
                {
                    JButton btnRemove = new JButton("Remove");
                    btnRemove.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {

                            ;
                            onRemovePerson(personsTable.getSelectedRows());
                        }
                    });
                    panel_tableButtons.add(btnRemove);
                }
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        onSave();
                    }
                });
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

    protected void onSave() {
        //
    }

    protected void onAddPerson() {
        //
    }

    protected void onRemovePerson(int [] rowsId) {
        //
    }

}
