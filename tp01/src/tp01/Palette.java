package tp01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Palette extends JFrame {

    private MenuBar menuBar;
    private Menu chooseFigure, chooseMode, chooseColor;
    private MenuItem line, polygon, circle, ellipse, lineSegment, ray;
    private MenuItem draw, move;
    private MenuItem backgroundColor, borderColor;
    private JFrame app;
    private Color bckColor =Color.PINK, brColor = Color.BLACK;

    private FigureType figureType;
    private boolean modeType;

    public Palette() {
        setTitle("TP lab 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        app = this;
        run();
    }

    public void run() {
        createMenu();
    }

    public void createMenu() {
        app.add(new DrawPanel());
        menuBar = new MenuBar();
        this.setMenuBar(menuBar);
        chooseFigure = new Menu("Choose figure");
        chooseFigure.add(line = new MenuItem("line"));
        chooseFigure.add(polygon = new MenuItem("polygon"));
        chooseFigure.add(circle = new MenuItem("circle"));
        chooseFigure.add(ellipse = new MenuItem("ellipse"));
        chooseFigure.add(lineSegment = new MenuItem("lineSegment"));
        chooseFigure.add(ray = new MenuItem("ray"));

        chooseMode = new Menu("Choose mode");
        chooseMode.add(draw = new MenuItem("draw"));
        chooseMode.add(move = new MenuItem("move"));

        chooseColor = new Menu("Choose color");
        chooseColor.add(backgroundColor = new MenuItem("Background Color"));
        chooseColor.add(borderColor = new MenuItem("Border Color"));


        menuBar.add(chooseFigure);
        menuBar.add(chooseMode);
        menuBar.add(chooseColor);

        backgroundColor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                bckColor = JColorChooser.showDialog(app, "ColorChooserDemo", null);
            }
        });
        borderColor.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                brColor = JColorChooser.showDialog(app, "ColorChooserDemo", null);
            }
        });
        chooseFigure.addActionListener(figureListener);
        chooseMode.addActionListener(modeListener);

    }

    ActionListener modeListener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            if (event.getActionCommand().equals("draw")) {
                modeType = true;
                System.out.println(modeType);

            } else if (event.getActionCommand().equals("move")) {
                modeType = false;
                System.out.println(modeType);

            }
        }
    };
    ActionListener figureListener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
                case "line":
                    figureType = FigureType.LINE;
                    System.out.println(figureType);

                    break;
                case "polygon":
                    figureType = FigureType.POLYGON;
                    System.out.println(figureType);

                    break;
                case "lineSegment":
                    figureType = FigureType.LINESEGMENT;
                    System.out.println(figureType);

                    break;
                case "ray":
                    figureType = FigureType.RAY;
                    System.out.println(figureType);

                    break;
                case "circle":
                    figureType = FigureType.CIRCLE;
                    System.out.println(figureType);

                    break;
                case "ellipse":
                    figureType = FigureType.ELLIPSE;
                    System.out.println(figureType);

                    break;
                default:
                    figureType = FigureType.ELLIPSE;
            }
        }
    };

    public Color getBckColor() {
        return bckColor;
    }

    public void setBckColor(Color bckColor) {
        this.bckColor = bckColor;
    }

    public Color getBrColor() {
        return brColor;
    }

    public void setBrColor(Color brColor) {
        this.brColor = brColor;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    public void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public boolean isModeType() {
        return modeType;
    }

    public void setModeType(boolean modeType) {
        this.modeType = modeType;
    }
}
