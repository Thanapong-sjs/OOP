import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSweeper extends JFrame {

    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int MINES = 10;
    private static final int SIZE = 50;
    private JButton[][] buttons = new JButton[ROWS][COLS];
    private boolean[][] isMine = new boolean[ROWS][COLS];
    private boolean[][] isRevealed = new boolean[ROWS][COLS];
    private int[][] neighborMines = new int[ROWS][COLS];

    public MineSweeper() {
        // ตั้งค่าหน้าต่างโปรแกรม
        setTitle("Java Mine Sweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(ROWS, COLS)); // ใช้ GridLayout สร้างตาราง
        setSize(COLS * SIZE, ROWS * SIZE);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.BOLD, 18));
                buttons[row][col].setFocusPainted(false);
                
                // เพิ่ม Event ให้แต่ละปุ่มเมื่อถูกคลิก
                final int r = row;
                final int c = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleCellClick(r, c);
                    }
                });
                
                add(buttons[row][col]);
            }
        }
        placeMines();

        calculateNeighbors();

        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void placeMines() {
        int count = 0;
        while (count < MINES) {
            int row = (int) (Math.random() * ROWS);
            int col = (int) (Math.random() * COLS);
            if (!isMine[row][col]) {
                isMine[row][col] = true;
                count++;
            }
        }
    }
    private void calculateNeighbors() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (isMine[row][col]) continue;
                
                int count = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nr = row + i;
                        int nc = col + j;
                        if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && isMine[nr][nc]) {
                            count++;
                        }
                    }
                }
                neighborMines[row][col] = count;
            }
        }
    }

    private void handleCellClick(int row, int col) {
        if (isRevealed[row][col]) return;

        isRevealed[row][col] = true;
        buttons[row][col].setEnabled(false);

        if (isMine[row][col]) {
            buttons[row][col].setText("*");
            buttons[row][col].setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, "Game Over! โดนระเบิดซะแล้ว!");
            System.exit(0);
        } else {

            if (neighborMines[row][col] > 0) {
                buttons[row][col].setText(String.valueOf(neighborMines[row][col]));
            } else {
                buttons[row][col].setText("");
                revealEmptyCells(row, col);
            }
        }
        
        checkWinCondition();
    }
    private void revealEmptyCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nr = row + i;
                int nc = col + j;
                if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && !isRevealed[nr][nc]) {
                    handleCellClick(nr, nc); // เรียกตัวเองซ้ำ (Recursion)
                }
            }
        }
    }

    private void checkWinCondition() {
        int revealedCount = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (isRevealed[row][col]) {
                    revealedCount++;
                }
            }
        }
        
        if (revealedCount == (ROWS * COLS) - MINES) {
            JOptionPane.showMessageDialog(this, "You Win! ยินดีด้วยคุณชนะแล้ว!");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MineSweeper();
            }
        });
    }
}