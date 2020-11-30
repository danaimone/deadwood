package GUI.Views;

import Deadwood.DeadwoodLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class BoardView extends JFrame {
    /* Image Paths */
    private static final String BOARD_IMG = "graphics/board.jpg";
    private static final String DICE_IMG_FOLDER = "graphics/dice/";
    private static final String SHOT_TAKE_IMG = "graphics/shot.png";
    /* Text Constants */
    private static final String TITLE = "Deadwood";
    private static final String MENU_TEXT = "MENU";
    private static final String ACT_BUTTON_TEXT = "Act";
    private static final String REHEARSE_BUTTON_TEXT = "Rehearse";
    private static final String MOVE_BUTTON_TEXT = "Move";
    private static final String TAKE_BUTTON_TEXT = "Take a Role";
    private static final String END_TURN_BUTTON_TEXT = "End Turn";
    private static final String UPGRADE_BUTTON_TEXT = "Upgrade";
    // JLabels
    JLabel boardLabel;
    JLabel cardLabel;
    JLabel playerLabel;
    JLabel mLabel;
    //JButtons
    JButton bAct;
    JButton bRehearse;
    JButton bMove;
    // JLayered Pane
    JLayeredPane bPane;
    private HashMap<Character, ArrayList<String>> diceImages;

    public BoardView() {
        super(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        bPane = getLayeredPane();
        boardLabel = new JLabel();
        ImageIcon icon = new ImageIcon("graphics/board.jpg");
        setupBoardImage(icon);
        createCardLabel();
        bPane.add(cardLabel, 1);

        createPlayerLabel();
        bPane.add(playerLabel, 3);

        createActionButtonsMenu(icon);

        createActActionButton(icon);
        createRehearseActionButton(icon);
        createMoveActionButton(icon);
        bPane.add(bAct, 2);
        bPane.add(bRehearse, 2);
        bPane.add(bMove, 2);
    }

    private void setupBoardImage(ImageIcon icon) {
        boardLabel.setIcon(icon);
        boardLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        bPane.add(boardLabel, 0);
        setSize(icon.getIconWidth() + 200, icon.getIconHeight() + 35);
    }

    private void createCardLabel() {
        cardLabel = new JLabel();
        ImageIcon cIcon = new ImageIcon("graphics/cards/01.png");
        cardLabel.setIcon(cIcon);
        cardLabel.setBounds(20, 65, cIcon.getIconWidth() + 2, cIcon.getIconHeight());
        cardLabel.setOpaque(true);
    }

    private void createPlayerLabel() {
        playerLabel = new JLabel();
        ImageIcon pIcon = new ImageIcon("r2.png");
        playerLabel.setIcon(pIcon);
        playerLabel.setBounds(114, 227, 46, 46);
        playerLabel.setVisible(false);
    }

    private void createMoveActionButton(ImageIcon icon) {
        bMove = new JButton(MOVE_BUTTON_TEXT);
        bMove.setBackground(Color.white);
        bMove.setBounds(icon.getIconWidth() + 10, 90, 100, 20);
        bMove.addMouseListener(new BoardMouseListener());
    }

    private void createRehearseActionButton(ImageIcon icon) {
        bRehearse = new JButton(REHEARSE_BUTTON_TEXT);
        bRehearse.setBackground(Color.white);
        bRehearse.setBounds(icon.getIconWidth() + 10, 60, 100, 20);
        bRehearse.addMouseListener(new BoardMouseListener());
    }

    private void createActActionButton(ImageIcon icon) {
        bAct = new JButton(ACT_BUTTON_TEXT);
        bAct.setBackground(Color.white);
        bAct.setBounds(icon.getIconWidth() + 10, 30, 100, 20);
        bAct.addMouseListener(new BoardMouseListener());
    }

    private void createActionButtonsMenu(ImageIcon icon) {
        mLabel = new JLabel(MENU_TEXT);
        mLabel.setBounds(icon.getIconWidth() + 40, 0, 100, 20);
        bPane.add(mLabel, 2);
    }

    class BoardMouseListener implements MouseListener {
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == bAct) {
                playerLabel.setVisible(true);
                DeadwoodLogger.logInfo("Acting is selected.");
            } else if (e.getSource() == bRehearse) {
                DeadwoodLogger.logInfo("Rehearse is selected.");
            } else if (e.getSource() == bMove) {
                DeadwoodLogger.logInfo("Move is selected");
            }
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

    }
}

