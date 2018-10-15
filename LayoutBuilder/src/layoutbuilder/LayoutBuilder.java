package layoutbuilder;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class LayoutBuilder {
    //driver function
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                            createAndShowGUI();
                    }
            });
    }

    //create main drawing area
    private static void createAndShowGUI() {
        DrawingArea drawingArea = new DrawingArea();
        ButtonPanel buttonPanel = new ButtonPanel( drawingArea );

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Layout Painter");
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add(drawingArea);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(450, 450);
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }

    /* the buttons class
     * todo: maybe disable clipping? should do that at some time?
     */
    static class ButtonPanel extends JPanel implements ActionListener {
        private DrawingArea drawingArea;

        /* use existing JButton to create a button with a text field 
         * and colored background. Color class used not only as background
         * but as future reference for drawing. 
         */ 
        private JButton createButton(String text, Color background) {
            JButton button = new JButton( text );
            button.setBackground( background );
            button.addActionListener( this );

            return button;
        }
        
        //get pretty colors
        public ButtonPanel(DrawingArea drawingArea) {
            this.drawingArea = drawingArea;

            add( createButton("A1", Color.RED) );
            add( createButton("A2", Color.ORANGE) );
            add( createButton("A3", Color.YELLOW) );
            add( createButton("A4", Color.GREEN) );
            add( createButton("A5", Color.BLUE) );
            add( createButton("A6", Color.MAGENTA) );
            add( createButton("Erase Layout", null) );
        }


        /* what happens on button press -
         * if you press 'erase' then clear the drawing area
         * otherwise you get a color
         */
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();

            if ("Erase Layout".equals(e.getActionCommand()))
                    drawingArea.clear();
            else
                    drawingArea.setForeground( button.getBackground() );
        }
    }

    //the drawing area
    static class DrawingArea extends JPanel {
        private final static int AREA_SIZE = 450;
        private ArrayList<ColoredRectangle> coloredRectangles = new ArrayList<ColoredRectangle>();
        private Rectangle shape;

        public DrawingArea() {
            setBackground(Color.WHITE);

            MyMouseListener ml = new MyMouseListener();
            addMouseListener(ml);
            addMouseMotionListener(ml);
        }

        @Override
        public Dimension getPreferredSize() {
            return isPreferredSizeSet() ?
                    super.getPreferredSize() : new Dimension(AREA_SIZE, AREA_SIZE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            //paint here
            Color foreground = g.getColor();

            g.setColor( Color.BLACK );
            g.drawString("Select aisle number below and draw on the white space", 40, 15);

            for (DrawingArea.ColoredRectangle cr : coloredRectangles) {
                g.setColor( cr.getForeground() );
                Rectangle r = cr.getRectangle();
                g.drawRect(r.x, r.y, r.width, r.height);
            }

            //paint on mouse drag
            if (shape != null) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.setColor( foreground );
                g2d.draw( shape );
            }
        }

        public void addRectangle(Rectangle rectangle, Color color) {
            //add Rectangle so it can be added
            ColoredRectangle cr = new ColoredRectangle(color, rectangle);
            coloredRectangles.add( cr );
            repaint();
        }

        public void clear() {
            coloredRectangles.clear();
            repaint();
        }

        class MyMouseListener extends MouseInputAdapter {
            private Point startPoint;

            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                shape = new Rectangle();
            }

            public void mouseDragged(MouseEvent e) {
                int x = Math.min(startPoint.x, e.getX());
                int y = Math.min(startPoint.y, e.getY());
                int width = Math.abs(startPoint.x - e.getX());
                int height = Math.abs(startPoint.y - e.getY());

                shape.setBounds(x, y, width, height);
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                if (shape.width != 0 || shape.height != 0) {
                        addRectangle(shape, e.getComponent().getForeground());
                }
                shape = null;
            }
        }

        class ColoredRectangle {
            private Color foreground;
            private Rectangle rectangle;

            public ColoredRectangle(Color foreground, Rectangle rectangle) {
                    this.foreground = foreground;
                    this.rectangle = rectangle;
            }

            public Color getForeground() {
                    return foreground;
            }

            public void setForeground(Color foreground) {
                    this.foreground = foreground;
            }

            public Rectangle getRectangle() {
                    return rectangle;
            }
        }
    }
}
