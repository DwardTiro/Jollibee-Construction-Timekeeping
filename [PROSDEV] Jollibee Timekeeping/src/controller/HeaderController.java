package controller;

import gui.MainFrame;
import gui.PopBox;
import gui.SearchResultsPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import model.Employee;

public class HeaderController implements Listen {

    private final String SEARCH_FIELD_DEFAULT = "Search";
    private final String HOME_PAGE = "add_time";
    private final String SEARCH_RESULT_LABEL_POSITIVE = "Search Results for ";
    private final String SEARCH_RESULT_LABEL_NEGATIVE = "No Search Result for ";
    private static final HeaderController controller = new HeaderController();

    private final MainFrame mainFrame;
    private final JPanel mainCardPanel;
    private final CardLayout mainLayout;

    private HeaderController() {
        mainFrame = MainFrame.getInstance();

        addListeners();
        mainCardPanel = mainFrame.getMainPanelCardPanel();
        mainLayout = (CardLayout) mainCardPanel.getLayout();
    }

    public static HeaderController getInstance() {
        return controller;
    }

    @Override
    public final void addListeners() {
        mainFrame.getMainTextFieldSearch().addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                if (mainFrame.getMainTextFieldSearch().getText().equalsIgnoreCase(SEARCH_FIELD_DEFAULT)) {
                    mainFrame.getMainTextFieldSearch().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (mainFrame.getMainTextFieldSearch().getText().equalsIgnoreCase("")) {
                    mainFrame.getMainTextFieldSearch().setText(SEARCH_FIELD_DEFAULT);
                }
            }
        });

        mainFrame.getMainTextFieldSearch().addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent ev) {
                if (ev.getKeyChar() == KeyEvent.VK_ENTER && mainFrame.getMainTextFieldSearch().hasFocus()) {

                    String s = mainFrame.getMainTextFieldSearch().getText();
                    if (!s.isEmpty()) {
                        try {
                            ArrayList<Employee> empList = Employee.searchDB(s);
                            if (empList == null) {
                                //PopBox.infoBox("No search Result", "");
                                mainFrame.getPanelSearchResultsContainer().setPreferredSize(new Dimension(0,0));
                                mainFrame.getPanelSearchResultsContainer().repaint();
                                mainFrame.getPanelSearchResultsContainer().revalidate();
                                mainFrame.getLabelSearchResults().setText(SEARCH_RESULT_LABEL_NEGATIVE + mainFrame.getMainTextFieldSearch().getText());
                            } else {
                                System.out.println("U got results");
                                //SearchResultController.getInstance().setModel(empList);
                                //SearchResultController.getInstance().showPanel();
                                
                                ArrayList<SearchResultsPanel> resultsPanels = new ArrayList<>();
                                
                                mainFrame.getPanelSearchResultsContainer().removeAll();
                                mainFrame.getLabelSearchResults().setText(SEARCH_RESULT_LABEL_POSITIVE + mainFrame.getMainTextFieldSearch().getText());
                                mainFrame.getPanelSearchResultsContainer().setPreferredSize(new Dimension(SearchResultsPanel.PANEL_WIDTH, SearchResultsPanel.PANEL_HEIGHT * empList.size()));
                                for(int i = 0; i < empList.size(); i++){
                                    Employee e = empList.get(i);
                                    SearchResultsPanel srp = new SearchResultsPanel(e.getLname() + ", " + e.getFname() + " " + e.getMname(), String.valueOf(e.getID()));
                                    mainFrame.getPanelSearchResultsContainer().add(srp);
                                    resultsPanels.add(srp);
                                }
                                mainFrame.getPanelSearchResultsContainer().repaint();
                                mainFrame.getPanelSearchResultsContainer().revalidate();
                                
                                SearchResultController.getInstance().showPanel();
                                SearchResultController.getInstance().addListeners(resultsPanels);
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(HeaderController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }

    public void search(String input) {

    }

    public void showPanel() {
        mainLayout.show(mainCardPanel, HOME_PAGE);
    }
}
